import javax.swing.*;
import java.awt.*;

public class MyComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        this.paint(g2);
    }

    public void paint(Graphics g)
    {
        Font font = new Font("Bitstream Charter", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("Фамилия:", 20, 40);
        g.drawString("Имя:", 20, 80);
        g.drawString("Телефон:", 20, 120);
        g.drawString("Важность заказа:", 20, 160);
        g.drawRect(130, 20, 200, 30);
        g.drawRect(80,60 , 200, 30);
        g.drawRect(130,100 , 200, 30);
        g.drawRect(200,140 , 200, 30);
    }
}
