package com.epam.lab.reportutils;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.util.ArrayList;
import java.util.List;

public class ReportApender extends AppenderSkeleton {
    private List<LoggingEvent> eventList = new ArrayList<>();

    @Override
    protected void append(LoggingEvent loggingEvent) {
        eventList.add(loggingEvent);
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
