
public class RunRamblerBB{

    public static void main(String[] arg) {

        TerrainMap map1 = new TerrainMap("src/search3/tmc.pgm");

        RamblerSearch searcher = new RamblerSearch(map1, new Coords(2,12));
        SearchState initState = (SearchState) new RamblerState(new Coords(6, 3), 0);

        String res_bb = searcher.runSearch(initState, "branchAndBound");
        System.out.println(res_bb);
    }
}
