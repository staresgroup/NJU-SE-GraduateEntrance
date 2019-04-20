
public class CommandHelper {
	private static String show_course_cmd = "Show";
	private static String add_course_cmd = "add";

	public static String getShow_course() {
		return show_course_cmd;
	}
	
	public static String add_course(Course cs) {
		return add_course_cmd + " " + cs.toString();
	}
	
}
