
public class CheckSolution {

	public final static float eps = 0.001f;
	
	boolean almostEqual(float a, float b) {
		return Math.abs(a - b) < eps;
	}
	
	boolean check(float[] a, float[] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int ii = 0; ii < a.length; ii++) {
			if (!almostEqual(a[ii], b[ii])) {
				return false;
			}
		}
		return true;
	}
	
	boolean check(float[][] a, float[][] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int ii = 0; ii < a.length; ii++) {
			if (!check(a[ii], b[ii])) {
				return false;
			}
		}
		return true;
	}
}
