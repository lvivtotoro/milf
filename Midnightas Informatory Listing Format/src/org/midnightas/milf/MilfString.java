package org.midnightas.milf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class MilfString implements MilfObject, CharSequence {

	public static final int ID = 2;

	private String string;

	public MilfString(String str) {
		this.string = str;
	}

	/**
	 * If you use this, decompile something as soon as possible
	 */
	public MilfString() {
		this.string = null;
	}

	@Override
	public byte[] compile(boolean withId) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		if (withId)
			os.write(ID);
		os.write(MilfUtils.intToBytes(string.length()), 0, 4);
		try {
			os.write(string.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace(); // free coffee if this happens
		}
		return os.toByteArray();
	}

	@Override
	public MilfString decompile(boolean withId, ByteBuffer buffer) {
		if (withId)
			buffer.get();
		int size = buffer.getInt();
		byte[] bytes = new byte[size];
		buffer.get(bytes, 0, bytes.length);
		this.string = new String(bytes, StandardCharsets.UTF_8);
		return this;
	}

	@Override
	public int length() {
		return string.length();
	}

	@Override
	public char charAt(int index) {
		return string.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return string.subSequence(start, end);
	}

	public String toString() {
		return this.string;
	}

}
