package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {

    static Image card2c = new Image("2C.png");
    static Image card2d = new Image("2D.png");
    static Image card2h = new Image("2H.png");
    static Image card2s = new Image("2S.png");
    static Image card3c = new Image("3C.png");
    static Image card3d = new Image("3D.png");
    static Image card3h = new Image("3H.png");
    static Image card3s = new Image("3S.png");
    static Image card4c = new Image("4C.png");
    static Image card4d = new Image("4D.png");
    static Image card4h = new Image("4H.png");
    static Image card4s = new Image("4S.png");
    static Image card5c = new Image("5C.png");
    static Image card5d = new Image("5D.png");
    static Image card5h = new Image("5H.png");
    static Image card5s = new Image("5S.png");

    public Image cardImage;

    public Card(Image cardImage) {
        this.cardImage = cardImage;
    }

    public Image getCardImage() {
        return card3c;
    }
}
