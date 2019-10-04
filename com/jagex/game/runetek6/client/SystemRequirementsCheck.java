/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.client;

import java.io.File;
import java.io.PrintStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemRequirementsCheck {
    private static boolean loadedDirectX = false;
    private static boolean loadedVSRuntime = false;
    private static final Logger logger = LoggerFactory.getLogger(SystemRequirementsCheck.class);

    public static boolean getLoadedDirectX() {
        return loadedDirectX;
    }

    public static boolean performCheckForDll(String string) {
        String[] arrstring;
        boolean bl = false;
        String string2 = File.separator;
        String string3 = System.getenv("windir");
        if (string3.isEmpty()) {
            logger.warn("windir environment variable is empty, using default one");
            string3 = "C:" + string2 + "Windows";
        }
        if (!string3.endsWith(string2)) {
            string3 = string3 + string2;
        }
        for (String string4 : arrstring = new String[]{string3 + "System32" + string2, string3 + "SysWOW64" + string2}) {
            try {
                System.load(string4 + string);
                bl = true;
                break;
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                logger.error("linkage error failed to load " + string4 + string);
                unsatisfiedLinkError.printStackTrace();
            }
            catch (Exception exception) {
                logger.error("exception failed to load " + string4 + string);
                exception.printStackTrace();
            }
        }
        return bl;
    }

    public static boolean performAllChecks() {
        boolean bl = false;
        loadedDirectX = SystemRequirementsCheck.performCheckForDll("D3DX9_43.dll");
        loadedVSRuntime = SystemRequirementsCheck.performCheckForDll("MSVCR100.dll");
        boolean bl2 = bl = loadedDirectX && loadedVSRuntime;
        if (!bl) {
            logger.error("Depedencies are not satisfied! DirectX :" + loadedDirectX + "  VSRuntime:" + loadedVSRuntime);
            System.out.println("Depedencies are not found! DirectX :" + loadedDirectX + "  VSRuntime:" + loadedVSRuntime);
        }
        return bl;
    }
}

