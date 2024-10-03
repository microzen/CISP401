package lab;
import java.io.Serializable;

public class Date implements Serializable {
	private int month;
	private int day;
	private int year;		// year must be a 4 digit number
	
	public Date(int month, int day, int year) {
		setDate(month, day, year);
	}
	
	public Date(Date aDate) {
		if (aDate == null) {
			System.err.println("Date cannot be null!");
		}
		month = aDate.month;
		day = aDate.day;
		year = aDate.year;
	}
	
	public void setDate(int month, int day, int year) {
		if (dateOK(month, day, year)) {
			this.month = month;
			this.day = day;
			this.year = year;
		}
		else System.err.println("Date values not valid!");
	}
	
	private boolean dateOK(int month, int day, int year) {
		if (year < 1000 || year > 9999) return false;
		switch (month) {
		case 2:
			if (year % 4 == 0) {
				if (day < 1 || day > 29) return false;
			}
			else {
				if (day < 1 || day > 28) return false;
			}
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day < 1 || day > 31) return false;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (day < 1 || day > 30) return false;
			break;
		default: return false;
		}
		return true;
	}
	
	public String getMonthString() {
		switch (month) {
		case 1: return "January";
		case 2: return "February";
		case 3: return "March";
		case 4: return "April";
		case 5: return "May";
		case 6: return "June";
		case 7: return "July";
		case 8: return "August";
		case 9: return "September";
		case 10: return "October";
		case 11: return "November";
		case 12: return "December";
		}
		return null;
	}
	
	@Override
	public String toString() {
		return getMonthString() + " " + day + ", " + year;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (! (o instanceof Date)) return false;
		Date otherDate = (Date) o;
		if (day == otherDate.day && month == otherDate.month && year == otherDate.year) return true;
		return false;
	}
	
	public boolean precedes(Date otherDate) {
		if (year > otherDate.year) return false;
		else if (year < otherDate.year) return true; 
		else {
			if (month > otherDate.month) return false;
			else if (month < otherDate.month) return true; 
			else {
				if (day < otherDate.day) return true;
				else return false;
			}
		}
	}
	
}
