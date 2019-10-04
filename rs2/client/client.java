package rs2.client;

import com.jagex.core.constants.D123;
import com.jagex.core.constants.E294;
import com.jagex.core.constants.G320;
import com.jagex.core.constants.Language;
import com.jagex.core.stringtools.general.D281;
import com.jagex.core.stringtools.general.G282;
import com.jagex.core.stringtools.general.J173;
import com.jagex.core.stringtools.general.Q280;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.client.GameShell3$Environment;
import com.jagex.game.runetek6.client.GameShell3$FrameParameters;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTransmission;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.broadcast.CommonStateAndEventTypes;
import com.jagex.game.runetek6.comms.broadcast.SceneryConfig;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamStatistics;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.packetchannel.DelayableUDPPacketChannel;
import com.jagex.game.runetek6.comms.statestream.packetchannel.NumberingPacketChannel;
import com.jagex.game.runetek6.comms.statestream.packetchannel.UDPPacketChannelClient;
import com.jagex.game.runetek6.config.Js5Archive;
import com.jagex.game.runetek6.config.cursortype.CursorType;
import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import com.jagex.game.runetek6.config.defaults.DefaultsGroup;
import com.jagex.game.runetek6.config.defaults.GraphicsDefaults;
import com.jagex.game.runetek6.config.invtype.InvTypeList;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.vartype.SparseVarDomain;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import com.jagex.game.runetek6.gameentity.components.ProcessLogicEventComponent;
import com.jagex.game.runetek6.gameentity.components.TimerComponent;
import com.jagex.game.runetek6.scenegraph.D75;
import com.jagex.game.runetek6.scenegraph.E254;
import com.jagex.game.runetek6.scenegraph.L170;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.xelement.Ao74;
import com.jagex.game.runetek6.xelement.Bh77;
import com.jagex.game.runetek6.xelement.Bj61;
import com.jagex.game.runetek6.xelement.J113;
import com.jagex.game.runetek6.xelement.Q79;
import com.jagex.game.runetek6.xelement.T101;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.jnibindings.runetek6.Graphics;
import com.jagex.jnibindings.runetek6.IrradianceVolumes;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import com.jagex.jnibindings.runetek6.NativeResourceLoader;
import com.jagex.jnibindings.runetek6.NavPowerClient;
import com.jagex.jnibindings.runetek6.ProcessInfo;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.jnibindings.runetek6.RuntimeTool.F511;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.js5.G137;
import com.jagex.js5.L145;
import com.jagex.js5.S136;
import com.jagex.js5.W144;
import com.jagex.js5.js5;
import com.jagex.maths.Ag566;
import com.jagex.maths.H303;
import com.jagex.maths.I48;
import com.jagex.maths.Matrix4;
import com.jagex.maths.N319;
import com.jagex.maths.O166;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Point;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.chat.G232;
import rs2.client.friends.ClientFriendListComponent;
import rs2.client.friends.D236;
import rs2.client.inventory.ClientInventory;
import rs2.client.inventory.G451;
import rs2.client.loading.Load;
import rs2.client.login.E275;
import rs2.client.login.H577;
import rs2.client.login.J570;
import rs2.client.login.Login;
import rs2.client.login.R273;
import rs2.client.login.W274;
import rs2.client.lua.ClientScriptAPI;
import rs2.client.lua.ClientScriptMessaging;
import rs2.client.lua.debugdialog.DebugDialog;
import rs2.client.sound.SoundManager;
import rs2.client.web.G405;
import rs2.client.worldelement.Npc;
import rs2.client.worldelement.NpcComponent;
import rs2.client.worldelement.PlayerComponent;
import rs2.client.worldelement.player;
import rs2.shared.lua.G284;
import rs2.shared.movement.I187;
import rs2.shared.movement.M188;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerAvatarDescriptor;
import rs2.shared.movement.PlayerPhysicsAvatar;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.Q40;
import rs2.shared.movement.ScheduledMovementComponent;
import rs2.shared.movement.Y192;
import rs2.shared.sound.SoundComponent;
import tfu.Ab158;
import tfu.Af155;
import tfu.At476;
import tfu.Aw157;
import tfu.Az399;
import tfu.B665;
import tfu.Ba115;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bn279;
import tfu.Bs1;
import tfu.Bt286;
import tfu.Bu350;
import tfu.Bv351;
import tfu.Bz650;
import tfu.C340;
import tfu.D285;
import tfu.Df147;
import tfu.Dg449;
import tfu.Dp208;
import tfu.Dr574;
import tfu.Ea395;
import tfu.Ed472;
import tfu.Ee573;
import tfu.Ef450;
import tfu.Ej287;
import tfu.El328;
import tfu.Eq28;
import tfu.Et578;
import tfu.Eu326;
import tfu.Ev579;
import tfu.Ex582;
import tfu.Ey446;
import tfu.F342;
import tfu.Fc454;
import tfu.Fg140;
import tfu.Fj373;
import tfu.Fk353;
import tfu.Fr156;
import tfu.Fw152;
import tfu.G289;
import tfu.Gb471;
import tfu.Gc330;
import tfu.Gd27;
import tfu.Gf474;
import tfu.Gg3;
import tfu.Gh19;
import tfu.Gj16;
import tfu.Gl480;
import tfu.Gm479;
import tfu.Gn5;
import tfu.Go485;
import tfu.Gs329;
import tfu.Gt488;
import tfu.Gu487;
import tfu.Gv486;
import tfu.Gz143;
import tfu.H149;
import tfu.Ha262;
import tfu.Hb335;
import tfu.Hd425;
import tfu.Hf380;
import tfu.Hi86;
import tfu.Hk84;
import tfu.Hl134;
import tfu.Hq338;
import tfu.Hx339;
import tfu.Is139;
import tfu.Iz11;
import tfu.Ja527;
import tfu.Jh522;
import tfu.Ji520;
import tfu.Jp534;
import tfu.Jt38;
import tfu.Jv532;
import tfu.Kc180;
import tfu.Kj334;
import tfu.Ko370;
import tfu.Kr260;
import tfu.Ku323;
import tfu.Kv538;
import tfu.Lb33;
import tfu.Lf336;
import tfu.Lk495;
import tfu.Ll42;
import tfu.Lq191;
import tfu.Lr302;
import tfu.Lt501;
import tfu.Lv148;
import tfu.Lx337;
import tfu.Ly234;
import tfu.Lz409;
import tfu.Md230;
import tfu.Mf509;
import tfu.Mi507;
import tfu.Mk163;
import tfu.Ms517;
import tfu.Mu209;
import tfu.Mv477;
import tfu.W667;

@Kv538(true)
public class client extends GameShell3 {
   public static int a;
   public static boolean aa = false;
   public static String[] ab = new String[]{"Loading", "Loading 2", "Loading 3", "Login screen", "Login screen (Map build)", "Logging in from loginscreen to lobby", "Logging in from loginscreen to game", "Lobby screen", "Lobby screen (Map build)", "Logging in from lobbyscreen to game", "Logging in from lobbyscreen to game (Map build)", "Game screen", "Game screen (Map build)", "Logging in from gamescreen to lobby", "Reconnecting", "Switch World", "Error"};
   public static int ac = 0;
   private static long ad;
   public static boolean ae;
   public static String af = null;
   private static final Color ag = new Color(128, 0, 0);
   public static R273 ah;
   public static String ai;
   public static Fr156 aj;
   static final int ak = 100;
   public static String al;
   public static boolean am = false;
   public static boolean an = false;
   public static boolean ao = false;
   public static H577 ap = new H577();
   private static final Color aq = new Color(80, 80, 80);
   public static Matrix4 ar;
   public static int as = 0;
   private static F511 at = new F511();
   public static H303 au;
   public static int av = 0;
   public static int aw = 1;
   public static H303 ax;
   static final float ay = 0.3F;
   public static boolean az = false;
   public static int b = 200;
   public static boolean ba;
   public static boolean bb;
   public static boolean bc;
   private static Vector3 bd;
   public static N319 be;
   public static boolean bg;
   private static boolean bh;
   public static long bi;
   public static int bj;
   public static boolean bk;
   public static Matrix4 bl;
   public static Matrix4 bm;
   public static String bn;
   public static Matrix4 bo;
   public static boolean bp;
   public static Vector3 bq;
   public static String br;
   public static boolean bs;
   public static boolean bt;
   public static client bu;
   public static int bv;
   private static float bw;
   public static boolean bx;
   public static boolean by;
   public static int bz;
   public static String c;
   static IdentityHashMap ca;
   private static long cb;
   private static long cc;
   private static int cd;
   private static ArrayList ce;
   public static boolean cf;
   private static int cg;
   public static Hx339 ch;
   public static Socket ci;
   public static ScriptManager cj;
   private static ArrayList ck;
   public static boolean cl;
   private static long cm;
   public static boolean cn;
   public static Color[] co;
   private static int cp;
   public static ByteBuffer cr;
   public static boolean cs;
   private static int ct;
   public static boolean cu;
   private static ArrayDeque cv;
   public static boolean cw;
   public static Color[] cx;
   public static Color[] cy;
   public static boolean cz;
   public static double d = 0.0D;
   public static long da;
   public static js5 db;
   public static final I187 dc;
   public static js5 dd;
   public static UDPPacketChannelClient de;
   public static int df;
   public static js5 dg;
   public static DelayableUDPPacketChannel dh;
   public static float di;
   public static L145 dj;
   public static int dk;
   public static boolean dl;
   public static W144 dm;
   public static boolean dn;
   public static boolean do_;
   public static boolean dp;
   public static final LossyStateStreamSynchronizer dq;
   public static js5 dr;
   public static final Q40 ds;
   public static G137 dt;
   public static boolean du;
   public static LossyStateStreamStatistics dv;
   public static NumberingPacketChannel dw;
   public static S136[] dx;
   public static js5 dy;
   public static int dz;
   public static boolean e = false;
   public static js5 ea;
   public static js5 eb;
   public static js5 ec;
   private static String ed;
   public static js5 ee;
   public static js5 ef;
   public static js5 eg;
   public static js5 eh;
   public static js5 ei;
   public static Hl134 ej;
   public static js5 ek;
   public static Df147 el;
   public static js5 em;
   public static CursorTypeList en;
   public static js5 eo;
   public static js5 ep;
   public static Aw157 eq;
   public static js5 er;
   public static js5 es;
   public static js5 et;
   public static js5 eu;
   public static int ev;
   public static final Ab158 ew;
   public static Eq28 ex;
   public static js5 ey;
   public static js5 ez;
   public static int f = 0;
   public static ObjTypeList fa;
   public static int fb;
   public static final int fc = 3;
   public static VarPlayerTypeListClient fd;
   public static int fe;
   static boolean ff;
   public static int fg;
   public static ParamTypeList fh;
   public static VarBasicTypeListClient fi;
   public static int fj;
   public static Go485 fk;
   public static VarBitTypeListClient fl;
   public static VarBasicTypeListClient fm;
   public static VarBasicTypeListClient fn;
   public static VarBasicTypeListClient fo;
   public static Map fp;
   public static final int fq = 4;
   static Hx339 fr;
   public static VarBasicTypeListClient fs;
   public static Map ft;
   public static final int fu = 0;
   public static InvTypeList fv;
   public static boolean fw;
   public static final N272 fx;
   public static final int fy = 1;
   public static GraphicsDefaults fz;
   public static float ga;
   public static D285 gb;
   static boolean gc;
   public static float gd;
   private static final int[] ge;
   static Bv351 gf;
   private static int[] gg;
   public static float gh;
   private static final int gi = 4095;
   public static int gj;
   public static boolean gk;
   private static int[] gl;
   public static int gm;
   public static int gn;
   private static int[] go;
   public static int gp;
   public static float gq;
   public static int gr;
   private static int[] gs;
   public static final int[] gt;
   public static Ms517 gu;
   static long gv;
   public static int gw;
   public static int gx;
   public static int gy;
   public static Ll42 gz;
   public static final boolean h = false;
   public static int ha;
   public static int hb;
   public static int hc;
   private static int hd;
   private static Hb335 he;
   private static int hf;
   public static Hd425[] hg;
   public static int hh;
   public static short[] hi;
   public static int hj;
   public static int hk;
   public static Random hl;
   public static int hm;
   public static int hn;
   public static int ho;
   public static int hp;
   private static int hq;
   static int hr;
   public static float[] hs;
   public static int ht;
   public static int hu;
   public static int hv;
   private static float hw;
   public static int hx;
   public static int hy;
   private static int hz;
   public static boolean i = false;
   public static final int ia = 2048;
   public static int ib;
   public static boolean ic;
   public static boolean id;
   public static boolean ie;
   public static boolean if_;
   public static boolean ig;
   public static int ih;
   public static int ii;
   public static int ij;
   public static int ik;
   public static boolean il;
   public static long im;
   public static int in;
   public static boolean io;
   public static boolean ip;
   public static int iq;
   public static long ir;
   public static long is;
   public static int it;
   public static boolean iu;
   public static boolean iv;
   public static boolean iw;
   public static int ix;
   public static int iy;
   public static int iz;
   public static int j = 0;
   public static int ja;
   public static Hb335 jb;
   public static Clipboard jc;
   public static int jd;
   public static int je;
   public static int jf;
   public static int jg;
   private static long[] jh;
   public static Ha262 ji;
   public static volatile int jj;
   private static final int[] jk;
   public static int jl;
   public static int jm;
   public static int jn;
   public static int jo;
   private static int jp;
   public static int jq;
   public static Fg140 jr;
   public static SparseVarDomain js;
   private static final int jt = 100;
   public static String ju;
   public static String jv;
   public static Fw152 jw;
   private static int jx;
   public static boolean jy;
   public static Hf380 jz;
   public static boolean k = false;
   private static boolean ka;
   public static Calendar kb;
   public static double kc;
   public static int kd;
   public static int ke;
   public static String kf;
   public static Ah608[] kg;
   public static Dr574 kh;
   public static int ki;
   public static Ef450 kj;
   public static short[] kk;
   public static int kl;
   public static int km;
   public static float kn;
   public static Dr574 ko;
   public static double kp;
   public static double kq;
   public static byte kr;
   public static int ks;
   public static int kt;
   public static ClientFriendListComponent ku;
   public static Ef450 kv;
   public static int kw;
   public static boolean kx;
   public static double ky;
   public static byte kz;
   private static final Bu350 l = new Bu350(3, "Client utilPool");
   public static boolean la;
   static float lb;
   public static boolean lc;
   public static double ld;
   private static int le;
   public static boolean lf;
   static Component lg;
   public static final Hi86 lh;
   private static float[] li;
   public static long lj;
   public static boolean lk;
   public static long ll;
   public static boolean lm;
   public static int ln;
   public static double lo;
   static final Logger logger = LoggerFactory.getLogger(client.class);
   public static boolean lp;
   public static G284 lq;
   public static boolean lr;
   public static G284 ls;
   static float lt;
   private static final int lu = 200;
   public static boolean lv;
   public static final Hk84 lw;
   public static boolean lx;
   private static int[] ly;
   public static RotTrans lz;
   public static Gd27 m = null;
   static final int ma = 200;
   static GameEntity[] mb;
   static boolean mc;
   private static float[] md;
   private static int[] me;
   static final int[] mf;
   public static E254 mg;
   static final int mh = Integer.MIN_VALUE;
   static float[] mi;
   private static float[] mj;
   static float[] mk;
   static int ml;
   public static Scene mm;
   static final int mn = 150;
   static final int[] mo;
   static int mp;
   static float[] mq;
   static final int mr = 3;
   public static boolean ms;
   static final int mt = 25;
   static final int mu = 10;
   static float[] mv;
   private static int mw;
   static float[] mx;
   static Vector3[] my;
   static float[] mz;
   public static Language n;
   private static ByteBuffer nc;
   static long ng;
   public static String nh;
   private static Jp534 ni;
   static int nw;
   public static String o = "";
   private static final char[] p = new char[200];
   public static int q = 0;
   public static final boolean r = false;
   public static long s = 0L;
   public static D123 t;
   private static int u = 0;
   private static final boolean v = true;
   public static boolean w = false;
   public static Gm479 z;
   private B402 cq = null;

   @Be2
   @Bs1
   public static void nativeMouseInputMove(int var0, int var1) {
      if (fx.s != null) {
         if (var0 < -1) {
            var0 = -1;
         } else if (var0 > 65534) {
            var0 = 65534;
         }

         if (var1 < -1) {
            var1 = -1;
         } else if (var1 > 65534) {
            var1 = 65534;
         }

         if (cg != var0 || ct != var1) {
            El328 var2 = El328.d(Eu326.EVENT_MOUSE_MOVE, fx.s);
            Gs329.k(var2.q, 0);
            int var3 = var2.q.v;
            int var4 = var0 - cg;
            cg = var0;
            int var5 = var1 - ct;
            ct = var1;
            int var6 = (int)((Gz143.g() - cm) / 20L);
            if (var6 < 8 && var4 >= -32 && var4 <= 31 && var5 >= -32 && var5 <= 31) {
               var4 += 32;
               var5 += 32;
               Gs329.i(var2.q, (var6 << 12) + (var4 << 6) + var5);
            } else if (var6 < 32 && var4 >= -128 && var4 <= 127 && var5 >= -128 && var5 <= 127) {
               var4 += 128;
               var5 += 128;
               Gs329.k(var2.q, 128 + var6);
               Gs329.i(var2.q, (var4 << 8) + var5);
            } else if (var6 < 32) {
               Gs329.k(var2.q, 192 + var6);
               if (var0 != 1 && var1 != -1) {
                  Gs329.a(var2.q, var0 | var1 << 16);
               } else {
                  Gs329.a(var2.q, Integer.MIN_VALUE);
               }
            } else {
               Gs329.i(var2.q, '\ue000' + var6);
               if (var0 != 1 && var1 != -1) {
                  Gs329.a(var2.q, var0 | var1 << 16);
               } else {
                  Gs329.a(var2.q, Integer.MIN_VALUE);
               }
            }

            cm = Gz143.g();
            Gs329.ac(var2.q, var2.q.v - var3);
            N272.e(fx, var2);
         }
      }

   }

   public static final native void nativeSetFocus();

   public static void by() {
      if (ac == 11) {
         if (ac == 3) {
            z(4);
         } else if (ac == 11) {
            z(12);
         }

      }
   }

   @Be2
   public static void main(String[] var0) {
      if (var0.length != 6 && var0.length != 7) {
         j("Argument count");
      }

      logger.debug("start");
      q(var0, new client());
   }

   static void bb() {
      bt();
      la = true;
      M188.w();
      cj.event.triggerEvent((String)"__onMapFullyBuilt", (Object)null);
      Lz409.b = 0;
      Lz409.l = 0;
      if (F511.j(at) && !F511.e(at)) {
         F511.q(at);
         Z132.q("MapBuildState_" + F511.h(at));
      }

   }

   private static final void j(String var0) {
      logger.error("Bad " + var0 + ", Usage: worldid, lobbyid, demoworldid, <live/rc/wip>, <english/german>, <game0/game1>, <loading bar config>");
      System.exit(1);
   }

   public static final void ac() {
      fa.cacheReset();
      fl.cacheReset();
      fd.cacheReset();
      fi.cacheReset();
      fn.cacheReset();
      fm.cacheReset();
      fs.cacheReset();
      fh.cacheReset();
      en.cacheReset();
      Aw157.b(eq);
      js5.m(dr);
      js5.m(dy);
      js5.m(dg);
      js5.m(er);
      js5.m(ez);
      js5.m(et);
      js5.m(eu);
      js5.m(ey);
      js5.m(ea);
      js5.m(em);
      js5.m(eh);
      js5.m(es);
      js5.m(ec);
      js5.m(ei);
      js5.m(ef);
      js5.m(ek);
      js5.m(eb);
      js5.m(ee);
      Eq28.s(ex);
   }

   public final void maininit() {
      js5.i = false;
      Hi86.q(lh);
      Gl480.d = true;
      Frame var1 = new Frame(" ");
      var1.pack();
      var1.dispose();
      dj = new L145();
      dm = new W144();
      Mv477.g(new int[]{20, 260}, new int[]{1000, 100});
      I48.g(4096);
      O166.g(4096);
      Ag566.g(128);
      CommonStateAndEventTypes.Init(false);
      if (t != D123.INTBETA && t != D123.LIVE) {
         if (af != null) {
            Lf336.j.d = af;
            Lf336.j.g = av;
            Lf336.j.q = '鱀' + Lf336.j.g;
            Lf336.j.j = '썐' + Lf336.j.g;
         } else if (D123.d(t, G320.OFFICE)) {
            Lf336.j.d = this.getCodeBase().getHost();
            Lf336.j.q = '鱀' + Lf336.j.g;
            Lf336.j.j = '썐' + Lf336.j.g;
         } else if (t == D123.LOCAL) {
            Lf336.j.q = '鱀' + Lf336.j.g;
            Lf336.j.j = '썐' + Lf336.j.g;
         }
      } else {
         Lf336.j.d = this.getCodeBase().getHost();
      }

      Lf336.q = Lf336.j;

      try {
         Al161.d(InetAddress.getByName(Lf336.q.d));
      } catch (UnknownHostException var4) {
      }

      if (m == Gd27.RUNESCAPE) {
         ba = false;
      }

      hi = ObjType.clientpalette = new short[256];

      try {
         jc = this.getToolkit().getSystemClipboard();
      } catch (Exception var3) {
      }

      if (t != D123.LIVE) {
         bx = true;
      }

      setPhysicsSpeed((float)Lq191.g());
      GameShell3.loadingTitle = Mk163.g(Mk163.LOADING, n);
      Bz650.g(!D123.d(t, G320.HAS_EXTERNAL_ACCESS));
      Bz650.d(Ed472.values());
      Bz650.q(Ej287.values());
      GameEntity.bf = Ba115.d(Ej287.CLIENT_SCRIPTED);
      GameEntity.bn = Ba115.d(Ej287.CLIENT_ATTACHMENT);
      ai = System.getProperty("jagex.packcontentpath");
      if (ai != null && !(new File(ai)).isDirectory()) {
         ai = null;
         throw new RuntimeException("Invalid Pack Content Path : " + ai);
      } else {
         al = System.getProperty("jagex.srccontentpath");
         if (al != null && !(new File(al)).isDirectory()) {
            al = null;
            throw new RuntimeException("Invalid Source Content Path : " + al);
         } else {
            Y192.g(true);
         }
      }
   }

   public final void mainphysics() {
      Lb33.g(Lb33.UDP);
      boolean var8 = false;

      try {
         label175: {
            try {
               var8 = true;
               Lb33.g(Lb33.ProcessIncoming);
               boolean var18 = false;

               try {
                  var18 = true;
                  dq.processIncomingPackets();
                  Lb33.d(Lb33.ProcessIncoming);
                  var18 = false;
               } finally {
                  if (var18) {
                     Lb33.d(Lb33.ProcessIncoming);
                  }
               }

               Lb33.g(Lb33.SendOutgoing);
               boolean var13 = false;

               try {
                  var13 = true;
                  dq.sendOutgoingPackets();
                  Lb33.d(Lb33.SendOutgoing);
                  var13 = false;
               } finally {
                  if (var13) {
                     Lb33.d(Lb33.SendOutgoing);
                  }
               }
            } catch (Exception var21) {
               logger.error("Exception servicing state stream synchronizer", var21);
               at();
               Lb33.d(Lb33.UDP);
               var8 = false;
               break label175;
            }

            Lb33.d(Lb33.UDP);
            var8 = false;
         }
      } finally {
         if (var8) {
            Lb33.d(Lb33.UDP);
         }
      }

      if (gb == null || D285.j(gb)) {
         if (kx) {
            e();
         }

         if (gk && M188.s() < 1.0F) {
            ad();
         }

      }
   }

   private static void e() {
      float var0 = 0.25F;
      int var1 = ln;
      if ((float)(System.nanoTime() - ll) > 2.0F * Lq191.d() * 1.0E9F) {
         var1 = 0;
      }

      float var2 = (float)var1 / var0;
      float var3 = kn - var2;
      int var4 = Lq191.g();
      if (var3 < (float)var4 / 2.0F) {
         var3 = (float)var4 / 2.0F;
      }

      if (var3 > (float)var4 * 2.0F) {
         var3 = (float)var4 * 2.0F;
      }

      setPhysicsSpeed(var3);
   }

   public void cycleend(boolean var1) {
      Lv148.d(var1);
   }

   public void mainloop(float var1) {
      this.s(var1);
   }

   private void h(float var1) {
      if (e) {
         if (s == 0L) {
            s = Kc180.g((long)b);
            if (s == 0L) {
               logger.error("pNativeBuffer == null");
            } else {
               logger.debug("allocated " + b + " bytes for pNativeBuffer");
            }
         }

         if (s != 0L) {
            player var2 = Gc330.j();
            ScriptCamera var3 = ScriptCamera.getActiveCamera();
            ScaleRotTrans var4 = ScaleRotTrans.g;
            if (var2 != null) {
               var4 = var2.getWorldTransform();
            }

            ScaleRotTrans var5 = ScaleRotTrans.g;
            Matrix4 var6 = Matrix4.g;
            if (var3 != null) {
               var5 = var3.getWorldTransform();
               var6 = var3.getProjMatrix();
            }

            long var7 = s;
            byte var9 = (byte)H149.e;
            Kc180.b(var7, var9);
            ++var7;
            Kc180.s(var7, H149.h);
            var7 += (long)H149.d;
            Kc180.v(var7, var4.scale);
            var7 += 4L;
            Kc180.v(var7, var5.rot.x);
            var7 += 4L;
            Kc180.v(var7, var5.rot.y);
            var7 += 4L;
            Kc180.v(var7, var5.rot.z);
            var7 += 4L;
            Kc180.v(var7, var5.rot.w);
            var7 += 4L;
            Kc180.v(var7, var5.trans.x);
            var7 += 4L;
            Kc180.v(var7, var5.trans.y);
            var7 += 4L;
            Kc180.v(var7, var5.trans.z);
            var7 += 4L;
            Kc180.v(var7, var6.f00);
            var7 += 4L;
            Kc180.v(var7, var6.f01);
            var7 += 4L;
            Kc180.v(var7, var6.f02);
            var7 += 4L;
            Kc180.v(var7, var6.f03);
            var7 += 4L;
            Kc180.v(var7, var6.f10);
            var7 += 4L;
            Kc180.v(var7, var6.f11);
            var7 += 4L;
            Kc180.v(var7, var6.f12);
            var7 += 4L;
            Kc180.v(var7, var6.f13);
            var7 += 4L;
            Kc180.v(var7, var6.f20);
            var7 += 4L;
            Kc180.v(var7, var6.f21);
            var7 += 4L;
            Kc180.v(var7, var6.f22);
            var7 += 4L;
            Kc180.v(var7, var6.f23);
            var7 += 4L;
            Kc180.v(var7, var6.f30);
            var7 += 4L;
            Kc180.v(var7, var6.f31);
            var7 += 4L;
            Kc180.v(var7, var6.f32);
            var7 += 4L;
            Kc180.v(var7, var6.f33);
            var7 += 4L;
            long var10 = 0L;
            if (gz != null && gz.d != null && gz.d.d != null) {
               var10 = DiscreteDynamicsWorld.g(gz.d.d);
            }

            Kc180.s(var7, var10);
            var7 += (long)Kc180.e();
            int var12 = -1;
            RotTrans var13 = RotTrans.g;
            RotTrans var14 = RotTrans.g;
            if (var2 != null) {
               RotTrans var15 = var2.getWorldTransform().q();
               var13 = var15;
               var14 = var15;
               PlayerPhysicsComponent var16 = (PlayerPhysicsComponent)player.eb(var2, PlayerPhysicsComponent.class);
               if (var16 != null) {
                  Integer var17 = PlayerPhysicsComponent.m(var16, false);
                  if (var17 != null) {
                     PlayerAvatarDescriptor var18 = PlayerAvatarDescriptor.g(var17);
                     if (var18 != null) {
                        Vector3 var19 = Vector3.al(Vector3.q, var15.rot);
                        var13 = var15.r(var19, PlayerAvatarDescriptor.h(var18) * 0.9F);
                        var14 = var15.s(Gh19.g);
                        var14 = var14.r(var19, PlayerAvatarDescriptor.h(var18) * 0.5F);
                        var14 = PlayerAvatarDescriptor.l(var18, var14);
                     }
                  }

                  PlayerPhysicsAvatar var30 = var16.getAvatar(false);
                  if (var30 != null) {
                     CollisionObject var32 = var30.e;
                     if (var32 != null) {
                        var12 = (int)var32.s;
                     }
                  }
               }
            }

            Kc180.r(var7, var12);
            var7 += 4L;
            Kc180.r(var7, Gn5.CAMERA_COLLIDE.ordinal());
            var7 += 4L;
            Kc180.r(var7, Gn5.CAMERA_SIGHT.ordinal());
            var7 += 4L;
            Kc180.v(var7, var13.trans.x);
            var7 += 4L;
            Kc180.v(var7, var13.trans.y);
            var7 += 4L;
            Kc180.v(var7, var13.trans.z);
            var7 += 4L;
            Kc180.v(var7, var14.rot.x);
            var7 += 4L;
            Kc180.v(var7, var14.rot.y);
            var7 += 4L;
            Kc180.v(var7, var14.rot.z);
            var7 += 4L;
            Kc180.v(var7, var14.rot.w);
            var7 += 4L;
            Kc180.v(var7, var14.trans.x);
            var7 += 4L;
            Kc180.v(var7, var14.trans.y);
            var7 += 4L;
            Kc180.v(var7, var14.trans.z);
            var7 += 4L;
            if (var7 > s + (long)b) {
               throw new Error("Buffer overrun - wrote " + (var7 - s) + " bytes, only had room for " + b + " - bailing out!");
            }

            nativeUpdateGameplayStates(s, b, var1);
            var7 = s;
            float var27 = Kc180.u(var7);
            var7 += 4L;
            float var28 = Kc180.u(var7);
            var7 += 4L;
            float var29 = Kc180.u(var7);
            var7 += 4L;
            float var31 = Kc180.u(var7);
            var7 += 4L;
            float var33 = Kc180.u(var7);
            var7 += 4L;
            float var20 = Kc180.u(var7);
            var7 += 4L;
            float var21 = Kc180.u(var7);
            var7 += 4L;
            float var22 = Kc180.u(var7);
            var7 += 4L;
            float var23 = Kc180.u(var7);
            var7 += 4L;
            float var24 = Kc180.u(var7);
            var7 += 4L;
            float var25 = Kc180.u(var7);
            var7 += 4L;
            float var26 = Kc180.u(var7);
            var7 += 4L;
            bm = new Matrix4(var27, var28, var29, 0.0F, var31, var33, var20, 0.0F, var21, var22, var23, 0.0F, var24, var25, var26, 1.0F);
            bq = new Vector3(var24, var25, var26);
            bo = bm.j();
            bl = bo.g(var6);
            bw = Kc180.u(var7);
            var7 += 4L;
            if (var7 > s + (long)b) {
               throw new Error("Buffer overrun - read " + (var7 - s) + " bytes, only had room for " + b + " - bailing out!");
            }
         }

      }
   }

   public static final void ak() {
      ScriptCamera.br();
      Ll42.g(gz);
   }

   @Be2
   @Bs1
   public static void clientRequestFocus() {
      GameShell3.canvas.requestFocusInWindow();
   }

   public void mainredraw() {
      Lb33.g(Lb33.MainRedraw);

      try {
         if (ac == 16) {
            Lb33.d(Lb33.MainRedraw);
         } else {
            long var1 = System.nanoTime() / 1000000L;
            long var3 = var1 - ad;
            if (ad == 0L) {
               var3 = 20L;
            }

            ad = var1;
            Lb33.g(Lb33.zAudioRender);
            boolean var71 = false;

            try {
               var71 = true;
               b(this);
               Lb33.d(Lb33.zAudioRender);
               var71 = false;
            } finally {
               if (var71) {
                  Lb33.d(Lb33.zAudioRender);
               }
            }

            Lb33.g(Lb33.zTweening);
            boolean var63 = false;

            try {
               var63 = true;
               if (mm != null && gb != null && D285.j(gb)) {
                  M188.h((float)var3 * 0.001F);
                  if (gk) {
                     while(M188.s() < 0.0F) {
                        ad();
                     }
                  }

                  Iterator var5 = mm.x(ScheduledMovementComponent.class).iterator();

                  while(var5.hasNext()) {
                     ScheduledMovementComponent var6 = (ScheduledMovementComponent)var5.next();
                     var6.w((float)var3 * 0.001F);
                  }

                  var5 = mm.x(PlayerPhysicsComponent.class).iterator();

                  while(var5.hasNext()) {
                     PlayerPhysicsComponent var81 = (PlayerPhysicsComponent)var5.next();
                     var81.z();
                  }
               }

               Lb33.d(Lb33.zTweening);
               var63 = false;
            } finally {
               if (var63) {
                  Lb33.d(Lb33.zTweening);
               }
            }

            Lb33.g(Lb33.UpdateGameplayStates);
            boolean var55 = false;

            try {
               var55 = true;
               if (!r(ac) && !y(ac)) {
                  H149.q(cj.getLuaStateNativeRef(), (float)var3 * 0.001F);
               }

               this.h((float)var3 * 0.001F);
               if (!r(ac) && !y(ac)) {
                  H149.j(cj.getLuaStateNativeRef(), (float)var3 * 0.001F);
               }

               Lb33.d(Lb33.UpdateGameplayStates);
               var55 = false;
            } finally {
               if (var55) {
                  Lb33.d(Lb33.UpdateGameplayStates);
               }
            }

            Lb33.g(Lb33.zGamedrawmain);
            boolean var47 = false;

            try {
               var47 = true;
               if (ac == 11) {
                  bo(0, 0, GameShell3.canvasWid, GameShell3.canvasHei);
               }

               if (GameShell3.fsframe == null) {
                  Container var79 = this.getTopContainer();
                  int var82 = var79.getSize().width;
                  int var7 = var79.getSize().height;
                  if (var79 == GameShell3.frame) {
                     Insets var8 = GameShell3.frame.getInsets();
                     var82 -= var8.left + var8.right;
                     var7 -= var8.top + var8.bottom;
                  }

                  if (var82 != GameShell3.frameWid || var7 != GameShell3.frameHei) {
                     GameShell3.frameWid = var82;
                     GameShell3.frameHei = var7;
                     ir = Gz143.g() + 500L;
                     bt = false;
                     aq();
                  }
               }

               if (Hq338.g && GameShell3.fsframe != null && v(ac)) {
                  f(W159.g().j, -1, -1, false);
               }

               B665.q(B665.g());
               boolean var80 = false;
               if (GameShell3.fullredraw) {
                  GameShell3.fullredraw = false;
                  var80 = true;
               }

               if (e && GameShell3.focus && !bh) {
                  nativeSetFocus();
               }

               bh = GameShell3.focus;
               if (var80) {
                  al();
               }

               if (r(ac)) {
                  if (this.cq == null) {
                     this.cq = new B402();
                     this.cq.d(GameShell3.canvas, Load.w(), GameShell3.canvasWid, GameShell3.canvasHei, this.cc(this.cq.g()));
                  } else {
                     B402.j(this.cq, GameShell3.canvas, Load.w(), GameShell3.canvasWid, GameShell3.canvasHei);
                  }
               } else {
                  if (this.cq != null) {
                     B402.q(this.cq);
                     this.cq = null;
                  }

                  if (x(ac)) {
                     bm();
                  } else if (ac == 11) {
                     bq(var3);
                  }
               }

               Lb33.d(Lb33.zGamedrawmain);
               var47 = false;
            } finally {
               if (var47) {
                  Lb33.d(Lb33.zGamedrawmain);
               }
            }

            Lb33.g(Lb33.zNavPower);
            boolean var39 = false;

            try {
               var39 = true;
               if (ni.g != null) {
                  for(int var83 = 0; var83 < Jh522.g(ni.g); ++var83) {
                     byte[] var84 = Jh522.q(ni.g, var83);
                     if (var84.length > 0) {
                        if (nc == null || nc.capacity() < var84.length) {
                           nc = ByteBuffer.allocateDirect(var84.length);
                        }

                        nc.position(0);
                        nc.put(var84);
                        NavPowerClient.renderFromRenderData(nc, var84.length, (float)(-gn), (float)(-gj));
                     }
                  }
               }

               Lb33.d(Lb33.zNavPower);
               var39 = false;
            } finally {
               if (var39) {
                  Lb33.d(Lb33.zNavPower);
               }
            }

            Lb33.g(Lb33.zNativeRender);
            boolean var31 = false;

            try {
               var31 = true;
               if (debugconsole.isopen()) {
                  debugconsole.w();
               }

               int var10000 = ac;
               int var10001 = ac;
               if (dp) {
                  bl(20, 20);
               }

               ScriptCamera var85 = ScriptCamera.getActiveCamera();
               float var86 = 0.0F;
               float var87 = 0.0F;
               float var88 = 0.0F;
               float var9 = 0.0F;
               float var10 = 0.0F;
               float var11 = 0.0F;
               if (var85 != null) {
                  var86 = var85.i;
                  var87 = var85.o;
                  var88 = var85.c;
                  var9 = var85.a;
                  var10 = var85.ag;
                  var11 = var85.f;
               }

               player var12 = Gc330.j();
               ArrayList var13 = new ArrayList();
               if (var12 != null) {
                  w(var13, var12);
               }

               Collection var14 = l();
               H149.e(ax, ar, mg != null ? mg.d : null, (float)var3 * 0.001F, var86, var87, var88, var9, var10, var11, var13, var14);
               if (bg) {
                  am();
               }

               Lb33.d(Lb33.zNativeRender);
               var31 = false;
            } finally {
               if (var31) {
                  Lb33.d(Lb33.zNativeRender);
               }
            }

            Lb33.d(Lb33.MainRedraw);
         }
      } finally {
         Lb33.d(Lb33.MainRedraw);
      }
   }

   private static Collection l() {
      if (gz.d == null) {
         return null;
      } else {
         GameEntity[] var0 = gz.d.getEntitiesInSphere(bq, bw, Gn5.PLAYER_OR_NPC_VOLUME_QUERY.ordinal(), Gj16.NONE.az, 128);
         ArrayList var1 = new ArrayList();
         player var2 = Gc330.j();
         GameEntity[] var3 = var0;
         int var4 = var0.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            GameEntity var6 = var3[var5];
            if (var6 != var2 && (GameEntity.ee(var6, PlayerComponent.class) || GameEntity.ee(var6, NpcComponent.class))) {
               w(var1, var6);
            }
         }

         return var1;
      }
   }

   static {
      ar = Matrix4.g;
      ax = new H303();
      au = new H303();
      ad = 0L;
      ae = true;
      bd = null;
      bm = Matrix4.g;
      bq = Vector3.g;
      bo = Matrix4.g;
      bl = Matrix4.g;
      bj = 0;
      bk = true;
      bh = false;
      bp = true;
      bx = false;
      by = false;
      bv = 0;
      bg = false;
      bb = false;
      ba = true;
      bi = (long)(Math.random() * 9.999999999E9D);
      bt = false;
      bz = 0;
      bc = false;
      cw = true;
      cp = 0;
      cd = 0;
      ck = new ArrayList();
      ce = new ArrayList();
      ca = new IdentityHashMap();
      cv = new ArrayDeque();
      cl = false;
      cb = -1L;
      cm = -1L;
      cg = -1;
      ct = -1;
      cc = -1L;
      cx = new Color[]{new Color(9179409), new Color(3289650), new Color(3289650), new Color(3289650)};
      cy = new Color[]{new Color(9179409), new Color(16777215), new Color(16726277), new Color(16726277)};
      co = new Color[]{new Color(16777215), new Color(16777215), new Color(16741381), new Color(16741381)};
      cr = null;
      cu = false;
      cz = false;
      cn = false;
      cs = false;
      cf = false;
      dn = false;
      dp = false;
      dv = null;
      df = 0;
      do_ = false;
      de = null;
      dh = null;
      dw = null;
      dq = new LossyStateStreamSynchronizer();
      du = false;
      dl = false;
      dc = new G408();
      ds = new C414();
      dk = 0;
      di = 0.0F;
      dx = new S136[Js5Archive.getRequiredArrayLength()];
      eo = null;
      ev = 0;
      ex = new Eq28(8);
      ed = null;
      ew = new Af666();
      fb = 0;
      fk = Go485.NONE;
      fj = 0;
      fg = 0;
      fw = false;
      ft = new HashMap();
      fx = new N272();
      fe = 0;
      ff = false;
      gq = -1.0F;
      gp = 104;
      gy = 104;
      gh = 1.0F;
      gf = new Bv351();
      gc = false;
      gt = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      gz = new Ll42();
      gk = false;
      gs = new int[4096];
      gg = new int[4096];
      gl = new int[50];
      go = new int[50];
      ge = new int[]{-1, 8192, 0, -1, 12288, 10240, 14336, -1, 4096, 6144, 2048};
      gw = 0;
      gm = 2;
      gx = 0;
      gr = 2;
      hn = 0;
      hb = 1;
      hr = 0;
      hj = 0;
      hx = 2;
      ho = 0;
      ht = 1;
      hu = 0;
      hl = new Random();
      hf = 0;
      hq = 5000;
      hw = 0.0F;
      hd = 0;
      hv = 0;
      he = new Hb335();
      hz = 0;
      hs = new float[3];
      hk = 0;
      hh = 0;
      hc = 0;
      hp = 0;
      hm = 0;
      ir = 0L;
      id = true;
      ii = 765;
      iq = 503;
      ib = 32;
      ij = 16;
      ip = false;
      il = false;
      ik = 0;
      in = 0;
      ic = false;
      iw = false;
      ig = false;
      if_ = false;
      iu = true;
      io = false;
      jb = new Hb335();
      ja = -1;
      jj = -1;
      ji = new Ha262(8);
      jx = 0;
      jk = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      je = 0;
      jn = 0;
      jh = new long[100];
      jp = 0;
      ju = null;
      jv = null;
      kf = null;
      ki = 0;
      kl = 0;
      ke = 0;
      ks = 0;
      kt = 0;
      ku = new ClientFriendListComponent();
      kb = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      ka = false;
      kx = true;
      kn = (float)Lq191.g();
      kc = 0.0D;
      kp = 99999.0D;
      kq = 0.0D;
      ky = 0.0D;
      ld = 0.0D;
      lo = 0.0D;
      ln = 0;
      ll = 0L;
      lz = RotTrans.g;
      lh = new Hi86(Integer.class);
      lw = new Hk84();
      lj = 0L;
      la = false;
      lv = false;
      lt = -1.0F;
      lb = -1.0F;
      lm = false;
      lq = new G284();
      ls = new G284();
      lx = true;
      lf = true;
      lr = true;
      lp = true;
      lc = false;
      lk = true;
      le = 0;
      li = new float[200];
      ly = new int[200];
      md = new float[200];
      me = new int[200];
      mj = new float[200];
      mw = 0;
      ms = true;
      mf = new int[]{0, 1, 1, 5, 5, 4, 4, 0, 2, 6, 6, 7, 7, 3, 3, 2, 0, 2, 4, 6, 5, 7, 1, 3};
      mz = new float[4];
      mk = new float[4];
      mq = new float[4];
      mi = new float[8];
      mv = new float[8];
      mx = new float[8];
      mp = 0;
      ml = 0;
      mc = true;
      mo = new int[4];
      ni = new Jp534();
      ng = 0L;
      nw = 0;
      nh = null;
   }

   public static final void q(String[] var0, client var1) {
      try {
         System.setErr(System.out);
         Lf336.j = new Lx337();

         try {
            Lf336.j.g = Integer.parseInt(var0[0]);
            Lf336.j.d = A412.b;
         } catch (NumberFormatException var4) {
            String[] var3 = StringTools.y(var0[0], ':');
            if (var3.length != 2) {
               throw new Exception("Invalid server address - should be of the form host-name:node-id");
            }

            Lf336.d = var3[0];
            Lf336.j.g = Integer.parseInt(var3[1]);
            Lf336.j.d = Lf336.d;
         }

         t = D123.LOCAL;
         if (var0[3].equals("live")) {
            z = Gm479.LIVE;
         }

         if (var0[3].equals("buildlive")) {
            z = Gm479.BUILDLIVE;
         } else if (var0[3].equals("rc")) {
            z = Gm479.RC;
         } else if (var0[3].equals("wip")) {
            z = Gm479.WIP;
         } else {
            j("modewhat");
         }

         n = Language.q(var0[4]);
         if (n == null) {
            if (var0[4].equals("english")) {
               n = Language.EN;
            } else if (var0[4].equals("german")) {
               n = Language.DE;
            } else {
               j("language");
            }
         }

         k = false;
         if (var0[5].equals("game0")) {
            m = Gd27.RUNESCAPE;
         } else if (var0[5].equals("game1")) {
            m = Gd27.STELLARDAWN;
         } else if (var0[5].equals("game2")) {
            m = Gd27.ALTERNATEREALITY;
         } else if (var0[5].equals("game3")) {
            m = Gd27.TRANSFORMERS;
         } else if (var0[5].equals("game4")) {
            m = Gd27.SCRATCH;
         } else {
            j("game");
         }

         az = true;
         ip = true;
         System.loadLibrary("jawt");
         boolean var2 = false;
         if (System.getProperty("jagex.useCache") != null) {
            var2 = Boolean.parseBoolean(System.getProperty("jagex.useCache"));
         }

         bu = var1;
         var1.startApplication(1280, 720, m.h, z.h, 32 + z.s, Js5Archive.getRequiredArrayLength(), var2, 1, 1);
         GameShell3.frame.setLocation(40, 40);
      } catch (Exception var5) {
         Ku323.g((String)null, var5);
      }

   }

   public static boolean v(int var0) {
      return var0 == 3 || var0 == 11;
   }

   public static boolean y(int var0) {
      return var0 == 4 || var0 == 12;
   }

   public static boolean p(int var0) {
      return var0 == 3 || var0 == 4 || var0 == 6;
   }

   public static void z(int var0) {
      if (ac != var0) {
         ac = var0;
         String var1 = null;
         switch(var0) {
         case 3:
            var1 = "loginscreen";
            break;
         case 4:
            var1 = "buildingmap";
         case 5:
         case 7:
         case 8:
         case 9:
         case 10:
         case 13:
         default:
            break;
         case 6:
            var1 = "login";
            break;
         case 11:
            var1 = "game";
            break;
         case 12:
            var1 = "buildmap";
            break;
         case 14:
            var1 = "reconnect";
            break;
         case 15:
            var1 = "switchworld";
            break;
         case 16:
            var1 = "error";
         }

         cj.event.triggerEvent((String)"__onLoadState", var1);
         logger.debug("Mainstate: {} {}", ab[var0], Gz143.g());
         if (var0 == 14) {
            Login.q();
         }

         if (var0 == 15) {
            Login.d();
         }

         if (var0 == 13) {
            Login.g();
         }

         if (var0 != 14 && fr != null) {
            fr.h();
            fr = null;
         }

         if (var0 == 3) {
            k();
         }

         if (y(ac)) {
            dr.m = 2;
            et.m = 2;
            if (F511.e(at)) {
               F511.g(at);
            }

            if (!F511.j(at)) {
               F511.d(at);
               Z132.g("MapBuildState_" + F511.h(at));
            }
         }

         if (y(var0)) {
            dr.m = 1;
            et.m = 1;
         }

         if (var0 == 12 || var0 == 3) {
            G405.d(bu, getEnvironment());
         }

      }
   }

   public static void t(client var0, float var1) {
      Lb33.g(Lb33.NetClient);

      try {
         boolean var2 = dm.s();
         if (!var2) {
            var0.m(var1);
         }

         Lb33.d(Lb33.NetClient);
      } finally {
         Lb33.d(Lb33.NetClient);
      }
   }

   public void m(float var1) {
      if (dm.u > ev) {
         logger.debug("Js5connect error: {}", dm.z);
         Lx337.q(Lf336.q);
         di = (float)(dm.u - 1) * 5.0F;
         if (di > 60.0F) {
            di = 60.0F;
         }

         if (dm.u >= 2 && dm.z == Mf509.CLIENT_OUT_OF_DATE.getId()) {
            this.error("js5connect_outofdate");
            z(16);
            return;
         }

         if (dm.u >= 4 && dm.z == -1) {
            this.error("js5crc");
            z(16);
            return;
         }

         if (dm.u >= 4 && r(ac)) {
            if (dm.z != Mf509.SERVER_FULL.getId() && dm.z != Mf509.IP_LIMIT.getId()) {
               if (dm.z > 0) {
                  if (ed == null) {
                     this.error("js5connect");
                  } else {
                     this.error("js5proxy_" + ed.trim());
                  }
               } else {
                  this.error("js5io");
               }
            } else {
               this.error("js5connect_full");
            }

            z(16);
            return;
         }
      }

      ev = dm.u;
      if (di > 0.0F) {
         di -= var1;
      } else {
         try {
            if (dk == 0) {
               logger.trace("Attempting js5remote connection on port: {}", Lx337.d(Lf336.q));
               ci = Lf336.q.g();
               ++dk;
            }

            if (dk == 1) {
               ch = Hx339.g(ci, 25000);
               Gg3 var2 = new Gg3(9);
               Gg3.k(var2, Ex582.INIT_JS5REMOTE_CONNECTION.w);
               Gg3.a(var2, 1);
               Gg3.a(var2, 1);
               ch.e(var2.r, 0, 9);
               ++dk;
               da = Gz143.g();
            }

            int var3;
            if (dk == 2) {
               if (ch.d(1)) {
                  byte[] var7 = new byte[1];
                  var3 = ch.j(var7, 0, 1);
                  if (var7[0] != 0) {
                     n(this, var3);
                     return;
                  }

                  logger.trace("Js5connect ok: {}", var3);
                  ++dk;
               } else if (Gz143.g() - da > 30000L) {
                  n(this, 1001);
                  return;
               }
            }

            if (dk == 3) {
               Ja527[] var8 = Ja527.values();
               var3 = var8.length * 4;
               if (ch.d(var3)) {
                  Gg3 var4 = new Gg3(var3);
                  ch.j(var4.r, 0, var4.r.length);

                  for(int var5 = 0; var5 < var8.length; ++var5) {
                     Ja527.d(var8[var5], Gg3.bd(var4));
                  }

                  boolean var9 = r(ac) || p(ac);
                  W144.b(dm, ch, !var9);
                  ci = null;
                  ch = null;
                  dk = 0;
               }
            }
         } catch (IOException var6) {
            logger.error("", var6);
            n(this, 1002);
         }

      }
   }

   public static void n(client var0, int var1) {
      ci = null;
      ch = null;
      dk = 0;
      ++dm.u;
      dm.z = var1;
   }

   public static N272 i() {
      return fx;
   }

   public static void o() {
      if (H149.y) {
         Graphics.resetFromCanvas(GameShell3.canvas, 0, 0, 2, 0, 0, 0);
         H149.p = GameShell3.canvasWid;
         H149.x = GameShell3.canvasHei;
      }

   }

   public static J160 a() {
      if (Hq338.g && GameShell3.fsframe != null) {
         return J160.FULLSCREEN;
      } else {
         return id ? J160.RESIZABLE : J160.SMALL;
      }
   }

   public static void f(J160 var0, int var1, int var2, boolean var3) {
      ir = 0L;
      J160 var4 = a();
      if (var0 == J160.FULLSCREEN || var4 == J160.FULLSCREEN) {
         var3 = true;
      }

      var3 = true;
      c(var4, var0, var1, var2, var3);
   }

   public static final float bh(float var0, float var1) {
      if (mm == null) {
         return 0.0F;
      } else {
         float var2 = var0 / 4.0F;
         float var3 = var1 / 4.0F;
         if (var2 >= 0.0F && var3 >= 0.0F && var2 <= (float)(gp - 1) && var3 <= (float)(gy - 1)) {
            float var4 = var0 + (float)gn;
            float var5 = var1 + (float)gj;
            float var6 = gz.d.d.ao(var4, var5);
            return var6;
         } else {
            return 0.0F;
         }
      }
   }

   public static void ag() {
      El328 var0 = El328.d(Eu326.WINDOW_STATUS, fx.s);
      Gs329.k(var0.q, a().getId());
      Gs329.i(var0.q, GameShell3.canvasWid);
      Gs329.i(var0.q, GameShell3.canvasHei);
      Gs329.k(var0.q, W159.g().q);
      N272.e(fx, var0);
   }

   public void cyclestart(boolean var1) {
      Lv148.g(var1);
   }

   private static void ai() {
      GameShell3.canvasWid = GameShell3.frameWid;
      GameShell3.leftMargin = 0;
      GameShell3.canvasHei = GameShell3.frameHei;
      GameShell3.topMargin = 0;
   }

   public static void al() {
      if (GameShell3.fsframe == null) {
         int var0 = GameShell3.leftMargin;
         int var1 = GameShell3.topMargin;
         int var2 = GameShell3.frameWid - GameShell3.canvasWid - var0;
         int var3 = GameShell3.frameHei - GameShell3.canvasHei - var1;
         if (var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
            try {
               Container var4 = bu.getTopContainer();
               int var5 = 0;
               int var6 = 0;
               if (var4 == GameShell3.frame) {
                  Insets var7 = GameShell3.frame.getInsets();
                  var5 = var7.left;
                  var6 = var7.top;
               }

               java.awt.Graphics var9 = var4.getGraphics();
               var9.setColor(Color.black);
               if (var0 > 0) {
                  var9.fillRect(var5, var6, var0, GameShell3.frameHei);
               }

               if (var1 > 0) {
                  var9.fillRect(var5, var6, GameShell3.frameWid, var1);
               }

               if (var2 > 0) {
                  var9.fillRect(var5 + GameShell3.frameWid - var2, var6, var2, GameShell3.frameHei);
               }

               if (var3 > 0) {
                  var9.fillRect(var5, var6 + GameShell3.frameHei - var3, GameShell3.frameWid, var3);
               }
            } catch (Exception var8) {
               logger.error("", var8);
            }
         }

      }
   }

   public static void af(int var0) {
      if (!W159.g().b) {
         var0 = -1;
      }

      if (var0 != ja) {
         if (var0 != -1) {
            CursorType var1 = en.list(var0);
            Fj373 var2 = var1.getCursor();
            if (var2 != null) {
               GameShell3.mouseImp.g(GameShell3.canvas, Fj373.e(var2), Fj373.q(var2), Fj373.j(var2), new Point(var1.hotspotx, var1.hotspoty));
               ja = var0;
            } else {
               var0 = -1;
            }
         }

         if (var0 == -1 && ja != -1) {
            GameShell3.mouseImp.g(GameShell3.canvas, (int[])null, -1, -1, new Point());
            ja = -1;
         }

      }
   }

   public static final void av() {
      df = 0;
      ln = 0;
      ll = 0L;
      Lz409.r();
      gn = 0;
      gj = 0;
      gd = 0.0F;
      ga = 0.0F;
      Gc330.g();
      ClientScriptAPI.setNativeSelfGameEntity(cj.getScriptManagerNativeRef(), cj.getLuaStateNativeRef(), (GameEntity)null);
      ft.clear();
      fe = 0;
      jw.d();
      kj = null;
      kv = null;
      ko = null;
      kh = null;
      dv = null;
   }

   public static final void ap() {
      player var0 = Gc330.j();
      if (var0 != null) {
         cj.event.triggerEvent((String)"__onLogout", var0);
      }

      LuaNativeEvents.detachAllEventHandlers(cj.getLuaStateNativeRef());
      G451.j();
      N272.s(fx);
      Login.e();
      ac();
      W667.g(2);
      SoundManager.p = -1;
      SoundManager.x = false;
      SoundManager.o();
      At476.g(true);
      av();
      if (mm != null) {
         Scene.u(mm);
         mm = null;
      }

      mg = null;
      bk();
      J570.q();
      System.gc();
      z(3);

      try {
         Mu209.g(bu, "loggedout");
      } catch (Throwable var2) {
      }

   }

   private static void bi() {
      Bn279 var0;
      while((var0 = gf.g()) != null) {
         try {
            ((H393)var0.d()).g();
         } catch (Exception var2) {
            logger.error("", var2);
         }
      }

   }

   public static void ab() {
      Is139 var0 = openPrefs("2", m.h, true);
      jr.j(var0);
   }

   public static final void aw(client var0) {
      Lb33.g(Lb33.NotLoggedInLoop);

      try {
         aj();
         SoundManager.v();
         ++hf;
         if (mm != null) {
            bi();
            Scene.z(mm, 0.02F);
         }

         if (bj % 1500 == 0) {
            G405.d(bu, getEnvironment());
         }

         if (jr.q && jr.j < Gz143.g() - 60000L) {
            ab();
         }

         ku.j.b();
         Lb33.d(Lb33.NotLoggedInLoop);
      } finally {
         Lb33.d(Lb33.NotLoggedInLoop);
      }
   }

   public static native void initNative();

   @Be2
   @Bs1
   public static void nativeKeyboardInput(int var0) {
      if (var0 != 0 && fx != null && fx.s != null) {
         long var1 = (Gz143.g() - cc) / 50L;
         if (var1 > 65535L) {
            var1 = 65535L;
         }

         cc = Gz143.g();
         El328 var3 = El328.d(Eu326.EVENT_KEYBOARD, fx.s);
         Gs329.k(var3.q, 3);
         Gs329.k(var3.q, var0);
         Gs329.i(var3.q, (int)var1);
         N272.e(fx, var3);
      }

   }

   public static void b(client var0) {
      boolean var1 = W667.d();
      if (var1 && SoundManager.x && SoundManager.y != null) {
         SoundManager.y.q();
      }

   }

   @Be2
   @Bs1
   public static void nativeMouseInputClick(int var0, int var1, int var2) {
      if (fx.s != null) {
         long var3 = (Gz143.g() - cb) / 50L;
         if (var3 > 32767L) {
            var3 = 32767L;
         }

         cb = Gz143.g();
         if (var2 < 0) {
            var2 = 0;
         } else if (var2 > 65535) {
            var2 = 65535;
         }

         if (var1 < 0) {
            var1 = 0;
         } else if (var1 > 65535) {
            var1 = 65535;
         }

         int var5 = (int)var3;

         assert var0 >= 0 && var0 <= 9;

         El328 var6 = El328.d(Eu326.EVENT_MOUSE_CLICK, fx.s);
         Gs329.a(var6.q, var1 | var2 << 16);
         Gs329.i(var6.q, var5 | var0 << 15);
         N272.e(fx, var6);
      }

   }

   @Jv532
   public static final void ar(float var0) {
      Lb33.g(Lb33.GameLoop);

      try {
         if (fx.o) {
            fx.o = false;
            at();
            Lb33.d(Lb33.GameLoop);
         } else {
            Lb33.g(Lb33.TCPin);
            boolean var28 = false;

            int var1;
            try {
               var28 = true;
               var1 = 0;

               while(true) {
                  if (var1 >= 100 || !be(fx)) {
                     Lb33.d(Lb33.TCPin);
                     var28 = false;
                     break;
                  }

                  ++var1;
               }
            } finally {
               if (var28) {
                  Lb33.d(Lb33.TCPin);
               }
            }

            SoundManager.v();
            if (ac != 11) {
               Lb33.d(Lb33.GameLoop);
            } else {
               Lb33.g(Lb33.ReflectionReceiver);

               El328 var34;
               int var2;
               while(true) {
                  boolean var22 = false;

                  try {
                     var22 = true;
                     if (!Ji520.d()) {
                        Lb33.d(Lb33.ReflectionReceiver);
                        var22 = false;
                        break;
                     }

                     var34 = El328.d(Eu326.REFLECTION_CHECK_REPLY, fx.s);
                     Gs329.k(var34.q, 0);
                     var2 = var34.q.v;
                     Ji520.q(var34.q);
                     Gs329.ac(var34.q, var34.q.v - var2);
                     N272.e(fx, var34);
                  } finally {
                     if (var22) {
                        Lb33.d(Lb33.ReflectionReceiver);
                     }
                  }
               }

               if (GameShell3.focus != bk) {
                  bk = GameShell3.focus;
                  var34 = El328.d(Eu326.EVENT_APPLET_FOCUS, fx.s);
                  Gs329.k(var34.q, GameShell3.focus ? 1 : 0);
                  N272.e(fx, var34);
               }

               if (ac != 11) {
                  Lb33.d(Lb33.GameLoop);
               } else {
                  N272 var10000 = fx;
                  var10000.p += var0;
                  if (fx.p > 15.0F) {
                     logger.error("Lost connection due to timeout.\tReconnecting....");
                     at();
                     Lb33.d(Lb33.GameLoop);
                  } else {
                     if (mm != null) {
                        Lb33.g(Lb33.WorldProcess);
                        boolean var16 = false;

                        try {
                           var16 = true;
                           bi();
                           Scene.z(mm, var0);
                           Scene.k(mm);
                           Iterator var35 = mm.x(AnimationGraphComponent.class).iterator();

                           while(var35.hasNext()) {
                              AnimationGraphComponent var36 = (AnimationGraphComponent)var35.next();
                              var36.g(var0);
                           }

                           var35 = mm.x(SoundComponent.class).iterator();

                           while(var35.hasNext()) {
                              SoundComponent var37 = (SoundComponent)var35.next();
                              SoundComponent.g(var37, var0);
                           }

                           var35 = mm.x(TimerComponent.class).iterator();

                           while(var35.hasNext()) {
                              TimerComponent var38 = (TimerComponent)var35.next();
                              TimerComponent.g(var38, var0);
                           }

                           var35 = mm.x(ProcessLogicEventComponent.class).iterator();

                           while(var35.hasNext()) {
                              ProcessLogicEventComponent var39 = (ProcessLogicEventComponent)var35.next();
                              ProcessLogicEventComponent.g(var39, var0);
                           }

                           Scene.i(mm);
                           Lb33.d(Lb33.WorldProcess);
                           var16 = false;
                        } finally {
                           if (var16) {
                              Lb33.d(Lb33.WorldProcess);
                           }
                        }
                     }

                     ClientScriptMessaging.d(fx);
                     Gf474.w();
                     bd();
                     aj();

                     for(var1 = 0; var1 < hd; ++var1) {
                        if (bv > 1) {
                           --bv;
                        }

                        ++hf;
                        if (hp != 0) {
                           hc += 20;
                           if (hc >= 400) {
                              hp = 0;
                           }
                        }

                        ax();
                     }

                     if (jr.q && jr.j < Gz143.g() - 60000L) {
                        ab();
                     }

                     ku.j.b();
                     ++hr;
                     if (hr > 500) {
                        hr = 0;
                        var1 = (int)(Math.random() * 8.0D);
                        if ((var1 & 1) == 1) {
                           gw += gm;
                        }

                        if ((var1 & 2) == 2) {
                           gx += gr;
                        }

                        if ((var1 & 4) == 4) {
                           hn += hb;
                        }
                     }

                     if (gw < -50) {
                        gm = 2;
                     }

                     if (gw > 50) {
                        gm = -2;
                     }

                     if (gx < -55) {
                        gr = 2;
                     }

                     if (gx > 55) {
                        gr = -2;
                     }

                     if (hn < -40) {
                        hb = 1;
                     }

                     if (hn > 40) {
                        hb = -1;
                     }

                     ++hu;
                     if (hu > 500) {
                        hu = 0;
                        var1 = (int)(Math.random() * 8.0D);
                        if ((var1 & 1) == 1) {
                           hj += hx;
                        }

                        if ((var1 & 2) == 2) {
                           ho += ht;
                        }
                     }

                     if (hj < -60) {
                        hx = 2;
                     }

                     if (hj > 60) {
                        hx = -2;
                     }

                     if (ho < -20) {
                        ht = 1;
                     }

                     if (ho > 10) {
                        ht = -1;
                     }

                     if (ff) {
                        cb();
                        ff = false;
                     }

                     try {
                        fx.j();
                     } catch (IOException var29) {
                        logger.error("Connection failure when flushing. Reconnecting....", var29);
                        at();
                     }

                     if (cf) {
                        bw();
                     }

                     if (Y192.e) {
                        while(Y192.j()) {
                           var34 = El328.d(Eu326.PHYSICSCONTROLDEBUGGER_STATE, fx.s);
                           Gs329.i(var34.q, 0);
                           var2 = var34.q.v;
                           if (Y192.e(var34.q)) {
                              Gs329.as(var34.q, var34.q.v - var2);
                              N272.e(fx, var34);
                           }
                        }
                     }

                     Lb33.d(Lb33.GameLoop);
                  }
               }
            }
         }
      } finally {
         Lb33.d(Lb33.GameLoop);
      }
   }

   private static void ax() {
      long var0 = System.currentTimeMillis();
      if (var0 - N272.g(fx) > 1000L) {
         El328 var2 = El328.d(Eu326.NO_TIMEOUT, fx.s);
         N272.e(fx, var2);
         N272.d(fx, var0);
      }

   }

   public static final void am() {
      fa.cacheClean(5);
      fl.cacheClean(5);
      fd.cacheClean(5);
      fi.cacheClean(5);
      fn.cacheClean(5);
      fm.cacheClean(5);
      fs.cacheClean(5);
      fh.cacheClean(5);
      en.cacheClean(5);
      Aw157.l(eq, 50);
      ex.h(5);
   }

   private static final boolean bs(N272 var0) throws IOException {
      Hx339 var1 = var0.q;
      Gs329 var2 = var0.b;
      if (var1 == null) {
         return false;
      } else {
         int var4;
         if (var0.r == null) {
            if (var0.y) {
               if (!var1.d(1)) {
                  return false;
               }

               var1.j(var0.b.r, 0, 1);
               ++var0.z;
               var0.p = 0.0F;
               var0.y = false;
            }

            var2.v = 0;
            if (Gs329.q(var2)) {
               if (!var1.d(1)) {
                  return false;
               }

               var1.j(var0.b.r, 1, 1);
               ++var0.z;
               var0.p = 0.0F;
            }

            var0.y = true;
            Ea395[] var3 = Ea395.values();
            var4 = Gs329.j(var2);
            if (var4 < 0 || var4 >= var3.length) {
               throw new IOException(var4 + " " + var2.v);
            }

            var0.r = var3[var4];
            var0.v = var0.r.dy;
         }

         if (var0.v == -1) {
            if (!var1.d(1)) {
               return false;
            }

            var1.j(var2.r, 0, 1);
            var0.v = var2.r[0] & 255;
            ++var0.z;
            var0.p = 0.0F;
         }

         if (var0.v == -2) {
            if (!var1.d(2)) {
               return false;
            }

            var1.j(var2.r, 0, 2);
            var2.v = 0;
            var0.v = Gs329.au(var2);
            var0.z += 2;
            var0.p = 0.0F;
         }

         if (var0.v > 0) {
            if (!var1.d(var0.v)) {
               return false;
            }

            var2.v = 0;
            var1.j(var2.r, 0, var0.v);
            var0.z += var0.v;
            var0.p = 0.0F;
         }

         var0.i = var0.k;
         var0.k = var0.n;
         var0.n = var0.r;
         logger.trace("Packet : " + var0.r.toString());
         if (var0.r == Ea395.REBUILD_NORMAL) {
            bp();
            var0.r = null;
            return false;
         } else if (var0.r == Ea395.LOGOUT_SWITCH_PLAYER) {
            ap.q = Gs329.bd(var2);
            z(13);
            var0.r = null;
            return true;
         } else if (var0.r == Ea395.LOGOUT) {
            logger.trace("logout");
            ap();
            var0.r = null;
            return false;
         } else {
            int var18;
            String var25;
            if (var0.r == Ea395.LOGOUT_TRANSFER) {
               var18 = Gs329.au(var2);
               var25 = Gs329.bk(var2);
               logger.trace("logout transfer to world " + var18 + " on " + var25);
               Lf336.g(var18, var25);
               z(15);
               var0.r = null;
               return false;
            } else if (var0.r == Ea395.UPDATE_REBOOT_TIMER) {
               bv = Gs329.au(var2) * 30;
               var0.r = null;
               return true;
            } else if (var0.r == Ea395.LAST_LOGIN_INFO) {
               var18 = Gs329.bd(var2);
               bn = InetAddress.getByAddress(new byte[]{(byte)(var18 >> 24 & 255), (byte)(var18 >> 16 & 255), (byte)(var18 >> 8 & 255), (byte)(var18 & 255)}).getHostName();
               var0.r = null;
               return true;
            } else if (var0.r == Ea395.UPDATE_DOB) {
               iy = Gs329.ad(var2);
               ic = Gs329.ar(var2) == 1;
               var0.r = null;
               return true;
            } else if (var0.r == Ea395.REFLECTION_CHECKER) {
               Ji520.j(var2, var0.v);
               var0.r = null;
               return true;
            } else if (var0.r == Ea395.PLAYER_INFO2) {
               Gc330.s(var2, var0.v);
               ++mw;
               var0.r = null;
               return true;
            } else if (var0.r == Ea395.TICK) {
               var18 = Gs329.bd(var2);
               kn = Gs329.bl(var2);
               if (!do_ || !la) {
                  df = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(var18, dz);
                  do_ = true;
               }

               ln = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(df, var18) - dz;
               ll = System.nanoTime();
               var0.r = null;
               return true;
            } else {
               int var21;
               String var34;
               String var47;
               String var51;
               if (var0.r == Ea395.MESSAGE_GAME) {
                  var18 = Gs329.br(var2);
                  var4 = Gs329.bd(var2);
                  var21 = Gs329.ar(var2);
                  var34 = "";
                  var47 = var34;
                  if ((var21 & 1) != 0) {
                     var34 = Gs329.bk(var2);
                     if ((var21 & 2) != 0) {
                        var47 = Gs329.bk(var2);
                     } else {
                        var47 = var34;
                     }
                  }

                  var51 = Gs329.bk(var2);
                  if (var18 == 99) {
                     debugconsole.addline(var51);
                     logger.info(var51);
                  } else if (var18 == 98) {
                     debugconsole.s(var51);
                  } else {
                     if (!var47.equals("") && cj(var47)) {
                        var0.r = null;
                        return true;
                     }

                     G232.q(var18, var4, var34, var47, var34, var51);
                  }

                  var0.r = null;
                  return true;
               } else {
                  int var6;
                  boolean var9;
                  String var26;
                  boolean var31;
                  boolean var33;
                  if (var0.r == Ea395.UPDATE_FRIENDLIST) {
                     while(var2.v < var0.v) {
                        var31 = Gs329.ar(var2) == 1;
                        var25 = Gs329.bk(var2);
                        var26 = Gs329.bk(var2);
                        var6 = Gs329.au(var2);
                        var33 = Gs329.ar(var2) == 1;
                        var51 = "";
                        var9 = false;
                        if (var6 > 0) {
                           var51 = Gs329.bk(var2);
                           var9 = Gs329.ar(var2) == 1;
                        }

                        logger.error("Got friend: " + var25 + " world:" + var6 + " samegame:" + var9);
                        ku.j.j(var31, var25, var26, var6, var51, var9, var33);
                     }

                     ClientFriendListComponent.g(ku, true);
                     LuaNativeEvents.invokeOnClientFriendListUpdate(cj.getLuaStateNativeRef());
                     var0.r = null;
                     return true;
                  } else {
                     int var11;
                     int var12;
                     boolean var29;
                     int var40;
                     int var44;
                     int var50;
                     if (var0.r == Ea395.UPDATE_INV_PARTIAL) {
                        var18 = Gs329.au(var2);
                        var4 = Gs329.ar(var2);
                        var29 = (var4 & 1) == 1;
                        logger.trace("Received inventory update for inventory: " + var18 + " other player?: " + var29);
                        ArrayList var46 = var29 ? null : new ArrayList(0);
                        ClientInventory var58 = G451.d(var18, var29);

                        while(var2.v < var0.v) {
                           var40 = Gs329.br(var2);
                           var44 = Gs329.au(var2);
                           var50 = 0;
                           if (var44 != 0) {
                              var50 = Gs329.ar(var2);
                              if (var50 == 255) {
                                 var50 = Gs329.bd(var2);
                              }
                           }

                           var58.g(var40, var44 - 1, var50);
                           if (var44 != 0) {
                              var11 = Gs329.ar(var2);

                              for(var12 = 0; var12 < var11; ++var12) {
                                 Kr260 var73 = fi.decodeVarValue(var2);
                                 var58.q(var40, var73.g, var73.d);
                              }
                           }

                           if (!var29) {
                              var46.add(var40);
                           }
                        }

                        var0.r = null;
                        if (!var29) {
                           cw(new Y388(var58, var46));
                        }

                        return true;
                     } else {
                        int var41;
                        if (var0.r == Ea395.UPDATE_INV_FULL) {
                           var18 = Gs329.au(var2);
                           var4 = Gs329.ar(var2);
                           var29 = (var4 & 1) == 1;
                           logger.trace("Received full inventory for inventory: " + var18 + " other player?: " + var29);
                           ClientInventory var45 = G451.d(var18, var29);
                           ClientInventory.d(var45);

                           while(true) {
                              do {
                                 if (var2.v >= var0.v) {
                                    var0.r = null;
                                    if (!var29) {
                                       cw(new U406(var45));
                                    }

                                    return true;
                                 }

                                 var41 = Gs329.br(var2);
                                 var40 = Gs329.au(var2);
                                 var44 = 0;
                                 if (var40 != 0) {
                                    var44 = Gs329.ar(var2);
                                    if (var44 == 255) {
                                       var44 = Gs329.bd(var2);
                                    }
                                 }

                                 var45.g(var41, var40 - 1, var44);
                              } while(var40 == 0);

                              var50 = Gs329.ar(var2);

                              for(var11 = 0; var11 < var50; ++var11) {
                                 Kr260 var66 = fi.decodeVarValue(var2);
                                 var45.q(var41, var66.g, var66.d);
                              }
                           }
                        } else if (var0.r == Ea395.NPC_APPEARED) {
                           cp();
                           var0.r = null;
                           return true;
                        } else if (var0.r == Ea395.NPC_UPDATE) {
                           cd();
                           var0.r = null;
                           return true;
                        } else if (var0.r == Ea395.NPC_EXTENDED_STATE) {
                           ck();
                           var0.r = null;
                           return true;
                        } else if (var0.r == Ea395.NPC_GONE) {
                           ce();
                           var0.r = null;
                           return true;
                        } else if (var0.r == Ea395.VARCLAN) {
                           var18 = Gs329.au(var2);
                           if (js == null) {
                              js = new SparseVarDomain(fm);
                           }

                           Kr260 var80 = fm.decodeVarValue(var2);
                           js.varValues.s(var80.g, var80.d);
                           var0.r = null;
                           return true;
                        } else if (var0.r == Ea395.VARCLAN_ENABLE) {
                           js = new SparseVarDomain(fm);
                           var0.r = null;
                           return true;
                        } else if (var0.r == Ea395.VARCLAN_DISABLE) {
                           js = null;
                           var0.r = null;
                           return true;
                        } else {
                           byte var79;
                           if (var0.r == Ea395.VARP_SMALL) {
                              var18 = Gs329.au(var2);
                              var79 = Gs329.ax(var2);
                              logger.trace("Received small varp variable: " + var18 + " value:" + var79);
                              jw.q(fd.list(var18), var79);
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.VARP_LARGE) {
                              var18 = Gs329.au(var2);
                              var4 = Gs329.bd(var2);
                              logger.trace("Received big varp variable: " + var18 + " value:" + var4);
                              jw.q(fd.list(var18), var4);
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.VARBIT_SMALL) {
                              var18 = Gs329.au(var2);
                              var4 = Gs329.ar(var2);
                              logger.trace("Received small varbit variable: " + var18 + " value:" + var4);
                              Fw152.j(jw, fl.list(var18), var4);
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.VARBIT_LARGE) {
                              var18 = Gs329.au(var2);
                              var4 = Gs329.bd(var2);
                              logger.trace("Received big varbit variable: " + var18 + " value:" + var4);
                              Fw152.j(jw, fl.list(var18), var4);
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.CLIENT_SETVARC_SMALL) {
                              var18 = Gs329.au(var2);
                              var79 = Gs329.ax(var2);
                              logger.trace("client_setvarc (small) - var:" + var18 + " val:" + var79);
                              cl();
                              L410.j(var18, var79);
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.CLIENT_SETVARC_LARGE) {
                              var18 = Gs329.au(var2);
                              var4 = Gs329.bd(var2);
                              logger.trace("client_setvarc (large) - var:" + var18 + " val:" + var4);
                              cl();
                              L410.j(var18, var4);
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.CLIENT_SETVARCSTR_SMALL) {
                              var18 = Gs329.au(var2);
                              var25 = Gs329.bk(var2);
                              logger.trace("client_setvarcstr (small) - var:" + var18 + " val:" + var25);
                              cl();
                              L410.e(var18, var25);
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.CLIENT_SETVARCSTR_LARGE) {
                              var18 = Gs329.au(var2);
                              var25 = Gs329.bk(var2);
                              logger.trace("client_setvarcstr (large) - var:" + var18 + " val:" + var25);
                              cl();
                              L410.e(var18, var25);
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.SETDRAWORDER) {
                              var18 = Gs329.ar(var2);
                              cl();
                              hz = var18;
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.MIDI_SONG) {
                              var18 = Gs329.au(var2);
                              if (var18 == 65535) {
                                 var18 = -1;
                              }

                              var4 = Gs329.ar(var2);
                              var21 = Gs329.ar(var2);
                              SoundManager.t(var18, var4, var21);
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.MIDI_JINGLE) {
                              var18 = Gs329.au(var2);
                              if (var18 == 65535) {
                                 var18 = -1;
                              }

                              var4 = Gs329.ay(var2);
                              var21 = Gs329.ar(var2);
                              SoundManager.m(var18, var4, var21);
                              var0.r = null;
                              return true;
                           } else if (var0.r == Ea395.FMOD_PLAYSOUND) {
                              var18 = Gs329.bd(var2);
                              var4 = Gs329.ar(var2);
                              var26 = Gs329.bk(var2);
                              SoundManager.ag(var18, var4, var26);
                              var0.r = null;
                              return true;
                           } else {
                              String var22;
                              if (var0.r == Ea395.FMOD_STARTMUSIC) {
                                 var22 = Gs329.bk(var2);
                                 var25 = Gs329.bk(var2);
                                 logger.debug("Received StartMusic {}", var22);
                                 SoundManager.ap(var22, var25);
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.FMOD_STOPMUSIC) {
                                 logger.debug("Received StopMusic");
                                 SoundManager.ao();
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.FMOD_SETMUSICPARAMETER) {
                                 var22 = Gs329.bk(var2);
                                 SoundManager.aa(var22);
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.FMOD_PLAYAMBIENCE) {
                                 var22 = Gs329.bk(var2);
                                 var25 = Gs329.bk(var2);
                                 logger.debug("Received StartAmbience");
                                 SoundManager.am(var22, var25);
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.FMOD_STOPAMBIENCE) {
                                 logger.debug("Received StopAmbience");
                                 SoundManager.as();
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.FMOD_SETAMBIENCEPARAMETER) {
                                 var22 = Gs329.bk(var2);
                                 SoundManager.aa(var22);
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.FMOD_PRELOADBANK) {
                                 var22 = Gs329.bk(var2);
                                 SoundManager.ac(var22);
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.FMOD_MIXERPRESET) {
                                 var22 = Gs329.bk(var2);
                                 SoundManager.at(var22);
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.FMOD_STOPALLSOUNDS) {
                                 SoundManager.ab();
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.GENERIC_BROADCAST_STATE) {
                                 BroadcastStateAndEventsTypes$StatePayload var76 = new BroadcastStateAndEventsTypes$StatePayload();
                                 BroadcastStateAndEventsTypes$StateDefinition var74 = BroadcastStateAndEventsTransmission.UnpackStateMessage(var2, var76);
                                 player var78 = Gc330.j();
                                 logger.trace("BROADCAST_STATE with statedef: '" + var74 + "' / thisplayer: '" + var78 + "' / payload: '" + var76 + "'");
                                 if (var74 != null) {
                                    ck.add(new F407(var76.broadcasterID, var74, var76, var78));
                                 } else {
                                    logger.warn("um... couldn't build a StateDefinition from incoming state packet.");
                                 }

                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.GENERIC_BROADCAST_EVENT) {
                                 BroadcastStateAndEventsTypes$EventPayload var75 = new BroadcastStateAndEventsTypes$EventPayload();
                                 BroadcastStateAndEventsTypes$EventDefinition var71 = BroadcastStateAndEventsTransmission.UnpackEventMessage(var2, var75);
                                 if (var71 != null) {
                                    ck.add(new E413(var75.broadcasterID, var71, var75));
                                 }

                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.GENERIC_BROADCAST_GONE) {
                                 BroadcastStateAndEventsTypes$GonePayload var72 = BroadcastStateAndEventsTransmission.UnpackGoneMessage(var2);
                                 ck.add(new Aq668(var72.broadcasterID, var72));
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.GENERIC_BROADCAST_APPEARED) {
                                 BroadcastStateAndEventsTypes$AppearedPayload var69 = BroadcastStateAndEventsTransmission.UnpackAppearedMessage(var2);
                                 ck.add(new M411(var69.broadcasterID, var69));
                                 var0.r = null;
                                 return true;
                              } else if (var0.r == Ea395.GENERIC_BROADCAST_ATOMIC_END_MARKER) {
                                 if (y(ac)) {
                                    ce.addAll(ck);
                                 } else {
                                    Iterator var67 = ck.iterator();

                                    while(var67.hasNext()) {
                                       V385 var70 = (V385)var67.next();
                                       var70.j();
                                    }
                                 }

                                 ck.clear();
                                 var0.r = null;
                                 return true;
                              } else {
                                 boolean var27;
                                 if (var0.r == Ea395.UPDATE_IGNORELIST_PARTIAL) {
                                    var18 = Gs329.ar(var2);
                                    var27 = (var18 & 1) == 1;
                                    var26 = Gs329.bk(var2);
                                    var34 = Gs329.bk(var2);
                                    var47 = Gs329.bk(var2);
                                    var51 = Gs329.bk(var2);
                                    ku.e.g(var27, var26, var34, var47, var51, (var18 & 2) == 2);
                                    LuaNativeEvents.invokeOnClientFriendListUpdate(cj.getLuaStateNativeRef());
                                    var0.r = null;
                                    return true;
                                 } else if (var0.r == Ea395.MESSAGE_PUBLIC) {
                                    var18 = Gs329.au(var2);
                                    player var65 = Gc330.e(var18);
                                    if (var65 == null) {
                                       var0.r = null;
                                       return true;
                                    } else {
                                       var21 = Gs329.au(var2);
                                       var6 = Gs329.ar(var2);
                                       if (var65.ai != null) {
                                          var33 = false;
                                          if (var6 <= 1) {
                                             if ((!ic || iw) && !io) {
                                                if (cj(var65.ai)) {
                                                   var33 = true;
                                                }
                                             } else {
                                                var33 = true;
                                             }
                                          }

                                          if (!var33 && hm == 0) {
                                             byte var55 = -1;
                                             var51 = Et578.g(Af155.q(var2));
                                             byte var56;
                                             if (var6 != 1 && var6 != 2) {
                                                var56 = 2;
                                             } else {
                                                var56 = 1;
                                             }

                                             G232.j(var56, 0, var65.bi(true), player.bt(var65, false), var65.aq, var51, (String)null, var55);
                                          }
                                       }

                                       var0.r = null;
                                       return true;
                                    }
                                 } else {
                                    int var14;
                                    long var28;
                                    long var52;
                                    String var64;
                                    if (var0.r == Ea395.MESSAGE_PRIVATE) {
                                       var31 = Gs329.ar(var2) == 1;
                                       var25 = Gs329.bk(var2);
                                       var26 = var25;
                                       if (var31) {
                                          var26 = Gs329.bk(var2);
                                       }

                                       var28 = (long)Gs329.au(var2);
                                       var52 = (long)Gs329.ay(var2);
                                       var50 = Gs329.ar(var2);
                                       long var59 = (var28 << 32) + var52;
                                       boolean var63 = false;
                                       var14 = 0;

                                       while(true) {
                                          if (var14 >= 100) {
                                             if (var50 <= 1) {
                                                if ((!ic || iw) && !io) {
                                                   if (cj(var26)) {
                                                      var63 = true;
                                                   }
                                                } else {
                                                   var63 = true;
                                                }
                                             }
                                             break;
                                          }

                                          if (jh[var14] == var59) {
                                             var63 = true;
                                             break;
                                          }

                                          ++var14;
                                       }

                                       if (!var63 && hm == 0) {
                                          jh[jp] = var59;
                                          jp = (jp + 1) % 100;
                                          var64 = Et578.g(Af155.q(var2));
                                          if (var50 == 2) {
                                             G232.j(7, 0, A412.g(1) + var25, A412.g(1) + var26, var25, var64, (String)null, -1);
                                          } else if (var50 == 1) {
                                             G232.j(7, 0, A412.g(0) + var25, A412.g(0) + var26, var25, var64, (String)null, -1);
                                          } else {
                                             G232.j(3, 0, var25, var26, var25, var64, (String)null, -1);
                                          }
                                       }

                                       var0.r = null;
                                       return true;
                                    } else if (var0.r == Ea395.CHAT_FILTER_SETTINGS) {
                                       je = Gs329.ar(var2);
                                       jn = Gs329.ar(var2);
                                       var0.r = null;
                                       return true;
                                    } else if (var0.r == Ea395.CHAT_FILTER_SETTINGS_PRIVATECHAT) {
                                       jz = Hf380.g(Gs329.ar(var2));
                                       var0.r = null;
                                       return true;
                                    } else if (var0.r == Ea395.UPDATE_IGNORELIST_FULL) {
                                       D236.s(ku.e);
                                       var18 = Gs329.ar(var2);

                                       for(var4 = 0; var4 < var18; ++var4) {
                                          var26 = Gs329.bk(var2);
                                          var34 = Gs329.bk(var2);
                                          var47 = Gs329.bk(var2);
                                          var51 = Gs329.bk(var2);
                                          ku.e.g(false, var26, var34, var47, var51, false);
                                       }

                                       LuaNativeEvents.invokeOnClientFriendListUpdate(cj.getLuaStateNativeRef());
                                       var0.r = null;
                                       return true;
                                    } else if (var0.r == Ea395.SYNTH_SOUND) {
                                       var18 = Gs329.au(var2);
                                       if (var18 == 65535) {
                                          var18 = -1;
                                       }

                                       var4 = Gs329.ar(var2);
                                       var21 = Gs329.au(var2);
                                       var6 = Gs329.ar(var2);
                                       var41 = Gs329.au(var2);
                                       SoundManager.p(var18, var4, var21, var6, var41);
                                       var0.r = null;
                                       return true;
                                    } else if (var0.r == Ea395.VORBIS_SOUND) {
                                       var18 = Gs329.au(var2);
                                       if (var18 == 65535) {
                                          var18 = -1;
                                       }

                                       var4 = Gs329.ar(var2);
                                       var21 = Gs329.au(var2);
                                       var6 = Gs329.ar(var2);
                                       var41 = Gs329.au(var2);
                                       SoundManager.u(var18, var4, var21, var6, false, var41);
                                       var0.r = null;
                                       return true;
                                    } else if (var0.r == Ea395.VORBIS_SPEECH_SOUND) {
                                       var18 = Gs329.au(var2);
                                       if (var18 == 65535) {
                                          var18 = -1;
                                       }

                                       var4 = Gs329.ar(var2);
                                       var21 = Gs329.au(var2);
                                       var6 = Gs329.ar(var2);
                                       SoundManager.u(var18, var4, var21, var6, true, 256);
                                       var0.r = null;
                                       return true;
                                    } else if (var0.r == Ea395.VORBIS_SPEECH_STOP) {
                                       SoundManager.n();
                                       var0.r = null;
                                       return true;
                                    } else if (var0.r == Ea395.RESET_CLIENT_VARCACHE) {
                                       logger.trace("Resetting variables to 0 in preperation for full transmit");
                                       jw.d();
                                       var0.r = null;
                                       return true;
                                    } else if (var0.r == Ea395.MESSAGE_PRIVATE_ECHO) {
                                       var22 = Gs329.bk(var2);
                                       var25 = Et578.g(Af155.q(var2));
                                       G232.q(6, 0, var22, var22, var22, var25);
                                       var0.r = null;
                                       return true;
                                    } else if (var0.r == Ea395.UPDATE_INV_STOP_TRANSMIT) {
                                       var18 = Gs329.au(var2);
                                       var4 = Gs329.ar(var2);
                                       var29 = (var4 & 1) == 1;
                                       G451.q(var18, var29);
                                       var0.r = null;
                                       return true;
                                    } else {
                                       long var53;
                                       if (var0.r == Ea395.MESSAGE_FRIENDCHANNEL) {
                                          var31 = Gs329.ar(var2) == 1;
                                          var25 = Gs329.bk(var2);
                                          var26 = var25;
                                          if (var31) {
                                             var26 = Gs329.bk(var2);
                                          }

                                          var28 = Gs329.bq(var2);
                                          var52 = (long)Gs329.au(var2);
                                          var53 = (long)Gs329.ay(var2);
                                          var12 = Gs329.ar(var2);
                                          long var62 = (var52 << 32) + var53;
                                          boolean var68 = false;
                                          int var16 = 0;

                                          while(true) {
                                             if (var16 >= 100) {
                                                if (var12 <= 1) {
                                                   if ((!ic || iw) && !io) {
                                                      if (cj(var26)) {
                                                         var68 = true;
                                                      }
                                                   } else {
                                                      var68 = true;
                                                   }
                                                }
                                                break;
                                             }

                                             if (jh[var16] == var62) {
                                                var68 = true;
                                                break;
                                             }

                                             ++var16;
                                          }

                                          if (!var68 && hm == 0) {
                                             jh[jp] = var62;
                                             jp = (jp + 1) % 100;
                                             String var77 = Et578.g(Af155.q(var2));
                                             if (var12 != 2 && var12 != 3) {
                                                if (var12 == 1) {
                                                   G232.j(9, 0, A412.g(0) + var25, A412.g(0) + var26, var25, var77, Q280.d(var28), -1);
                                                } else {
                                                   G232.j(9, 0, var25, var26, var25, var77, Q280.d(var28), -1);
                                                }
                                             } else {
                                                G232.j(9, 0, A412.g(1) + var25, A412.g(1) + var26, var25, var77, Q280.d(var28), -1);
                                             }
                                          }

                                          var0.r = null;
                                          return true;
                                       } else if (var0.r == Ea395.MESSAGE_CLANCHANNEL) {
                                          var31 = Gs329.ar(var2) == 1;
                                          var25 = Gs329.bk(var2);
                                          long var57 = (long)Gs329.au(var2);
                                          long var38 = (long)Gs329.ay(var2);
                                          var44 = Gs329.ar(var2);
                                          var53 = (var57 << 32) + var38;
                                          boolean var60 = false;
                                          Dr574 var61 = null;
                                          var61 = var31 ? kh : ko;
                                          if (var61 == null) {
                                             var60 = true;
                                          } else {
                                             var14 = 0;

                                             while(true) {
                                                if (var14 >= 100) {
                                                   if (var44 <= 1) {
                                                      if ((!ic || iw) && !io) {
                                                         if (cj(var25)) {
                                                            var60 = true;
                                                         }
                                                      } else {
                                                         var60 = true;
                                                      }
                                                   }
                                                   break;
                                                }

                                                if (jh[var14] == var53) {
                                                   var60 = true;
                                                   break;
                                                }

                                                ++var14;
                                             }
                                          }

                                          if (!var60 && hm == 0) {
                                             jh[jp] = var53;
                                             jp = (jp + 1) % 100;
                                             var64 = Et578.g(Af155.q(var2));
                                             int var15 = var31 ? 41 : 44;
                                             if (var44 != 2 && var44 != 3) {
                                                if (var44 == 1) {
                                                   G232.j(var15, 0, A412.g(0) + var25, A412.g(0) + var25, var25, var64, var61.k, -1);
                                                } else {
                                                   G232.j(var15, 0, var25, var25, var25, var64, var61.k, -1);
                                                }
                                             } else {
                                                G232.j(var15, 0, A412.g(1) + var25, A412.g(1) + var25, var25, var64, var61.k, -1);
                                             }
                                          }

                                          var0.r = null;
                                          return true;
                                       } else if (var0.r == Ea395.MESSAGE_GROUP) {
                                          var31 = Gs329.ar(var2) == 1;
                                          var25 = Gs329.bk(var2);
                                          var26 = var25;
                                          if (var31) {
                                             var26 = Gs329.bk(var2);
                                          }

                                          var6 = Gs329.ar(var2);
                                          var33 = false;
                                          if (var6 <= 1) {
                                             if ((!ic || iw) && !io) {
                                                if (var6 <= 1 && cj(var26)) {
                                                   var33 = true;
                                                }
                                             } else {
                                                var33 = true;
                                             }
                                          }

                                          if (!var33 && hm == 0) {
                                             var51 = Et578.g(Af155.q(var2));
                                             if (var6 == 2) {
                                                G232.j(24, 0, A412.g(1) + var25, A412.g(1) + var26, var25, var51, (String)null, -1);
                                             } else if (var6 == 1) {
                                                G232.j(24, 0, A412.g(0) + var25, A412.g(0) + var26, var25, var51, (String)null, -1);
                                             } else {
                                                G232.j(24, 0, var25, var26, var25, var51, (String)null, -1);
                                             }
                                          }

                                          var0.r = null;
                                          return true;
                                       } else {
                                          Object[] var43;
                                          if (var0.r == Ea395.CLANCHANNEL_FULL) {
                                             var31 = Gs329.ar(var2) == 1;
                                             if (var0.v == 1) {
                                                logger.trace("Received ClanChannel RESET - affined:" + var31);
                                                if (var31) {
                                                   kh = null;
                                                } else {
                                                   ko = null;
                                                }

                                                var0.r = null;
                                                return true;
                                             } else {
                                                Dr574 var48;
                                                if (var31) {
                                                   var48 = kh = new Dr574(var2);
                                                } else {
                                                   var48 = ko = new Dr574(var2);
                                                }

                                                var43 = new Object[]{var31 ? "Affined" : "Listened", var48.n, var48.e()};
                                                logger.trace("\n{} ClanChannel received and set - updateNum: {}\n{}", var43);
                                                var0.r = null;
                                                return true;
                                             }
                                          } else if (var0.r == Ea395.CLANSETTINGS_FULL) {
                                             var31 = Gs329.ar(var2) == 1;
                                             if (var0.v == 1) {
                                                if (var31) {
                                                   kv = null;
                                                } else {
                                                   kj = null;
                                                }

                                                var0.r = null;
                                                return true;
                                             } else {
                                                Ef450 var42;
                                                if (var31) {
                                                   var42 = kv = new Ef450(var2);
                                                } else {
                                                   var42 = kj = new Ef450(var2);
                                                }

                                                var43 = new Object[]{var31 ? "Affined" : "Listened", var42.s, var42.u()};
                                                logger.trace("{} ClanRecord received and set - updateNum: {}\n{}", var43);
                                                var0.r = null;
                                                return true;
                                             }
                                          } else if (var0.r == Ea395.CLANCHANNEL_DELTA) {
                                             var31 = Gs329.ar(var2) == 1;
                                             Ee573 var39 = new Ee573(var2);
                                             Dr574 var35;
                                             if (var31) {
                                                var35 = kh;
                                             } else {
                                                var35 = ko;
                                             }

                                             var39.d(var35);
                                             logger.trace(var35.e());
                                             var0.r = null;
                                             return true;
                                          } else if (var0.r == Ea395.CLANSETTINGS_DELTA) {
                                             var31 = Gs329.ar(var2) == 1;
                                             Dg449 var37 = new Dg449(var2);
                                             Ef450 var30;
                                             if (var31) {
                                                var30 = kv;
                                             } else {
                                                var30 = kj;
                                             }

                                             var37.d(var30);
                                             logger.trace(var30.u());
                                             var0.r = null;
                                             return true;
                                          } else {
                                             boolean var8;
                                             if (var0.r == Ea395.UPDATE_FRIENDCHAT_CHANNEL_FULL) {
                                                if (var0.v == 0) {
                                                   ju = null;
                                                   jv = null;
                                                   kf = null;
                                                   km = 0;
                                                   kg = null;
                                                   var0.r = null;
                                                   return true;
                                                } else {
                                                   jv = Gs329.bk(var2);
                                                   var31 = Gs329.ar(var2) == 1;
                                                   if (var31) {
                                                      kf = Gs329.bk(var2);
                                                   } else {
                                                      kf = jv;
                                                   }

                                                   long var36 = Gs329.bq(var2);
                                                   ju = Q280.g(var36);
                                                   kr = Gs329.ax(var2);
                                                   logger.trace("CLANCHAT: Received full channel list for channel: {}, kickrank: {}", ju, kr);
                                                   var6 = Gs329.ar(var2);
                                                   if (var6 == 255) {
                                                      var0.r = null;
                                                      return true;
                                                   } else {
                                                      km = var6;
                                                      logger.trace("USERCOUNT={}", km);
                                                      Ah608[] var32 = new Ah608[100];

                                                      for(var40 = 0; var40 < km; ++var40) {
                                                         var32[var40] = new Ah608();
                                                         var32[var40].g = Gs329.bk(var2);
                                                         var31 = Gs329.ar(var2) == 1;
                                                         if (var31) {
                                                            var32[var40].d = Gs329.bk(var2);
                                                         } else {
                                                            var32[var40].d = var32[var40].g;
                                                         }

                                                         var32[var40].q = Md230.e(var32[var40].d, (Ly234)null);
                                                         var32[var40].j = Gs329.au(var2);
                                                         var32[var40].h = Gs329.ax(var2);
                                                         var32[var40].e = Gs329.bk(var2);
                                                         if (var32[var40].d.equals(Gc330.j().aq)) {
                                                            kz = var32[var40].h;
                                                         }
                                                      }

                                                      var8 = false;
                                                      var50 = km;

                                                      while(var50 > 0) {
                                                         var8 = true;
                                                         --var50;

                                                         for(var11 = 0; var11 < var50; ++var11) {
                                                            if (var32[var11].q.compareTo(var32[var11 + 1].q) > 0) {
                                                               Ah608 var54 = var32[var11];
                                                               var32[var11] = var32[var11 + 1];
                                                               var32[var11 + 1] = var54;
                                                               var8 = false;
                                                            }
                                                         }

                                                         if (var8) {
                                                            break;
                                                         }
                                                      }

                                                      kg = var32;
                                                      logger.trace("-=-=- CLANCHAT FULL CHANNEL UPDATE -=-=-");
                                                      logger.trace("usercount={}", km);

                                                      for(var11 = 0; var11 < km; ++var11) {
                                                         logger.trace("{} (w{})", kg[var11].d, kg[var11].j);
                                                      }

                                                      var0.r = null;
                                                      return true;
                                                   }
                                                }
                                             } else if (var0.r == Ea395.UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER) {
                                                var22 = Gs329.bk(var2);
                                                var29 = Gs329.ar(var2) == 1;
                                                if (var29) {
                                                   var25 = Gs329.bk(var2);
                                                } else {
                                                   var25 = var22;
                                                }

                                                var6 = Gs329.au(var2);
                                                byte var7 = Gs329.ax(var2);
                                                var8 = false;
                                                if (var7 == -128) {
                                                   var8 = true;
                                                }

                                                if (var8) {
                                                   if (km == 0) {
                                                      var0.r = null;
                                                      return true;
                                                   }

                                                   var9 = false;

                                                   for(var44 = 0; var44 < km && (!kg[var44].d.equals(var25) || kg[var44].j != var6); ++var44) {
                                                   }

                                                   if (var44 < km) {
                                                      while(var44 < km - 1) {
                                                         kg[var44] = kg[var44 + 1];
                                                         ++var44;
                                                      }

                                                      --km;
                                                      kg[km] = null;
                                                   }
                                                } else {
                                                   String var49 = Gs329.bk(var2);
                                                   Ah608 var10 = new Ah608();
                                                   var10.g = var22;
                                                   var10.d = var25;
                                                   var10.q = Md230.e(var10.d, (Ly234)null);
                                                   var10.j = var6;
                                                   var10.h = var7;
                                                   var10.e = var49;

                                                   for(var11 = km - 1; var11 >= 0; --var11) {
                                                      var12 = kg[var11].q.compareTo(var10.q);
                                                      if (var12 == 0) {
                                                         kg[var11].j = var6;
                                                         kg[var11].h = var7;
                                                         kg[var11].e = var49;
                                                         if (var25.equals(Gc330.j().aq)) {
                                                            kz = var7;
                                                         }

                                                         logger.trace("-=-=- CLANCHAT INCR+ CHANNEL UPDATE -=-=-");
                                                         logger.trace("usercount={}", km);

                                                         for(int var13 = 0; var13 < km; ++var13) {
                                                            logger.trace("{} (w{})", kg[var13].d, kg[var13].j);
                                                         }

                                                         var0.r = null;
                                                         return true;
                                                      }

                                                      if (var12 < 0) {
                                                         break;
                                                      }
                                                   }

                                                   if (km >= kg.length) {
                                                      var0.r = null;
                                                      return true;
                                                   }

                                                   for(var12 = km - 1; var12 > var11; --var12) {
                                                      kg[var12 + 1] = kg[var12];
                                                   }

                                                   if (km == 0) {
                                                      kg = new Ah608[100];
                                                   }

                                                   kg[var11 + 1] = var10;
                                                   ++km;
                                                   if (var25.equals(Gc330.j().aq)) {
                                                      kz = var7;
                                                   }
                                                }

                                                logger.trace("-=-=- CLANCHAT INCR+ CHANNEL UPDATE -=-=-");
                                                logger.trace("usercount={}", km);

                                                for(var44 = 0; var44 < km; ++var44) {
                                                   logger.trace("{} (w{})", kg[var44].d, kg[var44].j);
                                                }

                                                var0.r = null;
                                                return true;
                                             } else if (var0.r == Ea395.TRIGGER_ONDIALOGABORT) {
                                                var0.r = null;
                                                return true;
                                             } else if (var0.r == Ea395.UPDATE_UID192) {
                                                var2.v += 28;
                                                if (Gs329.bc(var2)) {
                                                   storeUID192(var2, var2.v - 28);
                                                }

                                                var0.r = null;
                                                return true;
                                             } else if (var0.r == Ea395.UPDATE_SITESETTINGS) {
                                                G405.g(o, bu, getEnvironment());
                                                var0.r = null;
                                                return true;
                                             } else {
                                                byte[] var24;
                                                if (var0.r == Ea395.URL_OPEN) {
                                                   if (Hq338.g && GameShell3.fsframe != null) {
                                                      f(W159.g().j, -1, -1, false);
                                                   }

                                                   var24 = new byte[var0.v - 1];
                                                   var27 = Gs329.ar(var2) == 1;
                                                   Gs329.e(var2, var24, 0, var0.v - 1);
                                                   var26 = J173.s(var24, 0, var0.v - 1);
                                                   Dp208.q(var26, true, false, ao, aa);
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.SOCIAL_NETWORK_LOGOUT) {
                                                   if (Hq338.g && GameShell3.fsframe != null) {
                                                      f(W159.g().j, -1, -1, false);
                                                   }

                                                   var24 = new byte[var0.v];
                                                   Gs329.e(var2, var24, 0, var0.v);
                                                   var25 = J173.s(var24, 0, var0.v);
                                                   var26 = "opensn";
                                                   if (!k || !Dp208.s(var25, 1, var26)) {
                                                      Dp208.j(var25, true, false, var26, ao, aa);
                                                   }

                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETTEXT) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETPLAYERMODEL_OTHER) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETPLAYERMODEL_SELF) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETMODEL) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETANIM) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETNPCHEAD) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETPLAYERHEAD) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETCOLOUR) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETHIDE) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETOBJECT) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETPOSITION) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETSCROLLPOS) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETANGLE) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SPINMODEL) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETPLAYERHEAD_IGNOREWORN) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETTARGETPARAM) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETEVENTS) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.RUNCLIENTSCRIPT) {
                                                   var22 = Gs329.bk(var2);
                                                   Object[] var23 = new Object[var22.length() + 1];

                                                   for(var21 = var22.length() - 1; var21 >= 0; --var21) {
                                                      if (var22.charAt(var21) == 's') {
                                                         var23[var21 + 1] = Gs329.bk(var2);
                                                      } else {
                                                         var23[var21 + 1] = new Integer(Gs329.bd(var2));
                                                      }
                                                   }

                                                   var23[0] = new Integer(Gs329.bd(var2));
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_OPENTOP) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_OPENSUB) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_OPENSUB_ACTIVE_PLAYER) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_OPENSUB_ACTIVE_NPC) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_OPENSUB_ACTIVE_LOC) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_OPENSUB_ACTIVE_OBJ) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_CLOSESUB) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_MOVESUB) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.DEBUG_SERVER_TRIGGERS) {
                                                   var18 = Gs329.au(var2);
                                                   var4 = Gs329.au(var2);
                                                   var21 = Gs329.au(var2);
                                                   cl();
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETGRAPHIC) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETTEXTFONT) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETVIDEO) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETRECOL) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETRETEX) {
                                                   var0.r = null;
                                                   return true;
                                                } else if (var0.r == Ea395.IF_SETCLICKMASK) {
                                                   var0.r = null;
                                                   return true;
                                                } else {
                                                   byte var19;
                                                   if (var0.r == Ea395.SONG_CHANNEL_FACTOR) {
                                                      var19 = Gs329.ax(var2);
                                                      var4 = Gs329.ar(var2);
                                                      cl();
                                                      SoundManager.a(var19, var4);
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.REDUCE_ATTACK_PRIORITY) {
                                                      iu = Gs329.ar(var2) == 1;
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.SEND_PING) {
                                                      var18 = Gs329.bd(var2);
                                                      var4 = Gs329.bd(var2);
                                                      El328 var5 = El328.d(Eu326.SEND_PING_REPLY, var0.s);
                                                      Gs329.a(var5.q, var18);
                                                      Gs329.a(var5.q, var4);
                                                      N272.e(var0, var5);
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.EXECUTE_CLIENT_CHEAT) {
                                                      var18 = Gs329.au(var2);
                                                      var4 = Gs329.bd(var2);
                                                      debugconsole.y(var18, var4);
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.DEBUG_PATHFINDING_STATIC) {
                                                      Lk495.g().e(var2);
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.DEBUG_PATHFINDING_DYNAMIC) {
                                                      Lk495.g().j(var2);
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.NAVPOWER_DEBUG_RENDER_CHUNK) {
                                                      ni.g(var2, var0.v);
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.SCRIPT_MESSAGE) {
                                                      Az399 var20 = ClientScriptMessaging.q(var2);
                                                      G284.g(lq, (long)var20.s.length);
                                                      cw(new K398(var20));
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.STATEEVENT_EVENTSBUFFER) {
                                                      Gf474.v(var2);
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.STATESTREAM_STATISTICS) {
                                                      if (LossyStateStreamProfiler.enabled) {
                                                         dv = LossyStateStreamStatistics.deserialise(var2);
                                                      }

                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.PHYSICSCONTROLDEBUGGER_ACTIVATE) {
                                                      Y192.e = Gs329.ar(var2) == 1;
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.ADJUST_PHYSICS_LOOKAHEAD) {
                                                      var19 = Gs329.ax(var2);
                                                      dz += var19;
                                                      if (var19 > 0) {
                                                         du = true;
                                                      }

                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.SET_TARGET) {
                                                      as = Gs329.ak(var2);
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r == Ea395.SERVER_FACTS) {
                                                      var18 = Gs329.bd(var2);
                                                      var4 = Gs329.bd(var2);
                                                      d = (double)var18 + (double)var4 / 1000000.0D;
                                                      q = Gs329.bd(var2);
                                                      j = Gs329.bd(var2);
                                                      var0.r = null;
                                                      return true;
                                                   } else if (var0.r != Ea395.MAPPEDUPDATE) {
                                                      Ku323.g((var0.r != null ? var0.r.ordinal() : -1) + A412.q + (var0.k != null ? var0.k.ordinal() : -1) + A412.q + (var0.i != null ? var0.i.ordinal() : -1) + " " + var0.v, new RuntimeException());
                                                      ap();
                                                      return true;
                                                   } else {
                                                      while(var2.v < var0.v) {
                                                         Ey446 var17 = Ey446.values()[Gs329.ar(var2)];
                                                         cq(var17);
                                                      }

                                                      var0.r = null;
                                                      return true;
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   static final void ay() {
      la = false;
      lv = false;
   }

   public static final void bd() {
   }

   private static void bu(Bh77 var0, Vector3 var1, Iterator var2) {
      nh = (new File(var0.r)).getName();

      int var3;
      for(var3 = 0; var3 < Bh77.da(var0); ++var3) {
         try {
            XElement var4 = Bh77.dx(var0, var3);
            GameEntity var5 = new GameEntity((Bb4)var2.next(), cj);
            mm.add(var5);
            ca.put(var5, new Ap386());
            XElement.bo(var4, var5, var1, new T404());
         } catch (Exception var6) {
            logger.error("", var6);
         }
      }

      for(var3 = 0; var3 < Bh77.db(var0); ++var3) {
         J113 var7 = Bh77.dd(var0, var3);
         L170 var9 = new L170(var7.ah, var7.d, var7.ah);
         L170.r(var9, var1);
         mm.add(var9);
      }

      for(var3 = 0; var3 < Bh77.dg(var0); ++var3) {
         Ao74 var8 = Bh77.er(var0, var3);
         D75 var10 = new D75(var8.ah, var8.ap, var8.d);
         D75.r(var10, var1);
         mm.add(var10);
      }

      if (var0.j != null) {
         Scene.g(mm, var0.j, var1);
      }

      logger.debug("Building xmap from {}", var0.r);
      if (var0.b != null) {
         mm.q(var0.b, var1, var0.r);
      }

      if (var0.l != null) {
         Scene.j(mm, eg, var0.l, var0.r);
      }

      if (var0.w != null) {
         Scene.e(mm, eg, var0.w, var0.r);
      }

      if (var0.e != null) {
         Scene.h(mm, var0.e);
      }

   }

   private static final void aj() {
      Lb33.g(Lb33.VariableSystem);

      try {
         for(int var0 = Fw152.g(jw, true); var0 != -1; var0 = Fw152.g(jw, false)) {
            cv(var0);
         }

         for(L410 var1 = L410.q(); var1 != null; var1 = L410.q()) {
            int var2 = L410.s(var1);
            long var3 = L410.b(var1);
            VarBasicType var5;
            player var6;
            if (var2 == 1) {
               var5 = fo.list((int)var3);
               jr.setVarValueInt(var5, var1.g);
               var6 = Gc330.j();
               if (var6 != null) {
                  player.cj(var6, var5, var1.g);
               }
            } else if (var2 == 2) {
               var5 = fo.list((int)var3);
               jr.setVarValue(var5, var1.j);
               var6 = Gc330.j();
               if (var6 != null) {
                  player.cj(var6, var5, var1.j);
               }
            }
         }

         Lb33.d(Lb33.VariableSystem);
      } finally {
         Lb33.d(Lb33.VariableSystem);
      }
   }

   private static void bl(int var0, int var1) {
      if (!debugconsole.isopen()) {
         int var2 = D150.j.e + D150.j.h + 2;
         String var3;
         if (lx) {
            if (Al161.d < 0) {
               var3 = "Ping: not available";
            } else {
               var3 = "Ping: " + Al161.d + "ms";
            }

            F342.g(D150.s, var3, var0, var1, -1, -2013265920);
            var1 += var2;
            Lt501.d(Lt501.PING, (double)Al161.d);
         }

         int var4;
         int var7;
         String var8;
         if (lf) {
            int var18 = 0;
            var4 = 0;
            int var5 = 0;

            int var6;
            for(var6 = 0; var6 < Js5Archive.VALUES.length; ++var6) {
               if (dx[var6] != null) {
                  var18 += S136.i(dx[var6]);
                  var4 += dx[var6].s();
                  var5 += dx[var6].b();
               }
            }

            var6 = var5 * 100 / var18;
            var7 = var4 * 10000 / var18;
            var8 = "Cache:" + D281.g((long)var7, 2, true, Language.EN) + "% (" + var6 + "%)";
            var1 += var2;
            F342.g(D150.s, var8, var0, var1, -1, -2013265920);
            var1 += var2;
         }

         double var11;
         String var13;
         String var19;
         String var27;
         float var31;
         if (lr) {
            var3 = String.format("FPS: %.1f (%.2f ms) Average: %.1f Low: %.1f High: %.1f %s", GameShell3.fps, 1000.0D / GameShell3.fps, GameShell3.fpsAverage, GameShell3.fpsL, GameShell3.fpsH, GameShell3.PauseCountFPS == 0.0D ? "" : "(Paused)");
            F342.g(D150.s, var3, var0, var1, GameShell3.fps < 30.0D ? -65536 : -256, -2013265920);
            var1 += var2;
            Lt501.d(Lt501.FPS, GameShell3.fps);
            Lt501.d(Lt501.FPSAverage, GameShell3.fpsAverage);
            Lt501.d(Lt501.FPSL, GameShell3.fpsL);
            Lt501.d(Lt501.FPSH, GameShell3.fpsH);
            Lt501.d(Lt501.FPS_TRACKING_PAUSED, GameShell3.PauseCountFPS);
            var19 = String.format("LPS: %.1f [%d]", GameShell3.lps, getspeed());
            F342.g(D150.s, var19, var0, var1, -1, -2013265920);
            var1 += var2;
            Lt501.d(Lt501.LPS, GameShell3.lps);
            String var22 = String.format("PPS: %.1f Lookahead: %d C-S: %d late: %d skipped: %d", GameShell3.pps, dz, ln, Lz409.b, Lz409.l);
            F342.g(D150.s, var22, var0, var1, -1, -2013265920);
            boolean var25 = (float)(System.currentTimeMillis() - Lz409.w) > 2.0F * Lq191.d() * 2000.0F;
            if (var25 || M188.q) {
               var7 = Kj334.e(D150.j, var22 + " ");
               var8 = "";
               if (var25) {
                  var8 = "NO DYNAMIC STATES ";
               }

               if (M188.q) {
                  var8 = var8 + "EXTRAPOLATING ";
               }

               F342.g(D150.s, var8, var0 + var7, var1, -65536, -2013265920);
            }

            var1 += var2;
            Lt501.d(Lt501.PPS, GameShell3.pps);
            Lt501.d(Lt501.FRAMES_AHEAD, (double)ln);
            if (lo == 0.0D) {
               ld += (double)kn;
               ++ky;
               if (ky > 0.0D) {
                  kq = ld / ky;
               }

               if ((double)kn > kc) {
                  kc = (double)kn;
                  if (kn > 999.0F) {
                     kc = 999.0D;
                  }
               }

               if ((double)kn < kp) {
                  kp = (double)kn;
               }
            }

            var27 = String.format("Server PPS: %.1f Average: %.1f Low: %.1f High: %.1f %s", kn, kq, kp, kc, lo == 0.0D ? "" : "(Paused)");
            F342.g(D150.s, var27, var0, var1, -256, -2013265920);
            var1 += var2;
            Lt501.d(Lt501.PPS_TRACKING_PAUSED, lo);
            Vector3 var30 = Vector3.g;
            player var9 = Gc330.j();
            if (var9 != null) {
               PlayerPhysicsComponent var10 = (PlayerPhysicsComponent)player.eb(var9, PlayerPhysicsComponent.class);
               if (var10 != null && var10.q != null) {
                  var30 = var10.getPosition(false);
               }
            }

            var31 = M188.s();
            F342.g(D150.s, "PhysFramesRemaining: " + var31, var0, var1, var31 < 0.0F ? -65536 : -1, -2013265920);
            var1 += var2;
            var11 = Math.toDegrees((double)ClientScriptAPI.getCameraHeading());
            if (var11 < 0.0D) {
               var11 += 360.0D;
            }

            var13 = String.format("%5.0f %5.0f %5.0f  %d", var30.x, var30.y, var30.z, (int)var11);
            F342.g(D150.s, "LocXYZ CamFace: " + var13, var0, var1, -1, -2013265920);
            var1 += var2 * 2;
            Lt501.g(Lt501.POSITION, var13);
         }

         if (lp) {
            var3 = "NPCs: " + q;
            F342.g(D150.s, var3, var0, var1, -32897, -2013265920);
            var1 += var2;
            Lt501.d(Lt501.NPCS, (double)q);
            F342.g(D150.s, "Players: " + j, var0, var1, -32897, -2013265920);
            var1 += var2;
            Lt501.d(Lt501.PLAYERS, (double)j);
            var19 = String.format("CURRENT BOT: %s %s", debugconsole.d, debugconsole.g);
            F342.g(D150.s, var19, var0, var1, -256, -2013265920);
            var1 += var2;
            Lt501.g(Lt501.BOT_NUMBER, debugconsole.g);
            if (lm) {
               F342.g(D150.s, "Lua Data In: " + lq.j(), var0, var1, -6316033, -2013265920);
               var1 += var2;
               F342.g(D150.s, "Lua Data Out: " + ls.j(), var0, var1, -6316033, -2013265920);
               var1 += var2;
            }

            double var23 = cj.getLuaPoolSize();
            if (var23 >= 1024.0D) {
               var27 = String.format("%.2fMb", var23 / 1024.0D);
            } else {
               var27 = String.format("%.2fKb", var23);
            }

            F342.g(D150.s, "CLua: " + var27, var0, var1, var23 > 102400.0D ? -32897 : -8388737, -2013265920);
            var1 += var2;
            Lt501.d(Lt501.LUA_MEMORY, var23 / 1024.0D);
            if (d > 0.0D) {
               var23 = d;
               if (var23 >= 1024.0D) {
                  var27 = String.format("%.2fMb", var23 / 1024.0D);
               } else {
                  var27 = String.format("%.2fKb", var23);
               }

               F342.g(D150.s, "SLua: " + var27, var0, var1, var23 > 102400.0D ? -32897 : -8388737, -2013265920);
               var1 += var2;
            }

            Runtime var32 = Runtime.getRuntime();
            double var28 = (double)(var32.totalMemory() - var32.freeMemory()) / 1048576.0D;
            var11 = (double)var32.maxMemory() / 1048576.0D;
            var13 = String.format("%.2fMB/%.2fMB", var28, var11);
            F342.g(D150.s, "Java memory: " + var13, var0, var1, var28 / var11 > 0.9D ? -32897 : -8388737, -2013265920);
            var1 += var2;
            Lt501.g(Lt501.JAVA_MEMORY, var13);
            String var14 = String.format("Unsafe: %.2fMb", (double)Kc180.q() / 1048576.0D);
            F342.g(D150.s, var14, var0, var1, -8388737, -2013265920);
            var1 += var2;
            String var15 = String.format("Working set: %.2fMb (Peak: %.2fMb)", (double)ProcessInfo.GetWorkingSetSize() / 1048576.0D, (double)ProcessInfo.GetPeakWorkingSetSize() / 1048576.0D);
            F342.g(D150.s, var15, var0, var1, -8388737, -2013265920);
            var1 += var2;
            String var16 = String.format("Commit charge: %.2fMb (Peak: %.2fMb)", (double)ProcessInfo.GetCommitCharge() / 1048576.0D, (double)ProcessInfo.GetPeakCommitCharge() / 1048576.0D);
            F342.g(D150.s, var16, var0, var1, -8388737, -2013265920);
            var1 += var2;
            if (mm != null) {
               String var17 = String.format("SceneGraph: Nodes %d, GameEntities %d", Scene.m(mm), Scene.n(mm));
               F342.g(D150.s, var17, var0, var1, -8388737, -2013265920);
               var1 += var2;
               Lt501.d(Lt501.SCENE_NODES, (double)Scene.m(mm));
               Lt501.d(Lt501.GAME_ENTITIES, (double)Scene.n(mm));
            }
         }

         if (lc) {
            player var20 = Gc330.j();
            if (var20 != null) {
               PlayerPhysicsComponent var21 = (PlayerPhysicsComponent)player.eb(var20, PlayerPhysicsComponent.class);
               if (var21 != null && var21.getAvatar(false) != null && var21.getAvatar(false).b != null) {
                  var1 += var2;
                  var1 += var2;
                  BulletVehicle var24 = var21.getAvatar(false).b;
                  float var26 = Vector3.f(var24.e.l());
                  var26 = (float)((int)((var26 - 0.2F) * 10.0F)) / 10.0F;
                  F342.g(D150.s, "Car speed: " + var26 + " m/s", var0, var1, -1, -2013265920);
                  var1 += var2;
                  var27 = new String();

                  for(int var33 = 0; var33 < BulletVehicle.g(var24); ++var33) {
                     float var29 = var24.s(var33);
                     var31 = (float)((int)(var29 * 10.0F)) / 10.0F;
                     var27 = var27 + "    " + var31;
                  }

                  F342.g(D150.s, "Wheel slip status:" + var27, var0, var1, -1, -2013265920);
                  var1 += var2;
               }
            }
         }

         if (lk) {
            var3 = String.format("ScrEvt: %d/s (Hndlrs-Act: %d, Cre: %d, Del: %d)", cd, ScriptManager.totalHandlersActive, ScriptManager.totalHandlersCreated, ScriptManager.totalHandlersDestroyed);
            F342.g(D150.s, var3, var0, var1, -256, -2013265920);
            int var10000 = var1 + var2;
            Lt501.d(Lt501.SCRIPTEVENTS_HANDLERSEXIST, (double)(ScriptManager.totalHandlersCreated - ScriptManager.totalHandlersDestroyed));
            Lt501.d(Lt501.SCRIPTEVENTS_HANDLERSACTIVE, (double)ScriptManager.totalHandlersActive);
            var4 = (int)(System.nanoTime() / 1000000L);
            if (var4 >= cp) {
               cd = ScriptManager.totalHandlersTriggered;
               Lt501.d(Lt501.SCRIPTEVENTS_TRIGGERED, (double)cd);
               ScriptManager.totalHandlersTriggered = 0;
               cp = var4 + 1000;
            }
         }

      }
   }

   private static void bw() {
      if (ms) {
         li[le] = kn;
         md[le] = getPhysicsSpeed();
         me[le] = ln;
         ly[le] = mw;
         mw = 0;
         float var0 = 0.0F;
         player var1 = Gc330.j();
         if (var1 != null) {
            PlayerPhysicsComponent var2 = (PlayerPhysicsComponent)player.eb(var1, PlayerPhysicsComponent.class);
            if (var2 != null && var2.q != null) {
               var0 = M188.l(var2.q);
            }
         }

         mj[le] = var0;
         le = (le + 1) % 200;
      }
   }

   public static final void bj(Vector3 var0) {
      bk();
      gu = Ms517.d();
      gz = new Ll42();
      float var1 = Lq191.d();
      gz.d = new PhysicsWorldWrapper(gu.q(var1, var0));
      gz.d.d.at(Gn5.aq);
      gk = true;
   }

   public static void aq() {
      client var0 = bu;
      synchronized(var0) {
         if (GameShell3.fsframe == null) {
            Object var1;
            if (GameShell3.frame != null) {
               var1 = GameShell3.frame;
            } else {
               var1 = bu.getTopContainer();
            }

            GameShell3.frameWid = ((Container)var1).getSize().width;
            GameShell3.frameHei = ((Container)var1).getSize().height;
            Insets var2;
            if (var1 == GameShell3.frame) {
               var2 = GameShell3.frame.getInsets();
               GameShell3.frameWid -= var2.left + var2.right;
               GameShell3.frameHei -= var2.top + var2.bottom;
            }

            if (a() != J160.SMALL) {
               ai();
            } else {
               GameShell3.canvasWid = ii;
               GameShell3.leftMargin = (GameShell3.frameWid - ii) / 2;
               GameShell3.canvasHei = iq;
               GameShell3.topMargin = 0;
            }

            GameShell3.canvas.setSize(GameShell3.canvasWid, GameShell3.canvasHei);
            o();
            if (var1 == GameShell3.frame) {
               var2 = GameShell3.frame.getInsets();
               GameShell3.canvas.setLocation(var2.left + GameShell3.leftMargin, var2.top + GameShell3.topMargin);
            } else {
               GameShell3.canvas.setLocation(GameShell3.leftMargin, GameShell3.topMargin);
            }

            al();
         }
      }
   }

   public final void mainquit() {
      if (jr != null && jr.q) {
         ab();
      }

      Kc180.d(s);
      cj.purgeNative();
      H149.d();
      NativeResourceLoader.d();
      if (Hq338.g && GameShell3.fsframe != null) {
         Hq338.q(GameShell3.fsimp14, GameShell3.fsframe);
         GameShell3.fsframe = null;
      }

      Al161.q();
      N272.s(fx);
      SoundManager.b();
      W144.v(dm);
      L145.s(dj);

      try {
         debugconsole.d();
      } catch (Exception var2) {
      }

      if (DebugDialog.j != null) {
         DebugDialog.d(DebugDialog.j);
      }

   }

   public static final native void nativeUpdateGameplayStates(long var0, int var2, float var3);

   public static final void br(int var0, int var1, Bt286 var2, float var3, float var4, int var5) {
      ay();
      if (gb != null && D285.d(gb) != var0) {
         Iterator var6 = ft.values().iterator();

         while(var6.hasNext()) {
            Npc var7 = (Npc)var6.next();
            Npc.ca(var7);
            Scene.w(mm, var7);
         }

         ft.clear();
      }

      logger.debug("Got new build coordinates: {}, {}", var3, var4);
      gd = var3;
      ga = var4;
      z(var5);
      int var15 = gn;
      int var16 = gj;
      gn = 0;
      gj = 0;
      int var8 = gn - var15;
      int var9 = gj - var16;
      gb = new D285(var0, var1, var2, gn, gj, gq);
      Vector3 var12;
      int var17;
      if (var5 == 12) {
         Iterator var10 = ft.values().iterator();

         while(var10.hasNext()) {
            Npc var11 = (Npc)var10.next();
            var12 = Vector3.i(var11.getWorldTransform().trans, (float)var8, 0.0F, (float)var9);
            Npc.w(var11, var12);
         }
      } else {
         var17 = (gp - 1) * 4;
         int var18 = (gy - 1) * 4;
         Iterator var20 = ft.values().iterator();

         label48:
         while(true) {
            Npc var13;
            Vector3 var14;
            do {
               if (!var20.hasNext()) {
                  break label48;
               }

               var13 = (Npc)var20.next();
               var14 = Vector3.i(var13.getWorldTransform().trans, (float)var8, 0.0F, (float)var9);
               Npc.w(var13, var14);
            } while((int)var14.x >= 0 && (int)var14.x <= var17 && (int)var14.z >= 0 && (int)var14.z <= var18);

            Npc.ca(var13);
            Scene.w(mm, var13);
            var20.remove();
         }
      }

      for(var17 = 0; var17 < 2048; ++var17) {
         player var19 = Gc330.e(var17);
         if (var19 != null) {
            var12 = Vector3.i(var19.getWorldTransform().trans, (float)var8, 0.0F, (float)var9);
            player.w(var19, var12);
         }
      }

      SoundManager.y();
      Hb335.g(jb);
   }

   private static final void ce() {
      Gs329 var0 = fx.b;
      Bb4 var1 = Bb4.e(var0, Ed472.NPC);
      Npc var2 = (Npc)ft.get(var1);
      Npc.ca(var2);
      Scene.w(mm, var2);
      ft.remove(var1);
   }

   public static final void bv(boolean var0) {
      SoundManager.r();
      int var10000 = ac;
   }

   public static final void bn() {
      ca.clear();
      Iterator var0 = gb.b.iterator();
      Iterator var1 = D285.q(gb).iterator();

      while(var1.hasNext()) {
         G289 var2 = (G289)var1.next();
         if (G289.g(var2) != null) {
            bz(G289.g(var2), G289.d(var2) + (float)gn, G289.q(var2) + (float)gj);
            bu(G289.g(var2), new Vector3(G289.d(var2), 0.0F, G289.q(var2)), var0);
         }
      }

      var1 = ce.iterator();

      while(var1.hasNext()) {
         V385 var3 = (V385)var1.next();
         var3.j();
      }

      ce.clear();
      if (ca.isEmpty()) {
         bb();
         ba();
      } else {
         nw = 0;
         ng = System.currentTimeMillis();
         cj.event.triggerEvent((String)"__onMapLoading", ca.size());
      }

   }

   public static boolean bg(int var0) {
      return gb != null && D285.d(gb) == var0;
   }

   public static boolean cj(String var0) {
      return D236.e(ku.e, var0) != -1;
   }

   public static void ba() {
      while(true) {
         Ag389 var0 = (Ag389)cv.peek();
         if (var0 == null || var0.h()) {
            return;
         }

         cv.remove();
         logger.debug("Running delayed {} now", var0);
         Ag389.s(var0);
      }
   }

   private static void c(J160 var0, J160 var1, int var2, int var3, boolean var4) {
      if (Hq338.g && GameShell3.fsframe != null && (var1 != J160.FULLSCREEN || var2 != GameShell3.lastFullscreenWidth || var3 != GameShell3.lastFullscreenHeight)) {
         Hq338.q(GameShell3.fsimp14, GameShell3.fsframe);
         GameShell3.fsframe = null;
      }

      if (Hq338.g && var1 == J160.FULLSCREEN && GameShell3.fsframe == null) {
         GameShell3.fsframe = Hq338.d(GameShell3.fsimp14, var2, var3, 0, 0);
         if (GameShell3.fsframe != null) {
            GameShell3.lastFullscreenWidth = var2;
            GameShell3.lastFullscreenHeight = var3;
         }
      }

      if (var1 == J160.FULLSCREEN && (!Hq338.g || GameShell3.fsframe == null)) {
         c(var0, W159.g().j, -1, -1, true);
      } else {
         Object var5;
         Insets var6;
         if (GameShell3.fsframe != null) {
            GameShell3.frameWid = var2;
            GameShell3.frameHei = var3;
            var5 = GameShell3.fsframe;
         } else if (GameShell3.frame != null) {
            var6 = GameShell3.frame.getInsets();
            int var10001 = var6.left + var6.right;
            GameShell3.frameWid = GameShell3.frame.getSize().width - var10001;
            var10001 = var6.top + var6.bottom;
            GameShell3.frameHei = GameShell3.frame.getSize().height - var10001;
            var5 = GameShell3.frame;
         } else {
            var5 = bu.getTopContainer();
            GameShell3.frameWid = ((Container)var5).getSize().width;
            GameShell3.frameHei = ((Container)var5).getSize().height;
         }

         if (var1 != J160.SMALL) {
            ai();
         } else {
            GameShell3.canvasWid = ii;
            GameShell3.leftMargin = (GameShell3.frameWid - ii) / 2;
            GameShell3.canvasHei = iq;
            GameShell3.topMargin = 0;
         }

         GameShell3.canvas.setSize(GameShell3.canvasWid, GameShell3.canvasHei);
         if (H149.y) {
            Graphics.resetFromCanvas(GameShell3.canvas, 0, 0, 2, 0, 0, 0);
            H149.x = GameShell3.canvasHei;
            H149.p = GameShell3.canvasWid;
         }

         if (var5 == GameShell3.frame) {
            var6 = GameShell3.frame.getInsets();
            GameShell3.canvas.setLocation(var6.left + GameShell3.leftMargin, var6.top + GameShell3.topMargin);
         } else {
            GameShell3.canvas.setLocation(GameShell3.leftMargin, GameShell3.topMargin);
         }

         if (var1 != J160.RESIZABLE && var1 != J160.FULLSCREEN) {
            id = false;
         } else {
            id = true;
         }

         if (fx.q != null && u(ac)) {
            ag();
         }

         GameShell3.fullredraw = true;
      }
   }

   static void bt() {
      long var0 = System.nanoTime();
      cj.event.triggerEvent((String)"__onOptimizeBroadphase", "start");
      logger.debug("Optimising broadphase for interpolated world...");
      gz.d.d.au();
      cj.event.triggerEvent((String)"__onOptimizeBroadphase", "stop");
      long var2 = System.nanoTime();
      logger.debug("Optimize took: {}", var2 - var0);
      logger.debug("Baking world irradiance lighting...");
      IrradianceVolumes.initiateIrradianceBake();
   }

   private static void bz(Bh77 var0, float var1, float var2) {
      if (var0 != null) {
         gz.d.e(var0.j, var1, var2);
      }

   }

   public static void bc(BroadcastStateAndEventsTypes$StatePayload var0, GameEntity var1, Runnable var2) {
      SceneryConfig var3 = SceneryConfig.DeserializeHelper(var0.wire_data);
      Bb4 var4 = var0.broadcasterID;
      logger.trace("Received spawny sceneryconfig for " + var4);
      if (var3.originalElementAddresses == null) {
         logger.trace("Hmmm, was asked to spawn something with a null originalElementAddresses array.  Ignoring.  Hopefully a proper payload will come along later.");
      } else {
         Vector3 var5 = new Vector3((float)(-gn), 0.0F, (float)(-gj));
         Bn279 var6 = (Bn279)GameEntity.ej(var1, "spawnyMcSpawnins_AsynchronousTask");
         if (var6 != null) {
            Bn279.j(var6);
         }

         Bn279 var7 = l.g(new Z392(var3, var1, var5, var2), gf, (Object)null);
         var1.setProperty("spawnyMcSpawnins_AsynchronousTask", var7);
      }

   }

   public static final boolean be(N272 var0) {
      try {
         return bs(var0);
      } catch (IOException var4) {
         at();
         logger.error("Exception in TCP In. Reconnecting....", var4);
         return true;
      } catch (Exception var5) {
         String var2 = (var0.r != null ? var0.r.ordinal() : -1) + A412.q + (var0.k != null ? var0.k.ordinal() : -1) + A412.q + (var0.i != null ? var0.i.ordinal() : -1) + " " + var0.v + A412.q + " ";

         for(int var3 = 0; var3 < var0.v && var3 < 50; ++var3) {
            var2 = var2 + var0.b.r[var3] + A412.q;
         }

         logger.error(var2, var5);
         Ku323.g(var2, var5);
         ap();
         return true;
      }
   }

   private static final void bx(float var0) {
      if (gq != var0) {
         gp = gy = (int)Math.ceil((double)(var0 / 4.0F));
         gq = var0;
      }
   }

   public static void cw(Ag389 var0) {
      if (cv.isEmpty() && !var0.h()) {
         Ag389.s(var0);
      } else {
         logger.debug("Delaying {}", var0);
         cv.add(var0);
      }
   }

   public static final void cq(Ey446 var0) {
      Gs329 var1 = fx.b;
      int var18;
      UUID var19;
      if (var0 == Ey446.LOC_CHANGE) {
         var19 = var1.bo();
         var18 = Gs329.bd(var1);
         logger.trace("Received loc_change guid: {}, id: {}", var19, var18);
      } else if (var0 == Ey446.LOC_DEL) {
         var19 = var1.bo();
         logger.trace("Received loc_del guid: {}", var19);
      } else if (var0 == Ey446.LOC_CUSTOMISE) {
         var19 = var1.bo();
         var18 = Gs329.ar(var1);
      } else if (var0 == Ey446.LOC_ANIM) {
         var19 = var1.bo();
         var18 = Gs329.bd(var1);
         logger.trace("Received loc_anim guid: {}", var19);
         ca(var19, var18);
      } else {
         int var4;
         int var5;
         int var6;
         int var17;
         if (var0 == Ey446.FMOD_PLAY_SOUND_AREA) {
            var17 = Gs329.bd(var1);
            String var20 = Gs329.bk(var1);
            var4 = Gs329.bd(var1);
            var5 = Gs329.bd(var1);
            var6 = Gs329.bd(var1);
            logger.trace("Received PlaySoundArea");
            SoundManager.c(var17, new Vector3((float)var4, (float)var5, (float)var6), var20);
         } else {
            float var2;
            float var3;
            int var8;
            int var9;
            int var10;
            float var14;
            int var22;
            if (var0 == Ey446.SOUND_AREA) {
               var2 = Gs329.bl(var1) - (float)gn;
               var3 = Gs329.bl(var1) - (float)gj;
               var4 = Gs329.au(var1);
               if (var4 == 65535) {
                  var4 = -1;
               }

               var5 = Gs329.ar(var1);
               var6 = var5 >> 4 & 15;
               var22 = var5 & 7;
               var8 = Gs329.ar(var1);
               var9 = Gs329.ar(var1);
               var10 = Gs329.au(var1);
               Object[] var23 = new Object[]{var2, var3, var6, var4, var22};
               logger.trace("Received sound_area x: {}, z: {}, range: {}, synth: {}, loops: {}", var23);
               if (var2 >= 0.0F && var3 >= 0.0F && var2 < (float)(gp << 2) && var3 < (float)(gy << 2)) {
                  int var24 = var6 + 1 << 2;
                  float var25 = Gc330.j().getWorldTransform().trans.x;
                  var14 = Gc330.j().getWorldTransform().trans.z;
                  if (var25 >= var2 - (float)var24 && var25 <= var2 + (float)var24 && var14 >= var3 - (float)var24 && var14 <= var3 + (float)var24) {
                     SoundManager.x(var4, var22, var8, var9, var2, var3, (float)(var6 << 2), var10);
                  }
               }

            } else if (var0 == Ey446.SOUND_VORBIS_AREA) {
               var17 = Gs329.ar(var1);
               var3 = Gs329.bl(var1) - (float)gn;
               float var21 = Gs329.bl(var1) - (float)gj;
               var5 = Gs329.au(var1);
               if (var5 == 65535) {
                  var5 = -1;
               }

               var6 = Gs329.ar(var1);
               var22 = var6 >> 4 & 15;
               var8 = var6 & 7;
               var9 = Gs329.ar(var1);
               var10 = Gs329.ar(var1);
               int var11 = Gs329.au(var1);
               Object[] var12 = new Object[]{var3, var21, var22, var5, var8};
               logger.trace("Received sound_vorbis_area x: {},  z: {}, range: {}, vorbis: {}, loops: {}", var12);
               if (var3 >= 0.0F && var21 >= 0.0F && var3 < (float)(gp << 2) && var21 < (float)(gy << 2)) {
                  int var13 = var22 + 1 << 2;
                  var14 = Gc330.j().getWorldTransform().trans.x;
                  float var15 = Gc330.j().getWorldTransform().trans.z;
                  if (var14 >= var3 - (float)var13 && var14 <= var3 + (float)var13 && var15 >= var21 - (float)var13 && var15 <= var21 + (float)var13) {
                     SoundManager.z(var5, var8, var9, var10, var3, var21, (float)(var22 << 2), false, var11);
                  }
               }

            } else if (var0 == Ey446.LOC_PREFETCH) {
               var17 = Gs329.bd(var1);
               var18 = Gs329.ar(var1);
            } else if (var0 == Ey446.TEXT_COORD) {
               Gs329.ar(var1);
               var2 = Gs329.bl(var1) - (float)gn;
               var3 = Gs329.bl(var1) - (float)gj;
               var4 = Gs329.au(var1);
               var5 = Gs329.ar(var1);
               var6 = Gs329.ay(var1);
               String var7 = Gs329.bk(var1);

               try {
                  var8 = Integer.parseInt(var7);
                  var9 = (int)bh(var2, var3);
                  cm(var2, var3, var5, var4, var8 == var9 ? -16711936 : -65536, var8 + ":" + var9);
               } catch (NumberFormatException var16) {
                  cm(var2, var3, var5, var4, var6, var7);
               }

            } else {
               Ku323.g("" + var0, new RuntimeException());
               ap();
            }
         }
      }
   }

   private static final void cp() {
      Gs329 var0 = fx.b;
      Gs329.h(var0);
      boolean var1 = var0.s(1) == 1;
      Gs329.b(var0);
      Bb4 var2 = Bb4.e(var0, Ed472.NPC);
      int var3 = -1;
      if (var1) {
         var3 = Gs329.au(var0);
      }

      float var4 = Gs329.bl(var0);
      float var5 = Gs329.bl(var0);
      int var6 = Gs329.ar(var0);
      int var7 = Gs329.au(var0);
      float var8 = Gs329.bl(var0);
      float var9 = Gs329.bl(var0);
      float var10 = Gs329.bl(var0);
      float var11 = Gs329.bl(var0);
      Npc var12 = (Npc)ft.get(var2);
      if (var12 != null) {
         throw new IllegalStateException(var12.toString());
      } else {
         Vector3 var13 = new Vector3(var8, var9, var10);
         Quaternion var14 = Lr302.d(var11);
         Npc var15 = new Npc(var2);
         var15.setObjectTranslation(var8, var9, var10);
         mm.add(var15);
         Npc.bn(var15, var4, var5, var6, var7);
         if (var3 >= 0) {
            XElement.ai.r(var15, var3, new O396(var15, var13, var14));
         }

         if (var3 < 0 || Jt38.t(var4, var5)) {
            var15.bt(var13, var14);
         }

         ft.put(var2, var15);
         ScheduledMovementComponent.u(var15.i, dq);
      }
   }

   private static final void cd() {
      Gs329 var0 = fx.b;
      Bb4 var1 = Bb4.e(var0, Ed472.NPC);
      float var2 = Gs329.bl(var0);
      float var3 = Gs329.bl(var0);
      int var4 = Gs329.ar(var0);
      int var5 = Gs329.au(var0);
      Npc var6 = (Npc)ft.get(var1);
      Npc.bn(var6, var2, var3, var4, var5);
   }

   private static final void ck() {
      Gb471.g(fx.b);
   }

   public static final void bo(int var0, int var1, int var2, int var3) {
      if (mm != null && Gc330.j() != null) {
         Lb33.g(Lb33.GameDraw);

         try {
            ++hv;
            C340.y(var0, var1, var2, var3);
            C340.j(var0, var1, var0 + var2, var1 + var3);
            ScriptCamera var4 = ScriptCamera.getActiveCamera();
            if (var4 != null) {
               RotTrans var5 = ScriptCamera.v(var4).q();
               H303.q(ax, var5);
               ar = var4.ai;
               if (bd == null) {
                  ao();
               }

               double var6 = (double)(var4.getWorldTransform().trans.x - bd.x);
               double var8 = (double)(var4.getWorldTransform().trans.y - bd.y);
               double var10 = (double)(var4.getWorldTransform().trans.z - bd.z);
               double var12 = var6 * var6 + var8 * var8 + var10 * var10;
               float var14 = 10.0F;
               if (var12 >= 100.0D) {
                  ao();
               }
            } else {
               bd = null;
            }

            C340.d(ax, ar);

            try {
               if (!w && SoundManager.i) {
                  SoundManager.k();
               }

               Lk495.d(gn, gj);
               Lk495.q(Lk495.g());
            } catch (Exception var20) {
               logger.error("", var20);
            }

            SoundManager.r();
            if (ae && W144.e(dm) == 0) {
               ae = false;
            }

            if (ae) {
               C340.e((float)var0, (float)var1, (float)var2, (float)var3, -16777216);
               lb = (float)GameShell3.renderFrameCount;
            }

            try {
               if (!w) {
               }
            } catch (Exception var19) {
               logger.error("", var19);
            }

            Lb33.d(Lb33.GameDraw);
         } finally {
            Lb33.d(Lb33.GameDraw);
         }
      } else {
         C340.e((float)var0, (float)var1, (float)var2, (float)var3, -16777216);
      }
   }

   public static void ca(UUID var0, int var1) {
   }

   public static void cb() {
      El328 var0 = El328.d(Eu326.TRANSMITVAR_VERIFYID, fx.s);
      Gs329.a(var0.q, fe);
      N272.e(fx, var0);
   }

   public static boolean cl() {
      ++fe;
      ff = true;
      return true;
   }

   static void ao() {
      XElementLibrary.y(XElement.ai);
      XElement.bm();
      ScriptCamera var0 = ScriptCamera.getActiveCamera();
      if (var0 != null) {
         bd = var0.getWorldTransform().trans;
      } else {
         bd = null;
      }

   }

   public static void cm(float var0, float var1, int var2, int var3, int var4, String var5) {
      X390 var6 = new X390();
      var6.g = var0;
      var6.d = var1;
      var6.j = bj + var3;
      var6.q = var2;
      var6.h = var5;
      var6.e = var4;
      Hb335.d(jb, var6);
   }

   public static final void bk() {
      gk = false;
      if (gz.d != null) {
         PhysicsWorldWrapper.l(gz.d);
         gz.d = null;
      }

   }

   private static void w(ArrayList var0, SceneGraphNode var1) {
      if (var1.g() != 0L) {
         var0.add(var1);
      }

      Iterator var2 = var1.ai().iterator();

      while(var2.hasNext()) {
         SceneGraphNode var3 = (SceneGraphNode)var2.next();
         w(var0, var3);
      }

   }

   public static int aa(Vector3 var0) {
      ScriptCamera var1 = ScriptCamera.getActiveCamera();
      if (var1 != null) {
         Vector3 var2 = var1.getWorldTransform().trans;
         float var3 = var0.x - var2.x;
         float var4 = var0.y - var2.y;
         float var5 = var0.z - var2.z;
         float var6 = var3 * var3 + var4 * var4 + var5 * var5;
         if (var6 < 1.0F) {
            var6 = 1.0F;
         }

         return (int)(1000000.0F / var6);
      } else {
         return 0;
      }
   }

   public static boolean u(int var0) {
      return var0 == 11 || var0 == 12;
   }

   public static final void as() {
      fa.cacheRemoveSoftReferences();
      fl.cacheRemoveSoftReferences();
      fd.cacheRemoveSoftReferences();
      fi.cacheRemoveSoftReferences();
      fn.cacheRemoveSoftReferences();
      fm.cacheRemoveSoftReferences();
      fs.cacheRemoveSoftReferences();
      fh.cacheRemoveSoftReferences();
      en.cacheRemoveSoftReferences();
      Aw157.w(eq);
      Eq28.b(ex);
   }

   public static final void ad() {
      Lb33.g(Lb33.Physics);

      try {
         player var0 = Gc330.j();
         int var1 = dc.e();
         int var2 = Lz409.p(Lz409.d);

         Iterator var3;
         player var4;
         for(var3 = Gc330.h().iterator(); var3.hasNext(); var4.a.discardStates(var1)) {
            var4 = (player)var3.next();
            player.bs(var4);
            var4.f.discardStates(var1);
            if (var2 >= 0) {
               var4.c.discardStates(var2);
               var4.ag.discardStates(var2);
            }
         }

         var3 = ft.values().iterator();

         while(var3.hasNext()) {
            Npc var13 = (Npc)var3.next();
            ScheduledMovementComponent.p(var13.i, var1);
            if (var2 >= 0) {
               ScheduledMovementComponent.x(var13.i, var2);
            }
         }

         if (gz.d.d == null) {
            Lb33.d(Lb33.Physics);
         } else {
            Lz409.b(Lz409.d);
            Lz409.y();
            int var12 = df;
            int var14 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(df, Lq191.j() - dz);
            if (la) {
               LuaNativeEvents.invokeOnUpdatePhysicsPre(cj.getLuaStateNativeRef());
               String var5 = "client";
               if (var0 != null) {
                  var5 = "client_" + var0.aq;
               }

               Iterator var6 = Gc330.h().iterator();

               while(var6.hasNext()) {
                  player var7 = (player)var6.next();
                  int var8 = var12;
                  if (var7 != var0) {
                     var8 = var14;
                  }

                  PlayerPhysicsComponent.p((PlayerPhysicsComponent)player.eb(var7, PlayerPhysicsComponent.class), var8, false, true, var5);
                  ((PlayerPhysicsComponent)player.eb(var7, PlayerPhysicsComponent.class)).i(var8, false);
               }

               if (mm != null) {
                  var6 = mm.x(ScheduledMovementComponent.class).iterator();

                  while(var6.hasNext()) {
                     ScheduledMovementComponent var16 = (ScheduledMovementComponent)var6.next();
                     ScheduledMovementComponent.h(var16, var12, false, true);
                  }
               }

               ArrayList var15 = new ArrayList();
               gz.d.d.ak(var15);
               Y192.q();
               gz.d.j(var15);
               Iterator var17 = Gc330.h().iterator();

               while(var17.hasNext()) {
                  player var18 = (player)var17.next();
                  ((PlayerPhysicsComponent)player.eb(var18, PlayerPhysicsComponent.class)).u();
               }

               if (mm != null) {
                  var17 = mm.x(ScheduledMovementComponent.class).iterator();

                  while(var17.hasNext()) {
                     ScheduledMovementComponent var19 = (ScheduledMovementComponent)var17.next();
                     ScheduledMovementComponent.l(var19);
                  }
               }

               LuaNativeEvents.invokeOnUpdatePhysicsPost(cj.getLuaStateNativeRef());
            }

            df = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(df, 1);
            Lz409.v(df);
            M188.e();
            Lb33.d(Lb33.Physics);
         }
      } finally {
         Lb33.d(Lb33.Physics);
      }
   }

   public static void au() {
      if (fx.q != null) {
         long var0 = System.currentTimeMillis();
         long var2 = var0 - N272.g(fx);
         if (var2 > 200L) {
            El328 var4 = El328.d(Eu326.NO_TIMEOUT, fx.s);
            N272.e(fx, var4);
            N272.d(fx, var0);
         }
      }

   }

   public static final void at() {
      fr = fx.q;
      fx.q = null;
      ap();
   }

   public static boolean r(int var0) {
      return var0 == 0;
   }

   public static void k() {
      cj.event.triggerEvent((String)"__onStartup", (Object)null);
   }

   public static final void bp() {
      Gs329 var0 = fx.b;
      float var1 = Gg3.bl(var0);
      float var2 = Gg3.bl(var0);
      float var3 = Gg3.bl(var0);
      int var4 = Gg3.bd(var0);
      int var5 = Gg3.bd(var0);
      Bt286 var6 = Bt286.m(var0, Ed472.STATIC_SCENERY);
      bx(var1);
      br(var5, var4, var6, var2, var3, 12);
   }

   public static boolean x(int var0) {
      return var0 == 3 || var0 == 6;
   }

   private List cc(List var1) {
      ArrayList var2 = new ArrayList();

      BufferedImage var5;
      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2.add(var5)) {
         String var4 = (String)var3.next();
         var5 = null;

         try {
            URL var6 = this.getClass().getClassLoader().getResource(var4);
            if (var6 == null) {
               var6 = (new File("../clientjar/" + var4)).toURI().toURL();
            }

            if (var6 != null) {
               var5 = ImageIO.read(var6);
            }
         } catch (IOException var7) {
            logger.debug("", var7);
         }
      }

      return var2;
   }

   public static final void bm() {
      C340.q();
      hf = 0;
   }

   public final void init() {
      if (this.checkhost()) {
         Z132.g("client.init()");
         Ev579[] var1 = Ev579.values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            Ev579 var4 = var1[var3];
            String var5 = this.getParameter(var4.aq);
            if (var5 != null) {
               switch(Integer.parseInt(var4.aq)) {
               case 4:
                  z = Gm479.g(Integer.parseInt(var5));
                  if (z != Gm479.WIP && z != Gm479.RC && z != Gm479.BUILDLIVE && z != Gm479.LIVE) {
                     z = Gm479.LIVE;
                  }
                  break;
               case 5:
                  m = Gd27.g(Integer.parseInt(var5));
                  break;
               case 6:
                  n = Language.j(Integer.parseInt(var5));
                  break;
               case 7:
                  f = Integer.parseInt(var5);
                  break;
               case 8:
                  if (var5.equalsIgnoreCase(A412.g)) {
                     i = true;
                  } else {
                     i = false;
                  }
                  break;
               case 9:
                  c = var5;
                  break;
               case 10:
                  o = var5;
                  break;
               case 11:
                  a = Integer.parseInt(var5);
                  break;
               case 12:
                  if (var5.equalsIgnoreCase(A412.g)) {
                     ao = true;
                  } else {
                     ao = false;
                  }
                  break;
               case 13:
                  if (var5.equalsIgnoreCase(A412.g)) {
                     aa = true;
                  } else {
                     aa = false;
                  }
                  break;
               case 14:
                  if (var5.equalsIgnoreCase(A412.g)) {
                     am = true;
                  } else {
                     am = false;
                  }
               case 15:
               case 16:
                  break;
               case 17:
                  ap.q = Integer.parseInt(var5);
                  break;
               case 18:
                  byte[] var10 = G282.q(Mi507.g(var5));
                  if (var10.length < 16) {
                     ah = null;
                  } else {
                     ah = new R273(var10, false);
                  }
                  break;
               case 19:
               case 23:
               default:
                  Ku323.g("Parameter not implemented in client: " + var4.aq, new RuntimeException());
                  break;
               case 20:
                  ap.g = Long.parseLong(var5);
                  break;
               case 21:
                  ap.d = var5;
                  if (ap.d.length() > 50) {
                     ap.d = null;
                  }
                  break;
               case 22:
                  if (var5.equals(A412.g)) {
                     fw = true;
                  } else {
                     fw = false;
                  }
                  break;
               case 24:
                  br = var5;
                  break;
               case 25:
                  if (var5.equalsIgnoreCase(A412.g)) {
                     an = true;
                  } else {
                     an = false;
                  }
                  break;
               case 26:
                  if (var5.equalsIgnoreCase(A412.g)) {
                     k = true;
                  } else {
                     k = false;
                  }
                  break;
               case 27:
                  t = (D123)E294.g(D123.class, Integer.parseInt(var5));
                  if (t == D123.LOCAL) {
                     t = D123.WTWIP;
                  } else if (!D123.d(t, G320.OFFICE) && t != D123.LIVE) {
                     t = D123.LIVE;
                  }
                  break;
               case 28:
                  if (var5.equalsIgnoreCase(A412.g)) {
                     az = true;
                     ip = true;
                  }
                  break;
               case 29:
                  Lf336.j = new Lx337();
                  Lf336.j.g = Integer.parseInt(var5);
                  break;
               case 30:
                  Gg3 var9 = new Gg3(50);
                  Gg3.ag(var9, Long.parseLong(var5));
                  Gg3.ag(var9, (long)(Math.random() * 9.223372036854776E18D));
                  ah = new R273(var9.r, true);
                  break;
               case 31:
                  int var6 = var5.lastIndexOf(58);
                  af = var5.substring(0, var6);
                  av = Integer.parseInt(var5.substring(var6 + 1));
                  System.out.println("Using alias server " + af + ":" + av);
               }
            }
         }

         if (m != Gd27.RUNESCAPE && m != Gd27.ALTERNATEREALITY && m != Gd27.TRANSFORMERS) {
            if (m == Gd27.STELLARDAWN) {
               ii = 640;
               iq = 480;
            }
         } else {
            ii = 765;
            iq = 503;
         }

         GameShell3$FrameParameters var7 = new GameShell3$FrameParameters(ii, iq, ib, ij, m.s);
         boolean var8 = true;
         bu = this;
         this.startApplet(var7, m.h, z.h, 32 + z.s, Js5Archive.getRequiredArrayLength(), var8, 1, 1, am);
      }
   }

   private void s(float var1) {
      Lb33.g(Lb33.MainLoop);

      try {
         Lb33.g(Lb33.zMainLoopBeginning);
         boolean var111 = false;

         try {
            var111 = true;
            Ko370.d();
            Hi86.q(lh);
            if (ac == 16) {
               Lb33.d(Lb33.zMainLoopBeginning);
               Lb33.d(Lb33.MainLoop);
               return;
            }

            Lb33.g(Lb33.NetStats);
            boolean var122 = false;

            try {
               var122 = true;
               hw += var1;
               hd = (int)(hw / 0.02F);
               if (hd > 0) {
                  hw -= (float)(hd * 1) / 50.0F;
               }

               int var2 = 0;

               while(true) {
                  if (var2 >= hd) {
                     Lb33.d(Lb33.NetStats);
                     var122 = false;
                     break;
                  }

                  ++bj;
                  if (bj % 1000 == 1) {
                     GregorianCalendar var3 = new GregorianCalendar();
                     hy = var3.get(11) * 600 + var3.get(12) * 10 + var3.get(13) / 6;
                     hl.setSeed((long)hy);
                  }

                  N272.h(fx);
                  ++var2;
               }
            } finally {
               if (var122) {
                  Lb33.d(Lb33.NetStats);
               }
            }

            t(this, var1);
            if (dt != null) {
               G137.j(dt);
            }

            Lb33.d(Lb33.zMainLoopBeginning);
            var111 = false;
         } finally {
            if (var111) {
               Lb33.d(Lb33.zMainLoopBeginning);
            }
         }

         Lb33.g(Lb33.zSoundManager);
         boolean var100 = false;

         try {
            var100 = true;
            SoundManager.w();
            Lb33.d(Lb33.zSoundManager);
            var100 = false;
         } finally {
            if (var100) {
               Lb33.d(Lb33.zSoundManager);
            }
         }

         Lb33.g(Lb33.zEvents);
         boolean var89 = false;

         try {
            var89 = true;
            if (cj != null) {
               LuaNativeEvents.d(cj.getLuaStateNativeRef(), var1);
            }

            Lb33.d(Lb33.zEvents);
            var89 = false;
         } finally {
            if (var89) {
               Lb33.d(Lb33.zEvents);
            }
         }

         Lb33.g(Lb33.XElementQueue);
         boolean var78 = false;

         try {
            var78 = true;
            XElement.bd();
            if (XElement.ai != null) {
               XElementLibrary.v(XElement.ai);
            }

            Lb33.d(Lb33.XElementQueue);
            var78 = false;
         } finally {
            if (var78) {
               Lb33.d(Lb33.XElementQueue);
            }
         }

         Lb33.g(Lb33.zDebug);
         boolean var67 = false;

         try {
            var67 = true;
            if (cj != null && cj.luaConsole != null) {
               cj.luaConsole.service();
            }

            if (Scripting.q() > 0) {
               Scripting.e(cj.getScriptManagerNativeRef(), cj.getLuaStateNativeRef());
            }

            if (debugconsole.isopen()) {
               debugconsole.e();
            }

            Lb33.d(Lb33.zDebug);
            var67 = false;
         } finally {
            if (var67) {
               Lb33.d(Lb33.zDebug);
            }
         }

         if (r(ac)) {
            Lb33.g(Lb33.Loading);
            boolean var56 = false;

            try {
               var56 = true;
               Load.g();
               doneslowupdate();
               Lb33.d(Lb33.Loading);
               var56 = false;
            } finally {
               if (var56) {
                  Lb33.d(Lb33.Loading);
               }
            }
         } else if (y(ac)) {
            bf();
         }

         if (mm != null) {
            Scene.d(mm);
         }

         if (!y(ac)) {
            W274 var133;
            if (p(ac)) {
               aw(this);
               if (ac == 6) {
                  Lb33.g(Lb33.ProcessActiveLogin);
                  boolean var45 = false;

                  try {
                     var45 = true;
                     var133 = Login.j(var1);
                     if (var133 != null && var133.g != E275.SUCCESS) {
                        if (var133.q != null) {
                           Mf509 var134 = var133.d;
                           var133.q.trigger((Object)null, var134 != null ? var134.getId() : null);
                        }

                        ap();
                     }

                     Lb33.d(Lb33.ProcessActiveLogin);
                     var45 = false;
                  } finally {
                     if (var45) {
                        Lb33.d(Lb33.ProcessActiveLogin);
                     }
                  }
               }
            } else if (u(ac)) {
               ar(var1);
            } else if (ac == 14 || ac == 15) {
               Lb33.g(Lb33.Login);
               boolean var34 = false;

               try {
                  var34 = true;
                  var133 = Login.j(var1);
                  if (var133 != null && var133.g != E275.SUCCESS) {
                     if (ac == 15) {
                        if (Lf336.h) {
                           Lf336.d(Lf336.e.g, Lf336.e.d);
                           Login.d();
                        } else {
                           ap();
                        }
                     } else {
                        ap();
                     }
                  }

                  Lb33.d(Lb33.Login);
                  var34 = false;
               } finally {
                  if (var34) {
                     Lb33.d(Lb33.Login);
                  }
               }
            }
         }

         Lb33.d(Lb33.MainLoop);
      } finally {
         Lb33.d(Lb33.MainLoop);
      }
   }

   public static void an(Q79 var0, String var1) {
      XElementLibrary var2 = new XElementLibrary(lh, lw, var0, new Az669());
      if (var1 == null || w) {
         Hk84.d(lw, XElement.class, new Gv486(ek));
      }

      Hi86.p(lh, Fc454.class, new Gt488(em, "Material"));
      Hi86.p(lh, Skeleton.class, new Gt488(es, "Skeleton"));
      Hi86.p(lh, Fk353.class, new Gt488(eh, "Mesh"));
      Hi86.p(lh, XElement.class, new Gt488(ek, "Element"));
      Hi86.p(lh, Iz11.class, new Gt488(eo, "Physical Geometry"));
      Hi86.p(lh, T101.class, new Gt488(eb, "XArea"));
      Hi86.p(lh, Bh77.class, new Gt488(ef, "XMap"));
      Hi86.p(lh, Bj61.class, new Gu487(eg, "AnimSet", "Animation Set"));
      Hi86.u(lh, Fc454.class, Fc454.i);
      Hi86.u(lh, Skeleton.class, Skeleton.d);
      Hi86.u(lh, Fk353.class, Fk353.k);
      Hi86.u(lh, Iz11.class, Iz11.e);
      Hi86.u(lh, T101.class, T101.d);
      Hi86.u(lh, Bh77.class, Bh77.d);
      Hi86.u(lh, XElement.class, var2.s);
      Hi86.u(lh, Bj61.class, Bj61.d);
      XElement.ai = var2;
      if (var1 != null) {
      }

      byte[] var3 = js5.y(eu, DefaultsGroup.ERROR.js5GroupId);
      if (var3 != null) {
         Hi86.d(lh, new Gg3(var3));
      }

   }

   public static final void cv(int var0) {
      At476.d();
      int var1 = fd.list(var0).clientCode;
      if (var1 != 0) {
         int var2 = jw.getVarValueInt(fd.list(var0));
         if (var1 == 6) {
            jx = var2;
         }

      }
   }

   public static final void bq(long var0) {
      C340.q();
      hf = 0;
   }

   public static final void bf() {
      Lb33.g(Lb33.MapBuild);

      try {
         bv(false);
         if (!gb.g()) {
            Lb33.d(Lb33.MapBuild);
         } else {
            if (mm != null) {
               Iterator var0 = Gc330.h().iterator();

               while(var0.hasNext()) {
                  player var1 = (player)var0.next();
                  PlayerPhysicsComponent.l((PlayerPhysicsComponent)player.eb(var1, PlayerPhysicsComponent.class));
                  var1.ba = null;
                  mm.remove(var1, true, false);
               }

               var0 = ft.values().iterator();

               while(var0.hasNext()) {
                  Npc var8 = (Npc)var0.next();
                  Npc.cp(var8);
                  mm.remove(var8, true, false);
               }

               var0 = ClientScriptAPI.g.iterator();

               while(var0.hasNext()) {
                  ScriptCamera var9 = (ScriptCamera)var0.next();
                  mm.remove(var9, true, false);
               }
            }

            long var7 = Gz143.g();
            logger.debug("Profile: Starting...");
            ak();
            Iterator var2 = Gc330.h().iterator();

            player var3;
            while(var2.hasNext()) {
               var3 = (player)var2.next();
               if (player.ee(var3, PlayerPhysicsComponent.class)) {
                  player.co(var3);
               }
            }

            if (mm != null) {
               Scene.u(mm);
               mm = null;
            }

            Bv351.d(gf);
            gf = new Bv351();
            ca.clear();
            System.gc();
            mg = new E254();
            mm = new Scene(mg);
            At476.g(false);
            SoundManager.r();
            bv(true);
            logger.debug("Profile: Reset took: {} ms", Gz143.g() - var7);
            var7 = Gz143.g();
            logger.debug("Profile: Overworld ground build took: {} ms", Gz143.g() - var7);
            var7 = Gz143.g();
            bv(true);
            bn();
            logger.debug("Profile: Overworld location load took: {} ms", Gz143.g() - var7);
            var7 = Gz143.g();
            bv(true);
            logger.debug("Profile: Overworld finish ground took: {} ms", Gz143.g() - var7);
            var7 = Gz143.g();
            var2 = Gc330.h().iterator();

            while(var2.hasNext()) {
               var3 = (player)var2.next();
               mm.add(var3);
               if (player.ee(var3, PlayerPhysicsComponent.class)) {
                  player.cy(var3);
               }
            }

            var2 = ft.values().iterator();

            while(var2.hasNext()) {
               Npc var11 = (Npc)var2.next();
               mm.add(var11);
               Npc.cd(var11);
            }

            var2 = ClientScriptAPI.g.iterator();

            while(var2.hasNext()) {
               ScriptCamera var12 = (ScriptCamera)var2.next();
               mm.add(var12);
            }

            SoundManager.r();
            El328 var10;
            if (GameShell3.getEnvironment() == GameShell3$Environment.APPLICATION && fx.q != null && ac == 12) {
               var10 = El328.d(Eu326.DETECT_MODIFIED_CLIENT, fx.s);
               Gs329.a(var10.q, 1057001181);
               N272.e(fx, var10);
            }

            if (ac == 4) {
               z(3);
            } else {
               z(11);
               if (fx.q != null) {
                  var10 = El328.d(Eu326.MAP_BUILD_COMPLETE, fx.s);
                  N272.e(fx, var10);
               }
            }

            SoundManager.r();
            ao();
            doneslowupdate();
            logger.debug("Profile: Final stage took: {} ms", Gz143.g() - var7);
            var7 = Gz143.g();
            if (gc) {
               debugconsole.addline(Long.toString(Gz143.g() - gv));
               gc = false;
            }

            Lb33.d(Lb33.MapBuild);
         }
      } finally {
         Lb33.d(Lb33.MapBuild);
      }
   }
}
