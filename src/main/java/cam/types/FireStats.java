package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.Defense;

/**
 * Stats for Fire CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class FireStats {
    static class FireAttack implements Attack {
        @Override
        public double getValue() {
            return 35;
        }
    }

    static class FireDefense implements Defense {
        @Override
        public double getValue() {
            return 25;
        }
    }
}
