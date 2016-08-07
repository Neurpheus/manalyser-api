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
 * Defines quality constants for morphological components.
 * 
 * @author Jakub Strychowski
 */
public abstract class QualityConst {

    /** Maximum value of quality property. */
    public static final int MAXIMUM = 100;
    /** Quality of a component which does not make any errors. */
    public static final int PERFECT = 100;
    /** Quality of a component which does not make more errors then an expert from the morphology domain. */
    public static final int EXPERT = 95;
    /** Quality of a component which does not make more errors then a common native speaker. */
    public static final int COMMON_PERSON = 90;
    /** 
     * Quality of a component which does not make more errors then a common person 
     * who is not a native speaker. 
     */
    public static final int VERY_GOOD = 85;
    /** Quality of a component which does not make a lot of errors. */
    public static final int GOOD = 80;
    /** Quality of a component which can be used in a system but provides errors during processing. */
    public static final int FAIR = 70;
    /** Quality of a component which can be used for some task for which the quality is not so important. */
    public static final int ACCEPTABLE = 60;
    /** Quality of a component which does many errors but realises its task. */
    public static final int POOR = 50;
    /** Quality of a component which provides many errors but can be used for testing. */
    public static final int BAD = 40;
    /** Quality of a component which should not be used at all. */
    public static final int VERY_BAD = 30;
    /** Quality of a component which fails a natural language processing. */
    public static final int FAILURE = 20;
    /** Minimum value of quality property. */
    public static final int MINIMUM = 1;

    /**
     * This class cannot be instanced.
     */
    private QualityConst() {

    }
}
