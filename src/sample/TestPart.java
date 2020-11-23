package sample;

import com.google.api.client.util.Data;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestPart extends AnchorPane {
    private Client client;
    @FXML
    TextFlow typeOfTest;
    @FXML
    TextFlow nameOfCompany;
    @FXML
    ImageView icon_IV;
    @FXML
    Button TrueButton;
    @FXML
    Button finalbutton;
    @FXML
    Button falsebutton;
    @FXML
    Pane description_pane;
    @FXML
    TextArea description;
    @FXML
    TextField expert;
    @FXML
    Button returnbutton;
    private String result;
    private Test test;
    public TestPart() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("testpart.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        fxmlLoader.load();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTilePane(Test tilePane) {
        this.test = tilePane;
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
                       description_pane.toFront();
                       result = "True";
                }
                catch (Exception ee){
                    System.out.println(ee);
                }
            }
        };
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                try {
                    description_pane.toFront();
                    result = "False";
                }
                catch (Exception ee){
                    System.out.println(ee);
                }
            }
        };
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                try {
                    description_pane.toBack();
                }
                catch (Exception ee){
                    System.out.println(ee);
                }
            }
        };
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                try {
                    finalButtonCliked(title);
                    description_pane.toBack();
                    description.clear();
                    expert.clear();
                }
                catch (Exception ee){
                    System.out.println(ee);
                }
            }
        };
        TrueButton.setOnAction(event);
        falsebutton.setOnAction(event1);
        returnbutton.setOnAction(event2);
        finalbutton.setOnAction(event3);
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
        else if(title.equals("تصویربرداری")) {
            icon_IV.setImage(new Image(getClass().getResourceAsStream("/icon/tasvir.png")));
        }
        else if (title.equals("بیمه گری")){
            icon_IV.setImage(new Image(getClass().getResourceAsStream("/icon/Insurance.png")));
        }
        else {
            icon_IV.setImage(new Image(getClass().getResourceAsStream("/icon/lab.png")));
        }
    }
    public void finalButtonCliked(String title) throws SQLException, IOException {
        Statement statement =Database.clientData();
        if (result.equals("True")) {
            if (title.equals("تست اولیه")) {
                statement.execute("UPDATE myguests SET First_Test = 'True' WHERE ID='"+client.getID()+"'");
                statement.execute("UPDATE myguests SET Last_status = 'B' WHERE ID='"+client.getID()+"'");
            } else if (title.equals("پزشکان")) {
                statement.execute("UPDATE myguests SET Physicians = 'True' WHERE ID='"+client.getID()+"'");
            } else if (title.equals("دارو")) {
                statement.execute("UPDATE myguests SET Drog = 'True' WHERE ID='"+client.getID()+"'");
            } else if (title.equals("تصویربرداری")) {
                statement.execute("UPDATE myguests SET Imaging = 'True' WHERE ID='"+client.getID()+"'");
            } else if (title.equals("بیمه گری")) {
                statement.execute("UPDATE myguests SET Insurance = 'True' WHERE ID='"+client.getID()+"'");
            } else {
                statement.execute("UPDATE myguests SET Lab = 'True' WHERE ID='"+client.getID()+"'");
            }
            test.addgusts();
        }
        String time = LocalDateTime.now().getHour() + ":"+LocalDateTime.now().getMinute();
        statement.execute("INSERT INTO test(Tester_ID,Client_ID,Time,Date,Type,Result,Description,Expert) VALUES ('"+Controller.user.getId()+"','"+client.getID()+"','"+time+"','"+shamsi.getCurrentShamsidate()+"','"+title+"','"+result+"','"+description.getText()+"','"+expert.getText()+"')");
    }
}
