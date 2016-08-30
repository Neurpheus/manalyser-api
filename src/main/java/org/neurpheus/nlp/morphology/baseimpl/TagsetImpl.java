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
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.neurpheus.nlp.morphology.tagset.GrammaticalCategory;
import org.neurpheus.nlp.morphology.tagset.GrammaticalProperties;
import org.neurpheus.nlp.morphology.tagset.GrammaticalPropertiesList;
import org.neurpheus.nlp.morphology.tagset.GrammaticalTag;
import org.neurpheus.nlp.morphology.tagset.Tagset;
import org.neurpheus.nlp.morphology.tagset.xml.Category;
import org.neurpheus.nlp.morphology.tagset.xml.Description;
import org.neurpheus.nlp.morphology.tagset.xml.Example;
import org.neurpheus.nlp.morphology.tagset.xml.Language;
import org.neurpheus.nlp.morphology.tagset.xml.Name;
import org.neurpheus.nlp.morphology.tagset.xml.Tag;
import org.xml.sax.SAXException;

/**
 * Represents a set of tags describing grammatical properties of word forms.
 *
 * @author Jakub Strychowski
 */
public class TagsetImpl implements Tagset {

    /** The logger of this class. */
    private static Logger logger = Logger.getLogger(TagsetImpl.class.getName());
    
    /** Identifier of this class. */
    protected static final long serialVersionUID = -770608080319234446L;
    
    private static final ThreadLocal<Tagset> deserializationTagset = new ThreadLocal<>();
    
    /** The grammatical categories. */
    private Map categories;
    
    /** The grammatical tags. */
    private Map tags;

    /** The cached grammatical properties. */
    private transient Map grammaticalPropertiesCache;

    /** The cached grammatical properties by unique identifiers. */
    private Map grammaticalPropertiesCacheById;
    
    /** The cached lists of grammatical properties lists. */
    private transient Map grammaticalPropertiesListCache;

    /** The cached lists of grammatical properties lists by unique identifiers. */
    private Map grammaticalPropertiesListCacheById;
    
    /**
     * Constructs a new, empty tagset.
     */
    public TagsetImpl() {
        categories = new HashMap();
        tags = new HashMap();
        GrammaticalTag xxxtag = new GrammaticalTagImpl(Tagset.MARK_FOR_UNKNOWN_FORM);
        tags.put(xxxtag.getSymbol(), xxxtag);
        grammaticalPropertiesCache = new HashMap();
        grammaticalPropertiesListCache = new HashMap();
        grammaticalPropertiesCacheById = new HashMap();
        grammaticalPropertiesListCacheById = new HashMap();
    }

    /**
     * Returns a list of grammatical categories defined in this tagset.
     * 
     * @return The collection of objects implementing the {@link GrammaticalCategory} interface.
     */
    public Collection getGrammaticalCategories() {
        return categories.values();
    }

    /**
     * Sets a new list of grammatical categories and tags for this tagset.
     * 
     * @param newCategories The collection of objects implementing the {@link GrammaticalCategory} interface.
     */
    public synchronized void setGrammaticalCategories(final Collection newCategories) {
        if (newCategories == null) {
            throw new NullPointerException("The [newCategories] argument cannot be null.");
        }
        categories.clear();
        tags.clear();
        for (final Iterator it = newCategories.iterator(); it.hasNext();) {
            GrammaticalCategory gc = (GrammaticalCategory) it.next();
            addGrammaticalCategory(gc);
        }
    }

    /**
     * Returns a grammatical category represented by the given symbol and belonging to this tagset.
     *
     * @param categorySymbol The symbol of the category.
     * 
     * @return A grammatical category belonging to this tagset and denoted by 
     *  the given symbol, or <code>null</code> if there is no such a category.
     */
    public GrammaticalCategory getGrammaticalCategory(final String categorySymbol) {
        if (categorySymbol == null) {
            throw new NullPointerException("The [categorySymbol] argument cannot be null.");
        }
        if (categorySymbol.length() == 0) {
            throw new IllegalArgumentException("The [categorySymbol] argument cannot be empty.");
        }
        return (GrammaticalCategory) categories.get(categorySymbol);
    }

    /**
     * Adds the given grammatical category and its tags to this tagset.
     * 
     * @param category The grammatical category which have to be added to this tagset.
     */
    public void addGrammaticalCategory(final GrammaticalCategory category) {
        if (category == null) {
            throw new NullPointerException("The [category] argument cannot be null.");
        }
        categories.put(category.getSymbol(), category);
        for (final Iterator it = category.getTags().iterator(); it.hasNext();) {
            GrammaticalTag tag = (GrammaticalTag) it.next();
            tags.put(tag.getSymbol(), tag);
        }
    }

    /**
     * Returns a collection of tags defined in this tagset.
     * 
     * @return The collection of objects implementing the {@link GrammaticalTag} interface.
     */
    public Collection getTags() {
        return tags.values();
    }

    /**
     * Returns a grammatical tag represented by the given symbol and belonging to this tagset.
     *
     * @param tagSymbol The symbol of the tag.
     * 
     * @return The tag belonging to this tagset and denoted by
     *  the given symbol or <code>null</code> if there is no such a tag.
     */
    public GrammaticalTag getTag(final String tagSymbol) {
        if (tagSymbol == null) {
            throw new NullPointerException("The [tagSymbol] argument cannot be null.");
        }
        if (tagSymbol.length() == 0) {
            throw new IllegalArgumentException("The [tagSymbol] argument cannot be empty");
        }
        return (GrammaticalTag) tags.get(tagSymbol);
    }

    /**
     * Reads a tagset from an XML document.
     * 
     * @param in The input stream providing the XML document.
     * 
     * @throws java.io.IOException if any input/output error occurred.
     */
    public void readFromXML(final InputStream in) throws IOException {
        if (in == null) {
            throw new NullPointerException("The [in] argument cannot be null.");
        }
        try {
            org.neurpheus.nlp.morphology.tagset.xml.Tagset xmlTagset =
                    org.neurpheus.nlp.morphology.tagset.xml.Tagset.read(in);
            Category[] catArray = xmlTagset.getCategory();
            for (int i = 0; i < catArray.length; i++) {
                Category c = catArray[i];
                GrammaticalCategory newCategory = new GrammaticalCategoryImpl(c.getSymbol());
                Name[] names = c.getName();
                for (int j = 0; j < names.length; j++) {
                    Name n = names[j];
                    newCategory.setName(n.getLang(), n.getValue());
                }
                Description[] descriptions = c.getDescription();
                for (int j = 0; j < descriptions.length; j++) {
                    Description d = descriptions[j];
                    newCategory.setDescription(d.getLang(), d.getValue());
                }
                Tag[] tagsArray = c.getTag();
                for (int k = 0; k < tagsArray.length; k++) {
                    Tag t = tagsArray[k];
                    GrammaticalTag newTag = new GrammaticalTagImpl(t.getSymbol());
                    names = t.getName();
                    for (int j = 0; j < names.length; j++) {
                        Name n = names[j];
                        newTag.setName(n.getLang(), n.getValue());
                    }
                    descriptions = t.getDescription();
                    for (int j = 0; j < descriptions.length; j++) {
                        Description d = descriptions[j];
                        newTag.setDescription(d.getLang(), d.getValue());
                    }
                    Example[] examples = t.getExample();
                    for (int j = 0; j < examples.length; j++) {
                        Example e = examples[j];
                        String[] oldarr = newTag.getExamples(e.getLang());
                        String[] newarr = new String[oldarr.length + 1];
                        if (oldarr.length > 0) {
                            System.arraycopy(oldarr, 0, newarr, 0, oldarr.length);
                        }
                        newarr[newarr.length - 1] = e.getValue();
                        newTag.setExamples(e.getLang(), newarr);
                    }
                    newCategory.addTag(newTag);
                }
                addGrammaticalCategory(newCategory);
            }
        } catch (SAXException se) {
            logger.log(Level.SEVERE, "Cannot parse XML document using SAX parser", se);
            throw new IOException("Cannot parse XML document using SAX parser");
        } catch (ParserConfigurationException pe) {
            logger.log(Level.SEVERE, "Cannot find XML parser.", pe);
            throw new IOException("Cannot find XML parser.");
        }
    }

    /**
     * Writes this tagset as an XML document.
     * 
     * @param out The output stream where the XML document will be send.
     * 
     * @throws java.io.IOException if any input/output error occurred.
     */
    public void writeAsXML(final OutputStream out) throws IOException {
        if (out == null) {
            throw new NullPointerException("The [out] argument cannot be null.");
        }
        org.neurpheus.nlp.morphology.tagset.xml.Tagset xmlTagset =
                new org.neurpheus.nlp.morphology.tagset.xml.Tagset();
        HashSet allLanguages = new HashSet();
        for (final Iterator it = getGrammaticalCategories().iterator(); it.hasNext();) {
            GrammaticalCategory gc = (GrammaticalCategory) it.next();
            Category xmlCategory = new Category();
            xmlTagset.addCategory(xmlCategory);
            xmlCategory.setSymbol(gc.getSymbol());
            Collection languages = gc.getLanguageCodes();
            allLanguages.addAll(languages);
            for (final Iterator langIt = languages.iterator(); langIt.hasNext();) {
                String lang = langIt.next().toString();
                String nameValue = gc.getName(lang);
                if (nameValue != null) {
                    Name xmlName = new Name();
                    xmlName.setLang(lang);
                    xmlName.setValue(nameValue);
                    xmlCategory.addName(xmlName);
                }
                String descValue = gc.getDescription(lang);
                if (descValue != null) {
                    Description xmlDesc = new Description();
                    xmlDesc.setLang(lang);
                    xmlDesc.setValue(descValue);
                    xmlCategory.addDescription(xmlDesc);
                }
            }
            for (final Iterator tagIt = gc.getTags().iterator(); tagIt.hasNext();) {
                GrammaticalTag tag = (GrammaticalTag) tagIt.next();
                Tag xmlTag = new Tag();
                xmlCategory.addTag(xmlTag);
                xmlTag.setSymbol(tag.getSymbol());
                languages = tag.getLanguageCodes();
                allLanguages.addAll(languages);
                for (final Iterator langIt = languages.iterator(); langIt.hasNext();) {
                    String lang = langIt.next().toString();
                    String nameValue = tag.getName(lang);
                    if (nameValue != null) {
                        Name xmlName = new Name();
                        xmlName.setLang(lang);
                        xmlName.setValue(nameValue);
                        xmlTag.addName(xmlName);
                    }
                    String descValue = tag.getDescription(lang);
                    if (descValue != null) {
                        Description xmlDesc = new Description();
                        xmlDesc.setLang(lang);
                        xmlDesc.setValue(descValue);
                        xmlTag.addDescription(xmlDesc);
                    }
                    String[] examples = tag.getExamples(lang);
                    for (int i = 0; i < examples.length; i++) {
                        Example example = new Example();
                        example.setLang(lang);
                        example.setValue(examples[i]);
                        xmlTag.addExample(example);
                    }
                }
            }
        }
        String[] langs = (String[]) allLanguages.toArray(new String[0]);
        Locale[] locales = new Locale[langs.length];
        for (int i = 0; i < langs.length; i++) {
            locales[i] = new Locale(langs[i]);
        }
        for (int i = 0; i < langs.length; i++) {
            String lang = langs[i];
            Language l = new Language();
            xmlTagset.addLanguage(l);
            l.addSymbol(lang);
            for (int j = 0; j < langs.length; j++) {
                Name name = new Name();
                name.setLang(langs[j]);
                name.setValue(locales[i].getDisplayLanguage(locales[j]));
                l.addName(name);
            }
        }
        xmlTagset.write(out, "utf-8");
    }
    
    /**
     * Returns an object representing grammatical properties defined by the given mark.
     * It is recommended that a tagset should cache result objects for 
     * common marks to speed up processing.
     * 
     * @param mark The mark of grammatical properties.
     * 
     * @return The result grammatical properties.
     */
    public GrammaticalProperties getGrammaticalProperties(String mark) {
        if (mark == null) {
            throw new NullPointerException("The [mark] argument cannot be null.");
        }
        if (grammaticalPropertiesCache == null) {
            grammaticalPropertiesCache = new HashMap();
        }
        GrammaticalProperties result = (GrammaticalProperties) grammaticalPropertiesCache.get(mark);
        if (result == null) {
            result = new GrammaticalPropertiesImpl(mark, this);
            grammaticalPropertiesCache.put(mark, result);            
            grammaticalPropertiesCacheById.put(new Integer(result.getId()), result);
        }
        return result;
    }
    
    /**
     * Returns an object representing grammatical properties defined by the given id.
     * 
     * @param id The unique id of grammatical properties.
     * 
     * @return The result grammatical properties.
     */
    public GrammaticalProperties getGrammaticalPropertiesById(int id) {
        GrammaticalProperties result = (GrammaticalProperties) grammaticalPropertiesCacheById.get(new Integer(id));
        return result;
    }
    
    /**
     * Returns an object representing grammatical properties list defined by the given id.
     * 
     * @param id The unique id of grammatical properties list.
     * 
     * @return The result grammatical properties list.
     */
    public GrammaticalPropertiesList getGrammaticalPropertiesListById(int id) {
        GrammaticalPropertiesList result = (GrammaticalPropertiesList) grammaticalPropertiesListCacheById.get(new Integer(id));
        return result;
    }
    
    /**
     * Return an object representing a list of grammatical properties
     * defined byt the given list of marks
     * 
     * @param marks List of marks separated by the '+' sign.
     * 
     * @return Teh result list of grammatical properties.
     */
    public GrammaticalPropertiesList getGrammaticalPropertiesList(String marks) {
        if (marks == null) {
            throw new NullPointerException("The [marks] argument cannot be null.");
        }
        if (grammaticalPropertiesListCache == null) {
            grammaticalPropertiesListCache = new HashMap();
        }
        GrammaticalPropertiesList result = (GrammaticalPropertiesList) grammaticalPropertiesListCache.get(marks);
        if (result == null) {
            result = new GrammaticalPropertiesListImpl(marks, this);
            grammaticalPropertiesListCache.put(marks, result);            
            grammaticalPropertiesListCacheById.put(new Integer(result.getId()), result);
        }
        return result;
    }
    
    /**
     * Creates a new grammatical category which can be added to a tagset.
     * 
     * @param categorySymbol The symbol of the category.
     * 
     * @return Created category.
     */
    public GrammaticalCategory createGrammaticalCategory(final String categorySymbol) {
        if (categorySymbol == null) {
            throw new NullPointerException("The [categorySymbol] argument cannot be null.");
        }
        GrammaticalCategory result = new GrammaticalCategoryImpl(categorySymbol);
        return result;
    }

    /**
     * Creates a new grammatical tag which can be added to a grammatical category.
     * 
     * @param tagSymbol The symbol of the tag.
     * 
     * @return Created tag.
     */
    public GrammaticalTag createGrammaticalTag(final String tagSymbol) {
        if (tagSymbol == null) {
            throw new NullPointerException("The [tagSymbol] argument cannot be null.");
        }
        GrammaticalTag tag = new GrammaticalTagImpl(tagSymbol);
        return tag;
    }

    /**
     * Returns grammatical properties for an unknown word form.
     * 
     * @return The grammatical properties marked by the "xxx" string.
     */
    public GrammaticalProperties getUnknownGrammaticalProperties() {
        return getGrammaticalProperties(Tagset.MARK_FOR_UNKNOWN_FORM);
    }
    
    /**
     * Returns list of grammatical properties for an unknown word form.
     * 
     * @return The grammatical properties marked by the "xxx" string.
     */
    public GrammaticalPropertiesList getUnknownGrammaticalPropertiesList() {
        return getGrammaticalPropertiesList(Tagset.MARK_FOR_UNKNOWN_FORM);
    }

    public static Tagset getDeserializationTagset() {
        return deserializationTagset.get();
    }
    
    public static void setDeserializationTagset(final Tagset tagset) {
        deserializationTagset.set(tagset);
    }
    
    public static Object getDeserializationLockObject() {
        return logger;
    }
    
    private void reindexIdentifiers() {
        HashSet gplSet = new HashSet();
        grammaticalPropertiesCache = new HashMap();
        if (grammaticalPropertiesListCache != null) {
            gplSet.addAll(grammaticalPropertiesListCache.values());
        }
        if (grammaticalPropertiesListCacheById != null) {
            gplSet.addAll(grammaticalPropertiesListCacheById.values());
        }
        grammaticalPropertiesListCache = new HashMap();
        grammaticalPropertiesListCacheById = new HashMap();
        grammaticalPropertiesCache = new HashMap();
        int index = 1;
        for (final Iterator it = gplSet.iterator(); it.hasNext();) {
            GrammaticalPropertiesList gpl = (GrammaticalPropertiesList) it.next();
            gpl.setId(index++);
            grammaticalPropertiesListCache.put(gpl.toString(), gpl);
            grammaticalPropertiesListCacheById.put(new Integer(gpl.getId()), gpl);
            ArrayList newList = new ArrayList();
            for (final Iterator gpit = gpl.getGrammaticalProperties().iterator(); gpit.hasNext();) {
                GrammaticalProperties gp = (GrammaticalProperties) gpit.next();
                newList.add(getGrammaticalProperties(gp.getMark()));
            }
            gpl.setGrammaticalProperties(newList);
        }
        
        HashSet gpSet = new HashSet();
        if (grammaticalPropertiesCache != null) {
            gpSet.addAll(grammaticalPropertiesCache.values());
        }
        if (grammaticalPropertiesCacheById != null) {
            gpSet.addAll(grammaticalPropertiesCacheById.values());
        }
        grammaticalPropertiesCache = new HashMap();
        grammaticalPropertiesCacheById = new HashMap();
        index = 1;
        for (final Iterator it = gpSet.iterator(); it.hasNext();) {
            GrammaticalProperties gp = (GrammaticalProperties) it.next();
            gp.setId(index++);
            grammaticalPropertiesCache.put(gp.getMark(), gp);
            grammaticalPropertiesCacheById.put(new Integer(gp.getId()), gp);
        }
        
    }
        
    
    /**
     * Writes this object into the given output stream.
     *
     * @param out   The output stream where this IPB should be stored.
     *
     * @throws IOException if any write error occurred.
     */
    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.writeObject(categories);
        out.writeObject(tags);
        reindexIdentifiers();
        out.writeObject(grammaticalPropertiesCacheById);
        out.writeObject(grammaticalPropertiesListCacheById);
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
        categories = (Map) in.readObject();
        tags = (Map) in.readObject();
        synchronized(logger) {
            setDeserializationTagset(this);
            grammaticalPropertiesCacheById = (Map) in.readObject();
            grammaticalPropertiesListCacheById = (Map) in.readObject();
        }
        grammaticalPropertiesCache = new HashMap();
        for (final Iterator it = grammaticalPropertiesCacheById.values().iterator(); it.hasNext();) {
            GrammaticalProperties gp = (GrammaticalProperties) it.next();
            grammaticalPropertiesCache.put(gp.getMark(), gp);
        }
        grammaticalPropertiesListCache = new HashMap();
        for (final Iterator it = grammaticalPropertiesListCacheById.values().iterator(); it.hasNext();) {
            GrammaticalPropertiesList gpl = (GrammaticalPropertiesList) it.next();
            grammaticalPropertiesListCache.put(gpl.toString(), gpl);
        }
    }

    /**
     * Removes all descriptions of tags and categories.     
     */
    public void compact() {
        for (final Iterator it = categories.values().iterator(); it.hasNext();) {
            GrammaticalCategory c = (GrammaticalCategory) it.next();
            c.compact();
        }
        for (final Iterator it = tags.values().iterator(); it.hasNext();) {
            GrammaticalTag t = (GrammaticalTag) it.next();
            t.compact();
        }
    }

    /**
     * Writes this object into the given data output stream.
     *
     * @param out   The output stream where this tagset should be stored.
     *
     * @throws IOException if any write error occurred.
     */
    public void write(final DataOutputStream out) throws IOException {


        Map m = tags;
        TagsetStreamPacker.writeInt(m.size(), out);
        for (final Iterator it = m.values().iterator(); it.hasNext();) {
            GrammaticalTag tag = (GrammaticalTag) it.next();
            tag.write(out);
        }

        m = categories;
        TagsetStreamPacker.writeInt(m.size(), out);
        for (final Iterator it = m.values().iterator(); it.hasNext();) {
            GrammaticalCategory cat = (GrammaticalCategory) it.next();
            cat.write(out);
        }


        reindexIdentifiers();

        m = grammaticalPropertiesCacheById;
        TagsetStreamPacker.writeInt(m.size(), out);
        for (final Iterator it = m.values().iterator(); it.hasNext();) {
            GrammaticalProperties prop = (GrammaticalProperties) it.next();
            prop.write(out);
        }

        m = grammaticalPropertiesListCacheById;
        TagsetStreamPacker.writeInt(m.size(), out);
        for (final Iterator it = m.values().iterator(); it.hasNext();) {
            GrammaticalPropertiesList propList = (GrammaticalPropertiesList) it.next();
            propList.write(out);
        }
    }

    /**
     * Reads this object from the given data input stream.
     *
     * @param in The input stream from which this object should be read.
     *
     * @throws IOException if any read error occurred.
     */
    public void read(DataInputStream in) throws IOException {

        tags = new HashMap();
        int size = TagsetStreamPacker.readInt(in);
        for (int i = 0; i < size; i++) {
            GrammaticalTag tag = new GrammaticalTagImpl();
            tag.read(in);
            tags.put(tag.getSymbol(), tag);
        }

        categories = new HashMap();
        size = TagsetStreamPacker.readInt(in);
        for (int i = 0; i < size; i++) {
            GrammaticalCategory cat = new GrammaticalCategoryImpl();
            cat.read(in, this);
            categories.put(cat.getSymbol(), cat);
        }

        grammaticalPropertiesCacheById = new HashMap();
        size = TagsetStreamPacker.readInt(in);
        for (int i = 0; i < size; i++) {
            GrammaticalProperties prop = new GrammaticalPropertiesImpl();
            prop.read(in);
            grammaticalPropertiesCacheById.put(new Integer(prop.getId()), prop);
        }


        grammaticalPropertiesListCacheById = new HashMap();
        size = TagsetStreamPacker.readInt(in);
        for (int i = 0; i < size; i++) {
            GrammaticalPropertiesList prop = new GrammaticalPropertiesListImpl();
            prop.read(in, this);
            grammaticalPropertiesListCacheById.put(new Integer(prop.getId()), prop);
        }

        grammaticalPropertiesCache = new HashMap();
        for (final Iterator it = grammaticalPropertiesCacheById.values().iterator(); it.hasNext();) {
            GrammaticalProperties gp = (GrammaticalProperties) it.next();
            grammaticalPropertiesCache.put(gp.getMark(), gp);
        }
        grammaticalPropertiesListCache = new HashMap();
        for (final Iterator it = grammaticalPropertiesListCacheById.values().iterator(); it.hasNext();) {
            GrammaticalPropertiesList gpl = (GrammaticalPropertiesList) it.next();
            grammaticalPropertiesListCache.put(gpl.toString(), gpl);
        }

    }
    
}
