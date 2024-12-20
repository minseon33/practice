package com.example.unittest_integrationtest.ZombieGame.entity;

public class Zombie {
    private final int attackPower;

    private Zombie(int attackPower) {
        this.attackPower = attackPower;
    }

    public static Zombie createZombie(int attackPower){
        return new Zombie(attackPower);
    }

    public int getAttackPower() {
        return attackPower;
    }

}
