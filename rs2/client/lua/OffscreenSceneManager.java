package rs2.client.lua;

import com.jagex.game.runetek6.event.EventHandler;
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
import com.jagex.game.runetek6.xelement.Ao74;
import com.jagex.game.runetek6.xelement.Bh77;
import com.jagex.game.runetek6.xelement.J113;
import com.jagex.game.runetek6.xelement.W14;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.jnibindings.runetek6.RenderToTexture;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.Collection;
import java.util.Iterator;
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

@ScriptEntryClass("OffscreenSceneManager")
public class OffscreenSceneManager {
   public static long e = 0L;
   public static int h = 4;
   static final Logger logger = LoggerFactory.getLogger(Scene.class);
   public static Ba115 r;
   private static int s = 0;
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
   public void setActiveCamera(ScriptCamera var1) {
      this.d.e = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GameEntity[] getEntities() {
      Collection var1 = this.d.r.values();
      GameEntity[] var2 = new GameEntity[var1.size()];
      int var3 = 0;

      GameEntity var5;
      for(Iterator var4 = var1.iterator(); var4.hasNext(); var2[var3++] = var5) {
         var5 = (GameEntity)var4.next();
      }

      return var2;
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
   public static OffscreenSceneManager construct(long var0) {
      return new OffscreenSceneManager(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void add(SceneGraphNode var1) {
      this.d.add(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void remove(SceneGraphNode var1) {
      Scene.w(this.d, var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void advance() {
      long var1 = System.currentTimeMillis();
      float var3 = (float)(var1 - this.q) / 1000.0F;
      this.q = var1;
      q(this, this.d.v);
      Scene.k(this.d);
      Iterator var4 = this.d.x(AnimationGraphComponent.class).iterator();

      while(var4.hasNext()) {
         AnimationGraphComponent var5 = (AnimationGraphComponent)var4.next();
         var5.g(var3);
      }

      var4 = this.d.x(SoundComponent.class).iterator();

      while(var4.hasNext()) {
         SoundComponent var6 = (SoundComponent)var4.next();
         SoundComponent.g(var6, var3);
      }

      var4 = this.d.x(TimerComponent.class).iterator();

      while(var4.hasNext()) {
         TimerComponent var7 = (TimerComponent)var4.next();
         TimerComponent.g(var7, var3);
      }

      var4 = this.d.x(ProcessLogicEventComponent.class).iterator();

      while(var4.hasNext()) {
         ProcessLogicEventComponent var8 = (ProcessLogicEventComponent)var4.next();
         ProcessLogicEventComponent.g(var8, var3);
      }

      Scene.i(this.d);
      Scene.z(this.d, var3);
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
   public void addTerrain(W14 var1, Vector3 var2) {
      throw new RuntimeException("AddTerrain not implemented for offscreen scenes");
   }

   static {
      r = Ba115.g(Ej287.OFFSCREEN_SCRIPTED, 1000);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean loadMap(String var1) throws InterruptedException {
      int var2 = client.eb.getgroupid(var1);
      if (var2 >= 0) {
         byte var3 = -1;
         this.v = r.b(1000);
         this.b = new D285(var3, var2, this.v, 0, 0, 0.0F);
         if (this.b != null) {
            while(!this.b.g()) {
               Thread.sleep(0L);
            }

            int var4 = this.g();
            if (this.d.v != null) {
               q(this, this.d.v);
            }

            return var4 > 0;
         }
      }

      return false;
   }

   private int g() {
      int var1 = 0;
      Iterator var2 = this.b.b.iterator();
      Iterator var3 = D285.q(this.b).iterator();

      while(var3.hasNext()) {
         G289 var4 = (G289)var3.next();
         Bh77 var5 = G289.g(var4);
         if (var5 != null) {
            var1 += this.d(var5, new Vector3(G289.d(var4), 0.0F, G289.q(var4)), var2);
         }
      }

      return var1;
   }

   private int d(Bh77 var1, Vector3 var2, Iterator var3) {
      int var4 = 0;

      int var5;
      for(var5 = 0; var5 < Bh77.da(var1); ++var5) {
         try {
            XElement var6 = Bh77.dx(var1, var5);
            GameEntity var7 = new GameEntity((Bb4)var3.next(), client.cj);
            this.d.add(var7);
            XElement.bq(var6, var7, (EventHandler)null);
            ++var4;
         } catch (Exception var8) {
            logger.error("", var8);
         }
      }

      for(var5 = 0; var5 < Bh77.db(var1); ++var5) {
         J113 var9 = Bh77.dd(var1, var5);
         L170 var11 = new L170(var9.ah, var9.d, var9.ah);
         L170.r(var11, var2);
         this.d.add(var11);
         ++var4;
      }

      for(var5 = 0; var5 < Bh77.dg(var1); ++var5) {
         Ao74 var10 = Bh77.er(var1, var5);
         D75 var12 = new D75(var10.ah, var10.ap, var10.d);
         D75.r(var12, var2);
         this.d.add(var12);
         ++var4;
      }

      return var4;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void addGroundCover(String var1, Vector3 var2, String var3) {
      throw new RuntimeException("AddGroundCover not implemented for offscreen scenes");
   }

   OffscreenSceneManager(long var1) {
      E254 var3 = new E254();
      this.d = new Scene(var3);
      this.d.j = "Offscreen Scene";
      this.q = System.currentTimeMillis();
      this.j = var1;
      this.d.y = this.j;
      h = Kc180.e();
   }

   public static void q(OffscreenSceneManager var0, Collection var1) {
      if (var1 != null) {
         int var2 = var1.size();
         int var3 = 4 + var2 * (h + 32);
         if (s < var3) {
            if (e != 0L) {
               Kc180.d(e);
            }

            e = Kc180.g((long)var3);
            s = var3;
         }

         long var4 = e;
         int var6 = 0;
         long var7 = var4;
         var4 += 4L;
         Iterator var9 = var1.iterator();

         while(var9.hasNext()) {
            L253 var10 = (L253)var9.next();
            long var11 = var10.g();
            if (var11 != 0L) {
               ScaleRotTrans var13 = var10.getObjectTransform();
               if (var13 != null) {
                  Kc180.s(var4, var11);
                  var4 += (long)h;
                  Kc180.v(var4, var13.scale);
                  var4 += 4L;
                  Kc180.v(var4, var13.rot.x);
                  var4 += 4L;
                  Kc180.v(var4, var13.rot.y);
                  var4 += 4L;
                  Kc180.v(var4, var13.rot.z);
                  var4 += 4L;
                  Kc180.v(var4, var13.rot.w);
                  var4 += 4L;
                  Kc180.v(var4, var13.trans.x);
                  var4 += 4L;
                  Kc180.v(var4, var13.trans.y);
                  var4 += 4L;
                  Kc180.v(var4, var13.trans.z);
                  var4 += 4L;
                  ++var6;
               }
            }
         }

         Kc180.r(var7, var6);
         RenderToTexture.processFrame(var0.j, e, (int)(var4 - e));
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public final void SetSceneName(String var1) {
      this.d.j = var1;
   }
}
