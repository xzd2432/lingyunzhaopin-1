package com.lingyun.framework.domain.admin;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Job implements Serializable {
    private Integer id;

    private String jobname;

    private String address;

    private String addressDetails;

    private String pay;

    private String minEducation;

    private String jobCategory;

    private String jobSkill;

    private String brightSpot;

    private Integer jobNumber;

    private String department;

    private Date createdatetime;

    private Date uptodate;

    private Integer companyId;

    private String jobDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname == null ? null : jobname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails == null ? null : addressDetails.trim();
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay == null ? null : pay.trim();
    }

    public String getMinEducation() {
        return minEducation;
    }

    public void setMinEducation(String minEducation) {
        this.minEducation = minEducation == null ? null : minEducation.trim();
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory == null ? null : jobCategory.trim();
    }

    public String getjobSkill() {
        return jobSkill;
    }

    public void setjobSkill(String jobSkill) {
        this.jobSkill = jobSkill == null ? null : jobSkill.trim();
    }

    public String getBrightSpot() {
        return brightSpot;
    }

    public void setBrightSpot(String brightSpot) {
        this.brightSpot = brightSpot == null ? null : brightSpot.trim();
    }

    public Integer getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Integer jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Date getUptodate() {
        return uptodate;
    }

    public void setUptodate(Date uptodate) {
        this.uptodate = uptodate;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getJobDescribe() {
        return jobDescribe;
    }

    public void setJobDescribe(String jobDescribe) {
        this.jobDescribe = jobDescribe == null ? null : jobDescribe.trim();
    }
}