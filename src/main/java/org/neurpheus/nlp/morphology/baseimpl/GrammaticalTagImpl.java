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
package org.neurpheus.nlp.morphology.baseimpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.neurpheus.nlp.morphology.tagset.GrammaticalTag;

/**
 * Represents a mark which assigns a grammatical property to word forms.
 *
 * @author Jakub Strychowski
 */
public class GrammaticalTagImpl implements GrammaticalTag {

    /** Identifier of this class. */
    protected static final long serialVersionUID = -770608080316222839L;
    /** The symbol marking unknown tags.*/
    public static final String SYMBOL_OF_UNKNOWN_TAG = "unknown";
    /** The symbol of this tag. */
    private String symbol;
    /** The names of this tag. */
    private Map names;
    /** The descriptions of this tag. */
    private Map descriptions;
    /** The example word forms descibed by this tag. */
    private Map examples;

    /**
     * Constructs an instances of the grammatical tag.
     */
    public GrammaticalTagImpl() {
        symbol = SYMBOL_OF_UNKNOWN_TAG;
        names = new HashMap();
        descriptions = new HashMap();
        examples = new HashMap();
    }

    /**
     * Constructs an instances of the grammatical tag marked by the given symbol. 
     * 
     * @param tagSymbol The symbol of the constructed tag.
     */
    public GrammaticalTagImpl(final String tagSymbol) {
        if (tagSymbol == null) {
            throw new NullPointerException("The [tagSymbol] argument cannot be null.");
        }
        if (tagSymbol.trim().length() == 0) {
            throw new IllegalArgumentException("The [tagSymbol] argument cannot be empty.");
        }
        symbol = tagSymbol;
        names = new HashMap();
        descriptions = new HashMap();
        examples = new HashMap();
    }

    /**
     * Returns a symbol which marks word forms.
     *
     * @return A short string used for tagging.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets a new value for a symbol used as a mark of a grammatical property.
     *
     * @param newSymbol A short string used for tagging.
     */
    public void setSymbol(final String newSymbol) {
        if (newSymbol == null) {
            throw new NullPointerException("The [newSymbol] argument cannot be null.");
        }
        if (newSymbol.trim().length() == 0) {
            throw new IllegalArgumentException("The [newSymbol] argument cannot be empty.");
        }
        symbol = newSymbol;
    }

    /**
     * Returns a name of a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language of the name.
     *
     * @return The name of the grammatical property written in the given language 
     *  or an empty string if the name is unavailable in the given language.
     */
    public String getName(final String languageCode) {
        if (languageCode == null) {
            throw new NullPointerException("The [languageCode] argument cannot be null.");
        }
        if (languageCode.length() == 0) {
            throw new IllegalArgumentException("The [languageCode] argument cannot be empty.");
        }
        Object res = names.get(languageCode);
        return res == null ? "" : res.toString();
    }

    /**
     * Sets a new name for a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language in which the name is written.
     * @param newName The new name.
     */
    public void setName(final String languageCode, final String newName) {
        if (languageCode == null) {
            throw new NullPointerException("The [languageCode] argument cannot be null.");
        }
        if (languageCode.length() == 0) {
            throw new IllegalArgumentException("The [languageCode] argument cannot be empty.");
        }
        if (newName == null) {
            throw new NullPointerException("The [newName] argument cannot be null.");
        }
        names.put(languageCode, newName);
    }

    /**
     * Returns a description of a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language of the description.
     *
     * @return The description of the grammatical property written in the given language 
     *  or an empty string if the description is unavailable in the given language.
     */
    public String getDescription(final String languageCode) {
        if (languageCode == null) {
            throw new NullPointerException("The [languageCode] argument cannot be null.");
        }
        if (languageCode.length() == 0) {
            throw new IllegalArgumentException("The [languageCode] argument cannot be empty.");
        }
        Object res = descriptions.get(languageCode);
        return res == null ? "" : res.toString();
    }

    /**
     * Sets a new description for a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language in which the description is written.
     * @param newDescription The new description.
     */
    public void setDescription(final String languageCode, final String newDescription) {
        if (languageCode == null) {
            throw new NullPointerException("The [nlanguageCode argument cannot be null.");
        }
        if (languageCode.length() == 0) {
            throw new IllegalArgumentException("The [languageCode] argument cannot be empty.");
        }
        if (newDescription == null) {
            throw new NullPointerException("The [newDescription] argument cannot be null.");
        }
        descriptions.put(languageCode, newDescription);
    }

    /**
     * Returns a collection of language codes for which names and descriptions ara available.
     * 
     * @return Collection of Strings.
     */
    public Collection getLanguageCodes() {
        HashSet result = new HashSet(names.keySet());
        result.addAll(descriptions.keySet());
        result.addAll(examples.keySet());
        return result;
    }

    /**
     * Returns string representation of this object - a symbol this tag.
     * 
     * @return The symbol of this grammatical tag.
     */
    public String toString() {
        return symbol;
    }

    /**
     * Returns almost unique identifier of this object.
     * 
     * @return The hash code of the symbol of this grammatical tag.
     */
    public int hashCode() {
        return symbol.hashCode() + (int) serialVersionUID;
    }

    /**
     * Checks if this tag is equal to the given object.
     * 
     * @param obj The object with which to compare.
     * 
     * @return <code>true</code> if the given object represents the same 
     *  grammatical property as this tag.
     */
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof GrammaticalTag) {
            return symbol.equals(((GrammaticalTag) obj).getSymbol());
        } else {
            return false;
        }
    }

    /**
     * Compare this grammatical tag with other objects.
     * 
     * @param obj The object with which to compare.
     * 
     * @return vale equal to 0 , greater then 0 or lower then 0 according to 
     *  the order of symbols of compared grammatical tags.
     */
    public int compareTo(final Object obj) {
        if (obj != null && obj instanceof GrammaticalTag) {
            GrammaticalTag gt = (GrammaticalTag) obj;
            return symbol.compareTo(gt.getSymbol());
        } else {
            return 1;
        }
    }
    
    /**
     * Returns example word forms described by a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language of the examples.
     *
     * @return The example word forms or an empty array if the are no examples for the given language.
     */
    public String[] getExamples(final String languageCode) {
        if (languageCode == null) {
            throw new NullPointerException("The [languageCode] argument cannot be null.");
        }
        if (languageCode.length() == 0) {
            throw new IllegalArgumentException("The [languageCode] argument cannot be empty.");
        }
        String[] res = (String[]) examples.get(languageCode);
        if (res == null) {
            res = new String[0];
        }
        return res;
    }

    /**
     * Sets new example word forms for a grammatical property represented by this tag.
     * 
     * @param languageCode The code of a language of the examples.
     * @param newExamples The array of examples.
     */
    public void setExamples(final String languageCode, final String[] newExamples) {
        if (newExamples == null) {
            throw new NullPointerException("The [newExamples] argument cannot be null.");
        }
        if (languageCode == null) {
            throw new NullPointerException("The [languageCode] argument cannot be null.");
        }
        if (languageCode.length() == 0) {
            throw new IllegalArgumentException("The [languageCode] argument cannot be empty.");
        }
        examples.put(languageCode, newExamples);
    }
    
    /**
     * Removes all descriptions of tags and categories.     
     */
    public void compact() {
        descriptions.clear();
    }

    /**
     * Writes this object into the given data output stream.
     *
     * @param out   The output stream where this tagset should be stored.
     *
     * @throws IOException if any write error occurred.
     */
    public void write(final DataOutputStream out) throws IOException {
        TagsetStreamPacker.writeString(symbol, out);
        TagsetStreamPacker.writeStringsMap(names, out);
        TagsetStreamPacker.writeStringsMap(descriptions, out);
        TagsetStreamPacker.writeStringArrayMap(examples, out);
    }

    /**
     * Reads this object from the given data input stream.
     *
     * @param in The input stream from which this object should be read.
     *
     * @throws IOException if any read error occurred.
     */
    public void read(DataInputStream in) throws IOException {
        symbol = TagsetStreamPacker.readString(in);
        names = TagsetStreamPacker.readStringsMap(in);
        descriptions = TagsetStreamPacker.readStringsMap(in);
        examples = TagsetStreamPacker.readStringArrayMap(in);
    }

}
