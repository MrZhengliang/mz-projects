package com.sh.manage.module.verify;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sh.manage.utils.WebUtils;


/**
 * 绘制图形验证码 Create: 
 * 修改原有的生成随机数，增加从页面将随机数当参数传进来
 */
public class DrawConfirmCode extends HttpServlet {

	/**
	 * 日志管理
	 */
	private Logger logger = Logger.getLogger(DrawConfirmCode.class);
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static String key = "rand"; // 默认的session key

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// String k = servletConfig.getInitParameter("key");
		// if (k != null && k.trim().length() != 0) {
		// key = k;
		// }
	}

	Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
//		// PrintWriter out = response.getWriter();
//
//		// 设置页面不缓存
//
//		response.setHeader("Pragma", "No-cache");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setDateHeader("Expires", 0);
//
//		// 在内存中创建图象
//		int width = 60, height = 22;
//		BufferedImage image = new BufferedImage(width, height,
//				BufferedImage.TYPE_INT_RGB);
//
//		// 获取图形上下文
//
//		Graphics g = image.getGraphics();
//
//		// 生成随机类
//
//		Random random = new Random();
//
//		// 设定背景色
//
//		g.setColor(getRandColor(200, 250));
//		g.fillRect(0, 0, width, height);
//
//		// 设定字体
//		g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//
//		// 画边框
//
//		// g.setColor(new Color());
//		// g.drawRect(0,0,width-1,height-1);
//
//		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
//
//		g.setColor(getRandColor(160, 200));
//		for (int i = 0; i < 155; i++) {
//			int x = random.nextInt(width);
//			int y = random.nextInt(height);
//			int xl = random.nextInt(12);
//			int yl = random.nextInt(12);
//			g.drawLine(x, y, x + xl, y + yl);
//		}
//
//		// 取随机产生的认证码(4位数字)
//		String sRand = "";
//		for (int i = 0; i < 4; i++) {
//			String rand = String.valueOf(random.nextInt(10));
//			sRand += rand;
//			// 将认证码显示到图象中
//			g.setColor(new Color(20 + random.nextInt(110), 20 + random
//					.nextInt(110), 20 + random.nextInt(110)));
//			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
//
//			g.drawString(rand, 13 * i + 6, 16);
//		}
//
//		// sRand = request.getParameter("code");// 获取验证页面传过来的随机数wangzhen
//		if (sRand != "" && sRand != null) {
//			for (int i = 0; i < sRand.length(); i++) {
//				g.setColor(new Color(20 + random.nextInt(110), 20 + random
//						.nextInt(110), 20 + random.nextInt(110)));
//				// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
//
//				g.drawString(sRand.charAt(i) + "", 13 * i + 6, 16);
//			}
//		}
//
//		// 将认证码存入SESSION
//		request.getSession().setAttribute("key", sRand);
//
//		// 图象生效
//		g.dispose();
//
//		// 输出图象到页面
//
//		// ImageIO.write(image, "JPEG", response.getOutputStream());
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response
//				.getOutputStream());
//		encoder.encode(image);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		String rand = this.getValidateImage(RANGE, 70, 21, 4, 1,os);
		// 将认证码存入SESSION
		request.getSession().setAttribute(KEY, rand);
		WebUtils.outputJpegStream(response, new ByteArrayInputStream(os.toByteArray()));
	}
	// Clean up resources
	@Override
	public void destroy() {
	}
	
	
	
	
	
	/** 默认的session key */
	protected static String KEY = "key";

	/** 随机字符范围 */
	protected static String RANGE = "ABCDEFGHJKMNOPQRST23456789";
	//add by fuzhengliang 20130724
    public String getValidateImage(String str, int width, int height, int show, int lineNum, OutputStream output)
    {
      Random random = new Random();
      BufferedImage image = new BufferedImage(width, height, 5);

      Font font = new Font("Arial", 0, height - 1);
      int distance = 18;
      Graphics2D d = (Graphics2D)image.getGraphics();
      d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      d.setColor(Color.WHITE);
      d.fillRect(0, 0, image.getWidth(), image.getHeight());
      d.setColor(new Color(random.nextInt(100) + 100, random.nextInt(100) + 100, random.nextInt(100) + 100));
      for (int i = 0; i < lineNum; i++) {
        d.drawLine(random.nextInt(image.getWidth()), random.nextInt(image.getHeight()), random.nextInt(image.getWidth()), 
          random.nextInt(image.getHeight()));
      }
      d.setColor(new Color(0X8FB9EB));
      d.setFont(font);
      String checkCode = "";

      int x = -distance;
      for (int i = 0; i < show; i++) {
        char tmp = str.charAt(random.nextInt(str.length()));
        checkCode = checkCode + tmp;
        x += distance;
        d.setColor(new Color(random.nextInt(100) + 50, random.nextInt(100) + 50, random.nextInt(100) + 50));
        d.drawString(String.valueOf(tmp), x, random.nextInt(image.getHeight() - font.getSize()) + font.getSize());
      }
      d.dispose();
      try {
        ImageIO.write(image, "jpg", output);
        logger.info("checkCode:"+checkCode);
      } catch (IOException e) {
          logger.info("生成验证码错误.", e);
    	  e.printStackTrace();
      }
      return checkCode;
    }
    //add end
}
