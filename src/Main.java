import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";
    public static final String D = "D";
    public static final String E = "E";
    public static final String W = "W";
    public static final String S = "S";

    public static final int PRIZE_5 = 5;
    public static final int PRIZE_10 = 10;
    public static final int PRIZE_15 = 15;
    public static final int PRIZE_20 = 20;
    public static final int PRIZE_25 = 25;
    public static final int PRIZE_50 = 50;
    public static final int PRIZE_75 = 75;
    public static final int PRIZE_100 = 100;
    public static final int PRIZE_150 = 150;
    public static final int PRIZE_400 = 400;


    public static final String[] c1 = {B, D, A, A, E, S, A, B, C, C, C, B, E, D, B, D, C, D, A, A, B, D};
    public static final String[] c2 = {A, B, D, E, C, E, C, D, S, D, B, A, S, C, D, A, W, C, B, A, A, B};
    public static final String[] c3 = {B, E, S, D, E, S, A, B, A, B, C, D, C, S, D, B, W, C, A, W, B, E};
    public static final String[] c4 = {E, D, A, D, C, C, A, A, A, B, D, C, B, W, B, C, S, D, A, S, E, D};
    public static final String[] c5 = {C, D, A, A, A, S, A, B, D, C, B, D, D, E, E, B, C, A, C, B, C, D};
    public static final String[][] cylinders = {c1, c2, c3, c4, c5};

    public static final int[][] regularWays = {{0, 0, 0, 0, 0}, {0, 0, 1, 2, 2}, {1, 1, 1, 1, 1}, {2, 2, 1, 0, 0}, {2, 2, 2, 2, 2}};

    public static HashMap<Integer, Integer> rtp = new HashMap<>();
    public static HashMap<String, ArrayList<Integer>> prize = new HashMap<>();

    public static boolean qaPrint = false;

    public static void main(String[] args) {

        // setup variables
        //---------------------------------------------------------------
        ArrayList<Integer> pA = new ArrayList<>();
        pA.add(5);
        pA.add(20);
        pA.add(50);
        prize.put(A, pA);
        ArrayList<Integer> pB = new ArrayList<>();
        pB.add(5);
        pB.add(20);
        pB.add(50);
        prize.put(B, pB);
        ArrayList<Integer> pC = new ArrayList<>();
        pC.add(10);
        pC.add(50);
        pC.add(100);
        prize.put(C, pC);
        ArrayList<Integer> pD = new ArrayList<>();
        pD.add(15);
        pD.add(75);
        pD.add(150);
        prize.put(D, pD);
        ArrayList<Integer> pE = new ArrayList<>();
        pE.add(25);
        pE.add(150);
        pE.add(400);
        prize.put(E, pE);
        ArrayList<Integer> pS = new ArrayList<>();
        pS.add(5);
        pS.add(15);
        pS.add(25);
        prize.put(S, pS);

        rtp.put(PRIZE_5, 0);
        rtp.put(PRIZE_10, 0);
        rtp.put(PRIZE_15, 0);
        rtp.put(PRIZE_20, 0);
        rtp.put(PRIZE_25, 0);
        rtp.put(PRIZE_50, 0);
        rtp.put(PRIZE_75, 0);
        rtp.put(PRIZE_100, 0);
        rtp.put(PRIZE_150, 0);
        rtp.put(PRIZE_400, 0);

        SecureRandom rand = new SecureRandom();
        int[] rotateToPosition = {0, 0, 0, 0, 0};

        long wonScatter = 0;
        long totalWin = 0;
        double returnToPlayer;

        //-------------------------------------------------------------------------
        // game configs
        //-------------------------------------------------------------------------

        // set the number of spins
        Long numberOfGames = 10_000_000L;
        System.out.println("Initial (payed) spins " + numberOfGames);

        // if you want to print the table and some other info to test if is working
        qaPrint = false;

        // if you want a 243Ways paying game just turn next line to false
        boolean isRegularGame = true;

        // if you want a FreeSpins game mode turn next line to true
        boolean isFreeSpinsGame = true;

        long totalBets = isRegularGame? numberOfGames * 10 :  numberOfGames * 250;


        for (long i = 0L; i < numberOfGames; i++) {

            rotateToPosition = rotateCylinders(rotateToPosition, rand);
            if(qaPrint){
                System.out.println("game: " + i);
                printCylinders(rotateToPosition);
            }

            String table[][] = generateGameArea(rotateToPosition);

            int vs = verifyScatter(table);
            if (vs > 2) {
                int win = getScatterPrize(vs);
                totalWin += win;
                int value = rtp.get(win);
                rtp.put(win, value + 1);
                wonScatter++;

                if(isFreeSpinsGame){
                    // free spins
                    numberOfGames += 3;
                }
            }
            if(isRegularGame){
                totalWin += getPrize4RegularWays(table);
            }else{
                if (qaPrint && hasWildSymbol(table)){
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

        System.out.format("prize 5 -> %d  -> %4.6f \n", rtp.get(PRIZE_5), (double) 5 * rtp.get(PRIZE_5) / totalBets);
        System.out.format("prize 10 -> %d  -> %4.6f \n", rtp.get(PRIZE_10), (double) 10 * rtp.get(PRIZE_10) / totalBets);
        System.out.format("prize 15 -> %d  -> %4.6f \n", rtp.get(PRIZE_15), (double) 15 * rtp.get(PRIZE_15) / totalBets);
        System.out.format("prize 20 -> %d  -> %4.6f \n", rtp.get(PRIZE_20), (double) 20 * rtp.get(PRIZE_20) / totalBets);
        System.out.format("prize 25 -> %d  -> %4.6f \n", rtp.get(PRIZE_25), (double) 25 * rtp.get(PRIZE_25) / totalBets);
        System.out.format("prize 50 -> %d  -> %4.6f \n", rtp.get(PRIZE_50), (double) 50 * rtp.get(PRIZE_50) / totalBets);
        System.out.format("prize 75 -> %d  -> %4.6f \n", rtp.get(PRIZE_75), (double) 75 * rtp.get(PRIZE_75) / totalBets);
        System.out.format("prize 100 -> %d  -> %4.6f \n", rtp.get(PRIZE_100), (double) 100 * rtp.get(PRIZE_100) / totalBets);
        System.out.format("prize 150 -> %d  -> %4.6f \n", rtp.get(PRIZE_150), (double) 150 * rtp.get(PRIZE_150) / totalBets);
        System.out.format("prize 400 -> %d  -> %4.6f \n", rtp.get(PRIZE_400), (double) 400 * rtp.get(PRIZE_400) / totalBets);

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
            Integer r = rand.nextInt(60) + 1;
            int value = (currentPosition[i] + r) % 20;
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

    public static String[][] generateGameArea(int[] toPosition) {
        String[][] table = new String[3][5];
        for (int i = 0; i < 5; i++) {
            table[0][i] = cylinders[i][toPosition[i]];
            table[1][i] = cylinders[i][toPosition[i] + 1];
            table[2][i] = cylinders[i][toPosition[i] + 2];
        }
        return table;
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
        if(hasWildSymbol(table)){
            table = expandingWild(table, rand);
        }
        if(qaPrint){
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
                }else{
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
        if(qaPrint){
            System.out.println("Dismissing any eventual Scatter prize, the total win for this table is: "+totalWin);
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
        if(qaPrint){
            printGameArea(table);
        }
        for (int line = 0; line < 5; line++) {
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
            }
        }
        return totalWin;
    }

    public static int getPrize(String symbol, int count, int split) {
        if(qaPrint){
            System.out.printf("prizes %d%s = %d with value %d \n",count, symbol, split, Main.prize.get(symbol).get(count-3));
        }
        return Main.prize.get(symbol).get(count-3);
    }

    public static int getScatterPrize(int count) {
        return getPrize(S, count, 1);
    }


}