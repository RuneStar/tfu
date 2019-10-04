package tfu;

import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Ls502 {
   public static byte[] d = new byte[]{31, -117, 8, 0, 0, 0, 0, 0, 0, 0};
   private static final boolean g = false;
   CRC32 b;
   int e;
   int h;
   int j;
   Inflater l;
   public Gg3 q;
   Deflater s;

   public Ls502(int var1, int var2, int var3) {
      this.j = var1;
      this.e = var2;
      this.h = var3;
   }

   public void g(Gg3 var1, byte[] var2) {
      if (var1.r[var1.v] == 31 && var1.r[var1.v + 1] == -117) {
         if (this.l == null) {
            this.l = new Inflater(true);
         }

         try {
            this.l.setInput(var1.r, var1.v + 10, var1.r.length - (var1.v + 10 + 8));
            this.l.inflate(var2);
         } catch (Exception var4) {
            this.l.reset();
            throw new RuntimeException("");
         }

         this.l.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public Ls502() {
      this(-1, 1000000, 1000000);
   }
}
