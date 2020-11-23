package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestPerformed implements Initializable {
    @FXML
    public TilePane TestTilePane;
    @FXML
    public ScrollPane scrollpane;
    @FXML
    public Label dataLbl;
    @FXML
    public Label roozLbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addgusts();
            TestTilePane.setHgap(10);
            TestTilePane.setVgap(10);
            TestTilePane.setMaxWidth(Region.USE_PREF_SIZE);
            scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            dataLbl.setText(shamsi.getCurrentShamsidate());
            roozLbl.setText(shamsi.rooz());
        } catch (SQLException | IOException e) {
            System.out.println(e);
        }
    }

    public void addgusts() throws SQLException, IOException {
        String sql = "SELECT * from myguests WHERE Tester= '" + Controller.user.getUserName() + "'";
        if (Controller.user.getUserName().equals("admin")) {
            sql = "SELECT * from myguests";
        }
        Statement statement = Database.clientData();
        ResultSet resultSet = statement.executeQuery(sql);
        TestTilePane.getChildren().clear();
        while (resultSet.next()) {
            Client client = new Client(resultSet.getInt("ID"), resultSet.getString("Province"), resultSet.getString("Company"), resultSet.getString("Product_Name"),
                    resultSet.getString("Prodact_type"), resultSet.getString("Manager"), resultSet.getString("Phone_number"), resultSet.getString("Last_status"),
                    resultSet.getString("Tester"), resultSet.getString("gmail"), resultSet.getString("Requst_date"),
                    resultSet.getString("Requst_number"), resultSet.getString("Leter_Number"), resultSet.getString("Physicians"), resultSet.getString("Drog"), resultSet.getString("Imaging"), resultSet.getString("Lab"), resultSet.getString("Insurance"), resultSet.getString("First_Test"));
            if (client.getImaging() != null || client.getPhysicians() != null || client.getLab() != null || client.getInsurance() != null || client.getFirst_Test() != null || client.getDrog() != null) {
                TestPerformedCart testPerformedCart = new TestPerformedCart();
                testPerformedCart.initialize(client,this);
                TestTilePane.getChildren().add(testPerformedCart);
            }
        }
    }
}
