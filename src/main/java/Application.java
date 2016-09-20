import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    private PolygonOperations polygon;
    private static final int MINIMUM_SIDE_LIMIT = 3;
    private static final int MAXIMUM_SIDE_LIMIT = 10;
    private static final Logger logger = Logger.getLogger(Application.class.getName());
    private final Scanner scanner;

    Application() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        try {
            getDataAndInitObject();
        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage());
            System.exit(1);
        }

        printResults();
    }

    private void getDataAndInitObject() {
        int numberOfSides = 0;
        double lengthOfEachSide = 0.0;

        try {
            logger.log(Level.INFO, "Enter number of sides :");
            numberOfSides = scanner.nextInt();

            logger.log(Level.INFO, "Enter length of each side :");
            lengthOfEachSide = scanner.nextDouble();

        } catch (InputMismatchException inputMismatchError) {
            logger.log(Level.SEVERE, "Aborting : Unexpected input types.");
            System.exit(1);
        }

        if (isValidateNumberOfSides(numberOfSides) && isValidateLength(lengthOfEachSide))
            polygon = new Polygon(numberOfSides, lengthOfEachSide);
        else
            throw new IllegalArgumentException("Invalid Input");
    }

    private boolean isValidateNumberOfSides(int numberOfSides) {

        if (numberOfSides >= MINIMUM_SIDE_LIMIT && numberOfSides <= MAXIMUM_SIDE_LIMIT)
            return true;
        else
            return false;
    }

    private boolean isValidateLength(double lengthOfEachSide) {

        if (lengthOfEachSide > 0)
            return true;
        else
            return false;
    }

    private void printResults() {
        logger.log(Level.INFO, "Sum of Interior Angles of Polygon : " + polygon.calculateSumOfInteriorAngles() + "\n");
        logger.log(Level.INFO, "Parameter of Polygon : " + polygon.calculateParameter() + "\n");
    }
}
