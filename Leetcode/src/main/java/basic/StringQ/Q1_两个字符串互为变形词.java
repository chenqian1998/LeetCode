package basic.StringQ;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/27
 * @description
 */
public class Q1_两个字符串互为变形词 {
	public boolean solve(String s1, String s2){
		if(s1 == null || s2==null || s1.length() != s2.length()){
			return false;
		}
		int[] map = new int[256];
		for(int i=0; i<s1.length(); i++){
			map[s1.indexOf(i)]++;
		}
		for (int i=0; i<s2.length(); i++){
			map[s2.indexOf(i)]--;
		}
		for(int i=0; i<256; i++){
			if(map[i]!=0){
				return false;
			}
		}
		return true;
	}
}
