package interest

// InterestRate returns the interest rate for the provided balance.
func InterestRate(balance float64) float32 {
	// panic("Please implement the InterestRate function")
	if balance < 0 {
		return 3.213 // negative balance
	} else if balance < 1000 {
		return 0.5 // balance between 0 and 999.99
	} else if balance < 5000 {
		return 1.621 // balance between 1000 and 4999.99
	} else {
		return 2.475 // balance of 5000 or more
	}
}

// Interest calculates the interest for the provided balance.
func Interest(balance float64) float64 {
	// panic("Please implement the Interest function")
	return balance * float64(InterestRate(balance)/100)
}

// AnnualBalanceUpdate calculates the annual balance update, taking into account the interest rate.
func AnnualBalanceUpdate(balance float64) float64 {
	// panic("Please implement the AnnualBalanceUpdate function")
	return balance + Interest(balance)
}

// YearsBeforeDesiredBalance calculates the minimum number of years required to reach the desired balance.
func YearsBeforeDesiredBalance(balance, targetBalance float64) int {
	// panic("Please implement the YearsBeforeDesiredBalance function")
	years := 0
	for balance < targetBalance {
		balance = AnnualBalanceUpdate(balance)
		years++
	}
	return years
}
