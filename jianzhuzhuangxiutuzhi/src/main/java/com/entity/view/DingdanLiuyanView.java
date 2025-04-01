package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.entity.DingdanLiuyanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-28
 */
@TableName("dingdan_liuyan")
public class DingdanLiuyanView extends DingdanLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 dingdan
			/**
			* 订单信息
			*/
			private Integer tuzhiOrderId;
			/**
			* 用户id
			*/
			private Integer yonghuId;
			/**
			* 图纸id
			*/
			private Integer tuzhiId;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 接单时间
			*/
			private Date insertTime;

		//级联表 shiguongfang
			/**
			* 施工方姓名
			*/
			private String shiguongfangName;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 身份证号
			*/
			private String shiguongfangIdNumber;
			/**
			* 手机号
			*/
			private String shiguongfangPhone;
			/**
			* 照片
			*/
			private String shiguongfangPhoto;
	private String shejishiName;

	public String getShejishiName() {
		return shejishiName;
	}

	public void setShejishiName(String shejishiName) {
		this.shejishiName = shejishiName;
	}



	public DingdanLiuyanView() {

	}

	public DingdanLiuyanView(DingdanLiuyanEntity dingdanLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, dingdanLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}










				//级联表的get和set dingdan
					/**
					* 获取： 订单信息
					*/
					public Integer getTuzhiOrderId() {
						return tuzhiOrderId;
					}
					/**
					* 设置： 订单信息
					*/
					public void setTuzhiOrderId(Integer tuzhiOrderId) {
						this.tuzhiOrderId = tuzhiOrderId;
					}
					/**
					* 获取： 用户id
					*/
					public Integer getYonghuId() {
						return yonghuId;
					}
					/**
					* 设置： 用户id
					*/
					public void setYonghuId(Integer yonghuId) {
						this.yonghuId = yonghuId;
					}
					/**
					* 获取： 图纸id
					*/
					public Integer getTuzhiId() {
						return tuzhiId;
					}
					/**
					* 设置： 图纸id
					*/
					public void setTuzhiId(Integer tuzhiId) {
						this.tuzhiId = tuzhiId;
					}
					/**
					* 获取： 接单时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 接单时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}













				//级联表的get和set shiguongfang
					/**
					* 获取： 施工方姓名
					*/
					public String getShiguongfangName() {
						return shiguongfangName;
					}
					/**
					* 设置： 施工方姓名
					*/
					public void setShiguongfangName(String shiguongfangName) {
						this.shiguongfangName = shiguongfangName;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getShiguongfangIdNumber() {
						return shiguongfangIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setShiguongfangIdNumber(String shiguongfangIdNumber) {
						this.shiguongfangIdNumber = shiguongfangIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getShiguongfangPhone() {
						return shiguongfangPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setShiguongfangPhone(String shiguongfangPhone) {
						this.shiguongfangPhone = shiguongfangPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getShiguongfangPhoto() {
						return shiguongfangPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setShiguongfangPhoto(String shiguongfangPhoto) {
						this.shiguongfangPhoto = shiguongfangPhoto;
					}


















}
