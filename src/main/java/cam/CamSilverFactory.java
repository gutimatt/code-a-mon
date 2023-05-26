package main.java.cam;

/**
 * Middle tier level of a Cam.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class CamSilverFactory implements CamLevelFactory {
    @Override
    public Attack addLevelAttack() {
        return new WeaponAttack();
    }

    @Override
    public Defense addLevelDefense() {
        return new Armor();
    }
}
