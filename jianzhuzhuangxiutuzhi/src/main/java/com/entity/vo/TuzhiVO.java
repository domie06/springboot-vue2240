package com.entity.vo;

import com.entity.TuzhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 图纸信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-28
 */
@TableName("tuzhi")
public class TuzhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 图纸标题
     */

    @TableField(value = "tuzhi_name")
    private String tuzhiName;


    /**
     * 图纸预览
     */

    @TableField(value = "tuzhi_photo")
    private String tuzhiPhoto;


    /**
     * 文件
     */

    @TableField(value = "tuzhi_file")
    private String tuzhiFile;


    /**
     * 类型
     */

    @TableField(value = "tuzhi_types")
    private Integer tuzhiTypes;


    /**
     * 发布设计师
     */

    @TableField(value = "shejishi_id")
    private Integer shejishiId;


    /**
     * 详情内容
     */

    @TableField(value = "tuzhi_content")
    private String tuzhiContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：图纸标题
	 */
    public String getTuzhiName() {
        return tuzhiName;
    }


    /**
	 * 获取：图纸标题
	 */

    public void setTuzhiName(String tuzhiName) {
        this.tuzhiName = tuzhiName;
    }
    /**
	 * 设置：图纸预览
	 */
    public String getTuzhiPhoto() {
        return tuzhiPhoto;
    }


    /**
	 * 获取：图纸预览
	 */

    public void setTuzhiPhoto(String tuzhiPhoto) {
        this.tuzhiPhoto = tuzhiPhoto;
    }
    /**
	 * 设置：文件
	 */
    public String getTuzhiFile() {
        return tuzhiFile;
    }


    /**
	 * 获取：文件
	 */

    public void setTuzhiFile(String tuzhiFile) {
        this.tuzhiFile = tuzhiFile;
    }
    /**
	 * 设置：类型
	 */
    public Integer getTuzhiTypes() {
        return tuzhiTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setTuzhiTypes(Integer tuzhiTypes) {
        this.tuzhiTypes = tuzhiTypes;
    }
    /**
	 * 设置：发布设计师
	 */
    public Integer getShejishiId() {
        return shejishiId;
    }


    /**
	 * 获取：发布设计师
	 */

    public void setShejishiId(Integer shejishiId) {
        this.shejishiId = shejishiId;
    }
    /**
	 * 设置：详情内容
	 */
    public String getTuzhiContent() {
        return tuzhiContent;
    }


    /**
	 * 获取：详情内容
	 */

    public void setTuzhiContent(String tuzhiContent) {
        this.tuzhiContent = tuzhiContent;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
