package myGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class SpaceShip {

    private Picture pictureSpaceShip;
    private int middleShip;
    private boolean crashed = false;

    public SpaceShip() {
        this.pictureSpaceShip = new Picture(640, 600, "Resources/spsf.png");
        pictureSpaceShip.grow(70, 70);
        middleShip = getPictureSpaceShip().getWidth()/2;
    }

    public void fire(List<Destroyables> destroyables) {
        Shot shot = new Shot(this.pictureSpaceShip.getX() + this.getPictureSpaceShip().getWidth() / 2 - 10, this.pictureSpaceShip.getY() + 50);
        Sound sound = new Sound("/Resources/shotLaser.wav");
        sound.play();
        ColisionDetector colisionDetector = new ColisionDetector(destroyables, shot);
        for (int y = shot.getShotPicture().getY(); y > 10; y = y - 5) {
            shot.getShotPicture().translate(0, -5);
            if(colisionDetector.spaceShipCheckColision()){
                shot.getShotPicture().delete();
                return;
            }
            CustomSleep.sleep(10);
        }
        Sound.shoot.stop();
        shot.getShotPicture().delete();
    }

    public void fire_mouse(double x, double y, List<Destroyables> destroyables) {
        Shot shot = new Shot(this.pictureSpaceShip.getX() + middleShip - 10, this.pictureSpaceShip.getY() + 50);
        Sound.shoot.play();
        ColisionDetector colisionDetector = new ColisionDetector(destroyables, shot);

        double factor = ((y - this.pictureSpaceShip.getY()) + 50) / (x - (this.pictureSpaceShip.getX() + middleShip +10));
        double angle = Math.atan(factor);
        double vx = Math.cos(angle) * 700;
        if (x < this.pictureSpaceShip.getX() +middleShip - 10) {
            vx = -vx;
        }
        double vy = Math.abs(Math.sin(angle)) * 700;

        System.out.println("vx: "  + vx + "vy :" + vy);
        if (y < 900) {
            for (int row = this.pictureSpaceShip.getY(); row > 0 && shot.getShotPicture().getX() < 1270; row -= Math.abs(vy) * 0.05) {
                assert shot != null;
                shot.getShotPicture().translate(vx * 0.05, -(vy * 0.05));
                if(colisionDetector.spaceShipCheckColision()){
                    shot.getShotPicture().delete();
                    shot = null;
                }
                CustomSleep.sleep(50);
            }
            assert shot != null;
            shot.getShotPicture().delete();
        }
    }

    public Picture getPictureSpaceShip() {
        return pictureSpaceShip;
    }


}
