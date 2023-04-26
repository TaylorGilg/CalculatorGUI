/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package calculatordemo2;

import javax.swing.JTextArea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;  // This brings in the Field feature of Java Reflection

class CalculatorUITest {

    private static CalculatorUI classUnderTest;

    @BeforeAll
    public static void setUp() {
        classUnderTest = new CalculatorUI();
    }

    @DisplayName("Testing that writer writes the display")
    @Test
    public void writerSetText() throws Exception {
        // Use reflection to access the private field “text”
        Class cls = classUnderTest.getClass();
        Field field = cls.getDeclaredField("text");
        field.setAccessible(true);
        // Set the value of “text” to “mytext”
        JTextArea text = (JTextArea) field.get(classUnderTest);
        text.setText("mytext");
        // Test that the value of “text” is “mytext”
        assertEquals("mytext", text.getText());
    }
    
    @Test 
    void appPanelIsCreated() {
        assertNotNull(classUnderTest, "app should have a panel object");
    }
}

