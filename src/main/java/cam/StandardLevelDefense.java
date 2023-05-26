package main.java.cam;

/**
 * Standard level of a defense for a CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class StandardLevelDefense implements Defense {
    @Override
    public double getValue() {
        return 1;
    }
}
