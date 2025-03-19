









package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 资产借用
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jieyong")
public class JieyongController {
    private static final Logger logger = LoggerFactory.getLogger(JieyongController.class);

    @Autowired
    private JieyongService jieyongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShangpinService shangpinService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jieyongService.queryPage(params);

        //字典表数据转换
        List<JieyongView> list =(List<JieyongView>)page.getList();
        for(JieyongView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JieyongEntity jieyong = jieyongService.selectById(id);
        if(jieyong !=null){
            //entity转view
            JieyongView view = new JieyongView();
            BeanUtils.copyProperties( jieyong , view );//把实体数据重构到view中

                //级联表
                ShangpinEntity shangpin = shangpinService.selectById(jieyong.getShangpinId());
                if(shangpin != null){
                    BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangpinId(shangpin.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(jieyong.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }


    /**
    * 后端详情
    */
    @RequestMapping("/guihuan/{id}")
    public R guihuan(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("guihuan方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JieyongEntity jieyong = jieyongService.selectById(id);
        if(jieyong !=null){
            if(jieyong.getGuihuanTypes().equals(1)){
                jieyong.setGuihuanTypes(2);


                ShangpinEntity shangpinEntity = shangpinService.selectById(jieyong.getShangpinId());
                if(shangpinEntity != null ){
                    shangpinEntity.setShangpinKucunNumber(shangpinEntity.getShangpinKucunNumber() +jieyong.getJieyongNumber());
                    shangpinService.updateById(shangpinEntity);
                }
                jieyongService.updateById(jieyong);
                return R.ok();
            }else{
                return R.error(511,"该借出已经归还");
            }
        }else {
            return R.error(511,"查不到借用数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JieyongEntity jieyong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jieyong:{}",this.getClass().getName(),jieyong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            jieyong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jieyong.setInsertTime(new Date());
            jieyong.setCreateTime(new Date());
            jieyong.setGuihuanTypes(1);

        ShangpinEntity shangpinEntity = shangpinService.selectById(jieyong.getShangpinId());
        if(shangpinEntity == null){
            return R.error(511,"查不到商品");
        }
        int i = shangpinEntity.getShangpinKucunNumber() - jieyong.getJieyongNumber();
        if(i<0){
            return R.error(511,"借用数量大于库存数量");
        }
        shangpinEntity.setShangpinKucunNumber(i);

        shangpinService.updateById(shangpinEntity);
        jieyongService.insert(jieyong);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JieyongEntity jieyong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jieyong:{}",this.getClass().getName(),jieyong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            jieyong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JieyongEntity> queryWrapper = new EntityWrapper<JieyongEntity>()
            .notIn("id",jieyong.getId())
            .andNew()
            .eq("yonghu_id", jieyong.getYonghuId())
            .eq("shangpin_id", jieyong.getShangpinId())
            .eq("jieyong_number", jieyong.getJieyongNumber())
            .eq("guihuan_types", jieyong.getGuihuanTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JieyongEntity jieyongEntity = jieyongService.selectOne(queryWrapper);
        if(jieyongEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jieyong.set
            //  }
            jieyongService.updateById(jieyong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jieyongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<JieyongEntity> jieyongList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JieyongEntity jieyongEntity = new JieyongEntity();
//                            jieyongEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jieyongEntity.setShangpinId(Integer.valueOf(data.get(0)));   //校园资产 要改的
//                            jieyongEntity.setJieyongNumber(Integer.valueOf(data.get(0)));   //借用数量 要改的
//                            jieyongEntity.setJieyongContent("");//照片
//                            jieyongEntity.setGuihuanTypes(Integer.valueOf(data.get(0)));   //是否归还 要改的
//                            jieyongEntity.setInsertTime(date);//时间
//                            jieyongEntity.setCreateTime(date);//时间
                            jieyongList.add(jieyongEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jieyongService.insertBatch(jieyongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}
