public class SumRunnable implements Runnable{
	private Integer start;
	private Integer end;
	private SumContainer sumContainer;
	private Integer[] array;
	private Integer number;

	public SumRunnable(Integer start, Integer end, SumContainer sumContainer, Integer[] array, Integer number)
	{
		this.number = number;
		this.start = start;
		this.end = end;
		this.sumContainer = sumContainer;
		this.array = array;
	}
	@Override
	public void run() {
		Integer pieceSum;

		pieceSum = 0;
		for (int i = this.start; i <= this.end; ++i)
			pieceSum += array[i];
		System.out.printf("Thread %d: from %d to %d sum is %d\n", this.number + 1, this.start, this.end, pieceSum);
		this.sumContainer.setSum(this.sumContainer.getSum() + pieceSum);
	}
}
