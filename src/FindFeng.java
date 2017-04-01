import java.util.Scanner;

/**
 * Created by mayiwei on 2017/3/30.
 */
public class FindFeng {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++){
              a[i]=sc.nextInt();
            }
            find(a,n);
        }
    }

    public static void find(int[] a,int n){
        if(n==0||a.length==0){
            System.out.println("-1 -1");
            return;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        int[] all = new int[n];
        for (int i=0;i<n;i++){
            if (i==0) {
                up[0]=0;
            }else {
                if (a[i]>a[i-1]) {
                    up[i]=up[i-1]+1;
                }else {
                    up[i]=0;
                }
            }
        }
        for (int i=n-1;i>=0;i--){
            if (i==n-1) {
                down[i]=0;
            }else {
                if (a[i]>a[i+1]){
                    down[i]=down[i+1]+1;
                } else {
                    down[i]=0;
                }
            }
        }
        for (int i=0;i<n;i++){
            if (up[i]!=0&&down[i]!=0){
                all[i]=up[i]+down[i];
            }else {
                all[i]=0;
            }

        }
        int max=0,tmpi=-1;
        for (int i=1;i<n-1;i++){
            if (max<all[i]){
                max=all[i];
                tmpi=i;
            }
        }
        if (tmpi==-1){
            System.out.println("-1 -1");
        }else {
            int start=tmpi-up[tmpi];
            int end=tmpi+down[tmpi];
            System.out.println(start+" "+end);
        }
    }
}
