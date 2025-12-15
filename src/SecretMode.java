/**
 * Lead Author(s):
 *
 * @author 5550129061; zixin wu
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * version 1
 */

import java.util.List;

import java.util.ArrayList;

public class SecretMode extends GameMode
{
	//don't count point in secret mode
	public boolean isScored()
	{
		return false;
	}
	
	public List<Question> buildRound(Category category, WordBank wordBank, int count)
	{
		//new list
		List<Question> list = new ArrayList<>();
		
		//my answers
		list.add(new PhotoQuestion("catcodile", "images/catcodile.jpg"));
		list.add(new PhotoQuestion("eaglet", "images/eaglet.jpg"));	
		list.add(new PhotoQuestion("girtle", "images/girtle.jpg"));
		list.add(new PhotoQuestion("lionguin", "images/lionguin.jpg"));
		list.add(new PhotoQuestion("snakat", "images/snakat.jpg"));
		list.add(new PhotoQuestion("tigake", "images/tigake.jpg"));
		
		return list;
	}
}
