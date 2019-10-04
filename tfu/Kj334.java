// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.stringtools.general.J173;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.js5.js5;

public class Kj334
{
    public static final boolean g = false;
    private static String[] l;
    public int b;
    private byte[] d;
    public int e;
    public int h;
    public int j;
    private byte[][] q;
    public int s;
    
    private Kj334(final byte[] array) {
        final Gg3 gg3 = new Gg3(array);
        if (Gg3.ar(gg3) != 0) {
            throw new RuntimeException("");
        }
        final boolean b = Gg3.ar(gg3) == 1;
        Gg3.bx(gg3, this.d = new byte[256], 0, 256);
        if (b) {
            final int[] array2 = new int[256];
            final int[] array3 = new int[256];
            for (int i = 0; i < 256; ++i) {
                array2[i] = Gg3.ar(gg3);
            }
            for (int j = 0; j < 256; ++j) {
                array3[j] = Gg3.ar(gg3);
            }
            final byte[][] array4 = new byte[256][];
            for (int k = 0; k < 256; ++k) {
                array4[k] = new byte[array2[k]];
                byte b2 = 0;
                for (int l = 0; l < array4[k].length; ++l) {
                    b2 += Gg3.ax(gg3);
                    array4[k][l] = b2;
                }
            }
            final byte[][] array5 = new byte[256][];
            for (int n = 0; n < 256; ++n) {
                array5[n] = new byte[array2[n]];
                byte b3 = 0;
                for (int n2 = 0; n2 < array5[n].length; ++n2) {
                    b3 += Gg3.ax(gg3);
                    array5[n][n2] = b3;
                }
            }
            this.q = new byte[256][256];
            for (int n3 = 0; n3 < 256; ++n3) {
                if (n3 != 32) {
                    if (n3 != 160) {
                        for (int n4 = 0; n4 < 256; ++n4) {
                            if (n4 != 32) {
                                if (n4 != 160) {
                                    this.q[n3][n4] = (byte)d(array4, array5, array3, this.d, array2, n3, n4);
                                }
                            }
                        }
                    }
                }
            }
            this.j = array3[32] + array2[32];
        }
        else {
            this.j = Gg3.ar(gg3);
        }
        this.s = Gg3.ar(gg3);
        this.b = Gg3.ar(gg3);
        this.e = Gg3.ar(gg3);
        this.h = Gg3.ar(gg3);
    }
    
    public static Kj334 g(final js5 js5, final int n) {
        final byte[] v = js5.v(js5, n);
        if (v == null) {
            return null;
        }
        return new Kj334(v);
    }
    
    public static int j(final Kj334 kj334, final int n) {
        return kj334.d[n] & 0xFF;
    }
    
    static int d(final byte[][] array, final byte[][] array2, final int[] array3, final byte[] array4, final int[] array5, final int n, final int n2) {
        final int n3 = array3[n];
        final int n4 = n3 + array5[n];
        final int n5 = array3[n2];
        final int n6 = n5 + array5[n2];
        int n7 = n3;
        if (n5 > n3) {
            n7 = n5;
        }
        int n8;
        if (n6 < (n8 = n4)) {
            n8 = n6;
        }
        int n9 = array4[n] & 0xFF;
        if ((array4[n2] & 0xFF) < n9) {
            n9 = (array4[n2] & 0xFF);
        }
        final byte[] array6 = array2[n];
        final byte[] array7 = array[n2];
        int n10 = n7 - n3;
        int n11 = n7 - n5;
        for (int i = n7; i < n8; ++i) {
            final int n12 = array6[n10++] + array7[n11++];
            if (n12 < n9) {
                n9 = n12;
            }
        }
        return -n9;
    }
    
    public Kj334(final byte[] d, final byte[][] q, final int j, final int e, final int h, final int s, final int b) {
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
        this.h = h;
        this.s = s;
        this.b = b;
    }
    
    public static int e(final Kj334 kj334, final String s) {
        return h(kj334, s, null);
    }
    
    public static int h(final Kj334 kj334, final String s, final Km535[] array) {
        if (s == null) {
            return 0;
        }
        int n = -1;
        int n2 = -1;
        int n3 = 0;
        for (int length = s.length(), i = 0; i < length; ++i) {
            char char1 = s.charAt(i);
            if (char1 == '<') {
                n = i;
            }
            else {
                if (char1 == '>' && n != -1) {
                    final String substring = s.substring(n + 1, i);
                    n = -1;
                    if (substring.equals("lt")) {
                        char1 = '<';
                    }
                    else if (substring.equals("gt")) {
                        char1 = '>';
                    }
                    else if (substring.equals("nbsp")) {
                        char1 = ' ';
                    }
                    else if (substring.equals("shy")) {
                        char1 = '\u00ad';
                    }
                    else if (substring.equals("times")) {
                        char1 = '\u00d7';
                    }
                    else if (substring.equals("euro")) {
                        char1 = '\u20ac';
                    }
                    else if (substring.equals("copy")) {
                        char1 = '©';
                    }
                    else if (substring.equals("reg")) {
                        char1 = '®';
                    }
                    else {
                        if (substring.startsWith("img=") && array != null) {
                            try {
                                n3 += array[StringTools.j(substring.substring(4))].q();
                                n2 = -1;
                            }
                            catch (Exception ex) {}
                        }
                        continue;
                    }
                }
                if (n == -1) {
                    n3 += (kj334.d[J173.g(char1) & 0xFF] & 0xFF);
                    if (kj334.q != null && n2 != -1) {
                        n3 += kj334.q[n2][char1];
                    }
                    n2 = char1;
                }
            }
        }
        return n3;
    }
    
    static {
        Kj334.l = new String[100];
    }
    
    public static int q(final Kj334 kj334, final int n, final char c) {
        if (kj334.q != null) {
            return kj334.q[n][c];
        }
        return 0;
    }
}
