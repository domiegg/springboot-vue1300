package com.entity.vo;

import com.entity.ShangpinChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 入库详情
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shangpin_churu_inout_list")
public class ShangpinChuruInoutListVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 入库
     */

    @TableField(value = "shangpin_churu_inout_id")
    private Integer shangpinChuruInoutId;


    /**
     * 校园资产
     */

    @TableField(value = "shangpin_id")
    private Integer shangpinId;


    /**
     * 入库数量
     */

    @TableField(value = "shangpin_churu_inout_list_number")
    private Integer shangpinChuruInoutListNumber;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：入库
	 */
    public Integer getShangpinChuruInoutId() {
        return shangpinChuruInoutId;
    }


    /**
	 * 获取：入库
	 */

    public void setShangpinChuruInoutId(Integer shangpinChuruInoutId) {
        this.shangpinChuruInoutId = shangpinChuruInoutId;
    }
    /**
	 * 设置：校园资产
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }


    /**
	 * 获取：校园资产
	 */

    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 设置：入库数量
	 */
    public Integer getShangpinChuruInoutListNumber() {
        return shangpinChuruInoutListNumber;
    }


    /**
	 * 获取：入库数量
	 */

    public void setShangpinChuruInoutListNumber(Integer shangpinChuruInoutListNumber) {
        this.shangpinChuruInoutListNumber = shangpinChuruInoutListNumber;
    }
    /**
	 * 设置：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：操作时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
