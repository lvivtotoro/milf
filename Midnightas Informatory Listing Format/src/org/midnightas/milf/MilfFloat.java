package org.midnightas.milf;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class MilfFloat implements MilfObject {

	public static final int ID = 3;

	private float f;

	public MilfFloat(float i) {
		this.f = i;
	}

	@Override
	public byte[] compile(boolean withId) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		if (withId)
			os.write(ID);
		os.write(MilfUtils.intToBytes(Float.floatToIntBits(f)), 0, 4);
		return os.toByteArray();
	}

	@Override
	public MilfObject decompile(boolean withId, ByteBuffer buffer) {
		if (withId)
			buffer.get();
		f = buffer.getFloat();
		return this;
	}

}
