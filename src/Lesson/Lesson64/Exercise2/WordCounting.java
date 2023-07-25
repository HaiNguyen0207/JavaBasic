package Lesson.Lesson64.Exercise2;

import java.util.Objects;

public class WordCounting<String, Integer> {
    private String word;
    private Integer occurrence;

    public WordCounting() {
    }

    public WordCounting(String word) {
        this.word = word;
    }

    public WordCounting(String word, Integer occurrence) {
        this.word = word;
        this.occurrence = occurrence;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Integer occurrence) {
        this.occurrence = occurrence;
    }

    @Override
    public java.lang.String toString() {
        return "WordCounting{" +
                "word=" + word +
                ", occurrence=" + occurrence +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        WordCounting<?, ?> that = (WordCounting<?, ?>) o;
        return Objects.equals(word, that.word) &&
                Objects.equals(occurrence, that.occurrence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, occurrence);
    }
}
