package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map.Entry;

public class R378 implements StateFactory {
   public K189 g() {
      return new K189();
   }

   public K189 d(K189 var1) {
      return new K189(var1);
   }

   public static void q(R378 var0, K189 var1, K189 var2, ByteBuffer var3) {
      int var4 = var3.position();
      int var5 = 0;
      int var11;
      if (var1 != null) {
         var3.mark();
         var3.put((byte)0);
         Iterator var6 = var1.g.keySet().iterator();

         while(var6.hasNext()) {
            Integer var7 = (Integer)var6.next();
            if (!var2.g.containsKey(var7)) {
               var3.putInt(var7);
               ++var5;
            }
         }

         if (var5 > 0) {
            var11 = var3.position();
            var3.reset();
            var3.put((byte)var5);
            var3.position(var11);
         }
      } else {
         var3.put((byte)0);
      }

      var11 = 0;
      var3.mark();
      var3.put((byte)0);
      Iterator var12 = var2.g.entrySet().iterator();

      while(true) {
         Entry var8;
         Object var9;
         Object var10;
         do {
            if (!var12.hasNext()) {
               if (var11 > 0) {
                  int var13 = var3.position();
                  var3.reset();
                  var3.put((byte)var11);
                  var3.position(var13);
               }

               boolean var14 = false;
               if (var1 == null) {
                  var14 = true;
               } else if (var1.q == null) {
                  if (var2.q != null) {
                     var14 = true;
                  }
               } else if (!var1.q.equals(var2.q)) {
                  var14 = true;
               }

               boolean var15 = false;
               if (var1 == null) {
                  var15 = true;
               } else if (var1.j == null) {
                  if (var2.j != null) {
                     var15 = true;
                  }
               } else if (!Av190.g(var1.j, var2.j)) {
                  var15 = true;
               }

               if (var5 == 0 && var11 == 0 && !var14 && !var15) {
                  var3.position(var4);
                  return;
               }

               if (!var14) {
                  var3.put((byte)0);
               } else if (var2.q == null) {
                  var3.put((byte)1);
               } else {
                  var3.put((byte)2);
                  var3.putInt(var2.q);
               }

               if (!var15) {
                  var3.put((byte)0);
               } else if (var2.j == null) {
                  var3.put((byte)1);
               } else {
                  var3.put((byte)2);
                  var3.putFloat(var2.j.g.x);
                  var3.putFloat(var2.j.g.y);
                  var3.putFloat(var2.j.g.z);
                  var3.putFloat(var2.j.d);
                  var3.putInt(var2.j.j);
                  var3.putFloat(var2.j.q);
               }

               return;
            }

            var8 = (Entry)var12.next();
            var9 = var8.getValue();
            if (var1 == null) {
               break;
            }

            var10 = var1.g.get(var8.getKey());
         } while(var9.equals(var10));

         var3.putInt((Integer)var8.getKey());
         var3.putInt((Integer)var2.d.get(var8.getKey()));
         if (var9 instanceof Boolean) {
            Boolean var16 = (Boolean)var9;
            var3.put((byte)(var16 ? 1 : 0));
         } else if (var9 instanceof Double) {
            Double var17 = (Double)var9;
            var3.put((byte)2);
            var3.putDouble(var17);
         }

         ++var11;
      }
   }

   public K189 j(K189 var1, ByteBuffer var2) {
      K189 var3;
      if (var1 == null) {
         var3 = new K189();
      } else {
         var3 = new K189(var1);
      }

      if (var2.remaining() == 0) {
         return var3;
      } else {
         int var4 = var2.get() & 255;

         int var5;
         int var6;
         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var2.getInt();
            var3.g.remove(var6);
            var3.d.remove(var6);
         }

         var5 = var2.get() & 255;

         int var7;
         for(var6 = 0; var6 < var5; ++var6) {
            var7 = var2.getInt();
            int var8 = var2.getInt();
            byte var9 = var2.get();
            switch(var9) {
            case 0:
               var3.g.put(var7, Boolean.FALSE);
               var3.d.put(var7, var8);
               break;
            case 1:
               var3.g.put(var7, Boolean.TRUE);
               var3.d.put(var7, var8);
               break;
            case 2:
               double var10 = var2.getDouble();
               var3.g.put(var7, var10);
               var3.d.put(var7, var8);
            }
         }

         var6 = var2.get() & 255;
         if (var6 == 0) {
            var3.q = var1 == null ? null : var1.q;
         } else if (var6 == 1) {
            var3.q = null;
         } else {
            var3.q = var2.getInt();
         }

         var7 = var2.get() & 255;
         if (var7 == 0) {
            var3.j = var1 == null ? null : var1.j;
         } else if (var7 == 1) {
            var3.j = null;
         } else {
            float var14 = var2.getFloat();
            float var15 = var2.getFloat();
            float var16 = var2.getFloat();
            float var11 = var2.getFloat();
            int var12 = var2.getInt();
            float var13 = var2.getFloat();
            var3.j = new Av190(new Vector3(var14, var15, var16), var11, var12, var13);
         }

         return var3;
      }
   }
}
