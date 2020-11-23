package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
    private int ID;
    private String Province;
    private String Company;
    private String Product_Name;
    private String Prodact_type;
    private String Manager;
    private String Phone_number;
    private String Last_status;
    private String Tester;
    private String gmail;
    private String Requst_date;
    private String Requst_number;
    private String Leter_Number;
    private String Physicians;
    private String Drog;
    private String Imaging;
    private String Lab;
    private String Insurance;
    private String First_Test;

    public Client(int ID, String province, String company, String product_Name, String prodact_type, String manager, String phone_number, String last_status, String tester, String gmail, String requst_date, String requst_number, String leter_Number, String physicians, String drog, String imaging, String lab, String insurance, String first_Test) {
        this.ID = ID;
        Province = province;
        Company = company;
        Product_Name = product_Name;
        Prodact_type = prodact_type;
        Manager = manager;
        Phone_number = phone_number;
        Last_status = last_status;
        Tester = tester;
        this.gmail = gmail;
        Requst_date = requst_date;
        Requst_number = requst_number;
        Leter_Number = leter_Number;
        Physicians = physicians;
        Drog = drog;
        Imaging = imaging;
        Lab = lab;
        Insurance = insurance;
        First_Test = first_Test;
    }

    public int getID() {
        return ID;
    }

    public String getProvince() {
        return Province;
    }

    public String getCompany() {
        return Company;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public String getProdact_type() {
        return Prodact_type;
    }

    public String getManager() {
        return Manager;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public String getLast_status() {
        return Last_status;
    }

    public String getTester() {
        return Tester;
    }

    public String getGmail() {
        return gmail;
    }

    public String getRequst_date() {
        return Requst_date;
    }

    public String getRequst_number() {
        return Requst_number;
    }

    public String getLeter_Number() {
        return Leter_Number;
    }

    public String getPhysicians() {
        return Physicians;
    }

    public String getDrog() {
        return Drog;
    }

    public String getImaging() {
        return Imaging;
    }

    public String getLab() {
        return Lab;
    }

    public String getInsurance() {
        return Insurance;
    }

    public String getFirst_Test() {
        return First_Test;
    }
}

