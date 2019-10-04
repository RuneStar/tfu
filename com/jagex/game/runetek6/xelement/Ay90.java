package com.jagex.game.runetek6.xelement;

import com.jagex.jnibindings.runetek6.D91;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ay90 {
   private static final Logger logger = LoggerFactory.getLogger(Ay90.class);
   private Map d = new HashMap();
   private float q = 0.0F;

   public static float[] g(Ay90 var0, D91 var1) {
      float[] var2 = new float[var1.g()];
      Arrays.fill(var2, var0.q);
      Iterator var3 = var0.d.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         String var5 = (String)var4.getKey();
         int var6 = var1.d(var5);
         if (var6 != -1) {
            var2[var6] = (Float)var4.getValue();
         } else {
            logger.info("[blue]Unrecognised joint in skeleton mask: {}[/blue]", var5);
         }
      }

      return var2;
   }
}
