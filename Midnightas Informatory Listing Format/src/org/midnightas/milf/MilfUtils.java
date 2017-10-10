package org.midnightas.milf;

public class MilfUtils {

	public static final byte[] intToBytes(int i) {
		return new byte[] { (byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i };
	}

	public static final byte[] shortToBytes(short i) {
		return new byte[] { (byte) (i >>> 8), (byte) i };
	}

	public static final String byteArrayToString(byte[] bytes) {
		String[] s = new String[bytes.length];
		for (int i = 0; i < bytes.length; i++)
			s[i] = String.format("%02x", bytes[i]);
		return "[" + String.join(", ", s) + "]";
	}

}
