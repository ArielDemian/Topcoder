import java.util.Arrays;
import java.util.Comparator;

public class BuildingBridges {
	// Consider a 2-D map with a horizontal river passing through its center.
	// There are n cities on the southern bank with x-coordinates a(1) ... a(n)
	// and n cities on the northern bank with x-coordinates b(1) ... b(n). You
	// want to connect as many north-south pairs of cities as possible with
	// bridges such that no two bridges cross. When connecting cities, you can
	// only connect city i on the northern bank to city i on the southern bank.
	public int connect(double[] a, double[] b) {
		int n = a.length, i, j;
		if (b.length != n)
			return -1;
		double[][] v = new double[n][2];
		int[] d = new int[n];
		for (i = 0; i < n; i++) {
			v[i][0] = a[i];
			v[i][1] = b[i];
		}
		Arrays.sort(v, new CoordinatesComparator());
		d[0] = 1;
		for (j = 1; j < n; j++) {
			d[j] = 1;
			for (i = j - 1; i >= 0; i--) {
				if (v[j][1] >= v[i][1] && d[i] + 1 > d[j]) {
					d[j] = d[i] + 1;
				}
			}
		}
		j = 0;
		for (i = 0; i < n; i++)
			if (d[i] > j)
				j = d[i];
		return j;
	}
}

class CoordinatesComparator implements Comparator<double[]> {

	@Override
	public int compare(double[] a, double[] b) {
		if (a[0] > b[0])
			return 1;
		else if (a[0] < b[0])
			return -1;
		else if (a[1] > b[1])
			return 1;
		else if (a[1] < b[1])
			return -1;
		else
			return 0;
	}

}