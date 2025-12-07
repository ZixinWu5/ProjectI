# ProjectI
word spelling game
As the program runs, you will be asked to type your name and choose a category for what kind of English words you want to practice for spelling. 3 kinds: fruit, animals, daily. Each round contains 10 random questions, each question shows up for 4 seconds, then after the question disappears, you have to type it in the line. If you answer one question right you will get one point, if you spelled it wrong, you will get cut 2 points. After one round showed how many got it right and how many it got wrong. If you want to give up at the midpoint, you could choose to redo the same category. 

(Hiding play, if you win for 3 different categories in three rounds. You could see a secret hidden way to play. Show you one photo each question, and will be asked to type out the sentences/words you think relate to that photo, but you will not earn any points in order to win or lose, just for fun. After the round will tell you the correct answer, and end.) 

Learning Outcomes:
Lo1: OOP Design Principles:
In my project, the game handles flow, gameview handles visuals, and question class handles game prompts. I communicate between classes, passing data. Interfaces and abstract classes help overall structure hold shape. I try to keep each part small and readable, so others who read my code could still easily identify what is the job for each class. 

Lo2: Single & Multidimensional Arrays
I use a 2D array to store word banks by category, which keeps everything fast and simple. When I need a random word, I just pull from the right row and shuffle. Each rows for a category, each column holds the words. 

Lo3:objects, classes, aggregation
The controller holds references to things like scoreBoard, the mode, and the question list, and that is my aggregation.  Each round builds a new set of question objects, and each question quietly handles its own checking. 

Lo4:Inheritance & Polymorphism
Question is an abstract class, and TextQuestion and PhotoQuestion inherit from it. The Question sets the shape, and every question has to reveal() and checkAnswer(). When the game runs, let text questions check exact spelling while photo questions check for a matching sentence of word. 

Lo5:Generic Collection&Data Structure
When I build a round, I use lists to hold questions so I can make random shuffles, pick, remove, and iterate easily. I put the 2D array into a list so I could shuffle. It is very helpful because it makes the words come in, turn into question objects, ask, then list gone after round ends. 

Lo6:GUI &Event-Driven Programming
Players click buttons to choose categories, start the round, and submit answers in the grid. The timer trigger will be there too. I will use Swing components to display the messages, images, and input fields. 

Lo7: Exception Handling
If a photo is asked without an image or key I throw an exception. That situation could be because my path for the photo is wrong, or something else. But I still try to prepare just in case.

Lo8: Text File I/O
I am not sure what I'm gonna use. 

Planning working time: 
8 weeks. 

ToDo-list

Week 1-2: game, GameView, ScoreBoard, RoundResult,Tracker should build up.
Week 3-4: QuestionTimer, Category, GameBoard, StandardMode build up.
Week 5-6: SecretMode, WordSpelling, FileWordProvide, Question, textQuestion, PhotoQuestion.
Week 7-8: PhotoItem, GUI polish, and error checking. 














