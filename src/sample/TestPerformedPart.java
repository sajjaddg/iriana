package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPerformedPart extends AnchorPane {
    private Client client;
    @FXML
    TextFlow nameOfCompany;
    @FXML
    ImageView icon_IV;
    @FXML
    TextFlow typeOfTest;
    @FXML
    Button RecycleBin;
    Statement statement = Database.clientData();
    TestPerformed testPerformed;
    public TestPerformedPart() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("testPerformedPart.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        fxmlLoader.load();
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public void setTestPerformed(TestPerformed testPerformed){
        this.testPerformed = testPerformed;
    }
    public void initialize(String title){
        Text text = new Text("("+client.getProduct_Name()+")" +" "+title);
        text.setFill(Color.WHITE);
        Text text1 = new Text(client.getCompany());
        text1.setFill(Color.WHITE);
        typeOfTest.getChildren().add(text);
        nameOfCompany.getChildren().add(text1);
        setIVicon(title);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                try {
                    deleteTest(title);

                }
                catch (Exception ee){
                    System.out.println(ee);
                }
            }
        };
        RecycleBin.setOnAction(event);
    }
    private void setIVicon(String title){
        if (title.equals("تست اولیه")){
        icon_IV.setImage(new Image(getClass().getResourceAsStream("/icon/first.png")));
    }
        else if (title.equals("پزشکان")){
        icon_IV.setImage(new Image(getClass().getResourceAsStream("/icon/pezeshk.png")));
        }
        else if (title.equals("دارو")){
            icon_IV.setImage(new Image(getClass().getResourceAsStream("/icon/drog.png")));
        }
        else if(title.equals("تصویربرداری")){
            icon_IV.setImage(new Image(getClass().getResourceAsStream("/icon/tasvir.png")));
        }
        else if (title.equals("بیمه گری")){
            icon_IV.setImage(new Image(getClass().getResourceAsStream("/icon/Insurance.png")));
        }
        else {
            icon_IV.setImage(new Image(getClass().getResourceAsStream("/icon/lab.png")));
        }
    }
    public void deleteTest(String title) throws SQLException, IOException {
        if (title.equals("تست اولیه")) {
            statement.execute("UPDATE myguests SET First_Test = null WHERE ID='" + client.getID() + "'");
            statement.execute("UPDATE myguests SET Last_status = 'A' WHERE ID='" + client.getID() + "'");
        } else if (title.equals("پزشکان")) {
            statement.execute("UPDATE myguests SET Physicians = null WHERE ID='" + client.getID() + "'");
        } else if (title.equals("دارو")) {
            statement.execute("UPDATE myguests SET Drog = null WHERE ID='" + client.getID() + "'");
        } else if (title.equals("تصویربرداری")) {
            statement.execute("UPDATE myguests SET Imaging = null WHERE ID='" + client.getID() + "'");
        } else if (title.equals("بیمه گری")) {
            statement.execute("UPDATE myguests SET Insurance = null WHERE ID='" + client.getID() + "'");
        } else {
            statement.execute("UPDATE myguests SET Lab = null WHERE ID='" + client.getID() + "'");
        }
        testPerformed.addgusts();
    }
}
