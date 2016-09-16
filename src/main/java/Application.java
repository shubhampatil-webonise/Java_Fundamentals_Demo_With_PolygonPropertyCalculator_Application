import java.util.Scanner;

public class Application {

    PolygonOperations polygon;

    public void start(){
        getDataAndInitObject();
        printResults();
    }

    private void getDataAndInitObject(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of sides :");
        int numberOfSides = in.nextInt();

        System.out.println("Enter length of each side :");
        double lengthOfEachSide = in.nextDouble();

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
