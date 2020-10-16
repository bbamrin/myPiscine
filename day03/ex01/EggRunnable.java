public class EggRunnable implements Runnable{
	private TruthStore store;
	private Integer amount;

	public EggRunnable(TruthStore truthStore, Integer amount)
	{
		this.store = truthStore;
		this.amount = amount;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.amount; ++i) {
			this.store.produceTruth("Egg");
		}
	}
}
