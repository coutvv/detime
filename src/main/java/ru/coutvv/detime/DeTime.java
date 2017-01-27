package ru.coutvv.detime;

import java.time.LocalDateTime;

public class DeTime {

	private int hour;
	private int minute;
	private int seconds;
	
	private boolean started = true;
	
	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSeconds() {
		return seconds;
	}

	public DeTime() {
		LocalDateTime tradDate = LocalDateTime.now();
		int tempH = tradDate.getHour();
		int tempM = tradDate.getMinute();
		int tempS = tradDate.getSecond();
		int temp = (tempH * 3600) + (tempM * 60) + tempS;
		temp *= 1000;
		seconds = temp / 864;
		hour = seconds / 10000; seconds -= hour*10000;
		minute = seconds / 100; seconds -= minute*100;
		startCount();
	}
	
	private void incrementSecond() {
		if(seconds < 99) seconds++;
		else {
			seconds = 0;
			incrementMinute();
		}
	}
	private void incrementMinute() {
		if(minute < 99) minute++;
		else {
			minute = 0;
			incrementHour();
		}
	}
	private void incrementHour() {
		if(hour < 9) hour++;
		else hour = 0;
	}
	
	public void stop() {
		started = false;
	}
	
	private void startCount() {
		new Thread(new Runnable() {
			private long timemillis = System.currentTimeMillis();
			public void run() {
				System.out.println("go");
				while(started) {
					if((timemillis - System.currentTimeMillis())%864L == 0) {
						incrementSecond();
					}
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public static void main(String[] args) throws InterruptedException {
		DeTime dt = new DeTime();
		System.out.println(System.currentTimeMillis());
		for(int i = 0 ; i < 100; i++) {
			System.out.println(dt.getHour() + ":" + dt.getMinute() + ":" + dt.getSeconds());
			Thread.sleep(864);
		}
	}
}
