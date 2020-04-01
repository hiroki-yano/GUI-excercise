
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BoxTest extends JPanel{
    static final int WIDTH = 800; // 画面サイズ（幅）
    static final int HEIGHT = 600; // 画面サイズ（高さ）
    int status = 0; // 箱の状態（0:黒，その他:赤）

    // コンストラクタ（初期化処理）
    public BoxTest() {
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addMouseListener(new MouseProc());
    }

    // 画面描画
    public void paintComponent(Graphics g) {
        // 背景
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // 箱を表示
        if (status == 0) {
            g.setColor(Color.black);
        } else {
            g.setColor(Color.red);
        }
        g.fillRect(350, 250, 100, 100);
    }
    // クリックされた時の処理用のクラス
    class MouseProc extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            // 位置を取得
        	// x座標を返す
            int mx = e.getX();
            // y座標を返す
            int my = e.getY();
            // 四角形の内部かどうかの判定
            if (350<mx && mx<450 && 250<my && my<350) {
                if (status == 0) {
                    status = 1;
                } else {
                    status = 0;
                }
            }
            // 再描画要求
            repaint();
        }
    }

     // 起動時
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().setLayout(new FlowLayout());
        f.getContentPane().add(new BoxTest());
        f.pack();
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}