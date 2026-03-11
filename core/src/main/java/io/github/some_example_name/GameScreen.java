package io.github.some_example_name;

public class GameScreen extends ScreenAdapter {
    private OrthographicCamera _camera;
    private SpriteBatch _batch;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    
    public GameScreen(OrthographicCamera camera) {
        this._camera = camera;
        this._batch = new SpriteBatch();
        this.world = new World(new Vector2(0,0), false);
        this.debugRenderer = new Box2DDebugRenderer();
    }

    private void update(){
        this.world.step(1/60f, 6, 2);
        cameraUpdate();
        this._batch.setProjectionMatrix(this._camera.combined);
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            Gdx.app.exit();
        }
    }

    private void cameraUpdate(){
        _camera.position.set(Vector3(0,0,0));
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