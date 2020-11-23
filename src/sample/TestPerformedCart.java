package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPerformedCart extends AnchorPane {
    private Client client;
    @FXML
    HBox testpart_Hbox;
    @FXML
    ScrollPane testcart_srollpane;
    TestPerformed testPerformed ;
    public TestPerformedCart() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("testPerformedCart.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        fxmlLoader.load();
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void setTestPerformed (TestPerformed testPerformed){
        this.testPerformed = testPerformed;
    }
    public void initialize(Client c , TestPerformed t) throws IOException, SQLException {
        setClient(c);
        setTestPerformed(t);
//        System.out.println(t.getClass());
        if (client.getProdact_type().equals("مطب")) {
            int count = 0;
            if (client.getFirst_Test() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("تست اولیه");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getPhysicians() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("پزشکان");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getDrog() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("دارو");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getImaging() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("تصویربرداری");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getInsurance() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("بیمه گری");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getLab() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("آزمایش");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (count==6){
                Statement statement =Database.clientData();
                statement.execute("UPDATE myguests SET Last_status = 'C' WHERE ID='"+client.getID()+"'");
            }
        }
        if (client.getProdact_type().equals("داروخانه")){
            int count = 0 ;
            if (client.getFirst_Test() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("تست اولیه");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getInsurance() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("بیمه گری");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getDrog() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("دارو");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (count==3){
                Statement statement =Database.clientData();
                statement.execute("UPDATE myguests SET Last_status = 'C' WHERE ID='"+client.getID()+"'");
            }
        }
        if (client.getProdact_type().equals("تصویربرداری")) {
            int count = 0 ;
            if (client.getFirst_Test() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("تست اولیه");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getInsurance() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("بیمه گری");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getImaging() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("تصویربرداری");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (count==3){
                Statement statement =Database.clientData();
                statement.execute("UPDATE myguests SET Last_status = 'C' WHERE ID='"+client.getID()+"'");
            }
        }
        if(client.getProdact_type().equals("آزمایشگاه")) {
            int count =0;
            if (client.getFirst_Test() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("تست اولیه");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getInsurance() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("بیمه گری");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (client.getLab() != null) {
                TestPerformedPart testPart = new TestPerformedPart();
                testPart.setClient(client);
                testPart.setTestPerformed(testPerformed);
                testPart.initialize("آزمایش");
                testpart_Hbox.getChildren().add(testPart);
                count++;
            }
            if (count==3){
                Statement statement =Database.clientData();
                statement.execute("UPDATE myguests SET Last_status = 'C' WHERE ID='"+client.getID()+"'");
            }
        }
        testpart_Hbox.setSpacing(10);
        testcart_srollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        testcart_srollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }
}
