package srcmain;

public class Person {
    private int id;
    private String username;
    private String password;
    private int money;

    Person() {
        this.id = 1;
        this.username = "default username";
        this.password = "1";
        this.money = 1000;
    }
    Person(int id, String username, String password, int money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public void setId(int id) {
        //
        this.id = id;
    }
    public int getId() {
        //
        return this.id;
    }

    public void setUsername(String username) {
        //
        this.username = username;
    }
    public String getUsername() {
        //
        return this.username;
    }

    public void setPassword(String password) {
        //
        this.password= password;
    }
    public String getPassword() {
        //
        return this.password;
    }

    public void setMoney(int money) {
        //
        this.money = money;
    }
    public int getMoney() {
        //
        return money;
    }
}