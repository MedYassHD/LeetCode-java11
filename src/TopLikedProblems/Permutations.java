package TopLikedProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Permutations {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		int[] nums = { 5, 4, 6, 2 };
		System.out.println(permute(nums));
	}

	public static List<List<Integer>> permute(int[] nums) {
		var k = 0;
		List<List<Integer>> resuList = new ArrayList<>();
		long nbr = LongStream.rangeClosed(1, nums.length).reduce(1, (a, b) -> a * b);
		int i = 0, j = 0;
		while (nbr != 0) {
			k = nums[j];
			nums[j] = nums[i];
			nums[i] = k;
			i++;
			try {
				j = Random.class.newInstance().nextInt(nums.length);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			if (i >= nums.length - 1)
				i = 0;
			List<Integer> intList = Arrays.stream(nums).boxed().collect(Collectors.toList());
			if (!resuList.contains(intList)) {
				resuList.add(intList);
				System.out.println(intList);
				nbr--;
			}
		}
		return resuList;
	}
}