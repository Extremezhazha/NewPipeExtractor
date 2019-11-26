package org.schabi.newpipe.extractor;

public interface StreamingServiceFactory {
    StreamingService make(int index);
}
