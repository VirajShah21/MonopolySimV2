package org.virajshah.monopoly.core;

import java.util.ArrayList;

public class Logger {
	private boolean printing;
	private ArrayList<String> logs;

	/**
	 * @param printing True to print logs to System.out
	 */
	public Logger(boolean printing) {
		this.printing = printing;
		this.logs = new ArrayList<>();
	}

	/**
	 * Log a message
	 * 
	 * @param message Message
	 */
	public void info(String message) {
		logs.add(String.format("[%d] [INFO] %s", logs.size(), message));
		print();
	}

	/**
	 * Log a warning
	 * 
	 * @param message Warning
	 */
	public void warn(String message) {
		logs.add(String.format("[%d] [WARN] %s", logs.size(), message));
		print();
	}

	/**
	 * Log an error
	 * 
	 * @param message Error
	 */
	public void error(String message) {
		logs.add(String.format("[%d] [ERRR] %s", logs.size(), message));
		print();
	}

	/**
	 * Conditionally print log
	 */
	private void print() {
		if (printing)
			System.out.println(logs.get(logs.size() - 1));
	}
}
