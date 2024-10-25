package org.dfrecycle.jssc.sample;

import jssc.SerialPort;
import jssc.SerialPortException;

public class Main {
	public static void main(String[] args) {
		SerialPort serialPort = new SerialPort("COM5");

		try {
			serialPort.openPort();
			serialPort.setParams(
					SerialPort.BAUDRATE_9600, 
					SerialPort.DATABITS_8, 
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
			
			
			while(serialPort.isOpened()) {
				String data = serialPort.readString();
				if(data != null) {
					System.out.print(data);
				}
			}
		} catch (SerialPortException e) {
			e.printStackTrace();
		}

		try {
			serialPort.closePort();
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	}

}
