/*
 * Neurpheus - Morfological Analyser
 *
 * Copyright (C) 2006-2008 Jakub Strychowski
 *
 *  This library is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU Lesser General License as published by the Free
 *  Software Foundation; either version 2.1 of the License, or (at your option)
 *  any later version.
 *
 *  This library is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *  or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General License
 *  for more details.
 */
package org.neurpheus.nlp.morphology.tagset;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

/**
 *  Represents morphological properties of a single word form.
 *
 * @author Jakub Strychowski
 */
public interface GrammaticalProperties extends Serializable, Comparable {

    /**
     * Returns a morphosyntatic mark describing the grammatical properties.
     * 
     * @return The mark describing these properties.
     */
    String getMark();

    /**
     * Sets a new morphosyntatic mark describing for this grammatical properties.
     * 
     * @param newMark The new mark for grammatical properties.
     */
    void setMark(String newMark);

    /**
     * Returns a collection of tags describing the grammatical properties of a word form.
     * 
     * 
     * @return A list of {@link GrammaticalTag} objects.
     */
    Collection getTags();

    /**
     * Sets a new list of tags describing the grammatical properties of a word form.
     * 
     * @param newTags The new set of tags describing grammatical properties.
     */
    void setTags(Collection newTags);

    /**
     * Returns a collection of tags belonging to the given grammatical category
     * and describing this grammatical properties of a word form.
     * 
     * @param category The grammatical category.
     * 
     * @return A collection of {@link GrammaticalTag} objects.
     */
    Collection  getTags(GrammaticalCategory category);

    /**
     * Checks if this grammatical properties uses a property represented by the given tag.
     * 
     * @param tag The grammatical tag representing a grammatical property.
     * 
     * @return <code>true</code> if this grammatical properties contains the given property.
     */
    boolean hasTag(GrammaticalTag tag);

    /**
     * Checks if this grammatical properties uses a property represented by the given tag symbol.
     * 
     * @param tagSymbol The symbol of grammatical tag representing a grammatical property.
     * 
     * @return <code>true</code> if this grammatical properties contains the given property.
     */
    boolean hasTag(String tagSymbol);

    /**
     * Returns a tagset which defines all tags describing grammatical properties.
     * 
     * @return The tagset defining all possible grammatical properties.
     */
    Tagset getTagset();

    /**
     * Sets a tagset which defines all tags describing grammatical properties.
     * 
     * @param newTagset The new tagset.
     */
    void setTagset(Tagset newTagset);
    
    /**
     * Checks if this grammatical properties contains all tags represented by the given properties.
     * 
     * @param properties Subset of tags which may be covered.
     * 
     * @return <code>true</code> if gramamtical properties represented by this
     *  object contain all tags from the given grammatical propertie object.
     */
    boolean covers(GrammaticalProperties properties);
    
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
     *
     * @throws IOException if any read error occurred.
     */
    void read(DataInputStream in) throws IOException;
    
}
