// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import com.jagex.maths.V198;
import com.jagex.maths.Vector3;

public enum Ag97
{
    d("NUMERIC", 1, (Class)Double.class, "number") {
        Az96(final String s, final int n, final Class clazz, final String s2) {
        }
    }, 
    e("VECTOR4", 4, (Class)V198.class, "vector4") {
        Al118(final String s, final int n, final Class clazz, final String s2) {
        }
    }, 
    g("STRING", 0, (Class)String.class, "string") {
        M195(final String s, final int n, final Class clazz, final String s2) {
        }
    }, 
    j("VECTOR3", 3, (Class)Vector3.class, "vector3") {
        Y197(final String s, final int n, final Class clazz, final String s2) {
        }
    }, 
    q("BOOLEAN", 2, (Class)Boolean.class, "boolean") {
        C196(final String s, final int n, final Class clazz, final String s2) {
        }
    };
    
    public final Class h;
    public final String s;
    
    private Ag97(final String name, final int ordinal, final Class h, final String s) {
        this.h = h;
        this.s = s;
    }
}
