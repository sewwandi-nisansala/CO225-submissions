import java.util.Arrays;

public class InstructionMemory {

	static int pc=0;

	static void findInstructionType(RegisterFile ram,int[] instruction){
		int[] opCode = Arrays.copyOfRange(instruction, 0, 6);
		int opCodeDec = binaryToDecimal(opCode);
		if(opCodeDec==0) {
			new Rtype(ram,instruction);
		}
		else if(opCodeDec==2 || opCodeDec==3 || opCodeDec==16) {
			new Jtype(ram,instruction);
		}
		else {
			new Itype(ram,instruction);
		}

	}

	static int binaryToDecimal(int[] binary){
		int decimal=0;
		for(int i=binary.length-1;i>=0;--i)
		{
			decimal+=binary[i]*Math.pow(2, binary.length-1-i);
		}
		return decimal;
	}
}
