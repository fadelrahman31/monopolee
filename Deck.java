/* CLASS DECK YANG MERUPAKAN KUMPULAN CARD DAN SEBAGAI PEMBENTUK CARD */

import java.util.Random;

public class Deck {
    private final int totalDeck = 16;
    private Card[] cards = new Card[totalDeck]; // ada 16 cards dalam satu deck
    private String gantiDeck;
    private int urutan = 0;
    private int total;
    private Player p;


    public Deck (String gantiDeck) {
        if (gantiDeck.equals("ch")) { // Deck cards akan merepresentasikan change bila ganti deck adalah "ch"
            this.total = totalDeck;
            this.cards[0] = new MoneyCard("Kamu dapat bonus uang dari bank sebanyak 100!", 100);
            this.cards[1] = new MoneyCard("Kamu memenangkan kontes kecantikan, kamu mendapat 150", 150);
            this.cards[2] = new MoneyCard("Bayar pajak cuy, 20 aja kok", -20);
            this.cards[3] = new MoneyCard("Selamat! Ada kenaikan keuntungan pada perusahaan sendal jepitmu sebanyak 200!", 200);
            this.cards[4] = new GoToCard("Kamu ingin jalan-jalan ke Ciumbuleuit, pergilah kesana...", 39);
            this.cards[5] = new MoneyCard("Terima uang dari teman yang pernah ngutang sama kamu, dapat 25", 25);
            this.cards[6] = new FreeJailCard("Kamu dapat kartu bebas penjara, gunakanlah baik-baik ya");
            this.cards[7] = new MoneyCard("Dapat komisi 80 dari pekerjaan", 80);
            this.cards[8] = new MoneyCard("Dapat warisan sebanyak 125", 125);
            this.cards[9] = new GoToCard("Kamu dipanggil temen kamu di Kopo, kesana cepet", 18);
            this.cards[10] = new GoToJailCard("Kamu ditangkap karena mencuri ayam tetangga!!!");
            this.cards[11] = new MoneyCard("Kamu menemukan uang di jalan sebanyak 30", 30);
            this.cards[12] = new MoneyCard("Anda mendapat bonus gaji 225", 225);
            this.cards[13] = new MoneyCard("Kamu mencuri uang seseorang lho, dapat 99", 99);
            this.cards[14] = new CloseRailroadCard("Pergilah ke stasiun terdekat");
            this.cards[15] = new GoToCard("Maju ke START", 0);
        }
        else if (gantiDeck.equals("cc")) { // Deck cards akan merepresentasikan community chest bila ganti deck adalah "cc"
            this.total = totalDeck;
            this.cards[0] = new MoneyCard("Karena kesalahan bank, anda rugi 125", -125);
            this.cards[1] = new MoneyCard("Tagihan asuransi anda membludak 100, bayar gih", -100);
            this.cards[2] = new MoneyCard("Bayar cicilan mobil lu bos seharga 250", -250);
            this.cards[3] = new FreeJailCard("Kamu dapat kartu bebas penjara, gunakanlah baik-baik ya");
            this.cards[4] = new MoneyCard("Bayar hutang ke bank 50", -50);
            this.cards[5] = new GoToJailCard("Masuk penjara karena mencuri");
            this.cards[6] = new MoneyCard("Bayar tagihan pajak bangunan rumah lu 300", -300);
            this.cards[7] = new MoneyCard("Selamat kamu mendapatkan hadiah lotere 300!!!", 300);
            this.cards[8] = new GoToCard("Maju ke Free Parking", 20);
            this.cards[9] = new MoneyCard("Bayar BPJS buat anak cu, totalnya 75", -75);
            this.cards[10] = new MoneyCard("Anda dapat pajak tapi anak lu minta hehe",0);
            this.cards[11] = new MoneyCard("Kamu harus memperpanjang STNK dan SIM kamu ke bank, bayar 100", -100);
            this.cards[12] = new MoneyCard("Selamat kamu mendapatkan hadiah juara 1 makan besar sebanyak 200!", 200);
            this.cards[13] = new MoneyCard("Buka rekening deposito buat investasi, bayar 80 buat feenya", -80);
            this.cards[14] = new MoneyCard("Kamu kelupaan membayar tagihan internet sebanyak 50, bayar cuy", -50);
            this.cards[15] = new GoToCard("Pergilah ke PLN Bandung", 12);

        }
    }


    public int getUrutan() {
        return urutan;
    }

    public int getTotal() {
        return total;
    }

    public String getGantiDeck() {
        return gantiDeck;
    }

    public void setGantiDeck(String gantiDeck) {
        this.gantiDeck = gantiDeck;
    }


    public String printCardText () {
        return cards[urutan].printCardText();
    }

    public void shuffleCard() { // Kocok/shuffle kartu
        Random random = new Random();

        for (int i = 0; i < 1000; i++) { // kartu dishuffle 1000x biar kemungkinan semua urutan kartu kena shuffle
            int card1 = random.nextInt(total);
            int card2 = random.nextInt(total);

            Card temp = cards[card1];
            cards[card1] = cards[card2];
            cards[card2] = temp;
        }
    }

    public void nextCard(Player p) {
        //Card temp = cards[urutan];
        cards[urutan].executeCard(p);
        urutan++;
        if (urutan == total) {
            urutan = 0;
        }
    }
}
