package ua.com.kisit.lab_3;

public class Clock {

    private int hour;
    private int minute;


    public void nextMinute() {
        minute++;

        if (minute > 59) {
            minute = 0;
            hour++;
        }

        if (hour > 23) {
            hour = 0;
        }

    }

    public Clock() {
    }

    public Clock(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Clock{" +
                "hour=" + hour +
                ", minute=" + minute +
                '}';
    }

    public static void main(String[] args) {

        Clock clock = new Clock(11,54);
        System.out.println(clock);


    }
}