package percolation;

import java.util.Arrays;

public class QuickUnionUF {
	public QuickUnionUF(int n) {
		id = new int[n];

		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public void union(int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);

		if (pRoot == qRoot) {
			return;
		}

		id[pRoot] = qRoot;
	}

	public boolean connected(int p, int q) {
		return findRoot(p) == findRoot(q);
	}

	public String toString() {
		return Arrays.toString(id);
	}

	private int findRoot (int p) {
		while(p != id[p]) {
			p = id[p];
		}

		return p;
	}

	private int[] id;
}
