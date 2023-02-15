class School {

    private val studentGradeMap = mutableMapOf<Int, List<String>>()

    fun add(student: String, grade: Int) {
        studentGradeMap[grade] = (grade(grade) + student).sorted()
    }

    fun grade(grade: Int): List<String> {
        return studentGradeMap.getOrDefault(grade, listOf())
    }

    fun roster(): List<String> {
        return studentGradeMap.toSortedMap().flatMap { it.value }
    }
}
