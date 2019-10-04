// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import org.slf4j.LoggerFactory;
import java.util.Iterator;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.ArrayList;
import org.slf4j.Logger;

abstract class Ap73
{
    private static final Logger logger;
    ArrayList b;
    String s;
    
    static final void r(final Ap73 ap73, final SceneGraphNode sceneGraphNode) {
        if (ap73.b != null) {
            for (final Ap73 ap74 : ap73.b) {
                try {
                    final SceneGraphNode y = ap74.y();
                    sceneGraphNode.attach(y, ap74.s);
                    r(ap74, y);
                }
                catch (Exception ex) {
                    Ap73.logger.error("", ex);
                }
            }
        }
    }
    
    abstract SceneGraphNode y();
    
    abstract void p();
    
    static {
        logger = LoggerFactory.getLogger(Ap73.class);
    }
    
    public static final void v(final Ap73 ap73) {
        ap73.p();
        if (ap73.b != null) {
            final Iterator<Ap73> iterator = ap73.b.iterator();
            while (iterator.hasNext()) {
                v(iterator.next());
            }
        }
    }
}
