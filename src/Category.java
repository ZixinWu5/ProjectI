
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

public class Category
{
	//variable store category name
	private String name;

	public static final Category FRUIT = new Category("fruit");
	public static final Category ZOOTOPIA = new Category("zootopia");
	public static final Category DAILY = new Category("daily");

	//constructor save name
	public Category(String name)
	{
		this.name = name;
	}

	//return name, getter method
	public String getName()
	{
		return name;
	}

	//
	@Override
	public String toString()
	{
		return name;
	}

}
