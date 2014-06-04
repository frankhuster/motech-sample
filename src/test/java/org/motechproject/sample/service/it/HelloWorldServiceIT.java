package org.motechproject.sample.service.it;

import org.motechproject.sample.service.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.motechproject.testing.osgi.BasePaxIT;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Verify that HelloWorldService present, functional.
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class HelloWorldServiceIT extends BasePaxIT {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private HelloWorldService helloService;

    @Test
    public void testHelloWorldServicePresent() throws Exception {
        logger.info("testHelloWorldServicePresent");
        assertNotNull(helloService);
        assertNotNull(helloService.sayHello());
    }

    @Test
    public void testHelloWorldServiceFunctional() throws Exception {
        logger.info("testHelloWorldServiceFunctional");
        assertEquals("Hello World", helloService.sayHello());
    }
}
