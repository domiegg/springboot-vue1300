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
 * 资产报废
 *
 * @author 
 * @email
 */
@TableName("baofei")
public class BaofeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BaofeiEntity() {

	}

	public BaofeiEntity(T t) {
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

    @Override
    public String toString() {
        return "Baofei{" +
            "id=" + id +
            ", shangpinId=" + shangpinId +
            ", baofeiNumber=" + baofeiNumber +
            ", baofeiContent=" + baofeiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
