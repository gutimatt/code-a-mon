package main.java.cam;

/**
 * Facotry for gold level.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class CamGoldFactory implements CamLevelFactory {
    @Override
    public Attack addLevelAttack() {
        return new SpecialAttack();
    }

    @Override
    public Defense addLevelDefense() {
        return new Shield();
    }
}
