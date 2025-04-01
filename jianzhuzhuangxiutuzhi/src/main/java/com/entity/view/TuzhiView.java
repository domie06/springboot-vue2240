package com.entity.view;

import com.entity.TuzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 图纸信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-28
 */
@TableName("tuzhi")
public class TuzhiView extends TuzhiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 类型的值
		*/
		private String tuzhiValue;



		//级联表 shejishi
			/**
			* 设计师姓名
			*/
			private String shejishiName;
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
			private String shejishiIdNumber;
			/**
			* 手机号
			*/
			private String shejishiPhone;
			/**
			* 照片
			*/
			private String shejishiPhoto;

	public TuzhiView() {

	}

	public TuzhiView(TuzhiEntity tuzhiEntity) {
		try {
			BeanUtils.copyProperties(this, tuzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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












				//级联表的get和set shejishi
					/**
					* 获取： 设计师姓名
					*/
					public String getShejishiName() {
						return shejishiName;
					}
					/**
					* 设置： 设计师姓名
					*/
					public void setShejishiName(String shejishiName) {
						this.shejishiName = shejishiName;
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
					public String getShejishiIdNumber() {
						return shejishiIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setShejishiIdNumber(String shejishiIdNumber) {
						this.shejishiIdNumber = shejishiIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getShejishiPhone() {
						return shejishiPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setShejishiPhone(String shejishiPhone) {
						this.shejishiPhone = shejishiPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getShejishiPhoto() {
						return shejishiPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setShejishiPhoto(String shejishiPhoto) {
						this.shejishiPhoto = shejishiPhoto;
					}














}
