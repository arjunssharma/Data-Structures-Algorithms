import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RangeMinimumQuery {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.valueOf(line.split(" ")[0]);
		int M = Integer.valueOf(line.split(" ")[1]);

		int values[] = new int[N];
		line = br.readLine();

		int i = 0;
		for (String S : line.split(" "))
			values[i++] = Integer.valueOf(S);

		SegmentTree segmentTree = new SegmentTree(N);
		segmentTree.buildTree(values, 0, N - 1, 0);

		for (int l = 0; l < M; l++) {
			line = br.readLine();
			int left = Integer.valueOf(line.split(" ")[0]);
			int right = Integer.valueOf(line.split(" ")[1]);
			System.out.println(segmentTree.query(values, left, right));
		}
	}
}

class SegmentTree {
	int[] tree;
	private final int INF = Integer.MAX_VALUE - 1;
	private final int STARTINDEX = 0;
	private final int ENDINDEX;

	public SegmentTree(int size) {
		ENDINDEX = size - 1;
		int height = 2 * (int) Math.pow(2, Math.ceil(Math.log(size) / Math.log(2)));
		tree = new int[height];
		for (int i = 0; i < height; i++)
			tree[i] = INF;
	}

	public void buildTree(int[] values, int left, int right, int root) {
		if (left == right) {
			tree[root] = values[left];
			return;
		}
		int mid = (left + right) / 2;
		buildTree(values, left, mid, 2 * root + 1);
		buildTree(values, mid + 1, right, 2 * root + 2);
		tree[root] = Math.min(tree[2 * root + 1], tree[2 * root + 2]);
	}

	public int query(int[] values, int qs, int qe) {
		return queryUtil(values, STARTINDEX, ENDINDEX, qs, qe, 0);
	}

	private int queryUtil(int[] values, int l, int r, int qs, int qe, int root) {
		int left = 2 * root + 1, right = left + 1;
		if (l >= qs && r <= qe)
			return tree[root];
		if (l > qe || r < qs)
			return INF;
		int mid = (l + r) / 2;
		return Math.min(queryUtil(values, l, mid, qs, qe, left), queryUtil(values, mid + 1, r, qs, qe, right));
	}
}