package array;

public class ArrayExample {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int k = 2;

        k = k % n; 

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for (int i = k, j = n - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for(int i = 0; i < n; i++) {
        	System.out.print(arr[i] + " ");
        }
    }
}