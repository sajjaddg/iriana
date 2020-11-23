package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class Fullclientview {
    private Client client;
    @FXML
    public TextFlow Company;
    @FXML
    public TextFlow Province;
    @FXML
    public TextFlow Product_Name;
    @FXML
    public TextFlow Prodact_type;
    @FXML
    public TextFlow Manager;
    @FXML
    public TextFlow gmail;
    @FXML
    public TextFlow Phone_number;
    @FXML
    public ImageView IVicon;
    @FXML
    public Button exitBtn;
    @FXML
    public TextFlow lastStatus;
    @FXML
    public TextFlow TesterName;
    @FXML
    public TextFlow Leter_Number;


    public void initialize(Client client) {
        this.client=client;
        setIVicon();
        setInformatio();
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
    }

    private void setInformatio() {
        Text leter_Number = new Text(client.getLeter_Number() +"\n"+client.getRequst_number());
        leter_Number.setFill(Color.WHITE);
        Text company = new Text(client.getCompany());
        company.setFill(Color.WHITE);
        Text province = new Text(client.getProvince());
        province.setFill(Color.WHITE);
        Text product_Name = new Text(client.getProduct_Name());
        product_Name.setFill(Color.WHITE);
        Text prodact_type = new Text(client.getProdact_type());
        prodact_type.setFill(Color.WHITE);
        Text manager = new Text(client.getManager());
        manager.setFill(Color.WHITE);
        Text gmail = new Text(client.getGmail());
        gmail.setFill(Color.WHITE);
        Text phone_number = new Text(client.getPhone_number());
        phone_number.setFill(Color.WHITE);
        Text laststatus = new Text("تست اولیه انجام نشده است");
        laststatus.setFill(Color.WHITE);
        if (client.getLast_status().equals("B")){
            laststatus.setText("تست اولیه انجام شده است");
        }
        if (client.getLast_status().equals("C")){
            laststatus.setText("آماده برای لایسنس");
        }
        Text tester = new Text(client.getTester());
        tester.setFill(Color.WHITE);
        lastStatus.getChildren().add(laststatus);
        TesterName.getChildren().add(tester);
        Company.getChildren().add(company);
        Province.getChildren().add(province);
        Product_Name.getChildren().add(product_Name);
        Prodact_type.getChildren().add(prodact_type);
        Manager.getChildren().add(manager);
        this.gmail.getChildren().add(gmail);
        Phone_number.getChildren().add(phone_number);
        Leter_Number.getChildren().add(leter_Number);
    }

    private void setIVicon() {
        if (client.getProdact_type().equals("مطب")) {
            IVicon.setImage(new Image(getClass().getResourceAsStream("/icon/matab.png")));
        } else if (client.getProdact_type().equals("داروخانه")) {
            IVicon.setImage(new Image(getClass().getResourceAsStream("/icon/drog.png")));
        } else if (client.getProdact_type().equals("تصویربرداری")) {
            IVicon.setImage(new Image(getClass().getResourceAsStream("/icon/tasvir.png")));
        } else {
            IVicon.setImage(new Image(getClass().getResourceAsStream("/icon/lab.png")));
        }

    }
}
