/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import application.RocketController;
import application.dto.MerlinEngineDTO;
import application.dto.RocketDTO;


import java.util.concurrent.TimeUnit;

public class SpaceX {

    static RocketController controller = new RocketController();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        controller.createRocket("32WESSDS", new int[]{10,30});//120 Kn
        controller.addEngine("32WESSDS", 80);
       
        controller.createRocket("LDSFJA32");//210 Kn
        controller.addEngines("LDSFJA32",new int[]{40,50,50,30,10});


        printAcceleration("32WESSDS");

        printDesacceleration("32WESSDS");

        printAcceleration("LDSFJA32");

        printDesacceleration("LDSFJA32");

    }

    public static void printallRockets() throws Exception {

        for (RocketDTO r : controller.getRockets()) {
            System.out.println(formatString(r));
        }
    }

    public static void printRocketByID(String id) throws Exception {

        for (RocketDTO r : controller.getRockets()) {
            if (r.getId().contentEquals(id)) {
                System.out.println(formatString(r));
            }
        }
    }

    public static String formatString(RocketDTO r) throws Exception {
        String result;
        result = String.format("%s\t%s  \t totalPower: %d kN\n", r.getId(), printPowerEachEngine(r), r.getTotalPower());
        return result;
    }

    public static String printPowerEachEngine(RocketDTO r) throws Exception {
        String result = "";
        for (MerlinEngineDTO enginesdto : r.getEngines()) {
            enginesdto.getPower();
            result += enginesdto.getPower() + " ";
        }
        return result;
    }

    public static void printAcceleration(String id) throws Exception {

        System.out.println("////////////////////ACCELERATE FALCON9 ROCKET: " + id + "///////////////////////////\n");
        printRocketByID(id);
        while (controller.totalPower(id) < controller.maxPower(id)) {
            controller.increasePower(id);
            printRocketByID(id);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printDesacceleration(String id) throws Exception {
        System.out.println("////////////////////DESACCELERATE FALCON9 ROCKET: " + id + "///////////////////////////\n");
        printRocketByID(id);
        while (controller.totalPower(id) != 0) {
            controller.decreasePower(id);
            printRocketByID(id);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
