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

package com.questdb.ql.ops.col;

import com.questdb.io.sink.CharSink;
import com.questdb.ql.Record;
import com.questdb.ql.StorageFacade;
import com.questdb.ql.ops.AbstractVirtualColumn;
import com.questdb.store.ColumnType;

public class StrRecordSourceColumn extends AbstractVirtualColumn {
    private final int index;

    public StrRecordSourceColumn(int index) {
        super(ColumnType.STRING);
        this.index = index;
    }

    @Override
    public CharSequence getFlyweightStr(Record rec) {
        return rec.getFlyweightStr(index);
    }

    @Override
    public CharSequence getFlyweightStrB(Record rec) {
        return rec.getFlyweightStrB(index);
    }

    @Override
    public CharSequence getStr(Record rec) {
        return rec.getStr(index);
    }

    @Override
    public void getStr(Record rec, CharSink sink) {
        rec.getStr(index, sink);
    }

    @Override
    public int getStrLen(Record rec) {
        return rec.getStrLen(index);
    }

    @Override
    public boolean isConstant() {
        return false;
    }

    @Override
    public void prepare(StorageFacade facade) {
    }
}
