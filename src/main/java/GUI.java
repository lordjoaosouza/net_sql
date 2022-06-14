import javax.swing.*;
import java.net.InetAddress;

public class GUI {
    public GUI() {
        Database database = Database.getInstance(); // Singleton call

        JFrame frame = new JFrame("Get IP");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("URL:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Get IP");

        button.addActionListener(e -> {
            String url = textField.getText();
            this.getIP(url, frame, database);
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        frame.setSize(300, 100);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void getIP(String url, JFrame frame, Database database) {
        try {
            String ip = InetAddress.getByName(url).getHostAddress();  // Get IP from url
            String host = InetAddress.getByName(url).getHostName();  // Get hostname from url
            database.addRequest(host, ip); // Add request to database
            JOptionPane.showMessageDialog(frame, "IP: " + ip);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Could not find IP!\n" + e.getMessage());
            database.addRequest(url, "Error");  // Add request error to database
        }
    }
}
