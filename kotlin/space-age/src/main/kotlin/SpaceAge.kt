import kotlin.math.roundToInt

class SpaceAge(private val seconds: Int) {

    private val earthYearSeconds = 60 * 60 * 24 * 365.25

    fun onEarth(): Double = (seconds.toDouble() / earthYearSeconds * 100.0).roundToInt() / 100.0
    fun onMercury(): Double = (seconds.toDouble() / (earthYearSeconds * 0.2408467) * 100.0).roundToInt() / 100.0
    fun onVenus(): Double = (seconds.toDouble() / (earthYearSeconds * 0.61519726) * 100.0).roundToInt() / 100.0
    fun onMars(): Double = (seconds.toDouble() / (earthYearSeconds * 1.8808158) * 100.0).roundToInt() / 100.0
    fun onJupiter(): Double = (seconds.toDouble() / (earthYearSeconds * 11.862615) * 100.0).roundToInt() / 100.0
    fun onSaturn(): Double = (seconds.toDouble() / (earthYearSeconds * 29.447498) * 100.0).roundToInt() / 100.0
    fun onUranus(): Double = (seconds.toDouble() / (earthYearSeconds * 84.016846) * 100.0).roundToInt() / 100.0
    fun onNeptune(): Double = (seconds.toDouble() / (earthYearSeconds * 164.79132) * 100.0).roundToInt() / 100.0
}
