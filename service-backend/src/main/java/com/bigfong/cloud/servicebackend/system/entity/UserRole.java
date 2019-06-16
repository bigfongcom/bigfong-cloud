package com.bigfong.cloud.servicebackend.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;


@Data
@ToString
@TableName("tb_user_role")
public class UserRole implements Serializable {

    @TableField("user_id")
    private Integer userId;

    @TableField("role_id")
    private Integer roleId;
}
