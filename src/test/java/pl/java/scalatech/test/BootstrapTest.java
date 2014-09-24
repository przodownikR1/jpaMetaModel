package pl.java.scalatech.test;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.config.DsConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DsConfig.class})
@ActiveProfiles(profiles="dev,cache")
@Slf4j

public class BootstrapTest {

    
    @Test
    public void shouldWork(){
        log.info("ok");
    }
}

