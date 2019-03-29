package de.comsystoreply.spring.core.bootcamp.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {WebConfiguration.class}
)
class CarControllerTest {
    @Autowired
    private CarController carController;

    @Test
    void hasAutowired() {
        // TODO: ...
    }
}