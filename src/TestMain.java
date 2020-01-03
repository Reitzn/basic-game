import java.awt.EventQueue;
import javax.swing.JFrame;

public class TestMain extends JFrame {

    public TestMain() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(400, 300);
        setResizable(false);

        setTitle("Shooting missiles");
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