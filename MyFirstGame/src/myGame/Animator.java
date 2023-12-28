package myGame;


import java.util.ConcurrentModificationException;
import java.util.List;

/*
    So basically I created a new Thread just to animate the spaceship shot,
    the thread responsible to draw things on canvas and listen to keyboard events
    was getting stuck on executing the spaceship.shot(), therefore it was "listening to keyboard events",
    instead of drawing things on canvas, so I created a new Thread just to animate the shot.
    Go check your keyboard handler to see how I made the new Thread start running.
 */
public class Animator implements Runnable{

    private SpaceShip ship;

    private List<Destroyables> destroyables;


    public Animator(SpaceShip spaceShip, List<Destroyables> destroyables) {
        this.ship = spaceShip;
       this.destroyables = destroyables;
    }

    public void animateSpaceShip() {
        try {
            ship.fire(destroyables);
        }catch (NullPointerException | ConcurrentModificationException f) {
            System.out.println(f.getMessage());
        }

    }

    @Override
    public void run() {
        animateSpaceShip();
    }
}
