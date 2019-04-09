package com.lingyun.framework.domain.shop;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class Member implements Serializable{
    private Long id;

    private Date createDate;

    private Date modifyDate;

    private String address;

    private BigDecimal amount;

    private String attributeValue0;

    private String attributeValue1;

    private String attributeValue2;

    private String attributeValue3;

    private String attributeValue4;

    private String attributeValue5;

    private String attributeValue6;

    private String attributeValue7;

    private String attributeValue8;

    private String attributeValue9;

    private BigDecimal balance;

    private Date birth;

    private String email;

    private Integer gender;

    private Boolean isEnabled;

    private Boolean isLocked;

    private Date lockedDate;

    private Date loginDate;

    private Integer loginFailureCount;

    private String loginIp;

    private String mobile;

    private String name;

    private String password;

    private String phone;

    private Long point;

    private String registerIp;

    private Date safeKeyExpire;

    private String safeKeyValue;

    private String username;

    private String zipCode;

    private Long area;

    private Long memberRank;

}