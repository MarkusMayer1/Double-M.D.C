package at.ac.fhcampuswien;

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
    Label playerHandValue;

    @FXML
    public void Hit(MouseEvent event) throws FileNotFoundException {
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
            game.Hit();
            drawPlayer();
        }
    }

    @FXML
    public void Start(MouseEvent event) throws FileNotFoundException {
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
            game.StartGame();
            drawPlayer();
            Btn_Start.setVisible(false);
            Btn_Hit.setVisible(true);
            Btn_Stand.setVisible(true);
        }
    }

    private void drawPlayer() throws FileNotFoundException {
        playerHandValue.setText(Integer.toString(game.getP().getGameHand().HandValue()));
        int index = 1;
        for (Card card: game.getP().GameHand.getHand()) {
            switch (index) {
                case 1:
                    InputStream stream1 = new FileInputStream("src/main/resources/Karten/"+card.toString());
                    Image image1 = new Image(stream1);
                    imgV_player1.setImage(image1);
                    break;
                case 2:
                    InputStream stream2 = new FileInputStream("src/main/resources/Karten/"+card.toString());
                    Image image2 = new Image(stream2);
                    imgV_player2.setImage(image2);
                    break;
                case 3:
                    InputStream stream3 = new FileInputStream("src/main/resources/Karten/"+card.toString());
                    Image image3 = new Image(stream3);
                    imgV_player3.setImage(image3);
                    break;
                case 4:
                    InputStream stream4 = new FileInputStream("src/main/resources/Karten/"+card.toString());
                    Image image4 = new Image(stream4);
                    imgV_player4.setImage(image4);
                    break;
                case 5:
                    InputStream stream5 = new FileInputStream("src/main/resources/Karten/"+card.toString());
                    Image image5 = new Image(stream5);
                    imgV_player5.setImage(image5);
                    break;
                case 6:
                    InputStream stream6 = new FileInputStream("src/main/resources/Karten/"+card.toString());
                    Image image6 = new Image(stream6);
                    imgV_player6.setImage(image6);
                    break;
                case 7:
                    InputStream stream7 = new FileInputStream("src/main/resources/Karten/"+card.toString());
                    Image image7 = new Image(stream7);
                    imgV_player7.setImage(image7);
                    break;
            }
            index++;
        }
    }
}
