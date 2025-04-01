package com.entity.vo;

import com.entity.DingdanLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 订单留言
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-28
 */
@TableName("dingdan_liuyan")
public class DingdanLiuyanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
