package basic.ArrayAndMatrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/20
 * @description
 */
public class bd_区间合并 {
	static class Data{
		public int start;
		public int end;
		public Data(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Data{" +
					"start=" + start +
					", end=" + end +
					'}';
		}
	}

	 static class MyComparator implements Comparator<Data>{
		 @Override
		 public int compare(Data o1, Data o2) {
			 if(o1.start == o1.start){
			 	return o1.end - o2.end;
			 }else {
			 	return o1.start - o2.start;
			 }
		 }
	 }


	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] strs = input.split(" ");
		int length = strs.length;
		Data[] data = new Data[length/2];
		for(int i=0; i<length/2; i++){
			data[i] = new Data(Integer.valueOf(strs[2*i]), Integer.valueOf(strs[2*i+1]));
		}

		MyComparator myComparator = new MyComparator();
		Arrays.sort(data, myComparator);

		System.out.println(Arrays.toString(data));

		int canMergeTimes = 0;
		Data temp = data[0];
		for(int i=1; i<length/2; i++){
			if(data[i].start <= temp.end){
				canMergeTimes++;
				temp = new Data(Math.min(temp.start, data[i].start), data[i].end);
			}else {
				temp = data[i];
			}
		}
		System.out.println(length/2 - canMergeTimes);
	}

}
