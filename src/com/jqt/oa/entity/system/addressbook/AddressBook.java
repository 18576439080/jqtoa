package com.jqt.oa.entity.system.addressbook;

import org.apache.ibatis.type.Alias;

import com.jqt.oa.entity.base.BaseEntity;

/**
 * 通讯录管理
 * @author Administrator
 *
 */
@Alias("AddressBook")
public class AddressBook extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String name;//姓名
	
	private String deptname;//部门名称
	
	private String phone;//个人电话
	
	private String workphone;//办公电话
	
	private String fixedphone;//固定电话
	
	private String fax;//传真
	
	private String email;//电子邮箱
	
	private String remark;//备注

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWorkphone() {
		return workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getFixedphone() {
		return fixedphone;
	}

	public void setFixedphone(String fixedphone) {
		this.fixedphone = fixedphone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "AddressBook [id=" + id + ", name=" + name + ", deptname=" + deptname + ", phone=" + phone
				+ ", workphone=" + workphone + ", fixedphone=" + fixedphone + ", fax=" + fax + ", email=" + email
				+ ", remark=" + remark + "]";
	}
}
