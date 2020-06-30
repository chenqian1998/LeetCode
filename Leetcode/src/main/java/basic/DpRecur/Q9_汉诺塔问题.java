package basic.DpRecur;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/30
 * @description
 */
public class Q9_汉诺塔问题 {
	public void solve() {
		printMove(10, "from", "mid", "to");
	}

	private void printMove(int n, String from, String mid, String to) {
		if (n == 1) {
			System.out.println("move from" + from + "to" + to);
		} else {
			printMove(n - 1, from, to, mid);
			printMove(1, from, mid, to);
			printMove(n - 1, mid, from, to);
		}
	}

}
