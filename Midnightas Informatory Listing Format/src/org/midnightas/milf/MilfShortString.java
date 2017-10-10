package org.midnightas.milf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class MilfShortString implements MilfObject, CharSequence {

	public static final int ID = 1;

	private String string;

	public MilfShortString() {
	}

	public MilfShortString(String str) {
		if (str.length() > Byte.MAX_VALUE)
			throw new IllegalArgumentException("str size is larger than 255");
		this.string = str;
	}

	@Override
	public byte[] compile(boolean withId) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		if (withId)
			os.write(ID);
		os.write((byte) string.length());
		try {
			os.write(string.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace(); // free coffee if this happens
		}
		return os.toByteArray();
	}

	@Override
	public MilfObject decompile(boolean withId, ByteBuffer buffer) {
		if (withId)
			buffer.get();
		int size = buffer.get() & 0xFF;
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
