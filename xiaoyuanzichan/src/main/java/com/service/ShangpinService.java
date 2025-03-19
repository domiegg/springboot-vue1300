package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangpinEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 校园资产 服务类111
 */
public interface ShangpinService extends IService<ShangpinEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}