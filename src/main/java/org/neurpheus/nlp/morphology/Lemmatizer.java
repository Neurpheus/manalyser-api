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

/**
 * <b>Determines lemmas of word forms</b>.
 * <p>
 * Lemmatization is the process of determining the lemma for a given word. 
 * </p>
 * <p>
 * A <b>lemmatizer</b> performs the lemmatization process.
 * </p>
 * <p>
 * Each lemmatizers can additionally perform stemming process therefore
 * this interface inherits form the {@link Stemmer} interface.
 * </p>
 * 
 * @author Jakub Strychowski
 */
public interface Lemmatizer extends Stemmer {

    /**
     * Returns the best lemma for the given word form.
     *
     * @param   wordForm    The form which should be analysed.
     *
     * @return  The lemma of the given word form.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if an error occurred 
     * during the analysis of the word form.
     */
    String getLemma(String wordForm) throws MorphologyException;

    /**
     * Returns possible lemmas for a given word form.
     * <p>
     * A lemmatizer can return many lemmas for a single analysed form. 
     * This situation occurs when form belongs to many lexemes or it is 
     * impossible to perform lemmatization unambiguously. 
     * The final selection should be performed by a context or semantic analysis.
     * </p>
     * <p>
     * <b>Note:</b> 
     * You can use {@link #getLemmatizationResults} method to receive
     * an accuracy of the returned values.
     * </p>
     *
     * @param   wordForm    The form which should be lemmatized.
     * 
     * @return  The array of possible lemmas for the given word form. 
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if an error occurred 
     * during the analysis of the word form.
     */
    String[] getLemmas(String wordForm) throws MorphologyException;

    /**
     * Returns the best lemma for the given word form and an accuracy 
     * of a lemmatization process.
     *
     * @param   wordForm    The word form which should be lemmatized.
     *
     * @return  The lemma and its accuracy.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if an error occurred 
     * during the analysis of the word form.
     */
    AnalysisResult getLemmatizationResult(String wordForm) throws MorphologyException;

    /**
     * Returns possible lemmas for the given word form and an accuracy
     * of a lemmatization process.
     * <p>
     * Lemmatizers can return many lemmas for a single analysed word form. 
     * This situation occurs when form belongs to many lexemes or it is 
     * impossible to perform lemmatization unambiguously. 
     * The final selection should be performed by a context or semantic analysis.
     * </p>
     *
     * @param   wordForm    The word form which should be lemmatized.
     * 
     * @return  The array of lemmas of the given word form and their accuracy 
     *          sorted from the best to the worst. 
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if an error occurred 
     * during the analysis of the word form.
     */
    AnalysisResult[] getLemmatizationResults(String wordForm) throws MorphologyException;
}
