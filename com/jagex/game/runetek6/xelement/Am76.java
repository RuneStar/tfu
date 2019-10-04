/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.xelement.Ao74;
import com.jagex.game.runetek6.xelement.Ap73;
import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.Bg72;
import com.jagex.game.runetek6.xelement.Br114;
import com.jagex.game.runetek6.xelement.Bv116;
import com.jagex.game.runetek6.xelement.D80;
import com.jagex.game.runetek6.xelement.G104;
import com.jagex.game.runetek6.xelement.J113;
import com.jagex.game.runetek6.xelement.N78;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ba115;
import tfu.Bb4;
import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;

public class Am76
extends N78 {
    private static final Logger logger = LoggerFactory.getLogger(Am76.class);
    public String aa;
    public Vector3 ah;
    public Float ao;
    public Quaternion ap;

    static void ep(Ap73 ap73, ArrayList arrayList, N78 n78, Hi86 hi86, ScriptManager scriptManager, boolean bl) {
        Object object;
        if (bl && n78.al != null) {
            for (Am76 am76 : n78.al) {
                object = new Br114((J113)am76);
                ((Ap73)object).s = am76.aa;
                if (arrayList == null) {
                    arrayList = ap73.b = new ArrayList<Object>();
                }
                arrayList.add(object);
                Am76.ep((Ap73)object, null, am76, hi86, scriptManager, bl);
            }
        }
        if (bl && n78.av != null) {
            for (Am76 am76 : n78.av) {
                object = new Bg72((Ao74)am76);
                ((Ap73)object).s = am76.aa;
                if (arrayList == null) {
                    ap73.b = new ArrayList();
                    arrayList = ap73.b;
                }
                arrayList.add(object);
                Am76.ep((Ap73)object, null, am76, hi86, scriptManager, bl);
            }
        }
        if (n78.af != null) {
            for (Am76 am76 : n78.af) {
                object = new GameEntity(GameEntity.bn.h(), scriptManager);
                try {
                    G104 g104 = XElement.bw((GameEntity)object, (XElement)am76, hi86, bl);
                    g104.s = am76.aa;
                    if (arrayList == null) {
                        ap73.b = new ArrayList();
                        arrayList = ap73.b;
                    }
                    arrayList.add(g104);
                }
                catch (Exception exception) {
                    logger.error("", exception);
                    GameEntity.b((SceneGraphNode)object);
                }
            }
        }
    }

    public static void eo(Am76 am76, Gg3 gg3) throws Au64 {
        int n;
        while ((n = Gg3.ar(gg3)) != 0) {
            Bv116 bv116 = Bv116.g(n);
            int n2 = bv116.b != -1 ? bv116.b : Gg3.bd(gg3);
            int n3 = gg3.v + n2;
            switch (bv116) {
                case ATTACHMENT_POINT: {
                    am76.aa = gg3.bh();
                    break;
                }
                case POSITION: {
                    float f = Gg3.bl(gg3);
                    float f2 = Gg3.bl(gg3);
                    float f3 = Gg3.bl(gg3);
                    am76.ah = new Vector3(f, f2, f3);
                    break;
                }
                case ORIENTATION: {
                    float f = Gg3.bl(gg3);
                    float f2 = Gg3.bl(gg3);
                    float f3 = Gg3.bl(gg3);
                    float f4 = Gg3.bl(gg3);
                    am76.ap = new Quaternion(f, f2, f3, f4);
                    break;
                }
                case SCALE: {
                    am76.ao = Float.valueOf(Gg3.bl(gg3));
                    break;
                }
                case SUPER_TYPE_PROPERTIES: {
                    N78.eg(am76, gg3);
                    break;
                }
                default: {
                    gg3.v += n2;
                }
            }
            if (gg3.v == n3) continue;
            throw new Au64("Chunk length mismatch when deserialising " + (Object)((Object)bv116) + ": expected " + n2 + " bytes, read " + (gg3.v - (n3 - n2)) + " bytes");
        }
    }

    @Override
    public void r(Gg3 gg3, Hk84 hk84, Hg85 hg85, Hi86 hi86) {
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
            Gg3.aq(gg3, this.ao.floatValue());
        }
        Gg3.k(gg3, Bv116.SUPER_TYPE_PROPERTIES.s);
        int n = gg3.v += 4;
        super.r(gg3, hk84, hg85, hi86);
        Gg3.am(gg3, gg3.v - n);
        Gg3.k(gg3, 0);
    }

    public Am76(D80 d80) {
        super(d80);
    }
}

