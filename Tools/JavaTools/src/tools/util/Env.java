// $Id: Env.java,v 1.4 2003/10/07 21:46:09 idgay Exp $

package tools.util;

/**
 * The <code>Env</code> class provides an implementation of <code>getenv</code>
 * that actually works, unlike the one in <code>java.lang.System</code>. The
 * class cannot be instantiated.
 * 
 * V1.1: provide wrapper so that getenv doesn't fail horribly when the native
 * code is not found.
 * 
 * @author R M Yorston, David Gay
 * @version 1.1
 */
public class Env {
	static private boolean loaded;
	static {
		try {
			java.lang.System.loadLibrary("getenv");
			loaded = true;
		} catch (Throwable t) {
			// System.err.println(
			// "getenv JNI library not found. Env.getenv will not work");
			// System.err.println("(please consult installation directions in");
			// System.err.println(
			// "tinyos-1.x/tools/java/net/tinyos/util/Env.INSTALL)");
		}
	}

	private Env() {
	}

	/**
	 * Gets an environment variable. An environment variable is a
	 * system-dependent external variable that has a string value.
	 * 
	 * @param name
	 *            name of the environment variable
	 * @return the value of the variable, or <code>null</code> if the variable
	 *         is not defined.
	 */
	public static String getenv(String name) {
		if (loaded) {
			// return igetenv(name);
			return null;
		} else {
			return null;
		}
	}

	private static native String igetenv(String name);
}
