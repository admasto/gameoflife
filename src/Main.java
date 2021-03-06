public class Main {

	public static void main(String[] args) {

		//Config config = new Config();
		
		Rule[] rules = { new RPopulation() };

		SimulationEngine engine = new SimulationEngine(
				SimulationEngine.EdgeMode.BORDERED, rules, 24, 36);

		engine.setCellAtTo(11, 12, Cell.State.ALIVE);
		engine.setCellAtTo(12, 12, Cell.State.ALIVE);
		engine.setCellAtTo(13, 12, Cell.State.ALIVE);

		ifGUI gui = new SwingGUI(engine.getCells(), 600, 600);
		//ifGUI gui = new ConsoleGUI();

		long lastTime;
		long lastDelta;

		while (true) {
			lastTime = System.currentTimeMillis();
			engine.tick();
			gui.displayArray(engine.getCells());
			lastDelta = System.currentTimeMillis() - lastTime;
			try {
				Thread.sleep(Math.max(0, 300 - lastDelta));
			} catch (InterruptedException e) {
				// Sleep interrupted
			}
		}

	}

}
