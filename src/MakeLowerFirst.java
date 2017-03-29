import java.util.Scanner;

/**
 * Created by mayiwei on 2017/3/28.
 */
public class MakeLowerFirst {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            char[] s = sc.nextLine().toCharArray();
            make(s);
        }

    }

    public static void make(char[] s){
        char tmp;
        int count=0;
        for (int i=0;i<s.length&&count<s.length;){
            if (s[i]<='Z'&&s[i]>='A'){
                tmp = s[i];
                for (int j=i;j<s.length-1;j++){
                    s[j] = s[j+1];
                }
                s[s.length-1]=tmp;
            }else {
                i++;
            }
            count++;
        }
        System.out.println(s);
    }

}
