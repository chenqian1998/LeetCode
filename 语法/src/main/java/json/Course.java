package json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class Course {
	String courseName;

	Integer code;

}
