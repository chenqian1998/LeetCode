package basic.StringQ;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/28
 * @description
 */
public class Q4_字符串的统计字符串 {
	public String getCountString(String s){
		if(s == null || "".equals(s)){
			return "";
		}
		String res = "";
		char[] chas = s.toCharArray();
		int count = 1;
		for(int i=1; i< chas.length; i++){
			if(chas[i] == chas[i-1]){
				count +=1;
			}else {
				if("".equals(res)){
					res = res + chas[i-1] + "_" + count;
				}else {
					res = res + "_" + chas[i-1] + "_" + count;
				}

				count = 1;
			}
		}
		return res;
	}

	@Test
	public void test(){
		String s = "aaabbadddffc";
		System.out.println(getCountString(s));
	}


	/**
	 * a_1_b_100 , index位置上是上面元素
	 * @param cstr
	 * @param index
	 * @return
	 */
	public char getCharAt(String cstr,int index){
		if(cstr == null || "".equals(cstr) || index<0){
			return 0;
		}
		String cur=null;
		String[] strs = cstr.split("_");
		int count = 0;
		for(int i=0; i< strs.length; i++){
			if((i & 1) == 1){
				count += Integer.parseInt(strs[i]);
				if(count > index){
					return cur.toCharArray()[0];
				}
			}else {
				cur = strs[i];
			}
		}
		return 0;
	}


	@Test
	public void test02(){
		String cstr = "a_100_b_2_c_4";
		int index = 106;
		System.out.println(getCharAt(cstr,index));

	}
}
