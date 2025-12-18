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

public class RoundResult
{
	//declare variable for name, category, correct, incorrect, and final score
	private final String playerName;
	private final Category category;
	private final int correct;
	private final int incorrect;
	private final int finalScore;

	//constructor
	public RoundResult(String playerName, Category category, int correct, int incorrect, int finalScore)
	{
		this.playerName = playerName;
		this.category = category;
		this.correct = correct;
		this.incorrect = incorrect;
		this.finalScore = finalScore;
	}

	// return player name
	public String getPlayerName()
	{
		return playerName;
	}

	// return category choose
	public Category getCategory()
	{
		return category;
	}

	// get number score right answer in that round
	public int getCorrect()
	{
		return correct;
	}

	// get number of score incorrect answer in that round
	public int getIncorrect()
	{
		return incorrect;
	}

	// get final score
	public int getFinalScore()
	{
		return finalScore;
	}

	// show a summary
	@Override
	public String toString()
	{
		return playerName + "category:" + category + "correct: " + correct + "incorrect: " + incorrect + "finalScore: " + finalScore;
	}
}
