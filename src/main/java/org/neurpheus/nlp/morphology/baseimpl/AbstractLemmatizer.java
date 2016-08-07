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

import org.neurpheus.nlp.morphology.AnalysisResult;
import org.neurpheus.nlp.morphology.Lemmatizer;
import org.neurpheus.nlp.morphology.MorphologyException;

/**
 * Basic, abstract implementation of a lemmatizer component.
 * 
 * If your class extends this class then it is enough to implement the {@link org.neurpheus.nlp.morphology.Lemmatizer#getLemmatizationResults} method.
 *
 * @author Jakub Strychowski
 */
public abstract class AbstractLemmatizer extends AbstractStemmer implements Lemmatizer {

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
    public String getLemma(String wordForm) throws MorphologyException {
        if (wordForm == null) {
            throw new NullPointerException("The [wordForm] argument cannot be null.");
        }
        AnalysisResult[] results = getLemmatizationResults(wordForm);
        if (results == null || results.length == 0) {
            String className = this.getClass().getName();
            throw new NullPointerException("The lemmatizer " + className 
                    + " has returned empty or null result for the word form : " + wordForm);
        }
        return results[0].getForm();
    }

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
    public String[] getLemmas(String wordForm) throws MorphologyException {
        if (wordForm == null) {
            throw new NullPointerException("The [wordForm] argument cannot be null.");
        }
        AnalysisResult[] results = getLemmatizationResults(wordForm);
        if (results == null || results.length == 0) {
            String className = this.getClass().getName();
            throw new NullPointerException("The lemmatizer " + className 
                    + " has returned empty or null result for the word form : " + wordForm);
        }
        String[] r = new String[results.length];
        for (int i = results.length - 1; i >= 0; i--) {
            r[i] = results[i].getForm();
        }
        return r;
        
    }

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
    public AnalysisResult getLemmatizationResult(String wordForm) throws MorphologyException {
        if (wordForm == null) {
            throw new NullPointerException("The [wordForm] argument cannot be null.");
        }
        AnalysisResult[] results = getLemmatizationResults(wordForm);
        if (results == null || results.length == 0) {
            String className = this.getClass().getName();
            throw new NullPointerException("The lemmatizlength" + className 
                    + " has returned empty or null result for the word form : " + wordForm);
        }
        return results[0];
    }

    /**
     * Returns possible stems for the given word form and an accuracy
     * of a stemming process.
     * <p>
     * Stemmers may return many stems for a single analysed word form. 
     * This situation occurs when form belongs to many lexemes or it is 
     * impossible to perform stemming unambiguously. 
     * The final selection should be performed by a context or semantic analysis.
     * </p>
     *
     * @param   wordForm    The word form which should be stemmed.
     * 
     * @return  The array of stems of the given word form and their accuracy 
     *          sorted from the best to the worst. 
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if an error occurred 
     * during the analysis of the word form.
     */
    public AnalysisResult[] getStemmingResults(String wordForm) throws MorphologyException {
        return getLemmatizationResults(wordForm);
    }
    
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
    public abstract AnalysisResult[] getLemmatizationResults(String wordForm) throws MorphologyException;
    
}
