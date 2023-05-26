package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.Defense;

/**
 * Stats for the Water CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class WaterStats {
    static class WaterAttack implements Attack {
        @Override
        public double getValue() {
            return 40;
        }
    }

    static class WaterDefense implements Defense {
        @Override
        public double getValue() {
            return 30;
        }
    }
}
