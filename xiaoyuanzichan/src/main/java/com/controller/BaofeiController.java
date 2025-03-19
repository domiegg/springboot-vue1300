









package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
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
 * 资产报废
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/baofei")
public class BaofeiController {
    private static final Logger logger = LoggerFactory.getLogger(BaofeiController.class);

    @Autowired
    private BaofeiService baofeiService;


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
        PageUtils page = baofeiService.queryPage(params);

        //字典表数据转换
        List<BaofeiView> list =(List<BaofeiView>)page.getList();
        for(BaofeiView c:list){
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
        BaofeiEntity baofei = baofeiService.selectById(id);
        if(baofei !=null){
            //entity转view
            BaofeiView view = new BaofeiView();
            BeanUtils.copyProperties( baofei , view );//把实体数据重构到view中

                //级联表
                ShangpinEntity shangpin = shangpinService.selectById(baofei.getShangpinId());
                if(shangpin != null){
                    BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangpinId(shangpin.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BaofeiEntity baofei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,baofei:{}",this.getClass().getName(),baofei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");


        ShangpinEntity shangpinEntity = shangpinService.selectById(baofei.getShangpinId());
        if(shangpinEntity == null){
            return R.error(511,"查不到物资");
        }

        int i = shangpinEntity.getShangpinKucunNumber() - baofei.getBaofeiNumber();
        if( i<0){
            return R.error(511,"报废数量大于库存数量");

        }




        baofei.setInsertTime(new Date());
        baofei.setCreateTime(new Date());
        baofeiService.insert(baofei);

        shangpinEntity.setShangpinKucunNumber(i);
        shangpinService.updateById(shangpinEntity);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    @Transactional(rollbackFor = {Exception.class})
    public R update(@RequestBody BaofeiEntity baofei, HttpServletRequest request){
        try {

            logger.debug("update方法:,,Controller:{},,baofei:{}",this.getClass().getName(),baofei.toString());

            String role = String.valueOf(request.getSession().getAttribute("role"));
            if(StringUtil.isEmpty(role))
                return R.error(511,"权限为空");
            BaofeiEntity oldBaofeiEntity = baofeiService.selectById(baofei.getId());//老的报废
            ShangpinEntity oldShangpinEntity = shangpinService.selectById(oldBaofeiEntity.getShangpinId());//老的商品
            if(oldShangpinEntity != null){
                oldShangpinEntity.setShangpinKucunNumber(oldShangpinEntity.getShangpinKucunNumber() +oldBaofeiEntity.getBaofeiNumber());
                shangpinService.updateById(oldShangpinEntity);
            }

            if(oldShangpinEntity != null && baofei.getShangpinId().equals(oldShangpinEntity.getId())){
                oldShangpinEntity.setShangpinKucunNumber(oldShangpinEntity.getShangpinKucunNumber() + baofei.getBaofeiNumber());
                shangpinService.updateById(oldShangpinEntity);
            }else{
                ShangpinEntity newShangpinEntity = shangpinService.selectById(baofei.getShangpinId());//老的商品
                int i = newShangpinEntity.getShangpinKucunNumber() - baofei.getBaofeiNumber();
                if(i<0){
                    new Exception();
                    return R.error(511,"报废数量大于库存数量");
                }
                newShangpinEntity.setShangpinKucunNumber(i);
                shangpinService.updateById(newShangpinEntity);
            }
            baofeiService.updateById(baofei);//根据id更新
            return R.ok();
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"出错了 请联系管理员");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());

        ArrayList<Integer> integers = new ArrayList<>();
//        integers.addAll(ids)

        List<BaofeiEntity> baofeiEntities = baofeiService.selectBatchIds(Arrays.asList(ids));
        List<Integer> shangpinIds = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(BaofeiEntity a:baofeiEntities){
            shangpinIds.add(a.getShangpinId());
            hashMap.put(a.getShangpinId(),a.getBaofeiNumber());
        }
        List<ShangpinEntity> shangpinEntities = shangpinService.selectBatchIds(shangpinIds);
        for(ShangpinEntity a:shangpinEntities){
            a.setShangpinKucunNumber(a.getShangpinKucunNumber()+hashMap.get(a.getId()));
        }
        shangpinService.updateBatchById(shangpinEntities);
        baofeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<BaofeiEntity> baofeiList = new ArrayList<>();//上传的东西
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
                            BaofeiEntity baofeiEntity = new BaofeiEntity();
//                            baofeiEntity.setShangpinId(Integer.valueOf(data.get(0)));   //校园资产 要改的
//                            baofeiEntity.setBaofeiNumber(Integer.valueOf(data.get(0)));   //报废数量 要改的
//                            baofeiEntity.setBaofeiContent("");//照片
//                            baofeiEntity.setInsertTime(date);//时间
//                            baofeiEntity.setCreateTime(date);//时间
                            baofeiList.add(baofeiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        baofeiService.insertBatch(baofeiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}
