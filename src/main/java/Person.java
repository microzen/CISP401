import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private Date born;
	private Date died;	// null indicates they are still alive
	
	public Person(String initialName, Date birthDate, Date deathDate) {
		if (consistent(birthDate, deathDate)) {
			name = initialName;
			born = new Date(birthDate);
			if (deathDate == null) died = null;
			else died = new Date(deathDate);
		}
		else {
			System.err.println("Dates not consistent!");
		}
	}
	
	public Person(Person original) throws Exception {
		if (original == null) {
			throw new Exception("Null Person object cannot be copied");
		}
		name = original.name;
		born = new Date(original.born);
		
		if (original.died == null) died = null;
		else died = new Date(original.died);
	}
	
	public void set(String newName, Date birthDate, Date deathDate) {
		if (consistent(birthDate, deathDate)) {
			name = newName;
			born = new Date(birthDate);
			if (deathDate == null) died = null;
			else died = new Date(deathDate);
		}
		else {
			System.err.println("Dates not consistent!");
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof Person)) return false;
		Person otherPerson = (Person) o;
		return name.equals(otherPerson.name) && 
				born.equals(otherPerson.born) && 
				died.equals(otherPerson.died);
	}
	
	public void setBirthDate(Date newDate) {
		if (consistent(newDate, died)) {
			born = new Date(newDate);
		}
		else System.err.println("Dates not consistent!");
	}
	
	public void setDeathDate(Date newDate) {
		if (! consistent(newDate, died)) {
			System.err.println("Dates not consistent!");
		}
		if (newDate == null) died = null;
		else died = new Date(newDate);
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getBirthDate() {
		return new Date(born);
	}
	
	public Date getDeathDate() {
		if (died == null) return null;
		else return new Date(died);
	}
	
	private boolean consistent(Date birthDate, Date deathDate) {
		if (birthDate == null) return false;
		if (deathDate == null) return true;
		return birthDate.precedes(deathDate) || birthDate.equals(deathDate);
	}
}
