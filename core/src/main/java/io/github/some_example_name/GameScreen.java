package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import io.github.some_example_name.helpers.Constants;
import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
    private final OrthographicCamera _camera;
    private final SpriteBatch _batch;
    private final World world;
    private final Box2DDebugRenderer debugRenderer;

    public GameScreen(OrthographicCamera camera) {
        this._camera = camera;
        this._batch = new SpriteBatch();
        this.world = new World(new Vector2(0, 0), false);
        this.debugRenderer = new Box2DDebugRenderer();
    }

    private void update() {
        this.world.step(1/60f, 6, 2);
        cameraUpdate();
        this._batch.setProjectionMatrix(this._camera.combined);
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    private void cameraUpdate(){
        _camera.position.set(new Vector3(0, 0, 0));
        _camera.update();
    }

    @Override
    public void render(float delta){
        this.update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        _batch.begin();



        _batch.end();
        debugRenderer.render(world, _camera.combined.scl(Constants.PPM));
        // _camera.update();
        // _batch.setProjectionMatrix(_camera.combined);

        // world.step(1/60f, 6, 2);
        // debugRenderer.render(world, _camera.combined);
        
    }
}