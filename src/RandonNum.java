import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mayiwei on 2017/3/29.
 */
public class RandonNum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            sort(a);
        }
    }


    public static void sort(int[] r){
        if (r.length==0||r==null) return;
        Arrays.sort(r);
        List<Integer> ns = new LinkedList<>();
        int last =0;
        for (int i=0;i<r.length;i++){
            if (last!=r[i]){
                last=r[i];
                ns.add(last);
            }
        }
        for (int i=0;i<ns.size();i++){
            System.out.println(ns.get(i));
        }
    }

}
