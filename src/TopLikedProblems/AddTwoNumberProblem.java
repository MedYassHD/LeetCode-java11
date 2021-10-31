package TopLikedProblems;

import java.math.BigDecimal;

class AddTwoNumberProblem {

	public static void main(String[] args) {
		ListNode l1 = new ListNode();
		for (int i = 0; i < 31; i++) {
			if (i == 0)
				l1 = new ListNode(1, l1);
			l1 = new ListNode(0, l1);
			if (i == 30)
				l1 = new ListNode(1, l1);
		}

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		addTwoNumbers(l1, l2);

	}
	
	/**
	 * LeetCode Submission report of my solution. Runtime: 20 ms, faster than 5.16%
	 * of Java online submissions for Search Insert Position. Memory Usage: 40.3 MB,
	 * less than 46.32% of Java online submissions for Search Insert Position.
	 */

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode rslt = new ListNode();
		String numberOne = "";
		String numberTwo = "";
		String tmp = new String();

		while (l1 != null || l2 != null) {
			if (l1 != null) {
				numberOne = numberOne + Integer.toString(l1.val);
				l1 = l1.next;
			}
			if (l2 != null) {
				numberTwo = numberTwo + Integer.toString(l2.val);
				l2 = l2.next;
			}
		}
		tmp = reverse(numberOne);

		BigDecimal xBig = new BigDecimal(tmp);

		tmp = reverse(numberTwo);

		BigDecimal ybig = new BigDecimal(tmp);

		String finalRslt = xBig.add(ybig).toPlainString();

		rslt = new ListNode(Character.getNumericValue(finalRslt.charAt(0)));
		for (int i = 1; i < finalRslt.length(); i++) {
			rslt = new ListNode(Character.getNumericValue(finalRslt.charAt(i)), rslt);
		}

		return rslt;
	}

	private static String reverse(String str) {
		String rslt = new String();
		int l = str.length() - 1;
		while (l > -1) {
			rslt = rslt + str.charAt(l);
			l--;
		}
		return rslt;
	}
}