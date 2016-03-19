/*
 * ©2015 Joel Brisbin. All Rights Reserved.
 */

package com.example.user.joelscrappycrapsapp;

/**
 * Created by User on 9/14/2015.
 */
import java.util.Random;
public class Die
{
    private int face;

    private Random r;

    public Die() {
        this.face = 1;
        r = new Random();
    }
    public int roll()
    {
        this.face = r.nextInt(6) + 1;
        return this.face;
    }

    public int getFace() {

        return this.face;
    }
    public void setFace(int face) {
        if(face<1)
        {
            this.face = 1;
        }
        else if(face>6)
        {
            this.face = 6;
        }
        else
        {
            this.face = face;
        }
    }
}
