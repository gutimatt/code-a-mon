package main.java.cam;

/**
 * Default level of attack for a Cam.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class StandardLevelAttack implements Attack {
    @Override
    public double getValue() {
        return 1;
    }
}
