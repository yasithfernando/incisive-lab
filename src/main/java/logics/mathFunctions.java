package logics;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.ToDoubleFunction;

public class mathFunctions {

    public static double calculateMean(double[] dataArray){
        double mean = 0;
        double sum ;
        int i ;
        int n = dataArray.length;
        sum = 0;
        for (i = 0; i < n; i++) {
        sum = dataArray[i];
        }
        return mean;
    }

    public static double calculateStandardDeviation(Double[] dataArray){
        double sum = 0;
        for(double i : dataArray){
            sum += i;
        }
        int length = dataArray.length;
        double mean = sum/length;

        double standardDeviation = 0;
        for(double i : dataArray) {
            standardDeviation += Math.pow(i - mean , 2);
        }
        return Math.sqrt(standardDeviation/length);
    }

    public static BigDecimal calculateMeanBigDecimal(BigDecimal[] data) {
        // Calculate the mean
        BigDecimal sum = Arrays.stream(data).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal mean = sum.divide(BigDecimal.valueOf(data.length), MathContext.DECIMAL32);
        return mean;
    }

    public static BigDecimal calculateStandardDeviationBigDecimal(BigDecimal[] data) {
        // Calculate the mean
        BigDecimal mean = calculateMeanBigDecimal(data);

        // Calculate the standard deviation
        BigDecimal sumOfSquaredDiffs = Arrays.stream(data)
                .map(x -> x.subtract(mean).pow(2))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal standardDeviation = BigDecimal.valueOf(Math.sqrt(sumOfSquaredDiffs.divide(BigDecimal.valueOf(data.length), MathContext.DECIMAL32).doubleValue()));
        System.out.println("Standard deviation: " + standardDeviation);

        return standardDeviation;
    }




}
