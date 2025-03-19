package com.entity.vo;

import com.entity.BaofeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资产报废
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("baofei")
public class BaofeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 校园资产
     */

    @TableField(value = "shangpin_id")
    private Integer shangpinId;


    /**
     * 报废数量
     */

    @TableField(value = "baofei_number")
    private Integer baofeiNumber;


    /**
     * 报废备注
     */

    @TableField(value = "baofei_content")
    private String baofeiContent;


    /**
     * 报废时间
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
	 * 设置：报废数量
	 */
    public Integer getBaofeiNumber() {
        return baofeiNumber;
    }


    /**
	 * 获取：报废数量
	 */

    public void setBaofeiNumber(Integer baofeiNumber) {
        this.baofeiNumber = baofeiNumber;
    }
    /**
	 * 设置：报废备注
	 */
    public String getBaofeiContent() {
        return baofeiContent;
    }


    /**
	 * 获取：报废备注
	 */

    public void setBaofeiContent(String baofeiContent) {
        this.baofeiContent = baofeiContent;
    }
    /**
	 * 设置：报废时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：报废时间
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
