/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Hs30;

public interface Ib29 {
    public static final Logger logger = LoggerFactory.getLogger(Ib29.class);

    public Object getResourceAddress(String var1);

    public String getIdentifier();

    public byte[] getData(Object var1) throws Hs30;
}

