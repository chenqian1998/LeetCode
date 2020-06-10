package json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/10
 * @description
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class responseMsg {
	private Integer code;
	private String msg;

	private Course course;

	private List<Student> students;

}
