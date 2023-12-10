import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";
    public static final String D = "D";
    public static final String E = "E";
    public static final String F = "F";
    public static final String G = "G";
    public static final String H = "H";
    public static final String W = "W";
    public static final String S = "S";

    public static final int REEL_STOPS = 33;

    /*
    low/medium volatility prizes
     */

    public static final int PRIZE_3 = 3;
    public static final int PRIZE_5 = 5;
    public static final int PRIZE_6 = 6;
    public static final int PRIZE_12 = 12;
    public static final int PRIZE_30 = 30;
    public static final int PRIZE_60 = 60;

    /*
    high volatility prizes
    */
    public static final int PRIZE_1 = 1;
    public static final int PRIZE_11 = 11;
    //    public static final int PRIZE_5 = 5;
//    public static final int PRIZE_12 = 12;
    public static final int PRIZE_20 = 20;
    public static final int PRIZE_250 = 250;
    public static final int PRIZE_400 = 400;
    public static final int PRIZE_425 = 425;

    public static final String[] c1 = {B,D,A,D,B,D,C,C,B,C,C,B,D,B,A,D,A,B,D,C,E,A,C,F,A,B,C,G,A,H,D,A,S,B,D};
    public static final String[] c2 = {C,W,A,W,W,A,B,W,B,W,C,C,D,W,D,D,E,W,A,B,W,E,F,W,F,G,W,G,H,W,H,W,S,C,W};
    public static final String[] c3 = {A,W,A,B,W,B,B,A,B,W,C,C,D,W,D,D,E,W,A,C,W,E,F,W,F,G,W,G,H,W,H,W,S,A,W};
    public static final String[] c4 = {B,W,B,A,W,C,B,B,C,W,C,D,D,W,A,A,E,W,A,D,W,D,F,W,G,C,W,H,B,W,A,W,S,B,W};
    public static final String[] c5 = {E,F,G,H,C,B,A,C,F,C,D,A,D,B,C,D,E,B,A,E,F,D,F,G,A,G,B,H,C,E,D,B,S,E,F};

    public static final String[][] cylinders = {c1, c2, c3, c4, c5};

    public static final int[][] regularWays = {
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 2},
            {2, 2, 2, 2, 1},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 0, 0},
            {1, 1, 1, 2, 2},
            {2, 2, 2, 1, 1},
            {0, 0, 1, 1, 1},
            {1, 1, 0, 0, 0},
            {1, 1, 2, 2, 2},
            {2, 2, 1, 1, 1},
            {0, 0, 1, 1, 2},
            {0, 0, 1, 2, 2},
            {1, 1, 0, 0, 1},
            {1, 1, 2, 2, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 2, 1, 1},
            {2, 2, 1, 2, 2},
            {2, 2, 1, 0, 0},
            {0, 1, 2, 1, 0},
            {2, 1, 0, 1, 2}};


    //public static final int[][] regularWays = {{1, 1, 1, 1, 1}};
    public static final int LINES = 25;
    public static int MAX_PRIZE = 0;

    public static HashMap<Integer, Integer> rtp = new HashMap<>();
    public static HashMap<String, ArrayList<Integer>> prize = new HashMap<>();


    public static HashMap<Integer, Integer> prizeFreq = new HashMap<>();

    public static boolean isSimulation = false;
    public static boolean qaPrint = false;

    public static int[] grid = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int[] MULTIPLIERS = {1, 2, 3, 4, 5, 10, 15, 20, 25, 35, 40, 45, 50, 60, 70, 80, 90, 100, 125, 150, 175, 200, 500, 1000};
    public static final int[][] BONUS_LOW_FREQ ={{5000,3000,2000,1000,500,250,175,125,90,65,40,35,20,16,16,16,8,8,4,4,2,2,2,1},
            {2000,1500,850,600,275,150,100,75,50,40,45,35,30,25,20,15,10,8,5,5,3,3,3,2},
            {1000,800,600,500,400,300,200,102,76,60,55,50,45,40,30,20,10,9,9,7,6,6,5,3}};
    public static final int[][] BONUS_HIGH_FREQ ={{3500,2500,1500,1000,1000,240,170,122,90,65,40,35,20,16,16,16,8,8,4,4,2,2,2,1},
            {1000,750,650,550,275,150,100,75,50,40,45,35,30,25,25,20,12,9,6,5,4,4,4,3},
            {900,800,600,500,400,300,200,100,90,75,60,55,50,45,30,25,15,10,10,8,7,7,6,4}};

    public static final String LOW = "low";
    public static final String HIGH = "high";

    public static int getBonusMultiplier(SecureRandom rand, String volatility, int scatSymbols){



        return 0;
    }
    public static void main(String[] args) {

        // setup variables
        /*
        medium/low volatility with max win 5000 x bet
         */

        ArrayList<Integer> pA = new ArrayList<>();
        pA.add(3);
        pA.add(6);
        pA.add(12);
        prize.put(A, pA);
        ArrayList<Integer> pB = new ArrayList<>();
        pB.add(3);
        pB.add(6);
        pB.add(12);
        prize.put(B, pB);
        ArrayList<Integer> pC = new ArrayList<>();
        pC.add(3);
        pC.add(6);
        pC.add(12);
        prize.put(C, pC);
        ArrayList<Integer> pD = new ArrayList<>();
        pD.add(3);
        pD.add(6);
        pD.add(12);
        prize.put(D, pD);
        ArrayList<Integer> pE = new ArrayList<>();
        pE.add(5);
        pE.add(11);
        pE.add(30);
        prize.put(E, pE);
        ArrayList<Integer> pF = new ArrayList<>();
        pF.add(5);
        pF.add(11);
        pF.add(30);
        prize.put(F, pF);
        ArrayList<Integer> pG = new ArrayList<>();
        pG.add(5);
        pG.add(11);
        pG.add(30);
        prize.put(G, pG);
        ArrayList<Integer> pH = new ArrayList<>();
        pH.add(5);
        pH.add(11);
        pH.add(60);
        prize.put(H, pH);
        ArrayList<Integer> pS = new ArrayList<>();
        pS.add(0);
        pS.add(0);
        pS.add(0);
        prize.put(S, pS);

        rtp.put(0, 0);
        rtp.put(PRIZE_1, 0);
        rtp.put(PRIZE_3, 0);
        rtp.put(PRIZE_5, 0);
        rtp.put(PRIZE_6, 0);
        rtp.put(PRIZE_11, 0);
        rtp.put(PRIZE_12, 0);
        rtp.put(PRIZE_20, 0);
        rtp.put(PRIZE_30, 0);
        rtp.put(PRIZE_60, 0);
        rtp.put(PRIZE_250, 0);
        rtp.put(PRIZE_400, 0);
        rtp.put(PRIZE_425, 0);


        SecureRandom rand = new SecureRandom();
        int[] rotateToPosition = {0, 0, 0, 0, 0};

        long wonScatter = 0;
        long totalWin = 0;
        double returnToPlayer;


        HashMap<Integer, Integer> prize25LineFreq = prizeFrequency();
        for (Map.Entry<Integer, Integer> entry : prize25LineFreq.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }
        System.out.println("================== prize Freq start ===================");
        for (Map.Entry<Integer, Integer> entry : prizeFreq.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }

        System.out.println("================== prize Freq end ===================");
        //-------------------------------------------------------------------------
        // game Simulation configs
        //-------------------------------------------------------------------------

        // set the number of spins
        Long numberOfGames = 10_000_000L;
        System.out.println("Initial (payed) spins " + numberOfGames);

        // if you want to print the table and some other info to test if is working
        qaPrint = false;


        // if you want a 243Ways paying game just turn next line to false
        boolean isRegularGame = true;

        // volatility high = true (if false then low volatitily game)
        boolean isVolatilityHighGame = false;

        // if you want a FreeSpins game mode turn next line to true
        boolean isFreeSpinsGame = false;

        long totalBets = isRegularGame ? numberOfGames * LINES : numberOfGames * 250;

        isSimulation = true;
        for (long i = 0L; i < numberOfGames; i++) {

            rotateToPosition = rotateCylinders(rotateToPosition, rand);
            if (qaPrint) {
                System.out.println("game: " + i);
                printCylinders(rotateToPosition);
            }

            String table[][] = generateGameArea(rotateToPosition);
            //printGameArea(table);
            int vs = verifyScatter(table);

            int maxSpins=0;
            int[] grid = scatterTable2Grid(table);
            for(int index=0; index<grid.length; index++){
                if(grid[index]==1){
                    maxSpins++;
                }
            }




            if (vs > 2) {
                int win = getScatterPrize(vs);
                totalWin += win;
                int value = rtp.get(win);
                rtp.put(win, value + 1);
                wonScatter++;

                if (isFreeSpinsGame) {
                    // free spins
                    numberOfGames += 3;
                }
            }
            if (isRegularGame) {
                if (qaPrint) {
                    printGameArea(table);
                }
                totalWin += getPrize4RegularWays(table);
            } else {
                if (qaPrint && hasWildSymbol(table)) {
                    printGameArea(table);
                    System.out.println("==changes=to==\n");
                }
                totalWin += getPrizeFor243Ways(table, rand);
            }
        }
        returnToPlayer = ((double) totalWin / (totalBets)) * 100.0;

        // results printing

        System.out.println("SCATTER PRIZEs won: " + wonScatter);
        System.out.println("=======================================\n");
        System.out.println("Prizes frequency: ");

        if (isVolatilityHighGame) {
            System.out.format("prize 1 -> %d  -> %4.6f \n", rtp.get(PRIZE_1), (double) 1 * rtp.get(PRIZE_1) / totalBets);
            System.out.format("prize 3 -> %d  -> %4.6f \n", rtp.get(PRIZE_3), (double) 2 * rtp.get(PRIZE_3) / totalBets);
            System.out.format("prize 5 -> %d  -> %4.6f \n", rtp.get(PRIZE_5), (double) 5 * rtp.get(PRIZE_5) / totalBets);
            System.out.format("prize 12 -> %d  -> %4.6f \n", rtp.get(PRIZE_12), (double) 12 * rtp.get(PRIZE_12) / totalBets);
            System.out.format("prize 20 -> %d  -> %4.6f \n", rtp.get(PRIZE_20), (double) 20 * rtp.get(PRIZE_20) / totalBets);
            System.out.format("prize 250 -> %d  -> %4.6f \n", rtp.get(PRIZE_250), (double) 250 * rtp.get(PRIZE_250) / totalBets);
            System.out.format("prize 400 -> %d  -> %4.6f \n", rtp.get(PRIZE_400), (double) 400 * rtp.get(PRIZE_400) / totalBets);
            System.out.format("prize 425 -> %d  -> %4.6f \n", rtp.get(PRIZE_425), (double) 425 * rtp.get(PRIZE_425) / totalBets);

        } else {
            System.out.format("prize 1 -> %d  -> %4.6f \n", rtp.get(PRIZE_1), (double) 1 * rtp.get(PRIZE_1) / totalBets);

            System.out.format("prize 3 -> %d  -> %4.6f \n", rtp.get(PRIZE_3), (double) 3 * rtp.get(PRIZE_3) / totalBets);
            System.out.format("prize 5 -> %d  -> %4.6f \n", rtp.get(PRIZE_5), (double) 5 * rtp.get(PRIZE_5) / totalBets);
            System.out.format("prize 6 -> %d  -> %4.6f \n", rtp.get(PRIZE_6), (double) 6 * rtp.get(PRIZE_6) / totalBets);
            System.out.format("prize 11 -> %d  -> %4.6f \n", rtp.get(PRIZE_11), (double) 11 * rtp.get(PRIZE_11) / totalBets);
            System.out.format("prize 12 -> %d  -> %4.6f \n", rtp.get(PRIZE_12), (double) 12 * rtp.get(PRIZE_12) / totalBets);
            System.out.format("prize 30 -> %d  -> %4.6f \n", rtp.get(PRIZE_30), (double) 30 * rtp.get(PRIZE_30) / totalBets);
            System.out.format("prize 60 -> %d  -> %4.6f \n", rtp.get(PRIZE_60), (double) 60 * rtp.get(PRIZE_60) / totalBets);
            System.out.format("MAX PRIZE:  %d \n", MAX_PRIZE);

        }

        System.out.format("total win = %d \n", totalWin);
        System.out.format("total bets = %d \n", totalBets);
        System.out.format("total spins = %d \n", numberOfGames);
        System.out.format("RTP = %4.4f \n", returnToPlayer);
    }

    public static int[] rotateCylinders(int[] currentPosition, SecureRandom rand) {
        // rodar cilindros a partir da posição anterior é um preciosismo :D
        // a geração aleatória a partir da posição 0 dava resultados iguais
        int[] newPosition = {0, 0, 0, 0, 0};
        for (int i = 0; i < 5; i++) {
            Integer r = rand.nextInt(70) + 1;
            int value = (currentPosition[i] + r) % REEL_STOPS;
            newPosition[i] += value;
        }
        return newPosition;
    }

    public static void printGameArea(String[][] table) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%s ", table[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void printCylinders(int[] cylinder) {
        for (int i = 0; i < 5; i++) {
            System.out.printf("%d ", cylinder[i]);
        }
        System.out.print("\n");
    }


    public static int verifyScatter(String[][] table) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (table[i][j].equals(S)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static int getPrizeFor243Ways(String[][] table, SecureRandom rand) {
        int totalWin = 0;
        if (hasWildSymbol(table)) {
            table = expandingWild(table, rand);
        }
        if (qaPrint) {
            printGameArea(table);
        }

        for (int line = 0; line < 3; line++) {
            int dim = 1;
            int split = 1;
            String symbol = table[line][0];
            if (symbol.equals(S)) {
                break;
            }
            for (int col = 1; col < 5; col++) {
                int count = countSymbolOnColumn(symbol, col, table);
                if (count > 0) {
                    dim++;
                    split *= count;
                } else {
                    break;
                }
            }
            if (dim > 2) {
                int win = getPrize(symbol, dim, split);
                totalWin += win * split;
                int value = rtp.get(win);
                rtp.put(win, value + split);
            }
        }
        if (qaPrint) {
            System.out.println("Dismissing any eventual Scatter prize, the total win for this table is: " + totalWin);
        }

        return totalWin;
    }


    public static int countSymbolOnColumn(String symbol, int column, String[][] table) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (symbol.equals(table[i][column]) || W.equals(table[i][column])) {
                count++;
            }
        }
        return count;
    }

    public static boolean hasWildSymbol(String[][] table) {
        for (int line = 0; line < 3; line++) {
            for (int col = 0; col < 5; col++) {
                if (W.equals(table[line][col])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String[][] expandingWild(String[][] table, SecureRandom rand) {
        String[][] newTable = table;
        for (int col = 0; col < 5; col++) {
            int count = countSymbolOnColumn(W, col, table);
            if (count > 0) {
                Integer r = rand.nextInt(100);
                if (r < 80) {
                    for (int line = 0; line < 3; line++) {
                        newTable[line][col] = W;
                    }
                }
            }
        }
        return newTable;
    }

    public static int getPrize4RegularWays(String[][] table) {

        int totalWin = 0;
        if (qaPrint) {
            printGameArea(table);
        }
        for (int line = 0; line < LINES; line++) {
            int sum = 1;
            String firstLetter = table[regularWays[line][0]][0];
            if (firstLetter.equals(S)) {
                break;
            }
            for (int i = 1; i < 5; i++) {
                if (firstLetter.equals(table[regularWays[line][i]][i]) || W.equals(table[regularWays[line][i]][i])) {
                    sum++;
                } else {
                    break;
                }
            }
            if (sum > 2) {
                int win = getPrize(firstLetter, sum, 1);
                totalWin += win;
                int value = rtp.get(win);
                rtp.put(win, value + 1);
                if (!isSimulation) {
                    if (!prizeFreq.containsKey(win)) {
                        prizeFreq.put(win, 1);
                    } else {
                        prizeFreq.put(win, prizeFreq.get(win) + 1);
                    }
                }
            }
        }
        //System.out.printf("total prize: %d\n",totalWin);
        if (MAX_PRIZE < totalWin) {
            MAX_PRIZE = totalWin;
        }
        return totalWin;
    }

    public static int getPrize(String symbol, int count, int split) {
        if (qaPrint) {
            System.out.printf("prizes %d%s = %d with value %d \n", count, symbol, split, Main.prize.get(symbol).get(count - 3));
        }
        return Main.prize.get(symbol).get(count - 3);
    }

    public static int getScatterPrize(int count) {
        return getPrize(S, count, 1);
    }

    public static boolean turnSymbol(SecureRandom random){
        return random.nextDouble()<0.05f;
    }

    public static int runSpin(SecureRandom random, int maxSpins){

        int sum = 0;
        for(int spin = 0; spin < maxSpins; spin++){
            for(int i=0; i<grid.length; i++){
                // only empty grids are prompt to turn a symbol
                // and the grid position i is empty if grid[i]==0
                if (grid[i] < 1){
                    if(turnSymbol(random)){
                        grid[i]=1;
                        //System.out.println("Symbol turned at position: " + i);
                        sum++;
                    }
                }
            }
            // the spins will be reset if some symbol is turned during the bonus spin game
            if (sum>0){
                return maxSpins;
            }
        }
        // if no symbol turned, then the game comes to an end
        return 0;
    }

    public static int[] scatterTable2Grid(String[][] table){
        int[] grid = new int[15];
        for(int line = 0; line<table[0].length; line++){
            for(int column = 0; column<table.length; column++){
                if(table[line][column]==S){
                    grid[5*line+column]=1;
                }
            }
        }
        return grid;
    }

    public static ArrayList<String> table2List(String[][] table) {
        ArrayList<String> tabList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                tabList.add(table[i][j]);
            }
        }
        return tabList;
    }

    public static String[][] generateGameArea(int[] toPosition) {
        String[][] table = new String[3][5];
        for (int i = 0; i < 5; i++) {
            table[0][i] = cylinders[i][toPosition[i]];
            table[1][i] = cylinders[i][toPosition[i] + 1];
            table[2][i] = cylinders[i][toPosition[i] + 2];
        }
        return table;
    }


    public static HashMap<Integer, Integer> prizeFrequency() {

        HashMap<Integer, Integer> prizes = new HashMap<>();
        String[][] table = new String[3][5];
        for (int r1 = 0; r1 < REEL_STOPS; r1++) {
            for (int r2 = 0; r2 < REEL_STOPS; r2++) {
                for (int r3 = 0; r3 < REEL_STOPS; r3++) {
                    for (int r4 = 0; r4 < REEL_STOPS; r4++) {
                        for (int r5 = 0; r5 < REEL_STOPS; r5++) {
                            int positions[] = {r1, r2, r3, r4, r5};
                            table = generateGameArea(positions);
                            int prize = getPrize4RegularWays(table);
                            if (!prizes.containsKey(prize)) {
                                prizes.put(prize, 1);
                            } else {
                                prizes.put(prize, prizes.get(prize) + 1);
                            }
                        }
                    }
                }
            }
        }
        return prizes;
    }

    public static ArrayList<GameArea> generateGameAreaList() {
        ArrayList<GameArea> gameAreaList = new ArrayList<>();
        String[][] table = new String[3][5];
        for (int r1 = 0; r1 < REEL_STOPS; r1++) {
            for (int r2 = 0; r2 < REEL_STOPS; r2++) {
                for (int r3 = 0; r3 < REEL_STOPS; r3++) {
                    for (int r4 = 0; r4 < REEL_STOPS; r4++) {
                        for (int r5 = 0; r5 < REEL_STOPS; r5++) {
                            int positions[] = {r1, r2, r3, r4, r5};
                            table = generateGameArea(positions);
                            GameArea gm = new GameArea(table);
                            gameAreaList.add(gm);
                            gm.setPrize(getPrize4RegularWays(table));
                            gm.setFrequency();
                        }
                    }
                }
            }
        }
        return gameAreaList;
    }

    public static void printHashMap(HashMap<Integer, Integer> map) {

    }

}