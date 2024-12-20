package com.example.unittest_integrationtest.ZombieGame.game;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.unittest_integrationtest.ZombieGame.view.View;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ZombieGameTest {
    @Mock
    private static View view;
    private static ByteArrayOutputStream outputMessage;
    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @DisplayName("10미만의 랜덤한 값이 만들어진다.")
    @RepeatedTest(5)
    void generateRandomNumber() {
        boolean result = false;
        ZombieGame zombieGame = new ZombieGame(new View());
        int randomNumber = zombieGame.generateRandomNumber();
        if(randomNumber<10){
            result = true;
        }
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("유저와 좀비가 배틀한다.")
    @Test
    void battleStart() throws IOException {
    //given

        //mock 연습
        ZombieGame zombieGame = new ZombieGame(view);
        BufferedReader mockBufferReader = mock(BufferedReader.class);
        when(mockBufferReader.readLine()).thenReturn("katty", "5");
    //when
        zombieGame.gameStart();
    //then

    }

    @Test
    void gameStart() {
    }
}