public class Dice {
	private int diceOne = 0;//dadu satu
	private int diceTwo = 0;//dadu dua
	private int total = 0;//total dua dadu

	public Dice(){
	diceOne =0;
	diceTwo =0;
	total =0;
	}

	public int roll (){ //roll the dice

		diceOne = (int)(6*Math.random()+1);
		diceTwo = (int)(6*Math.random()+1);
		total = diceOne + diceTwo;
		return total;
	}



	public boolean isDouble (){ // are the two dice last rolled doubles?
	if (diceOne==diceTwo)
		return true;
	else
		return false;

	}

	public int getDiceOne() {
		return diceOne;
	}

	public int getDiceTwo() {
		return diceTwo;
	}

	public void setDiceOne(int diceOne) {
		this.diceOne = diceOne;
	}

	public void setDiceTwo(int diceTwo) {
		this.diceTwo = diceTwo;
	}

	public int getTotal() {
	    return total;
	}
}