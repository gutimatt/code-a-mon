package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.Defense;

/**
 * Stats fo the Air CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class AirStats {
    static class AirAttack implements Attack {
        @Override
        public double getValue() {
            return 25;
        }
    }

    static class AirDefense implements Defense {
        @Override
        public double getValue() {
            return 35;
        }
    }
}
