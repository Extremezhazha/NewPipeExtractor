package org.schabi.newpipe.extractorext;

import org.schabi.newpipe.extractor.StreamingServiceFactory;
import org.schabi.newpipe.extractorext.services.youtubeext.YoutubeService;

import java.util.List;
import java.util.function.Function;

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

    private static class YoutubeServiceFactory implements StreamingServiceFactory {

        @Override
        public StreamingService make(int index) {
            return new YoutubeService(index);
        }
    }

    private static StreamingServiceFactory factory;

    /**
     * When creating a new service, put this service in the end of this list,
     * and give it the next free id.
     */
    private static List<StreamingServiceFactory> SERVICES =
            asList(
                    factory = new YoutubeServiceFactory()
            );

    /**
     * Get all the supported services.
     *
     * @return a unmodifiable list of all the supported services
     */
    public static List<StreamingServiceFactory> all() {
        return SERVICES;
    }

}
