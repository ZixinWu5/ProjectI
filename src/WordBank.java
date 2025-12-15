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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordBank
{
	//i feel something is wrong here, why it need to throw exception here(?), otherwise will turn red
	public List<String> getWordsForCategory(Category category)
	{
		try {
		//if category fruit, then read fruit file, and get words from there
		if(category == Category.FRUIT)
		{
			return loadWordsFromFile("src/fruit.txt");
		//if category is animal, then read from animal file, get words from it
		} else if(category == Category.Zootopia)
		{
			return loadWordsFromFile("src/zootopia.txt");
		//if category is daily, then read from daily file, get words from it
		} else if(category == Category.DAILY)
		{
			return loadWordsFromFile("src/daily.txt");
		}
		}
		catch(IOException e)
		{
			System.out.println("cannot find words: "+ e.getMessage());
		}
		//if none of them up there, end
		return new ArrayList<>();
	}
	
	private List<String> loadWordsFromFile(String fileName) throws IOException
	{
		//empty bags
		List<String> words = new ArrayList<>();
		//open file
		FileReader fr = new FileReader(fileName);
		//read it
		BufferedReader br = new BufferedReader(fr);
		
		//read one line, return one line, if not return null
		String line = br.readLine();
		//if not null continue
		while(line!= null)
		{
			//if not empty
			if(line.length() > 0)
			{
				//add to words
				words.add(line);
			}
			//then read next line
			line = br.readLine();
		}
		//always close it
		br.close();
		return words;
	}
	
}
