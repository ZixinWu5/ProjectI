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

import java.util.ArrayList;
import java.util.List;


public class Tracker
{
	// three categories (animal / fruit / daily) - or more
	private final List<Category> allCategories;
	// categories already completed
	private final List<Category> completed;
	// how many categories to unlock secret mode
	private final int requiredCount;
	// check if unlocked secret mode
	private boolean secretUnlocked;
	// save result
	private final List<RoundResult> history;
	public Tracker(int requiredCount, List<Category> allCategories)
	{
		this.requiredCount = requiredCount;
		// copy all categories list
		this.allCategories = new ArrayList<>(allCategories);
		this.completed = new ArrayList<>();
		this.history = new ArrayList<>();
		this.secretUnlocked = false;
	}
	// save round result
	public void recordRoundResult(RoundResult result)
	{
		history.add(result);
		Category c = result.getCategory();
		// if category not recorded yet, add to completed
		if (!completed.contains(c))
		{
			completed.add(c);
		}
		// unlock secret mode when enough categories are completed
		if (completed.size() >= requiredCount)
		{
			secretUnlocked = true;
		}
	}
	// check if all required categories are completed
	public boolean allRequiredCategoriesCompleted()
	{
		return completed.size() >= requiredCount;
	}
	// return remaining categories that are not completed yet
	public List<Category> getRemainingCategories()
	{
		List<Category> remaining = new ArrayList<>(allCategories);
		remaining.removeAll(completed);
		return remaining;
	}
	// secret mode unlocked or not
	public boolean isSecretModeUnlocked()
	{
		return secretUnlocked;
	}
}


