package com.choudou5.javasaasx.base.logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A Class to monitor Logging events and hold N events in memory
 *
 * This is abstract so we can support both JUL and Log4j (and other logging platforms)
 */
public abstract class LogWatcher<E> {

    private static final Logger log = LoggerFactory.getLogger(LogWatcher.class);

    public static final String[] LEVELS = new String[]{"ALL", "TRACE", "DEBUG", "INFO", "WARN", "ERROR", "FATAL", "OFF"};

    protected CircularList<E> history;
    protected long last = -1;

    /**
     * @return The valid level names for this framework
     */
    public List<String> getAllLevels(){
        return Arrays.asList(LEVELS);
    }

    /**
     * Sets the log level within this framework
     */
    public abstract void setLogLevel(String category, String level);

    /**
     * @return all registered loggers
     */
    public abstract Collection<LoggerInfo> getAllLoggers();

    public void add(E event, long timstamp) {
        history.add(event);
        last = timstamp;
    }

    public long getLastEvent() {
        return last;
    }

    public int getHistorySize() {
        return (history==null) ? -1 : history.getBufferSize();
    }

    public List<Map> getHistory(long since, AtomicBoolean found) {
        if(history==null) {
            return null;
        }
        List<Map> docs = new ArrayList<>();
        Iterator<E> iter = history.iterator();
        while(iter.hasNext()) {
            E e = iter.next();
            long ts = getTimestamp(e);
            if(ts == since) {
                if(found!=null) {
                    found.set(true);
                }
            }
            if(ts>since) {
                docs.add(toDoc(e));
            }
        }
        return docs;
    }

    public abstract long getTimestamp(E event);
    public abstract Map toDoc(E event);

    public abstract void registerListener(ListenerConfig cfg);

    public void reset() {
        history.clear();
        last = -1;
    }

}
