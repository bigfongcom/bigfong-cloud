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
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 3554316034860494763L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String salt;

    @TableField("dept_id")
    private Integer deptId;

    /*@Transient
    private String deptName;*/

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("create_time")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("modify_time")
    private Date modifyTime;

    private String avatar;

    private String phone;

    private String sex;

    private String description;

    private Boolean status;

    public void setUsername(String username) {
        this.username = username == null ? "" : username.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? "" : password.trim();
    }
}
