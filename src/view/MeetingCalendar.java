package view;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Meeting;
import control.Court;

public class MeetingCalendar extends JInternalFrame {
    private JCalendar calendar;
    private JTextArea meetingDetails;

    public MeetingCalendar() {
        super("Court Hearings Calendar", true, true, true, true); // Title, resizable, closable, maximizable, iconifiable
        setSize(500, 400);
        getContentPane().setLayout(new BorderLayout());

        // Calendar Component
        calendar = new JCalendar();
        calendar.getDayChooser().getDayPanel().setForeground(new Color(0, 0, 128));
        calendar.setForeground(new Color(0, 64, 128));
        calendar.setBackground(new Color(192, 192, 192));

        // Meeting Details Area
        meetingDetails = new JTextArea();
        meetingDetails.setEditable(false);
        meetingDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
        meetingDetails.setForeground(new Color(0, 64, 128));
        meetingDetails.setBackground(new Color(207, 207, 201));
        meetingDetails.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JScrollPane scrollPane = new JScrollPane(meetingDetails);
        scrollPane.setPreferredSize(new Dimension(400, 150));

        // Listen for date selection in the calendar
        calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                Date selectedDate = calendar.getDate();
                showMeetingsForDate(selectedDate);
            }
        });

        getContentPane().add(calendar, BorderLayout.CENTER);
        getContentPane().add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void showMeetingsForDate(Date selectedDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder details = new StringBuilder();

        Map<Integer, Meeting> allMeetings = Court.getInstance().getAllMeetings();

        List<Meeting> meetingsOnDate = allMeetings.values()
            .stream()
            .filter(meeting -> dateFormat.format(meeting.getMeetingDate()).equals(dateFormat.format(selectedDate)))
            .collect(Collectors.toList());

        if (meetingsOnDate.isEmpty()) {
            meetingDetails.setText("No meetings scheduled for " + dateFormat.format(selectedDate));
        } else {
            for (Meeting meeting : meetingsOnDate) {
                details.append("Time: ").append(meeting.getHour()).append("\n")
                       .append("Case ID: ").append(meeting.getCasee().getCode()).append("\n")
                       .append("Courtroom: ").append(meeting.getCourtroom().getCourtroomNumber()).append("\n")
                       .append("---------------------------\n");
            }
            meetingDetails.setText(details.toString());
        }
    }
}
