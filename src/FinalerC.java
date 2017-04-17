import java.util.Scanner;

/**
 * Created by mayiwei on 2017/4/11.
 */
public class FinalerC {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x=new int[n];
        int[] l=new int[n];
        for (int i=0;i<n;i++){
            x[i]=sc.nextInt();
            l[i]=sc.nextInt();
        }
        System.out.println(shot(n,x,l));
    }

    public static int shot(int n,int[] x,int[] l){
        int count=0;
        int countTmp;
        for (int i=0;i<n-1;i++){
            for (int k=i+1;k<n;k++){
                countTmp=0;
                for (int j=0;j<n;j++){
                    if ((x[i]<=x[j]+l[j]&&x[i]>=x[j])||(x[k]<=x[j]+l[j]&&x[k]>=x[j])) countTmp++;
                }
                if (count<countTmp) count=countTmp;
                countTmp=0;
                for (int j=0;j<n;j++){
                    if ((x[i]<=x[j]+l[j]&&x[i]>=x[j])||(x[k]<=x[j]+l[j]&&x[k]>=x[j])) countTmp++;
                }
                if (count<countTmp) count=countTmp;
            }

        }
        return count;
    }

}
