package Main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Help {
	private static WebDriver driver;
	
	// Reading from a text file.
	public static List<String> textFromFile(String fileName) {
		List<String> list = new ArrayList<String>();
		File file = new File(fileName); // textMessLorem.txt
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			while (s != null) {
				list.add(s);
				s = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Parsing strings by specified separators.
	public static String[] splitStr(String s, String _chr) {
		String[] splits = s.split("[" + _chr + "]+"); // "[-,. ]+"
		return splits;
	}

	public static String randomEmail() {

		String allowedChars = "abcdefghiklmnopqrstuvwxyz";
		String randommail = "";
		int num = (int) (Math.floor(Math.random() * (8 - 3)) + 3);

		for (int i = 0; i < num; i++) {
			int rnum = (int) Math.floor(Math.random() * allowedChars.length());
			randommail = randommail + allowedChars.subSequence(rnum, rnum + 1);
		}

		randommail += "@gmail.com";
		// System.out.println(randomstring);
		return randommail;

	}

	public static String randomLogin() {

		String randomstring = "";
		String allowedChars1 = "bcdfghklmnpqrstvwxz";
		String allowedChars2 = "aeiouy";
		int num = (int) (Math.floor(Math.random() * (8 - 3)) + 3);

		for (int i = 0; i < num; i++) {
			if (i % 2 == 0) {
				int rnum2 = (int) Math.floor(Math.random()
						* allowedChars1.length());
				randomstring += allowedChars1.substring(rnum2, rnum2 + 1);
			}

			else {
				int rnum = (int) Math.floor(Math.random()
						* allowedChars2.length());
				randomstring += allowedChars2.substring(rnum, rnum + 1);
			}
		}
		randomstring = randomstring.toUpperCase().substring(0, 1)
				+ randomstring.substring(1);

		return randomstring;
	}
	
	public static String randomString() {
		String randomstring = "";
		int num = (int) (Math.floor(Math.random() * (30 - 10)) + 10);
		for (int i = 0; i < num; i++) {
			randomstring = randomstring + randomLogin() + " ";
		}
		randomstring = randomstring.toUpperCase().substring(0, 1)
				+ randomstring.substring(1).toLowerCase();
		randomstring =  randomstring + ".";
		randomstring = randomstring.replace(" .", ".");
		return randomstring;
	}
	
	public static String randomParagraph() {
		String randomParagraph = "";
		int num = (int) (Math.floor(Math.random() * (6 - 2)) + 2);
		for (int i = 0; i < num; i++) {
			randomParagraph = randomParagraph + randomString() + " ";
		}
		return randomParagraph;
	}
	
	
	public static String randomText() {
		String randomText = "";
		int num = (int) (Math.floor(Math.random() * (5 - 1)) + 1);
		for (int i = 0; i < num; i++) {
			randomText = randomText + randomParagraph() + "\n";
		}
		return randomText;
	}

	public boolean isElementPresent(WebDriver driver, WebElement element) {
		Dimension pr = element.getSize();
		if (pr.getHeight() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static String CurDateString() {
		Calendar now = Calendar.getInstance();
		int vbn = now.get(Calendar.MINUTE);
		String hjk;
		if (vbn < 10)
			 hjk = "0" + vbn;
		else {
			hjk = "" + vbn;
		}

		String curDate = now.get(Calendar.DATE) + "-"
				+ (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.YEAR) + "-" + now.get(Calendar.HOUR_OF_DAY) + "-" + hjk;
		;
		return curDate;
	}

	public static String MonthToInt(String month) {
		String monthInt = " ";
		if (month.equals("января") == true) {
			monthInt = "1";
		}
		if (month.equals("февраля") == true) {
			monthInt = "2";
		}
		if (month.equals("марта") == true) {
			monthInt = "3";
		}
		if (month.equals("апреля") == true) {
			monthInt = "4";
		}
		if (month.equals("мая") == true) {
			monthInt = "5";
		}
		if (month.equals("июня") == true) {
			monthInt = "6";
		}
		if (month.equals("июля") == true) {
			monthInt = "7";
		}
		if (month.equals("августа") == true) {
			monthInt = "8";
		}
		return monthInt;

	}
	
	public static void openNewWin(WebElement element) throws AWTException, InterruptedException{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	public static void mouseClick(Point dfg) throws AWTException, InterruptedException{
		
		Robot robot = new Robot();
		robot.mouseMove(dfg.x, dfg.y + 10);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		try { Thread.sleep(1000); } catch(Exception e) {} // Click one second
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
	}
	
	public static void refreshPage() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		
	}	
	
	public static void sendTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		
	}	
	
	public static Date date() {
		Date date = new Date();
		return date;
	}
	
//	----------------------------------------------------------------
	

	

}
