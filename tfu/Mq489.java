// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.game.runetek6.config.vartype.VarTypeList;
import java.util.Iterator;
import com.jagex.game.runetek6.config.vartype.SparseVarDomain;

public class Mq489 extends SparseVarDomain implements Iterable
{
    int d;
    int g;
    
    public static int d(final Mq489 mq489) {
        return mq489.g;
    }
    
    public static int q(final Mq489 mq489) {
        return mq489.d;
    }
    
    @Override
    public Iterator iterator() {
        return super.varValues.iterator();
    }
    
    public static void j(final Mq489 mq489, final int d) {
        mq489.d = d;
    }
    
    public Mq489(final int g, final int d, final VarTypeList list) {
        super(list);
        this.g = g;
        this.d = d;
    }
}
