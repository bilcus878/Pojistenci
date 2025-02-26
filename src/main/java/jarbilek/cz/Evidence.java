package jarbilek.cz;

import java.util.ArrayList;
import java.util.List;

public class Evidence {
    private List<Pojistenec> pojistenci = new ArrayList<>();

    public void pridatPojistence(String jmeno, String prijmeni, int vek, String telefon) {
        pojistenci.add(new Pojistenec(jmeno, prijmeni, vek, telefon));
    }

    public void zobrazVsechny() {
        if (pojistenci.isEmpty()) {
            System.out.println("Žádní pojištěnci nejsou v evidenci.");
        } else {
            for (Pojistenec p : pojistenci) {
                System.out.println(p);
            }
        }
    }

    public void vyhledatPojistence(String jmeno, String prijmeni) {
        boolean nalezen = false;
        for (Pojistenec p : pojistenci) {
            if (p.getJmeno().equalsIgnoreCase(jmeno) && p.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                System.out.println("Nalezen: " + p);
                nalezen = true;
            }
        }
        if (!nalezen) {
            System.out.println("Pojištěnec nenalezen.");
        }
    }
}

