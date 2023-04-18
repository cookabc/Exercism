package blackjack

// ParseCard returns the integer value of a card following blackjack ruleset.
func ParseCard(card string) int {
	cards := map[string]int{
		"ace":   11,
		"two":   2,
		"three": 3,
		"four":  4,
		"five":  5,
		"six":   6,
		"seven": 7,
		"eight": 8,
		"nine":  9,
		"ten":   10,
		"jack":  10,
		"queen": 10,
		"king":  10,
	}
	return cards[card]
}
// FirstTurn returns the decision for the first turn, given two cards of the
// player and one card of the dealer.
func FirstTurn(card1, card2, dealerCard string) string {
	switch {
		case ParseCard(card1)+ParseCard(card2) > 20:
			return LargeHand(IsBlackjack(card1, card2), ParseCard(dealerCard))
		default:
			return SmallHand(ParseCard(card1)+ParseCard(card2), ParseCard(dealerCard))
	}
}
// IsBlackjack returns true if the player has a blackjack, false otherwise.
func IsBlackjack(card1, card2 string) bool {
	return ParseCard(card1)+ParseCard(card2) == 21
}
// LargeHand implements the decision tree for hand scores larger than 20 points.
func LargeHand(isBlackjack bool, dealerScore int) string {
	switch {
	case !isBlackjack:
		return "P"
	case dealerScore < 10:
		return "W"
	default:
		return "S"
	}
}
// SmallHand implements the decision tree for hand scores with less than 21 points.
func SmallHand(handScore, dealerScore int) string {
	switch {
	case handScore <= 11 || (dealerScore >= 7 && handScore < 17):
		return "H"
	default:
		return "S"
	}
}
