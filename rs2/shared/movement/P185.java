// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.maths.Vector3;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.maths.I48;
import com.jagex.jnibindings.runetek6.jagbullet.B45;
import org.slf4j.Logger;

public class P185
{
    private static final Logger logger;
    float b;
    private B45 d;
    public float e;
    private float h;
    public float j;
    float l;
    public I48 p;
    private float q;
    float r;
    private boolean s;
    float v;
    float w;
    float y;
    
    public static float e(final P185 p) {
        return p.q;
    }
    
    public static void g(final P185 p2, final B45 d) {
        p2.d = d;
        h(p2, 0.0f);
        p2.b = d.az;
        p2.l = d.ah;
        p2.w = 1.0f;
        p2.r = 1.0f;
        p2.v = 1.0f;
        p2.y = 1.0f;
    }
    
    public void d(final BulletVehicle bulletVehicle, final float n, final float n2, final float e, final float n3, final float n4, final boolean s, final C184 c184) {
        this.e = e;
        if (this.d == null) {
            return;
        }
        final Vector3 al = Vector3.al(new Vector3(0.0f, 0.0f, 1.0f), bulletVehicle.e.as().q());
        float n5 = n;
        final float o = Vector3.o(al, bulletVehicle.e.l());
        if (o * e < -1.0f) {
            n5 = 0.0f;
        }
        final float n6 = (e > 0.0f) ? this.b : this.l;
        float n8;
        if (false) {
            final float n7 = 0.5f * n6;
            if (n5 < n7) {
                n8 = this.d.ag / (n5 + 0.001f);
            }
            else {
                n8 = this.d.ag * (n6 - n5) / (n7 * n7);
            }
        }
        else {
            final ArrayList list = (e >= 0.0f) ? this.d.ai : this.d.af;
            final ArrayList list2 = (e >= 0.0f) ? this.d.al : this.d.av;
            if (list2.size() > 0) {
                final float n9 = (e > 0.0f) ? this.w : this.v;
                final float n10 = (e > 0.0f) ? this.r : this.y;
                float n11 = (n10 != 0.0) ? (Math.abs(o) / n10) : 1000000.0f;
                if (o * e < -1.0f) {
                    n11 = 0.0f;
                }
                int n12;
                for (n12 = list2.size() - 1; n12 >= 0 && list2.get(n12) > n11; --n12) {}
                float floatValue;
                if (n12 == list2.size() - 1) {
                    floatValue = list.get(n12);
                }
                else if (n12 == -1) {
                    floatValue = list.get(0) * n11 / list2.get(0);
                }
                else {
                    floatValue = list.get(n12) + (list.get(n12 + 1) - list.get(n12)) * (n11 - list2.get(n12)) / (list2.get(n12 + 1) - list2.get(n12));
                }
                n8 = floatValue * n9 * bulletVehicle.e.q / this.d.x;
                if (n5 > n6) {
                    n8 = 0.0f;
                }
            }
            else {
                n8 = 0.0f;
            }
        }
        if (n8 < 0.0f) {
            n8 = 0.0f;
        }
        final float n13 = bulletVehicle.e.q * -DiscreteDynamicsWorld.af(bulletVehicle.q).y * this.d.v * (this.d.aq / 4.0f);
        if (n8 > n13) {
            n8 = n13;
        }
        int n14 = 0;
        if (this.d.ap) {
            n14 += 2;
        }
        if (this.d.ao) {
            n14 += 2;
        }
        float n15;
        if (n14 == 0) {
            n15 = 0.0f;
        }
        else {
            n15 = n8 / (n14 / 4.0f);
        }
        h(this, n15 * e * this.d.x);
        float au;
        if (n > this.d.ax) {
            au = this.d.au;
        }
        else {
            final float n16 = n / this.d.ax;
            au = (1.0f - n16) * this.d.ar + n16 * this.d.au;
        }
        final float n17 = au * this.d.aj * n2;
        final float n18 = au * n3;
        if (q(this) > n18) {
            j(this, q(this) - n17);
            if (q(this) < n18) {
                j(this, n18);
            }
        }
        if (q(this) < n18) {
            j(this, q(this) + n17);
            if (q(this) > n18) {
                j(this, n18);
            }
        }
        if (n4 > 0.0f) {
            float n19 = 0.0f;
            int n20 = 0;
            if (this.d.aa) {
                n19 += this.d.l;
                ++n20;
            }
            if (this.d.an) {
                n19 += this.d.v;
                ++n20;
            }
            if (n20 > 0) {
                this.h = n4 * this.d.ak * bulletVehicle.e.q * -DiscreteDynamicsWorld.af(bulletVehicle.q).y * (n19 / n20);
            }
            else {
                this.h = 0.0f;
            }
        }
        else {
            this.h = 0.0f;
        }
        this.s = s;
        final I48 d = I48.d();
        int n21 = 0;
        for (int i = 0; i < BulletVehicle.g(bulletVehicle); ++i) {
            final Vector3 m = bulletVehicle.m(i);
            if (Vector3.f(m) > 0.01f) {
                I48.i(d, m.x, m.y, m.z);
                ++n21;
            }
        }
        float n22;
        if (n21 > 0) {
            if (I48.c(d) > 0.0f) {
                I48.m(d);
            }
            n22 = this.d.bc;
        }
        else {
            I48.p(d, 0.0f, 1.0f, 0.0f);
            n22 = this.d.bz;
        }
        this.p.j = d.j * n22 + this.p.j * (1.0f - n22);
        this.p.e = d.e * n22 + this.p.e * (1.0f - n22);
        this.p.h = d.h * n22 + this.p.h * (1.0f - n22);
        if (I48.c(this.p) > 0.0f) {
            I48.m(this.p);
        }
        I48.y(d);
        bulletVehicle.v(this.p);
        final float q = q(this);
        if (c184 != null) {
            c184.d("vehicle.control", e(this), this.h, this.s, q);
        }
        bulletVehicle.d(e(this), this.h, this.s, q);
    }
    
    public static float q(final P185 p) {
        return p.j;
    }
    
    public P185() {
        this.q = 0.0f;
        this.j = 0.0f;
        this.e = 0.0f;
        this.h = 0.0f;
        this.b = 0.0f;
        this.l = 0.0f;
        this.w = 1.0f;
        this.r = 1.0f;
        this.v = 1.0f;
        this.y = 1.0f;
        this.p = new I48(0.0f, 1.0f, 0.0f);
    }
    
    public static void h(final P185 p2, final float q) {
        p2.q = q;
    }
    
    static {
        logger = LoggerFactory.getLogger(P185.class);
    }
    
    public static void j(final P185 p2, final float j) {
        p2.j = j;
    }
}
