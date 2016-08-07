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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.neurpheus.nlp.morphology.MorphologicalComponent;
import org.neurpheus.nlp.morphology.MorphologyException;

/**
 * Abstract implementation of a morphological component.
 *
 * @author Jakub Strychowski
 */
public abstract class AbstractMorphologicalComponent implements MorphologicalComponent {

    /** Holds properties of this morphological component. */
    private Map properties = new HashMap();
    /** Holds locales supported by this component. */
    private Collection supportedLocales = new ArrayList();
    /** Flag denoting if this component has been initialised. */
    private boolean initialized = false;
    /** Flag denoting if this component has been suspended. */
    private boolean suspended = false;

    /**
     * Forces an initialisation of this component. 
     * The component should initialise itself automaticly before processing, 
     * but a client may use this method to perform the initialisation
     * in particular conditions (for example when the system starts up).
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if the component cannot be initialised.
     */
    public void init() throws MorphologyException {
        if (!initialized) {
            initialized = true;
        }
    }

    /**
     * Frees all resources consumed by this components and destroys it.
     * The component cannot be used any more after invocation of this method.
     */
    public void destroy() {
        if (properties != null) {
            properties.clear();
            properties = null;
        }
        if (supportedLocales != null) {
            supportedLocales.clear();
            supportedLocales = null;
        }
    }

    /**
     * Suspends the component freeing consumed resources.
     * The component will not be used for a long time and should free 
     * as much resources as possible.
     * After invocation of this method the component can be resumed by 
     * the {@link #resume} method.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if the component cannot be suspended.
     */
    public void suspend() throws MorphologyException {
        if (!initialized) {
            init();
        }
        if (!suspended) {
            suspended = true;
        }
    }

    /**
     * Resumes this component from the suspension state.
     * The component loads again all resources required for a morphological processing.
     * The resumed component should perform its tasks immediately.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if the component cannot be resumed.
     */
    public void resume() throws MorphologyException {
        if (!initialized) {
            init();
        }
        if (suspended) {
            suspended = false;
        }
    }

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
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#PERFECT} = 100</li>
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#EXPERT} = 95</li>
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#COMMON_PERSON} = 90</li>
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#VERY_GOOD} = 85</li>
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#GOOD} = 80</li>
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#FAIR} = 70</li>
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#ACCEPTABLE} = 60</li>
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#POOR} = 50</li>
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#BAD} = 40</li>
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#VERY_BAD} = 30</li>
     *     <li>{@link org.neurpheus.nlp.morphology.QualityConst#FAILURE} = 20</li>
     * </ul>
     * </p>
     * 
     * @return The quality of this component.
     */
    public abstract int getQuality();

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
     *     <li>{@link org.neurpheus.nlp.morphology.SpeedConst#INSTANST} = 100 (500000 words/s)</li>
     *     <li>{@link org.neurpheus.nlp.morphology.SpeedConst#VERY_FAST} = 80 (100000 words/s)</li>
     *     <li>{@link org.neurpheus.nlp.morphology.SpeedConst#FAST} = 60 (50000 words/s)</li>
     *     <li>{@link org.neurpheus.nlp.morphology.SpeedConst#MEDIUM} = 40  (10000 words/s)</li>
     *     <li>{@link org.neurpheus.nlp.morphology.SpeedConst#SLOW} = 20 (5000 words/s)</li>
     *     <li>{@link org.neurpheus.nlp.morphology.SpeedConst#VERY_SLOW} = 10 (1000 words/s)</li>
     *     <li>{@link org.neurpheus.nlp.morphology.SpeedConst#TESTUDINAL} = 5 (500 words/s)</li>
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
    public abstract int getSpeed();

    /**
     * Returns a collection of locales representing languages supported by this component.
     * 
     * @return A collection of {@link java.util.Locale} objects.
     */
    public Collection getSupportedLocales() {
        return supportedLocales;
    }

    /**
     * Returns an information about this component.
     *
     * @param   propertyName    The name of a property holding the information.
     *   Some names of properties are defined as constant values in 
     *   the {@link org.neurpheus.nlp.morphology.PropertyConst} class, for example:<ul>
     *   <li>{@link org.neurpheus.nlp.morphology.PropertyConst#NAME}, </li>
     *   <li>{@link org.neurpheus.nlp.morphology.PropertyConst#VERSION}, </li>
     *   <li>{@link org.neurpheus.nlp.morphology.PropertyConst#VENDOR}, </li>
     *   <li>{@link org.neurpheus.nlp.morphology.PropertyConst#AUTHORS}, </li>
     *   <li>{@link org.neurpheus.nlp.morphology.PropertyConst#BUILD_DATE}, </li>
     *   <li>{@link org.neurpheus.nlp.morphology.PropertyConst#LICENCE}, </li>
     *   <li>{@link org.neurpheus.nlp.morphology.PropertyConst#WEB_PAGE}, </li>
     *   <li>{@link org.neurpheus.nlp.morphology.PropertyConst#DESCRIPTION}, </li>
     *   <li>{@link org.neurpheus.nlp.morphology.PropertyConst#COPYRIGHT}.</li></ul>
     *
     * @return  The value of property or <code>null</code> if property is unavailable.
     */
    public Object getProperty(String propertyName) {
        if (propertyName == null) {
            throw new NullPointerException("The [propertyName] argument cannot be null.");
        }
        return properties.get(propertyName);
    }

    /**
     * Returns an instance of this component for the specified language.
     * 
     * @param locale The locales representing a language supported by this component.
     * 
     * @return An instances of the component supporting the given language.
     * 
     * @throws org.neurpheus.nlp.morphology.MorphologyException if the instance cannot be created.
     */
    public abstract MorphologicalComponent getInstance(final Locale locale) throws MorphologyException;

    /**
     * Return a map of properties of this morphological component.
     * 
     * @return Mapping between names (String) and values (Object) of properties.
     */
    protected Map getProperties() {
        return properties;
    }

    /**
     * Sets collection of properties for this morphological component.
     * 
     * @param newProperties Mapping between names (String) and values (Object) of properties.
     */
    protected void setProperties(final Map newProperties) {
        if (newProperties == null) {
            throw new NullPointerException("The [newProperties] argument cannot be null.");
        }
        properties = newProperties;
    }

    /**
     * Sets a new value of a property.
     * 
     * @param propertyName The name of the property.
     * @param value The new value.
     */
    protected void setProperty(final String propertyName, final Object value) {
        if (propertyName == null) {
            throw new NullPointerException("The [propertyName] argument cannot be null.");
        }
        properties.put(propertyName, value);
    }

    /**
     * Sets collection of locales supported by this morphological component.
     * 
     * @param newSupportedLocales Collection of <code>Locale</code> objects.
     */
    public void setSupportedLocales(final Collection newSupportedLocales) {
        if (newSupportedLocales == null) {
            throw new NullPointerException("The [newSupportedLocales] argument cannot be null.");
        }
        supportedLocales = newSupportedLocales;
    }

    /**
     * Checks if this component has been initialised.
     * 
     * @return <code>true</code> if component has been initialised.
     */
    public boolean isInitialized() {
        return initialized;
    }

    /**
     * Changes initialisation state of this component.
     * 
     * @param newInitialized <code>true</code> if component has been initialised.
     */
    protected void setInitialized(final boolean newInitialized) {
        initialized = newInitialized;
    }

    /**
     * Checks if this component has been suspended.
     * 
     * @return <code>true</code> if component is suspended.
     */
    public boolean isSuspended() {
        return suspended;
    }

    /**
     * Changes suspension state of this component.
     * 
     * @param newSuspended <code>true</code> if component is suspended.
     */
    protected void setSuspended(final boolean newSuspended) {
        suspended = newSuspended;
    }
}
