package tfu;

import java.io.IOException;
import java.io.OutputStream;

class Ht433 implements Runnable {
   private boolean b;
   private OutputStream d;
   private int e = 0;
   private Thread g;
   private int h = 0;
   private byte[] j;
   private int q;
   private IOException s;

   public void h() {
      this.d = new Hj423();
   }

   private boolean q() {
      if (this.b) {
         try {
            this.d.close();
            if (this.s == null) {
               this.s = new IOException("Closed");
            }
         } catch (IOException var2) {
            if (this.s == null) {
               this.s = new IOException(var2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void run() {
      do {
         int var1;
         synchronized(this) {
            while(true) {
               if (this.s != null) {
                  return;
               }

               if (this.e <= this.h) {
                  var1 = this.h - this.e;
               } else {
                  var1 = this.q - this.e + this.h;
               }

               if (var1 > 0) {
                  break;
               }

               try {
                  this.d.flush();
               } catch (IOException var10) {
                  this.s = var10;
                  return;
               }

               if (this.q()) {
                  return;
               }

               try {
                  this.wait();
               } catch (InterruptedException var11) {
               }
            }
         }

         try {
            if (this.e + var1 <= this.q) {
               this.d.write(this.j, this.e, var1);
            } else {
               int var13 = this.q - this.e;
               this.d.write(this.j, this.e, var13);
               this.d.write(this.j, 0, var1 - var13);
            }
         } catch (IOException var9) {
            IOException var2 = var9;
            synchronized(this) {
               this.s = var2;
               return;
            }
         }

         synchronized(this) {
            this.e = (this.e + var1) % this.q;
         }
      } while(!this.q());

   }

   Ht433(OutputStream var1, int var2) {
      this.d = var1;
      this.q = var2 + 1;
      this.j = new byte[this.q];
      this.g = new Thread(this);
      this.g.setDaemon(true);
      this.g.setName("ClientStreamWriter");
      this.g.start();
   }

   public static void e(Ht433 var0) {
      synchronized(var0) {
         var0.b = true;
         var0.notifyAll();
      }

      try {
         var0.g.join();
      } catch (InterruptedException var3) {
      }

   }

   public void j(byte[] var1, int var2, int var3) throws IOException {
      if (var3 >= 0 && var2 >= 0 && var2 + var3 <= var1.length) {
         synchronized(this) {
            if (this.s != null) {
               throw new IOException(this.s.toString());
            } else {
               int var5;
               if (this.e <= this.h) {
                  var5 = this.q - this.h + this.e - 1;
               } else {
                  var5 = this.e - this.h - 1;
               }

               if (var5 < var3) {
                  throw new IOException("Buffer overflow " + var3 + " " + var5);
               } else {
                  if (this.h + var3 <= this.q) {
                     System.arraycopy(var1, var2, this.j, this.h, var3);
                  } else {
                     int var6 = this.q - this.h;
                     System.arraycopy(var1, var2, this.j, this.h, var6);
                     System.arraycopy(var1, var2 + var6, this.j, 0, var3 - var6);
                  }

                  this.h = (this.h + var3) % this.q;
                  this.notifyAll();
               }
            }
         }
      } else {
         throw new IOException();
      }
   }
}
