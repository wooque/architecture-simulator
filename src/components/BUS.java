package components;

public class BUS extends LogicalComponent{
	
	private String name;

	public BUS(int in, int out, String name) {
		super(in, out, false);
		this.name=name;
		for(int i=0;i<out;i++){
			this.out[i].setIsInt();
		}
	}

	public void func(){
		int numOfInputActive=0;
		int activeInput=0;
		for(int i=0;i<in.length;i++){
			if((in[i]!=null)&&(!in[i].isHighZ())){
				numOfInputActive++;
				activeInput=i;
			}
		}
		if(numOfInputActive>1){
			System.out.println("Warning!!! You burned bus..."+name);
			return;
		}
		if(numOfInputActive==0){
			for(int i=0;i<out.length;i++){
				if(out[i]!=null){
					out[i].clear();
					out[i].setHighZ(true);
				}
			}
		}
		if(numOfInputActive==1){
			for(int i=0;i<out.length;i++){
				if(out[i]!=null){
										//dodato
					if(out[i].isBool())out[i].setBoolVal(in[activeInput].getBoolVal());
					
					else out[i].setIntVal(in[activeInput].getIntVal());
				}
			}
		}
	}

	public String getName() {
		return name;
	}
}
