// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.net.URL;
import sun.net.www.protocol.http.AuthenticationInfo;
import java.net.InetSocketAddress;
import java.io.OutputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.io.IOException;
import java.net.Proxy;
import java.util.Collection;
import java.net.URISyntaxException;
import java.net.URI;
import java.net.Socket;
import java.net.ProxySelector;

public class Ix442 extends Jm443
{
    private static final String d = "java.net.useSystemProxies";
    private final ProxySelector g;
    
    @Override
    public Socket g() throws IOException {
        final boolean boolean1 = Boolean.parseBoolean(System.getProperty("java.net.useSystemProxies"));
        System.out.println("java.net.useSystemProxies: " + boolean1);
        if (!boolean1) {
            System.setProperty("java.net.useSystemProxies", "true");
        }
        final boolean b = super.e == 443;
        List<Proxy> select;
        List<Proxy> select2;
        try {
            select = this.g.select(new URI((b ? "https" : "http") + "://" + super.j));
            select2 = this.g.select(new URI((b ? "http" : "https") + "://" + super.j));
        }
        catch (URISyntaxException ex) {
            ex.printStackTrace();
            return this.b();
        }
        select.addAll(select2);
        final Object[] array = select.toArray();
        Jd444 jd444 = null;
        final Object[] array2 = array;
        for (int length = array2.length, i = 0; i < length; ++i) {
            final Proxy proxy = (Proxy)array2[i];
            try {
                final Socket d = this.d(proxy);
                if (d != null) {
                    System.out.println("Connected with " + proxy.toString());
                    return d;
                }
            }
            catch (Jd444 jd445) {
                System.out.println("Proxy auth failure: " + jd445.getMessage());
                jd444 = jd445;
            }
            catch (IOException ex2) {
                ex2.printStackTrace();
            }
            System.out.println("Failed to connect with " + proxy.toString());
        }
        if (jd444 != null) {
            throw jd444;
        }
        return this.b();
    }
    
    public Ix442() {
        this.g = ProxySelector.getDefault();
    }
    
    private Socket q(final String host, final int port, final String str) throws IOException {
        final Socket socket = new Socket(host, port);
        socket.setSoTimeout(10000);
        final OutputStream outputStream = socket.getOutputStream();
        if (str == null) {
            outputStream.write(("CONNECT " + super.j + ":" + super.e + " HTTP/1.0\n\n").getBytes(Charset.forName("ISO-8859-1")));
        }
        else {
            outputStream.write(("CONNECT " + super.j + ":" + super.e + " HTTP/1.0\n" + str + "\n\n").getBytes(Charset.forName("ISO-8859-1")));
        }
        outputStream.flush();
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final String line = bufferedReader.readLine();
        if (line != null) {
            if (line.startsWith("HTTP/1.0 200") || line.startsWith("HTTP/1.1 200")) {
                return socket;
            }
            if (line.startsWith("HTTP/1.0 407") || line.startsWith("HTTP/1.1 407")) {
                int n = 0;
                final String prefix = "proxy-authenticate: ";
                System.out.println("Authenticating Proxy!");
                for (String x = bufferedReader.readLine(); x != null && n < 50; x = bufferedReader.readLine(), ++n) {
                    System.out.println(x);
                    if (x.toLowerCase().startsWith(prefix)) {
                        String s = x.substring(prefix.length()).trim();
                        final int index = s.indexOf(32);
                        if (index != -1) {
                            s = s.substring(0, index);
                        }
                        throw new Jd444(s);
                    }
                }
                throw new Jd444("");
            }
            System.out.println("Got line from proxy: " + line);
        }
        outputStream.close();
        bufferedReader.close();
        socket.close();
        return null;
    }
    
    private Socket d(final Proxy proxy) throws IOException {
        if (proxy.type() == Proxy.Type.DIRECT) {
            return this.b();
        }
        final SocketAddress address = proxy.address();
        if (!(address instanceof InetSocketAddress)) {
            return null;
        }
        final InetSocketAddress inetSocketAddress = (InetSocketAddress)address;
        if (proxy.type() == Proxy.Type.HTTP) {
            String string = null;
            try {
                final Class<AuthenticationInfo> clazz = AuthenticationInfo.class;
                final Method declaredMethod = clazz.getDeclaredMethod("getProxyAuth", String.class, Integer.TYPE);
                declaredMethod.setAccessible(true);
                final Object invoke = declaredMethod.invoke(null, inetSocketAddress.getHostName(), new Integer(inetSocketAddress.getPort()));
                if (invoke != null) {
                    final Method declaredMethod2 = clazz.getDeclaredMethod("supportsPreemptiveAuthorization", (Class<?>[])new Class[0]);
                    declaredMethod2.setAccessible(true);
                    if (declaredMethod2.invoke(invoke, new Object[0])) {
                        final Method declaredMethod3 = clazz.getDeclaredMethod("getHeaderName", (Class<?>[])new Class[0]);
                        declaredMethod3.setAccessible(true);
                        final Method declaredMethod4 = clazz.getDeclaredMethod("getHeaderValue", URL.class, String.class);
                        declaredMethod4.setAccessible(true);
                        string = (String)declaredMethod3.invoke(invoke, new Object[0]) + ": " + (String)declaredMethod4.invoke(invoke, new URL("https://" + super.j + "/"), "https");
                    }
                }
                else {
                    System.out.println("No auth info!");
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Using auth: " + string);
            return this.q(inetSocketAddress.getHostName(), inetSocketAddress.getPort(), string);
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            final Socket socket = new Socket(proxy);
            socket.connect(new InetSocketAddress(super.j, super.e));
            return socket;
        }
        return null;
    }
}
