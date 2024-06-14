package com.kmSystem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private static final Logger log = LoggerFactory.getLogger(LogService.class);

    public void info(String id) {
        log.info("打了一个infolog，id是: {}", id);
    }
    public void debug(String id) {
        log.debug("打了一个debuglog，id是: {}", id);
    }
    public void warn(String id) {
        log.warn("打了一个warnlog，id是: {}", id);
    }
    public void error(String id) {
        log.error("打了一个errorlog，id是: {}", id);
    }
}
