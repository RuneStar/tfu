// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public final class Le231
{
    private static final String g = "#";
    
    public static final boolean g(final String s, final String s2, final String anObject, final String anObject2) {
        if (s == null || anObject == null) {
            return false;
        }
        if (s.startsWith("#") || anObject.startsWith("#")) {
            return s.equals(anObject);
        }
        return s2.equals(anObject2);
    }
}
