package com.kodilla;

public class Hand {

    int soft = 8; // temporary value

    public void addCard(Card card) {
        System.out.println("add card");
    }

    public int evealuateHand() {
        return 10;
    }

    public int getSoft() {
        return soft;
    }

    public void discardHand() {
        System.out.println("Tymczasowy tekst z discardHand");
    }
}
