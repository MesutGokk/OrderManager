package core;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Helper {
    public static void setTheme(){
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels ()){
            if (info.getName().equals("Nimbus")){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                         IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

        }
    }
    public static boolean isFieldEmpty (JTextField field){
        return field.getText().trim().isEmpty();
    }
    public static boolean isFieldListEmpty(JTextField[]fields){
        for (JTextField field : fields) {
            if (isFieldEmpty(field)) return true;

        }
        return false;
    }
    public static boolean isEmailValid (String mail){
        if (mail == null || mail.trim().isEmpty()) return false;

        if (!mail.contains("@")) return false;
        String [] parts = mail.split("@");

        if (parts.length != 2) return false;

        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) return false;

        if (!parts [1].contains(".")) return false;
         return true;

    }
    public static void showMsg (String message){
        String msg;
        String title;
        int msgType = JOptionPane.WARNING_MESSAGE;

        switch (message) {
            case "fill" -> {
                msg = "Please fill in the required fields.";
                title = "Error!";
                msgType = JOptionPane.WARNING_MESSAGE;
            }
            case "done" -> {
                msg = "Success!";
                title = "Result";
                msgType = JOptionPane.INFORMATION_MESSAGE;
            }
            case "error" -> {
                msg = "Something went wrong.";
                title = "Error!";
                msgType = JOptionPane.ERROR_MESSAGE;
            }
            default -> {
                msg = message;
                title = "message";
            }
        }
        JOptionPane.showMessageDialog(null, msg, title, msgType);
    }
}
