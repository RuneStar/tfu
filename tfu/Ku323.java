// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.DataInputStream;
import java.net.URL;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.applet.Applet;

public class Ku323 extends RuntimeException
{
    private static final boolean d = true;
    public static int e;
    private static final boolean g = true;
    public static int h;
    public static String j;
    public static long q;
    public static Applet s;
    private String b;
    private Throwable l;
    
    private Ku323(final Throwable l, final String b) {
        this.b = b;
        this.initCause(this.l = l);
    }
    
    public static String d(Throwable l) throws IOException {
        String s;
        if (l instanceof Ku323) {
            final Ku323 ku323 = (Ku323)l;
            s = ku323.b + " | ";
            l = ku323.l;
        }
        else {
            s = "";
        }
        final StringWriter out = new StringWriter();
        final PrintWriter s2 = new PrintWriter(out);
        l.printStackTrace(s2);
        s2.close();
        final BufferedReader bufferedReader = new BufferedReader(new StringReader(out.toString()));
        final String line = bufferedReader.readLine();
        while (true) {
            final String line2 = bufferedReader.readLine();
            if (line2 == null) {
                break;
            }
            final int index = line2.indexOf(40);
            final int index2 = line2.indexOf(41, index + 1);
            String substring;
            if (index != -1) {
                substring = line2.substring(0, index);
            }
            else {
                substring = line2;
            }
            final String trim = substring.trim();
            final String substring2 = trim.substring(trim.lastIndexOf(32) + 1);
            String s3 = s + substring2.substring(substring2.lastIndexOf(9) + 1);
            if (index != -1 && index2 != -1) {
                final int index3 = line2.indexOf(".java:", index);
                if (index3 >= 0) {
                    s3 += line2.substring(index3 + 5, index2);
                }
            }
            s = s3 + ' ';
        }
        return s + "| " + line;
    }
    
    private static final void q(final String s) {
        System.out.println("Error: " + j(s, "%0a", "\n"));
    }
    
    private static final String j(String string, final String s, final String str) {
        for (int i = string.indexOf(s); i != -1; i = string.indexOf(s, i + str.length())) {
            string = string.substring(0, i) + str + string.substring(i + s.length());
        }
        return string;
    }
    
    public static void g(final String str, final Throwable t) {
        try {
            String s = "";
            if (t != null) {
                s = d(t);
            }
            if (str != null) {
                if (t != null) {
                    s += " | ";
                }
                s += str;
            }
            q(s);
            final String d = Mi507.d(s);
            if (Ku323.s == null) {
                return;
            }
            String property = "Unknown";
            String property2 = "1.1";
            try {
                property = System.getProperty("java.vendor");
                property2 = System.getProperty("java.version");
            }
            catch (Exception ex2) {}
            final DataInputStream dataInputStream = new DataInputStream(new URL(Ku323.s.getCodeBase(), "clienterror.ws?c=" + Ku323.e + "&cs=" + Ku323.h + "&u=" + ((Ku323.j != null) ? Mi507.d(Ku323.j) : ("" + Ku323.q)) + "&v1=" + Mi507.d(property) + "&v2=" + Mi507.d(property2) + "&e=" + d).openStream());
            dataInputStream.read();
            dataInputStream.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
