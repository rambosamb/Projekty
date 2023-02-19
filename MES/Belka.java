package MES;

import java.util.Scanner;

public class Belka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = 0;
        while (m <= 0) {
            System.out.println("Wpisz ilość elementów skończonych");
            m = scanner.nextInt();
        }
        int E;
        System.out.println("Podaj E - moduł Younga");
        E = scanner.nextInt();
        int J;
        System.out.println("Podaj J - moment bezwładności przekroju belki");
        J = scanner.nextInt();
        macierzsztywnoscik(E,J,m);
        macierzprzyporzadkowaniaPi(m);
        macierzprzyporzadkowaniaPiT(m);
        transponedAndMultiplied(m, macierzprzyporzadkowaniaPiT(m),macierzsztywnoscik(E,J,m));
        transponedAndMultipliedALL(m, transponedAndMultiplied(m, macierzprzyporzadkowaniaPiT(m),macierzsztywnoscik(E,J,m)),macierzprzyporzadkowaniaPi(m));
        matrixAdd(m,transponedAndMultipliedALL(m, transponedAndMultiplied(m, macierzprzyporzadkowaniaPiT(m),macierzsztywnoscik(E,J,m)),macierzprzyporzadkowaniaPi(m)));
        matrixKp(m,transponedAndMultipliedALL(m, transponedAndMultiplied(m, macierzprzyporzadkowaniaPiT(m),macierzsztywnoscik(E,J,m)),macierzprzyporzadkowaniaPi(m)));
    }
    public static int[][][] macierzsztywnoscik(int E ,int J, int m) {
        Scanner scanner = new Scanner(System.in);
        int[][][] macierzsztywnoscik = new int[m][4][4];
        for (int i = 0; i < macierzsztywnoscik.length; i++) {
            int l;
            System.out.println("Wpisz długość l" + (i + 1));
            l = scanner.nextInt();
            int t = ((E * J)) / l;
            System.out.println("k" + (i + 1) + " =");
            macierzsztywnoscik[i][0][0] = 6 * t;
            macierzsztywnoscik[i][0][1] = 3 * l * t;
            macierzsztywnoscik[i][0][2] = -6 * t;
            macierzsztywnoscik[i][0][3] = 3 * l * t;
            macierzsztywnoscik[i][1][0] = 3 * l * t;
            macierzsztywnoscik[i][1][1] = 2 * l * l * t;
            macierzsztywnoscik[i][1][2] = -3 * l * t;
            macierzsztywnoscik[i][1][3] = l * l * t;
            macierzsztywnoscik[i][2][0] = -6 * t;
            macierzsztywnoscik[i][2][1] = -3 * l * t;
            macierzsztywnoscik[i][2][2] = 6 * t;
            macierzsztywnoscik[i][2][3] = -3 * l * t;
            macierzsztywnoscik[i][3][0] = 3 * l * t;
            macierzsztywnoscik[i][3][1] = l * l * t;
            macierzsztywnoscik[i][3][2] = -3 * l * t;
            macierzsztywnoscik[i][3][3] = 2 * l * l * t;
            int[][] macierzsztywnosci = macierzsztywnoscik[i];
            for (int j = 0; j < macierzsztywnosci.length; j++) {
                int[] macierzsztywnoscicolumn = macierzsztywnosci[j];
                for (int k = 0; k < macierzsztywnoscicolumn.length; k++) {
                    System.out.print(macierzsztywnosci[j][k] + " ");
                }
                System.out.println();
            }
        }
        return macierzsztywnoscik;

    }
    private static int [][][] macierzprzyporzadkowaniaPi(int m) {
        System.out.println("Zadanie rozpatrywane jest od lewej do prawej ES");
        int[][][] macierzprzyporzadkowaniaPi = new int[m][4][(m + 1) * 2];
        for (int i = 0; i < macierzprzyporzadkowaniaPi.length; i++) {
            System.out.println("Macierz Pi" + (i + 1));
            int[][] matrixPi = macierzprzyporzadkowaniaPi[i];
            for (int j = 0; j < matrixPi.length; j++) {
                int[] versematrixG = matrixPi[j];
                for (int k = 0; k < versematrixG.length; k++) {
                    if (j == k - (i * 2)) {
                        matrixPi[j][k] = 1;
                    }
                    System.out.print(matrixPi[j][k] + " ");
                }
                System.out.println();
            }
        }
        return macierzprzyporzadkowaniaPi;
    }
    private static int [][][] macierzprzyporzadkowaniaPiT(int m) {
        int[][][] macierzprzyporzadkowaniaPiT = new int[m][(m + 1) * 2][4];
        for (int i = 0; i < macierzprzyporzadkowaniaPiT.length; i++) {
            System.out.println("Macierz PiT" + (i + 1));
            int[][] matrixPi = macierzprzyporzadkowaniaPiT[i];
            for (int j = 0; j < matrixPi.length; j++) {
                int[] versematrixG = matrixPi[j];
                for (int k = 0; k < versematrixG.length; k++) {
                    if (j == k + (i * 2)) {
                        matrixPi[j][k] = 1;
                    }
                    System.out.print(matrixPi[j][k] + " ");
                }
                System.out.println();
            }
        }
        return macierzprzyporzadkowaniaPiT;
    }

    private static int [][][] transponedAndMultiplied(int m, int [][][]macierzprzyporzadkowaniaPiT, int [][][]macierzsztywnoscik) {

        int[][][] transponedAndMultiplied = new int[m][(m + 1) * 2][4];
        for (int i = 0; i < transponedAndMultiplied.length; i++) {
            System.out.println("πt" + (i + 1) + " * k" + (i + 1));
            int[][] wiersz = transponedAndMultiplied[i];
            for (int j = 0; j < wiersz.length; j++) {
                int[] kolumna = wiersz[j];
                for (int k = 0; k < kolumna.length; k++) {
                    for (int l = 0; l < kolumna.length; l++) {
                        int multiplier1 = macierzprzyporzadkowaniaPiT[i][j][l];
                        int multiplier2 = macierzsztywnoscik[i][l][k];
                        transponedAndMultiplied[i][j][k] += multiplier1 * multiplier2;
                    }
                    System.out.print(transponedAndMultiplied[i][j][k] + " ");
                }
                System.out.println();
            }
        }
        return transponedAndMultiplied;
    }

    private static int [][][] transponedAndMultipliedALL(int m, int [][][] transponedAndMultiplied, int [][][]macierzprzyporzadkowaniaPi){
        int[][][] transponedAndMultipliedALL = new int[m][(m + 1) * 2][(m + 1) * 2];
        for (int i = 0; i < transponedAndMultipliedALL.length; i++) {
            System.out.println("Kp" + (i + 1));
            int[][] wiersz = transponedAndMultipliedALL[i];
            for (int j = 0; j < wiersz.length; j++) {
                int[] kolumna = wiersz[j];
                for (int k = 0; k < kolumna.length; k++) {
                    for (int l = 0; l < 4; l++) {
                        int multiplier1 = transponedAndMultiplied[i][j][l];
                        int multiplier2 = macierzprzyporzadkowaniaPi[i][l][k];
                        transponedAndMultipliedALL[i][j][k] += multiplier1 * multiplier2;
                    }
                    System.out.print(transponedAndMultipliedALL[i][j][k] + " ");
                }
                System.out.println();
            }
        }
        return transponedAndMultipliedALL;
    }

    private static int [][] matrixAdd(int m, int [][][]transponedAndMultipliedALL) {
        System.out.println("Dodawanie macierzy - " + "Kp = ");
        int[][] matrixAdd = new int[(m + 1) * 2][(m + 1) * 2];
        for (int i = 0; i < matrixAdd.length; i++) {
            int[] columnmatrixAdd = matrixAdd[i];
            for (int j = 0; j < columnmatrixAdd.length; j++) {
                for (int k = 0; k < m; k++) {
                    int adder1 = transponedAndMultipliedALL[k][i][j];
                    matrixAdd[i][j] += adder1;
                }
                System.out.print(matrixAdd[i][j] + " ");
            }
            System.out.println();
        }
        return matrixAdd;
    }


    private static int [][] matrixKp(int m, int [][][]transponedAndMultipliedALL) {
        System.out.println("Dodawanie macierzy - " + "Kp = ");
        int[][] matrixKp = new int[(m + 1) * 2][(m + 1) * 2];
        for (int i = 0; i < matrixKp.length; i++) {
            int[] columnmatrixAdd = matrixKp[i];
            for (int j = 0; j < columnmatrixAdd.length; j++) {
                for (int k = 0; k < m; k++) {
                    int adder1 = transponedAndMultipliedALL[k][i][j];
                    matrixKp[i][j] += adder1;
                }
                System.out.print(matrixKp[i][j] + " ");
            }
            System.out.println();
        }
        return matrixKp;
    }



}
