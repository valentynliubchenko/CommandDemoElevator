package org.example.command;

import org.example.Controller;
import org.example.Shaft;

import java.util.HashMap;

public class MoveSequensCommand implements Command {
    private final Controller controller;

    public MoveSequensCommand (Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute (HashMap<String, Object> params) {

        Shaft shaft = (Shaft) params.get("shaft");
        System.out.println(shaft);
        controller.moveSequens(shaft);
    }
}
