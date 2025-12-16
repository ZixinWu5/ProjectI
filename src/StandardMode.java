
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

class StandardMode extends GameMode
{
	@Override
	public boolean isScored()
	{
		return true;
	}

	public List<Question> buildRound(Category category, WordBank wordBank,
			int questionCount)
	{
		List<Question> list = new ArrayList<>();
		List<String> words = wordBank.getWordsForCategory(category);
		for (int i = 0; i < questionCount; i++)
		{
			String w = words.get(i);
			list.add(new Question("spell " + w, w));
		}
		return list;
	}
}
