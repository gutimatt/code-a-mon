package main.java.cam.types;

import main.java.cam.Attack;
import main.java.cam.Defense;

/**
 * Stats for a normal CAM.
 * @author : Matthew Gutierrez
 * @version : 1.0
 **/
public class NormalStats {
    static class NormalAttack implements Attack {
        @Override
        public double getValue() {
            return 20;
        }
    }

    static class NormalDefense implements Defense {
        @Override
        public double getValue() {
            return 20;
        }
    }
}
