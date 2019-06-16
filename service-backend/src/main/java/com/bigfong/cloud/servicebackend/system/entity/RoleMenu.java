package com.bigfong.cloud.servicebackend.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@ToString
@TableName("tb_role_menu")
public class RoleMenu implements Serializable {

    @TableField("role_id")
    private Integer roleId;

    @TableField("menu_id")
    private Integer menuId;
}
