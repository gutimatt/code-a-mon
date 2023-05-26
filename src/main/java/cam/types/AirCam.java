package main.java.cam.types;

import main.java.cam.Cam;
import main.java.cam.CamFactory;
import main.java.cam.CamLevelFactory;

/**
 * Air CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class AirCam extends Cam {

    protected CamLevelFactory camLevelFactory;
    protected CamFactory camFactory;

    /**
     * Constructor.
     * @param camLevelFactory - Level of the CAM.
     * @param camFactory - Defines attack and defend stats for Fire CAM
     * @param name - Name given
     */
    public AirCam(CamLevelFactory camLevelFactory,
                  CamFactory camFactory,
                  String name) {
        this.camLevelFactory = camLevelFactory;
        this.camFactory = camFactory;
        this.name = name;
    }

    /**
     * Sets the level and CAM Attack and defense levels.
     */
    public void makeCam() {
        System.out.println("Making Air Cam :  " + name);

        this.levelAttack = camLevelFactory.addLevelAttack();
        this.levelDefense = camLevelFactory.addLevelDefense();

        this.camAttack = camFactory.addCamAttack();
        this.camDefense = camFactory.addCamDefense();
    }

    /**
     * Change the factory used for the attack and defense level when Cam levels up.
     * @param camLevelFactory - new Factory
     */
    public void setCamLevelFactory(CamLevelFactory camLevelFactory) {
        this.camLevelFactory = camLevelFactory;
        this.levelAttack = camLevelFactory.addLevelAttack();
        this.levelDefense = camLevelFactory.addLevelDefense();
    }
}
