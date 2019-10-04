/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.jnibindings.runetek6.Ping;
import java.io.IOException;
import rs2.client.Al161;

final class Q400
implements Runnable {
    Q400() {
    }

    @Override
    public void run() {
        while (Al161.j()) {
            Q400 q400 = this;
            synchronized (q400) {
                if (Al161.e() != null) {
                    try {
                        Al161.d = Ping.g(Al161.e(), 1000L);
                    }
                    catch (IOException iOException) {
                        Al161.d = -1;
                    }
                }
            }
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {}
        }
        Ping.quit();
    }
}

