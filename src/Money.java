public class Money {

    private int current;


    public void setLoseBet(int current, int bet) 
    {
        this.current = current - bet;

    }

    public int getLoseBet() 
    {
        return current;
    }

    public void setWinBet(int current, int bet) 
    {
        this.current = current + bet;

    }

    public int getWinBet() 
    {
        return current;
    }

    public String getStartCredit() 
    {
    	return "How much are you entering the casino with? Enter your credit of choice:";
    }
}