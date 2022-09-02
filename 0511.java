import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n>0){
            String[] tmp = sc.nextLine().split("  ");
            System.out.println(minDistance(tmp[0], tmp[1]));

            n--;
        }
    }
    public static int minDistance(String str1, String str2){
        int len = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len+1][len2+1];

        for(int i=0;i<=len;i++) dp[i][0] = i;
        for(int i=0;i<=len2;i++) dp[0][i] = i;

        for(int i=0;i<len;i++){
            char c1 = str1.charAt(i);
            for(int j=0;j<len2;j++){
                char c2 = str2.charAt(j);

                if(c1 == c2) dp[i+1][j+1] = dp[i][j];
                else{
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j+1] + 1;
                    int delete = dp[i+1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i+1][j+1] = min;
                }
            }
        }
        return dp[len][len2];
    }
}
