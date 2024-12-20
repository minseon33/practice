package com.example.unittest_integrationtest.ZombieGame.entity;

public class User {


    private final String userName;
    private int attackPower;
    private int hp;
    private boolean isAlive;
    private int level;

    private User(String userName,int attackPower) {
        this.userName = userName;
        this.attackPower = attackPower;
        this.hp = 100;
        this.isAlive = true;
        this.level = 0;
    }

    public static User initUser(String userName, int attackPower){
        return new User(userName, attackPower);
    }

    public User applyFightResult(boolean fightResult){
        if (!fightResult){
            applyZombieDamage();
        }
        return verifyAlive();
    }

    private void applyZombieDamage(){
        if(hp>0){
            hp -= 10;
        }

    }

    private User verifyAlive(){
        if(hp <= 0){
            isAlive = false;
        }
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getLevel() {
        return level;
    }
}
