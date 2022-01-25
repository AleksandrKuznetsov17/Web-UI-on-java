package ru.gb.lesson.lesson4.extentions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gb.lesson.lesson4.TriangleTest;

public class TestTimer implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final Logger logger = LoggerFactory.getLogger(TestTimer.class);

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        long startTime = System.currentTimeMillis();
        extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).put("start time", startTime);
        logger.info("Start test: " + extensionContext.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        long endTime = System.currentTimeMillis();
        long startTime = (long) extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).get("start time");
        logger.info("End test: " + extensionContext.getDisplayName() + ". Duration: " + (endTime - startTime) + " ms");
    }
}
