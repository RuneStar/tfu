// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scenegraph;

import org.slf4j.LoggerFactory;
import com.jagex.jnibindings.runetek6.Light;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;

public class L170 extends SceneGraphNode
{
    private static final Logger logger;
    Vector3 k;
    float n;
    
    private static void j(final L170 l170) {
        l170.v = Light.create();
        if (l170.v == 0L) {
            L170.logger.error("Uh-oh, failed to allocate another Light.  Light pool probably full.");
            return;
        }
        Light.setParams(l170.v, 0.0f, 0.0f, 0.0f, l170.n, l170.k.x, l170.k.y, l170.k.z);
    }
    
    @Override
    public void l() {
        if (super.v != 0L) {
            Light.destroy(super.v);
            super.v = 0L;
        }
    }
    
    public L170(final Vector3 vector3, final float n, final Vector3 k) {
        this.n = n;
        this.k = k;
        j(this);
        if (vector3 != null) {
            SceneGraphNode.w(this, vector3);
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(L170.class);
    }
}
