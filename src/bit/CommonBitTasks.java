package bit;

public class CommonBitTasks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print(getBit(3, 0));
		System.out.print(" "+getBit(3, 1));
		System.out.print(" "+getBit(3, 2));
		System.out.print(" "+getBit(3, 3));

	}

	private static boolean getBit(int num, int i) {
		System.out.println(1 << i);
		System.out.println(num & (1 << i));
		return ((num & (1 << i)) != 0);
	}

}
