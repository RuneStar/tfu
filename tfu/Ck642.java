// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Ck642
{
    int d;
    int[] e;
    int g;
    int[] j;
    int q;
    
    Ck642() {
        Cg550.j(16);
        this.g = ((Cg550.q() != 0) ? (Cg550.j(4) + 1) : 1);
        if (Cg550.q() != 0) {
            this.d = Cg550.j(8) + 1;
        }
        else {
            this.d = 0;
        }
        Cg550.j(2);
        if (this.g > 1) {
            this.q = Cg550.j(4);
        }
        this.j = new int[this.g];
        this.e = new int[this.g];
        for (int i = 0; i < this.g; ++i) {
            Cg550.j(8);
            this.j[i] = Cg550.j(8);
            this.e[i] = Cg550.j(8);
        }
    }
}
