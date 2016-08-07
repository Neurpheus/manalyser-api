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
import java.io.Serializable;
import java.util.Collection;

/**
 * Represents a mark which assigns a grammatical property to word forms.
 *
 * @author Jakub Strychowski
 */
public interface GrammaticalTag extends Serializable {


    /**
     * Returns a symbol which marks word forms.
     *
     * @return A short string used for tagging.
     */
    String getSymbol();

    /**
     * Sets a new value for a symbol used as a mark of a grammatical property.
     *
     * @param newSymbol A short string used for tagging.
     */
    void setSymbol(String newSymbol);

    /**
     * Returns a name of a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language of the name.
     *
     * @return The name of the grammatical property written in the given language 
     *  or an empty string if the name is unavailable in the given language.
     */
    String getName(String languageCode);

    /**
     * Sets a new name for a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language in which the name is written.
     * @param newName The new name.
     */
    void setName(String languageCode, String newName);

    /**
     * Returns a description of a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language of the description.
     *
     * @return The description of the grammatical property written in the given language 
     *  or an empty string if the description is unavailable in the given language.
     */
    String getDescription(String languageCode);

    /**
     * Sets a new description for a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language in which the description is written.
     * @param newDescription The new description.
     */
    void setDescription(String languageCode, String newDescription);

    /**
     * Returns example word forms described by a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language of the examples.
     *
     * @return The example word forms or an empty array if the are no examples for the given language.
     */
    String[] getExamples(String languageCode);

    /**
     * Sets new example word forms for a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language of the examples.
     * @param newExamples The array of examples.
     */
    void setExamples(String languageCode, String[] newExamples);
    
    /**
     * Returns a collection of language codes for which names and descriptions ara available.
     * 
     * @return Collection of Strings.
     */
    Collection getLanguageCodes();
    
    /**
     * Removes all descriptions.
     */
    void compact();

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
