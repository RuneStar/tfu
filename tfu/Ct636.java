// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Ct636
{
    private int d;
    private int e;
    int g;
    private int h;
    private int j;
    private int q;
    private int[] s;
    
    Ct636() {
        this.g = Cg550.j(16);
        this.d = Cg550.j(24);
        this.q = Cg550.j(24);
        this.j = Cg550.j(24) + 1;
        this.e = Cg550.j(6) + 1;
        this.h = Cg550.j(8);
        final int[] array = new int[this.e];
        for (int i = 0; i < this.e; ++i) {
            int j = 0;
            final int k = Cg550.j(3);
            if (Cg550.q() != 0) {
                j = Cg550.j(5);
            }
            array[i] = (j << 3 | k);
        }
        this.s = new int[this.e * 8];
        for (int l = 0; l < this.e * 8; ++l) {
            this.s[l] = (((array[l >> 3] & 1 << (l & 0x7)) != 0x0) ? Cg550.j(8) : -1);
        }
    }
}
