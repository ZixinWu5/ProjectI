import java.awt.Image;

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

public class Question
{
	// question player could see
	private final String prompt;
	// correct answer for question
	private final String answer;

	/**
	 * Purpose: constructor a question with a prompt and a correct answer
	 * 
	 * @param prompt
	 * @param answer
	 */
	public Question(String prompt, String answer)
	{
		this.prompt = prompt;
		this.answer = answer;
	}

	// return question
	public String getPrompt()
	{
		return prompt;
	}

	// return correct answer
	public String getAnswer()
	{
		return answer;
	}

	// check if player answer is right
	public boolean checkAnswer(String playerAnswer)
	{
		// if empty, return false
		if (playerAnswer == null)
		{
			return false;
		}
		if (playerAnswer.isEmpty())
		{
			return false;
		}
		//just in case if player put answer as capital
		String a = playerAnswer.trim().toLowerCase();
		String b = answer.trim().toLowerCase();
		return a.equals(b);
	}

}