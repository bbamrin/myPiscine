
public class TruthStore {
	private Integer amountOfTruthAvailable = 0;

	public synchronized void produceTruth(String truth)
	{
		while (amountOfTruthAvailable >= 1)
		{
			try{
				wait();
			}
			catch (InterruptedException e)
			{

			}
		}
		amountOfTruthAvailable++;
		System.out.println(truth);
		notify();
	}

	public synchronized void consumeTruth(String truth)
	{
		while (amountOfTruthAvailable < 1)
		{
			try{
				wait();
			}
			catch (InterruptedException e)
			{

			}
		}
		amountOfTruthAvailable--;
		System.out.println(truth);
		notify();
	}
}
