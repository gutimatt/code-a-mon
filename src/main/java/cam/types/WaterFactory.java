package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.CamFactory;
import main.java.cam.Defense;

/**
 * Factory for Water CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class WaterFactory implements CamFactory {
    @Override
    public Attack addCamAttack() {
        return new WaterStats.WaterAttack();
    }

    @Override
    public Defense addCamDefense() {
        return new WaterStats.WaterDefense();
    }
}
