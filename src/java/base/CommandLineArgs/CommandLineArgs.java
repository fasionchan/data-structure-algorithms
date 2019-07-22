/*
 * Author: fasion
 * Created time: 2019-07-20 12:20:13
 * Last Modified by: fasion
 * Last Modified time: 2019-07-22 16:03:24
 */

public class CommandLineArgs {
	public static void main(String args[]) {
		for (int i=0; i<args.length; i++) {
			System.out.printf("Args %d: `%s`\n", i, args[i]);
		}
	}
}
