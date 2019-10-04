// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import org.slf4j.LoggerFactory;
import tfu.Hg85;
import tfu.Hk84;
import tfu.Gg3;
import java.util.Iterator;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptManager;
import tfu.Hi86;
import java.util.ArrayList;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;

public class Am76 extends N78
{
    private static final Logger logger;
    public String aa;
    public Vector3 ah;
    public Float ao;
    public Quaternion ap;
    
    static void ep(final Ap73 ap73, ArrayList list, final N78 n78, final Hi86 hi86, final ScriptManager scriptManager, final boolean b) {
        if (b && n78.al != null) {
            for (final J113 j113 : n78.al) {
                final Br114 e = new Br114(j113);
                e.s = j113.aa;
                if (list == null) {
                    final ArrayList<Bg72> b2 = new ArrayList<Bg72>();
                    ap73.b = b2;
                    list = b2;
                }
                list.add((Bg72)e);
                ep(e, null, j113, hi86, scriptManager, b);
            }
        }
        if (b && n78.av != null) {
            for (final Ao74 ao74 : n78.av) {
                final Bg72 e2 = new Bg72(ao74);
                e2.s = ao74.aa;
                if (list == null) {
                    final ArrayList<Bg72> b3 = new ArrayList<Bg72>();
                    ap73.b = b3;
                    list = b3;
                }
                list.add(e2);
                ep(e2, null, ao74, hi86, scriptManager, b);
            }
        }
        if (n78.af != null) {
            for (final XElement xElement : n78.af) {
                final GameEntity gameEntity = new GameEntity(GameEntity.bn.h(), scriptManager);
                try {
                    final G104 bw = XElement.bw(gameEntity, xElement, hi86, b);
                    bw.s = xElement.aa;
                    if (list == null) {
                        final ArrayList<Bg72> b4 = new ArrayList<Bg72>();
                        ap73.b = b4;
                        list = b4;
                    }
                    list.add((Bg72)bw);
                }
                catch (Exception ex) {
                    Am76.logger.error("", ex);
                    SceneGraphNode.b(gameEntity);
                }
            }
        }
    }
    
    public static void eo(final Am76 am76, final Gg3 gg3) throws Au64 {
        int ar;
        while ((ar = Gg3.ar(gg3)) != 0) {
            final Bv116 g = Bv116.g(ar);
            final int i = (g.b != -1) ? g.b : Gg3.bd(gg3);
            final int n = gg3.v + i;
            switch (L117.g[g.ordinal()]) {
                case 1: {
                    am76.aa = gg3.bh();
                    break;
                }
                case 2: {
                    am76.ah = new Vector3(Gg3.bl(gg3), Gg3.bl(gg3), Gg3.bl(gg3));
                    break;
                }
                case 3: {
                    am76.ap = new Quaternion(Gg3.bl(gg3), Gg3.bl(gg3), Gg3.bl(gg3), Gg3.bl(gg3));
                    break;
                }
                case 4: {
                    am76.ao = Gg3.bl(gg3);
                    break;
                }
                case 5: {
                    N78.eg(am76, gg3);
                    break;
                }
                default: {
                    gg3.v += i;
                    break;
                }
            }
            if (gg3.v != n) {
                throw new Au64("Chunk length mismatch when deserialising " + g + ": expected " + i + " bytes, read " + (gg3.v - (n - i)) + " bytes");
            }
        }
    }
    
    @Override
    public void r(final Gg3 gg3, final Hk84 hk84, final Hg85 hg85, final Hi86 hi86) {
        if (this.aa != null) {
            Gg3.k(gg3, Bv116.ATTACHMENT_POINT.s);
            Gg3.a(gg3, Gg3.av(this.aa));
            gg3.ap(this.aa);
        }
        if (this.ah != null) {
            Gg3.k(gg3, Bv116.POSITION.s);
            Gg3.aq(gg3, this.ah.x);
            Gg3.aq(gg3, this.ah.y);
            Gg3.aq(gg3, this.ah.z);
        }
        if (this.ap != null) {
            Gg3.k(gg3, Bv116.ORIENTATION.s);
            Gg3.aq(gg3, this.ap.x);
            Gg3.aq(gg3, this.ap.y);
            Gg3.aq(gg3, this.ap.z);
            Gg3.aq(gg3, this.ap.w);
        }
        if (this.ao != null) {
            Gg3.k(gg3, Bv116.SCALE.s);
            Gg3.aq(gg3, this.ao);
        }
        Gg3.k(gg3, Bv116.SUPER_TYPE_PROPERTIES.s);
        final int v = gg3.v + 4;
        gg3.v = v;
        final int n = v;
        super.r(gg3, hk84, hg85, hi86);
        Gg3.am(gg3, gg3.v - n);
        Gg3.k(gg3, 0);
    }
    
    static {
        logger = LoggerFactory.getLogger(Am76.class);
    }
    
    public Am76(final D80 d80) {
        super(d80);
    }
}
