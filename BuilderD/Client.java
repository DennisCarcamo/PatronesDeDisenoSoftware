public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MealBuilder pizzaBuilder = new SandwichMealBuilder();
		MealDirector director = new MealDirector();
		director.makeMeal(pizzaBuilder);
		Meal meal = pizzaBuilder.getMeal();
		System.out.println(meal.toString());
	}
    
}

class Meal {
    public String sandwich;
    public String sideOrder;
    public String drink;
    public String offer;
    public double price;
    
    public String toString() {
	return "Sandwich: "+ sandwich + "\nSide Order: " + sideOrder + "\nDrink: "
				+ drink + "\nOffer: " + offer + "Price: " + price;
	}
}

 interface MealBuilder {
    public abstract void addSandwich(String sandwich);
    public abstract void addSides(String sides);
    public abstract void addDrink(String drink);
    public abstract void addOffer(String coupon);
    public abstract void setPrice(double price);
    public abstract Meal getMeal();
 }

class MealDirector {
    public void makeMeal(MealBuilder mealBuilder) {
		mealBuilder.addSandwich("Hamburger");
		mealBuilder.addSides("Fries");
		mealBuilder.addDrink("Coke");
		mealBuilder.addOffer("Weekend Bonanza");
		mealBuilder.setPrice(5.99);
   }
}
class SandwichMealBuilder implements MealBuilder{
    private Meal _meal = new Meal();

	@Override
	public void addSandwich(String sandwich) {
		_meal.sandwich = sandwich;
	}

	@Override
	public void addSides(String sides) {
		_meal.sideOrder = sides;
	}

	@Override
	public void addDrink(String drink) {
		_meal.drink = drink;
	}

	@Override
	public void addOffer(String coupon) {
		_meal.offer = coupon;
	}

	@Override
	public void setPrice(double price) {
		_meal.price = price;
	}

	@Override
	public Meal getMeal() {
		return _meal;
	}
    
}


