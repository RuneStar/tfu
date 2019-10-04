/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.login;

import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizerListener;
import com.jagex.game.runetek6.comms.statestream.packetchannel.DelayableUDPPacketChannel;
import com.jagex.game.runetek6.comms.statestream.packetchannel.NumberingPacketChannel;
import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import com.jagex.game.runetek6.comms.statestream.packetchannel.UDPPacketChannelClient;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import tfu.Gc330;
import tfu.Lz409;
import tfu.Mh508;

public class J570 {
    static final ByteBuffer d;
    private static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(J570.class);
        d = ByteBuffer.wrap(new byte[65536]).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static void g(int[] arrn) {
        logger.info("Starting UDP login");
        client.cr = ByteBuffer.wrap(Mh508.g(Gc330.d(), arrn));
        d.clear();
        client.dq.removeAllListeners();
        client.dq.removeAllStreams();
        client.dq.setChannel(null);
        client.dh = null;
        client.dw = null;
    }

    public static boolean d() {
        if (client.cr != null) {
            try {
                int n = client.de.read(d);
                if (n > 0) {
                    byte[] arrby = new byte[n];
                    d.clear();
                    d.get(arrby);
                    client.de.pushBackPacket(arrby);
                    logger.info("Finishing UDP login");
                    client.cr = null;
                    client.dw = new NumberingPacketChannel(client.de);
                    client.dq.setChannel(client.dw);
                    client.dq.addListener(Lz409.d);
                }
            }
            catch (IOException iOException) {
                return false;
            }
        }
        if (client.cr != null) {
            client.cr.rewind();
            try {
                client.de.write(client.cr);
            }
            catch (IOException iOException) {
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

