package myGame;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    Picture startPicture;

    public void startButton() {

        if (Game.State == Game.STATE.MENU) {
            Picture picture = new Picture(0, 0, "Resources/Fundo720.png");
            picture.grow(0,60);
            Sound.startMenuSong.play();
            Picture logoSpaceInvaders = new Picture(400, 30, "Resources/spaceinvaders_resized.png");
            this.startPicture = new Picture(600, 370, "Resources/StartButton_resized.png");
            startPicture.grow(20, 0);
            Picture soundButton = new Picture(635, 440, "Resources/sound_resized.png");
            soundButton.grow(20, 0);
            Picture exitGameButton = new Picture(600, 510, "Resources/ExitButton_resized.png");
            exitGameButton.grow(20, 0);
            Picture alien1 = new Picture(150, 300, "Resources/alien.png");
            alien1.grow(20, 0);
            Picture alien2 = new Picture(900, 300, "Resources/alien.png");
            alien2.grow(20, 0);
            picture.draw();
            logoSpaceInvaders.draw();
            startPicture.draw();
            alien1.draw();
            alien2.draw();
            soundButton.draw();
            exitGameButton.draw();
        }
    }
}
