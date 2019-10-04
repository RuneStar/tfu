// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script;

import java.util.LinkedList;
import org.slf4j.LoggerFactory;
import com.jagex.jnibindings.runetek6.Scripting;
import tfu.Lb33;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.slf4j.Logger;

public class LuaDebugEclipseConsole implements Runnable
{
    private static final Logger logger;
    List commands;
    private volatile boolean run;
    private final ScriptManager scriptManager;
    
    @Override
    public void run() {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (this.run) {
            try {
                final String line = bufferedReader.readLine();
                if (line != null) {
                    synchronized (this.commands) {
                        this.commands.add(line);
                    }
                    continue;
                }
                LuaDebugEclipseConsole.logger.error("Console input stream closed by Ctrl-Z - Don't press that key again...");
            }
            catch (IOException ex) {
                LuaDebugEclipseConsole.logger.error("", ex);
            }
            break;
        }
    }
    
    public void service() {
        Lb33.g(Lb33.LuaConsole);
        try {
            if (this.commands.size() > 0) {
                synchronized (this.commands) {
                    try {
                        final String s = this.commands.remove(0);
                        if (s.compareToIgnoreCase("/rl") != 0 && s.compareToIgnoreCase("/reload") != 0) {
                            if (s.compareToIgnoreCase("/reloadui") != 0) {
                                if (!s.trim().isEmpty()) {
                                    Scripting.executeScriptFromMemory(this.scriptManager.getScriptManagerNativeRef(), this.scriptManager.getLuaStateNativeRef(), s, 0, true);
                                }
                            }
                        }
                    }
                    catch (Exception ex) {
                        LuaDebugEclipseConsole.logger.error("", ex);
                    }
                }
            }
        }
        finally {
            Lb33.d(Lb33.LuaConsole);
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(LuaDebugEclipseConsole.class);
    }
    
    public LuaDebugEclipseConsole(final ScriptManager scriptManager) {
        this.run = true;
        this.commands = new LinkedList();
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        this.scriptManager = scriptManager;
    }
}
