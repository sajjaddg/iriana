package sample;

public class User {
    private int id;
    private String userName;
    private String gmail;
    private String phoneNumber;
    private String internalNumber;
    private String name;

    public User(int id, String userName, String gmail, String phoneNumber, String internalNumber, String name) {
        this.id = id;
        this.userName = userName;
        this.gmail = gmail;
        this.phoneNumber = phoneNumber;
        this.internalNumber = internalNumber;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getGmail() {
        return gmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInternalNumber() {
        return internalNumber;
    }

    public String getName() {
        return name;
    }
}
