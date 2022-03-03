package com.shammer.coaching.conway;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void app_requires_three_arguments() {
        String[] args = new String[]{};

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    App.main(args);
                });
    }

    @Test
    public void app_requires_three_numeric_arguments() {
        String[] args = new String[]{"incorrect", "-1", "20"};

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    App.main(args);
                });
    }

    @Test
    public void app_requires_two_positive_integer_arguments() {
        String[] args = new String[]{"4", "-1", "20"};

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    App.main(args);
                });
    }

}