package srcmain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.nio.file.Paths;
import java.time.Duration;

public class Main extends Application {
    @Override
    public void init() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        playBgm();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent homeParent = loader.load();

        HomeController homeController = loader.getController();

//        Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("BlackJack by GamblingMaster");
        primaryStage.setScene(new Scene(homeParent, 1280, 720));
        primaryStage.show();

        /*AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            }
        };
        timer.start();*/
    }

    MediaPlayer mediaPlayer;
    public void playBgm() {
        String bgmLocation = "forDanceOnly.mp3";
        Media bgm = new Media(Paths.get(bgmLocation).toUri().toString());
//        Media bgm = new Media("forDanceOnly.mp3");
        mediaPlayer = new MediaPlayer(bgm);
        mediaPlayer.setCycleCount(99);
        mediaPlayer.play();
    }

    @Override public void stop() {
        //
        //
    }

    public static void main(String[] args) {
        launch(args);
        //
    }
}
