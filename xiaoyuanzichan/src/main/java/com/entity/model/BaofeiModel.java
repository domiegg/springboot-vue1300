package com.entity.model;

import com.entity.BaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资产报废
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BaofeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 校园资产
     */
    private Integer shangpinId;


    /**
     * 报废数量
     */
    private Integer baofeiNumber;


    /**
     * 报废备注
     */
    private String baofeiContent;


    /**
     * 报废时间
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
	 * 获取：报废数量
	 */
    public Integer getBaofeiNumber() {
        return baofeiNumber;
    }


    /**
	 * 设置：报废数量
	 */
    public void setBaofeiNumber(Integer baofeiNumber) {
        this.baofeiNumber = baofeiNumber;
    }
    /**
	 * 获取：报废备注
	 */
    public String getBaofeiContent() {
        return baofeiContent;
    }


    /**
	 * 设置：报废备注
	 */
    public void setBaofeiContent(String baofeiContent) {
        this.baofeiContent = baofeiContent;
    }
    /**
	 * 获取：报废时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：报废时间
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
