package gross

// Units stores the Gross Store unit measurements.
func Units() map[string]int {
	return map[string]int{
		"quarter_of_a_dozen": 3,
		"half_of_a_dozen":    6,
		"dozen":              12,
		"small_gross":        120,
		"gross":              144,
		"great_gross":        1728,
	}
}

// NewBill creates a new bill.
func NewBill() map[string]int {
	return make(map[string]int)
}

// AddItem adds an item to the customer's bill.
func AddItem(bill, units map[string]int, item, unit string) bool {
	if _, ok := units[unit]; !ok {
		return false // Invalid unit
	}
	if _, ok := bill[item]; !ok {
		bill[item] = 0
	}
	bill[item] += units[unit]
	return true
}

// RemoveItem removes an item from the customer's bill.
func RemoveItem(bill, units map[string]int, item, unit string) bool {
	if _, ok := units[unit]; !ok {
		return false // Invalid unit
	}
	if qty, ok := bill[item]; ok {
		newQty := qty - units[unit]
		if newQty < 0 {
			return false // Invalid quantity
		} else if newQty == 0 {
			delete(bill, item)
		} else {
			bill[item] = newQty
		}
		return true
	}
	return false // Item not found
}

// GetItem returns the quantity of an item that the customer has in their bill.
func GetItem(bill map[string]int, item string) (int, bool) {
	qty, ok := bill[item]
	return qty, ok
}
