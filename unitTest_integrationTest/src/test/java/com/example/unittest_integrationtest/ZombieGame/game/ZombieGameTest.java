package com.example.unittest_integrationtest.ZombieGame.game;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.example.unittest_integrationtest.ZombieGame.entity.User;
import com.example.unittest_integrationtest.ZombieGame.entity.Zombie;
import com.example.unittest_integrationtest.ZombieGame.view.View;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ZombieGameTest {
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
    void gameStart() {
    //given
        User user = User.initUser("toto", 5);
        Zombie zombie = Zombie.createZombie(3);

        //mock 연습
        View mockView = mock(View.class);
        ZombieGame zombieGame = new ZombieGame(mockView);

        when(mockView.generateUserName()).thenReturn("toto");
        when(mockView.chooseBattleRound()).thenReturn(5);

        //when
        zombieGame.gameStart();
        Mockito.verify(mockView, times(1)).displayWinResult(any(Boolean.class),any(User.class));
        Mockito.verify(mockView, times(1)).chooseBattleRound();

        //then
    }


}