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
 * 订单留言
 *
 * @author 
 * @email
 * @date 2021-04-28
 */
@TableName("dingdan_liuyan")
public class DingdanLiuyanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DingdanLiuyanEntity() {

	}

	public DingdanLiuyanEntity(T t) {
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
     * 订单id
     */
    @TableField(value = "dingdan_id")

    private Integer dingdanId;


    /**
     * 施工方id
     */
    @TableField(value = "shiguongfang_id")

    private Integer shiguongfangId;


    /**
     * 留言内容
     */
    @TableField(value = "dingdan_liuyan_content")

    private String dingdanLiuyanContent;


    /**
     * 回复内容
     */
    @TableField(value = "reply_content")

    private String replyContent;


    /**
     * 讨论时间
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
	 * 设置：订单id
	 */
    public Integer getDingdanId() {
        return dingdanId;
    }


    /**
	 * 获取：订单id
	 */

    public void setDingdanId(Integer dingdanId) {
        this.dingdanId = dingdanId;
    }
    /**
	 * 设置：施工方id
	 */
    public Integer getShiguongfangId() {
        return shiguongfangId;
    }


    /**
	 * 获取：施工方id
	 */

    public void setShiguongfangId(Integer shiguongfangId) {
        this.shiguongfangId = shiguongfangId;
    }
    /**
	 * 设置：留言内容
	 */
    public String getDingdanLiuyanContent() {
        return dingdanLiuyanContent;
    }


    /**
	 * 获取：留言内容
	 */

    public void setDingdanLiuyanContent(String dingdanLiuyanContent) {
        this.dingdanLiuyanContent = dingdanLiuyanContent;
    }
    /**
	 * 设置：回复内容
	 */
    public String getReplyContent() {
        return replyContent;
    }


    /**
	 * 获取：回复内容
	 */

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
    /**
	 * 设置：讨论时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：讨论时间
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
        return "DingdanLiuyan{" +
            "id=" + id +
            ", dingdanId=" + dingdanId +
            ", shiguongfangId=" + shiguongfangId +
            ", dingdanLiuyanContent=" + dingdanLiuyanContent +
            ", replyContent=" + replyContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
