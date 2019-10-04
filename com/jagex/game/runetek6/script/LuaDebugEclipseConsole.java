/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script;

import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.Scripting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Lb33;

public class LuaDebugEclipseConsole
implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(LuaDebugEclipseConsole.class);
    List commands = new LinkedList();
    private volatile boolean run = true;
    private final ScriptManager scriptManager;

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (this.run) {
            try {
                String string = bufferedReader.readLine();
                if (string == null) {
                    logger.error("Console input stream closed by Ctrl-Z - Don't press that key again...");
                    break;
                }
                List list = this.commands;
                synchronized (list) {
                    this.commands.add(string);
                }
            }
            catch (IOException iOException) {
                logger.error("", iOException);
                break;
            }
        }
    }

    public void service() {
        Lb33.g(Lb33.LuaConsole);
        try {
            if (this.commands.size() > 0) {
                List list = this.commands;
                synchronized (list) {
                    try {
                        String string = (String)this.commands.remove(0);
                        if (string.compareToIgnoreCase("/rl") != 0 && string.compareToIgnoreCase("/reload") != 0 && string.compareToIgnoreCase("/reloadui") != 0 && !string.trim().isEmpty()) {
                            Scripting.executeScriptFromMemory(this.scriptManager.getScriptManagerNativeRef(), this.scriptManager.getLuaStateNativeRef(), string, 0, true);
                        }
                    }
                    catch (Exception exception) {
                        logger.error("", exception);
                    }
                }
            }
            Lb33.d(Lb33.LuaConsole);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.LuaConsole);
            throw throwable;
        }
    }

    public LuaDebugEclipseConsole(ScriptManager scriptManager) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        this.scriptManager = scriptManager;
    }
}

