package Lesson.Lesson53.Exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        Iphone iphone12Promax = new Iphone();
        iphone12Promax.setName("IP 12 Pro MAX");
        System.out.println("Tên máy: " + iphone12Promax.getName());
        iphone12Promax.turnOn(true);
        iphone12Promax.unlock("Face ID");
        iphone12Promax.changeBrightness(50);
        iphone12Promax.changeVolume(-30);
        iphone12Promax.connectPeripheral("bộ sạc");
        iphone12Promax.turnOff(true);
    }
}
