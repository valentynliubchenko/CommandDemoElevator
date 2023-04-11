package org.example;

import java.util.HashMap;

public class CommandDemo {
    public static void main(final String[] arguments) {
        System.out.println( "start Controler !" );
        int numOfShafts = 2;
        Controller  controller = new  Controller(numOfShafts);
        controller.init();
        HashMap<String, Object> map = new HashMap<>();
        map.put("param1", "On first");
        map.put("param2", "On kindly");
        controller.activate("on", map);
        controller.activate("off", map);

        HashMap<String, Shaft> mapMOve = new HashMap<>();
        map.put("shaft", controller.getShafts().get(0));

        controller.activate("move", map);

    }
}
