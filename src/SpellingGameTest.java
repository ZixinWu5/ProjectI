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

public class SpellingGameTest
{
    public static void main(String[] args)
    {

        GUI gui = new GUI();

        WordBank wordBank = new WordBank();
        ScoreBoard scoreBoard = new ScoreBoard();

        List<Category> allCategories = new ArrayList<>();
        allCategories.add(Category.FRUIT);
        allCategories.add(Category.Zootopia);
        allCategories.add(Category.DAILY);

        Tracker tracker = new Tracker(3, allCategories);

        GameMode standardMode = new StandardMode();
        GameMode secretMode = new SecretMode();
        QuestionTimer timer = new QuestionTimer();

        Game game = new Game(gui, wordBank, scoreBoard, tracker, standardMode, secretMode, timer);

        gui.setGame(game);

        game.start();
    }
}