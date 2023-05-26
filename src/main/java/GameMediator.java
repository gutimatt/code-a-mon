package main.java;

import java.util.ArrayList;
import java.util.Random;

import main.java.cam.Cam;
import main.java.cam.CamGoldFactory;
import main.java.cam.CamLevelFactory;
import main.java.cam.CamSilverFactory;
import main.java.cam.types.EarthCam;
import main.java.cam.types.WaterCam;
import main.java.util.CamOpposites;


/**
 * Mediator for a game to control cycles and handle battles.
 *
 * This class acts has a mediator to control the game flow.
 *
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class GameMediator {
    /**
     * Trainers belonging to a game.
     */
    ArrayList<Trainer> trainers;
    Random rand = new Random();

    /**
     * Constructor for a Game.
     */
    public GameMediator() {
        this.trainers = new ArrayList<>();
    }

    /**
     * Adds a trainer to the Game.
     * @param trainer - new Trainer
     */
    public void addTrainer(Trainer trainer) {
        trainer.setGame(this);
        trainers.add(trainer);
    }

    /**
     * Not yet implemented, but used to get a new prize like a potion or CAM.
     */
    public void spin() {
        System.out.println("Trainer is spinning");
    }

    /**
     * Bring all the Cams to 100 health.
     * @param cams - list of cams
     */
    public void healCams(ArrayList<Cam> cams) {
        for (Cam c: cams) {
            c.setHealth(100);
        }
    }

    /**
     * Prints the winner and gives 20 credits towards trainer.
     * @param trainer - winning trainer
     * @return Trainer that won
     */
    private Trainer getWinner(Trainer trainer) {
        System.out.println(trainer.getName() + " won!\n");
        trainer.setMoney(trainer.getMoney() + 20);
        return trainer;
    }

    /**
     * Updates the experience of the trainer and CAMS.
     * @param trainer - trainer to update experience
     * @param opp - opponent trainer to update experience
     * @param trainerCam - CAM of trainer
     * @param oppCam - CAM of opponent
     * @param diff - difference passed to determine amount of experience gained
     */
    private void updateExperience(
            Trainer trainer,
            Trainer opp,
            Cam trainerCam,
            Cam oppCam,
            int diff) {
        if (diff > 0) {
            trainer.setExperience(trainer.getExperience() + diff);
            opp.setExperience(opp.getExperience() + diff / 2);
            trainerCam.setExperience(trainerCam.getExperience() + diff);
            oppCam.setExperience(oppCam.getExperience() + diff / 2);
        } else if (diff < 0) {
            trainer.setExperience(trainer.getExperience() - diff / 2);
            opp.setExperience(opp.getExperience() - diff);
            trainerCam.setExperience(trainerCam.getExperience() - diff / 2);
            oppCam.setExperience(oppCam.getExperience() - diff);
        } else {
            int randInt = rand.nextInt(2);
            if (randInt < 1) {
                trainer.setExperience((int) (trainer.getExperience() * 1.1));
                opp.setExperience((int) (opp.getExperience() * 1.1));
                trainerCam.setExperience((int) (trainerCam.getExperience() * 1.1));
                oppCam.setExperience((int) (oppCam.getExperience() * 1.1));
            }
        }
    }

    /**
     * Battle two trainers using a random CAM from each trainer.
     * Each CAM takes a turn attacking the other.
     * @param trainer - trainer initializing battle
     * @param opp - opponent trainer is battling
     * @return Trainer that wins the battle
     */
    public Trainer battle(Trainer trainer, Trainer opp) {
        ArrayList<Cam> activeTrainerCams = trainer.getActiveCams();
        ArrayList<Cam> activeOppCams = opp.getActiveCams();

        if (activeTrainerCams.size() < 1) {
            System.out.println(trainer.getName() + " has no Code-A-Mons Healthy");
            return null;
        }

        if (activeOppCams.size() < 1) {
            System.out.println(opp.getName() + " has no Code-A-Mons Healthy");
            return null;
        }

        System.out.println(trainer.getName() + " started a battle against " + opp.getName());
        int intRandom = rand.nextInt(activeTrainerCams.size());
        int intRandom2 = rand.nextInt(activeOppCams.size());
        Cam trainerCam = activeTrainerCams.get(intRandom);
        Cam oppCam = activeOppCams.get(intRandom2);

        System.out.println(trainerCam);
        System.out.println(oppCam);

        while (trainerCam.isActive() && oppCam.isActive()) {
            int diff = camBattle(trainerCam, oppCam);
            updateExperience(trainer, opp, trainerCam, oppCam, diff);
            levelUpCam(trainerCam);
            levelUpCam(oppCam);

            if (!trainerCam.isActive()) {
                levelUpCam(oppCam);
                return getWinner(opp);
            }

            if (!oppCam.isActive()) {
                levelUpCam(trainerCam);
                return getWinner(trainer);
            }

            diff = camBattle(oppCam, trainerCam);
            updateExperience(opp, trainer, oppCam, trainerCam, diff);
            levelUpCam(trainerCam);
            levelUpCam(oppCam);

            if (!trainerCam.isActive()) {
                return getWinner(opp);
            }

            if (!oppCam.isActive()) {
                return getWinner(trainer);
            }
        }
        return null;
    }

    /**
     * Battle between two CAMs.
     * @param camA - Cam
     * @param camB - Cam
     * @return int - difference int the attack and defense
     */
    private int camBattle(Cam camA, Cam camB) {
        int attack = camA.getAttack();
        int defense = camB.getDefense();

        if (CamOpposites.isOpposite(camA, camB)) {
            if (camA.getClass().equals(WaterCam.class)) {
                System.out.println("Water attack boosted against fire.");
                attack += (attack * 1.25);
            } else if (camA.getClass().equals(EarthCam.class)) {
                System.out.println("Earth defense boosted against air.");
                defense += (defense * 1.25);
            }
        }

        int diff = attack - defense;

        if (diff > 0) {
            camB.setHealth(camB.getHealth() - diff);

            printSequence("attacked", camA,camB, diff);
        } else if (diff < 0) {
            int healed = camB.getHealth() - diff;
            if (healed > 100) {
                camB.setHealth(100);
            } else {
                camB.setHealth(healed);
            }

            printSequence("defended", camB,camA, diff);
        } else {
            int randInt = rand.nextInt(2);
            if (randInt < 1) {
                int damage = camB.getHealth() - (attack / 2);
                camB.setHealth(damage);

                printSequence("attacked", camA,camB, (attack / 2));

            } else {
                printSequence("missed", camA,camB, diff);
            }
        }

        if (camB.getHealth() < 0) {
            camB.setHealth(0);
        } else if (camB.getHealth() > 100) {
            camB.setHealth(100);
        }

        return diff;
    }

    /**
     * Prints information about each strike.
     * @param type - attack or defend to print
     * @param cam1 - Cam that attacked
     * @param cam2 - Cam that was attacked
     * @param amount - amount of the strike
     */
    private void printSequence(String type, Cam cam1, Cam cam2, int amount) {
        System.out.println(cam1.getName() + " " + type + " " + cam2.getName()
                + " for " + amount + " damage. "
                + cam1.getName() + " health - " + cam1.getHealth()
                + " " + cam2.getName() + " health - " + cam2.getHealth());
    }

    /**
     * Levels up a Cam to the next level if possible.
     * @param cam - Cam to try level up
     */
    private void levelUpCam(Cam cam) {
        int experience = cam.getExperience();
        int levelExperience = cam.getLevelExperience();

        if (experience >= levelExperience) {
            CamLevelFactory nextLevel;

            cam.setLevelExperience(levelExperience * 2);
            cam.setHealth(100);

            if (experience >= 200 && experience < 400) {
                System.out.println(cam.getName() + " is Level Silver");
                nextLevel = new CamSilverFactory();
                levelTo(cam, nextLevel);
            } else if (experience >= 400) {
                System.out.println(cam.getName() + " is Level Gold");
                nextLevel = new CamGoldFactory();
                levelTo(cam, nextLevel);
            }
        }
    }

    /**
     * Sets the Cam level factory based on the next level the Cam goes to.
     * @param cam - Cam
     * @param nextLevel - CamLevelFactory to level to
     */
    private void levelTo(Cam cam, CamLevelFactory nextLevel) {
        cam.setCamLevelFactory(nextLevel);
    }

    /**
     * Get the trainers in a game.
     * @return ArrayList of trainers
     */
    public ArrayList<Trainer> getTrainers() {
        ArrayList<Trainer> t = new ArrayList<>();
        for (Trainer trainer : trainers) {
            t.add(trainer);
        }
        return t;
    }
}
