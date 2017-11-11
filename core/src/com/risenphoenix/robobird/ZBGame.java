/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.risenphoenix.robobird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.risenphoenix.zbhelpers.AssetLoader;

/**
 *
 * @author pkc11430
 */
public class ZBGame extends Game {

    @Override
    public void create() {
        Gdx.app.log("ZBGame", "created");
        AssetLoader.load();
        setScreen(new GameScreen());
    }
    
    @Override
    public void dispose(){
        super.dispose();
        AssetLoader.dispose();
    }
    
}
