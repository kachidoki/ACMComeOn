package LeetCode.Array.HashTable;

import java.util.*;

/**
 * Created by mayiwei on 2017/5/12.
 */
//https://leetcode.com/problems/repeated-dna-sequences/#/description
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s==null||s.length()<10) return new ArrayList<>();
        List<String> res=new ArrayList<>();
        int n=s.length();
        Set<String> map=new HashSet<>();
        String tmp;
        for (int i=9;i<n;i++){
            tmp=s.substring(i-9,i+1);
            if (map.contains(tmp)){
                if (!res.contains(tmp)) res.add(tmp);
            }else {
                map.add(tmp);
            }
        }
        return res;
    }

    //简洁版
    public List<String> findRepeatedDnaSequences3(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }

    // hashmap + bits manipulation
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> rv = new ArrayList<>();
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(v) && doubleWords.add(v)) {
                rv.add(s.substring(i, i + 10));
            }
        }
        return rv;
    }


    //"rolling-hash" solution
    private static final Map<Character, Integer> A = new HashMap<>();
    static {
        A.put('A',0);
        A.put('C',1);
        A.put('G',2);
        A.put('T',3);
    }
    private final int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);

    public List<String> findRepeatedDnaSequences4(String s) {
        Set<String> res = new HashSet<>();
        Set<Integer> hashes = new HashSet<>();
        for (int i = 0, rhash = 0; i < s.length(); i++) {
            if (i > 9) rhash -= A_SIZE_POW_9 * A.get(s.charAt(i-10));
            rhash = A.size() * rhash + A.get(s.charAt(i));
            if (i > 8 && !hashes.add(rhash)) res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<>(res);
    }

}
