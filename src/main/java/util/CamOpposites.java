package main.java.util;

import main.java.cam.Cam;
import main.java.cam.types.AirCam;
import main.java.cam.types.EarthCam;
import main.java.cam.types.FireCam;
import main.java.cam.types.WaterCam;

/**
 * Class to check if two types of CAMS are opposite.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class CamOpposites {
    public static final int FIRE = 1;
    public static final int WATER = 1;
    public static final int AIR = -1;
    public static final int EARTH = -1;

    /**
     * Checks if two cams are opposite of another.
     * Fire and water are opposite.
     * Air and Earth are opposite.
     * @param cam1 - Cam
     * @param cam2 - Cam
     * @return boolean
     */
    public static boolean isOpposite(Cam cam1, Cam cam2) {
        if (cam1.getClass().getName().equals(cam2.getClass().getName())) {
            return false;
        }
        int c1 = convertType(cam1);
        int c2 = convertType(cam2);
        return (c1 * c2) > 0;
    }

    /**
     * Takes a Cam and maps it to the final attributes to find positive or negative.
     * @param cam - Cam
     * @return int of attribute looking for
     */
    private static int convertType(Cam cam) {
        if (cam.getClass().equals(WaterCam.class)) {
            return WATER;
        } else if (cam.getClass().equals(AirCam.class)) {
            return AIR;
        } else if (cam.getClass().equals(EarthCam.class)) {
            return EARTH;
        } else if (cam.getClass().equals(FireCam.class)) {
            return FIRE;
        } else {
            return 0;
        }
    }
}
