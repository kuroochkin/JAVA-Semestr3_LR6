import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main
{
    static JFrame jFrame = getFrame(); // Создаем Frame
    static JPanel jPanel = new JPanel(); // Создаем Panel


    public static void main(String[] args) throws Exception
    {
        jFrame.add(jPanel); // Передаем компонент Panel в Frame
        PrintInfo(jPanel);
        jFrame.setResizable(false); // Не допускаем изменение размера Frame
    }

    public static JFrame getFrame() // Метод создания Frame
    {
        JFrame frame = new JFrame("Форма заказа") {};
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }

    public static void PrintInfo(JPanel jPanel) throws Exception // Метод выполнения компонента
    {
        Properties prop = new Properties();
        Preloader preloader = new Preloader("settings.ini", prop);

        JTextField text1 = new JTextField(20); // Ячейка фамилии
        jPanel.add(new JLabel("Фамилия: "));
        jPanel.add(text1);

        JTextField text2 = new JTextField(23); // Ячейка имени
        jPanel.add(new JLabel("Имя: "));
        jPanel.add(text2); // Добавляем в панель

        jPanel.add(new JLabel("Телефон: ")); // Ячейка телефона
        JTextField text3 = new JTextField(20);
        jPanel.add(text3); // Добавляем в панель


        jPanel.add(new JLabel("Важность: ")); // Ячейка важности
        JComboBox<String> combo = new JComboBox<>();
        combo.insertItemAt("Низкая", 0);
        combo.addItem("Средняя");
        combo.addItem("Высокая");
        jPanel.add(combo);


        JButton button = new JButton("Оформить заказ");
        jPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(text1.getText().isEmpty() || text2.getText().isEmpty() || text3.getText().isEmpty())
                {
                    JLabel error = new JLabel("Ошибка! Заполните все поля!");
                    jPanel.add(error);
                    jPanel.revalidate();
                }
                else if(text1.getBackground() == Color.red|| text2.getBackground() == Color.red || text3.getBackground() == Color.red)
                {
                    JLabel error = new JLabel("Ошибка! Заполните все поля верно!");
                    jPanel.add(error);
                    jPanel.revalidate();
                }
                else
                {
                    jPanel.add(new JLabel("Спасибо за заказ! Ожидайте."));
                    jPanel.revalidate();
                    button.setEnabled(false);
                    text1.setEnabled(false);
                    text2.setEnabled(false);
                    text3.setEnabled(false);
                    combo.setEnabled(false);
                }

            }
        });

        jPanel.revalidate();

        text1.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                Pattern p = Pattern.compile(prop.getProperty("letter"));
                Matcher m = p.matcher(text1.getText());


                if (!m.matches()) {
                    text1.setEnabled(true);
                    text1.setBackground(Color.red);

                    text1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            text1.setEnabled(true);
                        }
                    });
                }
                else
                {
                    text1.setBackground(Color.green);
                }
            }
        });

        text2.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                Pattern p = Pattern.compile(prop.getProperty("letter"));
                Matcher m = p.matcher(text2.getText());

                if (!m.matches()) {
                    text2.setEnabled(true);
                    text2.setBackground(Color.red);


                    text2.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            text2.setEnabled(true);
                        }
                    });
                }
                else
                {
                    text2.setBackground(Color.green);
                }
            }
        });

        text3.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                Pattern p = Pattern.compile(prop.getProperty("number"));
                Matcher m = p.matcher(text3.getText());

                if (!m.matches()) {
                    text3.setEnabled(true);
                    text3.setBackground(Color.red);

                    text3.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            text3.setEnabled(true);
                        }
                    });
                }
                {
                    text3.setBackground(Color.green);
                }
            }
        });
    }
}