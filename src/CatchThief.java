import java.util.Scanner;

/**
 * Created by mayiwei on 2017/4/11.
 */
//http://exercise.acmcoder.com/online/online_judge_ques?ques_id=4400&konwledgeId=41
public class CatchThief {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(Catch(s,n));
    }

    public static int Catch(String q,int n){
        boolean[] iscatch = new boolean[n];
        int count=0;
        for (int i=0;i<n;i++){
            int x=q.charAt(i)-'0';
            if (x<=9&&x>=0){
                for (int j=i-x;j<=i+x&&j<n;j++){
                    if (j>=0&&q.charAt(j)=='X'&&!iscatch[j]){
                        count++;
                        iscatch[j]=true;
                    }
                }
            }
        }
        return count;
    }
}
