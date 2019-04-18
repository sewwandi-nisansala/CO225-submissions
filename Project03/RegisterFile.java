
public class RegisterFile {

	private int[] regSet = new int[16];

	int getData(int address) {
		return regSet[address];
	}

	void setData(int address,int data) {
		regSet[address] = data;
		System.out.println("Set data : "+data+ " on address "+address);
	}

	void setReturnAddr(int address) {
		regSet[15] = address;
		System.out.println("Set Return address " + address);
	}
}
