package com.woniuxy.shop.servlet;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;





import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * ͼƬ��֤�����
 * @author xumin
 *
 */

@SuppressWarnings("serial")
public class PictureCheckCodeServlet extends HttpServlet {




	// ��ȡ�����ɫ

	public Color getRandColor(int s, int e) {

		Random random = new Random();

		if (s > 255) s = 255;

		if (e > 255) e = 255;

		int r = s + random.nextInt(e - s); //������RGB��ɫ�е�rֵ

		int g = s + random.nextInt(e - s); //������RGB��ɫ�е�gֵ

		int b = s + random.nextInt(e - s); //������RGB��ɫ�е�bֵ

		return new Color(r, g, b);

	}




	public void service(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, IOException {

		response.setHeader("Pragma", "No-cache");

		response.setHeader("Cache-Control", "No-cache");

		response.setDateHeader("Expires", 0);

		// ָ����ɵ���Ӧ��ͼƬ

		response.setContentType("image/jpeg");

		int width = 86;

		int height = 26;

		BufferedImage image = new BufferedImage(width, height,

				BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();

		Graphics2D g2d = (Graphics2D) g;

		Random random = new Random();

		Font mFont = new Font("����", Font.BOLD, 17);

		g.setColor(getRandColor(200, 250));

		g.fillRect(0, 0, width, height);

		g.setFont(mFont);

		g.setColor(getRandColor(180, 200));

		// ����������

		for (int i = 0; i < 100; i++) {

			int x = random.nextInt(width - 1);

			int y = random.nextInt(height - 1);

			int x1 = random.nextInt(6) + 1;

			int y1 = random.nextInt(12) + 1;

			BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT,

					BasicStroke.JOIN_BEVEL);

			Line2D line = new Line2D.Double(x, y, x + x1, y + y1);

			g2d.setStroke(bs);

			g2d.draw(line);

		}

		String sRand = "";

		// ���������֤����

		String ctmp = "";

		int itmp = 0;

		for (int i = 0; i < 4; i++) {

			//random = new Random(new java.util.Date().getTime() + i);

			switch (random.nextInt(3)) {

			case 1:

				itmp = random.nextInt(26) + 65; // ���A~Z����ĸ

				ctmp = String.valueOf((char) itmp);
				if (ctmp.equalsIgnoreCase("o")) {
					ctmp = "A";
				}

				break;

			default:

				itmp = random.nextInt(10) + 48; // ���0~9������

				ctmp = String.valueOf((char) itmp);
				if (ctmp.equalsIgnoreCase("0")) {
					ctmp = "1";
				}

				break;

			}

			sRand += ctmp;

			Color color = new Color(20 + random.nextInt(110), 20 + random

					.nextInt(110), 20 + random.nextInt(110));

			g.setColor(color);

			// ��������תָ���Ƕ�

			Graphics2D g2d_word = (Graphics2D) g;

			AffineTransform trans = new AffineTransform();

			trans.rotate(random.nextInt(45) * 3.14 / 180, 15 * i + 8, 7);

			// ��������

			float scaleSize = random.nextFloat() +0.8f;

			if (scaleSize > 1f) scaleSize = 1f;

			trans.scale(scaleSize, scaleSize);

			g2d_word.setTransform(trans);

			g.drawString(ctmp, 15 * i + 18, 14);
		}

		// ����ɵ���֤�뱣�浽Session��

		HttpSession session = request.getSession(true);

		session.setAttribute("randCheckCode", sRand);

		g.dispose();
		//System.out.println("randCheckCode:"+session.getAttribute("randCheckCode"));
		
		ImageIO.write(image, "JPEG", response.getOutputStream());

	}




}