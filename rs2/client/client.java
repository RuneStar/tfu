/*
 * Decompiled with CFR 0.146.
 */
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
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$DataMessagePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessagePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.broadcast.CommonStateAndEventTypes;
import com.jagex.game.runetek6.comms.broadcast.SceneryConfig;
import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
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
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerType;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
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
import com.jagex.game.runetek6.script.LuaDebugEclipseConsole;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.xelement.Am76;
import com.jagex.game.runetek6.xelement.Ao74;
import com.jagex.game.runetek6.xelement.Bh77;
import com.jagex.game.runetek6.xelement.Bj61;
import com.jagex.game.runetek6.xelement.Bk68;
import com.jagex.game.runetek6.xelement.Bn70;
import com.jagex.game.runetek6.xelement.J113;
import com.jagex.game.runetek6.xelement.Q79;
import com.jagex.game.runetek6.xelement.T101;
import com.jagex.game.runetek6.xelement.W14;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.jnibindings.runetek6.IrradianceVolumes;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import com.jagex.jnibindings.runetek6.NativeResourceLoader;
import com.jagex.jnibindings.runetek6.NavPowerClient;
import com.jagex.jnibindings.runetek6.ProcessInfo;
import com.jagex.jnibindings.runetek6.RuntimeTool.F511;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.jnibindings.runetek6.Skeleton;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
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
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.Buffer;
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
import rs2.client.A412;
import rs2.client.Af666;
import rs2.client.Ag389;
import rs2.client.Ah608;
import rs2.client.Al161;
import rs2.client.Ap386;
import rs2.client.Aq668;
import rs2.client.Az669;
import rs2.client.B402;
import rs2.client.C414;
import rs2.client.D150;
import rs2.client.E413;
import rs2.client.F407;
import rs2.client.G408;
import rs2.client.H393;
import rs2.client.J160;
import rs2.client.K398;
import rs2.client.L410;
import rs2.client.M411;
import rs2.client.N272;
import rs2.client.O396;
import rs2.client.ScriptCamera;
import rs2.client.T404;
import rs2.client.U406;
import rs2.client.V385;
import rs2.client.W159;
import rs2.client.X390;
import rs2.client.Y388;
import rs2.client.Z392;
import rs2.client.chat.G232;
import rs2.client.debugconsole;
import rs2.client.friends.ClientFriendListComponent;
import rs2.client.friends.D236;
import rs2.client.friends.J228;
import rs2.client.inventory.ClientInventory;
import rs2.client.inventory.G451;
import rs2.client.loading.Load;
import rs2.client.loading.Q162;
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
import rs2.client.worldelement.L51;
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
import tfu.Br121;
import tfu.Bs1;
import tfu.Bt286;
import tfu.Bu350;
import tfu.Bv351;
import tfu.Bz650;
import tfu.C340;
import tfu.Cd585;
import tfu.D285;
import tfu.Df147;
import tfu.Dg449;
import tfu.Dp208;
import tfu.Dr574;
import tfu.Dv322;
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
import tfu.Hw321;
import tfu.Hx339;
import tfu.Ia63;
import tfu.Ic327;
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
import tfu.Lz409;
import tfu.Md230;
import tfu.Mf509;
import tfu.Mi507;
import tfu.Mk163;
import tfu.Mn54;
import tfu.Ms517;
import tfu.Mu209;
import tfu.Mv477;
import tfu.W667;

@Kv538(value=true)
public class client
extends GameShell3 {
    public static int a;
    public static boolean aa;
    public static String[] ab;
    public static int ac;
    private static long ad;
    public static boolean ae;
    public static String af;
    private static final Color ag;
    public static R273 ah;
    public static String ai;
    public static Fr156 aj;
    static final int ak = 100;
    public static String al;
    public static boolean am;
    public static boolean an;
    public static boolean ao;
    public static H577 ap;
    private static final Color aq;
    public static Matrix4 ar;
    public static int as;
    private static F511 at;
    public static H303 au;
    public static int av;
    public static int aw;
    public static H303 ax;
    static final float ay = 0.3f;
    public static boolean az;
    public static int b;
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
    public static double d;
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
    public static boolean e;
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
    public static int f;
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
    public static boolean i;
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
    public static int j;
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
    public static boolean k;
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
    private static final Bu350 l;
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
    static final Logger logger;
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
    public static Gd27 m;
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
    public static String o;
    private static final char[] p;
    public static int q;
    public static final boolean r = false;
    public static long s;
    public static D123 t;
    private static int u;
    private static final boolean v = true;
    public static boolean w = true;
    public static Gm479 z;
    private B402 cq = null;

    @Be2
    @Bs1
    public static void nativeMouseInputMove(int n, int n2) {
        if (client.fx.s != null) {
            if (n < -1) {
                n = -1;
            } else if (n > 65534) {
                n = 65534;
            }
            if (n2 < -1) {
                n2 = -1;
            } else if (n2 > 65534) {
                n2 = 65534;
            }
            if (cg != n || ct != n2) {
                El328 el328 = El328.d(Eu326.EVENT_MOUSE_MOVE, client.fx.s);
                Gs329.k(el328.q, 0);
                int n3 = el328.q.v;
                int n4 = n - cg;
                cg = n;
                int n5 = n2 - ct;
                ct = n2;
                int n6 = (int)((Gz143.g() - cm) / 20L);
                if (n6 < 8 && n4 >= -32 && n4 <= 31 && n5 >= -32 && n5 <= 31) {
                    Gs329.i(el328.q, (n6 << 12) + ((n4 += 32) << 6) + (n5 += 32));
                } else if (n6 < 32 && n4 >= -128 && n4 <= 127 && n5 >= -128 && n5 <= 127) {
                    Gs329.k(el328.q, 128 + n6);
                    Gs329.i(el328.q, ((n4 += 128) << 8) + (n5 += 128));
                } else if (n6 < 32) {
                    Gs329.k(el328.q, 192 + n6);
                    if (n == 1 || n2 == -1) {
                        Gs329.a(el328.q, Integer.MIN_VALUE);
                    } else {
                        Gs329.a(el328.q, n | n2 << 16);
                    }
                } else {
                    Gs329.i(el328.q, 57344 + n6);
                    if (n == 1 || n2 == -1) {
                        Gs329.a(el328.q, Integer.MIN_VALUE);
                    } else {
                        Gs329.a(el328.q, n | n2 << 16);
                    }
                }
                cm = Gz143.g();
                Gs329.ac(el328.q, el328.q.v - n3);
                N272.e(fx, el328);
            }
        }
    }

    public static final native void nativeSetFocus();

    public static void by() {
        if (ac != 11) {
            return;
        }
        if (ac == 3) {
            client.z(4);
        } else if (ac == 11) {
            client.z(12);
        }
    }

    @Be2
    public static void main(String[] arrstring) {
        if (arrstring.length != 6 && arrstring.length != 7) {
            client.j("Argument count");
        }
        logger.debug("start");
        client.q(arrstring, new client());
    }

    static void bb() {
        client.bt();
        la = true;
        M188.w();
        client.cj.event.triggerEvent("__onMapFullyBuilt", null);
        Lz409.b = 0;
        Lz409.l = 0;
        if (F511.j(at) && !F511.e(at)) {
            F511.q(at);
            Z132.q("MapBuildState_" + F511.h(at));
        }
    }

    private static final void j(String string) {
        logger.error("Bad " + string + ", Usage: worldid, lobbyid, demoworldid, <live/rc/wip>, <english/german>, <game0/game1>, <loading bar config>");
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

    @Override
    public final void maininit() {
        js5.i = false;
        Hi86.q(lh);
        Gl480.d = true;
        Frame frame = new Frame(" ");
        frame.pack();
        frame.dispose();
        dj = new L145();
        dm = new W144();
        Mv477.g(new int[]{20, 260}, new int[]{1000, 100});
        I48.g(4096);
        O166.g(4096);
        Ag566.g(128);
        CommonStateAndEventTypes.Init(false);
        if (t == D123.INTBETA || t == D123.LIVE) {
            Lf336.j.d = this.getCodeBase().getHost();
        } else if (af != null) {
            Lf336.j.d = af;
            Lf336.j.g = av;
            Lf336.j.q = 40000 + Lf336.j.g;
            Lf336.j.j = 50000 + Lf336.j.g;
        } else if (D123.d(t, G320.OFFICE)) {
            Lf336.j.d = this.getCodeBase().getHost();
            Lf336.j.q = 40000 + Lf336.j.g;
            Lf336.j.j = 50000 + Lf336.j.g;
        } else if (t == D123.LOCAL) {
            Lf336.j.q = 40000 + Lf336.j.g;
            Lf336.j.j = 50000 + Lf336.j.g;
        }
        Lf336.q = Lf336.j;
        try {
            Al161.d(InetAddress.getByName(Lf336.q.d));
        }
        catch (UnknownHostException unknownHostException) {
            // empty catch block
        }
        if (m == Gd27.RUNESCAPE) {
            ba = false;
        }
        ObjType.clientpalette = new short[256];
        hi = ObjType.clientpalette;
        try {
            jc = this.getToolkit().getSystemClipboard();
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (t != D123.LIVE) {
            bx = true;
        }
        client.setPhysicsSpeed(Lq191.g());
        GameShell3.loadingTitle = Mk163.g(Mk163.LOADING, n);
        Bz650.g(!D123.d(t, G320.HAS_EXTERNAL_ACCESS));
        Bz650.d(Ed472.values());
        Bz650.q(Ej287.values());
        GameEntity.bf = Ba115.d(Ej287.CLIENT_SCRIPTED);
        GameEntity.bn = Ba115.d(Ej287.CLIENT_ATTACHMENT);
        ai = System.getProperty("jagex.packcontentpath");
        if (ai != null && !new File(ai).isDirectory()) {
            ai = null;
            throw new RuntimeException("Invalid Pack Content Path : " + ai);
        }
        al = System.getProperty("jagex.srccontentpath");
        if (al != null && !new File(al).isDirectory()) {
            al = null;
            throw new RuntimeException("Invalid Source Content Path : " + al);
        }
        Y192.g(true);
    }

    @Override
    public final void mainphysics() {
        Lb33.g(Lb33.UDP);
        try {
            try {
                Lb33.g(Lb33.ProcessIncoming);
                try {
                    dq.processIncomingPackets();
                    Lb33.d(Lb33.ProcessIncoming);
                }
                catch (Throwable throwable) {
                    Lb33.d(Lb33.ProcessIncoming);
                    throw throwable;
                }
                Lb33.g(Lb33.SendOutgoing);
                dq.sendOutgoingPackets();
                Lb33.d(Lb33.SendOutgoing);
            }
            catch (Exception exception) {
                logger.error("Exception servicing state stream synchronizer", exception);
                client.at();
                Lb33.d(Lb33.UDP);
            }
            Lb33.d(Lb33.UDP);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.UDP);
            throw throwable;
        }
        if (gb != null && !D285.j(gb)) {
            return;
        }
        if (kx) {
            client.e();
        }
        if (gk && M188.s() < 1.0f) {
            client.ad();
        }
    }

    private static void e() {
        float f;
        float f2;
        int n;
        float f3 = 0.25f;
        int n2 = ln;
        if ((float)(System.nanoTime() - ll) > 2.0f * Lq191.d() * 1.0E9f) {
            n2 = 0;
        }
        if ((f2 = kn - (f = (float)n2 / f3)) < (float)(n = Lq191.g()) / 2.0f) {
            f2 = (float)n / 2.0f;
        }
        if (f2 > (float)n * 2.0f) {
            f2 = (float)n * 2.0f;
        }
        client.setPhysicsSpeed(f2);
    }

    @Override
    public void cycleend(boolean bl) {
        Lv148.d(bl);
    }

    @Override
    public void mainloop(float f) {
        this.s(f);
    }

    private void h(float f) {
        if (!e) {
            return;
        }
        if (s == 0L) {
            s = Kc180.g(b);
            if (s == 0L) {
                logger.error("pNativeBuffer == null");
            } else {
                logger.debug("allocated " + b + " bytes for pNativeBuffer");
            }
        }
        if (s != 0L) {
            player player2 = Gc330.j();
            ScriptCamera scriptCamera = ScriptCamera.getActiveCamera();
            ScaleRotTrans scaleRotTrans = ScaleRotTrans.g;
            if (player2 != null) {
                scaleRotTrans = player2.getWorldTransform();
            }
            ScaleRotTrans scaleRotTrans2 = ScaleRotTrans.g;
            Matrix4 matrix4 = Matrix4.g;
            if (scriptCamera != null) {
                scaleRotTrans2 = scriptCamera.getWorldTransform();
                matrix4 = scriptCamera.getProjMatrix();
            }
            long l = s;
            byte by = (byte)H149.e;
            Kc180.b(l, by);
            Kc180.s(++l, H149.h);
            Kc180.v(l += (long)H149.d, scaleRotTrans.scale);
            Kc180.v(l += 4L, scaleRotTrans2.rot.x);
            Kc180.v(l += 4L, scaleRotTrans2.rot.y);
            Kc180.v(l += 4L, scaleRotTrans2.rot.z);
            Kc180.v(l += 4L, scaleRotTrans2.rot.w);
            Kc180.v(l += 4L, scaleRotTrans2.trans.x);
            Kc180.v(l += 4L, scaleRotTrans2.trans.y);
            Kc180.v(l += 4L, scaleRotTrans2.trans.z);
            Kc180.v(l += 4L, matrix4.f00);
            Kc180.v(l += 4L, matrix4.f01);
            Kc180.v(l += 4L, matrix4.f02);
            Kc180.v(l += 4L, matrix4.f03);
            Kc180.v(l += 4L, matrix4.f10);
            Kc180.v(l += 4L, matrix4.f11);
            Kc180.v(l += 4L, matrix4.f12);
            Kc180.v(l += 4L, matrix4.f13);
            Kc180.v(l += 4L, matrix4.f20);
            Kc180.v(l += 4L, matrix4.f21);
            Kc180.v(l += 4L, matrix4.f22);
            Kc180.v(l += 4L, matrix4.f23);
            Kc180.v(l += 4L, matrix4.f30);
            Kc180.v(l += 4L, matrix4.f31);
            Kc180.v(l += 4L, matrix4.f32);
            Kc180.v(l += 4L, matrix4.f33);
            l += 4L;
            long l2 = 0L;
            if (gz != null && client.gz.d != null && client.gz.d.d != null) {
                l2 = DiscreteDynamicsWorld.g(client.gz.d.d);
            }
            Kc180.s(l, l2);
            l += (long)Kc180.e();
            int n = -1;
            RotTrans rotTrans = RotTrans.g;
            RotTrans rotTrans2 = RotTrans.g;
            if (player2 != null) {
                RotTrans rotTrans3;
                rotTrans = rotTrans3 = player2.getWorldTransform().q();
                rotTrans2 = rotTrans3;
                PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)player.eb(player2, PlayerPhysicsComponent.class);
                if (playerPhysicsComponent != null) {
                    Object object;
                    Object object2;
                    Integer n2 = PlayerPhysicsComponent.m(playerPhysicsComponent, false);
                    if (n2 != null && (object2 = PlayerAvatarDescriptor.g(n2)) != null) {
                        object = Vector3.al(Vector3.q, rotTrans3.rot);
                        rotTrans = rotTrans3.r((Vector3)object, PlayerAvatarDescriptor.h((PlayerAvatarDescriptor)object2) * 0.9f);
                        rotTrans2 = rotTrans2.s(Gh19.g);
                        rotTrans2 = rotTrans2.r((Vector3)object, PlayerAvatarDescriptor.h((PlayerAvatarDescriptor)object2) * 0.5f);
                        rotTrans2 = PlayerAvatarDescriptor.l((PlayerAvatarDescriptor)object2, rotTrans2);
                    }
                    if ((object2 = playerPhysicsComponent.getAvatar(false)) != null && (object = ((PlayerPhysicsAvatar)object2).e) != null) {
                        n = (int)((CollisionObject)object).s;
                    }
                }
            }
            Kc180.r(l, n);
            Kc180.r(l += 4L, Gn5.CAMERA_COLLIDE.ordinal());
            Kc180.r(l += 4L, Gn5.CAMERA_SIGHT.ordinal());
            Kc180.v(l += 4L, rotTrans.trans.x);
            Kc180.v(l += 4L, rotTrans.trans.y);
            Kc180.v(l += 4L, rotTrans.trans.z);
            Kc180.v(l += 4L, rotTrans2.rot.x);
            Kc180.v(l += 4L, rotTrans2.rot.y);
            Kc180.v(l += 4L, rotTrans2.rot.z);
            Kc180.v(l += 4L, rotTrans2.rot.w);
            Kc180.v(l += 4L, rotTrans2.trans.x);
            Kc180.v(l += 4L, rotTrans2.trans.y);
            Kc180.v(l += 4L, rotTrans2.trans.z);
            if ((l += 4L) > s + (long)b) {
                throw new Error("Buffer overrun - wrote " + (l - s) + " bytes, only had room for " + b + " - bailing out!");
            }
            client.nativeUpdateGameplayStates(s, b, f);
            l = s;
            float f2 = Kc180.u(l);
            float f3 = Kc180.u(l += 4L);
            float f4 = Kc180.u(l += 4L);
            float f5 = Kc180.u(l += 4L);
            float f6 = Kc180.u(l += 4L);
            float f7 = Kc180.u(l += 4L);
            float f8 = Kc180.u(l += 4L);
            float f9 = Kc180.u(l += 4L);
            float f10 = Kc180.u(l += 4L);
            float f11 = Kc180.u(l += 4L);
            float f12 = Kc180.u(l += 4L);
            float f13 = Kc180.u(l += 4L);
            bm = new Matrix4(f2, f3, f4, 0.0f, f5, f6, f7, 0.0f, f8, f9, f10, 0.0f, f11, f12, f13, 1.0f);
            bq = new Vector3(f11, f12, f13);
            bo = bm.j();
            bl = bo.g(matrix4);
            bw = Kc180.u(l += 4L);
            if ((l += 4L) > s + (long)b) {
                throw new Error("Buffer overrun - read " + (l - s) + " bytes, only had room for " + b + " - bailing out!");
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

    @Override
    public void mainredraw() {
        Lb33.g(Lb33.MainRedraw);
        try {
            if (ac == 16) {
                Lb33.d(Lb33.MainRedraw);
                return;
            }
            long l = System.nanoTime() / 1000000L;
            long l2 = l - ad;
            if (ad == 0L) {
                l2 = 20L;
            }
            ad = l;
            Lb33.g(Lb33.zAudioRender);
            client.b(this);
            Lb33.d(Lb33.zAudioRender);
            Lb33.g(Lb33.zTweening);
            if (mm != null && gb != null && D285.j(gb)) {
                M188.h((float)l2 * 0.001f);
                if (gk) {
                    while (M188.s() < 0.0f) {
                        client.ad();
                    }
                }
                for (com.jagex.game.runetek6.gameentity.Component component : mm.x(ScheduledMovementComponent.class)) {
                    ((ScheduledMovementComponent)component).w((float)l2 * 0.001f);
                }
                for (com.jagex.game.runetek6.gameentity.Component component : mm.x(PlayerPhysicsComponent.class)) {
                    ((PlayerPhysicsComponent)component).z();
                }
            }
            Lb33.d(Lb33.zTweening);
            Lb33.g(Lb33.UpdateGameplayStates);
            if (!client.r(ac) && !client.y(ac)) {
                H149.q(cj.getLuaStateNativeRef(), (float)l2 * 0.001f);
            }
            this.h((float)l2 * 0.001f);
            if (!client.r(ac) && !client.y(ac)) {
                H149.j(cj.getLuaStateNativeRef(), (float)l2 * 0.001f);
            }
            Lb33.d(Lb33.UpdateGameplayStates);
            Lb33.g(Lb33.zGamedrawmain);
            if (ac == 11) {
                client.bo(0, 0, GameShell3.canvasWid, GameShell3.canvasHei);
            }
            if (GameShell3.fsframe == null) {
                Container container = this.getTopContainer();
                int n = container.getSize().width;
                int n2 = container.getSize().height;
                if (container == GameShell3.frame) {
                    Insets insets = GameShell3.frame.getInsets();
                    n -= insets.left + insets.right;
                    n2 -= insets.top + insets.bottom;
                }
                if (n != GameShell3.frameWid || n2 != GameShell3.frameHei) {
                    GameShell3.frameWid = n;
                    GameShell3.frameHei = n2;
                    ir = Gz143.g() + 500L;
                    bt = false;
                    client.aq();
                }
            }
            if (Hq338.g && GameShell3.fsframe != null && client.v(ac)) {
                client.f(W159.g().j, -1, -1, false);
            }
            B665.q(B665.g());
            int n = 0;
            if (GameShell3.fullredraw) {
                GameShell3.fullredraw = false;
                n = 1;
            }
            if (e && GameShell3.focus && !bh) {
                client.nativeSetFocus();
            }
            bh = GameShell3.focus;
            if (n != 0) {
                client.al();
            }
            if (client.r(ac)) {
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
                if (client.x(ac)) {
                    client.bm();
                } else if (ac == 11) {
                    client.bq(l2);
                }
            }
            Lb33.d(Lb33.zGamedrawmain);
            Lb33.g(Lb33.zNavPower);
            if (client.ni.g != null) {
                for (n = 0; n < Jh522.g(client.ni.g); ++n) {
                    byte[] arrby = Jh522.q(client.ni.g, n);
                    if (arrby.length <= 0) continue;
                    if (nc == null || nc.capacity() < arrby.length) {
                        nc = ByteBuffer.allocateDirect(arrby.length);
                    }
                    nc.position(0);
                    nc.put(arrby);
                    NavPowerClient.renderFromRenderData(nc, arrby.length, -gn, -gj);
                }
            }
            Lb33.d(Lb33.zNavPower);
            Lb33.g(Lb33.zNativeRender);
            try {
                if (debugconsole.isopen()) {
                    debugconsole.w();
                }
                int n3 = ac;
                int n4 = ac;
                if (dp) {
                    client.bl(20, 20);
                }
                ScriptCamera scriptCamera = ScriptCamera.getActiveCamera();
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                float f6 = 0.0f;
                if (scriptCamera != null) {
                    f = scriptCamera.i;
                    f2 = scriptCamera.o;
                    f3 = scriptCamera.c;
                    f4 = scriptCamera.a;
                    f5 = scriptCamera.ag;
                    f6 = scriptCamera.f;
                }
                player player2 = Gc330.j();
                ArrayList<E> arrayList = new ArrayList<E>();
                if (player2 != null) {
                    client.w(arrayList, player2);
                }
                Collection collection = client.l();
                H149.e(ax, ar, mg != null ? client.mg.d : null, (float)l2 * 0.001f, f, f2, f3, f4, f5, f6, arrayList, collection);
                if (bg) {
                    client.am();
                }
                Lb33.d(Lb33.zNativeRender);
            }
            catch (Throwable throwable) {
                Lb33.d(Lb33.zNativeRender);
                throw throwable;
            }
            Lb33.d(Lb33.MainRedraw);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.MainRedraw);
            throw throwable;
        }
    }

    private static Collection l() {
        if (client.gz.d == null) {
            return null;
        }
        GameEntity[] arrgameEntity = client.gz.d.getEntitiesInSphere(bq, bw, Gn5.PLAYER_OR_NPC_VOLUME_QUERY.ordinal(), Gj16.NONE.az, 128);
        ArrayList<E> arrayList = new ArrayList<E>();
        player player2 = Gc330.j();
        for (GameEntity gameEntity : arrgameEntity) {
            if (gameEntity == player2 || !GameEntity.ee(gameEntity, PlayerComponent.class) && !GameEntity.ee(gameEntity, NpcComponent.class)) continue;
            client.w(arrayList, gameEntity);
        }
        return arrayList;
    }

    static {
        logger = LoggerFactory.getLogger(client.class);
        d = 0.0;
        q = 0;
        j = 0;
        e = false;
        s = 0L;
        b = 200;
        l = new Bu350(3, "Client utilPool");
        w = false;
        p = new char[200];
        u = 0;
        m = null;
        k = false;
        i = false;
        o = "";
        f = 0;
        ag = new Color(128, 0, 0);
        aq = new Color(80, 80, 80);
        af = null;
        av = 0;
        az = false;
        ap = new H577();
        ao = false;
        aa = false;
        an = false;
        am = false;
        as = 0;
        ac = 0;
        at = new F511();
        ab = new String[]{"Loading", "Loading 2", "Loading 3", "Login screen", "Login screen (Map build)", "Logging in from loginscreen to lobby", "Logging in from loginscreen to game", "Lobby screen", "Lobby screen (Map build)", "Logging in from lobbyscreen to game", "Logging in from lobbyscreen to game (Map build)", "Game screen", "Game screen (Map build)", "Logging in from gamescreen to lobby", "Reconnecting", "Switch World", "Error"};
        aw = 1;
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
        bi = (long)(Math.random() * 9.999999999E9);
        bt = false;
        bz = 0;
        bc = false;
        cw = true;
        cp = 0;
        cd = 0;
        ck = new ArrayList<E>();
        ce = new ArrayList<E>();
        ca = new IdentityHashMap<K, V>();
        cv = new ArrayDeque<E>();
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
        di = 0.0f;
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
        ft = new HashMap<K, V>();
        fx = new N272();
        fe = 0;
        ff = false;
        gq = -1.0f;
        gp = 104;
        gy = 104;
        gh = 1.0f;
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
        hw = 0.0f;
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
        kn = Lq191.g();
        kc = 0.0;
        kp = 99999.0;
        kq = 0.0;
        ky = 0.0;
        ld = 0.0;
        lo = 0.0;
        ln = 0;
        ll = 0L;
        lz = RotTrans.g;
        lh = new Hi86(Integer.class);
        lw = new Hk84();
        lj = 0L;
        la = false;
        lv = false;
        lt = -1.0f;
        lb = -1.0f;
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

    public static final void q(String[] arrstring, client client2) {
        try {
            System.setErr(System.out);
            Lf336.j = new Lx337();
            try {
                Lf336.j.g = Integer.parseInt(arrstring[0]);
                Lf336.j.d = A412.b;
            }
            catch (NumberFormatException numberFormatException) {
                String[] arrstring2 = StringTools.y(arrstring[0], ':');
                if (arrstring2.length != 2) {
                    throw new Exception("Invalid server address - should be of the form host-name:node-id");
                }
                Lf336.d = arrstring2[0];
                Lf336.j.g = Integer.parseInt(arrstring2[1]);
                Lf336.j.d = Lf336.d;
            }
            t = D123.LOCAL;
            if (arrstring[3].equals("live")) {
                z = Gm479.LIVE;
            }
            if (arrstring[3].equals("buildlive")) {
                z = Gm479.BUILDLIVE;
            } else if (arrstring[3].equals("rc")) {
                z = Gm479.RC;
            } else if (arrstring[3].equals("wip")) {
                z = Gm479.WIP;
            } else {
                client.j("modewhat");
            }
            n = Language.q(arrstring[4]);
            if (n == null) {
                if (arrstring[4].equals("english")) {
                    n = Language.EN;
                } else if (arrstring[4].equals("german")) {
                    n = Language.DE;
                } else {
                    client.j("language");
                }
            }
            k = false;
            if (arrstring[5].equals("game0")) {
                m = Gd27.RUNESCAPE;
            } else if (arrstring[5].equals("game1")) {
                m = Gd27.STELLARDAWN;
            } else if (arrstring[5].equals("game2")) {
                m = Gd27.ALTERNATEREALITY;
            } else if (arrstring[5].equals("game3")) {
                m = Gd27.TRANSFORMERS;
            } else if (arrstring[5].equals("game4")) {
                m = Gd27.SCRATCH;
            } else {
                client.j("game");
            }
            az = true;
            ip = true;
            System.loadLibrary("jawt");
            boolean bl = false;
            if (System.getProperty("jagex.useCache") != null) {
                bl = Boolean.parseBoolean(System.getProperty("jagex.useCache"));
            }
            bu = client2;
            client2.startApplication(1280, 720, client.m.h, client.z.h, 32 + client.z.s, Js5Archive.getRequiredArrayLength(), bl, 1, 1);
            GameShell3.frame.setLocation(40, 40);
        }
        catch (Exception exception) {
            Ku323.g(null, exception);
        }
    }

    public static boolean v(int n) {
        return n == 3 || n == 11;
    }

    public static boolean y(int n) {
        return n == 4 || n == 12;
    }

    public static boolean p(int n) {
        return n == 3 || n == 4 || n == 6;
    }

    public static void z(int n) {
        if (ac == n) {
            return;
        }
        ac = n;
        String string = null;
        switch (n) {
            case 3: {
                string = "loginscreen";
                break;
            }
            case 4: {
                string = "buildingmap";
                break;
            }
            case 6: {
                string = "login";
                break;
            }
            case 11: {
                string = "game";
                break;
            }
            case 12: {
                string = "buildmap";
                break;
            }
            case 14: {
                string = "reconnect";
                break;
            }
            case 15: {
                string = "switchworld";
                break;
            }
            case 16: {
                string = "error";
            }
        }
        client.cj.event.triggerEvent("__onLoadState", (Object)string);
        logger.debug("Mainstate: {} {}", (Object)ab[n], (Object)Gz143.g());
        if (n == 14) {
            Login.q();
        }
        if (n == 15) {
            Login.d();
        }
        if (n == 13) {
            Login.g();
        }
        if (n != 14 && fr != null) {
            fr.h();
            fr = null;
        }
        if (n == 3) {
            client.k();
        }
        if (client.y(ac)) {
            client.dr.m = 2;
            client.et.m = 2;
            if (F511.e(at)) {
                F511.g(at);
            }
            if (!F511.j(at)) {
                F511.d(at);
                Z132.g("MapBuildState_" + F511.h(at));
            }
        }
        if (client.y(n)) {
            client.dr.m = 1;
            client.et.m = 1;
        }
        if (n == 12 || n == 3) {
            G405.d(bu, client.getEnvironment());
        }
    }

    public static void t(client client2, float f) {
        Lb33.g(Lb33.NetClient);
        try {
            boolean bl = dm.s();
            if (!bl) {
                client2.m(f);
            }
            Lb33.d(Lb33.NetClient);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.NetClient);
            throw throwable;
        }
    }

    public void m(float f) {
        if (client.dm.u > ev) {
            logger.debug("Js5connect error: {}", client.dm.z);
            Lx337.q(Lf336.q);
            di = (float)(client.dm.u - 1) * 5.0f;
            if (di > 60.0f) {
                di = 60.0f;
            }
            if (client.dm.u >= 2 && client.dm.z == Mf509.CLIENT_OUT_OF_DATE.getId()) {
                this.error("js5connect_outofdate");
                client.z(16);
                return;
            }
            if (client.dm.u >= 4 && client.dm.z == -1) {
                this.error("js5crc");
                client.z(16);
                return;
            }
            if (client.dm.u >= 4 && client.r(ac)) {
                if (client.dm.z == Mf509.SERVER_FULL.getId() || client.dm.z == Mf509.IP_LIMIT.getId()) {
                    this.error("js5connect_full");
                } else if (client.dm.z > 0) {
                    if (ed == null) {
                        this.error("js5connect");
                    } else {
                        this.error("js5proxy_" + ed.trim());
                    }
                } else {
                    this.error("js5io");
                }
                client.z(16);
                return;
            }
        }
        ev = client.dm.u;
        if (di > 0.0f) {
            di -= f;
            return;
        }
        try {
            int n;
            Object object;
            if (dk == 0) {
                logger.trace("Attempting js5remote connection on port: {}", Lx337.d(Lf336.q));
                ci = Lf336.q.g();
            }
            if (++dk == 1) {
                ch = Hx339.g(ci, 25000);
                object = new Gg3(9);
                Gg3.k((Gg3)object, Ex582.INIT_JS5REMOTE_CONNECTION.w);
                Gg3.a((Gg3)object, 1);
                Gg3.a((Gg3)object, 1);
                ch.e(object.r, 0, 9);
                ++dk;
                da = Gz143.g();
            }
            if (dk == 2) {
                if (ch.d(1)) {
                    object = new byte[1];
                    n = ch.j((byte[])object, 0, 1);
                    if (object[0] != false) {
                        client.n(this, n);
                        return;
                    }
                    logger.trace("Js5connect ok: {}", n);
                    ++dk;
                } else if (Gz143.g() - da > 30000L) {
                    client.n(this, 1001);
                    return;
                }
            }
            if (dk == 3 && ch.d(n = ((Ja527[])(object = Ja527.values())).length * 4)) {
                int n2;
                Gg3 gg3 = new Gg3(n);
                ch.j(gg3.r, 0, gg3.r.length);
                for (n2 = 0; n2 < ((Ja527[])object).length; ++n2) {
                    Ja527.d(object[n2], Gg3.bd(gg3));
                }
                n2 = client.r(ac) || client.p(ac) ? 1 : 0;
                W144.b(dm, ch, n2 == 0);
                ci = null;
                ch = null;
                dk = 0;
            }
        }
        catch (IOException iOException) {
            logger.error("", iOException);
            client.n(this, 1002);
        }
    }

    public static void n(client client2, int n) {
        ci = null;
        ch = null;
        dk = 0;
        ++client.dm.u;
        client.dm.z = n;
    }

    public static N272 i() {
        return fx;
    }

    public static void o() {
        if (H149.y) {
            com.jagex.jnibindings.runetek6.Graphics.resetFromCanvas(GameShell3.canvas, 0, 0, 2, 0, 0, 0);
            H149.p = GameShell3.canvasWid;
            H149.x = GameShell3.canvasHei;
        }
    }

    public static J160 a() {
        if (Hq338.g && GameShell3.fsframe != null) {
            return J160.FULLSCREEN;
        }
        return id ? J160.RESIZABLE : J160.SMALL;
    }

    public static void f(J160 j160, int n, int n2, boolean bl) {
        ir = 0L;
        J160 j1602 = client.a();
        if (j160 == J160.FULLSCREEN || j1602 == J160.FULLSCREEN) {
            bl = true;
        }
        bl = true;
        client.c(j1602, j160, n, n2, bl);
    }

    public static final float bh(float f, float f2) {
        if (mm == null) {
            return 0.0f;
        }
        float f3 = f / 4.0f;
        float f4 = f2 / 4.0f;
        if (f3 < 0.0f || f4 < 0.0f || f3 > (float)(gp - 1) || f4 > (float)(gy - 1)) {
            return 0.0f;
        }
        float f5 = f + (float)gn;
        float f6 = f2 + (float)gj;
        float f7 = client.gz.d.d.ao(f5, f6);
        return f7;
    }

    public static void ag() {
        El328 el328 = El328.d(Eu326.WINDOW_STATUS, client.fx.s);
        Gs329.k(el328.q, client.a().getId());
        Gs329.i(el328.q, GameShell3.canvasWid);
        Gs329.i(el328.q, GameShell3.canvasHei);
        Gs329.k(el328.q, W159.g().q);
        N272.e(fx, el328);
    }

    @Override
    public void cyclestart(boolean bl) {
        Lv148.g(bl);
    }

    private static void ai() {
        GameShell3.canvasWid = GameShell3.frameWid;
        GameShell3.leftMargin = 0;
        GameShell3.canvasHei = GameShell3.frameHei;
        GameShell3.topMargin = 0;
    }

    public static void al() {
        if (GameShell3.fsframe != null) {
            return;
        }
        int n = GameShell3.leftMargin;
        int n2 = GameShell3.topMargin;
        int n3 = GameShell3.frameWid - GameShell3.canvasWid - n;
        int n4 = GameShell3.frameHei - GameShell3.canvasHei - n2;
        if (n > 0 || n3 > 0 || n2 > 0 || n4 > 0) {
            try {
                Object object;
                Container container = bu.getTopContainer();
                int n5 = 0;
                int n6 = 0;
                if (container == GameShell3.frame) {
                    object = GameShell3.frame.getInsets();
                    n5 = ((Insets)object).left;
                    n6 = ((Insets)object).top;
                }
                object = container.getGraphics();
                ((Graphics)object).setColor(Color.black);
                if (n > 0) {
                    ((Graphics)object).fillRect(n5, n6, n, GameShell3.frameHei);
                }
                if (n2 > 0) {
                    ((Graphics)object).fillRect(n5, n6, GameShell3.frameWid, n2);
                }
                if (n3 > 0) {
                    ((Graphics)object).fillRect(n5 + GameShell3.frameWid - n3, n6, n3, GameShell3.frameHei);
                }
                if (n4 > 0) {
                    ((Graphics)object).fillRect(n5, n6 + GameShell3.frameHei - n4, GameShell3.frameWid, n4);
                }
            }
            catch (Exception exception) {
                logger.error("", exception);
            }
        }
    }

    public static void af(int n) {
        if (!W159.g().b) {
            n = -1;
        }
        if (n == ja) {
            return;
        }
        if (n != -1) {
            CursorType cursorType = en.list(n);
            Fj373 fj373 = cursorType.getCursor();
            if (fj373 != null) {
                GameShell3.mouseImp.g(GameShell3.canvas, Fj373.e(fj373), Fj373.q(fj373), Fj373.j(fj373), new Point(cursorType.hotspotx, cursorType.hotspoty));
                ja = n;
            } else {
                n = -1;
            }
        }
        if (n == -1 && ja != -1) {
            GameShell3.mouseImp.g(GameShell3.canvas, null, -1, -1, new Point());
            ja = -1;
        }
    }

    public static final void av() {
        df = 0;
        ln = 0;
        ll = 0L;
        Lz409.r();
        gn = 0;
        gj = 0;
        gd = 0.0f;
        ga = 0.0f;
        Gc330.g();
        ClientScriptAPI.setNativeSelfGameEntity(cj.getScriptManagerNativeRef(), cj.getLuaStateNativeRef(), null);
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
        player player2 = Gc330.j();
        if (player2 != null) {
            client.cj.event.triggerEvent("__onLogout", (Object)player2);
        }
        LuaNativeEvents.detachAllEventHandlers(cj.getLuaStateNativeRef());
        G451.j();
        N272.s(fx);
        Login.e();
        client.ac();
        W667.g(2);
        SoundManager.p = -1;
        SoundManager.x = false;
        SoundManager.o();
        At476.g(true);
        client.av();
        if (mm != null) {
            Scene.u(mm);
            mm = null;
        }
        mg = null;
        client.bk();
        J570.q();
        System.gc();
        client.z(3);
        try {
            Mu209.g(bu, "loggedout");
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static void bi() {
        Bn279 bn279;
        while ((bn279 = gf.g()) != null) {
            try {
                ((H393)bn279.d()).g();
            }
            catch (Exception exception) {
                logger.error("", exception);
            }
        }
    }

    public static void ab() {
        Is139 is139 = client.openPrefs("2", client.m.h, true);
        jr.j(is139);
    }

    public static final void aw(client client2) {
        Lb33.g(Lb33.NotLoggedInLoop);
        try {
            client.aj();
            SoundManager.v();
            ++hf;
            if (mm != null) {
                client.bi();
                Scene.z(mm, 0.02f);
            }
            if (bj % 1500 == 0) {
                G405.d(bu, client.getEnvironment());
            }
            if (client.jr.q && client.jr.j < Gz143.g() - 60000L) {
                client.ab();
            }
            client.ku.j.b();
            Lb33.d(Lb33.NotLoggedInLoop);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.NotLoggedInLoop);
            throw throwable;
        }
    }

    public static native void initNative();

    @Be2
    @Bs1
    public static void nativeKeyboardInput(int n) {
        if (n != 0 && fx != null && client.fx.s != null) {
            long l = (Gz143.g() - cc) / 50L;
            if (l > 65535L) {
                l = 65535L;
            }
            cc = Gz143.g();
            El328 el328 = El328.d(Eu326.EVENT_KEYBOARD, client.fx.s);
            Gs329.k(el328.q, 3);
            Gs329.k(el328.q, n);
            Gs329.i(el328.q, (int)l);
            N272.e(fx, el328);
        }
    }

    public static void b(client client2) {
        boolean bl = W667.d();
        if (bl && SoundManager.x && SoundManager.y != null) {
            SoundManager.y.q();
        }
    }

    @Be2
    @Bs1
    public static void nativeMouseInputClick(int n, int n2, int n3) {
        if (client.fx.s != null) {
            long l = (Gz143.g() - cb) / 50L;
            if (l > 32767L) {
                l = 32767L;
            }
            cb = Gz143.g();
            if (n3 < 0) {
                n3 = 0;
            } else if (n3 > 65535) {
                n3 = 65535;
            }
            if (n2 < 0) {
                n2 = 0;
            } else if (n2 > 65535) {
                n2 = 65535;
            }
            int n4 = (int)l;
            assert (n >= 0 && n <= 9);
            El328 el328 = El328.d(Eu326.EVENT_MOUSE_CLICK, client.fx.s);
            Gs329.a(el328.q, n2 | n3 << 16);
            Gs329.i(el328.q, n4 | n << 15);
            N272.e(fx, el328);
        }
    }

    @Jv532
    public static final void ar(float f) {
        Lb33.g(Lb33.GameLoop);
        try {
            Object object;
            int n;
            if (client.fx.o) {
                client.fx.o = false;
                client.at();
                Lb33.d(Lb33.GameLoop);
                return;
            }
            Lb33.g(Lb33.TCPin);
            try {
                for (object = 0; object < 100 && client.be(fx); ++object) {
                }
                Lb33.d(Lb33.TCPin);
            }
            catch (Throwable object2) {
                Lb33.d(Lb33.TCPin);
                throw object2;
            }
            SoundManager.v();
            if (ac != 11) {
                Lb33.d(Lb33.GameLoop);
                return;
            }
            Lb33.g(Lb33.ReflectionReceiver);
            try {
                while (Ji520.d()) {
                    object = El328.d(Eu326.REFLECTION_CHECK_REPLY, client.fx.s);
                    Gs329.k(((El328)object).q, 0);
                    int n2 = object.q.v;
                    Ji520.q(((El328)object).q);
                    Gs329.ac(((El328)object).q, object.q.v - n2);
                    N272.e(fx, (El328)object);
                }
                Lb33.d(Lb33.ReflectionReceiver);
            }
            catch (Throwable throwable) {
                Lb33.d(Lb33.ReflectionReceiver);
                throw throwable;
            }
            if (GameShell3.focus != bk) {
                bk = GameShell3.focus;
                object = El328.d(Eu326.EVENT_APPLET_FOCUS, client.fx.s);
                Gs329.k(((El328)object).q, GameShell3.focus ? 1 : 0);
                N272.e(fx, (El328)object);
            }
            if (ac != 11) {
                Lb33.d(Lb33.GameLoop);
                return;
            }
            client.fx.p += f;
            if (client.fx.p > 15.0f) {
                logger.error("Lost connection due to timeout.\tReconnecting....");
                client.at();
                Lb33.d(Lb33.GameLoop);
                return;
            }
            if (mm != null) {
                Lb33.g(Lb33.WorldProcess);
                try {
                    client.bi();
                    Scene.z(mm, f);
                    Scene.k(mm);
                    object = mm.x(AnimationGraphComponent.class).iterator();
                    while (object.hasNext()) {
                        object2 = (AnimationGraphComponent)object.next();
                        ((AnimationGraphComponent)object2).g(f);
                    }
                    for (Object object2 : mm.x(SoundComponent.class)) {
                        SoundComponent.g((SoundComponent)object2, f);
                    }
                    for (Object object2 : mm.x(TimerComponent.class)) {
                        TimerComponent.g((TimerComponent)object2, f);
                    }
                    for (Object object2 : mm.x(ProcessLogicEventComponent.class)) {
                        ProcessLogicEventComponent.g((ProcessLogicEventComponent)object2, f);
                    }
                    Scene.i(mm);
                    Lb33.d(Lb33.WorldProcess);
                }
                catch (Throwable throwable) {
                    Lb33.d(Lb33.WorldProcess);
                    throw throwable;
                }
            }
            ClientScriptMessaging.d(fx);
            Gf474.w();
            client.bd();
            client.aj();
            for (n = 0; n < hd; ++n) {
                if (bv > 1) {
                    --bv;
                }
                ++hf;
                if (hp != 0 && (hc += 20) >= 400) {
                    hp = 0;
                }
                client.ax();
            }
            if (client.jr.q && client.jr.j < Gz143.g() - 60000L) {
                client.ab();
            }
            client.ku.j.b();
            if (++hr > 500) {
                hr = 0;
                n = (int)(Math.random() * 8.0);
                if ((n & 1) == 1) {
                    gw += gm;
                }
                if ((n & 2) == 2) {
                    gx += gr;
                }
                if ((n & 4) == 4) {
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
            if (++hu > 500) {
                hu = 0;
                n = (int)(Math.random() * 8.0);
                if ((n & 1) == 1) {
                    hj += hx;
                }
                if ((n & 2) == 2) {
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
                client.cb();
                ff = false;
            }
            try {
                fx.j();
            }
            catch (IOException iOException) {
                logger.error("Connection failure when flushing. Reconnecting....", iOException);
                client.at();
            }
            if (cf) {
                client.bw();
            }
            if (Y192.e) {
                while (Y192.j()) {
                    object = El328.d(Eu326.PHYSICSCONTROLDEBUGGER_STATE, client.fx.s);
                    Gs329.i(((El328)object).q, 0);
                    object2 = object.q.v;
                    if (!Y192.e(((El328)object).q)) continue;
                    Gs329.as(((El328)object).q, object.q.v - object2);
                    N272.e(fx, (El328)object);
                }
            }
            Lb33.d(Lb33.GameLoop);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.GameLoop);
            throw throwable;
        }
    }

    private static void ax() {
        long l = System.currentTimeMillis();
        if (l - N272.g(fx) > 1000L) {
            El328 el328 = El328.d(Eu326.NO_TIMEOUT, client.fx.s);
            N272.e(fx, el328);
            N272.d(fx, l);
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

    private static final boolean bs(N272 n272) throws IOException {
        Object object;
        int n;
        Hx339 hx339 = n272.q;
        Gs329 gs329 = n272.b;
        if (hx339 == null) {
            return false;
        }
        if (n272.r == null) {
            if (n272.y) {
                if (!hx339.d(1)) {
                    return false;
                }
                hx339.j(n272.b.r, 0, 1);
                ++n272.z;
                n272.p = 0.0f;
                n272.y = false;
            }
            gs329.v = 0;
            if (Gs329.q(gs329)) {
                if (!hx339.d(1)) {
                    return false;
                }
                hx339.j(n272.b.r, 1, 1);
                ++n272.z;
                n272.p = 0.0f;
            }
            n272.y = true;
            object = Ea395.values();
            n = Gs329.j(gs329);
            if (n < 0 || n >= ((Ea395[])object).length) {
                throw new IOException(n + " " + gs329.v);
            }
            n272.r = object[n];
            n272.v = n272.r.dy;
        }
        if (n272.v == -1) {
            if (!hx339.d(1)) {
                return false;
            }
            hx339.j(gs329.r, 0, 1);
            n272.v = gs329.r[0] & 0xFF;
            ++n272.z;
            n272.p = 0.0f;
        }
        if (n272.v == -2) {
            if (!hx339.d(2)) {
                return false;
            }
            hx339.j(gs329.r, 0, 2);
            gs329.v = 0;
            n272.v = Gs329.au(gs329);
            n272.z += 2;
            n272.p = 0.0f;
        }
        if (n272.v > 0) {
            if (!hx339.d(n272.v)) {
                return false;
            }
            gs329.v = 0;
            hx339.j(gs329.r, 0, n272.v);
            n272.z += n272.v;
            n272.p = 0.0f;
        }
        n272.i = n272.k;
        n272.k = n272.n;
        n272.n = n272.r;
        logger.trace("Packet : " + n272.r.toString());
        if (n272.r == Ea395.REBUILD_NORMAL) {
            client.bp();
            n272.r = null;
            return false;
        }
        if (n272.r == Ea395.LOGOUT_SWITCH_PLAYER) {
            client.ap.q = Gs329.bd(gs329);
            client.z(13);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.LOGOUT) {
            logger.trace("logout");
            client.ap();
            n272.r = null;
            return false;
        }
        if (n272.r == Ea395.LOGOUT_TRANSFER) {
            int n2 = Gs329.au(gs329);
            String string = Gs329.bk(gs329);
            logger.trace("logout transfer to world " + n2 + " on " + string);
            Lf336.g(n2, string);
            client.z(15);
            n272.r = null;
            return false;
        }
        if (n272.r == Ea395.UPDATE_REBOOT_TIMER) {
            bv = Gs329.au(gs329) * 30;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.LAST_LOGIN_INFO) {
            int n3 = Gs329.bd(gs329);
            bn = InetAddress.getByAddress(new byte[]{(byte)(n3 >> 24 & 0xFF), (byte)(n3 >> 16 & 0xFF), (byte)(n3 >> 8 & 0xFF), (byte)(n3 & 0xFF)}).getHostName();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_DOB) {
            iy = Gs329.ad(gs329);
            ic = Gs329.ar(gs329) == 1;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.REFLECTION_CHECKER) {
            Ji520.j(gs329, n272.v);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.PLAYER_INFO2) {
            Gc330.s(gs329, n272.v);
            ++mw;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.TICK) {
            int n4 = Gs329.bd(gs329);
            kn = Gs329.bl(gs329);
            if (!do_ || !la) {
                df = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(n4, dz);
                do_ = true;
            }
            ln = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(df, n4) - dz;
            ll = System.nanoTime();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MESSAGE_GAME) {
            String string;
            int n5 = Gs329.br(gs329);
            n = Gs329.bd(gs329);
            int n6 = Gs329.ar(gs329);
            String string2 = string = "";
            if ((n6 & 1) != 0) {
                string = Gs329.bk(gs329);
                string2 = (n6 & 2) != 0 ? Gs329.bk(gs329) : string;
            }
            String string3 = Gs329.bk(gs329);
            if (n5 == 99) {
                debugconsole.addline(string3);
                logger.info(string3);
            } else if (n5 == 98) {
                debugconsole.s(string3);
            } else {
                if (!string2.equals("") && client.cj(string2)) {
                    n272.r = null;
                    return true;
                }
                G232.q(n5, n, string, string2, string, string3);
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_FRIENDLIST) {
            while (gs329.v < n272.v) {
                boolean bl = Gs329.ar(gs329) == 1;
                String string = Gs329.bk(gs329);
                String string4 = Gs329.bk(gs329);
                int n7 = Gs329.au(gs329);
                boolean bl2 = Gs329.ar(gs329) == 1;
                String string5 = "";
                boolean bl3 = false;
                if (n7 > 0) {
                    string5 = Gs329.bk(gs329);
                    bl3 = Gs329.ar(gs329) == 1;
                }
                logger.error("Got friend: " + string + " world:" + n7 + " samegame:" + bl3);
                client.ku.j.j(bl, string, string4, n7, string5, bl3, bl2);
            }
            ClientFriendListComponent.g(ku, true);
            LuaNativeEvents.invokeOnClientFriendListUpdate(cj.getLuaStateNativeRef());
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_INV_PARTIAL) {
            int n8 = Gs329.au(gs329);
            n = Gs329.ar(gs329);
            boolean bl = (n & 1) == 1;
            logger.trace("Received inventory update for inventory: " + n8 + " other player?: " + bl);
            ArrayList<Integer> arrayList = bl ? null : new ArrayList<Integer>(0);
            ClientInventory clientInventory = G451.d(n8, bl);
            while (gs329.v < n272.v) {
                int n9 = Gs329.br(gs329);
                int n10 = Gs329.au(gs329);
                int n11 = 0;
                if (n10 != 0 && (n11 = Gs329.ar(gs329)) == 255) {
                    n11 = Gs329.bd(gs329);
                }
                clientInventory.g(n9, n10 - 1, n11);
                if (n10 != 0) {
                    int n12 = Gs329.ar(gs329);
                    for (int i = 0; i < n12; ++i) {
                        Kr260 kr260 = fi.decodeVarValue(gs329);
                        clientInventory.q(n9, kr260.g, kr260.d);
                    }
                }
                if (bl) continue;
                arrayList.add(n9);
            }
            n272.r = null;
            if (!bl) {
                client.cw(new Y388(clientInventory, arrayList));
            }
            return true;
        }
        if (n272.r == Ea395.UPDATE_INV_FULL) {
            int n13 = Gs329.au(gs329);
            n = Gs329.ar(gs329);
            boolean bl = (n & 1) == 1;
            logger.trace("Received full inventory for inventory: " + n13 + " other player?: " + bl);
            ClientInventory clientInventory = G451.d(n13, bl);
            ClientInventory.d(clientInventory);
            while (gs329.v < n272.v) {
                int n14 = Gs329.br(gs329);
                int n15 = Gs329.au(gs329);
                int n16 = 0;
                if (n15 != 0 && (n16 = Gs329.ar(gs329)) == 255) {
                    n16 = Gs329.bd(gs329);
                }
                clientInventory.g(n14, n15 - 1, n16);
                if (n15 == 0) continue;
                int n17 = Gs329.ar(gs329);
                for (int i = 0; i < n17; ++i) {
                    Kr260 kr260 = fi.decodeVarValue(gs329);
                    clientInventory.q(n14, kr260.g, kr260.d);
                }
            }
            n272.r = null;
            if (!bl) {
                client.cw(new U406(clientInventory));
            }
            return true;
        }
        if (n272.r == Ea395.NPC_APPEARED) {
            client.cp();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.NPC_UPDATE) {
            client.cd();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.NPC_EXTENDED_STATE) {
            client.ck();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.NPC_GONE) {
            client.ce();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARCLAN) {
            int n18 = Gs329.au(gs329);
            if (js == null) {
                js = new SparseVarDomain(fm);
            }
            Kr260 kr260 = fm.decodeVarValue(gs329);
            client.js.varValues.s(kr260.g, kr260.d);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARCLAN_ENABLE) {
            js = new SparseVarDomain(fm);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARCLAN_DISABLE) {
            js = null;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARP_SMALL) {
            int n19 = Gs329.au(gs329);
            n = Gs329.ax(gs329);
            logger.trace("Received small varp variable: " + n19 + " value:" + n);
            jw.q(fd.list(n19), n);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARP_LARGE) {
            int n20 = Gs329.au(gs329);
            n = Gs329.bd(gs329);
            logger.trace("Received big varp variable: " + n20 + " value:" + n);
            jw.q(fd.list(n20), n);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARBIT_SMALL) {
            int n21 = Gs329.au(gs329);
            n = Gs329.ar(gs329);
            logger.trace("Received small varbit variable: " + n21 + " value:" + n);
            Fw152.j(jw, fl.list(n21), n);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARBIT_LARGE) {
            int n22 = Gs329.au(gs329);
            n = Gs329.bd(gs329);
            logger.trace("Received big varbit variable: " + n22 + " value:" + n);
            Fw152.j(jw, fl.list(n22), n);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLIENT_SETVARC_SMALL) {
            int n23 = Gs329.au(gs329);
            n = Gs329.ax(gs329);
            logger.trace("client_setvarc (small) - var:" + n23 + " val:" + n);
            client.cl();
            L410.j(n23, n);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLIENT_SETVARC_LARGE) {
            int n24 = Gs329.au(gs329);
            n = Gs329.bd(gs329);
            logger.trace("client_setvarc (large) - var:" + n24 + " val:" + n);
            client.cl();
            L410.j(n24, n);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLIENT_SETVARCSTR_SMALL) {
            int n25 = Gs329.au(gs329);
            String string = Gs329.bk(gs329);
            logger.trace("client_setvarcstr (small) - var:" + n25 + " val:" + string);
            client.cl();
            L410.e(n25, string);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLIENT_SETVARCSTR_LARGE) {
            int n26 = Gs329.au(gs329);
            String string = Gs329.bk(gs329);
            logger.trace("client_setvarcstr (large) - var:" + n26 + " val:" + string);
            client.cl();
            L410.e(n26, string);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.SETDRAWORDER) {
            int n27 = Gs329.ar(gs329);
            client.cl();
            hz = n27;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MIDI_SONG) {
            int n28 = Gs329.au(gs329);
            if (n28 == 65535) {
                n28 = -1;
            }
            n = Gs329.ar(gs329);
            int n29 = Gs329.ar(gs329);
            SoundManager.t(n28, n, n29);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MIDI_JINGLE) {
            int n30 = Gs329.au(gs329);
            if (n30 == 65535) {
                n30 = -1;
            }
            n = Gs329.ay(gs329);
            int n31 = Gs329.ar(gs329);
            SoundManager.m(n30, n, n31);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_PLAYSOUND) {
            int n32 = Gs329.bd(gs329);
            n = Gs329.ar(gs329);
            String string = Gs329.bk(gs329);
            SoundManager.ag(n32, n, string);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_STARTMUSIC) {
            object = Gs329.bk(gs329);
            String string = Gs329.bk(gs329);
            logger.debug("Received StartMusic {}", object);
            SoundManager.ap((String)object, string);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_STOPMUSIC) {
            logger.debug("Received StopMusic");
            SoundManager.ao();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_SETMUSICPARAMETER) {
            object = Gs329.bk(gs329);
            SoundManager.aa((String)object);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_PLAYAMBIENCE) {
            object = Gs329.bk(gs329);
            String string = Gs329.bk(gs329);
            logger.debug("Received StartAmbience");
            SoundManager.am((String)object, string);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_STOPAMBIENCE) {
            logger.debug("Received StopAmbience");
            SoundManager.as();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_SETAMBIENCEPARAMETER) {
            object = Gs329.bk(gs329);
            SoundManager.aa((String)object);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_PRELOADBANK) {
            object = Gs329.bk(gs329);
            SoundManager.ac((String)object);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_MIXERPRESET) {
            object = Gs329.bk(gs329);
            SoundManager.at((String)object);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_STOPALLSOUNDS) {
            SoundManager.ab();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.GENERIC_BROADCAST_STATE) {
            object = new BroadcastStateAndEventsTypes$StatePayload();
            BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition = BroadcastStateAndEventsTransmission.UnpackStateMessage(gs329, (BroadcastStateAndEventsTypes$StatePayload)object);
            player player2 = Gc330.j();
            logger.trace("BROADCAST_STATE with statedef: '" + broadcastStateAndEventsTypes$StateDefinition + "' / thisplayer: '" + player2 + "' / payload: '" + object + "'");
            if (broadcastStateAndEventsTypes$StateDefinition != null) {
                ck.add(new F407(object.broadcasterID, broadcastStateAndEventsTypes$StateDefinition, (BroadcastStateAndEventsTypes$StatePayload)object, player2));
            } else {
                logger.warn("um... couldn't build a StateDefinition from incoming state packet.");
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.GENERIC_BROADCAST_EVENT) {
            object = new BroadcastStateAndEventsTypes$EventPayload();
            BroadcastStateAndEventsTypes$EventDefinition broadcastStateAndEventsTypes$EventDefinition = BroadcastStateAndEventsTransmission.UnpackEventMessage(gs329, (BroadcastStateAndEventsTypes$EventPayload)object);
            if (broadcastStateAndEventsTypes$EventDefinition != null) {
                ck.add(new E413(object.broadcasterID, broadcastStateAndEventsTypes$EventDefinition, (BroadcastStateAndEventsTypes$EventPayload)object));
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.GENERIC_BROADCAST_GONE) {
            object = BroadcastStateAndEventsTransmission.UnpackGoneMessage(gs329);
            ck.add(new Aq668(object.broadcasterID, (BroadcastStateAndEventsTypes$GonePayload)object));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.GENERIC_BROADCAST_APPEARED) {
            object = BroadcastStateAndEventsTransmission.UnpackAppearedMessage(gs329);
            ck.add(new M411(object.broadcasterID, (BroadcastStateAndEventsTypes$AppearedPayload)object));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.GENERIC_BROADCAST_ATOMIC_END_MARKER) {
            if (client.y(ac)) {
                ce.addAll(ck);
            } else {
                for (V385 v385 : ck) {
                    v385.j();
                }
            }
            ck.clear();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_IGNORELIST_PARTIAL) {
            int n33 = Gs329.ar(gs329);
            n = (n33 & 1) == 1 ? 1 : 0;
            String string = Gs329.bk(gs329);
            String string6 = Gs329.bk(gs329);
            String string7 = Gs329.bk(gs329);
            String string8 = Gs329.bk(gs329);
            client.ku.e.g(n != 0, string, string6, string7, string8, (n33 & 2) == 2);
            LuaNativeEvents.invokeOnClientFriendListUpdate(cj.getLuaStateNativeRef());
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MESSAGE_PUBLIC) {
            int n34 = Gs329.au(gs329);
            player player3 = Gc330.e(n34);
            if (player3 == null) {
                n272.r = null;
                return true;
            }
            int n35 = Gs329.au(gs329);
            int n36 = Gs329.ar(gs329);
            if (player3.ai != null) {
                boolean bl = false;
                if (n36 <= 1) {
                    if (ic && !iw || io) {
                        bl = true;
                    } else if (client.cj(player3.ai)) {
                        bl = true;
                    }
                }
                if (!bl && hm == 0) {
                    int n37 = -1;
                    String string = Et578.g(Af155.q(gs329));
                    int n38 = n36 == 1 || n36 == 2 ? 1 : 2;
                    G232.j(n38, 0, player3.bi(true), player.bt(player3, false), player3.aq, string, null, n37);
                }
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MESSAGE_PRIVATE) {
            String string;
            int n39;
            boolean bl;
            long l;
            String string9;
            block253 : {
                boolean bl4 = Gs329.ar(gs329) == 1;
                string = string9 = Gs329.bk(gs329);
                if (bl4) {
                    string = Gs329.bk(gs329);
                }
                long l2 = Gs329.au(gs329);
                long l3 = Gs329.ay(gs329);
                n39 = Gs329.ar(gs329);
                l = (l2 << 32) + l3;
                bl = false;
                for (int i = 0; i < 100; ++i) {
                    if (jh[i] != l) continue;
                    bl = true;
                    break block253;
                }
                if (n39 <= 1) {
                    if (ic && !iw || io) {
                        bl = true;
                    } else if (client.cj(string)) {
                        bl = true;
                    }
                }
            }
            if (!bl && hm == 0) {
                client.jh[client.jp] = l;
                jp = (jp + 1) % 100;
                String string10 = Et578.g(Af155.q(gs329));
                if (n39 == 2) {
                    G232.j(7, 0, A412.g(1) + string9, A412.g(1) + string, string9, string10, null, -1);
                } else if (n39 == 1) {
                    G232.j(7, 0, A412.g(0) + string9, A412.g(0) + string, string9, string10, null, -1);
                } else {
                    G232.j(3, 0, string9, string, string9, string10, null, -1);
                }
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CHAT_FILTER_SETTINGS) {
            je = Gs329.ar(gs329);
            jn = Gs329.ar(gs329);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CHAT_FILTER_SETTINGS_PRIVATECHAT) {
            jz = Hf380.g(Gs329.ar(gs329));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_IGNORELIST_FULL) {
            D236.s(client.ku.e);
            int n40 = Gs329.ar(gs329);
            for (n = 0; n < n40; ++n) {
                String string = Gs329.bk(gs329);
                String string11 = Gs329.bk(gs329);
                String string12 = Gs329.bk(gs329);
                String string13 = Gs329.bk(gs329);
                client.ku.e.g(false, string, string11, string12, string13, false);
            }
            LuaNativeEvents.invokeOnClientFriendListUpdate(cj.getLuaStateNativeRef());
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.SYNTH_SOUND) {
            int n41 = Gs329.au(gs329);
            if (n41 == 65535) {
                n41 = -1;
            }
            n = Gs329.ar(gs329);
            int n42 = Gs329.au(gs329);
            int n43 = Gs329.ar(gs329);
            int n44 = Gs329.au(gs329);
            SoundManager.p(n41, n, n42, n43, n44);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VORBIS_SOUND) {
            int n45 = Gs329.au(gs329);
            if (n45 == 65535) {
                n45 = -1;
            }
            n = Gs329.ar(gs329);
            int n46 = Gs329.au(gs329);
            int n47 = Gs329.ar(gs329);
            int n48 = Gs329.au(gs329);
            SoundManager.u(n45, n, n46, n47, false, n48);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VORBIS_SPEECH_SOUND) {
            int n49 = Gs329.au(gs329);
            if (n49 == 65535) {
                n49 = -1;
            }
            n = Gs329.ar(gs329);
            int n50 = Gs329.au(gs329);
            int n51 = Gs329.ar(gs329);
            SoundManager.u(n49, n, n50, n51, true, 256);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VORBIS_SPEECH_STOP) {
            SoundManager.n();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.RESET_CLIENT_VARCACHE) {
            logger.trace("Resetting variables to 0 in preperation for full transmit");
            jw.d();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MESSAGE_PRIVATE_ECHO) {
            object = Gs329.bk(gs329);
            String string = Et578.g(Af155.q(gs329));
            G232.q(6, 0, (String)object, (String)object, (String)object, string);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_INV_STOP_TRANSMIT) {
            int n52 = Gs329.au(gs329);
            n = Gs329.ar(gs329);
            boolean bl = (n & 1) == 1;
            G451.q(n52, bl);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MESSAGE_FRIENDCHANNEL) {
            long l;
            String string;
            boolean bl;
            int n53;
            long l4;
            String string14;
            block254 : {
                boolean bl5 = Gs329.ar(gs329) == 1;
                string = string14 = Gs329.bk(gs329);
                if (bl5) {
                    string = Gs329.bk(gs329);
                }
                l = Gs329.bq(gs329);
                long l5 = Gs329.au(gs329);
                long l6 = Gs329.ay(gs329);
                n53 = Gs329.ar(gs329);
                l4 = (l5 << 32) + l6;
                bl = false;
                for (int i = 0; i < 100; ++i) {
                    if (jh[i] != l4) continue;
                    bl = true;
                    break block254;
                }
                if (n53 <= 1) {
                    if (ic && !iw || io) {
                        bl = true;
                    } else if (client.cj(string)) {
                        bl = true;
                    }
                }
            }
            if (!bl && hm == 0) {
                client.jh[client.jp] = l4;
                jp = (jp + 1) % 100;
                String string15 = Et578.g(Af155.q(gs329));
                if (n53 == 2 || n53 == 3) {
                    G232.j(9, 0, A412.g(1) + string14, A412.g(1) + string, string14, string15, Q280.d(l), -1);
                } else if (n53 == 1) {
                    G232.j(9, 0, A412.g(0) + string14, A412.g(0) + string, string14, string15, Q280.d(l), -1);
                } else {
                    G232.j(9, 0, string14, string, string14, string15, Q280.d(l), -1);
                }
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MESSAGE_CLANCHANNEL) {
            boolean bl;
            String string;
            Dr574 dr574;
            boolean bl6;
            long l;
            int n54;
            block255 : {
                bl6 = Gs329.ar(gs329) == 1;
                string = Gs329.bk(gs329);
                long l7 = Gs329.au(gs329);
                long l8 = Gs329.ay(gs329);
                n54 = Gs329.ar(gs329);
                l = (l7 << 32) + l8;
                bl = false;
                dr574 = null;
                Dr574 dr5742 = dr574 = bl6 ? kh : ko;
                if (dr574 == null) {
                    bl = true;
                } else {
                    for (int i = 0; i < 100; ++i) {
                        if (jh[i] != l) continue;
                        bl = true;
                        break block255;
                    }
                    if (n54 <= 1) {
                        if (ic && !iw || io) {
                            bl = true;
                        } else if (client.cj(string)) {
                            bl = true;
                        }
                    }
                }
            }
            if (!bl && hm == 0) {
                int n55;
                client.jh[client.jp] = l;
                jp = (jp + 1) % 100;
                String string16 = Et578.g(Af155.q(gs329));
                int n56 = n55 = bl6 ? 41 : 44;
                if (n54 == 2 || n54 == 3) {
                    G232.j(n55, 0, A412.g(1) + string, A412.g(1) + string, string, string16, dr574.k, -1);
                } else if (n54 == 1) {
                    G232.j(n55, 0, A412.g(0) + string, A412.g(0) + string, string, string16, dr574.k, -1);
                } else {
                    G232.j(n55, 0, string, string, string, string16, dr574.k, -1);
                }
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MESSAGE_GROUP) {
            String string;
            boolean bl = Gs329.ar(gs329) == 1;
            String string17 = string = Gs329.bk(gs329);
            if (bl) {
                string17 = Gs329.bk(gs329);
            }
            int n57 = Gs329.ar(gs329);
            boolean bl7 = false;
            if (n57 <= 1) {
                if (ic && !iw || io) {
                    bl7 = true;
                } else if (n57 <= 1 && client.cj(string17)) {
                    bl7 = true;
                }
            }
            if (!bl7 && hm == 0) {
                String string18 = Et578.g(Af155.q(gs329));
                if (n57 == 2) {
                    G232.j(24, 0, A412.g(1) + string, A412.g(1) + string17, string, string18, null, -1);
                } else if (n57 == 1) {
                    G232.j(24, 0, A412.g(0) + string, A412.g(0) + string17, string, string18, null, -1);
                } else {
                    G232.j(24, 0, string, string17, string, string18, null, -1);
                }
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLANCHANNEL_FULL) {
            boolean bl;
            boolean bl8 = bl = Gs329.ar(gs329) == 1;
            if (n272.v == 1) {
                logger.trace("Received ClanChannel RESET - affined:" + bl);
                if (bl) {
                    kh = null;
                } else {
                    ko = null;
                }
                n272.r = null;
                return true;
            }
            Dr574 dr574 = bl ? (kh = new Dr574(gs329)) : (ko = new Dr574(gs329));
            Object[] arrobject = new Object[]{bl ? "Affined" : "Listened", dr574.n, dr574.e()};
            logger.trace("\n{} ClanChannel received and set - updateNum: {}\n{}", arrobject);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLANSETTINGS_FULL) {
            boolean bl;
            boolean bl9 = bl = Gs329.ar(gs329) == 1;
            if (n272.v == 1) {
                if (bl) {
                    kv = null;
                } else {
                    kj = null;
                }
                n272.r = null;
                return true;
            }
            Ef450 ef450 = bl ? (kv = new Ef450(gs329)) : (kj = new Ef450(gs329));
            Object[] arrobject = new Object[]{bl ? "Affined" : "Listened", ef450.s, ef450.u()};
            logger.trace("{} ClanRecord received and set - updateNum: {}\n{}", arrobject);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLANCHANNEL_DELTA) {
            boolean bl = Gs329.ar(gs329) == 1;
            Ee573 ee573 = new Ee573(gs329);
            Dr574 dr574 = bl ? kh : ko;
            ee573.d(dr574);
            logger.trace(dr574.e());
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLANSETTINGS_DELTA) {
            boolean bl = Gs329.ar(gs329) == 1;
            Dg449 dg449 = new Dg449(gs329);
            Ef450 ef450 = bl ? kv : kj;
            dg449.d(ef450);
            logger.trace(ef450.u());
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_FRIENDCHAT_CHANNEL_FULL) {
            int n58;
            int n59;
            if (n272.v == 0) {
                ju = null;
                jv = null;
                kf = null;
                km = 0;
                kg = null;
                n272.r = null;
                return true;
            }
            jv = Gs329.bk(gs329);
            boolean bl = Gs329.ar(gs329) == 1;
            kf = bl ? Gs329.bk(gs329) : jv;
            long l = Gs329.bq(gs329);
            ju = Q280.g(l);
            kr = Gs329.ax(gs329);
            logger.trace("CLANCHAT: Received full channel list for channel: {}, kickrank: {}", (Object)ju, (Object)kr);
            int n60 = Gs329.ar(gs329);
            if (n60 == 255) {
                n272.r = null;
                return true;
            }
            km = n60;
            logger.trace("USERCOUNT={}", km);
            Ah608[] arrah608 = new Ah608[100];
            for (n59 = 0; n59 < km; ++n59) {
                arrah608[n59] = new Ah608();
                arrah608[n59].g = Gs329.bk(gs329);
                bl = Gs329.ar(gs329) == 1;
                arrah608[n59].d = bl ? Gs329.bk(gs329) : arrah608[n59].g;
                arrah608[n59].q = Md230.e(arrah608[n59].d, null);
                arrah608[n59].j = Gs329.au(gs329);
                arrah608[n59].h = Gs329.ax(gs329);
                arrah608[n59].e = Gs329.bk(gs329);
                if (!arrah608[n59].d.equals(Gc330.j().aq)) continue;
                kz = arrah608[n59].h;
            }
            n59 = 0;
            int n61 = km;
            while (n61 > 0) {
                n59 = 1;
                for (n58 = 0; n58 < --n61; ++n58) {
                    if (arrah608[n58].q.compareTo(arrah608[n58 + 1].q) <= 0) continue;
                    Ah608 ah608 = arrah608[n58];
                    arrah608[n58] = arrah608[n58 + 1];
                    arrah608[n58 + 1] = ah608;
                    n59 = 0;
                }
                if (n59 == 0) continue;
            }
            kg = arrah608;
            logger.trace("-=-=- CLANCHAT FULL CHANNEL UPDATE -=-=-");
            logger.trace("usercount={}", km);
            for (n58 = 0; n58 < km; ++n58) {
                logger.trace("{} (w{})", (Object)client.kg[n58].d, (Object)client.kg[n58].j);
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER) {
            object = Gs329.bk(gs329);
            boolean bl = Gs329.ar(gs329) == 1;
            String string = bl ? Gs329.bk(gs329) : object;
            int n62 = Gs329.au(gs329);
            byte by = Gs329.ax(gs329);
            boolean bl10 = false;
            if (by == -128) {
                bl10 = true;
            }
            if (bl10) {
                if (km == 0) {
                    n272.r = null;
                    return true;
                }
                int n63 = 0;
                for (n63 = 0; !(n63 >= km || client.kg[n63].d.equals(string) && client.kg[n63].j == n62); ++n63) {
                }
                if (n63 < km) {
                    while (n63 < km - 1) {
                        client.kg[n63] = kg[n63 + 1];
                        ++n63;
                    }
                    client.kg[--client.km] = null;
                }
            } else {
                int n64;
                int n65;
                String string19 = Gs329.bk(gs329);
                Ah608 ah608 = new Ah608();
                ah608.g = object;
                ah608.d = string;
                ah608.q = Md230.e(ah608.d, null);
                ah608.j = n62;
                ah608.h = by;
                ah608.e = string19;
                for (n65 = client.km - 1; n65 >= 0; --n65) {
                    n64 = client.kg[n65].q.compareTo(ah608.q);
                    if (n64 == 0) {
                        client.kg[n65].j = n62;
                        client.kg[n65].h = by;
                        client.kg[n65].e = string19;
                        if (string.equals(Gc330.j().aq)) {
                            kz = by;
                        }
                        logger.trace("-=-=- CLANCHAT INCR+ CHANNEL UPDATE -=-=-");
                        logger.trace("usercount={}", km);
                        for (int i = 0; i < km; ++i) {
                            logger.trace("{} (w{})", (Object)client.kg[i].d, (Object)client.kg[i].j);
                        }
                        n272.r = null;
                        return true;
                    }
                    if (n64 < 0) break;
                }
                if (km >= kg.length) {
                    n272.r = null;
                    return true;
                }
                for (n64 = client.km - 1; n64 > n65; --n64) {
                    client.kg[n64 + 1] = kg[n64];
                }
                if (km == 0) {
                    kg = new Ah608[100];
                }
                client.kg[n65 + 1] = ah608;
                ++km;
                if (string.equals(Gc330.j().aq)) {
                    kz = by;
                }
            }
            logger.trace("-=-=- CLANCHAT INCR+ CHANNEL UPDATE -=-=-");
            logger.trace("usercount={}", km);
            for (int i = 0; i < km; ++i) {
                logger.trace("{} (w{})", (Object)client.kg[i].d, (Object)client.kg[i].j);
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.TRIGGER_ONDIALOGABORT) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_UID192) {
            gs329.v += 28;
            if (Gs329.bc(gs329)) {
                client.storeUID192(gs329, gs329.v - 28);
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_SITESETTINGS) {
            G405.g(o, bu, client.getEnvironment());
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.URL_OPEN) {
            if (Hq338.g && GameShell3.fsframe != null) {
                client.f(W159.g().j, -1, -1, false);
            }
            object = new byte[n272.v - 1];
            n = Gs329.ar(gs329) == 1 ? 1 : 0;
            Gs329.e(gs329, (byte[])object, 0, n272.v - 1);
            String string = J173.s((byte[])object, 0, n272.v - 1);
            Dp208.q(string, true, false, ao, aa);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.SOCIAL_NETWORK_LOGOUT) {
            if (Hq338.g && GameShell3.fsframe != null) {
                client.f(W159.g().j, -1, -1, false);
            }
            object = new byte[n272.v];
            Gs329.e(gs329, (byte[])object, 0, n272.v);
            String string = J173.s((byte[])object, 0, n272.v);
            String string20 = "opensn";
            if (!k || !Dp208.s(string, 1, string20)) {
                Dp208.j(string, true, false, string20, ao, aa);
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETTEXT) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETPLAYERMODEL_OTHER) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETPLAYERMODEL_SELF) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETMODEL) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETANIM) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETNPCHEAD) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETPLAYERHEAD) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETCOLOUR) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETHIDE) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETOBJECT) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETPOSITION) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETSCROLLPOS) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETANGLE) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SPINMODEL) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETPLAYERHEAD_IGNOREWORN) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETTARGETPARAM) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETEVENTS) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.RUNCLIENTSCRIPT) {
            object = Gs329.bk(gs329);
            Object[] arrobject = new Object[object.length() + 1];
            for (int i = object.length() - 1; i >= 0; --i) {
                arrobject[i + 1] = object.charAt(i) == 's' ? Gs329.bk(gs329) : new Integer(Gs329.bd(gs329));
            }
            arrobject[0] = new Integer(Gs329.bd(gs329));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_OPENTOP) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_OPENSUB) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_OPENSUB_ACTIVE_PLAYER) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_OPENSUB_ACTIVE_NPC) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_OPENSUB_ACTIVE_LOC) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_OPENSUB_ACTIVE_OBJ) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_CLOSESUB) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_MOVESUB) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.DEBUG_SERVER_TRIGGERS) {
            int n66 = Gs329.au(gs329);
            n = Gs329.au(gs329);
            int n67 = Gs329.au(gs329);
            client.cl();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETGRAPHIC) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETTEXTFONT) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETVIDEO) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETRECOL) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETRETEX) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.IF_SETCLICKMASK) {
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.SONG_CHANNEL_FACTOR) {
            byte by = Gs329.ax(gs329);
            n = Gs329.ar(gs329);
            client.cl();
            SoundManager.a(by, n);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.REDUCE_ATTACK_PRIORITY) {
            iu = Gs329.ar(gs329) == 1;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.SEND_PING) {
            int n68 = Gs329.bd(gs329);
            n = Gs329.bd(gs329);
            El328 el328 = El328.d(Eu326.SEND_PING_REPLY, n272.s);
            Gs329.a(el328.q, n68);
            Gs329.a(el328.q, n);
            N272.e(n272, el328);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.EXECUTE_CLIENT_CHEAT) {
            int n69 = Gs329.au(gs329);
            n = Gs329.bd(gs329);
            debugconsole.y(n69, n);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.DEBUG_PATHFINDING_STATIC) {
            Lk495.g().e(gs329);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.DEBUG_PATHFINDING_DYNAMIC) {
            Lk495.g().j(gs329);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.NAVPOWER_DEBUG_RENDER_CHUNK) {
            ni.g(gs329, n272.v);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.SCRIPT_MESSAGE) {
            object = ClientScriptMessaging.q(gs329);
            G284.g(lq, object.s.length);
            client.cw(new K398((Az399)object));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.STATEEVENT_EVENTSBUFFER) {
            Gf474.v(gs329);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.STATESTREAM_STATISTICS) {
            if (LossyStateStreamProfiler.enabled) {
                dv = LossyStateStreamStatistics.deserialise(gs329);
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.PHYSICSCONTROLDEBUGGER_ACTIVATE) {
            Y192.e = Gs329.ar(gs329) == 1;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.ADJUST_PHYSICS_LOOKAHEAD) {
            byte by = Gs329.ax(gs329);
            dz += by;
            if (by > 0) {
                du = true;
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.SET_TARGET) {
            as = Gs329.ak(gs329);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.SERVER_FACTS) {
            int n70 = Gs329.bd(gs329);
            n = Gs329.bd(gs329);
            d = (double)n70 + (double)n / 1000000.0;
            q = Gs329.bd(gs329);
            j = Gs329.bd(gs329);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MAPPEDUPDATE) {
            while (gs329.v < n272.v) {
                object = Ey446.values()[Gs329.ar(gs329)];
                client.cq((Ey446)((Object)object));
            }
            n272.r = null;
            return true;
        }
        Ku323.g((n272.r != null ? n272.r.ordinal() : -1) + A412.q + (n272.k != null ? n272.k.ordinal() : -1) + A412.q + (n272.i != null ? n272.i.ordinal() : -1) + " " + n272.v, new RuntimeException());
        client.ap();
        return true;
    }

    static final void ay() {
        la = false;
        lv = false;
    }

    public static final void bd() {
    }

    private static void bu(Bh77 bh77, Vector3 vector3, Iterator iterator) {
        Am76 am76;
        int n;
        SceneGraphNode sceneGraphNode;
        nh = new File(bh77.r).getName();
        for (n = 0; n < Bh77.da(bh77); ++n) {
            try {
                am76 = Bh77.dx(bh77, n);
                sceneGraphNode = new GameEntity((Bb4)iterator.next(), cj);
                mm.add(sceneGraphNode);
                ca.put(sceneGraphNode, new Ap386());
                XElement.bo(am76, sceneGraphNode, vector3, new T404());
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
            mm.add(sceneGraphNode);
        }
        for (n = 0; n < Bh77.dg(bh77); ++n) {
            am76 = Bh77.er(bh77, n);
            sceneGraphNode = new D75(am76.ah, am76.ap, ((Ao74)am76).d);
            D75.r(sceneGraphNode, vector3);
            mm.add(sceneGraphNode);
        }
        if (bh77.j != null) {
            Scene.g(mm, bh77.j, vector3);
        }
        logger.debug("Building xmap from {}", (Object)bh77.r);
        if (bh77.b != null) {
            mm.q(bh77.b, vector3, bh77.r);
        }
        if (bh77.l != null) {
            Scene.j(mm, eg, bh77.l, bh77.r);
        }
        if (bh77.w != null) {
            Scene.e(mm, eg, bh77.w, bh77.r);
        }
        if (bh77.e != null) {
            Scene.h(mm, bh77.e);
        }
    }

    private static final void aj() {
        Lb33.g(Lb33.VariableSystem);
        try {
            int n = Fw152.g(jw, true);
            while (n != -1) {
                client.cv(n);
                n = Fw152.g(jw, false);
            }
            L410 l410 = L410.q();
            while (l410 != null) {
                VarBasicType varBasicType;
                player player2;
                int n2 = L410.s(l410);
                long l = L410.b(l410);
                if (n2 == 1) {
                    varBasicType = fo.list((int)l);
                    jr.setVarValueInt(varBasicType, l410.g);
                    player2 = Gc330.j();
                    if (player2 != null) {
                        player.cj(player2, varBasicType, l410.g);
                    }
                } else if (n2 == 2) {
                    varBasicType = fo.list((int)l);
                    jr.setVarValue(varBasicType, l410.j);
                    player2 = Gc330.j();
                    if (player2 != null) {
                        player.cj(player2, varBasicType, l410.j);
                    }
                }
                l410 = L410.q();
            }
            Lb33.d(Lb33.VariableSystem);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.VariableSystem);
            throw throwable;
        }
    }

    private static void bl(int n, int n2) {
        int n3;
        String string;
        Object object;
        float f;
        PlayerPhysicsComponent playerPhysicsComponent;
        Object object2;
        double d;
        int n4;
        int n5;
        if (debugconsole.isopen()) {
            return;
        }
        int n6 = D150.j.e + D150.j.h + 2;
        if (lx) {
            object2 = Al161.d < 0 ? "Ping: not available" : "Ping: " + Al161.d + "ms";
            F342.g(D150.s, (String)object2, n, n2, -1, -2013265920);
            n2 += n6;
            Lt501.d(Lt501.PING, Al161.d);
        }
        if (lf) {
            int n7 = 0;
            n5 = 0;
            int n8 = 0;
            for (n4 = 0; n4 < Js5Archive.VALUES.length; ++n4) {
                if (dx[n4] == null) continue;
                n7 += S136.i(dx[n4]);
                n5 += dx[n4].s();
                n8 += dx[n4].b();
            }
            n4 = n8 * 100 / n7;
            n3 = n5 * 10000 / n7;
            object = "Cache:" + D281.g(n3, 2, true, Language.EN) + "% (" + n4 + "%)";
            F342.g(D150.s, (String)object, n, n2 += n6, -1, -2013265920);
            n2 += n6;
        }
        if (lr) {
            PlayerPhysicsComponent playerPhysicsComponent2;
            object2 = String.format("FPS: %.1f (%.2f ms) Average: %.1f Low: %.1f High: %.1f %s", GameShell3.fps, 1000.0 / GameShell3.fps, GameShell3.fpsAverage, GameShell3.fpsL, GameShell3.fpsH, GameShell3.PauseCountFPS == 0.0 ? "" : "(Paused)");
            F342.g(D150.s, (String)object2, n, n2, GameShell3.fps < 30.0 ? -65536 : -256, -2013265920);
            Lt501.d(Lt501.FPS, GameShell3.fps);
            Lt501.d(Lt501.FPSAverage, GameShell3.fpsAverage);
            Lt501.d(Lt501.FPSL, GameShell3.fpsL);
            Lt501.d(Lt501.FPSH, GameShell3.fpsH);
            Lt501.d(Lt501.FPS_TRACKING_PAUSED, GameShell3.PauseCountFPS);
            String string2 = String.format("LPS: %.1f [%d]", GameShell3.lps, client.getspeed());
            F342.g(D150.s, string2, n, n2 += n6, -1, -2013265920);
            Lt501.d(Lt501.LPS, GameShell3.lps);
            String string3 = String.format("PPS: %.1f Lookahead: %d C-S: %d late: %d skipped: %d", GameShell3.pps, dz, ln, Lz409.b, Lz409.l);
            F342.g(D150.s, string3, n, n2 += n6, -1, -2013265920);
            int n9 = n4 = (float)(System.currentTimeMillis() - Lz409.w) > 2.0f * Lq191.d() * 2000.0f ? 1 : 0;
            if (n4 != 0 || M188.q) {
                n3 = Kj334.e(D150.j, string3 + " ");
                object = "";
                if (n4 != 0) {
                    object = "NO DYNAMIC STATES ";
                }
                if (M188.q) {
                    object = (String)object + "EXTRAPOLATING ";
                }
                F342.g(D150.s, (String)object, n + n3, n2, -65536, -2013265920);
            }
            n2 += n6;
            Lt501.d(Lt501.PPS, GameShell3.pps);
            Lt501.d(Lt501.FRAMES_AHEAD, ln);
            if (lo == 0.0) {
                ld += (double)kn;
                if ((ky += 1.0) > 0.0) {
                    kq = ld / ky;
                }
                if ((double)kn > kc) {
                    kc = kn;
                    if (kn > 999.0f) {
                        kc = 999.0;
                    }
                }
                if ((double)kn < kp) {
                    kp = kn;
                }
            }
            String string4 = String.format("Server PPS: %.1f Average: %.1f Low: %.1f High: %.1f %s", Float.valueOf(kn), kq, kp, kc, lo == 0.0 ? "" : "(Paused)");
            F342.g(D150.s, string4, n, n2, -256, -2013265920);
            n2 += n6;
            Lt501.d(Lt501.PPS_TRACKING_PAUSED, lo);
            object = Vector3.g;
            player player2 = Gc330.j();
            if (player2 != null && (playerPhysicsComponent2 = (PlayerPhysicsComponent)player.eb(player2, PlayerPhysicsComponent.class)) != null && playerPhysicsComponent2.q != null) {
                object = playerPhysicsComponent2.getPosition(false);
            }
            F342.g(D150.s, "PhysFramesRemaining: " + f, n, n2, (f = M188.s()) < 0.0f ? -65536 : -1, -2013265920);
            n2 += n6;
            d = Math.toDegrees(ClientScriptAPI.getCameraHeading());
            if (d < 0.0) {
                d += 360.0;
            }
            string = String.format("%5.0f %5.0f %5.0f  %d", Float.valueOf(((Vector3)object).x), Float.valueOf(((Vector3)object).y), Float.valueOf(((Vector3)object).z), (int)d);
            F342.g(D150.s, "LocXYZ CamFace: " + string, n, n2, -1, -2013265920);
            n2 += n6 * 2;
            Lt501.g(Lt501.POSITION, string);
        }
        if (lp) {
            double d2;
            object2 = "NPCs: " + q;
            F342.g(D150.s, (String)object2, n, n2, -32897, -2013265920);
            Lt501.d(Lt501.NPCS, q);
            F342.g(D150.s, "Players: " + j, n, n2 += n6, -32897, -2013265920);
            Lt501.d(Lt501.PLAYERS, j);
            String string5 = String.format("CURRENT BOT: %s %s", debugconsole.d, debugconsole.g);
            F342.g(D150.s, string5, n, n2 += n6, -256, -2013265920);
            n2 += n6;
            Lt501.g(Lt501.BOT_NUMBER, debugconsole.g);
            if (lm) {
                F342.g(D150.s, "Lua Data In: " + lq.j(), n, n2, -6316033, -2013265920);
                F342.g(D150.s, "Lua Data Out: " + ls.j(), n, n2 += n6, -6316033, -2013265920);
                n2 += n6;
            }
            String string6 = (d2 = cj.getLuaPoolSize()) >= 1024.0 ? String.format("%.2fMb", d2 / 1024.0) : String.format("%.2fKb", d2);
            F342.g(D150.s, "CLua: " + string6, n, n2, d2 > 102400.0 ? -32897 : -8388737, -2013265920);
            n2 += n6;
            Lt501.d(Lt501.LUA_MEMORY, d2 / 1024.0);
            if (client.d > 0.0) {
                d2 = client.d;
                string6 = d2 >= 1024.0 ? String.format("%.2fMb", d2 / 1024.0) : String.format("%.2fKb", d2);
                F342.g(D150.s, "SLua: " + string6, n, n2, d2 > 102400.0 ? -32897 : -8388737, -2013265920);
                n2 += n6;
            }
            object = Runtime.getRuntime();
            double d3 = (double)(((Runtime)object).totalMemory() - ((Runtime)object).freeMemory()) / 1048576.0;
            d = (double)((Runtime)object).maxMemory() / 1048576.0;
            string = String.format("%.2fMB/%.2fMB", d3, d);
            F342.g(D150.s, "Java memory: " + string, n, n2, d3 / d > 0.9 ? -32897 : -8388737, -2013265920);
            Lt501.g(Lt501.JAVA_MEMORY, string);
            String string7 = String.format("Unsafe: %.2fMb", (double)Kc180.q() / 1048576.0);
            F342.g(D150.s, string7, n, n2 += n6, -8388737, -2013265920);
            String string8 = String.format("Working set: %.2fMb (Peak: %.2fMb)", (double)ProcessInfo.GetWorkingSetSize() / 1048576.0, (double)ProcessInfo.GetPeakWorkingSetSize() / 1048576.0);
            F342.g(D150.s, string8, n, n2 += n6, -8388737, -2013265920);
            String string9 = String.format("Commit charge: %.2fMb (Peak: %.2fMb)", (double)ProcessInfo.GetCommitCharge() / 1048576.0, (double)ProcessInfo.GetPeakCommitCharge() / 1048576.0);
            F342.g(D150.s, string9, n, n2 += n6, -8388737, -2013265920);
            n2 += n6;
            if (mm != null) {
                String string10 = String.format("SceneGraph: Nodes %d, GameEntities %d", Scene.m(mm), Scene.n(mm));
                F342.g(D150.s, string10, n, n2, -8388737, -2013265920);
                n2 += n6;
                Lt501.d(Lt501.SCENE_NODES, Scene.m(mm));
                Lt501.d(Lt501.GAME_ENTITIES, Scene.n(mm));
            }
        }
        if (lc && (object2 = Gc330.j()) != null && (playerPhysicsComponent = (PlayerPhysicsComponent)player.eb((GameEntity)object2, PlayerPhysicsComponent.class)) != null && playerPhysicsComponent.getAvatar(false) != null && playerPhysicsComponent.getAvatar((boolean)false).b != null) {
            n2 += n6;
            BulletVehicle bulletVehicle = playerPhysicsComponent.getAvatar((boolean)false).b;
            float f2 = Vector3.f(bulletVehicle.e.l());
            f2 = (float)((int)((f2 - 0.2f) * 10.0f)) / 10.0f;
            F342.g(D150.s, "Car speed: " + f2 + " m/s", n, n2 += n6, -1, -2013265920);
            n2 += n6;
            String string11 = new String();
            for (int i = 0; i < BulletVehicle.g(bulletVehicle); ++i) {
                float f3 = bulletVehicle.s(i);
                f = (float)((int)(f3 * 10.0f)) / 10.0f;
                string11 = string11 + "    " + f;
            }
            F342.g(D150.s, "Wheel slip status:" + string11, n, n2, -1, -2013265920);
            n2 += n6;
        }
        if (lk) {
            object2 = String.format("ScrEvt: %d/s (Hndlrs-Act: %d, Cre: %d, Del: %d)", cd, ScriptManager.totalHandlersActive, ScriptManager.totalHandlersCreated, ScriptManager.totalHandlersDestroyed);
            F342.g(D150.s, (String)object2, n, n2, -256, -2013265920);
            n2 += n6;
            Lt501.d(Lt501.SCRIPTEVENTS_HANDLERSEXIST, ScriptManager.totalHandlersCreated - ScriptManager.totalHandlersDestroyed);
            Lt501.d(Lt501.SCRIPTEVENTS_HANDLERSACTIVE, ScriptManager.totalHandlersActive);
            n5 = (int)(System.nanoTime() / 1000000L);
            if (n5 >= cp) {
                cd = ScriptManager.totalHandlersTriggered;
                Lt501.d(Lt501.SCRIPTEVENTS_TRIGGERED, cd);
                ScriptManager.totalHandlersTriggered = 0;
                cp = n5 + 1000;
            }
        }
    }

    private static void bw() {
        PlayerPhysicsComponent playerPhysicsComponent;
        if (!ms) {
            return;
        }
        client.li[client.le] = kn;
        client.md[client.le] = client.getPhysicsSpeed();
        client.me[client.le] = ln;
        client.ly[client.le] = mw;
        mw = 0;
        float f = 0.0f;
        player player2 = Gc330.j();
        if (player2 != null && (playerPhysicsComponent = (PlayerPhysicsComponent)player.eb(player2, PlayerPhysicsComponent.class)) != null && playerPhysicsComponent.q != null) {
            f = M188.l(playerPhysicsComponent.q);
        }
        client.mj[client.le] = f;
        le = (le + 1) % 200;
    }

    public static final void bj(Vector3 vector3) {
        client.bk();
        gu = Ms517.d();
        gz = new Ll42();
        float f = Lq191.d();
        client.gz.d = new PhysicsWorldWrapper(gu.q(f, vector3));
        client.gz.d.d.at(Gn5.aq);
        gk = true;
    }

    public static void aq() {
        client client2 = bu;
        synchronized (client2) {
            Insets insets;
            if (GameShell3.fsframe != null) {
                return;
            }
            Container container = GameShell3.frame != null ? GameShell3.frame : bu.getTopContainer();
            GameShell3.frameWid = container.getSize().width;
            GameShell3.frameHei = container.getSize().height;
            if (container == GameShell3.frame) {
                insets = GameShell3.frame.getInsets();
                GameShell3.frameWid -= insets.left + insets.right;
                GameShell3.frameHei -= insets.top + insets.bottom;
            }
            if (client.a() != J160.SMALL) {
                client.ai();
            } else {
                GameShell3.canvasWid = ii;
                GameShell3.leftMargin = (GameShell3.frameWid - ii) / 2;
                GameShell3.canvasHei = iq;
                GameShell3.topMargin = 0;
            }
            GameShell3.canvas.setSize(GameShell3.canvasWid, GameShell3.canvasHei);
            client.o();
            if (container == GameShell3.frame) {
                insets = GameShell3.frame.getInsets();
                GameShell3.canvas.setLocation(insets.left + GameShell3.leftMargin, insets.top + GameShell3.topMargin);
            } else {
                GameShell3.canvas.setLocation(GameShell3.leftMargin, GameShell3.topMargin);
            }
            client.al();
        }
    }

    @Override
    public final void mainquit() {
        if (jr != null && client.jr.q) {
            client.ab();
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
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (DebugDialog.j != null) {
            DebugDialog.d(DebugDialog.j);
        }
    }

    public static final native void nativeUpdateGameplayStates(long var0, int var2, float var3);

    public static final void br(int n, int n2, Bt286 bt286, float f, float f2, int n3) {
        Object object;
        client.ay();
        if (gb != null && D285.d(gb) != n) {
            for (Npc npc : ft.values()) {
                Npc.ca(npc);
                Scene.w(mm, npc);
            }
            ft.clear();
        }
        logger.debug("Got new build coordinates: {}, {}", Float.valueOf(f), (Object)Float.valueOf(f2));
        gd = f;
        ga = f2;
        client.z(n3);
        int n4 = gn;
        int n5 = gj;
        gn = 0;
        gj = 0;
        int n6 = gn - n4;
        int n7 = gj - n5;
        gb = new D285(n, n2, bt286, gn, gj, gq);
        if (n3 == 12) {
            for (Npc npc : ft.values()) {
                object = Vector3.i(npc.getWorldTransform().trans, n6, 0.0f, n7);
                Npc.w(npc, (Vector3)object);
            }
        } else {
            int n8 = (gp - 1) * 4;
            int n9 = (gy - 1) * 4;
            object = ft.values().iterator();
            while (object.hasNext()) {
                Npc npc = (Npc)object.next();
                Vector3 vector3 = Vector3.i(npc.getWorldTransform().trans, n6, 0.0f, n7);
                Npc.w(npc, vector3);
                if ((int)vector3.x >= 0 && (int)vector3.x <= n8 && (int)vector3.z >= 0 && (int)vector3.z <= n9) continue;
                Npc.ca(npc);
                Scene.w(mm, npc);
                object.remove();
            }
        }
        for (int i = 0; i < 2048; ++i) {
            player player2 = Gc330.e(i);
            if (player2 == null) continue;
            object = Vector3.i(player2.getWorldTransform().trans, n6, 0.0f, n7);
            player.w(player2, (Vector3)object);
        }
        SoundManager.y();
        Hb335.g(jb);
    }

    private static final void ce() {
        Gs329 gs329 = client.fx.b;
        Bb4 bb4 = Bb4.e(gs329, Ed472.NPC);
        Npc npc = (Npc)ft.get(bb4);
        Npc.ca(npc);
        Scene.w(mm, npc);
        ft.remove(bb4);
    }

    public static final void bv(boolean bl) {
        SoundManager.r();
        int n = ac;
    }

    public static final void bn() {
        ca.clear();
        Iterator<E> iterator = client.gb.b.iterator();
        for (Object object : D285.q(gb)) {
            if (G289.g((G289)object) == null) continue;
            client.bz(G289.g((G289)object), G289.d((G289)object) + (float)gn, G289.q((G289)object) + (float)gj);
            client.bu(G289.g((G289)object), new Vector3(G289.d((G289)object), 0.0f, G289.q((G289)object)), iterator);
        }
        for (Object object : ce) {
            ((V385)object).j();
        }
        ce.clear();
        if (ca.isEmpty()) {
            client.bb();
            client.ba();
        } else {
            nw = 0;
            ng = System.currentTimeMillis();
            client.cj.event.triggerEvent("__onMapLoading", (Object)ca.size());
        }
    }

    public static boolean bg(int n) {
        return gb != null && D285.d(gb) == n;
    }

    public static boolean cj(String string) {
        return D236.e(client.ku.e, string) != -1;
    }

    public static void ba() {
        Ag389 ag389;
        while ((ag389 = (Ag389)cv.peek()) != null && !ag389.h()) {
            cv.remove();
            logger.debug("Running delayed {} now", ag389);
            Ag389.s(ag389);
        }
    }

    private static void c(J160 j160, J160 j1602, int n, int n2, boolean bl) {
        Insets insets;
        Container container;
        if (Hq338.g && GameShell3.fsframe != null && (j1602 != J160.FULLSCREEN || n != GameShell3.lastFullscreenWidth || n2 != GameShell3.lastFullscreenHeight)) {
            Hq338.q(GameShell3.fsimp14, GameShell3.fsframe);
            GameShell3.fsframe = null;
        }
        if (Hq338.g && j1602 == J160.FULLSCREEN && GameShell3.fsframe == null && (GameShell3.fsframe = Hq338.d(GameShell3.fsimp14, n, n2, 0, 0)) != null) {
            GameShell3.lastFullscreenWidth = n;
            GameShell3.lastFullscreenHeight = n2;
        }
        if (!(j1602 != J160.FULLSCREEN || Hq338.g && GameShell3.fsframe != null)) {
            client.c(j160, W159.g().j, -1, -1, true);
            return;
        }
        if (GameShell3.fsframe != null) {
            GameShell3.frameWid = n;
            GameShell3.frameHei = n2;
            container = GameShell3.fsframe;
        } else if (GameShell3.frame != null) {
            insets = GameShell3.frame.getInsets();
            GameShell3.frameWid = GameShell3.frame.getSize().width - (insets.left + insets.right);
            GameShell3.frameHei = GameShell3.frame.getSize().height - (insets.top + insets.bottom);
            container = GameShell3.frame;
        } else {
            container = bu.getTopContainer();
            GameShell3.frameWid = container.getSize().width;
            GameShell3.frameHei = container.getSize().height;
        }
        if (j1602 != J160.SMALL) {
            client.ai();
        } else {
            GameShell3.canvasWid = ii;
            GameShell3.leftMargin = (GameShell3.frameWid - ii) / 2;
            GameShell3.canvasHei = iq;
            GameShell3.topMargin = 0;
        }
        GameShell3.canvas.setSize(GameShell3.canvasWid, GameShell3.canvasHei);
        if (H149.y) {
            com.jagex.jnibindings.runetek6.Graphics.resetFromCanvas(GameShell3.canvas, 0, 0, 2, 0, 0, 0);
            H149.x = GameShell3.canvasHei;
            H149.p = GameShell3.canvasWid;
        }
        if (container == GameShell3.frame) {
            insets = GameShell3.frame.getInsets();
            GameShell3.canvas.setLocation(insets.left + GameShell3.leftMargin, insets.top + GameShell3.topMargin);
        } else {
            GameShell3.canvas.setLocation(GameShell3.leftMargin, GameShell3.topMargin);
        }
        id = j1602 == J160.RESIZABLE || j1602 == J160.FULLSCREEN;
        if (client.fx.q != null && client.u(ac)) {
            client.ag();
        }
        GameShell3.fullredraw = true;
    }

    static void bt() {
        long l = System.nanoTime();
        client.cj.event.triggerEvent("__onOptimizeBroadphase", (Object)"start");
        logger.debug("Optimising broadphase for interpolated world...");
        client.gz.d.d.au();
        client.cj.event.triggerEvent("__onOptimizeBroadphase", (Object)"stop");
        long l2 = System.nanoTime();
        logger.debug("Optimize took: {}", l2 - l);
        logger.debug("Baking world irradiance lighting...");
        IrradianceVolumes.initiateIrradianceBake();
    }

    private static void bz(Bh77 bh77, float f, float f2) {
        if (bh77 != null) {
            client.gz.d.e(bh77.j, f, f2);
        }
    }

    public static void bc(BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload, GameEntity gameEntity, Runnable runnable) {
        SceneryConfig sceneryConfig = SceneryConfig.DeserializeHelper(broadcastStateAndEventsTypes$StatePayload.wire_data);
        Bb4 bb4 = broadcastStateAndEventsTypes$StatePayload.broadcasterID;
        logger.trace("Received spawny sceneryconfig for " + bb4);
        if (sceneryConfig.originalElementAddresses == null) {
            logger.trace("Hmmm, was asked to spawn something with a null originalElementAddresses array.  Ignoring.  Hopefully a proper payload will come along later.");
        } else {
            Vector3 vector3 = new Vector3(-gn, 0.0f, -gj);
            Bn279 bn279 = (Bn279)GameEntity.ej(gameEntity, "spawnyMcSpawnins_AsynchronousTask");
            if (bn279 != null) {
                Bn279.j(bn279);
            }
            Bn279 bn2792 = l.g(new Z392(sceneryConfig, gameEntity, vector3, runnable), gf, null);
            gameEntity.setProperty("spawnyMcSpawnins_AsynchronousTask", bn2792);
        }
    }

    public static final boolean be(N272 n272) {
        try {
            return client.bs(n272);
        }
        catch (IOException iOException) {
            client.at();
            logger.error("Exception in TCP In. Reconnecting....", iOException);
            return true;
        }
        catch (Exception exception) {
            String string = (n272.r != null ? n272.r.ordinal() : -1) + A412.q + (n272.k != null ? n272.k.ordinal() : -1) + A412.q + (n272.i != null ? n272.i.ordinal() : -1) + " " + n272.v + A412.q + " ";
            for (int i = 0; i < n272.v && i < 50; ++i) {
                string = string + n272.b.r[i] + A412.q;
            }
            logger.error(string, exception);
            Ku323.g(string, exception);
            client.ap();
            return true;
        }
    }

    private static final void bx(float f) {
        if (gq == f) {
            return;
        }
        gp = gy = (int)Math.ceil(f / 4.0f);
        gq = f;
    }

    public static void cw(Ag389 ag389) {
        if (cv.isEmpty() && !ag389.h()) {
            Ag389.s(ag389);
            return;
        }
        logger.debug("Delaying {}", ag389);
        cv.add(ag389);
    }

    public static final void cq(Ey446 ey446) {
        Gs329 gs329 = client.fx.b;
        if (ey446 == Ey446.LOC_CHANGE) {
            UUID uUID = gs329.bo();
            int n = Gs329.bd(gs329);
            logger.trace("Received loc_change guid: {}, id: {}", uUID, (Object)n);
            return;
        }
        if (ey446 == Ey446.LOC_DEL) {
            UUID uUID = gs329.bo();
            logger.trace("Received loc_del guid: {}", uUID);
            return;
        }
        if (ey446 == Ey446.LOC_CUSTOMISE) {
            UUID uUID = gs329.bo();
            int n = Gs329.ar(gs329);
            return;
        }
        if (ey446 == Ey446.LOC_ANIM) {
            UUID uUID = gs329.bo();
            int n = Gs329.bd(gs329);
            logger.trace("Received loc_anim guid: {}", uUID);
            client.ca(uUID, n);
            return;
        }
        if (ey446 == Ey446.FMOD_PLAY_SOUND_AREA) {
            int n = Gs329.bd(gs329);
            String string = Gs329.bk(gs329);
            int n2 = Gs329.bd(gs329);
            int n3 = Gs329.bd(gs329);
            int n4 = Gs329.bd(gs329);
            logger.trace("Received PlaySoundArea");
            SoundManager.c(n, new Vector3(n2, n3, n4), string);
            return;
        }
        if (ey446 == Ey446.SOUND_AREA) {
            float f = Gs329.bl(gs329) - (float)gn;
            float f2 = Gs329.bl(gs329) - (float)gj;
            int n = Gs329.au(gs329);
            if (n == 65535) {
                n = -1;
            }
            int n5 = Gs329.ar(gs329);
            int n6 = n5 >> 4 & 0xF;
            int n7 = n5 & 7;
            int n8 = Gs329.ar(gs329);
            int n9 = Gs329.ar(gs329);
            int n10 = Gs329.au(gs329);
            Object[] arrobject = new Object[]{Float.valueOf(f), Float.valueOf(f2), n6, n, n7};
            logger.trace("Received sound_area x: {}, z: {}, range: {}, synth: {}, loops: {}", arrobject);
            if (f >= 0.0f && f2 >= 0.0f && f < (float)(gp << 2) && f2 < (float)(gy << 2)) {
                int n11 = n6 + 1 << 2;
                float f3 = Gc330.j().getWorldTransform().trans.x;
                float f4 = Gc330.j().getWorldTransform().trans.z;
                if (f3 >= f - (float)n11 && f3 <= f + (float)n11 && f4 >= f2 - (float)n11 && f4 <= f2 + (float)n11) {
                    SoundManager.x(n, n7, n8, n9, f, f2, n6 << 2, n10);
                }
            }
            return;
        }
        if (ey446 == Ey446.SOUND_VORBIS_AREA) {
            int n = Gs329.ar(gs329);
            float f = Gs329.bl(gs329) - (float)gn;
            float f5 = Gs329.bl(gs329) - (float)gj;
            int n12 = Gs329.au(gs329);
            if (n12 == 65535) {
                n12 = -1;
            }
            int n13 = Gs329.ar(gs329);
            int n14 = n13 >> 4 & 0xF;
            int n15 = n13 & 7;
            int n16 = Gs329.ar(gs329);
            int n17 = Gs329.ar(gs329);
            int n18 = Gs329.au(gs329);
            Object[] arrobject = new Object[]{Float.valueOf(f), Float.valueOf(f5), n14, n12, n15};
            logger.trace("Received sound_vorbis_area x: {},  z: {}, range: {}, vorbis: {}, loops: {}", arrobject);
            if (f >= 0.0f && f5 >= 0.0f && f < (float)(gp << 2) && f5 < (float)(gy << 2)) {
                int n19 = n14 + 1 << 2;
                float f6 = Gc330.j().getWorldTransform().trans.x;
                float f7 = Gc330.j().getWorldTransform().trans.z;
                if (f6 >= f - (float)n19 && f6 <= f + (float)n19 && f7 >= f5 - (float)n19 && f7 <= f5 + (float)n19) {
                    SoundManager.z(n12, n15, n16, n17, f, f5, n14 << 2, false, n18);
                }
            }
            return;
        }
        if (ey446 == Ey446.LOC_PREFETCH) {
            int n = Gs329.bd(gs329);
            int n20 = Gs329.ar(gs329);
            return;
        }
        if (ey446 == Ey446.TEXT_COORD) {
            Gs329.ar(gs329);
            float f = Gs329.bl(gs329) - (float)gn;
            float f8 = Gs329.bl(gs329) - (float)gj;
            int n = Gs329.au(gs329);
            int n21 = Gs329.ar(gs329);
            int n22 = Gs329.ay(gs329);
            String string = Gs329.bk(gs329);
            try {
                int n23 = Integer.parseInt(string);
                int n24 = (int)client.bh(f, f8);
                client.cm(f, f8, n21, n, n23 == n24 ? -16711936 : -65536, n23 + ":" + n24);
            }
            catch (NumberFormatException numberFormatException) {
                client.cm(f, f8, n21, n, n22, string);
            }
            return;
        }
        Ku323.g("" + (Object)((Object)ey446), new RuntimeException());
        client.ap();
    }

    private static final void cp() {
        Gs329 gs329 = client.fx.b;
        Gs329.h(gs329);
        boolean bl = gs329.s(1) == 1;
        Gs329.b(gs329);
        Bb4 bb4 = Bb4.e(gs329, Ed472.NPC);
        int n = -1;
        if (bl) {
            n = Gs329.au(gs329);
        }
        float f = Gs329.bl(gs329);
        float f2 = Gs329.bl(gs329);
        int n2 = Gs329.ar(gs329);
        int n3 = Gs329.au(gs329);
        float f3 = Gs329.bl(gs329);
        float f4 = Gs329.bl(gs329);
        float f5 = Gs329.bl(gs329);
        float f6 = Gs329.bl(gs329);
        Npc npc = (Npc)ft.get(bb4);
        if (npc != null) {
            throw new IllegalStateException(npc.toString());
        }
        Vector3 vector3 = new Vector3(f3, f4, f5);
        Quaternion quaternion = Lr302.d(f6);
        Npc npc2 = new Npc(bb4);
        npc2.setObjectTranslation(f3, f4, f5);
        mm.add(npc2);
        Npc.bn(npc2, f, f2, n2, n3);
        if (n >= 0) {
            XElement.ai.r(npc2, n, new O396(npc2, vector3, quaternion));
        }
        if (n < 0 || Jt38.t(f, f2)) {
            npc2.bt(vector3, quaternion);
        }
        ft.put(bb4, npc2);
        ScheduledMovementComponent.u(npc2.i, dq);
    }

    private static final void cd() {
        Gs329 gs329 = client.fx.b;
        Bb4 bb4 = Bb4.e(gs329, Ed472.NPC);
        float f = Gs329.bl(gs329);
        float f2 = Gs329.bl(gs329);
        int n = Gs329.ar(gs329);
        int n2 = Gs329.au(gs329);
        Npc npc = (Npc)ft.get(bb4);
        Npc.bn(npc, f, f2, n, n2);
    }

    private static final void ck() {
        Gb471.g(client.fx.b);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final void bo(int n, int n2, int n3, int n4) {
        if (mm == null || Gc330.j() == null) {
            C340.e(n, n2, n3, n4, -16777216);
            return;
        }
        Lb33.g(Lb33.GameDraw);
        try {
            ++hv;
            C340.y(n, n2, n3, n4);
            C340.j(n, n2, n + n3, n2 + n4);
            ScriptCamera scriptCamera = ScriptCamera.getActiveCamera();
            if (scriptCamera != null) {
                RotTrans rotTrans = ScriptCamera.v(scriptCamera).q();
                H303.q(ax, rotTrans);
                ar = scriptCamera.ai;
                if (bd == null) {
                    client.ao();
                }
                double d = scriptCamera.getWorldTransform().trans.x - client.bd.x;
                double d2 = scriptCamera.getWorldTransform().trans.y - client.bd.y;
                double d3 = scriptCamera.getWorldTransform().trans.z - client.bd.z;
                double d4 = d * d + d2 * d2 + d3 * d3;
                float f = 10.0f;
                if (d4 >= 100.0) {
                    client.ao();
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
            }
            catch (Exception exception) {
                logger.error("", exception);
            }
            SoundManager.r();
            if (ae && W144.e(dm) == 0) {
                ae = false;
            }
            if (ae) {
                C340.e(n, n2, n3, n4, -16777216);
                lb = GameShell3.renderFrameCount;
            }
            try {
                if (w) {
                    // empty if block
                }
            }
            catch (Exception exception) {
                logger.error("", exception);
            }
            Lb33.d(Lb33.GameDraw);
            return;
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.GameDraw);
            throw throwable;
        }
    }

    public static void ca(UUID uUID, int n) {
    }

    public static void cb() {
        El328 el328 = El328.d(Eu326.TRANSMITVAR_VERIFYID, client.fx.s);
        Gs329.a(el328.q, fe);
        N272.e(fx, el328);
    }

    public static boolean cl() {
        ++fe;
        ff = true;
        return true;
    }

    static void ao() {
        XElementLibrary.y(XElement.ai);
        XElement.bm();
        ScriptCamera scriptCamera = ScriptCamera.getActiveCamera();
        bd = scriptCamera != null ? scriptCamera.getWorldTransform().trans : null;
    }

    public static void cm(float f, float f2, int n, int n2, int n3, String string) {
        X390 x390 = new X390();
        x390.g = f;
        x390.d = f2;
        x390.j = bj + n2;
        x390.q = n;
        x390.h = string;
        x390.e = n3;
        Hb335.d(jb, x390);
    }

    public static final void bk() {
        gk = false;
        if (client.gz.d != null) {
            PhysicsWorldWrapper.l(client.gz.d);
            client.gz.d = null;
        }
    }

    private static void w(ArrayList arrayList, SceneGraphNode sceneGraphNode) {
        if (sceneGraphNode.g() != 0L) {
            arrayList.add(sceneGraphNode);
        }
        for (SceneGraphNode sceneGraphNode2 : sceneGraphNode.ai()) {
            client.w(arrayList, sceneGraphNode2);
        }
    }

    public static int aa(Vector3 vector3) {
        ScriptCamera scriptCamera = ScriptCamera.getActiveCamera();
        if (scriptCamera != null) {
            Vector3 vector32 = scriptCamera.getWorldTransform().trans;
            float f = vector3.x - vector32.x;
            float f2 = vector3.y - vector32.y;
            float f3 = vector3.z - vector32.z;
            float f4 = f * f + f2 * f2 + f3 * f3;
            if (f4 < 1.0f) {
                f4 = 1.0f;
            }
            return (int)(1000000.0f / f4);
        }
        return 0;
    }

    public static boolean u(int n) {
        return n == 11 || n == 12;
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
            player player2 = Gc330.j();
            int n = dc.e();
            int n2 = Lz409.p(Lz409.d);
            for (L51 l51 : Gc330.h()) {
                player.bs(l51);
                l51.f.discardStates(n);
                if (n2 >= 0) {
                    l51.c.discardStates(n2);
                    l51.ag.discardStates(n2);
                }
                l51.a.discardStates(n);
            }
            for (L51 l51 : ft.values()) {
                ScheduledMovementComponent.p(((Npc)l51).i, n);
                if (n2 < 0) continue;
                ScheduledMovementComponent.x(((Npc)l51).i, n2);
            }
            if (client.gz.d.d == null) {
                Lb33.d(Lb33.Physics);
                return;
            }
            Lz409.b(Lz409.d);
            Lz409.y();
            int n3 = df;
            int n4 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(df, Lq191.j() - dz);
            if (la) {
                LuaNativeEvents.invokeOnUpdatePhysicsPre(cj.getLuaStateNativeRef());
                String string = "client";
                if (player2 != null) {
                    string = "client_" + player2.aq;
                }
                for (Iterator<Object> iterator : Gc330.h()) {
                    int n5 = n3;
                    if (iterator != player2) {
                        n5 = n4;
                    }
                    PlayerPhysicsComponent.p((PlayerPhysicsComponent)player.eb((GameEntity)((Object)iterator), PlayerPhysicsComponent.class), n5, false, true, string);
                    ((PlayerPhysicsComponent)player.eb(iterator, PlayerPhysicsComponent.class)).i(n5, false);
                }
                if (mm != null) {
                    for (Iterator<Object> iterator : mm.x(ScheduledMovementComponent.class)) {
                        ScheduledMovementComponent.h((ScheduledMovementComponent)((Object)iterator), n3, false, true);
                    }
                }
                Iterator<E> iterator = new ArrayList<E>();
                client.gz.d.d.ak((ArrayList)((Object)iterator));
                Y192.q();
                client.gz.d.j((ArrayList)((Object)iterator));
                for (player player3 : Gc330.h()) {
                    ((PlayerPhysicsComponent)player.eb(player3, PlayerPhysicsComponent.class)).u();
                }
                if (mm != null) {
                    for (ScheduledMovementComponent scheduledMovementComponent : mm.x(ScheduledMovementComponent.class)) {
                        ScheduledMovementComponent.l(scheduledMovementComponent);
                    }
                }
                LuaNativeEvents.invokeOnUpdatePhysicsPost(cj.getLuaStateNativeRef());
            }
            df = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(df, 1);
            Lz409.v(df);
            M188.e();
            Lb33.d(Lb33.Physics);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.Physics);
            throw throwable;
        }
    }

    public static void au() {
        long l;
        long l2;
        if (client.fx.q != null && (l2 = (l = System.currentTimeMillis()) - N272.g(fx)) > 200L) {
            El328 el328 = El328.d(Eu326.NO_TIMEOUT, client.fx.s);
            N272.e(fx, el328);
            N272.d(fx, l);
        }
    }

    public static final void at() {
        fr = client.fx.q;
        client.fx.q = null;
        client.ap();
    }

    public static boolean r(int n) {
        return n == 0;
    }

    public static void k() {
        client.cj.event.triggerEvent("__onStartup", null);
    }

    public static final void bp() {
        Gs329 gs329 = client.fx.b;
        float f = Gg3.bl(gs329);
        float f2 = Gg3.bl(gs329);
        float f3 = Gg3.bl(gs329);
        int n = Gg3.bd(gs329);
        int n2 = Gg3.bd(gs329);
        Bt286 bt286 = Bt286.m(gs329, Ed472.STATIC_SCENERY);
        client.bx(f);
        client.br(n2, n, bt286, f2, f3, 12);
    }

    public static boolean x(int n) {
        return n == 3 || n == 6;
    }

    private List cc(List list) {
        ArrayList<BufferedImage> arrayList = new ArrayList<BufferedImage>();
        for (String string : list) {
            BufferedImage bufferedImage = null;
            try {
                URL uRL = this.getClass().getClassLoader().getResource(string);
                if (uRL == null) {
                    uRL = new File("../clientjar/" + string).toURI().toURL();
                }
                if (uRL != null) {
                    bufferedImage = ImageIO.read(uRL);
                }
            }
            catch (IOException iOException) {
                logger.debug("", iOException);
            }
            arrayList.add(bufferedImage);
        }
        return arrayList;
    }

    public static final void bm() {
        C340.q();
        hf = 0;
    }

    @Override
    public final void init() {
        if (!this.checkhost()) {
            return;
        }
        Z132.g("client.init()");
        block28 : for (Ev579 ev579 : Ev579.values()) {
            String string = this.getParameter(ev579.aq);
            if (string == null) continue;
            switch (Integer.parseInt(ev579.aq)) {
                case 26: {
                    if (string.equalsIgnoreCase(A412.g)) {
                        k = true;
                        continue block28;
                    }
                    k = false;
                    continue block28;
                }
                case 29: {
                    Lf336.j = new Lx337();
                    Lf336.j.g = Integer.parseInt(string);
                    continue block28;
                }
                case 27: {
                    t = (D123)E294.g(D123.class, Integer.parseInt(string));
                    if (t == D123.LOCAL) {
                        t = D123.WTWIP;
                        continue block28;
                    }
                    if (D123.d(t, G320.OFFICE) || t == D123.LIVE) continue block28;
                    t = D123.LIVE;
                    continue block28;
                }
                case 4: {
                    z = Gm479.g(Integer.parseInt(string));
                    if (z == Gm479.WIP || z == Gm479.RC || z == Gm479.BUILDLIVE || z == Gm479.LIVE) continue block28;
                    z = Gm479.LIVE;
                    continue block28;
                }
                case 5: {
                    m = Gd27.g(Integer.parseInt(string));
                    continue block28;
                }
                case 6: {
                    n = Language.j(Integer.parseInt(string));
                    continue block28;
                }
                case 7: {
                    f = Integer.parseInt(string);
                    continue block28;
                }
                case 8: {
                    if (string.equalsIgnoreCase(A412.g)) {
                        i = true;
                        continue block28;
                    }
                    i = false;
                    continue block28;
                }
                case 9: {
                    c = string;
                    continue block28;
                }
                case 10: {
                    o = string;
                    continue block28;
                }
                case 28: {
                    if (!string.equalsIgnoreCase(A412.g)) continue block28;
                    az = true;
                    ip = true;
                    continue block28;
                }
                case 11: {
                    a = Integer.parseInt(string);
                    continue block28;
                }
                case 12: {
                    if (string.equalsIgnoreCase(A412.g)) {
                        ao = true;
                        continue block28;
                    }
                    ao = false;
                    continue block28;
                }
                case 13: {
                    if (string.equalsIgnoreCase(A412.g)) {
                        aa = true;
                        continue block28;
                    }
                    aa = false;
                    continue block28;
                }
                case 25: {
                    if (string.equalsIgnoreCase(A412.g)) {
                        an = true;
                        continue block28;
                    }
                    an = false;
                    continue block28;
                }
                case 14: {
                    if (string.equalsIgnoreCase(A412.g)) {
                        am = true;
                        continue block28;
                    }
                    am = false;
                    continue block28;
                }
                case 15: {
                    continue block28;
                }
                case 16: {
                    continue block28;
                }
                case 18: {
                    Object n = G282.q(Mi507.g(string));
                    if (((byte[])n).length < 16) {
                        ah = null;
                        continue block28;
                    }
                    ah = new R273((byte[])n, false);
                    continue block28;
                }
                case 30: {
                    Object n = new Gg3(50);
                    Gg3.ag((Gg3)n, Long.parseLong(string));
                    Gg3.ag((Gg3)n, (long)(Math.random() * 9.223372036854776E18));
                    ah = new R273(n.r, true);
                    continue block28;
                }
                case 17: {
                    client.ap.q = Integer.parseInt(string);
                    continue block28;
                }
                case 20: {
                    client.ap.g = Long.parseLong(string);
                    continue block28;
                }
                case 21: {
                    client.ap.d = string;
                    if (client.ap.d.length() <= 50) continue block28;
                    client.ap.d = null;
                    continue block28;
                }
                case 22: {
                    if (string.equals(A412.g)) {
                        fw = true;
                        continue block28;
                    }
                    fw = false;
                    continue block28;
                }
                case 24: {
                    br = string;
                    continue block28;
                }
                case 31: {
                    int n = string.lastIndexOf(58);
                    af = string.substring(0, n);
                    av = Integer.parseInt(string.substring(n + 1));
                    System.out.println("Using alias server " + af + ":" + av);
                    continue block28;
                }
                default: {
                    Ku323.g("Parameter not implemented in client: " + ev579.aq, new RuntimeException());
                }
            }
        }
        if (m == Gd27.RUNESCAPE || m == Gd27.ALTERNATEREALITY || m == Gd27.TRANSFORMERS) {
            ii = 765;
            iq = 503;
        } else if (m == Gd27.STELLARDAWN) {
            ii = 640;
            iq = 480;
        }
        GameShell3$FrameParameters gameShell3$FrameParameters = new GameShell3$FrameParameters(ii, iq, ib, ij, client.m.s);
        int n = 1;
        bu = this;
        this.startApplet(gameShell3$FrameParameters, client.m.h, client.z.h, 32 + client.z.s, Js5Archive.getRequiredArrayLength(), n != 0, 1, 1, am);
    }

    private void s(float f) {
        Lb33.g(Lb33.MainLoop);
        try {
            Object object;
            Lb33.g(Lb33.zMainLoopBeginning);
            try {
                Ko370.d();
                Hi86.q(lh);
                if (ac == 16) {
                    Lb33.d(Lb33.zMainLoopBeginning);
                    Lb33.d(Lb33.MainLoop);
                    return;
                }
                Lb33.g(Lb33.NetStats);
                hd = (int)((hw += f) / 0.02f);
                if (hd > 0) {
                    hw -= (float)(hd * 1) / 50.0f;
                }
                for (int i = 0; i < hd; ++i) {
                    if (++bj % 1000 == 1) {
                        object = new GregorianCalendar();
                        hy = ((Calendar)object).get(11) * 600 + ((Calendar)object).get(12) * 10 + ((Calendar)object).get(13) / 6;
                        hl.setSeed(hy);
                    }
                    N272.h(fx);
                }
                Lb33.d(Lb33.NetStats);
                client.t(this, f);
                if (dt != null) {
                    G137.j(dt);
                }
                Lb33.d(Lb33.zMainLoopBeginning);
            }
            catch (Throwable throwable) {
                Lb33.d(Lb33.zMainLoopBeginning);
                throw throwable;
            }
            Lb33.g(Lb33.zSoundManager);
            SoundManager.w();
            Lb33.d(Lb33.zSoundManager);
            Lb33.g(Lb33.zEvents);
            try {
                if (cj != null) {
                    LuaNativeEvents.d(cj.getLuaStateNativeRef(), f);
                }
                Lb33.d(Lb33.zEvents);
            }
            catch (Throwable throwable) {
                Lb33.d(Lb33.zEvents);
                throw throwable;
            }
            Lb33.g(Lb33.XElementQueue);
            XElement.bd();
            if (XElement.ai != null) {
                XElementLibrary.v(XElement.ai);
            }
            Lb33.d(Lb33.XElementQueue);
            Lb33.g(Lb33.zDebug);
            try {
                if (cj != null && client.cj.luaConsole != null) {
                    client.cj.luaConsole.service();
                }
                if (Scripting.q() > 0) {
                    Scripting.e(cj.getScriptManagerNativeRef(), cj.getLuaStateNativeRef());
                }
                if (debugconsole.isopen()) {
                    debugconsole.e();
                }
                Lb33.d(Lb33.zDebug);
            }
            catch (Throwable throwable) {
                Lb33.d(Lb33.zDebug);
                throw throwable;
            }
            if (client.r(ac)) {
                Lb33.g(Lb33.Loading);
                try {
                    Load.g();
                    client.doneslowupdate();
                    Lb33.d(Lb33.Loading);
                }
                catch (Throwable throwable) {
                    Lb33.d(Lb33.Loading);
                    throw throwable;
                }
            } else if (client.y(ac)) {
                client.bf();
            }
            if (mm != null) {
                Scene.d(mm);
            }
            if (!client.y(ac)) {
                if (client.p(ac)) {
                    client.aw(this);
                    if (ac == 6) {
                        Lb33.g(Lb33.ProcessActiveLogin);
                        try {
                            W274 w274 = Login.j(f);
                            if (w274 != null && w274.g != E275.SUCCESS) {
                                if (w274.q != null) {
                                    object = w274.d;
                                    w274.q.trigger(null, object != null ? Integer.valueOf(((Mf509)object).getId()) : null);
                                }
                                client.ap();
                            }
                            Lb33.d(Lb33.ProcessActiveLogin);
                        }
                        catch (Throwable throwable) {
                            Lb33.d(Lb33.ProcessActiveLogin);
                            throw throwable;
                        }
                    }
                } else if (client.u(ac)) {
                    client.ar(f);
                } else if (ac == 14 || ac == 15) {
                    Lb33.g(Lb33.Login);
                    try {
                        W274 w274 = Login.j(f);
                        if (w274 != null && w274.g != E275.SUCCESS) {
                            if (ac == 15) {
                                if (Lf336.h) {
                                    Lf336.d(Lf336.e.g, Lf336.e.d);
                                    Login.d();
                                } else {
                                    client.ap();
                                }
                            } else {
                                client.ap();
                            }
                        }
                        Lb33.d(Lb33.Login);
                    }
                    catch (Throwable throwable) {
                        Lb33.d(Lb33.Login);
                        throw throwable;
                    }
                }
            }
            Lb33.d(Lb33.MainLoop);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.MainLoop);
            throw throwable;
        }
    }

    public static void an(Q79 q79, String string) {
        byte[] arrby;
        XElementLibrary xElementLibrary = new XElementLibrary(lh, lw, q79, new Az669());
        if (string == null || w) {
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
        Hi86.u(lh, XElement.class, xElementLibrary.s);
        Hi86.u(lh, Bj61.class, Bj61.d);
        XElement.ai = xElementLibrary;
        if (string != null) {
            // empty if block
        }
        if ((arrby = js5.y(eu, DefaultsGroup.ERROR.js5GroupId)) != null) {
            Hi86.d(lh, new Gg3(arrby));
        }
    }

    public static final void cv(int n) {
        At476.d();
        int n2 = ((VarPlayerType)client.fd.list((int)n)).clientCode;
        if (n2 == 0) {
            return;
        }
        int n3 = jw.getVarValueInt(fd.list(n));
        if (n2 == 6) {
            jx = n3;
        }
    }

    public static final void bq(long l) {
        C340.q();
        hf = 0;
    }

    public static final void bf() {
        Lb33.g(Lb33.MapBuild);
        try {
            Object object;
            client.bv(false);
            if (!gb.g()) {
                Lb33.d(Lb33.MapBuild);
                return;
            }
            if (mm != null) {
                for (GameEntity gameEntity : Gc330.h()) {
                    PlayerPhysicsComponent.l((PlayerPhysicsComponent)player.eb(gameEntity, PlayerPhysicsComponent.class));
                    gameEntity.ba = null;
                    mm.remove(gameEntity, true, false);
                }
                for (GameEntity gameEntity : ft.values()) {
                    Npc.cp((Npc)gameEntity);
                    mm.remove(gameEntity, true, false);
                }
                for (GameEntity gameEntity : ClientScriptAPI.g) {
                    mm.remove(gameEntity, true, false);
                }
            }
            long l = Gz143.g();
            logger.debug("Profile: Starting...");
            client.ak();
            for (GameEntity gameEntity : Gc330.h()) {
                if (!player.ee(gameEntity, PlayerPhysicsComponent.class)) continue;
                player.co(gameEntity);
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
            client.bv(true);
            logger.debug("Profile: Reset took: {} ms", Gz143.g() - l);
            l = Gz143.g();
            logger.debug("Profile: Overworld ground build took: {} ms", Gz143.g() - l);
            l = Gz143.g();
            client.bv(true);
            client.bn();
            logger.debug("Profile: Overworld location load took: {} ms", Gz143.g() - l);
            l = Gz143.g();
            client.bv(true);
            logger.debug("Profile: Overworld finish ground took: {} ms", Gz143.g() - l);
            l = Gz143.g();
            for (GameEntity gameEntity : Gc330.h()) {
                mm.add(gameEntity);
                if (!player.ee(gameEntity, PlayerPhysicsComponent.class)) continue;
                player.cy(gameEntity);
            }
            for (GameEntity gameEntity : ft.values()) {
                mm.add(gameEntity);
                Npc.cd((Npc)gameEntity);
            }
            for (GameEntity gameEntity : ClientScriptAPI.g) {
                mm.add(gameEntity);
            }
            SoundManager.r();
            if (GameShell3.getEnvironment() == GameShell3$Environment.APPLICATION && client.fx.q != null && ac == 12) {
                object = El328.d(Eu326.DETECT_MODIFIED_CLIENT, client.fx.s);
                Gs329.a(((El328)object).q, 1057001181);
                N272.e(fx, (El328)object);
            }
            if (ac == 4) {
                client.z(3);
            } else {
                client.z(11);
                if (client.fx.q != null) {
                    object = El328.d(Eu326.MAP_BUILD_COMPLETE, client.fx.s);
                    N272.e(fx, (El328)object);
                }
            }
            SoundManager.r();
            client.ao();
            client.doneslowupdate();
            logger.debug("Profile: Final stage took: {} ms", Gz143.g() - l);
            l = Gz143.g();
            if (gc) {
                debugconsole.addline(Long.toString(Gz143.g() - gv));
                gc = false;
            }
            Lb33.d(Lb33.MapBuild);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.MapBuild);
            throw throwable;
        }
    }
}

