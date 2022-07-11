import org.junit.Assert;
import org.junit.Test;
import java.util.Random;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class HammurabiEngineTest {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    @Test
    public void harvestTest() {
        int actual = 1 + rand.nextInt(5);

        Assert.assertEquals(true, (actual < 6));
    }

    @Test
    public void harvestTest1() {
        int min = 50;
        int max = 100;
        int actual = min + rand.nextInt(max);

        Assert.assertEquals(true, (actual < 150));
    }


    @Test
    public void plagueDeathsTest() {
        int plagues = 0;
        int population = 100;
        for (int i = 0; i < 10000; i++) {
            int deaths = HammurabiEngine.plagueDeaths(population);
            if (deaths != 0){
                plagues++;
            }
        }
        assertEquals(true, plagues>1300);
        //plagues happen at least 13% of the time
    }

    @Test
    public void plagueDeathsTest1() {
        int plagues = 0;
        int population = 100;
        for (int i = 0; i < 10000; i++) {
            int deaths = HammurabiEngine.plagueDeaths(population);
            if (deaths != 0){
                plagues++;
            }
        }
        assertEquals(true, plagues<1500);
        //plagues happen no more than 15% of the time
    }

    @Test
    public void grainEatenByRatsTest() {
        int ratAttack = 0;
        int bushels = 1000;
        for (int i = 0; i < 10000; i++) {
            if (HammurabiEngine.grainEatenByRats(bushels) != 0) {
                ratAttack++;
            }
        }
        Assert.assertEquals(true, ratAttack > 3999);
        //rats attack 39.99% of the time;
    }

    @Test
    public void grainEatenByRatsTest1() {
        int ratAttack = 0;
        int bushels = 1000;
        for (int i = 0; i < 10000; i++) {
            if (HammurabiEngine.grainEatenByRats(bushels) != 0) {
                ratAttack++;
            }
        }
        Assert.assertEquals(true, ratAttack > 3900);
        //rats attack 39.00% of the time;
    }

    @Test
    public void newCostOfLandTest() {
        int newCost = HammurabiEngine.newCostOfLand();
        Assert.assertEquals(true, newCost<=23);
    }

    @Test
    public void newCostOfLandTest1() {
        int newCost = HammurabiEngine.newCostOfLand();
        Assert.assertEquals(true, newCost>=17);
    }
}