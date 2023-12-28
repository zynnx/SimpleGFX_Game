package myGame;

import java.util.List;

public class MouseAnimator implements Runnable {

    private SpaceShip ship;

    private List<Destroyables> destroyables;

    //if MENU vamos poder dar start, mute, exit
    //else ship.fire.mouse
    double x,y;
    public MouseAnimator(SpaceShip spaceShip, double x, double y, List<Destroyables> destroyables) {
        ship = spaceShip;
        this.x = x;
        this.y = y;
        this.destroyables = destroyables;
    }

    public void animateSpaceShip() {
        ship.fire_mouse(x,y,destroyables);
    }

    @Override
    public void run() {
        animateSpaceShip();
    }
}
