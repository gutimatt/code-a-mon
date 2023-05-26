package main.java.cam;

/**
 * Factory for making a CAM.
 *
 * This is one of the Abstract factories to create a Cam based on the type of Cam.
 *
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public interface CamFactory {
    /**
     * Gets the appropriate attack object to return.
     * @return Attack of a CAM
     */
    public Attack addCamAttack();

    /**
     * Gets the appropriate defense object to return.
     * @return Defense of a CAM
     */
    public Defense addCamDefense();
}
