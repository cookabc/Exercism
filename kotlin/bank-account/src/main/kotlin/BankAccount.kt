class BankAccount {

    private var accountOpen: Boolean = true

    var balance: Long = 0
        get() {
            check(accountOpen)
            return field
        }

    @Synchronized
    fun adjustBalance(amount: Long) {
        check(accountOpen)
        balance += amount
    }

    fun close() {
        accountOpen = false
    }
}
