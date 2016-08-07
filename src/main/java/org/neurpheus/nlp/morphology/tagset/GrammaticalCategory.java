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
 * A grammatical category is a set of features which express related conceptual
 * distinctions, and are often expressed in similar ways in a language.
 * They are often the subject of agreement constraints.
 * <p/>
 * A grammatical category is a general term. It encompasses among other things:
 * <ul>
 * <li>Grammatical aspect</li>
 * <li>Grammatical case</li>
 * <li>Grammatical mood</li>
 * <li>Definiteness</li>
 * <li>Animacy</li>
 * <li>Evidentiality</li>
 * <li>Noun class</li>
 * <li>Grammatical gender</li>
 * <li>Grammatical number</li>
 * <li>Grammatical polarity</li>
 * <li>Tense</li>
 * <li>Transitivity</li>
 * <li>Grammatical voice</li>
 * <li>Grammatical person</li>
 * </ul>
 *
 * @author Jakub Strychowski
 */
public interface GrammaticalCategory extends Serializable {

    /**
     * Returns a symbol which represents this category.
     *
     * @return A short string representing this category.
     */
    String getSymbol();

    /**
     * Sets a new value for a symbol which represents this category.
     *
     * @param newSymbol A short string representing this category.
     */
    void setSymbol(String newSymbol);

    /**
     * Returns a name of this grammatical category.
     *
     * @param languageCode The code of a language of the name.
     *
     * @return The name of the grammatical category written in the given language
     *  or <code>null</code> if the name is unavailable in the given language.
     */
    String getName(String languageCode);

    /**
     * Sets a new name for this grammatical category.
     *
     * @param languageCode The code of a language in which the name is written.
     * @param newName The new name.
     */
    void setName(String languageCode, String newName);

    /**
     * Returns a description of this grammatical category.
     *
     * @param languageCode The code of a language of the description.
     *
     * @return The description of the grammatical category written in the given language
     *  or <code>null</code> if the description is unavailable in the given language.
     */
    String getDescription(String languageCode);

    /**
     * Sets a new description for a grammatical category represented by this tag.
     *
     * @param languageCode The code of a language in which the description is written.
     * @param newDescription The new description.
     */
    void setDescription(String languageCode, String newDescription);

    /**
     * Returns a collection of language codes for which names and descriptions ara available.
     *
     * @return Collection of Strings.
     */
    Collection getLanguageCodes();

    /**
     * Returns a collection of tags belonging to this grammatical category.
     *
     * @return Collection of {@link GrammaticalTag} objects.
     */
    Collection getTags();

    /**
     * Returns a grammatical tag represented by the given symbol and belonging to this category.
     *
     * @param tagSymbol The symbol of the tag.
     * 
     * @return The tag belonging to this category and denoted by
     *  the given symbol or <code>null</code> if the tag does not belong to this category.
     */
    GrammaticalTag getTag(String tagSymbol);

    /**
     * Adds a grammatical tag to a set of tags belonging to this grammatical category.
     *
     * @param tag The tag belonging to this category.
     */
    void addTag(GrammaticalTag tag);

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
     * @param tagset The tagset for which this category is defined.
     * @throws IOException if any read error occurred.
     */
    void read(DataInputStream in, Tagset tagset) throws IOException;
    
}
