package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/10
 * @description
 */
public class BasicJSON {

	/**
	 * 今天有一个针对json的问题，所以特地来学习下
	 *
	 * 接口通过HTTP 通过POST 发送， body中的数据如下
	 * {
	 *   "corpId":"1234abc",
	 *   "departmentId:"100",
	 *   "keys":[]
	 * }
	 *
	 * 然后我返回：
	 * {
	 *   "responseStatus":{
	 *     "TimeStamp":"11111",
	 *     "ACK":"success",
	 *     "Errors":[]
	 *   },
	 *   "ids":[
	 *     "xiaobai",
	 *     "小成",
	 *     "ddxx",
	 *     "jiukakan"
	 *  	]
	 * }
	 *
	 * 核心问题就是这么
	 */

	String wxMsg = "\'";
	String wxMsg2 = "\t \"";

	//json字符串-简单对象型
	private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

	//json字符串-数组类型
	private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

	//复杂格式json字符串
	private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";


	@Test
	public void controller(){
		System.out.println(wxMsg);
		System.out.println(wxMsg2);
	}

	/**
	 * JSON其实就是某种格式的字符串，可以转换成对象 getObject(name, class)
	 * 尤其是转换成[]数组的操作要注意，getJsonArray("name")
	 */
	@Test
	public void JSON_2_CLASS(){
		JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
		System.out.println(jsonObject);

		Integer teacherAge = jsonObject.getInteger("teacherAge");
		System.out.println(teacherAge);

		System.out.println(jsonObject.get("teacherName"));

		// {"courseName":"english","code":1270}
		System.out.println(jsonObject.get("course"));

		// 如果建立了对应的class
		System.out.println(jsonObject.getObject("course", Course.class));

		// 转换成LIST
		JSONArray students = jsonObject.getJSONArray("students");
		System.out.println(students);

		ArrayList<Integer> ids = new ArrayList<>();
		ArrayList<String> names = new ArrayList<>();

		for (int i=0; i< students.size(); i++){
			Student s = students.getObject(i,Student.class);
			System.out.println(s);
			ids.add(s.getStudentAge());
			names.add(s.getStudentName());
		}
		System.out.println(names);
	}

	@Test
	public void CLASS_2_JSON(){
		Student ccc = new Student(1, "ccc");
		String jsonString = JSON.toJSONString(ccc);
		System.out.println(jsonString);

		Student aaa = new Student(1, "aaa");
		Student bbb = new Student(1, "aaa");

		Student[] arr = {aaa,bbb,ccc};

		List<Student> objects = Arrays.asList(aaa,bbb,ccc);

		responseMsg responseMsg = new responseMsg(200, "success", new Course("计算机", 1024), objects);
		String jsonString1 = JSON.toJSONString(responseMsg);
		System.out.println(jsonString1);
	}

}
