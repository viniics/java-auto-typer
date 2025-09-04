import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class AutoTyper {
    public void autoType() throws Exception {
        Thread.sleep(5000);
        Robot robot = new Robot();
        Path filePath = Paths.get("text.txt");
        FileReader fileReader = new FileReader(filePath.toFile());
        int charPos;
        while ((charPos = fileReader.read()) != -1) {
            Thread.sleep(10);
            typeChar(robot, (char) charPos);
        }
        fileReader.close();
    }

    private void typeChar(Robot robot, char c) {
        boolean upper = Character.isUpperCase(c);
        int keyCode = keyMap.getOrDefault(Character.toLowerCase(c), -1);

        if (keyCode == -1) {
            System.out.println("Unsupported char: " + c);
            return;
        }

        if (upper) {
            robot.keyPress(KeyEvent.VK_SHIFT);
        }

        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);

        if (upper) {
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    private final Map<Character, Integer> keyMap = new HashMap<>();
    {
        keyMap.put('a', KeyEvent.VK_A);
        keyMap.put('b', KeyEvent.VK_B);
        keyMap.put('c', KeyEvent.VK_C);
        keyMap.put('d', KeyEvent.VK_D);
        keyMap.put('e', KeyEvent.VK_E);
        keyMap.put('f', KeyEvent.VK_F);
        keyMap.put('g', KeyEvent.VK_G);
        keyMap.put('h', KeyEvent.VK_H);
        keyMap.put('i', KeyEvent.VK_I);
        keyMap.put('j', KeyEvent.VK_J);
        keyMap.put('k', KeyEvent.VK_K);
        keyMap.put('l', KeyEvent.VK_L);
        keyMap.put('m', KeyEvent.VK_M);
        keyMap.put('n', KeyEvent.VK_N);
        keyMap.put('o', KeyEvent.VK_O);
        keyMap.put('p', KeyEvent.VK_P);
        keyMap.put('q', KeyEvent.VK_Q);
        keyMap.put('r', KeyEvent.VK_R);
        keyMap.put('s', KeyEvent.VK_S);
        keyMap.put('t', KeyEvent.VK_T);
        keyMap.put('u', KeyEvent.VK_U);
        keyMap.put('v', KeyEvent.VK_V);
        keyMap.put('w', KeyEvent.VK_W);
        keyMap.put('x', KeyEvent.VK_X);
        keyMap.put('y', KeyEvent.VK_Y);
        keyMap.put('z', KeyEvent.VK_Z);

        keyMap.put('0', KeyEvent.VK_0);
        keyMap.put('1', KeyEvent.VK_1);
        keyMap.put('2', KeyEvent.VK_2);
        keyMap.put('3', KeyEvent.VK_3);
        keyMap.put('4', KeyEvent.VK_4);
        keyMap.put('5', KeyEvent.VK_5);
        keyMap.put('6', KeyEvent.VK_6);
        keyMap.put('7', KeyEvent.VK_7);
        keyMap.put('8', KeyEvent.VK_8);
        keyMap.put('9', KeyEvent.VK_9);

        keyMap.put(' ', KeyEvent.VK_SPACE);
        keyMap.put('.', KeyEvent.VK_PERIOD);
        keyMap.put(',', KeyEvent.VK_COMMA);
        keyMap.put('!', KeyEvent.VK_EXCLAMATION_MARK);
        keyMap.put('?', KeyEvent.VK_SLASH);
        keyMap.put(':', KeyEvent.VK_COLON);
        keyMap.put(';', KeyEvent.VK_SEMICOLON);
        keyMap.put('"', KeyEvent.VK_QUOTE);
        keyMap.put('\'', KeyEvent.VK_QUOTE);
        keyMap.put('\n', KeyEvent.VK_ENTER);
    }

}
