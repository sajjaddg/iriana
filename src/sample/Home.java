package sample;

import com.mysql.cj.xdevapi.JsonArray;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    public TilePane homeTilePane;
    @FXML
    public ScrollPane scrollpane;
    @FXML
    public Label dataLbl;
    @FXML
    public Label roozLbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            String sql = "SELECT * from myguests WHERE Tester= '"+Controller.user.getUserName()+"'";
            if (Controller.user.getUserName().equals("admin")){
                sql = "SELECT * from myguests";
            }
            Statement statement = Database.clientData();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Client client = new Client(resultSet.getInt("ID"),resultSet.getString("Province"),resultSet.getString("Company"),resultSet.getString("Product_Name"),
                                    resultSet.getString("Prodact_type"),resultSet.getString("Manager"),resultSet.getString("Phone_number"),resultSet.getString("Last_status"),
                                    resultSet.getString("Tester"),resultSet.getString("gmail"),resultSet.getString("Requst_date"),
                                    resultSet.getString("Requst_number"),resultSet.getString("Leter_Number"),resultSet.getString("Physicians"),resultSet.getString("Drog"),resultSet.getString("Imaging"),resultSet.getString("Lab"),resultSet.getString("Insurance"),resultSet.getString("First_Test"));
                ProductCart productCart = new ProductCart();
                productCart.initialize(client);
                homeTilePane.getChildren().add(productCart);
            }

            homeTilePane.setHgap(10);
            homeTilePane.setVgap(10);
            homeTilePane.setMaxWidth(Region.USE_PREF_SIZE);
            scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            dataLbl.setText(shamsi.getCurrentShamsidate());
            roozLbl.setText(shamsi.rooz());
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
}
