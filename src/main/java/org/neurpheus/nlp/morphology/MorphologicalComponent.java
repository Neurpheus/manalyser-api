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

import java.io.Serializable;
import java.util.Collection;
import java.util.Locale;

/**
 * <b>Represents a generic component which can analyse morphology of word forms</b>.
 * <p>
 * A real component may support many languages. The {@link #getSupportedLocales} method should
 * return information about all languages supported by the component.
 * </p>
 * <p>
 * The component can be described by a set of properties. The {@link #getProperty}
 * method returns values of these properties. 
 * </p>
 * <p>
 * Each component must control itself automatically but a client of this component
 * can optionally control it by the following methods:
 * <ul>
 * <li>{@link #init} - initialises resources of this component.</li>
 * <li>{@link #destroy} - destroys this component which will not be used any more</li>
 * <li>{@link #suspend} - suspends this component which will not be used for a long time, but
 * can be resumed if needed.</li>
 * <li>{@link #resume} - resumes this suspended component.</li>
 * </ul>
 * </p>
 * <p>
 * <b><font color="#FF0000">Each implementation of this interface must implement public constructor 
 * without parameters.</font></b>
 * </p>
 * 
 * @author Jakub Strychowski
 */
public interface MorphologicalComponent extends Serializable {


    /**
     * Forces an initialisation of this component. 
     * The component should initialise itself automaticly before processing, 
     * but a client may use this method to perform the initialisation
     * in particular conditions (for example when the system starts up).
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if the component cannot be initialised.
     */
    void init() throws MorphologyException;

    /**
     * Frees all resources consumed by this components and destroys it.
     * The component cannot be used any more after invocation of this method.
     */
    void destroy();

    /**
     * Suspends the component freeing consumed resources.
     * The component will not be used for a long time and should free 
     * as much resources as possible.
     * After invocation of this method the component can be resumed by 
     * the {@link #resume} method.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if the component cannot be suspended.
     */
    void suspend() throws MorphologyException;

    /**
     * Resumes this component from the suspension state.
     * The component loads again all resources required for a morphological processing.
     * The resumed component should perform its tasks immediately.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if the component cannot be resumed.
     */
    void resume() throws MorphologyException;

    /**
     * Returns the quality of this component as an integer value from 1 to 100 where
     * 100 denotes perfection. 
     * <p>
     * Returned value is used by the system to find best components if there are many available.
     * </p>
     * <p>
     * Be careful when you assign the quality property for you component. Do not assign
     * maximum values when your component is not perfect in all conditions or
     * is not as good as an experts from the domain or common person.
     * You should use one of the following constant values:
     * <ul>
     *     <li>{@link QualityConst#PERFECT} = 100</li>
     *     <li>{@link QualityConst#EXPERT} = 95</li>
     *     <li>{@link QualityConst#COMMON_PERSON} = 90</li>
     *     <li>{@link QualityConst#VERY_GOOD} = 85</li>
     *     <li>{@link QualityConst#GOOD} = 80</li>
     *     <li>{@link QualityConst#FAIR} = 70</li>
     *     <li>{@link QualityConst#ACCEPTABLE} = 60</li>
     *     <li>{@link QualityConst#POOR} = 50</li>
     *     <li>{@link QualityConst#BAD} = 40</li>
     *     <li>{@link QualityConst#VERY_BAD} = 30</li>
     *     <li>{@link QualityConst#FAILURE} = 20</li>
     * </ul>
     * </p>
     * 
     * @return The quality of this component.
     */
    int getQuality();

    /**
     * Returns the speed of this component as an integer value from 1 to 100 where
     * 100 denotes that the component returns results immediately.
     * <p>
     * A system uses returned value to find fastest component, if there are many components available.
     * </p>
     * <p>
     * Be careful when you assign the speed property for you component. Do not assign
     * maximum value if your component process less then 100000 words per second on 1GHz CPU.
     * You can use one of the following constant values 
     * (in the brackets proposed speed measured on 1GHz CPU on real text):
     * <ul>
     *     <li>{@link SpeedConst#INSTANST} = 100 (500000 words/s)</li>
     *     <li>{@link SpeedConst#VERY_FAST} = 80 (100000 words/s)</li>
     *     <li>{@link SpeedConst#FAST} = 60 (50000 words/s)</li>
     *     <li>{@link SpeedConst#MEDIUM} = 40  (10000 words/s)</li>
     *     <li>{@link SpeedConst#SLOW} = 20 (5000 words/s)</li>
     *     <li>{@link SpeedConst#VERY_SLOW} = 10 (1000 words/s)</li>
     *     <li>{@link SpeedConst#TESTUDINAL} = 5 (500 words/s)</li>
     * </ul>
     * </p>
     * <p><i>
     * When you measure speed of you component you should make following assumptions:<ul>
     * <li>Worm up you component before measuring.</li>
     * <li>A test set should be large enough.</li>
     * <li>Do not reserve to much memory for you component. The Java garbage collector 
     * has a big impact on an efficiency, and if you reserve to much memory it will
     * be not invoked. In real systems, which use multiple components, a memory consumption 
     * for a single component is limited.</li>
     * <li>If you measure speed on a CPU with frequency x multiply you results by 1GHz/x.</li>
     * <li>Do not change results for multi-core CPUs - your component can use many cores to speed up.</li>
     * <li>Test your component on PCs with common configuration.</li>
     * <li>Make tests on real data where words forms are distributed according to reality.</li>
     * </ul>
     * </i></p>
     * 
     * @return The speed of this component.
     */
    int getSpeed();

    /**
     * Returns a collection of locales representing languages supported by this component.
     * 
     * @return A collection of {@link java.util.Locale} objects.
     */
    Collection getSupportedLocales();

    /**
     * Returns an information about this component.
     *
     * @param   propertyName    The name of a property holding the information.
     *   Some names of properties are defined as constant values in 
     *   the {@link PropertyConst} class, for example:<ul>
     *   <li>{@link PropertyConst#NAME}, </li>
     *   <li>{@link PropertyConst#VERSION}, </li>
     *   <li>{@link PropertyConst#VENDOR}, </li>
     *   <li>{@link PropertyConst#AUTHORS}, </li>
     *   <li>{@link PropertyConst#BUILD_DATE}, </li>
     *   <li>{@link PropertyConst#LICENCE}, </li>
     *   <li>{@link PropertyConst#WEB_PAGE}, </li>
     *   <li>{@link PropertyConst#DESCRIPTION}, </li>
     *   <li>{@link PropertyConst#COPYRIGHT}.</li></ul>
     *
     * @return  The value of property or <code>null</code> if property is unavailable.
     */
    Object getProperty(String propertyName);
    
    
    
    /**
     * Returns an instance of this component for the specified language.
     * 
     * @param loc The locales representing a language supported by this component.
     * 
     * @return An instances of the component supporting the given language.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if the instance cannot be created.
     */
    MorphologicalComponent getInstance(Locale loc) throws MorphologyException;
    
}
