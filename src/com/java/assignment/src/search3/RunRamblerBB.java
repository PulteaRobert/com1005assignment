import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunRamblerBB{

    public static void main(String[] arg) {

        TerrainMap map1 = new TerrainMap("src/search3/tmc.pgm");
        Random rand = new Random();
        List<Coords> testCases = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            testCases.add(new Coords(rand.nextInt(15), rand.nextInt(15)));
        }

        List<RamblerSearch> searchers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            searchers.add(new RamblerSearch(map1, new Coords(15, 15)));
        }
        SearchState[] initStates = new RamblerState[10];

        for (int i = 0; i < initStates.length; i++) {
            initStates[i] = new RamblerState(testCases.get(i), 0);
        }

        double[] results = new double[10];

        for (int i = 0; i < searchers.size(); i++) {
           results[i] = searchers.get(i).runSearchE(initStates[i], "branchAndBound");
        }

        for (int i = 0; i < results.length; i++) {
            sb.append(String.format("For the init state (%s, %s) with the goal (15, 15) we have an efficiency of ", testCases.get(i).getx(), testCases.get(i).gety()));
            sb.append(results[i]);
            sb.append('\n');
        }

        sb.append("Average efficiency").append('\n');
        sb.append(Arrays.stream(results).average());

        System.out.println(sb);

    }
}
