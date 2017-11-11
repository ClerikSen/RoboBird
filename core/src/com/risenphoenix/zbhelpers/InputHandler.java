/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.risenphoenix.zbhelpers;

import com.badlogic.gdx.InputProcessor;
import com.risenphoenix.gameobjects.Bird;
import com.risenphoenix.gameworld.GameWorld;

/**
 *
 * @author pkc11430
 */
public class InputHandler implements InputProcessor {

    private Bird myBird;
    private GameWorld myWorld;
    
    public InputHandler(GameWorld myWorld){
        this.myWorld = myWorld;
        myBird = myWorld.getBird();
    }

    
    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        
        if(myWorld.isReady()){
            myWorld.start();
        }
        
        myBird.onClick();
        
        if(myWorld.isGameOver()||myWorld.isHighScore()){
            myWorld.restart();
        }
        
        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
    
}
