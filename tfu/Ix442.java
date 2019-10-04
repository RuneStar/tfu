package tfu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.Proxy.Type;
import java.nio.charset.Charset;
import java.util.List;
import sun.net.www.protocol.http.AuthenticationInfo;

public class Ix442 extends Jm443 {
   private static final String d = "java.net.useSystemProxies";
   private final ProxySelector g = ProxySelector.getDefault();

   public Socket g() throws IOException {
      boolean var1 = Boolean.parseBoolean(System.getProperty("java.net.useSystemProxies"));
      System.out.println("java.net.useSystemProxies: " + var1);
      if (!var1) {
         System.setProperty("java.net.useSystemProxies", "true");
      }

      boolean var4 = super.e == 443;

      List var2;
      List var3;
      try {
         var2 = this.g.select(new URI((var4 ? "https" : "http") + "://" + super.j));
         var3 = this.g.select(new URI((var4 ? "http" : "https") + "://" + super.j));
      } catch (URISyntaxException var15) {
         var15.printStackTrace();
         return this.b();
      }

      var2.addAll(var3);
      Object[] var5 = var2.toArray();
      Jd444 var6 = null;
      Object[] var7 = var5;
      int var8 = var5.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         Object var10 = var7[var9];
         Proxy var11 = (Proxy)var10;

         try {
            Socket var12 = this.d(var11);
            if (var12 != null) {
               System.out.println("Connected with " + var11.toString());
               return var12;
            }
         } catch (Jd444 var13) {
            System.out.println("Proxy auth failure: " + var13.getMessage());
            var6 = var13;
         } catch (IOException var14) {
            var14.printStackTrace();
         }

         System.out.println("Failed to connect with " + var11.toString());
      }

      if (var6 != null) {
         throw var6;
      } else {
         return this.b();
      }
   }

   private Socket q(String var1, int var2, String var3) throws IOException {
      Socket var4 = new Socket(var1, var2);
      var4.setSoTimeout(10000);
      OutputStream var5 = var4.getOutputStream();
      if (var3 == null) {
         var5.write(("CONNECT " + super.j + ":" + super.e + " HTTP/1.0\n\n").getBytes(Charset.forName("ISO-8859-1")));
      } else {
         var5.write(("CONNECT " + super.j + ":" + super.e + " HTTP/1.0\n" + var3 + "\n\n").getBytes(Charset.forName("ISO-8859-1")));
      }

      var5.flush();
      BufferedReader var6 = new BufferedReader(new InputStreamReader(var4.getInputStream()));
      String var7 = var6.readLine();
      if (var7 != null) {
         label53: {
            if (!var7.startsWith("HTTP/1.0 200") && !var7.startsWith("HTTP/1.1 200")) {
               if (!var7.startsWith("HTTP/1.0 407") && !var7.startsWith("HTTP/1.1 407")) {
                  System.out.println("Got line from proxy: " + var7);
                  break label53;
               }

               int var8 = 0;
               String var9 = "proxy-authenticate: ";
               System.out.println("Authenticating Proxy!");

               for(var7 = var6.readLine(); var7 != null && var8 < 50; ++var8) {
                  System.out.println(var7);
                  if (var7.toLowerCase().startsWith(var9)) {
                     var7 = var7.substring(var9.length()).trim();
                     int var10 = var7.indexOf(32);
                     if (var10 != -1) {
                        var7 = var7.substring(0, var10);
                     }

                     throw new Jd444(var7);
                  }

                  var7 = var6.readLine();
               }

               throw new Jd444("");
            }

            return var4;
         }
      }

      var5.close();
      var6.close();
      var4.close();
      return null;
   }

   private Socket d(Proxy var1) throws IOException {
      if (var1.type() == Type.DIRECT) {
         return this.b();
      } else {
         SocketAddress var2 = var1.address();
         if (!(var2 instanceof InetSocketAddress)) {
            return null;
         } else {
            InetSocketAddress var3 = (InetSocketAddress)var2;
            if (var1.type() == Type.HTTP) {
               String var14 = null;

               try {
                  Class var5 = AuthenticationInfo.class;
                  Method var6 = var5.getDeclaredMethod("getProxyAuth", String.class, Integer.TYPE);
                  var6.setAccessible(true);
                  Object var7 = var6.invoke((Object)null, var3.getHostName(), new Integer(var3.getPort()));
                  if (var7 != null) {
                     Method var8 = var5.getDeclaredMethod("supportsPreemptiveAuthorization");
                     var8.setAccessible(true);
                     if ((Boolean)var8.invoke(var7)) {
                        Method var9 = var5.getDeclaredMethod("getHeaderName");
                        var9.setAccessible(true);
                        Method var10 = var5.getDeclaredMethod("getHeaderValue", URL.class, String.class);
                        var10.setAccessible(true);
                        String var11 = (String)var9.invoke(var7);
                        String var12 = (String)var10.invoke(var7, new URL("https://" + super.j + "/"), "https");
                        var14 = var11 + ": " + var12;
                     }
                  } else {
                     System.out.println("No auth info!");
                  }
               } catch (Exception var13) {
                  var13.printStackTrace();
               }

               System.out.println("Using auth: " + var14);
               return this.q(var3.getHostName(), var3.getPort(), var14);
            } else if (var1.type() == Type.SOCKS) {
               Socket var4 = new Socket(var1);
               var4.connect(new InetSocketAddress(super.j, super.e));
               return var4;
            } else {
               return null;
            }
         }
      }
   }
}
