package org.midnightas.milf;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class MilfPos implements MilfObject {

	public static final int ID = 6;

	private float x, y;

	public MilfPos() {
		this(0, 0);
	}

	public MilfPos(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	@Override
	public byte[] compile(boolean withId) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		if (withId)
			os.write(ID);
		os.write(MilfUtils.intToBytes(Float.floatToIntBits(x)), 0, 4);
		os.write(MilfUtils.intToBytes(Float.floatToIntBits(y)), 0, 4);
		return os.toByteArray();
	}

	@Override
	public MilfPos decompile(boolean withId, ByteBuffer buffer) {
		if (withId)
			buffer.get();
		x = buffer.getFloat();
		y = buffer.getFloat();
		return this;
	}

}
