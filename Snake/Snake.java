package Snake;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {




        //liczby pierwsze 3,5,7,11,13,17,19



        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz liczbę, a sprawdzę czy jest liczbą pierwszą ");
        int y = scanner.nextInt();
        while (y<=0){
            System.out.println("Liczba musi być większa od 0");
            y = scanner.nextInt();
        }


        while (y<100) {
            boolean x = false;


            while (y == 1 || y == 2) {
                System.out.println("Liczba jest pierwsza");
                y = scanner.nextInt();
            }


            for (int j = 2; j <= (y / 2); j++) {
                if (y % j == 0) {
                    x = true;
                    break;
                }
            }

            if (x) {
                System.out.println("Liczba nie jest pierwsza");
            } else {
                System.out.println("Liczba jest pierwsza");
            }
            y = scanner.nextInt();
        }



    }


}
