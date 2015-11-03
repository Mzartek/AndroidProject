package com.paris8.univ.androidproject.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.util.Log;

import com.paris8.univ.androidproject.engine.camera.PerspCamera;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by mzartek on 22/09/15.
 */
public class EngineView extends GLSurfaceView
{
    final static private String TAG = "EngineView";

    public EngineView(Context context, AssetManager assetManager)
    {
        super(context);
        setEGLConfigChooser(8, 8, 8, 0, 24, 8);
        setEGLContextClientVersion(2);
        setRenderer(new Renderer(assetManager));
    }

    private class Renderer implements GLSurfaceView.Renderer
    {
        private static final String TAG = "Renderer";

        private AssetManager assetManager;

        private int mWidth = 0;
        private int mHeight = 0;

        private float tmp = 0.0f;

        private PerspCamera camera;

        private ShaderProgram skyboxProgram;

        private SkyBox skyBox;

        public Renderer(AssetManager assetManager)
        {
            this.assetManager = assetManager;
        }

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config)
        {
            GraphicsRenderer.printGLinfo();

            camera = new PerspCamera();
            camera.setCameraPosition(0, 0, 0);

            try
            {
                skyboxProgram = new ShaderProgram(this.assetManager,
                        "Shaders/SkyBox/skybox_vs.glsl",
                        "Shaders/SkyBox/skybox_fs.glsl");
            }
            catch (Exception ex)
            {
                Log.e(TAG, ex.toString());
            }

            skyBox = new SkyBox(skyboxProgram);
            skyBox.load(this.assetManager,
                    "Textures/BlueSky/bluesky_right.jpg", "Textures/BlueSky/bluesky_left.jpg",
                    "Textures/BlueSky/bluesky_top.jpg", "Textures/BlueSky/bluesky_top.jpg",
                    "Textures/BlueSky/bluesky_front.jpg", "Textures/BlueSky/bluesky_back.jpg");
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height)
        {
            mWidth = width;
            mHeight = height;
            GraphicsRenderer.setSize(mWidth, mHeight);

            camera.setPerspective(90, width, height, 0.1f, 100.0f);
        }

        @Override
        public void onDrawFrame(GL10 gl)
        {
            GraphicsRenderer.clear();

            camera.setAngle((float)Math.toRadians(tmp += 0.1), 0);
            camera.updateData();

            skyBox.display(camera);
        }
    }
}
