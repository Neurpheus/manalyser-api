/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.neurpheus.nlp.morphology.tagset;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Represents a set of grammatical properties.
 * 
 * @author Jakub Strychowski
 */
public interface GrammaticalPropertiesList  extends Serializable, Comparable {
    
    public final static String MARK_SEPARATOR = "+";

    
    /**
     * Returns a list of grammatical properties
     * 
     * @return The list of {@link GrammaticalProperties} objects.
     */
    List getGrammaticalProperties();
    
    /**
     * Sets a list of grammatical properties
     * 
     * @param newList The list of {@link GrammaticalProperties} objects.
     */
    void setGrammaticalProperties(List newList);
    
    
    /**
     * Merges two list of grammatical properties into one.
     * 
     * @param gpl The grammatiacal properties list which should be merged with thin one.
     */
    void merge(GrammaticalPropertiesList gpl);
    
    /**
     * Checks if this list of grammatical properties contains grammatical properties
     * covering the given properties.
     * 
     * 
     * @param properties Subset of tags which may be covered.
     * 
     * @return <code>true</code> if one of gramamtical properties represented by this
     *  object contain all tags from the given grammatical propertie object.
     */
    boolean covers(GrammaticalProperties properties);
    
    /**
     * Removes all duplicated grammatical properties.
     * 
     * @param tagset The tagset containing definitions of all tags.
     */
    void normalize(Tagset tagset);
    
    /**
     * Returns a unique identifier of this object.
     * 
     * @return The unique identifier.
     */
    int getId();
    
    /**
     * Sets a unique identifier for this object.
     * 
     * @param newId The unique identifier.
     */
    void setId(int newId);
    

    /**
     * Writes this object into the given data output stream.
     *
     * @param out   The output stream where this object should be stored.
     *
     * @throws IOException if any write error occurred.
     */
    void write(final DataOutputStream out) throws IOException;

    /**
     * Reads this object from the given data input stream.
     *
     * @param in The input stream from which this object should be read.
     * @param tagset The tagset for which this category is defined.
     *
     * @throws IOException if any read error occurred.
     */
    void read(DataInputStream in, Tagset tagset) throws IOException;

}
