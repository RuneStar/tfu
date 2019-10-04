/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.B45;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.C184;

public class P185 {
    private static final Logger logger = LoggerFactory.getLogger(P185.class);
    float b = 0.0f;
    private B45 d;
    public float e = 0.0f;
    private float h = 0.0f;
    public float j = 0.0f;
    float l = 0.0f;
    public I48 p = new I48(0.0f, 1.0f, 0.0f);
    private float q = 0.0f;
    float r = 1.0f;
    private boolean s;
    float v = 1.0f;
    float w = 1.0f;
    float y = 1.0f;

    public static float e(P185 p185) {
        return p185.q;
    }

    public static void g(P185 p185, B45 b45) {
        p185.d = b45;
        P185.h(p185, 0.0f);
        p185.b = b45.az;
        p185.l = b45.ah;
        p185.w = 1.0f;
        p185.r = 1.0f;
        p185.v = 1.0f;
        p185.y = 1.0f;
    }

    public void d(BulletVehicle bulletVehicle, float f, float f2, float f3, float f4, float f5, boolean bl, C184 c184) {
        float f6;
        float f7;
        float f8;
        this.e = f3;
        if (this.d == null) {
            return;
        }
        Vector3 vector3 = new Vector3(0.0f, 0.0f, 1.0f);
        Quaternion quaternion = bulletVehicle.e.as().q();
        vector3 = Vector3.al(vector3, quaternion);
        float f9 = f;
        float f10 = Vector3.o(vector3, bulletVehicle.e.l());
        if (f10 * f3 < -1.0f) {
            f9 = 0.0f;
        }
        float f11 = f3 > 0.0f ? this.b : this.l;
        boolean bl2 = false;
        if (bl2) {
            f7 = 0.5f * f11;
            f6 = f9 < f7 ? this.d.ag / (f9 + 0.001f) : this.d.ag * (f11 - f9) / (f7 * f7);
        } else {
            ArrayList arrayList;
            ArrayList arrayList2 = f3 >= 0.0f ? this.d.ai : this.d.af;
            ArrayList arrayList3 = arrayList = f3 >= 0.0f ? this.d.al : this.d.av;
            if (arrayList.size() > 0) {
                float f12;
                int n;
                float f13 = f3 > 0.0f ? this.w : this.v;
                float f14 = f3 > 0.0f ? this.r : this.y;
                float f15 = f12 = (double)f14 != 0.0 ? Math.abs(f10) / f14 : 1000000.0f;
                if (f10 * f3 < -1.0f) {
                    f12 = 0.0f;
                }
                for (n = arrayList.size() - 1; n >= 0 && !(((Float)arrayList.get(n)).floatValue() <= f12); --n) {
                }
                float f16 = n == arrayList.size() - 1 ? ((Float)arrayList2.get(n)).floatValue() : (n == -1 ? ((Float)arrayList2.get(0)).floatValue() * f12 / ((Float)arrayList.get(0)).floatValue() : ((Float)arrayList2.get(n)).floatValue() + (((Float)arrayList2.get(n + 1)).floatValue() - ((Float)arrayList2.get(n)).floatValue()) * (f12 - ((Float)arrayList.get(n)).floatValue()) / (((Float)arrayList.get(n + 1)).floatValue() - ((Float)arrayList.get(n)).floatValue()));
                f6 = (f16 *= f13) * bulletVehicle.e.q / this.d.x;
                if (f9 > f11) {
                    f6 = 0.0f;
                }
            } else {
                f6 = 0.0f;
            }
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f6 > (f7 = bulletVehicle.e.q * -DiscreteDynamicsWorld.af((DiscreteDynamicsWorld)bulletVehicle.q).y * this.d.v * (this.d.aq / 4.0f))) {
            f6 = f7;
        }
        int n = 0;
        if (this.d.ap) {
            n += 2;
        }
        if (this.d.ao) {
            n += 2;
        }
        f6 = n == 0 ? 0.0f : (f6 /= (float)n / 4.0f);
        P185.h(this, (f6 *= f3) * this.d.x);
        f9 = 0.0f;
        if (f > this.d.ax) {
            f9 = this.d.au;
        } else {
            f10 = f / this.d.ax;
            f9 = (1.0f - f10) * this.d.ar + f10 * this.d.au;
        }
        f10 = f9 * this.d.aj * f2;
        f9 *= f4;
        if (P185.q(this) > f9) {
            P185.j(this, P185.q(this) - f10);
            if (P185.q(this) < f9) {
                P185.j(this, f9);
            }
        }
        if (P185.q(this) < f9) {
            P185.j(this, P185.q(this) + f10);
            if (P185.q(this) > f9) {
                P185.j(this, f9);
            }
        }
        if (f5 > 0.0f) {
            f9 = 0.0f;
            int n2 = 0;
            if (this.d.aa) {
                f9 += this.d.l;
                ++n2;
            }
            if (this.d.an) {
                f9 += this.d.v;
                ++n2;
            }
            this.h = n2 > 0 ? f5 * this.d.ak * bulletVehicle.e.q * -DiscreteDynamicsWorld.af((DiscreteDynamicsWorld)bulletVehicle.q).y * (f9 /= (float)n2) : 0.0f;
        } else {
            this.h = 0.0f;
        }
        this.s = bl;
        I48 i48 = I48.d();
        f10 = (float)false;
        for (int i = 0; i < BulletVehicle.g(bulletVehicle); ++i) {
            Vector3 vector32 = bulletVehicle.m(i);
            if (!(Vector3.f(vector32) > 0.01f)) continue;
            I48.i(i48, vector32.x, vector32.y, vector32.z);
            ++f10;
        }
        if (f10 > 0) {
            if (I48.c(i48) > 0.0f) {
                I48.m(i48);
            }
            f8 = this.d.bc;
        } else {
            I48.p(i48, 0.0f, 1.0f, 0.0f);
            f8 = this.d.bz;
        }
        this.p.j = i48.j * f8 + this.p.j * (1.0f - f8);
        this.p.e = i48.e * f8 + this.p.e * (1.0f - f8);
        this.p.h = i48.h * f8 + this.p.h * (1.0f - f8);
        if (I48.c(this.p) > 0.0f) {
            I48.m(this.p);
        }
        I48.y(i48);
        bulletVehicle.v(this.p);
        float f17 = P185.q(this);
        if (c184 != null) {
            c184.d("vehicle.control", Float.valueOf(P185.e(this)), Float.valueOf(this.h), this.s, Float.valueOf(f17));
        }
        bulletVehicle.d(P185.e(this), this.h, this.s, f17);
    }

    public static float q(P185 p185) {
        return p185.j;
    }

    public static void h(P185 p185, float f) {
        p185.q = f;
    }

    public static void j(P185 p185, float f) {
        p185.j = f;
    }
}

