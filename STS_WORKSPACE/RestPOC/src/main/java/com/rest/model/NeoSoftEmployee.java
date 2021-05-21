package com.rest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Data
@Entity
@Table(name = "neosoftemployees")
public class NeoSoftEmployee {
	@Id
	private long id;
    private String name;
    private String surName;
    private String emailId;
    private String aadharNo;
    private String PassportNo;
    private long contactNo;
    private String pinCode;
    private Integer activeFlag;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date DOB;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date joiningDate;
    
	/*
	 * public long getId() { return id; } public void setId(long id) { this.id = id;
	 * } public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public String getSurName() { return surName; } public
	 * void setSurName(String surName) { this.surName = surName; } public String
	 * getEmailId() { return emailId; } public void setEmailId(String emailId) {
	 * this.emailId = emailId; } public String getAadharNo() { return aadharNo; }
	 * public void setAadharNo(String aadharNo) { this.aadharNo = aadharNo; } public
	 * String getPassportNo() { return PassportNo; } public void
	 * setPassportNo(String passportNo) { PassportNo = passportNo; } public long
	 * getContactNo() { return contactNo; } public void setContactNo(long contactNo)
	 * { this.contactNo = contactNo; } public String getPinCode() { return pinCode;
	 * } public void setPinCode(String pinCode) { this.pinCode = pinCode; } public
	 * Integer getActiveFlag() { return activeFlag; } public void
	 * setActiveFlag(Integer activeFlag) { this.activeFlag = activeFlag; } public
	 * Date getDOB() { return DOB; } public void setDOB(Date dOB) { DOB = dOB; }
	 * public Date getJoiningDate() { return joiningDate; } public void
	 * setJoiningDate(Date joiningDate) { this.joiningDate = joiningDate; }
	 * 
	 * @Override public String toString() { return "NeoSoftEmployee [id=" + id +
	 * ", name=" + name + ", surName=" + surName + ", emailId=" + emailId +
	 * ", aadharNo=" + aadharNo + ", PassportNo=" + PassportNo + ", contactNo=" +
	 * contactNo + ", pinCode=" + pinCode + ", activeFlag=" + activeFlag + ", DOB="
	 * + DOB + ", joiningDate=" + joiningDate + "]"; }
	 */
    
    
}