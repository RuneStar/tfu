package rs2.client.loading;

import com.jagex.core.constants.D123;
import com.jagex.core.constants.Language;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes;
import com.jagex.game.runetek6.comms.broadcast.Flag;
import com.jagex.game.runetek6.comms.broadcast.GeographicEntityWrangler;
import com.jagex.game.runetek6.config.Js5Archive;
import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import com.jagex.game.runetek6.config.defaults.DefaultsGroup;
import com.jagex.game.runetek6.config.defaults.GraphicsDefaults;
import com.jagex.game.runetek6.config.invtype.InvTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.ScriptablePickResult;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.gameentity.components.ProcessLogicEventComponent;
import com.jagex.game.runetek6.gameentity.components.TimerComponent;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.script.ScriptManager$Init;
import com.jagex.game.runetek6.xelement.Q79;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.jnibindings.runetek6.Decals;
import com.jagex.jnibindings.runetek6.GroundCover;
import com.jagex.jnibindings.runetek6.Js5NativeInterface;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import com.jagex.jnibindings.runetek6.NativeResourceLoader;
import com.jagex.jnibindings.runetek6.ParticleEngine;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.jnibindings.runetek6.StateManager;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import com.jagex.js5.G137;
import com.jagex.js5.J135;
import com.jagex.js5.Q138;
import com.jagex.js5.js5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.Al161;
import rs2.client.D150;
import rs2.client.R146;
import rs2.client.ScriptCamera;
import rs2.client.W159;
import rs2.client.client;
import rs2.client.debugconsole;
import rs2.client.friends.ClientFriendListComponent;
import rs2.client.geographicentities.GeographicEntityScriptAPIClient;
import rs2.client.geographicentities.GeographicEntityWranglerClient;
import rs2.client.login.Login;
import rs2.client.lua.ChatScriptAPI;
import rs2.client.lua.ClientScriptAPI;
import rs2.client.lua.ClientScriptMessaging;
import rs2.client.lua.Mouse2ScriptAPI;
import rs2.client.lua.OffscreenSceneManager;
import rs2.client.lua.debugdialog.DebugDialog;
import rs2.client.sound.SoundManager;
import rs2.client.web.ClientURLTools;
import rs2.client.worldelement.Npc;
import rs2.client.worldelement.NpcComponent;
import rs2.client.worldelement.PlayerComponent;
import rs2.client.worldelement.player;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.PhysicsComponent;
import rs2.shared.movement.PhysicsQueryResultList;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerAvatarDescriptor;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.ScheduledMovementComponent;
import rs2.shared.sound.SoundAdapter;
import rs2.shared.sound.SoundComponent;
import tfu.Af155;
import tfu.Al154;
import tfu.Ap127;
import tfu.Aw157;
import tfu.Be2;
import tfu.Bk151;
import tfu.Bs1;
import tfu.Df147;
import tfu.Dh131;
import tfu.Fg140;
import tfu.Fr156;
import tfu.Fw152;
import tfu.Gg3;
import tfu.Gh19;
import tfu.Gj16;
import tfu.Gn5;
import tfu.Gz143;
import tfu.H149;
import tfu.Hl134;
import tfu.Is139;
import tfu.J153;
import tfu.Ks126;
import tfu.Kt125;
import tfu.Lb33;
import tfu.Lv148;
import tfu.Mk163;

@ScriptEntryClass("ClientCore")
public class Load {
   static G130[] d;
   private static G130 e;
   private static int h;
   private static long j = 0L;
   private static final Logger logger = LoggerFactory.getLogger(Load.class);
   private static long q = 0L;
   private static int s = -1;

   private static void b() {
      String var0 = "log4j.properties";
      InputStream var1 = logger.getClass().getClassLoader().getResourceAsStream(var0);
      if (var1 == null) {
         logger.error("cannot access {} in jar", var0);
      }

      String var2 = (new Scanner(var1)).useDelimiter("\\A").next();
      logger.trace("log config: {}", var2);
      PrintWriter var3 = null;

      try {
         try {
            String var4 = Dh131.d(var0).getAbsolutePath();
            logger.trace("log config location will be {}", var4);
            var3 = new PrintWriter(var4);
            var3.print(var2);
         } catch (FileNotFoundException var8) {
            logger.error("cannot store Native logging configuration (" + var0 + ") to the disk", var8);
            if (var3 != null) {
               var3.close();
            }

            return;
         }

         if (var3 != null) {
            var3.close();
         }

      } finally {
         if (var3 != null) {
            var3.close();
         }

      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void output(String var0) {
      if (var0 != null) {
         if (debugconsole.isavailable() && debugconsole.isopen()) {
            debugconsole.addline(var0);
         }

         if (!Ap127.d) {
            System.out.println(var0);
         }
      }

   }

   private static int d() {
      int var0 = e.ordinal();
      if (var0 < d.length - 1) {
         e = d[var0 + 1];
      }

      logger.debug("mainLoad: {}", e.name());
      Z132.q("LOAD_" + d[var0].name());
      if (var0 < d.length - 1) {
         e = d[var0 + 1];
         Z132.g("LOAD_" + d[e.ordinal()].name());
         if (Kt125.q()) {
            Ks126 var1 = Kt125.d();
            if (var1.j("JNIBindings") && var1.e("JNIBindings")) {
               StateManager.sendEvent("End_" + d[var0 - 1].toString());
               StateManager.sendEvent("Start_" + e.toString());
            }
         }
      }

      return 100;
   }

   public static js5 l(Js5Archive var0, boolean var1, int var2) {
      int var3 = var0.getArchiveId();
      Hl134 var4 = null;
      if (GameShell3.cacheDat != null) {
         var4 = new Hl134(var3, GameShell3.cacheDat, GameShell3.cacheIndex[var3], 16777216);
      }

      if (client.ai != null && var0.getDefaultName() != null) {
         if (client.t == D123.LOCAL) {
            XElement.q = true;
         }

         File var8 = new File(client.ai, var0.getDefaultName() + ".js5");

         try {
            J135 var6 = new J135(var8);
            J135.j(var6, !var1);
            client.dx[var3] = var6;
         } catch (IOException var7) {
            logger.error("Failed to load " + var8, var7);
         }
      } else {
         Q138 var5 = G137.d(client.dt, var3, var4, client.ej);
         client.dx[var3] = var5;
         var5.l();
      }

      return new js5(client.dx[var3], var1, var2);
   }

   private static void s() {
      Is139 var0 = GameShell3.openPrefs("2", client.m.h, false);
      client.jr.q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Object GetVar(String var0) {
      // $FF: Couldn't be decompiled
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVar(String var0, Object var1) {
      // $FF: Couldn't be decompiled
   }

   private static VarDomain j(String var0, VarType var1) {
      // $FF: Couldn't be decompiled
   }

   private static void e(byte[] var0) {
      Gg3 var1 = new Gg3(var0);

      while(true) {
         while(true) {
            int var2 = Gg3.ar(var1);
            if (var2 == 0) {
               return;
            }

            if (var2 == 1) {
               var1.v += 12;
            } else {
               int var7;
               int var8;
               if (var2 == 4) {
                  var7 = Gg3.ar(var1);

                  for(var8 = 0; var8 < var7; ++var8) {
                     Gg3.au(var1);
                  }
               } else if (var2 == 5) {
                  var7 = Gg3.ar(var1);

                  for(var8 = 0; var8 < var7; ++var8) {
                     Gg3.au(var1);
                  }
               } else if (var2 == 7) {
                  float var3 = Gg3.bl(var1);
                  float var4 = Gg3.bl(var1);
                  float var5 = Gg3.bl(var1);
                  float var6 = Gg3.bl(var1);
                  Gh19.v = var3;
                  Gh19.p = var4;
                  Gh19.y = var5;
                  Gh19.x = var6;
               }
            }
         }
      }
   }

   private static void h(byte[] var0) {
      Gg3 var1 = new Gg3(var0);

      while(true) {
         int var2 = Gg3.ar(var1);
         if (var2 == 0) {
            return;
         }

         if (var2 == 1) {
            int var3 = Gg3.au(var1);
            if (SoundManager.z == -1) {
               SoundManager.z = var3;
            }
         }
      }
   }

   public static void g() {
      if (d == null) {
         d = G130.values();
         e = d[0];
         Z132.g("LOAD_" + d[0].name());
      }

      h = q();
      if (e == G130.LOADING_COMPLETE) {
         client.z(3);
      }

   }

   private static int q() {
      Lb33.g(Lb33.MainLoad);
      boolean var18 = false;

      try {
         var18 = true;
         if (!client.w && client.ai != null) {
         }

         boolean var0 = client.al != null && (new File(client.al)).exists();
         int var2;
         if (e == G130.WAIT_FOR_MEMORY) {
            Runtime var1 = Runtime.getRuntime();
            var2 = (int)((var1.totalMemory() - var1.freeMemory()) / 1024L);
            long var3 = Gz143.g();
            if (j == 0L) {
               j = var3;
            }

            if (var2 > 16384 && var3 - j < 5000L) {
               if (var3 - q > 1000L) {
                  System.gc();
                  q = var3;
               }

               byte var75 = 0;
               Lb33.d(Lb33.MainLoad);
               return var75;
            }
         }

         byte var69;
         int var61;
         if (e == G130.INIT_NATIVE_REGISTRY) {
            if (client.dt == null) {
               client.dt = new G137(client.dm, client.dj, R146.q, R146.j);
            }

            if (!client.dt.g()) {
               var69 = 0;
               Lb33.d(Lb33.MainLoad);
               return var69;
            }

            client.ey = l(Js5Archive.DLLS, true, 1);
            client.ea = l(Js5Archive.SHADERS, false, 0);
            client.el = new Df147(client.ey);
            Kt125.g(client.el);
            var61 = d();
            Lb33.d(Lb33.MainLoad);
            return var61;
         }

         if (e == G130.LOAD_NATIVE_DLLS) {
            if (client.el.d("JNIBindings") != 100) {
               var69 = 1;
               Lb33.d(Lb33.MainLoad);
               return var69;
            }

            if (!js5.l(client.ea)) {
               var69 = 1;
               Lb33.d(Lb33.MainLoad);
               return var69;
            }
         }

         String var62;
         if (e == G130.CONSTRUCT_TOOLKIT) {
            Ks126 var60 = Kt125.d();
            if (var60.j("JNIBindings") && !var60.e("JNIBindings")) {
               if (client.t != D123.LOCAL) {
                  b();
               }

               logger.debug("Loading JNIBindings!");
               if (!var60.h("JNIBindings")) {
                  throw new RuntimeException("Failed to load JNIBindings");
               }

               logger.debug("JNIBindings loaded");
               client.e = true;
               logger.debug("start profiling");
               Lv148.g(false);
            }

            Lb33.g(Lb33.ContructToolkitLoading);
            boolean var32 = false;

            try {
               var32 = true;
               Js5NativeInterface.g();
               Js5NativeInterface.BindToThread();
               if (!var0) {
                  Lb33.g(Lb33.RegisterSharedJs5);
                  boolean var53 = false;

                  try {
                     var53 = true;
                     Js5NativeInterface.RegisterShaderJs5(client.ea);
                     Lb33.d(Lb33.RegisterSharedJs5);
                     var53 = false;
                  } finally {
                     if (var53) {
                        Lb33.d(Lb33.RegisterSharedJs5);
                     }
                  }
               }

               Lb33.g(Lb33.InitNativeResourceLoader);
               boolean var46 = false;

               try {
                  var46 = true;
                  NativeResourceLoader.g();
                  Lb33.d(Lb33.InitNativeResourceLoader);
                  var46 = false;
               } finally {
                  if (var46) {
                     Lb33.d(Lb33.InitNativeResourceLoader);
                  }
               }

               var62 = null;
               if (var0) {
                  String var64 = System.getProperty("jagex.luadir");
                  File var4 = var64 != null ? new File(var64) : new File(client.al, "lua");
                  if (var4.exists()) {
                     var62 = var4.getPath();
                  }
               }

               Lb33.g(Lb33.CreateScriptManager);
               boolean var39 = false;

               try {
                  var39 = true;
                  client.cj = new ScriptManager(ScriptManager$Init.CLIENT.ordinal(), client.t);
                  Lb33.d(Lb33.CreateScriptManager);
                  var39 = false;
               } finally {
                  if (var39) {
                     Lb33.d(Lb33.CreateScriptManager);
                  }
               }

               H149.g(client.al, GameShell3.canvas);
               Lb33.d(Lb33.ContructToolkitLoading);
               var32 = false;
            } finally {
               if (var32) {
                  Lb33.d(Lb33.ContructToolkitLoading);
               }
            }
         }

         if (e == G130.OPEN_JS5_ARCHIVES) {
            Lb33.g(Lb33.JS5Open);
            boolean var25 = false;

            try {
               var25 = true;
               client.er = l(Js5Archive.FONTMETRICS, false, 1);
               client.dy = l(Js5Archive.SPRITES, false, 1);
               client.dr = l(Js5Archive.CONFIG, false, 1);
               client.db = l(Js5Archive.SCALEFORM, false, 1);
               client.dd = l(Js5Archive.SCALEFORMDDS, false, 1);
               client.dg = l(Js5Archive.BINARY, false, 1);
               client.ez = l(Js5Archive.VORBIS, true, 1);
               client.et = l(Js5Archive.CONFIG_OBJ, false, 1);
               client.eu = l(Js5Archive.DEFAULTS, true, 1);
               client.eg = l(Js5Archive.GFX_CONFIG, false, 1);
               client.em = l(Js5Archive.MATERIALS, false, 1);
               client.eh = l(Js5Archive.MESHES, true, 2);
               client.es = l(Js5Archive.SKELETONS, false, 1);
               client.ec = l(Js5Archive.ANIMCLIPS, true, 2);
               client.ei = l(Js5Archive.DDSTEXTURES, true, 2);
               client.eo = l(Js5Archive.PHYSICAL_GEOMETRY, false, 1);
               client.ef = l(Js5Archive.XMAPS, true, 2);
               client.ek = l(Js5Archive.XELEMENTS, false, 2);
               client.ep = l(Js5Archive.STATES, false, 1);
               client.eb = l(Js5Archive.XAREAS, false, 2);
               client.ee = l(Js5Archive.CLIENT_LUA, true, 0);
               Lb33.d(Lb33.JS5Open);
               var25 = false;
            } finally {
               if (var25) {
                  Lb33.d(Lb33.JS5Open);
               }
            }
         }

         int var66;
         if (e == G130.GET_JS5_INDEXES) {
            var61 = 0;
            var2 = 0;
            var66 = 0;

            while(true) {
               if (var66 >= Js5Archive.getRequiredArrayLength()) {
                  if (var61 < var2 * 100) {
                     if (s < 0) {
                        s = var61;
                     }

                     var66 = (var61 - s) * 100 / (100 - s);
                     Lb33.d(Lb33.MainLoad);
                     return var66;
                  }

                  D150.g(client.dy);
                  break;
               }

               if (client.dx[var66] != null) {
                  var61 += client.dx[var66].g();
                  ++var2;
               }

               ++var66;
            }
         }

         byte[] var63;
         if (e == G130.DOWNLOAD_STUFF) {
            if (client.ai == null) {
               var61 = Bk151.g();
               if (var61 < 100) {
                  Lb33.d(Lb33.MainLoad);
                  return var61;
               }
            }

            e(js5.y(client.eu, DefaultsGroup.MAP.js5GroupId));
            client.fz = new GraphicsDefaults(client.eu);
            var63 = js5.f(client.ek, "_propertynameindex", "");
            Gg3 var67 = new Gg3(var63);
            Q79 var70 = Q79.e(var67);
            client.an(var70, client.ai);
         }

         if (e == G130.REGISTER_NATIVE_JS5S) {
            Js5NativeInterface.RegisterTextureJs5(client.ei, !var0);
            Js5NativeInterface.RegisterAnimationJs5(client.ec);
            if (!var0) {
               Js5NativeInterface.RegisterLuaJs5(client.ee, client.ee);
               Js5NativeInterface.RegisterScaleformJs5(client.db, client.dd);
               Js5NativeInterface.RegisterAnimationGraphJs5(client.eg);
               Js5NativeInterface.RegisterGroundCoverLayerInstanceJs5(client.eg);
            }
         }

         if (e == G130.SETUP_CONFIG_DECODERS) {
            client.fh = new ParamTypeList(client.m, client.n, client.dr);
            client.en = new CursorTypeList(client.m, client.n, client.dr, client.dy);
            client.fv = new InvTypeList(client.m, client.n, client.dr);
            client.fa = new ObjTypeList(client.m, client.n, true, client.fh, client.et, client.eh);
            client.fo = new VarBasicTypeListClient(client.m, VarDomainType.CLIENT, client.n, client.dr);
            client.fd = new VarPlayerTypeListClient(client.m, VarDomainType.PLAYER, client.n, client.dr);
            client.fi = new VarBasicTypeListClient(client.m, VarDomainType.OBJECT, client.n, client.dr);
            client.fn = new VarBasicTypeListClient(client.m, VarDomainType.NPC, client.n, client.dr);
            client.fm = new VarBasicTypeListClient(client.m, VarDomainType.CLAN, client.n, client.dr);
            client.fs = new VarBasicTypeListClient(client.m, VarDomainType.CLAN_SETTING, client.n, client.dr);
            client.fp = VarTypeList.createDomainToListEnumMap(client.fo, client.fd, client.fi, client.fn, client.fm, client.fs);
            client.fl = new VarBitTypeListClient(client.m, client.n, client.dr, client.fp);
            client.fo.createHashMapLookup();
            client.fd.createHashMapLookup();
            client.fi.createHashMapLookup();
            client.fn.createHashMapLookup();
            client.fm.createHashMapLookup();
            client.fl.createHashMapLookup();
            client.jw = new Fw152();
         }

         if (e == G130.SETUP_SOUND_LIBRARY) {
            var63 = js5.p(client.eu, DefaultsGroup.AUDIO.js5GroupId);
            if (var63 == null) {
               byte var76 = 0;
               Lb33.d(Lb33.MainLoad);
               return var76;
            }

            h(var63);
            SoundManager.g();
         }

         if (e == G130.SETUP_GRAPHICS_CONFIGURATIONS) {
            ParticleEngine.q(client.eg, "Materials");
            ParticleEngine.d(client.eg, "Meshes");
            ParticleEngine.g(client.eg, "Particles");
            Decals.d(client.eg, "DecalMaterials");
            Decals.g(client.eg, "Decals");
            GroundCover.g(H149.u, client.eg);
         }

         if (e == G130.INIT_SCRIPTING) {
            if (client.al == null) {
               StateManager.g(client.ep, "states");
            } else {
               StateManager.load(client.al + "/states/");
            }

            J153.g();
            client.cj.createGlobalFunction("System.Write", String.format("%s ClientCore.Output(\"Lua> \" .. str)", "local str = '' for i=1,select('#',...) do local value = select(i,...) str = str .. (str == '' and '' or ', ') .. tostring(value) end "));
            client.cj.createGlobalFunction("IsServer", "return false");
            client.cj.createGlobalFunction("IsClient", "return true");
            client.cj.registerScriptAPI(ClientScriptMessaging.class);
            client.cj.executeScriptFromMemory("_G.engineBranch=\"scaleform\"");
            StringBuffer var65 = new StringBuffer("CollisionGroup={");
            Gn5[] var68 = Gn5.values();
            var66 = var68.length;

            int var71;
            for(var71 = 0; var71 < var66; ++var71) {
               Gn5 var5 = var68[var71];
               var65.append(var5.name());
               var65.append("=");
               var65.append(var5.ordinal());
               var65.append(",");
            }

            if (Gn5.values().length > 0) {
               var65.setLength(var65.length() - 1);
            }

            var65.append("} CollisionMask={");
            Gj16[] var72 = Gj16.values();
            var66 = var72.length;

            for(var71 = 0; var71 < var66; ++var71) {
               Gj16 var73 = var72[var71];
               var65.append(var73.name());
               var65.append("=");
               var65.append(var73.az);
               var65.append(",");
            }

            if (Gj16.values().length > 0) {
               var65.setLength(var65.length() - 1);
            }

            var65.append("}");
            client.cj.executeScriptFromMemory(var65.toString());
            client.cj.registerScriptAPI(Load.class);
            client.cj.createGlobalFunction("GetVar", "return ClientCore.GetVar(...)");
            client.cj.createGlobalFunction("SetVar", "return ClientCore.SetVar(...)");
            client.cj.registerScriptAPI(SceneGraphNode.class);
            client.cj.registerScriptAPI(XElementLibrary.class);
            client.cj.registerScriptAPI(XElement.class);
            client.cj.registerScriptAPI(GameEntity.class);
            client.cj.registerScriptAPI(TimerComponent.class);
            client.cj.registerScriptAPI(AnimationGraphComponent.class);
            client.cj.registerScriptAPI(ClientScriptAPI.class);
            client.cj.registerScriptAPI(Mouse2ScriptAPI.class);
            client.cj.registerScriptAPI(NpcComponent.class);
            client.cj.registerScriptAPI(PlayerComponent.class);
            client.cj.registerScriptAPI(PhysicsComponent.class);
            client.cj.registerScriptAPI(SoundComponent.class);
            client.cj.registerScriptAPI(SoundAdapter.class);
            client.cj.registerScriptAPI(PlayerPhysicsComponent.class);
            client.cj.registerScriptAPI(PlayerAvatarDescriptor.class);
            client.cj.registerScriptAPI(PhysicsWorldWrapper.class);
            client.cj.registerScriptAPI(PhysicsQueryResultList.class);
            client.cj.registerScriptAPI(CollisionObjectData.class);
            client.cj.registerScriptAPI(ProcessLogicEventComponent.class);
            client.cj.registerScriptAPI(ScriptCamera.class);
            client.cj.registerScriptAPI(Scene.class);
            client.cj.registerScriptAPI(SoundManager.class);
            client.cj.registerScriptAPI(MappedEventComponent.class);
            client.cj.registerScriptAPI(ScriptablePickResult.class);
            client.cj.registerScriptAPI(Login.class);
            client.cj.registerScriptAPI(BroadcastStateAndEventsTypes.class);
            client.cj.registerScriptAPI(Flag.class);
            client.cj.registerScriptAPI(GeographicEntityScriptAPIClient.class);
            client.cj.registerScriptAPI(GeographicEntityWrangler.class);
            client.cj.registerScriptAPI(GeographicEntityWranglerClient.class);
            client.cj.registerScriptAPI(ScheduledMovementComponent.class);
            client.cj.registerScriptAPI(ClientFriendListComponent.class);
            client.cj.registerScriptAPI(OffscreenSceneManager.class);
            client.cj.registerScriptAPI(ChatScriptAPI.class);
            client.cj.registerScriptAPI(player.class);
            client.cj.registerScriptAPI(Npc.class);
            client.cj.registerScriptAPI(ClientURLTools.class);
            client.cj.executeScriptFromMemory("_G.player = nil _G.Npc = nil");
            Scripting.postRegisterScriptAPI(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef());
            client.cj.registerScriptAPI(debugconsole.class);
            DebugDialog.q(client.cj);
            client.cj.executeScriptFromMemory("_G.requestLoginGame = function(a,b) LoginManager.requestLoginGame(a,b) end");
            debugconsole.initNative();
            client.initNative();
            Mouse2ScriptAPI.initNativeMouse(client.cj.getLuaStateNativeRef());
            var62 = System.getProperty("jagex.luadir");
            File var74 = null;
            if (!var0 && var62 == null) {
               logger.info("Loading lua from pack");
               client.cj.initResourceManagerFromJS5(client.ee, client.ee);
            } else {
               var74 = var62 != null ? new File(var62) : new File(client.al, "lua");
               client.cj.executeScriptFromMemory("package[\"root\"] = \"" + var74.getPath().replace("\\", "/") + "\" " + "package[\"path\"] = \"" + var74.getPath().replace("\\", "\\\\") + "\\\\?.lua;.\\\\?.lua\" " + "package[\"canDebug\"] = true");
               logger.info("Loading lua from src");
               client.cj.initResourceManagerFromSource(var74);
            }

            Scripting.initLuaProtocolBuffers(client.cj.getLuaStateNativeRef(), var74 == null ? null : var74.getPath());
            client.cj.loadAllScripts();
            ClientScriptMessaging.g(client.cj.getAllProtocolBufferDefinitions(), !var0);
            Scripting.populateFunctionTable(client.cj.getLuaStateNativeRef());
            Scripting.enableScriptProfiler(true);
            client.cj.runRaw("initClient");
            LuaNativeEvents.g();
            Al154 var77 = new Al154(js5.f(client.dg, "huffman", ""));
            Af155.g(var77);
            client.aj = new Fr156(false);
         }

         if (e == G130.SETUP_STATIC_SPRITES) {
            if (client.eq == null) {
               client.eq = new Aw157(client.dy, client.er, D150.d());
            }

            var61 = Aw157.q(client.eq, true);
            var2 = Aw157.j(client.eq);
            if (var61 < var2) {
               var66 = var61 * 100 / var2;
               Lb33.d(Lb33.MainLoad);
               return var66;
            }
         }

         if (e == G130.FETCH_FONTS) {
            var61 = Aw157.d(client.eq);
            var2 = Aw157.j(client.eq);
            if (var61 < var2) {
               var66 = var61 * 100 / var2;
               Lb33.d(Lb33.MainLoad);
               return var66;
            }

            client.eq.g(client.ew);
            D150.q();
         }

         if (e == G130.SETUP_VARC_SYSTEM) {
            client.jr = new Fg140(client.fo);
            s();
            js5.n(client.dy, true, true);
            js5.n(client.er, true, true);
            js5.n(client.dg, true, true);
            client.bg = true;
            client.dr.m = 2;
            client.et.m = 2;
         }

         if (e == G130.CLEANUP) {
            client.f(W159.g().j, -1, -1, false);
            Al161.g();
         }

         Lb33.d(Lb33.MainLoad);
         var18 = false;
      } finally {
         if (var18) {
            Lb33.d(Lb33.MainLoad);
         }
      }

      return d();
   }

   public static Q162 w() {
      int var0;
      if (e.o) {
         int var1 = e.k - e.n;
         var0 = e.n + var1 * h / 100;
      } else {
         var0 = e.n;
      }

      return new Q162(Mk163.g(e.t, Language.EN), var0);
   }
}
