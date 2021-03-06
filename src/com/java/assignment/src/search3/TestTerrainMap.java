
/**
  * TestTerrainMap.java
  *
  * Phil Green 2013 version
  * Heidi Christensen 2021 version
  * 
  * Example of how you load a terrain map
*/

import java.io.FileNotFoundException;

public class TestTerrainMap {

  /**
   * constructor, given a PGM image Reads a PGM file. The maximum greyscale value
   * is rescaled to be between 0 and 255.
   * 
   * @param arg // - filename
   * @return
   * @throws FileNotFoundException
   */

  public static void main(String[] arg) {

    TerrainMap tm = new TerrainMap("src/search3/tmc.pgm");
    System.out.println(tm.getWidth());
    System.out.println(tm.getTmap()[7][2]);

  }
}
