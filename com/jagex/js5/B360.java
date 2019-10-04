// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.js5;

import tfu.Gg3;

public class B360 extends E361
{
    int d;
    Gg3 g;
    byte q;
    
    @Override
    byte[] g() {
        if (super.l || this.g.v < this.g.r.length - this.q) {
            throw new RuntimeException("Not ready!");
        }
        return this.g.r;
    }
    
    @Override
    int d() {
        if (this.g == null) {
            return 0;
        }
        return this.g.v * 100 / (this.g.r.length - this.q);
    }
    
    B360() {
    }
}
