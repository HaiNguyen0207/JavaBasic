package Lesson.Lesson53.Exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        Timekeeper timekeeper = new Timekeeper();
        timekeeper.restart(true);
        timekeeper.readFingerprint();
        timekeeper.checkin();
        timekeeper.pushNotification("Xin cảm ơn");
        timekeeper.sleep(true);
        timekeeper.readFingerprint();
        timekeeper.checkout();
        timekeeper.pushNotification("Tạm biệt");
        timekeeper.turnOff(true);
    }
}
