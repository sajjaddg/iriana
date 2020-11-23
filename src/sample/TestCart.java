package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TestCart extends AnchorPane {
    private Client client;
    @FXML
    HBox testpart_Hbox;
    @FXML
    ScrollPane testcart_srollpane;
    public TestCart() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("testCart.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        fxmlLoader.load();
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public void initialize(Client c , Test t) throws IOException {
        setClient(c);
        if (client.getProdact_type().equals("مطب")) {
            if (client.getFirst_Test() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.initialize("تست اولیه");
                testPart.setTilePane(t);
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getPhysicians() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("پزشکان");
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getDrog() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("دارو");
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getImaging() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("تصویربرداری");
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getInsurance() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("بیمه گری");
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getLab() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("آزمایش");
                testpart_Hbox.getChildren().add(testPart);
            }
        }
        if (client.getProdact_type().equals("داروخانه")){
            if (client.getFirst_Test() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("تست اولیه");
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getInsurance() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("بیمه گری");
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getDrog() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("دارو");
                testpart_Hbox.getChildren().add(testPart);
            }
        }
        if (client.getProdact_type().equals("تصویربرداری")) {
            if (client.getFirst_Test() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("تست اولیه");
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getInsurance() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("بیمه گری");
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getImaging() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("تصویربرداری");
                testpart_Hbox.getChildren().add(testPart);
            }
        }
        if(client.getProdact_type().equals("آزمایشگاه")) {
            if (client.getFirst_Test() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("تست اولیه");
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getInsurance() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("بیمه گری");
                testpart_Hbox.getChildren().add(testPart);
            }
            if (client.getLab() == null) {
                TestPart testPart = new TestPart();
                testPart.setClient(client);
                testPart.setTilePane(t);
                testPart.initialize("آزمایش");
                testpart_Hbox.getChildren().add(testPart);
            }
        }
        testpart_Hbox.setSpacing(10);
        testcart_srollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        testcart_srollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }
}
