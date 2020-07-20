package basic.StringQ;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/16
 * @description
 */
public class Q6_在有序但是有空的数组中查找字符串 {
	public int getIndex(String[] strs, String s){
		int length = strs.length;
		int start = 0;
		int end = length-1;
		int mid = (start + end) / 2;

		while(start <= end){
			if(strs[mid] == null){
				// [start.......end] 中点是null ， 只想向附近的找
				int j = mid-1;
				while(j>=start && strs[j] == null){
					j--;
				}

				if(j < start){
					// 这种情况就说明左边全部是null
					start = mid;
				}else {
					if(strs[j].compareTo(s) < 0){
						start = mid + 1;
					}else if(strs[j].compareTo(s) > 0){
						end = j-1;
					}else {
						return j;
					}
				}

			}
			else {
				if(strs[mid].equals(s)){
					return mid;
				}else if(strs[mid].compareTo(s) < 0){
					start = mid + 1;
				}else {
					end = mid -1;
				}
			}

			mid = (start + end)/2;
		}
		return -1;
	}

}
