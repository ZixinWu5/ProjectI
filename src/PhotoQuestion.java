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

import javax.swing.ImageIcon;

public class PhotoQuestion extends Question
{
	private ImageIcon image;

	public PhotoQuestion(String answer, String imagePath)
	{
		super("What do you think the name of the animal?", answer);
		this.image = new ImageIcon(imagePath);
	}
	
	public boolean isPhoto()
	{
		return true;
	}
	
	public ImageIcon getImage()
	{
		return image;
	}
	
}
