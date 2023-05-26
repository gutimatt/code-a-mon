package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.Defense;

/**
 * Stats for the Earth CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class EarthStats {
    static class EarthAttack implements Attack {
        @Override
        public double getValue() {
            return 30;
        }
    }

    static class EarthDefense implements Defense {
        @Override
        public double getValue() {
            return 40;
        }
    }
}
