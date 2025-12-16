
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

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PhotoQuestion extends Question
{
	private final String imagePath;

	public PhotoQuestion(String answer, String imagePath)
	{
		super("What do you think the name of the animal?", answer);
		this.imagePath = imagePath;
	}

	@Override
	public Image getImage()
	{
		try
		{
			return ImageIO.read(getClass().getResource(imagePath));
		}
		catch (IOException | IllegalArgumentException e)
		{
			return null;
		}
	}
}