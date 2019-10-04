package rs2.client.sound;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.Scaleform;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import fmod.E245;
import fmod.J251;
import fmod.M249;
import fmod.Q244;
import fmod.U240;
import fmod.W242;
import fmod.X243;
import fmod.Z256;
import fmod.fmod;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.D150;
import rs2.client.ScriptCamera;
import rs2.client.client;
import rs2.client.lua.ClientScriptAPI;
import rs2.shared.sound.SoundAdapter;
import rs2.shared.sound.SoundComponent;
import tfu.Be2;
import tfu.Bs1;
import tfu.Cd585;
import tfu.Ce586;
import tfu.Cz584;
import tfu.Dn555;
import tfu.F342;
import tfu.Gc330;
import tfu.Gg3;

@ScriptEntryClass
public class SoundManager {
   private static boolean a = false;
   static int aa = 0;
   static boolean af = false;
   static String ag = "";
   static Q583[] ah = null;
   public static LinkedList ai = new LinkedList();
   static Hashtable al = new Hashtable();
   private static boolean am = false;
   static int an = 0;
   static int ao = 0;
   static long ap = 0L;
   static String aq = "R:\\WIP\\src\\sounds\\fmod\\";
   private static String[] av = null;
   static Hashtable az = new Hashtable();
   public static final int b = 32;
   public static E245 c;
   private static final float d = 1.9F;
   public static final int e = 16384;
   public static U240 f;
   public static final int h = 8192;
   public static boolean i = false;
   public static final int j = 8192;
   public static Cz584 k;
   public static final int l = 32;
   private static final Logger logger = LoggerFactory.getLogger(SoundManager.class);
   public static Cd585 m;
   public static Ce586 n = null;
   private static Random o = new Random();
   public static int p = -1;
   public static final int q = 16384;
   public static final boolean r = true;
   public static final int s = 0;
   public static Dn555 t;
   public static final int u = 2;
   public static Ce586 v = null;
   public static final boolean w = false;
   public static boolean x = false;
   public static Cd585 y;
   public static int z = -1;

   public static void i(String var0, int var1) {
      F342.d(D150.s, var0, GameShell3.canvasWid - 10, GameShell3.canvasHei - 320 - var1 * 13, -256, 0);
   }

   public static boolean g() {
      if (!af) {
         fmod.q(new U587());
         f = fmod.g();
         c = fmod.d();
         if (c == null) {
            logger.info("Unable to init FMOD!");
            return false;
         }

         X243.j(30000L);
         E245.s(c, 1024, 16L, 0);
         ag = X243.d = GameShell3.getCacheLocation().getAbsolutePath() + "\\";
         E245.l(c, ag);
         q();
         Ag588.s("botinfo");
         K589.d("music");
         j();
         E245.u(c, 0, new Q244(0.0F, 0.0F, 0.0F), new Q244(0.0F, 0.0F, 0.0F), new Q244(1.0F, 0.0F, 0.0F), new Q244(0.0F, 1.0F, 0.0F));
         af = true;
         GameEntity.cw = new J590();
      }

      logger.trace("SoundManager version {} initialised", 1.9F);
      if (f != null && f.g != 0L) {
         Scaleform.initSound(f.g);
      }

      return true;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void CreateVehicle(GameEntity var0) {
      H591.g(var0);
   }

   static void q() {
      logger.trace("SoundManager.clearOutdatedFiles()");
      File[] var0 = (new File(ag)).listFiles(new A592());
      if (var0 != null) {
         byte[] var1 = G593.e("filelen.dat", true);
         Gg3 var2 = new Gg3(var1);
         ah = new Q583[var2.r.length / 8];

         int var4;
         int var5;
         for(int var3 = 0; var3 < ah.length; ++var3) {
            var4 = Gg3.bd(var2);
            var5 = Gg3.bd(var2);
            ah[var3] = new Q583(var4, var5);
         }

         File[] var11 = var0;
         var4 = var0.length;

         for(var5 = 0; var5 < var4; ++var5) {
            File var6 = var11[var5];
            if (client.ez.getgroupid(var6.getName()) == -1) {
               var6.delete();
            } else {
               long var7 = var6.length();
               long var9 = (long)d(var6.getName());
               if (var9 != 0L && var9 != var7) {
                  logger.trace("Deleted outdated file {}", var6.getName());
                  var6.delete();
               }
            }
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void StopAllSounds() {
      logger.trace("SoundManager.StopAllSounds()");
      ab();
   }

   public static void b() {
      if (c != null) {
         logger.trace("SoundManager.quit()");
         E245.b(c);
         c = null;
      }

   }

   public static void l() {
      logger.trace("SoundManager.updateFmodCamera() - cam = {}, self = {}", ScriptCamera.getActiveCamera(), Gc330.j());
      if (ScriptCamera.getActiveCamera() != null && Gc330.j() != null) {
         ScaleRotTrans var0 = ScriptCamera.getActiveCamera().getWorldTransform();
         Quaternion var1 = var0.rot;
         Vector3 var2 = new Vector3(2.0F * (var1.x * var1.z + var1.w * var1.y), 2.0F * (var1.y * var1.z - var1.w * var1.x), 1.0F - 2.0F * (var1.x * var1.x + var1.y * var1.y));
         var2 = Vector3.u(var2);
         Vector3 var3 = new Vector3(2.0F * (var1.x * var1.y - var1.w * var1.z), 1.0F - 2.0F * (var1.x * var1.x + var1.z * var1.z), 2.0F * (var1.y * var1.z + var1.w * var1.x));
         Vector3 var4 = var0.trans;
         if (var4 != null) {
            Q244 var5 = new Q244(var2.x, var2.y, var2.z);
            Q244 var6 = new Q244(var3.x, var3.y, var3.z);
            Q244 var7 = new Q244(var4.x, var4.y, var4.z);
            E245.u(c, 0, var7, new Q244(0.0F, 0.0F, 0.0F), var5, var6);
         }
      }

   }

   public static void w() {
   }

   public static void r() {
      v();
   }

   public static void v() {
      if (c != null) {
         ++an;
         logger.trace("SoundManager.serviceAudio()");
         G593.q();
         K589.q();
         X243.d();
         F594.j();
         H591.j();
         l();
         E245.t(c);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void StopMusic() {
      logger.trace("SoundManager.StopMusic()");
   }

   public static void u(int var0, int var1, int var2, int var3, boolean var4, int var5) {
   }

   public static void n() {
   }

   public static void k() {
      if (af) {
         int var0 = U240.g(fmod.s);
         int var1 = fmod.getMemoryUsed();
         byte var2 = 0;
         String var10000 = "Num FMOD channels: " + var0;
         int var3 = var2 + 1;
         i(var10000, var2);
         i("FMOD memory used : " + var1, var3++);
      }

   }

   public static void m(int var0, int var1, int var2) {
   }

   public static void o() {
   }

   static C595[] f(String var0) {
      var0 = var0.replace(" ", "");
      if (var0.length() == 0) {
         return null;
      } else {
         String[] var1 = var0.split(",");
         C595[] var2 = new C595[var1.length];

         for(int var3 = 0; var3 < var2.length; ++var3) {
            String[] var4 = var1[var3].split("=");
            if (var4.length == 2) {
               var2[var3] = new C595();
               var2[var3].g = var4[0];
               var2[var3].d = Integer.parseInt(var4[1]);
            }
         }

         return var2;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int PlaySoundOnEntityAtTransform(String var0, GameEntity var1, String var2, RotTrans var3) {
      Object[] var4 = new Object[]{var0, var1, var2, var3};
      logger.trace("Enter SoundManager.PlaySoundOnEntityAtTransform({}, {}, {}, {})", var4);
      SoundComponent var5 = (SoundComponent)GameEntity.eb(var1, SoundComponent.class);
      if (var5 == null) {
         var5 = new SoundComponent();
         GameEntity.ep(var1, var5);
      }

      SoundAdapter var6;
      if (!var5.hasSound(var0)) {
         var6 = var5.addSoundAtTransform(var0, var2, var3);
      } else {
         var6 = var5.getSound(var0);
         var6.setWorldTransform(var3);
      }

      int var7 = ai(var6);
      return var7;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void StopSound(int var0) {
      logger.trace("SoundManager.StopSound({})", var0);
      ArrayList var1 = X243.ao();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         X243 var3 = (X243)var2.next();
         if (var3.t == var0) {
            X243.f(var3);
            break;
         }
      }

   }

   public static void ao() {
      K589.b();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean IsSoundPlaying(int var0) {
      logger.trace("SoundManager.IsSoundPlaying({})", var0);
      ArrayList var1 = X243.ao();
      Iterator var2 = var1.iterator();

      X243 var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (X243)var2.next();
      } while(var3.t != var0);

      return X243.y(var3);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetSoundParameter(int var0, String var1) {
      logger.trace("SoundManager.SetSoundParameter({}, {})", var0, var1);
      ArrayList var2 = X243.ao();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         X243 var4 = (X243)var3.next();
         if (var4.t == var0) {
            C595[] var5 = f(var1);
            if (var5 != null) {
               C595[] var6 = var5;
               int var7 = var5.length;

               for(int var8 = 0; var8 < var7; ++var8) {
                  C595 var9 = var6[var8];
                  var4.ag(var9.g, (float)var9.d);
               }
            }
            break;
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int Play2dSound(String var0, int var1, String var2) {
      Object[] var3 = new Object[]{var0, var1, var2};
      logger.trace("SoundManager.Play2dSound({}, {}, {})", var3);
      return aq(var0, var1, var2);
   }

   public static int aq(String var0, int var1, String var2) {
      int var3 = -1;
      if (af) {
         X243 var4 = c.x(var0, var1);
         if (var4 != null) {
            var3 = var4.t;
            C595[] var5 = f(var2);
            if (var5 != null) {
               C595[] var6 = var5;
               int var7 = var5.length;

               for(int var8 = 0; var8 < var7; ++var8) {
                  C595 var9 = var6[var8];
                  var4.ag(var9.g, (float)var9.d);
               }
            }
         }
      }

      return var3;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int PlaySoundOnEntity(String var0, GameEntity var1, String var2) {
      Object[] var3 = new Object[]{var0, var1, var2};
      logger.trace("Enter SoundManager.PlaySoundOnEntity({}, {}, {})", var3);
      SoundComponent var4 = (SoundComponent)GameEntity.eb(var1, SoundComponent.class);
      if (var4 == null) {
         var4 = new SoundComponent();
         GameEntity.ep(var1, var4);
      }

      SoundAdapter var5;
      if (!var4.hasSound(var0)) {
         var5 = var4.addSound(var0, var2);
      } else {
         var5 = var4.getSound(var0);
      }

      int var6 = ai(var5);
      return var6;
   }

   private static int ai(SoundAdapter var0) {
      float var1 = var0.getVolume();
      String var2 = var0.getName();
      String var3 = var0.getParams();
      Vector3 var4 = ClientScriptAPI.clientToServerPos(var0.getWorldTransform().trans);
      al(var0);
      int var5 = av(var2, var4, var3);
      SetSoundVolume(var5, var1);
      SoundAdapter.d(var0, var3, var5);
      return var5;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void StopSoundOnEntity(String var0, GameEntity var1) {
      Object[] var2 = new Object[]{var0, var1};
      logger.trace("Enter SoundManager.StopSoundOnEntity({}, {})", var2);
      SoundComponent var3 = (SoundComponent)GameEntity.eb(var1, SoundComponent.class);
      if (var3 == null) {
         throw new RuntimeException("Failed to stop the sound on the GameEntity since there was no SoundComponent. Use 'PlaySoundOnEntity' first which ensure this.");
      } else {
         var3.d(var0);
      }
   }

   private static void al(SoundAdapter var0) {
      T596 var1 = new T596();
      var0.addEventHandler("SoundTransformChangedEvent", var1);
      D597 var2 = new D597();
      var0.addEventHandler("SoundLinearVelocityChangedEvent", var2);
      B598 var3 = new B598();
      var0.addEventHandler("SoundAngularVelocityChangedEvent", var3);
      W599 var4 = new W599();
      var0.addEventHandler("SoundRemovedEvent", var4);
      Al600 var5 = new Al600();
      var0.addEventHandler("SoundStoppedEvent", var5);
      Az601 var6 = new Az601();
      var0.addEventHandler("SoundVolumeChangedEvent", var6);
      Aq602 var7 = new Aq602();
      var0.addEventHandler("SoundParamsChangedEvent", var7);
   }

   private static void af(SoundAdapter var0) {
      SoundAdapter.j(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int Play3dSound(String var0, float var1, float var2, float var3, String var4) {
      Object[] var5 = new Object[]{var0, var1, var2, var3, var4};
      logger.trace("SoundManager.Play3dSound({}, {}, {}, {}, {})", var5);
      return av(var0, new Vector3(var1, var2, var3), var4);
   }

   public static int av(String var0, Vector3 var1, String var2) {
      int var3 = -1;
      if (af) {
         aw("SCRIPT", var0);
         X243 var4 = c.p(var0, var1.x, var1.y, var1.z);
         if (var4 != null) {
            C595[] var5 = f(var2);
            if (var5 != null) {
               C595[] var6 = var5;
               int var7 = var5.length;

               for(int var8 = 0; var8 < var7; ++var8) {
                  C595 var9 = var6[var8];
                  var4.ag(var9.g, (float)var9.d);
               }
            }

            var3 = var4.t;
         }
      }

      return var3;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void StartMusic(String var0, String var1) {
      if (var0.contains("titlemusic")) {
         var0 = "Title";
      }

      if (var0.contains("character")) {
         var0 = "CharacterSelect";
      }

      if (var0.contains("battlemusic")) {
         var0 = "Exploration";
      }

      K589.h(var0, var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetSoundParameterByName(String var0, String var1) {
      logger.trace("SoundManager.SetSoundParameter({}, {})", var0, var1);
      an(var0, var1);
   }

   public static void ap(String var0, String var1) {
   }

   static void j() {
      logger.trace("SoundManager.loadProjects()");
      char[] var0 = G593.h("projects.txt", true);
      String var1 = String.valueOf(var0).replace("\r", "");
      String[] var2 = var1.split("\n");
      boolean var3 = false;
      String[] var4 = var2;
      int var5 = var2.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         String var7 = var4[var6];
         if (var7.length() > 0 && !var7.replace(" ", "").startsWith("//")) {
            byte[] var8 = G593.e(var7 + ".fev", true);
            if (var8 == null) {
               logger.warn("Did not find (or could not download) fmod file %{}.fev in time to init the SoundManager. Does this file exist? If not you should remove it from the projects.txt file as it will cause a 30 second blocking delay to the client load.", var7);
            } else {
               if (var7.contains("Safety")) {
               }

               c.w(var8);
            }
         }
      }

      h();
   }

   public static void a(int var0, int var1) {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetMusicParameter(String var0) {
      logger.trace("SoundManager.SetMusicParameter({})", var0);
      K589.s(var0);
   }

   public static void aa(String var0) {
      K589.s(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void script_SetAmbienceParameter(String var0) {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetSoundVolume(int var0, float var1) {
      logger.trace("SoundManager.SetSoundVolume({}, {})", var0, var1);
      ArrayList var2 = X243.ao();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         X243 var4 = (X243)var3.next();
         if (var4.t == var0) {
            X243.i(var4, var1);
            break;
         }
      }

   }

   public static void an(String var0, String var1) {
      if (af) {
         C595[] var2 = f(var1);
         if (var2 != null) {
            ArrayList var3 = F594.g();
            Iterator var4 = var3.iterator();

            while(true) {
               F594 var5;
               do {
                  if (!var4.hasNext()) {
                     return;
                  }

                  var5 = (F594)var4.next();
               } while(!var5.h.equals(var0));

               C595[] var6 = var2;
               int var7 = var2.length;

               for(int var8 = 0; var8 < var7; ++var8) {
                  C595 var9 = var6[var8];
                  var5.s.ag(var9.g, (float)var9.d);
               }
            }
         }
      }

   }

   static int d(String var0) {
      int var1 = StringTools.l(var0);

      for(int var2 = 0; var2 < ah.length; ++var2) {
         if (ah[var2].g == var1) {
            return ah[var2].d;
         }
      }

      return 0;
   }

   public static void ag(int var0, int var1, String var2) {
      if (af) {
         X243 var3 = c.x(s(var0), var1);
         if (var3 != null) {
            C595[] var4 = f(var2);
            if (var4 != null) {
               C595[] var5 = var4;
               int var6 = var4.length;

               for(int var7 = 0; var7 < var6; ++var7) {
                  C595 var8 = var5[var7];
                  var3.ag(var8.g, (float)var8.d);
               }
            }
         }
      }

   }

   public static void p(int var0, int var1, int var2, int var3, int var4) {
   }

   public static void as() {
      Y603.q();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void PreLoadBank(String var0) {
      logger.trace("SoundManager.PreLoadBank({})", var0);
      ac(var0);
   }

   public static void ac(String var0) {
      int var4;
      if (var0.toLowerCase().endsWith(".fev")) {
         Z256[] var1 = E245.m(c);
         Z256[] var2 = var1;
         int var3 = var1.length;

         for(var4 = 0; var4 < var3; ++var4) {
            Z256 var5 = var2[var4];
            if (var0.toLowerCase().startsWith(var5.j().d.toLowerCase())) {
               String[] var6 = var5.e();
               String[] var7 = var6;
               int var8 = var6.length;

               for(int var9 = 0; var9 < var8; ++var9) {
                  String var10 = var7[var9];
                  G593.d(var10, 100000L);
               }

               return;
            }
         }
      } else if (var0.toLowerCase().endsWith(".fsb")) {
         G593.d(var0, 100000L);
      } else {
         X243 var11 = c.r(var0, 4);
         if (X243.h(var11)) {
            String[] var12 = var11.aq();
            String[] var13 = var12;
            var4 = var12.length;

            for(int var14 = 0; var14 < var4; ++var14) {
               String var15 = var13[var14];
               G593.d(var15, 100000L);
            }
         }
      }

   }

   public static void at(String var0) {
   }

   private static void h() {
      if (c != null) {
         logger.trace("SoundManager.convertBankToCRC()");
         Z256[] var0 = E245.m(c);
         Z256[] var1 = var0;
         int var2 = var0.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            Z256 var4 = var1[var3];
            W242 var5 = var4.j();
            String var6 = var5.d;
            J251[] var7 = Z256.q(var4);
            J251[] var8 = var7;
            int var9 = var7.length;

            for(int var10 = 0; var10 < var9; ++var10) {
               J251 var11 = var8[var10];
               e(var11, al, var6 + "/" + var11.s().d);
            }
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void StopAllLevelSounds() {
      ArrayList var0 = X243.ao();
      Iterator var1 = var0.iterator();

      while(var1.hasNext()) {
         X243 var2 = (X243)var1.next();
         if (var2 != Y603.g()) {
            M249 var3 = var2.l();
            if (!var3.g().g.equalsIgnoreCase("Music")) {
               X243.f(var2);
            }
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void LoadWorldAudio(String var0) {
      F594.h(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void StopWorldAudio() {
      F594.e();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetMixerVolume(String var0, float var1) {
      M249[] var2 = E245.d(c);
      M249[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         M249 var6 = var3[var5];
         if (var6.g().g.equalsIgnoreCase(var0)) {
            M249.d(var6, var1);
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void DestroyVehicle(GameEntity var0) {
      H591.d(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void StopAllEngines() {
      H591.q();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void ShowPlayingSounds(GameEntity var0, boolean var1) {
      am = var1;
   }

   static void aw(String var0, String var1) {
      if (a) {
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void ToggleEventNames() {
      a ^= true;
   }

   // $FF: synthetic method
   static Logger ar() {
      return logger;
   }

   // $FF: synthetic method
   static void ax(SoundAdapter var0) {
      af(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetSoundPosition(int var0, float var1, float var2, float var3) {
      Object[] var4 = new Object[]{var0, var1, var2, var3};
      logger.trace("SoundManager.SetSoundPosition({}, {}, {}, {})", var4);
      ArrayList var5 = X243.ao();
      Iterator var6 = var5.iterator();

      while(var6.hasNext()) {
         X243 var7 = (X243)var6.next();
         if (var7.t == var0) {
            X243.u(var7, new Q244(var1, var2, var3));
            break;
         }
      }

   }

   public static String s(int var0) {
      String var1 = (String)al.get(new Integer(var0));
      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void StopAmbience() {
      logger.trace("SoundManager.StopAmbience()");
      Y603.q();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetMood(String var0) {
      K589.s(var0);
   }

   static void e(J251 var0, Hashtable var1, String var2) {
      logger.trace("SoundManager.addEventsToTable({})", var0);
      J251[] var3 = J251.j(var0);
      J251[] var4 = var3;
      int var5 = var3.length;

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         J251 var7 = var4[var6];
         e(var7, var1, var2 + "/" + var7.s().d);
      }

      X243[] var16 = J251.e(var0);
      X243[] var17 = var16;
      var6 = var16.length;

      for(int var18 = 0; var18 < var6; ++var18) {
         X243 var8 = var17[var18];
         String var9 = var2 + "/" + X243.b(var8).d;
         Integer var10 = StringTools.l(var9);
         var1.put(var10, var9);
         String[] var11 = c.n(var9);
         String[] var12 = var11;
         int var13 = var11.length;

         for(int var14 = 0; var14 < var13; ++var14) {
            String var15 = var12[var14];
            if (var15.startsWith("!")) {
               logger.debug("Preloading audio bank" + var15);
               G593.d(var15, 30000L);
            }
         }
      }

   }

   public static void ab() {
      Z256[] var0 = E245.m(c);
      Z256[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Z256 var4 = var1[var3];
         Z256.s(var4, true);
      }

   }

   public static void c(int var0, Vector3 var1, String var2) {
      if (af) {
         X243 var3 = c.y(s(var0), new Q244(var1.x, var1.y, var1.z));
         C595[] var4 = f(var2);
         if (var4 != null) {
            C595[] var5 = var4;
            int var6 = var4.length;

            for(int var7 = 0; var7 < var6; ++var7) {
               C595 var8 = var5[var7];
               var3.ag(var8.g, (float)var8.d);
            }
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void PlayAmbience(String var0, String var1) {
      logger.trace("SoundManager.PlayAmbience({}, {})", var0, var1);
      Y603.d(var0, var1);
   }

   public static void t(int var0, int var1, int var2) {
   }

   public static void z(int var0, int var1, int var2, int var3, float var4, float var5, float var6, boolean var7, int var8) {
   }

   public static void am(String var0, String var1) {
      Y603.d(var0, var1);
   }

   public static void y() {
   }

   public static void x(int var0, int var1, int var2, int var3, float var4, float var5, float var6, int var7) {
   }
}
