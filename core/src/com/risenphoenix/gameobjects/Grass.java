/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.risenphoenix.gameobjects;

/**
 *
 * @author pkc11430
 */
public class Grass extends Scrollable {
    
    public Grass(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
    }
    
    public void onRestart(float x,float scrollSpeed){
        position.x = x;
        velocity.x = scrollSpeed;
    }
    
}
