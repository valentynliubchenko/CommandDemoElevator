package org.example;

import org.example.command.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shaft {
    private SequenceOfStops sequenceOfStops;
    private final HashMap<String, Command> commandMap;

    private final List<DoneComand> doneComands = new ArrayList<>();

    public Shaft (HashMap<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    public List<DoneComand> getDoneComands () {
        return doneComands;
    }

    public void setSequenceOfStops (SequenceOfStops sequenceOfStops) {
        this.sequenceOfStops = sequenceOfStops;
    }

    public void activateShaft () {
        System.out.println("activateShaft");
        doneComands.clear();
        if (sequenceOfStops != null && sequenceOfStops.stopFloors != null) {
            for (int stopFloor : sequenceOfStops.stopFloors) {
                System.out.println("stop on floor " + Integer.toString(stopFloor));
                //дергаем команды для каждого этажа т.е. старт стоп опенДор слосе дор....
                DoneComand doneComand = new DoneComand();
                doneComands.add(doneComand);
            }
        }
    }

}
