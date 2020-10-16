
public class UserIdsGenerator {
	private static Integer lastId;
	private static UserIdsGenerator instance;

	private UserIdsGenerator()
	{
		lastId = -1;
	}

	public Integer generateId()
	{
		return ++lastId;
	}

	public static UserIdsGenerator getInstance()
	{
		if (instance == null)
			instance = new UserIdsGenerator();
		return instance;
	}
}
