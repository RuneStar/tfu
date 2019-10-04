package tfu;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class Hy431 implements Runnable {
   private InputStream d;
   private int e = 0;
   private Thread g;
   private int h = 0;
   private byte[] j;
   private int q;
   private IOException s;

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if (this.s != null) {
                  return;
               }

               if (this.e == 0) {
                  var1 = this.q - this.h - 1;
               } else if (this.e <= this.h) {
                  var1 = this.q - this.h;
               } else {
                  var1 = this.e - this.h - 1;
               }

               if (var1 > 0) {
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var9) {
               }
            }
         }

         int var2;
         try {
            var2 = this.d.read(this.j, this.h, var1);
            if (var2 == -1) {
               throw new EOFException();
            }
         } catch (IOException var10) {
            IOException var3 = var10;
            synchronized(this) {
               this.s = var3;
               return;
            }
         }

         synchronized(this) {
            this.h = (this.h + var2) % this.q;
         }
      }
   }

   Hy431(InputStream var1, int var2) {
      this.d = var1;
      this.q = var2 + 1;
      this.j = new byte[this.q];
      this.g = new Thread(this);
      this.g.setDaemon(true);
      this.g.setName("ClientStreamReader");
      this.g.start();
   }

   public boolean q(int var1) throws IOException {
      if (var1 > 0 && var1 < this.q) {
         synchronized(this) {
            int var3;
            if (this.e <= this.h) {
               var3 = this.h - this.e;
            } else {
               var3 = this.q - this.e + this.h;
            }

            if (var3 < var1) {
               if (this.s != null) {
                  throw new IOException(this.s.toString());
               } else {
                  this.notifyAll();
                  return false;
               }
            } else {
               return true;
            }
         }
      } else {
         throw new IOException();
      }
   }

   public int j() throws IOException {
      synchronized(this) {
         int var2;
         if (this.e <= this.h) {
            var2 = this.h - this.e;
         } else {
            var2 = this.q - this.e + this.h;
         }

         if (this.s != null) {
            throw new IOException(this.s.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   public int e(byte[] var1, int var2, int var3) throws IOException {
      if (var3 >= 0 && var2 >= 0 && var2 + var3 <= var1.length) {
         synchronized(this) {
            int var5;
            if (this.e <= this.h) {
               var5 = this.h - this.e;
            } else {
               var5 = this.q - this.e + this.h;
            }

            if (var3 > var5) {
               var3 = var5;
            }

            if (var3 == 0 && this.s != null) {
               throw new IOException(this.s.toString());
            } else {
               if (this.e + var3 <= this.q) {
                  System.arraycopy(this.j, this.e, var1, var2, var3);
               } else {
                  int var6 = this.q - this.e;
                  System.arraycopy(this.j, this.e, var1, var2, var6);
                  System.arraycopy(this.j, 0, var1, var2 + var6, var3 - var6);
               }

               this.e = (this.e + var3) % this.q;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   public void h() {
      synchronized(this) {
         if (this.s == null) {
            this.s = new IOException("Closed");
         }

         this.notifyAll();
      }

      try {
         this.g.join();
      } catch (InterruptedException var3) {
      }

   }

   public void s() {
      this.d = new Ho429();
   }
}
