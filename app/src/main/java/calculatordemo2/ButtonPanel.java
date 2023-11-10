package calculatordemo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel {
    private JPanel panel;
    private JButton[] buttons;

    public ButtonPanel(String[] buttonValues, int row, int col)
    {
        panel = new JPanel(new GridLayout(row,col));
        buttons = new JButton[buttonValues.length];

        for (int i = 0; i < buttonValues.length; i++) {
			buttons[i] = new JButton(buttonValues[i]); 
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

    public boolean hasButton (JButton button)
    {
        for (JButton b : buttons)
        {
            if(b.getText() == button.getText())
            {
                return true;
            }
        }
        return false;
    }

}
