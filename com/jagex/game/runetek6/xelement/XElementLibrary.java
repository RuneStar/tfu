// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Mz200;
import tfu.Ik357;
import tfu.Bn279;
import tfu.Lb33;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import tfu.Be2;
import tfu.Bs1;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.scripthelpers.STaskFuture;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Ia63;
import tfu.Hi86;
import tfu.Hk84;
import tfu.Bv351;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("ElementLibrary")
public class XElementLibrary extends D80
{
    private static final Logger logger;
    private final Bv351 b;
    public final Hk84 e;
    final Bk68 h;
    public final Hi86 j;
    private Q79 q;
    public final Ia63 s;
    
    public XElementLibrary(final Hi86 j, final Hk84 e, final Q79 q, final Bk68 h) {
        super(null);
        this.s = new Ab205(this);
        this.b = new Bv351();
        this.e = e;
        this.j = j;
        this.q = q;
        this.h = h;
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public STaskFuture getElementForEntity(final GameEntity gameEntity, final String s, final EventHandler eventHandler) {
        return new STaskFuture(this.r(gameEntity, Hk84.g(this.e, XElement.class, s), eventHandler));
    }
    
    @Override
    public void j(final String s) {
        Q79.g(this.q, s);
    }
    
    public static void y(final XElementLibrary xElementLibrary) {
        Hi86.w(xElementLibrary.j);
    }
    
    @Override
    public int d(final String s) {
        return Q79.d(this.q, s);
    }
    
    @Override
    public String q(final int n) {
        return Q79.q(this.q, n);
    }
    
    static {
        logger = LoggerFactory.getLogger(XElementLibrary.class);
    }
    
    public static void v(final XElementLibrary xElementLibrary) {
        Lb33.g(Lb33.XElementLibraryQueue);
        try {
            while (true) {
                final Bn279 g = xElementLibrary.b.g();
                if (g == null) {
                    break;
                }
                try {
                    if (((Bf71)g.j).g.getScene() == null) {
                        continue;
                    }
                    ((Bf71)g.j).d.trigger(g.d(), null);
                }
                catch (Exception ex) {
                    XElementLibrary.logger.error("", ex);
                }
            }
        }
        finally {
            Lb33.d(Lb33.XElementLibraryQueue);
        }
    }
    
    public static XElement w(final XElementLibrary xElementLibrary, final Integer n) {
        try {
            return (XElement)xElementLibrary.j.j(XElement.class, n);
        }
        catch (Ik357 ik357) {
            return null;
        }
    }
    
    public Bn279 r(final GameEntity g, final Integer n, final EventHandler d) {
        if (g == null) {
            throw new NullPointerException();
        }
        if (g.getScene() == null) {
            throw new IllegalArgumentException("GetElementForEntity() must be called with an entity already added to a scene - this entity has not been added");
        }
        final Bf71 bf71 = new Bf71();
        bf71.g = g;
        bf71.d = d;
        return this.j.h(XElement.class, n, new Ad199(this, g), this.b, bf71);
    }
}
