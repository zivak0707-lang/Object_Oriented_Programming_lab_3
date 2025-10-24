package ua.com.kisit.lab_3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ClockFrame2 {

    JFrame frame;
    JPanel mainPanel;
    JLabel timeLabel;

    public ClockFrame2() {
        frame = new JFrame("Digital Clock");
        mainPanel = new JPanel();
        timeLabel = new JLabel();

        frame.setSize(700, 180);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(20, 20, 40));
        mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        JPanel clockPanel = new JPanel();
        clockPanel.setLayout(new GridBagLayout());
        clockPanel.setBackground(new Color(30, 30, 60));
        clockPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(100, 200, 255), 2),
                new EmptyBorder(20, 20, 20, 20)
        ));

        timeLabel.setFont(new Font("Consolas", Font.BOLD, 48));
        timeLabel.setForeground(new Color(0, 255, 200));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);

        java.util.Calendar now = java.util.Calendar.getInstance();
        int hour = now.get(java.util.Calendar.HOUR_OF_DAY);
        int minute = now.get(java.util.Calendar.MINUTE);
        int second = now.get(java.util.Calendar.SECOND);
        int millis = now.get(java.util.Calendar.MILLISECOND);

        ClockExt2 clockExt = new ClockExt2(hour, minute, second, millis);

        clockPanel.add(timeLabel);
        mainPanel.add(clockPanel);
        frame.add(mainPanel);

        Timer timer = new Timer(100, e -> {
            clockExt.nextMillisecond();

            String timeText = String.format(
                    "%02d : %02d : %02d : %03d",
                    clockExt.getHour(),
                    clockExt.getMinute(),
                    clockExt.getSeconds(),
                    clockExt.getMilliseconds()
            );

            timeLabel.setText(timeText);
        });

        timer.start();
        frame.setVisible(true);
    }
}