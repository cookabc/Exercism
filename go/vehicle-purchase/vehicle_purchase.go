package purchase

import "fmt"

// NeedsLicense determines whether a license is needed to drive a type of vehicle. Only "car" and "truck" require a license.
func NeedsLicense(kind string) bool {
	// panic("NeedsLicense not implemented")
	return kind == "car" || kind == "truck"
}

// ChooseVehicle recommends a vehicle for selection. It always recommends the vehicle that comes first in lexicographical order.
func ChooseVehicle(option1, option2 string) string {
	// panic("ChooseVehicle not implemented")
	option := option2
	if option1 < option2 {
		option = option1
	}
	return fmt.Sprintf("%s is clearly the better choice.", option)
}

// CalculateResellPrice calculates how much a vehicle can resell for at a certain age.
func CalculateResellPrice(originalPrice, age float64) float64 {
	// panic("CalculateResellPrice not implemented")
	percent := 0.5
    if age < 3 {
        percent = 0.8
    } else if age < 10 {
    	percent = 0.7
    }
	return originalPrice * percent
}
