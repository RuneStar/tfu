// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import org.slf4j.LoggerFactory;
import fmod.M249;
import fmod.J251;
import fmod.Z256;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import rs2.client.lua.ClientScriptAPI;
import java.util.Iterator;
import rs2.shared.sound.SoundAdapter;
import com.jagex.game.runetek6.gameentity.Component;
import rs2.shared.sound.SoundComponent;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Quaternion;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import tfu.Gc330;
import rs2.client.ScriptCamera;
import rs2.client.client;
import tfu.Gg3;
import java.io.FileFilter;
import java.io.File;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.Scaleform;
import com.jagex.game.runetek6.gameentity.GameEntity;
import fmod.Q244;
import fmod.X243;
import fmod.K560;
import fmod.fmod;
import tfu.F342;
import com.jagex.game.runetek6.client.GameShell3;
import rs2.client.D150;
import tfu.Dn555;
import java.util.Random;
import tfu.Ce586;
import tfu.Cd585;
import org.slf4j.Logger;
import tfu.Cz584;
import fmod.U240;
import fmod.E245;
import java.util.Hashtable;
import java.util.LinkedList;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass
public class SoundManager
{
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
    
    public static void i(final String s, final int n) {
        F342.d(D150.s, s, GameShell3.canvasWid - 10, GameShell3.canvasHei - 320 - n * 13, -256, 0);
    }
    
    public static boolean g() {
        if (!SoundManager.af) {
            fmod.q(new U587());
            SoundManager.f = fmod.g();
            SoundManager.c = fmod.d();
            if (SoundManager.c == null) {
                SoundManager.logger.info("Unable to init FMOD!");
                return false;
            }
            X243.j(30000L);
            E245.s(SoundManager.c, 1024, 16L, 0);
            SoundManager.ag = (X243.d = GameShell3.getCacheLocation().getAbsolutePath() + "\\");
            E245.l(SoundManager.c, SoundManager.ag);
            q();
            Ag588.s("botinfo");
            K589.d("music");
            j();
            E245.u(SoundManager.c, 0, new Q244(0.0f, 0.0f, 0.0f), new Q244(0.0f, 0.0f, 0.0f), new Q244(1.0f, 0.0f, 0.0f), new Q244(0.0f, 1.0f, 0.0f));
            SoundManager.af = true;
            GameEntity.cw = new J590();
        }
        SoundManager.logger.trace("SoundManager version {} initialised", 1.9f);
        if (SoundManager.f != null && SoundManager.f.g != 0L) {
            Scaleform.initSound(SoundManager.f.g);
        }
        return true;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void CreateVehicle(final GameEntity gameEntity) {
        H591.g(gameEntity);
    }
    
    static void q() {
        SoundManager.logger.trace("SoundManager.clearOutdatedFiles()");
        final File[] listFiles = new File(SoundManager.ag).listFiles(new A592());
        if (listFiles != null) {
            final Gg3 gg3 = new Gg3(G593.e("filelen.dat", true));
            SoundManager.ah = new Q583[gg3.r.length / 8];
            for (int i = 0; i < SoundManager.ah.length; ++i) {
                SoundManager.ah[i] = new Q583(Gg3.bd(gg3), Gg3.bd(gg3));
            }
            for (final File file : listFiles) {
                if (client.ez.getgroupid(file.getName()) == -1) {
                    file.delete();
                }
                else {
                    final long length2 = file.length();
                    final long n = d(file.getName());
                    if (n != 0L && n != length2) {
                        SoundManager.logger.trace("Deleted outdated file {}", file.getName());
                        file.delete();
                    }
                }
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopAllSounds() {
        SoundManager.logger.trace("SoundManager.StopAllSounds()");
        ab();
    }
    
    public static void b() {
        if (SoundManager.c != null) {
            SoundManager.logger.trace("SoundManager.quit()");
            E245.b(SoundManager.c);
            SoundManager.c = null;
        }
    }
    
    public static void l() {
        SoundManager.logger.trace("SoundManager.updateFmodCamera() - cam = {}, self = {}", ScriptCamera.getActiveCamera(), Gc330.j());
        if (ScriptCamera.getActiveCamera() != null && Gc330.j() != null) {
            final ScaleRotTrans worldTransform = ScriptCamera.getActiveCamera().getWorldTransform();
            final Quaternion rot = worldTransform.rot;
            final Vector3 u = Vector3.u(new Vector3(2.0f * (rot.x * rot.z + rot.w * rot.y), 2.0f * (rot.y * rot.z - rot.w * rot.x), 1.0f - 2.0f * (rot.x * rot.x + rot.y * rot.y)));
            final Vector3 vector3 = new Vector3(2.0f * (rot.x * rot.y - rot.w * rot.z), 1.0f - 2.0f * (rot.x * rot.x + rot.z * rot.z), 2.0f * (rot.y * rot.z + rot.w * rot.x));
            final Vector3 trans = worldTransform.trans;
            if (trans != null) {
                E245.u(SoundManager.c, 0, new Q244(trans.x, trans.y, trans.z), new Q244(0.0f, 0.0f, 0.0f), new Q244(u.x, u.y, u.z), new Q244(vector3.x, vector3.y, vector3.z));
            }
        }
    }
    
    public static void w() {
    }
    
    public static void r() {
        v();
    }
    
    public static void v() {
        if (SoundManager.c != null) {
            ++SoundManager.an;
            SoundManager.logger.trace("SoundManager.serviceAudio()");
            G593.q();
            K589.q();
            X243.d();
            F594.j();
            H591.j();
            l();
            E245.t(SoundManager.c);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopMusic() {
        SoundManager.logger.trace("SoundManager.StopMusic()");
    }
    
    public static void u(final int n, final int n2, final int n3, final int n4, final boolean b, final int n5) {
    }
    
    public static void n() {
    }
    
    public static void k() {
        if (SoundManager.af) {
            final int g = U240.g(fmod.s);
            final int memoryUsed = fmod.getMemoryUsed();
            int n = 0;
            i("Num FMOD channels: " + g, n++);
            i("FMOD memory used : " + memoryUsed, n++);
        }
    }
    
    public static void m(final int n, final int n2, final int n3) {
    }
    
    public static void o() {
    }
    
    static C595[] f(String replace) {
        replace = replace.replace(" ", "");
        if (replace.length() == 0) {
            return null;
        }
        final String[] split = replace.split(",");
        final C595[] array = new C595[split.length];
        for (int i = 0; i < array.length; ++i) {
            final String[] split2 = split[i].split("=");
            if (split2.length == 2) {
                array[i] = new C595();
                array[i].g = split2[0];
                array[i].d = Integer.parseInt(split2[1]);
            }
        }
        return array;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int PlaySoundOnEntityAtTransform(final String s, final GameEntity gameEntity, final String s2, final RotTrans worldTransform) {
        SoundManager.logger.trace("Enter SoundManager.PlaySoundOnEntityAtTransform({}, {}, {}, {})", new Object[] { s, gameEntity, s2, worldTransform });
        SoundComponent soundComponent = (SoundComponent)GameEntity.eb(gameEntity, SoundComponent.class);
        if (soundComponent == null) {
            soundComponent = new SoundComponent();
            GameEntity.ep(gameEntity, soundComponent);
        }
        SoundAdapter soundAdapter;
        if (!soundComponent.hasSound(s)) {
            soundAdapter = soundComponent.addSoundAtTransform(s, s2, worldTransform);
        }
        else {
            soundAdapter = soundComponent.getSound(s);
            soundAdapter.setWorldTransform(worldTransform);
        }
        return ai(soundAdapter);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopSound(final int i) {
        SoundManager.logger.trace("SoundManager.StopSound({})", i);
        for (final X243 x243 : X243.ao()) {
            if (x243.t == i) {
                X243.f(x243);
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
    public static boolean IsSoundPlaying(final int i) {
        SoundManager.logger.trace("SoundManager.IsSoundPlaying({})", i);
        for (final X243 x243 : X243.ao()) {
            if (x243.t == i) {
                return X243.y(x243);
            }
        }
        return false;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetSoundParameter(final int i, final String s) {
        SoundManager.logger.trace("SoundManager.SetSoundParameter({}, {})", i, s);
        for (final X243 x243 : X243.ao()) {
            if (x243.t == i) {
                final C595[] f = f(s);
                if (f != null) {
                    for (final C595 c595 : f) {
                        x243.ag(c595.g, (float)c595.d);
                    }
                    break;
                }
                break;
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int Play2dSound(final String s, final int i, final String s2) {
        SoundManager.logger.trace("SoundManager.Play2dSound({}, {}, {})", new Object[] { s, i, s2 });
        return aq(s, i, s2);
    }
    
    public static int aq(final String s, final int n, final String s2) {
        int t = -1;
        if (SoundManager.af) {
            final X243 x = SoundManager.c.x(s, n);
            if (x != null) {
                t = x.t;
                final C595[] f = f(s2);
                if (f != null) {
                    for (final C595 c595 : f) {
                        x.ag(c595.g, (float)c595.d);
                    }
                }
            }
        }
        return t;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int PlaySoundOnEntity(final String s, final GameEntity gameEntity, final String s2) {
        SoundManager.logger.trace("Enter SoundManager.PlaySoundOnEntity({}, {}, {})", new Object[] { s, gameEntity, s2 });
        SoundComponent soundComponent = (SoundComponent)GameEntity.eb(gameEntity, SoundComponent.class);
        if (soundComponent == null) {
            soundComponent = new SoundComponent();
            GameEntity.ep(gameEntity, soundComponent);
        }
        SoundAdapter soundAdapter;
        if (!soundComponent.hasSound(s)) {
            soundAdapter = soundComponent.addSound(s, s2);
        }
        else {
            soundAdapter = soundComponent.getSound(s);
        }
        return ai(soundAdapter);
    }
    
    private static int ai(final SoundAdapter soundAdapter) {
        final float volume = soundAdapter.getVolume();
        final String name = soundAdapter.getName();
        final String params = soundAdapter.getParams();
        final Vector3 clientToServerPos = ClientScriptAPI.clientToServerPos(soundAdapter.getWorldTransform().trans);
        al(soundAdapter);
        final int av = av(name, clientToServerPos, params);
        SetSoundVolume(av, volume);
        SoundAdapter.d(soundAdapter, params, av);
        return av;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopSoundOnEntity(final String s, final GameEntity gameEntity) {
        SoundManager.logger.trace("Enter SoundManager.StopSoundOnEntity({}, {})", new Object[] { s, gameEntity });
        final SoundComponent soundComponent = (SoundComponent)GameEntity.eb(gameEntity, SoundComponent.class);
        if (soundComponent == null) {
            throw new RuntimeException("Failed to stop the sound on the GameEntity since there was no SoundComponent. Use 'PlaySoundOnEntity' first which ensure this.");
        }
        soundComponent.d(s);
    }
    
    private static void al(final SoundAdapter soundAdapter) {
        soundAdapter.addEventHandler("SoundTransformChangedEvent", new T596());
        soundAdapter.addEventHandler("SoundLinearVelocityChangedEvent", new D597());
        soundAdapter.addEventHandler("SoundAngularVelocityChangedEvent", new B598());
        soundAdapter.addEventHandler("SoundRemovedEvent", new W599());
        soundAdapter.addEventHandler("SoundStoppedEvent", new Al600());
        soundAdapter.addEventHandler("SoundVolumeChangedEvent", new Az601());
        soundAdapter.addEventHandler("SoundParamsChangedEvent", new Aq602());
    }
    
    private static void af(final SoundAdapter soundAdapter) {
        SoundAdapter.j(soundAdapter);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int Play3dSound(final String s, final float f, final float f2, final float f3, final String s2) {
        SoundManager.logger.trace("SoundManager.Play3dSound({}, {}, {}, {}, {})", new Object[] { s, f, f2, f3, s2 });
        return av(s, new Vector3(f, f2, f3), s2);
    }
    
    public static int av(final String s, final Vector3 vector3, final String s2) {
        int t = -1;
        if (SoundManager.af) {
            aw("SCRIPT", s);
            final X243 p3 = SoundManager.c.p(s, vector3.x, vector3.y, vector3.z);
            if (p3 != null) {
                final C595[] f = f(s2);
                if (f != null) {
                    for (final C595 c595 : f) {
                        p3.ag(c595.g, (float)c595.d);
                    }
                }
                t = p3.t;
            }
        }
        return t;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StartMusic(String s, final String s2) {
        if (s.contains("titlemusic")) {
            s = "Title";
        }
        if (s.contains("character")) {
            s = "CharacterSelect";
        }
        if (s.contains("battlemusic")) {
            s = "Exploration";
        }
        K589.h(s, s2);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetSoundParameterByName(final String s, final String s2) {
        SoundManager.logger.trace("SoundManager.SetSoundParameter({}, {})", s, s2);
        an(s, s2);
    }
    
    public static void ap(final String s, final String s2) {
    }
    
    static void j() {
        SoundManager.logger.trace("SoundManager.loadProjects()");
        for (final String str : String.valueOf(G593.h("projects.txt", true)).replace("\r", "").split("\n")) {
            if (str.length() > 0) {
                if (!str.replace(" ", "").startsWith("//")) {
                    final byte[] e = G593.e(str + ".fev", true);
                    if (e == null) {
                        SoundManager.logger.warn("Did not find (or could not download) fmod file %{}.fev in time to init the SoundManager. Does this file exist? If not you should remove it from the projects.txt file as it will cause a 30 second blocking delay to the client load.", str);
                    }
                    else {
                        if (str.contains("Safety")) {}
                        SoundManager.c.w(e);
                    }
                }
            }
        }
        h();
    }
    
    public static void a(final int n, final int n2) {
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetMusicParameter(final String s) {
        SoundManager.logger.trace("SoundManager.SetMusicParameter({})", s);
        K589.s(s);
    }
    
    public static void aa(final String s) {
        K589.s(s);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void script_SetAmbienceParameter(final String s) {
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetSoundVolume(final int i, final float f) {
        SoundManager.logger.trace("SoundManager.SetSoundVolume({}, {})", i, f);
        for (final X243 x243 : X243.ao()) {
            if (x243.t == i) {
                X243.i(x243, f);
                break;
            }
        }
    }
    
    public static void an(final String anObject, final String s) {
        if (SoundManager.af) {
            final C595[] f = f(s);
            if (f != null) {
                for (final F594 f2 : F594.g()) {
                    if (f2.h.equals(anObject)) {
                        for (final C595 c595 : f) {
                            f2.s.ag(c595.g, (float)c595.d);
                        }
                    }
                }
            }
        }
    }
    
    static int d(final String s) {
        final int l = StringTools.l(s);
        for (int i = 0; i < SoundManager.ah.length; ++i) {
            if (SoundManager.ah[i].g == l) {
                return SoundManager.ah[i].d;
            }
        }
        return 0;
    }
    
    public static void ag(final int n, final int n2, final String s) {
        if (SoundManager.af) {
            final X243 x = SoundManager.c.x(s(n), n2);
            if (x != null) {
                final C595[] f = f(s);
                if (f != null) {
                    for (final C595 c595 : f) {
                        x.ag(c595.g, (float)c595.d);
                    }
                }
            }
        }
    }
    
    public static void p(final int n, final int n2, final int n3, final int n4, final int n5) {
    }
    
    public static void as() {
        Y603.q();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void PreLoadBank(final String s) {
        SoundManager.logger.trace("SoundManager.PreLoadBank({})", s);
        ac(s);
    }
    
    public static void ac(final String s) {
        if (s.toLowerCase().endsWith(".fev")) {
            for (final Z256 z256 : E245.m(SoundManager.c)) {
                if (s.toLowerCase().startsWith(z256.j().d.toLowerCase())) {
                    final String[] e = z256.e();
                    for (int length2 = e.length, j = 0; j < length2; ++j) {
                        G593.d(e[j], 100000L);
                    }
                    break;
                }
            }
        }
        else if (s.toLowerCase().endsWith(".fsb")) {
            G593.d(s, 100000L);
        }
        else {
            final X243 r = SoundManager.c.r(s, 4);
            if (X243.h(r)) {
                final String[] aq = r.aq();
                for (int length3 = aq.length, k = 0; k < length3; ++k) {
                    G593.d(aq[k], 100000L);
                }
            }
        }
    }
    
    public static void at(final String s) {
    }
    
    private static void h() {
        if (SoundManager.c != null) {
            SoundManager.logger.trace("SoundManager.convertBankToCRC()");
            for (final Z256 z256 : E245.m(SoundManager.c)) {
                final String d = z256.j().d;
                for (final J251 j2 : Z256.q(z256)) {
                    e(j2, SoundManager.al, d + "/" + j2.s().d);
                }
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopAllLevelSounds() {
        for (final X243 x243 : X243.ao()) {
            if (x243 == Y603.g()) {
                continue;
            }
            if (x243.l().g().g.equalsIgnoreCase("Music")) {
                continue;
            }
            X243.f(x243);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void LoadWorldAudio(final String s) {
        F594.h(s);
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
    public static void SetMixerVolume(final String anotherString, final float n) {
        for (final M249 m249 : E245.d(SoundManager.c)) {
            if (m249.g().g.equalsIgnoreCase(anotherString)) {
                M249.d(m249, n);
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void DestroyVehicle(final GameEntity gameEntity) {
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
    public static void ShowPlayingSounds(final GameEntity gameEntity, final boolean am) {
        SoundManager.am = am;
    }
    
    static void aw(final String s, final String s2) {
        if (SoundManager.a) {}
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void ToggleEventNames() {
        SoundManager.a ^= true;
    }
    
    static {
        logger = LoggerFactory.getLogger(SoundManager.class);
        SoundManager.v = null;
        SoundManager.p = -1;
        SoundManager.x = false;
        SoundManager.z = -1;
        SoundManager.n = null;
        SoundManager.i = false;
        SoundManager.o = new Random();
        SoundManager.a = false;
        SoundManager.ag = "";
        SoundManager.aq = "R:\\WIP\\src\\sounds\\fmod\\";
        SoundManager.ai = new LinkedList();
        SoundManager.al = new Hashtable();
        SoundManager.af = false;
        SoundManager.av = null;
        SoundManager.az = new Hashtable();
        SoundManager.ah = null;
        SoundManager.ap = 0L;
        SoundManager.ao = 0;
        SoundManager.aa = 0;
        SoundManager.an = 0;
        SoundManager.am = false;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetSoundPosition(final int i, final float f, final float f2, final float f3) {
        SoundManager.logger.trace("SoundManager.SetSoundPosition({}, {}, {}, {})", new Object[] { i, f, f2, f3 });
        for (final X243 x243 : X243.ao()) {
            if (x243.t == i) {
                X243.u(x243, new Q244(f, f2, f3));
                break;
            }
        }
    }
    
    public static String s(final int value) {
        return SoundManager.al.get(new Integer(value));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void StopAmbience() {
        SoundManager.logger.trace("SoundManager.StopAmbience()");
        Y603.q();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetMood(final String s) {
        K589.s(s);
    }
    
    static void e(final J251 j251, final Hashtable hashtable, final String s) {
        SoundManager.logger.trace("SoundManager.addEventsToTable({})", j251);
        for (final J251 j252 : J251.j(j251)) {
            e(j252, hashtable, s + "/" + j252.s().d);
        }
        final X243[] e = J251.e(j251);
        for (int length2 = e.length, l = 0; l < length2; ++l) {
            final String string = s + "/" + X243.b(e[l]).d;
            hashtable.put(StringTools.l(string), string);
            for (final String str : SoundManager.c.n(string)) {
                if (str.startsWith("!")) {
                    SoundManager.logger.debug("Preloading audio bank" + str);
                    G593.d(str, 30000L);
                }
            }
        }
    }
    
    public static void ab() {
        final Z256[] m = E245.m(SoundManager.c);
        for (int length = m.length, i = 0; i < length; ++i) {
            Z256.s(m[i], true);
        }
    }
    
    public static void c(final int n, final Vector3 vector3, final String s) {
        if (SoundManager.af) {
            final X243 y = SoundManager.c.y(s(n), new Q244(vector3.x, vector3.y, vector3.z));
            final C595[] f = f(s);
            if (f != null) {
                for (final C595 c595 : f) {
                    y.ag(c595.g, (float)c595.d);
                }
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void PlayAmbience(final String s, final String s2) {
        SoundManager.logger.trace("SoundManager.PlayAmbience({}, {})", s, s2);
        Y603.d(s, s2);
    }
    
    public static void t(final int n, final int n2, final int n3) {
    }
    
    public static void z(final int n, final int n2, final int n3, final int n4, final float n5, final float n6, final float n7, final boolean b, final int n8) {
    }
    
    public static void am(final String s, final String s2) {
        Y603.d(s, s2);
    }
    
    public static void y() {
    }
    
    public static void x(final int n, final int n2, final int n3, final int n4, final float n5, final float n6, final float n7, final int n8) {
    }
}
