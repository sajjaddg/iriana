package sample;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class History {
    private Client client;
    @FXML
    public Button exitBtn;
    @FXML
    public VBox testHistory;
    @FXML
    public ScrollPane scroll;

    public void initialize(Client c) throws SQLException, IOException {
        client = c;
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                try {
                    Stage stage = (Stage) exitBtn.getScene().getWindow();
                    stage.close();
                }
                catch (Exception ee){
                    System.out.println(ee);
                }
            }
        };
        exitBtn.setOnAction(event);
        Statement statement = Database.clientData();
        ResultSet resultset = statement.executeQuery("SELECT * FROM test WHERE Client_ID='"+c.getID()+"'");
        while (resultset.next()){
            TestView testView = new TestView();
            testView.initialize(resultset.getString("Description"),resultset.getString("Result"),resultset.getString("Type"));
            testHistory.getChildren().add(testView);
        }
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        testHistory.setSpacing(10);
    }
}
