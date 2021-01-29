package com.cy.pj.sys.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class logTests {
    private static final Logger logger = LoggerFactory.getLogger(logTests.class);

    @Test
    void testLevel(){
        //lever:trace<debug<info<warn<error
        logger.trace("log.lever.trace");
        logger.debug("log.lever.debug");
        logger.info("log.lever.info");
        logger.warn("log.lever.warn");
        logger.error("log.lever.error");
    }
}
