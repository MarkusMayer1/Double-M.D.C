package at.ac.fhcampuswien;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Controller {

    private Game game = new Game();

    @FXML
    ImageView imgV_player1;
    @FXML
    ImageView imgV_player2;
    @FXML
    ImageView imgV_player3;
    @FXML
    ImageView imgV_player4;
    @FXML
    ImageView imgV_player5;
    @FXML
    ImageView imgV_player6;
    @FXML
    ImageView imgV_player7;
    @FXML
    Button Btn_Start;
    @FXML
    Button Btn_Hit;
    @FXML
    Button Btn_Stand;
    @FXML
    Button Btn_Double;
    @FXML
    Label playerHandValue;
    @FXML
    Label dealerHandValue;
    @FXML
    ImageView imgV_dealer1;
    @FXML
    ImageView imgV_dealer2;
    @FXML
    ImageView imgV_dealer3;
    @FXML
    ImageView imgV_dealer4;
    @FXML
    ImageView imgV_dealer5;
    @FXML
    ImageView imgV_dealer6;
    @FXML
    ImageView imgV_dealer7;
    @FXML
    Label WinMessage;
    @FXML
    Label Budget;
    @FXML
    Label Bet;

    public void WinGame() {
        WinMessage.setText(game.checkWin());
        WinMessage.setVisible(true);
        Btn_Hit.setDisable(true);
        Btn_Stand.setDisable(true);
        Btn_Double.setDisable(true);
        Btn_Start.setVisible(true);
        dealerHandValue.setVisible(true);
    }

    @FXML
    public void exit(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            Platform.exit();
        }
    }

    @FXML
    public void Hit(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            game.Hit();
            drawPlayer();
            if (game.getP().getGameHand().HandValue() >= 21) {
                game.dealersTurn();
                drawDealer();
                WinGame();
            }
        }
    }

    @FXML
    public void Start(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            restart();
            if (game.getP().getBudget() <= 5) {
                endscreen();
            } else {
                game.StartGame(game.getP().getBudget());
                game.getP().setBudget(game.getP().getBudget() - game.getP().getEinsatz());
                Budget.setText("Budget: " + game.getP().getBudget());
                Bet.setText("Bet: " + game.getP().getEinsatz());
                drawPlayer();
                drawDealer();
                dealerHandValue.setVisible(false);
                Btn_Start.setVisible(false);
                Btn_Hit.setVisible(true);
                Btn_Stand.setVisible(true);
                Btn_Double.setVisible(true);
                if (game.getP().getBudget() < game.getP().getEinsatz()) {
                    Btn_Double.setDisable(true);
                }
            }
        }
    }

    @FXML
    public void Stand(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            game.dealersTurn();
            drawDealer();
            WinGame();
        }
    }

    @FXML
    public void Double(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            game.Hit();
            drawPlayer();
            game.getP().setBudget(game.getP().getBudget() - game.getP().getEinsatz());
            game.getP().setEinsatz(game.getP().getEinsatz() * 2);
            Budget.setText("Budget: " + game.getP().getBudget());
            Bet.setText("Bet: " + game.getP().getEinsatz());

            game.dealersTurn();
            drawDealer();

            WinGame();
            game.getP().setEinsatz(game.getP().getEinsatz() / 2);
        }
    }

    public void restart() {
        Btn_Hit.setDisable(false);
        Btn_Stand.setDisable(false);
        Btn_Double.setDisable(false);
        WinMessage.setVisible(false);

        imgV_player1.setImage(null);
        imgV_player2.setImage(null);
        imgV_player3.setImage(null);
        imgV_player4.setImage(null);
        imgV_player5.setImage(null);
        imgV_player6.setImage(null);
        imgV_player7.setImage(null);

        imgV_dealer1.setImage(null);
        imgV_dealer2.setImage(null);
        imgV_dealer3.setImage(null);
        imgV_dealer4.setImage(null);
        imgV_dealer5.setImage(null);
        imgV_dealer6.setImage(null);
        imgV_dealer7.setImage(null);
    }

    public void endscreen() {
        Btn_Hit.setDisable(true);
        Btn_Stand.setDisable(true);
        Btn_Double.setDisable(true);
        WinMessage.setText("No Money left");
        WinMessage.setVisible(true);
        Btn_Start.setDisable(true);

        playerHandValue.setVisible(false);
        dealerHandValue.setVisible(false);

        imgV_player1.setImage(null);
        imgV_player2.setImage(null);
        imgV_player3.setImage(null);
        imgV_player4.setImage(null);
        imgV_player5.setImage(null);
        imgV_player6.setImage(null);
        imgV_player7.setImage(null);

        imgV_dealer1.setImage(null);
        imgV_dealer2.setImage(null);
        imgV_dealer3.setImage(null);
        imgV_dealer4.setImage(null);
        imgV_dealer5.setImage(null);
        imgV_dealer6.setImage(null);
        imgV_dealer7.setImage(null);
    }

    //Anzeigen der Bilder in den ImageViews
    private void drawPlayer() {
        playerHandValue.setText(Integer.toString(game.getP().getGameHand().HandValue()));
        int index = 1;
        try {
            for (Card card : game.getP().GameHand.getHand()) {
                switch (index) {
                    case 1:
                        InputStream stream1 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image1 = new Image(stream1);
                        imgV_player1.setImage(image1);
                        break;
                    case 2:
                        InputStream stream2 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image2 = new Image(stream2);
                        imgV_player2.setImage(image2);
                        break;
                    case 3:
                        InputStream stream3 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image3 = new Image(stream3);
                        imgV_player3.setImage(image3);
                        break;
                    case 4:
                        InputStream stream4 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image4 = new Image(stream4);
                        imgV_player4.setImage(image4);
                        break;
                    case 5:
                        InputStream stream5 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image5 = new Image(stream5);
                        imgV_player5.setImage(image5);
                        break;
                    case 6:
                        InputStream stream6 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image6 = new Image(stream6);
                        imgV_player6.setImage(image6);
                        break;
                    case 7:
                        InputStream stream7 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image7 = new Image(stream7);
                        imgV_player7.setImage(image7);
                        break;
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Anzeigen der Bilder in den ImageViews
    private void drawDealer() {
        dealerHandValue.setText(Integer.toString(game.getD().getGameHand().HandValue()));
        int index = 1;
        try {
            for (Card card : game.getD().GameHand.getHand()) {
                switch (index) {
                    case 1:
                        InputStream stream1 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image1 = new Image(stream1);
                        imgV_dealer1.setImage(image1);
                        break;
                    case 2:
                        InputStream stream2 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image2 = new Image(stream2);
                        imgV_dealer2.setImage(image2);
                        break;
                    case 3:
                        InputStream stream3 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image3 = new Image(stream3);
                        imgV_dealer3.setImage(image3);
                        break;
                    case 4:
                        InputStream stream4 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image4 = new Image(stream4);
                        imgV_dealer4.setImage(image4);
                        break;
                    case 5:
                        InputStream stream5 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image5 = new Image(stream5);
                        imgV_dealer5.setImage(image5);
                        break;
                    case 6:
                        InputStream stream6 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image6 = new Image(stream6);
                        imgV_dealer6.setImage(image6);
                        break;
                    case 7:
                        InputStream stream7 = new FileInputStream("src/main/resources/Karten/" + card.toString());
                        Image image7 = new Image(stream7);
                        imgV_dealer7.setImage(image7);
                        break;
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
