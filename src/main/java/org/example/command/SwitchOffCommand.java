package org.example.command;

import org.example.Controller;
import org.example.command.Command;

import java.util.HashMap;

public class SwitchOffCommand implements Command {
    private final Controller controller;

    public SwitchOffCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute (HashMap<String, Object> params) {
        controller.turnOff();
    }
}
