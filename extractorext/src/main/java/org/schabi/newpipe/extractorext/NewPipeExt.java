package org.schabi.newpipe.extractorext;

/*
 * Created by Christian Schabesberger on 23.08.15.
 *
 * Copyright (C) Christian Schabesberger 2015 <chris.schabesberger@mailbox.org>
 * NewPipe.java is part of NewPipe.
 *
 * NewPipe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * NewPipe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with NewPipe.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.schabi.newpipe.extractor.StreamingService;
import org.schabi.newpipe.extractor.StreamingServiceFactory;

import java.util.List;
import java.util.function.Function;

/**
 * Provides access to streaming services supported by NewPipe.
 */
public class NewPipeExt {

    private NewPipeExt() {
    }


    public static List<StreamingServiceFactory> getAddList() {
        return ServiceList.all();
    }
}
