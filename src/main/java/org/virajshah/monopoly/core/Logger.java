package org.virajshah.monopoly.core;

import java.util.ArrayList;

public class Logger {
	private boolean printing;
	private ArrayList<String> logs;

	public Logger(boolean printing) {
		this.printing = printing;
		this.logs = new ArrayList<>();
	}

	public void info(String message) {
		logs.add(String.format("[%d] [INFO] %s", logs.size(), message));
		print();
	}

	public void warn(String message) {
		logs.add(String.format("[%d] [WARN] %s", logs.size(), message));
		print();
	}

	public void error(String message) {
		logs.add(String.format("[%d] [ERRR] %s", logs.size(), message));
		print();
	}

	private void print() {
		if (printing)
			System.out.println(logs.get(logs.size() - 1));
	}
}
