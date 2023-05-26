package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.Defense;

/** Interface for attacking and defend level of a CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public interface Stats {
    /**
     * Gets the attack of the CAM.
     * @return - Attack object
     */
    public Attack getAttack();

    /**
     * Gets teh defense of the CAM.
     * @return - Defense of the CAM
     */
    public Defense getDefense();
}
