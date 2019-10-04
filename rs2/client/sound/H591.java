package rs2.client.sound;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.maths.Vector3;
import fmod.E245;
import fmod.Q244;
import fmod.X243;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rs2.client.ScriptCamera;
import rs2.shared.movement.PlayerPhysicsComponent;
import tfu.Gz143;

public class H591 {
   public static boolean ac = true;
   protected static ArrayList ah = new ArrayList();
   private static long am;
   static int at = 0;
   public static float j = 0.0F;
   private ArrayList a;
   String aa;
   Vector3 ab;
   float ad;
   final float ae;
   private float af;
   private Map ag;
   protected float ai;
   int aj;
   int ak;
   protected float al;
   X243 an;
   String ao;
   int ap;
   String aq;
   int ar;
   protected ScriptCamera as;
   float au;
   public Q244 av;
   int aw;
   float ax;
   float ay;
   private GameEntity az;
   public String b;
   float bd;
   float bl;
   float bm;
   float[] bo;
   float[] bq;
   private ArrayList c;
   public int d;
   public boolean e;
   private ArrayList f;
   public float g = 0.5F;
   String h;
   protected float i;
   protected float k;
   public boolean l;
   protected float m;
   protected float n;
   private ArrayList o;
   public int p;
   public O678 q;
   public float r;
   public String s;
   protected int t;
   private float u;
   public float v;
   public float w;
   public int x;
   public float y;
   protected int z;

   static void r(H591 var0) {
      var0.ai += (var0.al - var0.ai) * j * 2.0F;
      Iterator var1;
      P679 var2;
      if (var0.e && var0.al == 0.0F && var0.ai < 0.05F) {
         var1 = var0.o.iterator();

         while(var1.hasNext()) {
            var2 = (P679)var1.next();
            P679.g(var2);
         }

         if (var0.an != null) {
            X243.c(var0.an);
            var0.an = null;
         }

         var0.e = false;
         var0.q = O678.READY;
         ah.remove(var0);
      }

      if (var0.w < (float)var0.p) {
         var0.w = (float)var0.p;
      }

      if (var0.w > (float)var0.x) {
         var0.w = (float)var0.x;
      }

      var0.u = var0.w;
      if (var0.r == 0.0F) {
         var0.i = 1.0F;
         var0.k = 0.0F;
      }

      if (var0.r > 0.0F) {
         var0.k = var0.r;
         var0.i = 1.0F - var0.r;
      }

      if (var0.r < 0.0F) {
         var0.k = 1.0F - -var0.r;
         var0.i = -var0.r;
      }

      var0.m += (var0.k - var0.m) * 4.0F * j;
      var0.n += (var0.i - var0.n) * 4.0F * j;
      if (var0.q == O678.PLAYING) {
         var0.e = true;
         var0.d = 0;
         var1 = var0.o.iterator();

         while(var1.hasNext()) {
            var2 = (P679)var1.next();
            P679.d(var2, var0.av);
            P679.q(var2, var0.u, var0.m, var0.n);
         }

         if (var0.d == 0) {
            boolean var3 = false;
         }
      }

   }

   public static void g(GameEntity var0) {
      Iterator var1 = ah.iterator();

      H591 var2;
      do {
         if (!var1.hasNext()) {
            H591 var3 = new H591();
            var3.az = var0;
            var3.l = false;
            var3.ap = GameEntity.ev(var0, "BotNumber", 36);
            ah.add(var3);
            return;
         }

         var2 = (H591)var1.next();
      } while(var2.az.bg != var0.bg);

   }

   public static void d(GameEntity var0) {
      Iterator var1 = ah.iterator();

      while(var1.hasNext()) {
         H591 var2 = (H591)var1.next();
         if (var2.az == var0) {
            w(var2);
         }
      }

   }

   public static void j() {
      j = (float)(Gz143.g() - am) / 1000.0F;
      if (j > 0.25F) {
         j = 0.25F;
      }

      am = Gz143.g();
      at = ah.size();

      for(int var0 = ah.size() - 1; var0 >= 0; --var0) {
         H591 var1 = (H591)ah.get(var0);
         var1.e();
      }

   }

   public static void q() {
      Iterator var0 = ah.iterator();

      while(var0.hasNext()) {
         H591 var1 = (H591)var0.next();
         w(var1);
      }

   }

   static float h(H591 var0) {
      if (var0.aj == var0.ak) {
         if (var0.bm < 500.0F) {
            var0.bm += 15.0F * j;
         }
      } else {
         var0.bm = 0.0F;
      }

      if (var0.au > 80.0F) {
         var0.bd += (4200.0F + var0.bm + (var0.au - 80.0F) * 25.0F - (var0.bd + var0.bm)) * j;
      } else {
         var0.bd += (4200.0F + var0.bm - (var0.bd + var0.bm)) * j;
      }

      float var1;
      if (var0.bl > 0.0F) {
         var0.bl -= j;
         var0.ax += (0.0F - var0.ax) * 1.5F * j;
      } else {
         var1 = Math.abs(var0.r);
         if (var0.r < 0.0F) {
            var0.aj = 1;
         }

         if (var0.r != 0.0F) {
            var1 *= j;
            var0.ax += var1 / ((float)var0.aj * 4.0F) * (var0.aw == 0 ? 4.0F : 1.0F);
            if (var0.ax > 1.0F) {
               if (var0.r > 0.0F) {
                  float var2 = var0.ax;
                  var0.ax -= var0.bq[var0.aj - 1];
                  if (var0.aj < var0.ak) {
                     ++var0.aj;
                     var0.bl = var0.bo[var0.aj - 1];
                     var0.ax = var2;
                     v(var0, "GEAR");
                  } else {
                     var0.ax = 1.0F;
                  }
               } else {
                  var0.ax = 1.0F;
               }
            } else if (var0.ax < 0.0F) {
               var0.ax = 1.0F;
               --var0.aj;
               v(var0, "GEAR");
               if (var0.aj == 0) {
                  var0.aj = 1;
               }
            }
         } else {
            var0.aj = 1;
            var0.ax -= j * 0.5F;
            if (var0.au < 10.0F) {
               var0.aj = 1;
            }

            if (var0.ax < 0.0F) {
               if (var0.aj > 1) {
                  --var0.aj;
                  var0.ax += 0.8F;
               } else {
                  var0.ax = 0.0F;
               }
            }
         }
      }

      var1 = 500.0F + s(var0, var0.ax * (var0.au / 80.0F)) * (var0.bd + var0.bm - 500.0F);
      var0.ay = (float)((double)var0.ay + Math.random() * 0.20000000298023224D);
      return var1;
   }

   static float s(H591 var0, float var1) {
      return (float)Math.sin((double)(var1 * 1.571F));
   }

   public H591() {
      this.q = O678.NOTREADY;
      this.e = false;
      this.h = "";
      this.s = "";
      this.b = "";
      this.l = false;
      this.w = 500.0F;
      this.r = 0.0F;
      this.v = 0.0F;
      this.y = 0.0F;
      this.p = 500;
      this.x = 4500;
      this.u = 0.0F;
      this.m = 0.0F;
      this.n = 0.0F;
      this.k = 0.0F;
      this.i = 0.0F;
      this.o = new ArrayList();
      this.a = new ArrayList();
      this.f = new ArrayList();
      this.c = new ArrayList();
      this.ag = new HashMap();
      this.aq = "";
      this.ai = 0.7F;
      this.al = 0.7F;
      this.af = 0.5F;
      this.av = new Q244(0.0F, 0.0F, 0.0F);
      this.az = null;
      this.ap = -1;
      this.ao = "";
      this.aa = "";
      this.an = null;
      this.ab = new Vector3(0.0F, 0.0F, 0.0F);
      this.aw = 0;
      this.ar = 0;
      this.ax = 0.0F;
      this.au = 0.0F;
      this.aj = 1;
      this.ak = 5;
      this.ay = 0.0F;
      this.ad = 50.0F;
      this.ae = 4200.0F;
      this.bd = 4200.0F;
      this.bm = 0.0F;
      this.bq = new float[]{0.2F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F};
      this.bo = new float[]{0.5F, 0.5F, 0.4F, 0.4F, 0.3F, 0.3F, 0.2F, 0.2F, 0.1F};
      this.bl = 0.0F;
   }

   public static void w(H591 var0) {
      v(var0, "stop");
      var0.al = 0.0F;
   }

   public static void v(H591 var0, String var1) {
      if (var0.ag.containsKey(var1)) {
         L681 var2 = (L681)var0.ag.get(var1);
         L681.g(var2, var0.av);
      }

   }

   void y(String var1) {
      if (!var1.equals("")) {
         String[] var2 = var1.split(",");
         this.aq = var2[0].replace("\\", "/");
         int var3 = Integer.parseInt(var2[1]);
         this.z = Integer.parseInt(var2[2]);
         this.t = Integer.parseInt(var2[3]);
         int var4 = 4;
         this.o.clear();

         int var5;
         for(var5 = 0; var5 < var3; ++var5) {
            P679 var6 = new P679(this, this.ap, var2[var4], this, this.p, this.x, this.z, this.t);
            var6.u = var5;
            var4 = var6.j(var2, var4);
            this.o.add(var6);
         }

         var5 = Integer.parseInt(var2[var4++]);

         int var9;
         for(var9 = 0; var9 < var5; ++var9) {
            String var7 = var2[var4++];
            String[] var8 = var7.split("\\|");
            this.ag.put(var8[0], new L681(this, "VEHICLES/A" + this.ap + "/" + var8[1], Float.parseFloat(var8[2]), this));
         }

         this.aa = "VEHICLES/A" + this.ap + "/skidtype_06";
         var5 = Integer.parseInt(var2[var4++]);

         for(var9 = 0; var9 < var5; ++var9) {
            Ai683 var10 = new Ai683(this, this, this.p, this.x);
            var4 = Ai683.g(var10, var2, var4);
            this.a.add(var10);
         }

         this.c.clear();
         if (var2[var4].equals("G")) {
            ++var4;
            var5 = Integer.parseInt(var2[var4++]);

            for(var9 = 0; var9 < var5; ++var9) {
               String[] var11 = var2[var4++].split("\\|");
               this.c.add(new R676(this, Float.parseFloat(var11[0]), Float.parseFloat(var11[1])));
            }
         } else {
            this.c.add(new R676(this, 0.0F, 0.0F));
            this.c.add(new R676(this, 1.0F, 1.0F));
         }
      }

   }

   // $FF: synthetic method
   static ArrayList p(H591 var0) {
      return var0.f;
   }

   public static void l(H591 var0) {
      var0.e = true;
      var0.al = var0.g;
      var0.ai = 0.0F;
      var0.q = O678.PLAYING;
      v(var0, "start");
      var0.ax = 0.5F;
      var0.aj = 3;
   }

   private void e() {
      if (this.az != null) {
         Vector3 var1 = this.az.getWorldTransform().trans;
         Vector3 var2 = var1;
         ScriptCamera var3 = ScriptCamera.getActiveCamera();
         if (var3 != null) {
            var2 = var3.getWorldTransform().trans;
         }

         Iterator var4;
         if (Vector3.f(Vector3.k(var2, var1)) > 90.0F) {
            var4 = this.o.iterator();

            while(var4.hasNext()) {
               P679 var19 = (P679)var4.next();
               P679.g(var19);
            }

            return;
         }

         this.av.g = var1.x;
         this.av.d = var1.y;
         this.av.q = var1.z;
         var4 = this.f.iterator();

         while(var4.hasNext()) {
            X243 var5 = (X243)var4.next();
            if (!X243.y(var5)) {
               this.f.remove(var5);
               break;
            }

            X243.u(var5, this.av);
         }

         PlayerPhysicsComponent var16 = (PlayerPhysicsComponent)GameEntity.eb(this.az, PlayerPhysicsComponent.class);
         if (var16 != null && var16.getAvatar(false) != null && var16.getAvatar(false).b != null) {
            if (!this.e) {
               int var17 = this.ap;
               if (var17 != -1) {
                  this.s = Ag588.h(var17);
                  this.b();
                  this.e = true;
                  l(this);
               }
            }

            BulletVehicle var18 = var16.getAvatar(false).b;
            this.ar = BulletVehicle.g(var18);
            boolean var6 = false;
            this.aw = 0;

            for(int var7 = 0; var7 < this.ar; ++var7) {
               boolean var8 = var18.e(var7);
               var6 |= var8;
               if (var8) {
                  ++this.aw;
               }
            }

            float var20 = Math.min(10.0F, Math.abs(var16.vehicleGetWheelSlipSpeed(this.ar - 1)));
            var20 /= 10.0F;
            if (var20 >= 0.01F) {
               if (this.an == null) {
                  this.an = E245.v(SoundManager.c, this.aa);
                  if (X243.h(this.an)) {
                     X243.i(this.an, var6 ? var20 * this.af : 0.0F);
                     X243.u(this.an, this.av);
                     this.an.a();
                  } else {
                     this.an = null;
                  }
               } else {
                  X243.i(this.an, var6 ? var20 * this.af : 0.0F);
                  X243.u(this.an, this.av);
               }
            } else if (this.an != null) {
               X243.c(this.an);
               this.an = null;
            }

            float var21 = Vector3.f(var18.e.l());
            float var9 = Vector3.f(this.ab);
            Vector3 var10 = var18.e.l();
            float var11 = Math.abs(var10.y - this.ab.y);
            if (var11 > 3.0F) {
               float var12 = Math.min(var11 / 10.0F, 1.0F) * this.g;
               X243 var13 = SoundManager.c.y("VEHICLES/Generic/Vehicle_Landing", this.av);
               if (X243.h(var13)) {
                  X243.i(var13, var12);
                  this.f.add(var13);
               }
            }

            String[] var22 = new String[]{"Light", "Medium", "Heavy"};
            float var23 = var21 - var9;
            if (var23 < -4.0F) {
               byte var14 = 0;
               if (var23 < -4.0F) {
                  var14 = 0;
               }

               if (var23 < -10.0F) {
                  var14 = 1;
               }

               if (var23 < -20.0F) {
                  var14 = 2;
               }

               if (var21 < var9) {
                  X243 var15 = SoundManager.c.y("VEHICLES/Generic/Damage_" + var22[var14], this.av);
                  if (X243.h(var15)) {
                     X243.i(var15, this.g);
                     this.f.add(var15);
                  }
               }
            }

            this.ab = var10;
            float var24 = var16.getAvatar(false).w.e;
            var21 = var21 / 30.0F * 80.0F;
            this.au += (var21 - this.au) * 5.0F * j;
            if (var24 > 0.0F) {
               this.r = 1.0F;
            } else if (var24 < 0.0F) {
               this.r = -1.0F;
            } else {
               this.r = 0.0F;
            }

            this.w = h(this);
         } else if (this.q == O678.PLAYING) {
            w(this);
         }

         r(this);
      }

   }

   public void b() {
      if (this.q == O678.NOTREADY) {
         if (this.l && !this.b.equals("")) {
            this.h = this.b;
         } else {
            this.h = this.s;
         }

         S677 var1 = new S677(this);
         int var2 = this.ap;
         if (var2 != -1 && this.q == O678.NOTREADY) {
            String var3 = this.aq = Ag588.j(var2).replace("\n", "");
            String var4 = var3 + ".fsb";
            G593.g(var4, 100000L, true, var1, this);
            this.q = O678.LOADING;
         }

      }
   }
}
