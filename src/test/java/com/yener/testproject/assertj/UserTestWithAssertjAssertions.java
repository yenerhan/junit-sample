package com.yener.testproject.assertj;

import com.yener.testproject.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class UserTestWithAssertjAssertions {

    @Test
    void createUser() {
        User user = new User("erhan", "yener", null);
        assertThat(user.getFirstName()).as("User's name %s",user.getFirstName())
                .doesNotContainOnlyWhitespaces()
                .isNotEmpty()
                .isNotBlank()
                .isEqualTo("erhan")
                .endsWith("n")
                .contains("rha");

    }
}
