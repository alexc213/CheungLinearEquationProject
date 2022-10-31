import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {
        //start
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coord2 = scan.nextLine();

        int x1;
        int y1;

        int x2;
        int y2;

        //coord1 numbers

        int commaIndex = coord1.indexOf(",");
        String x1Half = coord1.substring(1, commaIndex);
        String y1Half = coord1.substring(commaIndex + 2,coord1.length()-1);

        x1 = Integer.parseInt(x1Half);
        y1 = Integer.parseInt(y1Half);

        //coord2 numbers

        int commaIndex2 = coord2.indexOf(",");
        String x2Half = coord2.substring(1, commaIndex2);
        String y2Half = coord2.substring(commaIndex2 + 2,coord2.length()-1);

        x2 = Integer.parseInt(x2Half);
        y2 = Integer.parseInt(y2Half);

        //check vertical line
        if (x1 != x2){
            LinearEquation obj = new LinearEquation(x1,y1,x2,y2);
            System.out.println(obj.lineInfo());
            System.out.print("Enter a value for x: ");
            double x = scan.nextDouble();
            System.out.println("The point on the line is: " + obj.coordinateForX(x));
        } else {
            System.out.println("These points are on a vertical line: x = " + x1);
        }

    }
}
