package com.lingyun.framework.domain.admin;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Info {
    private Integer infoid;

    private String infoname;

    private String infotheme;

    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss-sss")

    private Date infotdate;

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

    public String getInfoname() {
        return infoname;
    }

    public void setInfoname(String infoname) {
        this.infoname = infoname == null ? null : infoname.trim();
    }

    public String getInfotheme() {
        return infotheme;
    }

    public void setInfotheme(String infotheme) {
        this.infotheme = infotheme == null ? null : infotheme.trim();
    }

    public Date getInfotdate() {
        return infotdate;
    }

    public void setInfotdate(Date infotdate) {
        this.infotdate = infotdate;
    }
}