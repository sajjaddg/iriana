package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventCart extends AnchorPane {
    @FXML
    TextFlow name;
    public EventCart() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("eventcart.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        fxmlLoader.load();
    }

    @FXML
    public void initialize(String name){
        Text text = new Text(name+"");
        text.setFill(Color.WHITE);
        text.autosize();
        this.name.getChildren().add(text);
        this.name.autosize();

    }
}
