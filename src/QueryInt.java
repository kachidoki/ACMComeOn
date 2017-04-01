import java.util.Scanner;

/**
 * Created by mayiwei on 2017/3/30.
 */
public class QueryInt {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int q = sc.nextInt();
            sc.nextLine();
            int[] A=new int[n];
            int[] B=new int[n];
            for (int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            sc.nextLine();
            for (int i=0;i<n;i++){
                B[i]=sc.nextInt();
            }
            sc.nextLine();
            int[][] xy=new int[2][q];
            for (int i=0;i<q;i++){
                xy[0][i]=sc.nextInt();
                xy[1][i]=sc.nextInt();
                sc.nextLine();
            }
            find(A,B,xy,n,q);
        }
    }

    public static void find(int[] A,int[] B,int[][] xy,int n,int q){
        for (int i=0;i<q;i++){
            int count=0;
            for (int j=0;j<n;j++){
                if (A[j]>=xy[0][i]&&B[j]>=xy[1][i]) count++;
            }
            System.out.println(count);
            count=0;
        }
    }



}
