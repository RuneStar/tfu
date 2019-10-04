// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import tfu.Kj334;
import tfu.F342;
import tfu.Fb341;
import tfu.C340;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler;
import tfu.Lq191;
import tfu.If31;
import java.io.FileNotFoundException;
import java.io.File;
import com.jagex.game.runetek6.event.EventHandler;
import rs2.client.login.Login;
import tfu.Hq338;
import com.jagex.core.constants.D123;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import tfu.Ap127;
import tfu.Gc330;
import com.jagex.js5.W144;
import tfu.Lx337;
import tfu.Lf336;
import tfu.Kt125;
import tfu.Hb335;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.core.stringtools.general.J173;
import java.util.Date;
import org.slf4j.LoggerFactory;
import com.jagex.jnibindings.runetek6.Scripting;
import tfu.Lb33;
import rs2.shared.movement.PhysicsQueryResultList;
import com.jagex.maths.Vector3;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import tfu.Gj16;
import tfu.Gn5;
import rs2.client.lua.ClientScriptAPI;
import java.io.IOException;
import tfu.Mk163;
import tfu.Gz143;
import com.jagex.core.stringtools.general.StringTools;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import tfu.Gg3;
import tfu.El328;
import tfu.Eu326;
import com.jagex.jnibindings.runetek6.StateManager;
import java.io.FileOutputStream;
import org.slf4j.Logger;
import tfu.Be2;
import tfu.Bs1;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("DebugConsole")
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public class debugconsole
{
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
    public static void externalKeyboardInput(final int n, final char c, final int n2) {
        if (n == 84) {
            l(false);
        }
        else if (n == 80) {
            l(true);
        }
        else if (n == 83 && (n2 & 0x4) != 0x0) {
            final String string = "lua_exec_server telecoordf " + StateManager.getOverrideCameraX() + " " + StateManager.getOverrideCameraY() + " " + StateManager.getOverrideCameraZ();
            final El328 d = El328.d(Eu326.CLIENT_CHEAT, client.fx.s);
            Gg3.k(d.q, string.length() + 3);
            Gg3.k(d.q, 0);
            Gg3.k(d.q, 0);
            d.q.af(string);
            N272.e(client.fx, d);
        }
        else if (n == 66 && (n2 & 0x4) != 0x0) {
            if (client.jc != null) {
                String string2 = "";
                for (int i = debugconsole.s.length - 1; i >= 0; --i) {
                    if (debugconsole.s[i] != null && debugconsole.s[i].length() > 0) {
                        string2 = string2 + debugconsole.s[i] + '\n';
                    }
                }
                client.jc.setContents(new StringSelection(string2), null);
            }
        }
        else if (n == 67 && (n2 & 0x4) != 0x0) {
            if (client.jc != null) {
                try {
                    final Transferable contents = client.jc.getContents(null);
                    if (contents != null) {
                        final String s = (String)contents.getTransferData(DataFlavor.stringFlavor);
                        if (s != null) {
                            j(StringTools.y(s, '\n'));
                        }
                    }
                }
                catch (Exception ex) {}
            }
        }
        else if (n == 85 && debugconsole.commandcharpointer > 0) {
            debugconsole.currententry = debugconsole.currententry.substring(0, debugconsole.commandcharpointer - 1) + debugconsole.currententry.substring(debugconsole.commandcharpointer);
            --debugconsole.commandcharpointer;
        }
        else if (n == 101 && debugconsole.commandcharpointer < debugconsole.currententry.length()) {
            debugconsole.currententry = debugconsole.currententry.substring(0, debugconsole.commandcharpointer) + debugconsole.currententry.substring(debugconsole.commandcharpointer + 1);
        }
        else if (n == 96 && debugconsole.commandcharpointer > 0) {
            --debugconsole.commandcharpointer;
        }
        else if (n == 97 && debugconsole.commandcharpointer < debugconsole.currententry.length()) {
            ++debugconsole.commandcharpointer;
        }
        else if (n == 102) {
            debugconsole.commandcharpointer = 0;
        }
        else if (n == 103) {
            debugconsole.commandcharpointer = debugconsole.currententry.length();
        }
        else if (n == 104 && debugconsole.commandpointer < debugconsole.s.length) {
            ++debugconsole.commandpointer;
            h();
            debugconsole.commandcharpointer = debugconsole.currententry.length();
        }
        else if (n == 105 && debugconsole.commandpointer > 0) {
            --debugconsole.commandpointer;
            h();
            debugconsole.commandcharpointer = debugconsole.currententry.length();
        }
        else if (c >= ' ' && c < '\u007f') {
            debugconsole.currententry = debugconsole.currententry.substring(0, debugconsole.commandcharpointer) + c + debugconsole.currententry.substring(debugconsole.commandcharpointer);
            ++debugconsole.commandcharpointer;
        }
    }
    
    private static void j(final String[] p) {
        if (p.length > 1) {
            for (int i = 0; i < p.length; ++i) {
                if (p[i].startsWith("pause")) {
                    int int1 = 5;
                    try {
                        int1 = Integer.parseInt(p[i].substring(6));
                    }
                    catch (Exception ex) {}
                    addline("Pausing for " + int1 + " seconds...");
                    debugconsole.p = p;
                    debugconsole.y = i + 1;
                    debugconsole.v = Gz143.g() + int1 * 1000;
                    return;
                }
                debugconsole.currententry = p[i];
                l(false);
            }
        }
        else {
            debugconsole.currententry += p[0];
            debugconsole.commandcharpointer += p[0].length();
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
            if (debugconsole.s == null) {
                g();
            }
            debugconsole.r = true;
            debugconsole.w = 0;
            client.ms = false;
        }
    }
    
    private static void g() {
        debugconsole.e = D150.h.e + D150.h.h + 2;
        debugconsole.h = D150.e.e + D150.e.h + 2;
        debugconsole.s = new String[500];
        for (int i = 0; i < debugconsole.s.length; ++i) {
            debugconsole.s[i] = "";
        }
        addline(Mk163.g(Mk163.DEBUG_CONSOLE_INFO, client.n));
    }
    
    @Be2
    @Bs1
    public static void close() {
        debugconsole.r = false;
        client.ms = true;
    }
    
    public static void d() {
        if (debugconsole.x != null) {
            try {
                debugconsole.x.close();
            }
            catch (IOException ex) {
                debugconsole.logger.error("", ex);
            }
        }
        debugconsole.x = null;
    }
    
    private static void q(final int n, final int n2) {
        final Vector3[] physicsRayFromPixelSpace = ClientScriptAPI.getPhysicsRayFromPixelSpace((float)n, (float)n2);
        final PhysicsQueryResultList raycast = client.gz.d.raycast(physicsRayFromPixelSpace[0], physicsRayFromPixelSpace[1], Gn5.ENVIRONMENT_QUERY.ordinal(), Gj16.NONE.az, false, true);
        if (raycast.d.size() > 0) {
            final Vector3 d = raycast.d.get(0).d;
            final PhysicsQueryResultList raycast2 = client.gz.d.raycast(Vector3.g(d.x, 1000.0f, d.z), Vector3.g(d.x, 0.0f, d.z), Gn5.ENVIRONMENT_QUERY.ordinal(), Gj16.PLAYER.az + Gj16.GATE1_CLOSE.az + Gj16.GATE2_CLOSE.az + Gj16.GATE3_CLOSE.az + Gj16.GATE4_CLOSE.az + Gj16.GATE5_CLOSE.az + Gj16.GATE6_CLOSE.az + Gj16.GATE7_CLOSE.az + Gj16.GATE8_CLOSE.az + Gj16.GATE9_CLOSE.az + Gj16.GATE10_CLOSE.az + Gj16.GATE11_CLOSE.az + Gj16.GATE12_CLOSE.az + Gj16.GATE13_CLOSE.az + Gj16.GATE14_CLOSE.az, false, true);
            if (raycast2.d.size() > 0) {
                final Vector3 d2 = raycast2.d.get(0).d;
                debugconsole.logger.debug("Teleport to : " + d2);
                final String string = "lua_exec_server telecoordf " + d2.x + " " + (d2.y + 10.0f) + " " + d2.z;
                final El328 d3 = El328.d(Eu326.CLIENT_CHEAT, client.fx.s);
                Gg3.k(d3.q, string.length() + 3);
                Gg3.k(d3.q, 0);
                Gg3.k(d3.q, 0);
                d3.q.af(string);
                N272.e(client.fx, d3);
            }
        }
    }
    
    public static void e() {
        Lb33.g(Lb33.DebugConsole);
        try {
            if (debugconsole.w < 102) {
                debugconsole.w += 6;
            }
            if (debugconsole.y != -1 && debugconsole.v < Gz143.g()) {
                for (int i = debugconsole.y; i < debugconsole.p.length; ++i) {
                    if (debugconsole.p[i].startsWith("pause")) {
                        int int1 = 5;
                        try {
                            int1 = Integer.parseInt(debugconsole.p[i].substring(6));
                        }
                        catch (Exception ex) {}
                        addline("Pausing for " + int1 + " seconds...");
                        debugconsole.y = i + 1;
                        debugconsole.v = Gz143.g() + int1 * 1000;
                        return;
                    }
                    debugconsole.currententry = debugconsole.p[i];
                    l(false);
                }
                debugconsole.y = -1;
            }
        }
        finally {
            Lb33.d(Lb33.DebugConsole);
        }
    }
    
    public static native void initNative();
    
    private static boolean b(final String s, final int n, final boolean b, final String s2) {
        try {
            return Scripting.matchLuaGlobal(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), s, n, b, s2);
        }
        catch (Exception ex) {
            debugconsole.logger.error("", ex);
            return false;
        }
    }
    
    @Be2
    @Bs1
    public static void externalMouseClick(final int i, final int j, final int n) {
        if (n == 9) {
            debugconsole.logger.debug("Teleport: " + i + "," + j);
            q(i, j);
        }
    }
    
    private static void h() {
        if (debugconsole.commandpointer > 0) {
            int n = 0;
            for (int i = 0; i < debugconsole.s.length; ++i) {
                if (debugconsole.s[i].indexOf("--> ") != -1 && ++n == debugconsole.commandpointer) {
                    debugconsole.currententry = debugconsole.s[i].substring(debugconsole.s[i].indexOf(62) + 2);
                    break;
                }
            }
        }
        else {
            debugconsole.currententry = "";
        }
    }
    
    static {
        debugconsole.g = "";
        debugconsole.d = "";
        logger = LoggerFactory.getLogger(debugconsole.class);
        debugconsole.b = 0;
        debugconsole.l = 0;
        debugconsole.currententry = "";
        debugconsole.commandpointer = 0;
        debugconsole.commandcharpointer = 0;
        debugconsole.w = 0;
        debugconsole.r = false;
        debugconsole.y = -1;
    }
    
    private static void l(final boolean b) {
        if (debugconsole.currententry.length() == 0) {
            return;
        }
        if (!b || (!debugconsole.currententry.startsWith("lua ") && !debugconsole.currententry.startsWith("luas ") && !debugconsole.currententry.startsWith("lua_exec ") && !debugconsole.currententry.startsWith("lua_exec_server "))) {
            addline("--> " + debugconsole.currententry);
            v(debugconsole.currententry, false, b);
            debugconsole.commandpointer = 0;
            if (!b) {
                debugconsole.commandcharpointer = 0;
                debugconsole.currententry = "";
            }
            return;
        }
        final int index = debugconsole.currententry.indexOf(32);
        if (index > 1 && b(debugconsole.currententry.substring(index + 1), debugconsole.commandcharpointer - index - 1, false, debugconsole.currententry.substring(0, index))) {
            return;
        }
    }
    
    @Bs1
    @Be2
    public static void addline(final String s) {
        if (debugconsole.s == null) {
            g();
        }
        client.kb.setTime(new Date(Gz143.g()));
        final int value = client.kb.get(11);
        final int value2 = client.kb.get(12);
        final int value3 = client.kb.get(13);
        final String string = Integer.toString(value / 10) + value % 10 + ":" + value2 / 10 + value2 % 10 + ":" + value3 / 10 + value3 % 10;
        final String[] y = StringTools.y(s, '\n');
        for (int i = 0; i < y.length; ++i) {
            for (int j = debugconsole.b; j > 0; --j) {
                debugconsole.s[j] = debugconsole.s[j - 1];
            }
            debugconsole.s[0] = string + ": " + y[i];
            if (debugconsole.x != null) {
                try {
                    debugconsole.x.write(J173.j(debugconsole.s[0] + "\n"));
                }
                catch (IOException ex) {
                    debugconsole.logger.error("", ex);
                }
            }
            if (debugconsole.b < debugconsole.s.length - 1) {
                ++debugconsole.b;
                if (debugconsole.l > 0) {
                    ++debugconsole.l;
                }
            }
        }
    }
    
    @Be2
    @Bs1
    public static void externalMouseInput(final int n) {
        if (n != 0) {
            debugconsole.l += n;
            if (debugconsole.l >= debugconsole.b) {
                debugconsole.l = debugconsole.b - 1;
            }
            if (debugconsole.l < 0) {
                debugconsole.l = 0;
            }
        }
    }
    
    static String r(String s) {
        String substring = null;
        final int index = s.indexOf("--> ");
        if (index >= 0) {
            substring = s.substring(0, index + 4);
            s = s.substring(index + 4);
        }
        if (s.startsWith("directlogin ")) {
            final int index2 = s.indexOf(" ", "directlogin ".length());
            if (index2 >= 0) {
                final int length = s.length();
                s = s.substring(0, index2) + " ";
                for (int i = index2 + 1; i < length; ++i) {
                    s += "*";
                }
            }
        }
        if (substring != null) {
            return substring + s;
        }
        return s;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void ExecuteCommand(final String s, final boolean b, final boolean b2) {
        v(s, b, b2);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void PauseFPSTrack(final int n) {
        if (n == 0) {
            GameShell3.PauseCountFPS = 0.0;
        }
        else {
            GameShell3.PauseCountFPS = 1.0;
        }
    }
    
    @Be2
    @Bs1
    public static boolean isopen() {
        return debugconsole.r;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetBotNameNumber(final String g, final String d) {
        debugconsole.g = g;
        debugconsole.d = d;
    }
    
    public static void y(final int n, final int q) {
        if (n == 1) {
            throw new Error();
        }
        if (n == 2) {
            throw new OutOfMemoryError();
        }
        try {
            if (n == 3) {
                close();
            }
            else if (n == 4) {
                addline("" + GameShell3.fps);
            }
            else if (n == 6) {
                client.bx = true;
            }
            else if (n == 7) {
                client.bx = false;
            }
            else if (n == 8) {
                Hb335.g(client.jb);
            }
            else if (n == 9) {
                client.as();
                for (int i = 0; i < 10; ++i) {
                    System.gc();
                }
                final Runtime runtime = Runtime.getRuntime();
                addline("" + (int)((runtime.totalMemory() - runtime.freeMemory()) / 1024L));
            }
            else if (n == 11) {
                addline(Kt125.d().b() ? "Success" : "Failure");
            }
            else if (n == 13) {
                Lx337.q(Lf336.q);
            }
            else if (n == 14) {
                W144.v(client.dm);
            }
            else if (n == 17) {
                W144.r(client.dm);
            }
            else if (n == 15) {
                GameShell3.canvas.setLocation(50, 50);
            }
            else if (n == 16) {
                GameShell3.canvas.setLocation(GameShell3.leftMargin, GameShell3.topMargin);
            }
            else if (n == 19) {
                client.by();
            }
            else if (n == 20) {
                client.gv = Gz143.g();
                client.gc = true;
                client.by();
            }
            else if (n == 21) {
                final Vector3 trans = Gc330.j().getWorldTransform().trans;
                addline(((int)trans.x >> 2) + " " + ((int)trans.z >> 2));
            }
            else if (n == 26) {
                client.ac();
            }
            else if (n == 27) {
                client.bz = 0;
                client.by();
            }
            else if (n == 28) {
                client.bz = 1;
                client.by();
            }
            else if (n == 29) {
                client.bz = 2;
                client.by();
            }
            else if (n == 42) {
                client.at();
            }
            else if (n == 31) {
                client.dc.g(null).d.at(Gn5.aq);
            }
            else if (n == 32) {
                client.dc.g(null).d.at(Gn5.ai);
            }
            else if (n == 33) {
                client.dc.g(null).d.at(Gn5.al);
            }
            else if (n == 34) {
                client.dc.g(null).d.aw();
            }
            else if (n == 35) {
                client.dc.g(null).d.ar();
            }
            else if (n == 36) {
                Ap127.d = !Ap127.d;
            }
            else if (n == 37) {
                if (q > 0) {
                    Ap127.q = q;
                }
            }
            else if (n == 38) {
                if (q > 0) {
                    Ap127.j = (float)q;
                }
            }
            else if (n == 40) {
                DiscreteDynamicsWorld.ax(client.dc.g(null).d, (float)q);
            }
            else if (n == 41) {
                client.lc = !client.lc;
            }
        }
        catch (Exception ex) {
            addline(Mk163.g(Mk163.DEBUG_CONSOLE_ERROR, client.n));
        }
    }
    
    public static void v(final String str, final boolean b, final boolean b2) {
        try {
            if (str.equalsIgnoreCase("commands") || str.equalsIgnoreCase("help")) {
                addline("commands - This command");
                addline("cls - Clear console");
                addline("displayfps - Toggle FPS and other information");
                addline("renderer - Print graphics renderer information");
                addline("heap - Print java memory information");
                addline("getcamerapos - Print location and direction of camera for use in bug reports");
                return;
            }
            if (str.equalsIgnoreCase("cls")) {
                debugconsole.b = 0;
                debugconsole.l = 0;
                return;
            }
            if (str.equalsIgnoreCase("displayfps")) {
                client.bx = !client.bx;
                if (client.bx) {
                    addline("FPS on");
                }
                else {
                    addline("FPS off");
                }
                return;
            }
            if (str.equals("heap")) {
                addline("Heap: " + GameShell3.maxmemory + "MB");
                return;
            }
        }
        catch (Exception ex) {
            addline(Mk163.g(Mk163.DEBUG_CONSOLE_ERROR, client.n));
            debugconsole.logger.error("", ex);
            return;
        }
        Label_1218: {
            if (client.t == D123.LIVE) {
                if (client.ik < 2) {
                    break Label_1218;
                }
            }
            try {
                if (str.equalsIgnoreCase("wm1")) {
                    client.f(J160.SMALL, -1, -1, false);
                    if (client.a() == J160.SMALL) {
                        addline("Success");
                    }
                    else {
                        addline("Failure");
                    }
                    return;
                }
                if (str.equalsIgnoreCase("wm2")) {
                    client.f(J160.RESIZABLE, -1, -1, false);
                    if (client.a() == J160.RESIZABLE) {
                        addline("Success");
                    }
                    else {
                        addline("Failure");
                    }
                    return;
                }
                if (Hq338.g && str.equalsIgnoreCase("wm3")) {
                    client.f(J160.FULLSCREEN, 1024, 768, false);
                    if (client.a() == J160.FULLSCREEN) {
                        addline("Success");
                    }
                    else {
                        addline("Failure");
                    }
                    return;
                }
                if (str.equalsIgnoreCase("clientdrop")) {
                    if (client.ac == 11) {
                        client.at();
                    }
                    else if (client.ac == 12) {
                        client.fx.o = true;
                    }
                    return;
                }
                if (str.equalsIgnoreCase("breakcon")) {
                    if (client.fx.q != null) {
                        client.fx.q.s();
                    }
                    W144.y(client.dm);
                    return;
                }
                if (str.startsWith("directlogin")) {
                    final String[] p3 = StringTools.p(str.substring(12), ' ');
                    if (p3.length == 2) {
                        Login.requestLoginWithUsername(p3[0], p3[1], null);
                    }
                    return;
                }
                if (str.startsWith("snlogin ")) {
                    Login.requestLoginFromSocialNetwork(Integer.parseInt(StringTools.p(str.substring(8), ' ')[0]), null);
                    return;
                }
                if (str.startsWith("setoutput ")) {
                    File file = new File(str.substring(10));
                    if (file.exists()) {
                        file = new File(str.substring(10) + "." + Gz143.g() + ".log");
                        if (file.exists()) {
                            addline("file already exists!");
                            return;
                        }
                    }
                    if (debugconsole.x != null) {
                        debugconsole.x.close();
                        debugconsole.x = null;
                    }
                    try {
                        debugconsole.x = new FileOutputStream(file);
                    }
                    catch (FileNotFoundException ex3) {
                        addline("Could not create " + file.getName());
                    }
                    catch (SecurityException ex4) {
                        addline("Cannot write to " + file.getName());
                    }
                    return;
                }
                if (str.equals("closeoutput")) {
                    if (debugconsole.x != null) {
                        debugconsole.x.close();
                    }
                    debugconsole.x = null;
                    return;
                }
                if (str.startsWith("runscript ")) {
                    final File file2 = new File(str.substring(10));
                    if (!file2.exists()) {
                        addline("No such file");
                        return;
                    }
                    final byte[] q = If31.q(file2);
                    if (q == null) {
                        addline("Failed to read file");
                        return;
                    }
                    j(StringTools.y(StringTools.v(J173.h(q), '\r', ""), '\n'));
                }
                if (str.startsWith("lps ")) {
                    final int j = StringTools.j(str.substring(4));
                    GameShell3.setspeed(j);
                    addline("Set logic rate to " + j);
                    return;
                }
                if (str.equalsIgnoreCase("physicsreg")) {
                    client.kx = !client.kx;
                    addline("Physics regulation " + (client.kx ? "on" : "off"));
                    return;
                }
                if (str.startsWith("lookahead ")) {
                    final int int1 = Integer.parseInt(str.substring("lookahead ".length()));
                    if (int1 > client.dz) {
                        client.du = true;
                    }
                    client.dz = int1;
                    addline("Set client lookahead to " + int1);
                    return;
                }
                if (client.ac == 11) {
                    final El328 d = El328.d(Eu326.CLIENT_CHEAT, client.fx.s);
                    Gg3.k(d.q, str.length() + 3);
                    Gg3.k(d.q, b ? 1 : 0);
                    Gg3.k(d.q, b2 ? 1 : 0);
                    d.q.af(str);
                    N272.e(client.fx, d);
                    if (!Ap127.d) {
                        debugconsole.logger.info("->server: {}", str);
                    }
                }
                if (str.startsWith("cyclerate ")) {
                    Lq191.q(StringTools.j(str.substring(4)));
                    return;
                }
                if (str.equals("ssprofile")) {
                    LossyStateStreamProfiler.enabled = !LossyStateStreamProfiler.enabled;
                    addline("Client-side ssprofile " + (LossyStateStreamProfiler.enabled ? "on" : "off"));
                    return;
                }
                if (str.equals("udploss")) {
                    addline("Client UDP loss: " + client.dw.getUnreceivedCount() + "/" + client.dw.getReceivedCount());
                    return;
                }
            }
            catch (Exception ex2) {
                addline(Mk163.g(Mk163.DEBUG_CONSOLE_ERROR, client.n));
                debugconsole.logger.error("", ex2);
                return;
            }
        }
        if (client.ac != 11) {
            addline(Mk163.g(Mk163.DEBUG_CONSOLE_UNKNOWNCOMMAND, client.n) + str);
            debugconsole.logger.debug(str);
        }
    }
    
    public static void s(final String currententry) {
        debugconsole.currententry = currententry;
        debugconsole.commandcharpointer = debugconsole.currententry.length();
    }
    
    public static void w() {
        C340.j(0, 0, GameShell3.canvasWid, 350);
        C340.b(0.0f, 0.0f, (float)GameShell3.canvasWid, 350.0f, debugconsole.w << 24 | 0x332277, Fb341.BLEND_NORMAL);
        final int n = 350 / debugconsole.h;
        if (debugconsole.b > 0) {
            final int n2 = 346 - debugconsole.h - 4;
            final int n3 = n * n2 / (n + debugconsole.b - 1);
            int n4 = 4;
            if (debugconsole.b > 1) {
                n4 += (debugconsole.b - 1 - debugconsole.l) * (n2 - n3) / (debugconsole.b - 1);
            }
            C340.b((float)(GameShell3.canvasWid - 16), (float)n4, 12.0f, (float)n3, debugconsole.w << 24 | 0x332277, Fb341.BLEND_ADDITIVE);
            for (int l = debugconsole.l; l < debugconsole.l + n && l < debugconsole.b; ++l) {
                final String[] y = StringTools.y(debugconsole.s[l], '\b');
                final int n5 = (GameShell3.canvasWid - 8 - 16) / y.length;
                for (int i = 0; i < y.length; ++i) {
                    final int n6 = 8 + i * n5;
                    C340.j(n6, 0, n6 + n5 - 8, 350);
                    int n7 = -4144960;
                    final String r = r(y[i]);
                    if (r.length() >= 15) {
                        if (r.length() >= 17 && r.substring(10, 17).equals("--> lua")) {
                            n7 = -128;
                        }
                        else if (r.substring(10, 14).equals("--> ")) {
                            n7 = -64;
                        }
                        else if (r.length() >= 23 && r.substring(10, 23).equals("Lua> [string ")) {
                            n7 = -32640;
                        }
                        else if (r.length() >= 32 && r.substring(10, 32).equals("....Lua Stacktrace....")) {
                            n7 = -28528;
                        }
                        else if (r.length() >= 16 && r.substring(10, 16).equals("   at ")) {
                            n7 = -28528;
                        }
                        else if (r.substring(10, 15).equals("Lua> ")) {
                            n7 = -8323200;
                        }
                    }
                    F342.g(D150.b, r, n6, 350 - debugconsole.e - 2 - D150.e.h - (l - debugconsole.l) * debugconsole.h, n7, -16777216);
                }
            }
        }
        F342.d(D150.s, (client.w ? "" : "Build: ") + 1 + " " + 1, GameShell3.canvasWid - 25, 330, -1, -16777216);
        C340.j(0, 0, GameShell3.canvasWid, 350);
        C340.h(0.0f, (float)(350 - debugconsole.e), (float)GameShell3.canvasWid, -1);
        F342.g(D150.l, "--> " + r(debugconsole.currententry), 10, 350 - D150.h.h - 1, -1, -16777216);
        if (GameShell3.focus) {
            int n8 = -1;
            if (client.bj % 30 > 15) {
                n8 = 16777215;
            }
            C340.s((float)(10 + Kj334.e(D150.h, "--> " + r(debugconsole.currententry).substring(0, debugconsole.commandcharpointer))), (float)(350 - D150.h.h - 11), 12.0f, n8);
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
    public static void PausePPSTrack(final int n) {
        if (n == 0) {
            client.lo = 0.0;
        }
        else {
            client.lo = 1.0;
        }
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
