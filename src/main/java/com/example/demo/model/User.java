package com.example.demo.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 李理
 * @since 2017-12-01
 */
@TableName("db_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	private String id;
	private String name;
    /**
     * 班级名称让34
     */
	@TableField("class_name")
	private String className;
	@TableField("created_at")
	private Long createdAt;
	@TableField("updated_at")
	private Long updatedAt;
	@TableField("del_tag")
	private Boolean delTag;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getDelTag() {
		return delTag;
	}

	public void setDelTag(Boolean delTag) {
		this.delTag = delTag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", name=" + name +
			", className=" + className +
			", createdAt=" + createdAt +
			", updatedAt=" + updatedAt +
			", delTag=" + delTag +
			"}";
	}
}
