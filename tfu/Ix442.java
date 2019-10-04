/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import sun.net.www.protocol.http.AuthenticationInfo;
import tfu.Jd444;
import tfu.Jm443;

public class Ix442
extends Jm443 {
    private static final String d = "java.net.useSystemProxies";
    private final ProxySelector g = ProxySelector.getDefault();

    @Override
    public Socket g() throws IOException {
        List<Proxy> list;
        List<Proxy> list2;
        boolean bl = Boolean.parseBoolean(System.getProperty(d));
        System.out.println("java.net.useSystemProxies: " + bl);
        if (!bl) {
            System.setProperty(d, "true");
        }
        boolean bl2 = this.e == 443;
        try {
            list = this.g.select(new URI((bl2 ? "https" : "http") + "://" + this.j));
            list2 = this.g.select(new URI((bl2 ? "http" : "https") + "://" + this.j));
        }
        catch (URISyntaxException uRISyntaxException) {
            uRISyntaxException.printStackTrace();
            return this.b();
        }
        list.addAll(list2);
        Object[] arrobject = list.toArray();
        Jd444 jd444 = null;
        for (Object object : arrobject) {
            Proxy proxy = (Proxy)object;
            try {
                Socket socket = this.d(proxy);
                if (socket != null) {
                    System.out.println("Connected with " + proxy.toString());
                    return socket;
                }
            }
            catch (Jd444 jd4442) {
                System.out.println("Proxy auth failure: " + jd4442.getMessage());
                jd444 = jd4442;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            System.out.println("Failed to connect with " + proxy.toString());
        }
        if (jd444 != null) {
            throw jd444;
        }
        return this.b();
    }

    private Socket q(String string, int n, String string2) throws IOException {
        Socket socket = new Socket(string, n);
        socket.setSoTimeout(10000);
        OutputStream outputStream = socket.getOutputStream();
        if (string2 == null) {
            outputStream.write(("CONNECT " + this.j + ":" + this.e + " HTTP/1.0\n\n").getBytes(Charset.forName("ISO-8859-1")));
        } else {
            outputStream.write(("CONNECT " + this.j + ":" + this.e + " HTTP/1.0\n" + string2 + "\n\n").getBytes(Charset.forName("ISO-8859-1")));
        }
        outputStream.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String string3 = bufferedReader.readLine();
        if (string3 != null) {
            if (string3.startsWith("HTTP/1.0 200") || string3.startsWith("HTTP/1.1 200")) {
                return socket;
            }
            if (string3.startsWith("HTTP/1.0 407") || string3.startsWith("HTTP/1.1 407")) {
                String string4 = "proxy-authenticate: ";
                System.out.println("Authenticating Proxy!");
                string3 = bufferedReader.readLine();
                for (int i = 0; string3 != null && i < 50; ++i) {
                    System.out.println(string3);
                    if (string3.toLowerCase().startsWith(string4)) {
                        int n2 = (string3 = string3.substring(string4.length()).trim()).indexOf(32);
                        if (n2 != -1) {
                            string3 = string3.substring(0, n2);
                        }
                        throw new Jd444(string3);
                    }
                    string3 = bufferedReader.readLine();
                }
                throw new Jd444("");
            }
            System.out.println("Got line from proxy: " + string3);
        }
        outputStream.close();
        bufferedReader.close();
        socket.close();
        return null;
    }

    private Socket d(Proxy proxy) throws IOException {
        if (proxy.type() == Proxy.Type.DIRECT) {
            return this.b();
        }
        SocketAddress socketAddress = proxy.address();
        if (!(socketAddress instanceof InetSocketAddress)) {
            return null;
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
        if (proxy.type() == Proxy.Type.HTTP) {
            String string = null;
            try {
                Class<AuthenticationInfo> class_ = AuthenticationInfo.class;
                Method method = class_.getDeclaredMethod("getProxyAuth", String.class, Integer.TYPE);
                method.setAccessible(true);
                Object object = method.invoke(null, inetSocketAddress.getHostName(), new Integer(inetSocketAddress.getPort()));
                if (object != null) {
                    Method method2 = class_.getDeclaredMethod("supportsPreemptiveAuthorization", new Class[0]);
                    method2.setAccessible(true);
                    if (((Boolean)method2.invoke(object, new Object[0])).booleanValue()) {
                        Method method3 = class_.getDeclaredMethod("getHeaderName", new Class[0]);
                        method3.setAccessible(true);
                        Method method4 = class_.getDeclaredMethod("getHeaderValue", URL.class, String.class);
                        method4.setAccessible(true);
                        String string2 = (String)method3.invoke(object, new Object[0]);
                        String string3 = (String)method4.invoke(object, new URL("https://" + this.j + "/"), "https");
                        string = string2 + ": " + string3;
                    }
                } else {
                    System.out.println("No auth info!");
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println("Using auth: " + string);
            return this.q(inetSocketAddress.getHostName(), inetSocketAddress.getPort(), string);
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            Socket socket = new Socket(proxy);
            socket.connect(new InetSocketAddress(this.j, this.e));
            return socket;
        }
        return null;
    }
}

