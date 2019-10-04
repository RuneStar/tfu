// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;

public class Ms517
{
    private static boolean d;
    private static final Logger logger;
    
    public DiscreteDynamicsWorld q(final float n, final Vector3 vector3) {
        g();
        final DiscreteDynamicsWorld discreteDynamicsWorld = new DiscreteDynamicsWorld(1, 100000, 100000, 100, 1000, 1000, 1000, n);
        discreteDynamicsWorld.d(vector3);
        return discreteDynamicsWorld;
    }
    
    public static Ms517 d() {
        if (!Ms517.d) {
            g();
            Ms517.d = true;
        }
        return new Ms517();
    }
    
    private static void g() {
        final Ks126 d = Kt125.d();
        if (d.j("jagbullet") && !d.e("jagbullet")) {
            Ms517.logger.info("Loading jagbullet!");
            if (!d.h("jagbullet")) {
                throw new RuntimeException("Failed to load jagbullet");
            }
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(Ms517.class);
        Ms517.d = false;
    }
}
