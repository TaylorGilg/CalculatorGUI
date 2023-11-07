package calculatordemo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel {
    private JPanel panel;
    private JButton[] buttons;

    public ButtonPanel(String[] buttonNames, int row, int col)
    {
        panel = new JPanel(new GridLayout(row,col));
        buttons = new JButton[buttonNames.length];

        for (int i = 0; i < buttonNames.length; i++) {
			buttons[i] = new JButton(buttonNames[i]); 
            panel.add(buttons[i]);
		}

    }

    public JPanel getPanel()
    {
        return panel;
    }

    public void addButtonListener(ActionListener listener)
    {
        for(JButton button: buttons)
        {
            button.addActionListener(listener);
        }
    }

}
