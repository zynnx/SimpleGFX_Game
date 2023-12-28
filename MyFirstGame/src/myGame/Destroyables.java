package myGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import static myGame.MyMouse.startGame;

public class Destroyables<T> {
    Game game;
    private Picture picDestroyable1;
    private boolean destroyed = false;

    public Destroyables(int x, int y, Game game) {
        this.game = game;
        picDestroyable1 = new Picture(x, y, "Resources/d1.png");
        picDestroyable1.grow(-300, -300);
        picDestroyable1.draw();
    }



    public void fire(SpaceShip spaceShip) {
            Shot shot = new Shot(this.picDestroyable1.getX() + this.picDestroyable1.getWidth() + 43, this.picDestroyable1.getY() - 25);
            SpaceshipCollision spaceshipCollision = new SpaceshipCollision(spaceShip, shot);
            for (int y = shot.getShotPicture().getY(); y < 680; y = y + 15) {
                if (spaceshipCollision.spaceshipHit()) {
                    Game.State = Game.STATE.MENU;
                    Sound.shipExplosion.play();
                    Sound.battleSong.stop();
                    Picture gameOver = new Picture(0,0,"Resources/gameover.jpg");
                    gameOver.draw();
                } else {
                    shot.getShotPicture().translate(0, 15);
                    CustomSleep.sleep(50);
                }
            }
            shot.getShotPicture().delete();
    }

    public Picture getPicDestroyable1() {
        return picDestroyable1;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }



}
