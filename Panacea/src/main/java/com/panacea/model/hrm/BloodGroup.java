package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_BLOODLIST")
public class BloodGroup {
	@Id
	@Column(name="GroupId",length=4)
	private String GroupId;
	@Column(name="GroupDesc",length=50)
	private String GroupDesc;
	public BloodGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getGroupId() {
		return GroupId;
	}
	public void setGroupId(String groupId) {
		GroupId = groupId;
	}
	public String getGroupDesc() {
		return GroupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		GroupDesc = groupDesc;
	}
	public BloodGroup(String groupId, String groupDesc) {
		super();
		GroupId = groupId;
		GroupDesc = groupDesc;
	}
	
}
