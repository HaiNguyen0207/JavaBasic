package Lesson.Lesson54;

public class SpeakableExample {
    public static void main(String[] args) {
        Speaking speaking = new Speaking(new Speakable() {
            @Override
            public void speak() {
                System.out.println("Hello...");
            }

            @Override
            public void whisper() {
                System.out.println("I love you...");
            }
        });
        speaking.doSpeak();
    }
}


