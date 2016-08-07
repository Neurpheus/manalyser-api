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
import org.neurpheus.nlp.morphology.MorphologicalAnalyser;
import org.neurpheus.nlp.morphology.MorphologicalAnalysisResult;
import org.neurpheus.nlp.morphology.MorphologyException;

/**
 * Basic, abstract implementation of a morphological component.
 * 
 * If your class extends this class then it is enough to implement the {@link #analyse} method.
 *
 * @author Jakub Strychowski
 */
public abstract class AbstractMorphologicalAnalyser 
        extends AbstractLemmatizer implements MorphologicalAnalyser {

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
    public AnalysisResult[] getLemmatizationResults(String wordForm) throws MorphologyException {
        if (wordForm == null) {
            throw new NullPointerException("The [wordForm] argument cannot be null.");
        }
        return analyse(wordForm);
    }
    
    /**
     * Analyse morphologically the given word form and returns possible results.
     * 
     * @param wordForm The word form which should be analysed.
     * 
     * @return An array of {@link MorphologicalAnalysisResult} objects.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if a serious error 
     * occurred during the analysis.
     */
    public abstract MorphologicalAnalysisResult[] analyse(String wordForm) throws MorphologyException;
    
}
