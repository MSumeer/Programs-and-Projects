/* ***************************************
   AUTHOR: Muhammad Sumeer Date: 02/12/2017
		   ***This is a quiz program that checks if the user typed the correct answer to the question and gives a random mark it it is correct.
		      However if the answer is correct 0 marks are always given.
   ****************************************/
// This imports the utility Scanner. Scanner allows the program to read what the user is typing.
import java.util.Scanner;

import java.io.*;

public class MiniProject9{

	public static final int arraySize = 2;
	
	public static void main(String[] param)
	{

		    boolean newSave = false;

		    boolean repeat = false;

		    questionBank quizQuestion = new questionBank();

		    arrays Arrays = new arrays();

		    quizRecord Quiz = new quizRecord();

		    Quiz = readQuestionQuiz(Quiz);

		    quizQuestion = setQuestion(quizQuestion, "Who won the cricket world cup 2016?       ", "Who won the 2016 premier league?          ", "Who won previous NBA Playoffs?            ");

		    Arrays = setAnswer(Arrays,"Austrailia", "Chelsea", "Golden State Warriors");

		    if (getQuestionNum(Quiz) > 0){

			    newSave = continueFromPreviousSave(Quiz, Arrays, quizQuestion);

			    repeat = true;

		    }

		    if(getQuestionNum(Quiz) < 1 && repeat == false||newSave == false && repeat == false){

				newStart(Quiz, Arrays, quizQuestion);
		    }

		    System.exit(0);

  	}

  	/********************************
	*This method is the main method that is run at the start of the program.
	*This method checks if ther is a previous save.
	*/
    	public static void newStart(quizRecord Quiz, arrays Arrays, questionBank quizQuestion){

		Quiz = setAmountOfQuestions(Quiz);

		Quiz = resetQuestionNum(Quiz);

		Arrays = setAnswerCorrect(Quiz, Arrays, quizQuestion);

		int p = 0;

		for (int i = 0; i <= arraySize; i++){

			p++;

			if (getAnswerCorrect(Arrays)[i] == true){

				setMark(Arrays, Dice(), i);

				print("For question " + p + " you scored " + getMark(Arrays)[i] + "/6");

			}
		}

		if (getContinue(Quiz) == false){
			saveQuestion(Quiz, Arrays);

			System.exit(0);

		}

		double total = getMark(Arrays)[0] + getMark(Arrays)[1] + getMark(Arrays)[2];
		System.out.println("\nYour total marks are: " + total);

		for (int i = 0; i<= arraySize; i++){

			for (int j = 0; j<=arraySize; j++){

				if (j < arraySize){

					quizQuestion = swapQuestion(quizQuestion, Arrays , getQuestion(quizQuestion)[j], getQuestion(quizQuestion)[j+1], j );

					Arrays = swapMarks(Arrays, getMark(Arrays)[j], getMark(Arrays)[j+1], j );

				}

				if(j == arraySize){

					quizQuestion = swapQuestion(quizQuestion, Arrays , getQuestion(quizQuestion)[j], getQuestion(quizQuestion)[j-2], j );

					Arrays = swapMarks(Arrays, getMark(Arrays)[j], getMark(Arrays)[j-2], j );

				}
			}
		}

		print("Question" + "                                       Marks");

		print(getQuestion(quizQuestion)[0] + "Your marks are: " + getMark(Arrays)[0]);

		print(getQuestion(quizQuestion)[1] + "Your marks are: " + getMark(Arrays)[1]);

		print(getQuestion(quizQuestion)[2] + "Your marks are: " + getMark(Arrays)[2]);

		return;

	}

	/********************************
	*This method is the newStart method that starts the program from fresh.
	*This will randomly generate the amount of questions and asks for the input from the user.
	*It will then sort out the array and print all the questions and marks in order.
	*/

	public static boolean continueFromPreviousSave(quizRecord Quiz, arrays Arrays, questionBank quizQuestion){

		print("Would you like to continue from previous save");

		boolean input = input();

		if(input == true){

			Arrays = readQuestionArrays(Arrays);

			setAnswerCorrect(Quiz, Arrays, quizQuestion);

			int p = 0;

    			for (int i = 0; i <= arraySize; i++){

    				p++;

    				if (getAnswerCorrect(Arrays)[i] == true){

					setMark(Arrays, Dice(), i);

					print("For question " + p + " you scored " + getMark(Arrays)[i] + "/6");

				}
    			}

        		if (getContinue(Quiz) == false){

				saveQuestion(Quiz, Arrays);

				System.exit(0);

      			}

    			double total = getMark(Arrays)[0] + getMark(Arrays)[1] + getMark(Arrays)[2];

			print("\nYour total marks are: " + total);

			for (int i = 0; i<= arraySize; i++){

      				for (int j = 0; j<=arraySize; j++){

        				if (j < 2){

        					quizQuestion = swapQuestion(quizQuestion, Arrays , getQuestion(quizQuestion)[j], getQuestion(quizQuestion)[j+1], j );

        					Arrays = swapMarks(Arrays, getMark(Arrays)[j], getMark(Arrays)[j+1], j );

        				}

        				if(j == 2){

        					quizQuestion = swapQuestion(quizQuestion, Arrays , getQuestion(quizQuestion)[j], getQuestion(quizQuestion)[j-2], j );

        					Arrays = swapMarks(Arrays, getMark(Arrays)[j], getMark(Arrays)[j-2], j );

        				}
          			}
    			}

			print("Question" + "                                       Marks");

			print(getQuestion(quizQuestion)[0] + "Your marks are: " + getMark(Arrays)[0]);

			print(getQuestion(quizQuestion)[1] + "Your marks are: " + getMark(Arrays)[1]);

			print(getQuestion(quizQuestion)[2] + "Your marks are: " + getMark(Arrays)[2]);


	        }
   	 	return input;

	}

	/********************************
	*This method is the continueFromPreviousSave method. Where it load the values from the file.
	*This will then ask for the user input for the next question.
	*Finally will check if the answer is correct and print it in order.
	*/

	public static String StringInput(){

	    	String userInput;

	    	Scanner scanner = new Scanner(System.in);

	    	userInput = scanner.nextLine();

	    	return userInput;

  	}
	/********************************
	*This method is the StringInput which gets the input from user as a String.
	*/

	public static boolean input(){

	    	String userInput;

        	boolean Input = false;

	    	Scanner scanner = new Scanner(System.in);

	    	userInput = scanner.nextLine();

    		if (userInput.equals("y")){

      			Input = true;

   		 }

	    	return Input;
  	}

	/********************************
	*This method is the input method for a boolean.
	*/

	public static arrays readQuestionArrays(arrays Arrays){

		try{

			BufferedReader inputStream = new BufferedReader(new FileReader("myQuestion.txt"));
			BufferedReader InputStream = new BufferedReader(new FileReader("myAnswers.txt"));

			double check = Double.parseDouble(inputStream.readLine());
			check = Double.parseDouble(inputStream.readLine());

			for (int i = 0; i<=arraySize; i++){

				check = Double.parseDouble(inputStream.readLine());
				if (check > 0 ){

					getMark(Arrays)[i] = check;
				}
			}

			for(int p = 0; p<=arraySize; p++){

				String Check = InputStream.readLine();

				if (Check != null){

					getAnswer(Arrays)[p] = Check;
				}
			}
		}

		catch(IOException e){
    			e.printStackTrace();

    		}

      		return Arrays;
	}
	/********************************
	*This method is the readQuestionArrays which reads from the file.
	*/

	public static quizRecord readQuestionQuiz(quizRecord Quiz){

		try{

			BufferedReader inputStream = new BufferedReader(new FileReader("myQuestion.txt"));

			int check = Integer.parseInt(inputStream.readLine());

			int questionNum;

			int amountOfQuestions;

			if (check > 0){

				questionNum = check;

      				setQuestionNumFile(questionNum, Quiz);
    			}

			check = Integer.parseInt(inputStream.readLine());

			if (check > 0){

				amountOfQuestions = check;

				setAmountOfQuestionFile(amountOfQuestions, Quiz);

			}
		}

		catch (IOException ex){

			ex.printStackTrace();

		}

		return Quiz;
  	}
	/********************************
	*This method is the readQuestionArrays which reads from the file.
	*/


	public static void saveQuestion(quizRecord Quiz, arrays Arrays){

		try{

			new FileWriter("myQuestion.txt");

  			PrintWriter outputStream = new PrintWriter("myQuestion.txt");

  			outputStream.println(getQuestionNum(Quiz));

  			outputStream.println(getAmountOfQuestions(Quiz));

			outputStream.println(getMark(Arrays)[0]);

			outputStream.println(getMark(Arrays)[1]);

			outputStream.println(getMark(Arrays)[2]);

			outputStream.close();
 		}

		catch (IOException ex){

			ex.printStackTrace();
		}

  		return;
	}
	/********************************
	*This method is the saveQuetion which saves the details on the file.
	*/

	public static arrays swapMarks(arrays Arrays, double low, double high, int j){

		if ( j < 2 ){

			if (getMark(Arrays)[j] < getMark(Arrays)[j+1] ){

				getMark(Arrays)[j] = high;

				getMark(Arrays)[j+1]= low;

			}
		}

		if (j == 2){

			if (getMark(Arrays)[j] > getMark(Arrays)[j-2]){

				getMark(Arrays)[j] = high;

				getMark(Arrays)[j-2]= low;

			}
		}

		return Arrays;
	}
	/********************************
	*This method is the swapMarks which sorts the marks from larges to smallest.
	*/


	public static questionBank swapQuestion(questionBank quizQuestion, arrays Arrays,  String low, String high, int j){

		if ( j < 2 ){

			if (getMark(Arrays)[j] < getMark(Arrays)[j+1] ){

				getQuestion(quizQuestion)[j] = high;

				getQuestion(quizQuestion)[j+1]= low;
			}
		}
		if (j == 2){

			if (getMark(Arrays)[j] > getMark(Arrays)[j-2]){

				getQuestion(quizQuestion)[j] = high;

				getQuestion(quizQuestion)[j-2]= low;

			}
		}

		return quizQuestion;
 	 }
	/********************************
	*This method is the swapQuestion which sorts out the questions
	*/


	public static arrays isAnswerCorrect(quizRecord Quiz, questionBank quizQuestion, arrays Arrays) {

 		String UserAnswer;

  		int count = 4;

  		print("Welcome to this Sports Quiz");

  		print("You have " + getAmountOfQuestions(Quiz) +" questions to answer");

  		for(int i = getQuestionNum(Quiz); i< getAmountOfQuestions(Quiz); i++){

    			Quiz =  setQuestionNum(Quiz, i);

				print(getQuestion(quizQuestion)[i]);

  				Scanner scanner = new Scanner(System.in);

  				while (count > 0){

  					UserAnswer = scanner.nextLine();

  					if (UserAnswer.equals(getAnswer(Arrays)[i])){

						getAnswerCorrect(Arrays)[i] = true;

    						print("Your Answer is correct");

        					setContinue(Quiz, true);

    						count = 4;

    						break;

					}

					else{

						count = count -1;
						print("inccorect you have " + count + " tries.");

					}
				}

  				if (count == 0){
    					count = 4;
  				}
				if (getQuestionNum(Quiz) == getAmountOfQuestions(Quiz) - 1){

   					resetQuestionNum(Quiz);
    					saveQuestion(Quiz, Arrays);

    				}
				else{
					print("Would You like to continue");

					UserAnswer = StringInput();

					if(UserAnswer.equals("y") ){
					}

					else{

						setQuestionNum(Quiz, i+1);

						setContinue(Quiz, false);

      						saveQuestion(Quiz, Arrays);

      						return Arrays;

      					}

				}


    		}

		return Arrays;
	}

  	/********************************
	*This method is the isAnswerCorrect method where it checks if the answer is correct and returns a boolean value.
	*/

	public static int randomNumber(){

		int RandomNumber = 0;

		while (RandomNumber == 0){

			RandomNumber =  (int)(Math.random() * 3.5);

		}

		return RandomNumber;

	}
	/********************************
	*This method is the randomNumber method which generates a randomNumber
	*/


	public static double Dice(){

		double RandomNumber;
		boolean morethan6 = true;
		RandomNumber = (Math.random()) * 10;

		while (morethan6 == true){

			if (RandomNumber <= 6 && RandomNumber >= 1){

				RandomNumber = Math.round(RandomNumber);
				morethan6 = false;
				break;
			}
			else{
				RandomNumber = (Math.random()) * 10;
				morethan6 = true;
			}
		}

		return RandomNumber;
	}
	/********************************
	*This method is the Dice method which returns a random number
	*/

	public static void print(String Print){

		System.out.println(Print);

	}

	//These are the setter methods
	public static questionBank setQuestion(questionBank quizQuestion, String worldCup, String premierLeague, String NBA ){

		quizQuestion.questions[0] = worldCup;
		quizQuestion.questions[1] = premierLeague;
		quizQuestion.questions[2] = NBA;

		return quizQuestion;
	}

	public static arrays setAnswer(arrays Arrays, String worldCup, String premierLeague, String NBA ){

  		Arrays.answers[0] = worldCup;
		Arrays.answers[1] = premierLeague;
		Arrays.answers[2] = NBA;

		return Arrays;
		}

	public static quizRecord setQuestionNum(quizRecord Quiz, int i){

		Quiz.questionNum = i;

		return Quiz;
	}

	public static quizRecord setAmountOfQuestions(quizRecord Quiz){

		Quiz.amountOfQuestions = randomNumber();

		return Quiz;
	}

	public static arrays setAnswerCorrect(quizRecord Quiz, arrays Arrays, questionBank quizQuestion){

		Arrays = isAnswerCorrect(Quiz, quizQuestion, Arrays);

		return Arrays;
	}

	public static arrays setMark(arrays Arrays, double dice, int i){

		Arrays.mark[i] = dice;

		return Arrays;
	}

	public static quizRecord setQuestionNumFile(int questionNum, quizRecord Quiz){

		Quiz.questionNum = questionNum;

		return Quiz;

	}

	public static quizRecord setAmountOfQuestionFile(int amountOfQuestions, quizRecord Quiz){

		Quiz.amountOfQuestions = amountOfQuestions;

		return Quiz;

	}

	public static quizRecord setContinue(quizRecord Quiz, boolean Continue){

		Quiz.Continue = Continue;

		return Quiz;

	}

	public static quizRecord resetQuestionNum( quizRecord Quiz){

  		Quiz.questionNum = 0;

		return Quiz;

	}

//These are the getter methods
	public static String[] getQuestion(questionBank quizQuestion){

		return quizQuestion.questions;

	}

	public static String[] getAnswer(arrays Arrays){

		return Arrays.answers;

	}

	public static int getQuestionNum(quizRecord Quiz){

		return Quiz.questionNum;

	}

	public static boolean[] getAnswerCorrect(arrays Arrays){

		return Arrays.answerCorrect;

	}

	public static double[] getMark(arrays Arrays){

		return Arrays.mark;

	}

	public static int getAmountOfQuestions(quizRecord Quiz){

		return Quiz.amountOfQuestions;

	}

	public static boolean getContinue(quizRecord Quiz){

		return Quiz.Continue;

	}
}

//This is the record
class quizRecord
{
	int amountOfQuestions;
	int questionNum;
	boolean Continue = true;
}
class questionBank
{
	String[] questions = new String[3];
}
class arrays
{
	boolean[] answerCorrect = new boolean[3];
	String[] answers = new String[3];
	double[] mark = new double[3];
}
