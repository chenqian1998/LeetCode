package basic.DpRecur;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/30
 * @description
 */
public class Q8_信封嵌套问题 {
	class Envelope{
		public int len;
		public int width;

		public Envelope(int len, int width){
			this.len = len;
			this.width = width;
		}
	}

	 class EnvelopeComparator implements Comparator<Envelope>{
		@Override
		public int compare(Envelope o1, Envelope o2) {
			if(o1.len != o2.len){
				return o1.len - o2.len;
			}else {
				return o1.width - o2.width;
			}
		}
	}

	public Envelope[] getSortedEnvelopes(int[][] matrix){
		Envelope[] arr = new Envelope[matrix.length];
		for(int i=0; i<matrix.length; i++){
			arr[i] = new Envelope(matrix[i][0],matrix[i][1]);
		}
		Arrays.sort(arr, new EnvelopeComparator());
		return arr;
	}





}
