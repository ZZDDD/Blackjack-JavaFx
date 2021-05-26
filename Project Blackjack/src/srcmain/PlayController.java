package srcmain;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.util.Duration;


public class PlayController implements Initializable {
    public String cheating = "no";
    public Boolean isFirstRound = true;
    public String[] dealerHandStrings = new String[8];
    int dealerHandStringsNum = 0;
    ////////////////////////////////////////////////////////////////////////////// INITIALIZE
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(nextRoundButton);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(2);
        scaleTransition.setDuration(Duration.seconds(1));
        scaleTransition.setByX(1.6);
        scaleTransition.setByY(1.6);
        scaleTransition.play();
    }
//    player player = new player();
    Core core = new Core();
    Accounts accounts = new Accounts();

    @FXML public HBox dealerHand;
    @FXML public HBox playerHand;
    @FXML public Label roleLabel;
    @FXML public Label statusLabel;
    @FXML public Label dealerPointsLabel;
    @FXML public Label playerPointsLabel;
    public void initCore(Core core) {
        this.core = core;
        if (this.core.getRole().equals("dealer")) {
            roleLabel.setText("dealer");
        } else {
            roleLabel.setText("player");
        }

        statusLabel.setText("");
        dealerPointsLabel.setText("");
        playerPointsLabel.setText("");

        core.start();
        core.startCard();

        /*String[] dealerDealtCards = core.getDealerDealtCards();
        dealerHitAnimation();
        ImageView cardImage = new ImageView();
        cardImage.setImage(getCardImage(dealerDealtCards[1]));
        dealerHand.getChildren().addAll(cardImage);
        dealerHitAnimation();
        ImageView cardImage1 = new ImageView();
        if (this.core.getRole().equals("dealer")) {
            cardImage1.setImage(getCardImage(dealerDealtCards[2]));
            dealerHand.getChildren().addAll(cardImage1);
        } else {
            cardImage1.setImage(pile.getImage());
            dealerHand.getChildren().addAll(cardImage1);
        }


        String[] playerDealtCards = core.getPlayerDealtCards();
        playerHitAnimation();
        ImageView cardImage2 = new ImageView();
        cardImage2.setImage(getCardImage(playerDealtCards[1]));
        playerHand.getChildren().addAll(cardImage2);
        playerHitAnimation();
        ImageView cardImage3 = new ImageView();
        cardImage3.setImage(getCardImage(playerDealtCards[2]));
        playerHand.getChildren().addAll(cardImage3);

        if (!core.getStatus().equals("playing")) {
            checkStausAndEndIfPossible();
        }

        if (core.getRole().equals("dealer")) {
            standCommand("dealer", "GUI: ");
        }

        if (!core.getStatus().equals("playing")) {
            checkStausAndEndIfPossible();
        }*/
    }
    public void initAccounts(Accounts accounts) {
        this.accounts = accounts;
        //
    }

    ////////////////////////////////////////////////////////////////////////////////// GUI CONTROLS

    @FXML ImageView iconback;
    public void goBackReady(MouseEvent mouseEventGoBackReady) throws IOException {
        if (core.getStatus().equals("playing")) {
            Alert alert = new Alert(Alert.AlertType.WARNING,"Game is still playing");
            alert.setTitle("Warning");
            alert.setHeaderText("You cannot leave");
            alert.showAndWait();
            return;
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ready.fxml"));
        Parent readyParent = loader.load();

        ReadyController readyController = loader.getController();
        readyController.initAccounts(accounts);

        Scene readyScene = new Scene(readyParent);
        Stage window = (Stage)((Node)mouseEventGoBackReady.getSource()).getScene().getWindow();
        window.setScene(readyScene);
        window.show();
        // System.out.println("You are home now!");
    }

    public Image getCardImage(String cardName) {
        System.out.println(cardName);
        Image cardImage = new Image("srcmain/pics/" + cardName + ".png");
        return cardImage;
    }

    @FXML public ImageView pile;
    public void hit(MouseEvent mouseEvent) {
        hitCommand(core.getRole(), "GUI: ");
    }
    public void hitCommand(String role, String source) {
        if (core.getRole().equals("dealer")) {
            dealerHitAnimation();
            String dealerCards[] = core.getDealerCards();
            for (int i = 0; i < dealerCards.length; i++) {
                ImageView cardImageHit = new ImageView();
                cardImageHit.setImage(getCardImage(dealerCards[i]));
                dealerHand.getChildren().addAll(cardImageHit);
            }
            checkStausAndEndIfPossible();
        } else {
            playerHitAnimation();
            String playerCards[] = core.getPlayerCards();
            for (int i = 0; i < playerCards.length; i++) {
                ImageView cardImageHit = new ImageView();
                cardImageHit.setImage(getCardImage(playerCards[i]));
                playerHand.getChildren().addAll(cardImageHit);
            }
            checkStausAndEndIfPossible();
        }

        commandMessage.setText(source + "You Hit");
    }
//    @FXML public ImageView backAnimationImageView;
    @FXML public StackPane pileParentStackPane;
    @FXML public StackPane animationStackPane;
    public void dealerHitAnimation() {
/*        TranslateTransition initTrans = new TranslateTransition();
        initTrans.setDuration(Duration.seconds(0.5));
        initTrans.setNode(backAnimationImageView);
        initTrans.setByX(-600);
        initTrans.setByY(-200);
        initTrans.play();
        initTrans.setOnFinished(event -> {
            backAnimationImageView.setVisible(false);
        });*/
        ImageView image = new ImageView();
        image.setImage(pile.getImage());
        animationStackPane.getChildren().addAll(image); // make image pos. on stackpane
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.2));
        trans.setNode(image);
        trans.setToX(-600);
        trans.setToY(-200);
        trans.play();
        trans.setOnFinished(event -> {
            animationStackPane.getChildren().clear();
        });
    }
    public void playerHitAnimation() {
/*        backAnimationImageView.setVisible(true);
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.5));
        trans.setNode(backAnimationImageView);
        trans.setFromX(trans.getFromX());
        trans.setFromZ(trans.getFromY());
        trans.setToX(-600);
        trans.setToY(210);
//        trans.setAutoReverse(true);
//        trans.setCycleCount(2);

        trans.play();
        trans.setOnFinished(event -> {
            backAnimationImageView.setVisible(false);
            *//*TranslateTransition transInvisible = new TranslateTransition();
            transInvisible.setDuration(Duration.ZERO);
            transInvisible.setNode(backAnimationImageView);
            transInvisible.setToX(600);
            transInvisible.setToY(-210);
            transInvisible.play();*//*
        });*/
        ImageView image = new ImageView();
        image.setImage(pile.getImage());
        animationStackPane.getChildren().addAll(image); // make image pos. on stackpane
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(0.2));
        trans.setNode(image);
        trans.setToX(-600);
        trans.setToY(210);
        trans.play();
        trans.setOnFinished(event -> {
            animationStackPane.getChildren().clear();
        });
    }

    @FXML public ImageView standButton;
    public void stand(MouseEvent mouseEvent) {
        standCommand(core.getRole(), "GUI: ");
    }
    public void standCommand(String commandRole, String source) {
        commandMessage.setText(source + "You Standed");
        if (core.getRole().equals("dealer")) {
            checkStausAndEndIfPossible();
        } else { // player
            core.setAllow(true);
            checkStausAndEndIfPossible();
            while (core.getStatus().equals("playing")) {
                dealerHitAnimation();
                String dealerCards[] = core.getDealerCards();
                dealerHandStrings[dealerHandStringsNum] = dealerCards[0]; // add to dealerHandStrings
                dealerHandStringsNum++;
                for (int i = 0; i < dealerCards.length; i++) {
                    ImageView cardImageHit = new ImageView();
                    cardImageHit.setImage(getCardImage(dealerCards[i]));
                    dealerHand.getChildren().addAll(cardImageHit);
                }
                checkStausAndEndIfPossible();
            }
        }
    }

    public void checkStausAndEndIfPossible() {
        switch(core.getStatus()) {
            case "playing":
                break;
            case "dealerBlackjack" :
                removeDealerHandAndAddAllCards();
                if (core.getRole().equals("dealer")) {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() + accounts.getCurrentUserBet());
                } else {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() - accounts.getCurrentUserBet());
                }
                alertInfo("dealerBlackjack");
                resetGame();
                break;
            case "dealerWon" :
                removeDealerHandAndAddAllCards();
                if (core.getRole().equals("dealer")) {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() + accounts.getCurrentUserBet());
                } else {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() - accounts.getCurrentUserBet());
                }
                alertInfo("dealerWon");
                resetGame();
                break;
            case "dealerBust" :
                removeDealerHandAndAddAllCards();
                if (core.getRole().equals("dealer")) {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() - accounts.getCurrentUserBet());
                } else {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() + accounts.getCurrentUserBet());
                }
                alertInfo("dealerBust");
                resetGame();
                break;
            case "playerBlackjack" :
                removeDealerHandAndAddAllCards();
                if (core.getRole().equals("dealer")) {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() - accounts.getCurrentUserBet());
                } else {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() + accounts.getCurrentUserBet());
                }
                alertInfo("playerBlackjack");
                resetGame();
                break;
            case "playerWon":
                removeDealerHandAndAddAllCards();
                if (core.getRole().equals("dealer")) {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() - accounts.getCurrentUserBet());
                } else {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() + accounts.getCurrentUserBet());
                }
                alertInfo("playerWon");
                resetGame();
                break;
            case "playerBust":
                removeDealerHandAndAddAllCards();
                if (core.getRole().equals("dealer")) {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() + accounts.getCurrentUserBet());
                } else {
                    accounts.setCurrentUserMoney(accounts.getCurrentUserMoney() - accounts.getCurrentUserBet());
                }
                alertInfo("playerBust");
                resetGame();
                break;
            case "push":
                removeDealerHandAndAddAllCards();
                alertInfo("push");
                resetGame();
                break;
            default:
                break;
        }
    }
    public void removeDealerHandAndAddAllCards() {
        dealerHand.getChildren().clear();
        for (int i = 0; i < dealerHandStringsNum; i++) {
            ImageView image = new ImageView();
            image.setImage(getCardImage(dealerHandStrings[i]));
            dealerHand.getChildren().addAll(image);
        }
        for (int i = 0; i < dealerHandStrings.length; i++) { // clear hand string
            dealerHandStrings[i] = "";
        }
        dealerHandStringsNum = 0;
    }

    public void resetGame() {
        dealerHand.getChildren().clear();
        playerHand.getChildren().clear();
        statusLabel.setText("");
        commandMessage.setText("");
    }
    @FXML Button nextRoundButton;
    public void nextRoundButtonClicked(ActionEvent event) {
        resetGame();
        dealerHand.getChildren().clear();
        for (int i = 0; i < dealerHandStrings.length; i++) { // clear hand string
            dealerHandStrings[i] = "";
        }
        dealerHandStringsNum = 0;


        core.start();
        if (isFirstRound) {
            core.startCard();
        }
        isFirstRound = false;

        if (cheating.equals("blackjack")) {
            if (core.getRole().equals("dealer")) {
                String[] dealerDealtCards = core.cheatBlackjack();
                dealerHitAnimation();
                ImageView cardImage = new ImageView();
                cardImage.setImage(getCardImage(dealerDealtCards[1]));
                dealerHand.getChildren().addAll(cardImage);
                dealerHitAnimation();
                ImageView cardImage1 = new ImageView();
                if (this.core.getRole().equals("dealer")) {
                    cardImage1.setImage(getCardImage(dealerDealtCards[2]));
                    dealerHand.getChildren().addAll(cardImage1);
                } else {
                    cardImage1.setImage(pile.getImage());
                    dealerHand.getChildren().addAll(cardImage1);
                }

                String[] playerDealtCards = core.getPlayerDealtCards();
                playerHitAnimation();
                ImageView cardImage2 = new ImageView();
                cardImage2.setImage(getCardImage(playerDealtCards[1]));
                playerHand.getChildren().addAll(cardImage2);
                playerHitAnimation();
                ImageView cardImage3 = new ImageView();
                cardImage3.setImage(getCardImage(playerDealtCards[2]));
                playerHand.getChildren().addAll(cardImage3);
            } else { // player
                String[] dealerDealtCards = core.getDealerDealtCards();
                dealerHandStrings[dealerHandStringsNum] = dealerDealtCards[1]; // add to dealerHandStrings
                dealerHandStringsNum++;
                dealerHandStrings[dealerHandStringsNum] = dealerDealtCards[2];
                dealerHandStringsNum++;
                dealerHitAnimation();
                ImageView cardImage = new ImageView();
                cardImage.setImage(getCardImage(dealerDealtCards[1]));
                dealerHand.getChildren().addAll(cardImage);
                dealerHitAnimation();
                ImageView cardImage1 = new ImageView();
                if (this.core.getRole().equals("dealer")) {
                    cardImage1.setImage(getCardImage(dealerDealtCards[2]));
                    dealerHand.getChildren().addAll(cardImage1);
                } else {
                    cardImage1.setImage(pile.getImage());
                    dealerHand.getChildren().addAll(cardImage1);
                }

                String[] playerDealtCards = core.cheatBlackjack();
                playerHitAnimation();
                ImageView cardImage2 = new ImageView();
                cardImage2.setImage(getCardImage(playerDealtCards[1]));
                playerHand.getChildren().addAll(cardImage2);
                playerHitAnimation();
                ImageView cardImage3 = new ImageView();
                cardImage3.setImage(getCardImage(playerDealtCards[2]));
                playerHand.getChildren().addAll(cardImage3);
            }

        } else if (cheating.equals("ace")) {
            if (core.getRole().equals("dealer")) {
                String[] dealerDealtCards = core.cheatAce();
                dealerHitAnimation();
                ImageView cardImage = new ImageView();
                cardImage.setImage(getCardImage(dealerDealtCards[1]));
                dealerHand.getChildren().addAll(cardImage);
                dealerHitAnimation();
                ImageView cardImage1 = new ImageView();
                if (this.core.getRole().equals("dealer")) {
                    cardImage1.setImage(getCardImage(dealerDealtCards[2]));
                    dealerHand.getChildren().addAll(cardImage1);
                } else {
                    cardImage1.setImage(pile.getImage());
                    dealerHand.getChildren().addAll(cardImage1);
                }

                String[] playerDealtCards = core.getPlayerDealtCards();
                playerHitAnimation();
                ImageView cardImage2 = new ImageView();
                cardImage2.setImage(getCardImage(playerDealtCards[1]));
                playerHand.getChildren().addAll(cardImage2);
                playerHitAnimation();
                ImageView cardImage3 = new ImageView();
                cardImage3.setImage(getCardImage(playerDealtCards[2]));
                playerHand.getChildren().addAll(cardImage3);
            } else { // player
                String[] dealerDealtCards = core.getDealerDealtCards();
                dealerHandStrings[dealerHandStringsNum] = dealerDealtCards[1]; // add to dealerHandStrings
                dealerHandStringsNum++;
                dealerHandStrings[dealerHandStringsNum] = dealerDealtCards[2];
                dealerHandStringsNum++;
                dealerHitAnimation();
                ImageView cardImage = new ImageView();
                cardImage.setImage(getCardImage(dealerDealtCards[1]));
                dealerHand.getChildren().addAll(cardImage);
                dealerHitAnimation();
                ImageView cardImage1 = new ImageView();
                if (this.core.getRole().equals("dealer")) {
                    cardImage1.setImage(getCardImage(dealerDealtCards[2]));
                    dealerHand.getChildren().addAll(cardImage1);
                } else {
                    cardImage1.setImage(pile.getImage());
                    dealerHand.getChildren().addAll(cardImage1);
                }

                String[] playerDealtCards = core.cheatAce();
                playerHitAnimation();
                ImageView cardImage2 = new ImageView();
                cardImage2.setImage(getCardImage(playerDealtCards[1]));
                playerHand.getChildren().addAll(cardImage2);
                playerHitAnimation();
                ImageView cardImage3 = new ImageView();
                cardImage3.setImage(getCardImage(playerDealtCards[2]));
                playerHand.getChildren().addAll(cardImage3);
            }
        } else { // no cheating
//            System.out.println("load image");
            String[] dealerDealtCards = core.getDealerDealtCards();
            dealerHandStrings[dealerHandStringsNum] = dealerDealtCards[1]; // add to dealerHandStrings
            dealerHandStringsNum++;
            dealerHandStrings[dealerHandStringsNum] = dealerDealtCards[2];
            dealerHandStringsNum++;
            dealerHitAnimation();
            ImageView cardImage = new ImageView();
            cardImage.setImage(getCardImage(dealerDealtCards[1]));

            dealerHand.getChildren().addAll(cardImage);
            dealerHitAnimation();
            ImageView cardImage1 = new ImageView();
            if (this.core.getRole().equals("dealer")) {
                cardImage1.setImage(getCardImage(dealerDealtCards[2]));
                dealerHand.getChildren().addAll(cardImage1);
            } else {
                cardImage1.setImage(getCardImage(dealerDealtCards[2])); // for test
                cardImage1.setImage(pile.getImage()); // back
                dealerHand.getChildren().addAll(cardImage1);
            }

            String[] playerDealtCards = core.getPlayerDealtCards();
            playerHitAnimation();
            ImageView cardImage2 = new ImageView();
            cardImage2.setImage(getCardImage(playerDealtCards[1]));
            playerHand.getChildren().addAll(cardImage2);
            playerHitAnimation();
            ImageView cardImage3 = new ImageView();
            cardImage3.setImage(getCardImage(playerDealtCards[2]));
            playerHand.getChildren().addAll(cardImage3);
//            System.out.println("load image");


            // if we are dealer, player hit
            if (core.getRole().equals("dealer")) {
                checkStausAndEndIfPossible();
                while (core.getStatus().equals("playing")) {
                    playerHitAnimation();
                    String playerCards[] = core.getPlayerCards();
                    for (int i = 0; i < playerCards.length; i++) {
                        ImageView cardImageHit = new ImageView();
                        cardImageHit.setImage(getCardImage(playerCards[i]));
                        playerHand.getChildren().addAll(cardImageHit);
                    }
                    if (core.getokma()){
                        core.setBAllow(false);
                        return;
                    }
                }
            }
        }

        if (core.getokma()) { // duplicate for safety
            core.setBAllow(false);
            return;
        } else {
            System.out.println(cheating);
            cheating = "no";

            checkStausAndEndIfPossible();
            core.setBAllow(false);
        }
        /*if (!core.getStatus().equals("playing")) {
            checkStausAndEndIfPossible();
        }*/

        /*if (core.getRole().equals("dealer")) {
            standCommand("dealer", "GUI: ");
        }

        if (!core.getStatus().equals("playing")) {
            checkStausAndEndIfPossible();
        }*/
    }

    public void alertInfo(String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, info);
        alert.setTitle("Game");
        alert.setHeaderText(info);
        alert.showAndWait();
    }
    //////////////////////////////////////////////////////////////////////////////////////// COMMANDS:
    @FXML public TextField commandPalette;
    @FXML public Button commandButton;
    @FXML public Label commandMessage;
    public void commandButtonClicked(ActionEvent eventCommandButtonClicked) {
        String commandString = commandPalette.getText();
        switch(commandString) {
            case "":
                break;
            case "dealer hit" :
                hitCommand("dealer","Command: ");
                break;
            case "dealer stand" :
                standCommand("dealer","Command: ");
                break;
            case "player hit" :
                hitCommand("player","Command: ");
                break;
            case "player stand" :
                standCommand("player","Command: ");
                break;
            case "blackjack":
                cheating = "blackjack";
                commandMessage.setText("You will get blackjack next round");
                break;
            case "ace":
                cheating = "ace";
                commandMessage.setText("You will get ace next round");
                break;
            default:
                commandMessage.setText("Unknown Command");
        }
        commandPalette.clear();
    }
}