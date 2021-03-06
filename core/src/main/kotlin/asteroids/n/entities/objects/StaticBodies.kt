package asteroids.n.entities.objects

import asteroids.n.Constants
import asteroids.n.MainClass
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.Vector2

class Earth(resname: String = "assets/earth", filenum: Int = 360, msFrameDelay: Long = 1000, mass: Float = 1000f) : SpaceStaticAnimatedObject(resname, filenum, msFrameDelay, mass) {
    var health = Constants.EARTH_HEALTH_MAX
    init {
        position = Vector2(Gdx.graphics.width.toFloat()/2, Gdx.graphics.height.toFloat()/2)
    }
}

class Moon(img: Texture = Texture(Gdx.files.classpath("assets/moon.png")), mass: Float = 250f, val radius: Float = 270f) : SpaceStaticImageObject(img, mass) {
    val rechargingZone = Texture(Gdx.files.classpath("assets/moon_base.png"))

    init {
        position = Vector2(360- radius, Gdx.graphics.width.toFloat()/2)
    }
    val step = 1f
    var totalSteps = 0f
    var angle = 270.0 // because of initial position
    override fun draw(batch: Batch) {
        totalSteps += Gdx.graphics.deltaTime
        if (totalSteps >= step) {
            totalSteps = 0f

            angle += 0.1f
            position = Vector2((Gdx.graphics.width/2f + Math.sin(angle*Math.PI/180)* radius).toFloat(),
                               (Gdx.graphics.height/2f + Math.cos(angle*Math.PI/180)* radius).toFloat())

        }
        super.draw(batch)
        batch.draw(rechargingZone, sprite.x - sprite.width, sprite.y- sprite.height)
    }
}

