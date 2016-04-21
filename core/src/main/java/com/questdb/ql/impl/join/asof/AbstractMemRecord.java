/*******************************************************************************
 *    ___                  _   ____  ____
 *   / _ \ _   _  ___  ___| |_|  _ \| __ )
 *  | | | | | | |/ _ \/ __| __| | | |  _ \
 *  | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *   \__\_\\__,_|\___||___/\__|____/|____/
 *
 * Copyright (c) 2014-2016 Appsicle
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.questdb.ql.impl.join.asof;

import com.questdb.factory.configuration.RecordMetadata;
import com.questdb.io.sink.CharSink;
import com.questdb.misc.Unsafe;
import com.questdb.ql.AbstractRecord;
import com.questdb.std.DirectInputStream;
import com.questdb.store.SymbolTable;

import java.io.OutputStream;

abstract class AbstractMemRecord extends AbstractRecord {

    AbstractMemRecord(RecordMetadata metadata) {
        super(metadata);
    }

    @Override
    public byte get(int col) {
        return Unsafe.getUnsafe().getByte(address(col));
    }


    @Override
    public void getBin(int col, OutputStream s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public DirectInputStream getBin(int col) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getBinLen(int col) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getBool(int col) {
        return Unsafe.getBool(address(col));
    }

    @Override
    public long getDate(int col) {
        return Unsafe.getUnsafe().getLong(address(col));
    }

    @Override
    public double getDouble(int col) {
        return Unsafe.getUnsafe().getDouble(address(col));
    }

    @Override
    public float getFloat(int col) {
        return Unsafe.getUnsafe().getFloat(address(col));
    }

    @Override
    public CharSequence getFlyweightStr(int col) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CharSequence getFlyweightStrB(int col) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getInt(int col) {
        return Unsafe.getUnsafe().getInt(address(col));
    }

    @Override
    public long getLong(int col) {
        return Unsafe.getUnsafe().getLong(address(col));
    }

    @Override
    public long getRowId() {
        return -1;
    }

    @Override
    public short getShort(int col) {
        return Unsafe.getUnsafe().getShort(address(col));
    }

    @Override
    public CharSequence getStr(int col) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getStr(int col, CharSink sink) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getStrLen(int col) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getSym(int col) {
        return getSymbolTable(col).value(Unsafe.getUnsafe().getInt(address(col)));
    }

    protected abstract long address(int col);

    protected abstract SymbolTable getSymbolTable(int col);
}
