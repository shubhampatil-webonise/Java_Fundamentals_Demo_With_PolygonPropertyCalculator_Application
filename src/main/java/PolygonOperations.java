
abstract public class PolygonOperations {
    int numberOfSides;
    double lengthOfEachSide;

    public int calculateSumOfInteriorAngles() {
        return 180 * (numberOfSides - 2);
    }

    public double calculateParameter() {
        return (numberOfSides * lengthOfEachSide);
    }
}
