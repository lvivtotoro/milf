package org.midnightas.milf;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class MilfInt implements MilfObject {

	public static final int ID = 3;

	private int i;

	public MilfInt(int i) {
		this.i = i;
	}

	@Override
	public byte[] compile(boolean withId) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		if (withId)
			os.write(ID);
		os.write(MilfUtils.intToBytes(i), 0, 4);
		return os.toByteArray();
	}

	@Override
	public MilfObject decompile(boolean withId, ByteBuffer buffer) {
		if (withId)
			buffer.get();
		i = buffer.getInt();
		return this;
	}

}
