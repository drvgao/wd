package com.wd.samples;

import org.apache.log4j.Logger;

public class LogTest {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		final Logger logger = Logger.getLogger(LogTest.class);

		try {
			int i = 10;
			i = i / 0;
		} catch (ArithmeticException e) {
			logger.error("asd", e);
		}

	}
}
