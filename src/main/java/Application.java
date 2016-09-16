import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    private PolygonOperations polygon;

    public void start(){
        try{
            getDataAndInitObject();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

        printResults();
    }

    private void getDataAndInitObject(){
        Scanner in = new Scanner(System.in);

        int numberOfSides = 0;
        double lengthOfEachSide = 0.0;

        try{
            System.out.println("Enter number of sides :");
            numberOfSides = in.nextInt();

            System.out.println("Enter length of each side :");
            lengthOfEachSide = in.nextDouble();

        }catch (InputMismatchException e){
            System.out.println("Aborting : Unexpected input types.");
            System.exit(0);
        }

        if (validateNumberOfSides(numberOfSides) && validateLengthOfEachSide(lengthOfEachSide))
            polygon = new Polygon(numberOfSides, lengthOfEachSide);
        else
            throw new IllegalArgumentException("Invalid Input");
    }

    private boolean validateNumberOfSides(int numberOfSides){

        if(numberOfSides >= 3 && numberOfSides <=10)
            return true;
        else
            return false;
    }

    private boolean validateLengthOfEachSide(double lengthOfEachSide){

        if(lengthOfEachSide > 0)
            return true;
        else
            return false;
    }

    private void printResults(){

        System.out.println("Sum of Interior Angles of Polygon : " + polygon.calculateSumOfInteriorAngles() + "\n");
        System.out.println("Parameter of Polygon : " + polygon.calculateParameter() + "\n");
    }
}
