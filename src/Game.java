import java.util.ArrayList;
import java.util.List;
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

//main controller class
//connect the game view, word bank, word bank, question, question timer, score board, tracker, game mode
public class Game
{
    //game has a game view
    private final GameView view;
    //game has a word bank
    private final WordBank wordBank;
    //game has a score board
    private final ScoreBoard scoreBoard;
    //game has a tracker
    private final Tracker tracker;
    //game has a standard mode
    private final GameMode standardMode;
    //game has a secret mode
    private final GameMode secretMode;
    //game has a timer for question
    private final QuestionTimer timer;

    //game has a player name
    private String playerName;
    //game has a category for play
    private Category currentCategory;
    //game has a list of questions for round
    private List<Question> currentQuestions;
    //game has an index tell which question player is on
    private int currentIndex;
    //game has a history list contain all past round results
    private final List<RoundResult> history;

    //standard mode has 10 questions each round
    public static final int standardModeQuestions = 10;
    //secret mode has 6 questions each round
    public static final int secretModeQuestions = 6;
    //time, 4 seconds show question
    public static final int questionTimer = 4 * 1000;

    //constructor
    public Game(GameView view, WordBank wordBank, ScoreBoard scoreBoard, Tracker tracker, GameMode standardMode,
                GameMode secretMode, QuestionTimer timer)
    {
        this.view = view;
        this.wordBank = wordBank;
        this.scoreBoard = scoreBoard;
        this.tracker = tracker;
        this.standardMode = standardMode;
        this.secretMode = secretMode;
        this.timer = timer;
        this.history = new ArrayList<>();
    }

    //show welcome message and ask name
    public void start()
    {
        view.showWelcomeMessage();
        view.askPlayerName();
    }

    //use the player name after they typed it
    public void playerName(String name)
    {
        if (name == null)
        {
            this.playerName = "";
            return;
        }
        int start = 0;
        for (int i = 0; i < name.length(); i++)
        {
            if (name.charAt(i) != ' ')
            {
                start = i;
                break;
            }
        }
        
        int end = name.length() - 1;
        for (int i = name.length() - 1; i >= 0; i--)
        {
            if (name.charAt(i) != ' ')
            {
                end = i;
                break;
            }
        }
        this.playerName = name.substring(start, end + 1);
    }

    //call when player choose category
    public void categoryChosen(Category category)
    {
        this.currentCategory = category;
        startStandardRoundForCurrentCategory();
    }

    //called when timer time is up for a question
    public void questionTimeUp()
    {
        view.hideQuestion();
        view.enableAnswerInput();
    }

    //called when player submit answer
    public void answerSubmit(String answer)
    {
        //if question not ready or index over limit, return
        if (currentQuestions == null || currentIndex >= currentQuestions.size())
        {
            return;
        }

        //take out question
        Question question = currentQuestions.get(currentIndex);
        //check if it is right
        boolean correct = question.checkAnswer(answer);

        //if this mode has score, update score
        if (standardMode.isScored())
        {
            if (correct)
            {
                scoreBoard.addCorrect();
            }
            else
            {
                scoreBoard.addIncorrect();
            }
        }

        //update points on view
        view.updateScore(scoreBoard);

        //next question index
        currentIndex++;

        //if have question then next, none then end
        if (currentIndex < currentQuestions.size())
        {
            showNextQuestion();
        }
        else
        {
        	finishRound();
        }
    }

    //call when player press quit 
    public void quit()
    {
    	view.redoCategory();
    }

    //if player say no re do then next category, if say yes then re do category
    public void redoCategoryChoose(boolean redo)
    {
    	if(redo)
    	{
    		startStandardRoundForCurrentCategory();
    	}
    	else
    	{
    		askForNextCategory();
    	}
    }
    //choose next category or move to secret mode
    private void askForNextCategory()
    {
    	//if required categories all done, check secret mode
    	if (tracker.allRequiredCategoriesCompleted())
        {
            checkAndOpenSecretMode();
            return;
        }
        //or choose one from uncompleted ones
        List<Category> remaining = tracker.getRemainingCategories();
        view.askForCategorySelection(remaining);
    }

    //start standard mode round
    private void startStandardRoundForCurrentCategory()
    {
        //reset score
        scoreBoard.reset();

        //standard mode choose questions from word bank
        currentQuestions = standardMode.buildRound(currentCategory, wordBank, standardModeQuestions);
        //start with first question
        currentIndex = 0;
        //show first question
        showNextQuestion();
    }

    private void showNextQuestion()
    {
        // take question
        Question question = currentQuestions.get(currentIndex);

        // show question
        view.showQuestion(question);

        // when time is running, disable input
        view.allowAnswerInput();

        // task run after 4 seconds timer
        timer.start(questionTimer, new Runnable()
        {
        	@Override
            public void run()
            {
                questionTimeUp();
            }
        });
    }

    //save record, check result
    private void finishRound()
    {
        //ask score board how many question right
        int correct = scoreBoard.getCorrectCount();
        //ask score board how many question wrong
        int incorrect = scoreBoard.getIncorrectCount();
        //ask score board total point
        int finalScore = scoreBoard.getScore();

        //we could use following to save to history, and file
        RoundResult result = new RoundResult(playerName, currentCategory, correct, incorrect, finalScore);
        //save records
        history.add(result);
        //check if category done
        tracker.recordRoundResult(result);

        //just in case if not authorize, file not exist
        try
        {
            standardMode.saveRoundResult(result);
        }
        //if during save have wrong, show the error message
        catch (Exception e)
        {
            view.showErrorMessage("cannot save round result" + e.getMessage());
        }

        //tell game view the round result
        view.showRoundSummary(result);

        //ask tracker if secret mode can be unlocked
        if (tracker.isSecretModeUnlocked())
        {
            checkAndOpenSecretMode();
        }
        else
        {
            //if not, let player choose another category
            askForNextCategory();
        }
    }

    //finish the round, save record, check result
    private void checkAndOpenSecretMode()
    {
        // if secret mode is not unlocked, end the game
        if (!tracker.isSecretModeUnlocked())
        {
            view.showEndMessage(playerName);
            return;
        }

        // ask the player if they want to play secret mode
        boolean playSecret = view.askPlaySecretMode();

        if (playSecret)
        {
            //if yes, then start
            startSecretModeRound();
        }
        else
        {
            //if not, end game
            view.showEndMessage(playerName);
        }
    }

    //start secret mode round
    private void startSecretModeRound()
    {
        //reset point in secret mode
        scoreBoard.reset();
        //take question from word bank using secret mode
        currentQuestions = secretMode.buildRound(currentCategory, wordBank, secretModeQuestions);
        //start first question
        currentIndex = 0;
        //show first question
        showNextQuestion();
    }

    //return a read only copy of record
    public List<RoundResult> getHistory()
    {
        return List.copyOf(history);
    }
}