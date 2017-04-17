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
import org.neurpheus.nlp.morphology.MorphologicalAnalysisResult;
import org.neurpheus.nlp.morphology.tagset.GrammaticalPropertiesList;

/**
 * Represents a result produced by a morphological analyser.
 *
 * @author Jakub Strychowski
 */
public class MorphologicalAnalysisResultImpl
        extends AnalysisResultImpl implements MorphologicalAnalysisResult {

    /** The unique identifier of this class. */
    public static final long serialVersionUID = -770608080324110917L;
    
    /** The grammatical properties of an analysed form. */
    protected GrammaticalPropertiesList grammaticalPropertiesList;
    /** The core of an analysed form. */
    protected String core;
    /** The grammatical morphemes of an analysed form. */
    protected String grammaticalMorphemes;

    /** Holds represenation of unknown core. */
    public static final String UNKNOWN_CORE = "---";
    
    /**
     * Constructs a new uninitialised morphological analysis result.
     */
    public MorphologicalAnalysisResultImpl() {
        super();
        grammaticalPropertiesList = null;
        core = "";
        grammaticalMorphemes = "";
    }
    
    /**
     * Constructs and initialises a morphological analysis result.
     * 
     * @param formValue The result form.
     * @param accuracyValue The accuracy of the analysis.
     * @param coreValue The core of an analysed form.
     * @param morphemes The grammatical morphemes of the analysed form.
     * @param gramProperties The grammatical properties of the analysed form.
     */
    public MorphologicalAnalysisResultImpl(
            final String formValue, final double accuracyValue,
            final String coreValue, final String morphemes,
            final GrammaticalPropertiesList gramPropertiesList) {
        super(formValue, accuracyValue);
        core = coreValue == null ? "" : coreValue;
        grammaticalMorphemes = morphemes;
        grammaticalPropertiesList = gramPropertiesList;
    }
    
    /**
     * Returns grammatical properties of an analysed form.
     * 
     * @return The grammatical properties determined from morphemes of the analysed form.
     */
    public GrammaticalPropertiesList getGrammaticalPropertiesList() {
        return grammaticalPropertiesList;
    }

    /**
     * Sets a new value of grammatical properties of an analysed form. 
     * 
     * @param newGrammaticalProperties The new value of grammatical properties.
     */
    public void setGrammaticalPropertiesList(final GrammaticalPropertiesList newGrammaticalPropertiesList) {
        if (newGrammaticalPropertiesList == null) {
            throw new NullPointerException("The [newGrammaticalProperties] argument cannot be null.");
        }
        grammaticalPropertiesList = newGrammaticalPropertiesList;
    }

    public final static char WILDCARD = '*';
    
    public static String determineCore(String form, String supplement) {
        if (supplement.length() == 0) {
            return form;
        } else {
            int pos = supplement.indexOf(WILDCARD);
            if (pos < 0) {
                return "";
            } else {
                StringBuffer buffer = new StringBuffer();
                if (pos == 0) {
                    buffer.append(form.substring(0, form.length() - supplement.length() + 1));
                    buffer.append(WILDCARD);
                } else {
                    // with prefix
                    buffer.append(WILDCARD);
                    buffer.append(form.substring(pos, form.length() - supplement.length() + pos + 1));
                    buffer.append(WILDCARD);
                }
                return buffer.toString();
            }
        }
    }
    
    /**
     * Returns the core of an analysed word form.
     *      
     * @return The core of the analysed form. 
     * The '*' sign denotes places where grammatical morphemes occurs.
     */
    public String getCore() {
        if (core == null) {
            if (form != null && grammaticalMorphemes != null) {
                core = determineCore(form, grammaticalMorphemes);
            }
        }
        return core;
    }

    /**
     * Sets a new value of a core of an analysed form. 
     * 
     * @param newCore The new value of the core.
     */
    public void setCore(final String newCore) {
        if (newCore == null) {
            throw new NullPointerException("The [newCore] argument cannot be null.");
        }
        core = newCore;
    }

    /**
     * Returns a string representing a set of grammatical morphemes of an analysed word form.
     * 
     * @return The grammatical morphemes of the analysed form.
     * The '*' sign denotes places where the core of the form occurs.
     */
    public String getGrammaticalMorphemes() {
        return grammaticalMorphemes;
    }

    /**
     * Sets a new value of grammatical morphemes of an analysed form.
     * 
     * @param newGrammaticalMorphemes The new value of the grammatical morphemes.
     */
    public void setGrammaticalMorphemes(final String newGrammaticalMorphemes) {
        if (newGrammaticalMorphemes == null) {
            throw new NullPointerException("The [newGrammaticalMorphemes] argument cannot be null.");
        }
        grammaticalMorphemes = newGrammaticalMorphemes;
    }
    
    /**
     * Return a hash code of this object.
     * 
     * @return almost unique identifier of this analysis result.
     */
    public int hashCode() {
        return super.hashCode() << 8 + (getGrammaticalPropertiesList() == null ? 0 : getGrammaticalPropertiesList().hashCode());
    }

    /**
     * Checks if the given object is equals to this analysis result.
     * Two analysis results are equal if their forms are equals.
     * 
     * @param o The object which have to be compare.
     * 
     * @return <code>true</code> if the given object is equal to this object.
     */
    public boolean equals(final Object o) {
        if (super.equals(o)) {
            return getGrammaticalPropertiesList() != null && getGrammaticalPropertiesList().equals(((MorphologicalAnalysisResult) o).getGrammaticalPropertiesList());
        } else {
            return false;
        }
    }

    /**
     * Serialises the object to the output stream.
     * 
     * @param oos The output stream.
     * @throws java.io.IOException if any i/o error occurred. 
     */
    protected void writeObject(final ObjectOutputStream oos) throws IOException {
        super.writeObject(oos);
        oos.writeUTF(getCore());
        oos.writeUTF(getGrammaticalMorphemes());
        oos.writeObject(getGrammaticalPropertiesList());
    }

    /**
     * Deserialises this object from the input stream.
     * 
     * @param ois The input stream.
     * 
     * @throws java.lang.ClassNotFoundException if there is any class mapping problem.
     * @throws java.io.IOException if any i/o error occurred. 
     */
    protected void readObject(final ObjectInputStream ois) throws ClassNotFoundException, IOException {
        super.readObject(ois);
        core = ois.readUTF();
        grammaticalMorphemes = ois.readUTF();
        grammaticalPropertiesList = (GrammaticalPropertiesList) ois.readObject();
    }
    
    /** 
     * Returns string representing this analysis result.
     * 
     * @return Result in the form : $BASEFORM [$ACCURACY] ($CORE)($GRAMMATICAL_MORPHEMES){$GRAMMA}.
     */
    public String toString() {
        StringBuffer res = new StringBuffer(super.toString());
        res.append('(');
        res.append(getCore());
        res.append(')');
        res.append('(');
        res.append(getGrammaticalMorphemes());
        res.append(')');
        GrammaticalPropertiesList gpl = getGrammaticalPropertiesList();
        if (gpl != null) {
            res.append('{');
            res.append(gpl.toString());
            res.append('}');
        }
        return res.toString();
    }

    /**
     * Writes this object to a data stream.
     *
     * @param out The data stream into which this object should be serialized.
     *
     * @throws java.io.IOException If any output error occurred.
     */
    public void write(DataOutputStream out) throws IOException {
        super.write(out);
        TagsetStreamPacker.writeString(core, out);
        TagsetStreamPacker.writeString(grammaticalMorphemes, out);
        TagsetStreamPacker.writeInt(grammaticalPropertiesList == null ? 0 : grammaticalPropertiesList.getId(), out);
    }

    /**
     * Reads this object from a data stream.
     *
     * @param in The data stream from which this object should be serialized.
     *
     * @throws java.io.IOException If any input error occurred.
     */
    public void read(DataInputStream in) throws IOException {
        super.read(in);
        core = TagsetStreamPacker.readString(in);
        grammaticalMorphemes = TagsetStreamPacker.readString(in);
        int id = TagsetStreamPacker.readInt(in);
        if (id == 0) {
            grammaticalPropertiesList = null;
        } else {
            grammaticalPropertiesList = TagsetImpl.getDeserializationTagset().getGrammaticalPropertiesListById(id);
        }
    }

    
}
