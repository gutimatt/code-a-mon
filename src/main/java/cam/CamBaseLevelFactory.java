package main.java.cam;

/**
 * Default Level Factory.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class CamBaseLevelFactory implements CamLevelFactory {
    @Override
    public Attack addLevelAttack() {
        return new StandardLevelAttack();
    }

    @Override
    public Defense addLevelDefense() {
        return new StandardLevelDefense();
    }
}
