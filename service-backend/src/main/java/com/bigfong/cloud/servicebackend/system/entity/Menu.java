package com.bigfong.cloud.servicebackend.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Data
@ToString
@TableName("tb_menu")
public class Menu implements Serializable {

    public static final String TYPE_MENU = "menu";
    public static final String TYPE_BUTTON = "button";

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    @TableField("parent_id")
    private Integer parentId;

    private String url;

    private String perms;

    private String type;

    private String icon;

    private Integer priority;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("create_time")
    private Date createTime;

    private Boolean status;

    public void setName(String name) {
        this.name = name == null ? "" : name.trim();
    }

    public void setUrl(String url) {
        this.url = url == null ? "" : url.trim();
    }

    public void setPerms(String perms) {
        this.perms = perms == null ? "" : perms.trim();
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? "" : icon.trim();
    }
}
