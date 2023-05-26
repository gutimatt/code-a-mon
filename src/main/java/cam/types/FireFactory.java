package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.CamFactory;
import main.java.cam.Defense;

/**
 * Factory for Fire CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class FireFactory implements CamFactory {
    @Override
    public Attack addCamAttack() {
        return new FireStats.FireAttack();
    }

    @Override
    public Defense addCamDefense() {
        return new FireStats.FireDefense();
    }
}
