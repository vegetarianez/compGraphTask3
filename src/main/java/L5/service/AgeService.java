package L5.service;


import L5.exception.InvalidAgeException;
import L5.model.Human;

public class AgeService {
    public void setAge(int age, Human human) {
        try {
            if (age <= 0) {
                throw new InvalidAgeException("Возраст должен быть больше 0.");
            }

            System.out.println("Возраст изменен на " + age);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (InvalidAgeException e) {
            throw new RuntimeException(e);
        } finally {
            if (age < 0) {
                age = 0;
            }
        }
        human.setAge(age);

    }
}
