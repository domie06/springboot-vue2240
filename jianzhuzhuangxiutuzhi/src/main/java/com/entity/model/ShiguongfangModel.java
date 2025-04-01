package com.entity.model;

import com.entity.ShiguongfangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 施工方
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-28
 */
public class ShiguongfangModel implements Serializable {
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
     * 施工方姓名
     */
    private String shiguongfangName;


    /**
     * 性别
     */
    private Integer sexTypes;


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
	 * 获取：施工方姓名
	 */
    public String getShiguongfangName() {
        return shiguongfangName;
    }


    /**
	 * 设置：施工方姓名
	 */
    public void setShiguongfangName(String shiguongfangName) {
        this.shiguongfangName = shiguongfangName;
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
    public String getShiguongfangIdNumber() {
        return shiguongfangIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setShiguongfangIdNumber(String shiguongfangIdNumber) {
        this.shiguongfangIdNumber = shiguongfangIdNumber;
    }
    /**
	 * 获取：手机号
	 */
    public String getShiguongfangPhone() {
        return shiguongfangPhone;
    }


    /**
	 * 设置：手机号
	 */
    public void setShiguongfangPhone(String shiguongfangPhone) {
        this.shiguongfangPhone = shiguongfangPhone;
    }
    /**
	 * 获取：照片
	 */
    public String getShiguongfangPhoto() {
        return shiguongfangPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setShiguongfangPhoto(String shiguongfangPhoto) {
        this.shiguongfangPhoto = shiguongfangPhoto;
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
