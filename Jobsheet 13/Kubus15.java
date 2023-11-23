import java.util.Scanner;
public class Kubus15 {
    static int hitungVolume (int sisi) {
    int Volume = sisi*sisi*sisi;
    return Volume;
    }
    static int hitungLuasPermukaan (int a) {
        int Luas = 6*a;
        return Luas;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int s, L, vol;
        System.out.print("Masukkan sisi ");
        s = sc.nextInt();

        vol = hitungVolume(s);
        System.out.println("Volume Kubus adalah " + vol);
        L = hitungLuasPermukaan(s);
        System.out.println("Luas Permukaan Kubus adalah " + L);

    }
}
