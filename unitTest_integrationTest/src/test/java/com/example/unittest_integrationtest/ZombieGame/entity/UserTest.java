package com.example.unittest_integrationtest.ZombieGame.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    @DisplayName("유저를 초기화했을때 이름이 바르게 초기화된다.")
    void initUserName() {
        User user = User.initUser("katty", 5);
        Assertions.assertThat(user.getUserName()).isEqualTo("katty");
    }

    @Test
    @DisplayName("유저를 초기화했을때 attackPower 가 설정한 값으로 초기화된다.")
    void initUserAttackPower() {
        User user = User.initUser("katty", 5);
        Assertions.assertThat(user.getAttackPower()).isEqualTo(5);
    }

    @Test
    @DisplayName("유저를 초기화했을때 초기 체력은 100이다.")
    void initUserHp() {
        User user = User.initUser("katty", 5);
        Assertions.assertThat(user.getHp()).isEqualTo(100);
    }

    @Test
    @DisplayName("유저를 초기화했을때 초기 레벨은 0이다.")
    void initUserLevel() {
        User user = User.initUser("katty", 5);
        Assertions.assertThat(user.getLevel()).isEqualTo(0);
    }

    @Test
    @DisplayName("좀비와 싸워서 지면 hp가 10씩 깎인다.")
    void applyZombieDamage() {
        User user = User.initUser("katty", 5);
        while (user.getHp()>0){
            user.applyFightResult(false);
        }
        Assertions.assertThat(user.getHp()).isEqualTo(0);
    }

    @Test
    @DisplayName("좀비와 싸워서 hp가 0씩 alive 상태값이 false 로 변경된다.")
    void applyFightResult() {
        User user = User.initUser("katty", 5);
        for (int i = 0; i < 100; i++) {
            user = user.applyFightResult(false);
        }
        Assertions.assertThat(user.isAlive()).isEqualTo(false);
    }

}