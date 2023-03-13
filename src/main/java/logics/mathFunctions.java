package logics;

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

    }
