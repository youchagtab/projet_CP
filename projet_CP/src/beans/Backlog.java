package beans;

import java.util.List;

public class Backlog 
{
	protected List<UserStory> _usersStories ;

	public List<UserStory> getUsersStories() {
		return _usersStories;
	}
	
	public List<UserStory> ajouterUserStory(UserStory userStory)
	{
		_usersStories.add(userStory);
		return _usersStories;
	}

	public void setUsersStories(List<UserStory> usersStories) {
		_usersStories = usersStories;
	}
}
