package com.entity.view;

import com.entity.DingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 已接订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-28
 */
@TableName("dingdan")
public class DingdanView extends DingdanEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 tuzhi
			/**
			* 图纸标题
			*/
			private String tuzhiName;
			/**
			* 图纸预览
			*/
			private String tuzhiPhoto;
			/**
			* 文件
			*/
			private String tuzhiFile;
			/**
			* 类型
			*/
			private Integer tuzhiTypes;
				/**
				* 类型的值
				*/
				private String tuzhiValue;
			/**
			* 发布设计师
			*/
			private Integer shejishiId;
			/**
			* 详情内容
			*/
			private String tuzhiContent;

		//级联表 tuzhi_order
			/**
			* 订单号
			*/
			private String orderNumber;
			/**
			* 图纸id
			*/
			private Integer tuzhiId;
			/**
			* 用户id
			*/
			private Integer yonghuId;
			/**
			* 订单状态
			*/
			private Integer orderTypes;
				/**
				* 订单状态的值
				*/
				private String orderValue;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 下单时间
			*/
			private Date insertTime;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
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
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public DingdanView() {

	}

	public DingdanView(DingdanEntity dingdanEntity) {
		try {
			BeanUtils.copyProperties(this, dingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

































				//级联表的get和set tuzhi
					/**
					* 获取： 图纸标题
					*/
					public String getTuzhiName() {
						return tuzhiName;
					}
					/**
					* 设置： 图纸标题
					*/
					public void setTuzhiName(String tuzhiName) {
						this.tuzhiName = tuzhiName;
					}
					/**
					* 获取： 图纸预览
					*/
					public String getTuzhiPhoto() {
						return tuzhiPhoto;
					}
					/**
					* 设置： 图纸预览
					*/
					public void setTuzhiPhoto(String tuzhiPhoto) {
						this.tuzhiPhoto = tuzhiPhoto;
					}
					/**
					* 获取： 文件
					*/
					public String getTuzhiFile() {
						return tuzhiFile;
					}
					/**
					* 设置： 文件
					*/
					public void setTuzhiFile(String tuzhiFile) {
						this.tuzhiFile = tuzhiFile;
					}
					/**
					* 获取： 类型
					*/
					public Integer getTuzhiTypes() {
						return tuzhiTypes;
					}
					/**
					* 设置： 类型
					*/
					public void setTuzhiTypes(Integer tuzhiTypes) {
						this.tuzhiTypes = tuzhiTypes;
					}


						/**
						* 获取： 类型的值
						*/
						public String getTuzhiValue() {
							return tuzhiValue;
						}
						/**
						* 设置： 类型的值
						*/
						public void setTuzhiValue(String tuzhiValue) {
							this.tuzhiValue = tuzhiValue;
						}
					/**
					* 获取： 发布设计师
					*/
					public Integer getShejishiId() {
						return shejishiId;
					}
					/**
					* 设置： 发布设计师
					*/
					public void setShejishiId(Integer shejishiId) {
						this.shejishiId = shejishiId;
					}
					/**
					* 获取： 详情内容
					*/
					public String getTuzhiContent() {
						return tuzhiContent;
					}
					/**
					* 设置： 详情内容
					*/
					public void setTuzhiContent(String tuzhiContent) {
						this.tuzhiContent = tuzhiContent;
					}








				//级联表的get和set tuzhi_order
					/**
					* 获取： 订单号
					*/
					public String getOrderNumber() {
						return orderNumber;
					}
					/**
					* 设置： 订单号
					*/
					public void setOrderNumber(String orderNumber) {
						this.orderNumber = orderNumber;
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
					* 获取： 订单状态
					*/
					public Integer getOrderTypes() {
						return orderTypes;
					}
					/**
					* 设置： 订单状态
					*/
					public void setOrderTypes(Integer orderTypes) {
						this.orderTypes = orderTypes;
					}


						/**
						* 获取： 订单状态的值
						*/
						public String getOrderValue() {
							return orderValue;
						}
						/**
						* 设置： 订单状态的值
						*/
						public void setOrderValue(String orderValue) {
							this.orderValue = orderValue;
						}
					/**
					* 获取： 下单时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 下单时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}





				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
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
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}





}
