/*
package srcmain;

import java.util.Objects;
import java.util.Random;
import javafx.scene.image.Image;
public class Core {
    String role = "player";
    int[][] card = new int[9][14];
    int[][] playerCard = new int[3][6];
    int[][] aiCard = new int[3][6];
    int point = 0;
    int suit = 0;
    int numbersai = 0;
    int numbersplayer = 0;
    String status = "playing";
    Random r = new Random();
    int ainum = 0;
    int playernum = 0;
    int wonTimes = 0;
    boolean aBoolean=false;
    boolean bBoolean=true;


    public void start() {
        aBoolean=false;
        bBoolean=true;
        status="playing";
        numbersplayer=0;
        numbersai=0;
        int count = 0;
        boolean a = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 14; j++) {
                if (card[i][j] == 0) {
                    count++;
                }
            }
        }
        if (count < 61) {
            a = true;
        } else {
            a = false;
        }
        if (a) {
            for (int i = 0; i < card.length; i++) {
                for (int j = 1; j < card[0].length; j++) {
                    card[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                playerCard[i][j]=0;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                aiCard[i][j]=0;
            }
        }

    }

    public int[][] startCard() {
        numbersplayer=0;
        numbersai=0;
        for (int i = 0; i < card.length; i++) {
            for (int j = 1; j < card[0].length; j++) {
                card[i][j] = 1;
            }
        }
        return card;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


   */
/* public Image getCardImage(String cardName) {
        Image cardImage = new Image("srcmain/pics/" + cardName + ".png");
        return cardImage;
    }*//*



    public boolean isPlaying() {
        //
        return false;
    }

    public void next() {
        //
        return;
    }

    public String[] cheatBlackjack() {
        if (Objects.equals(role, "player")) {
            for (int i = 1; i < card.length; i++) {
                for (int j = 10; j < 14; j++) {
                    if (card[i][j] == 1) {
                        playerCard[1][1] = j;
                        playerCard[2][1] = i;
                        playerCard[1][2] = 1;
                        playerCard[2][2] = 1;
                        card[i][j] = 0;
                    }
                }
            }
            String[] playersCard = new String[playerCard.length];
            for (int j = 1; j < playerCard.length-1; j++) {
                playersCard[j] = makeCard(playerCard[1][j], playerCard[2][j]);
                playersCard[j+1]  =makeCard(playerCard[1][j+1],playerCard[2][j+1]);
            }
            return playersCard;
        } else {
            for (int i = 1; i < card.length; i++) {
                for (int j = 10; j < 14; j++) {
                    if (card[i][j] == 1) {
                        aiCard[1][1] = j;
                        aiCard[2][1] = i;
                        aiCard[1][2] = 1;
                        aiCard[2][1] = 1;
                        card[i][j] = 0;
                    }
                }
            }
            String[] playersCard = new String[aiCard.length];
            for (int j = 1; j < aiCard.length; j++) {
                playersCard[j] = makeCard(aiCard[1][j], aiCard[2][j]);
            }
            return playersCard;
        }
    }

    public String[] cheatAce() {
        if (Objects.equals(role, "player")) {
            playerCard[1][1] = 1;
            playerCard[2][1] = 1;
            String[] playersCard = new String[playerCard.length];
            while (true) {
                point = r.nextInt(13) % (13) + 1;
                suit = r.nextInt(8) % (8) + 1;
                if (card[suit][point] != 0) {
                    playerCard[1][2] = point;
                    playerCard[2][2] = suit;
                    card[suit][point] = 0;
                    break;
                }
            }
            for (int j = 1; j < playerCard.length-1; j++) {
                playersCard[j] = makeCard(playerCard[1][j], playerCard[2][j]);
                playersCard[j+1]=makeCard(playerCard[1][j+1], playerCard[2][j+1]);
            }
            return playersCard;
        } else
            aiCard[1][1] = 1;
        aiCard[2][1] = 1;
        String[] playersCard = new String[aiCard.length];
        for (int j = 1; j < aiCard.length; j++) {
            playersCard[j] = makeCard(aiCard[1][j], aiCard[2][j]);
        }
        return playersCard;
    }
    public String[] getDealerCards () {
        numbersai++;
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                aiCard[1][2 + numbersai] = point;
                aiCard[2][2 + numbersai] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        String[] afaiCard = new String[1];
        afaiCard[0] = makeCard(aiCard[1][2 + numbersai], aiCard[2][2 + numbersai]);
        System.out.println("lll");
        System.out.println(aiCard[1][2 + numbersai]+"      "+aiCard[2][2 + numbersai]);

        return afaiCard;
    }
    public String[] getPlayerCards () {
        System.out.println("kkkk");
        numbersplayer++;
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                playerCard[1][2 + numbersplayer] = point;
                playerCard[2][2 + numbersplayer] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        String[] afplayersCard = new String[1];
        System.out.println("kkkk");
        afplayersCard[0] = makeCard(playerCard[1][2 + numbersplayer], playerCard[2][2 + numbersplayer]);
        System.out.println(playerCard[1][2 + numbersplayer]+"      "+playerCard[2][2 + numbersplayer]);
        return afplayersCard;
    }

    public void setAllow(boolean setallow){
        this.aBoolean=setallow;
    }
    public void setBAllow(boolean ss){
        this.bBoolean=ss;
    }


    public String getStatus() {
        System.out.println("getstatus called");
        int ainum = 0;
        int playernum = 0;
        boolean aix;
        boolean playerx;
        int aisum = 0;
        int playersum=0;

        boolean haveAce = false;
        for (int i = 1; i < aiCard[0].length; i++) {
            if (aiCard[1][i] == 1) {
                haveAce = true;
                break;
            }
        }

        int aiSum = 0;
        if (haveAce) {
            for (int i = 0; i < aiCard[0].length; i++) {
                if (aiCard[1][i] > 10) {
                    aiSum += 10;
                } else {
                    aiSum += aiCard[1][i];
                }
            }
            if (aiSum + 10 > 21) {
                ainum = aiSum;
            } else {
                ainum = aiSum + 10;
            }
        } else { // no ace
            for (int i = 0; i < aiCard[0].length; i++) {
                if (aiCard[1][i] > 10) {
                    aiSum += 10;
                } else {
                    aiSum += aiCard[1][i];
                }
            }
            ainum = aiSum;
        }

        boolean haveaAce = false;
        for (int i = 1; i < playerCard[0].length; i++) {
            if (playerCard[1][i] == 1) {
                haveaAce = true;
                break;
            }
        }
        int playerSum = 0;
        if (haveaAce) {
            for (int i = 0; i < playerCard[0].length; i++) {
                if (playerCard[1][i] > 10) {
                    playerSum += 10;
                } else {
                    playerSum += playerCard[1][i];
                }
            }
            if (playerSum + 10 > 21) {
                playernum = playerSum;
            } else {
                playernum = playerSum + 10;
            }
        } else {
            for (int i = 1; i < playerCard[0].length; i++) {
                if (playerCard[1][i] > 10) {
                    playerSum += 10;
                } else {
                    playerSum += playerCard[1][i];
                }
            }
        }
            playernum =playerSum;



            for (int i = 1; i < aiCard[0].length; i++) {
                if (aiCard[1][i] > 10) {
                    aisum += 10;
                } else {
                    aisum += aiCard[1][i];
                }
            }
            if (aisum > 21) {
                aix = true;
            } else {
                aix = false;
            }
            aisum=0;

            for (int i = 1; i < playerCard[0].length; i++) {
                if (playerCard[1][i] > 10)
                    playersum += 10;
                else
                    playersum += playerCard[1][i];
            }
            if (playersum > 21) {
                playerx = true;
            } else {
                playerx = false;
            }
            playersum=0;

            // didn't consider the condition of no ace!
            int aisSum = 0;
            int inter = 0;
            boolean hasAce = false;
            for (int i = 0; i < aiCard[0].length; i++) {
                if (aiCard[1][i] == 1){
                    hasAce = true;
                    break;
                }

            }
            if (hasAce){
                for (int i = 0; i < aiCard[0].length; i++) {
                    if (aiCard[1][i] > 10) {
                        inter += 10;
                        System.out.println(inter+"a");
                    } else {
                        inter += aiCard[1][i];
                        System.out.println(inter+"b");
                    }
                    System.out.println(aiCard[1][i]);
                }
                if (inter + 10 > 21) {
                    aisSum = inter;
                } else {
                    aisSum = inter + 10;
                }
            }
            else {
                for (int i = 0; i < aiCard[0].length; i++) {
                    if (aiCard[1][i] > 10) {
                        inter += 10;
                        System.out.println(inter+"a");
                    } else {
                        inter += aiCard[1][i];
                        System.out.println(inter+"b");
                    }
                    System.out.println(aiCard[1][i]);
                }
                aisSum=inter;
            }
            System.out.println(aisSum+"shduhd");

           inter = 0;
           int playersSum = 0;
           hasAce = false;
           for (int i = 0; i < playerCard[0].length; i++) {
               if (playerCard[1][i] == 1){
                   hasAce = true;
                   break;
               }
           }
           if (hasAce){
               for (int i = 0; i < playerCard[0].length; i++) {
                   System.out.println("nnn");
                   if (playerCard[1][i] > 10) {
                       inter += 10;
                       System.out.println(inter+"c");
                   } else {
                       System.out.println(inter+"d");
                       inter += playerCard[1][i];
                   }
                   System.out.println(playerCard[1][i]);
               }
               if (inter + 10 > 21) {
                   playersSum = inter;
               } else {
                   playersSum = inter + 10;
               }
           }
           else {
               for (int i = 0; i < playerCard[0].length; i++) {
                   System.out.println("nnn");
                   if (playerCard[1][i] > 10) {
                       inter += 10;
                       System.out.println(inter+"c");
                   } else {
                       System.out.println(inter+"d");
                       inter += playerCard[1][i];
                   }
                   playersSum=inter;
                   System.out.println(playerCard[1][i]);
               }

           }
            System.out.println(playersSum);




            int sum = 0;
            int aceNumber = 0;
            boolean bai = false;
            for (int i = 1; i < aiCard[0].length; i++) {
                if (aiCard[1][i] == 1)
                    aceNumber++;
            }
            if (aceNumber == 0) {
                for (int i = 1; i < aiCard[0].length; i++) {
                    if (aiCard[1][i] > 10){
                        sum += 10;
                    }
                    else {
                        sum += aiCard[1][i];
                    }
                }
                if (sum == 21)
                    bai = true;
            } else {
                for (int i = 1; i < aiCard[0].length; i++) {
                    if (aiCard[1][i] > 10){
                        sum += 10;
                    }
                    else {
                    sum += aiCard[1][i];
                    }
                    if (sum == 21)
                        bai = true;
                    else if (sum + 10 == 21)
                        bai = true;
                    else
                        bai = false;
                }
            }
            sum = 0;
            aceNumber=0;
            boolean bp = false;
            for (int i = 1; i < playerCard[0].length; i++) {
                if (playerCard[1][i] == 1)
                    aceNumber++;
            }
            if (aceNumber == 0) {
                for (int i = 1; i < playerCard[0].length; i++) {
                    if (playerCard[1][i] > 10){
                        sum += 10;
                    }
                    else {
                    sum += playerCard[1][i];
                    }
                }
                if (sum == 21)
                    bp = false;
            } else {
                for (int i = 1; i < playerCard[0].length; i++) {
                    if (playerCard[1][i] > 10){
                        sum += 10;
                    }
                    else {
                    sum += playerCard[1][i];
                    }
                    if (sum == 21)
                        bp = true;
                    else if (sum + 10 == 21)
                        bp = true;
                    else
                        bp = false;
                }
            }
if (bBoolean) {
    if (bai) {
        status = "dealerBlackjack";
        return status;
    }
    if (bp) {
        status = "playerBlackjack";
        return status;
    }
}
        if (playerx){
            status="playerBust";
            return status;
        }
        if (aBoolean) {
            if (aix) {
                status = "dealerBust";
                return status;
            }
            boolean okma = false;
            if (ainum > playernum) {
                okma = true;
                if (playersSum > aisSum) {

                    status = "playerWon";
                }

                if (aisSum > playersSum) {

                    status = "dealerWon";
                }
                if (playersSum == aisSum) {
                    status = "push";
                }
                return status;

            }
             else {
                return status = "playing";
            }
        }


         ainum = 0;
         playernum = 0;
         aisum = 0;
         playersum=0;
        haveAce = false;
        haveaAce=false;
        sum = 0;
        aceNumber=0;
        aiSum = 0;
        playersSum = 0;
        inter = 0;
        aisSum=0;
        playersSum=0;


//            if (role == "player") {
//                if (bai) {
//                    status = "dealerBlackjack";
//                }
//                if (bp) {
//                    status = "playerBlackjack";
//                }
//            if (playerx) {
//                status = "playerBust";
//            }
//            if (aix) {
//                status = "dealerBust";
//            }
            */
/* else {
                if (bai) {
                    status = "playerBlackjack";
                }
                if (bp) {
                    status = "dealerBlackjack";
                }*//*

//                if (playerx) {
//                    status = "dealerBust";
//                }
//                if (aix) {
//                    status = "playerBust";
//                }

//            if (role == "player") {
//                if (aiSum > playerSum) {
//                    ainum++;
//                    playernum--;
//                    status = "dealerWon";
//                }
//                if (playerSum > aiSum) {
//                    playernum++;
//                    ainum--;
//                    status = "playerWon";
//                }
//                if (playerSum == aiSum) {
//                    status = "push";
//                }
//                return status;
//            } else if (aiSum > playerSum) {
//                ainum++;
//                playernum--;
//                status = "playerWon";
//            }
//            if (playerSum > aiSum) {
//                playernum++;
//                ainum--;
//                status = "dealerWon";
//            }
//            if (playerSum == aiSum) {
//                status = "push";
//            }

        return status;
    }


    public String[] getDealerDealtCards () {
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                aiCard[1][1] = point;//这张牌是翻面的
                aiCard[2][1] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                aiCard[1][2] = point;
                aiCard[2][2] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        String[] DealtCard = new String[aiCard.length];
        for (int j = 1; j < aiCard.length; j++) {
            DealtCard[j] = makeCard(aiCard[1][j], aiCard[2][j]);
        }
        return DealtCard;

    }

//    public String[] getDealerCards () {
//        numbersai++;
//        while (true) {
//            point = r.nextInt(13) % (13) + 1;
//            suit = r.nextInt(8) % (8) + 1;
//            if (card[suit][point] != 0) {
//                aiCard[1][2 + numbersai] = point;
//                aiCard[2][2 + numbersai] = suit;
//                card[suit][point] = 0;
//                break;
//            }
//        }
//        String[] afaiCard = new String[1];
//        afaiCard[0] = makeCard(aiCard[1][2 + numbersai], aiCard[2][2 + numbersai]);
//        return afaiCard;
//    }

    public String[] getPlayerDealtCards () {
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                playerCard[1][1] = point;//这张牌是翻面的
                playerCard[2][1] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                playerCard[1][2] = point;
                playerCard[2][2] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        String[] playersCard = new String[3];
        for (int j = 1; j < 3; j++) {
            playersCard[j] = makeCard(playerCard[1][j], playerCard[2][j]);
        }
        return playersCard;
    }

    public int getWonTimes () {
        if (Objects.equals(role, "dealer")) {
            wonTimes = ainum;
        }
        if (Objects.equals(role, "player")) {
            wonTimes = playernum;
        }
        return wonTimes;
    }

//    public String[] getPlayerCards () {
//        numbersplayer++;
//        while (true) {
//            point = r.nextInt(13) % (13) + 1;
//            suit = r.nextInt(8) % (8) + 1;
//            if (card[suit][point] != 0) {
//                playerCard[1][2 + numbersplayer] = point;
//                playerCard[2][2 + numbersplayer] = suit;
//                card[suit][point] = 0;
//                String[] afplayersCard = new String[1];
//                afplayersCard[0] = makeCard(playerCard[1][2 + numbersplayer], playerCard[2][2 + numbersplayer]);
//                return afplayersCard;
//            }
//        }
//    }
    public static String makeCard ( int a, int b){
        String x = "o";
        String y = "i";
        if (a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 7 || a == 8 || a == 9 || a == 10) {
            x = String.valueOf(a);
        }
        if (a == 1) {
            x = "A";
        }
        if (a == 11) {
            x = "J";
        }
        if (a == 12) {
            x = "Q";
        }
        if (a == 13) {
            x = "K";
        }
        if (b == 1 || b == 5) {
            y = "H";
        }
        if (b == 2 || b == 6) {
            y = "D";
        }
        if (b == 3 || b == 7) {
            y = "S";
        }
        if (b == 4 || b == 8) {
            y = "C";
        }
        return x + y;
    }
}


*/

package srcmain;

import java.util.Objects;
import java.util.Random;
import javafx.scene.image.Image;
public class Core {
    String role = "player";
    int[][] card = new int[9][14];
    int[][] playerCard = new int[3][6];
    int[][] aiCard = new int[3][6];
    int point = 0;
    int suit = 0;
    int numbersai = 0;
    int numbersplayer = 0;
    String status = "playing";
    Random r = new Random();
    int ainum = 0;
    int playernum = 0;
    int wonTimes = 0;
    boolean aBoolean=false;
    boolean bBoolean=true;
    boolean okma=false;


    public void start() {
        aBoolean=false;
        bBoolean=true;
        status="playing";
        numbersplayer=0;
        numbersai=0;
        okma=false;
        int count = 0;
        boolean a = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 14; j++) {
                if (card[i][j] == 0) {
                    count++;
                }
            }
        }
        if (count < 61) {
            a = true;
        } else {
            a = false;
        }
        if (a) {
            for (int i = 0; i < card.length; i++) {
                for (int j = 1; j < card[0].length; j++) {
                    card[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                playerCard[i][j]=0;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                aiCard[i][j]=0;
            }
        }

    }

    public int[][] startCard() {
        numbersplayer=0;
        numbersai=0;
        for (int i = 0; i < card.length; i++) {
            for (int j = 1; j < card[0].length; j++) {
                card[i][j] = 1;
            }
        }
        return card;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


   /* public Image getCardImage(String cardName) {
        Image cardImage = new Image("srcmain/pics/" + cardName + ".png");
        return cardImage;
    }*/


    public boolean isPlaying() {
        //
        return false;
    }

    public void next() {
        //
        return;
    }

    public String[] cheatBlackjack() {
        if (Objects.equals(role, "player")) {
            for (int i = 1; i < card.length; i++) {
                for (int j = 10; j < 14; j++) {
                    if (card[i][j] == 1) {
                        playerCard[1][1] = j;
                        playerCard[2][1] = i;
                        playerCard[1][2] = 1;
                        playerCard[2][2] = 1;
                        card[i][j] = 0;
                    }
                }
            }
            String[] playersCard = new String[playerCard.length];
            for (int j = 1; j < playerCard.length-1; j++) {
                playersCard[j] = makeCard(playerCard[1][j], playerCard[2][j]);
                playersCard[j+1]  =makeCard(playerCard[1][j+1],playerCard[2][j+1]);
            }
            return playersCard;
        } else {
            for (int i = 1; i < card.length; i++) {
                for (int j = 10; j < 14; j++) {
                    if (card[i][j] == 1) {
                        aiCard[1][1] = j;
                        aiCard[2][1] = i;
                        aiCard[1][2] = 1;
                        aiCard[2][1] = 1;
                        card[i][j] = 0;
                    }
                }
            }
            String[] playersCard = new String[aiCard.length];
            for (int j = 1; j < aiCard.length; j++) {
                playersCard[j] = makeCard(aiCard[1][j], aiCard[2][j]);
            }
            return playersCard;
        }
    }

    public String[] cheatAce() {
        if (Objects.equals(role, "player")) {
            playerCard[1][1] = 1;
            playerCard[2][1] = 1;
            String[] playersCard = new String[playerCard.length];
            while (true) {
                point = r.nextInt(13) % (13) + 1;
                suit = r.nextInt(8) % (8) + 1;
                if (card[suit][point] != 0) {
                    playerCard[1][2] = point;
                    playerCard[2][2] = suit;
                    card[suit][point] = 0;
                    break;
                }
            }
            for (int j = 1; j < playerCard.length-1; j++) {
                playersCard[j] = makeCard(playerCard[1][j], playerCard[2][j]);
                playersCard[j+1]=makeCard(playerCard[1][j+1], playerCard[2][j+1]);
            }
            return playersCard;
        } else
            aiCard[1][1] = 1;
        aiCard[2][1] = 1;
        String[] playersCard = new String[aiCard.length];
        for (int j = 1; j < aiCard.length; j++) {
            playersCard[j] = makeCard(aiCard[1][j], aiCard[2][j]);
        }
        return playersCard;
    }
    public String[] getDealerCards () {
        numbersai++;
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                aiCard[1][2 + numbersai] = point;
                aiCard[2][2 + numbersai] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        String[] afaiCard = new String[1];
        afaiCard[0] = makeCard(aiCard[1][2 + numbersai], aiCard[2][2 + numbersai]);
        System.out.println("lll");
        System.out.println(aiCard[1][2 + numbersai]+"      "+aiCard[2][2 + numbersai]);

        return afaiCard;
    }
    public String[] getPlayerCards () {
        System.out.println("kkkk");
        numbersplayer++;
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                playerCard[1][2 + numbersplayer] = point;
                playerCard[2][2 + numbersplayer] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        String[] afplayersCard = new String[1];
        System.out.println("kkkk");
        afplayersCard[0] = makeCard(playerCard[1][2 + numbersplayer], playerCard[2][2 + numbersplayer]);
        System.out.println(playerCard[1][2 + numbersplayer]+"      "+playerCard[2][2 + numbersplayer]);
        return afplayersCard;
    }

    public void setAllow(boolean setallow){
        this.aBoolean=setallow;
    }
    public void setBAllow(boolean ss){
        this.bBoolean=ss;
    }


    public String getStatus() {
        System.out.println("getstatus called");
        int ainum = 0;
        int playernum = 0;
        boolean aix;
        boolean playerx;
        int aisum = 0;
        int playersum=0;

        boolean haveAce = false;
        for (int i = 1; i < aiCard[0].length; i++) {
            if (aiCard[1][i] == 1) {
                haveAce = true;
                break;
            }
        }

        int aiSum = 0;
        if (haveAce) {
            for (int i = 0; i < aiCard[0].length; i++) {
                if (aiCard[1][i] > 10) {
                    aiSum += 10;
                } else {
                    aiSum += aiCard[1][i];
                }
            }
            if (aiSum + 10 > 21) {
                ainum = aiSum;
            } else {
                ainum = aiSum + 10;
            }
        } else { // no ace
            for (int i = 0; i < aiCard[0].length; i++) {
                if (aiCard[1][i] > 10) {
                    aiSum += 10;
                } else {
                    aiSum += aiCard[1][i];
                }
            }
            ainum = aiSum;
        }

        boolean haveaAce = false;
        for (int i = 1; i < playerCard[0].length; i++) {
            if (playerCard[1][i] == 1) {
                haveaAce = true;
                break;
            }
        }
        int playerSum = 0;
        if (haveaAce) {
            for (int i = 0; i < playerCard[0].length; i++) {
                if (playerCard[1][i] > 10) {
                    playerSum += 10;
                } else {
                    playerSum += playerCard[1][i];
                }
            }
            if (playerSum + 10 > 21) {
                playernum = playerSum;
            } else {
                playernum = playerSum + 10;
            }
        } else {
            for (int i = 1; i < playerCard[0].length; i++) {
                if (playerCard[1][i] > 10) {
                    playerSum += 10;
                } else {
                    playerSum += playerCard[1][i];
                }
            }
        }
        playernum =playerSum;


        for (int i = 1; i < aiCard[0].length; i++) {
            if (aiCard[1][i] > 10) {
                aisum += 10;
            } else {
                aisum += aiCard[1][i];
            }
        }
        if (aisum > 21) {
            aix = true;
        } else {
            aix = false;
        }
        aisum=0;

        for (int i = 1; i < playerCard[0].length; i++) {
            if (playerCard[1][i] > 10)
                playersum += 10;
            else
                playersum += playerCard[1][i];
        }
        if (playersum > 21) {
            playerx = true;
        } else {
            playerx = false;
        }
        playersum=0;

        // didn't consider the condition of no ace!
        int aisSum = 0;
        int inter = 0;
        boolean hasAce = false;
        for (int i = 0; i < aiCard[0].length; i++) {
            if (aiCard[1][i] == 1){
                hasAce = true;
                break;
            }

        }
        if (hasAce){
            for (int i = 0; i < aiCard[0].length; i++) {
                if (aiCard[1][i] > 10) {
                    inter += 10;
                    System.out.println(inter+"a");
                } else {
                    inter += aiCard[1][i];
                    System.out.println(inter+"b");
                }
                System.out.println(aiCard[1][i]);
            }
            if (inter + 10 > 21) {
                aisSum = inter;
            } else {
                aisSum = inter + 10;
            }
        }
        else {
            for (int i = 0; i < aiCard[0].length; i++) {
                if (aiCard[1][i] > 10) {
                    inter += 10;
                    System.out.println(inter+"a");
                } else {
                    inter += aiCard[1][i];
                    System.out.println(inter+"b");
                }
                System.out.println(aiCard[1][i]);
            }
            aisSum=inter;
        }
        System.out.println(aisSum+"shduhd");

        inter = 0;
        int playersSum = 0;
        hasAce = false;
        for (int i = 0; i < playerCard[0].length; i++) {
            if (playerCard[1][i] == 1){
                hasAce = true;
                break;
            }
        }
        if (hasAce){
            for (int i = 0; i < playerCard[0].length; i++) {
                System.out.println("nnn");
                if (playerCard[1][i] > 10) {
                    inter += 10;
                    System.out.println(inter+"c");
                } else {
                    System.out.println(inter+"d");
                    inter += playerCard[1][i];
                }
                System.out.println(playerCard[1][i]);
            }
            if (inter + 10 > 21) {
                playersSum = inter;
            } else {
                playersSum = inter + 10;
            }
        }
        else {
            for (int i = 0; i < playerCard[0].length; i++) {
                System.out.println("nnn");
                if (playerCard[1][i] > 10) {
                    inter += 10;
                    System.out.println(inter+"c");
                } else {
                    System.out.println(inter+"d");
                    inter += playerCard[1][i];
                }
                playersSum=inter;
                System.out.println(playerCard[1][i]);
            }

        }
        System.out.println(playersSum);




        int sum = 0;
        int aceNumber = 0;
        boolean bai = false;
        for (int i = 1; i < aiCard[0].length; i++) {
            if (aiCard[1][i] == 1)
                aceNumber++;
        }
        if (aceNumber == 0) {
            for (int i = 1; i < aiCard[0].length; i++) {
                if (aiCard[1][i] > 10){
                    sum += 10;
                }
                else {
                    sum += aiCard[1][i];
                }
            }
            if (sum == 21)
                bai = true;
        } else {
            for (int i = 1; i < aiCard[0].length; i++) {
                if (aiCard[1][i] > 10){
                    sum += 10;
                }
                else {
                    sum += aiCard[1][i];
                }
                if (sum == 21)
                    bai = true;
                else if (sum + 10 == 21)
                    bai = true;
                else
                    bai = false;
            }
        }
        sum = 0;
        aceNumber=0;
        boolean bp = false;
        for (int i = 1; i < playerCard[0].length; i++) {
            if (playerCard[1][i] == 1)
                aceNumber++;
        }
        if (aceNumber == 0) {
            for (int i = 1; i < playerCard[0].length; i++) {
                if (playerCard[1][i] > 10){
                    sum += 10;
                }
                else {
                    sum += playerCard[1][i];
                }
            }
            if (sum == 21)
                bp = false;
        } else {
            for (int i = 1; i < playerCard[0].length; i++) {
                if (playerCard[1][i] > 10){
                    sum += 10;
                }
                else {
                    sum += playerCard[1][i];
                }
                if (sum == 21)
                    bp = true;
                else if (sum + 10 == 21)
                    bp = true;
                else
                    bp = false;
            }
        }
        if (role.equals( "player")) {
            if (bBoolean) {

                if (bai) {
                    status = "dealerBlackjack";
                    return status;
                }
                if (bp) {
                    status = "playerBlackjack";
                    return status;
                }

            }
            if (playerx) {
                status = "playerBust";
                return status;
            }
            if (aBoolean) {
                if (aix) {
                    status = "dealerBust";
                    return status;
                }
                boolean okma = false;
                if (ainum > playernum) {
                    okma = true;
                    if (playersSum > aisSum) {

                        status = "playerWon";
                    }

                    if (aisSum > playersSum) {

                        status = "dealerWon";
                    }
                    if (playersSum == aisSum) {
                        status = "push";
                    }
                    return status;

                } else {
                    return status = "playing";
                }
            }
        }if (role.equals("dealer")) {
            if (!bBoolean) {

                if (bai) {
                    status = "playerBlackjack";
                    return status;
                }
                if (bp) {
                    status = "dealerBlackjack";
                    return status;
                }

            }
            if (playerx) {
                status = "playerBust";
                return status;
            }
            if (!aBoolean) {
                if (aix) {
                    status = "dealerBust";
                    return status;
                }
                 okma = false;
                if (ainum <playernum) {
                    okma = true;
                    if (playersSum > aisSum) {

                        status = "playerWon";
                    }

                    if (aisSum > playersSum) {

                        status = "dealerWon";
                    }
                    if (playersSum == aisSum) {
                        status = "push";
                    }
                    return status;
                } else {
                    return status = "playing";
                }
            }
        }


        ainum = 0;
        playernum = 0;
        aisum = 0;
        playersum=0;
        haveAce = false;
        haveaAce=false;
        sum = 0;
        aceNumber=0;
        aiSum = 0;
        playersSum = 0;
        inter = 0;
        aisSum=0;
        playersSum=0;


        return status;
    }
    public boolean getokma(){
        return okma;
    }


    public String[] getDealerDealtCards () {
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                aiCard[1][1] = point;//这张牌是翻面的
                aiCard[2][1] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                aiCard[1][2] = point;
                aiCard[2][2] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        String[] DealtCard = new String[aiCard.length];
        for (int j = 1; j < aiCard.length; j++) {
            DealtCard[j] = makeCard(aiCard[1][j], aiCard[2][j]);
        }
        return DealtCard;

    }

//    public String[] getDealerCards () {
//        numbersai++;
//        while (true) {
//            point = r.nextInt(13) % (13) + 1;
//            suit = r.nextInt(8) % (8) + 1;
//            if (card[suit][point] != 0) {
//                aiCard[1][2 + numbersai] = point;
//                aiCard[2][2 + numbersai] = suit;
//                card[suit][point] = 0;
//                break;
//            }
//        }
//        String[] afaiCard = new String[1];
//        afaiCard[0] = makeCard(aiCard[1][2 + numbersai], aiCard[2][2 + numbersai]);
//        return afaiCard;
//    }

    public String[] getPlayerDealtCards () {
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                playerCard[1][1] = point;//这张牌是翻面的
                playerCard[2][1] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        while (true) {
            point = r.nextInt(13) % (13) + 1;
            suit = r.nextInt(8) % (8) + 1;
            if (card[suit][point] != 0) {
                playerCard[1][2] = point;
                playerCard[2][2] = suit;
                card[suit][point] = 0;
                break;
            }
        }
        String[] playersCard = new String[3];
        for (int j = 1; j < 3; j++) {
            playersCard[j] = makeCard(playerCard[1][j], playerCard[2][j]);
        }
        return playersCard;
    }

    public int getWonTimes () {
        if (Objects.equals(role, "dealer")) {
            wonTimes = ainum;
        }
        if (Objects.equals(role, "player")) {
            wonTimes = playernum;
        }
        return wonTimes;
    }

    //    public String[] getPlayerCards () {
//        numbersplayer++;
//        while (true) {
//            point = r.nextInt(13) % (13) + 1;
//            suit = r.nextInt(8) % (8) + 1;
//            if (card[suit][point] != 0) {
//                playerCard[1][2 + numbersplayer] = point;
//                playerCard[2][2 + numbersplayer] = suit;
//                card[suit][point] = 0;
//                String[] afplayersCard = new String[1];
//                afplayersCard[0] = makeCard(playerCard[1][2 + numbersplayer], playerCard[2][2 + numbersplayer]);
//                return afplayersCard;
//            }
//        }
//    }
    public static String makeCard ( int a, int b){
        String x = "o";
        String y = "i";
        if (a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 7 || a == 8 || a == 9 || a == 10) {
            x = String.valueOf(a);
        }
        if (a == 1) {
            x = "A";
        }
        if (a == 11) {
            x = "J";
        }
        if (a == 12) {
            x = "Q";
        }
        if (a == 13) {
            x = "K";
        }
        if (b == 1 || b == 5) {
            y = "H";
        }
        if (b == 2 || b == 6) {
            y = "D";
        }
        if (b == 3 || b == 7) {
            y = "S";
        }
        if (b == 4 || b == 8) {
            y = "C";
        }
        return x + y;
    }
}



