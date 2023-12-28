package myGame;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static myGame.MyMouse.startGame;

public class SpaceshipCollision {

    private SpaceShip spaceShip;
    private Shot shot;
    private Map<Shot, SpaceShip> colisionMap = new HashMap<>();

    public SpaceshipCollision(SpaceShip spaceShip, Shot shot) {
        this.spaceShip = spaceShip;
        this.shot = shot;
        add();
    }

    public void add() {
        colisionMap.put(this.shot, this.spaceShip);
    }

    public boolean spaceshipHit() {
        Rectangle shotColision = new Rectangle(shot.getShotPicture().getX(), shot.getShotPicture().getY(), shot.getShotPicture().getWidth(), shot.getShotPicture().getHeight());
        int x = spaceShip.getPictureSpaceShip().getX()+50;
        int y = spaceShip.getPictureSpaceShip().getY()+60;
        int w = spaceShip.getPictureSpaceShip().getWidth()-100;
        int h = spaceShip.getPictureSpaceShip().getHeight()-200;
        Rectangle spaceShip = new Rectangle(x, y, w, h);
        return shotColision.intersects(spaceShip);
    }


}

