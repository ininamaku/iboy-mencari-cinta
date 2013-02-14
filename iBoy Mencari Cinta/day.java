class Day {
	String hour[10];
	
	Day() {
		for (int i=0; i<10; i++) {
			hour[i] = "";
		}
	}
	
	Day(int idx, String str) {
		for (int i=0; i<10; i++) {
			if (i==idx) 
				hour[i] = str;
			else
				hour[i] = "";
		}
	}
	
	String getHour (int idx) {
		return hour[idx];
	}
	
	void setHour (int idx, String str) {
		hour[idx] = str;
	}	
}