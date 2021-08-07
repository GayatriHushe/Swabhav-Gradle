package com.techlabs.action;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CaptchaAction extends ActionSupport {

	private String date = "";
	private byte imageBytes[] = null;
	static String regex = "^[A-Za-z0-9_]+$";
	private static final Pattern check = Pattern.compile(regex);
	private String charPool[] = { "A", "B", "C", "D", "t", "u", "v", "x", "y", "z", "1", "2", "3", "4", "E", "F", "G",
			"H", "I", "J", "g", "h", "i", "j", "k", "7", "8", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "9", "0", "5", "6", "7", "8", "9", "a", "b",
			"c", "d", "e", "f", "l", "m", "n", "o", "p", "q", "r", "s" };
	private String rndcode = "";
	private int rndNumber;
	public static final String CAPTCHA_KEY = "";
	private HttpServletResponse response;

	@Override
	public String execute() throws Exception {
		try {
			response = ServletActionContext.getResponse();
			response.setContentType("image/jpeg");
			int width = 110;
			int height = 33;
			int fontSize = 18;
			int xGap = 12;
			int yGap = 22;
			String fontName = "Arial";
			Color gradiantStartColor = Color.DARK_GRAY;
			Color gradiantEndColor = Color.DARK_GRAY;
			Color textColor = new Color(255, 255, 255);
			String[] newData = { genrateRandomCode() };
			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = bufferedImage.createGraphics();
			RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g2d.setRenderingHints(rh);
			GradientPaint gp = new GradientPaint(0, 0, gradiantStartColor, 0, height / 2, gradiantEndColor, true);
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, width, height);
			for (int i = 0; i < width - 10; i = i + 25) {
				int q = Math.abs(genrateSecureRandomNumber()) % width;
				int colorIndex = Math.abs(genrateSecureRandomNumber()) % 200;
				g2d.setColor(new Color(colorIndex, colorIndex, colorIndex));
				g2d.drawLine(i, q, width, height);
				g2d.drawLine(q, i, i, height);
			}
			g2d.setColor(textColor);
			int index = Math.abs(genrateSecureRandomNumber()) % newData.length;
			String captcha = newData[index];
			if (captcha != null || !captcha.isEmpty() && check.matcher(captcha).matches()) {
				ServletActionContext.getRequest().getSession().setAttribute(CAPTCHA_KEY, captcha);
			}
			int x = 0;
			int y = 0;
			for (int i = 0; i < newData[index].length(); i++) {
				Font font = new Font(fontName, Font.BOLD, fontSize);
				g2d.setFont(font);
				x += xGap + (Math.abs(genrateSecureRandomNumber()) % 7);
				y = yGap + Math.abs(genrateSecureRandomNumber()) % 12;
				g2d.drawChars(newData[index].toCharArray(), i, 1, x, y);
			}
			g2d.dispose();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", baos);
			baos.flush();
			imageBytes = baos.toByteArray();
			baos.close();
			OutputStream outputStream = response.getOutputStream();
			if (imageBytes != null) {
				outputStream.write(imageBytes);
			}
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String genrateRandomCode() throws NoSuchAlgorithmException {
		rndcode = "";
		for (int i = 0; i < 6; i++) {
			rndNumber = genrateSecureRandomNumber() % 50;
			rndcode = rndcode.concat(charPool[rndNumber]);
		}
		return rndcode;
	}

	public int genrateSecureRandomNumber() {
		SecureRandom secureRandomGenerator = null;
		int sr = 0;
		try {
			if (System.getProperty("os.name").startsWith("Windows")) {
				secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
				sr = secureRandomGenerator.nextInt(1000000);
			}
			else {
				secureRandomGenerator = SecureRandom.getInstance("NativePRNG");
				sr = secureRandomGenerator.nextInt(1000000);
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sr;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}