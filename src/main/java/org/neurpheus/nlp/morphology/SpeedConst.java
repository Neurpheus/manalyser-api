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
 * Defines speed constants for morphological components.
 * 
 * @author Jakub Strychowski
 */
public abstract class SpeedConst {

    /** Maximum value of speed property. */
    public static final int MAXIMUM = 100;
    /** Speed of a component which returns results immediately. */
    public static final int INSTANST = 100;
    /** Speed of a component which returns results very quickly. */
    public static final int VERY_FAST = 80;
    /** Speed of a component which returns results quickly. */
    public static final int FAST = 60;
    /** Speed of a component which returns results in acceptable time. */
    public static final int MEDIUM = 40;
    /** Speed of a component which returns results slowly. */
    public static final int SLOW = 20;
    /** Speed of a component which returns results very slowly. */
    public static final int VERY_SLOW = 10;
    /** Speed of a component which returns results very, very slowly. */
    public static final int TESTUDINAL = 5;
    /** Minimum value of speed property. */
    public static final int MINIMUM = 1;

    /**
     * This class cannot be instanced.
     */
    private SpeedConst() {

    }
}
