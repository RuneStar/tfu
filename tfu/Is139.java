package tfu;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class Is139 {
   private static final boolean g = true;
   private final File d;
   private long e;
   private final long j;
   private RandomAccessFile q;

   public static final int h(Is139 var0, byte[] var1, int var2, int var3) throws IOException {
      int var4 = var0.q.read(var1, var2, var3);
      if (var4 > 0) {
         var0.e += (long)var4;
      }

      return var4;
   }

   public static final File g(Is139 var0) {
      return var0.d;
   }

   public static final void d(Is139 var0, long var1) throws IOException {
      var0.q.seek(var1);
      var0.e = var1;
   }

   public static final long e(Is139 var0) throws IOException {
      return var0.q.length();
   }

   public static final void s(Is139 var0, long var1) throws IOException {
      if (var1 > var0.j - var0.e) {
         var1 = var0.j - var0.e;
      }

      var0.q.setLength(var1);
   }

   public Is139(File var1, String var2, long var3) throws IOException {
      if (var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if (var1.length() > var3) {
         System.out.println("Deleting: " + var1 + " as length exceeds maxlen - filelen:" + var1.length() + " maxlen:" + var3);
         var1.delete();
      }

      this.q = new RandomAccessFile(var1, var2);
      this.d = var1;
      this.j = var3;
      this.e = 0L;
      int var5 = this.q.read();
      if (var5 != -1 && !var2.equals("r")) {
         this.q.seek(0L);
         this.q.write(var5);
      }

      this.q.seek(0L);
   }

   protected void finalize() throws Throwable {
      if (this.q != null) {
         System.out.println("Warning! fileondisk " + this.d + " not closed correctly using close(). Auto-closing instead. ");
         j(this);
      }

   }

   public static void b(Is139 var0) throws IOException {
      var0.q.getFD().sync();
   }

   public static final void j(Is139 var0) throws IOException {
      if (var0.q != null) {
         var0.q.close();
         var0.q = null;
      }

   }

   public final void q(byte[] var1, int var2, int var3) throws IOException {
      if ((long)var3 + this.e > this.j) {
         this.q.seek(this.j);
         this.q.write(1);
         throw new EOFException();
      } else {
         this.q.write(var1, var2, var3);
         this.e += (long)var3;
      }
   }
}
