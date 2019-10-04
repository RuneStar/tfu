// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.client;

import org.slf4j.LoggerFactory;
import java.io.File;
import org.slf4j.Logger;

public class SystemRequirementsCheck
{
    private static boolean loadedDirectX;
    private static boolean loadedVSRuntime;
    private static final Logger logger;
    
    public static boolean getLoadedDirectX() {
        return SystemRequirementsCheck.loadedDirectX;
    }
    
    public static boolean performCheckForDll(final String str) {
        boolean b = false;
        final String separator = File.separator;
        String str2 = System.getenv("windir");
        if (str2.isEmpty()) {
            SystemRequirementsCheck.logger.warn("windir environment variable is empty, using default one");
            str2 = "C:" + separator + "Windows";
        }
        if (!str2.endsWith(separator)) {
            str2 += separator;
        }
        for (final String str3 : new String[] { str2 + "System32" + separator, str2 + "SysWOW64" + separator }) {
            try {
                System.load(str3 + str);
                b = true;
                break;
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                SystemRequirementsCheck.logger.error("linkage error failed to load " + str3 + str);
                unsatisfiedLinkError.printStackTrace();
            }
            catch (Exception ex) {
                SystemRequirementsCheck.logger.error("exception failed to load " + str3 + str);
                ex.printStackTrace();
            }
        }
        return b;
    }
    
    public static boolean performAllChecks() {
        SystemRequirementsCheck.loadedDirectX = performCheckForDll("D3DX9_43.dll");
        SystemRequirementsCheck.loadedVSRuntime = performCheckForDll("MSVCR100.dll");
        final boolean b = SystemRequirementsCheck.loadedDirectX && SystemRequirementsCheck.loadedVSRuntime;
        if (!b) {
            SystemRequirementsCheck.logger.error("Depedencies are not satisfied! DirectX :" + SystemRequirementsCheck.loadedDirectX + "  VSRuntime:" + SystemRequirementsCheck.loadedVSRuntime);
            System.out.println("Depedencies are not found! DirectX :" + SystemRequirementsCheck.loadedDirectX + "  VSRuntime:" + SystemRequirementsCheck.loadedVSRuntime);
        }
        return b;
    }
    
    static {
        SystemRequirementsCheck.loadedDirectX = false;
        SystemRequirementsCheck.loadedVSRuntime = false;
        logger = LoggerFactory.getLogger(SystemRequirementsCheck.class);
    }
}
