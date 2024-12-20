package com.example.unittest_integrationtest.ZombieGame.view;

import com.example.unittest_integrationtest.ZombieGame.entity.User;
import com.example.unittest_integrationtest.ZombieGame.entity.Zombie;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ViewTest {

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

    @Test
    @DisplayName("사용자가 이름을 입력한다.")
    void generateUserName() {
        String input = "katty";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        View view = new View();
        String userName = view.generateUserName();

        Assertions.assertThat(userName).isEqualTo(input);
    }

    @Test
    @DisplayName("사용자가 이름을 입력하지 않았을 시 에러를 반환하고, 다시 입력받는다.")
    void generateUserName2() {
        String input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        View view = new View();

        Assertions.assertThatThrownBy(view::generateUserName).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("사용자가 배틀할 횟수를 입력한다.")
    void chooseBattleRound() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        View view = new View();
        int battleRound = view.chooseBattleRound();

        Assertions.assertThat(battleRound).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("배틀할 횟수가 숫자가 아닐경우 다시 입력받는다.")
    void chooseBattleRound2() {
        String input = "ㅂㅈㄷㅂㅈ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        View view = new View();

        Assertions.assertThatThrownBy(view::chooseBattleRound).isInstanceOf(NullPointerException.class);
    }
    @Test
    @DisplayName("배틀할 횟수가 빈값일 경우 다시 입력받는다.")
    void chooseBattleRound3() {
        String input = " ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        View view = new View();

        Assertions.assertThatThrownBy(view::chooseBattleRound).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("승리의 결과를 표출한다.")
    void displayWinResult() {
        User user = User.initUser("katty", 5);
        View view = new View();

        view.displayWinResult(true, user);
        Assertions.assertThat(outputMessage.toString()).isEqualTo("남은 생명력 : "+ user.getHp()+"\n"
                +user.getUserName() + "가 좀비세상에서 살아남았습니다.\n");
    }

    @Test
    @DisplayName("패배의 결과를 표출한다.")
    void displayWinResult2() {
        User user = User.initUser("katty", 5);
        View view = new View();

        view.displayWinResult(false, user);
        Assertions.assertThat(outputMessage.toString()).isEqualTo("남은 생명력 : "+ user.getHp()+"\n"
                + user.getUserName() + "가 좀비세상에서 싸우다 사망하였습니다.\n");
    }

    @Test
    @DisplayName("배틀의 승리 결과를 표출한다.")
    void displayBattleResult() {
        User user = User.initUser("katty", 5);
        Zombie zombie = Zombie.createZombie(2);
        View view = new View();

        view.displayBattleResult(user,zombie,true);
        Assertions.assertThat(outputMessage.toString())
                .isEqualTo(
                        user.getUserName()+"의 공격력("+user.getAttackPower()+") "
                                + "vs 좀비의 공격력("+zombie.getAttackPower()+") = " + user.getUserName() + "승리\n");
    }
    @Test
    @DisplayName("배틀의 패배 결과를 표출한다.")
    void displayBattleResult2() {
        User user = User.initUser("katty", 5);
        Zombie zombie = Zombie.createZombie(2);
        View view = new View();

        view.displayBattleResult(user,zombie,false);
        Assertions.assertThat(outputMessage.toString())
                .isEqualTo(
                        user.getUserName()+"의 공격력("+user.getAttackPower()+") "
                                + "vs 좀비의 공격력("+zombie.getAttackPower()+") = " + user.getUserName() + "패배\n");
    }
}