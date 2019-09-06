package in.rama.practise.array;

public class MaxAmplitude {
    public static String solution(int[] T) {
        // write your code in Java SE 8
        int maxAmplitude = 0;
        String season = "";
        int chunkSize = T.length / 4;

        int winterAmplitude = getAmplitude(0, chunkSize, T);
        if (maxAmplitude < winterAmplitude) {
            maxAmplitude = winterAmplitude;
            season = "WINTER";
        }

        int springAmplitude = getAmplitude(chunkSize, 2 * chunkSize, T);
        if (maxAmplitude < springAmplitude) {
            maxAmplitude = springAmplitude;
            season = "SPRING";
        }

        int summerAmplitude = getAmplitude(2 * chunkSize, 3 * chunkSize, T);
        if (maxAmplitude < summerAmplitude) {
            maxAmplitude = summerAmplitude;
            season = "SUMMER";
        }

        //AUTUMN
        int autmnAmplitude = getAmplitude(3 * chunkSize, 4 * chunkSize, T);
        if (maxAmplitude < autmnAmplitude) {
            season = "AUTUMN";
        }

        return season;
    }

    private static int getAmplitude(int startIndex, int endIndex, int[] T) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = startIndex; i < endIndex; i++) {
            if (min > T[i]) {
                min = T[i];
            }

            if (max < T[i]) {
                max = T[i];
            }
        }

        return max - min;
    }
}

