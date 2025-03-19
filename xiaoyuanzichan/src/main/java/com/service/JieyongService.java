package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JieyongEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 资产借用 服务类111
 */
public interface JieyongService extends IService<JieyongEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}