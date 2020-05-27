package com.etoak.commons;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class VerifyCode {

	// ������
	private int result;

	public BufferedImage createImage() {
		// ͼƬ���
		int width = 105;
		// ͼƬ�߶�
		int height = 32;

		// ����BufferedImage����
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();

		// ���ñ�����ɫ
		graphics.setColor(new Color(0xCDDCDC));
		graphics.fillRect(0, 0, width, height);

		// ���߿�
		graphics.setColor(Color.black);
		graphics.drawRect(0, 0, width - 1, height - 1);

		// �����������
		Random random = new Random();
		for (int i = 0; i < 15; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			graphics.drawLine(x, y, x + xl, y + yl);
		}

		// ������֤����ʽ����:1+2*3
		String verifyCode = this.generateExpression();
		// ��ʼ��ͼ
		graphics.setColor(new Color(0, 88, 0));
		graphics.setFont(new Font("Fixedsys", Font.BOLD, 24));
		graphics.drawString(verifyCode + "=?", 8, 24);
		graphics.dispose();

		// ������ʽ���
		result = this.calc(verifyCode);

		// ����ͼƬ����
		return image;
	}

	public int getResult() {
		return result; 
	}

	/**
	 * ������ʽ��ֵ
	 * 
	 * @param expression
	 * @return
	 * @see [�ࡢ��#��������#��Ա]
	 */
	private int calc(String expression) {
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			return (Integer) engine.eval(expression);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * ������֤����ʽ��1+2
	 * 
	 * @return
	 * @see [�ࡢ��#��������#��Ա]
	 */
	private String generateExpression() {
		Random random = new Random();

		// �����ȡ������ 0-9
		int number = random.nextInt(10); // [0-9]
		int number2 = random.nextInt(10);
		// ������: + - *
		char[] operators = new char[] { '+', '-', '*' };

		// ����ó�һ��������
		char operator = operators[random.nextInt(3)];// 0-2
		return "" + number + operator + number2;
	}

	public static void main(String[] args) {
		VerifyCode verifyCode = new VerifyCode();
		String exp = verifyCode.generateExpression();
		System.out.println(exp + "=" + verifyCode.calc(exp));
	}

}
