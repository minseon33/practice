package com.example.unittest_integrationtest.ZombieGame.view;
import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    @DisplayName("battleRound가 숫자가 아니면 에러를 발생한다.")
    void validateNumber(){
        String battleRound = "nana";
        InputValidator inputValidator = new InputValidator();

        Assertions.assertThatThrownBy(() ->
                inputValidator.validateNumber(battleRound)).isInstanceOf(NumberFormatException.class);
    }
}