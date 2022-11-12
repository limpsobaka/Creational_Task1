import java.util.Objects;

public class Person {
  private String name;
  private String surname;
  private int age = -1;
  private String address;

  public Person(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public Person(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  public Person(String name, String surname, int age, String address) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.address = address;
  }

  public PersonBuilder newChildBuilder() {
    return new PersonBuilder().setSurname(this.surname);
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  public boolean hasAge() {
    return age > -1;
  }

  public boolean hasAddress() {
    return (!address.isEmpty());
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void happyBirthday() throws Exception {
    if (this.hasAge()) {
      this.age += 1;
    } else {
      throw new Exception("Возраст не установлен!");
    }
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", age=" + age +
            ", city='" + address + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, age, address);
  }
}
