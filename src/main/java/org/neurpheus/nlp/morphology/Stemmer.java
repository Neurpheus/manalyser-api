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
 * <b>Determines stems of word forms</b>.
 * <p>
 * A <b>stemmer</b> is an algorithm which determines a stem form of a given inflected 
 * (or, sometimes, derived) word form - generally a written word form. 
 * The stem need not be identical to the morphological root of the word; 
 * it is usually sufficient that related words map to the same stem, 
 * even if this stem is not in itself a valid root.
 * </p>
 * <p>
 * A stemmer for English, for example, should identify the string "cats" 
 * (and possibly "catlike", "catty" etc.) as based on the root "cat", 
 * and "stemmer", "stemming", "stemmed" as based on "stem".
 * </p>
 * <p>
 * <b>Note: </b> stemmers produce lowercased results.
 * </p>
 *
 *
 * @author Jakub Strychowski
 */
public interface Stemmer extends MorphologicalComponent {

        
    /**
     * Returns the best stem for the given word form.
     *
     * @param   wordForm    The word form which should be stemmed.
     *
     * @return  The stem of the given word form.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if an error occurred 
     * during the analysis of the word form.
     */
    String getStem(String wordForm) throws MorphologyException;
    
    /**
     * Returns possible stems for the given word form.
     * <p>
     * Stemmers may return many stems for a single analysed word form. 
     * This situation occurs when form belongs to many lexemes or it is 
     * impossible to perform stemming unambiguously. 
     * The final selection should be performed by a context or semantic analysis.
     * </p>
     * <p>
     * <b>Note:</b> 
     * You can use the {@link #getStemmingResults} method to receive
     * an accuracy of each returned stem.
     * </p>
     *
     * @param   wordForm    The word form which should be stemmed.
     * 
     * @return  The array of stems of the given word form sorted 
     *          according to accuracy (from the best to the worst).
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if an error occurred 
     * during the analysis of the word form.
     */
    String[] getStems(String wordForm) throws MorphologyException;

    
    /**
     * Returns the best stem for the given word form and an accuracy 
     * of a stemming process.
     *
     * @param   wordForm    The word form which should be stemmed.
     *
     * @return  The stem and its accuracy.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if an error occurred 
     * during the analysis of the word form.
     */
    AnalysisResult getStemmingResult(String wordForm) throws MorphologyException; 
    
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
    AnalysisResult[] getStemmingResults(String wordForm) throws MorphologyException;
    
    
}
