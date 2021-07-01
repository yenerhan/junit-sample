package com.yener.testproject.basic;

import com.yener.testproject.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class TimeOutTest {

    @Test
    @DisplayName("Zaman aşımı testi")
    void timeOutException(){
        User user=new User();
        assertTimeout(Duration.ofMillis(10),()->{
            //Nothing will be done and this code run under the 10ms
        });

        assertTimeout(Duration.ofMillis(200),() -> {
            user.userTimeOutMethod();
        });

        //200 milisaniyelik zaman geçtiyse bunu beklemeden exception throw et diyebiliriz
        assertTimeoutPreemptively(Duration.ofMillis(6),() -> user.userTimeOutMethod());
    }
}
