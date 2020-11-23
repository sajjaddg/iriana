package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    PasswordField password_TF;
    @FXML
    TextField userName_TF;
    public static User user;

    Statement statement =Database.clientData();
    public Controller() throws SQLException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        password_TF.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode().equals(KeyCode.ENTER))
                {
                    sigingClicked();
                }
            }
        });

    }
    public void sigingClicked(){
        System.out.println(loginCheck(userName_TF.getText(),password_TF.getText()));
        String queryString = "SELECT * FROM tester where userName='"+userName_TF.getText()+"'";
        if (loginCheck(userName_TF.getText(),password_TF.getText())){
            try {
                ResultSet result = statement.executeQuery(queryString);
                while (result.next()) {
                    User user = new User(result.getInt("ID"), result.getString("userName"), result.getString("gmail"), result.getString("phoneNumber"), result.getString("internalNumber"), result.getString("name"));
                    Controller.user = user;
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashbord.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    Scene scene = new Scene(root1);
                    scene.setFill(Color.TRANSPARENT);
                    stage.setScene(scene);
                    Dashbord controller = fxmlLoader.getController();
                    controller.initialize(user);
                    stage.show();
                }
                Stage stage = (Stage) password_TF.getScene().getWindow();
                stage.close();
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
    }
    public Boolean loginCheck(String username, String password) {
        try {
            String queryString = "SELECT * FROM tester where userName='"+username+"' and password='"+password+"'";
            ResultSet results = statement.executeQuery(queryString); //where ps is Object of PreparedStatement
            if (!results.next()) {
                return false;
            }
            return true;
        } catch (SQLException sql) {
            System.out.println(sql);
            return false;
        }
    }
    public void exitClicked(){
        System.exit(0);
    }

}
