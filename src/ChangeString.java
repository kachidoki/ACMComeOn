import java.util.Stack;

/**
 * Created by mayiwei on 2017/4/7.
 */
//给定字符串（ASCII码0-255）数组，请在不开辟额外空间的情况下删除开始和结尾处的空格，并将中间的多个连续的空格合并成一个。
// 例如："   i    am a      little boy.    "，变成"i am a little boy"
public class ChangeString {


    void FormatString(char str[],int len){
        if (str==null||len<=0) return;
        int i=0,j=0;
        while (str[i]==' '){
            i++;
        }
        while (i<=str.length-1){
            if (str[i]==' '&&(i==str.length-1||str[i+1]==' ')){
                i++;
                continue;
            }
            str[j++]=str[i++];
        }
    }
}
