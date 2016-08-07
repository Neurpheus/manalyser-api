/*
 * Neurpheus - Morfological Analyser
 *
 * Copyright (C) 2006-2009 Jakub Strychowski
 *
 *  This library is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU Lesser General Public License as published by the Free
 *  Software Foundation; either version 2.1 of the License, or (at your option)
 *  any later version.
 *
 *  This library is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *  or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 *  for more details.
 */
package org.neurpheus.nlp.morphology.baseimpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Utility class which reduce size of data stored in streams.
 *
 * @author Jakub Strychowski
 */
public class TagsetStreamPacker {

    private final static Logger logger = Logger.getLogger(TagsetStreamPacker.class.getName());

    public static void writeInt(int id, DataOutputStream out) throws IOException {
        if (id < Byte.MAX_VALUE - 1) {
            out.writeByte(id);
        } else if (id < Short.MAX_VALUE) {
            out.writeByte(Byte.MAX_VALUE - 1);
            out.writeShort(id);
        } else {
            out.writeByte(Byte.MAX_VALUE);
            out.writeInt(id);
        }
    }

    public static void writeString(final String str, DataOutputStream out) throws IOException {
        if (str == null) {
            writeInt(-1, out);
        } else {
            byte[] bytes = str.getBytes("utf-8");
            writeInt(bytes.length, out);
            out.write(bytes);
        }
    }

    private final static char[] EMPTY_CHAR_ARRAY = new char[0];

    private final static String EMPTY_STRING = "";

    public static String decode(byte[] bytes) {
        if (bytes == null) {
            return null;
        } else if (bytes.length == 0) {
            return EMPTY_STRING;
        } else {
            char[] result = new char[bytes.length];
            final int blen = bytes.length;
            int bpos = 0;
            int cpos = 0;
            char c;
            while (bpos < blen) {
                c = (char) (0xFF & bytes[bpos++]);
                if ((c & 0x80) != 0) {
                    if ((c & 0xC0) == 0xC0) {
                        c = (char) (((c & 0x1F) << 6) | (bytes[bpos++] & 0x3F));
                    } else if ((c & 0xE0) == 0xE0) {
                        c = (char) (((c & 0x0F) << 12) | ((bytes[bpos++] & 0x3F) << 6) | (bytes[bpos++] & 0x3F));
                    } else if ((c & 0xF8) == 0xF0) {
                        bpos += 3;
                        logger.warning("Unsupported characted found: " + Integer.toHexString((int) c));
                    }
                }
                result[cpos++] = c;
            }
            return new String(result, 0, cpos);
        }
    }

    public static String readString(DataInputStream in) throws IOException {
        int v = readInt(in);
        if (v == -1) {
            return null;
        } else {
            byte[] bytes = new byte[v];
            in.readFully(bytes);
            return decode(bytes);
        }
    }


    public static int readInt(DataInputStream in) throws IOException {
        byte b = in.readByte();
        if (b < Byte.MAX_VALUE - 1) {
            return (int) b;
        } else if (b == Byte.MAX_VALUE) {
            return in.readInt();
        } else {
            return in.readShort();
        }
    }

    public static void writeStringsMap(final Map map, final DataOutputStream out) throws IOException {
        int size = map == null ? 0 : map.size();
        writeInt(size, out);
        if (size > 0) {
            for (final Iterator it = map.entrySet().iterator(); it.hasNext();) {
                Map.Entry entry = (Map.Entry) it.next();
                writeString(entry.getKey().toString(), out);
                writeString(entry.getValue().toString(), out);
            }
        }
    }

    public static Map readStringsMap(final DataInputStream in) throws IOException {
        int size = readInt(in);
        Map result = new HashMap();
        for (int i = 0; i < size; i++) {
            String key = readString(in);
            String value = readString(in);
            result.put(key, value);
        }
        return result;
    }

    public static void writeStringArrayMap(final Map map, final DataOutputStream out) throws IOException {
        int size = map == null ? 0 : map.size();
        writeInt(size, out);
        if (size > 0) {
            for (final Iterator it = map.entrySet().iterator(); it.hasNext();) {
                Map.Entry entry = (Map.Entry) it.next();
                writeString(entry.getKey().toString(), out);
                String[] a = (String[]) entry.getValue();
                int len = a == null ? 0 : a.length;
                writeInt(len, out);
                for (int i = 0; i < len; i++) {
                    writeString(a[i], out);
                }
            }
        }
    }

    public static Map readStringArrayMap(final DataInputStream in) throws IOException {
        int size = readInt(in);
        Map result = new HashMap();
        for (int i = 0; i < size; i++) {
            String key = readString(in);
            int len = readInt(in);
            String[] a = new String[len];
            for (int j = 0; j < len; j++) {
                a[j] = readString(in);
            }
            result.put(key, a);
        }
        return result;
    }

}
