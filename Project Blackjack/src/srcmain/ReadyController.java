package srcmain;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReadyController implements Initializable {
    Accounts accounts = new Accounts();
    Core core = new Core();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup roleToggleGroup = new ToggleGroup();
        roleToggleGroup.getToggles().addAll(dealerRadioButton, playerRadioButton);

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(startButton);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(999999999);
        scaleTransition.setDuration(Duration.seconds(1));
        scaleTransition.setByX(1.5);
        scaleTransition.setByY(1.5);
        scaleTransition.play();
    }

    @FXML public Label usernameLabel;
    @FXML public Label moneyLabel;
    public void initAccounts(Accounts accounts) {
        accounts.setPersonMoneyBasedOnCurrentUser();
        this.accounts = accounts;
        usernameLabel.setText(this.accounts.getCurrentUsername());
        moneyLabel.setText(String.valueOf(this.accounts.getCurrentUserMoney()));
    }

    @FXML RadioButton dealerRadioButton;
    @FXML RadioButton playerRadioButton;
    @FXML RadioButton easyRadioButton;
    @FXML RadioButton hardRadioButton;
    @FXML TextField betTextField;
    @FXML ImageView startButton;
    public void playerButtonSelected(ActionEvent eventPlayerButtonSelected) {
        //
        core.setRole("player");
    }
    public void dealerButtonSelected(ActionEvent event) {
        //
        core.setRole("dealer");
    }
    public void easyButtonSelected(ActionEvent event) {
    }

    public void hardButtonSelected(ActionEvent event) {
    }
    public void goPlay(MouseEvent mouseEventGoPlay) throws IOException {
        this.accounts.setCurrentUserBet(Integer.valueOf(betTextField.getText()));

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("play.fxml"));
        Parent playParent = loader.load();

        PlayController playController = loader.getController();
        playController.initCore(this.core);
        playController.initAccounts(this.accounts);

        Scene playScene = new Scene(playParent);
        Stage window = (Stage)((Node)mouseEventGoPlay.getSource()).getScene().getWindow();
        window.setScene(playScene);
        window.show();
    }

    @FXML ImageView iconback;
    public void goBackHome(MouseEvent mouseEventGoBackHome) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));

        Scene homeScene = new Scene(homeParent);
        Stage window = (Stage)((Node)mouseEventGoBackHome.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
        // System.out.println("You are home now!");
    }



        /*
        @FXML ImageView rankButton;
        public void rankButtonClicked(MouseEvent eventRankButtonClicked) throws IOException {
        Parent rankParent = FXMLLoader.load(getClass().getResource("rank.fxml"));
        Scene rankScene = new Scene(rankParent);

        Stage window = (Stage)((Node)eventRankButtonClicked.getSource()).getScene().getWindow();
        window.setScene(rankScene);
        window.show();
        }*/


}
