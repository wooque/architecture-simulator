package sim.components;

public class NOT extends LogicalComponent {

	public NOT() {
		super(1, 1, false);
	}

	public void func() {
		//makes trouble...
		//need testing...
		if(in[0].isHighZ()){
			out[0].setHighZ(true);
			return;
		}
		out[0].setBoolVal(!in[0].getBoolVal());
	}
}
