package cvter.intern.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by cvter on 2017/5/25.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestLimit {

    /**
     * 时间段，单位为秒，默认值0
     */
    int value() default 0;
}