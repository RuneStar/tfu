package tfu;

import java.io.IOException;
import java.net.Socket;

class Hu432 extends Hx339 {
   private static final boolean g = true;
   private Socket d;
   private Ht433 j;
   private Hy431 q;

   public void h() {
      Ht433.e(this.j);

      try {
         this.d.close();
      } catch (IOException var2) {
      }

      this.q.h();
   }

   public boolean d(int var1) throws IOException {
      return this.q.q(var1);
   }

   public void s() {
      this.q.s();
      this.j.h();
   }

   public int q() throws IOException {
      return this.q.j();
   }

   public void e(byte[] var1, int var2, int var3) throws IOException {
      this.j.j(var1, var2, var3);
   }

   public Hu432(Socket var1, int var2) throws IOException {
      this.d = var1;
      this.d.setSoTimeout(30000);
      this.d.setTcpNoDelay(true);
      this.q = new Hy431(this.d.getInputStream(), var2);
      this.j = new Ht433(this.d.getOutputStream(), var2);
   }

   public int j(byte[] var1, int var2, int var3) throws IOException {
      return this.q.e(var1, var2, var3);
   }

   protected void finalize() {
      this.h();
   }
}
