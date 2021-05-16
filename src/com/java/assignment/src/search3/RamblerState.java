/*
 *	State in a map search
 *	Phil Green 2013 version
 * Heidi Christensen (heidi.christensen@sheffield.ac.uk) 2021 version
 */

import java.util.*;

public class RamblerState extends SearchState {

    // pixel for this state
    private Coords pixel;

    // constructor
    public RamblerState(Coords coords, int lc) {
        pixel = coords;
        localCost = lc;
    }

    // accessor
    public Coords getPixel() {
        return pixel;
    }


    // goalPredicate
    public boolean goalPredicate(Search searcher) {
        RamblerSearch ramblerSearch = (RamblerSearch) searcher;
        Coords goal = ramblerSearch.getGoal(); // get target city
        return pixel.equals(goal);
    }

    // getSuccessors
    public ArrayList<SearchState> getSuccessors(Search searcher) {
        RamblerSearch ramblerSearch = (RamblerSearch) searcher;
        TerrainMap map = ramblerSearch.getMap();
        ArrayList<SearchState> succs = new ArrayList<SearchState>();
        int cost;
        int[][] tpmap = map.getTmap();

        //North Step
        if(pixel.gety() - 1 >= 0) {
            int heightDiff = tpmap[pixel.getx()][pixel.gety() - 1] - tpmap[pixel.getx()][pixel.gety()];
            cost = heightDiff <= 0 ? 1 : 1 + Math.abs(heightDiff);
            succs.add(new RamblerState(new Coords(pixel.gety() - 1, pixel.getx()), cost));
        }

        //East Step
        if(pixel.getx() + 1 < map.getWidth()){
            int heightDiff = tpmap[pixel.getx() + 1][pixel.gety()] - tpmap[pixel.getx()][pixel.gety()];
            cost = heightDiff <= 0 ? 1 : 1 + Math.abs(heightDiff);
            succs.add(new RamblerState(new Coords(pixel.gety(), pixel.getx() + 1), cost));
        }

        //South Step
        if(pixel.gety() + 1 < map.getHeight()){
            int heightDiff = tpmap[pixel.getx()][pixel.gety() + 1] - tpmap[pixel.getx()][pixel.gety()];
            cost = heightDiff <= 0 ? 1 : 1 + Math.abs(heightDiff);
            succs.add(new RamblerState(new Coords(pixel.gety() + 1, pixel.getx()), cost));
        }

        //West Step
        if(pixel.getx() - 1 >= 0){
            int heightDiff = tpmap[pixel.getx() - 1][pixel.gety()] - tpmap[pixel.getx()][pixel.gety()];
            cost = heightDiff <= 0 ? 1 : 1 + Math.abs(heightDiff);
            succs.add(new RamblerState(new Coords(pixel.gety(), pixel.getx() - 1), cost));
        }


        return succs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RamblerState that = (RamblerState) o;
        return getPixel().equals(that.getPixel());
    }

    // sameState
    public boolean sameState(SearchState s2) {
        RamblerState rs2 = (RamblerState) s2;
        return rs2.equals(this);
    }

    // toString
    public String toString() {
        return ("Pixel coord:(" + pixel.getx() + " , " + pixel.gety() + ");");
    }



}

