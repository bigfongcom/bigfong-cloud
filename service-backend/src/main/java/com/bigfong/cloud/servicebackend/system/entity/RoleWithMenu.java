package com.bigfong.cloud.servicebackend.system.entity;

import lombok.Data;

import java.util.List;

/**
 * 为什么创建这个类？
 * 请看 {@link com.bigfong.cloud.servicebackend.system.entity.UserWithRole} 中的解释
 *
 */
@Data
public class RoleWithMenu extends Role {

    private Integer menuId;

    private List<Integer> menuIds;
}
