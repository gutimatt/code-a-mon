package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.CamFactory;
import main.java.cam.Defense;

/**
 * Factory for Earth CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class EarthFactory implements CamFactory {
    @Override
    public Attack addCamAttack() {
        return new EarthStats.EarthAttack();
    }

    @Override
    public Defense addCamDefense() {
        return new EarthStats.EarthDefense();
    }
}
