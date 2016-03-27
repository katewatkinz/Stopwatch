/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kyw356stopwatchfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
 
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ImageView hand;
    @FXML
    private Label titleLabel;
    @FXML
    private Integer elapsedTime = 0; 
    @FXML
    private Timeline timeLine;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private Button resetButton;
    @FXML
    private AnchorPane root;

 
    @FXML
    void handleStopButtonAction(ActionEvent event) 
     {
        timeLine.stop();   
     }
    @FXML
    void handleResetButtonAction(ActionEvent event) 
     {
        timeLine.stop();
        elapsedTime = 0;
        updateStopwatch(); 
     }
    
    
    @FXML
    void handleStartButtonAction(ActionEvent event)
    {
        timeLine.play();
    }

    public void updateStopwatch() 
    {         
        String output;
        Integer rotation = elapsedTime * 6;
        Integer seconds = elapsedTime%60;
        Integer minutes = elapsedTime/60;
        
        if(elapsedTime == 0)
        {
            output = ("00"+":"+"00");
            titleLabel.setText(output);
            
        }
        else if(elapsedTime != 0)
        {
        if(seconds < 10 && minutes < 10)
        {
            output = "0" + minutes.toString() + ":" + "0" + seconds.toString();
            titleLabel.setText(output);
        }
        else if(seconds >= 10 && minutes < 10)
        {
            output = "0" + minutes.toString() + ":" + seconds.toString();
            titleLabel.setText(output);
        }
        else if(seconds > 10 && minutes > 10)
        {        
            output = minutes.toString() + ":" + seconds.toString();
            titleLabel.setText(output);
        }
        }
        elapsedTime++;
        hand.setRotate(rotation);      
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       root.setStyle("-fx-background-color:black");
       timeLine = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> updateStopwatch() ));
       timeLine.setCycleCount(Animation.INDEFINITE);
    }
}