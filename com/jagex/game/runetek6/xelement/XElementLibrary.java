/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.scripthelpers.STaskFuture;
import com.jagex.game.runetek6.xelement.Ab205;
import com.jagex.game.runetek6.xelement.Ad199;
import com.jagex.game.runetek6.xelement.Bf71;
import com.jagex.game.runetek6.xelement.Bk68;
import com.jagex.game.runetek6.xelement.D80;
import com.jagex.game.runetek6.xelement.Q79;
import com.jagex.game.runetek6.xelement.XElement;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bn279;
import tfu.Bs1;
import tfu.Bv351;
import tfu.Hi86;
import tfu.Hk84;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Ik357;
import tfu.Lb33;
import tfu.Mz200;

@ScriptEntryClass(value="ElementLibrary")
public class XElementLibrary
extends D80 {
    private static final Logger logger = LoggerFactory.getLogger(XElementLibrary.class);
    private final Bv351 b;
    public final Hk84 e;
    final Bk68 h;
    public final Hi86 j;
    private Q79 q;
    public final Ia63 s = new Ab205(this);

    public XElementLibrary(Hi86 hi86, Hk84 hk84, Q79 q79, Bk68 bk68) {
        super(null);
        this.b = new Bv351();
        this.e = hk84;
        this.j = hi86;
        this.q = q79;
        this.h = bk68;
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public STaskFuture getElementForEntity(GameEntity gameEntity, String string, EventHandler eventHandler) {
        return new STaskFuture(this.r(gameEntity, Hk84.g(this.e, XElement.class, string), eventHandler));
    }

    @Override
    public void j(String string) {
        Q79.g(this.q, string);
    }

    public static void y(XElementLibrary xElementLibrary) {
        Hi86.w(xElementLibrary.j);
    }

    @Override
    public int d(String string) {
        return Q79.d(this.q, string);
    }

    @Override
    public String q(int n) {
        return Q79.q(this.q, n);
    }

    public static void v(XElementLibrary xElementLibrary) {
        Lb33.g(Lb33.XElementLibraryQueue);
        block4 : do {
            try {
                do {
                    Bn279 bn279;
                    if ((bn279 = xElementLibrary.b.g()) == null) {
                        Lb33.d(Lb33.XElementLibraryQueue);
                        return;
                    }
                    try {
                        GameEntity gameEntity = ((Bf71)bn279.j).g;
                        if (gameEntity.getScene() == null) continue block4;
                        ((Bf71)bn279.j).d.trigger(bn279.d(), null);
                        continue block4;
                    }
                    catch (Exception exception) {
                        logger.error("", exception);
                        continue;
                    }
                    break;
                } while (true);
            }
            catch (Throwable throwable) {
                Lb33.d(Lb33.XElementLibraryQueue);
                throw throwable;
            }
        } while (true);
    }

    public static XElement w(XElementLibrary xElementLibrary, Integer n) {
        try {
            return (XElement)xElementLibrary.j.j(XElement.class, n);
        }
        catch (Ik357 ik357) {
            return null;
        }
    }

    public Bn279 r(GameEntity gameEntity, Integer n, EventHandler eventHandler) {
        if (gameEntity == null) {
            throw new NullPointerException();
        }
        if (gameEntity.getScene() == null) {
            throw new IllegalArgumentException("GetElementForEntity() must be called with an entity already added to a scene - this entity has not been added");
        }
        Bf71 bf71 = new Bf71();
        bf71.g = gameEntity;
        bf71.d = eventHandler;
        return this.j.h(XElement.class, n, new Ad199(this, gameEntity), this.b, bf71);
    }
}

