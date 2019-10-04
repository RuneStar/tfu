// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
public @interface ScriptDefaults {
    boolean defaultBoolean() default false;
    
    int defaultLightUserData() default 0;
    
    int defaultInteger() default 0;
    
    String defaultString() default "";
    
    double defaultNumber() default 0.0;
}
