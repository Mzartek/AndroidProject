package com.paris8.univ.androidproject.game.piece;

import android.content.res.AssetManager;

import com.paris8.univ.androidproject.engine.camera.PerspCamera;
import com.paris8.univ.androidproject.game.Cube;

/**
 * Created by jpagny on 10/11/15.
 * C'est la cicatrice d'harry potter
 */
public class Form3 extends Form
{
    public Form3(AssetManager assetManager,
                 float r, float g, float b,
                 float x, float z, float xwin, float zwin,
                 float rotation, float rotationWin)
    {
        super(r, g, b, x, z, xwin, zwin, rotation, rotationWin);

        cubes = new Cube[]
                {
                        new Cube(assetManager),
                        new Cube(assetManager),
                        new Cube(assetManager),
                        new Cube(assetManager),
                        new Cube(assetManager),
                };
    }

    @Override
    public void display(PerspCamera camera)
    {
        super.displayShadow(camera);

        cubes[0].getModel().displayOffSet(camera, 0, 0, 0);
        cubes[1].getModel().displayOffSet(camera, 0, 0, 2);
        cubes[2].getModel().displayOffSet(camera, 2, 0, 2);
        cubes[3].getModel().displayOffSet(camera, 2, 0, 4);
        cubes[4].getModel().displayOffSet(camera, 2, 0, 6);

        super.displayFloor(camera);

        cubes[0].getModel().displayOffSet(camera, 0, 0, 0);
        cubes[1].getModel().displayOffSet(camera, 0, 0, 2);
        cubes[2].getModel().displayOffSet(camera, 2, 0, 2);
        cubes[3].getModel().displayOffSet(camera, 2, 0, 4);
        cubes[4].getModel().displayOffSet(camera, 2, 0, 6);

        super.displayCube(camera);

        cubes[0].getModel().displayOffSet(camera, 0, 0, 0);
        cubes[1].getModel().displayOffSet(camera, 0, 0, 2);
        cubes[2].getModel().displayOffSet(camera, 2, 0, 2);
        cubes[3].getModel().displayOffSet(camera, 2, 0, 4);
        cubes[4].getModel().displayOffSet(camera, 2, 0, 6);
    }
}