package com.mgtriffid.games.cotta.showcase;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mgtriffid.games.cotta.client.DrawableState;
import com.mgtriffid.games.cotta.client.UpdateResult;
import com.mgtriffid.games.cotta.core.entities.Component;
import com.mgtriffid.games.cotta.core.entities.Entity;
import com.mgtriffid.games.cotta.gdx.CottaGdxAdapter;
import com.mgtriffid.games.cotta.core.CottaGame;
import com.mgtriffid.games.cotta.showcase.components.PositionComponent;
import kotlin.reflect.KClass;

import java.util.List;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private Texture character;
    private CottaGdxAdapter gdxAdapter;

    private final List<KClass<Component<?>>> drawableComponents = DrawableComponentsKt.getDrawableComponentClasses();

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        character = new Texture("square.png");
        CottaGame game = new ShowcaseGame();
        gdxAdapter = new CottaGdxAdapter(game, new ShowcaseCottaClientGdxInput());
        gdxAdapter.initialize();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        UpdateResult result = gdxAdapter.invoke();
        if (result instanceof UpdateResult.Running) {
            draw((UpdateResult.Running) result);
        } else {
            batch.begin();
            batch.draw(image, 140, 210);
            batch.end();
        }
    }

    private void draw(UpdateResult.Running result) {
        DrawableState state = gdxAdapter.getDrawableState(result.getAlphas(), drawableComponents);
        batch.begin();
        if (state instanceof DrawableState.Ready) {
            for (Entity entity : ((DrawableState.Ready) state).getEntities()) {
                PositionComponent positionComponent = entity.getComponent(DrawableComponentsKt.getPosition());
                batch.draw(character, positionComponent.getX(), positionComponent.getY());
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        character.dispose();
    }
}
