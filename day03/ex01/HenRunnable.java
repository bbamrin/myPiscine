public class HenRunnable implements Runnable{
	private TruthStore store;
	private Integer amount;

	public HenRunnable(TruthStore store, Integer amount)
	{
		this.amount = amount;
		this.store = store;
	}

	@Override
	public void run() {
		for (int i = 0; i < amount; ++i) {
			this.store.consumeTruth("Hen");
		}
	}
}
