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

import org.neurpheus.nlp.morphology.tagset.GrammaticalProperties;

/**
 * <b>Generates different word forms from a base form and target grammatical properties</b>.
 * 
 * @author Jakub Strychowski
 */
public interface WordFormGenerator extends MorphologicalComponent {

    /**
     * Generates a word form described by the given grammatical properties.
     * 
     * @param baseForm The base form of a word (lemma of a lexeme). 
     * 
     * @param targetGrammaticalProperties The object representing the grammatical
     *          properties of the target word form.
     *  
     * @return The generated form.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if a serious error 
     * occurred during the generation.
     */
    String generateWordForm(String baseForm, GrammaticalProperties targetGrammaticalProperties)
            throws MorphologyException;

    /**
     * Generates a word form described by the given grammatical properties.
     * 
     * @param baseForm The base form of a word (lemma of a lexeme). 
     * 
     * @param targetGrammaticalProperties The symbol (mark) representing grammatical
     *          properties of the target word form.
     *  
     * @return The generated form.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if a serious error 
     * occurred during the generation.
     */
    String generateWordForm(String baseForm, String targetGrammaticalProperties)
            throws MorphologyException;
}
