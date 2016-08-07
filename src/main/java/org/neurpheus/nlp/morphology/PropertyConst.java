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
 * Defines names of standard properties describing morphological components.
 * 
 * @author Jakub Strychowski
 */
public abstract class PropertyConst {

    /**
     * The name of a property which holds the official name of a module.
     */
    public static final String NAME = "name";
    /**
     * The name of a property which holds the version of a module.
     */
    public static final String VERSION = "version";
    /**
     * The name of a property which holds the vendor name of a module.
     */
    public static final String VENDOR = "vendor";
    /**
     * The name of a property which holds the comma separate list of authors 
     * of a module.
     */
    public static final String AUTHORS = "authors";
    /**
     * The name of a property which holds the date when a module was build.
     */
    public static final String BUILD_DATE = "buildDate";
    /**
     * The name of a property which holds information about a module licence.
     */
    public static final String LICENCE = "licence";
    /**
     * The name of a property which holds the location of a module web-page.
     */
    public static final String WEB_PAGE = "webPage";
    /**
     * The name of a property which holds short description of a module.
     */
    public static final String DESCRIPTION = "description";
    /**
     * The name of a property which holds the copyright information
     * about a module.
     */
    public static final String COPYRIGHT = "copyright";

    /**
     * This class cannot be instanced.
     */
    private PropertyConst() {

    }
}
