import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HammurabiTest {

    @org.junit.Test
    public void setYearTest() {
        //given
        Hammurabi h = new Hammurabi();

        //when
        h.setYear(0);
        h.setYear(h.getYear()+1);

        //then
        Assert.assertEquals(1, h.getYear());
    }

    @org.junit.Test
    public void setYearTest1() {
        //given
        Hammurabi h = new Hammurabi();

        //when
        h.setYear(10);
        h.setYear(h.getYear()-1);

        //then
        Assert.assertEquals(9, h.getYear());
    }

    @Test
    public void setPopulation() {
        //given
        Hammurabi h = new Hammurabi();

        //when
        h.setPopulation(5);
        h.setPopulation(h.getPopulation() + 15);

        //then
        Assert.assertEquals(20, h.getPopulation());
    }

    @Test
    public void setPopulationTest() {
        //given
        Hammurabi h = new Hammurabi();

        //when
        h.setPopulation(50);
        h.setPopulation(h.getPopulation() / 2);

        //then
        Assert.assertEquals(25, h.getPopulation());
    }

    @Test
    public void setBushels() {
        //given
        Hammurabi h = new Hammurabi();

        //when
        h.setBushels(3000);
        h.setBushels(h.getBushels() - 200);

        //then
        Assert.assertEquals(2800, h.getBushels());
    }

    @Test
    public void setLandOwned() {
        Hammurabi h = new Hammurabi();

        h.setLandOwned(0);
        h.setLandOwned(20);

        Assert.assertEquals(20, h.getLandOwned());
    }

    @Test
    public void setLandSellPrice() {
        Hammurabi h = new Hammurabi();

        h.setLandSellPrice(18);
        h.setLandSellPrice(22);

        Assert.assertEquals(22, h.getLandSellPrice());
    }

    @Test
    public void setStarved() {
        Hammurabi h = new Hammurabi();

        h.setStarved(0);
        h.setStarved(50);
        h.setStarved(h.getStarved()+1);

        Assert.assertEquals(51, h.getStarved());
    }

    @Test
    public void setNewPeople() {
        Hammurabi h = new Hammurabi();

        h.setNewPeople(0);
        h.setNewPeople(5);

        Assert.assertEquals(5, h.getNewPeople());
    }

    @Test
    public void setBushelsPerAcre() {
        Hammurabi h = new Hammurabi();

        h.setBushelsPerAcre(18);

        Assert.assertEquals(18, h.getBushelsPerAcre());
    }

    @Test
    public void setBushelsHarvested() {
        Hammurabi h = new Hammurabi();

        h.setBushelsHarvested(4);

        Assert.assertEquals(4, h.getBushelsHarvested());
    }

    @Test
    public void setBushelsDestroyed() {
        Hammurabi h = new Hammurabi();

        h.setBushelsDestroyed(20);

        Assert.assertEquals(20, h.getBushelsDestroyed());
    }
}