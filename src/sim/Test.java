package sim;

import sim.components.LogicalComponent;

public class Test {

	public static void main(String[] args) {
		Configurator config = new Configurator("test.conf");
		Debugger debug = new Debugger(config, "debug.txt");
		LogicalComponent.initialise();
		debug.debug();
		LogicalComponent.CLK();
		debug.debug();
		LogicalComponent.CLK();
		debug.debug();
		LogicalComponent.CLK();
		debug.debug();
	}
}
