import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = " ";
        String b = " ";
        String c = " ";

        String d = " ";
        String e = " ";
        String f = " ";

        String g = " ";
        String h = " ";
        String i = " ";

        int position;

        System.out.println(" " + a + " | " + b +  " | "  + c + " ");
        System.out.println("---+---+---");
        System.out.println(" " + d + " | " + e +  " | "  + f + " ");
        System.out.println("---+---+---");
        System.out.println(" " + g + " | " + h +  " | "  + i + " ");
        System.out.println("Spelar X, vilken ruta (1-9)?");
        position = sc.nextInt();
        switch(position){
            case 1:
                a = "X";
                break;
            case 2:
                b = "X";
                break;
            case 3:
                c = "X";
                break;
            case 4:
                d = "X";
                break;
            case 5:
                e = "X";
                break;
            case 6:
                f = "X";
                break;
            case 7:
                g = "X";
                break;
            case 8:
                h = "X";
                break;
            case 9:
                i = "X";
                break;
            default:
                break;
        }
        System.out.println(" " + a + " | " + b +  " | "  + c + " ");
        System.out.println("---+---+---");
        System.out.println(" " + d + " | " + e +  " | "  + f + " ");
        System.out.println("---+---+---");
        System.out.println(" " + g + " | " + h +  " | "  + i + " ");
        System.out.println("Spelar O, vilken ruta (1-9)?");
    }
}