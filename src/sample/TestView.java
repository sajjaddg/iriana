package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestView extends AnchorPane {
    @FXML
    TextFlow Description;
    @FXML
    TextFlow Type;
    @FXML
    ImageView Result;
    public TestView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("testView.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        fxmlLoader.load();
    }
    @FXML
    public void initialize(String description , String result,String type) throws SQLException {
        Text descriptionText = new Text(description);
        descriptionText.setFill(Color.WHITE);
        Description.getChildren().add(descriptionText);
        try {
            Text typeText = new Text(type);
            typeText.setFill(Color.WHITE);
            Type.getChildren().add(typeText);
        }
        catch (Exception e){
        }

//        System.out.println(result);
        if (result.equals("True")){
            Result.setImage(new Image(getClass().getResourceAsStream("/icon/True.png")));
        }
        else {
            Result.setImage(new Image(getClass().getResourceAsStream("/icon/False.png")));
        }
    }
}
