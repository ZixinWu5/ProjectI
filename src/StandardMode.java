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
import java.util.Random;
import java.util.ArrayList;

class StandardMode extends GameMode
{	
	@Override
	public boolean isScored()
	{
		return true;
	}
	
	public List<Question> buildRound(Category category, WordBank wordBank, int questionCount)
	{
		List<Question> list = new ArrayList<>();
		List<String> words = wordBank.getWordsForCategory(category);
		
		Random random = new Random();
		int count = Math.min(questionCount, words.size());
		for(int i = 0; i < count ; i++)
		{
			int index = random.nextInt(words.size());
			String w = words.get(index);
			list.add(new Question("spell: "+ w,w));
			words.remove(index);
		}
		return list;
	}
}

