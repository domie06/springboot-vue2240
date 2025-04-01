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
 * 图纸订单
 *
 * @author 
 * @email
 * @date 2021-04-28
 */
@TableName("tuzhi_order")
public class TuzhiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TuzhiOrderEntity() {

	}

	public TuzhiOrderEntity(T t) {
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
     * 订单号
     */
    @TableField(value = "order_number")

    private String orderNumber;


    /**
     * 图纸id
     */
    @TableField(value = "tuzhi_id")

    private Integer tuzhiId;


    /**
     * 用户id
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 订单状态
     */
    @TableField(value = "order_types")

    private Integer orderTypes;


    /**
     * 下单时间
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
	 * 设置：订单号
	 */
    public String getOrderNumber() {
        return orderNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    /**
	 * 设置：图纸id
	 */
    public Integer getTuzhiId() {
        return tuzhiId;
    }


    /**
	 * 获取：图纸id
	 */

    public void setTuzhiId(Integer tuzhiId) {
        this.tuzhiId = tuzhiId;
    }
    /**
	 * 设置：用户id
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户id
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：订单状态
	 */
    public Integer getOrderTypes() {
        return orderTypes;
    }


    /**
	 * 获取：订单状态
	 */

    public void setOrderTypes(Integer orderTypes) {
        this.orderTypes = orderTypes;
    }
    /**
	 * 设置：下单时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：下单时间
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
        return "TuzhiOrder{" +
            "id=" + id +
            ", orderNumber=" + orderNumber +
            ", tuzhiId=" + tuzhiId +
            ", yonghuId=" + yonghuId +
            ", orderTypes=" + orderTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
