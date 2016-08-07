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
import java.util.Iterator;
import java.util.Map;
import org.neurpheus.nlp.morphology.tagset.GrammaticalCategory;
import org.neurpheus.nlp.morphology.tagset.GrammaticalTag;
import org.neurpheus.nlp.morphology.tagset.Tagset;

/**
 * Represents a grammatical category.
 *
 * @author Jakub Strychowski
 */
public class GrammaticalCategoryImpl implements GrammaticalCategory {

    /** Identifier of this class. */
    protected static final long serialVersionUID = -770608080317100412L;
    /** The symbol marking unknown category.*/
    public static final String SYMBOL_OF_UNKNOWN_CATEGORY = "unknown";
    /** The symbol of this category. */
    private String symbol;
    /** The names of this category. */
    private Map names;
    /** The descriptions of this category. */
    private Map descriptions;
    /** The tags belonging to this category. */
    private Map tags;
    
    /**
     * Constructs an instances of the grammatical tag.
     */
    public GrammaticalCategoryImpl() {
        symbol = SYMBOL_OF_UNKNOWN_CATEGORY;
        names = new HashMap();
        descriptions = new HashMap();
        tags = new HashMap();
    }

    /**
     * Constructs an instances of the grammatical tag marked by the given symbol. 
     * 
     * @param categorySymbol The symbol of the constructed tag.
     */
    public GrammaticalCategoryImpl(final String categorySymbol) {
        if (categorySymbol == null) {
            throw new NullPointerException("The [categorySymbol] argument cannot be null.");
        }
        if (categorySymbol.trim().length() == 0) {
            throw new IllegalArgumentException("The [categorySymbol] argument cannot be empty.");
        }
        symbol = categorySymbol;
        names = new HashMap();
        descriptions = new HashMap();
        tags = new HashMap();
    }

    /**
     * Returns a symbol which represents this category.
     *
     * @return A short string representing this category.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets a new value for a symbol which represents this category.
     *
     * @param newSymbol A short string representing this category.
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
     * Returns a name of this grammatical category.
     *
     * @param languageCode The code of a language of the name.
     *
     * @return The name of the grammatical category written in the given language
     *  or <code>null</code> if the name is unavailable in the given language.
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
     * Sets a new name for this grammatical category.
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
     * Returns a description of this grammatical category.
     *
     * @param languageCode The code of a language of the description.
     *
     * @return The description of the grammatical category written in the given language
     *  or <code>null</code> if the description is unavailable in the given language.
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
     * Sets a new description for a grammatical category represented by this tag.
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
        return result;
    }

    /**
     * Returns string representation of this object - a symbol of this category.
     * 
     * @return The symbol of this grammatical category.
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
     * Checks if this category is equal to the given object.
     * 
     * @param obj The object with which to compare.
     * 
     * @return <code>true</code> if the given object represents the same 
     *  grammatical category as this category.
     */
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof GrammaticalCategory) {
            return symbol.equals(((GrammaticalCategory) obj).getSymbol());
        } else {
            return false;
        }
    }

    /**
     * Compare this grammatical category with other objects.
     * 
     * @param obj The object with which to compare.
     * 
     * @return vale equal to 0 , greater then 0 or lower then 0 according to 
     *  the order of symbols of compared grammatical categories.
     */
    public int compareTo(final Object obj) {
        if (obj != null && obj instanceof GrammaticalCategory) {
            GrammaticalCategory gc = (GrammaticalCategory) obj;
            return symbol.compareTo(gc.getSymbol());
        } else {
            return 1;
        }
    }
    
    /**
     * Returns a collection of tags belonging to this grammatical category.
     *
     * @return Collection of {@link GrammaticalTag} objects.
     */
    public Collection getTags() {
        return tags.values();
    }

    /**
     * Returns a grammatical tag represented by the given symbol and belonging to this category.
     *
     * @param tagSymbol The symbol of the tag.
     * @return The tag belonging to this category and denoted by
     *  the given symbol or <code>null</code> if the tag does not belong to this category.
     */
    public GrammaticalTag getTag(final String tagSymbol) {
        if (tagSymbol == null) {
            throw new NullPointerException("The [symbol] argument cannot be null.");
        }
        if (tagSymbol.length() == 0) {
            throw new IllegalArgumentException("The [symbol] argument cannot be empty.");
        }
        return (GrammaticalTag) tags.get(tagSymbol);
    }

    /**
     * Adds a grammatical tag to a set of tags belonging to this grammatical category.
     *
     * @param tag The tag belonging to this category.
     */
    public void addTag(final GrammaticalTag tag) {
        if (tag == null) {
            throw new NullPointerException("The [tag] argument cannot be null.");
        }
        tags.put(tag.getSymbol(), tag);
    }

    /**
     * Removes all descriptions.
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
        int size = tags == null ? 0 : tags.size();
        TagsetStreamPacker.writeInt(size, out);
        if (size > 0) {
            for (final Iterator it = tags.entrySet().iterator(); it.hasNext();) {
                Map.Entry entry = (Map.Entry) it.next();
                TagsetStreamPacker.writeString(entry.getKey().toString(), out);
                GrammaticalTag tag = (GrammaticalTag) entry.getValue();
                TagsetStreamPacker.writeString(tag.getSymbol(), out);
            }
        }
    }

    /**
     * Reads this object from the given data input stream.
     *
     * @param in The input stream from which this object should be read.
     * @param tagset The tagset for which this category is defined.
     *
     * @throws IOException if any read error occurred.
     */
    public void read(final DataInputStream in, final Tagset tagset) throws IOException {
        symbol = TagsetStreamPacker.readString(in);
        names = TagsetStreamPacker.readStringsMap(in);
        descriptions = TagsetStreamPacker.readStringsMap(in);
        int size = TagsetStreamPacker.readInt(in);
        tags = new HashMap();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String key = TagsetStreamPacker.readString(in);
                String symbol = TagsetStreamPacker.readString(in);
                GrammaticalTag tag = tagset.getTag(symbol);
                tags.put(key, tag);
            }
        }
    }
    
}
