package com.entity.model;

import com.entity.ShejishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 设计师
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-28
 */
public class ShejishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 设计师姓名
     */
    private String shejishiName;


    /**
     * 性别
     */
    private Integer sexTypes;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：设计师姓名
	 */
    public String getShejishiName() {
        return shejishiName;
    }


    /**
	 * 设置：设计师姓名
	 */
    public void setShejishiName(String shejishiName) {
        this.shejishiName = shejishiName;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：身份证号
	 */
    public String getShejishiIdNumber() {
        return shejishiIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setShejishiIdNumber(String shejishiIdNumber) {
        this.shejishiIdNumber = shejishiIdNumber;
    }
    /**
	 * 获取：手机号
	 */
    public String getShejishiPhone() {
        return shejishiPhone;
    }


    /**
	 * 设置：手机号
	 */
    public void setShejishiPhone(String shejishiPhone) {
        this.shejishiPhone = shejishiPhone;
    }
    /**
	 * 获取：照片
	 */
    public String getShejishiPhoto() {
        return shejishiPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setShejishiPhoto(String shejishiPhoto) {
        this.shejishiPhoto = shejishiPhoto;
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
