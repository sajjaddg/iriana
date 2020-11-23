package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Dashbord {
    @FXML
    public BorderPane borderPane;
    @FXML
    public ScrollPane scrollpaneEvent;
    @FXML
    public VBox events;
    @FXML
    Label name_LBL;
    @FXML
    Label gmail_LBL;
    private User user;
    public void HomeBtnClicked() throws IOException {
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("home.fxml"));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("home.fxml"));
        Parent root1 = (Parent) loader.load();
        Home cvc = loader.getController();
        borderPane.setCenter(newLoadedPane);
    }
    public void TestBtnClicked() throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("test.fxml"));
        Parent root1 = (Parent) loader.load();
        Test cvc = loader.getController();
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("test.fxml"));
        borderPane.setCenter(newLoadedPane);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void initialize(User user) throws IOException {
        setUser(user);
        name_LBL.setText(user.getName());
        gmail_LBL.setText(user.getGmail());
        try {
            Claender claender = new Claender("sajjaddg@gmail.com");
            ArrayList<JSONObject> listevents = claender.getEvents();
            for (int i = 0; i<listevents.size();i++){
                JSONObject jsonObject = listevents.get(i);
                EventCart eventCart = new EventCart();
                eventCart.initialize(jsonObject.getString("summary"));
                events.getChildren().add(eventCart);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        events.setSpacing(10);
        scrollpaneEvent.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollpaneEvent.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        HomeBtnClicked();

    }
    public void exitClicked(){
        System.exit(0);
    }
    public void minimizeClicked(){
        Stage stage = (Stage) events.getScene().getWindow();
        stage.setIconified(true);

    }
    public void signOutClicked() throws IOException, URISyntaxException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root1);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        Stage astage = (Stage) scrollpaneEvent.getScene().getWindow();
        astage.close();
    }
    public void TestPerformedClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("testPerformed.fxml"));
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("testPerformed.fxml"));
        borderPane.setCenter(newLoadedPane);
    }
    public void reportBtnClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("report.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root1);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
}
