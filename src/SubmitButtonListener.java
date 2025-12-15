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

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class SubmitButtonListener implements ActionListener
{
	private final GUI gui;
	
	public SubmitButtonListener(GUI gui)
	{
		this.gui = gui;
	}
	public void actionPerformed(ActionEvent e)
	{
		gui.handleSubmitButton();
	}
}
