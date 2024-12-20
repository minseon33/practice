package com.example.unittest_integrationtest.ZombieGame.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ZombieTest {
    @Test
    @DisplayName("좀비를 생성한다.")
    void createZombie() {
        Zombie zombie = Zombie.createZombie(8);
        Assertions.assertThat(zombie.getAttackPower()).isEqualTo(8);
    }
}