package main.java;

import java.util.ArrayList;

import main.java.cam.Cam;


/**
 * Trainer class.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class Trainer {
    private String name;
    private GameMediator game;
    private ArrayList<Cam> cams;
    private int money = 0;
    private int experience;

    /**
     * constructor for the Trainer.
     * @param name - name of the trainer
     */

    public Trainer(String name) {
        this.name = name;
        this.cams = new ArrayList<>();
        this.money = 0;
        this.experience = 0;
    }

    /**
     * Get the name of the Trainer.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set a name for the Trainer.
     * @param name - String
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setGame(GameMediator game) {
        this.game = new GameMediator();
    }

    /**
     * Add a new cam to the trainer arsenal.
     * @param cam - new Cam
     */
    public void addCam(Cam cam) {
        cams.add(cam);
    }

    /**
     * Gets the amount of money a trainer has.
     * @return int
     */
    public int getMoney() {
        return money;
    }

    /**
     * Set a new amount of money a trainer has.
     * @param money - new amount
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Get the active cams a trainer has.
     * @return ArrayList of Cam
     */
    public ArrayList<Cam> getActiveCams() {
        ArrayList<Cam> activeCams = new ArrayList<>();
        for (Cam c : cams) {
            if (c.isActive()) {
                activeCams.add(c);
            }
        }
        return activeCams;
    }

    /**
     * Get the amount of experience a trainer has.
     * @return int
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Set the amount of experience a trainer has.
     * @param experience - int - new amount
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * calls the set mediator to battle another trainer.
     * @param opp - Trainer to battle
     * @return winner of the battle
     */
    public Trainer battle(Trainer opp) {
        return game.battle(this, opp);
    }

    /**
     * Calls the game mediator to heal cams.
     */
    public void healCams() {
        game.healCams(cams);
    }

    /**
     * Get information about a trainer to print.
     * @return String
     */
    @Override
    public String toString() {
        return "Trainer "  + name + "{\n"
                + "cams=" + cams
                + ", \nmoney=" + money
                + ", experience=" + experience
                + "}\n";
    }
}
