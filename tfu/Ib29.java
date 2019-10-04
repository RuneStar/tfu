package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Ib29 {
   Logger logger = LoggerFactory.getLogger(Ib29.class);

   Object getResourceAddress(String var1);

   String getIdentifier();

   byte[] getData(Object var1) throws Hs30;
}
