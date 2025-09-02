public class UnitConvert 
{
    /** Convert from feet to meters */
    public static double footToMeter(double foot)
    {

        // Convert
        double meter = 0.305 * foot;

        // Return result
        return meter;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter)
    {

        // Convert
        double foot = 3.279 * meter;

        // Return result
        return foot;
    }

    /**Makes the chart */
    public static void main(String[] args) 
    {
        // Column settup
        System.out.printf("%-10s%-10s%5s%-10s%-10s\n", "Feet", "Meters", "|    ", "Meters", "Feet");
        System.out.println("-------------------------------------------");
        
        // Settup variables
        double foot = 1;
        double meter = 20;
        
        // Data
        for (int i = 1; i <= 10; foot++, meter += 5, i++)
        {
            System.out.printf("%-10.1f%-10.3f%5s%-10.1f%-10.3f\n", foot, footToMeter(foot), "|    ", meter,
          meterToFoot(meter));
        }
    }
}