package com.kt.acanoclient.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
@Target({TYPE})
@Retention(RUNTIME)
public @interface AcanoType {
    String value();
}
