package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.CamFactory;
import main.java.cam.Defense;

/**
 * Factory for a Normal CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class NormalFactory implements CamFactory {

    @Override
    public Attack addCamAttack() {
        return new NormalStats.NormalAttack();
    }

    @Override
    public Defense addCamDefense() {
        return new NormalStats.NormalDefense();
    }
}
