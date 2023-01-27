package Snake;

public class Snake {
    public static void main(String[] args) {

        int [] numbers = {4,6,2,3,7,8,1,9,0};

        int last = numbers[numbers.length-1];
        int first = numbers[0];

        numbers[0] = last;
        numbers[numbers.length-1] = first;



        for (int i = 0; i <numbers.length; i++){

            System.out.println(numbers[i]);

        }


    }
}
