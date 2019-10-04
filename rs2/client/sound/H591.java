// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import fmod.E245;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import rs2.shared.movement.PlayerPhysicsComponent;
import java.util.HashMap;
import tfu.Gz143;
import java.util.Iterator;
import com.jagex.game.runetek6.gameentity.GameEntity;
import fmod.Q244;
import rs2.client.ScriptCamera;
import fmod.X243;
import java.util.Map;
import com.jagex.maths.Vector3;
import java.util.ArrayList;

public class H591
{
    public static boolean ac;
    protected static ArrayList ah;
    private static long am;
    static int at;
    public static float j;
    private ArrayList a;
    String aa;
    Vector3 ab;
    float ad;
    final float ae = 4200.0f;
    private float af;
    private Map ag;
    protected float ai;
    int aj;
    int ak;
    protected float al;
    X243 an;
    String ao;
    int ap;
    String aq;
    int ar;
    protected ScriptCamera as;
    float au;
    public Q244 av;
    int aw;
    float ax;
    float ay;
    private GameEntity az;
    public String b;
    float bd;
    float bl;
    float bm;
    float[] bo;
    float[] bq;
    private ArrayList c;
    public int d;
    public boolean e;
    private ArrayList f;
    public float g;
    String h;
    protected float i;
    protected float k;
    public boolean l;
    protected float m;
    protected float n;
    private ArrayList o;
    public int p;
    public O678 q;
    public float r;
    public String s;
    protected int t;
    private float u;
    public float v;
    public float w;
    public int x;
    public float y;
    protected int z;
    
    static void r(final H591 o) {
        o.ai += (o.al - o.ai) * (H591.j * 2.0f);
        if (o.e && o.al == 0.0f && o.ai < 0.05f) {
            final Iterator<P679> iterator = o.o.iterator();
            while (iterator.hasNext()) {
                P679.g(iterator.next());
            }
            if (o.an != null) {
                X243.c(o.an);
                o.an = null;
            }
            o.e = false;
            o.q = O678.READY;
            H591.ah.remove(o);
        }
        if (o.w < o.p) {
            o.w = (float)o.p;
        }
        if (o.w > o.x) {
            o.w = (float)o.x;
        }
        o.u = o.w;
        if (o.r == 0.0f) {
            o.i = 1.0f;
            o.k = 0.0f;
        }
        if (o.r > 0.0f) {
            o.k = o.r;
            o.i = 1.0f - o.r;
        }
        if (o.r < 0.0f) {
            o.k = 1.0f - -o.r;
            o.i = -o.r;
        }
        o.m += (o.k - o.m) * 4.0f * H591.j;
        o.n += (o.i - o.n) * 4.0f * H591.j;
        if (o.q == O678.PLAYING) {
            o.e = true;
            o.d = 0;
            for (final P679 p : o.o) {
                P679.d(p, o.av);
                P679.q(p, o.u, o.m, o.n);
            }
            if (o.d == 0) {}
        }
    }
    
    public static void g(final GameEntity az) {
        final Iterator<H591> iterator = H591.ah.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().az.bg == az.bg) {
                return;
            }
        }
        final H591 e = new H591();
        e.az = az;
        e.l = false;
        e.ap = GameEntity.ev(az, "BotNumber", 36);
        H591.ah.add(e);
    }
    
    public static void d(final GameEntity gameEntity) {
        for (final H591 h591 : H591.ah) {
            if (h591.az == gameEntity) {
                w(h591);
            }
        }
    }
    
    public static void j() {
        H591.j = (Gz143.g() - H591.am) / 1000.0f;
        if (H591.j > 0.25f) {
            H591.j = 0.25f;
        }
        H591.am = Gz143.g();
        H591.at = H591.ah.size();
        for (int i = H591.ah.size() - 1; i >= 0; --i) {
            ((H591)H591.ah.get(i)).e();
        }
    }
    
    public static void q() {
        final Iterator<H591> iterator = H591.ah.iterator();
        while (iterator.hasNext()) {
            w(iterator.next());
        }
    }
    
    static float h(final H591 h591) {
        if (h591.aj == h591.ak) {
            if (h591.bm < 500.0f) {
                h591.bm += 15.0f * H591.j;
            }
        }
        else {
            h591.bm = 0.0f;
        }
        if (h591.au > 80.0f) {
            h591.bd += (4200.0f + h591.bm + (h591.au - 80.0f) * 25.0f - (h591.bd + h591.bm)) * H591.j;
        }
        else {
            h591.bd += (4200.0f + h591.bm - (h591.bd + h591.bm)) * H591.j;
        }
        if (h591.bl > 0.0f) {
            h591.bl -= H591.j;
            h591.ax += (0.0f - h591.ax) * 1.5f * H591.j;
        }
        else {
            final float abs = Math.abs(h591.r);
            if (h591.r < 0.0f) {
                h591.aj = 1;
            }
            if (h591.r != 0.0f) {
                h591.ax += abs * H591.j / (h591.aj * 4.0f) * ((h591.aw == 0) ? 4.0f : 1.0f);
                if (h591.ax > 1.0f) {
                    if (h591.r > 0.0f) {
                        final float ax = h591.ax;
                        h591.ax -= h591.bq[h591.aj - 1];
                        if (h591.aj < h591.ak) {
                            ++h591.aj;
                            h591.bl = h591.bo[h591.aj - 1];
                            h591.ax = ax;
                            v(h591, "GEAR");
                        }
                        else {
                            h591.ax = 1.0f;
                        }
                    }
                    else {
                        h591.ax = 1.0f;
                    }
                }
                else if (h591.ax < 0.0f) {
                    h591.ax = 1.0f;
                    --h591.aj;
                    v(h591, "GEAR");
                    if (h591.aj == 0) {
                        h591.aj = 1;
                    }
                }
            }
            else {
                h591.aj = 1;
                h591.ax -= H591.j * 0.5f;
                if (h591.au < 10.0f) {
                    h591.aj = 1;
                }
                if (h591.ax < 0.0f) {
                    if (h591.aj > 1) {
                        --h591.aj;
                        h591.ax += 0.8f;
                    }
                    else {
                        h591.ax = 0.0f;
                    }
                }
            }
        }
        final float n = 500.0f + s(h591, h591.ax * (h591.au / 80.0f)) * (h591.bd + h591.bm - 500.0f);
        h591.ay += (float)(Math.random() * 0.20000000298023224);
        return n;
    }
    
    static float s(final H591 h591, final float n) {
        return (float)Math.sin(n * 1.571f);
    }
    
    public H591() {
        this.g = 0.5f;
        this.q = O678.NOTREADY;
        this.e = false;
        this.h = "";
        this.s = "";
        this.b = "";
        this.l = false;
        this.w = 500.0f;
        this.r = 0.0f;
        this.v = 0.0f;
        this.y = 0.0f;
        this.p = 500;
        this.x = 4500;
        this.u = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.k = 0.0f;
        this.i = 0.0f;
        this.o = new ArrayList();
        this.a = new ArrayList();
        this.f = new ArrayList();
        this.c = new ArrayList();
        this.ag = new HashMap();
        this.aq = "";
        this.ai = 0.7f;
        this.al = 0.7f;
        this.af = 0.5f;
        this.av = new Q244(0.0f, 0.0f, 0.0f);
        this.az = null;
        this.ap = -1;
        this.ao = "";
        this.aa = "";
        this.an = null;
        this.ab = new Vector3(0.0f, 0.0f, 0.0f);
        this.aw = 0;
        this.ar = 0;
        this.ax = 0.0f;
        this.au = 0.0f;
        this.aj = 1;
        this.ak = 5;
        this.ay = 0.0f;
        this.ad = 50.0f;
        this.bd = 4200.0f;
        this.bm = 0.0f;
        this.bq = new float[] { 0.2f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f };
        this.bo = new float[] { 0.5f, 0.5f, 0.4f, 0.4f, 0.3f, 0.3f, 0.2f, 0.2f, 0.1f };
        this.bl = 0.0f;
    }
    
    public static void w(final H591 h591) {
        v(h591, "stop");
        h591.al = 0.0f;
    }
    
    public static void v(final H591 h591, final String s) {
        if (h591.ag.containsKey(s)) {
            L681.g(h591.ag.get(s), h591.av);
        }
    }
    
    void y(final String s) {
        if (!s.equals("")) {
            final String[] split = s.split(",");
            this.aq = split[0].replace("\\", "/");
            final int int1 = Integer.parseInt(split[1]);
            this.z = Integer.parseInt(split[2]);
            this.t = Integer.parseInt(split[3]);
            int n = 4;
            this.o.clear();
            for (int i = 0; i < int1; ++i) {
                final P679 e = new P679(this, this.ap, split[n], this, this.p, this.x, this.z, this.t);
                e.u = i;
                n = e.j(split, n);
                this.o.add(e);
            }
            for (int int2 = Integer.parseInt(split[n++]), j = 0; j < int2; ++j) {
                final String[] split2 = split[n++].split("\\|");
                this.ag.put(split2[0], new L681(this, "VEHICLES/A" + this.ap + "/" + split2[1], Float.parseFloat(split2[2]), this));
            }
            this.aa = "VEHICLES/A" + this.ap + "/skidtype_06";
            for (int int3 = Integer.parseInt(split[n++]), k = 0; k < int3; ++k) {
                final Ai683 e2 = new Ai683(this, this, this.p, this.x);
                n = Ai683.g(e2, split, n);
                this.a.add(e2);
            }
            this.c.clear();
            if (split[n].equals("G")) {
                ++n;
                for (int int4 = Integer.parseInt(split[n++]), l = 0; l < int4; ++l) {
                    final String[] split3 = split[n++].split("\\|");
                    this.c.add(new R676(this, Float.parseFloat(split3[0]), Float.parseFloat(split3[1])));
                }
            }
            else {
                this.c.add(new R676(this, 0.0f, 0.0f));
                this.c.add(new R676(this, 1.0f, 1.0f));
            }
        }
    }
    
    static {
        H591.j = 0.0f;
        H591.ah = new ArrayList();
        H591.ac = true;
        H591.at = 0;
    }
    
    public static void l(final H591 h591) {
        h591.e = true;
        h591.al = h591.g;
        h591.ai = 0.0f;
        h591.q = O678.PLAYING;
        v(h591, "start");
        h591.ax = 0.5f;
        h591.aj = 3;
    }
    
    private void e() {
        if (this.az != null) {
            Vector3 vector4;
            final Vector3 vector3 = vector4 = this.az.getWorldTransform().trans;
            final ScriptCamera activeCamera = ScriptCamera.getActiveCamera();
            if (activeCamera != null) {
                vector4 = activeCamera.getWorldTransform().trans;
            }
            if (Vector3.f(Vector3.k(vector4, vector3)) > 90.0f) {
                final Iterator<P679> iterator = (Iterator<P679>)this.o.iterator();
                while (iterator.hasNext()) {
                    P679.g(iterator.next());
                }
                return;
            }
            this.av.g = vector3.x;
            this.av.d = vector3.y;
            this.av.q = vector3.z;
            for (final X243 o : this.f) {
                if (!X243.y(o)) {
                    this.f.remove(o);
                    break;
                }
                X243.u(o, this.av);
            }
            final PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(this.az, PlayerPhysicsComponent.class);
            if (playerPhysicsComponent != null && playerPhysicsComponent.getAvatar(false) != null && playerPhysicsComponent.getAvatar(false).b != null) {
                if (!this.e) {
                    final int ap = this.ap;
                    if (ap != -1) {
                        this.s = Ag588.h(ap);
                        this.b();
                        this.e = true;
                        l(this);
                    }
                }
                final BulletVehicle b = playerPhysicsComponent.getAvatar(false).b;
                this.ar = BulletVehicle.g(b);
                int n = 0;
                this.aw = 0;
                for (int i = 0; i < this.ar; ++i) {
                    final boolean e = b.e(i);
                    n |= (e ? 1 : 0);
                    if (e) {
                        ++this.aw;
                    }
                }
                final float n2 = Math.min(10.0f, Math.abs(playerPhysicsComponent.vehicleGetWheelSlipSpeed(this.ar - 1))) / 10.0f;
                if (n2 >= 0.01f) {
                    if (this.an == null) {
                        this.an = E245.v(SoundManager.c, this.aa);
                        if (X243.h(this.an)) {
                            X243.i(this.an, (n != 0) ? (n2 * this.af) : 0.0f);
                            X243.u(this.an, this.av);
                            this.an.a();
                        }
                        else {
                            this.an = null;
                        }
                    }
                    else {
                        X243.i(this.an, (n != 0) ? (n2 * this.af) : 0.0f);
                        X243.u(this.an, this.av);
                    }
                }
                else if (this.an != null) {
                    X243.c(this.an);
                    this.an = null;
                }
                final float f = Vector3.f(b.e.l());
                final float f2 = Vector3.f(this.ab);
                final Vector3 l = b.e.l();
                final float abs = Math.abs(l.y - this.ab.y);
                if (abs > 3.0f) {
                    final float n3 = Math.min(abs / 10.0f, 1.0f) * this.g;
                    final X243 y = SoundManager.c.y("VEHICLES/Generic/Vehicle_Landing", this.av);
                    if (X243.h(y)) {
                        X243.i(y, n3);
                        this.f.add(y);
                    }
                }
                final String[] array = { "Light", "Medium", "Heavy" };
                final float n4 = f - f2;
                if (n4 < -4.0f) {
                    int n5 = 0;
                    if (n4 < -4.0f) {
                        n5 = 0;
                    }
                    if (n4 < -10.0f) {
                        n5 = 1;
                    }
                    if (n4 < -20.0f) {
                        n5 = 2;
                    }
                    if (f < f2) {
                        final X243 y2 = SoundManager.c.y("VEHICLES/Generic/Damage_" + array[n5], this.av);
                        if (X243.h(y2)) {
                            X243.i(y2, this.g);
                            this.f.add(y2);
                        }
                    }
                }
                this.ab = l;
                final float e2 = playerPhysicsComponent.getAvatar(false).w.e;
                this.au += (f / 30.0f * 80.0f - this.au) * 5.0f * H591.j;
                if (e2 > 0.0f) {
                    this.r = 1.0f;
                }
                else if (e2 < 0.0f) {
                    this.r = -1.0f;
                }
                else {
                    this.r = 0.0f;
                }
                this.w = h(this);
            }
            else if (this.q == O678.PLAYING) {
                w(this);
            }
            r(this);
        }
    }
    
    public void b() {
        if (this.q != O678.NOTREADY) {
            return;
        }
        if (this.l && !this.b.equals("")) {
            this.h = this.b;
        }
        else {
            this.h = this.s;
        }
        final S677 s677 = new S677(this);
        final int ap = this.ap;
        if (ap != -1 && this.q == O678.NOTREADY) {
            final String replace = Ag588.j(ap).replace("\n", "");
            this.aq = replace;
            G593.g(replace + ".fsb", 100000L, true, s677, this);
            this.q = O678.LOADING;
        }
    }
}
