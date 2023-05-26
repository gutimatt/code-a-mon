package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.CamFactory;
import main.java.cam.Defense;

/**
 * Factory for Air CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class AirFactory implements CamFactory {
    @Override
    public Attack addCamAttack() {
        return new AirStats.AirAttack();
    }

    @Override
    public Defense addCamDefense() {
        return new AirStats.AirDefense();
    }
}
