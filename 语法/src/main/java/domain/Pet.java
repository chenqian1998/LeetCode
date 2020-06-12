package domain;

public class Pet implements Cloneable{
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
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

    public Object clone(){
        try{
            // 浅拷贝
            return super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
