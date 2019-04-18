import java.util.Arrays;

public class Rtype extends InstructionMemory{
	int rs;
	int rt;
	int rd;
	int shamt;
	int func;

	public Rtype(RegisterFile ram, int[] instruction) {
		int[] rs_binary = Arrays.copyOfRange(instruction, 6, 11);
		int[] rt_binary = Arrays.copyOfRange(instruction, 11, 16);
		int[] rd_binary = Arrays.copyOfRange(instruction, 16, 21);
		int[] shamt_binary = Arrays.copyOfRange(instruction, 21, 26);
		int[] func_binary = Arrays.copyOfRange(instruction, 26, 32);

		this.rs = binaryToDecimal(rs_binary);
		this.rt = binaryToDecimal(rt_binary);
		this.rd = binaryToDecimal(rd_binary);
		this.shamt = binaryToDecimal(shamt_binary);
		this.func = binaryToDecimal(func_binary);

		int rs_value = this.rs;
		int rt_value = this.rt;
		int result=0;

		switch(func) {
			case 0:
				result = rs_value<<rt_value;
				break;
			case 2:
				result = rs_value>>rt_value;
				break;
			case 32:
				result = rs_value+rt_value;
				break;
			case 34:
				result = rs_value-rt_value;
				break;
			case 24:
				result = rs_value*rt_value;
				break;
			case 26:
				result = rs_value/rt_value;
				break;
			case 36:
				result = rs_value&rt_value;
				break;
			case 37:
				result = rs_value|rt_value;
				break;
			case 39:
				result = ~(rs_value|rt_value);
				break;
			case 38:
				result = rs_value^rt_value;
				break;
			case 42:
				result = (rs_value<rt_value)? 1:0;
				break;

		}
		int rdVal = result;
		ram.setData(this.rd,rdVal);
	}

}
