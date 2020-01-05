import java.awt.EventQueue;
import javax.swing.JFrame;

public class TestMain extends JFrame {

    public TestMain() {

        add(new Board());

        setSize(900, 600);
        setResizable(false);

        setTitle("Basic Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            TestMain ex = new TestMain();
            ex.setVisible(true);
        });
    }
}