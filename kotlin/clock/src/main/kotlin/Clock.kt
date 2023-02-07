class Clock(private var hour: Int, private var minute: Int) {

    companion object Time {
        const val MINUTES_IN_HOUR = 60
        const val HOURS_IN_DAY = 24
    }

    override fun toString(): String {
        while (minute >= MINUTES_IN_HOUR) {
            minute -= MINUTES_IN_HOUR
            hour++
        }
        while (minute < 0) {
            minute += MINUTES_IN_HOUR
            hour--
        }
        while (hour >= HOURS_IN_DAY) {
            hour -= HOURS_IN_DAY
        }
        while (hour < 0) {
            hour += HOURS_IN_DAY
        }
        return "%02d:%02d".format(hour, minute)
    }

    override fun equals(other: Any?): Boolean {
        return other is Clock && (this.toString() == other.toString())
    }

    fun subtract(minutes: Int) {
        this.minute -= minutes
    }

    fun add(minutes: Int) {
        this.minute += minutes
    }

    override fun hashCode(): Int {
        var result = hour
        result = 31 * result + minute
        return result
    }

}
