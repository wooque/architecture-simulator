package sim;

import sim.components.LogicalComponent;

public class Test {

	public static void main(String[] args) {
		Configurator config = new Configurator("test.conf");
		Debuger debug = new Debuger(config, "debug.txt");
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
