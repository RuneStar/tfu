package tfu;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Hashtable;

public class Dh131 {
   public static boolean d = false;
   private static final boolean g = false;
   private static Hashtable j = new Hashtable(16);
   private static File q;

   public static void g(File var0) {
      q = var0;
      if (!q.exists()) {
         throw new RuntimeException("");
      } else {
         d = true;
      }
   }

   public static File d(String var0) {
      if (!d) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)j.get(var0);
         if (var1 != null) {
            return var1;
         } else {
            File var2 = new File(q, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if (!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  j.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if (var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
               }

               throw new RuntimeException();
            }
         }
      }
   }
}
