import java.util.Scanner;

public class FungsiKel9_15 {
    static Scanner input = new Scanner(System.in);
    static boolean login = false, valid = false, masuk = false;
    static String pilih;
    static String[][] dataNasabah = {
        {"01", "112233", "Annisa", "1122", "Nganjuk", "1000000", "Verified", "085123456"},
        {"02", "334455", "Iga", "3344", "Dampit", "5000000", "Verified", "081123456"},
        {"03", "556677", "Firman", "4455", "Blitar", "3500000", "Verified", "087123456"},
        {"04", "889911", "Bayu", "6677", "Jombang", "3000000", "Verified", "08912345"},
        {"05", "123456", "Novita", "8899", "Watugong", "10000000", "Verified", "088123456"}
    };
    static int[] pulsa = {22500, 27500, 52500, 102500, 502500, 1002500};
    static String[] operator = {"Indosat", "XL", "Telkomsel", "Axis"};
    static int riw = 0, hasil = 0;
    static String[] riwayat = new String[10]    ;
    static int loginAttempts = 0;
    public static void main(String[] args) {
        login();
    }
    static void login() {
        System.out.println("==================================================================");
        System.out.println("------------------------------------------------------------------");
        System.out.println(" __      _____ _    ___ ___  __  __ ___   _____ ___  \n" + //
                " \\ \\    / / __| |  / __/ _ \\|  \\/  | __| |_   _/ _ \\ \n" + //
                "  \\ \\/\\/ /| _|| |_| (_| (_) | |\\/| | _|    | || (_) |\n" + //
                "   \\_/\\_/ |___|____\\___\\___/|_|  |_|___|   |_| \\___/ \n" + //
                "                                                     ");
        System.out.println("------------------------------------------------------------------");
        System.out.println("    _ _____ __  __   ___   _   _  _ _  __  _  _  ___  \n" + //
                "   /_\\_   _|  \\/  | | _ ) /_\\ | \\| | |/ / | \\| |/ _ \\ \n" + //
                "  / _ \\| | | |\\/| | | _ \\/ _ \\| .` | ' <  | .` | (_) |\n" + //
                " /_/ \\_\\_| |_|  |_| |___/_/ \\_\\_|\\_|_|\\_\\ |_|\\_|\\___/ \n" + //
                "                                                      ");
        System.out.println("------------------------------------------------------------------");
        System.out.println("==================================================================");
        System.out.println();

        // Cek Login
        while (loginAttempts <= 3) {
            System.out.println("    =======================================================");
            System.out.println("    -------------------------------------------------------");
            System.out.print("      [   Masukkan PIN anda : ");
            String inputPin = input.next();
            System.out.println("    -------------------------------------------------------");
            System.out.println("    =======================================================");
            System.out.println();
            

            // Pengecekan verified/diblokir
            if (hasil != -1 && dataNasabah[hasil][6].equals("Disabled")) {
                System.out.println("============================================================================================");
                System.out.println("        [   Status akun anda " + dataNasabah[hasil][6]);
                System.out.println("============================================================================================");
            }

            // Pengecekan kesesuaian PIN login
            for (int i = 0; i < dataNasabah.length; i++) {
                if (inputPin.equals(dataNasabah[i][3]) && dataNasabah[i][6].equals("Verified")) {
                    login = true;
                    hasil = i;
                    menu();
                }
            }
            
            if (login) {
                menu();
            } else {
                    System.out.println("    =======================================================");
                    System.out.println("    |-----------------------------------------------------|");
                    System.out.println("    |       (!) Anda memasukkan PIN yang salah (!)        |");
                    System.out.println("    |              Silahkan Masukkan Kembali.             |");
                    System.out.println("    |-----------------------------------------------------|");
                    System.out.println("    =======================================================");
                    loginAttempts++;

                    if (loginAttempts >= 3) {
                        System.out.println("===============================================================================================");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.println("           (!) Anda telah gagal lebih dari 3 kali. Akun anda telah di-Disabled. (!)            ");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.println("===============================================================================================");
                        dataNasabah[hasil][6] = "Disabled";
                        break;
                }
            }
    }
}
    static void menu() {
                do {
                    System.out.println("    =======================================================");
                    System.out.println("    -------------------------------------------------------");
                    System.out.println("""
                            [       Silahkan pilih menu dibawah ini :
                            [       1. Data Nasabah
                            [       2. Cek Saldo
                            [       3. Tarik Tunai
                            [       4. Setor Tunai
                            [       5. Transfer Saldo
                            [       6. Riwayat Transaksi
                            [       7. Pembayaran Lain
                            [       8. Pengaturan Akun
                            [       0. Keluar
                            """);
                    System.out.print("\tMenu yang dipilih : ");
                    int menu = input.nextInt();

                    switch (menu) {
                        case 1:
                        dataNasabah();
                        case 2:
                        cekSaldo();
                        // case 3:
                        // tarikTunai();
                        // case 4:
                        // setorTunai();
                        // case 5:
                        // transferSaldo();
                        // case 6:
                        // riwayatTransaksi();
                        // case 7:
                        // pembayaranLain();
                        // case 8:
                        // pengaturanAkun();
                        // case 0:
                        // keluarMenu();
                        default:
                        System.out.println("    ======================================================");
                        System.out.println("    |----------------------------------------------------|");
                        System.out.println("    |           MENU YANG ANDA PILIH TIDAK VALID         |");
                        System.out.println("    |----------------------------------------------------|");
                        System.out.println("    ======================================================");
                    } break;     
                }while(login);
                    System.out.println();
}
    static void dataNasabah() {
        System.out.println("=====================================================================================");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("  ___      _     _____     _       _  _     _     ___     _     ___     _     _  _ \r\n" + //
                " |   \\    /_\\   |_   _|   /_\\     | \\| |   /_\\   / __|   /_\\   | _ )   /_\\   | || |\r\n" + //
                " | |) |  / _ \\    | |    / _ \\    | .` |  / _ \\  \\__ \\  / _ \\  | _ \\  / _ \\  | __ |\r\n" + //
                " |___/  /_/ \\_\\   |_|   /_/ \\_\\   |_|\\_| /_/ \\_\\ |___/ /_/ \\_\\ |___/ /_/ \\_\\ |_||_|\r\n" + //
                "                                                                                   ");
        System.out.println("-------------------------------------------------------------------------------------");        
        System.out.println("=====================================================================================");
        System.out.print("      [   Masukkan PIN anda : ");
        String inPin = input.next();
        
        int index = 0;
        if (inPin.equals(dataNasabah[hasil][3])) {
            for (int i = 0; i < dataNasabah.length; i++) {
                if (dataNasabah[i][3].equals(inPin)) {
                index = 1;
                System.out.println("    =======================================================");
                System.out.println("    [  _________________________________________________\t]");
                System.out.println("    [\t|        \tDATA NASABAH    \t\t|\t]");
                System.out.printf("    [\t|  ID\t\t\t: %s\t\t\t|\t]\n", dataNasabah[i][0]);
                System.out.printf("    [\t|  Nama\t\t\t: %s\t\t\t|\t]\n", dataNasabah[i][2]);
                System.out.printf("    [\t|  Nomor Rekening\t: %s\t\t|\t]\n", dataNasabah[i][1]);
                System.out.printf("    [\t|  Alamat\t\t: %s\t\t|\t]\n", dataNasabah[i][4]);
                System.out.printf("    [\t|  Nomor Telepon\t: %s\t\t|\t]\n", dataNasabah[i][7]);
                System.out.println("    [  -------------------------------------------------\t]");
                System.out.printf("    [\t|  Status Akun\t\t: %s\t\t|\t]\n", dataNasabah[i][6]);
                System.out.println("    [  -------------------------------------------------\t]");
                System.out.println("    =======================================================");

                System.out.println();
                System.out.print("\n    [   Ingin melanjutkan transaksi y/t: ");
                    pilih = input.next();
                    if (pilih.equals("y")) {
                        menu();
                    }else {
                        tutup();
                    } 
            }
        } 
        } else {
            index = 0;
            System.out.println("    =======================================================");
            System.out.println("    |-----------------------------------------------------|");
            System.out.println("    |       (!) Anda memasukkan PIN yang salah (!)        |");
            System.out.println("    |              Silahkan Masukkan Kembali.             |");
            System.out.println("    |-----------------------------------------------------|");
            System.out.println("    =======================================================");
            dataNasabah();
        }
        
        }
    static void cekSaldo() {
        System.out.println("======================================================================");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("   ___   ___   _  __    ___     _     _      ___     ___  \r\n" +  //   
                "  / __| | __| | |/ /   / __|   /_\\   | |    |   \\   / _ \\ \r\n" + //
                " | (__  | _|  | ' <    \\__ \\  / _ \\  | |__  | |) | | (_) |\r\n" + //
                "  \\___| |___| |_|\\_\\   |___/ /_/ \\_\\ |____| |___/   \\___/ \r\n" + //
                "                                                          ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("======================================================================");
        System.out.print("      [   Masukkan PIN anda : ");
        String inPin = input.next();

        int index = 0;
        if (inPin.equals(dataNasabah[hasil][3])) {
            for (int i = 0; i < dataNasabah.length; i++) {
                if (dataNasabah[i][3].equals(inPin)) {
                    index = 1;
                    System.out.println();
                    System.out.println("    =======================================================");
                    System.out.println("    [  _________________________________________________\t]");
                    System.out.println("    [\t|        \tCEK SALDO    \t\t|\t]");
                    System.out.printf("    [\t|  Nama\t\t\t: %s\t\t|\t\t]\n", dataNasabah[i][2]);
                    System.out.printf("    [\t|  Sisa Saldo\t\t: Rp. %s\t|\t]\n", dataNasabah[i][5]);
                    System.out.println("    [  -------------------------------------------------\t]");
                    System.out.println("    =======================================================");
                    System.out.println();
                    System.out.print("\n    [   Ingin melanjutkan transaksi y/t: ");
                    pilih = input.next();
                    if (pilih.equals("y")) {
                        menu();
                    }else {
                        System.out.println("    ======================================================");
                        System.out.println("    |----------------------------------------------------|");
                        System.out.println("    |       TERIMAKASIH TELAH MENGGUNAKAN ATM INI :).    |");
                        System.out.println("    |----------------------------------------------------|");
                        System.out.println("    ======================================================");
                        break;
                    }
                        System.out.println();
                }
            }
        } else {
            index = 0;
            System.out.println("    =======================================================");
            System.out.println("    |-----------------------------------------------------|");
            System.out.println("    |       (!) Anda memasukkan PIN yang salah (!)        |");
            System.out.println("    |              Silahkan Masukkan Kembali.             |");
            System.out.println("    |-----------------------------------------------------|");
            System.out.println("    =======================================================");
            cekSaldo();
        }
    }
    public static void tutup() {
        if (pilih == "t" || pilih == "T") {
            System.out.println("    ======================================================");
            System.out.println("    |----------------------------------------------------|");
            System.out.println("    |       TERIMAKASIH TELAH MENGGUNAKAN ATM INI :).    |");
            System.out.println("    |----------------------------------------------------|");
            System.out.println("    ======================================================");
        }
    }
    private static void keluarMenu() {
        System.out.print("      [   Apakah anda yakin ingin keluar y/t: ");
        pilih = input.next();
        if (pilih.equals("y")) {
            System.out.println("    ======================================================");
            System.out.println("    |----------------------------------------------------|");
            System.out.println("    |       TERIMAKASIH TELAH MENGGUNAKAN ATM INI :).    |");
            System.out.println("    |----------------------------------------------------|");
            System.out.println("    ======================================================");
        }else {
            menu();
        }
    }
}