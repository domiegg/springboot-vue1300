package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 资产借用
 *
 * @author 
 * @email
 */
@TableName("jieyong")
public class JieyongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JieyongEntity() {

	}

	public JieyongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Jieyong{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", shangpinId=" + shangpinId +
            ", jieyongNumber=" + jieyongNumber +
            ", jieyongContent=" + jieyongContent +
            ", guihuanTypes=" + guihuanTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
