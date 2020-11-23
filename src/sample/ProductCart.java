package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ProductCart extends AnchorPane {
    @FXML
    ImageView IVicon;
    @FXML
    TextFlow CompanyName;
    @FXML
    TextFlow Product_Name;
    @FXML
    Button fullview;
    @FXML
    Pane pane;
    @FXML
    Button history_Btn;
    private Client client;
    public ProductCart() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("productcart.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        fxmlLoader.load();
    }
    public void initialize(Client client){
        this.client = client;
        Text text1 = new Text(client.getCompany());
        Text text2 = new Text(client.getProduct_Name());
        text1.setFill(Color.WHITE);
        text2.setFill(Color.WHITE);
        CompanyName.getChildren().add(text1);
        Product_Name.getChildren().add(text2);
        setIVicon();
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fullclientview.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    Scene scene = new Scene(root1);
                    scene.setFill(Color.TRANSPARENT);
                    stage.setScene(scene);
                    Fullclientview controller = fxmlLoader.getController();
                    controller.initialize(ProductCart.this.client);
                    stage.show();
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
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("history.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    Scene scene = new Scene(root1);
                    scene.setFill(Color.TRANSPARENT);
                    stage.setScene(scene);
                    History controller = fxmlLoader.getController();
                    controller.initialize(ProductCart.this.client);
                    stage.show();
                }
                catch (Exception ee){
                    System.out.println(ee);
                }
            }
        };
        fullview.setOnAction(event);
        if (client.getLast_status().equals("C")){
            pane.setStyle(" -fx-border-color :#00D394;-fx-border-radius :6px;-fx-border-width:2px ;");
        }
        history_Btn.setOnAction(event1);
    }
    private void setIVicon(){
        if (client.getProdact_type().equals("مطب")){
            IVicon.setImage(new Image(getClass().getResourceAsStream("/icon/matab.png")));
        }
        else if (client.getProdact_type().equals("داروخانه")){
            IVicon.setImage(new Image(getClass().getResourceAsStream("/icon/drog.png")));
        }
        else if (client.getProdact_type().equals("تصویربرداری")){
            IVicon.setImage(new Image(getClass().getResourceAsStream("/icon/tasvir.png")));
        }
        else {
            IVicon.setImage(new Image(getClass().getResourceAsStream("/icon/lab.png")));
        }
    }
}
