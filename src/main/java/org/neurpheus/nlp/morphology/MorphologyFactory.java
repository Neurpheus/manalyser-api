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
package org.neurpheus.nlp.morphology;

import java.util.List;
import java.util.Locale;
import org.neurpheus.nlp.morphology.tagset.Tagset;

/**
 * <b>A factory returning available morphological components</b>.
 * <p>
 * To create a default instance of this interface use the {@link DefaultMorphologyFactory} class as in
 * the following example:
 * <pre>
 *    MorphologyFactory morphologyFactory = DefaultMorphologyFactory.getInstance();
 * </pre>
 * </p>
 * 
 * @author Jakub Strychowski
 */
public interface MorphologyFactory {

    /**
     *
     * Returns a list of all available generators for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return The list of objects implementing the {@link WordFormGenerator} interface.
     */
    List getAllGenerators(final Locale locale);

    /**
     *
     * Returns a list of all available lemmatizers for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return The list of objects implementing the {@link Lemmatizer} interface.
     */
    List getAllLemmatizers(final Locale locale);

    /**
     *
     * Returns a list of all available morphological analysers for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return The list of objects implementing the {@link MorphologicalAnalyser} interface.
     */
    List getAllMorphologicalAnalysers(final Locale locale);

    /**
     *
     * Returns a list of all available stemmers for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return The list of objects implementing the {@link Stemmer} interface.
     */
    List getAllStemmers(final Locale locale);

    /**
     * Returns the fastest generator for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return Found generator.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching generator.
     */
    WordFormGenerator getFastestGenerator(final Locale locale) throws MorphologyException;

    /**
     * Returns the fastest lemmatizer for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return Found lemmatizer.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching lemmatizer.
     */
    Lemmatizer getFastestLemmatizer(final Locale locale) throws MorphologyException;

    /**
     * Returns the fastest morphological analyser for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return Found morphological analyser.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException
     * if there is no matching morphological analyser.
     */
    MorphologicalAnalyser getFastestMorphologicalAnalyser(final Locale locale) throws MorphologyException;

    /**
     * Returns the fastest stemmer for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return Found stemmer.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching stemmer.
     */
    Stemmer getFastestStemmer(final Locale locale) throws MorphologyException;

    /**
     * Returns the generator for the given language and the given value of a property.
     *
     * @param locale The locale object which represents the language.
     * @param propertyName The name of the property.
     * @param propertyValue The value of the property.
     *
     * @return Found generator.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching generator.
     */
    WordFormGenerator getGenerator(
            final Locale locale,
            final String propertyName,
            final Object propertyValue) throws MorphologyException;

    /**
     * Returns a generator fulfilling the given criteria.
     *
     * @param locale The locale object which represents the language.
     * @param qualityImportance
     * The weight for the value of a quality property used during a selection of the result component.
     * @param speedImportance
     * The weight for the value of a speed property used during a selection of the result component.
     *
     * @return Found generator.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching generator.
     */
    WordFormGenerator getGenerator(
            final Locale locale,
            final double qualityImportance,
            final double speedImportance) throws MorphologyException;

    /**
     * Returns the lemmatizer for the given language and the given value of a property.
     *
     * @param locale The locale object which represents the language.
     * @param propertyName The name of the property.
     * @param propertyValue The value of the property.
     *
     * @return Found lemmatizer.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching lemmatizer.
     */
    Lemmatizer getLemmatizer(
            final Locale locale,
            final String propertyName,
            final Object propertyValue) throws MorphologyException;

    /**
     * Returns a lemmatizer fulfilling the given criteria.
     *
     * @param locale The locale object which represents the language.
     * @param qualityImportance
     * The weight for the value of a quality property used during a selection of the result component.
     * @param speedImportance
     * The weight for the value of a speed property used during a selection of the result component.
     *
     * @return Found lemmatizer.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching lemmatizer.
     */
    Lemmatizer getLemmatizer(
            final Locale locale,
            final double qualityImportance,
            final double speedImportance) throws MorphologyException;

    /**
     * Returns the morphological analyser for the given language and the given value of a property.
     *
     * @param locale The locale object which represents the language.
     * @param propertyName The name of the property.
     * @param propertyValue The value of the property.
     *
     * @return Found morphological analyser.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException
     * if there is no matching morphological analyser.
     */
    MorphologicalAnalyser getMorphologicalAnalyser(
            final Locale locale,
            final String propertyName,
            final Object propertyValue) throws MorphologyException;

    /**
     * Returns a morphological analyser fulfilling the given criteria.
     *
     * @param locale The locale object which represents the language.
     * @param qualityImportance
     * The weight for the value of a quality property used during a selection of the result component.
     * @param speedImportance
     * The weight for the value of a speed property used during a selection of the result component.
     *
     * @return Found morphological analyser.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException
     * if there is no matching morphological analyser.
     */
    MorphologicalAnalyser getMorphologicalAnalyser(
            final Locale locale,
            final double qualityImportance,
            final double speedImportance) throws MorphologyException;

    /**
     * Returns the most accurate generator for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return Found generator.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching generator.
     */
    WordFormGenerator getMostAccurateGenerator(
            final Locale locale) throws MorphologyException;

    /**
     * Returns the most accurate lemmatizer for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return Found lemmatizer.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching lemmatizer.
     */
    Lemmatizer getMostAccurateLemmatizer(
            final Locale locale) throws MorphologyException;

    /**
     * Returns the most accurate morphological analyser for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return Found morphological analyser.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException
     * if there is no matching morphological analyser.
     */
    MorphologicalAnalyser getMostAccurateMorphologicalAnalyser(
            final Locale locale) throws MorphologyException;

    /**
     * Returns the most accurate stemmer for the given language.
     *
     * @param locale The locale object which represents the language.
     *
     * @return Found stemmer.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching stemmer.
     */
    Stemmer getMostAccurateStemmer(
            final Locale locale) throws MorphologyException;

    /**
     * Returns the stemmer for the given language and the given value of a property.
     *
     * @param locale The locale object which represents the language.
     * @param propertyName The name of the property.
     * @param propertyValue The value of the property.
     *
     * @return Found stemmer.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching stemmer.
     */
    Stemmer getStemmer(
            final Locale locale,
            final String propertyName,
            final Object propertyValue) throws MorphologyException;

    /**
     * Returns a stemmer fulfilling the given criteria.
     *
     * @param locale The locale object which represents the language.
     * @param qualityImportance
     * The weight for the value of a quality property used during a selection of the result component.
     * @param speedImportance
     * The weight for the value of a speed property used during a selection of the result component.
     *
     * @return Found stemmer.
     *
     * @throws org.neurpheus.nlp.morphology.MorphologyException if there is no matching stemmer.
     */
    Stemmer getStemmer(
            final Locale locale,
            final double qualityImportance,
            final double speedImportance) throws MorphologyException;
    
    
    /**
     * Creates an empty tagset.
     * This method can be used for creation of the tagset which will be loaded 
     * from an XML file.
     * 
     * @return The empty tagset.
     */
    Tagset createTagset();
    
}
