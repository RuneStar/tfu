// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public interface Ib29
{
    public static final Logger logger = LoggerFactory.getLogger(Ib29.class);
    
    Object getResourceAddress(final String p0);
    
    String getIdentifier();
    
    byte[] getData(final Object p0) throws Hs30;
}
