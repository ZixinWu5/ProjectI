
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
import java.util.Random;
import java.util.ArrayList;

class StandardMode extends GameMode
{
	//count points
	@Override
	public boolean isScored()
	{
		return true;
	}
	
	public List<Question> buildRound(Category category, WordBank wordBank,
			int questionCount)
	{
		//new list and add 
		List<Question> list = new ArrayList<>();
		//take from word bank
		String[] words = wordBank.getWordsForCategory(category);
		
		//random shuffle yeah
		Random rand = new Random();
		
		//from array end to the beginning
		for (int i = words.length-1; i>0; i--)
		{
			//shuffle
			int j = rand.nextInt(i+1);
			String temp = words[i];
			words[i] = words[j];
			words[j] = temp;
		}
		
		//10 time loop
		for(int i = 0; i < questionCount; i++)
		{
			//take i words from w
			String w = words[i];
			//and add to the list and show question w, and answer a
			//variable had declare at question before
			list.add(new Question("spell " + w,w));
		}
		
		return list;
	}
}
