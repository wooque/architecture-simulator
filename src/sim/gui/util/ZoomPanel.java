package sim.gui.util;

import java.awt.*;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ZoomPanel extends JPanel {

    private final Image image;
    private final int zoomRatio;
    private int zoomX;
    private int zoomY;
    private final int zoomAreaWidth;
    private final int zoomAreaHeight;

    public ZoomPanel(Image image, int zoomAreaWidth, int zoomAreaHeight, int zoomRatio) {
            this.image = image;
            this.zoomAreaWidth = zoomAreaWidth;
            this.zoomAreaHeight = zoomAreaHeight;
            this.zoomRatio = zoomRatio;
            Dimension tempDimension = new Dimension((2 * zoomAreaWidth + 1) * zoomRatio, (2 * zoomAreaHeight + 1)* zoomRatio);
            setMinimumSize(tempDimension);
            setMaximumSize(tempDimension);
            setPreferredSize(tempDimension);
            setSize(tempDimension);
    }

    @Override
    public void paint(Graphics g) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), zoomX - zoomAreaWidth, zoomY - zoomAreaWidth, zoomX+ zoomAreaHeight, zoomY + zoomAreaHeight, null);
            g.setColor(Color.RED);
            g.drawLine((zoomAreaWidth) * zoomRatio + zoomRatio / 2, 0, (zoomAreaWidth) * zoomRatio + zoomRatio / 2,getHeight());
            g.drawLine((zoomAreaWidth + 1) * zoomRatio + zoomRatio / 2, 0, (zoomAreaWidth + 1) * zoomRatio + zoomRatio / 2,getHeight());
            g.drawLine(0, (zoomAreaHeight) * zoomRatio + zoomRatio / 2, getWidth(), (zoomAreaHeight) * zoomRatio+ zoomRatio / 2);
            g.drawLine(0, (zoomAreaHeight + 1) * zoomRatio + zoomRatio / 2, getWidth(), (zoomAreaHeight + 1) * zoomRatio+ zoomRatio / 2);
            g.drawString("(" + zoomX + ", " + zoomY + ")", 0, getFont().getSize());

    }
    public int getZoomX() {
            return zoomX;
    }
    public void setZoomX(int zoomX) {
            this.zoomX = zoomX;
    }
    public int getZoomY() {
            return zoomY;
    }
    public void setZoomY(int zoomY) {
            this.zoomY = zoomY;
    }
}
