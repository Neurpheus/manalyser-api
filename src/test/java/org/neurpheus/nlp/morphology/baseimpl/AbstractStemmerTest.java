/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.neurpheus.nlp.morphology.baseimpl;

import java.util.Locale;
import junit.framework.TestCase;
import org.neurpheus.nlp.morphology.AnalysisResult;
import org.neurpheus.nlp.morphology.DefaultMorphologyFactory;
import org.neurpheus.nlp.morphology.Stemmer;

/**
 *
 * @author jstrychowski
 */
public class AbstractStemmerTest extends TestCase {
    
    public AbstractStemmerTest(String testName) {
        super(testName);
    }            

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getStem method, of class AbstractStemmer.
     */
    public void testGetStem() throws Exception {
        System.out.println("getStem");
        Stemmer stemmer = DefaultMorphologyFactory.getInstance().getStemmer(Locale.ENGLISH, "name", "TestStemmer");
        assertEquals("test_1", stemmer.getStem("test"));
    }

    /**
     * Test of getStems method, of class AbstractStemmer.
     */
    public void testGetStems() throws Exception {
        System.out.println("getStems");
        Stemmer stemmer = DefaultMorphologyFactory.getInstance().getStemmer(Locale.ENGLISH, "name", "TestStemmer");
        String[] result = stemmer.getStems("test");
        assertEquals(3, result.length);
        assertEquals("test_1", result[0]);
        assertEquals("test_2", result[1]);
        assertEquals("test_3", result[2]);
    }

    /**
     * Test of getStemmingResult method, of class AbstractStemmer.
     */
    public void testGetStemmingResult() throws Exception {
        System.out.println("getStemmingResult");
        Stemmer stemmer = DefaultMorphologyFactory.getInstance().getStemmer(Locale.ENGLISH, "name", "TestStemmer");
        AnalysisResult result = stemmer.getStemmingResult("test");
        assertEquals("test_1", result.getForm());
        assertEquals(0.7, result.getAccuracy(), 0);
    }

    /**
     * Test of getStemmingResults method, of class AbstractStemmer.
     */
    public void testGetStemmingResults() throws Exception {
        System.out.println("getStemmingResults");
        Stemmer stemmer = DefaultMorphologyFactory.getInstance().getStemmer(Locale.ENGLISH, "name", "TestStemmer");
        AnalysisResult[] result = stemmer.getStemmingResults("test");
        assertEquals(3, result.length);
        assertEquals("test_1", result[0].getForm());
        assertEquals(0.7, result[0].getAccuracy(), 0);
        assertEquals("test_2", result[1].getForm());
        assertEquals(0.2, result[1].getAccuracy(), 0);
        assertEquals("test_3", result[2].getForm());
        assertEquals(0.1, result[2].getAccuracy(), 0);
    }

}
