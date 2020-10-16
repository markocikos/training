package percolation;

import java.util.Arrays;

public class QuickFindUF {
	public QuickFindUF(int n) {
		id = new int[n];

		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public void union(int p, int q) {
		int newComponentId = id[q];
		int oldComponentId = id[p];

		if (newComponentId == oldComponentId) {
			return;
		}

		for (int i = 0; i < id.length; i++) {
			if (id[i] == oldComponentId) {
				id[i] = newComponentId;
			}
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public String toString() {
		return Arrays.toString(id);
	}

	private int[] id;
}
