package srcmain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RankController implements Initializable {
    private Accounts accounts;

    @FXML public TableView<Person> rankListTableView;
    @FXML public TableColumn<Person, Integer> rankColumn;
    @FXML public TableColumn<Person, String> usernameColumn;
    @FXML public TableColumn<Person, Integer>  moneyColumn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rankColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("username"));
        moneyColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("money"));

        rankListTableView.setItems(getPeople());
    }
    public ObservableList<Person> getPeople() {
        //
        ObservableList<Person> people = FXCollections.observableArrayList();
        accounts = new Accounts();
        for (int i = 0; i < accounts.getPeopleNumber(); i++) {
            Person person = accounts.getPerson(i);
            person.setId(i);
            people.add(person);
        }
        /*people.add(new Person(6, "hhhh", "1", 200));
        people.add(new Person(5, "asdf", "1", 300));
        people.add(new Person(4, "hjkl", "1", 700));*/
        return people;
    }

    @FXML ImageView iconback;
    public void goBackHome(MouseEvent mouseEventGoBackHome) throws IOException {
        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent homeParent = loader.load();

        Scene homeScene = new Scene(homeParent);
        Stage window = (Stage)((Node)mouseEventGoBackHome.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();*/
        Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage)((Node)mouseEventGoBackHome.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
        // System.out.println("You are home now!");
    }


}
