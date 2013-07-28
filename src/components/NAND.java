package components;

public class NAND extends LogicalComponent {

	public NAND() {
		this(2);
	}

	public NAND(int in) {
		super(in, 1, false);
	}

	public void func() {

		boolean result = true;
		for (int i = 0; i < in.length; i++) 
			result = (result) &&(in[i].getBoolVal());
		
		result = !result;
		out[0].setBoolVal(result);
	}
	 
	      
	         
	          
	

	

}
