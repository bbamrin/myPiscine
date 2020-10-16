
public class User {
	private Integer identifier;
	private String  name;
	private Integer balance;

	public User(String name, Integer balance)
	{
		this.identifier = identifier;
		this.setBalance(balance);
		this.name = name;
		this.identifier = UserIdsGenerator.getInstance().generateId();
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		if (balance >= 0)
			this.balance = balance;
	}
}
