public class BackgroundRunnable implements Runnable{

	private String toPrint;
	private Integer count;

	public BackgroundRunnable(String toPrint, Integer count)
	{
		this.count = count;
		this.toPrint = toPrint;
	}


	@Override
	public void run() {
		while (this.count-- > 0)
			System.out.println(toPrint);
	}
}
