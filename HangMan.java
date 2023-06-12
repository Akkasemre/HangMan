package adamAsmaca;

import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {

        String[] kelimeler = {
                "java",
                "programlama",
                "bilgisayar",
                "yazılım",
                "geliştirme",
                "mobil",
                "web",
                "veritabanı",
                "algoritma",
                "sistem",
                "ağ",
                "bellek",
                "dosya",
                "kodlama",
                "test",
                "hata",
                "döngü",
                "fonksiyon",
                "değişken",
                "metod"
        };

            // olusturulan array den astgele string alma
            Random random = new Random();
            int randomIndex = random.nextInt(kelimeler.length);
            String randomString =kelimeler[randomIndex];

            //alınan random stringin uzunlugunu alma
            int randomStringsLength = randomString.length();

            //Secilen dizenin uzunlugunu alip tireler ile doldurma
            StringBuilder dashBuilder = new StringBuilder();
            for (int i =0; i<randomStringsLength;i++){
                dashBuilder.append("-");
            }
            //dashBuilder[] String hale getirmek
            String  dash = dashBuilder.toString();

            //Tahmin edilecek kısmı print etme ve karşılama
            System.out.println("Adam asmaca oyununa hosgeldiniz");

            System.out.println("Tire: " + dashBuilder);

            // adam asmaca platformu print etme
            System.out.println(" _________");
            System.out.println(" |        |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println("_|_");

            //kullanıcı tahmin counter olusturma
            int maxGuesses = 6;
            int wrongGuesses = 0;

            while(wrongGuesses<maxGuesses){
                //Scanner olusturma ve kullanıcıdan harf tahmini alma
                Scanner sc = new Scanner(System.in);
                System.out.println("Harf tahmin ediniz.");
                char guess = sc.next().toLowerCase().charAt(0);


                if(randomString.indexOf(guess) != -1) {
                    //tahmin dogru ise dashBuilder[] update
                    for (int i = 0; i < randomStringsLength; i++) {
                        if (randomString.charAt(i) == guess) {
                            dash = dash.substring(0, i) + guess + dash.substring(i + 1);
                            System.out.println("Tahmininiz dogru " + dash.toString());
                        }
                    }

                    //tum harfler dogru tahmin edilip edilmedigini bulma
                    if (!dash.contains("-")) {
                        System.out.println("Tebrikler oyunu kazandınız");
                        break;
                    }
                }else{
                    //tahmin yanlıssa wrongGuess sayacı artar ve adamın bir parcası asılır
                    wrongGuesses++;
                    drawHangman(wrongGuesses);
                }
            }

            if(wrongGuesses==maxGuesses){
                System.out.println("Tahmin hakkiniz bitti. Dogru kelime: " + randomString);
            }


        }

        static void drawHangman(int wrongGuesses){
        switch (wrongGuesses){
            case 1:
                System.out.println(" _________");
                System.out.println(" |        |");
                System.out.println(" |        O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|_");
                break;
            case 2:
                System.out.println(" _________");
                System.out.println(" |        |");
                System.out.println(" |        O");
                System.out.println(" |        |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|_");
                break;
            case 3:
                System.out.println(" _________");
                System.out.println(" |        |");
                System.out.println(" |        O");
                System.out.println(" |       /|");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|_");
                break;
            case 4:
                System.out.println(" _________");
                System.out.println(" |        |");
                System.out.println(" |        O");
                System.out.println(" |       /|\\");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|_");
                break;
            case 5:
                System.out.println(" _________");
                System.out.println(" |        |");
                System.out.println(" |        O");
                System.out.println(" |       /|\\");
                System.out.println(" |       /");
                System.out.println(" |");
                System.out.println("_|_");
                break;
            case 6:
                System.out.println(" _________");
                System.out.println(" |        |");
                System.out.println(" |        O");
                System.out.println(" |       /|\\");
                System.out.println(" |       / \\");
                System.out.println(" |");
                System.out.println("_|_");
                break;
        }
        }

    }



