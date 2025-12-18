
/**
 * Lead Author(s):
 *
 * @author 5550129061; zixin wu
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *         version 1
 */

import java.util.List;

import java.util.ArrayList;

public class SecretMode extends GameMode
{
	// don't count point in secret mode
	public boolean isScored()
	{
		return false;
	}

	public List<Question> buildRound(Category category, WordBank wordBank,
			int count)
	{
		//make list and add question and answers in
		List<Question> list = new ArrayList<>();
		list.add(new Question( "Q1: What is the animal call when cat + crocodile together?", "catcodile"));
		list.add(new Question( "Q2: What is the animal call when eagle + rabbit together?", "eaglet"));
		list.add(new Question( "Q3: What is the animal call when giraffe + Tortoise together?", "girtle"));
		list.add(new Question( "Q4: What is the animal call when lion + penguin together?", "lionguin"));
		list.add(new Question( "Q5: What is the animal call when snake + cat together?", "snaket"));
		list.add(new Question( "Q6: What is the animal call when togeer + snake together?", "togake"));
		
		//return it
		return list;
	}
}
