
/* BOARD PERMAINAN MONOPOLY */

import java.awt.Color;

public class Board {
    private final int totalTile = 40;
    private final Tile[] board;
    Deck chance = new Deck("ch");
    Deck communityChest = new Deck("cc");

    public Board() {
        board = new Tile[totalTile]; // 0 - 40

        for (int i = 0; i < totalTile; i++) {
            board[i] = makeTile(i);
        }
    }

    // Getter
    public int getTotalTile() {
        return this.totalTile;
    }

    public Tile getTileInfo(int position) {
        return board[position];
    }

    public Tile[] getBoard() {
        return board;
    }


    private Tile makeTile(int position) {
        switch (position) {
        case 0:
            return start(position);
        case 1:
            return cicadas(position);
        case 2:
            return communityChestTile(position);
        case 3:
            return padasuka(position);
        case 4:
            return incomeTax(position);
        case 5:
            return stCimahi(position);
        case 6:
            return uber(position);
        case 7:
            return chanceTile(position);
        case 8:
            return cicaheum(position);
        case 9:
            return antapani(position);
        case 10:
            return jail(position);
        case 11:
            return cihapit(position);
        case 12:
            return pln(position);
        case 13:
            return citarum(position);
        case 14:
            return cilaki(position);
        case 15:
            return stPadalarang(position);
        case 16:
            return burangrang(position);
        case 17:
            return communityChestTile(position);
        case 18:
            return kopo(position);
        case 19:
            return batununggal(position);
        case 20:
            return freeParking(position);
        case 21:
            return braga(position);
        case 22:
            return chanceTile(position);
        case 23:
            return merdeka(position);
        case 24:
            return riau(position);
        case 25:
            return stKiaracondong(position);
        case 26:
            return pajajaran(position);
        case 27:
            return cipaganti(position);
        case 28:
            return pdam(position);
        case 29:
            return pasirkaliki(position);
        case 30:
            return goToJail(position);
        case 31:
            return sarijadi(position);
        case 32:
            return pasteur(position);
        case 33:
            return communityChestTile(position);
        case 34:
            return sukajadi(position);
        case 35:
            return stBandung(position);
        case 36:
            return chanceTile(position);
        case 37:
            return dago(position);
        case 38:
            return luxuryTax(position);
        case 39:
            return ciumbuleiut(position);
        /*
         * case 40 : return; // ini buat jail
         */
        default:
            return null;
        }

    }

    // Tile START
    private Tile start(int position) {
        return new Start("START", position);
    }

    // Tile Free Parking
    private Tile freeParking(int position) {
        return new FreeParking("Free Parking", position);
    }

    // Tile Go To Jail
    private Tile goToJail(int position) {
        return new GoToJail("Go To Jail", position);
    }

    // Tile Just Visiting Jail
    private Tile jail(int position) {
        return new Jail("Jail", position);
    }

    // Tile Chance
    private Tile chanceTile(int position) {
        return new Chance("Chance", chance, position);
    }

    // Tile Community Chest
    private Tile communityChestTile(int position) {
        return new CommunityChest("Community Chest", communityChest, position);
    }

    // Tile Income Tax
    private Tile incomeTax(int position) {
        return new IncomeTax("Income Tax", position);
    }

    // Tile Luxury Tax
    private Tile luxuryTax(int position) {
        return new LuxuryTax("Luxury Tax", position);
    }

    // Tile Railroad
    private Tile stKiaracondong(int position) {
        Player owner = null;
        int harga = 200;

        return new Railroad(owner, "Stasiun Kiaracondong", position, harga);
    }

    private Tile stBandung(int position) {
        Player owner = null;
        int harga = 200;

        return new Railroad(owner, "Stasiun Bandung", position, harga);
    }

    private Tile stPadalarang(int position) {
        Player owner = null;
        int harga = 200;

        return new Railroad(owner, "Stasiun Padalarang", position, harga);
    }

    private Tile stCimahi(int position) {
        Player owner = null;
        int harga = 200;

        return new Railroad(owner, "Stasiun Cimahi", position, harga);
    }

    // Tile Utility
    private Tile pdam(int position) {
        Player owner = null;
        int harga = 150;

        return new Utility(owner, "PDAM Bandung", position, harga);
    }

    private Tile pln(int position) {
        Player owner = null;
        int harga = 150;

        return new Utility(owner, "PLN Bandung", position, harga);
    }

    // Tile Lot
    private Tile cicadas(int position) {
        Player owner = null;
        int harga = 60;
        // belum diberli siapa2 jadi blom harga sewa = 0
        int countRumah = 0;
        int hargaR = 50;
        Color kompleks = Color.magenta;

        return new Lot(owner, "Cicadas", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile padasuka(int position) {
        Player owner = null;
        int harga = 60;

        int countRumah = 0;
        int hargaR = 50;
        Color kompleks = Color.magenta;

        return new Lot(owner, "Padasuka", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile uber(int position) {
        Player owner = null;
        int harga = 100;

        int countRumah = 0;
        int hargaR = 50;
        Color kompleks = Color.cyan;

        return new Lot(owner, "Ujung Berung", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile cicaheum(int position) {
        Player owner = null;
        int harga = 100;

        int countRumah = 0;
        int hargaR = 50;
        Color kompleks = Color.cyan;

        return new Lot(owner, "Cicaheum", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile antapani(int position) {
        Player owner = null;
        int harga = 120;

        int countRumah = 0;
        int hargaR = 50;
        Color kompleks = Color.cyan;

        return new Lot(owner, "Antapani", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile cihapit(int position) {
        Player owner = null;
        int harga = 140;

        int countRumah = 0;
        int hargaR = 100;
        Color kompleks = Color.pink;

        return new Lot(owner, "Cihapit", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile citarum(int position) {
        Player owner = null;
        int harga = 140;

        int countRumah = 0;
        int hargaR = 100;
        Color kompleks = Color.pink;

        return new Lot(owner, "Citarum", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile cilaki(int position) {
        Player owner = null;
        int harga = 160;

        int countRumah = 0;
        int hargaR = 100;
        Color kompleks = Color.pink;

        return new Lot(owner, "Cilaki", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile burangrang(int position) {
        Player owner = null;
        int harga = 180;

        int countRumah = 0;
        int hargaR = 100;
        Color kompleks = Color.orange;

        return new Lot(owner, "Burangrang", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile kopo(int position) {
        Player owner = null;
        int harga = 180;

        int countRumah = 0;
        int hargaR = 100;
        Color kompleks = Color.orange;

        return new Lot(owner, "Kopo", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile batununggal(int position) {
        Player owner = null;
        int harga = 200;

        int countRumah = 0;
        int hargaR = 100;
        Color kompleks = Color.orange;

        return new Lot(owner, "Batununggal", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile braga(int position) {
        Player owner = null;
        int harga = 220;

        int countRumah = 0;
        int hargaR = 150;
        Color kompleks = Color.red;

        return new Lot(owner, "Braga", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile merdeka(int position) {
        Player owner = null;
        int harga = 220;

        int countRumah = 0;
        int hargaR = 150;
        Color kompleks = Color.red;

        return new Lot(owner, "Merdeka", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile riau(int position) {
        Player owner = null;
        int harga = 240;

        int countRumah = 0;
        int hargaR = 150;
        Color kompleks = Color.red;

        return new Lot(owner, "Riau", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile pajajaran(int position) {
        Player owner = null;
        int harga = 260;

        int countRumah = 0;
        int hargaR = 150;
        Color kompleks = Color.yellow;

        return new Lot(owner, "Pajajaran", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile cipaganti(int position) {
        Player owner = null;
        int harga = 260;

        int countRumah = 0;
        int hargaR = 150;
        Color kompleks = Color.yellow;

        return new Lot(owner, "Cipaganti", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile pasirkaliki(int position) {
        Player owner = null;
        int harga = 280;

        int countRumah = 0;
        int hargaR = 150;
        Color kompleks = Color.yellow;

        return new Lot(owner, "Pasirkaliki", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile sarijadi(int position) {
        Player owner = null;
        int harga = 300;

        int countRumah = 0;
        int hargaR = 200;
        Color kompleks = Color.green;

        return new Lot(owner, "Sarijadi", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile pasteur(int position) {
        Player owner = null;
        int harga = 300;

        int countRumah = 0;
        int hargaR = 200;
        Color kompleks = Color.green;

        return new Lot(owner, "Pasteur", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile sukajadi(int position) {
        Player owner = null;
        int harga = 320;

        int countRumah = 0;
        int hargaR = 200;
        Color kompleks = Color.green;

        return new Lot(owner, "Sukajadi", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile dago(int position) {
        Player owner = null;
        int harga = 350;

        int countRumah = 0;
        int hargaR = 200;
        Color kompleks = Color.blue;

        return new Lot(owner, "Dago", position, kompleks, harga, countRumah, hargaR);
    }

    private Tile ciumbuleiut(int position) {
        Player owner = null;
        int harga = 400;

        int countRumah = 0;
        int hargaR = 200;
        Color kompleks = Color.blue;

        return new Lot(owner, "Ciumbuleuit", position, kompleks, harga, countRumah, hargaR);
    }

}
