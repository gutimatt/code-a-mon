package main.java;

import main.java.cam.Cam;
import main.java.cam.CamBuilding;
import main.java.util.CamTypes;

/**
 * Main method to initiate program.
 *
 * @author : Matthew Gutierrez
 * @version : 1.0
 */
public class Main {
    private static GameMediator game;

    /**
     * Starting method for the program.
     *
     * @param args from initializing program.
     */
    public static void main(String[] args) {
        game = new GameMediator();

        Trainer trainer1 = new Trainer("John");
        Trainer trainer2 = new Trainer("Smith");

        game.addTrainer(trainer1);
        game.addTrainer(trainer2);

        Cam cam1 = CamBuilding.build(CamTypes.FIRE, "FireName2");
        Cam cam2 = CamBuilding.build(CamTypes.WATER, "WaterName");
        Cam cam3 = CamBuilding.build(CamTypes.FIRE, "FireName");
        Cam cam4 = CamBuilding.build(CamTypes.AIR, "AirName");
        Cam cam5 = CamBuilding.build(CamTypes.EARTH, "EarthName");
        Cam cam6 = CamBuilding.build(CamTypes.WATER, "WaterName2");

        trainer1.addCam(cam1);
        trainer1.addCam(cam2);
        trainer1.addCam(cam3);
        trainer2.addCam(cam4);
        trainer2.addCam(cam5);
        trainer2.addCam(cam6);

        printTrainersInfo();

        // runs three complete cycles
        for (int i = 0; i < 3; i++) {
            System.out.println("Cycle: " + (i + 1));
            // Runs a day cycle
            trainer1.battle(trainer2);
            trainer2.battle(trainer1);
            trainer1.battle(trainer2);

            // Runs the night cycle
            for (Trainer trainer : game.getTrainers()) {
                trainer.healCams();
            }

            printTrainersInfo();
        }
    }

    /**
     * Used for ui and debugging.  Prints trainer info including Cams.
     */
    public static void printTrainersInfo() {
        System.out.println();

        for (Trainer t : game.getTrainers()) {
            System.out.println(t);
        }
        System.out.println();
    }
}
