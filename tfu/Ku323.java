/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.applet.Applet;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import tfu.Mi507;

public class Ku323
extends RuntimeException {
    private static final boolean d = true;
    public static int e;
    private static final boolean g = true;
    public static int h;
    public static String j;
    public static long q;
    public static Applet s;
    private String b;
    private Throwable l;

    private Ku323(Throwable throwable, String string) {
        this.b = string;
        this.l = throwable;
        this.initCause(throwable);
    }

    public static String d(Throwable throwable) throws IOException {
        Object object;
        String string;
        String string2;
        if (throwable instanceof Ku323) {
            object = (Ku323)throwable;
            string = ((Ku323)object).b + " | ";
            throwable = ((Ku323)object).l;
        } else {
            string = "";
        }
        object = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer)object);
        throwable.printStackTrace(printWriter);
        printWriter.close();
        String string3 = ((StringWriter)object).toString();
        BufferedReader bufferedReader = new BufferedReader(new StringReader(string3));
        String string4 = bufferedReader.readLine();
        while ((string2 = bufferedReader.readLine()) != null) {
            int n;
            int n2 = string2.indexOf(40);
            int n3 = string2.indexOf(41, n2 + 1);
            String string5 = n2 != -1 ? string2.substring(0, n2) : string2;
            string5 = string5.trim();
            string5 = string5.substring(string5.lastIndexOf(32) + 1);
            string5 = string5.substring(string5.lastIndexOf(9) + 1);
            string = string + string5;
            if (n2 != -1 && n3 != -1 && (n = string2.indexOf(".java:", n2)) >= 0) {
                string = string + string2.substring(n + 5, n3);
            }
            string = string + ' ';
        }
        string = string + "| " + string4;
        return string;
    }

    private static final void q(String string) {
        System.out.println("Error: " + Ku323.j(string, "%0a", "\n"));
    }

    private static final String j(String string, String string2, String string3) {
        int n = string.indexOf(string2);
        while (n != -1) {
            string = string.substring(0, n) + string3 + string.substring(n + string2.length());
            n = string.indexOf(string2, n + string3.length());
        }
        return string;
    }

    public static void g(String string, Throwable throwable) {
        try {
            String string2 = "";
            if (throwable != null) {
                string2 = Ku323.d(throwable);
            }
            if (string != null) {
                if (throwable != null) {
                    string2 = string2 + " | ";
                }
                string2 = string2 + string;
            }
            Ku323.q(string2);
            string2 = Mi507.d(string2);
            if (s == null) {
                return;
            }
            String string3 = "Unknown";
            String string4 = "1.1";
            try {
                string3 = System.getProperty("java.vendor");
                string4 = System.getProperty("java.version");
            }
            catch (Exception exception) {
                // empty catch block
            }
            URL uRL = new URL(s.getCodeBase(), "clienterror.ws?c=" + e + "&cs=" + h + "&u=" + (j != null ? Mi507.d(j) : "" + q) + "&v1=" + Mi507.d(string3) + "&v2=" + Mi507.d(string4) + "&e=" + string2);
            DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
            dataInputStream.read();
            dataInputStream.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

