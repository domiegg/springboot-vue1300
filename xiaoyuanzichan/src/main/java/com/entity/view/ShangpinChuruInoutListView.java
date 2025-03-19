package com.entity.view;

import com.entity.ShangpinChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 入库详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shangpin_churu_inout_list")
public class ShangpinChuruInoutListView extends ShangpinChuruInoutListEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 shangpin
			/**
			* 资产编号
			*/
			private String shangpinUuidNumber;
			/**
			* 资产名称
			*/
			private String shangpinName;
			/**
			* 资产照片
			*/
			private String shangpinPhoto;
			/**
			* 资产类型
			*/
			private Integer shangpinTypes;
				/**
				* 资产类型的值
				*/
				private String shangpinValue;
			/**
			* 存放地点
			*/
			private Integer didianTypes;
				/**
				* 存放地点的值
				*/
				private String didianValue;
			/**
			* 资产库存
			*/
			private Integer shangpinKucunNumber;
			/**
			* 逻辑删除
			*/
			private Integer shangpinDelete;
			/**
			* 资产介绍
			*/
			private String shangpinContent;

		//级联表 shangpin_churu_inout
			/**
			* 出入库流水号
			*/
			private String shangpinChuruInoutUuidNumber;
			/**
			* 入库名称
			*/
			private String shangpinChuruInoutName;
			/**
			* 入库类型
			*/
			private Integer shangpinChuruInoutTypes;
				/**
				* 入库类型的值
				*/
				private String shangpinChuruInoutValue;
			/**
			* 备注
			*/
			private String shangpinChuruInoutContent;

	public ShangpinChuruInoutListView() {

	}

	public ShangpinChuruInoutListView(ShangpinChuruInoutListEntity shangpinChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinChuruInoutListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set shangpin
					/**
					* 获取： 资产编号
					*/
					public String getShangpinUuidNumber() {
						return shangpinUuidNumber;
					}
					/**
					* 设置： 资产编号
					*/
					public void setShangpinUuidNumber(String shangpinUuidNumber) {
						this.shangpinUuidNumber = shangpinUuidNumber;
					}
					/**
					* 获取： 资产名称
					*/
					public String getShangpinName() {
						return shangpinName;
					}
					/**
					* 设置： 资产名称
					*/
					public void setShangpinName(String shangpinName) {
						this.shangpinName = shangpinName;
					}
					/**
					* 获取： 资产照片
					*/
					public String getShangpinPhoto() {
						return shangpinPhoto;
					}
					/**
					* 设置： 资产照片
					*/
					public void setShangpinPhoto(String shangpinPhoto) {
						this.shangpinPhoto = shangpinPhoto;
					}
					/**
					* 获取： 资产类型
					*/
					public Integer getShangpinTypes() {
						return shangpinTypes;
					}
					/**
					* 设置： 资产类型
					*/
					public void setShangpinTypes(Integer shangpinTypes) {
						this.shangpinTypes = shangpinTypes;
					}


						/**
						* 获取： 资产类型的值
						*/
						public String getShangpinValue() {
							return shangpinValue;
						}
						/**
						* 设置： 资产类型的值
						*/
						public void setShangpinValue(String shangpinValue) {
							this.shangpinValue = shangpinValue;
						}
					/**
					* 获取： 存放地点
					*/
					public Integer getDidianTypes() {
						return didianTypes;
					}
					/**
					* 设置： 存放地点
					*/
					public void setDidianTypes(Integer didianTypes) {
						this.didianTypes = didianTypes;
					}


						/**
						* 获取： 存放地点的值
						*/
						public String getDidianValue() {
							return didianValue;
						}
						/**
						* 设置： 存放地点的值
						*/
						public void setDidianValue(String didianValue) {
							this.didianValue = didianValue;
						}
					/**
					* 获取： 资产库存
					*/
					public Integer getShangpinKucunNumber() {
						return shangpinKucunNumber;
					}
					/**
					* 设置： 资产库存
					*/
					public void setShangpinKucunNumber(Integer shangpinKucunNumber) {
						this.shangpinKucunNumber = shangpinKucunNumber;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getShangpinDelete() {
						return shangpinDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShangpinDelete(Integer shangpinDelete) {
						this.shangpinDelete = shangpinDelete;
					}
					/**
					* 获取： 资产介绍
					*/
					public String getShangpinContent() {
						return shangpinContent;
					}
					/**
					* 设置： 资产介绍
					*/
					public void setShangpinContent(String shangpinContent) {
						this.shangpinContent = shangpinContent;
					}


				//级联表的get和set shangpin_churu_inout
					/**
					* 获取： 出入库流水号
					*/
					public String getShangpinChuruInoutUuidNumber() {
						return shangpinChuruInoutUuidNumber;
					}
					/**
					* 设置： 出入库流水号
					*/
					public void setShangpinChuruInoutUuidNumber(String shangpinChuruInoutUuidNumber) {
						this.shangpinChuruInoutUuidNumber = shangpinChuruInoutUuidNumber;
					}
					/**
					* 获取： 入库名称
					*/
					public String getShangpinChuruInoutName() {
						return shangpinChuruInoutName;
					}
					/**
					* 设置： 入库名称
					*/
					public void setShangpinChuruInoutName(String shangpinChuruInoutName) {
						this.shangpinChuruInoutName = shangpinChuruInoutName;
					}
					/**
					* 获取： 入库类型
					*/
					public Integer getShangpinChuruInoutTypes() {
						return shangpinChuruInoutTypes;
					}
					/**
					* 设置： 入库类型
					*/
					public void setShangpinChuruInoutTypes(Integer shangpinChuruInoutTypes) {
						this.shangpinChuruInoutTypes = shangpinChuruInoutTypes;
					}


						/**
						* 获取： 入库类型的值
						*/
						public String getShangpinChuruInoutValue() {
							return shangpinChuruInoutValue;
						}
						/**
						* 设置： 入库类型的值
						*/
						public void setShangpinChuruInoutValue(String shangpinChuruInoutValue) {
							this.shangpinChuruInoutValue = shangpinChuruInoutValue;
						}
					/**
					* 获取： 备注
					*/
					public String getShangpinChuruInoutContent() {
						return shangpinChuruInoutContent;
					}
					/**
					* 设置： 备注
					*/
					public void setShangpinChuruInoutContent(String shangpinChuruInoutContent) {
						this.shangpinChuruInoutContent = shangpinChuruInoutContent;
					}













}
