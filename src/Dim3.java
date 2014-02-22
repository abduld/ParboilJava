
public class Dim3 {
	private final int x, y, z;
	
	Dim3(int x) {
		this(x, 1, 1);
	}
	
	Dim3(int x, int y) {
		this(x, y, 1);
	}
	
	Dim3(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}	
}
