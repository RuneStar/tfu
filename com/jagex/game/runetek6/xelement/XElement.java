// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Ki358;
import org.slf4j.LoggerFactory;
import tfu.Ik357;
import com.jagex.jnibindings.runetek6.D91;
import com.jagex.jnibindings.runetek6.Animation;
import tfu.Hk84;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.ArrayList;
import tfu.N105;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import tfu.Iz11;
import com.jagex.game.runetek6.script.ScriptManager;
import tfu.Br121;
import com.jagex.game.runetek6.scripthelpers.STaskFuture;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.maths.V198;
import com.jagex.maths.Vector3;
import java.util.HashSet;
import java.util.Collection;
import tfu.Hi86;
import com.jagex.game.runetek6.event.MappedEventType;
import com.jagex.maths.Matrix4;
import tfu.Ai354;
import tfu.Gg3;
import java.util.EnumMap;
import tfu.Be2;
import tfu.Bs1;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Bn279;
import com.jagex.game.runetek6.event.EventHandler;
import tfu.Lb33;
import com.jagex.jnibindings.runetek6.Skeleton;
import java.util.Iterator;
import tfu.Fk353;
import tfu.Hg85;
import java.util.HashMap;
import java.util.List;
import com.jagex.game.runetek6.event.PhysicsEventMode;
import com.jagex.maths.Q10;
import java.util.Set;
import java.util.Map;
import java.io.Serializable;
import java.util.UUID;
import org.slf4j.Logger;
import tfu.Bb4;
import tfu.Bv351;
import tfu.Bu350;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import tfu.Hp62;

@ScriptEntryClass("Element")
public class XElement extends Am76 implements Hp62
{
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
    public Map l;
    private Map m;
    private Map n;
    private Map o;
    public Map p;
    private Serializable r;
    private Serializable s;
    private Map t;
    public int u;
    private Serializable v;
    public Q10 w;
    public PhysicsEventMode x;
    private Map y;
    public List z;
    
    public XElement(final UUID e, final D80 d80, final Serializable h, final Serializable s) {
        super(d80);
        this.l = new HashMap();
        this.r = null;
        this.v = null;
        this.y = null;
        this.p = null;
        this.x = null;
        this.u = 7;
        this.e = e;
        this.h = h;
        this.s = s;
    }
    
    public XElement(final XElement b) {
        super(b);
        this.l = new HashMap();
        this.r = null;
        this.v = null;
        this.y = null;
        this.p = null;
        this.x = null;
        this.u = 7;
        this.b = b;
        this.s = ((b != null) ? b.h : null);
    }
    
    @Override
    public String toString() {
        return "XElement<" + this.h + ">@" + Integer.toHexString(this.hashCode());
    }
    
    public static Serializable w(final XElement xElement) {
        return v(xElement, null);
    }
    
    public void p(final Hg85 hg85) {
        String s = (this.r != null) ? ("Element (" + this.r + ")") : null;
        for (XElement b = this; b != null; b = b.b) {
            if (b.r != null && this.r != null && !b.r.equals(this.r)) {
                throw new RuntimeException("Inconsistent skeleton reference between XElement and Archetype " + b.h + " (" + this.r + ", " + b.r + ")");
            }
            if (b.z != null) {
                for (final Serializable obj : b.z) {
                    this.x(obj, Fk353.class, "Mesh", s, hg85);
                    s = "Mesh: " + obj + " (" + this.r + ")";
                }
            }
            if (b.t != null) {
                for (final Serializable obj2 : b.t.values()) {
                    this.x(obj2, Fk353.class, "Mesh", s, hg85);
                    s = "Mesh: " + obj2 + " (" + this.r + ")";
                }
            }
        }
    }
    
    private void x(final Serializable s, final Class clazz, final String s2, final String str, final Hg85 hg85) {
        final Serializable[] array = (Serializable[])hg85.g(Skeleton.class, clazz, s);
        if (array.length > 1) {
            throw new RuntimeException("Multiple skeleton references not allowed for resources!");
        }
        if (str != null) {
            if (this.r != null) {
                if (array.length != 0) {
                    final String lowerCase = this.r.toString().toLowerCase();
                    final String lowerCase2 = array[0].toString().toLowerCase();
                    if (!lowerCase.equals(lowerCase2)) {
                        throw new RuntimeException("Inconsistent skeleton reference between " + lowerCase + " and " + s2 + ": " + s + " (" + lowerCase2 + ")");
                    }
                }
            }
            else if (array.length != 0) {
                throw new RuntimeException("Inconsistent skeleton reference between " + str + " and " + s2 + ": " + s + " (" + array[0] + ")");
            }
        }
        else {
            this.r = ((array.length == 1) ? array[0] : null);
        }
    }
    
    public static void bd() {
        Lb33.g(Lb33.XElementQueue);
        try {
            if (G104.g == null) {
                G104.g = Thread.currentThread();
            }
            while (true) {
                final Bn279 g = XElement.aq.g();
                if (g == null) {
                    break;
                }
                try {
                    final G104 g2 = (G104)g.d();
                    if (g2 == null) {
                        continue;
                    }
                    final GameEntity j = g2.j();
                    if (j == null) {
                        continue;
                    }
                    if (g.j == null) {
                        continue;
                    }
                    ((EventHandler)g.j).trigger(j, null);
                }
                catch (Exception ex) {
                    XElement.logger.error("", ex);
                }
            }
            XElement.c = Bu350.q(XElement.ag, XElement.c);
        }
        finally {
            Lb33.d(Lb33.XElementQueue);
        }
    }
    
    public static void z(final XElement xElement, final Map map) {
        if (xElement.b != null) {
            z(xElement.b, map);
        }
        if (xElement.o != null && !xElement.o.isEmpty()) {
            map.putAll(xElement.o);
        }
    }
    
    public static Map t(final XElement[] array) {
        final HashMap hashMap = new HashMap();
        m(array, hashMap);
        return hashMap;
    }
    
    public static void m(final XElement[] array, final Map map) {
        for (int i = array.length - 1; i >= 0; --i) {
            z(array[i], map);
        }
    }
    
    public void n(final Integer n, final float[] array) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        this.o.put(n, array);
    }
    
    public void i(final int i, final Serializable s) {
        if (this.t == null) {
            this.t = new HashMap();
        }
        this.t.put(i, s);
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public void setMeshVisibility(@ScriptID final Integer n, final boolean b) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        this.m.put(n, b);
    }
    
    private static void ab(final XElement xElement, final EnumMap enumMap) {
        if (xElement.b != null) {
            ab(xElement.b, enumMap);
        }
        if (xElement.p != null) {
            enumMap.putAll(xElement.p);
        }
    }
    
    public static XElement by(final Gg3 gg3, final D80 d80) throws Au64 {
        final XElement xElement = new XElement(d80);
        int ar;
        while ((ar = Gg3.ar(gg3)) != 0) {
            final Bw168 g = Bw168.g(ar);
            final int i = (g.f != -1) ? g.f : Gg3.bd(gg3);
            final int n = gg3.v + i;
            switch (Bq171.g[g.ordinal()]) {
                case 6: {
                    xElement.e = UUID.fromString(Gg3.bk(gg3));
                    break;
                }
                case 7: {
                    xElement.h = Gg3.bd(gg3);
                    break;
                }
                case 8: {
                    xElement.s = Gg3.bd(gg3);
                    xElement.b = d80.g(xElement.s);
                    break;
                }
                case 9: {
                    xElement.r = Gg3.bd(gg3);
                    break;
                }
                case 10: {
                    final int bd = Gg3.bd(gg3);
                    final int bd2 = Gg3.bd(gg3);
                    for (int j = 0; j < bd; ++j) {
                        final int bd3 = Gg3.bd(gg3);
                        final float[] array = new float[bd2];
                        for (int k = 0; k < bd2; ++k) {
                            array[k] = Gg3.bl(gg3);
                        }
                        xElement.n(bd3, array);
                    }
                    break;
                }
                case 11: {
                    for (int n2 = i / 4, l = 0; l < n2; ++l) {
                        xElement.k(Gg3.bd(gg3));
                    }
                    break;
                }
                case 12: {
                    for (int n3 = i / 9, n4 = 0; n4 < n3; ++n4) {
                        final int bd4 = Gg3.bd(gg3);
                        xElement.i(bd4, Gg3.bd(gg3));
                        xElement.setMeshVisibility(bd4, Gg3.ar(gg3) == 1);
                    }
                    break;
                }
                case 13: {
                    while (gg3.v < n) {
                        xElement.ap(Gg3.bd(gg3), Gg3.bd(gg3));
                    }
                    break;
                }
                case 14: {
                    final int bd5 = Gg3.bd(gg3);
                    if (bd5 != -1) {
                        aq(xElement, bd5);
                        break;
                    }
                    XElement.logger.warn("Could not load collision geometry, bacause it was wrongly specified in an xml at pack time. Search xmap pack output for \"Unrecognised Collision Geometry\"");
                    break;
                }
                case 15: {
                    xElement.u = Gg3.bd(gg3);
                    break;
                }
                case 16: {
                    xElement.w = new Q10(new Matrix4(Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q, Gg3.bl(gg3) * Ai354.q));
                    break;
                }
                case 1:
                case 2:
                case 3:
                case 4:
                case 5: {
                    final int n5 = 0;
                    while (gg3.v < n) {
                        final String q = xElement.q(Gg3.au(gg3));
                        switch (Bq171.g[g.ordinal()]) {
                            case 1: {
                                xElement.l.put(q, Bu169.g(gg3, n5));
                                continue;
                            }
                            case 2: {
                                xElement.l.put(q, Aq107.g(gg3, n5));
                                continue;
                            }
                            case 3: {
                                xElement.l.put(q, V355.g(gg3, n5));
                                continue;
                            }
                            case 4: {
                                xElement.l.put(q, S356.g(gg3, n5));
                                continue;
                            }
                            case 5: {
                                xElement.l.put(q, Ah203.g(gg3, n5));
                                continue;
                            }
                            default: {
                                throw new RuntimeException();
                            }
                        }
                    }
                    break;
                }
                case 17: {
                    while (gg3.v < n) {
                        final int bd6 = Gg3.bd(gg3);
                        final String bh = gg3.bh();
                        if (xElement.y == null) {
                            xElement.y = new HashMap();
                        }
                        xElement.y.put(bd6, bh);
                    }
                    break;
                }
                case 18: {
                    while (gg3.v < n) {
                        final MappedEventType byId = MappedEventType.byId(Gg3.au(gg3));
                        final int bd7 = Gg3.bd(gg3);
                        if (xElement.p == null) {
                            xElement.p = new EnumMap(MappedEventType.class);
                        }
                        xElement.p.put(byId, bd7);
                    }
                    break;
                }
                case 19: {
                    xElement.x = PhysicsEventMode.byId(Gg3.ar(gg3));
                    break;
                }
                case 20: {
                    final XElement xElement2 = xElement;
                    final B352 a = new B352();
                    xElement2.a = a;
                    final B352 b352 = a;
                    b352.g = gg3.bp();
                    if (Gg3.ar(gg3) != 0) {
                        b352.d = Gg3.bd(gg3);
                    }
                    if (Gg3.ar(gg3) != 0) {
                        b352.q = Gg3.bd(gg3);
                    }
                    if (Gg3.ar(gg3) != 0) {
                        b352.j = Gg3.bd(gg3);
                        break;
                    }
                    break;
                }
                case 21: {
                    for (int bd8 = Gg3.bd(gg3), n6 = 0; n6 < bd8; ++n6) {
                        xElement.aa(Gg3.bd(gg3));
                    }
                    break;
                }
                case 22: {
                    Am76.eo(xElement, gg3);
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
        return xElement;
    }
    
    public static void c(final XElement[] array, final Set set) {
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < array.length; ++i) {
            array[i].o(set, hashMap);
        }
    }
    
    public static void aq(final XElement xElement, final Serializable v) {
        xElement.v = v;
    }
    
    public static void al(final XElement xElement, final Map map, final Hi86 hi86) {
        if (xElement.b != null) {
            al(xElement.b, map, hi86);
        }
        if (xElement.k != null) {
            for (final Serializable s : xElement.k) {
                try {
                    Bj61.g((Bj61)hi86.j(Bj61.class, s), map);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (xElement.n != null && !xElement.n.isEmpty()) {
            map.putAll(xElement.n);
        }
    }
    
    public static void av(final XElement[] array, final Map map, final Hi86 hi86) {
        for (int i = array.length - 1; i >= 0; --i) {
            al(array[i], map, hi86);
        }
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public static XElement construct(final XElement xElement) {
        return new XElement(xElement);
    }
    
    public void ap(final int i, final Serializable s) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        this.n.put(i, s);
    }
    
    public static void ao(final XElement xElement, final Set set) {
        if (xElement.b != null) {
            ao(xElement.b, set);
        }
        if (xElement.k != null) {
            set.addAll(xElement.k);
        }
    }
    
    public void aa(final Serializable s) {
        if (this.k == null) {
            this.k = new HashSet();
        }
        this.k.add(s);
    }
    
    public static B352 an(final XElement xElement) {
        return (xElement.a == null && xElement.b != null) ? an(xElement.b) : xElement.a;
    }
    
    public static B352 am(final XElement[] array) {
        for (int i = 0; i < array.length; ++i) {
            final B352 an = an(array[i]);
            if (an != null) {
                return an;
            }
        }
        return null;
    }
    
    public Map as() {
        final HashMap hashMap = new HashMap();
        ac(this, hashMap);
        return hashMap;
    }
    
    private static void ac(final XElement xElement, final Map map) {
        if (xElement.b != null) {
            ac(xElement.b, map);
        }
        if (xElement.y != null) {
            map.putAll(xElement.y);
        }
    }
    
    public Map at() {
        final EnumMap enumMap = new EnumMap((Class<K>)MappedEventType.class);
        ab(this, enumMap);
        return enumMap;
    }
    
    public static PhysicsEventMode aw(final XElement xElement) {
        if (xElement.x != null) {
            return xElement.x;
        }
        if (xElement.b != null) {
            return aw(xElement.b);
        }
        return PhysicsEventMode.OFF;
    }
    
    public static void ar(final XElement xElement, final Map map) {
        if (xElement.b != null) {
            ar(xElement.b, map);
        }
        map.putAll(xElement.l);
    }
    
    public static String ax(final XElement xElement, final String s, final String s2) {
        final Bm108 bm108 = xElement.l.get(s);
        return (String)((bm108 != null && bm108.w == Ag97.g) ? bm108.r : ((xElement.b != null) ? ax(xElement.b, s, s2) : s2));
    }
    
    public static double au(final XElement xElement, final String s, final double n) {
        final Bm108 bm108 = xElement.l.get(s);
        return (double)((bm108 != null && bm108.w == Ag97.d) ? bm108.r : ((xElement.b != null) ? au(xElement.b, s, n) : n));
    }
    
    public static boolean aj(final XElement xElement, final String s, final boolean b) {
        final Bm108 bm108 = xElement.l.get(s);
        return (boolean)((bm108 != null && bm108.w == Ag97.q) ? bm108.r : ((xElement.b != null) ? aj(xElement.b, s, b) : b));
    }
    
    public static Vector3 ak(final XElement xElement, final String s, final Vector3 vector3) {
        final Bm108 bm108 = xElement.l.get(s);
        return (Vector3)((bm108 != null && bm108.w == Ag97.j) ? bm108.r : ((xElement.b != null) ? ak(xElement.b, s, vector3) : vector3));
    }
    
    public static V198 ay(final XElement xElement, final String s, final V198 v198) {
        final Bm108 bm108 = xElement.l.get(s);
        return (V198)((bm108 != null && bm108.w == Ag97.e) ? bm108.r : ((xElement.b != null) ? ay(xElement.b, s, v198) : v198));
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public static STaskFuture configureEntityFromElements(final XElement[] array, final GameEntity gameEntity, final EventHandler eventHandler, @ScriptDefaults(defaultBoolean = true) final boolean b) {
        return bl(array, gameEntity, null, eventHandler, b);
    }
    
    private static Serializable v(final XElement xElement, Serializable s) {
        if (s != null) {
            if (!s.equals(xElement.r)) {
                XElement.logger.info("Archetype hierarchy skeleton inconsistency!");
                return s;
            }
        }
        else {
            s = xElement.r;
        }
        if (xElement.b != null) {
            s = v(xElement.b, s);
        }
        return s;
    }
    
    public static void bm() {
        XElement.ag.d();
    }
    
    public static STaskFuture bq(final XElement xElement, final GameEntity gameEntity, final EventHandler eventHandler) {
        return configureEntityFromElements(new XElement[] { xElement }, gameEntity, eventHandler, true);
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public static STaskFuture configureEntity(final XElement xElement, final GameEntity gameEntity, final EventHandler eventHandler, @ScriptDefaults(defaultBoolean = true) final boolean b) {
        return configureEntityFromElements(new XElement[] { xElement }, gameEntity, eventHandler, b);
    }
    
    public static STaskFuture bo(final XElement xElement, final GameEntity gameEntity, final Vector3 vector3, final EventHandler eventHandler) {
        return bl(new XElement[] { xElement }, gameEntity, vector3, eventHandler, true);
    }
    
    public static Serializable ag(final XElement xElement) {
        if (xElement.v != null) {
            return xElement.v;
        }
        return (xElement.b != null) ? ag(xElement.b) : null;
    }
    
    public static STaskFuture bl(final XElement[] array, final GameEntity gameEntity, final Vector3 vector3, final EventHandler eventHandler, final boolean b) {
        if (gameEntity == null) {
            throw new NullPointerException();
        }
        if (gameEntity.getScene() == null) {
            throw new IllegalStateException("ConfigureEntity() or ConfigureEntityFromElements() must be called with an entity already added to a scene - this entity has not been added");
        }
        return new STaskFuture(XElement.ag.g(new An120(gameEntity, array, vector3, b), XElement.aq, eventHandler));
    }
    
    static G104 bw(final GameEntity gameEntity, final XElement xElement, final Hi86 hi86, final boolean b) throws Exception {
        return bj(gameEntity, new XElement[] { xElement }, null, hi86, b);
    }
    
    public static G104 bj(final GameEntity d, final XElement[] array, final Vector3 vector3, final Hi86 hi86, final boolean b) throws Exception {
        final G104 bk = bk(array, vector3, hi86, d.bz, b);
        bk.d = d;
        return bk;
    }
    
    private static G104 bk(final XElement[] array, final Vector3 vector3, final Hi86 hi86, final ScriptManager scriptManager, final boolean b) throws Exception {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        Serializable s = null;
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            final Serializable w = w(array[i]);
            if (w != null) {
                if (n > 0 && w != s && (w == null || s == null || !w.equals(s))) {
                    throw new Exception("Elements contained more than one different skeleton, " + w + " vs " + s);
                }
                ++n;
                s = w;
            }
        }
        Bn279 e;
        if (b && s != null && hi86 != null) {
            e = hi86.e(Skeleton.class, s, Integer.MAX_VALUE, null, null);
        }
        else {
            e = null;
        }
        Bn279 s2;
        if (b) {
            s2 = Ai354.s(f(array), hi86, Integer.MAX_VALUE);
        }
        else {
            s2 = null;
        }
        final Serializable ai = ai(array);
        Bn279 e2;
        if (ai != null) {
            e2 = hi86.e(Iz11.class, ai, Integer.MAX_VALUE, null, null);
        }
        else {
            e2 = null;
        }
        Skeleton skeleton = null;
        if (e != null) {
            try {
                skeleton = (Skeleton)e.d();
            }
            catch (Exception ex) {
                XElement.logger.error("Error loading skeleton", ex);
            }
        }
        AnimationGraphComponent animationGraphComponent;
        if (b && skeleton != null) {
            final B352 am = am(array);
            if (am != null) {
                final Map af = af(array, hi86);
                if (!af.isEmpty()) {
                    animationGraphComponent = new AnimationGraphComponent(am.g, skeleton, af, t(array));
                    animationGraphComponent.d = am.j;
                    animationGraphComponent.q = am.d;
                    animationGraphComponent.j = am.q;
                }
                else {
                    animationGraphComponent = null;
                }
            }
            else {
                animationGraphComponent = null;
            }
        }
        else {
            animationGraphComponent = null;
        }
        MappedEventComponent mappedEventComponent = null;
        for (final XElement xElement : array) {
            Map at = xElement.at();
            final PhysicsEventMode aw = aw(xElement);
            if (at.size() > 0 || aw != PhysicsEventMode.OFF) {
                if (at.isEmpty()) {
                    at = null;
                }
                mappedEventComponent = new MappedEventComponent(at, aw);
                break;
            }
        }
        N105 n2 = null;
        if (s2 != null) {
            try {
                n2 = (N105)s2.d();
            }
            catch (Exception ex2) {
                XElement.logger.error("Error loading mesh", ex2);
            }
        }
        Iz11 iz11 = null;
        if (e2 != null) {
            try {
                iz11 = (Iz11)e2.d();
            }
            catch (Exception ex3) {
                XElement.logger.error("Error loading physical geometry", ex3);
            }
        }
        final ArrayList list = new ArrayList();
        if (n2 != null) {
            int n3 = 0;
            UUID e3 = null;
            for (final XElement xElement2 : array) {
                N105.e(n2, n3, xElement2.u);
                ++n3;
                if (xElement2.e != null && e3 == null) {
                    e3 = xElement2.e;
                }
            }
            if (e3 != null) {
                N105.s(n2, e3);
            }
        }
        final long n4 = b ? GameEntity.ew(skeleton, n2) : 0L;
        for (int length4 = array.length, l = 0; l < length4; ++l) {
            array[l].bh(list, hi86, scriptManager, b);
        }
        return new Aw103(list, n4, skeleton, n2, array, vector3, mappedEventComponent, iz11, animationGraphComponent, b);
    }
    
    private static void bx(final XElement xElement, final GameEntity gameEntity, final Vector3 vector3) {
        if (xElement.w == null) {
            SceneGraphNode.o(gameEntity, null);
        }
        if (xElement.b != null) {
            bx(xElement.b, gameEntity, vector3);
        }
        if (xElement.ah != null) {
            SceneGraphNode.w(gameEntity, xElement.ah);
        }
        if (vector3 != null) {
            SceneGraphNode.r(gameEntity, vector3);
        }
        if (xElement.ap != null) {
            gameEntity.setObjectRotation(xElement.ap);
        }
        if (xElement.ao != null) {
            gameEntity.setObjectScale(xElement.ao);
        }
        if (XElement.j == null || gameEntity.bg == XElement.j) {}
        if (xElement.w != null) {
            SceneGraphNode.o(gameEntity, xElement.w);
        }
    }
    
    @Override
    public void r(final Gg3 gg3, final Hk84 hk84, final Hg85 hg85, final Hi86 hi86) {
        if (this.h != null && this.h.equals("desoldier_ex01_sniperriflebase")) {
            System.out.println("WHAT!?");
        }
        boolean b = false;
        boolean b2 = false;
        if (this.e != null) {
            Gg3.k(gg3, Bw168.ID.a);
            final int v = gg3.v + 4;
            gg3.v = v;
            final int n = v;
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
            final Iterator<Serializable> iterator = (Iterator<Serializable>)this.z.iterator();
            while (iterator.hasNext()) {
                Gg3.a(gg3, Hk84.g(hk84, Fk353.class, iterator.next()));
            }
        }
        if (this.t != null && !this.t.isEmpty()) {
            Gg3.k(gg3, Bw168.NAMED_MESHES.a);
            Gg3.a(gg3, this.t.size() * 9);
            for (final Map.Entry<K, Serializable> entry : this.t.entrySet()) {
                final Serializable s = entry.getValue();
                Gg3.a(gg3, (int)entry.getKey());
                Gg3.a(gg3, Hk84.g(hk84, Fk353.class, s));
                Gg3.k(gg3, Boolean.TRUE.equals(this.m.get(entry.getKey())) ? 1 : 0);
            }
        }
        if (this.n != null && !this.n.isEmpty()) {
            Gg3.k(gg3, Bw168.ANIMATIONS.a);
            final int v2 = gg3.v + 4;
            gg3.v = v2;
            final int n2 = v2;
            for (final Map.Entry<Integer, V> entry2 : this.n.entrySet()) {
                Gg3.a(gg3, entry2.getKey());
                Gg3.a(gg3, Hk84.g(hk84, Animation.class, entry2.getValue()));
            }
            Gg3.am(gg3, gg3.v - n2);
            b2 = true;
        }
        if (this.k != null && !this.k.isEmpty()) {
            Gg3.k(gg3, Bw168.ANIMATION_SETS.a);
            final int v3 = gg3.v + 4;
            gg3.v = v3;
            final int n3 = v3;
            Gg3.a(gg3, this.k.size());
            final Iterator<Serializable> iterator4 = (Iterator<Serializable>)this.k.iterator();
            while (iterator4.hasNext()) {
                Gg3.a(gg3, Hk84.g(hk84, Bj61.class, iterator4.next()));
            }
            Gg3.am(gg3, gg3.v - n3);
            b2 = true;
        }
        if (this.v != null) {
            try {
                final int g = Hk84.g(hk84, Iz11.class, this.v);
                Gg3.k(gg3, Bw168.PHYSICS_COLLISION_GEOMETRY.a);
                Gg3.a(gg3, g);
            }
            catch (Exception ex) {
                XElement.logger.error("[red]Warning: Reference to a unrecognised (non-existant) collision geometry {}[/red]", this.v);
                XElement.logger.error("[red]       This instance of collision geometry will be ignored.[/red]");
            }
        }
        Gg3.k(gg3, Bw168.RENDER_FLAGS.a);
        Gg3.a(gg3, this.u);
        br(this, gg3, Bw168.STRING_PROPERTIES.a, Ag97.g);
        br(this, gg3, Bw168.NUMERIC_PROPERTIES.a, Ag97.d);
        br(this, gg3, Bw168.BOOLEAN_PROPERTIES.a, Ag97.q);
        br(this, gg3, Bw168.VECTOR3_PROPERTIES.a, Ag97.j);
        br(this, gg3, Bw168.VECTOR4_PROPERTIES.a, Ag97.e);
        if (this.y != null && !this.y.isEmpty()) {
            Gg3.k(gg3, Bw168.EVENT_HANDLERS.a);
            final int v4 = gg3.v + 4;
            gg3.v = v4;
            final int n4 = v4;
            for (final Map.Entry<Integer, V> entry3 : this.y.entrySet()) {
                Gg3.a(gg3, entry3.getKey());
                gg3.ap((String)entry3.getValue());
            }
            Gg3.am(gg3, gg3.v - n4);
        }
        if (this.p != null && !this.p.isEmpty()) {
            Gg3.k(gg3, Bw168.EVENT_MAPPINGS.a);
            final int v5 = gg3.v + 4;
            gg3.v = v5;
            final int n5 = v5;
            for (final Map.Entry<MappedEventType, V> entry4 : this.p.entrySet()) {
                Gg3.i(gg3, entry4.getKey().getId());
                Gg3.a(gg3, (int)entry4.getValue());
            }
            Gg3.am(gg3, gg3.v - n5);
        }
        if (this.x != null) {
            Gg3.k(gg3, Bw168.PHYSICS_EVENT_MODE.a);
            Gg3.k(gg3, this.x.getId());
        }
        if (this.a != null) {
            Gg3.k(gg3, Bw168.ANIMATION_GRAPH.a);
            final int v6 = gg3.v + 4;
            gg3.v = v6;
            final int n6 = v6;
            Gg3.ao(gg3, this.a.g);
            if (this.a.d != null) {
                Gg3.k(gg3, 1);
                Gg3.a(gg3, this.a.d);
            }
            else {
                Gg3.k(gg3, 0);
            }
            if (this.a.q != null) {
                Gg3.k(gg3, 1);
                Gg3.a(gg3, this.a.q);
            }
            else {
                Gg3.k(gg3, 0);
            }
            if (this.a.j != null) {
                Gg3.k(gg3, 1);
                Gg3.a(gg3, this.a.j);
            }
            else {
                Gg3.k(gg3, 0);
            }
            Gg3.am(gg3, gg3.v - n6);
        }
        this.p(hg85);
        if (this.r != null) {
            final int g2 = Hk84.g(hk84, Skeleton.class, this.r);
            Gg3.k(gg3, Bw168.SKELETON.a);
            Gg3.a(gg3, g2);
            if (this.i != null) {
                D91 d91;
                try {
                    d91 = (D91)hi86.j(D91.class, g2);
                }
                catch (Ik357 cause) {
                    throw new RuntimeException("Exception occured whilst loading skeleton", cause);
                }
                for (final Map.Entry<K, Ay90> entry5 : this.i.entrySet()) {
                    this.n((Integer)entry5.getKey(), Ay90.g(entry5.getValue(), d91));
                }
                Gg3.k(gg3, Bw168.SKELETON_MASKS.a);
                final int v7 = gg3.v + 4;
                gg3.v = v7;
                final int n7 = v7;
                Gg3.a(gg3, this.o.size());
                Gg3.a(gg3, d91.g());
                for (final Map.Entry<K, float[]> entry6 : this.o.entrySet()) {
                    final float[] array = entry6.getValue();
                    Gg3.a(gg3, (int)entry6.getKey());
                    for (int i = 0; i < array.length; ++i) {
                        Gg3.aq(gg3, array[i]);
                    }
                }
                Gg3.am(gg3, gg3.v - n7);
            }
            b = true;
        }
        else if (this.i != null) {
            throw new RuntimeException("Skeleton mask specified with-out implicit or explicit skeleton");
        }
        Gg3.k(gg3, Bw168.SUPER_TYPE_PROPERTIES.a);
        final int v8 = gg3.v + 4;
        gg3.v = v8;
        final int n8 = v8;
        super.r(gg3, hk84, hg85, hi86);
        Gg3.am(gg3, gg3.v - n8);
        Gg3.k(gg3, 0);
        if (b2 && !b) {
            XElement.logger.warn("[red]Element has animation but cannot find a skeleton[/red]");
        }
    }
    
    private static void br(final XElement xElement, final Gg3 gg3, final int n, final Ag97 ag97) {
        final Map ad = xElement.ad(ag97);
        if (!ad.isEmpty()) {
            Gg3.k(gg3, n);
            final int v = gg3.v + 4;
            gg3.v = v;
            final int n2 = v;
            for (final Map.Entry<String, V> entry : ad.entrySet()) {
                final String s = entry.getKey();
                final Bm108 bm108 = (Bm108)entry.getValue();
                Gg3.i(gg3, xElement.d(s));
                bm108.d(gg3);
            }
            Gg3.am(gg3, gg3.v - n2);
        }
    }
    
    private Map ad(final Ag97 ag97) {
        final HashMap<Object, Bm108> hashMap = new HashMap<Object, Bm108>();
        for (final Map.Entry<K, Bm108> entry : this.l.entrySet()) {
            final Bm108 bm108 = entry.getValue();
            if (bm108.w == ag97) {
                hashMap.put(entry.getKey(), bm108);
            }
        }
        return hashMap;
    }
    
    @Override
    public void onAllRefsReleased() {
    }
    
    static {
        logger = LoggerFactory.getLogger(XElement.class);
        XElement.q = false;
        XElement.j = null;
        XElement.f = true;
        ag = new Bu350("Element Worker Thread (Temporary)");
        aq = new Bv351();
    }
    
    public static Set f(final XElement[] array) {
        final HashSet set = new HashSet();
        c(array, set);
        return set;
    }
    
    public void o(final Set set, final Map map) {
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        a(this, set, hashMap, map);
        set.addAll(hashMap.values());
    }
    
    public static Serializable ai(final XElement[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final Serializable ag = ag(array[i]);
            if (ag != null) {
                return ag;
            }
        }
        return null;
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public static XElementLibrary getLibrary() {
        return XElement.ai;
    }
    
    public static Map af(final XElement[] array, final Hi86 hi86) {
        final HashMap hashMap = new HashMap();
        av(array, hashMap, hi86);
        return hashMap;
    }
    
    private void bh(final ArrayList list, final Hi86 hi86, final ScriptManager scriptManager, final boolean b) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        Am76.ep(null, list, this, hi86, scriptManager, b);
        if (this.b != null) {
            this.b.bh(list, hi86, scriptManager, b);
        }
    }
    
    public XElement(final D80 d80) {
        super(d80);
        this.l = new HashMap();
        this.r = null;
        this.v = null;
        this.y = null;
        this.p = null;
        this.x = null;
        this.u = 7;
    }
    
    public void k(final Serializable s) {
        if (this.z == null) {
            this.z = new ArrayList();
        }
        this.z.add(s);
    }
    
    private static void a(final XElement xElement, final Set set, final Map map, final Map map2) {
        if (xElement.m != null) {
            for (final Map.Entry<Object, V> entry : xElement.m.entrySet()) {
                if (!map2.containsKey(entry.getKey())) {
                    map2.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (xElement.z != null && !xElement.z.isEmpty()) {
            set.addAll(xElement.z);
        }
        if (xElement.t != null && !xElement.t.isEmpty()) {
            for (final Map.Entry<Integer, V> entry2 : xElement.t.entrySet()) {
                final Integer n = entry2.getKey();
                if (map.containsKey(n)) {
                    continue;
                }
                if (!Boolean.TRUE.equals(map2.get(n))) {
                    continue;
                }
                map.put(n, entry2.getValue());
            }
        }
        if (xElement.b != null) {
            a(xElement.b, set, map, map2);
        }
    }
    
    public static float[] u(final XElement xElement, final Integer n) {
        final float[] array = (float[])((xElement.o != null) ? ((float[])xElement.o.get(n)) : null);
        return (array == null && xElement.b != null) ? u(xElement.b, n) : array;
    }
    
    private static void bp(final XElement xElement, final GameEntity gameEntity) {
        if (xElement.b != null) {
            bp(xElement.b, gameEntity);
        }
        if (xElement.l != null) {
            for (final Map.Entry<K, Bm108> entry : xElement.l.entrySet()) {
                gameEntity.setProperty((String)entry.getKey(), Ki358.g(entry.getValue().r));
            }
        }
    }
}
