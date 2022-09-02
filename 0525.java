import java.util.*;
public class MyClass{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n>0){
            int num = Integer.parseInt(sc.nextLine().split(" ")[2]);

            String[] arr = new String[num];
            for(int i=0; i<num; i++) arr[i] = sc.nextLine();

            String[] main = new String[num];
            for(int i=0; i<=num; i++){
                for(int j=0; j<num; j++){
                    String[] tmp = arr[j].split(" ");
                    if(contains(tmp, i))  System.out.println(i);
                }
            }

            boolean flag = false;
            for(int j=0; j<i; j++){
                String[] tmp = arr[j].split(" ");
                for(int k=0; k<tmp.length; k++){
                    if(a == tmp[k]){
                        arr[j] = arr[j]+" "+b;
                        flag = true;
                        break;
                    }else if(b == tmp[k]){
                        arr[j] = arr[j]+" "+a;
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                arr[i] = temp;
            }
            System.out.println(arr[0]);

            n--;
        }
    }
}