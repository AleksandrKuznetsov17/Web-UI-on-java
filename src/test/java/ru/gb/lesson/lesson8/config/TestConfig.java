package ru.gb.lesson.lesson8.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({"file:src/test/resources/config.properties"})
public interface TestConfig extends Config {
    TestConfig testConfig = ConfigFactory.create(TestConfig.class);

    String login();
    String password();
    String baseUrl();
}
