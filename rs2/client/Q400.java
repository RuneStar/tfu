// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import java.io.IOException;
import com.jagex.jnibindings.runetek6.Ping;

final class Q400 implements Runnable
{
    @Override
    public void run() {
        while (Al161.j) {
            synchronized (this) {
                if (Al161.q != null) {
                    try {
                        Al161.d = Ping.g(Al161.q, 1000L);
                    }
                    catch (IOException ex) {
                        Al161.d = -1;
                    }
                }
            }
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex2) {}
        }
        Ping.quit();
    }
}
