// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.login;

import java.io.IOException;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizerListener;
import tfu.Lz409;
import com.jagex.game.runetek6.comms.statestream.packetchannel.NumberingPacketChannel;
import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import rs2.client.client;
import tfu.Mh508;
import tfu.Gc330;
import java.nio.ByteOrder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.nio.ByteBuffer;

public class J570
{
    static final ByteBuffer d;
    private static final Logger logger;
    
    static {
        logger = LoggerFactory.getLogger(J570.class);
        d = ByteBuffer.wrap(new byte[65536]).order(ByteOrder.LITTLE_ENDIAN);
    }
    
    public static void g(final int[] array) {
        J570.logger.info("Starting UDP login");
        client.cr = ByteBuffer.wrap(Mh508.g(Gc330.d(), array));
        J570.d.clear();
        client.dq.removeAllListeners();
        client.dq.removeAllStreams();
        client.dq.setChannel(null);
        client.dh = null;
        client.dw = null;
    }
    
    public static boolean d() {
        if (client.cr != null) {
            try {
                final int read = client.de.read(J570.d);
                if (read > 0) {
                    final byte[] dst = new byte[read];
                    J570.d.clear();
                    J570.d.get(dst);
                    client.de.pushBackPacket(dst);
                    J570.logger.info("Finishing UDP login");
                    client.cr = null;
                    client.dw = new NumberingPacketChannel(client.de);
                    client.dq.setChannel(client.dw);
                    client.dq.addListener(Lz409.d);
                }
            }
            catch (IOException ex) {
                return false;
            }
        }
        if (client.cr != null) {
            client.cr.rewind();
            try {
                client.de.write(client.cr);
            }
            catch (IOException ex2) {
                return false;
            }
        }
        return true;
    }
    
    public static void q() {
        client.cr = null;
        client.de = null;
        client.dq.removeAllListeners();
        client.dq.removeAllStreams();
        client.dq.setChannel(null);
        client.dh = null;
        client.dw = null;
    }
}
