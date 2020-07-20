package basic.ArrayAndMatrix;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/20
 * @description
 */
public class bd_出现次数TOPK {
	class Node{
		public int value;
		public int times;

		public Node(int value, int times) {
			this.value = value;
			this.times = times;
		}
	}

	class BaseComporator implements Comparator<Node>{
		@Override
		public int compare(Node node1, Node node2){
			return node1.times - node2.times;
		}
	}


	/**
	 *  前提是数组有序的
	 */
	public void findTimesTopK(int[] arr, int k){
		BaseComporator comporator = new BaseComporator();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
			}else{
				map.put(arr[i],1);
			}
		}

		PriorityQueue<Node> minHeap = new PriorityQueue<>(k,comporator);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			int value = entry.getKey();
			int times = entry.getValue();
			Node node = new Node(value,times);

			if(minHeap.size() == k){
				if(minHeap.peek().times < times){
					minHeap.poll();
					minHeap.add(node);
				}
			}else {
				minHeap.add(node);
			}
		}
		int[] res= new int[k];
		int i = 0;
		while(!minHeap.isEmpty()){
			res[i] = minHeap.poll().value;
			i++;
		}

		System.out.println(Arrays.toString(res));
	}


	@Test
	public void test(){
		int[] arr = {1,2,3,3,4,4};
		findTimesTopK(arr,3);
	}
}
