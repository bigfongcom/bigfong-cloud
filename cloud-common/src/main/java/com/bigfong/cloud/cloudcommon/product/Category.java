package com.bigfong.cloud.cloudcommon.product;

import com.bigfong.cloud.cloudcommon.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class Category  implements Serializable {

    /**
     * 商品分类id
     */
    private Integer id;

    /**
     * 商品分类名称
     */
    private String name;

    /**
     * 手机端显示的商品分类名
     */
    private String mobileName;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 家族图谱
     */
    private String parentIdPath;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 顺序排序
     */
    private Integer sortOrder;

    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 分类图片
     */
    private String image;

    /**
     * 是否推荐为热门分类
     */
    private Integer isHot;

    /**
     * 分类分组默认0
     */
    private Integer catGroup;

    /**
     * 分佣比例
     */
    private Integer commissionRate;

    private Integer hasChild;

}
