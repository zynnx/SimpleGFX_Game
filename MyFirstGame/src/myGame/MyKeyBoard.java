
package myGame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.List;

public class MyKeyBoard implements KeyboardHandler {

    private SpaceShip spaceShip;
    private List<Destroyables> destroyables;
    private Keyboard kb = new Keyboard(this);


    public MyKeyBoard(SpaceShip spaceShip, List<Destroyables> destroyables){
        this.spaceShip = spaceShip;
        this.destroyables = destroyables;
    }

    public void handler() {
        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(left);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(space);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(Game.State == Game.STATE.GAME) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_RIGHT:
                    if(spaceShip.getPictureSpaceShip().getX() < 1020) {
                        spaceShip.getPictureSpaceShip().translate(20, 0);
                    }
                    break;
                case KeyboardEvent.KEY_LEFT:
                    if(spaceShip.getPictureSpaceShip().getX() > 0) {
                        spaceShip.getPictureSpaceShip().translate(-20, 0);
                    }
                    break;
                case KeyboardEvent.KEY_SPACE:
                    Thread thread = new Thread(new Animator(spaceShip, destroyables));
                    thread.start();
                    break;
            }
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
