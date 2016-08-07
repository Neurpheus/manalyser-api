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
package org.neurpheus.nlp.morphology.baseimpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;
import org.neurpheus.nlp.morphology.tagset.GrammaticalCategory;
import org.neurpheus.nlp.morphology.tagset.GrammaticalProperties;
import org.neurpheus.nlp.morphology.tagset.GrammaticalTag;
import org.neurpheus.nlp.morphology.tagset.Tagset;

/**
 *  Represents morphological properties of a single word form.
 *
 * @author Jakub Strychowski
 */
public class GrammaticalPropertiesImpl implements GrammaticalProperties {

    /** Unique identifier of this class. */
    protected static final long serialVersionUID = -770608080321101512L;
    /** Logger of this class. */
    private static Logger logger = Logger.getLogger(GrammaticalPropertiesImpl.class.getName());
    /** The character which separates two grammatical tags within a mark. */
    public static final char TAG_SYMBOL_SEPARATOR = ':';
    /** The second character which separates two grammatical tags within a mark. */
    public static final char TAG_SYMBOL_SEPARATOR_2 = '.';
    
    /** Static value used for id generating. */
    private static int idGenerator = 1;
    
    /** The mark with all tags describing grammatical properties. */
    private String mark;
    /** 
     * The map of tags representing grammatical properties. 
     * This map contains mappings between tag symbols and tags.
     */
    private Map tags;
    /**
     * The tagset used for this grammatical properties definition.
     */
    private Tagset tagset;

    /** Holds unique identifier of this object. */
    private int id;
    
    /**
     * Creates an instance of object describing grammatical properties.
     */
    public GrammaticalPropertiesImpl() {
        id = idGenerator++;
        mark = "".intern();
        tagset = null;
        tags = null;
    }

    public static String normalizeMark(String mark) {
        StringBuffer res = new StringBuffer();
        StringBuffer tmp = new StringBuffer();
        HashSet tmptags = new HashSet();
        int length = mark.length();
        char lastSeparator = '\n';
        for (int i = 0; i <= length; i++) {
            char c = i < length ? mark.charAt(i) : '\n';
            switch (c) {
                case '.' :
                case ':' :
                case '+' :
                case '\n' :
                    if (tmp.length() > 0) {
                        String t = tmp.toString();
                        if (!tmptags.contains(t)) {
                            if (res.length() > 0) {
                                res.append(lastSeparator);
                            }
                            res.append(t);
                        }
                        tmp.setLength(0);
                        tmptags.add(t);
                    }
                    lastSeparator = c;
                    break;
                default :
                    tmp.append(c);
                    break;
            }
            
        }
        return res.toString().intern();
    }
    
    /**
     * Creates grammatical properties defined by the given mark and tagset.
     * 
     * @param markValue The mark which all symbols of tags defining grammatical properties.
     * @param tagsetValue The tagset used for the definition of the grammatical properties.
     */
    public GrammaticalPropertiesImpl(final String markValue, final Tagset tagsetValue) {
        if (markValue == null) {
            throw new NullPointerException("The [markValue] argument cannot be null.");
        }
        if (tagsetValue == null) {
            throw new NullPointerException("The [tagsetValue] argument cannot be null.");
        }
        id = idGenerator++;
        mark = normalizeMark(markValue);
        tagset = tagsetValue;
        setTagsFromMark();
    }

    /**
     * Fills the map of tags parsing the mark.
     */
    protected void setTagsFromMark() {
        tags = new HashMap();
        int tagSymbolStart = 0;
        int tagSymbolEnd = 0;
        int length = mark.length();
        while (tagSymbolEnd <= length) {
            if (tagSymbolEnd == length || mark.charAt(tagSymbolEnd) == TAG_SYMBOL_SEPARATOR 
                    || mark.charAt(tagSymbolEnd) == TAG_SYMBOL_SEPARATOR_2) {
                if (tagSymbolEnd > tagSymbolStart) {
                    String symbol = mark.substring(tagSymbolStart, tagSymbolEnd);
                    GrammaticalTag tag = tagset.getTag(symbol);
                    if (tag != null) {
                        tags.put(tag.getSymbol(), tag);
                    } else {
                        logger.warning("There is no tag defined in a tagset. Tag symbol: " + symbol);
                    }
                }
                ++tagSymbolEnd;
                tagSymbolStart = tagSymbolEnd;
            } else {
                ++tagSymbolEnd;
            }
        }


    }

    /**
     * Returns a morphosyntatic mark describing the grammatical properties.
     * 
     * @return The mark describing these properties.
     */
    public String getMark() {
        return mark;
    }

    /**
     * Sets a new morphosyntatic mark describing for this grammatical properties.
     * 
     * @param newMark The new mark for grammatical properties.
     */
    public void setMark(final String newMark) {
        if (newMark == null) {
            throw new NullPointerException("The [newMark] argument cannot be null.");
        }
        mark = normalizeMark(newMark);
        setTagsFromMark();
    }

    /**
     * Returns a collection of tags describing the grammatical properties of a word form.
     * 
     * @return A collection of {@link GrammaticalTag} objects.
     */
    public Collection getTags() {
        return tags.values();
    }

    /**
     * Sets a new collection of tags describing the grammatical properties of a word form.
     * 
     * @param newTags The new set of tags describing grammatical properties.
     */
    public void setTags(final Collection newTags) {
        if (newTags == null) {
            throw new NullPointerException("The [tags] argument cannot be null.");
        }
        tags = new HashMap();
        StringBuffer buffer = new StringBuffer();
        for (final Iterator it = newTags.iterator(); it.hasNext();) {
            GrammaticalTag tag = (GrammaticalTag) it.next();
            tags.put(tag.getSymbol(), tag);
            String symbol = tag.getSymbol();
            if (symbol.length() > 0) {
                if (buffer.length() > 0) {
                    buffer.append(TAG_SYMBOL_SEPARATOR);
                }
                buffer.append(symbol);
            }
        }
        mark = buffer.toString().intern();
    }

    /**
     * Returns a collection of tags belonging to the given grammatical category
     * and describing this grammatical properties of a word form.
     * 
     * @param category The grammatical category.
     * 
     * @return A collection of {@link GrammaticalTag} objects.
     */
    public Collection getTags(final GrammaticalCategory category) {
        if (category == null) {
            throw new NullPointerException("The [category] argument cannot be null.");
        }
        ArrayList result = new ArrayList();
        for (final Iterator it = category.getTags().iterator(); it.hasNext();) {
            GrammaticalTag tag = (GrammaticalTag) it.next();
            if (hasTag(tag)) {
                result.add(tag);
            }
        }
        return result;
    }

    /**
     * Checks if this grammatical properties uses a property represented by the given tag.
     * 
     * @param tag The grammatical tag representing a grammatical property.
     * 
     * @return <code>true</code> if this grammatical properties contains the given property.
     */
    public boolean hasTag(final GrammaticalTag tag) {
        if (tag == null) {
            throw new NullPointerException("The [tag] argument cannot be null.");
        }
        return tags.containsKey(tag.getSymbol());
    }

    /**
     * Checks if this grammatical properties uses a property represented by the given tag symbol.
     * 
     * @param tagSymbol The symbol of grammatical tag representing a grammatical property.
     * 
     * @return <code>true</code> if this grammatical properties contains the given property.
     */
    public boolean hasTag(final String tagSymbol) {
        if (tagSymbol == null) {
            throw new NullPointerException("The [tagSymbol] argument cannot be null.");
        }
        if (tagSymbol.length() == 0) {
            throw new IllegalArgumentException("The [tagSymbol] argument cannot be null.");
        }
        return tags.containsKey(tagSymbol);
    }

    /**
     * Returns a tagset which defines all tags describing grammatical properties.
     * 
     * @return The tagset defining all possible grammatical properties.
     */
    public Tagset getTagset() {
        return tagset;
    }

    /**
     * Sets a tagset which defines all tags describing grammatical properties.
     * 
     * @param newTagset The new tagset.
     */
    public void setTagset(final Tagset newTagset) {
        tagset = newTagset;
        setTagsFromMark();
    }

    /** 
     * Returns a string representation of the grammatical properties.
     * 
     * @return The mark of the grammatical properties.
     */
    public String toString() {
        return mark;
    }

    /**
     * Checks if this grammatical properties are equals to the given one.
     * 
     * @param obj The object to compare with.
     * 
     * @return <code>true</code> if grammatical properties are equal.
     */
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof GrammaticalProperties) {
            return mark.equals(((GrammaticalProperties) obj).getMark());
        } else {
            return false;
        }
    }

    /**
     * Almost unique identifier of this object.
     * 
     * @return The identifier.
     */
    public int hashCode() {
        return mark.hashCode();
    }

    /**
     * Compares this grammatical properties with another one.
     * 
     * @param obj The object which have to be compared.
     * 
     * @return result of a marks comparison.
     */
    public int compareTo(final Object obj) {
        if (obj != null && obj instanceof GrammaticalProperties) {
            GrammaticalProperties gp = (GrammaticalProperties) obj;
            return mark.compareTo(gp.getMark());
        } else {
            return 1;
        }
    }
    /**
     * Checks if this grammatical properties contains all tags represented by the given properties.
     * 
     * @param properties Subset of tags which may be covered.
     * 
     * @return <code>true</code> if gramamtical properties represented by this
     *  object contain all tags from the given grammatical propertie object.
     */
    public boolean covers(GrammaticalProperties properties) {
        for (final Iterator it = properties.getTags().iterator(); it.hasNext();) {
            GrammaticalTag tag = (GrammaticalTag) it.next();
            if (!tags.containsKey(tag.getSymbol())) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns a unique identifier of this object.
     * 
     * @return The unique identifier.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Sets a unique identifier for this object.
     * 
     * @param newId The unique identifier.
     */
    public void setId(int newId) {
        id = newId;
    }

    /**
     * Writes this object into the given output stream.
     *
     * @param out   The output stream where this IPB should be stored.
     *
     * @throws IOException if any write error occurred.
     */
    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.writeInt(id);
        out.writeUTF(mark);
    }
    
    /**
     * Reads this object data from the given input stream.
     *
     * @param in   The input stream where this IPB is stored.
     *
     * @throws IOException if any read error occurred.
     * @throws ClassNotFoundException if this object cannot be instantied.
     */
    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        mark = in.readUTF();
        tagset = TagsetImpl.getDeserializationTagset();
        setTagsFromMark();
    }

    /**
     * Writes this object into the given data output stream.
     *
     * @param out   The output stream where this tagset should be stored.
     *
     * @throws IOException if any write error occurred.
     */
    public void write(final DataOutputStream out) throws IOException {
        TagsetStreamPacker.writeInt(id, out);
        TagsetStreamPacker.writeString(mark, out);
    }

    /**
     * Reads this object from the given data input stream.
     *
     * @param in The input stream from which this object should be read.
     *
     * @throws IOException if any read error occurred.
     */
    public void read(DataInputStream in) throws IOException {
        id = TagsetStreamPacker.readInt(in);
        mark = TagsetStreamPacker.readString(in);
    }

}
