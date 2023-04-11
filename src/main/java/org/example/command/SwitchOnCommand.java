package org.example.command;

import org.example.Controller;
import org.example.command.Command;

import java.util.HashMap;

public class SwitchOnCommand implements Command {
    private final Controller controller;

    public SwitchOnCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute (HashMap<String, Object> params) {

        String p1 = (String) params.get("param1");
        System.out.println(p1);

        controller.turnOn();
    }
}
