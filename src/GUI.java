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


import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public interface GUI implements GameView
{
	private Game game;
	//main window
	private JFrame frame;
	
	//message(welcome, error information)
	private JLabel messageLabel;
	
	//question
	private JLabel questionLabel;
	//player put answer 
	private JTextField answerField;
	//player answer question
	private JButton submitButton;
	
	//show scores
	private JLabel scoreLabel;
	
	//confirm for re do
	private JPanel confirmPanel;
	private JButton yesButton;
	private JButton noButton;
	
	//dialog secret mode
	private JDialog secretDialog;
	private boolean secretChoice;
	
	//dialog for category
	private JDialog categoryDialog;
	private JDialog categoryPanel;
	
	public GUI()
	{
		frame = new JFrame("Speeling Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,700);
		frame.setLayout(new BorderLayout());
		
		//top of the window
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		//welcome message
		messageLabel = new JLabel("welcome");
		topPanel.add(messageLabel);
		frame.add(topPanel,BorderLayout.NORTH);
		
		//middle window
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		//question
		questionLabel = new JLabel("");
		questionLabel.setFont(new Font("Questions", Font.BOLD,25));
		centerPanel.add(questionLabel);
		frame.add(centerPanel, BorderLayout.CENTER);
		
		//bottom window
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		//player put the answer in 
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());
		answerField = new JTextField(30);
		submitButton = new JButton("Submit");
		inputPanel.add(new JLabel("your answer:"));
		inputPanel.add(answerField);
		inputPanel.add(submitButton);
		bottomPanel.add(inputPanel, BorderLayout.CENTER);

		//score
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.add(scoreLabel);
		bottomPanel.add(scorePanel, BorderLayout.SOUTH);
		frame.add(scorePanel,BorderLayout.SOUTH);
		
		//confirm
		confirmPanel = new JPanel();
		yesButton = new JButton("Yes");
		noButton = new JButton("No");
		confirmPanel.add(yesButton);
		confirmPanel.add(noButton);
		frame.add(confirmPanel, BorderLayout.EAST);
		confirmPanel.setVisible(false);
		
		//category choose panel
		JDialog dialog = new JDialog(frame, "Choose Category", true);
		dialog.setSize(350,200);
		dialog.setLayout(new BorderLayout());
		dialog.setLocationRelativeTo(frame);
		JLabel label = new JLabel("Choose a category:", SwingConstants.CENTER);
		dialog.add(label, BorderLayout.NORTH);
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		dialog.add(p,BorderLayout.CENTER);
		frame.setVisible(true);
		
		//yes or no button for play secret mode
		JDialog secrectButtonPanel = new JDialog(frame, "Secret Mode", true);
		secrectButtonPanel.setSize(300,150);
		secrectButtonPanel.setLayout(new BorderLayout());
		secrectButtonPanel.setLocationRelativeTo(frame);
	    JLabel text = new JLabel("Secret mode unlocked. Play it?", SwingConstants.CENTER);
	    secrectButtonPanel.add(text, BorderLayout.CENTER);
	    JPanel secrectButtonPanel1 = new JPanel();
	    JButton secretYes = new JButton("Yes");
	    JButton secretNo = new JButton("No");
	    p.add(secretYes);
	    p.add(secretNo);
	    secrectButtonPanel1.add(p,BorderLayout.NORTH);
	    secrectButtonPanel1.setVisible(true);
	}
	
		public void setGame(Game game)
		{
			this.game = game;
		}
		
		//welcome message show up 
		public void showWelcomeMessage()
		{
			messageLabel.setText("Welcome to the Spelling game");
		}
		
		//let player put their name
		public void askPlayerName()
		{
			String name = JOptionPane.showInputDialog(frame, "enter your name: ");
			if(game != null)
			{
				game.playerName(name);
			}
		}
		
		//time up hide question
		public void hideQuestion()
		{
			questionLabel.setText("");
		}
		
		//if time not up player cannot input answer
		public void disableAnswerInput()
		{
			answerField.setEnabled(false);
			submitButton.setEnabled(false);
		}
		
		//time up, player could put answer down
		public void enableAnswerInput()
		{
			answerField.setEnabled(true);
			submitButton.setEnabled(true);
			answerField.requestFocusInWindow();
		}
		
		//update score
		public void updateScore(ScoreBoard scoreBoard)
		{
			int score = scoreBoard.getScore();
			int correct = scoreBoard.getCorrectCount();
			int incorrect = scoreBoard.getIncorrectCount();
			
			String text = "Score" + score +"Correct: "+ correct +"incorrect: "+ incorrect;
			scoreLabel.setText(text);
		}
		
		//check if player want to re do category
		public boolean conformRedoCategory()
		{
			messageLabel.setText("Do you want to play this category again?");
			confirmPanel.setVisible(true);
		}
		
		//JDialog show up, player choose one category
		public void askForCategorySelection(List<Category> remaining)
		{
			categoryDialog.removeAll();
			if (remaining.contains(Category.FRUIT))
			{
		        makeButton(Category.FRUIT);
			}

		    if (remaining.contains(Category.ANIMAL))
		    {
		        makeButton(Category.ANIMAL);
		    }

		    if (remaining.contains(Category.DAILY))
		    {
		        makeButton(Category.DAILY);
		    }
		    
		    categoryDialog.pack();
		    categoryDialog.setVisible(true);

		}
		
		//if something wrong show messgae
		public void showErrorMessage(String message)
		{
			messageLabel.setText(message);
			JOptionPane.showMessageDialog(frame,  message, "Error",JOptionPane.INFORMATION_MESSAGE);
		}
		
		//summary for player when one round end
		public void showRoundSummary(RoundResult result)
		{
			String m = "Player " + result.getPlayerName() + "Category " + result.getCategory()+ "correct: "+ result.getCorrect() + "incorrect: "+ result,getIncorrect() + "Score: "+ result.getFinalScore();
			
			messageLabel.setText("Round end");
			JOptionPane.showMessageDialog(frame, m, "Round summary" , JOptionPane.INFORMATION_MESSAGE);
		}
		
		//dialog yes or no button for player choose open secret mode or not
		public boolean askPlaySecretMode()
		{
			secretChoice = false;
			secretDialog.setVisible(true);
			return secretChoice;
		}
		
		//show the question
		public void showQuestion(Question question)
		{
			questionLabel.setText(question.getPrompt());
		}
		
		//player finished, and good bye them
		public void showEndMessage(String playerName)
		{
			String end = "GoodBye"+playerName;
			messageLabel.setText(end);
			JOptionPane.showMessageDialog(frame,  end, "GoodBye", JOptionPane.INFORMATION_MESSAGE);
		}
}
