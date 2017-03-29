import java.util.Scanner;

/**
 * Created by mayiwei on 2017/3/20.
 */

//链接：https://www.nowcoder.com/questionTerminal/46eb436eb6564a62b9f972160e1699c9
// 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。
// 答案可能有多个，我我们需要找出长度最小的那个。
//例如 N = 18  L = 2：
//5 + 6 + 7 = 18
//3 + 4 + 5 + 6 = 18
//都是满足要求的，但是我们输出更短的 5 6 7
public class AddLtoN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        scanner.close();
        solition(n,l);
    }


    public static void solition(int n,int l){
        int bg=-1,ed=-1;
        for (int i=l;i<=100;i++){
            if (i%2==1&&n%i==0){
                int mid = n/i;
                bg=mid-(i-1)/2;
                ed=mid+(i-1)/2;
                if (bg>=0) break;
            }

            if (i%2==0&&(double)n/i-n/i==0.5f) {
                int mid = n / i;
                bg=mid-i/2+1;
                ed=mid+i/2;
                if (bg>=0) break;
            }
        }
        if (bg>=0){
            for (int i=bg;i<=ed;i++){
                System.out.print(i+" ");
            }
        }else {
            System.out.print("NO");
        }

    }

}
