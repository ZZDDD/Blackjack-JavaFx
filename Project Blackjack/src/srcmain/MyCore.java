package srcmain;

import java.util.Random;
import javafx.scene.image.Image;

public class MyCore {
    private String role = "player";


    public void setRole(String role) {
        if (role.equals("dealer")) {
            this.role = "dealer";
        } else if (role.equals("dealer")) {
            this.role = "player";
        } else {
            this.role = "player";
        }


    }

    public String getRole() {
        return role;
    }

    public String randomCard() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        int pointNumber = r.nextInt(13) + 1;
        if (pointNumber == 1) {
            sb.append("A");
        } else if (pointNumber == 11) {
            sb.append("J");
        } else if (pointNumber == 12) {
            sb.append("Q");
        } else if (pointNumber == 13) {
            sb.append("K");
        } else {
            sb.append(String.valueOf(pointNumber));
        }

        int suitNumber = r.nextInt(3);
        switch(suitNumber){
            case 0 :
                sb.append(String.valueOf("C"));
                break;
            case 1 :
                sb.append(String.valueOf("D"));
                break;
            case 2:
                sb.append(String.valueOf("H"));
                break;
            case 3:
                sb.append(String.valueOf("S"));
                break;
        }
        return sb.toString();
    }

 public Image getCardImage(String cardName) {
        Image cardImage = new Image("srcmain/pics/" + cardName + ".png");
        return cardImage;
    }


    public void start() {
        //
        //
    }


    public boolean isPlaying() {
        //
        return false;
    }

    public void next() {
        //
        return;
    }

    public String playerHit() {
        //
        return this.randomCard();
    }

    public String dealerHit() {
        //
        return this.randomCard();
    }




    public String getStatus() {
        return "";
    }

    public String[] getDealerCards() {
        String cards[] = new String[1];
        cards[1] = this.randomCard();
        return cards;
    }

    public String[] getDealerDealtCards() {
        String cards[] = new String[2];
        cards[2] = this.randomCard();
        return cards;
    }

    public String[] getPlayerDealtCards() {
        String cards[] = new String[2];
        cards[2] = this.randomCard();
        return cards;
    }

    public int getWonTimes() {
        return 1;
    }

    public String[] getPlayerCards() {
        String cards[] = new String[2];
        cards[2] = this.randomCard();
        return cards;
    }
}
