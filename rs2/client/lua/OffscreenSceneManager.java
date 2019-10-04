// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua;

import com.jagex.maths.ScaleRotTrans;
import com.jagex.jnibindings.runetek6.RenderToTexture;
import tfu.L253;
import tfu.Kc180;
import com.jagex.game.runetek6.scenegraph.E254;
import com.jagex.game.runetek6.xelement.Ao74;
import com.jagex.game.runetek6.xelement.J113;
import com.jagex.game.runetek6.scenegraph.D75;
import com.jagex.game.runetek6.scenegraph.L170;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.xelement.XElement;
import tfu.Bb4;
import com.jagex.game.runetek6.xelement.N78;
import com.jagex.game.runetek6.xelement.Bh77;
import tfu.G289;
import rs2.client.client;
import tfu.Bc288;
import tfu.Ej287;
import org.slf4j.LoggerFactory;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.xelement.W14;
import com.jagex.game.runetek6.gameentity.components.ProcessLogicEventComponent;
import com.jagex.game.runetek6.gameentity.components.TimerComponent;
import rs2.shared.sound.SoundComponent;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.Iterator;
import java.util.Collection;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import rs2.client.ScriptCamera;
import tfu.Bt286;
import com.jagex.game.runetek6.scenegraph.Scene;
import tfu.D285;
import tfu.Ba115;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("OffscreenSceneManager")
public class OffscreenSceneManager
{
    public static long e;
    public static int h;
    static final Logger logger;
    public static Ba115 r;
    private static int s;
    public D285 b;
    private Scene d;
    private long j;
    public int l;
    private long q;
    private Bt286 v;
    public int w;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setActiveCamera(final ScriptCamera e) {
        this.d.e = e;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getEntities() {
        final Collection<GameEntity> values = (Collection<GameEntity>)this.d.r.values();
        final GameEntity[] array = new GameEntity[values.size()];
        int n = 0;
        final Iterator<GameEntity> iterator = values.iterator();
        while (iterator.hasNext()) {
            array[n++] = iterator.next();
        }
        return array;
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
    public static OffscreenSceneManager construct(final long n) {
        return new OffscreenSceneManager(n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void add(final SceneGraphNode sceneGraphNode) {
        this.d.add(sceneGraphNode);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void remove(final SceneGraphNode sceneGraphNode) {
        Scene.w(this.d, sceneGraphNode);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void advance() {
        final long currentTimeMillis = System.currentTimeMillis();
        final float n = (currentTimeMillis - this.q) / 1000.0f;
        this.q = currentTimeMillis;
        q(this, this.d.v);
        Scene.k(this.d);
        final Iterator<AnimationGraphComponent> iterator = this.d.x(AnimationGraphComponent.class).iterator();
        while (iterator.hasNext()) {
            iterator.next().g(n);
        }
        final Iterator<SoundComponent> iterator2 = this.d.x(SoundComponent.class).iterator();
        while (iterator2.hasNext()) {
            SoundComponent.g(iterator2.next(), n);
        }
        final Iterator<TimerComponent> iterator3 = this.d.x(TimerComponent.class).iterator();
        while (iterator3.hasNext()) {
            TimerComponent.g(iterator3.next(), n);
        }
        final Iterator<ProcessLogicEventComponent> iterator4 = this.d.x(ProcessLogicEventComponent.class).iterator();
        while (iterator4.hasNext()) {
            ProcessLogicEventComponent.g(iterator4.next(), n);
        }
        Scene.i(this.d);
        Scene.z(this.d, n);
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
    public void addTerrain(final W14 w14, final Vector3 vector3) {
        throw new RuntimeException("AddTerrain not implemented for offscreen scenes");
    }
    
    static {
        logger = LoggerFactory.getLogger(Scene.class);
        OffscreenSceneManager.e = 0L;
        OffscreenSceneManager.h = 4;
        OffscreenSceneManager.s = 0;
        OffscreenSceneManager.r = Ba115.g(Ej287.OFFSCREEN_SCRIPTED, 1000);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean loadMap(final String s) throws InterruptedException {
        final int getgroupid = client.eb.getgroupid(s);
        if (getgroupid >= 0) {
            final int n = -1;
            this.v = OffscreenSceneManager.r.b(1000);
            this.b = new D285(n, getgroupid, this.v, 0, 0, 0.0f);
            if (this.b != null) {
                while (!this.b.g()) {
                    Thread.sleep(0L);
                }
                final int g = this.g();
                if (this.d.v != null) {
                    q(this, this.d.v);
                }
                return g > 0;
            }
        }
        return false;
    }
    
    private int g() {
        int n = 0;
        final Iterator<Object> iterator = this.b.b.iterator();
        for (final G289 g289 : D285.q(this.b)) {
            final Bh77 g290 = G289.g(g289);
            if (g290 != null) {
                n += this.d(g290, new Vector3(G289.d(g289), 0.0f, G289.q(g289)), iterator);
            }
        }
        return n;
    }
    
    private int d(final Bh77 bh77, final Vector3 vector3, final Iterator iterator) {
        int n = 0;
        for (int i = 0; i < N78.da(bh77); ++i) {
            try {
                final XElement dx = N78.dx(bh77, i);
                final GameEntity gameEntity = new GameEntity(iterator.next(), client.cj);
                this.d.add(gameEntity);
                XElement.bq(dx, gameEntity, null);
                ++n;
            }
            catch (Exception ex) {
                OffscreenSceneManager.logger.error("", ex);
            }
        }
        for (int j = 0; j < N78.db(bh77); ++j) {
            final J113 dd = N78.dd(bh77, j);
            final L170 l170 = new L170(dd.ah, dd.d, dd.ah);
            SceneGraphNode.r(l170, vector3);
            this.d.add(l170);
            ++n;
        }
        for (int k = 0; k < N78.dg(bh77); ++k) {
            final Ao74 er = N78.er(bh77, k);
            final D75 d75 = new D75(er.ah, er.ap, er.d);
            SceneGraphNode.r(d75, vector3);
            this.d.add(d75);
            ++n;
        }
        return n;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void addGroundCover(final String s, final Vector3 vector3, final String s2) {
        throw new RuntimeException("AddGroundCover not implemented for offscreen scenes");
    }
    
    OffscreenSceneManager(final long j) {
        this.q = 0L;
        this.j = 0L;
        this.b = null;
        this.l = 0;
        this.w = 0;
        this.v = null;
        this.d = new Scene(new E254());
        this.d.j = "Offscreen Scene";
        this.q = System.currentTimeMillis();
        this.j = j;
        this.d.y = this.j;
        OffscreenSceneManager.h = Kc180.e();
    }
    
    public static void q(final OffscreenSceneManager offscreenSceneManager, final Collection collection) {
        if (collection == null) {
            return;
        }
        final int s = 4 + collection.size() * (OffscreenSceneManager.h + 32);
        if (OffscreenSceneManager.s < s) {
            if (OffscreenSceneManager.e != 0L) {
                Kc180.d(OffscreenSceneManager.e);
            }
            OffscreenSceneManager.e = Kc180.g(s);
            OffscreenSceneManager.s = s;
        }
        final long e = OffscreenSceneManager.e;
        int n = 0;
        final long n2 = e;
        long n3 = e + 4L;
        for (final L253 l253 : collection) {
            final long g = l253.g();
            if (g == 0L) {
                continue;
            }
            final ScaleRotTrans objectTransform = l253.getObjectTransform();
            if (objectTransform == null) {
                continue;
            }
            Kc180.s(n3, g);
            final long n4 = n3 + OffscreenSceneManager.h;
            Kc180.v(n4, objectTransform.scale);
            final long n5 = n4 + 4L;
            Kc180.v(n5, objectTransform.rot.x);
            final long n6 = n5 + 4L;
            Kc180.v(n6, objectTransform.rot.y);
            final long n7 = n6 + 4L;
            Kc180.v(n7, objectTransform.rot.z);
            final long n8 = n7 + 4L;
            Kc180.v(n8, objectTransform.rot.w);
            final long n9 = n8 + 4L;
            Kc180.v(n9, objectTransform.trans.x);
            final long n10 = n9 + 4L;
            Kc180.v(n10, objectTransform.trans.y);
            final long n11 = n10 + 4L;
            Kc180.v(n11, objectTransform.trans.z);
            n3 = n11 + 4L;
            ++n;
        }
        Kc180.r(n2, n);
        RenderToTexture.processFrame(offscreenSceneManager.j, OffscreenSceneManager.e, (int)(n3 - OffscreenSceneManager.e));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public final void SetSceneName(final String j) {
        this.d.j = j;
    }
}
