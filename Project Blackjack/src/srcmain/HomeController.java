package srcmain;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // System.out.println("Initialized");
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(rankButton);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(999999999);
        scaleTransition.setDuration(Duration.seconds(1));
        scaleTransition.setByX(0.8);
        scaleTransition.setByY(0.8);
        scaleTransition.play();
    }

    Accounts accounts = new Accounts();
    /*
    public void initAccounts(Accounts accounts) {
        this.accounts = accounts;
        //
    }
    */

    @FXML ImageView rankButton;
    public void rankButtonClicked(MouseEvent eventRankButtonClicked) throws IOException {
        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("rank.fxml"));
        Parent rankParent = loader.load();

        ReadyController rankController = loader.getController();
        rankController.initCore(core);

        Scene rankScene = new Scene(rankParent);
        Stage window = (Stage)((Node)eventRankButtonClicked.getSource()).getScene().getWindow();
        window.setScene(rankScene);
        window.show();*/

        Parent rankParent = FXMLLoader.load(getClass().getResource("rank.fxml"));
        Scene rankScene = new Scene(rankParent);

        Stage window = (Stage)((Node)eventRankButtonClicked.getSource()).getScene().getWindow();
        window.setScene(rankScene);
        window.show();
    }

    /*@FXML RadioButton dealerButton;
    public void dealerButtonSelected(ActionEvent eventDealerButtonSelected) {
        core.setRole(true);
    }

    @FXML RadioButton playerButton;
    public void playerButtonSelected(ActionEvent eventPlayerButtonSelected) {
        core.setRole(false);
    }*/

    @FXML Button loginButton;
    @FXML public TextField username;
    @FXML public PasswordField password;
    @FXML public Label loginMessage;
    public void loginButtonClicked(ActionEvent eventLogin) throws IOException {
        String usernameInput = username.getText();
        String passwordInput = password.getText();
        if (accounts.userExisted(usernameInput)) { // user exist
            if (!passwordInput.equals(accounts.getPassword(usernameInput))) {
                loginMessage.setText("Wrong!");
                return;
            } else {
                accounts.setCurrentUsername(usernameInput);
                accounts.setCurrentUserMoney(accounts.getMoney(usernameInput));
            }
        } else { // user does not exist
            if (passwordInput  == "") {
                loginMessage.setText("empty!");
                return;
            } else { // add new user
                accounts.addUser(usernameInput, passwordInput);
                accounts.setCurrentUsername(usernameInput);
                accounts.setCurrentUserMoney(1000);
            }
        }

        // now to ready
        // Parent playParent = FXMLLoader.load(getClass().getResource("play.fxml"));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ready.fxml"));
        Parent readyParent = loader.load();
        
        ReadyController readyController = loader.getController();
        readyController.initAccounts(this.accounts);

        // change to play scene
        Scene readyScene = new Scene(readyParent);
        Stage window = (Stage)((Node)eventLogin.getSource()).getScene().getWindow();
        window.setScene(readyScene);
        window.show();
        // System.out.println("Logged In!");
    }


}
