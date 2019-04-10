package com.lingyun.framework.domain.shop;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Admin implements Serializable{
    private Long id;

    private Date createDate;

    private Date modifyDate;

    private String department;

    private String email;

    private Boolean isEnabled;

    private Boolean isLocked;

    private Date lockedDate;

    private Date loginDate;

    private Integer loginFailureCount;

    private String loginIp;

    private String name;

    private String password;

    private String username;


}