import java.util.HashMap;

public class DataMem {

	static HashMap<Integer,Integer> dataMem;

	static int getData(int addr) {
		return dataMem.get(addr);
	}

	static void setData(int addr, int data) {
		dataMem.put(addr, data);
	}
}
