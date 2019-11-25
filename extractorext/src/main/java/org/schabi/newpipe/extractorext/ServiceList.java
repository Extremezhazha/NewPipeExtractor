package org.schabi.newpipe.extractorext;

import org.schabi.newpipe.extractorext.services.youtubeext.YoutubeService;

import java.util.List;

import org.schabi.newpipe.extractor.StreamingService;

import static java.util.Arrays.asList;

/*
 * Copyright (C) Christian Schabesberger 2018 <chris.schabesberger@mailbox.org>
 * ServiceList.java is part of NewPipe.
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

/**
 * A list of supported services.
 */
public final class ServiceList {
    private ServiceList() {
        //no instance
    }

    public static final YoutubeService YouTube;
    /**
     * When creating a new service, put this service in the end of this list,
     * and give it the next free id.
     */
    private static List<StreamingService> SERVICES =
            asList(
                    (StreamingService) (YouTube = new YoutubeService(0))
            );

    /**
     * Get all the supported services.
     *
     * @return a unmodifiable list of all the supported services
     */
    public static List<StreamingService> all() {
        return SERVICES;
    }

    public static int nextId(){ return SERVICES.size(); }
}