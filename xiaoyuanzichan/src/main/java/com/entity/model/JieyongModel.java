package com.entity.model;

import com.entity.JieyongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资产借用
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JieyongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 校园资产
     */
    private Integer shangpinId;


    /**
     * 借用数量
     */
    private Integer jieyongNumber;


    /**
     * 借用备注
     */
    private String jieyongContent;


    /**
     * 是否归还
     */
    private Integer guihuanTypes;


    /**
     * 借用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：校园资产
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }


    /**
	 * 设置：校园资产
	 */
    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 获取：借用数量
	 */
    public Integer getJieyongNumber() {
        return jieyongNumber;
    }


    /**
	 * 设置：借用数量
	 */
    public void setJieyongNumber(Integer jieyongNumber) {
        this.jieyongNumber = jieyongNumber;
    }
    /**
	 * 获取：借用备注
	 */
    public String getJieyongContent() {
        return jieyongContent;
    }


    /**
	 * 设置：借用备注
	 */
    public void setJieyongContent(String jieyongContent) {
        this.jieyongContent = jieyongContent;
    }
    /**
	 * 获取：是否归还
	 */
    public Integer getGuihuanTypes() {
        return guihuanTypes;
    }


    /**
	 * 设置：是否归还
	 */
    public void setGuihuanTypes(Integer guihuanTypes) {
        this.guihuanTypes = guihuanTypes;
    }
    /**
	 * 获取：借用时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：借用时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
