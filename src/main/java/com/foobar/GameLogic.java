package com.foobar;

public class GameLogic implements Runnable {
    GameState currentState;
    VillagerShootingGame currentGame;
    EntityTypePicker targetGen;
    int gameTime;

    GameLogic(VillagerShootingGame game, GameState state) {
        currentState = state;
        currentGame = game;
        targetGen = new EntityTypePicker();
        gameTime = 0;
    }

    @Override
    public void run() {
        if(currentState == GameState.IN_LOBBY) {
            if(currentGame.activePlayers.size() == 1) {
                currentGame.activePlayers.get(0).teleport(currentGame.world.getSpawnLocation());
                gameTime = 5;
                currentState = GameState.STARTING;
            }
        }
        else if (currentState == GameState.STARTING) {
            gameTime--;
            if(gameTime == 0) {
                gameTime = 60;
                currentState = GameState.IN_GAME;
            }
        }
        else if (currentState == GameState.IN_GAME) {
            gameTime--;
            if(gameTime == 0) {
                gameTime = 10;
                currentState = GameState.POST_GAME;
            }
        }
        else if (currentState == GameState.POST_GAME) {
            gameTime--;
            if(gameTime == 0)
                currentState = GameState.RESETTING;
        }
        else if (currentState == GameState.RESETTING) {

        }
    }
}
