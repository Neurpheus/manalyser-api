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

/**
 * General exception caused by components performing morphological processing.
 *
 * @author Jakub Strychowski
 */
public class MorphologyException extends Exception implements Serializable {

    /** UID of this class. */
    static final long serialVersionUID = 770608290208165747L;

    /**
     * Constructs a new exception with <code>null</code> as its detail message.
     * The cause is not initialised, and may subsequently be initialised by a
     * call to <code>initCause</code>.
     */
    public MorphologyException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialised, and may subsequently be initialised by
     * a call to <code>initCause</code>.
     *
     * @param   message   the detail message. The detail message is saved for 
     *          later retrieval by the <code>getMessage()</code> method.
     */
    public MorphologyException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * <code>cause</code> is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the <code>getMessage()</code> method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         <code>getCause()</code> method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.4
     */
    public MorphologyException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>).
     * This constructor is useful for exceptions that are little more than
     * wrappers for other throwables (for example, <code>
     * java.security.PrivilegedActionException</code>).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         <code>getCause()</code> method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     */
    public MorphologyException(final Throwable cause) {
        super(cause);
    }
}
