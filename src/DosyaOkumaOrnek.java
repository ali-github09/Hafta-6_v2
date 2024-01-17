import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DosyaOkumaOrnek {

    public static void main(String[] args) {
        String dosyaYolu = "src/dosya.txt";

        try {
            int toplam = dosyadanSayilariOkuVeTopla(dosyaYolu);
            System.out.println("Toplam: " + toplam);
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
    }

    private static int dosyadanSayilariOkuVeTopla(String dosyaYolu) throws IOException {
        int toplam = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = bufferedReader.readLine()) != null) {
                int sayi = Integer.parseInt(satir);
                toplam += sayi;
            }
        }

        return toplam;
    }
}

