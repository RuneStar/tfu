// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import java.io.IOException;
import java.net.InetAddress;

public class Ping
{
    public static native void quit();
    
    public static int g(final InetAddress inetAddress, final long n) throws IOException {
        final byte[] address = inetAddress.getAddress();
        final int nativePing = nativePing(address[0], address[1], address[2], address[3], n);
        if (nativePing >= 0) {
            return nativePing;
        }
        switch (nativePing) {
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
            default: {
                throw new IOException("Unknown error");
            }
        }
    }
    
    private static native int nativePing(final byte p0, final byte p1, final byte p2, final byte p3, final long p4);
}
