#include <iostream>
#include <vector>
#include <memory>


class Animal {

    protected: std::string name;
    protected: int age;
    
    public:
    Animal(std::string n, int a) : age(a), name(n) {}

    virtual ~Animal() {}

    virtual void makeSound() = 0;

    virtual void printInfo() {
        std::cout << "\n" << name << " " << age << "\n";
        makeSound();
    }

};

class Lion : public Animal {

    public:
    Lion(std::string n, int a) : Animal(n, a) {}

    void makeSound() override {
        std::cout << "Rowr!";
    }

};

class Elephant : public Animal {

    public:
    Elephant(std::string n, int a) : Animal(n, a) {}

    void makeSound() override {
        std::cout << "Trumpet!";
    }

};

class Parrot : public Animal {

    bool canFly;

    public:
    Parrot(std::string n, int a) : Animal(n, a) {}

    void makeSound() override {
        std::cout << "Squawk!";
    }

};


class Zoo {

    public:
    Zoo() {}

    std::vector<std::unique_ptr<Animal>> animals;

    void addAnimal(std::unique_ptr<Animal> animal) {
        animals.push_back(std::move(animal));
    }

    void printAllAnimals() { 
        for(const auto& a : animals) {
            a->printInfo();
        }
    }

    void findAnimalByName(std::string name) {
        bool found = false;
        for(const auto& a : animals) {
            std::string animalName = typeid(*a).name();
            animalName = animalName.erase(0,1);
            if(animalName == name) {
                found = true;
                break;
            } else {
                found = false;
            }
        }
        if(found == false) {
            throw std::invalid_argument("Animal name not found!");
        } else {
            std::cout << "\n" << name << " found!";
        }
    }
};


int main() {

    Zoo zoo;

    auto elephant = std::make_unique<Elephant>("blud", 12);
    auto parrot = std::make_unique<Parrot>("blah", 12);
    auto lion = std::make_unique<Lion>("nigga", 12);

    zoo.addAnimal(std::move(elephant));
    zoo.addAnimal(std::move(parrot));
    zoo.addAnimal(std::move(lion));

    zoo.printAllAnimals();
    zoo.findAnimalByName("Elephant");
}