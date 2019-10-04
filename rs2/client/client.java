// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.game.runetek6.client.GameShell3$Environment;
import com.jagex.game.runetek6.config.defaults.DefaultsGroup;
import tfu.Gu487;
import com.jagex.game.runetek6.xelement.Bj61;
import com.jagex.game.runetek6.xelement.T101;
import tfu.Iz11;
import tfu.Fk353;
import com.jagex.jnibindings.runetek6.Skeleton;
import tfu.Ib29;
import tfu.Gt488;
import tfu.Fc454;
import tfu.Ip424;
import tfu.Gv486;
import com.jagex.game.runetek6.xelement.Bk68;
import com.jagex.game.runetek6.xelement.Q79;
import rs2.client.login.W274;
import rs2.client.login.E275;
import com.jagex.jnibindings.runetek6.Scripting;
import java.util.GregorianCalendar;
import tfu.Ko370;
import com.jagex.game.runetek6.client.GameShell3$FrameParameters;
import com.jagex.core.stringtools.general.G282;
import tfu.Mi507;
import com.jagex.core.constants.E294;
import tfu.Ev579;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import tfu.Ky391;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import tfu.C340;
import tfu.Gb471;
import com.jagex.maths.Quaternion;
import tfu.Jt38;
import tfu.Lr302;
import java.util.UUID;
import tfu.Br121;
import com.jagex.game.runetek6.comms.broadcast.SceneryConfig;
import com.jagex.jnibindings.runetek6.IrradianceVolumes;
import tfu.G289;
import rs2.client.worldelement.Npc;
import tfu.Bt286;
import rs2.client.lua.debugdialog.DebugDialog;
import com.jagex.jnibindings.runetek6.NativeResourceLoader;
import rs2.shared.movement.PhysicsWorldWrapper;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.ProcessInfo;
import tfu.Kj334;
import com.jagex.core.stringtools.general.D281;
import tfu.Lt501;
import tfu.F342;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.xelement.Ao74;
import com.jagex.game.runetek6.xelement.J113;
import com.jagex.game.runetek6.scenegraph.D75;
import com.jagex.game.runetek6.scenegraph.L170;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.xelement.XElement;
import tfu.Bb4;
import com.jagex.game.runetek6.xelement.N78;
import com.jagex.game.runetek6.xelement.Bh77;
import tfu.Az399;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import tfu.Kr260;
import tfu.Ey446;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler;
import tfu.Lk495;
import tfu.Dp208;
import com.jagex.core.stringtools.general.J173;
import tfu.Ly234;
import tfu.Md230;
import tfu.Dg449;
import tfu.Ee573;
import com.jagex.core.stringtools.general.Q280;
import rs2.client.friends.D236;
import tfu.Et578;
import tfu.Af155;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTransmission;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import rs2.client.inventory.ClientInventory;
import java.util.List;
import rs2.client.chat.G232;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import tfu.Ea395;
import tfu.Gs329;
import tfu.Jv532;
import tfu.Gf474;
import rs2.client.lua.ClientScriptMessaging;
import com.jagex.game.runetek6.gameentity.components.ProcessLogicEventComponent;
import com.jagex.game.runetek6.gameentity.components.TimerComponent;
import rs2.shared.sound.SoundComponent;
import com.jagex.game.runetek6.gameentity.animation.AnimationGraphComponent;
import tfu.Ji520;
import tfu.Bn279;
import tfu.Mu209;
import rs2.client.login.J570;
import tfu.At476;
import rs2.client.sound.SoundManager;
import tfu.W667;
import rs2.client.inventory.G451;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import rs2.client.lua.ClientScriptAPI;
import com.jagex.game.runetek6.config.cursortype.CursorType;
import java.awt.Point;
import tfu.Fj373;
import com.jagex.jnibindings.runetek6.Graphics;
import java.io.IOException;
import tfu.Ja527;
import tfu.Ex582;
import tfu.Mf509;
import java.applet.Applet;
import rs2.client.web.G405;
import rs2.client.login.Login;
import tfu.Ku323;
import com.jagex.core.stringtools.general.StringTools;
import tfu.Lx337;
import java.util.TimeZone;
import java.util.HashMap;
import com.jagex.game.runetek6.config.Js5Archive;
import org.slf4j.LoggerFactory;
import rs2.client.worldelement.NpcComponent;
import rs2.client.worldelement.PlayerComponent;
import tfu.Gj16;
import java.awt.Insets;
import java.awt.Container;
import java.util.Iterator;
import java.util.Collection;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.jnibindings.runetek6.NavPowerClient;
import tfu.Jh522;
import rs2.client.loading.Load;
import tfu.B665;
import tfu.Hq338;
import rs2.shared.movement.ScheduledMovementComponent;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import rs2.shared.movement.PlayerPhysicsAvatar;
import rs2.client.worldelement.player;
import tfu.Gn5;
import tfu.Gh19;
import rs2.shared.movement.PlayerAvatarDescriptor;
import rs2.shared.movement.PlayerPhysicsComponent;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import tfu.H149;
import com.jagex.maths.ScaleRotTrans;
import tfu.Gc330;
import tfu.Kc180;
import tfu.Lv148;
import tfu.Lb33;
import rs2.shared.movement.Y192;
import java.io.File;
import tfu.Ba115;
import tfu.Ej287;
import tfu.Bc288;
import tfu.Ed472;
import tfu.Bz650;
import tfu.Mk163;
import tfu.Lq191;
import com.jagex.game.runetek6.config.objtype.ObjType;
import java.net.UnknownHostException;
import java.net.InetAddress;
import com.jagex.core.constants.G320;
import tfu.Lf336;
import com.jagex.game.runetek6.comms.broadcast.CommonStateAndEventTypes;
import com.jagex.maths.Ag566;
import com.jagex.maths.O166;
import com.jagex.maths.I48;
import tfu.Mv477;
import java.awt.Frame;
import tfu.Gl480;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import tfu.Lz409;
import rs2.shared.movement.M188;
import tfu.Bs1;
import tfu.Be2;
import tfu.Gz143;
import tfu.Gg3;
import tfu.El328;
import tfu.Eu326;
import tfu.Gm479;
import com.jagex.core.constants.D123;
import tfu.Jp534;
import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.E254;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Gd27;
import com.jagex.maths.RotTrans;
import tfu.Hk84;
import rs2.shared.lua.G284;
import org.slf4j.Logger;
import tfu.Hi86;
import java.awt.Component;
import tfu.Bu350;
import rs2.client.friends.ClientFriendListComponent;
import tfu.Ef450;
import tfu.Dr574;
import java.util.Calendar;
import tfu.Hf380;
import tfu.Fw152;
import com.jagex.game.runetek6.config.vartype.SparseVarDomain;
import tfu.Fg140;
import tfu.Ha262;
import java.awt.datatransfer.Clipboard;
import java.util.Random;
import tfu.Hd425;
import tfu.Hb335;
import tfu.Ll42;
import tfu.Ms517;
import tfu.Bv351;
import tfu.D285;
import com.jagex.game.runetek6.config.defaults.GraphicsDefaults;
import com.jagex.game.runetek6.config.invtype.InvTypeList;
import java.util.Map;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import tfu.Go485;
import com.jagex.game.runetek6.config.vartype.general.VarBasicTypeListClient;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import tfu.Eq28;
import tfu.Ab158;
import tfu.Aw157;
import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import tfu.Df147;
import tfu.Hl134;
import com.jagex.js5.S136;
import com.jagex.game.runetek6.comms.statestream.packetchannel.NumberingPacketChannel;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamStatistics;
import com.jagex.js5.G137;
import rs2.shared.movement.Q40;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.js5.W144;
import com.jagex.js5.L145;
import com.jagex.game.runetek6.comms.statestream.packetchannel.DelayableUDPPacketChannel;
import com.jagex.game.runetek6.comms.statestream.packetchannel.UDPPacketChannelClient;
import rs2.shared.movement.I187;
import com.jagex.js5.js5;
import java.util.ArrayDeque;
import java.nio.ByteBuffer;
import com.jagex.game.runetek6.script.ScriptManager;
import java.net.Socket;
import tfu.Hx339;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import com.jagex.maths.N319;
import com.jagex.maths.Vector3;
import com.jagex.maths.H303;
import com.jagex.jnibindings.runetek6.RuntimeTool.F511;
import com.jagex.maths.Matrix4;
import rs2.client.login.H577;
import tfu.Fr156;
import rs2.client.login.R273;
import java.awt.Color;
import tfu.Kv538;
import com.jagex.game.runetek6.client.GameShell3;

@Kv538(true)
public class client extends GameShell3
{
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
    private B402 cq;
    static final /* synthetic */ boolean nm;
    
    @Be2
    @Bs1
    public static void nativeMouseInputMove(int cg, int ct) {
        if (client.fx.s != null) {
            if (cg < -1) {
                cg = -1;
            }
            else if (cg > 65534) {
                cg = 65534;
            }
            if (ct < -1) {
                ct = -1;
            }
            else if (ct > 65534) {
                ct = 65534;
            }
            if (client.cg != cg || client.ct != ct) {
                final El328 d = El328.d(Eu326.EVENT_MOUSE_MOVE, client.fx.s);
                Gg3.k(d.q, 0);
                final int v = d.q.v;
                int n = cg - client.cg;
                client.cg = cg;
                int n2 = ct - client.ct;
                client.ct = ct;
                final int n3 = (int)((Gz143.g() - client.cm) / 20L);
                if (n3 < 8 && n >= -32 && n <= 31 && n2 >= -32 && n2 <= 31) {
                    n += 32;
                    n2 += 32;
                    Gg3.i(d.q, (n3 << 12) + (n << 6) + n2);
                }
                else if (n3 < 32 && n >= -128 && n <= 127 && n2 >= -128 && n2 <= 127) {
                    n += 128;
                    n2 += 128;
                    Gg3.k(d.q, 128 + n3);
                    Gg3.i(d.q, (n << 8) + n2);
                }
                else if (n3 < 32) {
                    Gg3.k(d.q, 192 + n3);
                    if (cg == 1 || ct == -1) {
                        Gg3.a(d.q, Integer.MIN_VALUE);
                    }
                    else {
                        Gg3.a(d.q, cg | ct << 16);
                    }
                }
                else {
                    Gg3.i(d.q, 57344 + n3);
                    if (cg == 1 || ct == -1) {
                        Gg3.a(d.q, Integer.MIN_VALUE);
                    }
                    else {
                        Gg3.a(d.q, cg | ct << 16);
                    }
                }
                client.cm = Gz143.g();
                Gg3.ac(d.q, d.q.v - v);
                N272.e(client.fx, d);
            }
        }
    }
    
    public static final native void nativeSetFocus();
    
    public static void by() {
        if (client.ac != 11) {
            return;
        }
        if (client.ac == 3) {
            z(4);
        }
        else if (client.ac == 11) {
            z(12);
        }
    }
    
    @Be2
    public static void main(final String[] array) {
        if (array.length != 6 && array.length != 7) {
            j("Argument count");
        }
        client.logger.debug("start");
        q(array, new client());
    }
    
    static void bb() {
        bt();
        client.la = true;
        M188.w();
        client.cj.event.triggerEvent("__onMapFullyBuilt", null);
        Lz409.b = 0;
        Lz409.l = 0;
        if (F511.j(client.at) && !F511.e(client.at)) {
            F511.q(client.at);
            Z132.q("MapBuildState_" + F511.h(client.at));
        }
    }
    
    private static final void j(final String str) {
        client.logger.error("Bad " + str + ", Usage: worldid, lobbyid, demoworldid, <live/rc/wip>, <english/german>, <game0/game1>, <loading bar config>");
        System.exit(1);
    }
    
    public static final void ac() {
        client.fa.cacheReset();
        client.fl.cacheReset();
        client.fd.cacheReset();
        client.fi.cacheReset();
        client.fn.cacheReset();
        client.fm.cacheReset();
        client.fs.cacheReset();
        client.fh.cacheReset();
        client.en.cacheReset();
        Aw157.b(client.eq);
        js5.m(client.dr);
        js5.m(client.dy);
        js5.m(client.dg);
        js5.m(client.er);
        js5.m(client.ez);
        js5.m(client.et);
        js5.m(client.eu);
        js5.m(client.ey);
        js5.m(client.ea);
        js5.m(client.em);
        js5.m(client.eh);
        js5.m(client.es);
        js5.m(client.ec);
        js5.m(client.ei);
        js5.m(client.ef);
        js5.m(client.ek);
        js5.m(client.eb);
        js5.m(client.ee);
        Eq28.s(client.ex);
    }
    
    @Override
    public final void maininit() {
        js5.i = false;
        Hi86.q(client.lh);
        Gl480.d = true;
        final Frame frame = new Frame(" ");
        frame.pack();
        frame.dispose();
        client.dj = new L145();
        client.dm = new W144();
        Mv477.g(new int[] { 20, 260 }, new int[] { 1000, 100 });
        I48.g(4096);
        O166.g(4096);
        Ag566.g(128);
        CommonStateAndEventTypes.Init(false);
        if (client.t == D123.INTBETA || client.t == D123.LIVE) {
            Lf336.j.d = this.getCodeBase().getHost();
        }
        else if (client.af != null) {
            Lf336.j.d = client.af;
            Lf336.j.g = client.av;
            Lf336.j.q = 40000 + Lf336.j.g;
            Lf336.j.j = 50000 + Lf336.j.g;
        }
        else if (D123.d(client.t, G320.OFFICE)) {
            Lf336.j.d = this.getCodeBase().getHost();
            Lf336.j.q = 40000 + Lf336.j.g;
            Lf336.j.j = 50000 + Lf336.j.g;
        }
        else if (client.t == D123.LOCAL) {
            Lf336.j.q = 40000 + Lf336.j.g;
            Lf336.j.j = 50000 + Lf336.j.g;
        }
        Lf336.q = Lf336.j;
        try {
            Al161.d(InetAddress.getByName(Lf336.q.d));
        }
        catch (UnknownHostException ex) {}
        if (client.m == Gd27.RUNESCAPE) {
            client.ba = false;
        }
        client.hi = (ObjType.clientpalette = new short[256]);
        try {
            client.jc = this.getToolkit().getSystemClipboard();
        }
        catch (Exception ex2) {}
        if (client.t != D123.LIVE) {
            client.bx = true;
        }
        GameShell3.setPhysicsSpeed((float)Lq191.g());
        GameShell3.loadingTitle = Mk163.g(Mk163.LOADING, client.n);
        Bz650.g(!D123.d(client.t, G320.HAS_EXTERNAL_ACCESS));
        Bz650.d((Bc288[])Ed472.values());
        Bz650.q((Bc288[])Ej287.values());
        GameEntity.bf = Ba115.d(Ej287.CLIENT_SCRIPTED);
        GameEntity.bn = Ba115.d(Ej287.CLIENT_ATTACHMENT);
        client.ai = System.getProperty("jagex.packcontentpath");
        if (client.ai != null && !new File(client.ai).isDirectory()) {
            client.ai = null;
            throw new RuntimeException("Invalid Pack Content Path : " + client.ai);
        }
        client.al = System.getProperty("jagex.srccontentpath");
        if (client.al != null && !new File(client.al).isDirectory()) {
            client.al = null;
            throw new RuntimeException("Invalid Source Content Path : " + client.al);
        }
        Y192.g(true);
    }
    
    @Override
    public final void mainphysics() {
        Lb33.g(Lb33.UDP);
        try {
            Lb33.g(Lb33.ProcessIncoming);
            try {
                client.dq.processIncomingPackets();
            }
            finally {
                Lb33.d(Lb33.ProcessIncoming);
            }
            Lb33.g(Lb33.SendOutgoing);
            try {
                client.dq.sendOutgoingPackets();
            }
            finally {
                Lb33.d(Lb33.SendOutgoing);
            }
        }
        catch (Exception ex) {
            client.logger.error("Exception servicing state stream synchronizer", ex);
            at();
        }
        finally {
            Lb33.d(Lb33.UDP);
        }
        if (client.gb != null && !D285.j(client.gb)) {
            return;
        }
        if (client.kx) {
            e();
        }
        if (client.gk && M188.s() < 1.0f) {
            ad();
        }
    }
    
    private static void e() {
        final float n = 0.25f;
        int ln = client.ln;
        if (System.nanoTime() - client.ll > 2.0f * Lq191.d() * 1.0E9f) {
            ln = 0;
        }
        float physicsSpeed = client.kn - ln / n;
        final int g = Lq191.g();
        if (physicsSpeed < g / 2.0f) {
            physicsSpeed = g / 2.0f;
        }
        if (physicsSpeed > g * 2.0f) {
            physicsSpeed = g * 2.0f;
        }
        GameShell3.setPhysicsSpeed(physicsSpeed);
    }
    
    @Override
    public void cycleend(final boolean b) {
        Lv148.d(b);
    }
    
    @Override
    public void mainloop(final float n) {
        this.s(n);
    }
    
    private void h(final float n) {
        if (!client.e) {
            return;
        }
        if (client.s == 0L) {
            client.s = Kc180.g(client.b);
            if (client.s == 0L) {
                client.logger.error("pNativeBuffer == null");
            }
            else {
                client.logger.debug("allocated " + client.b + " bytes for pNativeBuffer");
            }
        }
        if (client.s != 0L) {
            final player j = Gc330.j();
            final ScriptCamera activeCamera = ScriptCamera.getActiveCamera();
            ScaleRotTrans scaleRotTrans = ScaleRotTrans.g;
            if (j != null) {
                scaleRotTrans = j.getWorldTransform();
            }
            ScaleRotTrans scaleRotTrans2 = ScaleRotTrans.g;
            Matrix4 matrix4 = Matrix4.g;
            if (activeCamera != null) {
                scaleRotTrans2 = activeCamera.getWorldTransform();
                matrix4 = activeCamera.getProjMatrix();
            }
            final long s = client.s;
            Kc180.b(s, (byte)H149.e);
            final long n2 = s + 1L;
            Kc180.s(n2, H149.h);
            final long n3 = n2 + H149.d;
            Kc180.v(n3, scaleRotTrans.scale);
            final long n4 = n3 + 4L;
            Kc180.v(n4, scaleRotTrans2.rot.x);
            final long n5 = n4 + 4L;
            Kc180.v(n5, scaleRotTrans2.rot.y);
            final long n6 = n5 + 4L;
            Kc180.v(n6, scaleRotTrans2.rot.z);
            final long n7 = n6 + 4L;
            Kc180.v(n7, scaleRotTrans2.rot.w);
            final long n8 = n7 + 4L;
            Kc180.v(n8, scaleRotTrans2.trans.x);
            final long n9 = n8 + 4L;
            Kc180.v(n9, scaleRotTrans2.trans.y);
            final long n10 = n9 + 4L;
            Kc180.v(n10, scaleRotTrans2.trans.z);
            final long n11 = n10 + 4L;
            Kc180.v(n11, matrix4.f00);
            final long n12 = n11 + 4L;
            Kc180.v(n12, matrix4.f01);
            final long n13 = n12 + 4L;
            Kc180.v(n13, matrix4.f02);
            final long n14 = n13 + 4L;
            Kc180.v(n14, matrix4.f03);
            final long n15 = n14 + 4L;
            Kc180.v(n15, matrix4.f10);
            final long n16 = n15 + 4L;
            Kc180.v(n16, matrix4.f11);
            final long n17 = n16 + 4L;
            Kc180.v(n17, matrix4.f12);
            final long n18 = n17 + 4L;
            Kc180.v(n18, matrix4.f13);
            final long n19 = n18 + 4L;
            Kc180.v(n19, matrix4.f20);
            final long n20 = n19 + 4L;
            Kc180.v(n20, matrix4.f21);
            final long n21 = n20 + 4L;
            Kc180.v(n21, matrix4.f22);
            final long n22 = n21 + 4L;
            Kc180.v(n22, matrix4.f23);
            final long n23 = n22 + 4L;
            Kc180.v(n23, matrix4.f30);
            final long n24 = n23 + 4L;
            Kc180.v(n24, matrix4.f31);
            final long n25 = n24 + 4L;
            Kc180.v(n25, matrix4.f32);
            final long n26 = n25 + 4L;
            Kc180.v(n26, matrix4.f33);
            final long n27 = n26 + 4L;
            long g = 0L;
            if (client.gz != null && client.gz.d != null && client.gz.d.d != null) {
                g = DiscreteDynamicsWorld.g(client.gz.d.d);
            }
            Kc180.s(n27, g);
            final long n28 = n27 + Kc180.e();
            int n29 = -1;
            RotTrans rotTrans = RotTrans.g;
            RotTrans rotTrans2 = RotTrans.g;
            if (j != null) {
                final RotTrans rotTrans3 = rotTrans2 = (rotTrans = j.getWorldTransform().q());
                final PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(j, PlayerPhysicsComponent.class);
                if (playerPhysicsComponent != null) {
                    final Integer m = PlayerPhysicsComponent.m(playerPhysicsComponent, false);
                    if (m != null) {
                        final PlayerAvatarDescriptor g2 = PlayerAvatarDescriptor.g(m);
                        if (g2 != null) {
                            final Vector3 al = Vector3.al(Vector3.q, rotTrans3.rot);
                            rotTrans = rotTrans3.r(al, PlayerAvatarDescriptor.h(g2) * 0.9f);
                            rotTrans2 = PlayerAvatarDescriptor.l(g2, rotTrans2.s(Gh19.g).r(al, PlayerAvatarDescriptor.h(g2) * 0.5f));
                        }
                    }
                    final PlayerPhysicsAvatar avatar = playerPhysicsComponent.getAvatar(false);
                    if (avatar != null) {
                        final CollisionObject e = avatar.e;
                        if (e != null) {
                            n29 = (int)e.s;
                        }
                    }
                }
            }
            Kc180.r(n28, n29);
            final long n30 = n28 + 4L;
            Kc180.r(n30, Gn5.CAMERA_COLLIDE.ordinal());
            final long n31 = n30 + 4L;
            Kc180.r(n31, Gn5.CAMERA_SIGHT.ordinal());
            final long n32 = n31 + 4L;
            Kc180.v(n32, rotTrans.trans.x);
            final long n33 = n32 + 4L;
            Kc180.v(n33, rotTrans.trans.y);
            final long n34 = n33 + 4L;
            Kc180.v(n34, rotTrans.trans.z);
            final long n35 = n34 + 4L;
            Kc180.v(n35, rotTrans2.rot.x);
            final long n36 = n35 + 4L;
            Kc180.v(n36, rotTrans2.rot.y);
            final long n37 = n36 + 4L;
            Kc180.v(n37, rotTrans2.rot.z);
            final long n38 = n37 + 4L;
            Kc180.v(n38, rotTrans2.rot.w);
            final long n39 = n38 + 4L;
            Kc180.v(n39, rotTrans2.trans.x);
            final long n40 = n39 + 4L;
            Kc180.v(n40, rotTrans2.trans.y);
            final long n41 = n40 + 4L;
            Kc180.v(n41, rotTrans2.trans.z);
            final long n42 = n41 + 4L;
            if (n42 > client.s + client.b) {
                throw new Error("Buffer overrun - wrote " + (n42 - client.s) + " bytes, only had room for " + client.b + " - bailing out!");
            }
            nativeUpdateGameplayStates(client.s, client.b, n);
            final long s2 = client.s;
            final float u = Kc180.u(s2);
            final long n43 = s2 + 4L;
            final float u2 = Kc180.u(n43);
            final long n44 = n43 + 4L;
            final float u3 = Kc180.u(n44);
            final long n45 = n44 + 4L;
            final float u4 = Kc180.u(n45);
            final long n46 = n45 + 4L;
            final float u5 = Kc180.u(n46);
            final long n47 = n46 + 4L;
            final float u6 = Kc180.u(n47);
            final long n48 = n47 + 4L;
            final float u7 = Kc180.u(n48);
            final long n49 = n48 + 4L;
            final float u8 = Kc180.u(n49);
            final long n50 = n49 + 4L;
            final float u9 = Kc180.u(n50);
            final long n51 = n50 + 4L;
            final float u10 = Kc180.u(n51);
            final long n52 = n51 + 4L;
            final float u11 = Kc180.u(n52);
            final long n53 = n52 + 4L;
            final float u12 = Kc180.u(n53);
            final long n54 = n53 + 4L;
            client.bm = new Matrix4(u, u2, u3, 0.0f, u4, u5, u6, 0.0f, u7, u8, u9, 0.0f, u10, u11, u12, 1.0f);
            client.bq = new Vector3(u10, u11, u12);
            client.bo = client.bm.j();
            client.bl = client.bo.g(matrix4);
            client.bw = Kc180.u(n54);
            final long n55 = n54 + 4L;
            if (n55 > client.s + client.b) {
                throw new Error("Buffer overrun - read " + (n55 - client.s) + " bytes, only had room for " + client.b + " - bailing out!");
            }
        }
    }
    
    public static final void ak() {
        ScriptCamera.br();
        Ll42.g(client.gz);
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
            if (client.ac == 16) {
                return;
            }
            final long ad = System.nanoTime() / 1000000L;
            long n = ad - client.ad;
            if (client.ad == 0L) {
                n = 20L;
            }
            client.ad = ad;
            Lb33.g(Lb33.zAudioRender);
            try {
                b(this);
            }
            finally {
                Lb33.d(Lb33.zAudioRender);
            }
            Lb33.g(Lb33.zTweening);
            try {
                if (client.mm != null && client.gb != null && D285.j(client.gb)) {
                    M188.h(n * 0.001f);
                    if (client.gk) {
                        while (M188.s() < 0.0f) {
                            ad();
                        }
                    }
                    final Iterator<ScheduledMovementComponent> iterator = (Iterator<ScheduledMovementComponent>)client.mm.x(ScheduledMovementComponent.class).iterator();
                    while (iterator.hasNext()) {
                        iterator.next().w(n * 0.001f);
                    }
                    final Iterator<PlayerPhysicsComponent> iterator2 = (Iterator<PlayerPhysicsComponent>)client.mm.x(PlayerPhysicsComponent.class).iterator();
                    while (iterator2.hasNext()) {
                        iterator2.next().z();
                    }
                }
            }
            finally {
                Lb33.d(Lb33.zTweening);
            }
            Lb33.g(Lb33.UpdateGameplayStates);
            try {
                if (!r(client.ac) && !y(client.ac)) {
                    H149.q(client.cj.getLuaStateNativeRef(), n * 0.001f);
                }
                this.h(n * 0.001f);
                if (!r(client.ac) && !y(client.ac)) {
                    H149.j(client.cj.getLuaStateNativeRef(), n * 0.001f);
                }
            }
            finally {
                Lb33.d(Lb33.UpdateGameplayStates);
            }
            Lb33.g(Lb33.zGamedrawmain);
            try {
                if (client.ac == 11) {
                    bo(0, 0, GameShell3.canvasWid, GameShell3.canvasHei);
                }
                if (GameShell3.fsframe == null) {
                    final Container topContainer = this.getTopContainer();
                    int width = topContainer.getSize().width;
                    int height = topContainer.getSize().height;
                    if (topContainer == GameShell3.frame) {
                        final Insets insets = GameShell3.frame.getInsets();
                        width -= insets.left + insets.right;
                        height -= insets.top + insets.bottom;
                    }
                    if (width != GameShell3.frameWid || height != GameShell3.frameHei) {
                        GameShell3.frameWid = width;
                        GameShell3.frameHei = height;
                        client.ir = Gz143.g() + 500L;
                        client.bt = false;
                        aq();
                    }
                }
                if (Hq338.g && GameShell3.fsframe != null && v(client.ac)) {
                    f(W159.g().j, -1, -1, false);
                }
                B665.q(B665.g());
                boolean b = false;
                if (GameShell3.fullredraw) {
                    GameShell3.fullredraw = false;
                    b = true;
                }
                if (client.e && GameShell3.focus && !client.bh) {
                    nativeSetFocus();
                }
                client.bh = GameShell3.focus;
                if (b) {
                    al();
                }
                if (r(client.ac)) {
                    if (this.cq == null) {
                        (this.cq = new B402()).d(GameShell3.canvas, Load.w(), GameShell3.canvasWid, GameShell3.canvasHei, this.cc(this.cq.g()));
                    }
                    else {
                        B402.j(this.cq, GameShell3.canvas, Load.w(), GameShell3.canvasWid, GameShell3.canvasHei);
                    }
                }
                else {
                    if (this.cq != null) {
                        B402.q(this.cq);
                        this.cq = null;
                    }
                    if (x(client.ac)) {
                        bm();
                    }
                    else if (client.ac == 11) {
                        bq(n);
                    }
                }
            }
            finally {
                Lb33.d(Lb33.zGamedrawmain);
            }
            Lb33.g(Lb33.zNavPower);
            try {
                if (client.ni.g != null) {
                    for (int i = 0; i < Jh522.g(client.ni.g); ++i) {
                        final byte[] q = Jh522.q(client.ni.g, i);
                        if (q.length > 0) {
                            if (client.nc == null || client.nc.capacity() < q.length) {
                                client.nc = ByteBuffer.allocateDirect(q.length);
                            }
                            client.nc.position(0);
                            client.nc.put(q);
                            NavPowerClient.renderFromRenderData(client.nc, q.length, (float)(-client.gn), (float)(-client.gj));
                        }
                    }
                }
            }
            finally {
                Lb33.d(Lb33.zNavPower);
            }
            Lb33.g(Lb33.zNativeRender);
            try {
                if (debugconsole.isopen()) {
                    debugconsole.w();
                }
                client.ac;
                client.ac;
                if (client.dp) {
                    bl(20, 20);
                }
                final ScriptCamera activeCamera = ScriptCamera.getActiveCamera();
                float j = 0.0f;
                float o = 0.0f;
                float c = 0.0f;
                float a = 0.0f;
                float ag = 0.0f;
                float f = 0.0f;
                if (activeCamera != null) {
                    j = activeCamera.i;
                    o = activeCamera.o;
                    c = activeCamera.c;
                    a = activeCamera.a;
                    ag = activeCamera.ag;
                    f = activeCamera.f;
                }
                final player k = Gc330.j();
                final ArrayList list = new ArrayList();
                if (k != null) {
                    w(list, k);
                }
                H149.e(client.ax, client.ar, (client.mg != null) ? client.mg.d : null, n * 0.001f, j, o, c, a, ag, f, list, l());
                if (client.bg) {
                    am();
                }
            }
            finally {
                Lb33.d(Lb33.zNativeRender);
            }
        }
        finally {
            Lb33.d(Lb33.MainRedraw);
        }
    }
    
    private static Collection l() {
        if (client.gz.d == null) {
            return null;
        }
        final GameEntity[] entitiesInSphere = client.gz.d.getEntitiesInSphere(client.bq, client.bw, Gn5.PLAYER_OR_NPC_VOLUME_QUERY.ordinal(), Gj16.NONE.az, 128);
        final ArrayList list = new ArrayList();
        final player j = Gc330.j();
        for (final GameEntity gameEntity : entitiesInSphere) {
            if (gameEntity != j && (GameEntity.ee(gameEntity, PlayerComponent.class) || GameEntity.ee(gameEntity, NpcComponent.class))) {
                w(list, gameEntity);
            }
        }
        return list;
    }
    
    static {
        nm = !client.class.desiredAssertionStatus();
        logger = LoggerFactory.getLogger(client.class);
        client.d = 0.0;
        client.q = 0;
        client.j = 0;
        client.e = false;
        client.s = 0L;
        client.b = 200;
        l = new Bu350(3, "Client utilPool");
        client.w = false;
        p = new char[200];
        client.u = 0;
        client.m = null;
        client.k = false;
        client.i = false;
        client.o = "";
        client.f = 0;
        ag = new Color(128, 0, 0);
        aq = new Color(80, 80, 80);
        client.af = null;
        client.av = 0;
        client.az = false;
        client.ap = new H577();
        client.ao = false;
        client.aa = false;
        client.an = false;
        client.am = false;
        client.as = 0;
        client.ac = 0;
        client.at = new F511();
        client.ab = new String[] { "Loading", "Loading 2", "Loading 3", "Login screen", "Login screen (Map build)", "Logging in from loginscreen to lobby", "Logging in from loginscreen to game", "Lobby screen", "Lobby screen (Map build)", "Logging in from lobbyscreen to game", "Logging in from lobbyscreen to game (Map build)", "Game screen", "Game screen (Map build)", "Logging in from gamescreen to lobby", "Reconnecting", "Switch World", "Error" };
        client.aw = 1;
        client.ar = Matrix4.g;
        client.ax = new H303();
        client.au = new H303();
        client.ad = 0L;
        client.ae = true;
        client.bd = null;
        client.bm = Matrix4.g;
        client.bq = Vector3.g;
        client.bo = Matrix4.g;
        client.bl = Matrix4.g;
        client.bj = 0;
        client.bk = true;
        client.bh = false;
        client.bp = true;
        client.bx = false;
        client.by = false;
        client.bv = 0;
        client.bg = false;
        client.bb = false;
        client.ba = true;
        client.bi = (long)(Math.random() * 9.999999999E9);
        client.bt = false;
        client.bz = 0;
        client.bc = false;
        client.cw = true;
        client.cp = 0;
        client.cd = 0;
        client.ck = new ArrayList();
        client.ce = new ArrayList();
        client.ca = new IdentityHashMap();
        client.cv = new ArrayDeque();
        client.cl = false;
        client.cb = -1L;
        client.cm = -1L;
        client.cg = -1;
        client.ct = -1;
        client.cc = -1L;
        client.cx = new Color[] { new Color(9179409), new Color(3289650), new Color(3289650), new Color(3289650) };
        client.cy = new Color[] { new Color(9179409), new Color(16777215), new Color(16726277), new Color(16726277) };
        client.co = new Color[] { new Color(16777215), new Color(16777215), new Color(16741381), new Color(16741381) };
        client.cr = null;
        client.cu = false;
        client.cz = false;
        client.cn = false;
        client.cs = false;
        client.cf = false;
        client.dn = false;
        client.dp = false;
        client.dv = null;
        client.df = 0;
        client.do_ = false;
        client.de = null;
        client.dh = null;
        client.dw = null;
        dq = new LossyStateStreamSynchronizer();
        client.du = false;
        client.dl = false;
        dc = new G408();
        ds = new C414();
        client.dk = 0;
        client.di = 0.0f;
        client.dx = new S136[Js5Archive.getRequiredArrayLength()];
        client.eo = null;
        client.ev = 0;
        client.ex = new Eq28(8);
        client.ed = null;
        ew = new Af666();
        client.fb = 0;
        client.fk = Go485.NONE;
        client.fj = 0;
        client.fg = 0;
        client.fw = false;
        client.ft = new HashMap();
        fx = new N272();
        client.fe = 0;
        client.ff = false;
        client.gq = -1.0f;
        client.gp = 104;
        client.gy = 104;
        client.gh = 1.0f;
        client.gf = new Bv351();
        client.gc = false;
        gt = new int[] { 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };
        client.gz = new Ll42();
        client.gk = false;
        client.gs = new int[4096];
        client.gg = new int[4096];
        client.gl = new int[50];
        client.go = new int[50];
        ge = new int[] { -1, 8192, 0, -1, 12288, 10240, 14336, -1, 4096, 6144, 2048 };
        client.gw = 0;
        client.gm = 2;
        client.gx = 0;
        client.gr = 2;
        client.hn = 0;
        client.hb = 1;
        client.hr = 0;
        client.hj = 0;
        client.hx = 2;
        client.ho = 0;
        client.ht = 1;
        client.hu = 0;
        client.hl = new Random();
        client.hf = 0;
        client.hq = 5000;
        client.hw = 0.0f;
        client.hd = 0;
        client.hv = 0;
        client.he = new Hb335();
        client.hz = 0;
        client.hs = new float[3];
        client.hk = 0;
        client.hh = 0;
        client.hc = 0;
        client.hp = 0;
        client.hm = 0;
        client.ir = 0L;
        client.id = true;
        client.ii = 765;
        client.iq = 503;
        client.ib = 32;
        client.ij = 16;
        client.ip = false;
        client.il = false;
        client.ik = 0;
        client.in = 0;
        client.ic = false;
        client.iw = false;
        client.ig = false;
        client.if_ = false;
        client.iu = true;
        client.io = false;
        client.jb = new Hb335();
        client.ja = -1;
        client.jj = -1;
        client.ji = new Ha262(8);
        client.jx = 0;
        jk = new int[] { 16776960, 16711680, 65280, 65535, 16711935, 16777215 };
        client.je = 0;
        client.jn = 0;
        client.jh = new long[100];
        client.jp = 0;
        client.ju = null;
        client.jv = null;
        client.kf = null;
        client.ki = 0;
        client.kl = 0;
        client.ke = 0;
        client.ks = 0;
        client.kt = 0;
        client.ku = new ClientFriendListComponent();
        client.kb = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        client.ka = false;
        client.kx = true;
        client.kn = (float)Lq191.g();
        client.kc = 0.0;
        client.kp = 99999.0;
        client.kq = 0.0;
        client.ky = 0.0;
        client.ld = 0.0;
        client.lo = 0.0;
        client.ln = 0;
        client.ll = 0L;
        client.lz = RotTrans.g;
        lh = new Hi86(Integer.class);
        lw = new Hk84();
        client.lj = 0L;
        client.la = false;
        client.lv = false;
        client.lt = -1.0f;
        client.lb = -1.0f;
        client.lm = false;
        client.lq = new G284();
        client.ls = new G284();
        client.lx = true;
        client.lf = true;
        client.lr = true;
        client.lp = true;
        client.lc = false;
        client.lk = true;
        client.le = 0;
        client.li = new float[200];
        client.ly = new int[200];
        client.md = new float[200];
        client.me = new int[200];
        client.mj = new float[200];
        client.mw = 0;
        client.ms = true;
        mf = new int[] { 0, 1, 1, 5, 5, 4, 4, 0, 2, 6, 6, 7, 7, 3, 3, 2, 0, 2, 4, 6, 5, 7, 1, 3 };
        client.mz = new float[4];
        client.mk = new float[4];
        client.mq = new float[4];
        client.mi = new float[8];
        client.mv = new float[8];
        client.mx = new float[8];
        client.mp = 0;
        client.ml = 0;
        client.mc = true;
        mo = new int[4];
        client.ni = new Jp534();
        client.ng = 0L;
        client.nw = 0;
        client.nh = null;
    }
    
    public static final void q(final String[] array, final client bu) {
        try {
            System.setErr(System.out);
            Lf336.j = new Lx337();
            try {
                Lf336.j.g = Integer.parseInt(array[0]);
                Lf336.j.d = A412.b;
            }
            catch (NumberFormatException ex2) {
                final String[] y = StringTools.y(array[0], ':');
                if (y.length != 2) {
                    throw new Exception("Invalid server address - should be of the form host-name:node-id");
                }
                Lf336.d = y[0];
                Lf336.j.g = Integer.parseInt(y[1]);
                Lf336.j.d = Lf336.d;
            }
            client.t = D123.LOCAL;
            if (array[3].equals("live")) {
                client.z = Gm479.LIVE;
            }
            if (array[3].equals("buildlive")) {
                client.z = Gm479.BUILDLIVE;
            }
            else if (array[3].equals("rc")) {
                client.z = Gm479.RC;
            }
            else if (array[3].equals("wip")) {
                client.z = Gm479.WIP;
            }
            else {
                j("modewhat");
            }
            client.n = Language.q(array[4]);
            if (client.n == null) {
                if (array[4].equals("english")) {
                    client.n = Language.EN;
                }
                else if (array[4].equals("german")) {
                    client.n = Language.DE;
                }
                else {
                    j("language");
                }
            }
            client.k = false;
            if (array[5].equals("game0")) {
                client.m = Gd27.RUNESCAPE;
            }
            else if (array[5].equals("game1")) {
                client.m = Gd27.STELLARDAWN;
            }
            else if (array[5].equals("game2")) {
                client.m = Gd27.ALTERNATEREALITY;
            }
            else if (array[5].equals("game3")) {
                client.m = Gd27.TRANSFORMERS;
            }
            else if (array[5].equals("game4")) {
                client.m = Gd27.SCRATCH;
            }
            else {
                j("game");
            }
            client.ip = (client.az = true);
            System.loadLibrary("jawt");
            boolean boolean1 = false;
            if (System.getProperty("jagex.useCache") != null) {
                boolean1 = Boolean.parseBoolean(System.getProperty("jagex.useCache"));
            }
            (client.bu = bu).startApplication(1280, 720, client.m.h, client.z.h, 32 + client.z.s, Js5Archive.getRequiredArrayLength(), boolean1, 1, 1);
            GameShell3.frame.setLocation(40, 40);
        }
        catch (Exception ex) {
            Ku323.g(null, ex);
        }
    }
    
    public static boolean v(final int n) {
        return n == 3 || n == 11;
    }
    
    public static boolean y(final int n) {
        return n == 4 || n == 12;
    }
    
    public static boolean p(final int n) {
        return n == 3 || n == 4 || n == 6;
    }
    
    public static void z(final int ac) {
        if (client.ac == ac) {
            return;
        }
        client.ac = ac;
        Object o = null;
        switch (ac) {
            case 3: {
                o = "loginscreen";
                break;
            }
            case 4: {
                o = "buildingmap";
                break;
            }
            case 6: {
                o = "login";
                break;
            }
            case 11: {
                o = "game";
                break;
            }
            case 12: {
                o = "buildmap";
                break;
            }
            case 14: {
                o = "reconnect";
                break;
            }
            case 15: {
                o = "switchworld";
                break;
            }
            case 16: {
                o = "error";
                break;
            }
        }
        client.cj.event.triggerEvent("__onLoadState", o);
        client.logger.debug("Mainstate: {} {}", client.ab[ac], Gz143.g());
        if (ac == 14) {
            Login.q();
        }
        if (ac == 15) {
            Login.d();
        }
        if (ac == 13) {
            Login.g();
        }
        if (ac != 14 && client.fr != null) {
            client.fr.h();
            client.fr = null;
        }
        if (ac == 3) {
            k();
        }
        if (y(client.ac)) {
            client.dr.m = 2;
            client.et.m = 2;
            if (F511.e(client.at)) {
                F511.g(client.at);
            }
            if (!F511.j(client.at)) {
                F511.d(client.at);
                Z132.g("MapBuildState_" + F511.h(client.at));
            }
        }
        if (y(ac)) {
            client.dr.m = 1;
            client.et.m = 1;
        }
        if (ac == 12 || ac == 3) {
            G405.d(client.bu, GameShell3.getEnvironment());
        }
    }
    
    public static void t(final client client, final float n) {
        Lb33.g(Lb33.NetClient);
        try {
            if (!client.dm.s()) {
                client.m(n);
            }
        }
        finally {
            Lb33.d(Lb33.NetClient);
        }
    }
    
    public void m(final float n) {
        if (client.dm.u > client.ev) {
            client.logger.debug("Js5connect error: {}", client.dm.z);
            Lx337.q(Lf336.q);
            client.di = (client.dm.u - 1) * 5.0f;
            if (client.di > 60.0f) {
                client.di = 60.0f;
            }
            if (client.dm.u >= 2 && client.dm.z == Mf509.CLIENT_OUT_OF_DATE.getId()) {
                this.error("js5connect_outofdate");
                z(16);
                return;
            }
            if (client.dm.u >= 4 && client.dm.z == -1) {
                this.error("js5crc");
                z(16);
                return;
            }
            if (client.dm.u >= 4 && r(client.ac)) {
                if (client.dm.z == Mf509.SERVER_FULL.getId() || client.dm.z == Mf509.IP_LIMIT.getId()) {
                    this.error("js5connect_full");
                }
                else if (client.dm.z > 0) {
                    if (client.ed == null) {
                        this.error("js5connect");
                    }
                    else {
                        this.error("js5proxy_" + client.ed.trim());
                    }
                }
                else {
                    this.error("js5io");
                }
                z(16);
                return;
            }
        }
        client.ev = client.dm.u;
        if (client.di > 0.0f) {
            client.di -= n;
            return;
        }
        try {
            if (client.dk == 0) {
                client.logger.trace("Attempting js5remote connection on port: {}", Lx337.d(Lf336.q));
                client.ci = Lf336.q.g();
                ++client.dk;
            }
            if (client.dk == 1) {
                client.ch = Hx339.g(client.ci, 25000);
                final Gg3 gg3 = new Gg3(9);
                Gg3.k(gg3, Ex582.INIT_JS5REMOTE_CONNECTION.w);
                Gg3.a(gg3, 1);
                Gg3.a(gg3, 1);
                client.ch.e(gg3.r, 0, 9);
                ++client.dk;
                client.da = Gz143.g();
            }
            if (client.dk == 2) {
                if (client.ch.d(1)) {
                    final byte[] array = { 0 };
                    final int j = client.ch.j(array, 0, 1);
                    if (array[0] != 0) {
                        n(this, j);
                        return;
                    }
                    client.logger.trace("Js5connect ok: {}", j);
                    ++client.dk;
                }
                else if (Gz143.g() - client.da > 30000L) {
                    n(this, 1001);
                    return;
                }
            }
            if (client.dk == 3) {
                final Ja527[] values = Ja527.values();
                final int n2 = values.length * 4;
                if (client.ch.d(n2)) {
                    final Gg3 gg4 = new Gg3(n2);
                    client.ch.j(gg4.r, 0, gg4.r.length);
                    for (int i = 0; i < values.length; ++i) {
                        Ja527.d(values[i], Gg3.bd(gg4));
                    }
                    W144.b(client.dm, client.ch, !r(client.ac) && !p(client.ac));
                    client.ci = null;
                    client.ch = null;
                    client.dk = 0;
                }
            }
        }
        catch (IOException ex) {
            client.logger.error("", ex);
            n(this, 1002);
        }
    }
    
    public static void n(final client client, final int z) {
        client.ci = null;
        client.ch = null;
        client.dk = 0;
        final W144 dm = client.dm;
        ++dm.u;
        client.dm.z = z;
    }
    
    public static N272 i() {
        return client.fx;
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
        }
        return client.id ? J160.RESIZABLE : J160.SMALL;
    }
    
    public static void f(final J160 j160, final int n, final int n2, final boolean b) {
        client.ir = 0L;
        final J160 a = a();
        if (j160 == J160.FULLSCREEN || a == J160.FULLSCREEN) {}
        c(a, j160, n, n2, true);
    }
    
    public static final float bh(final float n, final float n2) {
        if (client.mm == null) {
            return 0.0f;
        }
        final float n3 = n / 4.0f;
        final float n4 = n2 / 4.0f;
        if (n3 < 0.0f || n4 < 0.0f || n3 > client.gp - 1 || n4 > client.gy - 1) {
            return 0.0f;
        }
        return client.gz.d.d.ao(n + client.gn, n2 + client.gj);
    }
    
    public static void ag() {
        final El328 d = El328.d(Eu326.WINDOW_STATUS, client.fx.s);
        Gg3.k(d.q, a().getId());
        Gg3.i(d.q, GameShell3.canvasWid);
        Gg3.i(d.q, GameShell3.canvasHei);
        Gg3.k(d.q, W159.g().q);
        N272.e(client.fx, d);
    }
    
    @Override
    public void cyclestart(final boolean b) {
        Lv148.g(b);
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
        final int leftMargin = GameShell3.leftMargin;
        final int topMargin = GameShell3.topMargin;
        final int n = GameShell3.frameWid - GameShell3.canvasWid - leftMargin;
        final int n2 = GameShell3.frameHei - GameShell3.canvasHei - topMargin;
        if (leftMargin <= 0 && n <= 0 && topMargin <= 0) {
            if (n2 <= 0) {
                return;
            }
        }
        try {
            final Container topContainer = client.bu.getTopContainer();
            int left = 0;
            int top = 0;
            if (topContainer == GameShell3.frame) {
                final Insets insets = GameShell3.frame.getInsets();
                left = insets.left;
                top = insets.top;
            }
            final java.awt.Graphics graphics = topContainer.getGraphics();
            graphics.setColor(Color.black);
            if (leftMargin > 0) {
                graphics.fillRect(left, top, leftMargin, GameShell3.frameHei);
            }
            if (topMargin > 0) {
                graphics.fillRect(left, top, GameShell3.frameWid, topMargin);
            }
            if (n > 0) {
                graphics.fillRect(left + GameShell3.frameWid - n, top, n, GameShell3.frameHei);
            }
            if (n2 > 0) {
                graphics.fillRect(left, top + GameShell3.frameHei - n2, GameShell3.frameWid, n2);
            }
        }
        catch (Exception ex) {
            client.logger.error("", ex);
        }
    }
    
    public static void af(int ja) {
        if (!W159.g().b) {
            ja = -1;
        }
        if (ja == client.ja) {
            return;
        }
        if (ja != -1) {
            final CursorType list = client.en.list(ja);
            final Fj373 cursor = list.getCursor();
            if (cursor != null) {
                GameShell3.mouseImp.g(GameShell3.canvas, Fj373.e(cursor), Fj373.q(cursor), Fj373.j(cursor), new Point(list.hotspotx, list.hotspoty));
                client.ja = ja;
            }
            else {
                ja = -1;
            }
        }
        if (ja == -1 && client.ja != -1) {
            GameShell3.mouseImp.g(GameShell3.canvas, null, -1, -1, new Point());
            client.ja = -1;
        }
    }
    
    public static final void av() {
        client.df = 0;
        client.ln = 0;
        client.ll = 0L;
        Lz409.r();
        client.gn = 0;
        client.gj = 0;
        client.gd = 0.0f;
        client.ga = 0.0f;
        Gc330.g();
        ClientScriptAPI.setNativeSelfGameEntity(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), null);
        client.ft.clear();
        client.fe = 0;
        client.jw.d();
        client.kj = null;
        client.kv = null;
        client.ko = null;
        client.kh = null;
        client.dv = null;
    }
    
    public static final void ap() {
        final player j = Gc330.j();
        if (j != null) {
            client.cj.event.triggerEvent("__onLogout", j);
        }
        LuaNativeEvents.detachAllEventHandlers(client.cj.getLuaStateNativeRef());
        G451.j();
        N272.s(client.fx);
        Login.e();
        ac();
        W667.g(2);
        SoundManager.p = -1;
        SoundManager.x = false;
        SoundManager.o();
        At476.g(true);
        av();
        if (client.mm != null) {
            Scene.u(client.mm);
            client.mm = null;
        }
        client.mg = null;
        bk();
        J570.q();
        System.gc();
        z(3);
        try {
            Mu209.g(client.bu, "loggedout");
        }
        catch (Throwable t) {}
    }
    
    public client() {
        this.cq = null;
    }
    
    private static void bi() {
        Bn279 g;
        while ((g = client.gf.g()) != null) {
            try {
                ((H393)g.d()).g();
            }
            catch (Exception ex) {
                client.logger.error("", ex);
            }
        }
    }
    
    public static void ab() {
        client.jr.j(GameShell3.openPrefs("2", client.m.h, true));
    }
    
    public static final void aw(final client client) {
        Lb33.g(Lb33.NotLoggedInLoop);
        try {
            aj();
            SoundManager.v();
            ++client.hf;
            if (client.mm != null) {
                bi();
                Scene.z(client.mm, 0.02f);
            }
            if (client.bj % 1500 == 0) {
                G405.d(client.bu, GameShell3.getEnvironment());
            }
            if (client.jr.q && client.jr.j < Gz143.g() - 60000L) {
                ab();
            }
            client.ku.j.b();
        }
        finally {
            Lb33.d(Lb33.NotLoggedInLoop);
        }
    }
    
    public static native void initNative();
    
    @Be2
    @Bs1
    public static void nativeKeyboardInput(final int n) {
        if (n != 0 && client.fx != null && client.fx.s != null) {
            long n2 = (Gz143.g() - client.cc) / 50L;
            if (n2 > 65535L) {
                n2 = 65535L;
            }
            client.cc = Gz143.g();
            final El328 d = El328.d(Eu326.EVENT_KEYBOARD, client.fx.s);
            Gg3.k(d.q, 3);
            Gg3.k(d.q, n);
            Gg3.i(d.q, (int)n2);
            N272.e(client.fx, d);
        }
    }
    
    public static void b(final client client) {
        if (W667.d() && SoundManager.x && SoundManager.y != null) {
            SoundManager.y.q();
        }
    }
    
    @Be2
    @Bs1
    public static void nativeMouseInputClick(final int n, int n2, int n3) {
        if (client.fx.s != null) {
            long n4 = (Gz143.g() - client.cb) / 50L;
            if (n4 > 32767L) {
                n4 = 32767L;
            }
            client.cb = Gz143.g();
            if (n3 < 0) {
                n3 = 0;
            }
            else if (n3 > 65535) {
                n3 = 65535;
            }
            if (n2 < 0) {
                n2 = 0;
            }
            else if (n2 > 65535) {
                n2 = 65535;
            }
            final int n5 = (int)n4;
            if (!client.nm && (n < 0 || n > 9)) {
                throw new AssertionError();
            }
            final El328 d = El328.d(Eu326.EVENT_MOUSE_CLICK, client.fx.s);
            Gg3.a(d.q, n2 | n3 << 16);
            Gg3.i(d.q, n5 | n << 15);
            N272.e(client.fx, d);
        }
    }
    
    @Jv532
    public static final void ar(final float n) {
        Lb33.g(Lb33.GameLoop);
        try {
            if (client.fx.o) {
                client.fx.o = false;
                at();
                return;
            }
            Lb33.g(Lb33.TCPin);
            try {
                for (int n2 = 0; n2 < 100 && be(client.fx); ++n2) {}
            }
            finally {
                Lb33.d(Lb33.TCPin);
            }
            SoundManager.v();
            if (client.ac != 11) {
                return;
            }
            Lb33.g(Lb33.ReflectionReceiver);
            try {
                while (Ji520.d()) {
                    final El328 d = El328.d(Eu326.REFLECTION_CHECK_REPLY, client.fx.s);
                    Gg3.k(d.q, 0);
                    final int v = d.q.v;
                    Ji520.q(d.q);
                    Gg3.ac(d.q, d.q.v - v);
                    N272.e(client.fx, d);
                }
            }
            finally {
                Lb33.d(Lb33.ReflectionReceiver);
            }
            if (GameShell3.focus != client.bk) {
                client.bk = GameShell3.focus;
                final El328 d2 = El328.d(Eu326.EVENT_APPLET_FOCUS, client.fx.s);
                Gg3.k(d2.q, GameShell3.focus ? 1 : 0);
                N272.e(client.fx, d2);
            }
            if (client.ac != 11) {
                return;
            }
            final N272 fx = client.fx;
            fx.p += n;
            if (client.fx.p > 15.0f) {
                client.logger.error("Lost connection due to timeout.\tReconnecting....");
                at();
                return;
            }
            if (client.mm != null) {
                Lb33.g(Lb33.WorldProcess);
                try {
                    bi();
                    Scene.z(client.mm, n);
                    Scene.k(client.mm);
                    final Iterator<AnimationGraphComponent> iterator = (Iterator<AnimationGraphComponent>)client.mm.x(AnimationGraphComponent.class).iterator();
                    while (iterator.hasNext()) {
                        iterator.next().g(n);
                    }
                    final Iterator<SoundComponent> iterator2 = (Iterator<SoundComponent>)client.mm.x(SoundComponent.class).iterator();
                    while (iterator2.hasNext()) {
                        SoundComponent.g(iterator2.next(), n);
                    }
                    final Iterator<TimerComponent> iterator3 = (Iterator<TimerComponent>)client.mm.x(TimerComponent.class).iterator();
                    while (iterator3.hasNext()) {
                        TimerComponent.g(iterator3.next(), n);
                    }
                    final Iterator<ProcessLogicEventComponent> iterator4 = (Iterator<ProcessLogicEventComponent>)client.mm.x(ProcessLogicEventComponent.class).iterator();
                    while (iterator4.hasNext()) {
                        ProcessLogicEventComponent.g(iterator4.next(), n);
                    }
                    Scene.i(client.mm);
                }
                finally {
                    Lb33.d(Lb33.WorldProcess);
                }
            }
            ClientScriptMessaging.d(client.fx);
            Gf474.w();
            bd();
            aj();
            for (int i = 0; i < client.hd; ++i) {
                if (client.bv > 1) {
                    --client.bv;
                }
                ++client.hf;
                if (client.hp != 0) {
                    client.hc += 20;
                    if (client.hc >= 400) {
                        client.hp = 0;
                    }
                }
                ax();
            }
            if (client.jr.q && client.jr.j < Gz143.g() - 60000L) {
                ab();
            }
            client.ku.j.b();
            ++client.hr;
            if (client.hr > 500) {
                client.hr = 0;
                final int n3 = (int)(Math.random() * 8.0);
                if ((n3 & 0x1) == 0x1) {
                    client.gw += client.gm;
                }
                if ((n3 & 0x2) == 0x2) {
                    client.gx += client.gr;
                }
                if ((n3 & 0x4) == 0x4) {
                    client.hn += client.hb;
                }
            }
            if (client.gw < -50) {
                client.gm = 2;
            }
            if (client.gw > 50) {
                client.gm = -2;
            }
            if (client.gx < -55) {
                client.gr = 2;
            }
            if (client.gx > 55) {
                client.gr = -2;
            }
            if (client.hn < -40) {
                client.hb = 1;
            }
            if (client.hn > 40) {
                client.hb = -1;
            }
            ++client.hu;
            if (client.hu > 500) {
                client.hu = 0;
                final int n4 = (int)(Math.random() * 8.0);
                if ((n4 & 0x1) == 0x1) {
                    client.hj += client.hx;
                }
                if ((n4 & 0x2) == 0x2) {
                    client.ho += client.ht;
                }
            }
            if (client.hj < -60) {
                client.hx = 2;
            }
            if (client.hj > 60) {
                client.hx = -2;
            }
            if (client.ho < -20) {
                client.ht = 1;
            }
            if (client.ho > 10) {
                client.ht = -1;
            }
            if (client.ff) {
                cb();
                client.ff = false;
            }
            try {
                client.fx.j();
            }
            catch (IOException ex) {
                client.logger.error("Connection failure when flushing. Reconnecting....", ex);
                at();
            }
            if (client.cf) {
                bw();
            }
            if (Y192.e) {
                while (Y192.j()) {
                    final El328 d3 = El328.d(Eu326.PHYSICSCONTROLDEBUGGER_STATE, client.fx.s);
                    Gg3.i(d3.q, 0);
                    final int v2 = d3.q.v;
                    if (Y192.e(d3.q)) {
                        Gg3.as(d3.q, d3.q.v - v2);
                        N272.e(client.fx, d3);
                    }
                }
            }
        }
        finally {
            Lb33.d(Lb33.GameLoop);
        }
    }
    
    private static void ax() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - N272.g(client.fx) > 1000L) {
            N272.e(client.fx, El328.d(Eu326.NO_TIMEOUT, client.fx.s));
            N272.d(client.fx, currentTimeMillis);
        }
    }
    
    public static final void am() {
        client.fa.cacheClean(5);
        client.fl.cacheClean(5);
        client.fd.cacheClean(5);
        client.fi.cacheClean(5);
        client.fn.cacheClean(5);
        client.fm.cacheClean(5);
        client.fs.cacheClean(5);
        client.fh.cacheClean(5);
        client.en.cacheClean(5);
        Aw157.l(client.eq, 50);
        client.ex.h(5);
    }
    
    private static final boolean bs(final N272 n272) throws IOException {
        final Hx339 q = n272.q;
        final Gs329 b = n272.b;
        if (q == null) {
            return false;
        }
        if (n272.r == null) {
            if (n272.y) {
                if (!q.d(1)) {
                    return false;
                }
                q.j(n272.b.r, 0, 1);
                ++n272.z;
                n272.p = 0.0f;
                n272.y = false;
            }
            b.v = 0;
            if (Gs329.q(b)) {
                if (!q.d(1)) {
                    return false;
                }
                q.j(n272.b.r, 1, 1);
                ++n272.z;
                n272.p = 0.0f;
            }
            n272.y = true;
            final Ea395[] values = Ea395.values();
            final int j = Gs329.j(b);
            if (j < 0 || j >= values.length) {
                throw new IOException(j + " " + b.v);
            }
            n272.r = values[j];
            n272.v = n272.r.dy;
        }
        if (n272.v == -1) {
            if (!q.d(1)) {
                return false;
            }
            q.j(b.r, 0, 1);
            n272.v = (b.r[0] & 0xFF);
            ++n272.z;
            n272.p = 0.0f;
        }
        if (n272.v == -2) {
            if (!q.d(2)) {
                return false;
            }
            q.j(b.r, 0, 2);
            b.v = 0;
            n272.v = Gg3.au(b);
            n272.z += 2;
            n272.p = 0.0f;
        }
        if (n272.v > 0) {
            if (!q.d(n272.v)) {
                return false;
            }
            b.v = 0;
            q.j(b.r, 0, n272.v);
            n272.z += n272.v;
            n272.p = 0.0f;
        }
        n272.i = n272.k;
        n272.k = n272.n;
        n272.n = n272.r;
        client.logger.trace("Packet : " + n272.r.toString());
        if (n272.r == Ea395.REBUILD_NORMAL) {
            bp();
            n272.r = null;
            return false;
        }
        if (n272.r == Ea395.LOGOUT_SWITCH_PLAYER) {
            client.ap.q = Gg3.bd(b);
            z(13);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.LOGOUT) {
            client.logger.trace("logout");
            ap();
            n272.r = null;
            return false;
        }
        if (n272.r == Ea395.LOGOUT_TRANSFER) {
            final int au = Gg3.au(b);
            final String bk = Gg3.bk(b);
            client.logger.trace("logout transfer to world " + au + " on " + bk);
            Lf336.g(au, bk);
            z(15);
            n272.r = null;
            return false;
        }
        if (n272.r == Ea395.UPDATE_REBOOT_TIMER) {
            client.bv = Gg3.au(b) * 30;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.LAST_LOGIN_INFO) {
            final int bd = Gg3.bd(b);
            client.bn = InetAddress.getByAddress(new byte[] { (byte)(bd >> 24 & 0xFF), (byte)(bd >> 16 & 0xFF), (byte)(bd >> 8 & 0xFF), (byte)(bd & 0xFF) }).getHostName();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_DOB) {
            client.iy = Gg3.ad(b);
            client.ic = (Gg3.ar(b) == 1);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.REFLECTION_CHECKER) {
            Ji520.j(b, n272.v);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.PLAYER_INFO2) {
            Gc330.s(b, n272.v);
            ++client.mw;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.TICK) {
            final int bd2 = Gg3.bd(b);
            client.kn = Gg3.bl(b);
            if (!client.do_ || !client.la) {
                client.df = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(bd2, client.dz);
                client.do_ = true;
            }
            client.ln = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(client.df, bd2) - client.dz;
            client.ll = System.nanoTime();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MESSAGE_GAME) {
            final int br = Gg3.br(b);
            final int bd3 = Gg3.bd(b);
            final int ar = Gg3.ar(b);
            String bk3;
            String bk2 = bk3 = "";
            if ((ar & 0x1) != 0x0) {
                bk2 = Gg3.bk(b);
                if ((ar & 0x2) != 0x0) {
                    bk3 = Gg3.bk(b);
                }
                else {
                    bk3 = bk2;
                }
            }
            final String bk4 = Gg3.bk(b);
            if (br == 99) {
                debugconsole.addline(bk4);
                client.logger.info(bk4);
            }
            else if (br == 98) {
                debugconsole.s(bk4);
            }
            else {
                if (!bk3.equals("") && cj(bk3)) {
                    n272.r = null;
                    return true;
                }
                G232.q(br, bd3, bk2, bk3, bk2, bk4);
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_FRIENDLIST) {
            while (b.v < n272.v) {
                final boolean b2 = Gg3.ar(b) == 1;
                final String bk5 = Gg3.bk(b);
                final String bk6 = Gg3.bk(b);
                final int au2 = Gg3.au(b);
                final boolean b3 = Gg3.ar(b) == 1;
                String bk7 = "";
                boolean b4 = false;
                if (au2 > 0) {
                    bk7 = Gg3.bk(b);
                    b4 = (Gg3.ar(b) == 1);
                }
                client.logger.error("Got friend: " + bk5 + " world:" + au2 + " samegame:" + b4);
                client.ku.j.j(b2, bk5, bk6, au2, bk7, b4, b3);
            }
            ClientFriendListComponent.g(client.ku, true);
            LuaNativeEvents.invokeOnClientFriendListUpdate(client.cj.getLuaStateNativeRef());
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_INV_PARTIAL) {
            final int au3 = Gg3.au(b);
            final boolean b5 = (Gg3.ar(b) & 0x1) == 0x1;
            client.logger.trace("Received inventory update for inventory: " + au3 + " other player?: " + b5);
            final ArrayList list = b5 ? null : new ArrayList<Integer>(0);
            final ClientInventory d = G451.d(au3, b5);
            while (b.v < n272.v) {
                final int br2 = Gg3.br(b);
                final int au4 = Gg3.au(b);
                int n273 = 0;
                if (au4 != 0) {
                    n273 = Gg3.ar(b);
                    if (n273 == 255) {
                        n273 = Gg3.bd(b);
                    }
                }
                d.g(br2, au4 - 1, n273);
                if (au4 != 0) {
                    for (int ar2 = Gg3.ar(b), i = 0; i < ar2; ++i) {
                        final Kr260 decodeVarValue = client.fi.decodeVarValue(b);
                        d.q(br2, decodeVarValue.g, decodeVarValue.d);
                    }
                }
                if (!b5) {
                    list.add(Integer.valueOf(br2));
                }
            }
            n272.r = null;
            if (!b5) {
                cw(new Y388(d, list));
            }
            return true;
        }
        if (n272.r == Ea395.UPDATE_INV_FULL) {
            final int au5 = Gg3.au(b);
            final boolean b6 = (Gg3.ar(b) & 0x1) == 0x1;
            client.logger.trace("Received full inventory for inventory: " + au5 + " other player?: " + b6);
            final ClientInventory d2 = G451.d(au5, b6);
            ClientInventory.d(d2);
            while (b.v < n272.v) {
                final int br3 = Gg3.br(b);
                final int au6 = Gg3.au(b);
                int n274 = 0;
                if (au6 != 0) {
                    n274 = Gg3.ar(b);
                    if (n274 == 255) {
                        n274 = Gg3.bd(b);
                    }
                }
                d2.g(br3, au6 - 1, n274);
                if (au6 != 0) {
                    for (int ar3 = Gg3.ar(b), k = 0; k < ar3; ++k) {
                        final Kr260 decodeVarValue2 = client.fi.decodeVarValue(b);
                        d2.q(br3, decodeVarValue2.g, decodeVarValue2.d);
                    }
                }
            }
            n272.r = null;
            if (!b6) {
                cw(new U406(d2));
            }
            return true;
        }
        if (n272.r == Ea395.NPC_APPEARED) {
            cp();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.NPC_UPDATE) {
            cd();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.NPC_EXTENDED_STATE) {
            ck();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.NPC_GONE) {
            ce();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARCLAN) {
            Gg3.au(b);
            if (client.js == null) {
                client.js = new SparseVarDomain(client.fm);
            }
            final Kr260 decodeVarValue3 = client.fm.decodeVarValue(b);
            client.js.varValues.s(decodeVarValue3.g, decodeVarValue3.d);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARCLAN_ENABLE) {
            client.js = new SparseVarDomain(client.fm);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARCLAN_DISABLE) {
            client.js = null;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARP_SMALL) {
            final int au7 = Gg3.au(b);
            final byte ax = Gg3.ax(b);
            client.logger.trace("Received small varp variable: " + au7 + " value:" + ax);
            client.jw.q(client.fd.list(au7), ax);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARP_LARGE) {
            final int au8 = Gg3.au(b);
            final int bd4 = Gg3.bd(b);
            client.logger.trace("Received big varp variable: " + au8 + " value:" + bd4);
            client.jw.q(client.fd.list(au8), bd4);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARBIT_SMALL) {
            final int au9 = Gg3.au(b);
            final int ar4 = Gg3.ar(b);
            client.logger.trace("Received small varbit variable: " + au9 + " value:" + ar4);
            Fw152.j(client.jw, client.fl.list(au9), ar4);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.VARBIT_LARGE) {
            final int au10 = Gg3.au(b);
            final int bd5 = Gg3.bd(b);
            client.logger.trace("Received big varbit variable: " + au10 + " value:" + bd5);
            Fw152.j(client.jw, client.fl.list(au10), bd5);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLIENT_SETVARC_SMALL) {
            final int au11 = Gg3.au(b);
            final byte ax2 = Gg3.ax(b);
            client.logger.trace("client_setvarc (small) - var:" + au11 + " val:" + ax2);
            cl();
            L410.j(au11, ax2);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLIENT_SETVARC_LARGE) {
            final int au12 = Gg3.au(b);
            final int bd6 = Gg3.bd(b);
            client.logger.trace("client_setvarc (large) - var:" + au12 + " val:" + bd6);
            cl();
            L410.j(au12, bd6);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLIENT_SETVARCSTR_SMALL) {
            final int au13 = Gg3.au(b);
            final String bk8 = Gg3.bk(b);
            client.logger.trace("client_setvarcstr (small) - var:" + au13 + " val:" + bk8);
            cl();
            L410.e(au13, bk8);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.CLIENT_SETVARCSTR_LARGE) {
            final int au14 = Gg3.au(b);
            final String bk9 = Gg3.bk(b);
            client.logger.trace("client_setvarcstr (large) - var:" + au14 + " val:" + bk9);
            cl();
            L410.e(au14, bk9);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.SETDRAWORDER) {
            final int ar5 = Gg3.ar(b);
            cl();
            client.hz = ar5;
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MIDI_SONG) {
            int au15 = Gg3.au(b);
            if (au15 == 65535) {
                au15 = -1;
            }
            SoundManager.t(au15, Gg3.ar(b), Gg3.ar(b));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MIDI_JINGLE) {
            int au16 = Gg3.au(b);
            if (au16 == 65535) {
                au16 = -1;
            }
            SoundManager.m(au16, Gg3.ay(b), Gg3.ar(b));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_PLAYSOUND) {
            SoundManager.ag(Gg3.bd(b), Gg3.ar(b), Gg3.bk(b));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_STARTMUSIC) {
            final String bk10 = Gg3.bk(b);
            final String bk11 = Gg3.bk(b);
            client.logger.debug("Received StartMusic {}", bk10);
            SoundManager.ap(bk10, bk11);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_STOPMUSIC) {
            client.logger.debug("Received StopMusic");
            SoundManager.ao();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_SETMUSICPARAMETER) {
            SoundManager.aa(Gg3.bk(b));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_PLAYAMBIENCE) {
            final String bk12 = Gg3.bk(b);
            final String bk13 = Gg3.bk(b);
            client.logger.debug("Received StartAmbience");
            SoundManager.am(bk12, bk13);
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_STOPAMBIENCE) {
            client.logger.debug("Received StopAmbience");
            SoundManager.as();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_SETAMBIENCEPARAMETER) {
            SoundManager.aa(Gg3.bk(b));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_PRELOADBANK) {
            SoundManager.ac(Gg3.bk(b));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_MIXERPRESET) {
            SoundManager.at(Gg3.bk(b));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.FMOD_STOPALLSOUNDS) {
            SoundManager.ab();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.GENERIC_BROADCAST_STATE) {
            final BroadcastStateAndEventsTypes$StatePayload obj = new BroadcastStateAndEventsTypes$StatePayload();
            final BroadcastStateAndEventsTypes$StateDefinition unpackStateMessage = BroadcastStateAndEventsTransmission.UnpackStateMessage(b, obj);
            final player l = Gc330.j();
            client.logger.trace("BROADCAST_STATE with statedef: '" + unpackStateMessage + "' / thisplayer: '" + l + "' / payload: '" + obj + "'");
            if (unpackStateMessage != null) {
                client.ck.add(new F407(obj.broadcasterID, unpackStateMessage, obj, l));
            }
            else {
                client.logger.warn("um... couldn't build a StateDefinition from incoming state packet.");
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.GENERIC_BROADCAST_EVENT) {
            final BroadcastStateAndEventsTypes$EventPayload broadcastStateAndEventsTypes$EventPayload = new BroadcastStateAndEventsTypes$EventPayload();
            final BroadcastStateAndEventsTypes$EventDefinition unpackEventMessage = BroadcastStateAndEventsTransmission.UnpackEventMessage(b, broadcastStateAndEventsTypes$EventPayload);
            if (unpackEventMessage != null) {
                client.ck.add(new E413(broadcastStateAndEventsTypes$EventPayload.broadcasterID, unpackEventMessage, broadcastStateAndEventsTypes$EventPayload));
            }
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.GENERIC_BROADCAST_GONE) {
            final BroadcastStateAndEventsTypes$GonePayload unpackGoneMessage = BroadcastStateAndEventsTransmission.UnpackGoneMessage(b);
            client.ck.add(new Aq668(unpackGoneMessage.broadcasterID, unpackGoneMessage));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.GENERIC_BROADCAST_APPEARED) {
            final BroadcastStateAndEventsTypes$AppearedPayload unpackAppearedMessage = BroadcastStateAndEventsTransmission.UnpackAppearedMessage(b);
            client.ck.add(new M411(unpackAppearedMessage.broadcasterID, unpackAppearedMessage));
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.GENERIC_BROADCAST_ATOMIC_END_MARKER) {
            if (y(client.ac)) {
                client.ce.addAll(client.ck);
            }
            else {
                final Iterator<V385> iterator = (Iterator<V385>)client.ck.iterator();
                while (iterator.hasNext()) {
                    iterator.next().j();
                }
            }
            client.ck.clear();
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.UPDATE_IGNORELIST_PARTIAL) {
            final int ar6 = Gg3.ar(b);
            client.ku.e.g((ar6 & 0x1) == 0x1, Gg3.bk(b), Gg3.bk(b), Gg3.bk(b), Gg3.bk(b), (ar6 & 0x2) == 0x2);
            LuaNativeEvents.invokeOnClientFriendListUpdate(client.cj.getLuaStateNativeRef());
            n272.r = null;
            return true;
        }
        if (n272.r == Ea395.MESSAGE_PUBLIC) {
            final player e = Gc330.e(Gg3.au(b));
            if (e == null) {
                n272.r = null;
                return true;
            }
            Gg3.au(b);
            final int ar7 = Gg3.ar(b);
            if (e.ai != null) {
                boolean b7 = false;
                if (ar7 <= 1) {
                    if ((client.ic && !client.iw) || client.io) {
                        b7 = true;
                    }
                    else if (cj(e.ai)) {
                        b7 = true;
                    }
                }
                if (!b7 && client.hm == 0) {
                    final int n275 = -1;
                    final String g = Et578.g(Af155.q(b));
                    int n276;
                    if (ar7 == 1 || ar7 == 2) {
                        n276 = 1;
                    }
                    else {
                        n276 = 2;
                    }
                    G232.j(n276, 0, e.bi(true), player.bt(e, false), e.aq, g, null, n275);
                }
            }
            n272.r = null;
            return true;
        }
        else if (n272.r == Ea395.MESSAGE_PRIVATE) {
            final boolean b8 = Gg3.ar(b) == 1;
            String s2;
            final String s = s2 = Gg3.bk(b);
            if (b8) {
                s2 = Gg3.bk(b);
            }
            final long n277 = Gg3.au(b);
            final long n278 = Gg3.ay(b);
            final int ar8 = Gg3.ar(b);
            final long n279 = (n277 << 32) + n278;
            boolean b9 = false;
            while (true) {
                for (int n280 = 0; n280 < 100; ++n280) {
                    if (client.jh[n280] == n279) {
                        b9 = true;
                        if (!b9 && client.hm == 0) {
                            client.jh[client.jp] = n279;
                            client.jp = (client.jp + 1) % 100;
                            final String g2 = Et578.g(Af155.q(b));
                            if (ar8 == 2) {
                                G232.j(7, 0, A412.g(1) + s, A412.g(1) + s2, s, g2, null, -1);
                            }
                            else if (ar8 == 1) {
                                G232.j(7, 0, A412.g(0) + s, A412.g(0) + s2, s, g2, null, -1);
                            }
                            else {
                                G232.j(3, 0, s, s2, s, g2, null, -1);
                            }
                        }
                        n272.r = null;
                        return true;
                    }
                }
                if (ar8 > 1) {
                    continue;
                }
                if ((client.ic && !client.iw) || client.io) {
                    b9 = true;
                    continue;
                }
                if (cj(s2)) {
                    b9 = true;
                }
                continue;
            }
        }
        else {
            if (n272.r == Ea395.CHAT_FILTER_SETTINGS) {
                client.je = Gg3.ar(b);
                client.jn = Gg3.ar(b);
                n272.r = null;
                return true;
            }
            if (n272.r == Ea395.CHAT_FILTER_SETTINGS_PRIVATECHAT) {
                client.jz = Hf380.g(Gg3.ar(b));
                n272.r = null;
                return true;
            }
            if (n272.r == Ea395.UPDATE_IGNORELIST_FULL) {
                D236.s(client.ku.e);
                for (int ar9 = Gg3.ar(b), n281 = 0; n281 < ar9; ++n281) {
                    client.ku.e.g(false, Gg3.bk(b), Gg3.bk(b), Gg3.bk(b), Gg3.bk(b), false);
                }
                LuaNativeEvents.invokeOnClientFriendListUpdate(client.cj.getLuaStateNativeRef());
                n272.r = null;
                return true;
            }
            if (n272.r == Ea395.SYNTH_SOUND) {
                int au17 = Gg3.au(b);
                if (au17 == 65535) {
                    au17 = -1;
                }
                SoundManager.p(au17, Gg3.ar(b), Gg3.au(b), Gg3.ar(b), Gg3.au(b));
                n272.r = null;
                return true;
            }
            if (n272.r == Ea395.VORBIS_SOUND) {
                int au18 = Gg3.au(b);
                if (au18 == 65535) {
                    au18 = -1;
                }
                SoundManager.u(au18, Gg3.ar(b), Gg3.au(b), Gg3.ar(b), false, Gg3.au(b));
                n272.r = null;
                return true;
            }
            if (n272.r == Ea395.VORBIS_SPEECH_SOUND) {
                int au19 = Gg3.au(b);
                if (au19 == 65535) {
                    au19 = -1;
                }
                SoundManager.u(au19, Gg3.ar(b), Gg3.au(b), Gg3.ar(b), true, 256);
                n272.r = null;
                return true;
            }
            if (n272.r == Ea395.VORBIS_SPEECH_STOP) {
                SoundManager.n();
                n272.r = null;
                return true;
            }
            if (n272.r == Ea395.RESET_CLIENT_VARCACHE) {
                client.logger.trace("Resetting variables to 0 in preperation for full transmit");
                client.jw.d();
                n272.r = null;
                return true;
            }
            if (n272.r == Ea395.MESSAGE_PRIVATE_ECHO) {
                final String bk14 = Gg3.bk(b);
                G232.q(6, 0, bk14, bk14, bk14, Et578.g(Af155.q(b)));
                n272.r = null;
                return true;
            }
            if (n272.r == Ea395.UPDATE_INV_STOP_TRANSMIT) {
                G451.q(Gg3.au(b), (Gg3.ar(b) & 0x1) == 0x1);
                n272.r = null;
                return true;
            }
            if (n272.r == Ea395.MESSAGE_FRIENDCHANNEL) {
                final boolean b10 = Gg3.ar(b) == 1;
                String s4;
                final String s3 = s4 = Gg3.bk(b);
                if (b10) {
                    s4 = Gg3.bk(b);
                }
                final long bq = Gg3.bq(b);
                final long n282 = Gg3.au(b);
                final long n283 = Gg3.ay(b);
                final int ar10 = Gg3.ar(b);
                final long n284 = (n282 << 32) + n283;
                boolean b11 = false;
                while (true) {
                    for (int n285 = 0; n285 < 100; ++n285) {
                        if (client.jh[n285] == n284) {
                            b11 = true;
                            if (!b11 && client.hm == 0) {
                                client.jh[client.jp] = n284;
                                client.jp = (client.jp + 1) % 100;
                                final String g3 = Et578.g(Af155.q(b));
                                if (ar10 == 2 || ar10 == 3) {
                                    G232.j(9, 0, A412.g(1) + s3, A412.g(1) + s4, s3, g3, Q280.d(bq), -1);
                                }
                                else if (ar10 == 1) {
                                    G232.j(9, 0, A412.g(0) + s3, A412.g(0) + s4, s3, g3, Q280.d(bq), -1);
                                }
                                else {
                                    G232.j(9, 0, s3, s4, s3, g3, Q280.d(bq), -1);
                                }
                            }
                            n272.r = null;
                            return true;
                        }
                    }
                    if (ar10 > 1) {
                        continue;
                    }
                    if ((client.ic && !client.iw) || client.io) {
                        b11 = true;
                        continue;
                    }
                    if (cj(s4)) {
                        b11 = true;
                    }
                    continue;
                }
            }
            else {
                if (n272.r == Ea395.MESSAGE_CLANCHANNEL) {
                    final boolean b12 = Gg3.ar(b) == 1;
                    final String bk15 = Gg3.bk(b);
                    final long n286 = Gg3.au(b);
                    final long n287 = Gg3.ay(b);
                    final int ar11 = Gg3.ar(b);
                    final long n288 = (n286 << 32) + n287;
                    boolean b13 = false;
                    final Dr574 dr574 = b12 ? client.kh : client.ko;
                    Label_5045: {
                        if (dr574 == null) {
                            b13 = true;
                        }
                        else {
                            for (int n289 = 0; n289 < 100; ++n289) {
                                if (client.jh[n289] == n288) {
                                    b13 = true;
                                    break Label_5045;
                                }
                            }
                            if (ar11 <= 1) {
                                if ((client.ic && !client.iw) || client.io) {
                                    b13 = true;
                                }
                                else if (cj(bk15)) {
                                    b13 = true;
                                }
                            }
                        }
                    }
                    if (!b13 && client.hm == 0) {
                        client.jh[client.jp] = n288;
                        client.jp = (client.jp + 1) % 100;
                        final String g4 = Et578.g(Af155.q(b));
                        final int n290 = b12 ? 41 : 44;
                        if (ar11 == 2 || ar11 == 3) {
                            G232.j(n290, 0, A412.g(1) + bk15, A412.g(1) + bk15, bk15, g4, dr574.k, -1);
                        }
                        else if (ar11 == 1) {
                            G232.j(n290, 0, A412.g(0) + bk15, A412.g(0) + bk15, bk15, g4, dr574.k, -1);
                        }
                        else {
                            G232.j(n290, 0, bk15, bk15, bk15, g4, dr574.k, -1);
                        }
                    }
                    n272.r = null;
                    return true;
                }
                if (n272.r == Ea395.MESSAGE_GROUP) {
                    final boolean b14 = Gg3.ar(b) == 1;
                    String s6;
                    final String s5 = s6 = Gg3.bk(b);
                    if (b14) {
                        s6 = Gg3.bk(b);
                    }
                    final int ar12 = Gg3.ar(b);
                    boolean b15 = false;
                    if (ar12 <= 1) {
                        if ((client.ic && !client.iw) || client.io) {
                            b15 = true;
                        }
                        else if (ar12 <= 1 && cj(s6)) {
                            b15 = true;
                        }
                    }
                    if (!b15 && client.hm == 0) {
                        final String g5 = Et578.g(Af155.q(b));
                        if (ar12 == 2) {
                            G232.j(24, 0, A412.g(1) + s5, A412.g(1) + s6, s5, g5, null, -1);
                        }
                        else if (ar12 == 1) {
                            G232.j(24, 0, A412.g(0) + s5, A412.g(0) + s6, s5, g5, null, -1);
                        }
                        else {
                            G232.j(24, 0, s5, s6, s5, g5, null, -1);
                        }
                    }
                    n272.r = null;
                    return true;
                }
                if (n272.r == Ea395.CLANCHANNEL_FULL) {
                    final boolean b16 = Gg3.ar(b) == 1;
                    if (n272.v == 1) {
                        client.logger.trace("Received ClanChannel RESET - affined:" + b16);
                        if (b16) {
                            client.kh = null;
                        }
                        else {
                            client.ko = null;
                        }
                        n272.r = null;
                        return true;
                    }
                    Dr574 dr575;
                    if (b16) {
                        dr575 = (client.kh = new Dr574(b));
                    }
                    else {
                        dr575 = (client.ko = new Dr574(b));
                    }
                    client.logger.trace("\n{} ClanChannel received and set - updateNum: {}\n{}", new Object[] { b16 ? "Affined" : "Listened", dr575.n, dr575.e() });
                    n272.r = null;
                    return true;
                }
                else if (n272.r == Ea395.CLANSETTINGS_FULL) {
                    final boolean b17 = Gg3.ar(b) == 1;
                    if (n272.v == 1) {
                        if (b17) {
                            client.kv = null;
                        }
                        else {
                            client.kj = null;
                        }
                        n272.r = null;
                        return true;
                    }
                    Ef450 ef450;
                    if (b17) {
                        ef450 = (client.kv = new Ef450(b));
                    }
                    else {
                        ef450 = (client.kj = new Ef450(b));
                    }
                    client.logger.trace("{} ClanRecord received and set - updateNum: {}\n{}", new Object[] { b17 ? "Affined" : "Listened", ef450.s, ef450.u() });
                    n272.r = null;
                    return true;
                }
                else {
                    if (n272.r == Ea395.CLANCHANNEL_DELTA) {
                        final boolean b18 = Gg3.ar(b) == 1;
                        final Ee573 ee573 = new Ee573(b);
                        Dr574 dr576;
                        if (b18) {
                            dr576 = client.kh;
                        }
                        else {
                            dr576 = client.ko;
                        }
                        ee573.d(dr576);
                        client.logger.trace(dr576.e());
                        n272.r = null;
                        return true;
                    }
                    if (n272.r == Ea395.CLANSETTINGS_DELTA) {
                        final boolean b19 = Gg3.ar(b) == 1;
                        final Dg449 dg449 = new Dg449(b);
                        Ef450 ef451;
                        if (b19) {
                            ef451 = client.kv;
                        }
                        else {
                            ef451 = client.kj;
                        }
                        dg449.d(ef451);
                        client.logger.trace(ef451.u());
                        n272.r = null;
                        return true;
                    }
                    if (n272.r == Ea395.UPDATE_FRIENDCHAT_CHANNEL_FULL) {
                        if (n272.v == 0) {
                            client.ju = null;
                            client.jv = null;
                            client.kf = null;
                            client.km = 0;
                            client.kg = null;
                            n272.r = null;
                            return true;
                        }
                        client.jv = Gg3.bk(b);
                        if (Gg3.ar(b) == 1) {
                            client.kf = Gg3.bk(b);
                        }
                        else {
                            client.kf = client.jv;
                        }
                        client.ju = Q280.g(Gg3.bq(b));
                        client.kr = Gg3.ax(b);
                        client.logger.trace("CLANCHAT: Received full channel list for channel: {}, kickrank: {}", client.ju, client.kr);
                        final int ar13 = Gg3.ar(b);
                        if (ar13 == 255) {
                            n272.r = null;
                            return true;
                        }
                        client.km = ar13;
                        client.logger.trace("USERCOUNT={}", client.km);
                        final Ah608[] kg = new Ah608[100];
                        for (int n291 = 0; n291 < client.km; ++n291) {
                            kg[n291] = new Ah608();
                            kg[n291].g = Gg3.bk(b);
                            if (Gg3.ar(b) == 1) {
                                kg[n291].d = Gg3.bk(b);
                            }
                            else {
                                kg[n291].d = kg[n291].g;
                            }
                            kg[n291].q = Md230.e(kg[n291].d, null);
                            kg[n291].j = Gg3.au(b);
                            kg[n291].h = Gg3.ax(b);
                            kg[n291].e = Gg3.bk(b);
                            if (kg[n291].d.equals(Gc330.j().aq)) {
                                client.kz = kg[n291].h;
                            }
                        }
                        int km = client.km;
                        while (km > 0) {
                            boolean b20 = true;
                            --km;
                            for (int n292 = 0; n292 < km; ++n292) {
                                if (kg[n292].q.compareTo(kg[n292 + 1].q) > 0) {
                                    final Ah608 ah608 = kg[n292];
                                    kg[n292] = kg[n292 + 1];
                                    kg[n292 + 1] = ah608;
                                    b20 = false;
                                }
                            }
                            if (b20) {
                                break;
                            }
                        }
                        client.kg = kg;
                        client.logger.trace("-=-=- CLANCHAT FULL CHANNEL UPDATE -=-=-");
                        client.logger.trace("usercount={}", client.km);
                        for (int n293 = 0; n293 < client.km; ++n293) {
                            client.logger.trace("{} (w{})", client.kg[n293].d, client.kg[n293].j);
                        }
                        n272.r = null;
                        return true;
                    }
                    else {
                        if (n272.r == Ea395.UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER) {
                            final String bk16 = Gg3.bk(b);
                            String bk17;
                            if (Gg3.ar(b) == 1) {
                                bk17 = Gg3.bk(b);
                            }
                            else {
                                bk17 = bk16;
                            }
                            final int au20 = Gg3.au(b);
                            final byte ax3 = Gg3.ax(b);
                            boolean b21 = false;
                            if (ax3 == -128) {
                                b21 = true;
                            }
                            if (b21) {
                                if (client.km == 0) {
                                    n272.r = null;
                                    return true;
                                }
                                int n294;
                                for (n294 = 0; n294 < client.km && (!client.kg[n294].d.equals(bk17) || client.kg[n294].j != au20); ++n294) {}
                                if (n294 < client.km) {
                                    while (n294 < client.km - 1) {
                                        client.kg[n294] = client.kg[n294 + 1];
                                        ++n294;
                                    }
                                    --client.km;
                                    client.kg[client.km] = null;
                                }
                            }
                            else {
                                final String bk18 = Gg3.bk(b);
                                final Ah608 ah609 = new Ah608();
                                ah609.g = bk16;
                                ah609.d = bk17;
                                ah609.q = Md230.e(ah609.d, null);
                                ah609.j = au20;
                                ah609.h = ax3;
                                ah609.e = bk18;
                                int n295;
                                for (n295 = client.km - 1; n295 >= 0; --n295) {
                                    final int compareTo = client.kg[n295].q.compareTo(ah609.q);
                                    if (compareTo == 0) {
                                        client.kg[n295].j = au20;
                                        client.kg[n295].h = ax3;
                                        client.kg[n295].e = bk18;
                                        if (bk17.equals(Gc330.j().aq)) {
                                            client.kz = ax3;
                                        }
                                        client.logger.trace("-=-=- CLANCHAT INCR+ CHANNEL UPDATE -=-=-");
                                        client.logger.trace("usercount={}", client.km);
                                        for (int n296 = 0; n296 < client.km; ++n296) {
                                            client.logger.trace("{} (w{})", client.kg[n296].d, client.kg[n296].j);
                                        }
                                        n272.r = null;
                                        return true;
                                    }
                                    if (compareTo < 0) {
                                        break;
                                    }
                                }
                                if (client.km >= client.kg.length) {
                                    n272.r = null;
                                    return true;
                                }
                                for (int n297 = client.km - 1; n297 > n295; --n297) {
                                    client.kg[n297 + 1] = client.kg[n297];
                                }
                                if (client.km == 0) {
                                    client.kg = new Ah608[100];
                                }
                                client.kg[n295 + 1] = ah609;
                                ++client.km;
                                if (bk17.equals(Gc330.j().aq)) {
                                    client.kz = ax3;
                                }
                            }
                            client.logger.trace("-=-=- CLANCHAT INCR+ CHANNEL UPDATE -=-=-");
                            client.logger.trace("usercount={}", client.km);
                            for (int n298 = 0; n298 < client.km; ++n298) {
                                client.logger.trace("{} (w{})", client.kg[n298].d, client.kg[n298].j);
                            }
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.TRIGGER_ONDIALOGABORT) {
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.UPDATE_UID192) {
                            final Gs329 gs329 = b;
                            gs329.v += 28;
                            if (Gg3.bc(b)) {
                                GameShell3.storeUID192(b, b.v - 28);
                            }
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.UPDATE_SITESETTINGS) {
                            G405.g(client.o, client.bu, GameShell3.getEnvironment());
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.URL_OPEN) {
                            if (Hq338.g && GameShell3.fsframe != null) {
                                f(W159.g().j, -1, -1, false);
                            }
                            final byte[] array = new byte[n272.v - 1];
                            final boolean b22 = Gg3.ar(b) == 1;
                            Gs329.e(b, array, 0, n272.v - 1);
                            Dp208.q(J173.s(array, 0, n272.v - 1), true, false, client.ao, client.aa);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.SOCIAL_NETWORK_LOGOUT) {
                            if (Hq338.g && GameShell3.fsframe != null) {
                                f(W159.g().j, -1, -1, false);
                            }
                            final byte[] array2 = new byte[n272.v];
                            Gs329.e(b, array2, 0, n272.v);
                            final String s7 = J173.s(array2, 0, n272.v);
                            final String s8 = "opensn";
                            if (!client.k || !Dp208.s(s7, 1, s8)) {
                                Dp208.j(s7, true, false, s8, client.ao, client.aa);
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
                            final String bk19 = Gg3.bk(b);
                            final Object[] array3 = new Object[bk19.length() + 1];
                            for (int index = bk19.length() - 1; index >= 0; --index) {
                                if (bk19.charAt(index) == 's') {
                                    array3[index + 1] = Gg3.bk(b);
                                }
                                else {
                                    array3[index + 1] = new Integer(Gg3.bd(b));
                                }
                            }
                            array3[0] = new Integer(Gg3.bd(b));
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
                            Gg3.au(b);
                            Gg3.au(b);
                            Gg3.au(b);
                            cl();
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
                            final byte ax4 = Gg3.ax(b);
                            final int ar14 = Gg3.ar(b);
                            cl();
                            SoundManager.a(ax4, ar14);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.REDUCE_ATTACK_PRIORITY) {
                            client.iu = (Gg3.ar(b) == 1);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.SEND_PING) {
                            final int bd7 = Gg3.bd(b);
                            final int bd8 = Gg3.bd(b);
                            final El328 d3 = El328.d(Eu326.SEND_PING_REPLY, n272.s);
                            Gg3.a(d3.q, bd7);
                            Gg3.a(d3.q, bd8);
                            N272.e(n272, d3);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.EXECUTE_CLIENT_CHEAT) {
                            debugconsole.y(Gg3.au(b), Gg3.bd(b));
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.DEBUG_PATHFINDING_STATIC) {
                            Lk495.g().e(b);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.DEBUG_PATHFINDING_DYNAMIC) {
                            Lk495.g().j(b);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.NAVPOWER_DEBUG_RENDER_CHUNK) {
                            client.ni.g(b, n272.v);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.SCRIPT_MESSAGE) {
                            final Az399 q2 = ClientScriptMessaging.q(b);
                            G284.g(client.lq, q2.s.length);
                            cw(new K398(q2));
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.STATEEVENT_EVENTSBUFFER) {
                            Gf474.v(b);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.STATESTREAM_STATISTICS) {
                            if (LossyStateStreamProfiler.enabled) {
                                client.dv = LossyStateStreamStatistics.deserialise(b);
                            }
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.PHYSICSCONTROLDEBUGGER_ACTIVATE) {
                            Y192.e = (Gg3.ar(b) == 1);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.ADJUST_PHYSICS_LOOKAHEAD) {
                            final byte ax5 = Gg3.ax(b);
                            client.dz += ax5;
                            if (ax5 > 0) {
                                client.du = true;
                            }
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.SET_TARGET) {
                            client.as = Gg3.ak(b);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.SERVER_FACTS) {
                            client.d = Gg3.bd(b) + Gg3.bd(b) / 1000000.0;
                            client.q = Gg3.bd(b);
                            client.j = Gg3.bd(b);
                            n272.r = null;
                            return true;
                        }
                        if (n272.r == Ea395.MAPPEDUPDATE) {
                            while (b.v < n272.v) {
                                cq(Ey446.values()[Gg3.ar(b)]);
                            }
                            n272.r = null;
                            return true;
                        }
                        Ku323.g(((n272.r != null) ? n272.r.ordinal() : -1) + A412.q + ((n272.k != null) ? n272.k.ordinal() : -1) + A412.q + ((n272.i != null) ? n272.i.ordinal() : -1) + " " + n272.v, new RuntimeException());
                        ap();
                        return true;
                    }
                }
            }
        }
    }
    
    static final void ay() {
        client.la = false;
        client.lv = false;
    }
    
    public static final void bd() {
    }
    
    private static void bu(final Bh77 bh77, final Vector3 vector3, final Iterator iterator) {
        client.nh = new File(bh77.r).getName();
        for (int i = 0; i < N78.da(bh77); ++i) {
            try {
                final XElement dx = N78.dx(bh77, i);
                final GameEntity key = new GameEntity(iterator.next(), client.cj);
                client.mm.add(key);
                client.ca.put(key, new Ap386());
                XElement.bo(dx, key, vector3, new T404());
            }
            catch (Exception ex) {
                client.logger.error("", ex);
            }
        }
        for (int j = 0; j < N78.db(bh77); ++j) {
            final J113 dd = N78.dd(bh77, j);
            final L170 l170 = new L170(dd.ah, dd.d, dd.ah);
            SceneGraphNode.r(l170, vector3);
            client.mm.add(l170);
        }
        for (int k = 0; k < N78.dg(bh77); ++k) {
            final Ao74 er = N78.er(bh77, k);
            final D75 d75 = new D75(er.ah, er.ap, er.d);
            SceneGraphNode.r(d75, vector3);
            client.mm.add(d75);
        }
        if (bh77.j != null) {
            Scene.g(client.mm, bh77.j, vector3);
        }
        client.logger.debug("Building xmap from {}", bh77.r);
        if (bh77.b != null) {
            client.mm.q(bh77.b, vector3, bh77.r);
        }
        if (bh77.l != null) {
            Scene.j(client.mm, client.eg, bh77.l, bh77.r);
        }
        if (bh77.w != null) {
            Scene.e(client.mm, client.eg, bh77.w, bh77.r);
        }
        if (bh77.e != null) {
            Scene.h(client.mm, bh77.e);
        }
    }
    
    private static final void aj() {
        Lb33.g(Lb33.VariableSystem);
        try {
            for (int i = Fw152.g(client.jw, true); i != -1; i = Fw152.g(client.jw, false)) {
                cv(i);
            }
            for (L410 l410 = L410.q(); l410 != null; l410 = L410.q()) {
                final int s = L410.s(l410);
                final long b = L410.b(l410);
                if (s == 1) {
                    final VarBasicType list = client.fo.list((int)b);
                    client.jr.setVarValueInt(list, l410.g);
                    final player j = Gc330.j();
                    if (j != null) {
                        player.cj(j, list, l410.g);
                    }
                }
                else if (s == 2) {
                    final VarBasicType list2 = client.fo.list((int)b);
                    client.jr.setVarValue(list2, l410.j);
                    final player k = Gc330.j();
                    if (k != null) {
                        player.cj(k, list2, l410.j);
                    }
                }
            }
        }
        finally {
            Lb33.d(Lb33.VariableSystem);
        }
    }
    
    private static void bl(final int n, int n2) {
        if (debugconsole.isopen()) {
            return;
        }
        final int n3 = D150.j.e + D150.j.h + 2;
        if (client.lx) {
            String string;
            if (Al161.d < 0) {
                string = "Ping: not available";
            }
            else {
                string = "Ping: " + Al161.d + "ms";
            }
            F342.g(D150.s, string, n, n2, -1, -2013265920);
            n2 += n3;
            Lt501.d(Lt501.PING, Al161.d);
        }
        if (client.lf) {
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            for (int i = 0; i < Js5Archive.VALUES.length; ++i) {
                if (client.dx[i] != null) {
                    n4 += S136.i(client.dx[i]);
                    n5 += client.dx[i].s();
                    n6 += client.dx[i].b();
                }
            }
            final String string2 = "Cache:" + D281.g(n5 * 10000 / n4, 2, true, Language.EN) + "% (" + n6 * 100 / n4 + "%)";
            n2 += n3;
            F342.g(D150.s, string2, n, n2, -1, -2013265920);
            n2 += n3;
        }
        if (client.lr) {
            F342.g(D150.s, String.format("FPS: %.1f (%.2f ms) Average: %.1f Low: %.1f High: %.1f %s", GameShell3.fps, 1000.0 / GameShell3.fps, GameShell3.fpsAverage, GameShell3.fpsL, GameShell3.fpsH, (GameShell3.PauseCountFPS == 0.0) ? "" : "(Paused)"), n, n2, (GameShell3.fps < 30.0) ? -65536 : -256, -2013265920);
            n2 += n3;
            Lt501.d(Lt501.FPS, GameShell3.fps);
            Lt501.d(Lt501.FPSAverage, GameShell3.fpsAverage);
            Lt501.d(Lt501.FPSL, GameShell3.fpsL);
            Lt501.d(Lt501.FPSH, GameShell3.fpsH);
            Lt501.d(Lt501.FPS_TRACKING_PAUSED, GameShell3.PauseCountFPS);
            F342.g(D150.s, String.format("LPS: %.1f [%d]", GameShell3.lps, GameShell3.getspeed()), n, n2, -1, -2013265920);
            n2 += n3;
            Lt501.d(Lt501.LPS, GameShell3.lps);
            final String format = String.format("PPS: %.1f Lookahead: %d C-S: %d late: %d skipped: %d", GameShell3.pps, client.dz, client.ln, Lz409.b, Lz409.l);
            F342.g(D150.s, format, n, n2, -1, -2013265920);
            final boolean b = System.currentTimeMillis() - Lz409.w > 2.0f * Lq191.d() * 2000.0f;
            if (b || M188.q) {
                final int e = Kj334.e(D150.j, format + " ");
                String string3 = "";
                if (b) {
                    string3 = "NO DYNAMIC STATES ";
                }
                if (M188.q) {
                    string3 += "EXTRAPOLATING ";
                }
                F342.g(D150.s, string3, n + e, n2, -65536, -2013265920);
            }
            n2 += n3;
            Lt501.d(Lt501.PPS, GameShell3.pps);
            Lt501.d(Lt501.FRAMES_AHEAD, client.ln);
            if (client.lo == 0.0) {
                client.ld += client.kn;
                ++client.ky;
                if (client.ky > 0.0) {
                    client.kq = client.ld / client.ky;
                }
                if (client.kn > client.kc) {
                    client.kc = client.kn;
                    if (client.kn > 999.0f) {
                        client.kc = 999.0;
                    }
                }
                if (client.kn < client.kp) {
                    client.kp = client.kn;
                }
            }
            F342.g(D150.s, String.format("Server PPS: %.1f Average: %.1f Low: %.1f High: %.1f %s", client.kn, client.kq, client.kp, client.kc, (client.lo == 0.0) ? "" : "(Paused)"), n, n2, -256, -2013265920);
            n2 += n3;
            Lt501.d(Lt501.PPS_TRACKING_PAUSED, client.lo);
            Vector3 vector3 = Vector3.g;
            final player j = Gc330.j();
            if (j != null) {
                final PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(j, PlayerPhysicsComponent.class);
                if (playerPhysicsComponent != null && playerPhysicsComponent.q != null) {
                    vector3 = playerPhysicsComponent.getPosition(false);
                }
            }
            final float s = M188.s();
            F342.g(D150.s, "PhysFramesRemaining: " + s, n, n2, (s < 0.0f) ? -65536 : -1, -2013265920);
            n2 += n3;
            double degrees = Math.toDegrees(ClientScriptAPI.getCameraHeading());
            if (degrees < 0.0) {
                degrees += 360.0;
            }
            final String format2 = String.format("%5.0f %5.0f %5.0f  %d", vector3.x, vector3.y, vector3.z, (int)degrees);
            F342.g(D150.s, "LocXYZ CamFace: " + format2, n, n2, -1, -2013265920);
            n2 += n3 * 2;
            Lt501.g(Lt501.POSITION, format2);
        }
        if (client.lp) {
            F342.g(D150.s, "NPCs: " + client.q, n, n2, -32897, -2013265920);
            n2 += n3;
            Lt501.d(Lt501.NPCS, client.q);
            F342.g(D150.s, "Players: " + client.j, n, n2, -32897, -2013265920);
            n2 += n3;
            Lt501.d(Lt501.PLAYERS, client.j);
            F342.g(D150.s, String.format("CURRENT BOT: %s %s", debugconsole.d, debugconsole.g), n, n2, -256, -2013265920);
            n2 += n3;
            Lt501.g(Lt501.BOT_NUMBER, debugconsole.g);
            if (client.lm) {
                F342.g(D150.s, "Lua Data In: " + client.lq.j(), n, n2, -6316033, -2013265920);
                n2 += n3;
                F342.g(D150.s, "Lua Data Out: " + client.ls.j(), n, n2, -6316033, -2013265920);
                n2 += n3;
            }
            final double luaPoolSize = client.cj.getLuaPoolSize();
            String str;
            if (luaPoolSize >= 1024.0) {
                str = String.format("%.2fMb", luaPoolSize / 1024.0);
            }
            else {
                str = String.format("%.2fKb", luaPoolSize);
            }
            F342.g(D150.s, "CLua: " + str, n, n2, (luaPoolSize > 102400.0) ? -32897 : -8388737, -2013265920);
            n2 += n3;
            Lt501.d(Lt501.LUA_MEMORY, luaPoolSize / 1024.0);
            if (client.d > 0.0) {
                final double d = client.d;
                String str2;
                if (d >= 1024.0) {
                    str2 = String.format("%.2fMb", d / 1024.0);
                }
                else {
                    str2 = String.format("%.2fKb", d);
                }
                F342.g(D150.s, "SLua: " + str2, n, n2, (d > 102400.0) ? -32897 : -8388737, -2013265920);
                n2 += n3;
            }
            final Runtime runtime = Runtime.getRuntime();
            final double d2 = (runtime.totalMemory() - runtime.freeMemory()) / 1048576.0;
            final double d3 = runtime.maxMemory() / 1048576.0;
            final String format3 = String.format("%.2fMB/%.2fMB", d2, d3);
            F342.g(D150.s, "Java memory: " + format3, n, n2, (d2 / d3 > 0.9) ? -32897 : -8388737, -2013265920);
            n2 += n3;
            Lt501.g(Lt501.JAVA_MEMORY, format3);
            F342.g(D150.s, String.format("Unsafe: %.2fMb", Kc180.q() / 1048576.0), n, n2, -8388737, -2013265920);
            n2 += n3;
            F342.g(D150.s, String.format("Working set: %.2fMb (Peak: %.2fMb)", ProcessInfo.GetWorkingSetSize() / 1048576.0, ProcessInfo.GetPeakWorkingSetSize() / 1048576.0), n, n2, -8388737, -2013265920);
            n2 += n3;
            F342.g(D150.s, String.format("Commit charge: %.2fMb (Peak: %.2fMb)", ProcessInfo.GetCommitCharge() / 1048576.0, ProcessInfo.GetPeakCommitCharge() / 1048576.0), n, n2, -8388737, -2013265920);
            n2 += n3;
            if (client.mm != null) {
                F342.g(D150.s, String.format("SceneGraph: Nodes %d, GameEntities %d", Scene.m(client.mm), Scene.n(client.mm)), n, n2, -8388737, -2013265920);
                n2 += n3;
                Lt501.d(Lt501.SCENE_NODES, Scene.m(client.mm));
                Lt501.d(Lt501.GAME_ENTITIES, Scene.n(client.mm));
            }
        }
        if (client.lc) {
            final player k = Gc330.j();
            if (k != null) {
                final PlayerPhysicsComponent playerPhysicsComponent2 = (PlayerPhysicsComponent)GameEntity.eb(k, PlayerPhysicsComponent.class);
                if (playerPhysicsComponent2 != null && playerPhysicsComponent2.getAvatar(false) != null && playerPhysicsComponent2.getAvatar(false).b != null) {
                    n2 += n3;
                    n2 += n3;
                    final BulletVehicle b2 = playerPhysicsComponent2.getAvatar(false).b;
                    F342.g(D150.s, "Car speed: " + (int)((Vector3.f(b2.e.l()) - 0.2f) * 10.0f) / 10.0f + " m/s", n, n2, -1, -2013265920);
                    n2 += n3;
                    String string4 = new String();
                    for (int l = 0; l < BulletVehicle.g(b2); ++l) {
                        string4 = string4 + "    " + (int)(b2.s(l) * 10.0f) / 10.0f;
                    }
                    F342.g(D150.s, "Wheel slip status:" + string4, n, n2, -1, -2013265920);
                    n2 += n3;
                }
            }
        }
        if (client.lk) {
            F342.g(D150.s, String.format("ScrEvt: %d/s (Hndlrs-Act: %d, Cre: %d, Del: %d)", client.cd, ScriptManager.totalHandlersActive, ScriptManager.totalHandlersCreated, ScriptManager.totalHandlersDestroyed), n, n2, -256, -2013265920);
            n2 += n3;
            Lt501.d(Lt501.SCRIPTEVENTS_HANDLERSEXIST, ScriptManager.totalHandlersCreated - ScriptManager.totalHandlersDestroyed);
            Lt501.d(Lt501.SCRIPTEVENTS_HANDLERSACTIVE, ScriptManager.totalHandlersActive);
            final int n7 = (int)(System.nanoTime() / 1000000L);
            if (n7 >= client.cp) {
                client.cd = ScriptManager.totalHandlersTriggered;
                Lt501.d(Lt501.SCRIPTEVENTS_TRIGGERED, client.cd);
                ScriptManager.totalHandlersTriggered = 0;
                client.cp = n7 + 1000;
            }
        }
    }
    
    private static void bw() {
        if (!client.ms) {
            return;
        }
        client.li[client.le] = client.kn;
        client.md[client.le] = GameShell3.getPhysicsSpeed();
        client.me[client.le] = client.ln;
        client.ly[client.le] = client.mw;
        client.mw = 0;
        float l = 0.0f;
        final player j = Gc330.j();
        if (j != null) {
            final PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(j, PlayerPhysicsComponent.class);
            if (playerPhysicsComponent != null && playerPhysicsComponent.q != null) {
                l = M188.l(playerPhysicsComponent.q);
            }
        }
        client.mj[client.le] = l;
        client.le = (client.le + 1) % 200;
    }
    
    public static final void bj(final Vector3 vector3) {
        bk();
        client.gu = Ms517.d();
        client.gz = new Ll42();
        client.gz.d = new PhysicsWorldWrapper(client.gu.q(Lq191.d(), vector3));
        client.gz.d.d.at(Gn5.aq);
        client.gk = true;
    }
    
    public static void aq() {
        synchronized (client.bu) {
            if (GameShell3.fsframe != null) {
                return;
            }
            Container container;
            if (GameShell3.frame != null) {
                container = GameShell3.frame;
            }
            else {
                container = client.bu.getTopContainer();
            }
            GameShell3.frameWid = container.getSize().width;
            GameShell3.frameHei = container.getSize().height;
            if (container == GameShell3.frame) {
                final Insets insets = GameShell3.frame.getInsets();
                GameShell3.frameWid -= insets.left + insets.right;
                GameShell3.frameHei -= insets.top + insets.bottom;
            }
            if (a() != J160.SMALL) {
                ai();
            }
            else {
                GameShell3.canvasWid = client.ii;
                GameShell3.leftMargin = (GameShell3.frameWid - client.ii) / 2;
                GameShell3.canvasHei = client.iq;
                GameShell3.topMargin = 0;
            }
            GameShell3.canvas.setSize(GameShell3.canvasWid, GameShell3.canvasHei);
            o();
            if (container == GameShell3.frame) {
                final Insets insets2 = GameShell3.frame.getInsets();
                GameShell3.canvas.setLocation(insets2.left + GameShell3.leftMargin, insets2.top + GameShell3.topMargin);
            }
            else {
                GameShell3.canvas.setLocation(GameShell3.leftMargin, GameShell3.topMargin);
            }
            al();
        }
    }
    
    @Override
    public final void mainquit() {
        if (client.jr != null && client.jr.q) {
            ab();
        }
        Kc180.d(client.s);
        client.cj.purgeNative();
        H149.d();
        NativeResourceLoader.d();
        if (Hq338.g && GameShell3.fsframe != null) {
            Hq338.q(GameShell3.fsimp14, GameShell3.fsframe);
            GameShell3.fsframe = null;
        }
        Al161.q();
        N272.s(client.fx);
        SoundManager.b();
        W144.v(client.dm);
        L145.s(client.dj);
        try {
            debugconsole.d();
        }
        catch (Exception ex) {}
        if (DebugDialog.j != null) {
            DebugDialog.d(DebugDialog.j);
        }
    }
    
    public static final native void nativeUpdateGameplayStates(final long p0, final int p1, final float p2);
    
    public static final void br(final int n, final int n2, final Bt286 bt286, final float n3, final float n4, final int n5) {
        ay();
        if (client.gb != null && D285.d(client.gb) != n) {
            for (final Npc npc : client.ft.values()) {
                Npc.ca(npc);
                Scene.w(client.mm, npc);
            }
            client.ft.clear();
        }
        client.logger.debug("Got new build coordinates: {}, {}", n3, n4);
        client.gd = n3;
        client.ga = n4;
        z(n5);
        final int gn = client.gn;
        final int gj = client.gj;
        client.gn = 0;
        client.gj = 0;
        final int n6 = client.gn - gn;
        final int n7 = client.gj - gj;
        client.gb = new D285(n, n2, bt286, client.gn, client.gj, client.gq);
        if (n5 == 12) {
            for (final Npc npc2 : client.ft.values()) {
                SceneGraphNode.w(npc2, Vector3.i(npc2.getWorldTransform().trans, (float)n6, 0.0f, (float)n7));
            }
        }
        else {
            final int n8 = (client.gp - 1) * 4;
            final int n9 = (client.gy - 1) * 4;
            final Iterator<Npc> iterator3 = client.ft.values().iterator();
            while (iterator3.hasNext()) {
                final Npc npc3 = iterator3.next();
                final Vector3 i = Vector3.i(npc3.getWorldTransform().trans, (float)n6, 0.0f, (float)n7);
                SceneGraphNode.w(npc3, i);
                if ((int)i.x < 0 || (int)i.x > n8 || (int)i.z < 0 || (int)i.z > n9) {
                    Npc.ca(npc3);
                    Scene.w(client.mm, npc3);
                    iterator3.remove();
                }
            }
        }
        for (int j = 0; j < 2048; ++j) {
            final player e = Gc330.e(j);
            if (e != null) {
                SceneGraphNode.w(e, Vector3.i(e.getWorldTransform().trans, (float)n6, 0.0f, (float)n7));
            }
        }
        SoundManager.y();
        Hb335.g(client.jb);
    }
    
    private static final void ce() {
        final Bb4 e = Bb4.e(client.fx.b, Ed472.NPC);
        final Npc npc = client.ft.get(e);
        Npc.ca(npc);
        Scene.w(client.mm, npc);
        client.ft.remove(e);
    }
    
    public static final void bv(final boolean b) {
        SoundManager.r();
        client.ac;
    }
    
    public static final void bn() {
        client.ca.clear();
        final Iterator<Object> iterator = client.gb.b.iterator();
        for (final G289 g289 : D285.q(client.gb)) {
            if (G289.g(g289) != null) {
                bz(G289.g(g289), G289.d(g289) + client.gn, G289.q(g289) + client.gj);
                bu(G289.g(g289), new Vector3(G289.d(g289), 0.0f, G289.q(g289)), iterator);
            }
        }
        final Iterator<V385> iterator3 = (Iterator<V385>)client.ce.iterator();
        while (iterator3.hasNext()) {
            iterator3.next().j();
        }
        client.ce.clear();
        if (client.ca.isEmpty()) {
            bb();
            ba();
        }
        else {
            client.nw = 0;
            client.ng = System.currentTimeMillis();
            client.cj.event.triggerEvent("__onMapLoading", client.ca.size());
        }
    }
    
    public static boolean bg(final int n) {
        return client.gb != null && D285.d(client.gb) == n;
    }
    
    public static boolean cj(final String s) {
        return D236.e(client.ku.e, s) != -1;
    }
    
    public static void ba() {
        while (true) {
            final Ag389 ag389 = client.cv.peek();
            if (ag389 == null) {
                break;
            }
            if (ag389.h()) {
                break;
            }
            client.cv.remove();
            client.logger.debug("Running delayed {} now", ag389);
            Ag389.s(ag389);
        }
    }
    
    private static void c(final J160 j160, final J160 j161, final int n, final int n2, final boolean b) {
        if (Hq338.g && GameShell3.fsframe != null && (j161 != J160.FULLSCREEN || n != GameShell3.lastFullscreenWidth || n2 != GameShell3.lastFullscreenHeight)) {
            Hq338.q(GameShell3.fsimp14, GameShell3.fsframe);
            GameShell3.fsframe = null;
        }
        if (Hq338.g && j161 == J160.FULLSCREEN && GameShell3.fsframe == null) {
            GameShell3.fsframe = Hq338.d(GameShell3.fsimp14, n, n2, 0, 0);
            if (GameShell3.fsframe != null) {
                GameShell3.lastFullscreenWidth = n;
                GameShell3.lastFullscreenHeight = n2;
            }
        }
        if (j161 == J160.FULLSCREEN && (!Hq338.g || GameShell3.fsframe == null)) {
            c(j160, W159.g().j, -1, -1, true);
            return;
        }
        Container container;
        if (GameShell3.fsframe != null) {
            GameShell3.frameWid = n;
            GameShell3.frameHei = n2;
            container = GameShell3.fsframe;
        }
        else if (GameShell3.frame != null) {
            final Insets insets = GameShell3.frame.getInsets();
            GameShell3.frameWid = GameShell3.frame.getSize().width - (insets.left + insets.right);
            GameShell3.frameHei = GameShell3.frame.getSize().height - (insets.top + insets.bottom);
            container = GameShell3.frame;
        }
        else {
            container = client.bu.getTopContainer();
            GameShell3.frameWid = container.getSize().width;
            GameShell3.frameHei = container.getSize().height;
        }
        if (j161 != J160.SMALL) {
            ai();
        }
        else {
            GameShell3.canvasWid = client.ii;
            GameShell3.leftMargin = (GameShell3.frameWid - client.ii) / 2;
            GameShell3.canvasHei = client.iq;
            GameShell3.topMargin = 0;
        }
        GameShell3.canvas.setSize(GameShell3.canvasWid, GameShell3.canvasHei);
        if (H149.y) {
            Graphics.resetFromCanvas(GameShell3.canvas, 0, 0, 2, 0, 0, 0);
            H149.x = GameShell3.canvasHei;
            H149.p = GameShell3.canvasWid;
        }
        if (container == GameShell3.frame) {
            final Insets insets2 = GameShell3.frame.getInsets();
            GameShell3.canvas.setLocation(insets2.left + GameShell3.leftMargin, insets2.top + GameShell3.topMargin);
        }
        else {
            GameShell3.canvas.setLocation(GameShell3.leftMargin, GameShell3.topMargin);
        }
        if (j161 == J160.RESIZABLE || j161 == J160.FULLSCREEN) {
            client.id = true;
        }
        else {
            client.id = false;
        }
        if (client.fx.q != null && u(client.ac)) {
            ag();
        }
        GameShell3.fullredraw = true;
    }
    
    static void bt() {
        final long nanoTime = System.nanoTime();
        client.cj.event.triggerEvent("__onOptimizeBroadphase", "start");
        client.logger.debug("Optimising broadphase for interpolated world...");
        client.gz.d.d.au();
        client.cj.event.triggerEvent("__onOptimizeBroadphase", "stop");
        client.logger.debug("Optimize took: {}", System.nanoTime() - nanoTime);
        client.logger.debug("Baking world irradiance lighting...");
        IrradianceVolumes.initiateIrradianceBake();
    }
    
    private static void bz(final Bh77 bh77, final float n, final float n2) {
        if (bh77 != null) {
            client.gz.d.e(bh77.j, n, n2);
        }
    }
    
    public static void bc(final BroadcastStateAndEventsTypes$StatePayload broadcastStateAndEventsTypes$StatePayload, final GameEntity gameEntity, final Runnable runnable) {
        final SceneryConfig deserializeHelper = SceneryConfig.DeserializeHelper(broadcastStateAndEventsTypes$StatePayload.wire_data);
        client.logger.trace("Received spawny sceneryconfig for " + broadcastStateAndEventsTypes$StatePayload.broadcasterID);
        if (deserializeHelper.originalElementAddresses == null) {
            client.logger.trace("Hmmm, was asked to spawn something with a null originalElementAddresses array.  Ignoring.  Hopefully a proper payload will come along later.");
        }
        else {
            final Vector3 vector3 = new Vector3((float)(-client.gn), 0.0f, (float)(-client.gj));
            final Bn279 bn279 = (Bn279)GameEntity.ej(gameEntity, "spawnyMcSpawnins_AsynchronousTask");
            if (bn279 != null) {
                Bn279.j(bn279);
            }
            gameEntity.setProperty("spawnyMcSpawnins_AsynchronousTask", client.l.g(new Z392(deserializeHelper, gameEntity, vector3, runnable), client.gf, null));
        }
    }
    
    public static final boolean be(final N272 n272) {
        try {
            return bs(n272);
        }
        catch (IOException ex) {
            at();
            client.logger.error("Exception in TCP In. Reconnecting....", ex);
            return true;
        }
        catch (Exception ex2) {
            String str = ((n272.r != null) ? n272.r.ordinal() : -1) + A412.q + ((n272.k != null) ? n272.k.ordinal() : -1) + A412.q + ((n272.i != null) ? n272.i.ordinal() : -1) + " " + n272.v + A412.q + " ";
            for (int n273 = 0; n273 < n272.v && n273 < 50; ++n273) {
                str = str + n272.b.r[n273] + A412.q;
            }
            client.logger.error(str, ex2);
            Ku323.g(str, ex2);
            ap();
            return true;
        }
    }
    
    private static final void bx(final float gq) {
        if (client.gq == gq) {
            return;
        }
        client.gp = (client.gy = (int)Math.ceil(gq / 4.0f));
        client.gq = gq;
    }
    
    public static void cw(final Ag389 e) {
        if (client.cv.isEmpty() && !e.h()) {
            Ag389.s(e);
            return;
        }
        client.logger.debug("Delaying {}", e);
        client.cv.add(e);
    }
    
    public static final void cq(final Ey446 obj) {
        final Gs329 b = client.fx.b;
        if (obj == Ey446.LOC_CHANGE) {
            client.logger.trace("Received loc_change guid: {}, id: {}", b.bo(), Gg3.bd(b));
            return;
        }
        if (obj == Ey446.LOC_DEL) {
            client.logger.trace("Received loc_del guid: {}", b.bo());
            return;
        }
        if (obj == Ey446.LOC_CUSTOMISE) {
            b.bo();
            Gg3.ar(b);
            return;
        }
        if (obj == Ey446.LOC_ANIM) {
            final UUID bo = b.bo();
            final int bd = Gg3.bd(b);
            client.logger.trace("Received loc_anim guid: {}", bo);
            ca(bo, bd);
            return;
        }
        if (obj == Ey446.FMOD_PLAY_SOUND_AREA) {
            final int bd2 = Gg3.bd(b);
            final String bk = Gg3.bk(b);
            final int bd3 = Gg3.bd(b);
            final int bd4 = Gg3.bd(b);
            final int bd5 = Gg3.bd(b);
            client.logger.trace("Received PlaySoundArea");
            SoundManager.c(bd2, new Vector3((float)bd3, (float)bd4, (float)bd5), bk);
            return;
        }
        if (obj == Ey446.SOUND_AREA) {
            final float f = Gg3.bl(b) - client.gn;
            final float f2 = Gg3.bl(b) - client.gj;
            int au = Gg3.au(b);
            if (au == 65535) {
                au = -1;
            }
            final int ar = Gg3.ar(b);
            final int i = ar >> 4 & 0xF;
            final int j = ar & 0x7;
            final int ar2 = Gg3.ar(b);
            final int ar3 = Gg3.ar(b);
            final int au2 = Gg3.au(b);
            client.logger.trace("Received sound_area x: {}, z: {}, range: {}, synth: {}, loops: {}", new Object[] { f, f2, i, au, j });
            if (f >= 0.0f && f2 >= 0.0f && f < client.gp << 2 && f2 < client.gy << 2) {
                final int n = i + 1 << 2;
                final float x = Gc330.j().getWorldTransform().trans.x;
                final float z = Gc330.j().getWorldTransform().trans.z;
                if (x >= f - n && x <= f + n && z >= f2 - n && z <= f2 + n) {
                    SoundManager.x(au, j, ar2, ar3, f, f2, (float)(i << 2), au2);
                }
            }
            return;
        }
        if (obj == Ey446.SOUND_VORBIS_AREA) {
            Gg3.ar(b);
            final float f3 = Gg3.bl(b) - client.gn;
            final float f4 = Gg3.bl(b) - client.gj;
            int au3 = Gg3.au(b);
            if (au3 == 65535) {
                au3 = -1;
            }
            final int ar4 = Gg3.ar(b);
            final int k = ar4 >> 4 & 0xF;
            final int l = ar4 & 0x7;
            final int ar5 = Gg3.ar(b);
            final int ar6 = Gg3.ar(b);
            final int au4 = Gg3.au(b);
            client.logger.trace("Received sound_vorbis_area x: {},  z: {}, range: {}, vorbis: {}, loops: {}", new Object[] { f3, f4, k, au3, l });
            if (f3 >= 0.0f && f4 >= 0.0f && f3 < client.gp << 2 && f4 < client.gy << 2) {
                final int n2 = k + 1 << 2;
                final float x2 = Gc330.j().getWorldTransform().trans.x;
                final float z2 = Gc330.j().getWorldTransform().trans.z;
                if (x2 >= f3 - n2 && x2 <= f3 + n2 && z2 >= f4 - n2 && z2 <= f4 + n2) {
                    SoundManager.z(au3, l, ar5, ar6, f3, f4, (float)(k << 2), false, au4);
                }
            }
            return;
        }
        if (obj == Ey446.LOC_PREFETCH) {
            Gg3.bd(b);
            Gg3.ar(b);
            return;
        }
        if (obj == Ey446.TEXT_COORD) {
            Gg3.ar(b);
            final float n3 = Gg3.bl(b) - client.gn;
            final float n4 = Gg3.bl(b) - client.gj;
            final int au5 = Gg3.au(b);
            final int ar7 = Gg3.ar(b);
            final int ay = Gg3.ay(b);
            final String bk2 = Gg3.bk(b);
            try {
                final int int1 = Integer.parseInt(bk2);
                final int m = (int)bh(n3, n4);
                cm(n3, n4, ar7, au5, (int1 == m) ? -16711936 : -65536, int1 + ":" + m);
            }
            catch (NumberFormatException ex) {
                cm(n3, n4, ar7, au5, ay, bk2);
            }
            return;
        }
        Ku323.g("" + obj, new RuntimeException());
        ap();
    }
    
    private static final void cp() {
        final Gs329 b = client.fx.b;
        Gs329.h(b);
        final boolean b2 = b.s(1) == 1;
        Gs329.b(b);
        final Bb4 e = Bb4.e(b, Ed472.NPC);
        int au = -1;
        if (b2) {
            au = Gg3.au(b);
        }
        final float bl = Gg3.bl(b);
        final float bl2 = Gg3.bl(b);
        final int ar = Gg3.ar(b);
        final int au2 = Gg3.au(b);
        final float bl3 = Gg3.bl(b);
        final float bl4 = Gg3.bl(b);
        final float bl5 = Gg3.bl(b);
        final float bl6 = Gg3.bl(b);
        final Npc npc = client.ft.get(e);
        if (npc != null) {
            throw new IllegalStateException(npc.toString());
        }
        final Vector3 vector3 = new Vector3(bl3, bl4, bl5);
        final Quaternion d = Lr302.d(bl6);
        final Npc npc2 = new Npc(e);
        npc2.setObjectTranslation(bl3, bl4, bl5);
        client.mm.add(npc2);
        Npc.bn(npc2, bl, bl2, ar, au2);
        if (au >= 0) {
            XElement.ai.r(npc2, au, new O396(npc2, vector3, d));
        }
        if (au < 0 || Jt38.t(bl, bl2)) {
            npc2.bt(vector3, d);
        }
        client.ft.put(e, npc2);
        ScheduledMovementComponent.u(npc2.i, client.dq);
    }
    
    private static final void cd() {
        final Gs329 b = client.fx.b;
        Npc.bn((Npc)client.ft.get(Bb4.e(b, Ed472.NPC)), Gg3.bl(b), Gg3.bl(b), Gg3.ar(b), Gg3.au(b));
    }
    
    private static final void ck() {
        Gb471.g(client.fx.b);
    }
    
    public static final void bo(final int n, final int n2, final int n3, final int n4) {
        if (client.mm == null || Gc330.j() == null) {
            C340.e((float)n, (float)n2, (float)n3, (float)n4, -16777216);
            return;
        }
        Lb33.g(Lb33.GameDraw);
        try {
            ++client.hv;
            C340.y(n, n2, n3, n4);
            C340.j(n, n2, n + n3, n2 + n4);
            final ScriptCamera activeCamera = ScriptCamera.getActiveCamera();
            if (activeCamera != null) {
                H303.q(client.ax, SceneGraphNode.v(activeCamera).q());
                client.ar = activeCamera.ai;
                if (client.bd == null) {
                    ao();
                }
                final double n5 = activeCamera.getWorldTransform().trans.x - client.bd.x;
                final double n6 = activeCamera.getWorldTransform().trans.y - client.bd.y;
                final double n7 = activeCamera.getWorldTransform().trans.z - client.bd.z;
                if (n5 * n5 + n6 * n6 + n7 * n7 >= 100.0) {
                    ao();
                }
            }
            else {
                client.bd = null;
            }
            C340.d(client.ax, client.ar);
            try {
                if (!client.w && SoundManager.i) {
                    SoundManager.k();
                }
                Lk495.d(client.gn, client.gj);
                Lk495.q(Lk495.g());
            }
            catch (Exception ex) {
                client.logger.error("", ex);
            }
            SoundManager.r();
            if (client.ae && W144.e(client.dm) == 0) {
                client.ae = false;
            }
            if (client.ae) {
                C340.e((float)n, (float)n2, (float)n3, (float)n4, -16777216);
                client.lb = (float)GameShell3.renderFrameCount;
            }
            try {
                if (!client.w) {}
            }
            catch (Exception ex2) {
                client.logger.error("", ex2);
            }
        }
        finally {
            Lb33.d(Lb33.GameDraw);
        }
    }
    
    public static void ca(final UUID uuid, final int n) {
    }
    
    public static void cb() {
        final El328 d = El328.d(Eu326.TRANSMITVAR_VERIFYID, client.fx.s);
        Gg3.a(d.q, client.fe);
        N272.e(client.fx, d);
    }
    
    public static boolean cl() {
        ++client.fe;
        return client.ff = true;
    }
    
    static void ao() {
        XElementLibrary.y(XElement.ai);
        XElement.bm();
        final ScriptCamera activeCamera = ScriptCamera.getActiveCamera();
        if (activeCamera != null) {
            client.bd = activeCamera.getWorldTransform().trans;
        }
        else {
            client.bd = null;
        }
    }
    
    public static void cm(final float g, final float d, final int q, final int n, final int e, final String h) {
        final X390 x390 = new X390();
        x390.g = g;
        x390.d = d;
        x390.j = client.bj + n;
        x390.q = q;
        x390.h = h;
        x390.e = e;
        Hb335.d(client.jb, x390);
    }
    
    public static final void bk() {
        client.gk = false;
        if (client.gz.d != null) {
            PhysicsWorldWrapper.l(client.gz.d);
            client.gz.d = null;
        }
    }
    
    private static void w(final ArrayList list, final SceneGraphNode e) {
        if (e.g() != 0L) {
            list.add(e);
        }
        final Iterator<SceneGraphNode> iterator = (Iterator<SceneGraphNode>)e.ai().iterator();
        while (iterator.hasNext()) {
            w(list, iterator.next());
        }
    }
    
    public static int aa(final Vector3 vector3) {
        final ScriptCamera activeCamera = ScriptCamera.getActiveCamera();
        if (activeCamera != null) {
            final Vector3 trans = activeCamera.getWorldTransform().trans;
            final float n = vector3.x - trans.x;
            final float n2 = vector3.y - trans.y;
            final float n3 = vector3.z - trans.z;
            float n4 = n * n + n2 * n2 + n3 * n3;
            if (n4 < 1.0f) {
                n4 = 1.0f;
            }
            return (int)(1000000.0f / n4);
        }
        return 0;
    }
    
    public static boolean u(final int n) {
        return n == 11 || n == 12;
    }
    
    public static final void as() {
        client.fa.cacheRemoveSoftReferences();
        client.fl.cacheRemoveSoftReferences();
        client.fd.cacheRemoveSoftReferences();
        client.fi.cacheRemoveSoftReferences();
        client.fn.cacheRemoveSoftReferences();
        client.fm.cacheRemoveSoftReferences();
        client.fs.cacheRemoveSoftReferences();
        client.fh.cacheRemoveSoftReferences();
        client.en.cacheRemoveSoftReferences();
        Aw157.w(client.eq);
        Eq28.b(client.ex);
    }
    
    public static final void ad() {
        Lb33.g(Lb33.Physics);
        try {
            final player j = Gc330.j();
            final int e = client.dc.e();
            final int p = Lz409.p(Lz409.d);
            for (final player player : Gc330.h()) {
                player.bs(player);
                player.f.discardStates(e);
                if (p >= 0) {
                    player.c.discardStates(p);
                    player.ag.discardStates(p);
                }
                player.a.discardStates(e);
            }
            for (final Npc npc : client.ft.values()) {
                ScheduledMovementComponent.p(npc.i, e);
                if (p >= 0) {
                    ScheduledMovementComponent.x(npc.i, p);
                }
            }
            if (client.gz.d.d == null) {
                return;
            }
            Lz409.b(Lz409.d);
            Lz409.y();
            final int df = client.df;
            final int sumIDs = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(client.df, Lq191.j() - client.dz);
            if (client.la) {
                LuaNativeEvents.invokeOnUpdatePhysicsPre(client.cj.getLuaStateNativeRef());
                String string = "client";
                if (j != null) {
                    string = "client_" + j.aq;
                }
                for (final player player2 : Gc330.h()) {
                    int n = df;
                    if (player2 != j) {
                        n = sumIDs;
                    }
                    PlayerPhysicsComponent.p((PlayerPhysicsComponent)GameEntity.eb(player2, PlayerPhysicsComponent.class), n, false, true, string);
                    ((PlayerPhysicsComponent)GameEntity.eb(player2, PlayerPhysicsComponent.class)).i(n, false);
                }
                if (client.mm != null) {
                    final Iterator<ScheduledMovementComponent> iterator4 = (Iterator<ScheduledMovementComponent>)client.mm.x(ScheduledMovementComponent.class).iterator();
                    while (iterator4.hasNext()) {
                        ScheduledMovementComponent.h(iterator4.next(), df, false, true);
                    }
                }
                final ArrayList list = new ArrayList();
                client.gz.d.d.ak(list);
                Y192.q();
                client.gz.d.j(list);
                final Iterator<player> iterator5 = (Iterator<player>)Gc330.h().iterator();
                while (iterator5.hasNext()) {
                    ((PlayerPhysicsComponent)GameEntity.eb(iterator5.next(), PlayerPhysicsComponent.class)).u();
                }
                if (client.mm != null) {
                    final Iterator<ScheduledMovementComponent> iterator6 = (Iterator<ScheduledMovementComponent>)client.mm.x(ScheduledMovementComponent.class).iterator();
                    while (iterator6.hasNext()) {
                        ScheduledMovementComponent.l(iterator6.next());
                    }
                }
                LuaNativeEvents.invokeOnUpdatePhysicsPost(client.cj.getLuaStateNativeRef());
            }
            Lz409.v(client.df = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(client.df, 1));
            M188.e();
        }
        finally {
            Lb33.d(Lb33.Physics);
        }
    }
    
    public static void au() {
        if (client.fx.q != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - N272.g(client.fx) > 200L) {
                N272.e(client.fx, El328.d(Eu326.NO_TIMEOUT, client.fx.s));
                N272.d(client.fx, currentTimeMillis);
            }
        }
    }
    
    public static final void at() {
        client.fr = client.fx.q;
        client.fx.q = null;
        ap();
    }
    
    public static boolean r(final int n) {
        return n == 0;
    }
    
    public static void k() {
        client.cj.event.triggerEvent("__onStartup", null);
    }
    
    public static final void bp() {
        final Gs329 b = client.fx.b;
        final float bl = Gg3.bl(b);
        final float bl2 = Gg3.bl(b);
        final float bl3 = Gg3.bl(b);
        final int bd = Gg3.bd(b);
        final int bd2 = Gg3.bd(b);
        final Bt286 m = Bt286.m(b, Ed472.STATIC_SCENERY);
        bx(bl);
        br(bd2, bd, m, bl2, bl3, 12);
    }
    
    public static boolean x(final int n) {
        return n == 3 || n == 6;
    }
    
    private List cc(final List list) {
        final ArrayList<BufferedImage> list2 = new ArrayList<BufferedImage>();
        for (final String s : list) {
            BufferedImage read = null;
            try {
                URL input = this.getClass().getClassLoader().getResource(s);
                if (input == null) {
                    input = new File("../clientjar/" + s).toURI().toURL();
                }
                if (input != null) {
                    read = ImageIO.read(input);
                }
            }
            catch (IOException ex) {
                client.logger.debug("", ex);
            }
            list2.add(read);
        }
        return list2;
    }
    
    public static final void bm() {
        C340.q();
        client.hf = 0;
    }
    
    @Override
    public final void init() {
        if (!this.checkhost()) {
            return;
        }
        Z132.g("client.init()");
        for (final Ev579 ev579 : Ev579.values()) {
            final String parameter = this.getParameter(ev579.aq);
            if (parameter != null) {
                switch (Integer.parseInt(ev579.aq)) {
                    case 26: {
                        if (parameter.equalsIgnoreCase(A412.g)) {
                            client.k = true;
                            break;
                        }
                        client.k = false;
                        break;
                    }
                    case 29: {
                        Lf336.j = new Lx337();
                        Lf336.j.g = Integer.parseInt(parameter);
                        break;
                    }
                    case 27: {
                        client.t = (D123)E294.g(D123.class, Integer.parseInt(parameter));
                        if (client.t == D123.LOCAL) {
                            client.t = D123.WTWIP;
                            break;
                        }
                        if (!D123.d(client.t, G320.OFFICE) && client.t != D123.LIVE) {
                            client.t = D123.LIVE;
                            break;
                        }
                        break;
                    }
                    case 4: {
                        client.z = Gm479.g(Integer.parseInt(parameter));
                        if (client.z != Gm479.WIP && client.z != Gm479.RC && client.z != Gm479.BUILDLIVE && client.z != Gm479.LIVE) {
                            client.z = Gm479.LIVE;
                            break;
                        }
                        break;
                    }
                    case 5: {
                        client.m = Gd27.g(Integer.parseInt(parameter));
                        break;
                    }
                    case 6: {
                        client.n = Language.j(Integer.parseInt(parameter));
                        break;
                    }
                    case 7: {
                        client.f = Integer.parseInt(parameter);
                        break;
                    }
                    case 8: {
                        if (parameter.equalsIgnoreCase(A412.g)) {
                            client.i = true;
                            break;
                        }
                        client.i = false;
                        break;
                    }
                    case 9: {
                        client.c = parameter;
                        break;
                    }
                    case 10: {
                        client.o = parameter;
                        break;
                    }
                    case 28: {
                        if (parameter.equalsIgnoreCase(A412.g)) {
                            client.ip = (client.az = true);
                            break;
                        }
                        break;
                    }
                    case 11: {
                        client.a = Integer.parseInt(parameter);
                        break;
                    }
                    case 12: {
                        if (parameter.equalsIgnoreCase(A412.g)) {
                            client.ao = true;
                            break;
                        }
                        client.ao = false;
                        break;
                    }
                    case 13: {
                        if (parameter.equalsIgnoreCase(A412.g)) {
                            client.aa = true;
                            break;
                        }
                        client.aa = false;
                        break;
                    }
                    case 25: {
                        if (parameter.equalsIgnoreCase(A412.g)) {
                            client.an = true;
                            break;
                        }
                        client.an = false;
                        break;
                    }
                    case 14: {
                        if (parameter.equalsIgnoreCase(A412.g)) {
                            client.am = true;
                            break;
                        }
                        client.am = false;
                        break;
                    }
                    case 15: {
                        break;
                    }
                    case 16: {
                        break;
                    }
                    case 18: {
                        final byte[] q = G282.q(Mi507.g(parameter));
                        if (q.length < 16) {
                            client.ah = null;
                            break;
                        }
                        client.ah = new R273(q, false);
                        break;
                    }
                    case 30: {
                        final Gg3 gg3 = new Gg3(50);
                        Gg3.ag(gg3, Long.parseLong(parameter));
                        Gg3.ag(gg3, (long)(Math.random() * 9.223372036854776E18));
                        client.ah = new R273(gg3.r, true);
                        break;
                    }
                    case 17: {
                        client.ap.q = Integer.parseInt(parameter);
                        break;
                    }
                    case 20: {
                        client.ap.g = Long.parseLong(parameter);
                        break;
                    }
                    case 21: {
                        client.ap.d = parameter;
                        if (client.ap.d.length() > 50) {
                            client.ap.d = null;
                            break;
                        }
                        break;
                    }
                    case 22: {
                        if (parameter.equals(A412.g)) {
                            client.fw = true;
                            break;
                        }
                        client.fw = false;
                        break;
                    }
                    case 24: {
                        client.br = parameter;
                        break;
                    }
                    case 31: {
                        final int lastIndex = parameter.lastIndexOf(58);
                        client.af = parameter.substring(0, lastIndex);
                        client.av = Integer.parseInt(parameter.substring(lastIndex + 1));
                        System.out.println("Using alias server " + client.af + ":" + client.av);
                        break;
                    }
                    default: {
                        Ku323.g("Parameter not implemented in client: " + ev579.aq, new RuntimeException());
                        break;
                    }
                }
            }
        }
        if (client.m == Gd27.RUNESCAPE || client.m == Gd27.ALTERNATEREALITY || client.m == Gd27.TRANSFORMERS) {
            client.ii = 765;
            client.iq = 503;
        }
        else if (client.m == Gd27.STELLARDAWN) {
            client.ii = 640;
            client.iq = 480;
        }
        (client.bu = this).startApplet(new GameShell3$FrameParameters(client.ii, client.iq, client.ib, client.ij, client.m.s), client.m.h, client.z.h, 32 + client.z.s, Js5Archive.getRequiredArrayLength(), true, 1, 1, client.am);
    }
    
    private void s(final float n) {
        Lb33.g(Lb33.MainLoop);
        try {
            Lb33.g(Lb33.zMainLoopBeginning);
            try {
                Ko370.d();
                Hi86.q(client.lh);
                if (client.ac == 16) {
                    return;
                }
                Lb33.g(Lb33.NetStats);
                try {
                    client.hw += n;
                    client.hd = (int)(client.hw / 0.02f);
                    if (client.hd > 0) {
                        client.hw -= client.hd * 1 / 50.0f;
                    }
                    for (int i = 0; i < client.hd; ++i) {
                        ++client.bj;
                        if (client.bj % 1000 == 1) {
                            final GregorianCalendar gregorianCalendar = new GregorianCalendar();
                            client.hy = gregorianCalendar.get(11) * 600 + gregorianCalendar.get(12) * 10 + gregorianCalendar.get(13) / 6;
                            client.hl.setSeed(client.hy);
                        }
                        N272.h(client.fx);
                    }
                }
                finally {
                    Lb33.d(Lb33.NetStats);
                }
                t(this, n);
                if (client.dt != null) {
                    G137.j(client.dt);
                }
            }
            finally {
                Lb33.d(Lb33.zMainLoopBeginning);
            }
            Lb33.g(Lb33.zSoundManager);
            try {
                SoundManager.w();
            }
            finally {
                Lb33.d(Lb33.zSoundManager);
            }
            Lb33.g(Lb33.zEvents);
            try {
                if (client.cj != null) {
                    LuaNativeEvents.d(client.cj.getLuaStateNativeRef(), n);
                }
            }
            finally {
                Lb33.d(Lb33.zEvents);
            }
            Lb33.g(Lb33.XElementQueue);
            try {
                XElement.bd();
                if (XElement.ai != null) {
                    XElementLibrary.v(XElement.ai);
                }
            }
            finally {
                Lb33.d(Lb33.XElementQueue);
            }
            Lb33.g(Lb33.zDebug);
            try {
                if (client.cj != null && client.cj.luaConsole != null) {
                    client.cj.luaConsole.service();
                }
                if (Scripting.q() > 0) {
                    Scripting.e(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef());
                }
                if (debugconsole.isopen()) {
                    debugconsole.e();
                }
            }
            finally {
                Lb33.d(Lb33.zDebug);
            }
            if (r(client.ac)) {
                Lb33.g(Lb33.Loading);
                try {
                    Load.g();
                    doneslowupdate();
                }
                finally {
                    Lb33.d(Lb33.Loading);
                }
            }
            else if (y(client.ac)) {
                bf();
            }
            if (client.mm != null) {
                Scene.d(client.mm);
            }
            if (!y(client.ac)) {
                if (p(client.ac)) {
                    aw(this);
                    if (client.ac == 6) {
                        Lb33.g(Lb33.ProcessActiveLogin);
                        try {
                            final W274 j = Login.j(n);
                            if (j != null && j.g != E275.SUCCESS) {
                                if (j.q != null) {
                                    final Mf509 d = j.d;
                                    j.q.trigger(null, (d != null) ? Integer.valueOf(d.getId()) : null);
                                }
                                ap();
                            }
                        }
                        finally {
                            Lb33.d(Lb33.ProcessActiveLogin);
                        }
                    }
                }
                else if (u(client.ac)) {
                    ar(n);
                }
                else if (client.ac == 14 || client.ac == 15) {
                    Lb33.g(Lb33.Login);
                    try {
                        final W274 k = Login.j(n);
                        if (k != null && k.g != E275.SUCCESS) {
                            if (client.ac == 15) {
                                if (Lf336.h) {
                                    Lf336.d(Lf336.e.g, Lf336.e.d);
                                    Login.d();
                                }
                                else {
                                    ap();
                                }
                            }
                            else {
                                ap();
                            }
                        }
                    }
                    finally {
                        Lb33.d(Lb33.Login);
                    }
                }
            }
        }
        finally {
            Lb33.d(Lb33.MainLoop);
        }
    }
    
    public static void an(final Q79 q79, final String s) {
        final XElementLibrary ai = new XElementLibrary(client.lh, client.lw, q79, new Az669());
        if (s == null || client.w) {
            Hk84.d(client.lw, XElement.class, new Gv486(client.ek));
        }
        Hi86.p(client.lh, Fc454.class, new Gt488(client.em, "Material"));
        Hi86.p(client.lh, Skeleton.class, new Gt488(client.es, "Skeleton"));
        Hi86.p(client.lh, Fk353.class, new Gt488(client.eh, "Mesh"));
        Hi86.p(client.lh, XElement.class, new Gt488(client.ek, "Element"));
        Hi86.p(client.lh, Iz11.class, new Gt488(client.eo, "Physical Geometry"));
        Hi86.p(client.lh, T101.class, new Gt488(client.eb, "XArea"));
        Hi86.p(client.lh, Bh77.class, new Gt488(client.ef, "XMap"));
        Hi86.p(client.lh, Bj61.class, new Gu487(client.eg, "AnimSet", "Animation Set"));
        Hi86.u(client.lh, Fc454.class, Fc454.i);
        Hi86.u(client.lh, Skeleton.class, Skeleton.d);
        Hi86.u(client.lh, Fk353.class, Fk353.k);
        Hi86.u(client.lh, Iz11.class, Iz11.e);
        Hi86.u(client.lh, T101.class, T101.d);
        Hi86.u(client.lh, Bh77.class, Bh77.d);
        Hi86.u(client.lh, XElement.class, ai.s);
        Hi86.u(client.lh, Bj61.class, Bj61.d);
        XElement.ai = ai;
        if (s != null) {}
        final byte[] y = js5.y(client.eu, DefaultsGroup.ERROR.js5GroupId);
        if (y != null) {
            Hi86.d(client.lh, new Gg3(y));
        }
    }
    
    public static final void cv(final int n) {
        At476.d();
        final int clientCode = client.fd.list(n).clientCode;
        if (clientCode == 0) {
            return;
        }
        final int varValueInt = client.jw.getVarValueInt(client.fd.list(n));
        if (clientCode == 6) {
            client.jx = varValueInt;
        }
    }
    
    public static final void bq(final long n) {
        C340.q();
        client.hf = 0;
    }
    
    public static final void bf() {
        Lb33.g(Lb33.MapBuild);
        try {
            bv(false);
            if (!client.gb.g()) {
                return;
            }
            if (client.mm != null) {
                for (final player player : Gc330.h()) {
                    PlayerPhysicsComponent.l((PlayerPhysicsComponent)GameEntity.eb(player, PlayerPhysicsComponent.class));
                    player.ba = null;
                    client.mm.remove(player, true, false);
                }
                for (final Npc npc : client.ft.values()) {
                    Npc.cp(npc);
                    client.mm.remove(npc, true, false);
                }
                final Iterator<ScriptCamera> iterator3 = ClientScriptAPI.g.iterator();
                while (iterator3.hasNext()) {
                    client.mm.remove(iterator3.next(), true, false);
                }
            }
            final long g = Gz143.g();
            client.logger.debug("Profile: Starting...");
            ak();
            for (final player player2 : Gc330.h()) {
                if (GameEntity.ee(player2, PlayerPhysicsComponent.class)) {
                    player.co(player2);
                }
            }
            if (client.mm != null) {
                Scene.u(client.mm);
                client.mm = null;
            }
            Bv351.d(client.gf);
            client.gf = new Bv351();
            client.ca.clear();
            System.gc();
            client.mg = new E254();
            client.mm = new Scene(client.mg);
            At476.g(false);
            SoundManager.r();
            bv(true);
            client.logger.debug("Profile: Reset took: {} ms", Gz143.g() - g);
            client.logger.debug("Profile: Overworld ground build took: {} ms", Gz143.g() - Gz143.g());
            final long g2 = Gz143.g();
            bv(true);
            bn();
            client.logger.debug("Profile: Overworld location load took: {} ms", Gz143.g() - g2);
            final long g3 = Gz143.g();
            bv(true);
            client.logger.debug("Profile: Overworld finish ground took: {} ms", Gz143.g() - g3);
            final long g4 = Gz143.g();
            for (final player player3 : Gc330.h()) {
                client.mm.add(player3);
                if (GameEntity.ee(player3, PlayerPhysicsComponent.class)) {
                    player.cy(player3);
                }
            }
            for (final Npc npc2 : client.ft.values()) {
                client.mm.add(npc2);
                Npc.cd(npc2);
            }
            final Iterator<ScriptCamera> iterator7 = ClientScriptAPI.g.iterator();
            while (iterator7.hasNext()) {
                client.mm.add(iterator7.next());
            }
            SoundManager.r();
            if (GameShell3.getEnvironment() == GameShell3$Environment.APPLICATION && client.fx.q != null && client.ac == 12) {
                final El328 d = El328.d(Eu326.DETECT_MODIFIED_CLIENT, client.fx.s);
                Gg3.a(d.q, 1057001181);
                N272.e(client.fx, d);
            }
            if (client.ac == 4) {
                z(3);
            }
            else {
                z(11);
                if (client.fx.q != null) {
                    N272.e(client.fx, El328.d(Eu326.MAP_BUILD_COMPLETE, client.fx.s));
                }
            }
            SoundManager.r();
            ao();
            doneslowupdate();
            client.logger.debug("Profile: Final stage took: {} ms", Gz143.g() - g4);
            Gz143.g();
            if (client.gc) {
                debugconsole.addline(Long.toString(Gz143.g() - client.gv));
                client.gc = false;
            }
        }
        finally {
            Lb33.d(Lb33.MapBuild);
        }
    }
}
