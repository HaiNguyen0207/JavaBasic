package Lesson.Lesson54;

public class Speaking {
    private Speakable mspeakable;

    public Speaking(Speakable mspeakable) {
        this.mspeakable = mspeakable;
    }

    public Speakable getMspeakable() {
        return mspeakable;
    }

    public void setMspeakable(Speakable mspeakable) {
        this.mspeakable = mspeakable;
    }

    public void doSpeak() {
        System.out.println("Inside class Speaking...");
        mspeakable.whisper();
        mspeakable.speak();
    }
}
