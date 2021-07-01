package com.yener.testproject.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class ConditionalTest {

    @EnabledOnOs({OS.WINDOWS})
    @Test
    void shouldCreateUserOnlyWindows(){

    }

    @EnabledOnJre({JRE.JAVA_8})
    @Test
    void shouldCreateUserOnlyJRE8(){

    }

    @EnabledIfEnvironmentVariable(named = "ENV" ,matches = "staging-server")
    @Test
    void shouldCreateUserOnlyStagingEnv(){

    }

    @EnabledIf("2*3=6")
    @Test
    void shouldCreateUserIfStaticExpression(){

    }

    @Test
    @EnabledOnOs(OS.MAC)
    @EnabledOnJre(JRE.JAVA_10)
    void testOnMacWithJRE10(){

    }
}
