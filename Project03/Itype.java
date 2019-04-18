import java.util.Arrays;

public class Itype extends InstructionMemory{
	int opcode;
	int rs;
	int rt;
	int immediate;

	public Itype(RegisterFile ram, int[] instruction) {

		int[] opcode_binary = Arrays.copyOfRange(instruction, 0, 6);
		int[] rs_binary = Arrays.copyOfRange(instruction, 6, 11);
		int[] rt_binary = Arrays.copyOfRange(instruction, 11, 16);
		int[] immediate_binary = Arrays.copyOfRange(instruction,16,32);

		this.opcode = binaryToDecimal(opcode_binary);
		this.rs = binaryToDecimal(rs_binary);
		this.rt = binaryToDecimal(rt_binary);
		this.immediate = binaryToDecimal(immediate_binary);

		int rs_value = ram.getData(rs);
		int rt_value=0;
		int address=0;

		switch(opcode){
			case 4:
				rt_value = ram.getData(rt);
				if(rs_value==rt_value) {
					InstructionMemory.pc = this.immediate-1;
					System.out.println("branch to target");
				}
				break;
			case 7:
				rt_value = ram.getData(rt);
				if(rs_value>rt_value) {
					InstructionMemory.pc = this.immediate-1;
					System.out.println("branch to target");
				}
				break;
			case 8:
				rt_value = rs_value+this.immediate;
				ram.setData(rt, rt_value);
				break;
			case 12:
				rt_value = rs_value-this.immediate;
				ram.setData(rt, rt_value);
				System.out.println(rt_value);
				break;
			case 35:
				address = rs_value+this.immediate;
				rt_value = DataMem.getData(address);
				ram.setData(rt, rt_value);
				System.out.println(rt_value);
				break;
			case 43:
				rt_value = ram.getData(rt);
				address = rs_value+this.immediate;
				DataMem.setData(address, rt_value);
				System.out.println(rt_value);
				break;
		}

	}


}
