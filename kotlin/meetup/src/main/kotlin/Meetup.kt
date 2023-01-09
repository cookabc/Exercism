import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(private val month: Int, private val year: Int) {

    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate {
        val day = (1..LocalDate.of(year, month, 1).lengthOfMonth())
            .filter { LocalDate.of(year, month, it).dayOfWeek == dayOfWeek }
            .let { days ->
                when (schedule) {
                    MeetupSchedule.FIRST -> days.first()
                    MeetupSchedule.SECOND -> days[1]
                    MeetupSchedule.THIRD -> days[2]
                    MeetupSchedule.FOURTH -> days[3]
                    MeetupSchedule.LAST -> days.last()
                    MeetupSchedule.TEENTH -> days.first { it in (13..19) }
                }
            }
        return LocalDate.of(year, month, day)
    }
}
