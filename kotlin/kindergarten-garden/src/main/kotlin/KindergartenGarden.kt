class KindergartenGarden(private val diagram: String) {

    fun getPlantsOfStudent(student: String): List<String> {
        val studentIndex = (student.first().code - 'A'.code) * 2
        return diagram.split("\n")
            .flatMap {
                it.substring(studentIndex, studentIndex + 2).toList()
            }.mapNotNull {
                when (it) {
                    'C' -> "clover"
                    'G' -> "grass"
                    'R' -> "radishes"
                    'V' -> "violets"
                    else -> null
                }
            }
    }
}
