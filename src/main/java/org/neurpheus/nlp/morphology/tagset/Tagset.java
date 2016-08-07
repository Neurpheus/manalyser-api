/*
 * Neurpheus - Morfological Analyser
 *
 * Copyright (C) 2006-2008 Jakub Strychowski
 *
 *  This library is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU Lesser General Public License as published by the Free
 *  Software Foundation; either version 2.1 of the License, or (at your option)
 *  any later version.
 *
 *  This library is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *  or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 *  for more details.
 */
package org.neurpheus.nlp.morphology.tagset;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collection;

/**
 * Represents a set of tags describing grammatical properties of word forms.
 *
 * @author Jakub Strychowski
 */
public interface Tagset extends Serializable {

    /**
     * Tag representing unknown grammatical properties.
     */
    public static final String MARK_FOR_UNKNOWN_FORM = "xxx";

    /**
     * Reads a tagset from an XML document.
     * 
     * @param in The input stream providing the XML document.
     * 
     * @throws java.io.IOException if any input/output error occurred.
     */
    void readFromXML(InputStream in) throws IOException;

    /**
     * Writes this tagset as an XML document.
     * 
     * @param out The output stream where the XML document will be send.
     * 
     * @throws java.io.IOException if any input/output error occurred.
     */
    void writeAsXML(OutputStream out) throws IOException;

    /**
     * Returns a list of grammatical categories defined in this tagset.
     * 
     * @return The collection of objects implementing the {@link GrammaticalCategory} interface.
     */
    Collection getGrammaticalCategories();

    /**
     * Sets a new list of grammatical categories and tags for this tagset.
     * 
     * @param newCategories The collection of objects implementing the {@link GrammaticalCategory} interface.
     */
    void setGrammaticalCategories(Collection newCategories);

    /**
     * Returns a grammatical category represented by the given symbol and belonging to this tagset.
     *
     * @param categorySymbol The symbol of the category.
     * 
     * @return A grammatical category belonging to this tagset and denoted by 
     *  the given symbol, or <code>null</code> if there is no such a category.
     */
    GrammaticalCategory getGrammaticalCategory(String categorySymbol);

    /**
     * Adds the given grammatical category and its tags to this tagset.
     * 
     * @param category The grammatical category which have to be added to this tagset.
     */
    void addGrammaticalCategory(GrammaticalCategory category);

    /**
     * Returns a collection of tags defined in this tagset.
     * 
     * @return The collection of objects implementing the {@link GrammaticalTag} interface.
     */
    Collection getTags();

    /**
     * Returns a grammatical tag represented by the given symbol and belonging to this tagset.
     *
     * @param tagSymbol The symbol of the tag.
     * 
     * @return The tag belonging to this tagset and denoted by
     *  the given symbol or <code>null</code> if there is no such a tag.
     */
    GrammaticalTag getTag(String tagSymbol);

    /**
     * Returns an object representing grammatical properties defined by the given mark.
     * It is recommended that a tagset should cache result objects for 
     * common marks to speed up processing.
     * 
     * @param mark The mark of grammatical properties.
     * 
     * @return The result grammatical properties.
     */
    GrammaticalProperties getGrammaticalProperties(String mark);
  
    /**
     * Return an object representing a list of grammatical properties
     * defined byt the given list of marks
     * 
     * @param marks List of marks separated by the '+' sign.
     * 
     * @return Teh result list of grammatical properties.
     */
    GrammaticalPropertiesList getGrammaticalPropertiesList(String marks);
    
    /**
     * Creates a new grammatical category which can be added to a tagset.
     * 
     * @param categorySymbol The symbol of the category.
     * 
     * @return Created category.
     */
    GrammaticalCategory createGrammaticalCategory(String categorySymbol);
    
    /**
     * Creates a new grammatical tag which can be added to a grammatical category.
     * 
     * @param tagSymbol The symbol of the tag.
     * 
     * @return Created tag.
     */
    GrammaticalTag createGrammaticalTag(String tagSymbol);
    
    /**
     * Returns grammatical properties for an unknown word form.
     * 
     * @return The grammatical properties marked by the "xxx" string.
     */
    GrammaticalProperties getUnknownGrammaticalProperties();
    
    /**
     * Returns list of grammatical properties for an unknown word form.
     * 
     * @return The grammatical properties marked by the "xxx" string.
     */
    GrammaticalPropertiesList getUnknownGrammaticalPropertiesList();

    /**
     * Returns an object representing grammatical properties defined by the given id.
     * 
     * @param id The unique id of grammatical properties.
     * 
     * @return The result grammatical properties.
     */
    GrammaticalProperties getGrammaticalPropertiesById(int id);
    
    /**
     * Returns an object representing grammatical properties list defined by the given id.
     * 
     * @param id The unique id of grammatical properties list.
     * 
     * @return The result grammatical properties list.
     */
    GrammaticalPropertiesList getGrammaticalPropertiesListById(int id);

    /**
     * Removes all descriptions of tags and categories.     
     */
    void compact();

    /**
     * Writes this object into the given data output stream.
     *
     * @param out   The output stream where this tagset should be stored.
     *
     * @throws IOException if any write error occurred.
     */
    void write(final DataOutputStream out) throws IOException;

    /**
     * Reads this object from the given data input stream.
     *
     * @param in The input stream from which this object should be read.
     *
     * @throws IOException if any read error occurred.
     */
    void read(DataInputStream in) throws IOException;

}
