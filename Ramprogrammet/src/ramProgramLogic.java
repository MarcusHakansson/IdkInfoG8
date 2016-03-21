import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ramProgramLogic {

	private ramGUI RamGUI;

	public ramProgramLogic(ramGUI ClockGUI) {
		this.RamGUI = ClockGUI;
		new ClockThread().start();
	}
	
	

	public class ClockThread extends Thread {

		@Override
		public void run() {
			DecimalFormat timeFormat = new DecimalFormat("00");
			while (true) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}

				//System.out.println("Starting");
				Calendar cal = Calendar.getInstance();

				int day = cal.get(Calendar.DATE);
				int month = cal.get(Calendar.MONTH);
				int second = cal.get(Calendar.SECOND);
				int minute = cal.get(Calendar.MINUTE);
				int hour = cal.get(Calendar.HOUR_OF_DAY);

				RamGUI.setTimeOnLabel(timeFormat.format(day) + "/" + timeFormat.format(month + 1) + "  "
						+ timeFormat.format(hour) + ":" + timeFormat.format(minute) + ":" + timeFormat.format(second));

			}
		}
	}

	}
