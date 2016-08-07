/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.neurpheus.nlp.morphology.baseimpl;

import org.neurpheus.nlp.morphology.baseimpl.GrammaticalTagImpl;
import java.util.Collection;
import junit.framework.TestCase;

/**
 *
 * @author jstrychowski
 */
public class GrammaticalTagImplTest extends TestCase {
    
    public GrammaticalTagImplTest(String testName) {
        super(testName);
    }            

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getSymbol method, of class GrammaticalTagImpl.
     */
    public void testGetSymbol() {
        System.out.println("getSymbol");
        String expResult = "symbol1";
        GrammaticalTagImpl instance = new GrammaticalTagImpl("symbol1");
        String result = instance.getSymbol();
        assertEquals(expResult, result);
        
        expResult = "symbol2";
        instance = new GrammaticalTagImpl("symbol2");
        result = instance.getSymbol();
        assertEquals(expResult, result);
        
        try {
            new GrammaticalTagImpl(null);
            fail("The NullPointerException should be thrown.");
        } catch (NullPointerException e) {
            // ok
        }
        
    }

    /**
     * Test of setSymbol method, of class GrammaticalTagImpl.
     */
    public void testSetSymbol() {
        System.out.println("setSymbol");
        GrammaticalTagImpl instance = new GrammaticalTagImpl();
        String newSymbol = "symbol1";
        instance.setSymbol(newSymbol);
        String result = instance.getSymbol();
        assertEquals(newSymbol, result);
        
        newSymbol = "symbol2";
        instance.setSymbol(newSymbol);
        result = instance.getSymbol();
        assertEquals(newSymbol, result);
        
        newSymbol = "symbol1";
        instance.setSymbol(newSymbol);
        result = instance.getSymbol();
        assertEquals(newSymbol, result);
        
        newSymbol = "symbol2";
        instance.setSymbol(newSymbol);
        result = instance.getSymbol();
        assertEquals(newSymbol, result);

        try {
            instance.setSymbol(null);
            fail("The NullPointerException should be thrown.");
        } catch (NullPointerException e) {
            // ok;
        }
        
        try {
            instance.setSymbol("");
            fail("The IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok;
        }

        try {
            instance.setSymbol("  \t\n");
            fail("The IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok;
        }
        
    }

    /**
     * Test of getName method, of class GrammaticalTagImpl.
     */
    public void testGetName() {
        System.out.println("getName");
        String languageCode = "en";
        GrammaticalTagImpl instance = new GrammaticalTagImpl();
        String expResult = "";
        String result = instance.getName(languageCode);
        assertEquals(expResult, result);
        
        expResult = "name1";
        languageCode = "en";
        instance.setName(languageCode, expResult);
        result = instance.getName(languageCode);
        assertEquals(expResult, result);
        
        expResult = "name2";
        languageCode = "en";
        instance.setName(languageCode, expResult);
        result = instance.getName(languageCode);
        assertEquals(expResult, result);
        
        expResult = "name1";
        languageCode = "en";
        instance.setName(languageCode, expResult);
        result = instance.getName(languageCode);
        assertEquals(expResult, result);
        
        expResult = "name3";
        languageCode = "pl";
        instance.setName(languageCode, expResult);
        result = instance.getName(languageCode);
        assertEquals(expResult, result);
        expResult = "name1";
        languageCode = "en";
        result = instance.getName(languageCode);
        assertEquals(expResult, result);
        
        
        try {
            instance.getName(null);
            fail("The NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // ok
        }
        
        try {
            instance.getName("");
            fail("The IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // ok
        }
        
    }

    /**
     * Test of setName method, of class GrammaticalTagImpl.
     */
    public void testSetName() {
        System.out.println("setName");
        
        String languageCode = "en";
        GrammaticalTagImpl instance = new GrammaticalTagImpl();
        String expResult = "name1";
        instance.setName(languageCode, expResult);
        String result = instance.getName(languageCode);
        assertEquals(expResult, result);
        
        expResult = "name2";
        instance.setName(languageCode, expResult);
        result = instance.getName(languageCode);
        assertEquals(expResult, result);

        expResult = "name1";
        instance.setName(languageCode, expResult);
        result = instance.getName(languageCode);
        assertEquals(expResult, result);

        languageCode = "pl";
        expResult = "namepl1";
        instance.setName(languageCode, expResult);
        result = instance.getName(languageCode);
        assertEquals(expResult, result);
        languageCode = "en";
        expResult = "name1";
        result = instance.getName(languageCode);
        assertEquals(expResult, result);

        expResult = "";
        instance.setName(languageCode, expResult);
        result = instance.getName(languageCode);
        assertEquals(expResult, result);
        

        try {
            instance.setName(null, "abc");
            fail("The NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // ok
        }
        
        try {
            instance.setName("en", null);
            fail("The NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // ok
        }
        

        try {
            instance.setName("", "abc");
            fail("The IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // ok
        }
     
       
        
   }

    /**
     * Test of getDescription method, of class GrammaticalTagImpl.
     */
    public void testGetDescription() {
        System.out.println("getDescription");
        String languageCode = "en";
        GrammaticalTagImpl instance = new GrammaticalTagImpl();
        String expResult = "";
        String result = instance.getDescription(languageCode);
        assertEquals(expResult, result);
        
        expResult = "description1";
        languageCode = "en";
        instance.setDescription(languageCode, expResult);
        result = instance.getDescription(languageCode);
        assertEquals(expResult, result);
        
        expResult = "description2";
        languageCode = "en";
        instance.setDescription(languageCode, expResult);
        result = instance.getDescription(languageCode);
        assertEquals(expResult, result);
        
        expResult = "description1";
        languageCode = "en";
        instance.setDescription(languageCode, expResult);
        result = instance.getDescription(languageCode);
        assertEquals(expResult, result);
        
        expResult = "description3";
        languageCode = "pl";
        instance.setDescription(languageCode, expResult);
        result = instance.getDescription(languageCode);
        assertEquals(expResult, result);
        expResult = "description1";
        languageCode = "en";
        result = instance.getDescription(languageCode);
        assertEquals(expResult, result);
        
        
        try {
            instance.getDescription(null);
            fail("The NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // ok
        }
        
        try {
            instance.getDescription("");
            fail("The IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // ok
        }
        
    }

    /**
     * Test of setDescription method, of class GrammaticalTagImpl.
     */
    public void testSetDescription() {
        System.out.println("setDescription");
        
        String languageCode = "en";
        GrammaticalTagImpl instance = new GrammaticalTagImpl();
        String expResult = "description1";
        instance.setDescription(languageCode, expResult);
        String result = instance.getDescription(languageCode);
        assertEquals(expResult, result);
        
        expResult = "description2";
        instance.setDescription(languageCode, expResult);
        result = instance.getDescription(languageCode);
        assertEquals(expResult, result);

        expResult = "description1";
        instance.setDescription(languageCode, expResult);
        result = instance.getDescription(languageCode);
        assertEquals(expResult, result);

        languageCode = "pl";
        expResult = "descriptionpl1";
        instance.setDescription(languageCode, expResult);
        result = instance.getDescription(languageCode);
        assertEquals(expResult, result);
        languageCode = "en";
        expResult = "description1";
        result = instance.getDescription(languageCode);
        assertEquals(expResult, result);

        expResult = "";
        instance.setDescription(languageCode, expResult);
        result = instance.getDescription(languageCode);
        assertEquals(expResult, result);
        

        try {
            instance.setDescription(null, "abc");
            fail("The NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // ok
        }
        
        try {
            instance.setDescription("en", null);
            fail("The NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // ok
        }
        

        try {
            instance.setDescription("", "abc");
            fail("The IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // ok
        }
        
    }

    /**
     * Test of getLanguageCodes method, of class GrammaticalTagImpl.
     */
    public void testGetLanguageCodes() {
        System.out.println("getLanguageCodes");
        
        GrammaticalTagImpl instance = new GrammaticalTagImpl();
        
        Collection codes = instance.getLanguageCodes();
        assertTrue(codes.size() == 0);
        
        instance.setName("en", "name_en");
        codes = instance.getLanguageCodes();
        assertTrue(codes.size() == 1);
        assertTrue(codes.contains("en"));
        
        instance.setDescription("en", "desc_en");
        codes = instance.getLanguageCodes();
        assertTrue(codes.size() == 1);
        assertTrue(codes.contains("en"));
        
        instance.setName("pl", "name_pl");
        codes = instance.getLanguageCodes();
        assertTrue(codes.size() == 2);
        assertTrue(codes.contains("en"));
        assertTrue(codes.contains("pl"));
        
        instance.setDescription("fr", "name_fr");
        codes = instance.getLanguageCodes();
        assertTrue(codes.size() == 3);
        assertTrue(codes.contains("en"));
        assertTrue(codes.contains("pl"));
        assertTrue(codes.contains("fr"));
        
        instance.setExamples("gr", new String[] {"name_gr"});
        codes = instance.getLanguageCodes();
        assertTrue(codes.size() == 4);
        assertTrue(codes.contains("en"));
        assertTrue(codes.contains("pl"));
        assertTrue(codes.contains("fr"));
        assertTrue(codes.contains("gr"));
        
        
    }

    /**
     * Test of toString method, of class GrammaticalTagImpl.
     */
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "s1";
        GrammaticalTagImpl instance = new GrammaticalTagImpl(expResult);
        String result = instance.toString();
        assertEquals(expResult, result);

        expResult = "s2";
        instance = new GrammaticalTagImpl(expResult);
        result = instance.toString();
        assertEquals(expResult, result);

        expResult = "s3";
        instance.setSymbol(expResult);
        result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hashCode method, of class GrammaticalTagImpl.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        GrammaticalTagImpl gt1 = new GrammaticalTagImpl("s1");
        GrammaticalTagImpl gt2 = new GrammaticalTagImpl("s2");
        GrammaticalTagImpl gt3 = new GrammaticalTagImpl("s3");
        GrammaticalTagImpl gt1b = new GrammaticalTagImpl("s1");
        
        assertTrue(gt1.hashCode() != gt2.hashCode());
        assertTrue(gt1.hashCode() != gt3.hashCode());
        assertTrue(gt2.hashCode() != gt3.hashCode());
        assertFalse(gt1.hashCode() != gt1b.hashCode());
        
    }

    /**
     * Test of equals method, of class GrammaticalTagImpl.
     */
    public void testEquals() {
        System.out.println("equals");
        GrammaticalTagImpl gt1 = new GrammaticalTagImpl("s1");
        GrammaticalTagImpl gt2 = new GrammaticalTagImpl("s2");
        GrammaticalTagImpl gt3 = new GrammaticalTagImpl("s3");
        GrammaticalTagImpl gt1b = new GrammaticalTagImpl("s1");
        
        assertTrue(gt1.equals(gt1));
        assertTrue(gt1.equals(gt1b));
        assertFalse(gt1.equals(gt2));
        assertFalse(gt1.equals(gt3));
        
        assertFalse(gt2.equals(gt1));
        assertFalse(gt2.equals(gt1b));
        assertTrue(gt2.equals(gt2));
        assertFalse(gt2.equals(gt3));
        
        assertFalse(gt3.equals(gt1));
        assertFalse(gt3.equals(gt1b));
        assertFalse(gt3.equals(gt2));
        assertTrue(gt3.equals(gt3));
        
        assertTrue(gt1b.equals(gt1));
        assertTrue(gt1b.equals(gt1b));
        assertFalse(gt1b.equals(gt2));
        assertFalse(gt1b.equals(gt3));
    }

    /**
     * Test of compareTo method, of class GrammaticalTagImpl.
     */
    public void testCompareTo() {
        System.out.println("compareTo");
        
        GrammaticalTagImpl gt1 = new GrammaticalTagImpl("s1");
        GrammaticalTagImpl gt2 = new GrammaticalTagImpl("s2");
        GrammaticalTagImpl gt3 = new GrammaticalTagImpl("s3");
        
        assertTrue(gt1.compareTo(gt1) == 0);
        assertTrue(gt1.compareTo(gt2) < 0);
        assertTrue(gt1.compareTo(gt3) < 0);
        
        assertTrue(gt2.compareTo(gt1) > 0);
        assertTrue(gt2.compareTo(gt2) == 0);
        assertTrue(gt2.compareTo(gt3) < 0);
        
        assertTrue(gt3.compareTo(gt1) > 0);
        assertTrue(gt3.compareTo(gt2) > 0);
        assertTrue(gt3.compareTo(gt3) == 0);
        
    }
    
    
    /**
     * Test of getDescription method, of class GrammaticalTagImpl.
     */
    public void testGetSetExamples() {
        System.out.println("getExamples");
        String languageCode = "en";
        GrammaticalTagImpl instance = new GrammaticalTagImpl();
        String expResult = "";
        String[] result = instance.getExamples(languageCode);
        assertTrue(result.length == 0);

        
        instance.setExamples(languageCode, new String[] {"e1"});
        result = instance.getExamples(languageCode);
        assertTrue(result.length == 1);
        assertEquals("e1", result[0]);

        
        instance.setExamples(languageCode, new String[] {"e1", "e2"});
        result = instance.getExamples(languageCode);
        assertTrue(result.length == 2);
        assertEquals("e1", result[0]);
        assertEquals("e2", result[1]);
        
        languageCode = "pl";
        instance.setExamples(languageCode, new String[] {"p1", "p2", "p3"});
        result = instance.getExamples(languageCode);
        assertTrue(result.length == 3);
        assertEquals("p1", result[0]);
        assertEquals("p2", result[1]);
        assertEquals("p3", result[2]);
        
        try {
            instance.getExamples(null);
            fail("The NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // ok
        }
        
        try {
            instance.getExamples("");
            fail("The IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // ok
        }
        
        try {
            instance.setExamples(null, new String[0]);
            fail("The NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // ok
        }
        
        try {
            instance.setExamples("pl", null);
            fail("The NullPointerException should be thrown");
        } catch (NullPointerException e) {
            // ok
        }
        
        try {
            instance.setExamples("", new String[0]);
            fail("The IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // ok
        }
        
        
    }

    

}

