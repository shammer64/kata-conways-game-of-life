package com.shammer.coaching.conway;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class AppTest {

    @ParameterizedTest
    @CsvSource({"incorrect,20,200", "20,incorrect,200", "20,200,incorrect"})
    public void app_throws_exception_for_non_numeric_arguments(String rows, String cols, String gens) {
        String[] args = new String[]{rows, cols, gens};

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    App.main(args);
                });
    }
    @ParameterizedTest
    @CsvSource({"0,20,200", "20,-1,200", "20,20,-10"})
    public void app_throws_exception_for_non_positive_integer_arguments(String rows, String cols, String gens) {
        String[] args = new String[]{rows, cols, gens};

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    App.main(args);
                });
    }

}