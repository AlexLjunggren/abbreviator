package io.ljunggren.abbreviator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AbbreviateAddress {

    boolean capitalize();
    boolean usePeriod();
    boolean aggresive() default false;
    
}
