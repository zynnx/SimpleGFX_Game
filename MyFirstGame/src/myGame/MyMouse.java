package myGame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

import java.util.List;

public class MyMouse implements MouseHandler {

    private SpaceShip spaceShip;
    private List<Destroyables> destroyables;
    private Menu menu;
    private Mouse mouse = new Mouse(this);
    private Game.STATE gameState;

    private Game game;

    public static boolean startGame;

    public MyMouse(SpaceShip spaceShip, List<Destroyables> destroyables, Menu menu, Game game) {
        this.destroyables = destroyables;
        this.spaceShip = spaceShip;
        this.menu = menu;
        this.game = game;
    }

    public void handler(Game.STATE gameState) {
        this.gameState = gameState;
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEventType.MOUSE_CLICKED && gameState == Game.STATE.GAME) {
            Thread thread = new Thread(new MouseAnimator(spaceShip, mouseEvent.getX(), mouseEvent.getY(), destroyables));
            thread.start();
        } else if (mouseEvent.getEventType() == MouseEventType.MOUSE_CLICKED && Game.State == Game.STATE.MENU) {
            int xMin = menu.startPicture.getX();
            int xMax = menu.startPicture.getX() + menu.startPicture.getWidth();
            int yMin = menu.startPicture.getY() + menu.startPicture.getHeight();
            int yMax = menu.startPicture.getY() + menu.startPicture.getHeight() * 2;
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            if (mouseX < xMax && mouseX > xMin && mouseY > yMin && mouseY < yMax) {
                Game.State = Game.STATE.GAME;
                game.initGame();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}