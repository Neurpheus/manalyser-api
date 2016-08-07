/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.neurpheus.nlp.morphology.baseimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.TestCase;
import org.neurpheus.nlp.morphology.tagset.GrammaticalCategory;
import org.neurpheus.nlp.morphology.tagset.GrammaticalProperties;
import org.neurpheus.nlp.morphology.tagset.GrammaticalPropertiesList;
import org.neurpheus.nlp.morphology.tagset.GrammaticalTag;
import org.neurpheus.nlp.morphology.tagset.Tagset;

/**
 *
 * @author jstrychowski
 */
public class MorphologicalAnalysisResultImplTest extends TestCase {
    
    public MorphologicalAnalysisResultImplTest(String testName) {
        super(testName);
    }            

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    private GrammaticalTag createGrammaticalTag(final String prefix) {
        GrammaticalTag tag = new GrammaticalTagImpl("tag_" + prefix);
        tag.setName("pl", "polish_name_of_tag_" + prefix);
        tag.setName("en", "english_name_of_tag_" + prefix);
        tag.setDescription("pl", "polish_description_of_tag_" + prefix);
        tag.setDescription("en", "english_description_of_tag_" + prefix);
        String[] examples = new String[] 
            {"first_polish_example_of_tag_" + prefix, "second_polish_example_of_tag_" + prefix};
        tag.setExamples("pl", examples);
        examples = new String[] 
            {"first_english_example_of_tag_" + prefix, "second_english_example_of_tag_" + prefix};
        tag.setExamples("en", examples);
        return tag;
    }
    
    private GrammaticalCategory createGrammaticalCategory(final String prefix) {
        GrammaticalCategory category = new GrammaticalCategoryImpl("category_" + prefix);
        category.setName("pl", "polish_name_of_category_" + prefix);
        category.setName("en", "english_name_of_category_" + prefix);
        category.setDescription("pl", "polish_description_of_category_" + prefix);
        category.setDescription("en", "english_description_of_category_" + prefix);
        category.addTag(createGrammaticalTag(prefix + "_1"));
        category.addTag(createGrammaticalTag(prefix + "_2"));
        category.addTag(createGrammaticalTag(prefix + "_3"));
        return category;
    }
    
    private Tagset createTagset() {
        TagsetImpl tagset = new TagsetImpl();
        ArrayList categories = new ArrayList();
        GrammaticalCategory gc1 = createGrammaticalCategory("1");
        GrammaticalCategory gc2 = createGrammaticalCategory("2");
        GrammaticalCategory gc3 = createGrammaticalCategory("3");
        categories.add(gc1);
        categories.add(gc2);
        categories.add(gc3);
        tagset.setGrammaticalCategories(categories);
        return tagset;
    }
    
    /**
     * Test of getGrammaticalProperties method, of class MorphologicalAnalysisResultImpl.
     */
    public void testGetGrammaticalPropertiesList() {
        System.out.println("getGrammaticalPropertiesList");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        MorphologicalAnalysisResultImpl instance = new MorphologicalAnalysisResultImpl("test", 1.0, "test*", "*owych", gp);
        assertEquals(gp, instance.getGrammaticalPropertiesList());
    }

    /**
     * Test of setGrammaticalProperties method, of class MorphologicalAnalysisResultImpl.
     */
    public void testSetGrammaticalPropertiesList() {
        System.out.println("setGrammaticalPropertiesList");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        MorphologicalAnalysisResultImpl instance = new MorphologicalAnalysisResultImpl("test", 1.0, "test*", "*owych", gp);
        assertEquals(gp, instance.getGrammaticalPropertiesList());
        gp = tagset.getGrammaticalPropertiesList("tag_3_1:tag_3_2");
        instance.setGrammaticalPropertiesList(gp);
        assertEquals(gp, instance.getGrammaticalPropertiesList());
        try {
            instance.setGrammaticalPropertiesList(null);
            fail("The 'NullPointerException' should be thrown.");
        } catch (NullPointerException e) {
            // ok
        }
    }

    /**
     * Test of getCore method, of class MorphologicalAnalysisResultImpl.
     */
    public void testGetCore() {
        System.out.println("getCore");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        MorphologicalAnalysisResultImpl instance = new MorphologicalAnalysisResultImpl("test", 1.0, "test*", "*owych", gp);
        assertEquals("test*", instance.getCore());
    }

    /**
     * Test of setCore method, of class MorphologicalAnalysisResultImpl.
     */
    public void testSetCore() {
        System.out.println("setCore");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        MorphologicalAnalysisResultImpl instance = new MorphologicalAnalysisResultImpl("test", 1.0, "test*", "*owych", gp);
        assertEquals("test*", instance.getCore());
        instance.setCore("tt*");
        assertEquals("tt*", instance.getCore());
        try {
            instance.setCore(null);
            fail("The 'NullPointerException' should be thrown.");
        } catch (NullPointerException e) {
            // ok
        }
    }

    /**
     * Test of getGrammaticalMorphemes method, of class MorphologicalAnalysisResultImpl.
     */
    public void testGetGrammaticalMorphemes() {
        System.out.println("getGrammaticalMorphemes");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        MorphologicalAnalysisResultImpl instance = new MorphologicalAnalysisResultImpl("test", 1.0, "test*", "*owych", gp);
        assertEquals("*owych", instance.getGrammaticalMorphemes());
    }

    /**
     * Test of setGrammaticalMorphemes method, of class MorphologicalAnalysisResultImpl.
     */
    public void testSetGrammaticalMorphemes() {
        System.out.println("setGrammaticalMorphemes");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        MorphologicalAnalysisResultImpl instance = new MorphologicalAnalysisResultImpl("test", 1.0, "test*", "*owych", gp);
        assertEquals("*owych", instance.getGrammaticalMorphemes());
        instance.setGrammaticalMorphemes("*a");
        assertEquals("*a", instance.getGrammaticalMorphemes());
        try {
            instance.setGrammaticalMorphemes(null);
            fail("The 'NullPointerException' should be thrown.");
        } catch (NullPointerException e) {
            // ok
        }
    }
    
    /**
     * Test of getForm method, of class MorphologicalAnalysisResultImpl.
     */
    public void testGetForm() {
        System.out.println("getForm");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        MorphologicalAnalysisResultImpl instance = new MorphologicalAnalysisResultImpl("test", 1.0, "test*", "*owych", gp);
        assertEquals("test", instance.getForm());
    }

    /**
     * Test of setForm method, of class MorphologicalAnalysisResultImpl.
     */
    public void testSetForm() {
        System.out.println("setForm");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        MorphologicalAnalysisResultImpl instance = new MorphologicalAnalysisResultImpl("test", 1.0, "test*", "*owych", gp);
        assertEquals("test", instance.getForm());
        instance.setForm("test2");
        assertEquals("test2", instance.getForm());
        try {
            instance.setForm(null);
            fail("The NullPointerException should be thorwn.");
        } catch (NullPointerException e) {
            // ok
        }
    }

    /**
     * Test of getAccuracy method, of class MorphologicalAnalysisResultImpl.
     */
    public void testGetAccuracy() {
        System.out.println("getAccuracy");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        MorphologicalAnalysisResultImpl instance = new MorphologicalAnalysisResultImpl("test", 1.0, "test*", "*owych", gp);
        assertEquals(1.0, instance.getAccuracy(), 0);
        instance = new MorphologicalAnalysisResultImpl("test", 0.0, "test*", "*owych", gp);
        assertEquals(0.0, instance.getAccuracy(), 0);
        instance = new MorphologicalAnalysisResultImpl("test", 0.4, "test*", "*owych", gp);
        assertEquals(0.4, instance.getAccuracy(), 0);
    }

    /**
     * Test of setAccuracy method, of class MorphologicalAnalysisResultImpl.
     */
    public void testSetAccuracy() {
        System.out.println("setAccuracy");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        MorphologicalAnalysisResultImpl instance = new MorphologicalAnalysisResultImpl("test", 1.0, "test*", "*owych", gp);
        assertEquals(1.0, instance.getAccuracy(), 0);
        instance.setAccuracy(0.0);
        assertEquals(0.0, instance.getAccuracy(), 0);
        instance.setAccuracy(1.0);
        assertEquals(1.0, instance.getAccuracy(), 0);
        instance.setAccuracy(0.4);
        assertEquals(0.4, instance.getAccuracy(), 0);
        try {
            instance.setAccuracy(2.0);
            fail("The IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        }
        try {
            instance.setAccuracy(-0.4);
            fail("The IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e){
            // ok
        }

    }

    /**
     * Test of compareTo method, of class MorphologicalAnalysisResultImpl.
     */
    public void testCompareTo() {
        System.out.println("compareTo");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp1 = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        GrammaticalPropertiesList gp2 = tagset.getGrammaticalPropertiesList("tag_2_1:tag_1_2");
        GrammaticalPropertiesList gp3 = tagset.getGrammaticalPropertiesList("tag_3_1:tag_1_2");
        MorphologicalAnalysisResultImpl result1 = new MorphologicalAnalysisResultImpl("form1", 0.3, "form*", "*1", gp1);
        MorphologicalAnalysisResultImpl result2 = new MorphologicalAnalysisResultImpl("form2", 0.3, "form*", "*1", gp2);
        MorphologicalAnalysisResultImpl result3 = new MorphologicalAnalysisResultImpl("form3", 0.6, "form*", "*1", gp3);

        int result = result1.compareTo(result1);
        assertEquals(0, result);
        result = result1.compareTo(result2);
        assertEquals(-1, result);
        result = result1.compareTo(result3);
        assertEquals(1, result);

        result = result2.compareTo(result1);
        assertEquals(1, result);
        result = result2.compareTo(result2);
        assertEquals(0, result);
        result = result2.compareTo(result3);
        assertEquals(1, result);
        
        result = result3.compareTo(result1);
        assertEquals(-1, result);
        result = result3.compareTo(result2);
        assertEquals(-1, result);
        result = result3.compareTo(result3);
        assertEquals(0, result);
        
        MorphologicalAnalysisResultImpl[] table = new MorphologicalAnalysisResultImpl[3];

        table[0] = result1;
        table[1] = result2;
        table[2] = result3;
        Arrays.sort(table);
        assertEquals(table[0], result3);
        assertEquals(table[1], result1);
        assertEquals(table[2], result2);
        
        table[0] = result1;
        table[1] = result3;
        table[2] = result2;
        Arrays.sort(table);
        assertEquals(table[0], result3);
        assertEquals(table[1], result1);
        assertEquals(table[2], result2);
        
        table[0] = result2;
        table[1] = result1;
        table[2] = result3;
        Arrays.sort(table);
        assertEquals(table[0], result3);
        assertEquals(table[1], result1);
        assertEquals(table[2], result2);
        
        table[0] = result2;
        table[1] = result3;
        table[2] = result1;
        Arrays.sort(table);
        assertEquals(table[0], result3);
        assertEquals(table[1], result1);
        assertEquals(table[2], result2);
        
        table[0] = result3;
        table[1] = result1;
        table[2] = result2;
        Arrays.sort(table);
        assertEquals(table[0], result3);
        assertEquals(table[1], result1);
        assertEquals(table[2], result2);

        table[0] = result3;
        table[1] = result2;
        table[2] = result1;
        Arrays.sort(table);
        assertEquals(table[0], result3);
        assertEquals(table[1], result1);
        assertEquals(table[2], result2);
        
    }

    /**
     * Test of hashCode method, of class MorphologicalAnalysisResultImpl.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp1 = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        GrammaticalPropertiesList gp2 = tagset.getGrammaticalPropertiesList("tag_2_1:tag_1_2");
        GrammaticalPropertiesList gp3 = tagset.getGrammaticalPropertiesList("tag_3_1:tag_1_2");
        MorphologicalAnalysisResultImpl result1 = new MorphologicalAnalysisResultImpl("form1", 0.3, "form*", "*1", gp1);
        MorphologicalAnalysisResultImpl result2 = new MorphologicalAnalysisResultImpl("form2", 0.3, "form*", "*1", gp2);
        MorphologicalAnalysisResultImpl result3 = new MorphologicalAnalysisResultImpl("form3", 0.6, "form*", "*1", gp3);
        assertTrue(result1.hashCode() == result1.hashCode());
        assertTrue(result2.hashCode() == result2.hashCode());
        assertTrue(result3.hashCode() == result3.hashCode());
        assertTrue(result1.hashCode() != result2.hashCode());
        assertTrue(result1.hashCode() != result3.hashCode());
        assertTrue(result2.hashCode() != result3.hashCode());
       
    }

    /**
     * Test of equals method, of class MorphologicalAnalysisResultImpl.
     */
    public void testEquals() {
        System.out.println("equals");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp1 = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        GrammaticalPropertiesList gp2 = tagset.getGrammaticalPropertiesList("tag_2_1:tag_1_2");
        GrammaticalPropertiesList gp3 = tagset.getGrammaticalPropertiesList("tag_3_1:tag_1_2");
        MorphologicalAnalysisResultImpl result1 = new MorphologicalAnalysisResultImpl("form1", 0.3, "form*", "*1", gp1);
        MorphologicalAnalysisResultImpl result2 = new MorphologicalAnalysisResultImpl("form2", 0.3, "form*", "*1", gp2);
        MorphologicalAnalysisResultImpl result3 = new MorphologicalAnalysisResultImpl("form3", 0.6, "form*", "*1", gp3);
        MorphologicalAnalysisResultImpl result4 = new MorphologicalAnalysisResultImpl("form1", 0.6, "form*", "*1", gp1);
        
        assertTrue(result1.equals(result1));
        assertFalse(result1.equals(result2));
        assertFalse(result2.equals(result1));
        assertFalse(result1.equals(result3));
        assertFalse(result3.equals(result1));
        assertTrue(result1.equals(result4));
        assertTrue(result4.equals(result1));
        assertFalse(result3.equals(result4));
        assertFalse(result4.equals(result3));
        
    }

    /**
     * Test of writeObject method, of class MorphologicalAnalysisResultImpl.
     */
    public void testSerialization() throws Exception {
        System.out.println("writeObject");
        Tagset tagset = createTagset();
        GrammaticalPropertiesList gp1 = tagset.getGrammaticalPropertiesList("tag_1_1:tag_1_2");
        GrammaticalPropertiesList gp2 = tagset.getGrammaticalPropertiesList("tag_2_1:tag_1_2");
        GrammaticalPropertiesList gp3 = tagset.getGrammaticalPropertiesList("tag_3_1:tag_1_2");
        MorphologicalAnalysisResultImpl result1 = new MorphologicalAnalysisResultImpl("form1", 0.3, "form*", "*1", gp1);
        MorphologicalAnalysisResultImpl result2 = new MorphologicalAnalysisResultImpl("form2", 0.3, "form*", "*1", gp2);
        MorphologicalAnalysisResultImpl result3 = new MorphologicalAnalysisResultImpl("form3", 0.6, "form*", "*1", gp3);
        MorphologicalAnalysisResultImpl result4 = new MorphologicalAnalysisResultImpl("form1", 0.6, "form*", "*1", gp1);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(result1);
        oos.writeObject(result2);
        oos.writeObject(result3);
        oos.writeObject(result2);
        oos.writeObject(result1);
        oos.writeObject(result1);

        oos.close();

        byte[] data = baos.toByteArray();
        
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        
        MorphologicalAnalysisResultImpl result = (MorphologicalAnalysisResultImpl) ois.readObject();
        assertEquals(result, result1);
        result = (MorphologicalAnalysisResultImpl) ois.readObject();
        assertEquals(result, result2);
        result = (MorphologicalAnalysisResultImpl) ois.readObject();
        assertEquals(result, result3);
        result = (MorphologicalAnalysisResultImpl) ois.readObject();
        assertEquals(result, result2);
        result = (MorphologicalAnalysisResultImpl) ois.readObject();
        assertEquals(result, result1);
        result = (MorphologicalAnalysisResultImpl) ois.readObject();
        assertEquals(result, result1);

        ois.close();
        bais.close();
    }
    

}
