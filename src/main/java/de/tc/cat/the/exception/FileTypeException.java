package de.tc.cat.the.exception;

/*
 * Copyright (C) 2019 the-c
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Returns a Exception is file type not corect.
 *
 * @author Christian Trostmann
 * @version 1.0
 * @see java.io.Serializable
 * @see java.lang.Exception
 * @see java.lang.Throwable
 * @since 13
 */
public class FileTypeException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1800731807444388907L;

	/**
     * Creates a new instance of {@codeFileTypeException} without detail
     * message.
     */
    public FileTypeException() {
        super("This file type is not supportet for this class.");
    }
}
