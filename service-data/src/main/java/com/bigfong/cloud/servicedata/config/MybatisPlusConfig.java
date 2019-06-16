package com.bigfong.cloud.servicedata.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.bigfong.cloud.servicedata.common.DBTypeEnum;
import com.bigfong.cloud.servicedata.common.DynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  持久化配置
 * </p>
 *
 * @author lizhe
 * @since 2019-1-31
 */
@Configuration
@MapperScan({"com.bigfong.cloud.servicedata.mapper.*"})
public class MybatisPlusConfig {

    /**
     * mapper-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //paginationInterceptor.setLocalPage(true);// 开启 PageHelper 的支持
        return paginationInterceptor;
    }

    /**
     * mapper-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    @Bean(name = "basic")
    @ConfigurationProperties(prefix = "spring.datasource.druid.basic" )
    public DataSource basic () {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "product")
    @ConfigurationProperties(prefix = "spring.datasource.druid.goods" )
    public DataSource product () {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源配置
     * @return
     */
    @Bean
    @Primary
    public DataSource multipleDataSource (@Qualifier("basic") DataSource basic,
                                          @Qualifier("product") DataSource product ) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map< Object, Object > targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.basic.getValue(), basic );
        targetDataSources.put(DBTypeEnum.product.getValue(), product);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(basic);
        return dynamicDataSource;
    }


}
