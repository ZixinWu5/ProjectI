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
import java.net.URL;

public class PhotoQuestion extends Question
{
	private String imagePath;

	public PhotoQuestion(String answer, String imagePath)
	{
		super("What do you think the name of the animal?", answer);
		this.imagePath = imagePath;
	}
	
	public boolean isPhoto()
	{
		return true;
	}
	
	@Override
	public ImageIcon getImageIcon()
	{
		URL url = getClass().getResource("/" + imagePath);
		if(url == null)
		{
			System.out.println("image not found"+ imagePath);
			return null;
		}
		return new ImageIcon(url);
	}
}
