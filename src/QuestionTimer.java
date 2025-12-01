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
import java.util.Timer;
import java.util.TimerTask;

public class QuestionTimer
{
	private Timer timer;
	private int count = 2; 

	public void start(int milliseconds, Runnable task)
	{
		//build timer 
		timer = new Timer();
		//timer task
		TimerTask timerTask = new TimerTask()
		{
			//show question time up, unlocked input
			public void run()
			{
				//count will became 0
				System.out.println("Timer tick");
				count--;

				//check if 4 seconds up
				if (count <= 0)
				{
					System.out.println("Task complete");
					//unlocked input
					task.run();     
					timer.cancel(); 
					// stop timer
				}
			}
		};

		//run one time
		timer.schedule(timerTask, milliseconds, milliseconds);
	}

}
