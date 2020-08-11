package com.kodilla;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> deck;
    private int index;

    public Deck(int numDecks) {
        deck = new ArrayList<>();
        index = 0;
        }

    int numberOfCardsRemaining = 1; // temporary value
    int sizeOfDeck = 2; //temporary value

    public Card dealCard() {
        return null;
    }

    public void restoreDeck() {
        System.out.println("Chyba nowe rozdanie");
    }

    public void shuffle() {
        System.out.println("Tasowanie talii");
    }

    public int getNumberOfCardsRemaining() {
        return numberOfCardsRemaining;
    }

    public int getSizeOfDeck() {
        return sizeOfDeck;
    }
}
