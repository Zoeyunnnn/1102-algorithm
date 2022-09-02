import java.util.*;
public class HeapSort {

  public static void main(String[] args) {
    // int[] arr = {10,7,8,25,5,11,27,16,15,4,12,6,7,23,20};
    Scanner sc = new Scanner(System.in);
    int n = Integer.valueOf(sc.nextLine());
    while(n>0){
        String tmp = sc.nextLine();
        String[] Arr = tmp.split(",");
        int[] arr = new int[Arr.length];
        HeapSort hs = new HeapSort();

        for(int i=0;i<arr.length;i++) arr[i] = Integer.valueOf(Arr[i]);
        hs.heapSort(arr);
        
        int size = arr.length;
        for (int i=0;i<size;i++) {
            if(i==size-1) System.out.print(arr[i]);
            else System.out.print(arr[i]+",");
        }
        System.out.println();
        n--;
    }
    
  }
	
  private void heapSort(int[] arr){
    int arrLength = arr.length;
    // create heap from array start from index (n-1)/2
    for(int i = (arrLength-1)/2; i >= 0; i--){
      heapify(arr, arrLength, i);
    }
    // System.out.println(Arrays.toString(arr));
  }
    
  private void heapify(int[] numArr, int index, int i){
    // Getting parent and children indexes
    int root = i;
    int leftChild = 2*i + 1;
    int righChild = 2*i + 2;
    //compare left child value
    if(leftChild < index && numArr[leftChild] > numArr[root])
      root = leftChild;
    //comparing right child value
    if(righChild < index && numArr[righChild] > numArr[root])
      root = righChild;
      // swap values if required and call method recursively for next level
      if(root != i){
        swap(numArr, root, i);
        heapify(numArr, index, root);
      }
    }
    
    private void swap(int[] numArr, int index, int li){
      int temp = numArr[li];
      numArr[li] = numArr[index];
      numArr[index] = temp;
    }
}