/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.MappedEventType;
import com.jagex.game.runetek6.event.PhysicsEventMode;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.scripthelpers.STaskFuture;
import com.jagex.game.runetek6.xelement.Ag97;
import com.jagex.game.runetek6.xelement.Ah203;
import com.jagex.game.runetek6.xelement.Am76;
import com.jagex.game.runetek6.xelement.An120;
import com.jagex.game.runetek6.xelement.Aq107;
import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.Aw103;
import com.jagex.game.runetek6.xelement.Ay90;
import com.jagex.game.runetek6.xelement.B352;
import com.jagex.game.runetek6.xelement.Bj61;
import com.jagex.game.runetek6.xelement.Bm108;
import com.jagex.game.runetek6.xelement.Bu169;
import com.jagex.game.runetek6.xelement.Bw168;
import com.jagex.game.runetek6.xelement.D80;
import com.jagex.game.runetek6.xelement.G104;
import com.jagex.game.runetek6.xelement.S356;
import com.jagex.game.runetek6.xelement.V355;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.jnibindings.runetek6.Animation;
import com.jagex.jnibindings.runetek6.D91;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.maths.Matrix4;
import com.jagex.maths.Q10;
import com.jagex.maths.Quaternion;
import com.jagex.maths.V198;
import com.jagex.maths.Vector3;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ai354;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bn279;
import tfu.Br121;
import tfu.Bs1;
import tfu.Bu350;
import tfu.Bv351;
import tfu.Fk353;
import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;
import tfu.Hp62;
import tfu.Ik357;
import tfu.Iz11;
import tfu.Ki358;
import tfu.Lb33;
import tfu.N105;

@ScriptEntryClass(value="Element")
public class XElement
extends Am76
implements Hp62 {
    private static final Bu350 ag;
    public static XElementLibrary ai;
    private static final Bv351 aq;
    private static Object[] c;
    public static boolean f;
    public static Bb4 j;
    private static final Logger logger;
    public static boolean q;
    private B352 a;
    private XElement b;
    private UUID e;
    private Serializable h;
    private Map i;
    private Set k;
    public Map l = new HashMap();
    private Map m;
    private Map n;
    private Map o;
    public Map p = null;
    private Serializable r = null;
    private Serializable s;
    private Map t;
    public int u = 7;
    private Serializable v = null;
    public Q10 w;
    public PhysicsEventMode x = null;
    private Map y = null;
    public List z;

    public XElement(UUID uUID, D80 d80, Serializable serializable, Serializable serializable2) {
        super(d80);
        this.e = uUID;
        this.h = serializable;
        this.s = serializable2;
    }

    public XElement(XElement xElement) {
        super(xElement);
        this.b = xElement;
        this.s = xElement != null ? xElement.h : null;
    }

    public String toString() {
        return "XElement<" + this.h + ">@" + Integer.toHexString(this.hashCode());
    }

    public static Serializable w(XElement xElement) {
        return XElement.v(xElement, null);
    }

    public void p(Hg85 hg85) {
        String string = this.r != null ? "Element (" + this.r + ")" : null;
        XElement xElement = this;
        while (xElement != null) {
            if (xElement.r != null && this.r != null && !xElement.r.equals(this.r)) {
                throw new RuntimeException("Inconsistent skeleton reference between XElement and Archetype " + xElement.h + " (" + this.r + ", " + xElement.r + ")");
            }
            if (xElement.z != null) {
                for (Serializable serializable : xElement.z) {
                    this.x(serializable, Fk353.class, "Mesh", string, hg85);
                    string = "Mesh: " + serializable + " (" + this.r + ")";
                }
            }
            if (xElement.t != null) {
                for (Serializable serializable : xElement.t.values()) {
                    this.x(serializable, Fk353.class, "Mesh", string, hg85);
                    string = "Mesh: " + serializable + " (" + this.r + ")";
                }
            }
            xElement = xElement.b;
        }
    }

    private void x(Serializable serializable, Class class_, String string, String string2, Hg85 hg85) {
        Serializable[] arrserializable = (Serializable[])hg85.g(Skeleton.class, class_, serializable);
        if (arrserializable.length > 1) {
            throw new RuntimeException("Multiple skeleton references not allowed for resources!");
        }
        if (string2 != null) {
            if (this.r != null) {
                String string3;
                String string4;
                if (arrserializable.length != 0 && !(string4 = this.r.toString().toLowerCase()).equals(string3 = arrserializable[0].toString().toLowerCase())) {
                    throw new RuntimeException("Inconsistent skeleton reference between " + string4 + " and " + string + ": " + serializable + " (" + string3 + ")");
                }
            } else if (arrserializable.length != 0) {
                throw new RuntimeException("Inconsistent skeleton reference between " + string2 + " and " + string + ": " + serializable + " (" + arrserializable[0] + ")");
            }
        } else {
            this.r = arrserializable.length == 1 ? arrserializable[0] : null;
        }
    }

    public static void bd() {
        Lb33.g(Lb33.XElementQueue);
        try {
            Bn279 bn279;
            if (G104.g == null) {
                G104.g = Thread.currentThread();
            }
            while ((bn279 = aq.g()) != null) {
                try {
                    GameEntity gameEntity;
                    G104 g104 = (G104)bn279.d();
                    if (g104 == null || (gameEntity = g104.j()) == null || bn279.j == null) continue;
                    ((EventHandler)bn279.j).trigger(gameEntity, null);
                }
                catch (Exception exception) {
                    logger.error("", exception);
                }
            }
            c = Bu350.q(ag, c);
            Lb33.d(Lb33.XElementQueue);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.XElementQueue);
            throw throwable;
        }
    }

    public static void z(XElement xElement, Map map) {
        if (xElement.b != null) {
            XElement.z(xElement.b, map);
        }
        if (xElement.o != null && !xElement.o.isEmpty()) {
            map.putAll(xElement.o);
        }
    }

    public static Map t(XElement[] arrxElement) {
        HashMap hashMap = new HashMap();
        XElement.m(arrxElement, hashMap);
        return hashMap;
    }

    public static void m(XElement[] arrxElement, Map map) {
        for (int i = arrxElement.length - 1; i >= 0; --i) {
            XElement.z(arrxElement[i], map);
        }
    }

    public void n(Integer n, float[] arrf) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        this.o.put(n, arrf);
    }

    public void i(int n, Serializable serializable) {
        if (this.t == null) {
            this.t = new HashMap();
        }
        this.t.put(n, serializable);
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public void setMeshVisibility(@ScriptID Integer n, boolean bl) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        this.m.put(n, bl);
    }

    private static void ab(XElement xElement, EnumMap enumMap) {
        if (xElement.b != null) {
            XElement.ab(xElement.b, enumMap);
        }
        if (xElement.p != null) {
            enumMap.putAll(xElement.p);
        }
    }

    public static XElement by(Gg3 gg3, D80 d80) throws Au64 {
        int n;
        XElement xElement = new XElement(d80);
        while ((n = Gg3.ar(gg3)) != 0) {
            Bw168 bw168 = Bw168.g(n);
            int n2 = bw168.f != -1 ? bw168.f : Gg3.bd(gg3);
            int n3 = gg3.v + n2;
            switch (bw168) {
                case ID: {
                    xElement.e = UUID.fromString(Gg3.bk(gg3));
                    break;
                }
                case NAME: {
                    xElement.h = Integer.valueOf(Gg3.bd(gg3));
                    break;
                }
                case INHERITS: {
                    xElement.s = Integer.valueOf(Gg3.bd(gg3));
                    xElement.b = d80.g(xElement.s);
                    break;
                }
                case SKELETON: {
                    xElement.r = Integer.valueOf(Gg3.bd(gg3));
                    break;
                }
                case SKELETON_MASKS: {
                    int n4;
                    int n5;
                    int n6;
                    Object object;
                    int n7 = Gg3.bd(gg3);
                    int n8 = Gg3.bd(gg3);
                    for (n5 = 0; n5 < n7; ++n5) {
                        n6 = Gg3.bd(gg3);
                        object = new float[n8];
                        for (n4 = 0; n4 < n8; ++n4) {
                            object[n4] = Gg3.bl(gg3);
                        }
                        xElement.n(n6, (float[])object);
                    }
                    break;
                }
                case MESHES: {
                    int n8;
                    int n7 = n2 / 4;
                    for (n8 = 0; n8 < n7; ++n8) {
                        xElement.k(Integer.valueOf(Gg3.bd(gg3)));
                    }
                    break;
                }
                case NAMED_MESHES: {
                    int n5;
                    int n8;
                    int n7 = n2 / 9;
                    for (n8 = 0; n8 < n7; ++n8) {
                        n5 = Gg3.bd(gg3);
                        int n9 = Gg3.bd(gg3);
                        xElement.i(n5, Integer.valueOf(n9));
                        xElement.setMeshVisibility(n5, Gg3.ar(gg3) == 1);
                    }
                    break;
                }
                case ANIMATIONS: {
                    int n8;
                    int n7;
                    while (gg3.v < n3) {
                        n7 = Gg3.bd(gg3);
                        n8 = Gg3.bd(gg3);
                        xElement.ap(n7, Integer.valueOf(n8));
                    }
                    break;
                }
                case PHYSICS_COLLISION_GEOMETRY: {
                    int n7 = Gg3.bd(gg3);
                    if (n7 != -1) {
                        XElement.aq(xElement, Integer.valueOf(n7));
                        break;
                    }
                    logger.warn("Could not load collision geometry, bacause it was wrongly specified in an xml at pack time. Search xmap pack output for \"Unrecognised Collision Geometry\"");
                    break;
                }
                case RENDER_FLAGS: {
                    xElement.u = Gg3.bd(gg3);
                    break;
                }
                case OBB: {
                    float f = Gg3.bl(gg3) * Ai354.q;
                    float f2 = Gg3.bl(gg3) * Ai354.q;
                    float f3 = Gg3.bl(gg3) * Ai354.q;
                    int n6 = (int)(Gg3.bl(gg3) * Ai354.q);
                    Object object = Gg3.bl(gg3) * Ai354.q;
                    int n4 = (int)(Gg3.bl(gg3) * Ai354.q);
                    float f4 = Gg3.bl(gg3) * Ai354.q;
                    float f5 = Gg3.bl(gg3) * Ai354.q;
                    float f6 = Gg3.bl(gg3) * Ai354.q;
                    float f7 = Gg3.bl(gg3) * Ai354.q;
                    float f8 = Gg3.bl(gg3) * Ai354.q;
                    float f9 = Gg3.bl(gg3) * Ai354.q;
                    float f10 = Gg3.bl(gg3) * Ai354.q;
                    float f11 = Gg3.bl(gg3) * Ai354.q;
                    float f12 = Gg3.bl(gg3) * Ai354.q;
                    float f13 = Gg3.bl(gg3) * Ai354.q;
                    xElement.w = new Q10(new Matrix4(f, f2, f3, n6, (float)object, n4, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13));
                    break;
                }
                case STRING_PROPERTIES: 
                case NUMERIC_PROPERTIES: 
                case BOOLEAN_PROPERTIES: 
                case VECTOR3_PROPERTIES: 
                case VECTOR4_PROPERTIES: {
                    int n7 = 0;
                    block33 : while (gg3.v < n3) {
                        String string = xElement.q(Gg3.au(gg3));
                        switch (bw168) {
                            case STRING_PROPERTIES: {
                                xElement.l.put(string, Bu169.g(gg3, n7));
                                continue block33;
                            }
                            case NUMERIC_PROPERTIES: {
                                xElement.l.put(string, Aq107.g(gg3, n7));
                                continue block33;
                            }
                            case BOOLEAN_PROPERTIES: {
                                xElement.l.put(string, V355.g(gg3, n7));
                                continue block33;
                            }
                            case VECTOR3_PROPERTIES: {
                                xElement.l.put(string, S356.g(gg3, n7));
                                continue block33;
                            }
                            case VECTOR4_PROPERTIES: {
                                xElement.l.put(string, Ah203.g(gg3, n7));
                                continue block33;
                            }
                        }
                        throw new RuntimeException();
                    }
                    break;
                }
                case EVENT_HANDLERS: {
                    int n7;
                    while (gg3.v < n3) {
                        n7 = Gg3.bd(gg3);
                        String string = gg3.bh();
                        if (xElement.y == null) {
                            xElement.y = new HashMap();
                        }
                        xElement.y.put(n7, string);
                    }
                    break;
                }
                case EVENT_MAPPINGS: {
                    int n8;
                    while (gg3.v < n3) {
                        MappedEventType mappedEventType = MappedEventType.byId(Gg3.au(gg3));
                        n8 = Gg3.bd(gg3);
                        if (xElement.p == null) {
                            xElement.p = new EnumMap(MappedEventType.class);
                        }
                        xElement.p.put(mappedEventType, n8);
                    }
                    break;
                }
                case PHYSICS_EVENT_MODE: {
                    xElement.x = PhysicsEventMode.byId(Gg3.ar(gg3));
                    break;
                }
                case ANIMATION_GRAPH: {
                    B352 b352 = xElement.a = new B352();
                    b352.g = gg3.bp();
                    if (Gg3.ar(gg3) != 0) {
                        b352.d = Gg3.bd(gg3);
                    }
                    if (Gg3.ar(gg3) != 0) {
                        b352.q = Gg3.bd(gg3);
                    }
                    if (Gg3.ar(gg3) == 0) break;
                    b352.j = Gg3.bd(gg3);
                    break;
                }
                case ANIMATION_SETS: {
                    int n8;
                    int n7 = Gg3.bd(gg3);
                    for (n8 = 0; n8 < n7; ++n8) {
                        xElement.aa(Integer.valueOf(Gg3.bd(gg3)));
                    }
                    break;
                }
                case SUPER_TYPE_PROPERTIES: {
                    Am76.eo(xElement, gg3);
                    break;
                }
                default: {
                    gg3.v += n2;
                }
            }
            if (gg3.v == n3) continue;
            throw new Au64("Chunk length mismatch when deserialising " + (Object)((Object)bw168) + ": expected " + n2 + " bytes, read " + (gg3.v - (n3 - n2)) + " bytes");
        }
        return xElement;
    }

    public static void c(XElement[] arrxElement, Set set) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < arrxElement.length; ++i) {
            arrxElement[i].o(set, hashMap);
        }
    }

    public static void aq(XElement xElement, Serializable serializable) {
        xElement.v = serializable;
    }

    public static void al(XElement xElement, Map map, Hi86 hi86) {
        if (xElement.b != null) {
            XElement.al(xElement.b, map, hi86);
        }
        if (xElement.k != null) {
            for (Serializable serializable : xElement.k) {
                try {
                    Bj61 bj61 = (Bj61)hi86.j(Bj61.class, serializable);
                    Bj61.g(bj61, map);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        if (xElement.n != null && !xElement.n.isEmpty()) {
            map.putAll(xElement.n);
        }
    }

    public static void av(XElement[] arrxElement, Map map, Hi86 hi86) {
        for (int i = arrxElement.length - 1; i >= 0; --i) {
            XElement.al(arrxElement[i], map, hi86);
        }
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public static XElement construct(XElement xElement) {
        return new XElement(xElement);
    }

    public void ap(int n, Serializable serializable) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        this.n.put(n, serializable);
    }

    public static void ao(XElement xElement, Set set) {
        if (xElement.b != null) {
            XElement.ao(xElement.b, set);
        }
        if (xElement.k != null) {
            set.addAll(xElement.k);
        }
    }

    public void aa(Serializable serializable) {
        if (this.k == null) {
            this.k = new HashSet();
        }
        this.k.add(serializable);
    }

    public static B352 an(XElement xElement) {
        return xElement.a == null && xElement.b != null ? XElement.an(xElement.b) : xElement.a;
    }

    public static B352 am(XElement[] arrxElement) {
        for (int i = 0; i < arrxElement.length; ++i) {
            B352 b352 = XElement.an(arrxElement[i]);
            if (b352 == null) continue;
            return b352;
        }
        return null;
    }

    public Map as() {
        HashMap hashMap = new HashMap();
        XElement.ac(this, hashMap);
        return hashMap;
    }

    private static void ac(XElement xElement, Map map) {
        if (xElement.b != null) {
            XElement.ac(xElement.b, map);
        }
        if (xElement.y != null) {
            map.putAll(xElement.y);
        }
    }

    public Map at() {
        EnumMap enumMap = new EnumMap(MappedEventType.class);
        XElement.ab(this, enumMap);
        return enumMap;
    }

    public static PhysicsEventMode aw(XElement xElement) {
        if (xElement.x != null) {
            return xElement.x;
        }
        if (xElement.b != null) {
            return XElement.aw(xElement.b);
        }
        return PhysicsEventMode.OFF;
    }

    public static void ar(XElement xElement, Map map) {
        if (xElement.b != null) {
            XElement.ar(xElement.b, map);
        }
        map.putAll(xElement.l);
    }

    public static String ax(XElement xElement, String string, String string2) {
        Bm108 bm108 = (Bm108)xElement.l.get(string);
        return bm108 != null && bm108.w == Ag97.g ? (String)bm108.r : (xElement.b != null ? XElement.ax(xElement.b, string, string2) : string2);
    }

    public static double au(XElement xElement, String string, double d) {
        Bm108 bm108 = (Bm108)xElement.l.get(string);
        return bm108 != null && bm108.w == Ag97.d ? (Double)bm108.r : (xElement.b != null ? XElement.au(xElement.b, string, d) : d);
    }

    public static boolean aj(XElement xElement, String string, boolean bl) {
        Bm108 bm108 = (Bm108)xElement.l.get(string);
        return bm108 != null && bm108.w == Ag97.q ? (Boolean)bm108.r : (xElement.b != null ? XElement.aj(xElement.b, string, bl) : bl);
    }

    public static Vector3 ak(XElement xElement, String string, Vector3 vector3) {
        Bm108 bm108 = (Bm108)xElement.l.get(string);
        return bm108 != null && bm108.w == Ag97.j ? (Vector3)bm108.r : (xElement.b != null ? XElement.ak(xElement.b, string, vector3) : vector3);
    }

    public static V198 ay(XElement xElement, String string, V198 v198) {
        Bm108 bm108 = (Bm108)xElement.l.get(string);
        return bm108 != null && bm108.w == Ag97.e ? (V198)bm108.r : (xElement.b != null ? XElement.ay(xElement.b, string, v198) : v198);
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public static STaskFuture configureEntityFromElements(XElement[] arrxElement, GameEntity gameEntity, EventHandler eventHandler, @ScriptDefaults(defaultBoolean=true) boolean bl) {
        return XElement.bl(arrxElement, gameEntity, null, eventHandler, bl);
    }

    private static Serializable v(XElement xElement, Serializable serializable) {
        if (serializable != null) {
            if (!serializable.equals(xElement.r)) {
                logger.info("Archetype hierarchy skeleton inconsistency!");
                return serializable;
            }
        } else {
            serializable = xElement.r;
        }
        if (xElement.b != null) {
            serializable = XElement.v(xElement.b, serializable);
        }
        return serializable;
    }

    public static void bm() {
        ag.d();
    }

    public static STaskFuture bq(XElement xElement, GameEntity gameEntity, EventHandler eventHandler) {
        return XElement.configureEntityFromElements(new XElement[]{xElement}, gameEntity, eventHandler, true);
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public static STaskFuture configureEntity(XElement xElement, GameEntity gameEntity, EventHandler eventHandler, @ScriptDefaults(defaultBoolean=true) boolean bl) {
        return XElement.configureEntityFromElements(new XElement[]{xElement}, gameEntity, eventHandler, bl);
    }

    public static STaskFuture bo(XElement xElement, GameEntity gameEntity, Vector3 vector3, EventHandler eventHandler) {
        return XElement.bl(new XElement[]{xElement}, gameEntity, vector3, eventHandler, true);
    }

    public static Serializable ag(XElement xElement) {
        if (xElement.v != null) {
            return xElement.v;
        }
        return xElement.b != null ? XElement.ag(xElement.b) : null;
    }

    public static STaskFuture bl(XElement[] arrxElement, GameEntity gameEntity, Vector3 vector3, EventHandler eventHandler, boolean bl) {
        if (gameEntity == null) {
            throw new NullPointerException();
        }
        if (gameEntity.getScene() == null) {
            throw new IllegalStateException("ConfigureEntity() or ConfigureEntityFromElements() must be called with an entity already added to a scene - this entity has not been added");
        }
        An120 an120 = new An120(gameEntity, arrxElement, vector3, bl);
        return new STaskFuture(ag.g(an120, aq, eventHandler));
    }

    static G104 bw(GameEntity gameEntity, XElement xElement, Hi86 hi86, boolean bl) throws Exception {
        return XElement.bj(gameEntity, new XElement[]{xElement}, null, hi86, bl);
    }

    public static G104 bj(GameEntity gameEntity, XElement[] arrxElement, Vector3 vector3, Hi86 hi86, boolean bl) throws Exception {
        G104 g104 = XElement.bk(arrxElement, vector3, hi86, gameEntity.bz, bl);
        g104.d = gameEntity;
        return g104;
    }

    private static G104 bk(XElement[] arrxElement, Vector3 vector3, Hi86 hi86, ScriptManager scriptManager, boolean bl) throws Exception {
        Object object;
        Object object2;
        Bn279 bn279;
        AnimationGraphComponent animationGraphComponent;
        Object object3;
        Object object4;
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        Serializable serializable = null;
        int n = 0;
        for (XElement object42 : arrxElement) {
            object4 = XElement.w(object42);
            if (object4 == null) continue;
            if (!(n <= 0 || object4 == serializable || object4 != null && serializable != null && object4.equals(serializable))) {
                throw new Exception("Elements contained more than one different skeleton, " + object4 + " vs " + serializable);
            }
            ++n;
            serializable = object4;
        }
        Bn279 bn2792 = bl && serializable != null && hi86 != null ? hi86.e(Skeleton.class, serializable, Integer.MAX_VALUE, null, null) : null;
        if (bl) {
            Set set = XElement.f(arrxElement);
            bn279 = Ai354.s(set, hi86, Integer.MAX_VALUE);
        } else {
            bn279 = null;
        }
        Serializable serializable2 = XElement.ai(arrxElement);
        Object object7 = serializable2 != null ? (Object)hi86.e(Iz11.class, serializable2, Integer.MAX_VALUE, null, null) : (Object)null;
        object4 = null;
        if (bn2792 != null) {
            try {
                object4 = (Skeleton)bn2792.d();
            }
            catch (Exception animationGraphComponent2) {
                logger.error("Error loading skeleton", animationGraphComponent2);
            }
        }
        if (bl && object4 != null) {
            object = XElement.am(arrxElement);
            if (object != null) {
                object2 = XElement.af(arrxElement, hi86);
                if (!object2.isEmpty()) {
                    animationGraphComponent = new AnimationGraphComponent(((B352)object).g, (Skeleton)object4, (Map)object2, XElement.t(arrxElement));
                    animationGraphComponent.d = ((B352)object).j;
                    animationGraphComponent.q = ((B352)object).d;
                    animationGraphComponent.j = ((B352)object).q;
                } else {
                    animationGraphComponent = null;
                }
            } else {
                animationGraphComponent = null;
            }
        } else {
            animationGraphComponent = null;
        }
        object = null;
        for (XElement n2 : arrxElement) {
            object3 = n2.at();
            PhysicsEventMode physicsEventMode = XElement.aw(n2);
            if (object3.size() <= 0 && physicsEventMode == PhysicsEventMode.OFF) continue;
            if (object3.isEmpty()) {
                object3 = null;
            }
            object = new MappedEventComponent((Map)object3, physicsEventMode);
            break;
        }
        object2 = null;
        if (bn279 != null) {
            try {
                object2 = (N105)bn279.d();
            }
            catch (Exception iz11) {
                logger.error("Error loading mesh", iz11);
            }
        }
        Iz11 iz11 = null;
        if (object7 != null) {
            try {
                iz11 = (Iz11)((Bn279)object7).d();
            }
            catch (Exception arrayList) {
                logger.error("Error loading physical geometry", arrayList);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (object2 != null) {
            int l = 0;
            object3 = null;
            for (XElement xElement : arrxElement) {
                N105.e((N105)object2, l, xElement.u);
                ++l;
                if (xElement.e == null || object3 != null) continue;
                object3 = xElement.e;
            }
            if (object3 != null) {
                N105.s((N105)object2, (UUID)object3);
            }
        }
        long l = bl ? GameEntity.ew((Skeleton)object4, (N105)object2) : 0L;
        for (XElement xElement : arrxElement) {
            xElement.bh(arrayList, hi86, scriptManager, bl);
        }
        Iz11 iz112 = iz11;
        Object object5 = object;
        return new Aw103(arrayList, l, (Skeleton)object4, (N105)object2, arrxElement, vector3, (MappedEventComponent)object5, iz112, animationGraphComponent, bl);
    }

    private static void bx(XElement xElement, GameEntity gameEntity, Vector3 vector3) {
        if (xElement.w == null) {
            GameEntity.o(gameEntity, null);
        }
        if (xElement.b != null) {
            XElement.bx(xElement.b, gameEntity, vector3);
        }
        if (xElement.ah != null) {
            GameEntity.w(gameEntity, xElement.ah);
        }
        if (vector3 != null) {
            GameEntity.r(gameEntity, vector3);
        }
        if (xElement.ap != null) {
            gameEntity.setObjectRotation(xElement.ap);
        }
        if (xElement.ao != null) {
            gameEntity.setObjectScale(xElement.ao.floatValue());
        }
        if (j == null || gameEntity.bg == j) {
            // empty if block
        }
        if (xElement.w != null) {
            GameEntity.o(gameEntity, xElement.w);
        }
    }

    @Override
    public void r(Gg3 gg3, Hk84 hk84, Hg85 hg85, Hi86 hi86) {
        int n;
        if (this.h != null && this.h.equals("desoldier_ex01_sniperriflebase")) {
            System.out.println("WHAT!?");
        }
        boolean bl = false;
        boolean bl2 = false;
        if (this.e != null) {
            Gg3.k(gg3, Bw168.ID.a);
            n = gg3.v += 4;
            gg3.af(this.e.toString());
            Gg3.am(gg3, gg3.v - n);
        }
        if (this.h != null) {
            Gg3.k(gg3, Bw168.NAME.a);
            Gg3.a(gg3, Hk84.g(hk84, XElement.class, this.h));
        }
        if (this.s != null) {
            Gg3.k(gg3, Bw168.INHERITS.a);
            Gg3.a(gg3, Hk84.g(hk84, XElement.class, this.s));
        }
        if (this.w != null) {
            Gg3.k(gg3, Bw168.OBB.a);
            Gg3.aq(gg3, this.w.g.f00);
            Gg3.aq(gg3, this.w.g.f01);
            Gg3.aq(gg3, this.w.g.f02);
            Gg3.aq(gg3, this.w.g.f03);
            Gg3.aq(gg3, this.w.g.f10);
            Gg3.aq(gg3, this.w.g.f11);
            Gg3.aq(gg3, this.w.g.f12);
            Gg3.aq(gg3, this.w.g.f13);
            Gg3.aq(gg3, this.w.g.f20);
            Gg3.aq(gg3, this.w.g.f21);
            Gg3.aq(gg3, this.w.g.f22);
            Gg3.aq(gg3, this.w.g.f23);
            Gg3.aq(gg3, this.w.g.f30);
            Gg3.aq(gg3, this.w.g.f31);
            Gg3.aq(gg3, this.w.g.f32);
            Gg3.aq(gg3, this.w.g.f33);
        }
        if (this.z != null && !this.z.isEmpty()) {
            Gg3.k(gg3, Bw168.MESHES.a);
            Gg3.a(gg3, this.z.size() * 4);
            for (Serializable object : this.z) {
                Gg3.a(gg3, Hk84.g(hk84, Fk353.class, object));
            }
        }
        if (this.t != null && !this.t.isEmpty()) {
            Gg3.k(gg3, Bw168.NAMED_MESHES.a);
            Gg3.a(gg3, this.t.size() * 9);
            for (Map.Entry entry : this.t.entrySet()) {
                Serializable serializable = (Serializable)entry.getValue();
                Gg3.a(gg3, (Integer)entry.getKey());
                Gg3.a(gg3, Hk84.g(hk84, Fk353.class, serializable));
                Gg3.k(gg3, Boolean.TRUE.equals(this.m.get(entry.getKey())) ? 1 : 0);
            }
        }
        if (this.n != null && !this.n.isEmpty()) {
            Gg3.k(gg3, Bw168.ANIMATIONS.a);
            n = gg3.v += 4;
            for (Map.Entry entry : this.n.entrySet()) {
                Gg3.a(gg3, (Integer)entry.getKey());
                Gg3.a(gg3, Hk84.g(hk84, Animation.class, entry.getValue()));
            }
            Gg3.am(gg3, gg3.v - n);
            bl2 = true;
        }
        if (this.k != null && !this.k.isEmpty()) {
            Gg3.k(gg3, Bw168.ANIMATION_SETS.a);
            n = gg3.v += 4;
            Gg3.a(gg3, this.k.size());
            for (Serializable serializable : this.k) {
                Gg3.a(gg3, Hk84.g(hk84, Bj61.class, serializable));
            }
            Gg3.am(gg3, gg3.v - n);
            bl2 = true;
        }
        if (this.v != null) {
            n = -1;
            try {
                n = Hk84.g(hk84, Iz11.class, this.v);
                Gg3.k(gg3, Bw168.PHYSICS_COLLISION_GEOMETRY.a);
                Gg3.a(gg3, n);
            }
            catch (Exception exception) {
                logger.error("[red]Warning: Reference to a unrecognised (non-existant) collision geometry {}[/red]", this.v);
                logger.error("[red]       This instance of collision geometry will be ignored.[/red]");
            }
        }
        Gg3.k(gg3, Bw168.RENDER_FLAGS.a);
        Gg3.a(gg3, this.u);
        XElement.br(this, gg3, Bw168.STRING_PROPERTIES.a, Ag97.g);
        XElement.br(this, gg3, Bw168.NUMERIC_PROPERTIES.a, Ag97.d);
        XElement.br(this, gg3, Bw168.BOOLEAN_PROPERTIES.a, Ag97.q);
        XElement.br(this, gg3, Bw168.VECTOR3_PROPERTIES.a, Ag97.j);
        XElement.br(this, gg3, Bw168.VECTOR4_PROPERTIES.a, Ag97.e);
        if (this.y != null && !this.y.isEmpty()) {
            Gg3.k(gg3, Bw168.EVENT_HANDLERS.a);
            n = gg3.v += 4;
            for (Map.Entry entry : this.y.entrySet()) {
                Gg3.a(gg3, (Integer)entry.getKey());
                gg3.ap((String)entry.getValue());
            }
            Gg3.am(gg3, gg3.v - n);
        }
        if (this.p != null && !this.p.isEmpty()) {
            Gg3.k(gg3, Bw168.EVENT_MAPPINGS.a);
            n = gg3.v += 4;
            for (Map.Entry entry : this.p.entrySet()) {
                Gg3.i(gg3, ((MappedEventType)entry.getKey()).getId());
                Gg3.a(gg3, (Integer)entry.getValue());
            }
            Gg3.am(gg3, gg3.v - n);
        }
        if (this.x != null) {
            Gg3.k(gg3, Bw168.PHYSICS_EVENT_MODE.a);
            Gg3.k(gg3, this.x.getId());
        }
        if (this.a != null) {
            Gg3.k(gg3, Bw168.ANIMATION_GRAPH.a);
            n = gg3.v += 4;
            Gg3.ao(gg3, this.a.g);
            if (this.a.d != null) {
                Gg3.k(gg3, 1);
                Gg3.a(gg3, this.a.d);
            } else {
                Gg3.k(gg3, 0);
            }
            if (this.a.q != null) {
                Gg3.k(gg3, 1);
                Gg3.a(gg3, this.a.q);
            } else {
                Gg3.k(gg3, 0);
            }
            if (this.a.j != null) {
                Gg3.k(gg3, 1);
                Gg3.a(gg3, this.a.j);
            } else {
                Gg3.k(gg3, 0);
            }
            Gg3.am(gg3, gg3.v - n);
        }
        this.p(hg85);
        if (this.r != null) {
            n = Hk84.g(hk84, Skeleton.class, this.r);
            Gg3.k(gg3, Bw168.SKELETON.a);
            Gg3.a(gg3, n);
            if (this.i != null) {
                D91 d91;
                try {
                    d91 = (D91)hi86.j(D91.class, n);
                }
                catch (Ik357 ik357) {
                    throw new RuntimeException("Exception occured whilst loading skeleton", ik357);
                }
                for (Map.Entry entry : this.i.entrySet()) {
                    Ay90 ay90 = (Ay90)entry.getValue();
                    this.n((Integer)entry.getKey(), Ay90.g(ay90, d91));
                }
                Gg3.k(gg3, Bw168.SKELETON_MASKS.a);
                int n2 = gg3.v += 4;
                Gg3.a(gg3, this.o.size());
                Gg3.a(gg3, d91.g());
                for (Map.Entry entry : this.o.entrySet()) {
                    float[] arrf = (float[])entry.getValue();
                    Gg3.a(gg3, (Integer)entry.getKey());
                    for (int i = 0; i < arrf.length; ++i) {
                        Gg3.aq(gg3, arrf[i]);
                    }
                }
                Gg3.am(gg3, gg3.v - n2);
            }
            bl = true;
        } else if (this.i != null) {
            throw new RuntimeException("Skeleton mask specified with-out implicit or explicit skeleton");
        }
        Gg3.k(gg3, Bw168.SUPER_TYPE_PROPERTIES.a);
        n = gg3.v += 4;
        super.r(gg3, hk84, hg85, hi86);
        Gg3.am(gg3, gg3.v - n);
        Gg3.k(gg3, 0);
        if (bl2 && !bl) {
            logger.warn("[red]Element has animation but cannot find a skeleton[/red]");
        }
    }

    private static void br(XElement xElement, Gg3 gg3, int n, Ag97 ag97) {
        Map map = xElement.ad(ag97);
        if (!map.isEmpty()) {
            Gg3.k(gg3, n);
            int n2 = gg3.v += 4;
            for (Map.Entry entry : map.entrySet()) {
                String string = (String)entry.getKey();
                Bm108 bm108 = (Bm108)entry.getValue();
                Gg3.i(gg3, xElement.d(string));
                bm108.d(gg3);
            }
            Gg3.am(gg3, gg3.v - n2);
        }
    }

    private Map ad(Ag97 ag97) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.l.entrySet()) {
            Bm108 bm108 = (Bm108)entry.getValue();
            if (bm108.w != ag97) continue;
            hashMap.put(entry.getKey(), bm108);
        }
        return hashMap;
    }

    @Override
    public void onAllRefsReleased() {
    }

    static /* synthetic */ void bv(XElement xElement, GameEntity gameEntity) {
        XElement.bp(xElement, gameEntity);
    }

    static /* synthetic */ void bf(XElement xElement, GameEntity gameEntity, Vector3 vector3) {
        XElement.bx(xElement, gameEntity, vector3);
    }

    static /* synthetic */ Serializable bn(XElement xElement) {
        return xElement.h;
    }

    static /* synthetic */ Logger bg() {
        return logger;
    }

    static {
        logger = LoggerFactory.getLogger(XElement.class);
        q = false;
        j = null;
        f = true;
        ag = new Bu350("Element Worker Thread (Temporary)");
        aq = new Bv351();
    }

    public static Set f(XElement[] arrxElement) {
        HashSet hashSet = new HashSet();
        XElement.c(arrxElement, hashSet);
        return hashSet;
    }

    public void o(Set set, Map map) {
        HashMap hashMap = new HashMap();
        XElement.a(this, set, hashMap, map);
        set.addAll(hashMap.values());
    }

    public static Serializable ai(XElement[] arrxElement) {
        for (XElement xElement : arrxElement) {
            Serializable serializable = XElement.ag(xElement);
            if (serializable == null) continue;
            return serializable;
        }
        return null;
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public static XElementLibrary getLibrary() {
        return ai;
    }

    public static Map af(XElement[] arrxElement, Hi86 hi86) {
        HashMap hashMap = new HashMap();
        XElement.av(arrxElement, hashMap, hi86);
        return hashMap;
    }

    private void bh(ArrayList arrayList, Hi86 hi86, ScriptManager scriptManager, boolean bl) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        XElement.ep(null, arrayList, this, hi86, scriptManager, bl);
        if (this.b != null) {
            this.b.bh(arrayList, hi86, scriptManager, bl);
        }
    }

    public XElement(D80 d80) {
        super(d80);
    }

    public void k(Serializable serializable) {
        if (this.z == null) {
            this.z = new ArrayList();
        }
        this.z.add(serializable);
    }

    private static void a(XElement xElement, Set set, Map map, Map map2) {
        if (xElement.m != null) {
            for (Map.Entry entry : xElement.m.entrySet()) {
                if (map2.containsKey(entry.getKey())) continue;
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        if (xElement.z != null && !xElement.z.isEmpty()) {
            set.addAll(xElement.z);
        }
        if (xElement.t != null && !xElement.t.isEmpty()) {
            for (Map.Entry entry : xElement.t.entrySet()) {
                Integer n = (Integer)entry.getKey();
                if (map.containsKey(n) || !Boolean.TRUE.equals(map2.get(n))) continue;
                map.put(n, entry.getValue());
            }
        }
        if (xElement.b != null) {
            XElement.a(xElement.b, set, map, map2);
        }
    }

    public static float[] u(XElement xElement, Integer n) {
        float[] arrf = xElement.o != null ? (float[])xElement.o.get(n) : null;
        return arrf == null && xElement.b != null ? XElement.u(xElement.b, n) : arrf;
    }

    private static void bp(XElement xElement, GameEntity gameEntity) {
        if (xElement.b != null) {
            XElement.bp(xElement.b, gameEntity);
        }
        if (xElement.l != null) {
            for (Map.Entry entry : xElement.l.entrySet()) {
                Bm108 bm108 = (Bm108)entry.getValue();
                gameEntity.setProperty((String)entry.getKey(), Ki358.g(bm108.r));
            }
        }
    }
}

