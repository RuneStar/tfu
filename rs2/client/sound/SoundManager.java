/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.J332;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.Scaleform;
import com.jagex.js5.js5;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import fmod.B561;
import fmod.E245;
import fmod.J251;
import fmod.M249;
import fmod.N247;
import fmod.Q244;
import fmod.T239;
import fmod.U240;
import fmod.W242;
import fmod.X243;
import fmod.Z256;
import fmod.fmod;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.D150;
import rs2.client.ScriptCamera;
import rs2.client.client;
import rs2.client.lua.ClientScriptAPI;
import rs2.client.sound.A592;
import rs2.client.sound.Ag588;
import rs2.client.sound.Al600;
import rs2.client.sound.Aq602;
import rs2.client.sound.Az601;
import rs2.client.sound.B598;
import rs2.client.sound.C595;
import rs2.client.sound.D597;
import rs2.client.sound.F594;
import rs2.client.sound.G593;
import rs2.client.sound.H591;
import rs2.client.sound.J590;
import rs2.client.sound.K589;
import rs2.client.sound.Q583;
import rs2.client.sound.T596;
import rs2.client.sound.U587;
import rs2.client.sound.W599;
import rs2.client.sound.Y603;
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
    private static boolean a;
    static int aa;
    static boolean af;
    static String ag;
    static Q583[] ah;
    public static LinkedList ai;
    static Hashtable al;
    private static boolean am;
    static int an;
    static int ao;
    static long ap;
    static String aq;
    private static String[] av;
    static Hashtable az;
    public static final int b = 32;
    public static E245 c;
    private static final float d = 1.9f;
    public static final int e = 16384;
    public static U240 f;
    public static final int h = 8192;
    public static boolean i;
    public static final int j = 8192;
    public static Cz584 k;
    public static final int l = 32;
    private static final Logger logger;
    public static Cd585 m;
    public static Ce586 n;
    private static Random o;
    public static int p;
    public static final int q = 16384;
    public static final boolean r = true;
    public static final int s = 0;
    public static Dn555 t;
    public static final int u = 2;
    public static Ce586 v;
    public static final boolean w = false;
    public static boolean x;
    public static Cd585 y;
    public static int z;

    public static void i(String string, int n) {
        F342.d(D150.s, string, GameShell3.canvasWid - 10, GameShell3.canvasHei - 320 - n * 13, -256, 0);
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
            SoundManager.q();
            Ag588.s("botinfo");
            K589.d("music");
            SoundManager.j();
            E245.u(c, 0, new Q244(0.0f, 0.0f, 0.0f), new Q244(0.0f, 0.0f, 0.0f), new Q244(1.0f, 0.0f, 0.0f), new Q244(0.0f, 1.0f, 0.0f));
            af = true;
            GameEntity.cw = new J590();
        }
        logger.trace("SoundManager version {} initialised", Float.valueOf(1.9f));
        if (f != null && SoundManager.f.g != 0L) {
            Scaleform.initSound(SoundManager.f.g);
        }
        return true;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void CreateVehicle(GameEntity gameEntity) {
        H591.g(gameEntity);
    }

    static void q() {
        logger.trace("SoundManager.clearOutdatedFiles()");
        File[] arrfile = new File(ag).listFiles(new A592());
        if (arrfile != null) {
            byte[] arrby = G593.e("filelen.dat", true);
            Gg3 gg3 = new Gg3(arrby);
            ah = new Q583[gg3.r.length / 8];
            for (int i = 0; i < ah.length; ++i) {
                int n = Gg3.bd(gg3);
                int n2 = Gg3.bd(gg3);
                SoundManager.ah[i] = new Q583(n, n2);
            }
            for (File file : arrfile) {
                if (client.ez.getgroupid(file.getName()) == -1) {
                    file.delete();
                    continue;
                }
                long l = file.length();
                long l2 = SoundManager.d(file.getName());
                if (l2 == 0L || l2 == l) continue;
                logger.trace("Deleted outdated file {}", (Object)file.getName());
                file.delete();
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopAllSounds() {
        logger.trace("SoundManager.StopAllSounds()");
        SoundManager.ab();
    }

    public static void b() {
        if (c != null) {
            logger.trace("SoundManager.quit()");
            E245.b(c);
            c = null;
        }
    }

    public static void l() {
        logger.trace("SoundManager.updateFmodCamera() - cam = {}, self = {}", ScriptCamera.getActiveCamera(), (Object)Gc330.j());
        if (ScriptCamera.getActiveCamera() != null && Gc330.j() != null) {
            ScaleRotTrans scaleRotTrans = ScriptCamera.getActiveCamera().getWorldTransform();
            Quaternion quaternion = scaleRotTrans.rot;
            Vector3 vector3 = new Vector3(2.0f * (quaternion.x * quaternion.z + quaternion.w * quaternion.y), 2.0f * (quaternion.y * quaternion.z - quaternion.w * quaternion.x), 1.0f - 2.0f * (quaternion.x * quaternion.x + quaternion.y * quaternion.y));
            vector3 = Vector3.u(vector3);
            Vector3 vector32 = new Vector3(2.0f * (quaternion.x * quaternion.y - quaternion.w * quaternion.z), 1.0f - 2.0f * (quaternion.x * quaternion.x + quaternion.z * quaternion.z), 2.0f * (quaternion.y * quaternion.z + quaternion.w * quaternion.x));
            Vector3 vector33 = scaleRotTrans.trans;
            if (vector33 != null) {
                Q244 q244 = new Q244(vector3.x, vector3.y, vector3.z);
                Q244 q2442 = new Q244(vector32.x, vector32.y, vector32.z);
                Q244 q2443 = new Q244(vector33.x, vector33.y, vector33.z);
                E245.u(c, 0, q2443, new Q244(0.0f, 0.0f, 0.0f), q244, q2442);
            }
        }
    }

    public static void w() {
    }

    public static void r() {
        SoundManager.v();
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
            SoundManager.l();
            E245.t(c);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopMusic() {
        logger.trace("SoundManager.StopMusic()");
    }

    public static void u(int n, int n2, int n3, int n4, boolean bl, int n5) {
    }

    public static void n() {
    }

    public static void k() {
        if (af) {
            int n = U240.g(fmod.s);
            int n2 = fmod.getMemoryUsed();
            int n3 = 0;
            SoundManager.i("Num FMOD channels: " + n, n3++);
            SoundManager.i("FMOD memory used : " + n2, n3++);
        }
    }

    public static void m(int n, int n2, int n3) {
    }

    public static void o() {
    }

    static C595[] f(String string) {
        if ((string = string.replace(" ", "")).length() == 0) {
            return null;
        }
        String[] arrstring = string.split(",");
        C595[] arrc595 = new C595[arrstring.length];
        for (int i = 0; i < arrc595.length; ++i) {
            String[] arrstring2 = arrstring[i].split("=");
            if (arrstring2.length != 2) continue;
            arrc595[i] = new C595();
            arrc595[i].g = arrstring2[0];
            arrc595[i].d = Integer.parseInt(arrstring2[1]);
        }
        return arrc595;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int PlaySoundOnEntityAtTransform(String string, GameEntity gameEntity, String string2, RotTrans rotTrans) {
        SoundAdapter soundAdapter;
        Object[] arrobject = new Object[]{string, gameEntity, string2, rotTrans};
        logger.trace("Enter SoundManager.PlaySoundOnEntityAtTransform({}, {}, {}, {})", arrobject);
        SoundComponent soundComponent = (SoundComponent)GameEntity.eb(gameEntity, SoundComponent.class);
        if (soundComponent == null) {
            soundComponent = new SoundComponent();
            GameEntity.ep(gameEntity, soundComponent);
        }
        if (!soundComponent.hasSound(string)) {
            soundAdapter = soundComponent.addSoundAtTransform(string, string2, rotTrans);
        } else {
            soundAdapter = soundComponent.getSound(string);
            soundAdapter.setWorldTransform(rotTrans);
        }
        int n = SoundManager.ai(soundAdapter);
        return n;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopSound(int n) {
        logger.trace("SoundManager.StopSound({})", n);
        ArrayList arrayList = X243.ao();
        for (X243 x243 : arrayList) {
            if (x243.t != n) continue;
            X243.f(x243);
            break;
        }
    }

    public static void ao() {
        K589.b();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean IsSoundPlaying(int n) {
        logger.trace("SoundManager.IsSoundPlaying({})", n);
        ArrayList arrayList = X243.ao();
        for (X243 x243 : arrayList) {
            if (x243.t != n) continue;
            return X243.y(x243);
        }
        return false;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetSoundParameter(int n, String string) {
        logger.trace("SoundManager.SetSoundParameter({}, {})", n, (Object)string);
        ArrayList arrayList = X243.ao();
        for (X243 x243 : arrayList) {
            if (x243.t != n) continue;
            C595[] arrc595 = SoundManager.f(string);
            if (arrc595 == null) break;
            for (C595 c595 : arrc595) {
                x243.ag(c595.g, c595.d);
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int Play2dSound(String string, int n, String string2) {
        Object[] arrobject = new Object[]{string, n, string2};
        logger.trace("SoundManager.Play2dSound({}, {}, {})", arrobject);
        return SoundManager.aq(string, n, string2);
    }

    public static int aq(String string, int n, String string2) {
        X243 x243;
        int n2 = -1;
        if (af && (x243 = c.x(string, n)) != null) {
            n2 = x243.t;
            C595[] arrc595 = SoundManager.f(string2);
            if (arrc595 != null) {
                for (C595 c595 : arrc595) {
                    x243.ag(c595.g, c595.d);
                }
            }
        }
        return n2;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int PlaySoundOnEntity(String string, GameEntity gameEntity, String string2) {
        Object[] arrobject = new Object[]{string, gameEntity, string2};
        logger.trace("Enter SoundManager.PlaySoundOnEntity({}, {}, {})", arrobject);
        SoundComponent soundComponent = (SoundComponent)GameEntity.eb(gameEntity, SoundComponent.class);
        if (soundComponent == null) {
            soundComponent = new SoundComponent();
            GameEntity.ep(gameEntity, soundComponent);
        }
        SoundAdapter soundAdapter = !soundComponent.hasSound(string) ? soundComponent.addSound(string, string2) : soundComponent.getSound(string);
        int n = SoundManager.ai(soundAdapter);
        return n;
    }

    private static int ai(SoundAdapter soundAdapter) {
        float f = soundAdapter.getVolume();
        String string = soundAdapter.getName();
        String string2 = soundAdapter.getParams();
        Vector3 vector3 = ClientScriptAPI.clientToServerPos(soundAdapter.getWorldTransform().trans);
        SoundManager.al(soundAdapter);
        int n = SoundManager.av(string, vector3, string2);
        SoundManager.SetSoundVolume(n, f);
        SoundAdapter.d(soundAdapter, string2, n);
        return n;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopSoundOnEntity(String string, GameEntity gameEntity) {
        Object[] arrobject = new Object[]{string, gameEntity};
        logger.trace("Enter SoundManager.StopSoundOnEntity({}, {})", arrobject);
        SoundComponent soundComponent = (SoundComponent)GameEntity.eb(gameEntity, SoundComponent.class);
        if (soundComponent == null) {
            throw new RuntimeException("Failed to stop the sound on the GameEntity since there was no SoundComponent. Use 'PlaySoundOnEntity' first which ensure this.");
        }
        soundComponent.d(string);
    }

    private static void al(SoundAdapter soundAdapter) {
        T596 t596 = new T596();
        soundAdapter.addEventHandler("SoundTransformChangedEvent", t596);
        D597 d597 = new D597();
        soundAdapter.addEventHandler("SoundLinearVelocityChangedEvent", d597);
        B598 b598 = new B598();
        soundAdapter.addEventHandler("SoundAngularVelocityChangedEvent", b598);
        W599 w599 = new W599();
        soundAdapter.addEventHandler("SoundRemovedEvent", w599);
        Al600 al600 = new Al600();
        soundAdapter.addEventHandler("SoundStoppedEvent", al600);
        Az601 az601 = new Az601();
        soundAdapter.addEventHandler("SoundVolumeChangedEvent", az601);
        Aq602 aq602 = new Aq602();
        soundAdapter.addEventHandler("SoundParamsChangedEvent", aq602);
    }

    private static void af(SoundAdapter soundAdapter) {
        SoundAdapter.j(soundAdapter);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int Play3dSound(String string, float f, float f2, float f3, String string2) {
        Object[] arrobject = new Object[]{string, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), string2};
        logger.trace("SoundManager.Play3dSound({}, {}, {}, {}, {})", arrobject);
        return SoundManager.av(string, new Vector3(f, f2, f3), string2);
    }

    public static int av(String string, Vector3 vector3, String string2) {
        int n = -1;
        if (af) {
            SoundManager.aw("SCRIPT", string);
            X243 x243 = c.p(string, vector3.x, vector3.y, vector3.z);
            if (x243 != null) {
                C595[] arrc595 = SoundManager.f(string2);
                if (arrc595 != null) {
                    for (C595 c595 : arrc595) {
                        x243.ag(c595.g, c595.d);
                    }
                }
                n = x243.t;
            }
        }
        return n;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StartMusic(String string, String string2) {
        if (string.contains("titlemusic")) {
            string = "Title";
        }
        if (string.contains("character")) {
            string = "CharacterSelect";
        }
        if (string.contains("battlemusic")) {
            string = "Exploration";
        }
        K589.h(string, string2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetSoundParameterByName(String string, String string2) {
        logger.trace("SoundManager.SetSoundParameter({}, {})", (Object)string, (Object)string2);
        SoundManager.an(string, string2);
    }

    public static void ap(String string, String string2) {
    }

    static void j() {
        logger.trace("SoundManager.loadProjects()");
        char[] arrc = G593.h("projects.txt", true);
        String string = String.valueOf(arrc).replace("\r", "");
        String[] arrstring = string.split("\n");
        boolean bl = false;
        for (String string2 : arrstring) {
            if (string2.length() <= 0 || string2.replace(" ", "").startsWith("//")) continue;
            byte[] arrby = G593.e(string2 + ".fev", true);
            if (arrby == null) {
                logger.warn("Did not find (or could not download) fmod file %{}.fev in time to init the SoundManager. Does this file exist? If not you should remove it from the projects.txt file as it will cause a 30 second blocking delay to the client load.", (Object)string2);
                continue;
            }
            if (string2.contains("Safety")) {
                // empty if block
            }
            c.w(arrby);
        }
        SoundManager.h();
    }

    public static void a(int n, int n2) {
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetMusicParameter(String string) {
        logger.trace("SoundManager.SetMusicParameter({})", (Object)string);
        K589.s(string);
    }

    public static void aa(String string) {
        K589.s(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void script_SetAmbienceParameter(String string) {
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetSoundVolume(int n, float f) {
        logger.trace("SoundManager.SetSoundVolume({}, {})", n, (Object)Float.valueOf(f));
        ArrayList arrayList = X243.ao();
        for (X243 x243 : arrayList) {
            if (x243.t != n) continue;
            X243.i(x243, f);
            break;
        }
    }

    public static void an(String string, String string2) {
        C595[] arrc595;
        if (af && (arrc595 = SoundManager.f(string2)) != null) {
            ArrayList arrayList = F594.g();
            for (F594 f594 : arrayList) {
                if (!f594.h.equals(string)) continue;
                for (C595 c595 : arrc595) {
                    f594.s.ag(c595.g, c595.d);
                }
            }
        }
    }

    static int d(String string) {
        int n = StringTools.l(string);
        for (int i = 0; i < ah.length; ++i) {
            if (SoundManager.ah[i].g != n) continue;
            return SoundManager.ah[i].d;
        }
        return 0;
    }

    public static void ag(int n, int n2, String string) {
        C595[] arrc595;
        X243 x243;
        if (af && (x243 = c.x(SoundManager.s(n), n2)) != null && (arrc595 = SoundManager.f(string)) != null) {
            for (C595 c595 : arrc595) {
                x243.ag(c595.g, c595.d);
            }
        }
    }

    public static void p(int n, int n2, int n3, int n4, int n5) {
    }

    public static void as() {
        Y603.q();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void PreLoadBank(String string) {
        logger.trace("SoundManager.PreLoadBank({})", (Object)string);
        SoundManager.ac(string);
    }

    public static void ac(String string) {
        block3 : {
            String[] arrstring;
            block5 : {
                block4 : {
                    Z256[] arrz256;
                    if (!string.toLowerCase().endsWith(".fev")) break block4;
                    for (Z256 z256 : arrz256 = E245.m(c)) {
                        String[] arrstring2;
                        if (!string.toLowerCase().startsWith(z256.j().d.toLowerCase())) continue;
                        for (String string2 : arrstring2 = z256.e()) {
                            G593.d(string2, 100000L);
                        }
                        break block3;
                    }
                    break block3;
                }
                if (!string.toLowerCase().endsWith(".fsb")) break block5;
                G593.d(string, 100000L);
                break block3;
            }
            X243 x243 = c.r(string, 4);
            if (!X243.h(x243)) break block3;
            for (String string3 : arrstring = x243.aq()) {
                G593.d(string3, 100000L);
            }
        }
    }

    public static void at(String string) {
    }

    private static void h() {
        if (c != null) {
            Z256[] arrz256;
            logger.trace("SoundManager.convertBankToCRC()");
            for (Z256 z256 : arrz256 = E245.m(c)) {
                J251[] arrj251;
                W242 w242 = z256.j();
                String string = w242.d;
                for (J251 j251 : arrj251 = Z256.q(z256)) {
                    SoundManager.e(j251, al, string + "/" + j251.s().d);
                }
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopAllLevelSounds() {
        ArrayList arrayList = X243.ao();
        for (X243 x243 : arrayList) {
            if (x243 == Y603.g()) continue;
            M249 m249 = x243.l();
            if (m249.g().g.equalsIgnoreCase("Music")) continue;
            X243.f(x243);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void LoadWorldAudio(String string) {
        F594.h(string);
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
    public static void SetMixerVolume(String string, float f) {
        M249[] arrm249;
        for (M249 m249 : arrm249 = E245.d(c)) {
            if (!m249.g().g.equalsIgnoreCase(string)) continue;
            M249.d(m249, f);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void DestroyVehicle(GameEntity gameEntity) {
        H591.d(gameEntity);
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
    public static void ShowPlayingSounds(GameEntity gameEntity, boolean bl) {
        am = bl;
    }

    static void aw(String string, String string2) {
        if (a) {
            // empty if block
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void ToggleEventNames() {
        a ^= true;
    }

    static /* synthetic */ Logger ar() {
        return logger;
    }

    static /* synthetic */ void ax(SoundAdapter soundAdapter) {
        SoundManager.af(soundAdapter);
    }

    static {
        logger = LoggerFactory.getLogger(SoundManager.class);
        v = null;
        p = -1;
        x = false;
        z = -1;
        n = null;
        i = false;
        o = new Random();
        a = false;
        ag = "";
        aq = "R:\\WIP\\src\\sounds\\fmod\\";
        ai = new LinkedList();
        al = new Hashtable();
        af = false;
        av = null;
        az = new Hashtable();
        ah = null;
        ap = 0L;
        ao = 0;
        aa = 0;
        an = 0;
        am = false;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetSoundPosition(int n, float f, float f2, float f3) {
        Object[] arrobject = new Object[]{n, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)};
        logger.trace("SoundManager.SetSoundPosition({}, {}, {}, {})", arrobject);
        ArrayList arrayList = X243.ao();
        for (X243 x243 : arrayList) {
            if (x243.t != n) continue;
            X243.u(x243, new Q244(f, f2, f3));
            break;
        }
    }

    public static String s(int n) {
        String string = (String)al.get(new Integer(n));
        return string;
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
    public static void SetMood(String string) {
        K589.s(string);
    }

    static void e(J251 j251, Hashtable hashtable, String string) {
        logger.trace("SoundManager.addEventsToTable({})", j251);
        J251[] arrj251 = J251.j(j251);
        Object[] arrobject = arrj251;
        int n = arrobject.length;
        for (int i = 0; i < n; ++i) {
            J251 j2512 = arrobject[i];
            SoundManager.e(j2512, hashtable, string + "/" + j2512.s().d);
        }
        for (Object object : arrobject = J251.e(j251)) {
            String[] arrstring;
            String string2 = string + "/" + X243.b((X243)object).d;
            Integer n2 = StringTools.l(string2);
            hashtable.put(n2, string2);
            for (String string3 : arrstring = c.n(string2)) {
                if (!string3.startsWith("!")) continue;
                logger.debug("Preloading audio bank" + string3);
                G593.d(string3, 30000L);
            }
        }
    }

    public static void ab() {
        Z256[] arrz256;
        for (Z256 z256 : arrz256 = E245.m(c)) {
            Z256.s(z256, true);
        }
    }

    public static void c(int n, Vector3 vector3, String string) {
        if (af) {
            X243 x243 = c.y(SoundManager.s(n), new Q244(vector3.x, vector3.y, vector3.z));
            C595[] arrc595 = SoundManager.f(string);
            if (arrc595 != null) {
                for (C595 c595 : arrc595) {
                    x243.ag(c595.g, c595.d);
                }
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void PlayAmbience(String string, String string2) {
        logger.trace("SoundManager.PlayAmbience({}, {})", (Object)string, (Object)string2);
        Y603.d(string, string2);
    }

    public static void t(int n, int n2, int n3) {
    }

    public static void z(int n, int n2, int n3, int n4, float f, float f2, float f3, boolean bl, int n5) {
    }

    public static void am(String string, String string2) {
        Y603.d(string, string2);
    }

    public static void y() {
    }

    public static void x(int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
    }
}

