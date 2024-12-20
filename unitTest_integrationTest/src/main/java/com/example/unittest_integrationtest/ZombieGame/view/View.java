package com.example.unittest_integrationtest.ZombieGame.view;

import com.example.unittest_integrationtest.ZombieGame.entity.User;
import com.example.unittest_integrationtest.ZombieGame.entity.Zombie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
    private final InputValidator inputValidator;

    public View() {
        this.inputValidator = new InputValidator();
    }

    public String generateUserName() {
        try {
            System.out.println("유저의 이름을 입력하세요.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String userName = br.readLine();
            inputValidator.validateEmpty(userName);

            return userName;
        } catch (IOException e) {
            System.out.println("유저의 이름을 다시 입력하세요.");
            return generateUserName();
        }
    }

    public int chooseBattleRound() {
        try {
            System.out.println("배틀할 횟수를 입력하세요.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String battleRound = br.readLine();
            inputValidator.validateEmpty(battleRound);
            inputValidator.validateNumber(battleRound);
            return Integer.parseInt(battleRound);
        } catch (IOException e) {
            System.out.println("배틀할 횟수를 다시 입력해주세요");
            return chooseBattleRound();
        } catch (NumberFormatException e) {
            System.out.println("배틀할 횟수는 숫자로 입력하세요.");
            return chooseBattleRound();
        }
    }

    public void displayWinResult(boolean isWinner, User updatedUser) {
        System.out.println("남은 생명력 : "+ updatedUser.getHp());
        if (isWinner) {
            System.out.println(updatedUser.getUserName() + "가 좀비세상에서 살아남았습니다.");
            return;
        }
        System.out.println(updatedUser.getUserName() + "가 좀비세상에서 싸우다 사망하였습니다.");

    }

    public void displayBattleResult(User user, Zombie zombie, boolean winResult) {
        System.out.printf("%s의 공격력(%d) vs 좀비의 공격력(%d)", user.getUserName(), user.getAttackPower(),
                zombie.getAttackPower());
        if (winResult) {
            System.out.println(" = "+ user.getUserName() + "승리");
            return;
        }
        System.out.println(" = "+ user.getUserName() + "패배");
    }
}
