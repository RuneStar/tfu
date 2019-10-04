/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ks126;
import tfu.Kt125;

public class Ms517 {
    private static boolean d;
    private static final Logger logger;

    public DiscreteDynamicsWorld q(float f, Vector3 vector3) {
        Ms517.g();
        int n = 1;
        int n2 = 100000;
        int n3 = 100000;
        int n4 = 100;
        int n5 = 1000;
        int n6 = 1000;
        int n7 = 1000;
        DiscreteDynamicsWorld discreteDynamicsWorld = new DiscreteDynamicsWorld(n, n2, n3, n4, n5, n6, n7, f);
        discreteDynamicsWorld.d(vector3);
        return discreteDynamicsWorld;
    }

    public static Ms517 d() {
        if (!d) {
            Ms517.g();
            d = true;
        }
        return new Ms517();
    }

    private static void g() {
        Ks126 ks126 = Kt125.d();
        if (ks126.j("jagbullet") && !ks126.e("jagbullet")) {
            logger.info("Loading jagbullet!");
            if (!ks126.h("jagbullet")) {
                throw new RuntimeException("Failed to load jagbullet");
            }
        }
    }

    static {
        logger = LoggerFactory.getLogger(Ms517.class);
        d = false;
    }
}

