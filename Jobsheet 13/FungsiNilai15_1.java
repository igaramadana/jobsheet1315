import java.util.Scanner;

public class FungsiNilai15_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jmhMhs = input.nextInt();
        System.out.print("Masukkan jumlah tugas: ");        
        int jmhTugas = input.nextInt();
        int[][] nilai = new int[jmhMhs][jmhTugas];

        inputNilai(nilai, jmhMhs, jmhTugas, input);
        printNilai(nilai);
        nilaiTertinggi(nilai);
        bestStudent(nilai); 
    }
    static void inputNilai(int[][] nilai, int jmhMhs, int jmhTugas, Scanner input){
        for (int i = 0; i<jmhMhs; i++){
            System.out.println("Masukkan "+ jmhTugas + " nilai untuk mahasiswa " + (i+1));
            for (int j = 0; j < jmhTugas; j++){
                nilai[i][j] = input.nextInt();
            }
        }
    }
    public static void nilaiTertinggi(int[][] nilai){
        int highest = 0;
        int week = 0;
        
        for(int i=0; i<nilai.length; i++){
            for(int j=0; j<nilai[0].length; j++){
                if(nilai[i][j] > highest){
                    highest = nilai[i][j];
                    week = j+1; 
                }
            }
        }
        
        System.out.println("Nilai tertinggi adalah " + highest + " pada minggu ke-" + week);
    }
    public static void printNilai(int[][] nilai){ 
        System.out.println("Nilai Mingguan Mahasiswa:");
        for(int i=0; i<nilai.length; i++){
            System.out.print("Mahasiswa " + (i+1) +": "); 
            for(int j=0; j<nilai[0].length; j++){
                System.out.print(nilai[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void bestStudent(int[][] nilai){
        int highest = 0;
        int bestSt = 0;
        int total;
        
        for(int i=0; i<nilai.length; i++){
            total = 0;
            for(int j=0; j<nilai[0].length; j++){
                total += nilai[i][j];
            }
            
            if(total > highest){
                highest = total;
                bestSt = i+1;
            }
        }
        
        System.out.println("Mahasiswa dengan nilai tertinggi adalah mahasiswa " 
            + bestSt + " dengan total nilai " + highest);
    }
}