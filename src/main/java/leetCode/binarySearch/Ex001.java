package leetCode.binarySearch;

public class Ex001 {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(14));
    }
    public static int numberOfMatches(int n) {
        int teams = n;
        int curMatches = 0;
        int sumMatches = 0;
        while (teams > 1) {
            if (teams % 2 == 0) {
                curMatches = teams / 2;
                teams = curMatches;
            } else {
                curMatches = (teams - 1) / 2;
                teams = curMatches + 1;
            }
            sumMatches += curMatches;
        }

        return sumMatches;
    }
}