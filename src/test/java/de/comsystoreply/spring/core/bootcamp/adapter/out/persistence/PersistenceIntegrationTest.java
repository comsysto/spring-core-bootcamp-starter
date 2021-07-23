package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersistenceConfig.class)
@Transactional
abstract class PersistenceIntegrationTest {
}
