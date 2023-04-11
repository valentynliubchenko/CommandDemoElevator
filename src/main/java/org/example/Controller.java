package org.example;

import org.example.command.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {

    private final HashMap<String, Command> commandMap = new HashMap<>();

    public List<Shaft> getShafts () {
        return shafts;
    }

    private final List<Shaft> shafts = new ArrayList<>();

    public void register (String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    private List<SequenceOfStops> orderSequenceOfStops;

    //    private final List<List<DoneComand>> AllHistory =new ArrayList<>();
    public Controller (int numOfShafts) {
        for (int i = 0; i < numOfShafts; i++) {
            shafts.add(new Shaft(commandMap));
            shafts.add(new Shaft(commandMap));
        }
        init();
    }

    public void init () {
        Command switchOn = new SwitchOnCommand(this);
        Command switchOff = new SwitchOffCommand(this);
        Command moveSequensCommand = new MoveSequensCommand(this);
        Command fineNearest = new FineNearestCabinCommand(this);

        register("on", switchOn);
        register("off", switchOff);
        register("move", moveSequensCommand);
    }

    public void activate (String commandName, HashMap<String, Object> params) {
        Command command = commandMap.get(commandName);

        if (command == null) {
            throw new IllegalStateException("no command registered for " + command);
        }


        command.execute(params);
    }

    public void findNearestCabinCommand () {
        SequenceOfStops currentSequenceOfStops = new SequenceOfStops();
        currentSequenceOfStops.stopFloors.add(1);
        currentSequenceOfStops.stopFloors.add(4);
        currentSequenceOfStops.stopFloors.add(5);
        currentSequenceOfStops.currentFloor = 2;
        orderSequenceOfStops.add(currentSequenceOfStops);
        //определить ближайшую кабину
        //запустить в отдельном потоке
        //while {
        shafts.get(0).activate();
        //}

    }

    public void moveSequens (Shaft shaft) {
        if (orderSequenceOfStops!=null && !orderSequenceOfStops.isEmpty()) {
            shaft.setSequenceOfStops(orderSequenceOfStops.get(0));
            orderSequenceOfStops.remove(0);
        }
    }

    public void turnOn () {
        System.out.println("The light is on");
    }

    public void turnOff () {
        System.out.println("The light is off");
    }
}