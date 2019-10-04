package rs2.client.login;

import com.jagex.game.runetek6.comms.statestream.packetchannel.NumberingPacketChannel;
import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import java.io.IOException;
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
   private static final Logger logger = LoggerFactory.getLogger(J570.class);

   static {
      d = ByteBuffer.wrap(new byte[65536]).order(ByteOrder.LITTLE_ENDIAN);
   }

   public static void g(int[] var0) {
      logger.info("Starting UDP login");
      client.cr = ByteBuffer.wrap(Mh508.g(Gc330.d(), var0));
      d.clear();
      client.dq.removeAllListeners();
      client.dq.removeAllStreams();
      client.dq.setChannel((PacketChannel)null);
      client.dh = null;
      client.dw = null;
   }

   public static boolean d() {
      if (client.cr != null) {
         try {
            int var0 = client.de.read(d);
            if (var0 > 0) {
               byte[] var1 = new byte[var0];
               d.clear();
               d.get(var1);
               client.de.pushBackPacket(var1);
               logger.info("Finishing UDP login");
               client.cr = null;
               client.dw = new NumberingPacketChannel(client.de);
               client.dq.setChannel(client.dw);
               client.dq.addListener(Lz409.d);
            }
         } catch (IOException var3) {
            return false;
         }
      }

      if (client.cr != null) {
         client.cr.rewind();

         try {
            client.de.write(client.cr);
         } catch (IOException var2) {
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
      client.dq.setChannel((PacketChannel)null);
      client.dh = null;
      client.dw = null;
   }
}
