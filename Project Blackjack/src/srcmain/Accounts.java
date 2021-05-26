package srcmain;
import java.io.*;
import java.util.Scanner;


public class Accounts extends Person {
    private String currentUsername;
    private int currentUserMoney = 1000;
    private int currentUserBet = 100;
    private Person[] people = new Person[100];
    private int peopleNumber = 0;

    Accounts() {
//        File file = new File("accounts.txt");
        try {
           /* Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                peopleNumber++;
                String[] token = line.split(" ");
                people[peopleNumber - 1] = new Person();
                people[peopleNumber - 1].setUsername(token[0]);
                people[peopleNumber - 1].setPassword(token[1]);
                people[peopleNumber - 1].setMoney(Integer.valueOf(token[2]));
            }*/
            Reader reader = new BufferedReader(new FileReader("accounts.txt"));
            String line;
            while ((line = ((BufferedReader) reader).readLine()) != null) {
                peopleNumber++;
                String[] token = line.split(" ");
                people[peopleNumber - 1] = new Person();
                people[peopleNumber - 1].setUsername(token[0]);
                people[peopleNumber - 1].setPassword(token[1]);
                people[peopleNumber - 1].setMoney(Integer.valueOf(token[2]));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.currentUsername = "default username";
        this.currentUserMoney = 1000;
    }
    public String getCurrentUsername() {
        //
        return this.currentUsername;
    }

    public int getCurrentUserMoney() {
        //
        return this.currentUserMoney;
    }
    public int getCurrentUserBet() {
        return this.currentUserBet;
    }

    public void setCurrentUsername(String username) {
        //
        this.currentUsername = username;
    }

    public void setCurrentUserMoney(int money) {
        //
        this.currentUserMoney = money;
    }

    public void setCurrentUserBet(Integer bet) {
        //
        this.currentUserBet = bet;
    }

    public boolean userExisted(String usernameInput) {
        //
        for (int i = 0; i < peopleNumber; i++) {
            if (people[i].getUsername().equals(usernameInput)) {
                return true;
            }
        }
        return false;
    }

    public int getMoney(String usernameInput) {
        for (int i = 0; i < peopleNumber; i++) {
            if (people[i].getUsername().equals(usernameInput)) {
                return people[i].getMoney();
            }
        }
        return 1000;
    }

    public String getPassword(String usernameInput) {
        //
        for (int i = 0; i < peopleNumber; i++) {
            if (people[i].getUsername().equals(usernameInput)) {
                return people[i].getPassword();
            }
        }
        return "1";
    }

    public void addUser(String usernameInput, String passwordInput) {
        try {
            PrintWriter output = new PrintWriter("accounts.txt");
            for (int i = 0; i < peopleNumber; i++) {
                output.println(people[i].getUsername() + " " + people[i].getPassword() + " " + people[i].getMoney());
            }

            peopleNumber++;
            people[peopleNumber - 1] = new Person();
            people[peopleNumber - 1].setUsername(usernameInput);
            people[peopleNumber - 1].setPassword(passwordInput);
            people[peopleNumber - 1].setMoney(1000);
            output.print(people[peopleNumber - 1].getUsername() + " " + people[peopleNumber - 1].getPassword() + " " + people[peopleNumber - 1].getMoney());
            output.close();
            /*Writer write = new BufferedWriter(new FileWriter("accounts.txt"));
            peopleNumber++;
            people[peopleNumber - 1] = new Person();
            people[peopleNumber - 1].setUsername(usernameInput);
            people[peopleNumber - 1].setPassword(passwordInput);
            people[peopleNumber - 1].setMoney(1000);
            for (int i = 0; i < peopleNumber; i++) {
                out
            }
            write.write();
            write.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public Person getPerson(int i) {
        return people[i];
    }

    public void setPersonMoneyBasedOnCurrentUser() {
        try {
            PrintWriter output = new PrintWriter("accounts.txt");
            for (int i = 0; i < peopleNumber; i++) {
                if (people[i].getUsername().equals(currentUsername)) {
                    output.println(people[i].getUsername() + " " + people[i].getPassword() + " " + currentUserMoney);
                } else {
                    output.println(people[i].getUsername() + " " + people[i].getPassword() + " " + people[i].getMoney());
                }
            }
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
