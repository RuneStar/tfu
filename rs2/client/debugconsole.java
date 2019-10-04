/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.core.constants.D123;
import com.jagex.core.constants.Language;
import com.jagex.core.stringtools.general.J173;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler;
import com.jagex.game.runetek6.comms.statestream.packetchannel.NumberingPacketChannel;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.jnibindings.runetek6.StateManager;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.js5.W144;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.awt.Canvas;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.D150;
import rs2.client.J160;
import rs2.client.N272;
import rs2.client.client;
import rs2.client.login.Login;
import rs2.client.lua.ClientScriptAPI;
import rs2.shared.movement.I187;
import rs2.shared.movement.PhysicsQueryResultList;
import rs2.shared.movement.PhysicsWorldWrapper;
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
import tfu.Hx339;
import tfu.Ic327;
import tfu.If31;
import tfu.Kj334;
import tfu.Kt125;
import tfu.Lb33;
import tfu.Lf336;
import tfu.Ll42;
import tfu.Lq191;
import tfu.Lx337;
import tfu.Mk163;

@ScriptEntryClass(value="DebugConsole")
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public class debugconsole {
    private static int b;
    private static int commandcharpointer;
    private static int commandpointer;
    private static String currententry;
    public static String d;
    private static int e;
    public static String g;
    private static int h;
    private static final int j = 350;
    private static int l;
    private static final Logger logger;
    private static String[] p;
    private static boolean r;
    private static String[] s;
    private static final String t = "Failure";
    private static final String u = "\\/.:, _-+[]~@";
    private static long v;
    private static int w;
    private static FileOutputStream x;
    private static int y;
    private static final String z = "Success";

    @Be2
    @Bs1
    public static void externalKeyboardInput(int n, char c, int n2) {
        if (n == 84) {
            debugconsole.l(false);
        } else if (n == 80) {
            debugconsole.l(true);
        } else if (n == 83 && (n2 & 4) != 0) {
            String string = "lua_exec_server telecoordf " + StateManager.getOverrideCameraX() + " " + StateManager.getOverrideCameraY() + " " + StateManager.getOverrideCameraZ();
            El328 el328 = El328.d(Eu326.CLIENT_CHEAT, client.fx.s);
            Gs329.k(el328.q, string.length() + 3);
            Gs329.k(el328.q, 0);
            Gs329.k(el328.q, 0);
            el328.q.af(string);
            N272.e(client.fx, el328);
        } else if (n == 66 && (n2 & 4) != 0) {
            if (client.jc != null) {
                String string = "";
                for (int i = debugconsole.s.length - 1; i >= 0; --i) {
                    if (s[i] == null || s[i].length() <= 0) continue;
                    string = string + s[i] + '\n';
                }
                client.jc.setContents(new StringSelection(string), null);
            }
        } else if (n == 67 && (n2 & 4) != 0) {
            if (client.jc != null) {
                try {
                    String string;
                    Transferable transferable = client.jc.getContents(null);
                    if (transferable != null && (string = (String)transferable.getTransferData(DataFlavor.stringFlavor)) != null) {
                        String[] arrstring = StringTools.y(string, '\n');
                        debugconsole.j(arrstring);
                    }
                }
                catch (Exception exception) {}
            }
        } else if (n == 85 && commandcharpointer > 0) {
            currententry = currententry.substring(0, commandcharpointer - 1) + currententry.substring(commandcharpointer);
            --commandcharpointer;
        } else if (n == 101 && commandcharpointer < currententry.length()) {
            currententry = currententry.substring(0, commandcharpointer) + currententry.substring(commandcharpointer + 1);
        } else if (n == 96 && commandcharpointer > 0) {
            --commandcharpointer;
        } else if (n == 97 && commandcharpointer < currententry.length()) {
            ++commandcharpointer;
        } else if (n == 102) {
            commandcharpointer = 0;
        } else if (n == 103) {
            commandcharpointer = currententry.length();
        } else if (n == 104 && commandpointer < s.length) {
            ++commandpointer;
            debugconsole.h();
            commandcharpointer = currententry.length();
        } else if (n == 105 && commandpointer > 0) {
            --commandpointer;
            debugconsole.h();
            commandcharpointer = currententry.length();
        } else if (c >= ' ' && c < '\u007f') {
            currententry = currententry.substring(0, commandcharpointer) + c + currententry.substring(commandcharpointer);
            ++commandcharpointer;
        }
    }

    private static void j(String[] arrstring) {
        if (arrstring.length > 1) {
            for (int i = 0; i < arrstring.length; ++i) {
                if (arrstring[i].startsWith("pause")) {
                    int n = 5;
                    try {
                        n = Integer.parseInt(arrstring[i].substring(6));
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    debugconsole.addline("Pausing for " + n + " seconds...");
                    p = arrstring;
                    y = i + 1;
                    v = Gz143.g() + (long)(n * 1000);
                    return;
                }
                currententry = arrstring[i];
                debugconsole.l(false);
            }
        } else {
            currententry = currententry + arrstring[0];
            commandcharpointer += arrstring[0].length();
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
        if (debugconsole.isavailable()) {
            if (s == null) {
                debugconsole.g();
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
        for (int i = 0; i < s.length; ++i) {
            debugconsole.s[i] = "";
        }
        debugconsole.addline(Mk163.g(Mk163.DEBUG_CONSOLE_INFO, client.n));
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
            }
            catch (IOException iOException) {
                logger.error("", iOException);
            }
        }
        x = null;
    }

    private static void q(int n, int n2) {
        Vector3[] arrvector3 = ClientScriptAPI.getPhysicsRayFromPixelSpace(n, n2);
        PhysicsQueryResultList physicsQueryResultList = client.gz.d.raycast(arrvector3[0], arrvector3[1], Gn5.ENVIRONMENT_QUERY.ordinal(), Gj16.NONE.az, false, true);
        if (physicsQueryResultList.d.size() > 0) {
            Vector3 vector3 = ((L8)physicsQueryResultList.d.get((int)0)).d;
            Vector3 vector32 = Vector3.g(vector3.x, 1000.0f, vector3.z);
            Vector3 vector33 = Vector3.g(vector3.x, 0.0f, vector3.z);
            int n3 = Gj16.PLAYER.az + Gj16.GATE1_CLOSE.az + Gj16.GATE2_CLOSE.az + Gj16.GATE3_CLOSE.az + Gj16.GATE4_CLOSE.az + Gj16.GATE5_CLOSE.az + Gj16.GATE6_CLOSE.az + Gj16.GATE7_CLOSE.az + Gj16.GATE8_CLOSE.az + Gj16.GATE9_CLOSE.az + Gj16.GATE10_CLOSE.az + Gj16.GATE11_CLOSE.az + Gj16.GATE12_CLOSE.az + Gj16.GATE13_CLOSE.az + Gj16.GATE14_CLOSE.az;
            physicsQueryResultList = client.gz.d.raycast(vector32, vector33, Gn5.ENVIRONMENT_QUERY.ordinal(), n3, false, true);
            if (physicsQueryResultList.d.size() > 0) {
                vector3 = ((L8)physicsQueryResultList.d.get((int)0)).d;
                logger.debug("Teleport to : " + vector3);
                String string = "lua_exec_server telecoordf " + vector3.x + " " + (vector3.y + 10.0f) + " " + vector3.z;
                El328 el328 = El328.d(Eu326.CLIENT_CHEAT, client.fx.s);
                Gs329.k(el328.q, string.length() + 3);
                Gs329.k(el328.q, 0);
                Gs329.k(el328.q, 0);
                el328.q.af(string);
                N272.e(client.fx, el328);
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
                for (int i = debugconsole.y; i < p.length; ++i) {
                    if (p[i].startsWith("pause")) {
                        int n = 5;
                        try {
                            n = Integer.parseInt(p[i].substring(6));
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                        debugconsole.addline("Pausing for " + n + " seconds...");
                        y = i + 1;
                        v = Gz143.g() + (long)(n * 1000);
                        Lb33.d(Lb33.DebugConsole);
                        return;
                    }
                    currententry = p[i];
                    debugconsole.l(false);
                }
                y = -1;
            }
            Lb33.d(Lb33.DebugConsole);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.DebugConsole);
            throw throwable;
        }
    }

    public static native void initNative();

    private static boolean b(String string, int n, boolean bl, String string2) {
        try {
            return Scripting.matchLuaGlobal(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), string, n, bl, string2);
        }
        catch (Exception exception) {
            logger.error("", exception);
            return false;
        }
    }

    @Be2
    @Bs1
    public static void externalMouseClick(int n, int n2, int n3) {
        if (n3 == 9) {
            logger.debug("Teleport: " + n + "," + n2);
            debugconsole.q(n, n2);
        }
    }

    private static void h() {
        if (commandpointer > 0) {
            int n = 0;
            for (int i = 0; i < s.length; ++i) {
                if (s[i].indexOf("--> ") == -1 || ++n != commandpointer) continue;
                currententry = s[i].substring(s[i].indexOf(62) + 2);
                break;
            }
        } else {
            currententry = "";
        }
    }

    static {
        g = "";
        d = "";
        logger = LoggerFactory.getLogger(debugconsole.class);
        b = 0;
        l = 0;
        currententry = "";
        commandpointer = 0;
        commandcharpointer = 0;
        w = 0;
        r = false;
        y = -1;
    }

    private static void l(boolean bl) {
        if (currententry.length() == 0) {
            return;
        }
        if (bl && (currententry.startsWith("lua ") || currententry.startsWith("luas ") || currententry.startsWith("lua_exec ") || currententry.startsWith("lua_exec_server "))) {
            int n = currententry.indexOf(32);
            if (n > 1 && debugconsole.b(currententry.substring(n + 1), commandcharpointer - n - 1, false, currententry.substring(0, n))) {
                return;
            }
            return;
        }
        debugconsole.addline("--> " + currententry);
        debugconsole.v(currententry, false, bl);
        commandpointer = 0;
        if (!bl) {
            commandcharpointer = 0;
            currententry = "";
        }
    }

    @Bs1
    @Be2
    public static void addline(String string) {
        if (s == null) {
            debugconsole.g();
        }
        client.kb.setTime(new Date(Gz143.g()));
        int n = client.kb.get(11);
        int n2 = client.kb.get(12);
        int n3 = client.kb.get(13);
        String string2 = Integer.toString(n / 10) + n % 10 + ":" + n2 / 10 + n2 % 10 + ":" + n3 / 10 + n3 % 10;
        String[] arrstring = StringTools.y(string, '\n');
        for (int i = 0; i < arrstring.length; ++i) {
            for (int j = debugconsole.b; j > 0; --j) {
                debugconsole.s[j] = s[j - 1];
            }
            debugconsole.s[0] = string2 + ": " + arrstring[i];
            if (x != null) {
                try {
                    x.write(J173.j(s[0] + "\n"));
                }
                catch (IOException iOException) {
                    logger.error("", iOException);
                }
            }
            if (b >= s.length - 1) continue;
            ++b;
            if (l <= 0) continue;
            ++l;
        }
    }

    @Be2
    @Bs1
    public static void externalMouseInput(int n) {
        if (n != 0) {
            if ((l += n) >= b) {
                l = b - 1;
            }
            if (l < 0) {
                l = 0;
            }
        }
    }

    static String r(String string) {
        int n;
        String string2 = null;
        int n2 = string.indexOf("--> ");
        if (n2 >= 0) {
            string2 = string.substring(0, n2 + 4);
            string = string.substring(n2 + 4);
        }
        if (string.startsWith("directlogin ") && (n = string.indexOf(" ", "directlogin ".length())) >= 0) {
            int n3 = string.length();
            string = string.substring(0, n) + " ";
            for (int i = n + 1; i < n3; ++i) {
                string = string + "*";
            }
        }
        if (string2 != null) {
            return string2 + string;
        }
        return string;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void ExecuteCommand(String string, boolean bl, boolean bl2) {
        debugconsole.v(string, bl, bl2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void PauseFPSTrack(int n) {
        GameShell3.PauseCountFPS = n == 0 ? 0.0 : 1.0;
    }

    @Be2
    @Bs1
    public static boolean isopen() {
        return r;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetBotNameNumber(String string, String string2) {
        g = string;
        d = string2;
    }

    public static void y(int n, int n2) {
        if (n == 1) {
            throw new Error();
        }
        if (n == 2) {
            throw new OutOfMemoryError();
        }
        try {
            if (n == 3) {
                debugconsole.close();
            } else if (n == 4) {
                debugconsole.addline("" + GameShell3.fps);
            } else if (n == 6) {
                client.bx = true;
            } else if (n == 7) {
                client.bx = false;
            } else if (n == 8) {
                Hb335.g(client.jb);
            } else if (n == 9) {
                client.as();
                for (int i = 0; i < 10; ++i) {
                    System.gc();
                }
                Runtime runtime = Runtime.getRuntime();
                int n3 = (int)((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
                debugconsole.addline("" + n3);
            } else if (n == 11) {
                debugconsole.addline(Kt125.d().b() ? "Success" : "Failure");
            } else if (n == 13) {
                Lx337.q(Lf336.q);
            } else if (n == 14) {
                W144.v(client.dm);
            } else if (n == 17) {
                W144.r(client.dm);
            } else if (n == 15) {
                GameShell3.canvas.setLocation(50, 50);
            } else if (n == 16) {
                GameShell3.canvas.setLocation(GameShell3.leftMargin, GameShell3.topMargin);
            } else if (n == 19) {
                client.by();
            } else if (n == 20) {
                client.gv = Gz143.g();
                client.gc = true;
                client.by();
            } else if (n == 21) {
                Vector3 vector3 = Gc330.j().getWorldTransform().trans;
                debugconsole.addline(((int)vector3.x >> 2) + " " + ((int)vector3.z >> 2));
            } else if (n == 26) {
                client.ac();
            } else if (n == 27) {
                client.bz = 0;
                client.by();
            } else if (n == 28) {
                client.bz = 1;
                client.by();
            } else if (n == 29) {
                client.bz = 2;
                client.by();
            } else if (n == 42) {
                client.at();
            } else if (n == 31) {
                client.dc.g(null).d.at(Gn5.aq);
            } else if (n == 32) {
                client.dc.g(null).d.at(Gn5.ai);
            } else if (n == 33) {
                client.dc.g(null).d.at(Gn5.al);
            } else if (n == 34) {
                client.dc.g(null).d.aw();
            } else if (n == 35) {
                client.dc.g(null).d.ar();
            } else if (n == 36) {
                Ap127.d = !Ap127.d;
            } else if (n == 37) {
                if (n2 > 0) {
                    Ap127.q = n2;
                }
            } else if (n == 38) {
                if (n2 > 0) {
                    Ap127.j = n2;
                }
            } else if (n == 40) {
                DiscreteDynamicsWorld.ax(client.dc.g(null).d, n2);
            } else if (n == 41) {
                client.lc = !client.lc;
            }
        }
        catch (Exception exception) {
            debugconsole.addline(Mk163.g(Mk163.DEBUG_CONSOLE_ERROR, client.n));
            return;
        }
    }

    public static void v(String string, boolean bl, boolean bl2) {
        try {
            if (string.equalsIgnoreCase("commands") || string.equalsIgnoreCase("help")) {
                debugconsole.addline("commands - This command");
                debugconsole.addline("cls - Clear console");
                debugconsole.addline("displayfps - Toggle FPS and other information");
                debugconsole.addline("renderer - Print graphics renderer information");
                debugconsole.addline("heap - Print java memory information");
                debugconsole.addline("getcamerapos - Print location and direction of camera for use in bug reports");
                return;
            }
            if (string.equalsIgnoreCase("cls")) {
                b = 0;
                l = 0;
                return;
            }
            if (string.equalsIgnoreCase("displayfps")) {
                boolean bl3 = client.bx = !client.bx;
                if (client.bx) {
                    debugconsole.addline("FPS on");
                } else {
                    debugconsole.addline("FPS off");
                }
                return;
            }
            if (string.equals("heap")) {
                debugconsole.addline("Heap: " + GameShell3.maxmemory + "MB");
                return;
            }
        }
        catch (Exception exception) {
            debugconsole.addline(Mk163.g(Mk163.DEBUG_CONSOLE_ERROR, client.n));
            logger.error("", exception);
            return;
        }
        if (client.t != D123.LIVE || client.ik >= 2) {
            try {
                Object object;
                if (string.equalsIgnoreCase("wm1")) {
                    client.f(J160.SMALL, -1, -1, false);
                    if (client.a() == J160.SMALL) {
                        debugconsole.addline("Success");
                    } else {
                        debugconsole.addline("Failure");
                    }
                    return;
                }
                if (string.equalsIgnoreCase("wm2")) {
                    client.f(J160.RESIZABLE, -1, -1, false);
                    if (client.a() == J160.RESIZABLE) {
                        debugconsole.addline("Success");
                    } else {
                        debugconsole.addline("Failure");
                    }
                    return;
                }
                if (Hq338.g && string.equalsIgnoreCase("wm3")) {
                    client.f(J160.FULLSCREEN, 1024, 768, false);
                    if (client.a() == J160.FULLSCREEN) {
                        debugconsole.addline("Success");
                    } else {
                        debugconsole.addline("Failure");
                    }
                    return;
                }
                if (string.equalsIgnoreCase("clientdrop")) {
                    if (client.ac == 11) {
                        client.at();
                    } else if (client.ac == 12) {
                        client.fx.o = true;
                    }
                    return;
                }
                if (string.equalsIgnoreCase("breakcon")) {
                    if (client.fx.q != null) {
                        client.fx.q.s();
                    }
                    W144.y(client.dm);
                    return;
                }
                if (string.startsWith("directlogin")) {
                    String[] arrstring = StringTools.p(string.substring(12), ' ');
                    if (arrstring.length == 2) {
                        Login.requestLoginWithUsername(arrstring[0], arrstring[1], null);
                    }
                    return;
                }
                if (string.startsWith("snlogin ")) {
                    String[] arrstring = StringTools.p(string.substring(8), ' ');
                    int n = Integer.parseInt(arrstring[0]);
                    Login.requestLoginFromSocialNetwork(n, null);
                    return;
                }
                if (string.startsWith("setoutput ")) {
                    File file = new File(string.substring(10));
                    if (file.exists() && (file = new File(string.substring(10) + "." + Gz143.g() + ".log")).exists()) {
                        debugconsole.addline("file already exists!");
                        return;
                    }
                    if (x != null) {
                        x.close();
                        x = null;
                    }
                    try {
                        x = new FileOutputStream(file);
                    }
                    catch (FileNotFoundException fileNotFoundException) {
                        debugconsole.addline("Could not create " + file.getName());
                        return;
                    }
                    catch (SecurityException securityException) {
                        debugconsole.addline("Cannot write to " + file.getName());
                        return;
                    }
                    return;
                }
                if (string.equals("closeoutput")) {
                    if (x != null) {
                        x.close();
                    }
                    x = null;
                    return;
                }
                if (string.startsWith("runscript ")) {
                    object = new File(string.substring(10));
                    if (!((File)object).exists()) {
                        debugconsole.addline("No such file");
                        return;
                    }
                    byte[] arrby = If31.q((File)object);
                    if (arrby == null) {
                        debugconsole.addline("Failed to read file");
                        return;
                    }
                    String[] arrstring = StringTools.y(StringTools.v(J173.h(arrby), '\r', ""), '\n');
                    debugconsole.j(arrstring);
                }
                if (string.startsWith("lps ")) {
                    int n = StringTools.j(string.substring(4));
                    GameShell3.setspeed(n);
                    debugconsole.addline("Set logic rate to " + n);
                    return;
                }
                if (string.equalsIgnoreCase("physicsreg")) {
                    client.kx = !client.kx;
                    debugconsole.addline("Physics regulation " + (client.kx ? "on" : "off"));
                    return;
                }
                if (string.startsWith("lookahead ")) {
                    int n = Integer.parseInt(string.substring("lookahead ".length()));
                    if (n > client.dz) {
                        client.du = true;
                    }
                    client.dz = n;
                    debugconsole.addline("Set client lookahead to " + n);
                    return;
                }
                if (client.ac == 11) {
                    object = El328.d(Eu326.CLIENT_CHEAT, client.fx.s);
                    Gs329.k(((El328)object).q, string.length() + 3);
                    Gs329.k(((El328)object).q, bl ? 1 : 0);
                    Gs329.k(((El328)object).q, bl2 ? 1 : 0);
                    ((El328)object).q.af(string);
                    N272.e(client.fx, (El328)object);
                    if (!Ap127.d) {
                        logger.info("->server: {}", (Object)string);
                    }
                }
                if (string.startsWith("cyclerate ")) {
                    Lq191.q(StringTools.j(string.substring(4)));
                    return;
                }
                if (string.equals("ssprofile")) {
                    LossyStateStreamProfiler.enabled = !LossyStateStreamProfiler.enabled;
                    debugconsole.addline("Client-side ssprofile " + (LossyStateStreamProfiler.enabled ? "on" : "off"));
                    return;
                }
                if (string.equals("udploss")) {
                    debugconsole.addline("Client UDP loss: " + client.dw.getUnreceivedCount() + "/" + client.dw.getReceivedCount());
                    return;
                }
            }
            catch (Exception exception) {
                debugconsole.addline(Mk163.g(Mk163.DEBUG_CONSOLE_ERROR, client.n));
                logger.error("", exception);
                return;
            }
        }
        if (client.ac != 11) {
            debugconsole.addline(Mk163.g(Mk163.DEBUG_CONSOLE_UNKNOWNCOMMAND, client.n) + string);
            logger.debug(string);
        }
    }

    public static void s(String string) {
        currententry = string;
        commandcharpointer = currententry.length();
    }

    public static void w() {
        int n;
        C340.j(0, 0, GameShell3.canvasWid, 350);
        C340.b(0.0f, 0.0f, GameShell3.canvasWid, 350.0f, w << 24 | 0x332277, Fb341.BLEND_NORMAL);
        int n2 = 350 / h;
        if (b > 0) {
            n = 346 - h - 4;
            int n3 = n2 * n / (n2 + b - 1);
            int n4 = 4;
            if (b > 1) {
                n4 += (b - 1 - l) * (n - n3) / (b - 1);
            }
            C340.b(GameShell3.canvasWid - 16, n4, 12.0f, n3, w << 24 | 0x332277, Fb341.BLEND_ADDITIVE);
            for (int i = debugconsole.l; i < l + n2 && i < b; ++i) {
                String[] arrstring = StringTools.y(s[i], '\b');
                int n5 = (GameShell3.canvasWid - 8 - 16) / arrstring.length;
                for (int j = 0; j < arrstring.length; ++j) {
                    int n6 = 8 + j * n5;
                    C340.j(n6, 0, n6 + n5 - 8, 350);
                    int n7 = -4144960;
                    String string = debugconsole.r(arrstring[j]);
                    if (string.length() >= 15) {
                        if (string.length() >= 17 && string.substring(10, 17).equals("--> lua")) {
                            n7 = -128;
                        } else if (string.substring(10, 14).equals("--> ")) {
                            n7 = -64;
                        } else if (string.length() >= 23 && string.substring(10, 23).equals("Lua> [string ")) {
                            n7 = -32640;
                        } else if (string.length() >= 32 && string.substring(10, 32).equals("....Lua Stacktrace....")) {
                            n7 = -28528;
                        } else if (string.length() >= 16 && string.substring(10, 16).equals("   at ")) {
                            n7 = -28528;
                        } else if (string.substring(10, 15).equals("Lua> ")) {
                            n7 = -8323200;
                        }
                    }
                    F342.g(D150.b, string, n6, 350 - e - 2 - D150.e.h - (i - l) * h, n7, -16777216);
                }
            }
        }
        F342.d(D150.s, (client.w ? "" : "Build: ") + 1 + " " + 1, GameShell3.canvasWid - 25, 330, -1, -16777216);
        C340.j(0, 0, GameShell3.canvasWid, 350);
        C340.h(0.0f, 350 - e, GameShell3.canvasWid, -1);
        F342.g(D150.l, "--> " + debugconsole.r(currententry), 10, 350 - D150.h.h - 1, -1, -16777216);
        if (GameShell3.focus) {
            n = -1;
            if (client.bj % 30 > 15) {
                n = 16777215;
            }
            C340.s(10 + Kj334.e(D150.h, "--> " + debugconsole.r(currententry).substring(0, commandcharpointer)), 350 - D150.h.h - 11, 12.0f, n);
        }
        C340.q();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void ResetPPSHighLow() {
        client.kp = 9.9999999E7;
        client.kc = 0.0;
        client.kq = 0.0;
        client.ld = 0.0;
        client.ky = 0.0;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void PausePPSTrack(int n) {
        client.lo = n == 0 ? 0.0 : 1.0;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void ResetFPSHighLow() {
        GameShell3.fpsL = 9.9999999E7;
        GameShell3.fpsH = 0.0;
        GameShell3.fpsAverage = 0.0;
        GameShell3.fpsTotal = 0.0;
        GameShell3.fpsCount = 0.0;
    }
}

