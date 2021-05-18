public class RamblerSearch extends Search {
    private TerrainMap map;
    private Coords goal;

    public TerrainMap getMap() {
        return map;
    }

    public Coords getGoal() {
        return goal;
    }

    public RamblerSearch(TerrainMap m, Coords g) {
        map = m;
        goal = g;
    }

}
