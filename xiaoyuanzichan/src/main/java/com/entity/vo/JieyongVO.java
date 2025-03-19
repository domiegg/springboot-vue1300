package com.entity.vo;

import com.entity.JieyongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资产借用
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jieyong")
public class JieyongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 校园资产
     */

    @TableField(value = "shangpin_id")
    private Integer shangpinId;


    /**
     * 借用数量
     */

    @TableField(value = "jieyong_number")
    private Integer jieyongNumber;


    /**
     * 借用备注
     */

    @TableField(value = "jieyong_content")
    private String jieyongContent;


    /**
     * 是否归还
     */

    @TableField(value = "guihuan_types")
    private Integer guihuanTypes;


    /**
     * 借用时间
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
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
	 * 设置：借用数量
	 */
    public Integer getJieyongNumber() {
        return jieyongNumber;
    }


    /**
	 * 获取：借用数量
	 */

    public void setJieyongNumber(Integer jieyongNumber) {
        this.jieyongNumber = jieyongNumber;
    }
    /**
	 * 设置：借用备注
	 */
    public String getJieyongContent() {
        return jieyongContent;
    }


    /**
	 * 获取：借用备注
	 */

    public void setJieyongContent(String jieyongContent) {
        this.jieyongContent = jieyongContent;
    }
    /**
	 * 设置：是否归还
	 */
    public Integer getGuihuanTypes() {
        return guihuanTypes;
    }


    /**
	 * 获取：是否归还
	 */

    public void setGuihuanTypes(Integer guihuanTypes) {
        this.guihuanTypes = guihuanTypes;
    }
    /**
	 * 设置：借用时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：借用时间
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
