package blackjack

// ParseCard returns the integer value of a card following blackjack ruleset.
func ParseCard(card string) int {
	// panic("Please implement the ParseCard function")
	switch card {
		case "ace":
			return 11
		case "two":
			return 2
		case "three":
			return 3
		case "four":
			return 4
		case "five":
			return 5
		case "six":
			return 6
		case "seven":
			return 7
		case "eight":
			return 8
		case "nine":
			return 9
		case "ten", "jack", "queen", "king":
			return 10
		default:
			return 0
    }
}

// FirstTurn returns the decision for the first turn, given two cards of the
// player and one card of the dealer.
func FirstTurn(card1, card2, dealerCard string) string {
	// panic("Please implement the FirstTurn function")
	// Calculate the numerical values of the player's cards and the dealer's card
    value1 := ParseCard(card1)
    value2 := ParseCard(card2)
    dealerValue := ParseCard(dealerCard)

    // Check for pair of aces
    if card1 == "ace" && card2 == "ace" {
        return "P"
    }

    // Check for blackjack
    if value1+value2 == 21 {
        if dealerValue != 1 && dealerValue < 10 {
            return "W"
        } else {
            return "S"
        }
    }

    // Check for hand value in range [17, 20]
    if value1+value2 >= 17 && value1+value2 <= 20 {
        return "S"
    }

    // Check for hand value in range [12, 16]
    if value1+value2 >= 12 && value1+value2 <= 16 {
        if dealerValue >= 7 {
            return "H"
        } else {
            return "S"
        }
    }

    // Hand value is 11 or lower
    return "H"
}
