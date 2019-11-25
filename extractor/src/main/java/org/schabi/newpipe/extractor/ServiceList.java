package org.schabi.newpipe.extractor;

import org.schabi.newpipe.extractor.services.media_ccc.MediaCCCService;
import org.schabi.newpipe.extractor.services.soundcloud.SoundcloudService;
import org.schabi.newpipe.extractor.services.youtube.YoutubeService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

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
    public static final SoundcloudService SoundCloud;
    public static final MediaCCCService MediaCCC;

    /**
     * When creating a new service, put this service in the end of this list,
     * and give it the next free id.
     */
    private static List<StreamingService> SERVICES = new ArrayList<>(asList(
            YouTube = new YoutubeService(0),
            SoundCloud = new SoundcloudService(1),
            MediaCCC = new MediaCCCService(2)
    ));

    private static Set<String> ADDED_SERVICES = new HashSet<>();

    /**
     * Get all the supported services.
     *
     * @return a unmodifiable list of all the supported services
     */
    public static List<StreamingService> all() {
        return SERVICES;
    }

    public static void addService(Function<Integer, StreamingService> constructService) {
        StreamingService currentService = constructService.apply(SERVICES.size());
        if (!ADDED_SERVICES.contains(currentService.getServiceInfo().getName())) {
            ADDED_SERVICES.add(currentService.getServiceInfo().getName());
            SERVICES.add(currentService);
        }
    }

    public static void addServices(List<Function<Integer, StreamingService>> constructServiceList) {
        for (Function<Integer, StreamingService> constructService : constructServiceList)
            addService(constructService);
    }

}
