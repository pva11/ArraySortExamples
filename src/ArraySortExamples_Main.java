import java.util.Arrays;

public class ArraySortExamples_Main {

    public static void main(String[] args) {
        int [] array = new int [10];
       for (int i = 0;i<10;i++){
            array[i] = (int) (Math.random() * 10);
        }
        //shaker(array);
        shell(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shaker(int [] array) {
        int iter, q_iter, i, sign, border;

        iter = 0;
        q_iter = array.length/2;
        sign = 1;
        i = iter + 1;
        border = array.length - 1;

        while (iter < q_iter) {

            if (array[i] < array[i-1]) {
                swap(array,i,i-1);
            }

            if (i == border) {
                if (sign == 1) {
                    border = iter + 1;
                } else {
                    iter++;
                    border = array.length - 1 - iter;
                }
                if (i== border) {
                    iter++;
                }
                sign = (-1)*sign;

            }

            i = i + sign;

        }
    }

    public static void shell(int [] array) {
        int step = array.length;
        do {
            step = step/2;
            int i = 0;
            while (i + step != array.length) {
                if (array[i] > array [i + step]) {
                    swap(array, i, i + step);
                    int j = i - step;
                    boolean change = (j >= 0);
                    while (change) {
                        change = false;
                        if (array[j] > array[j+step]) {
                            swap(array, j, j + step);
                            change = true;
                        }
                        if (change) {
                            j = i - step;
                            change = (j >= 0);
                        }
                    }
                }
                i++;
            }
        } while (step != 1);
    }

    public static void swap(int [] array, int i, int j) {
        int temp;

        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
