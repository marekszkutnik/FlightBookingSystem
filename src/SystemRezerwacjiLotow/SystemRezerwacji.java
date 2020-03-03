package SystemRezerwacjiLotow;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SystemRezerwacji{

    public static void jeszczeRaz(){
        System.out.println("Wybierz 1 lub 2.");
        System.out.println("[1] Tak");
        System.out.println("[2] Nie");
    }

    public static void takNie(){
        System.out.println("[1] Tak");
        System.out.println("[2] Nie");
    }

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();

		int r = 1000000;
		int rand = Math.abs(rnd.nextInt() % r);

		List<Lot> listaLotow;
		Date dataW1 = new Date(119, 9, 11, 17, 30);
		Date dataP1 = new Date(119, 9, 15, 18, 45);
		Date dataW2 = new Date(119, 9, 14, 15, 5);
		Date dataP2 = new Date(119, 9, 16, 9, 45);
		Date dataW3 = new Date(119, 9, 21, 20, 55);
		Date dataP3 = new Date(119, 9, 28, 6, 30);
		Date dataW4 = new Date(119, 9, 24, 19, 0);
		Date dataP4 = new Date(119, 9, 25, 8, 15);
		Date dataW5 = new Date(119, 10, 2, 12, 45);
		Date dataP5 = new Date(119, 10, 4, 14, 5);
		Date dataW6 = new Date(119, 10, 4, 16, 15);
		Date dataP6 = new Date(119, 10, 8, 8, 15);
		Date dataW7 = new Date(119, 10, 17, 22, 40);
		Date dataP7 = new Date(119, 10, 25, 7, 0);
		Date dataW8 = new Date(119, 10, 23, 10, 10);
		Date dataP8 = new Date(119, 10, 25, 21, 15);
		Date dataW9 = new Date(119, 11, 1, 8, 10);
		Date dataP9 = new Date(119, 11, 8, 17, 10);
		Date dataW10 = new Date(119, 11, 10, 23, 45);
		Date dataP10 = new Date(119, 11, 15, 20, 45);

		int limitMiejsc = 100;
		int overbooking = 110;

		listaLotow = Arrays.asList(
				new Lot("Warszawa Chopina", "WAWCHO", "Budapeszt", "BUD", dataW1, dataP1, 2.5, 70, 400),
				new Lot("Warszawa Modlin", "WAWMOD", "Glasgow", "GLA", dataW2, dataP2, 3, 100, 250),
				new Lot("Warszawa Modlin", "WAWMOD", "Ibiza", "IBI", dataW3, dataP3, 3.5, 60, 500),
				new Lot("Warszawa Chopina", "WAWCHO", "Kopenhaga", "KOP", dataW4, dataP4, 2, 75, 300),
				new Lot("Warszawa Chopina", "WAWCHO", "Hamburg", "HAM", dataW5, dataP5, 1.5, 50, 400),
				new Lot("Warszawa Chopina", "WAWCHO", "Belfast", "BEL", dataW6, dataP6, 3.5, 40, 200),
				new Lot("Warszawa Modlin", "WAWMOD", "Rotterdam", "ROT", dataW7, dataP7, 2, 100, 300),
				new Lot("Warszawa Chopina", "WAWCHO", "Wenecja", "WEN", dataW8, dataP8, 3.5, 65, 300),
				new Lot("Warszawa Chopina", "WAWCHO", "Bruksela", "BRu", dataW9, dataP9, 2, 110, 350),
				new Lot("Warszawa Modlin", "WAWMOD", "Madryt", "MAD", dataW10, dataP10, 3.5, 85, 500)
		);

		System.out.println("Oto oferta lotów warszawskich lotnisk: ");
		for (Lot x : listaLotow) {
			System.out.println(x.toString());
		}
		System.out.println("* cena lotu nie uwzględnia dodatkowych opłat");

		try {
			List<Lot> wybor;
			do {
				System.out.println("Wybierz miejsce wylotu: ");
				String wybraneMiejsce = sc.nextLine().trim();
				System.out.println("Wybierz date wylotu (podaj w formacie w jakim podano w ofercie): ");
				String wybranaData = sc.nextLine().trim();
                System.out.println("Wybierz maksymalnę cenę: ");
                int maxCena = sc.nextInt();
				wybor = listaLotow.stream()
						.filter(lot -> lot.getMiejsceWylotu().equalsIgnoreCase(wybraneMiejsce))
						.filter(lot -> lot.getDataWylotu().toString().contains(wybranaData))
						.filter(lot -> lot.getCenaBazowa() <= maxCena)
						.collect(Collectors.toList());
				if (wybor.isEmpty()) {
					System.out.println("Niestety nie znaleźliśmy żadnego lotu dla Ciebie. Wprowadź dane jeszcze raz.");
				}
			} while (wybor.isEmpty());

			System.out.println("Oto lot, który pasuje do twoich preferencji: ");
			Lot wybranyLot = wybor.get(0);
            System.out.println(wybranyLot.toString());

			double doplata1 = 0;
			double nowaCena1 = 0;

			if (wybranyLot.getDataWylotu().toString().contains("Sun")) {
				nowaCena1 = wybranyLot.setCenaBazowa(wybranyLot.nowaCena1_1());
				doplata1 = nowaCena1 - wybranyLot.getCenaBazowa();
			}
			if (limitMiejsc - wybranyLot.getIloscPasazerow() < 50) {
				nowaCena1 = wybranyLot.setCenaBazowa(wybranyLot.nowaCena1_1());
				doplata1 = nowaCena1 - wybranyLot.getCenaBazowa();
			}
			if (limitMiejsc - wybranyLot.getIloscPasazerow() < 20) {
				nowaCena1 = wybranyLot.setCenaBazowa(wybranyLot.nowaCena1_25());
				doplata1 = nowaCena1 - wybranyLot.getCenaBazowa();
			} else {
				nowaCena1 = wybranyLot.getCenaBazowa();
				doplata1 = 0;
			}

			double nowaCena2 = 0;
			double doplata2 = 0;
			double cenaZaWszystkich = 0;
			System.out.println("Wybierz rodzaj klasy w której chcesz podróżować: ");
			System.out.println("[1] Klasa biznesowa (+65% ceny bazowej).");
			System.out.println("[2] Klasa ekonomiczna (+0% ceny bazowej).");
			int wybranaKlasa;
			do {
				wybranaKlasa = sc.nextInt();
				if (wybranaKlasa == 1) {
					nowaCena2 = wybranyLot.setCenaBazowa(wybranyLot.nowaCena1_65());
					doplata2 = nowaCena2 - wybranyLot.getCenaBazowa();
				} else if (wybranaKlasa == 2) {
					nowaCena2 = wybranyLot.getCenaBazowa();
					doplata2 = 0;
				} else {
					System.out.println("Wybierz 1 lub 2.");
					System.out.println("[1] Klasa biznesowa (+65% ceny bazowej).");
					System.out.println("[2] Klasa ekonomiczna (+0% ceny bazowej).");
				}
			} while (wybranaKlasa != 1 && wybranaKlasa != 2);

			int lacznaIloscWybranychPasazerow;
			do{

                System.out.println("Maksymalnie możesz wybrać 10 pasażerów.");
                System.out.println("Wybierz ilość dorosłych pasażerów (+ 18 lat): ");
                int wybranaIloscPasazerow_Dorosli = sc.nextInt();
                System.out.println("Wybierz ilość pasażerów w wieku 12-18 lat: ");
                int wybranaIloscPasazerow_Mlodziez = sc.nextInt();
                System.out.println("Wybierz ilość pasażerów w wieku 0-12 lat: ");
                int wybranaIloscPasazerow_Dzieci = sc.nextInt();
                System.out.println("Wybierz ilość pasażerów w wieku poniżej 2 lat: ");
                int wybranaIloscPasazerow_Niemowleta = sc.nextInt();
                lacznaIloscWybranychPasazerow = wybranaIloscPasazerow_Dorosli + wybranaIloscPasazerow_Mlodziez + wybranaIloscPasazerow_Dzieci + wybranaIloscPasazerow_Niemowleta;

                if(lacznaIloscWybranychPasazerow > 10){
                    System.out.println("Proszę wybrać maksymalnie 10 pasażerów.");
                }

            }while(lacznaIloscWybranychPasazerow > 10);

			cenaZaWszystkich = lacznaIloscWybranychPasazerow * wybranyLot.getCenaBazowa();

			if (wybranyLot.getIloscPasazerow() + lacznaIloscWybranychPasazerow > overbooking) {
				throw new OverbookingException("Brak miejsc. OVERBOOKING.");
			}

			if (wybranyLot.getIloscPasazerow() + lacznaIloscWybranychPasazerow < limitMiejsc) {
				System.out.println("Swietnie! Mamy jeszcze dla Ciebei wolne miejsca.");
			} else {
				System.out.println("Niestety w wybranym locie brakuje wolnych miejsc. Mamy jednak inną propozycję. Możesz polecieć z nami jako Steward i dodadtkowo dostać 20% rabatu");
				System.out.println("Czy interesuję Cię ta propzycja?");
				takNie();
				int czyStwerad;
				do {
					czyStwerad = sc.nextInt();
					if (czyStwerad == 1) {
						cenaZaWszystkich *= 0.8;
					} else if (czyStwerad == 2) {
						System.out.println("Istnieje również możliwość rezerwacji miejsca na skrzydle. W tym przyapdku rabat wynosiłby 50%");
						System.out.println("Czy interesuję Cię ta propzycja?");
						takNie();
						int czySkrzydlo;
						do {
							czySkrzydlo = sc.nextInt();
							if (czySkrzydlo == 1) {
								cenaZaWszystkich *= 0.5;
							} else if (czySkrzydlo == 2) {
                                System.out.println("Nie jesteśmmy w stanie złożyć lepszej propozycji. Dziekujemy.");
                                System.exit(0);
							} else {
								jeszczeRaz();
							}
						} while (czySkrzydlo != 1 && czySkrzydlo != 2);
					} else {
						jeszczeRaz();
					}

				} while (czyStwerad != 1 && czyStwerad != 2);

			}

			System.out.println("Obowiązuje również opłata obowiązkowa za serwis wynosząca 50zl.");
			double doplata3 = lacznaIloscWybranychPasazerow * 50;

			System.out.println("Poniższe opcje dotyczą wszystkich wybranych pasażerów.");
			System.out.println("Czy zabierasz ze sobą bagaż?");
			System.out.println("Opłata za bagaż wynosi 120 zl w przypadku bagażu 10 kg.");
			takNie();
			double doplata4 = 0;
			int czyBagaz;
			do {
				czyBagaz = sc.nextInt();
				if (czyBagaz == 1) {
					doplata4 = lacznaIloscWybranychPasazerow * 120;
				} else if (czyBagaz == 2) {
					doplata4 = 0;
				} else {
					jeszczeRaz();
				}
			} while (czyBagaz != 1 && czyBagaz != 2);

			System.out.println("Istnieje możliwość wcześcniejszej rezerwacji posiłku. Czy jesteś zainteresowany? ");
			System.out.println("Opłata za posiłek wynosi 40 zł.");
			takNie();
			double doplata5 = 0;
			int czyPosilek;
			do {
				czyPosilek = sc.nextInt();
				if (czyPosilek == 1) {
					doplata4 = lacznaIloscWybranychPasazerow * 40;
				} else if (czyPosilek == 2) {
					doplata4 = 0;
				} else {
					jeszczeRaz();

				}
			} while (czyPosilek != 1 && czyPosilek != 2);

			System.out.println("Za dodatkową opłatą przysługuje Ci również pierszeństwo przy wsiadaniu.");
			System.out.println("Opłata za tę usługę wynosi 25 zł w klasie biznesoej oraz 15 zł w klasie ekonomicznej.");
			takNie();
			double doplata6 = 0;
			int czyPierszenstwo;
			do {
				czyPierszenstwo = sc.nextInt();
				if (czyPierszenstwo == 1) {
					if (wybranaKlasa == 1) {
						doplata6 = lacznaIloscWybranychPasazerow * 25;
					} else {
						doplata6 = lacznaIloscWybranychPasazerow * 15;
					}
				} else if (czyPierszenstwo == 2) {
					doplata6 = 0;
				} else {
					jeszczeRaz();
				}
			} while (czyPierszenstwo != 1 && czyPierszenstwo != 2);

			double doplataCalkowita = doplata1 + doplata2 + doplata3 + doplata4 + doplata5 + doplata6;
			double cenaKoncowa = lacznaIloscWybranychPasazerow * (nowaCena2 + doplataCalkowita);
            String czyZdecydowany = String.format("Oto cena końcowa: %.2f \r\n", cenaKoncowa);
            String format = String.format("Cena: %.2f \r\n", cenaKoncowa);

            System.out.println(czyZdecydowany);
            System.out.println("Czy decydujesz się na zakup biletu?");
            takNie();
            int decyzjaOstateczna;
            do {
                decyzjaOstateczna = sc.nextInt();
                if (decyzjaOstateczna == 1) {

                    System.out.println("Dziekujemy za wybór naszej linii. Życzymy udanej podróży. ");

                    String filePath = "C:\\'filepath'\\Bilet.txt";
                    FileWriter fileWriter = null;

                    fileWriter = new FileWriter(filePath);
                    fileWriter.write("************************************************" + "\r\n");
                    fileWriter.write("Identyfikator rezerwacji: " + wybranyLot.getMiejsceWylotuSymbol() + wybranyLot.getMiejscePrzylotuSymbol() + rand + "\r\n");
                    fileWriter.write("Miejsce wylotu: " + wybranyLot.getMiejsceWylotu() + " " + wybranyLot.getMiejsceWylotuSymbol() + "\r\n");
                    fileWriter.write("Miejsce przylotu: " + wybranyLot.getMiejscePrzylotu() + " " + wybranyLot.getMiejscePrzylotuSymbol() + "\r\n");
                    fileWriter.write("Data wylotu: " + wybranyLot.getDataWylotu() + "\r\n");
                    fileWriter.write("Data przylotu: " + wybranyLot.getDataPowrotu() + "\r\n");
                    fileWriter.write(format);
                    fileWriter.write("************************************************");

                    fileWriter.close();

                } else if (decyzjaOstateczna == 2) {
                    System.out.println("Zaprszamy ponownie.");
                    System.exit(0);
                } else {
                    jeszczeRaz();
                }
            } while (decyzjaOstateczna != 1 && decyzjaOstateczna != 2);

		}
		catch (IOException ex) {
			System.out.println("Coś poszło nie tak z zapisaniem pliku do folderu. Błąd: " + ex.getMessage());
		}
		catch (InputMismatchException ex){
            System.out.println("Prawdopodobnie popełniłeś błąd podczas wpisywania parametrów wyszukiwania. Błąd: " + ex.getMessage());
        }
		catch(OverbookingException ex){
            System.out.println("Brak miejsc. OVERBOOKING. Błąd: " + ex.getMessage());
        }

    }
}







