package at.ac.fhcampuswien;

import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    Button Btn_Hit = new Button();

    Player player = new Player();

    @FXML
    protected void Hit(MouseEvent event){




        if(event.getEventType() == MouseEvent.MOUSE_CLICKED){




            player.getCard(player.getDeck());



        }
    }



}
