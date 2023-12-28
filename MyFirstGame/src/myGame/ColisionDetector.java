package myGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColisionDetector {

    private List<Destroyables> destroyables;
    private Shot shot;
    private Map <Shot, List<Destroyables>> colisionMap = new HashMap<>();
    public ColisionDetector(List<Destroyables> destroyables, Shot shot){
        this.destroyables = destroyables;
        this.shot = shot;
        add();
    }


    public void add(){
        colisionMap.put(this.shot,this.destroyables);
    }

    public boolean spaceShipCheckColision() {

        if (!destroyables.isEmpty()) {

            Rectangle shotColision = new Rectangle(shot.getShotPicture().getX(), shot.getShotPicture().getY(), shot.getShotPicture().getWidth(), shot.getShotPicture().getHeight());
            for (int i = 0; i < colisionMap.get(shot).size(); i++) {
                Destroyables destroyable = colisionMap.get(shot).get(i);
                if (destroyable.isDestroyed()) {
                    continue;
                }
                Rectangle destroyableColision = new Rectangle(destroyable.getPicDestroyable1().getX() - 90, destroyable.getPicDestroyable1().getY() - 90, 80, 80);
                if (shotColision.intersects(destroyableColision)) {
                    Sound.destroyedShipExplosion.play();
                    destroyable.setDestroyed(true);
                    destroyableColision.translate(0, 0);
                    destroyable.getPicDestroyable1().translate(0, 0);
                    destroyable.getPicDestroyable1().delete();
                    destroyables.remove(i);
                    return true;
                }
            }
            return false;
        } else{
            Game.State = Game.STATE.MENU;
            Sound.battleSong.stop();
            Picture win = new Picture(0,0,"Resources/win.png");
            win.draw();
            return true;
        }
    }
}
