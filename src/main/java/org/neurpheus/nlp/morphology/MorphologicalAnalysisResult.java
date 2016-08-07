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

import org.neurpheus.nlp.morphology.tagset.GrammaticalPropertiesList;

/**
 * Represents a result produced by a morphological analyser.
 *
 * @author Jakub Strychowski
 */
public interface MorphologicalAnalysisResult extends AnalysisResult {
    
    /**
     * Returns grammatical properties of an analysed form.
     * 
     * @return The grammatical properties determined from morphemes of the analysed form.
     */
    GrammaticalPropertiesList getGrammaticalPropertiesList();
    
    
    /**
     * Returns the core of an analysed word form.
     *      
     * @return The core of the analysed form. 
     * The '*' sign denotes places where grammatical morphemes occurs.
     */
    String getCore();

    /**
     * Returns a string representing a set of grammatical morphemes of an analysed word form.
     * 
     * @return The grammatical morphemes of the analysed form.
     * The '*' sign denotes places where the core of the form occurs.
     */
    String getGrammaticalMorphemes();
    
    
    
}
