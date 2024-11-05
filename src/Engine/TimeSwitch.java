package Engine;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Game.ScreenCoordinator;

public class TimeSwitch {
    boolean lastSwitch = false;
    boolean nextSwitch = true;
    private ScreenCoordinator screenCoordinator;
    private Timer timer;
    private Random random;
    
    public void TimeSwitch(){
        Math.random();

        
    }

    public void SwitchDaWorld() {
        timer = new Timer();

        int delay = 3000 + random.nextInt(7000); // NOTE 3,000 = 3s seconds are in 1,000 1=1k 2=2k so on
        System.out.println("Next switch in: " + delay + " ms");

        


    }

    public void stopSwitching() {
        if (timer != null) {
            timer.cancel();
        }

}
}
