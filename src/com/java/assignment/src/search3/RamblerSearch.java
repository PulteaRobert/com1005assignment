/*
 *       MapSearch.java
 *
 *       search for map traversal
 * Phil Green 2013 version
 * Heidi Christensen (heidi.christensen@sheffield.ac.uk) 2021 version
 */

import java.util.*;

public class RamblerSearch extends Search {
    private TerrainMap map;
    private Coords goal; // goal city

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
