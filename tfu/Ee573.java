// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Ee573
{
    private static final int b = 5;
    private static final int e = 2;
    private static final int h = 3;
    private static final int j = 1;
    private static final int s = 4;
    public long d;
    public long g;
    public Gx298 q;
    
    public void d(final Dr574 dr574) {
        if (dr574.bq != this.g || dr574.n != this.d) {
            throw new RuntimeException("ClanChannelDelta.applyToClanChannel(): Credentials do not match! cc.clanHash:" + dr574.bq + " updateNum:" + dr574.n + " delta.clanHash:" + this.g + " updateNum:" + this.d);
        }
        for (Eg572 eg572 = (Eg572)Gx298.i(this.q); eg572 != null; eg572 = (Eg572)Gx298.c(this.q)) {
            eg572.d(dr574);
        }
        ++dr574.n;
    }
    
    public Ee573(final Gg3 gg3) {
        this.d = -1L;
        this.q = new Gx298();
        this.g(gg3);
    }
    
    public Ee573(final Dr574 dr574) {
        this.d = -1L;
        this.q = new Gx298();
        this.g = dr574.bq;
        this.d = dr574.n;
    }
    
    public void g(final Gg3 gg3) {
        this.g = Gg3.bq(gg3);
        this.d = Gg3.bq(gg3);
        for (int i = Gg3.ar(gg3); i != 0; i = Gg3.ar(gg3)) {
            Eg572 eg572;
            if (i == 1) {
                eg572 = new Ek609(this);
            }
            else if (i == 4) {
                eg572 = new Dd615(this);
            }
            else if (i == 3) {
                eg572 = new Dx616(this);
            }
            else if (i == 2) {
                eg572 = new Dj617(this);
            }
            else {
                if (i != 5) {
                    throw new RuntimeException("Unrecognised ClanChannelDelta type in decode()");
                }
                eg572 = new Er571(this);
            }
            eg572.g(gg3);
            Gx298.t(this.q, eg572);
        }
    }
}
