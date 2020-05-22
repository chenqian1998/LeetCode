package 设计模式.观察者模式;

public class Observed {
    private Observer observer = new Observer();

    public void call(){
        observer.doSomething();
    }
}
