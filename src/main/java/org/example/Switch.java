package org.example;

import org.example.command.Command;

import java.util.HashMap;

public class Switch {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName, HashMap<String, Object> params) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("no command registered for " + commandName);
        }

        command.execute(params);
    }
}
