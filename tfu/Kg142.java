// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.maths.Vector3;

public class Kg142 implements Kz261
{
    public Vector3 g;
    
    public Kg142(final Vector3 g) {
        this.g = g;
    }
    
    public Kg142() {
        this.g = Vector3.g;
    }
    
    @Override
    public void d(final Gg3 gg3) {
        Vector3.w(this.g, gg3);
    }
    
    @Override
    public int g() {
        return Vector3.r(this.g);
    }
    
    @Override
    public void q(final Gg3 gg3) {
        this.g = Vector3.d(gg3);
    }
}
