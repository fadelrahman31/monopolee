//import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class Player {

	private String name; // players name
	private double balance; // players money
	private int cursor; // location of player on the board
	private int jailcard;// jumlah free jail yang dipunayi player
	public List<Lot> lots;// makes an arraylist to hold all of the players lots
	public List<Utility> utilities;// makes an arraylist to hold utilities
	public List<Railroad> railroads;// makes an arraylist to hold railroads
	private boolean diJail;
	private int countDiJail;
	private int countMagenta;
	private int countCyan;
	private int countPink;
	private int countOrange;
	private int countRed;
	private int countYellow;
	private int countGreen;
	private int countBlue;
	private boolean bangkrut;

	public Player(String name, int balance, int cursor) {
		this.name = name;
		this.balance = balance;
		this.cursor = cursor;
		this.jailcard = 0;
		this.lots = new ArrayListKita<Lot>();
		this.utilities = new ArrayListKita<Utility>();
		this.railroads = new ArrayListKita<Railroad>();
		this.countDiJail = 0;
		this.diJail = false;
		this.bangkrut = false;

		int countMagenta = 0;
		int countCyan = 0;
		int countPink = 0;
		int countOrange = 0;
		int countRed = 0;
		int countYellow = 0;
		int countGreen = 0;
		int countBlue = 0;
	}

	public Player getPlayer() {
		return this;
	}


	public boolean isBangkrut() {
		return bangkrut;
	}

	public void setBangkrut(boolean bangkrut) {
		this.bangkrut = bangkrut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// about cursor
	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}

	// about money
	// bisa bayar gak
	public boolean bisaBayar(double expense) {
		return (this.balance > expense);
	}

	// return player balance money now
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// nambah uang dari vsmoney(uang dari player lain yang kena rent) variabel masi
	// lom fix
	public void addmoney(double vsmoney) {
		this.balance = balance + vsmoney;
	}

	// mau ngambil uang dari balance buat bayar ato apa lah
	public double takeMoney(double expense) {
		// int temp;

		// if uang player cukup buat bayar expense
		if (this.balance > expense) {
			this.balance = this.balance - expense;// take the amount of money from the player

		} else if (this.balance < expense) {// kalau mau bayar ternyata uang ga cukup
			// temp = this.balance;//disimpen balance si pemain sekarang
			System.out.println("Uang gak cukup");
		}

		return expense;// return uang yang bisa diambil

	}

	public void giveMoney(Player dest, double expense) {
		dest.addmoney(expense);
	}

	// belom bikin dadu kalau buat posisi player maju ditaro di sini ? atau di main
	// terus buat go player setiap di start dpt duit lom ada variable buat tempatin
	// si start dimana

	// soal jail jailan
	public void usefreejail() {
		jailcard -= 1;
	}

	public void addfreejailcard() {
		jailcard += 1;
	}

	public int getJailcard() {
		return jailcard;
	}

	public void setJailcard(int jailcard) {
		this.jailcard = jailcard;
	}

	public boolean isDiJail() {
		return diJail;
	}

	public void setDiJail(boolean diJail) {
		this.diJail = diJail;
	}

	public int getCountDiJail() {
		return countDiJail;
	}

	public void setCountDiJail(int countDiJail) {
		this.countDiJail = countDiJail;
	}

	// about player properties

	public int numLots() { // kembalin jumlah lots pemain
		return lots.size();
	}

	public int numUtilities() { // kembalin jumlah utilites punya pemain
		return utilities.size();
	}

	public int numRailroads() { // kembalin jumlah railroads pemain
		return railroads.size();
	}

	public void addLots(Lot l) { // nambahin lot pemain
		lots.add(l);
	}

	public void addUtilities(Utility u) { // nambahin lot pemain
		utilities.add(u);
	}

	public void addRailroads(Railroad r) { // nambahin lot pemain
		railroads.add(r);
	}

	public boolean cekLot(String nama) {
		boolean found = false;
		for (int i = 0; i < this.lots.size(); i++) {
			if (this.lots.get(i).getName().equals(nama)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public boolean cekRailroads(String nama) {
		boolean found = false;
		for (int i = 0; i < this.railroads.size(); i++) {
			if (this.railroads.get(i).getName().equals(nama)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public boolean cekUtilities(String nama) {
		boolean found = false;
		for (int i = 0; i < this.utilities.size(); i++) {
			if (this.utilities.get(i).getName().equals(nama)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public Lot getLots(String nama) {
		Lot temp = null;
		for (int i = 0; i < this.lots.size(); i++) {
			if (this.lots.get(i).getName().equals(nama)) {
				temp = this.lots.get(i);
				break;
			}
		}
		return temp;
	}

	public Railroad getRailroads(String nama) {
		Railroad temp = null;
		for (int i = 0; i < this.railroads.size(); i++) {
			if (this.railroads.get(i).getName().equals(nama)) {
				temp =  this.railroads.get(i);
				break;
			}
		}
		return temp;
	}

	public Utility getUtilities(String nama) {
		Utility temp = null;
		for (int i = 0; i < this.utilities.size(); i++) {
			if (this.utilities.get(i).getName().equals(nama)) {
				temp = this.utilities.get(i);
				break;
			}
		}
		return temp;
	}

	public void removeLots(Lot p) {
		String name = p.getName();
		for (int i = 0; i < lots.size(); i++) {
			if (lots.get(i).getName().equals(name)) {
				lots.remove(i);
			}
		}
	}

	public void removeRailroads(Railroad p) {
		String name = p.getName();
		for (int i = 0; i < railroads.size(); i++) {
			if (railroads.get(i).getName().equals(name)) {
				railroads.remove(i);
			}
		}
	}

	public void removeUtilities(Utility p) {
		String name = p.getName();
		for (int i = 0; i < utilities.size(); i++) {
			if (utilities.get(i).getName().equals(name)) {
				utilities.remove(i);
			}
		}
	}

	public void displayallLots() {
		if (numLots() == 0) {
			System.out.println("Kamu tidak memiliki lot");
		} else {
			for (int i = 0; i < lots.size(); i++) {
				System.out.println((i + 1) + ". " + lots.get(i).getName() + ", rumah = " + lots.get(i).getCountRumah());
			}
		}
	}

	public void displayallRailroads() {
		if (numRailroads() == 0) {
			System.out.println("Kamu tidak memiliki railroad");
		} else {
			for (int i = 0; i < railroads.size(); i++) {
				System.out.println((i + 1) + ". " + railroads.get(i).getName());
			}
		}
	}

	public void displayallUtilities() {
		if (numUtilities() == 0) {
			System.out.println("Kamu tidak memiliki utility");
		} else {
			for (int i = 0; i < utilities.size(); i++) {
				System.out.println((i + 1) + ". " + utilities.get(i).getName());
			}
		}
	}

	public boolean cekSekompleks(Color kompleks) {
		if (kompleks == Color.magenta && getCountMagenta() == 2) {
			return true;
		} else if (kompleks == Color.cyan && getCountCyan() == 3) {
			return true;
		} else if (kompleks == Color.pink && getCountPink() == 3) {
			return true;
		} else if (kompleks == Color.orange && getCountOrange() == 3) {
			return true;
		} else if (kompleks == Color.red && getCountRed() == 3) {
			return true;
		} else if (kompleks == Color.yellow && getCountYellow() == 3) {
			return true;
		} else if (kompleks == Color.green && getCountGreen() == 3) {
			return true;
		} else if (kompleks == Color.blue && getCountBlue() == 2) {
			return true;
		} else {
			return false;
		}
	}

	public int getCountMagenta() {
		return countMagenta;
	}

	public void setCountMagenta(int countMagenta) {
		this.countMagenta = countMagenta;
	}

	public int getCountCyan() {
		return countCyan;
	}

	public void setCountCyan(int countCyan) {
		this.countCyan = countCyan;
	}

	public int getCountPink() {
		return countPink;
	}

	public void setCountPink(int countPink) {
		this.countPink = countPink;
	}

	public int getCountOrange() {
		return countOrange;
	}

	public void setCountOrange(int countOrange) {
		this.countOrange = countOrange;
	}

	public int getCountRed() {
		return countRed;
	}

	public void setCountRed(int countRed) {
		this.countRed = countRed;
	}

	public int getCountYellow() {
		return countYellow;
	}

	public void setCountYellow(int countYellow) {
		this.countYellow = countYellow;
	}

	public int getCountGreen() {
		return countGreen;
	}

	public void setCountGreen(int countGreen) {
		this.countGreen = countGreen;
	}

	public int getCountBlue() {
		return countBlue;
	}

	public void setCountBlue(int countBlue) {
		this.countBlue = countBlue;
	}

	public void incrementCountKompleks(Color kompleks) {
		if (kompleks.equals(Color.magenta)) {
			countMagenta++;
		} else if (kompleks.equals(Color.cyan)) {
			countCyan++;
		} else if (kompleks.equals(Color.pink)) {
			countPink++;
		} else if (kompleks.equals(Color.orange)) {
			countOrange++;
		} else if (kompleks.equals(Color.red)) {
			countRed++;
		} else if (kompleks.equals(Color.yellow)) {
			countYellow++;
		} else if (kompleks.equals(Color.green)) {
			countGreen++;
		} else if (kompleks.equals(Color.blue)) {
			countBlue++;
		}
	}

}