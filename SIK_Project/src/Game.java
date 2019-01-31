import java.util.concurrent.ThreadLocalRandom;

public class Game {
    public static void main(String[] args) {
        int checkFields = 0;
        int[][] Map = new int[5][5];
        int random = ThreadLocalRandom.current().nextInt(0, 5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Map[i][j] = 0;
            }
        }

        for (int k = 1; k <= 5; k++) {
            for (int j = 0; j < 2; j++) {
                if(Map[random][random] == 0){
                    Map[random][random] = k;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(Map[i][j]);
            }
        }
    }

}
