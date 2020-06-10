package structure;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/10
 * @description 主要是熟悉下string相关的API
 */
public class BasicString {
    /**
     * 词频统计
     *
     * @param s
     */
    public void countWords(String s, HashMap<String, Integer> hashMap) {
        // split(" ") 按照" " 分割
        String[] strs = s.split(" ");
        for (String val : strs ){
            if (hashMap.get(val) == null){
                hashMap.put(val, 1);
            }else {
                hashMap.put(val,hashMap.get(val) + 1);
            }
        }
        System.out.println(hashMap);
    }

    public void split(String s){
        String[] strings = s.split("a");
        String[] strings2 = s.split(" ");

        System.out.println(strings.length+ " , "+ strings2.length);
    }

    @Test
    public void minus(){
        char a = 'a';
        System.out.println(a);
        System.out.println((int)a);


        int[] table = new int[26];
        // 统计每个单词出现的频率
        String s = "abcdacmdeMM";
        s = s.toLowerCase();

        for(int i=0; i< s.length(); i++){
            table[s.charAt(i)-'a'] += 1;
        }

        




    }

    @Test
    public void test01(){
        String s = "a a a ";
        // countWords(s,new HashMap<>());
        split(s);
    }
}
