import java.util.Random;

public class Blackjack{
	
	private static Random roll = new Random();
	private int r1, r2, rr;
	private int score;
	private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
public String getDeck() 
	{	
		this.r1 = ranks[roll.nextInt(10)];
		this.r2 = ranks[roll.nextInt(10)];
		
		return suits[roll.nextInt(4)] + " " + r1 + " and " + suits[roll.nextInt(4)] + " " + r2;	
	}	

	
public int startScore()  
	{
		this.score = r1 + r2;

		return this.score;
	}

public String getExtra() 
{
	this.rr = ranks[roll.nextInt(10)];
	
	return suits[roll.nextInt(4)] + " " + rr;
}

public int addScore()  
	{
		return rr;
	}


public String rule(int player, int opp) 
{	
	if (player < opp && player <= 21 && opp <= 21) 
	{
		return "You lost";
	}	
	
	else if (player > 21) 
	{
		return "You lost";
	}
	
	else if (opp > 21)
	{
		return "You win";
	}
	
	return "";
}

public String ruleBook1() 
{
    return "Rule: You will get assigned 2 cards\n"
            + "continue drawing until you get a total value of 16 or higher\n"
            + "you will lose if your total card value goes above 21\n"
            + "you will be competing against a computer \n"
            + "so make sure your score is higher than it!!!\n"
            + "--------------------------------------";
}

public int reset() 
	{
	return 0;
	}
}
