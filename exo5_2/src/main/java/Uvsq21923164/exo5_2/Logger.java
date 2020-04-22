package Uvsq21923164.exo5_2;

import java.time.LocalDateTime;

public class Logger implements LogInterface {

	public void write(String string) {
		System.out.println(LocalDateTime.now() + ": " + string);
	}

}
