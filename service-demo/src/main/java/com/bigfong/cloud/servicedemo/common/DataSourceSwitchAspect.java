package com.bigfong.cloud.servicedemo.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <p>
 *  数据源AOP注解实现
 * </p>
 */
@Component
@Aspect
@Order(-100)
public class DataSourceSwitchAspect {

    private Logger log= LoggerFactory.getLogger(DataSourceSwitchAspect.class);
    @Pointcut("execution(* com.bigfong.cloud.servicedemo.service.basic..*.*(..))")
    private void basicAspect() {
    }

    @Pointcut("execution(* com.bigfong.cloud.servicedemo.service.product..*.*(..))")
    private void productAspect() {
    }


    @Before( "basicAspect()" )
    public void basic(JoinPoint joinPoint) {
        log.info("切换到basic 数据源...");
        setDataSource(joinPoint,DBTypeEnum.basic);
    }

    @Before("productAspect()" )
    public void product (JoinPoint joinPoint) {
        log.info("切换到product 数据源...");
        setDataSource(joinPoint,DBTypeEnum.product);
    }


    /**
     * 添加注解方式,如果有注解优先注解,没有则按传过来的数据源配置
     * @param joinPoint
     * @param dbTypeEnum
     */
    private void setDataSource(JoinPoint joinPoint, DBTypeEnum dbTypeEnum) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DataSourceSwitch dataSourceSwitch = methodSignature.getMethod().getAnnotation(DataSourceSwitch.class);
        if (Objects.isNull(dataSourceSwitch) || Objects.isNull(dataSourceSwitch.value())) {
            DbContextHolder.setDbType(dbTypeEnum);
        }else{
            log.info("根据注解来切换数据源,注解值为:"+dataSourceSwitch.value());
            switch (dataSourceSwitch.value().getValue()) {
                case "basic":
                    DbContextHolder.setDbType(DBTypeEnum.basic);
                    break;
                case "goods":
                    DbContextHolder.setDbType(DBTypeEnum.product);
                    break;
                default:
                    DbContextHolder.setDbType(dbTypeEnum);
            }
        }
    }
}
