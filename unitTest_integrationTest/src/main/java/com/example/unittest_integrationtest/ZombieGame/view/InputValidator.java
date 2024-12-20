package com.example.unittest_integrationtest.ZombieGame.view;

import java.io.IOException;

public class InputValidator {
    public void validateNumber(String battleRound) throws NumberFormatException {
        int i = Integer.parseInt(battleRound);
    }

    public void validateEmpty(String input) throws IOException {
        if (input.isBlank() || input.isEmpty()) {
            throw new IOException();
        }
    }
}
