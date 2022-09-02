import java.util.Scanner;
public class 0601 {
    public static String multiply(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        sb1.reverse();
        sb2.reverse();
        int[] a = new int[sb1.length() + sb2.length()];
        for (int i = 0; i < sb1.length(); i++) {
            for (int j = 0; j < sb2.length(); j++) {
                a[i + j] += (sb1.charAt(i) - '0') * (sb2.charAt(j) - '0');
            }
        }
        for (int i = 0; i < a.length - 1; i++) {
            a[i + 1] += a[i] / 10;
            a[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length - 1; i++) {
            sb.append(a[i]);
        }
        if (a[a.length - 1] != 0) {
            sb.append(a[a.length - 1]);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n>0){
            String tmp = sc.nextLine();
            String x, y, sum;
            x = tmp.split("  ")[0];
            y = tmp.split("  ")[1];
            sum = multiply(x, y);
            System.out.println(sum);
            
            n--;
        }
    }
}