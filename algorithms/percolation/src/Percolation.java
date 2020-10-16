import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
	public Percolation(int n) {
		_WEIGHTED_QUICK_UNION_FIND = new WeightedQuickUnionUF(n*n + 2);
		_OPEN_SITES_COUNT = 0;
		_MATRIX = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				_MATRIX[i][j] = 0;
			}
		}
	}
	public void open(int row, int col) {
		if(isOpen(row, col)) {
			return;
		}
		_OPEN_SITES_COUNT++;
		_MATRIX[row][col] = 1;
		int q = (row * _MATRIX.length) + col;
		int p = 0;
		if(row == 0) {
			_WEIGHTED_QUICK_UNION_FIND.union(col, _MATRIX.length * _MATRIX.length);
		}
		if(row == _MATRIX.length - 1) {
			p = (row * _MATRIX.length) + col;
			_WEIGHTED_QUICK_UNION_FIND.union(p, _MATRIX.length * _MATRIX.length + 1);
		}
		if((col < _MATRIX.length - 1) && isOpen(row, col + 1)) {
			p = (row * _MATRIX.length) + col + 1;
			_WEIGHTED_QUICK_UNION_FIND.union(p, q);
		}
		if(col > 0 && isOpen(row, col - 1)) {
			p = (row * _MATRIX.length) + col - 1;
			_WEIGHTED_QUICK_UNION_FIND.union(p, q);
		}
		if( row < _MATRIX.length - 1 && isOpen(row + 1, col)) {
			p = (row + 1) * _MATRIX.length + col;
			_WEIGHTED_QUICK_UNION_FIND.union(p, q);
		}
		if(row > 0 && isOpen(row - 1, col)) {
			p = (row - 1) * _MATRIX.length + col;
			_WEIGHTED_QUICK_UNION_FIND.union(p, q);
		}
	}
	public boolean isOpen(int row, int col) {
		return _MATRIX[row][col] == 1;
	}
	public int numberOfOpenSites() {
		return _OPEN_SITES_COUNT;
	}
	public boolean isFull(int row, int col) {
		return _WEIGHTED_QUICK_UNION_FIND.find(_MATRIX.length * _MATRIX.length) == _WEIGHTED_QUICK_UNION_FIND.find(row * _MATRIX.length + col);
	}
	public boolean percolates() {
		return _WEIGHTED_QUICK_UNION_FIND.find(_MATRIX.length * _MATRIX.length) == _WEIGHTED_QUICK_UNION_FIND.find(_MATRIX.length * _MATRIX.length + 1);
	}
	private int _MATRIX[][];
	private int _OPEN_SITES_COUNT;
	private WeightedQuickUnionUF _WEIGHTED_QUICK_UNION_FIND;
}