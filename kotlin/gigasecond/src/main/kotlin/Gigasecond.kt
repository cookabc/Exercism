import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(localDateTime: LocalDateTime) {

    constructor(localDate: LocalDate) : this(localDate.atStartOfDay())

    val date: LocalDateTime = localDateTime.plusSeconds(1000000000)
}
