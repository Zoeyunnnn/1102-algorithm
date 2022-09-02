import java.util.*;
import java.*;

public class 0309 {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int a = Integer.parseInt(sc.nextLine());
	    for(int i=0;i<a;i++){
	        String tmp = sc.nextLine();
	        String[] str = tmp.split(",");
	        int sumMax=Integer.parseInt(str[0]);
	        int pre=Integer.parseInt(str[0]);
	        for(int j=1;j<str.length;j++){
				int t = Integer.parseInt(str[j]);
	            pre = Math.max(t, t+pre);
				sumMax = Math.max(sumMax, pre);
            }
			System.out.println(sumMax);
        }
    }
}
