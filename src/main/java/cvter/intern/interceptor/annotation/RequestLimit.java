package cvter.intern.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求限制注解，使用时加在需要限制的action上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestLimit {

    /**
     * 时间段，单位为秒，默认值0
     */
    int value() default 0;

    /**
     * 提示信息
     *
     * @return 提示信息
     */
    String msg() default "";
}