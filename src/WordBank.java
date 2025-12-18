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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//place we read the word form file
public class WordBank
{
	public String[] getWordsForCategory(Category category)
	{
		//declare list, so we could store the words from file
		List<String> list;

		//determine category correct or not
		if (category == Category.FRUIT)
		{
			list = loadWordsFromFile("src/fruit.txt");
		}
		else if (category == Category.DAILY)
		{
			list = loadWordsFromFile("src/daily.txt");
		}
		else if (category == Category.ZOOTOPIA)
		{
			list = loadWordsFromFile("src/zootopia.txt");
		}
		else
		{
			//if none of them, return empty list
			return new String[0];
		}
		//change list to array, so I could shuffle the things after
		String[] arr = list.toArray(new String[0]);
		return arr;
	}

	private List<String> loadWordsFromFile(String fileName)
	{
		//declare a variable words to store 
		List<String> words = new ArrayList<>();

		try
		{
			//open file and read line by line 
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			//store each line variable
			String line;

			//every time read one line, until is null end loop
			while ((line = br.readLine()) != null)
			{
				//delete the extra empty space from read file
				line = line.trim();
				//ignore the empty space
				if (!line.isEmpty())
				{
					//add word to list
					words.add(line);
				}
			}
			//close is important
			br.close();
		}
		//just in case if something went wrong that cannot read from file
		catch (IOException e)
		{
			System.out.println("cannot load words: " + e.getMessage());
		}
		//return words 
		return words;
	}
}