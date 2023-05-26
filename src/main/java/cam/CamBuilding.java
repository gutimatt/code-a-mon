package main.java.cam;

import main.java.cam.types.AirCam;
import main.java.cam.types.AirFactory;
import main.java.cam.types.EarthCam;
import main.java.cam.types.EarthFactory;
import main.java.cam.types.FireCam;
import main.java.cam.types.FireFactory;
import main.java.cam.types.NormalCam;
import main.java.cam.types.NormalFactory;
import main.java.cam.types.WaterCam;
import main.java.cam.types.WaterFactory;
import main.java.util.CamTypes;

/**
 * Builds the appropriate CAM using the right factory based on the input.
 *
 * This builds out the abstract factories and creates the CAMs.
 *
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class CamBuilding {
    /**
     * Builds default level Cams.
     * @param type - type of CAm to build
     * @param name - name of the CAM
     * @return Cam built
     */
    public static Cam build(CamTypes type, String name) {
        Cam cam;
        CamBaseLevelFactory camLevelFactory = new CamBaseLevelFactory();
        CamFactory camFactory;

        if (type.equals(CamTypes.WATER)) {
            camFactory = new WaterFactory();
            cam = new WaterCam(camLevelFactory, camFactory, name);
        } else if (type.equals(CamTypes.AIR)) {
            camFactory = new AirFactory();
            cam = new AirCam(camLevelFactory, camFactory, name);
        } else if (type.equals(CamTypes.EARTH)) {
            camFactory = new EarthFactory();
            cam = new EarthCam(camLevelFactory, camFactory, name);
        } else if (type.equals(CamTypes.FIRE)) {
            camFactory = new FireFactory();
            cam = new FireCam(camLevelFactory, camFactory, name);
        } else {
            camFactory = new NormalFactory();
            cam = new NormalCam(camLevelFactory, camFactory, name);
        }

        cam.makeCam();
        return cam;
    }
}
