
/**
 * Class store the attribute of animals.
 * @author Devang
 *
 */
public abstract class Animal
{	
	public String name;
	public String animalType;
	public String sound;
	public int age;
	public Double weight;
	public String uniqueIdOfAnimal;
		
	public abstract String getAnimalSound();
}