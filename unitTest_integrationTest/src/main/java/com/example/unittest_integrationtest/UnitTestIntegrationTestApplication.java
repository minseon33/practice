package com.example.unittest_integrationtest;

import com.example.unittest_integrationtest.ZombieGame.game.ZombieGame;
import com.example.unittest_integrationtest.ZombieGame.view.View;

public class UnitTestIntegrationTestApplication {

    public static void main(String[] args) {
        ZombieGame zombieGame = new ZombieGame(new View());
        zombieGame.gameStart();
    }

}
