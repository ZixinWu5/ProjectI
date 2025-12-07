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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI implements GameView
{
	private Game game;
	// main window
	private JFrame frame;
	// message (welcome, error information)
	private JLabel messageLabel;
	// question
	private JLabel questionLabel;
	// player put answer
	private JTextField answerField;
	// player answer question
	private JButton submitButton;
	// show scores
	private JLabel scoreLabel;
	// confirm for re do
	private JPanel confirmPanel;
	private JButton yesButton;
	private JButton noButton;
	// dialog secret mode
	private JDialog secretDialog;
	private boolean secretChoice;
	// dialog for category
	private JDialog categoryDialog;
	private JPanel categoryPanel;

	public GUI()
	{
		frame = new JFrame("Spelling Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 700);
		frame.setLayout(new BorderLayout());

		// top of the window
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// welcome message
		messageLabel = new JLabel("welcome");
		topPanel.add(messageLabel);
		frame.add(topPanel, BorderLayout.NORTH);

		// middle window
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// question
		questionLabel = new JLabel("");
		questionLabel.setFont(new Font("Questions", Font.BOLD, 25));
		centerPanel.add(questionLabel);
		frame.add(centerPanel, BorderLayout.CENTER);

		// bottom window
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		// player put the answer in
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());
		answerField = new JTextField(30);
		submitButton = new JButton("Submit");
		inputPanel.add(new JLabel("your answer:"));
		inputPanel.add(answerField);
		inputPanel.add(submitButton);
		bottomPanel.add(inputPanel, BorderLayout.CENTER);

		// score
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		scoreLabel = new JLabel("Score: 0");
		scorePanel.add(scoreLabel);
		bottomPanel.add(scorePanel, BorderLayout.SOUTH);
		frame.add(bottomPanel, BorderLayout.SOUTH);

		// confirm
		confirmPanel = new JPanel();
		yesButton = new JButton("Yes");
		noButton = new JButton("No");
		confirmPanel.add(yesButton);
		confirmPanel.add(noButton);
		frame.add(confirmPanel, BorderLayout.EAST);
		confirmPanel.setVisible(false);

		// category choose panel
		categoryDialog = new JDialog(frame, "Choose Category", true);
		categoryDialog.setSize(350, 200);
		categoryDialog.setLayout(new BorderLayout());
		categoryDialog.setLocationRelativeTo(frame);
		JLabel label = new JLabel("Choose a category:", SwingConstants.CENTER);
		categoryDialog.add(label, BorderLayout.NORTH);
		categoryPanel = new JPanel(new FlowLayout());
		categoryDialog.add(categoryPanel, BorderLayout.CENTER);

		// yes or no button for play secret mode
		secretDialog = new JDialog(frame, "Secret Mode", true);
		secretDialog.setSize(300, 150);
		secretDialog.setLayout(new BorderLayout());
		secretDialog.setLocationRelativeTo(frame);
		JLabel text = new JLabel("Secret mode unlocked. Play it?", SwingConstants.CENTER);
		secretDialog.add(text, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		JButton secretYes = new JButton("Yes");
		JButton secretNo = new JButton("No");
		buttonPanel.add(secretYes);
		buttonPanel.add(secretNo);
		secretDialog.add(buttonPanel, BorderLayout.SOUTH);
		addSecretYesListeners(secretYes);
		addSecretNoListener(secretNo);

		submitButton.addActionListener(new SubmitButtonListener(this));
		
		frame.setVisible(true);
	}  

	//secret button listener
	private void addSecretYesListeners(JButton secretYes)
	{
		secretYes.addActionListener(new SecretYesListener(this));
	}
	
	private void addSecretNoListener(JButton secretNo)
	{
		secretNo.addActionListener(new SecretNoListener(this));
	}
	
	//handle submit listener
	private void handleSubmitButton()
	{
		String answer = answerField.getText();
		if(game!= null)
		{
			game.answerSubmit(answer);
		}
	}
	
	public void setGame(Game game)
	{
		this.game = game;
	}

	// welcome message show up
	@Override
	public void showWelcomeMessage()
	{
		messageLabel.setText("Welcome to the Spelling game");
	}

	// let player put their name
	@Override
	public void askPlayerName()
	{
		String name = JOptionPane.showInputDialog(frame, "enter your name: ");
		if (game != null)
		{
			game.playerName(name);
		}
	}
	
	// time up hide question
	@Override
	public void hideQuestion()
	{
		questionLabel.setText("");
		questionLabel.setIcon(null);
	}

	@Override
	public void showQuestion(Question question)
	{
		if (question.isPhoto())
		{
			questionLabel.setIcon(question.getImage());
			questionLabel.setText("");
		}
		else
		{
			questionLabel.setIcon(null);
			questionLabel.setText(question.getPrompt());
		}
	}

	// if time not up player cannot input answer
	@Override
	public void disableAnswerInput()   
	{
		answerField.setEnabled(false);
		submitButton.setEnabled(false);
	}

	// time up, player could put answer down
	@Override
	public void allowAnswerInput()
	{
		answerField.setEnabled(true);
		submitButton.setEnabled(true);
		answerField.requestFocusInWindow();
	}

	@Override
	// update score
	public void updateScore(ScoreBoard scoreBoard)
	{
		int score = scoreBoard.getScore();
		int correct = scoreBoard.getCorrectCount();
		int incorrect = scoreBoard.getIncorrectCount();

		String text = "Score: " + score + "  Correct: " + correct + "  Incorrect: " + incorrect;
		scoreLabel.setText(text);
	}

	@Override
	// check if player want to re do category
	public void redoCategory()
	{
		messageLabel.setText("Do you want to play this category again?");
		confirmPanel.setVisible(true);
	}

	@Override
	// player choose one category
	public void askForCategorySelection(List<Category> remaining)
	{
		categoryPanel.removeAll();

		if (remaining.contains(Category.FRUIT))
		{
			makeButton(Category.FRUIT);
		}
		if (remaining.contains(Category.Zootopia))
		{
			makeButton(Category.Zootopia);
		}
		if (remaining.contains(Category.DAILY))
		{
			makeButton(Category.DAILY);
		}

		categoryDialog.pack();
		categoryDialog.setVisible(true);
	}

	private void makeButton(Category category)
	{
		JButton button = new JButton(category.toString());
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				categoryDialog.setVisible(false);
				if (game != null)
				{
					game.categoryChosen(category);
				}
			}
		});
		categoryPanel.add(button);
	}

	@Override
	// if something wrong show message
	public void showErrorMessage(String message)
	{
		messageLabel.setText(message);
		JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	// summary for player when one round end
	public void showRoundSummary(RoundResult result)
	{
		String m = "Player: " + result.getPlayerName() + "  Category: " + result.getCategory()+ "  Correct: " + result.getCorrect()+ "  Incorrect: " + result.getIncorrect()+ "  Score: " + result.getFinalScore();
		messageLabel.setText("Round end");
		JOptionPane.showMessageDialog(frame, m, "Round summary", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	// dialog yes or no button for player choose open secret mode or not
	public boolean askPlaySecretMode()
	{
		secretChoice = false;
		secretDialog.setVisible(true);
		return secretChoice;
	}

	public void showQuestionT(Question question)
	{
		questionLabel.setIcon(null);
		questionLabel.setText(question.getPrompt());
	}

	@Override
	// player finished, and good bye them
	public void showEndMessage(String playerName)
	{
		String end = "GoodBye " + playerName;
		messageLabel.setText(end);
		JOptionPane.showMessageDialog(frame, end, "GoodBye", JOptionPane.INFORMATION_MESSAGE);
	}
}