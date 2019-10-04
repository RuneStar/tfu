// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Ln265;

public class J297 extends Ln265 implements Comparable
{
    public float d;
    public float g;
    public double q;
    
    public J297(final J297 j297) {
        this.g = j297.g;
        this.d = j297.d;
        this.q = j297.q;
    }
    
    @Override
    public String toString() {
        return this.g + "," + this.d;
    }
    
    public static int g(final J297 j297, final J297 j298) {
        return (j297.q < j298.q) ? -1 : 1;
    }
    
    public J297(final float g, final float d) {
        this.g = g;
        this.d = d;
    }
}
