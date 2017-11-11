/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.risenphoenix.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.risenphoenix.gameobjects.Bird;
import com.risenphoenix.gameobjects.ScrollHandler;
import com.risenphoenix.zbhelpers.AssetLoader;

/**
 *
 * @author pkc11430
 */
public class GameWorld {
    
    public enum GameState{
        READY,RUNNING,GAMEOVER,HIGHSCORE
    }

    
    public int midPointY;
    
    private GameState currentState;
    
    private Bird bird;
    
    private ScrollHandler scroller;
    
    private boolean isAlive = true;
    
    private Rectangle ground;
    
    private int score = 0;
    
    public GameWorld(int midPointY){
        bird = new Bird(33,midPointY-5,17,12);
        scroller = new ScrollHandler(this,midPointY + 66);
        ground = new Rectangle(0,midPointY+66,136,11);
        currentState = GameState.READY;
        this.midPointY = midPointY;
    }
    
    public void updateRunning(float delta){
        
        if(delta > .15f){
            delta = .15f;
        }
        
        bird.update(delta);
        scroller.update(delta);
        
        if(scroller.collides(bird)&&bird.isAlive()){
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }
        
        if(Intersector.overlaps(bird.getBoundingCircle(),ground)){
            scroller.stop();
            bird.die();
            bird.decelerate();
            currentState = GameState.GAMEOVER;
            
            if(score > AssetLoader.getHighScore()){
                AssetLoader.setHighScore(score);
                currentState = GameState.HIGHSCORE;
            }
        }
    }
    
    
    
    public void update(float delta){
        
        switch(currentState){
            case READY:
                updateReady(delta);
                break;
            case RUNNING:
                updateRunning(delta);
                break;
            default:
                break;
        }
    }
    
    public void updateReady(float delta){
        
    }
    
    public Bird getBird(){
        return bird;
    }
    
    public ScrollHandler getScroller(){
        return scroller;
    }
    
    public int getScore(){
        return score;
    }
    
    public void addScore(int increment){
        score+=increment;
    }
    
    public boolean isReady(){
        return currentState == GameState.READY;
    }
    
    public boolean isHighScore(){
        return currentState == GameState.HIGHSCORE;
    }
    
    public void start(){
        currentState = GameState.RUNNING;
    }
        
    public void restart(){
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY-5);
        scroller.onRestart();
        currentState = GameState.READY;
    }
    
    public boolean isGameOver(){
        return currentState == GameState.GAMEOVER;
    }
    
    
    
    
    
}
