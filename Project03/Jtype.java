import java.awt.*;
import java.util.Arrays;

public class Jtype extends InstructionMemory{
	int opcode;
	int target_address;

	public Jtype(RegisterFile ram, int[] instruction) {
		int[] opCodeBinary = Arrays.copyOfRange(instruction, 0, 6);
		int[] targetAddrBinary = Arrays.copyOfRange(instruction, 6, 32);

		this.opcode =binaryToDecimal(opCodeBinary);
		this.target_address =binaryToDecimal(targetAddrBinary);

		switch(opcode) {
			case 2:
				InstructionMemory.pc = target_address-1;
				break;
			case 3:
				ram.setReturnAddr(InstructionMemory.pc);
				InstructionMemory.pc = target_address-1;
				break;
			case 16:
				int addr = ram.getData(target_address);
				InstructionMemory.pc = addr - 1;
				break;
		}
		System.out.println("j target " + InstructionMemory.pc);
	}

}
