import java.util.ArrayList;

public class Garden {

	public static void main(String args[]) {
		int A[] = {1,2,1,2,1,2,1};
		System.out.println(totalFruit(A));
	}
	
	public static int totalFruit(int[] tree) {
		if (tree == null || tree.length < 1) {
			return 0;
		} else if (tree.length == 1) {
			return 1;
		}
		ArrayList<Integer> indexList = new ArrayList<>();
		int last = 0;
		indexList.add(0);
		for (int i = 1; i < tree.length; i++) {
			if (tree[last] != tree[i]) {
				indexList.add(i);
				last = i;
			}
		}
		if (indexList.size() == 1) {
			return tree.length;
		}
		// System.out.println(indexList);
		ArrayList<Integer> containsList = new ArrayList<>();
		int left = -1, right = -1;
		int maxSize = 0;
		for (int i = 0; i <= indexList.size(); i++) {
			int currentIndex;
			int currentFruit;
			if (i == indexList.size()) {
				currentIndex = tree.length;
				currentFruit = -1;
			} else {
				currentIndex = indexList.get(i);
				currentFruit = tree[currentIndex];
			}
			if (!containsList.contains(currentFruit)) {
				if (containsList.size() == 0) {
					left = currentIndex;
					containsList.add(currentFruit);
				} else if (containsList.size() == 1) {
					right = currentIndex;
					containsList.add(currentFruit);
				} else {
					// System.out.println(containsList + " " + currentFruit);
					// System.out.println(left + " " + currentIndex);
					maxSize = Math.max(maxSize, currentIndex - left);

					int lastFruit = tree[indexList.get(i - 1)];
					containsList.clear();
					containsList.add(lastFruit);
					left = indexList.get(i - 1);
					right = currentIndex;
					containsList.add(currentFruit);
				}
			} else {
				right = currentIndex;
			}
		}
		return maxSize;
	}
}