package project;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Showpic extends JPanel implements Runnable {

    private ImageIcon img; //ไว้เรียกไฟล์ภาพ
    static String pic;     // ไว้รับ path จากที่ click ที่ tree
    private String name = ""; // ไว้เทียบเมื่อมีก่ีเปลี่ยนภาพให้วาดใหม่ ไม่เช่นนั้น ภาพจะโผล่ๆหายเนื่องจากการใช้ thread
    private boolean a = false; // boolean ใช้เทียบเมื่อมีการเปลี่ยนภาพ
    static Thread draw; // thread ทำงานตลอดเพื่อรอรับ event ที่ต้องเปลี่ยนภาพ
    // Constructor ใช้กำหนด Panel
    public Showpic() {
        setBounds(400, 0, 600, 1000);
        setBackground(Color.RED);
        draw = new Thread(this);
    }
    // ใช้แสดงรูปภาพ
    @Override
    public void paintComponent(Graphics g) {
        if (a) {
            repaint();
            validate();
            img = new ImageIcon(pic);
            g.drawImage(img.getImage(), 400, 50, this);
            this.a = false;
            validate();
        }
    }
    //ส่วนใช้ตรวจสอบเมื่อมี event
    @Override
    public void run() {
        while (true) {
            validate();
            if (pic != null && !this.a) {
                if (pic != this.name) {
                    img = null;
                    this.name = pic;
                    repaint();
                    validate();
                    this.a = true;
                }
            }
        }
    } 

}
