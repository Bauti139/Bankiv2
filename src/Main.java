import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Proszę wpisać trz początkowe cyfry banku: ");
        String NumerBanku = in.nextLine();
        URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
        BufferedReader czytnik = new BufferedReader(new InputStreamReader(url.openStream()));
        String linia;
        while ((linia = czytnik.readLine()) != null) {
            if (linia.startsWith(NumerBanku)) {
                String[] parts = linia.split("\t+");
                String numerBanku = parts[0];
                String NazwaBanku = parts[1];


                System.out.println("Bank w którym masz konto to: " + NazwaBanku +  " Jego numer to:  " + numerBanku);
                break;
            }
        }
        czytnik.close();
    }
}