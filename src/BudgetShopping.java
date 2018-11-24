import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BudgetShopping {

	public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
		List<List<Integer>> tuple = new ArrayList<>();
		for (int i = 0; i < bundleQuantities.size(); i++) {
			List<Integer> tempList = new ArrayList<>();
			tempList.add(bundleQuantities.get(i));
			tempList.add(bundleCosts.get(i));
			tuple.add(tempList);
		}
		Collections.sort(tuple, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				if (((double) o2.get(0)) / o2.get(1) < ((double) o1.get(0)) / o1.get(1)) {
					return -1;
				} else if (((double) o2.get(0)) / o2.get(1) > ((double) o1.get(0)) / o1.get(1)) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		int dp[][] = new int[tuple.size() + 1][n + 1];
		for (int i = 1; i <= tuple.size(); i++) {
			for (int j = 1; j <= n; j++) {
				if (j >= tuple.get(i - 1).get(1)) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - tuple.get(i - 1).get(1)] + tuple.get(i - 1).get(0));
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		int r = tuple.size(), c = n;

		return dp[r][c];
	}
}