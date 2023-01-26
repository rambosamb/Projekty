package MES;

import java.util.Scanner;

public class Pret {
    public static void main(String[] args) {
        int matrixkiLength = 2;
        System.out.println("Wpisz ilosc wezlow");
        Scanner scanner = new Scanner(System.in);
        int nodePoint = scanner.nextInt();
        while (nodePoint <= 1 ){
            System.out.println("Ilość węzłów musi być większa lub równa 2");
            nodePoint = scanner.nextInt();
        }
        matrixki(matrixkiLength);
        matrixPi(nodePoint);
        matrixTransponed(nodePoint);
        matrixTransponedAndMultiplied(nodePoint,matrixkiLength,matrixTransponed(nodePoint),matrixki(matrixkiLength));
        matrixMultiplied(nodePoint, matrixTransponedAndMultiplied(nodePoint,matrixkiLength,matrixTransponed(nodePoint),matrixki(matrixkiLength)),matrixPi(nodePoint));
        matrixAdd(matrixMultiplied(nodePoint, matrixTransponedAndMultiplied(nodePoint,matrixkiLength,matrixTransponed(nodePoint),matrixki(matrixkiLength)),matrixPi(nodePoint)), nodePoint);
        matrixG(nodePoint);
        matrixGT(nodePoint);
        matrixmultipliedGTKp(nodePoint,matrixGT(nodePoint),matrixAdd(matrixMultiplied(nodePoint, matrixTransponedAndMultiplied(nodePoint,matrixkiLength,matrixTransponed(nodePoint),matrixki(matrixkiLength)),matrixPi(nodePoint)), nodePoint));
        matrixmultipliedGTKpG(nodePoint,matrixGT(nodePoint),matrixAdd(matrixMultiplied(nodePoint, matrixTransponedAndMultiplied(nodePoint,matrixkiLength,matrixTransponed(nodePoint),matrixki(matrixkiLength)),matrixPi(nodePoint)), nodePoint));





    }
    public static int[][] matrixki(int matrixkiLength){
        int[][] ki = new int[matrixkiLength][matrixkiLength];
        ki[0][0] = 1;
        ki[0][1] = -1;
        ki[1][1] = 1;
        ki[1][0] = -1;
        for (int i = 0; i < ki.length; i++) {
            int[] kolumny = ki[i];
            for (int j = 0; j < kolumny.length; j++) {
                System.out.print ( ki[i][j] + "  ");
            }
            System.out.println();
        }
        return ki;
    }
    
    public static int[][][] matrixPi(int nodePoint){
        int[][][] matrixPi = new int[nodePoint-1][2][nodePoint];
        for (int i = 0; i< matrixPi.length; i++)
        {
            System.out.println("π" + (i + 1)  + "=");
            int[][] matrix = matrixPi[i];
            for (int j = 0; j<matrix.length; j++) {
                int[] column = matrix[j];
                for (int k = 0; k < column.length; k++) {
                    if(k == i + j ){
                        matrixPi[i][j][k] = 1;
                    }
                    System.out.print(matrixPi[i][j][k] + " ");
                }
                System.out.println();
            }
        }
        return matrixPi;
    }
    public static int[][][] matrixTransponed(int nodePoint){
        System.out.println("Obliczanie macierzy transponowanej");
        int[][][] matrixTransponed = new int[nodePoint-1][nodePoint][2];
        for (int i = 0; i< matrixTransponed.length; i++)
        {
            System.out.println("πt" + (i + 1)  + "=");
            int[][] macierz = matrixTransponed[i];
            for (int j = 0; j<macierz.length; j++) {
                int[] kolumna = macierz[j];
                for (int k = 0; k < kolumna.length; k++) {
                    if(j == i + k ){
                        matrixTransponed[i][j][k] = 1;
                    }
                    System.out.print(matrixTransponed[i][j][k] + " ");
                }
                System.out.println();
            }
        }
        return matrixTransponed;
    }

    public static int[][][] matrixTransponedAndMultiplied(int nodePoint, int matrixkiLength, int [][][]matrixTransponed, int [][]matrixki){
        int [][][] matrixTransponedAndMultiplied = new int [nodePoint-1][nodePoint][2];
        System.out.println("Macierz transponowana i pomnożona ");
        for (int i = 0; i < matrixTransponedAndMultiplied.length; i++ )
        {
            System.out.println("πt" + (i + 1)  + " * k=");
            int [][] wiersz = matrixTransponedAndMultiplied[i];
            for (int j = 0; j < wiersz.length; j++)
            {
                int [] kolumna = wiersz[j];
                for (int k = 0; k < kolumna.length; k++)
                {
                    for(int l = 0; l < matrixkiLength; l++){
                        int multiplier1 = matrixTransponed[i][j][l];
                        int multiplier2 =  matrixki[l][k];
                        matrixTransponedAndMultiplied[i][j][k] += multiplier1 * multiplier2;
                    }
                    System.out.print(matrixTransponedAndMultiplied[i][j][k] + " ");
                }
                System.out.println();
            }

        }
        return matrixTransponedAndMultiplied;
    }


    public static int[][][] matrixMultiplied(int nodePoint, int [][][]matrixTransponedAndMultiplied, int[][][]matrixPi ) {
        int[][][] matrixMultiplied = new int[nodePoint - 1][nodePoint][nodePoint];
        for (int i = 0; i < matrixMultiplied.length; i++) {
            System.out.println("Kp" + (i + 1) + " = πt" + (i + 1) + " * k * π" + (i + 1) + " =");
            int[][] wiersz = matrixMultiplied[i];
            for (int j = 0; j < wiersz.length; j++) {
                int[] kolumna = wiersz[j];
                for (int k = 0; k < kolumna.length; k++) {
                    for (int l = 0; l < 2; l++) {
                        int multiplier1 = matrixTransponedAndMultiplied[i][j][l];
                        int multiplier2 = matrixPi[i][l][k];
                        matrixMultiplied[i][j][k] += multiplier1 * multiplier2;

                    }
                    System.out.print(matrixMultiplied[i][j][k] + " ");

                }
                System.out.println();
            }
        }
        return matrixMultiplied;
    }

    public static int [][] matrixAdd(int[][][] matrixMultiplied, int nodePoint) {
        System.out.println("Dodawanie macierzy - " + "Kp = ");
        int[][] matrixAdd = new int[nodePoint][nodePoint];
        for (int i = 0; i <= matrixMultiplied.length; i++) {
            int[] columnmatrixAdd = matrixAdd[i];
            for (int j = 0; j < columnmatrixAdd.length; j++) {
                for (int k = 0; k < nodePoint - 1; k++) {
                    int adder1 = matrixMultiplied[k][i][j];
                    matrixAdd[i][j] += adder1;
                }
                System.out.print(matrixAdd[i][j] + " ");
            }
            System.out.println();
        }
        return matrixAdd;

    }
    public static int [][] matrixG(int nodePoint){
        System.out.println("G (macierz warunków brzegowych)" + " =");
        int[][] matrixG = new int[nodePoint][nodePoint-1];
        for (int i = 0; i< matrixG.length; i++)
        {
            int[] versematrixG = matrixG[i];
            for (int j = 0; j<versematrixG.length; j++) {
                if (i == j+1) {
                    matrixG[i][j] = 1;
                }
                System.out.print(matrixG[i][j] + " ");
            }
            System.out.println();
        }
        return matrixG;
    }

    public static int [][] matrixGT(int nodePoint){
        System.out.println("GT (macierz transponowana warunków brzegowych)" + " =");

        int[][] matrixGT = new int[nodePoint-1][nodePoint];
        for (int i = 0; i< matrixGT.length; i++)
        {
            int[] versematrixG = matrixGT[i];
            for (int j = 0; j<versematrixG.length; j++) {
                if (i == j-1) {
                    matrixGT[i][j] = 1;
                }
                System.out.print(matrixGT[i][j] + " ");
            }
            System.out.println();
        }
        return matrixGT;
    }


    public static int [][] matrixmultipliedGTKp(int nodePoint,int [][] matrixGT,int [][] matrixAdd) {
        System.out.println("GT*Kp = ");
        int[][] matrixmultipliedGTKp = new int[nodePoint - 1][nodePoint];
        for (int i = 0; i < matrixmultipliedGTKp.length; i++) {
            int[] versematrixG = matrixmultipliedGTKp[i];
            for (int j = 0; j < versematrixG.length; j++) {
                for (int k = 0; k < matrixAdd.length; k++) {
                    int matrixmultiplierGT = matrixGT[i][k];
                    int matrixmultiplierKp = matrixAdd[k][j];

                    matrixmultipliedGTKp[i][j] += matrixmultiplierGT * matrixmultiplierKp;
                }

                System.out.print(matrixmultipliedGTKp[i][j] + " ");
            }
            System.out.println();
        }
        return matrixmultipliedGTKp;
    }
    public static int [][] matrixmultipliedGTKpG(int nodePoint, int [][]matrixmultipliedGTKp, int [][] matrixG) {
        System.out.println("K (Globalna rzeczywista macierz sztywności) = GT*Kp*G = ");
        int[][] matrixmultipliedGTKpG = new int[nodePoint - 1][nodePoint - 1];
        for (int i = 0; i < matrixmultipliedGTKpG.length; i++) {
            int[] versematrixGTKpG = matrixmultipliedGTKpG[i];
            for (int j = 0; j < versematrixGTKpG.length; j++) {
                for (int k = 0; k <= versematrixGTKpG.length; k++) {
                    int matrixmultiplierGTKp = matrixmultipliedGTKp[i][k];
                    int matrixmultiplierG = matrixG[k][j];

                    matrixmultipliedGTKpG[i][j] += matrixmultiplierGTKp * matrixmultiplierG;
                }

                System.out.print(matrixmultipliedGTKpG[i][j] + " ");
            }
            System.out.println();
        }
        return matrixmultipliedGTKpG;
    }



}
