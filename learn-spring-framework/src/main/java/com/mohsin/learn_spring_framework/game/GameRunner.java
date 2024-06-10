package com.mohsin.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Tells Spring to create instance of this class
@Component
public class GameRunner {
    GameConsole game;

    // This is loosely coupled through the interface.
    // If it would directly reference the class, it would be tightly coupled.
    public GameRunner(@Qualifier("MarioGameQualifier") GameConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game.toString());
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
