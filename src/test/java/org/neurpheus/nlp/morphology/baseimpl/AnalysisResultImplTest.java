/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.neurpheus.nlp.morphology.baseimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import junit.framework.TestCase;

/**
 * Test base implementation of the AnalysisResult interface.
 * 
 * @author Jakub Strychowski
 */
public class AnalysisResultImplTest extends TestCase {
    
    public AnalysisResultImplTest(String testName) {
        super(testName);
    }            

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getForm method, of class AnalysisResultImpl.
     */
    public void testGetForm() {
        System.out.println("getForm");
        AnalysisResultImpl instance = new AnalysisResultImpl();
        String expResult = "";
        String result = instance.getForm();
        assertEquals(expResult, result);
        
        expResult = "test123";
        instance = new AnalysisResultImpl(expResult, 0);
        result = instance.getForm();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setForm method, of class AnalysisResultImpl.
     */
    public void testSetForm() {
        System.out.println("setForm");
        String formValue = "test456";
        AnalysisResultImpl instance = new AnalysisResultImpl();
        instance.setForm(formValue);
        String result = instance.getForm();
        assertEquals(formValue, result);
        formValue = "test456567";
        instance.setForm(formValue);
        result = instance.getForm();
        assertEquals(formValue, result);
        try {
            instance.setForm(null);
            fail("The NullPointerException should be thorwn.");
        } catch (NullPointerException e) {
            // ok
        }
    }

    /**
     * Test of getAccuracy method, of class AnalysisResultImpl.
     */
    public void testGetAccuracy() {
        System.out.println("getAccuracy");
        AnalysisResultImpl instance = new AnalysisResultImpl();
        double expResult = 0.0;
        double result = instance.getAccuracy();
        assertEquals(expResult, result, 0.0);
        

        expResult = 1.0;
        instance = new AnalysisResultImpl("", expResult);
        result = instance.getAccuracy();
        assertEquals(expResult, result, 0.0);
        
        expResult = 0.4;
        instance = new AnalysisResultImpl("", expResult);
        result = instance.getAccuracy();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of setAccuracy method, of class AnalysisResultImpl.
     */
    public void testSetAccuracy() {
        System.out.println("setAccuracy");
        double accuracyValue = 0.3;
        AnalysisResultImpl instance = new AnalysisResultImpl();
        instance.setAccuracy(accuracyValue);
        double result = instance.getAccuracy();
        assertEquals(accuracyValue, result, 0.0);
        
        accuracyValue = 0.6;
        instance.setAccuracy(accuracyValue);
        result = instance.getAccuracy();
        assertEquals(accuracyValue, result, 0.0);
        
        accuracyValue = 1.0;
        instance.setAccuracy(accuracyValue);
        result = instance.getAccuracy();
        assertEquals(accuracyValue, result, 0.0);
        
        accuracyValue = 0.0;
        instance.setAccuracy(accuracyValue);
        result = instance.getAccuracy();
        assertEquals(accuracyValue, result, 0.0);
        
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
     * Test of compareTo method, of class AnalysisResultImpl.
     */
    public void testCompareTo() {
        System.out.println("compareTo");
        AnalysisResultImpl result1 = new AnalysisResultImpl("form1", 0.3);
        AnalysisResultImpl result2 = new AnalysisResultImpl("form2", 0.3);
        AnalysisResultImpl result3 = new AnalysisResultImpl("form3", 0.6);

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
        
        AnalysisResultImpl[] table = new AnalysisResultImpl[3];

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
     * Test of hashCode method, of class AnalysisResultImpl.
     */
    public void testHashCode() {
        System.out.println("hashCode");
        
        AnalysisResultImpl result1 = new AnalysisResultImpl("form1", 0.3);
        AnalysisResultImpl result2 = new AnalysisResultImpl("form2", 0.3);
        AnalysisResultImpl result3 = new AnalysisResultImpl("form3", 0.6);

        assertTrue(result1.hashCode() == result1.hashCode());
        assertTrue(result2.hashCode() == result2.hashCode());
        assertTrue(result3.hashCode() == result3.hashCode());
        assertTrue(result1.hashCode() != result2.hashCode());
        assertTrue(result1.hashCode() != result3.hashCode());
        assertTrue(result2.hashCode() != result3.hashCode());
       
    }

    /**
     * Test of equals method, of class AnalysisResultImpl.
     */
    public void testEquals() {
        System.out.println("equals");
        
        AnalysisResultImpl result1 = new AnalysisResultImpl("form1", 0.3);
        AnalysisResultImpl result2 = new AnalysisResultImpl("form1", 0.3);
        AnalysisResultImpl result3 = new AnalysisResultImpl("form3", 0.6);
        AnalysisResultImpl result4 = new AnalysisResultImpl("form1", 0.6);
        
        assertTrue(result1.equals(result1));
        assertTrue(result1.equals(result2));
        assertTrue(result2.equals(result1));
        assertFalse(result1.equals(result3));
        assertFalse(result3.equals(result1));
        assertTrue(result1.equals(result4));
        assertTrue(result4.equals(result1));
        assertFalse(result3.equals(result4));
        assertFalse(result4.equals(result3));
        
    }

    /**
     * Test of writeObject method, of class AnalysisResultImpl.
     */
    public void testSerialization() throws Exception {
        System.out.println("writeObject");
        AnalysisResultImpl result1 = new AnalysisResultImpl("form1", 0.3);
        AnalysisResultImpl result2 = new AnalysisResultImpl("form2", 0.3);
        AnalysisResultImpl result3 = new AnalysisResultImpl("form3", 0.6);
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
        
        AnalysisResultImpl result = (AnalysisResultImpl) ois.readObject();
        assertEquals(result, result1);
        result = (AnalysisResultImpl) ois.readObject();
        assertEquals(result, result2);
        result = (AnalysisResultImpl) ois.readObject();
        assertEquals(result, result3);
        result = (AnalysisResultImpl) ois.readObject();
        assertEquals(result, result2);
        result = (AnalysisResultImpl) ois.readObject();
        assertEquals(result, result1);
        result = (AnalysisResultImpl) ois.readObject();
        assertEquals(result, result1);

        ois.close();
        bais.close();
    }


}
