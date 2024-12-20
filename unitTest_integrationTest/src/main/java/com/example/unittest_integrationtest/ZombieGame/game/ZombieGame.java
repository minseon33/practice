package com.example.unittest_integrationtest.ZombieGame.game;

import com.example.unittest_integrationtest.ZombieGame.entity.User;
import com.example.unittest_integrationtest.ZombieGame.entity.Zombie;
import com.example.unittest_integrationtest.ZombieGame.view.View;
import java.util.Random;

public class ZombieGame {
    private final View view;

    public ZombieGame(View view) {
        this.view = view;
    }

    public void gameStart(){
        //유저생성
        User user = User.initUser(view.generateUserName(), generateRandomNumber());
        //싸움
        User updatedUser = battleStart(user);
        //승리자 출력
        view.displayWinResult(isWinner(updatedUser),updatedUser);
    }

    public int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(10);
    }

    private User battleStart(User user){
        int battleRound = view.chooseBattleRound();
        for (int i = 0; i < battleRound; i++) {
            if(!user.isAlive()){
               break;
            }
            boolean battleResult = battleWhitZombie(user);
            user = user.applyFightResult(battleResult);
        }
        return user;
    }

    private boolean battleWhitZombie(User user){
        Zombie zombie = Zombie.createZombie(generateRandomNumber());
        if(user.getAttackPower()>=zombie.getAttackPower()){
            view.displayBattleResult(user,zombie,true);
            return true;
        }
        view.displayBattleResult(user,zombie,false);
        return false;
    }

    private boolean isWinner(User updatedUser) {
        if (updatedUser.isAlive()) {
            return true;
        }
        return false;
    }

}
