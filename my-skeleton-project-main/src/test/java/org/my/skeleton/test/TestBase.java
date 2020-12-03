package org.my.skeleton.test;

import org.my.skeleton.Application;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class,properties = "spring.profiles.active=test")
public class TestBase {

}
