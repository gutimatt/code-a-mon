package main.java.cam.types;

import main.java.cam.Cam;
import main.java.cam.CamFactory;
import main.java.cam.CamLevelFactory;

/**
 * Earth CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class EarthCam extends Cam {

    private CamLevelFactory camLevelFactory;
    private CamFactory camFactory;

    /**
     * Constructor.
     * @param camLevelFactory - Level of the CAM
     * @param camFactory - Defines attack and defend stats for Fire CAM
     * @param name - Name given
     */
    public EarthCam(CamLevelFactory camLevelFactory,
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
        System.out.println("Making Earth Cam :  " + name);

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
