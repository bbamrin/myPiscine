package com.company;

public class UsersArrayList implements UserList {
	private User[] userArray;
	private Integer initArraySize;
	private Integer lastUserIndex;

	public UsersArrayList()
	{
		initArraySize = 10;
		lastUserIndex = -1;
		userArray = new User[initArraySize];
	}

	@Override
	public void addUser(User user) {
		if (this.userArray.length == lastUserIndex + 1)
		{
			int i = -1;
			User[] tmpArr = new User[this.userArray.length + this.userArray.length / 2];
			while (++i < this.userArray.length)
				tmpArr[i] = this.userArray[i];
			this.userArray = tmpArr;
		}
		this.userArray[lastUserIndex + 1] = user;
		lastUserIndex += 1;
	}

	@Override
	public User getUserById(Integer id) {
		int i = -1;

		while (++i <= lastUserIndex)
		{
			if (this.userArray[i].getIdentifier() == id)
				return this.userArray[i];
		}
		throw new UserNotFoundException("User with given id is not found");
	}

	@Override
	public User getUserByIndex(Integer index) {
		return this.userArray[index];
	}

	@Override
	public Integer getUserNumber() {
		return this.lastUserIndex + 1;
	}
}
