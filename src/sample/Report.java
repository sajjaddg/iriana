package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

public class Report {
    @FXML
    TextArea report;
    public void exitClicked(){
        Stage stage = (Stage) report.getScene().getWindow();
        stage.close();
    }
    public void finalBtnClicked() throws SQLException {
        try {
            Statement statement = Database.clientData();
            statement.execute("INSERT INTO dailyreport(Tester_ID,Date,Report) VALUES ('"+Controller.user.getId()+"','"+shamsi.getCurrentShamsidate()+"','"+report.getText()+"')");
        }
        catch (Exception e){
        }
        report.clear();
       exitClicked();
    }
}
