package transformarbinario;
import java.util.Scanner;

public class TransformarBinario {

    public static int binnary[]=new int[8];
    public static Scanner intro=new Scanner(System.in);
    
    public static void main(String[] args) throws Exception{
        do {
        process(input());
        output();
        } while (keepGoing());
    }
    
    public static int[] process(int number){
        int counter=0;
        for (int i =0;i<8;i++) {
            if (checkPar(number)) binnary[counter]=0;
            else binnary[counter]=1;
            counter++;
            number/=2;
        }
        return binnary;
    }
    
    public static boolean checkPar(int number){
        if (2*(number/2)==number) return true;
        else return false;
    }
    
    public static int err(String input) throws Exception {
        int in=0;
        try {
            in=Integer.parseInt(input);
        } catch (Exception ex) {
            System.out.println("Favor ingresar Dígitos y no carácteres");
            err(intro.next());
        }
        validInt(in);
        return in; 
    }
    
    public static int validInt(int in) throws Exception{
        if (in<0 || in >255) {
            System.out.println("Favor ingresar un número entre 0 y 255");
            input();
        }
        return in;
    }

    public static int input() throws Exception{
        System.out.println("Ingrese el valor a descomponer");
        String in=intro.next();
        int input=err(in);
        return input;
    }
    
    public static void output(){
        System.out.println();
        for (int i=0;i<8;i++) {
            System.out.print(binnary[7-i]);
        }
    }
    
    public static boolean keepGoing() {
        System.out.println();
        System.out.println("Ingrese la letra Y para continuar, cualquier otro ingreso cerrará el programa");
        String DO=intro.next();
        if (DO.equals("Y") || DO.equals("y")) return true;
        else return false;
    }
}