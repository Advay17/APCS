package Pets;
public class PetDemo {
	public static void main(String[] args) {
		Pet[] pets = { new Dog("Perry", 10, "doberman"), new Cat("Dwayne", 4, true), new Bird("Koo", 7, "owl"), new Fish("Serpentmoon Marbledale", 9999999, 512.1425)};
		for (Pet pet : pets) {
			System.out.println(pet.makeSound());
			System.out.println(pet.getInfo());
			System.out.println(pet.getName() + "'s favorite activity is " + pet.getFavoriteActivity());
			switch (pet.getClass().getName()) {
				case "Cat":
					((Cat)pet).scratch();
					break;
				case "Dog":
					((Dog)pet).fetch();
					break;
				case "Bird":
					((Bird)pet).fly();
					break;
				case "Fish":
					((Fish)pet).swim();
					break;
				default:
					System.out.println("broken");
					break;
			}
			System.out.println();
		}
	}
}
