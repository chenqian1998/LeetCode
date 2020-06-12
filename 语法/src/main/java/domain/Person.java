package domain;

// Comparable

import java.io.Serializable;

public class Person implements Cloneable, Serializable {

    private String name;
    private int age;
    private Pet pet;

    public Person() {
    }

    public Person(String name, int age, Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public int compareTo(Person person){
//            /*
//    返回值是 <0: 这个类比其他类小
//            =0：            相等
//            >0:             大于
//     */
//        return this.age - person.age;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Object clone(){
        try {
            // 深拷贝，就是对Pet在进行一次拷贝(clone())
            Person person = (Person)super.clone();
            person.setPet((Pet)this.getPet().clone());
            return person;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
