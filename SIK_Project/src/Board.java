import javax.print.attribute.standard.RequestingUserName;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.*;

public class Board {
    private int cube;
    private int[][] playerId = new int[5][5];
    private int random=ThreadLocalRandom.current().nextInt(0, 5);
    private int random2=ThreadLocalRandom.current().nextInt(0, 5);
    public Board() { }
    Player newPlayer = new Player();

    public void WriteTable() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                playerId[i][j] = 0;
            }
        }
        for (int k = 1; k <= 5; k++) {
            for (int j = 0; j < 2; j++) {
                if (playerId[random][random2] == 0) {
                    playerId[random][random2] = k;
                    random = ThreadLocalRandom.current().nextInt(0, 5);
                    random2 = ThreadLocalRandom.current().nextInt(0, 5);
                } else {
                    while (playerId[random][random2] != 0) {
                        random = ThreadLocalRandom.current().nextInt(0, 5);
                        random2 = ThreadLocalRandom.current().nextInt(0, 5);
                    }
                    playerId[random][random2] = k;
                    random = ThreadLocalRandom.current().nextInt(0, 5);
                    random2 = ThreadLocalRandom.current().nextInt(0, 5);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("PLANSZA " + (i + 1) + " " + (j + 1) + " " + playerId[i][j]);
            }
        }
    }
}
