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

/**
 * <b>Performs the morphological analysis task</b>.
 *
 * <p>
 * Each morphological analyser can perform also lemmatization and stemming task.
 * </p>
 * 
 * @author Jakub Strychowski
 */
public interface MorphologicalAnalyser extends Lemmatizer {
    
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
    MorphologicalAnalysisResult[] analyse(String wordForm) throws MorphologyException;
    
}
