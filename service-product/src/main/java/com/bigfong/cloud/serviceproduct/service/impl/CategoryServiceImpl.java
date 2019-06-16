package com.bigfong.cloud.serviceproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.cloudcommon.product.Category;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import com.bigfong.cloud.serviceproduct.common.DBTypeEnum;
import com.bigfong.cloud.serviceproduct.common.DataSourceSwitch;
import com.bigfong.cloud.serviceproduct.mapper.CategoryMapper;
import com.bigfong.cloud.serviceproduct.mapper.ProductMapper;
import com.bigfong.cloud.serviceproduct.service.ICategoryService;
import com.bigfong.cloud.serviceproduct.service.IProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 产品表
 服务实现类
 * </p>
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    private List<Category> categoryList;
    private Map<Integer,Category> categoryTreeMap;

    @Override
    public List<Category> getCategoryList() {
        categoryTreeMap = new LinkedHashMap<>();
        categoryList =  categoryMapper.selectAll();
        for (Category category : categoryList) {
            if (category.getLevel()==1){
                this.getCatTree(category);
            }
        }

        Collection<Category> valueCollection = categoryTreeMap.values();
        List<Category> categoryList2= new ArrayList<Category>(categoryTreeMap.values());

        return categoryList2;
    }

    private void getCatTree(Category category) {
        Integer gid = category.getId();
        categoryTreeMap.put(gid,category);

        for (Category item : categoryList) {
            if (item.getParentId()==gid){
                this.getCatTree(item);

                if (category.getHasChild() == null || category.getHasChild()==0){
                    category.setHasChild(1);
                    categoryTreeMap.put(gid,category); // 还有下级
                }

            }
        }
    }

}
