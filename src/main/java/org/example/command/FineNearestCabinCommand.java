package org.example.command;

import org.example.Controller;

import java.util.HashMap;

public class FineNearestCabinCommand implements Command {
    private final Controller controller;

    public FineNearestCabinCommand (Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute (HashMap<String, Object> params) {

        String p1 = (String)params.get("param1");
        System.out.println(p1);
        controller.findNearestCabinCommand();
    }
}
