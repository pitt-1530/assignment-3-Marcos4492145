package edu.pitt.se;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {

    @Test
    public void testClassifyEnergyNull() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        List<Integer> testList = null; 
        assertEquals(testClass.classifyEnergy(testList),"ERROR! List cannot be NULL");
    }
    @Test
    public void testClassifyEnergyEmpty() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        List<Integer> testList = new ArrayList(); 
        assertEquals(testClass.classifyEnergy(testList),"ERROR! List cannot be empty");
    }
    @Test
    public void testClassifyEnergyAverage() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        List<Integer> testList = new ArrayList(); 
        testList.add(10);
        testList.add(35);
        testList.add(110);
        testList.add(96);
        testList.add(43);
        testList.add(22);
        testList.add(10);
        testList.add(49);
        assertEquals(testClass.classifyEnergy(testList),"LOW");
    }

    @Test
    public void testIsValidTrackTitleNull() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        String testString = null;
        assertFalse(testClass.isValidTrackTitle(testString));
    }
    @Test
    public void testIsValidTrackTitleEmpty() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        String testString = "";
        assertFalse(testClass.isValidTrackTitle(testString));
    }
    @Test
    public void testIsValidTrackTitleGreaterThan30() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        String testString = "This string is longer than thirty characters";
        assertFalse(testClass.isValidTrackTitle(testString));
    }
    @Test
    public void testIsValidTrackTitle() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        String testString = "Valid Song Title";
        assertTrue(testClass.isValidTrackTitle(testString));
    }
    @Test
    public void testIsValidTrackTitleSpecial() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        String testString = "$Invalid Song Title%";
        assertFalse(testClass.isValidTrackTitle(testString));
    }

    @Test
    public void testNormalizeVolumeOne() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        assertEquals(testClass.normalizeVolume(120), 100);
    }
    @Test
    public void testNormalizeVolumeTwo() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        assertEquals(testClass.normalizeVolume(-10), 0);
    }
    @Test
    public void testNormalizeVolumeThree() {
        PlaylistRecommender testClass = new PlaylistRecommender();
        assertEquals(testClass.normalizeVolume(16), 20);
    }

}
