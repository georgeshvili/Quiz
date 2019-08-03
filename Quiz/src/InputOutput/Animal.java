package InputOutput;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {

        int i;
        Animal[] animals;
        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            i = ois.readInt();
            animals = new Animal[i];
            if(i >= 0)
                for (int j = 0; j < i; j++)
                    animals[j] = (Animal) ois.readObject();
            ois.close();
        } catch (Exception e){
            throw new java.lang.IllegalArgumentException();
        }
        return animals;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

}
