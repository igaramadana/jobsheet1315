import java.util.Scanner;
public class FungsiNilai15 {

    // Data nilai mahasiswa
    static int[][] nilai = new int [5][7];
       
    // Fungsi untuk menginput data nilai mahasiswa
    public static void inputNilai(){
        Scanner input = new Scanner(System.in);
        for(int i=0; i<nilai.length; i++){
            System.out.println("Masukkan 7 nilai mingguan untuk mahasiswa " +(i+1)+ ": ");
            for(int j=0; j<nilai[0].length; j++){
                nilai[i][j] = input.nextInt(); 
            }
        } 
    }
    
    // Fungsi untuk menampilkan nilai mahasiswa
    public static void printNilai(){ 
        System.out.println("Nilai Mingguan Mahasiswa:");
        for(int i=0; i<nilai.length; i++){
            System.out.print("Mahasiswa " + (i+1) +": "); 
            for(int j=0; j<nilai[0].length; j++){
                System.out.print(nilai[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Fungsi mencari nilai tertinggi
    public static void nilaiTertinggi(){
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
    
    // Fungsi menampilkan mahasiswa nilai tertinggi 
    public static void bestStudent(){
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

    public static void main(String[] args) {
        inputNilai();
        printNilai(); 
        nilaiTertinggi();
        bestStudent();
    }

}