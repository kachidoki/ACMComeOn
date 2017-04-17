import java.util.*;

/**
 * Created by mayiwei on 2017/4/11.
 */
public class FindFirstOneNum {

    public static int findOnlyOneElment(List<Integer> list) {
        int n =list.size();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++){
            if (map.containsKey(list.get(i))){
                map.put(list.get(i),map.get(list.get(i))+1);
            }else {
                map.put(list.get(i),1);
            }
        }
        for (int i=0;i<n;i++){
            if(map.get(list.get(i))==1) return list.get(i);
        }
        return -1;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        String s=in.nextLine();
        String[] snum =s.split(",");
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<snum.length;i++){
            list.add(Integer.valueOf(snum[i]));
        }
        res = findOnlyOneElment(list);
        System.out.println(res);

    }
}
