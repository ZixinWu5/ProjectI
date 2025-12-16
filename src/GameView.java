
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

public interface GameView
{
	// welcome message showed up when game start
	void showWelcomeMessage();

	// ask player name
	void askPlayerName();

	// hide question when timed up
	void hideQuestion();

	// when prompt need to be out
	void showQuestion(Question question);

	// if time not count down, player not allow put answer in
	void disableAnswerInput();

	// allow player to input answer
	void allowAnswerInput();

	// update scores
	void updateScore(ScoreBoard scoreBoard);

	// ask player if they want to re-do this category
	void redoCategory();

	// in the unselected category, ask player to choose one
	void askForCategorySelection(List<Category> remaining);

	// when file not saving correctly, or wrong input
	void showErrorMessage(String message);

	// contain player name, category, correct questions, wrong questions, total
	// scores
	void showRoundSummary(RoundResult result);

	// if secret mode unlocked, ask player if they want to play it
	boolean askPlaySecretMode();

	// when player choose not to play secret mode or unlocked secret mode but 3
	// categories are already played 1 time
	void showEndMessage(String playerName);
}