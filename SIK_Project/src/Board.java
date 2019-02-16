import java.util.concurrent.ThreadLocalRandom;


public class Board {
    public int[][] playerId = new int[5][5];
    public int[][] cubes = new int[5][5];
    private int random=ThreadLocalRandom.current().nextInt(0, 5);
    private int random2=ThreadLocalRandom.current().nextInt(0, 5);
    private int randomCubes = ThreadLocalRandom.current().nextInt(1, 6);
    private int check = 0;
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
                cubes[i][j] = playerId[i][j];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(cubes[i][j] != 0){
                    cubes[i][j] = 2;
                }
            }
        }
        for(int k = 0 ; k < 5; k++){
            while(cubes[random][random2]!=0){
                random = ThreadLocalRandom.current().nextInt(0, 5);
                random2 = ThreadLocalRandom.current().nextInt(0, 5);
            }
            cubes[random][random2] = randomCubes;
            randomCubes = ThreadLocalRandom.current().nextInt(1, 6);
        }
    }
}
