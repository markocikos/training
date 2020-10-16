package percolation;

public class Percolation {
	public static void main(String[] args) {
		QuickUnionUF qf = new QuickUnionUF(10);

		System.out.println(qf);
		qf.union(5, 6);
		System.out.println(qf);
		qf.union(5, 7);
		System.out.println(qf);
	}
}
