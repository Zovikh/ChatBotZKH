import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBotZKH extends JFrame implements ActionListener {
    //переменные и константы
    final String PROGRAM_TITLE = "Botman and RobBot";
    final int START_LOC = 600;
    final int W_WIDTH = 650;
    final int W_HEIGHT = 750;


    JTextArea dialArea; // бласть диалога
    JCheckBox switchAi;       // Включение и отключение ИИ
    JTextField entMessage; // Поле ввода сообщений
    SimpleBot chatBot;     // класс бота



    public static void main(String[] args) {
        new ChatBotZKH();
    }

    ChatBotZKH(){
        setTitle(PROGRAM_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOC, START_LOC, W_WIDTH, W_HEIGHT);

        dialArea = new JTextArea();
        dialArea.setLineWrap(true);
        JScrollPane scrollBar = new JScrollPane(dialArea);
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        switchAi = new JCheckBox("ИИ");
        switchAi.doClick();
        entMessage = new JTextField();
        entMessage.addActionListener(this);
        JButton enter = new JButton("Пуск");
        enter.addActionListener(this);
        add(BorderLayout.CENTER, scrollBar);
        bp.add(switchAi);
        bp.add(entMessage);
        bp.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
        chatBot = new SimpleBot();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (entMessage.getText().trim().length() > 0) {
            dialArea.append(entMessage.getText() + "\n");
            dialArea.append(PROGRAM_TITLE.substring(0, 9) +
                    chatBot.sayInReturn(entMessage.getText(), switchAi.isSelected()) + "\n");
        }
        entMessage.setText("");
        entMessage.requestFocusInWindow();
    }
}
