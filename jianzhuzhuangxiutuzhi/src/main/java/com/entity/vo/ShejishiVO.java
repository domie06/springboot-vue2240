package com.entity.vo;

import com.entity.ShejishiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 设计师
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-28
 */
@TableName("shejishi")
public class ShejishiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 设计师姓名
     */

    @TableField(value = "shejishi_name")
    private String shejishiName;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 身份证号
     */

    @TableField(value = "shejishi_id_number")
    private String shejishiIdNumber;


    /**
     * 手机号
     */

    @TableField(value = "shejishi_phone")
    private String shejishiPhone;


    /**
     * 照片
     */

    @TableField(value = "shejishi_photo")
    private String shejishiPhoto;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：设计师姓名
	 */
    public String getShejishiName() {
        return shejishiName;
    }


    /**
	 * 获取：设计师姓名
	 */

    public void setShejishiName(String shejishiName) {
        this.shejishiName = shejishiName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：身份证号
	 */
    public String getShejishiIdNumber() {
        return shejishiIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setShejishiIdNumber(String shejishiIdNumber) {
        this.shejishiIdNumber = shejishiIdNumber;
    }
    /**
	 * 设置：手机号
	 */
    public String getShejishiPhone() {
        return shejishiPhone;
    }


    /**
	 * 获取：手机号
	 */

    public void setShejishiPhone(String shejishiPhone) {
        this.shejishiPhone = shejishiPhone;
    }
    /**
	 * 设置：照片
	 */
    public String getShejishiPhoto() {
        return shejishiPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setShejishiPhoto(String shejishiPhoto) {
        this.shejishiPhoto = shejishiPhoto;
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
