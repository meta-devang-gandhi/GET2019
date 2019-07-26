
/**
 * Class used to create object of animal.
 * @author Devang
 *
 */
public class AnimalObjectFactory
{
	public static Animal getAnimalObject(String name,String animalType, String soundOfAnimal, int age,double weight,  String uniqueId)
	{
		Animal animal=null;
		AnimalsName animalName=null;
		for(AnimalsName value: AnimalsName.values()) 
		{
			if(name.equalsIgnoreCase(value.name())) 
			{
				animalName=value;
				break;
			} 
		}	
		switch (animalName) 
		{
		case LION:
				animal = new Lion(name, animalType, soundOfAnimal, age, weight, uniqueId);
				break;
		case CROCODILE:
				animal = new Crocodile(name, animalType, soundOfAnimal, age, weight, uniqueId);
				break;
		case PEACOCK:
				animal = new Peacock(name, animalType, soundOfAnimal, age, weight, uniqueId);
				break;

		default:
				System.out.println("error ocurred in adding animal !");
				break;
		}
		return animal;
	}
}
