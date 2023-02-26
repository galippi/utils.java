package lippiWare.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author liptakok
 */
public class threadImage
{
  public threadImage(java.awt.Component parent)
  {
    this.parent = parent;
    ready = true;
    stop = false;
    cancel = false;
    t = new Thread(new DrawingLoop());
    t.start();
  }
  java.awt.Component parent;
  Thread t;
  private class DrawingLoop
      implements Runnable {
      public void run()
      {
        System.out.println("DrawingLoop - Runnable - run");
        try
        {
          //Thread.sleep(2000);
          int ctr = 0;
          while(!stop)
          {
            if (!ready)
            {
              System.out.println("DrawingLoop ctr=" + ctr);ctr++;
              Drawing();
              setImg(img);
              ready = true;
              parent.repaint();
            }
            Thread.sleep(100);
          }
        } catch (InterruptedException e) {
              //threadMessage("I wasn't done!");
        }
      }
  }

  protected void Drawing()
  { /* drawing function */
    java.awt.Graphics2D g = img.createGraphics();
    g.setColor(Color.red);
    g.fillOval(img.getWidth() / 2, img.getHeight() / 2, img.getWidth() / 2 - 5, img.getHeight() / 2 - 5);
    g.setColor(Color.green);
    g.drawString("threadImage.drawString", 40, 40);
    g.dispose();
  }

  public boolean isCancelled()
  {
    return cancel;
  }

  public boolean isReady()
  {
    return ((imgReady != null) && ready);
  }

  public void Cancel()
  {
    cancel = true;
    while(!ready)
    { /* waiting to stop drawing thread */
      try
      {
         Thread.sleep(10);
      } catch (InterruptedException e) {
            //threadMessage("I wasn't done!");
      }
    }
    cancel = false;
  }
  public boolean setImage(int width, int height)
  {
    if ((img == null) || (img.getWidth() != width) || (img.getHeight() != height))
    {
      Cancel();
      img = new java.awt.image.BufferedImage(width, height, imageType);
      return true;
    }
    return false;
  }
  public void repaint()
  {
    if (img != null)
    {
      Cancel();
      ready = false;
    }
  }
  public java.awt.image.BufferedImage getImage()
  {
    return imgReady;
  }
  public void setImg(java.awt.image.BufferedImage newImg)
  {
    imgReady = newImg;
  }

  public void setImgTmp(BufferedImage img)
  {
    BufferedImage tmpImg = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
    java.awt.Graphics2D g2d = tmpImg.createGraphics();
    g2d.drawImage(img, 0, 0, null);
    g2d.dispose();
    imgReady = tmpImg;
    parent.repaint();
  }

  public void setType(int type)
  {
    imageType = type;
  }
  public void stop()
  {
    stop = true;
  }
  protected java.awt.image.BufferedImage img;
  protected java.awt.image.BufferedImage imgReady;
  int imageType = java.awt.image.BufferedImage.TYPE_INT_ARGB;
  protected Boolean ready;
  Boolean cancel;
  Boolean stop;
}
