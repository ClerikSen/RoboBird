/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.risenphoenix.robobird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.risenphoenix.gameworld.GameRenderer;
import com.risenphoenix.gameworld.GameWorld;
import com.risenphoenix.zbhelpers.InputHandler;

/**
 *
 * @author pkc11430
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    
    private float runTime = 0;
    
    public GameScreen(){
        
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight/(screenWidth/gameWidth);
        
        int midPointY = (int) (gameHeight/2);
        
        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world,(int)gameHeight,midPointY);
        
        Gdx.input.setInputProcessor(new InputHandler(world));
    }
    
    

    @Override
    public void render(float delta) {
        runTime+=delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int i, int i1) {
        Gdx.app.log("GameScreen", "resizing");
    }
    
    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }
    
    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void dispose() {
        
    }
    
}
