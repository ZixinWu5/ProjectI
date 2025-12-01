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

public class ScoreBoard
{
    private int correctCount;
    private int incorrectCount;

    //initial to 0 
    public ScoreBoard()
    {
        correctCount = 0;
        incorrectCount = 0;
    }

    //one is right 
    public void addCorrect()
    {
        correctCount++;
    }

    //one is wrong 
    public void addIncorrect()
    {
        incorrectCount++;
    }

    //how many is right
    public int getCorrectCount()
    {
        return correctCount;
    }

    //how many is wrong
    public int getIncorrectCount()
    {
        return incorrectCount;
    }

    //score = (1* correct) + (-2+ incorrect)
    public int getScore()
    {
        return correctCount - (incorrectCount *2);  
    }

    //reset count
    public void reset()
    {
        correctCount = 0;
        incorrectCount = 0;
    }
}