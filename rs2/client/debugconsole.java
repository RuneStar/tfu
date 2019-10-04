package rs2.client;

import com.jagex.core.constants.D123;
import com.jagex.core.stringtools.general.J173;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.jnibindings.runetek6.StateManager;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.js5.W144;
import com.jagex.maths.Vector3;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.login.Login;
import rs2.client.lua.ClientScriptAPI;
import rs2.shared.movement.PhysicsQueryResultList;
import tfu.Ap127;
import tfu.Be2;
import tfu.Bs1;
import tfu.C340;
import tfu.El328;
import tfu.Eu326;
import tfu.F342;
import tfu.Fb341;
import tfu.Gc330;
import tfu.Gj16;
import tfu.Gn5;
import tfu.Gs329;
import tfu.Gz143;
import tfu.Hb335;
import tfu.Hq338;
import tfu.If31;
import tfu.Kj334;
import tfu.Kt125;
import tfu.Lb33;
import tfu.Lf336;
import tfu.Lq191;
import tfu.Lx337;
import tfu.Mk163;

@ScriptEntryClass("DebugConsole")
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public class debugconsole {
   private static int b = 0;
   private static int commandcharpointer = 0;
   private static int commandpointer = 0;
   private static String currententry = "";
   public static String d = "";
   private static int e;
   public static String g = "";
   private static int h;
   private static final int j = 350;
   private static int l = 0;
   private static final Logger logger = LoggerFactory.getLogger(debugconsole.class);
   private static String[] p;
   private static boolean r = false;
   private static String[] s;
   private static final String t = "Failure";
   private static final String u = "\\/.:, _-+[]~@";
   private static long v;
   private static int w = 0;
   private static FileOutputStream x;
   private static int y = -1;
   private static final String z = "Success";

   @Be2
   @Bs1
   public static void externalKeyboardInput(int var0, char var1, int var2) {
      if (var0 == 84) {
         l(false);
      } else if (var0 == 80) {
         l(true);
      } else {
         String var7;
         if (var0 == 83 && (var2 & 4) != 0) {
            var7 = "lua_exec_server telecoordf " + StateManager.getOverrideCameraX() + " " + StateManager.getOverrideCameraY() + " " + StateManager.getOverrideCameraZ();
            El328 var9 = El328.d(Eu326.CLIENT_CHEAT, client.fx.s);
            Gs329.k(var9.q, var7.length() + 3);
            Gs329.k(var9.q, 0);
            Gs329.k(var9.q, 0);
            var9.q.af(var7);
            N272.e(client.fx, var9);
         } else if (var0 == 66 && (var2 & 4) != 0) {
            if (client.jc != null) {
               var7 = "";

               for(int var8 = s.length - 1; var8 >= 0; --var8) {
                  if (s[var8] != null && s[var8].length() > 0) {
                     var7 = var7 + s[var8] + '\n';
                  }
               }

               client.jc.setContents(new StringSelection(var7), (ClipboardOwner)null);
            }
         } else if (var0 == 67 && (var2 & 4) != 0) {
            if (client.jc != null) {
               try {
                  Transferable var3 = client.jc.getContents((Object)null);
                  if (var3 != null) {
                     String var4 = (String)var3.getTransferData(DataFlavor.stringFlavor);
                     if (var4 != null) {
                        String[] var5 = StringTools.y(var4, '\n');
                        j(var5);
                     }
                  }
               } catch (Exception var6) {
               }
            }
         } else if (var0 == 85 && commandcharpointer > 0) {
            currententry = currententry.substring(0, commandcharpointer - 1) + currententry.substring(commandcharpointer);
            --commandcharpointer;
         } else if (var0 == 101 && commandcharpointer < currententry.length()) {
            currententry = currententry.substring(0, commandcharpointer) + currententry.substring(commandcharpointer + 1);
         } else if (var0 == 96 && commandcharpointer > 0) {
            --commandcharpointer;
         } else if (var0 == 97 && commandcharpointer < currententry.length()) {
            ++commandcharpointer;
         } else if (var0 == 102) {
            commandcharpointer = 0;
         } else if (var0 == 103) {
            commandcharpointer = currententry.length();
         } else if (var0 == 104 && commandpointer < s.length) {
            ++commandpointer;
            h();
            commandcharpointer = currententry.length();
         } else if (var0 == 105 && commandpointer > 0) {
            --commandpointer;
            h();
            commandcharpointer = currententry.length();
         } else if (var1 >= ' ' && var1 < 127) {
            currententry = currententry.substring(0, commandcharpointer) + var1 + currententry.substring(commandcharpointer);
            ++commandcharpointer;
         }
      }

   }

   private static void j(String[] var0) {
      if (var0.length > 1) {
         for(int var1 = 0; var1 < var0.length; ++var1) {
            if (var0[var1].startsWith("pause")) {
               int var2 = 5;

               try {
                  var2 = Integer.parseInt(var0[var1].substring(6));
               } catch (Exception var4) {
               }

               addline("Pausing for " + var2 + " seconds...");
               p = var0;
               y = var1 + 1;
               v = Gz143.g() + (long)(var2 * 1000);
               return;
            }

            currententry = var0[var1];
            l(false);
         }
      } else {
         currententry = currententry + var0[0];
         commandcharpointer += var0[0].length();
      }

   }

   @Be2
   @Bs1
   public static boolean isavailable() {
      return client.ac != 0;
   }

   @Be2
   @Bs1
   public static void open() {
      if (isavailable()) {
         if (s == null) {
            g();
         }

         r = true;
         w = 0;
         client.ms = false;
      }

   }

   private static void g() {
      e = D150.h.e + D150.h.h + 2;
      h = D150.e.e + D150.e.h + 2;
      s = new String[500];

      for(int var0 = 0; var0 < s.length; ++var0) {
         s[var0] = "";
      }

      addline(Mk163.g(Mk163.DEBUG_CONSOLE_INFO, client.n));
   }

   @Be2
   @Bs1
   public static void close() {
      r = false;
      client.ms = true;
   }

   public static void d() {
      if (x != null) {
         try {
            x.close();
         } catch (IOException var1) {
            logger.error("", var1);
         }
      }

      x = null;
   }

   private static void q(int var0, int var1) {
      Vector3[] var2 = ClientScriptAPI.getPhysicsRayFromPixelSpace((float)var0, (float)var1);
      PhysicsQueryResultList var3 = client.gz.d.raycast(var2[0], var2[1], Gn5.ENVIRONMENT_QUERY.ordinal(), Gj16.NONE.az, false, true);
      if (var3.d.size() > 0) {
         Vector3 var4 = ((L8)var3.d.get(0)).d;
         Vector3 var5 = Vector3.g(var4.x, 1000.0F, var4.z);
         Vector3 var6 = Vector3.g(var4.x, 0.0F, var4.z);
         int var7 = Gj16.PLAYER.az + Gj16.GATE1_CLOSE.az + Gj16.GATE2_CLOSE.az + Gj16.GATE3_CLOSE.az + Gj16.GATE4_CLOSE.az + Gj16.GATE5_CLOSE.az + Gj16.GATE6_CLOSE.az + Gj16.GATE7_CLOSE.az + Gj16.GATE8_CLOSE.az + Gj16.GATE9_CLOSE.az + Gj16.GATE10_CLOSE.az + Gj16.GATE11_CLOSE.az + Gj16.GATE12_CLOSE.az + Gj16.GATE13_CLOSE.az + Gj16.GATE14_CLOSE.az;
         var3 = client.gz.d.raycast(var5, var6, Gn5.ENVIRONMENT_QUERY.ordinal(), var7, false, true);
         if (var3.d.size() > 0) {
            var4 = ((L8)var3.d.get(0)).d;
            logger.debug("Teleport to : " + var4);
            String var8 = "lua_exec_server telecoordf " + var4.x + " " + (var4.y + 10.0F) + " " + var4.z;
            El328 var9 = El328.d(Eu326.CLIENT_CHEAT, client.fx.s);
            Gs329.k(var9.q, var8.length() + 3);
            Gs329.k(var9.q, 0);
            Gs329.k(var9.q, 0);
            var9.q.af(var8);
            N272.e(client.fx, var9);
         }
      }

   }

   public static void e() {
      Lb33.g(Lb33.DebugConsole);

      try {
         if (w < 102) {
            w += 6;
         }

         if (y != -1 && v < Gz143.g()) {
            for(int var0 = y; var0 < p.length; ++var0) {
               if (p[var0].startsWith("pause")) {
                  int var1 = 5;

                  try {
                     var1 = Integer.parseInt(p[var0].substring(6));
                  } catch (Exception var6) {
                  }

                  addline("Pausing for " + var1 + " seconds...");
                  y = var0 + 1;
                  v = Gz143.g() + (long)(var1 * 1000);
                  Lb33.d(Lb33.DebugConsole);
                  return;
               }

               currententry = p[var0];
               l(false);
            }

            y = -1;
         }

         Lb33.d(Lb33.DebugConsole);
      } finally {
         Lb33.d(Lb33.DebugConsole);
      }
   }

   public static native void initNative();

   private static boolean b(String var0, int var1, boolean var2, String var3) {
      try {
         return Scripting.matchLuaGlobal(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), var0, var1, var2, var3);
      } catch (Exception var5) {
         logger.error("", var5);
         return false;
      }
   }

   @Be2
   @Bs1
   public static void externalMouseClick(int var0, int var1, int var2) {
      if (var2 == 9) {
         logger.debug("Teleport: " + var0 + "," + var1);
         q(var0, var1);
      }

   }

   private static void h() {
      if (commandpointer > 0) {
         int var0 = 0;

         for(int var1 = 0; var1 < s.length; ++var1) {
            if (s[var1].indexOf("--> ") != -1) {
               ++var0;
               if (var0 == commandpointer) {
                  currententry = s[var1].substring(s[var1].indexOf(62) + 2);
                  break;
               }
            }
         }
      } else {
         currententry = "";
      }

   }

   private static void l(boolean var0) {
      if (currententry.length() != 0) {
         if (!var0 || !currententry.startsWith("lua ") && !currententry.startsWith("luas ") && !currententry.startsWith("lua_exec ") && !currententry.startsWith("lua_exec_server ")) {
            addline("--> " + currententry);
            v(currententry, false, var0);
            commandpointer = 0;
            if (!var0) {
               commandcharpointer = 0;
               currententry = "";
            }

         } else {
            int var1 = currententry.indexOf(32);
            if (var1 <= 1 || !b(currententry.substring(var1 + 1), commandcharpointer - var1 - 1, false, currententry.substring(0, var1))) {
               ;
            }
         }
      }
   }

   @Bs1
   @Be2
   public static void addline(String var0) {
      if (s == null) {
         g();
      }

      client.kb.setTime(new Date(Gz143.g()));
      int var1 = client.kb.get(11);
      int var2 = client.kb.get(12);
      int var3 = client.kb.get(13);
      String var4 = Integer.toString(var1 / 10) + var1 % 10 + ":" + var2 / 10 + var2 % 10 + ":" + var3 / 10 + var3 % 10;
      String[] var5 = StringTools.y(var0, '\n');

      for(int var6 = 0; var6 < var5.length; ++var6) {
         for(int var7 = b; var7 > 0; --var7) {
            s[var7] = s[var7 - 1];
         }

         s[0] = var4 + ": " + var5[var6];
         if (x != null) {
            try {
               x.write(J173.j(s[0] + "\n"));
            } catch (IOException var8) {
               logger.error("", var8);
            }
         }

         if (b < s.length - 1) {
            ++b;
            if (l > 0) {
               ++l;
            }
         }
      }

   }

   @Be2
   @Bs1
   public static void externalMouseInput(int var0) {
      if (var0 != 0) {
         l += var0;
         if (l >= b) {
            l = b - 1;
         }

         if (l < 0) {
            l = 0;
         }
      }

   }

   static String r(String var0) {
      String var1 = null;
      int var2 = var0.indexOf("--> ");
      if (var2 >= 0) {
         var1 = var0.substring(0, var2 + 4);
         var0 = var0.substring(var2 + 4);
      }

      if (var0.startsWith("directlogin ")) {
         int var3 = var0.indexOf(" ", "directlogin ".length());
         if (var3 >= 0) {
            int var4 = var0.length();
            var0 = var0.substring(0, var3) + " ";

            for(int var5 = var3 + 1; var5 < var4; ++var5) {
               var0 = var0 + "*";
            }
         }
      }

      return var1 != null ? var1 + var0 : var0;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void ExecuteCommand(String var0, boolean var1, boolean var2) {
      v(var0, var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void PauseFPSTrack(int var0) {
      if (var0 == 0) {
         GameShell3.PauseCountFPS = 0.0D;
      } else {
         GameShell3.PauseCountFPS = 1.0D;
      }

   }

   @Be2
   @Bs1
   public static boolean isopen() {
      return r;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetBotNameNumber(String var0, String var1) {
      g = var0;
      d = var1;
   }

   public static void y(int var0, int var1) {
      if (var0 == 1) {
         throw new Error();
      } else if (var0 == 2) {
         throw new OutOfMemoryError();
      } else {
         try {
            if (var0 == 3) {
               close();
            } else if (var0 == 4) {
               addline("" + GameShell3.fps);
            } else if (var0 == 6) {
               client.bx = true;
            } else if (var0 == 7) {
               client.bx = false;
            } else if (var0 == 8) {
               Hb335.g(client.jb);
            } else if (var0 == 9) {
               client.as();

               for(int var2 = 0; var2 < 10; ++var2) {
                  System.gc();
               }

               Runtime var5 = Runtime.getRuntime();
               int var3 = (int)((var5.totalMemory() - var5.freeMemory()) / 1024L);
               addline("" + var3);
            } else if (var0 == 11) {
               addline(Kt125.d().b() ? "Success" : "Failure");
            } else if (var0 == 13) {
               Lx337.q(Lf336.q);
            } else if (var0 == 14) {
               W144.v(client.dm);
            } else if (var0 == 17) {
               W144.r(client.dm);
            } else if (var0 == 15) {
               GameShell3.canvas.setLocation(50, 50);
            } else if (var0 == 16) {
               GameShell3.canvas.setLocation(GameShell3.leftMargin, GameShell3.topMargin);
            } else if (var0 == 19) {
               client.by();
            } else if (var0 == 20) {
               client.gv = Gz143.g();
               client.gc = true;
               client.by();
            } else if (var0 == 21) {
               Vector3 var6 = Gc330.j().getWorldTransform().trans;
               addline(((int)var6.x >> 2) + " " + ((int)var6.z >> 2));
            } else if (var0 == 26) {
               client.ac();
            } else if (var0 == 27) {
               client.bz = 0;
               client.by();
            } else if (var0 == 28) {
               client.bz = 1;
               client.by();
            } else if (var0 == 29) {
               client.bz = 2;
               client.by();
            } else if (var0 == 42) {
               client.at();
            } else if (var0 == 31) {
               client.dc.g((Vector3)null).d.at(Gn5.aq);
            } else if (var0 == 32) {
               client.dc.g((Vector3)null).d.at(Gn5.ai);
            } else if (var0 == 33) {
               client.dc.g((Vector3)null).d.at(Gn5.al);
            } else if (var0 == 34) {
               client.dc.g((Vector3)null).d.aw();
            } else if (var0 == 35) {
               client.dc.g((Vector3)null).d.ar();
            } else if (var0 == 36) {
               Ap127.d = !Ap127.d;
            } else if (var0 == 37) {
               if (var1 > 0) {
                  Ap127.q = var1;
               }
            } else if (var0 == 38) {
               if (var1 > 0) {
                  Ap127.j = (float)var1;
               }
            } else if (var0 == 40) {
               DiscreteDynamicsWorld.ax(client.dc.g((Vector3)null).d, (float)var1);
            } else if (var0 == 41) {
               client.lc = !client.lc;
            }

         } catch (Exception var4) {
            addline(Mk163.g(Mk163.DEBUG_CONSOLE_ERROR, client.n));
         }
      }
   }

   public static void v(String var0, boolean var1, boolean var2) {
      try {
         if (var0.equalsIgnoreCase("commands") || var0.equalsIgnoreCase("help")) {
            addline("commands - This command");
            addline("cls - Clear console");
            addline("displayfps - Toggle FPS and other information");
            addline("renderer - Print graphics renderer information");
            addline("heap - Print java memory information");
            addline("getcamerapos - Print location and direction of camera for use in bug reports");
            return;
         }

         if (var0.equalsIgnoreCase("cls")) {
            b = 0;
            l = 0;
            return;
         }

         if (var0.equalsIgnoreCase("displayfps")) {
            client.bx = !client.bx;
            if (client.bx) {
               addline("FPS on");
            } else {
               addline("FPS off");
            }

            return;
         }

         if (var0.equals("heap")) {
            addline("Heap: " + GameShell3.maxmemory + "MB");
            return;
         }
      } catch (Exception var9) {
         addline(Mk163.g(Mk163.DEBUG_CONSOLE_ERROR, client.n));
         logger.error("", var9);
         return;
      }

      if (client.t != D123.LIVE || client.ik >= 2) {
         try {
            if (var0.equalsIgnoreCase("wm1")) {
               client.f(J160.SMALL, -1, -1, false);
               if (client.a() == J160.SMALL) {
                  addline("Success");
               } else {
                  addline("Failure");
               }

               return;
            }

            if (var0.equalsIgnoreCase("wm2")) {
               client.f(J160.RESIZABLE, -1, -1, false);
               if (client.a() == J160.RESIZABLE) {
                  addline("Success");
               } else {
                  addline("Failure");
               }

               return;
            }

            if (Hq338.g && var0.equalsIgnoreCase("wm3")) {
               client.f(J160.FULLSCREEN, 1024, 768, false);
               if (client.a() == J160.FULLSCREEN) {
                  addline("Success");
               } else {
                  addline("Failure");
               }

               return;
            }

            if (var0.equalsIgnoreCase("clientdrop")) {
               if (client.ac == 11) {
                  client.at();
               } else if (client.ac == 12) {
                  client.fx.o = true;
               }

               return;
            }

            if (var0.equalsIgnoreCase("breakcon")) {
               if (client.fx.q != null) {
                  client.fx.q.s();
               }

               W144.y(client.dm);
               return;
            }

            String[] var13;
            if (var0.startsWith("directlogin")) {
               var13 = StringTools.p(var0.substring(12), ' ');
               if (var13.length == 2) {
                  Login.requestLoginWithUsername(var13[0], var13[1], (EventHandler)null);
               }

               return;
            }

            if (var0.startsWith("snlogin ")) {
               var13 = StringTools.p(var0.substring(8), ' ');
               int var12 = Integer.parseInt(var13[0]);
               Login.requestLoginFromSocialNetwork(var12, (EventHandler)null);
               return;
            }

            File var3;
            if (var0.startsWith("setoutput ")) {
               var3 = new File(var0.substring(10));
               if (var3.exists()) {
                  var3 = new File(var0.substring(10) + "." + Gz143.g() + ".log");
                  if (var3.exists()) {
                     addline("file already exists!");
                     return;
                  }
               }

               if (x != null) {
                  x.close();
                  x = null;
               }

               try {
                  x = new FileOutputStream(var3);
                  return;
               } catch (FileNotFoundException var6) {
                  addline("Could not create " + var3.getName());
                  return;
               } catch (SecurityException var7) {
                  addline("Cannot write to " + var3.getName());
                  return;
               }
            }

            if (var0.equals("closeoutput")) {
               if (x != null) {
                  x.close();
               }

               x = null;
               return;
            }

            if (var0.startsWith("runscript ")) {
               var3 = new File(var0.substring(10));
               if (!var3.exists()) {
                  addline("No such file");
                  return;
               }

               byte[] var4 = If31.q(var3);
               if (var4 == null) {
                  addline("Failed to read file");
                  return;
               }

               String[] var5 = StringTools.y(StringTools.v(J173.h(var4), '\r', ""), '\n');
               j(var5);
            }

            int var11;
            if (var0.startsWith("lps ")) {
               var11 = StringTools.j(var0.substring(4));
               GameShell3.setspeed(var11);
               addline("Set logic rate to " + var11);
               return;
            }

            if (var0.equalsIgnoreCase("physicsreg")) {
               client.kx = !client.kx;
               addline("Physics regulation " + (client.kx ? "on" : "off"));
               return;
            }

            if (var0.startsWith("lookahead ")) {
               var11 = Integer.parseInt(var0.substring("lookahead ".length()));
               if (var11 > client.dz) {
                  client.du = true;
               }

               client.dz = var11;
               addline("Set client lookahead to " + var11);
               return;
            }

            if (client.ac == 11) {
               El328 var10 = El328.d(Eu326.CLIENT_CHEAT, client.fx.s);
               Gs329.k(var10.q, var0.length() + 3);
               Gs329.k(var10.q, var1 ? 1 : 0);
               Gs329.k(var10.q, var2 ? 1 : 0);
               var10.q.af(var0);
               N272.e(client.fx, var10);
               if (!Ap127.d) {
                  logger.info("->server: {}", var0);
               }
            }

            if (var0.startsWith("cyclerate ")) {
               Lq191.q(StringTools.j(var0.substring(4)));
               return;
            }

            if (var0.equals("ssprofile")) {
               LossyStateStreamProfiler.enabled = !LossyStateStreamProfiler.enabled;
               addline("Client-side ssprofile " + (LossyStateStreamProfiler.enabled ? "on" : "off"));
               return;
            }

            if (var0.equals("udploss")) {
               addline("Client UDP loss: " + client.dw.getUnreceivedCount() + "/" + client.dw.getReceivedCount());
               return;
            }
         } catch (Exception var8) {
            addline(Mk163.g(Mk163.DEBUG_CONSOLE_ERROR, client.n));
            logger.error("", var8);
            return;
         }
      }

      if (client.ac != 11) {
         addline(Mk163.g(Mk163.DEBUG_CONSOLE_UNKNOWNCOMMAND, client.n) + var0);
         logger.debug(var0);
      }

   }

   public static void s(String var0) {
      currententry = var0;
      commandcharpointer = currententry.length();
   }

   public static void w() {
      C340.j(0, 0, GameShell3.canvasWid, 350);
      C340.b(0.0F, 0.0F, (float)GameShell3.canvasWid, 350.0F, w << 24 | 3351159, Fb341.BLEND_NORMAL);
      int var0 = 350 / h;
      int var1;
      if (b > 0) {
         var1 = 346 - h - 4;
         int var2 = var0 * var1 / (var0 + b - 1);
         int var3 = 4;
         if (b > 1) {
            var3 += (b - 1 - l) * (var1 - var2) / (b - 1);
         }

         C340.b((float)(GameShell3.canvasWid - 16), (float)var3, 12.0F, (float)var2, w << 24 | 3351159, Fb341.BLEND_ADDITIVE);

         for(int var4 = l; var4 < l + var0 && var4 < b; ++var4) {
            String[] var5 = StringTools.y(s[var4], '\b');
            int var6 = (GameShell3.canvasWid - 8 - 16) / var5.length;

            for(int var7 = 0; var7 < var5.length; ++var7) {
               int var8 = 8 + var7 * var6;
               C340.j(var8, 0, var8 + var6 - 8, 350);
               int var9 = -4144960;
               String var10 = r(var5[var7]);
               if (var10.length() >= 15) {
                  if (var10.length() >= 17 && var10.substring(10, 17).equals("--> lua")) {
                     var9 = -128;
                  } else if (var10.substring(10, 14).equals("--> ")) {
                     var9 = -64;
                  } else if (var10.length() >= 23 && var10.substring(10, 23).equals("Lua> [string ")) {
                     var9 = -32640;
                  } else if (var10.length() >= 32 && var10.substring(10, 32).equals("....Lua Stacktrace....")) {
                     var9 = -28528;
                  } else if (var10.length() >= 16 && var10.substring(10, 16).equals("   at ")) {
                     var9 = -28528;
                  } else if (var10.substring(10, 15).equals("Lua> ")) {
                     var9 = -8323200;
                  }
               }

               F342.g(D150.b, var10, var8, 350 - e - 2 - D150.e.h - (var4 - l) * h, var9, -16777216);
            }
         }
      }

      F342.d(D150.s, (client.w ? "" : "Build: ") + 1 + " " + 1, GameShell3.canvasWid - 25, 330, -1, -16777216);
      C340.j(0, 0, GameShell3.canvasWid, 350);
      C340.h(0.0F, (float)(350 - e), (float)GameShell3.canvasWid, -1);
      F342.g(D150.l, "--> " + r(currententry), 10, 350 - D150.h.h - 1, -1, -16777216);
      if (GameShell3.focus) {
         var1 = -1;
         if (client.bj % 30 > 15) {
            var1 = 16777215;
         }

         C340.s((float)(10 + Kj334.e(D150.h, "--> " + r(currententry).substring(0, commandcharpointer))), (float)(350 - D150.h.h - 11), 12.0F, var1);
      }

      C340.q();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void ResetPPSHighLow() {
      client.kp = 9.9999999E7D;
      client.kc = 0.0D;
      client.kq = 0.0D;
      client.ld = 0.0D;
      client.ky = 0.0D;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void PausePPSTrack(int var0) {
      if (var0 == 0) {
         client.lo = 0.0D;
      } else {
         client.lo = 1.0D;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void ResetFPSHighLow() {
      GameShell3.fpsL = 9.9999999E7D;
      GameShell3.fpsH = 0.0D;
      GameShell3.fpsAverage = 0.0D;
      GameShell3.fpsTotal = 0.0D;
      GameShell3.fpsCount = 0.0D;
   }
}
