package archetype.test.service.impl;

import archetype.test.service.HelloWorldService;
import org.springframework.stereotype.Service;

/**
 * Simple implementation of the {@link HelloWorldService} interface.
 */
@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String sayHello() {
        return "Hello World";
    }

}
