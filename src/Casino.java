import java.io.*;
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
		int yesorno, bet, credit, current;
		boolean game = true;
		System.out.println("What game: 1 for Blackjack 2 for Craps");
		try {
		yesorno = keyboard.nextInt();
		
		System.out.println(cred.getStartCredit());
		credit = keyboard.nextInt();
		pWriter.println("You entered the casino with $" + credit);
		pWriter.println("");
		while(game == true) {
		if (yesorno == 1) 
		{  
			System.out.println(card.ruleBook1());
			do 
			{
				System.out.println("Place bet:");
				bet = keyboard.nextInt();
			
				System.out.println("You draw " + card.getDeck());
				current = card.startScore();
				System.out.println("Your starting score is: " + current);
			do 
			{
				System.out.println("Would you like to countinue: 1 for yes , 2 for no");
				yesorno = keyboard.nextInt(); 
				
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
			System.out.println("");
			System.out.println("Would you like to continue playing? 1 for yes , 2 for no");
			yesorno = keyboard.nextInt();
			}while(credit != 0 && yesorno == 1);
			
			if (credit == 0 && yesorno == 1)
				System.out.println("You have run out of money to play with!");
			if (credit == 0 && yesorno == 2)
				System.out.println("Thank you for playing.");
			if (credit !=0 && yesorno == 2)
				{
					System.out.println("Would you like to change game? 2 to change, 3 to leave ");
					yesorno = keyboard.nextInt();
				}
		}
		
		if (yesorno == 2) 
		{	
			System.out.println(dice.ruleBook2());
			
			
			do 
			{
				System.out.println("Place bet:");
				bet = keyboard.nextInt();
				
				current = dice.rollValue();
				System.out.println("Your dice roll score is " + dice.rollValue());
				
				if(dice.rule(current) == "reroll") 
				{
					System.out.println("Would you like roll again? You neither got a winning or losing score. 1 to roll again 2 to leave");
					yesorno = keyboard.nextInt();
				}
			
			}while 
				(yesorno == 1);
			
			if(dice.rule(current) == "You lost") {
				cred.setLoseBet(credit, bet);
				credit = cred.getLoseBet();
				pWriter.println("Craps -$" + bet );
				System.out.println("Your score was " + current + " You lost");
				System.out.println("Your current balance: " + credit);
			}
		
			if(dice.rule(current)=="You won") {
				cred.setWinBet(credit, bet);
				credit = cred.getWinBet();
				pWriter.println("Craps +$" + bet );
				System.out.println("Your score was " + current + "You lost");
				System.out.println("Your current balance: " + credit);
			}
			
			if (credit == 0 && yesorno == 1)
				System.out.println("You have run out of money to play with!");
			if (credit == 0 && yesorno == 2)
				System.out.println("Thank you for playing.");
			if (yesorno == 2)
				{
					System.out.println("Would you like to change game? 2 to change, 3 to leave ");
					yesorno = keyboard.nextInt();
				}
		}
		
		if (yesorno == 3) 
		{
			yesorno = 0;
			System.out.println("Thank you for playing.");
		}
		
		game = false;
		}
		}
			catch (Exception e) //will change to be more specific later
		{
			System.out.println("Invalid Input");
		};
	
		pWriter.println("Thank you for playing.");
		pWriter.close();	
		keyboard.close();
	}

}
