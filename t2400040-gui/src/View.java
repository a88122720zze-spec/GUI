import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JPanel {

    private Model model;

    // Sample instance variables:
    //private Image image;
    private WavSound sound;

    public View(Model model) {
        this.model = model;

//        // 画像を読み込む．画像ファイルは src においておくと bin に自動コピーされる
//        image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("robot.png"));
//        // サウンドを読み込む
//        sound = new WavSound(getClass().getResource("bomb.wav"));
      }

    /**
     * 画面を描画する
     * @param g  描画用のグラフィックスオブジェクト
     */
    @Override
    public void paintComponent(Graphics g) {
        // 画面をいったんクリア
        clear(g);

        // 描画する
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
        g.setColor(Color.WHITE);

        g.drawString("Timer: " + model.getTime(), 400, 50);
        //g.drawString("Key Typed: " + model.getTypedChar(), 100, 200);
        //g.drawString("KeyRollover: " + model.getEnableKeyRollover(), 100, 250);
        //g.drawString("Mouse Pressed: " + model.getMX() + "," + model.getMY(), 100, 300);
        //g.drawRect(x, y, width, height);
        g.drawRect(50, 60, 90, 200);
        g.drawString("Life: "+ model.getlife() , 50, 50);
        g.setColor(Color.GREEN);//四角の色を赤に設定
        g.fillRect(50, 260 - model.getlife() * 2, 90, model.getlife() * 2); 
        
        g.setColor(Color.WHITE);//白に戻す
        
        g.drawRect(150,600, 250, 160);//画像にする
        
        g.drawString("selected: " , 30, 300);//1文字
        g.drawString( model.getselected() ,60, 340);
        g.drawRect(25,270, 145, 80);
        
        g.drawString("特性: " + model.getFeatureThings() , 200, 300);
        g.drawString("type: " + model.getString(), 200, 350);
        
        //候補を示す
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));//大きさ変更
        g.setColor(Color.WHITE);
        Iterator<Feature> it = model.getFeature().iterator();
        int num =0;
        while (it.hasNext()) {
            Feature f = it.next();
            g.drawString( f.getfN() + " : " + f.getfR() +" :"+ f.getfe()  , 500,100+30*num );
            num++;
            
        }
        
        // 画像の表示例
        //g.drawImage(image, model.getMX(), model.getMY(), this);

        // Linux でアニメーションをスムーズに描画するため（描画結果が勝手に間引かれることを防ぐ）
        getToolkit().sync();
    }

    /**
     * 画面を黒色でクリア
     * @param g  描画用のグラフィックスオブジェクト
     */
    public void clear(Graphics g) {
        Dimension size = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, size.width, size.height);
    }

    public void playBombSound() {
        sound.play();
    }
}
