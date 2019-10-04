/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import java.io.IOException;
import java.net.InetAddress;

public class Ping {
    public static native void quit();

    public static int g(InetAddress inetAddress, long l) throws IOException {
        byte[] arrby = inetAddress.getAddress();
        int n = Ping.nativePing(arrby[0], arrby[1], arrby[2], arrby[3], l);
        if (n < 0) {
            switch (n) {
                case -1: {
                    throw new IOException("Couldn't initialise ICMP library");
                }
                case -2: {
                    throw new IOException("Couldn't find ICMP entry points");
                }
                case -3: {
                    throw new IOException("Couldn't create ICMP file handle");
                }
                case -4: {
                    throw new IOException("Couldn't allocate memory");
                }
                case -5: {
                    throw new IOException("An error occurred trying to reach the remote host");
                }
            }
            throw new IOException("Unknown error");
        }
        return n;
    }

    private static native int nativePing(byte var0, byte var1, byte var2, byte var3, long var4);
}

