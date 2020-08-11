package com.kodilla;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Blackjack extends Application {
    private final Deck deck = new Deck(1);
    private final Hand hand = new Hand();
    private final Hand dealer = new Hand();

    private boolean busted;
    private boolean playerTurn;

    private FlowPane cards = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane dealerCards = new FlowPane(Orientation.HORIZONTAL);
    private Label totalLabel = new Label();
    private Label getTotalLabelDealer = new Label();

    private Label dealerLbl = new Label("Karty krupiera");
    private Label playerLbl = new Label("Twoje karty");

    private Label status = new Label();
    private Image imageback = new Image("background.jpg");

    public void drawCard(Hand hand, FlowPane pane, Label l) {
        try {
            Card card = deck.dealCard();
            ImageView img = new ImageView(card.getCardImage());
            pane.getChildren().add(img);
            hand.addCard(card);

            int handTotal = hand.evealuateHand();

            StringBuilder total = new StringBuilder();
            if (hand.getSoft() > 0) {
                total.append(handTotal -10).append("/");
            }
            total.append(handTotal);
            l.setText(total.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void newDeck() {
            deck.restoreDeck();
            deck.shuffle();
            System.out.println("Talia przetasowana");
    }

    public void newHand() {
        if (deck.getNumberOfCardsRemaining() <= deck.getSizeOfDeck() * 0.2) {
            newDeck();
        }
        hand.discardHand();
        dealer.discardHand();
        cards.getChildren().removeAll(cards.getChildren());
        dealerCards.getChildren().removeAll(dealerCards.getChildren());
        totalLabel.setText("");
        getTotalLabelDealer.setText("");

        busted = false;
        playerTurn = true;

        drawCard(hand, cards, totalLabel);
        drawCard(dealer, dealerCards, getTotalLabelDealer);
        drawCard(hand, cards, totalLabel);

        status.setText("Twój ruch");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        totalLabel.setFont(new Font("Arial", 24));
        totalLabel.setTextFill(Color.web("#FFF"));

        getTotalLabelDealer.setFont(new Font("Arial", 24));
        getTotalLabelDealer.setTextFill(Color.web("#FFF"));

        status.setTextFill(Color.web("#FFF"));
        status.setFont(new Font("Arial", 24));

        dealerLbl.setTextFill(Color.web("#FFF"));
        dealerLbl.setFont(new Font("Arial", 24));

        playerLbl.setTextFill(Color.web("#FFF"));
        playerLbl.setFont(new Font("Arial", 24));


        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        Button drawButton = new Button();
        drawButton.setText("Hit");
        drawButton.setOnAction((e) -> {
            if (playerTurn && !busted) {
                drawCard(hand, cards, totalLabel);

                if (hand.evealuateHand() > 21) {
                    System.out.println("Przegrałeś");
                    busted = true;
                    playerTurn = false;
                    status.setText("Przegrałeś");
                }
            }
        });

        Button standBtn = new Button();
        standBtn.setText("Stand");
        standBtn.setOnAction((e) -> {
            if (playerTurn && !busted) {
                playerTurn = false;
                while (dealer.evealuateHand() < 17) {
                    drawCard(dealer, dealerCards, getTotalLabelDealer);
                }

                int playerTotal = hand.evealuateHand();
                int dealerTotal = hand.evealuateHand();

                System.out.println("Karty gracza: " + hand);
                System.out.println("Karty krupiera: " + dealer);

                if (playerTotal == 21) {
                    System.out.println("Wygrałeś");
                    status.setText("Wysgrałeś");
                } else if (dealerTotal <= 21 && playerTotal == dealerTotal) {
                    System.out.println("Remis");
                    status.setText("Remis");
                } else if (dealerTotal <= 21 && playerTotal <= dealerTotal) {
                    System.out.println("Przegrałeś");
                    status.setText("Przegrałeś");
                } else {
                    System.out.println("Wygrałeś");
                    status.setText("Wygrałeś");
                }
            }
        });

        Button newBtn = new Button();
        newBtn.setText("Nowe rozdanie");
        newBtn.setOnAction((e) -> {
            newHand();
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);

        grid.add(dealerCards, 0,0,3,1);
        grid.add(dealerLbl, 0,1);
        grid.add(getTotalLabelDealer, 1,1,2,1);

        Pane p = new Pane();
        p.setPrefSize(0, 100);
        grid.add(p,0,2);

        grid.add(cards,0,3,3,1);
        grid.add(playerLbl,0,4);
        grid.add(totalLabel,1,4,2,1);
        grid.add(drawButton,0,5);
        grid.add(standBtn,1,5);
        grid.add(newBtn,2,5);
        grid.add(status,0,6,3,1);
        grid.setBackground(background);

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        primaryStage.setTitle("Black Jack");
        primaryStage.setScene(scene);
        primaryStage.show();

        newDeck();
        newHand();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
