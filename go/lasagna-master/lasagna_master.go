package lasagna

const (
	defautlPreparationTimePerLayer = 2
	noodleQtyPerLayer              = 50
	sauceQtyPerLayer               = 0.2
	defaultServingInRecipe         = 2
)

// PreparationTime estimates the total preparation time based on the number of layers
func PreparationTime(layers []string, preparationTimePerLayer int) int {
	if preparationTimePerLayer <= 0 {
		preparationTimePerLayer = defautlPreparationTimePerLayer
	}
	return len(layers) * preparationTimePerLayer
}

// Quantities determines the quantity of noodles and sauce needed to make your meal
func Quantities(layers []string) (int, float64) {
	noodleLayers := 0
	sauceLayers := 0
	for _, l := range layers {
		switch l {
		case "noodles":
			noodleLayers++
		case "sauce":
			sauceLayers++
		}
	}
	return noodleLayers * noodleQtyPerLayer, float64(sauceLayers) * sauceQtyPerLayer
}

// AddSecretIngredient adds the secret ingredient to your recipe
func AddSecretIngredient(friendsList, myList []string) {
	myList[len(myList)-1] = friendsList[len(friendsList)-1]
}

// ScaleRecipe gives the amounts needed for the desired number of portions
func ScaleRecipe(quantities []float64, amount int) []float64 {
	var scaledAmounts []float64
	for _, recipeQty := range quantities {
		scaledAmounts = append(scaledAmounts, recipeQty/defaultServingInRecipe*float64(amount))
	}
	return scaledAmounts
}
