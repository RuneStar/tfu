/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface ScriptDefaults {
    public boolean defaultBoolean() default false;

    public int defaultLightUserData() default 0;

    public int defaultInteger() default 0;

    public String defaultString() default "";

    public double defaultNumber() default 0.0;
}

