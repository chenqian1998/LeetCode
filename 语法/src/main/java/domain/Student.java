package domain;

public class Student extends Person {
    private double score;

    public Student(String name, int age, Pet pet, double score) {
        super(name, age, pet);
        this.score = score;
    }

    public Student() {

    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() + '\'' +
                ", score=" + score +
                '}';
    }
}
