/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua;

import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.game.runetek6.gameentity.components.ProcessLogicEventComponent;
import com.jagex.game.runetek6.gameentity.components.TimerComponent;
import com.jagex.game.runetek6.scenegraph.D75;
import com.jagex.game.runetek6.scenegraph.E254;
import com.jagex.game.runetek6.scenegraph.L170;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.xelement.Am76;
import com.jagex.game.runetek6.xelement.Ao74;
import com.jagex.game.runetek6.xelement.Bh77;
import com.jagex.game.runetek6.xelement.J113;
import com.jagex.game.runetek6.xelement.W14;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.jnibindings.runetek6.RenderToTexture;
import com.jagex.js5.js5;
import com.jagex.maths.Quaternion;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.ScriptCamera;
import rs2.client.client;
import rs2.shared.sound.SoundComponent;
import tfu.Ba115;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.Bt286;
import tfu.D285;
import tfu.Ej287;
import tfu.G289;
import tfu.Kc180;
import tfu.L253;

@ScriptEntryClass(value="OffscreenSceneManager")
public class OffscreenSceneManager {
    public static long e;
    public static int h;
    static final Logger logger;
    public static Ba115 r;
    private static int s;
    public D285 b = null;
    private Scene d;
    private long j = 0L;
    public int l = 0;
    private long q = 0L;
    private Bt286 v = null;
    public int w = 0;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setActiveCamera(ScriptCamera scriptCamera) {
        this.d.e = scriptCamera;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getEntities() {
        Collection collection = this.d.r.values();
        GameEntity[] arrgameEntity = new GameEntity[collection.size()];
        int n = 0;
        for (GameEntity gameEntity : collection) {
            arrgameEntity[n++] = gameEntity;
        }
        return arrgameEntity;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final String GetSceneName() {
        return this.d.j;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void release() {
        if (this.d != null) {
            Scene.u(this.d);
            this.d = null;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static OffscreenSceneManager construct(long l) {
        return new OffscreenSceneManager(l);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void add(SceneGraphNode sceneGraphNode) {
        this.d.add(sceneGraphNode);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void remove(SceneGraphNode sceneGraphNode) {
        Scene.w(this.d, sceneGraphNode);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void advance() {
        long l = System.currentTimeMillis();
        float f = (float)(l - this.q) / 1000.0f;
        this.q = l;
        OffscreenSceneManager.q(this, this.d.v);
        Scene.k(this.d);
        for (Component component : this.d.x(AnimationGraphComponent.class)) {
            component.g(f);
        }
        for (Component component : this.d.x(SoundComponent.class)) {
            SoundComponent.g((SoundComponent)component, f);
        }
        for (Component component : this.d.x(TimerComponent.class)) {
            TimerComponent.g((TimerComponent)component, f);
        }
        for (Component component : this.d.x(ProcessLogicEventComponent.class)) {
            ProcessLogicEventComponent.g((ProcessLogicEventComponent)component, f);
        }
        Scene.i(this.d);
        Scene.z(this.d, f);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public ScriptCamera getActiveCamera() {
        return (ScriptCamera)this.d.e;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void addTerrain(W14 w14, Vector3 vector3) {
        throw new RuntimeException("AddTerrain not implemented for offscreen scenes");
    }

    static {
        logger = LoggerFactory.getLogger(Scene.class);
        e = 0L;
        h = 4;
        s = 0;
        r = Ba115.g(Ej287.OFFSCREEN_SCRIPTED, 1000);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean loadMap(String string) throws InterruptedException {
        int n = client.eb.getgroupid(string);
        if (n >= 0) {
            int n2 = -1;
            this.v = r.b(1000);
            this.b = new D285(n2, n, this.v, 0, 0, 0.0f);
            if (this.b != null) {
                while (!this.b.g()) {
                    Thread.sleep(0L);
                }
                int n3 = this.g();
                if (this.d.v != null) {
                    OffscreenSceneManager.q(this, this.d.v);
                }
                return n3 > 0;
            }
        }
        return false;
    }

    private int g() {
        int n = 0;
        Iterator iterator = this.b.b.iterator();
        for (G289 g289 : D285.q(this.b)) {
            Bh77 bh77 = G289.g(g289);
            if (bh77 == null) continue;
            n += this.d(bh77, new Vector3(G289.d(g289), 0.0f, G289.q(g289)), iterator);
        }
        return n;
    }

    private int d(Bh77 bh77, Vector3 vector3, Iterator iterator) {
        SceneGraphNode sceneGraphNode;
        Am76 am76;
        int n;
        int n2 = 0;
        for (n = 0; n < Bh77.da(bh77); ++n) {
            try {
                am76 = Bh77.dx(bh77, n);
                sceneGraphNode = new GameEntity((Bb4)iterator.next(), client.cj);
                this.d.add(sceneGraphNode);
                XElement.bq(am76, sceneGraphNode, null);
                ++n2;
                continue;
            }
            catch (Exception exception) {
                logger.error("", exception);
            }
        }
        for (n = 0; n < Bh77.db(bh77); ++n) {
            am76 = Bh77.dd(bh77, n);
            sceneGraphNode = new L170(am76.ah, ((J113)am76).d, am76.ah);
            L170.r(sceneGraphNode, vector3);
            this.d.add(sceneGraphNode);
            ++n2;
        }
        for (n = 0; n < Bh77.dg(bh77); ++n) {
            am76 = Bh77.er(bh77, n);
            sceneGraphNode = new D75(am76.ah, am76.ap, ((Ao74)am76).d);
            D75.r(sceneGraphNode, vector3);
            this.d.add(sceneGraphNode);
            ++n2;
        }
        return n2;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void addGroundCover(String string, Vector3 vector3, String string2) {
        throw new RuntimeException("AddGroundCover not implemented for offscreen scenes");
    }

    OffscreenSceneManager(long l) {
        E254 e254 = new E254();
        this.d = new Scene(e254);
        this.d.j = "Offscreen Scene";
        this.q = System.currentTimeMillis();
        this.d.y = this.j = l;
        h = Kc180.e();
    }

    public static void q(OffscreenSceneManager offscreenSceneManager, Collection collection) {
        if (collection == null) {
            return;
        }
        int n = collection.size();
        int n2 = 4 + n * (h + 32);
        if (s < n2) {
            if (e != 0L) {
                Kc180.d(e);
            }
            e = Kc180.g(n2);
            s = n2;
        }
        long l = e;
        int n3 = 0;
        long l2 = l;
        l += 4L;
        for (L253 l253 : collection) {
            ScaleRotTrans scaleRotTrans;
            long l3 = l253.g();
            if (l3 == 0L || (scaleRotTrans = l253.getObjectTransform()) == null) continue;
            Kc180.s(l, l3);
            Kc180.v(l += (long)h, scaleRotTrans.scale);
            Kc180.v(l += 4L, scaleRotTrans.rot.x);
            Kc180.v(l += 4L, scaleRotTrans.rot.y);
            Kc180.v(l += 4L, scaleRotTrans.rot.z);
            Kc180.v(l += 4L, scaleRotTrans.rot.w);
            Kc180.v(l += 4L, scaleRotTrans.trans.x);
            Kc180.v(l += 4L, scaleRotTrans.trans.y);
            Kc180.v(l += 4L, scaleRotTrans.trans.z);
            l += 4L;
            ++n3;
        }
        Kc180.r(l2, n3);
        RenderToTexture.processFrame(offscreenSceneManager.j, e, (int)(l - e));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void SetSceneName(String string) {
        this.d.j = string;
    }
}

