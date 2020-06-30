package basic.StringQ;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/27
 * @description
 */
public class Q2_两个字符串互为旋转词 {
	public boolean solve(String s1, String s2){
		if(s1 == null || s2==null || s1.length()!=s2.length()){
			return false;
		}
		String b2 = s2 + s2;
		return b2.contains(s1);
	}
}
