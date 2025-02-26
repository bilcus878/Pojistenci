package jarbilek.cz;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Evidence evidence = new Evidence();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 - Přidat pojištěného");
            System.out.println("2 - Zobrazit všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");
            System.out.print("Vyberte možnost: ");

            String volba = scanner.nextLine();

            switch (volba) {
                case "1":
                    pridatPojistence();
                    break;
                case "2":
                    evidence.zobrazVsechny();
                    break;
                case "3":
                    vyhledatPojistence();
                    break;
                case "4":
                    System.out.println("Ukončuji program.");
                    return;
                default:
                    System.out.println("Neplatná volba.");
            }
        }
    }

    private static void pridatPojistence() {
        String jmeno = zadatText("Zadejte jméno: ");
        String prijmeni = zadatText("Zadejte příjmení: ");
        int vek = zadatCislo("Zadejte věk: ");
        String telefon = zadatText("Zadejte telefonní číslo: ");

        evidence.pridatPojistence(jmeno, prijmeni, vek, telefon);
        System.out.println("Pojištěný přidán.");
    }

    private static void vyhledatPojistence() {
        String jmeno = zadatText("Zadejte jméno k vyhledání: ");
        String prijmeni = zadatText("Zadejte příjmení k vyhledání: ");
        evidence.vyhledatPojistence(jmeno, prijmeni);
    }

    private static String zadatText(String vyzva) {
        String text;
        do {
            System.out.print(vyzva);
            text = scanner.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println("Toto pole nesmí být prázdné.");
            }
        } while (text.isEmpty());
        return text;
    }

    private static int zadatCislo(String vyzva) {
        int cislo;
        while (true) {
            try {
                System.out.print(vyzva);
                cislo = Integer.parseInt(scanner.nextLine());
                if (cislo < 0) {
                    System.out.println("Číslo musí být kladné.");
                } else {
                    return cislo;
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatné číslo. Zadejte znovu.");
            }
        }
    }
}

