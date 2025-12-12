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

public abstract class GameMode
{
	public abstract boolean isScored();
	
	public abstract List<Question> buildRound(Category category, WordBank wordbank, int questionCount);
}
