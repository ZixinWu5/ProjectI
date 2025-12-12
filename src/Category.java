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
import java.util.Random;

public class Category
{
	private String name;
	private static String[] words;
	public static Category Zootopia;
	
	public static final Category FRUIT = new Category("fruit", words);
	public static final Category ZOOTOPIA = new Category("zootopia",words);
	public static final Category DAILY = new Category("daily",words);
	
	public Category(String name, String[] words)
	{
		this.name = name;
		this.words = words;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	public List<Question> questions(int count)
	{
		////list store question object
		ArrayList<Question> list = new ArrayList<>();
		//walk through word
		for(int i = 0; i <words.length; i++)
		{
			//take word
			String w = words[i];
			//prompt 
			list.add(new Question("spell:"+w,w));
		}
		
		//make random selection from word bank
		Random a = new Random();
		//go through words i = size -1, go to front, exchange i and random j
		for(int i = list.size()-1; i>0; i--)
		{
			//next(i+1) give a random number between 0-i
			int j = a.nextInt(i+1);
			//exchange by store to variable temp and assign
			Question temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
		//new array list
		ArrayList<Question> result = new ArrayList<>();
		//limit to 10 questions count, and the size of the list 
		for(int i =0; i < count && i < list.size(); i++)
		{
			//take list.get(i) and put it in result
			result.add(list.get(i));
		}
		//random question list
		return result;
	}
}
