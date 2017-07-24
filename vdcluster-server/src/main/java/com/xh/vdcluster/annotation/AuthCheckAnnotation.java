package com.xh.vdcluster.annotation;

/**
 * Created by macbookpro on 17/7/23.
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheckAnnotation {
    boolean check() default false;
}
