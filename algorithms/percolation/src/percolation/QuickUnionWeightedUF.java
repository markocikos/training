package percolation;

import java.util.Arrays;

public class QuickUnionWeightedUF {
	public QuickUnionWeightedUF(int n) {
		id = new int[n];

		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	public void union(int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);

		if (pRoot == qRoot) {
			return;
		}

		if (size[pRoot] <= size[qRoot]) {
			id[pRoot] = qRoot;
			size[qRoot] += size[pRoot];
		}
		else {
			id[qRoot] = pRoot;
			size[pRoot] += size[qRoot];
		}
	}

	public boolean connected(int p, int q) {
		return findRoot(p) == findRoot(q );
	}

	public String toString() {
		return Arrays.toString(id);
	}

	private int findRoot (int p) {
		while(p != id[p]) {
			// id[i] = id[id[i]]
			p = id[p];
		}

		return p;
	}

	private int[] id;
	private int[] size;
}
