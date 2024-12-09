package L5.model;

public abstract class Human implements Interface {
    int age;
    String name;

    public Human(int age, String name) {

        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println("Меня зовут " + name + " мне " + age);
    }
}
//пом файл , один тест дописать