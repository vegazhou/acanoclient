package com.kt.acanoclient.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
@Target({FIELD})
@Retention(RUNTIME)
public @interface ID {

}
