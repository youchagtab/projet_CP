package dao;

import java.util.List;

import beans.UserStory;

public interface IUserStoryDAO 
{
	public void ajouter(UserStory userStory);
	public UserStory recupererUserStory(int id);
	public List<UserStory> lister(int idProjet);
	public List<UserStory> listerParSprint(int idSprint);
	public void supprimer(int id);
	public void modifier(UserStory userStory);
}
