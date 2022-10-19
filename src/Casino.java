import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Lead Author(s):
 * @author Quoc Minh Tran	
 * @author Mark Truong
 **/
public class Casino
{

	public static void main(String[] args) throws IOException 
	{
		Scanner keyboard = new Scanner(System.in);
		Blackjack card = new Blackjack();
		Craps dice = new Craps();
		Opponent opp = new Opponent();
		Money cred = new Money();
		PrintWriter pWriter = new PrintWriter("receipts.txt");
		int yesorno, bet, credit=0, current;
		boolean game = true;
		
		System.out.println("Welcome to the M&M Casino. What game would you like to play today?\n"
							+ "1 for Blackjack, 2 for Craps");
		
		while(game == true) {
		try {		
		yesorno = keyboard.nextInt();
		
		yesorno = validInput(yesorno, keyboard);
		
		System.out.println(cred.getStartCredit());
		credit = keyboard.nextInt();
		
		credit = validCredit(credit, keyboard);
		
		pWriter.println("You entered the Casino with $" + credit);
		pWriter.println("");
		while(game == true) {
		if (yesorno == 1) 
		{  
			System.out.println(card.ruleBook1());
			do 
			{
				System.out.println("Place bet:");
				bet = keyboard.nextInt();
				
				bet = validBet(bet, credit, keyboard);
			
				System.out.println("You draw " + card.getDeck());
				current = card.startScore();
				System.out.println("Your starting score is: " + current);
			do 
			{
				System.out.println("Would you like to continue: 1 for yes , 2 for no");
				yesorno = keyboard.nextInt(); 
				
				yesorno = validInput(yesorno, keyboard);	
				
				if (yesorno == 1) 
				{
					System.out.println("You draw " + card.getExtra());
					current += card.addScore();
					System.out.println("Your current score is: " + current);
				}
				else if (yesorno == 2) 
					System.out.println("Your final score is: " + current);
			}while 
				(current <= 21 && yesorno == 1);
			
				int oppCurrent = opp.startScore();
			do 
			{ 
				opp.getExtra();
				oppCurrent += opp.addScore();
			}
			while(oppCurrent <= current);
			
			
			if(current <= 21)
				System.out.println("Opponent final score is: " + oppCurrent);
			
				System.out.println(card.rule(current, oppCurrent));
				System.out.println("");
				
			if(card.rule(current, oppCurrent) == "You lost") {
				cred.setLoseBet(credit, bet);
				credit = cred.getLoseBet();
				pWriter.println("Blackjack -$" + bet );
				System.out.println("Your current balance: " + credit);
			}
		
			if(card.rule(current, oppCurrent) == "You win") {
				cred.setWinBet(credit, bet);
				credit = cred.getWinBet();
				pWriter.println("Blackjack +$" + bet );
				System.out.println("Your current balance: " + credit);
			}
			System.out.println();
			System.out.println("Would you like to continue playing? 1 for yes , 2 for no");
			yesorno = keyboard.nextInt();
			}while(credit != 0 && yesorno == 1);
			
			if (credit == 0 && yesorno == 1) {
				game = false;
				yesorno = 0;
				System.out.println("You have run out of money to play with!");}
			if (credit == 0 && yesorno == 2) {
				game = false;
				yesorno = 0;
				System.out.println("Thank you for playing.");}
			if (credit !=0 && yesorno == 2)
				{
					System.out.println("Would you like to change game? 2 to change, 3 to leave");
					yesorno = keyboard.nextInt();

					while (yesorno != 2 && yesorno != 3) {
						System.out.println("You didn't type in the right number, please type in the correct number");
			
						yesorno = keyboard.nextInt();
			
					}
				}
		}
		
		if (yesorno == 2) 
		{
			System.out.println(dice.ruleBook2());
				
			do 
			{
				System.out.println("Place bet:");
				bet = keyboard.nextInt();
				
				bet = validBet(bet, credit, keyboard);
				
				current = dice.rollValue();
				System.out.println("Your dice roll score is " + current);
							
			while(dice.rule(current) == "reroll" && yesorno==1) 
			{
				System.out.println("Would you like roll again? You neither got a winning or losing score. 1 to roll again 2 to leave");
				yesorno = keyboard.nextInt();
				yesorno = validInput(yesorno, keyboard);

				if (yesorno == 1) {
					current = dice.rollValue();
					System.out.println("Your dice roll score is " + current);}
				
				if(yesorno == 2) {
					
					System.out.println("Thank you for playing");
				}
			}
			
			if(dice.rule(current) == "You lost") {
				cred.setLoseBet(credit, bet);
				credit = cred.getLoseBet();
				pWriter.println("Craps -$" + bet );
				System.out.println(dice.rule(current));
				System.out.println("Your current balance: " + credit);
			}
		
			if(dice.rule(current)=="You won") {
				cred.setWinBet(credit, bet);
				credit = cred.getWinBet();
				pWriter.println("Craps +$" + bet );
				System.out.println(dice.rule(current));
				System.out.println("Your current balance: " + credit);
			}
			
			System.out.println("Would you like to continue playing? 1 for yes , 2 for no");
			yesorno = keyboard.nextInt();
			
			}while(credit != 0 && yesorno == 1);
			
			if (credit == 0 && yesorno == 1)
				System.out.println("You have run out of money to play with!");
			if (credit == 0 && yesorno == 2)
				System.out.println("Thank you for playing.");
			if (yesorno == 2)
				{
					System.out.println("Would you like to change game? 1 to change, 3 to leave ");
					yesorno = keyboard.nextInt();
					
					while (yesorno != 1 && yesorno != 3) {
						System.out.println("You didn't type in the right number, please type in the correct number");
			
						yesorno = keyboard.nextInt();
						
					}
				}
		}
		
		if (yesorno == 3) 
		{
			yesorno = 0;
			System.out.println("Thank you for playing.");
			game = false;
		}
		
		}
		}
			catch (InputMismatchException e) 
		{
			keyboard.nextLine();
			System.out.println("Please enter the valid number");
		}	
			
		}
		pWriter.println();
		pWriter.println("Your final credit is: $" + credit);
		pWriter.println("Thank you for playing.");
		pWriter.close();	
		keyboard.close();
	}
	
	public static int validInput(int value, Scanner keyboard) {
		
		while (value > 2 || value <= 0) {
			System.out.println("You didn't type in the right number, please type in the correct number");
			
			value = keyboard.nextInt();
			
		} 
		return value;
	}
	
	public static int validCredit(int value, Scanner keyboard) {
		
		while (value <= 0) {
			System.out.println("You can not enter the casino with no money, enter the casino with a new credit: ");
			
			value = keyboard.nextInt();
			
		} 
		return value;
	
	}
	
	public static int validBet(int bet, int credit, Scanner keyboard) {
		while (bet > credit) {
			System.out.println("You can not bet over your credit, type in a valid bet.");
			
			bet = keyboard.nextInt();
		}
		return bet;
	}
}
