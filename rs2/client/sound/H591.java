/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import fmod.E245;
import fmod.Q244;
import fmod.X243;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rs2.client.ScriptCamera;
import rs2.client.sound.Ag588;
import rs2.client.sound.Ai683;
import rs2.client.sound.G593;
import rs2.client.sound.L681;
import rs2.client.sound.O678;
import rs2.client.sound.P679;
import rs2.client.sound.R676;
import rs2.client.sound.S677;
import rs2.client.sound.SoundManager;
import rs2.shared.movement.P185;
import rs2.shared.movement.PlayerPhysicsAvatar;
import rs2.shared.movement.PlayerPhysicsComponent;
import tfu.Bb4;
import tfu.Gz143;

public class H591 {
    public static boolean ac;
    protected static ArrayList ah;
    private static long am;
    static int at;
    public static float j;
    private ArrayList a;
    String aa = "";
    Vector3 ab;
    float ad = 50.0f;
    final float ae = 4200.0f;
    private float af = 0.5f;
    private Map ag;
    protected float ai = 0.7f;
    int aj = 1;
    int ak = 5;
    protected float al = 0.7f;
    X243 an = null;
    String ao = "";
    int ap = -1;
    String aq = "";
    int ar = 0;
    protected ScriptCamera as;
    float au = 0.0f;
    public Q244 av;
    int aw = 0;
    float ax = 0.0f;
    float ay = 0.0f;
    private GameEntity az = null;
    public String b = "";
    float bd = 4200.0f;
    float bl = 0.0f;
    float bm = 0.0f;
    float[] bo;
    float[] bq;
    private ArrayList c;
    public int d;
    public boolean e = false;
    private ArrayList f;
    public float g = 0.5f;
    String h = "";
    protected float i = 0.0f;
    protected float k = 0.0f;
    public boolean l = false;
    protected float m = 0.0f;
    protected float n = 0.0f;
    private ArrayList o;
    public int p = 500;
    public O678 q = O678.NOTREADY;
    public float r = 0.0f;
    public String s = "";
    protected int t;
    private float u = 0.0f;
    public float v = 0.0f;
    public float w = 500.0f;
    public int x = 4500;
    public float y = 0.0f;
    protected int z;

    static void r(H591 h591) {
        h591.ai += (h591.al - h591.ai) * (j * 2.0f);
        if (h591.e && h591.al == 0.0f && h591.ai < 0.05f) {
            for (P679 p679 : h591.o) {
                P679.g(p679);
            }
            if (h591.an != null) {
                X243.c(h591.an);
                h591.an = null;
            }
            h591.e = false;
            h591.q = O678.READY;
            ah.remove(h591);
        }
        if (h591.w < (float)h591.p) {
            h591.w = h591.p;
        }
        if (h591.w > (float)h591.x) {
            h591.w = h591.x;
        }
        h591.u = h591.w;
        if (h591.r == 0.0f) {
            h591.i = 1.0f;
            h591.k = 0.0f;
        }
        if (h591.r > 0.0f) {
            h591.k = h591.r;
            h591.i = 1.0f - h591.r;
        }
        if (h591.r < 0.0f) {
            h591.k = 1.0f - -h591.r;
            h591.i = -h591.r;
        }
        h591.m += (h591.k - h591.m) * 4.0f * j;
        h591.n += (h591.i - h591.n) * 4.0f * j;
        if (h591.q == O678.PLAYING) {
            h591.e = true;
            h591.d = 0;
            for (P679 p679 : h591.o) {
                P679.d(p679, h591.av);
                P679.q(p679, h591.u, h591.m, h591.n);
            }
            if (h591.d == 0) {
                boolean bl = false;
            }
        }
    }

    public static void g(GameEntity gameEntity) {
        for (H591 h591 : ah) {
            if (h591.az.bg != gameEntity.bg) continue;
            return;
        }
        H591 h591 = new H591();
        h591.az = gameEntity;
        h591.l = false;
        h591.ap = GameEntity.ev(gameEntity, "BotNumber", 36);
        ah.add(h591);
    }

    public static void d(GameEntity gameEntity) {
        for (H591 h591 : ah) {
            if (h591.az != gameEntity) continue;
            H591.w(h591);
        }
    }

    public static void j() {
        j = (float)(Gz143.g() - am) / 1000.0f;
        if (j > 0.25f) {
            j = 0.25f;
        }
        am = Gz143.g();
        at = ah.size();
        for (int i = H591.ah.size() - 1; i >= 0; --i) {
            H591 h591 = (H591)ah.get(i);
            h591.e();
        }
    }

    public static void q() {
        for (H591 h591 : ah) {
            H591.w(h591);
        }
    }

    static float h(H591 h591) {
        float f;
        if (h591.aj == h591.ak) {
            if (h591.bm < 500.0f) {
                h591.bm += 15.0f * j;
            }
        } else {
            h591.bm = 0.0f;
        }
        h591.bd = h591.au > 80.0f ? (h591.bd += (4200.0f + h591.bm + (h591.au - 80.0f) * 25.0f - (h591.bd + h591.bm)) * j) : (h591.bd += (4200.0f + h591.bm - (h591.bd + h591.bm)) * j);
        if (h591.bl > 0.0f) {
            h591.bl -= j;
            h591.ax += (0.0f - h591.ax) * 1.5f * j;
        } else {
            f = Math.abs(h591.r);
            if (h591.r < 0.0f) {
                h591.aj = 1;
            }
            if (h591.r != 0.0f) {
                h591.ax += (f *= j) / ((float)h591.aj * 4.0f) * (h591.aw == 0 ? 4.0f : 1.0f);
                if (h591.ax > 1.0f) {
                    if (h591.r > 0.0f) {
                        float f2 = h591.ax;
                        h591.ax -= h591.bq[h591.aj - 1];
                        if (h591.aj < h591.ak) {
                            ++h591.aj;
                            h591.bl = h591.bo[h591.aj - 1];
                            h591.ax = f2;
                            H591.v(h591, "GEAR");
                        } else {
                            h591.ax = 1.0f;
                        }
                    } else {
                        h591.ax = 1.0f;
                    }
                } else if (h591.ax < 0.0f) {
                    h591.ax = 1.0f;
                    --h591.aj;
                    H591.v(h591, "GEAR");
                    if (h591.aj == 0) {
                        h591.aj = 1;
                    }
                }
            } else {
                h591.aj = 1;
                h591.ax -= j * 0.5f;
                if (h591.au < 10.0f) {
                    h591.aj = 1;
                }
                if (h591.ax < 0.0f) {
                    if (h591.aj > 1) {
                        --h591.aj;
                        h591.ax += 0.8f;
                    } else {
                        h591.ax = 0.0f;
                    }
                }
            }
        }
        f = 500.0f + H591.s(h591, h591.ax * (h591.au / 80.0f)) * (h591.bd + h591.bm - 500.0f);
        h591.ay = (float)((double)h591.ay + Math.random() * 0.20000000298023224);
        return f;
    }

    static float s(H591 h591, float f) {
        return (float)Math.sin(f * 1.571f);
    }

    public H591() {
        this.o = new ArrayList();
        this.a = new ArrayList();
        this.f = new ArrayList();
        this.c = new ArrayList();
        this.ag = new HashMap();
        this.av = new Q244(0.0f, 0.0f, 0.0f);
        this.ab = new Vector3(0.0f, 0.0f, 0.0f);
        this.bq = new float[]{0.2f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f};
        this.bo = new float[]{0.5f, 0.5f, 0.4f, 0.4f, 0.3f, 0.3f, 0.2f, 0.2f, 0.1f};
    }

    public static void w(H591 h591) {
        H591.v(h591, "stop");
        h591.al = 0.0f;
    }

    public static void v(H591 h591, String string) {
        if (h591.ag.containsKey(string)) {
            L681 l681 = (L681)h591.ag.get(string);
            L681.g(l681, h591.av);
        }
    }

    void y(String string) {
        if (!string.equals("")) {
            int n;
            String[] arrstring;
            String[] arrstring2 = string.split(",");
            this.aq = arrstring2[0].replace("\\", "/");
            int n2 = Integer.parseInt(arrstring2[1]);
            this.z = Integer.parseInt(arrstring2[2]);
            this.t = Integer.parseInt(arrstring2[3]);
            int n3 = 4;
            this.o.clear();
            int n4 = 0;
            while (n4 < n2) {
                P679 p679 = new P679(this, this.ap, arrstring2[n3], this, this.p, this.x, this.z, this.t);
                p679.u = n4++;
                n3 = p679.j(arrstring2, n3);
                this.o.add(p679);
            }
            n4 = Integer.parseInt(arrstring2[n3++]);
            for (n = 0; n < n4; ++n) {
                arrstring = arrstring2[n3++];
                String[] arrstring3 = arrstring.split("\\|");
                this.ag.put(arrstring3[0], new L681(this, "VEHICLES/A" + this.ap + "/" + arrstring3[1], Float.parseFloat(arrstring3[2]), this));
            }
            this.aa = "VEHICLES/A" + this.ap + "/skidtype_06";
            n4 = Integer.parseInt(arrstring2[n3++]);
            for (n = 0; n < n4; ++n) {
                arrstring = new Ai683(this, this, this.p, this.x);
                n3 = Ai683.g((Ai683)arrstring, arrstring2, n3);
                this.a.add(arrstring);
            }
            this.c.clear();
            if (arrstring2[n3].equals("G")) {
                int n5 = ++n3;
                ++n3;
                n4 = Integer.parseInt(arrstring2[n5]);
                for (n = 0; n < n4; ++n) {
                    arrstring = arrstring2[n3++].split("\\|");
                    this.c.add(new R676(this, Float.parseFloat(arrstring[0]), Float.parseFloat(arrstring[1])));
                }
            } else {
                this.c.add(new R676(this, 0.0f, 0.0f));
                this.c.add(new R676(this, 1.0f, 1.0f));
            }
        }
    }

    static /* synthetic */ ArrayList p(H591 h591) {
        return h591.f;
    }

    static {
        j = 0.0f;
        ah = new ArrayList();
        ac = true;
        at = 0;
    }

    public static void l(H591 h591) {
        h591.e = true;
        h591.al = h591.g;
        h591.ai = 0.0f;
        h591.q = O678.PLAYING;
        H591.v(h591, "start");
        h591.ax = 0.5f;
        h591.aj = 3;
    }

    private void e() {
        if (this.az != null) {
            Vector3 vector3;
            Vector3 vector32 = vector3 = this.az.getWorldTransform().trans;
            ScriptCamera scriptCamera = ScriptCamera.getActiveCamera();
            if (scriptCamera != null) {
                vector32 = scriptCamera.getWorldTransform().trans;
            }
            if (Vector3.f(Vector3.k(vector32, vector3)) > 90.0f) {
                for (Object object2 : this.o) {
                    P679.g((P679)object2);
                }
                return;
            }
            this.av.g = vector3.x;
            this.av.d = vector3.y;
            this.av.q = vector3.z;
            Object object = this.f.iterator();
            while (object.hasNext()) {
                X243 x243 = (X243)object.next();
                if (!X243.y(x243)) {
                    this.f.remove(x243);
                    break;
                }
                X243.u(x243, this.av);
            }
            if ((object = (PlayerPhysicsComponent)GameEntity.eb(this.az, PlayerPhysicsComponent.class)) != null && ((PlayerPhysicsComponent)object).getAvatar(false) != null && object.getAvatar((boolean)false).b != null) {
                int n;
                Object object2;
                if (!this.e && (n = this.ap) != -1) {
                    this.s = Ag588.h(n);
                    this.b();
                    this.e = true;
                    H591.l(this);
                }
                object2 = object.getAvatar((boolean)false).b;
                this.ar = BulletVehicle.g((BulletVehicle)object2);
                boolean bl = false;
                this.aw = 0;
                for (int i = 0; i < this.ar; ++i) {
                    boolean bl2 = ((BulletVehicle)object2).e(i);
                    bl |= bl2;
                    if (!bl2) continue;
                    ++this.aw;
                }
                float f = Math.min(10.0f, Math.abs(((PlayerPhysicsComponent)object).vehicleGetWheelSlipSpeed(this.ar - 1)));
                if ((f /= 10.0f) >= 0.01f) {
                    if (this.an == null) {
                        this.an = E245.v(SoundManager.c, this.aa);
                        if (X243.h(this.an)) {
                            X243.i(this.an, bl ? f * this.af : 0.0f);
                            X243.u(this.an, this.av);
                            this.an.a();
                        } else {
                            this.an = null;
                        }
                    } else {
                        X243.i(this.an, bl ? f * this.af : 0.0f);
                        X243.u(this.an, this.av);
                    }
                } else if (this.an != null) {
                    X243.c(this.an);
                    this.an = null;
                }
                float f2 = Vector3.f(((BulletVehicle)object2).e.l());
                float f3 = Vector3.f(this.ab);
                Vector3 vector33 = ((BulletVehicle)object2).e.l();
                float f4 = Math.abs(vector33.y - this.ab.y);
                if (f4 > 3.0f) {
                    float f5 = Math.min(f4 / 10.0f, 1.0f) * this.g;
                    X243 x243 = SoundManager.c.y("VEHICLES/Generic/Vehicle_Landing", this.av);
                    if (X243.h(x243)) {
                        X243.i(x243, f5);
                        this.f.add(x243);
                    }
                }
                String[] arrstring = new String[]{"Light", "Medium", "Heavy"};
                float f6 = f2 - f3;
                if (f6 < -4.0f) {
                    X243 x243;
                    int n2 = 0;
                    if (f6 < -4.0f) {
                        n2 = 0;
                    }
                    if (f6 < -10.0f) {
                        n2 = 1;
                    }
                    if (f6 < -20.0f) {
                        n2 = 2;
                    }
                    if (f2 < f3 && X243.h(x243 = SoundManager.c.y("VEHICLES/Generic/Damage_" + arrstring[n2], this.av))) {
                        X243.i(x243, this.g);
                        this.f.add(x243);
                    }
                }
                this.ab = vector33;
                float f7 = object.getAvatar((boolean)false).w.e;
                f2 = f2 / 30.0f * 80.0f;
                this.au += (f2 - this.au) * 5.0f * j;
                this.r = f7 > 0.0f ? 1.0f : (f7 < 0.0f ? -1.0f : 0.0f);
                f3 = f2;
                this.w = H591.h(this);
            } else if (this.q == O678.PLAYING) {
                H591.w(this);
            }
            H591.r(this);
        }
    }

    public void b() {
        if (this.q != O678.NOTREADY) {
            return;
        }
        this.h = this.l && !this.b.equals("") ? this.b : this.s;
        S677 s677 = new S677(this);
        int n = this.ap;
        if (n != -1 && this.q == O678.NOTREADY) {
            String string = this.aq = Ag588.j(n).replace("\n", "");
            String string2 = string + ".fsb";
            G593.g(string2, 100000L, true, s677, this);
            this.q = O678.LOADING;
        }
    }
}

