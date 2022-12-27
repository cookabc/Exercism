class PhoneNumber(s: String) {

    val number: String = s.replace("\\D".toRegex(), "").removePrefix("1")

    init {
        require(number.matches("[2-9]\\d{2}[2-9]\\d{2}\\d{4}".toRegex()))
    }

}
