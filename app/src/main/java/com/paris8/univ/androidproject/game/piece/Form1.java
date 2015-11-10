package com.paris8.univ.androidproject.game.piece;

import android.content.res.AssetManager;

import com.paris8.univ.androidproject.engine.camera.PerspCamera;
import com.paris8.univ.androidproject.game.Cube;

/**
 * Created by Mzartek on 09/11/15.
 * C'est une barre |
 */
public class Form1 extends Form
{


    public Form1(AssetManager assetManager,
                 float r, float g, float b,
                 float x, float y, float z, float xwin, float ywin, float zwin,
                 float rotation, float rotationWin)
    {
        super(r, g, b, x, y, z, xwin, ywin, zwin, rotation, rotationWin);

        cubes = new Cube[]
                {
                        new Cube(assetManager, r, g, b),
                        new Cube(assetManager, r, g, b),
                        new Cube(assetManager, r, g, b),
                        new Cube(assetManager, r, g, b),
                };
    }

    @Override
    public void display(PerspCamera camera)
    {
        super.display(camera);

        cubes[0].getModel().displayOffSet(camera, 0, 0, 0);
        cubes[1].getModel().displayOffSet(camera, 0, 0, 2);
        cubes[2].getModel().displayOffSet(camera, 0, 0, 4);
        cubes[3].getModel().displayOffSet(camera, 0, 0, 6);
    }
}
