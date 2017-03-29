import java.util.*;

/**
 * Created by mayiwei on 2017/3/28.
 */
public class FindDifference {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        find(n,a);
    }

    public static void find(int n,int[] list){
        Arrays.sort(list);
        int min=list[0],max=list[n-1],min_n=0,max_n;
        int start=0,end=0;
        for (int i=0;i<n;i++){
            if (list[i]==min) {
                start++;
            }else {
                break;
            }
        }
        for (int i=n-1;i>0;i--){
            if (list[i]==max) {
                end++;
            }else {
                break;
            }
        }
        if (start==n||end==n){
            print(n,n);
            return;
        }
        max_n=start*end;

        int tmp_min=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int del = Math.abs(list[i]-list[i+1]);
            if (del<tmp_min) {
                min_n=0;
                tmp_min=del;
            }
            if (del==0) break;
            if (del==tmp_min) min_n++;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        if (tmp_min==0){
            for (int i=0;i<n-1;i++){
                if (Math.abs(list[i]-list[i+1])==0) {
                    if (map.containsKey(list[i])) map.put(list[i],map.get(list[i])+1);
                    else map.put(list[i],1);
                }
            }
            for (Integer key:map.keySet()){
                int val = map.get(key);
                min_n+=val*(val+1)/2;
            }
        }
        print(min_n,max_n);

    }

    public static void print(int min,int max){
        System.out.println(min+" "+max);
    }
}
