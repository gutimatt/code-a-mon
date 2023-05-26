package main.java.cam;

/**
 * Code a mon main class.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public abstract class Cam {

    protected String name;
    protected int health = 100;
    protected Attack levelAttack;
    protected Defense levelDefense;
    protected Attack camAttack;
    protected Defense camDefense;
    protected int experience = 10;
    protected int levelExperience = 100;

    /**
     * Get the name of a CAM.
     * @return - String
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     * @param name - new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the health.
     * @return int
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set the health.
     * @param health - new health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Get the total attack amount based on level and CAM Attack level.
     * @return int
     */
    public int getAttack() {
        return (int) (levelAttack.getValue() * camAttack.getValue());
    }

    /**
     * Checks if the CAM has a health more than 0.
     * @return boolean
     */
    public boolean isActive() {
        return health > 0;
    }

    /**
     * Get the defense based on the level and defense amount of CAM.
     * @return int
     */
    public int getDefense() {
        return (int) (levelDefense.getValue() * camDefense.getValue());
    }

    /**
     * Get experience of the CAM.
     * @return int
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Set the experience of a CAM.
     * @param experience - new experience
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Get the experience needed to level up.
     * @return int
     */
    public int getLevelExperience() {
        return levelExperience;
    }

    /**
     * Set a new experience needed to level up.
     * @param levelExperience - new level experience needed
     */
    public void setLevelExperience(int levelExperience) {
        this.levelExperience = levelExperience;
    }

    /**
     * Abstract method to make a new CAM.
     */
    public abstract void makeCam();

    /**
     * Prints information about the CAM.
     * @return String
     */
    @Override
    public String toString() {
        return "\nCam{" + name
                + ", health=" + health
                + ", attack=" + getAttack()
                + ", defense=" + getDefense()
                + ", experience=" + experience
                + ", levelExperience=" + levelExperience
                + "}";
    }

    public abstract void setCamLevelFactory(CamLevelFactory nextLevel);
}
