package stream;

import domain.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/4
 * @description
 *
 * java stream是对 Collection 操作的进一步封装，
 *
 */
public class basicStream {
	@Test
	public void test01(){
		Person p1 = new Person("james",10,null);
		Person p2 = new Person("jojo",18,null);
		Person p3 = new Person("jojo",28,null);
		Person p4 = new Person("jojo",8,null);

		ArrayList<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);

		// 排序逻辑
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getName().compareTo(o2.getName()) == 0){
					return o1.getAge() - o2.getAge();
				}
				return o1.getName().compareTo(o2.getName());
			}
		});

		System.out.println(list);
	}

	@Test
	public void testStringCompareTo(){
		/**
		 * str1.compareTo(str2) , compareTo()方法其实是比较两个字符串的大小，
		 * 这就要回到我们对字符串大小的定义
		 *
		 */
		String s1 = "abc";
		String s2 = "acb";
		String s3 = "ab";

		// -1
		System.out.println(s1.compareTo(s2));

		// 1
		System.out.println(s1.compareTo(s3));

		// 0
		System.out.println(s1.compareTo("abc"));
	}

}
