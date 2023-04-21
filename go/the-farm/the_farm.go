package thefarm

import "fmt"

// See types.go for the types defined for this exercise.

// TODO: Define the SillyNephewError type here.
type SillyNephewError struct {
	message string
}

func (e *SillyNephewError) Error() string {
	return e.message
}

// DivideFood computes the fodder amount per cow for the given cows.
func DivideFood(weightFodder WeightFodder, cows int) (float64, error) {
	// panic("Please implement DivideFood")
	amount, err := weightFodder.FodderAmount()
	if err != nil {
		if err == ErrScaleMalfunction {
			if amount < 0 {
				return 0, &SillyNephewError{"negative fodder"}
			}
			if amount >= 0 {
				return amountPerCow(amount*2, cows), nil
			}
		}
		return 0, &SillyNephewError{"non-scale error"}
	}
	if amount < 0 {
		return 0, &SillyNephewError{"negative fodder"}
	}
	if cows <= 0 {
		if cows == 0 {
			return 0, &SillyNephewError{"division by zero"}
		}
		return 0, &SillyNephewError{fmt.Sprintf("silly nephew, there cannot be %d cows", cows)}
	}
	return amountPerCow(amount, cows), nil
}

func amountPerCow(amount float64, cows int) float64 {
	if cows <= 0 {
		return 0
	}
	return amount / float64(cows)
}
