package myGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static myGame.MyMouse.startGame;

public class Game {
    public static STATE State = STATE.MENU;
    private SpaceShip spaceShip = new SpaceShip();
    private List<Destroyables> destroyables = new ArrayList<>(40);
    private MyKeyBoard kb = new MyKeyBoard(spaceShip, destroyables);
    private Menu menu = new Menu();
    private MyMouse mouse = new MyMouse(spaceShip, destroyables, menu, this);

    public void init() {
        menu.startButton();
        mouse.handler(STATE.MENU);
    }

    public void initGame() {
        Picture backGround = new Picture(0, 0, "Resources/Fundo720.png");
        backGround.grow(0, 60);
        Sound.startMenuSong.stop();
        Sound.battleSong.loopIndef();
        backGround.draw();
        spaceShip.getPictureSpaceShip().draw();
        createDestroyables();
        kb.handler();
        mouse.handler(STATE.GAME);
    }


    private void createDestroyables() {
        int startx = -50;
        int starty = -200;

        for (int fila = 0; fila < 30 / 10; fila++) {
            for (int i = 10 * fila; i < 10 * (fila + 1); i++) {
                destroyables.add(i, new Destroyables(startx, starty, this));
                startx += 100;
            }
            starty += 100;
            startx = -50;
        }
        generateFire();
    }

    public enum STATE {
        MENU,
        GAME;
    }

    public void generateFire() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int num = (int) (Math.random() * destroyables.size());
                destroyables.get(num).fire(spaceShip);
            }
        };
        timer.schedule(task, 0, 1000);
    }

}



