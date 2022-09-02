import java.util.*;
import java.lang.Math;
public class 0518{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n>0){
            int num = Integer.parseInt(sc.nextLine().split(" ")[1]);
            HashMap<Integer, Integer> distance  = new HashMap();
            for(int i=0; i<num; i++){
                String tmp="";
                if(i==num-1) tmp = sc.nextLine().split(" ")[0];
                else tmp = sc.nextLine().split(" ")[i+1];
                int t = Integer.parseInt(tmp);
                distance.put(i+1, t);
            }
            int diameter=0;
            int maxDiameter=0;
            for(int i=1; i<num; i++){
                diameter=0;
                if(i<num-1){
                    for(int j=0; j<2; j++){
                        String tmp = distance.get(i+j)+"";
                        int dist = Integer.parseInt(tmp);
                        diameter+=dist;
                    }
                }else{
                    for(int j=0; j<2; j++){
                        int a=0;
                        if(i+j>num) a=0+j;
                        else{
                            a=i+j;
                            String tmp = distance.get(a)+"";
                            int dist = Integer.parseInt(tmp);
                            diameter+=dist;
                        }
                    }
                }
                
                maxDiameter=Math.max(diameter, maxDiameter);
            }
            System.out.println(maxDiameter);
            n--;
        }
    }
}