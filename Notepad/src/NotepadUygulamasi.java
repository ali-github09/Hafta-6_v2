import java.io.*;
import java.util.Scanner;

public class NotepadUygulamasi {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Kullanıcıdan metin girişi al
            System.out.print("Bir metin girin: ");
            String metin = scanner.nextLine();

            // Metni dosyaya kaydet
            dosyayaKaydet("notlar.txt", metin);

            // En son kaydedilen metni ekrana yazdır
            String enSonKaydedilenMetin = dosyadanOku("notlar.txt");
            System.out.println("En son kaydedilen metin: " + enSonKaydedilenMetin);

        } catch (IOException e) {
            System.err.println("Dosya işlemleri sırasında bir hata oluştu: " + e.getMessage());
        }
    }

    private static void dosyayaKaydet(String dosyaAdi, String metin) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(dosyaAdi))) {
            printWriter.print(metin);
        }
    }

    private static String dosyadanOku(String dosyaAdi) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dosyaAdi))) {
            return bufferedReader.readLine();
        }
    }
}
