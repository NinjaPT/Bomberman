package presentation.swing;

import javax.swing.*;
import java.awt.*;

public class ElementViewer extends JLabel
{
    private static final int WIDTH = 43;
    private static final int HEIGHT = 43;

    public ElementViewer(String imgPath)
    {
        super(new ImageIcon(imgPath));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
}
