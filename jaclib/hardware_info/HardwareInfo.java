// 
// Decompiled by Procyon v0.5.36
// 

package jaclib.hardware_info;

public class HardwareInfo
{
    public static final native String[][] getDXDiagDisplayDevicesProps();
    
    public static final native int[] getCPUInfo();
    
    public static final native int[] getRawCPUInfo();
    
    public static final native String[] getDXDiagSystemProps();
}
