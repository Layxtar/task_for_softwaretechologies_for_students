package org.softwaretechnologies;

import org.softwaretechnologies.animals.Animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Zoo {
    private final List<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public List<String> soundAllAnimalsSortByName() {
        List<String> sounds = new ArrayList<>();
        animalList.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .forEach(animal -> sounds.add(animal.sound()));
        return sounds;
    }
}

