package main.java.cam;

/**
 * Interface for levels factory.
 *
 * This is a abstract factory used to create different levels for each Cam.
 *
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public interface CamLevelFactory {
    /**
     * Sets amount for a level to scale the CAM attack.
     * @return Attack specific to the Level
     */
    public Attack addLevelAttack();

    /**
     * Sets amount for a level to scale the CAM defense.
     * @return Defense specific to the Level
     */
    public Defense addLevelDefense();
}
