import java.util.Scanner;

public class Main {
    static int a, b;
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = Integer.parseInt(sc.nextLine());
	    while(n>0){
	        String[] str = sc.nextLine().split(",");
	        int[] arr = new int[str.length];
	        for (int j =0;j<str.length;j++) arr[j] = Integer.parseInt(str[j]);

            findMedian(arr, arr.length);
	        n--;
        }
    }
    static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
    static int Partition(int arr[], int l, int r){
        int lst = arr[r], i = l, j = l;
        while (j < r){
            if (arr[j] < lst){
                arr = swap(arr, i, j);
                i++;
            }
            j++;
        }
        arr = swap(arr, i, r);
        return i;
    }
    static int randomPartition(int arr[], int left, int right) {
        int n = right-left+ 1;
        int x = (int) (Math.random() % n);
        arr = swap(arr, left+x, right);
        return Partition(arr, left, right);
    }
    static int MedianUtil(int arr[], int left, int right, int k){
        // if l < r
        if (left <= right){
            int partitionIndex = randomPartition(arr, left, right);

            // If partition index = k
            if (partitionIndex == k){
                b = arr[partitionIndex];
                if (a != -1)
                    return Integer.MIN_VALUE;
            }else if (partitionIndex == k - 1){  // If index = k - 1
                a = arr[partitionIndex];
                if (b != -1)
                    return Integer.MIN_VALUE;
            }

            // If partitionIndex >= k
            if (partitionIndex >= k) return MedianUtil(arr, left, partitionIndex - 1, k);
            // If partitionIndex <= k
            else return MedianUtil(arr, partitionIndex + 1, right, k);
        }

        return Integer.MIN_VALUE;
    }
    static void findMedian(int arr[], int n){
        int ans;
        a = -1;
        b = -1;

        // If n is odd
        if (n % 2 == 1){
            MedianUtil(arr, 0, n - 1, n / 2);
            ans = b;
        }else{ // If n is even
            MedianUtil(arr, 0, n - 1, n / 2);
            ans = (a + b) / 2;
        }

        System.out.println(ans);
    }
}
