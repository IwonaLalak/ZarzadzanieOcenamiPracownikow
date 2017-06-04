package sample.tests;

import org.junit.Assert;
import org.junit.Test;
import sample.configuration.Tabs;


public class TabsTest {

    @Test
    public void PRACOWNICYTest() throws Exception{
        Tabs tabs = new Tabs();
        Assert.assertEquals(tabs.PRACOWNICY, "Pracownicy");
    }

    @Test
    public void DZIAŁYTest() throws Exception{
        Tabs tabs = new Tabs();
        Assert.assertEquals(tabs.DZIALY, "Działy");
    }

    @Test
    public void ANKIETYTest() throws Exception{
        Tabs tabs = new Tabs();
        Assert.assertEquals(tabs.ANKIETY, "Ankiety");
    }

    @Test
    public void GŁOSOWANIETest() throws Exception{
        Tabs tabs = new Tabs();
        Assert.assertEquals(tabs.GLOSOWANIE, "Głosowanie");
    }

    @Test
    public void GŁOSUJTest() throws Exception{
        Tabs tabs = new Tabs();
        Assert.assertEquals(tabs.GLOSUJ, "Głosuj");
    }
}
