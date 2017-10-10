package org.midnightas.milf;

import java.nio.ByteBuffer;

public class MilfGeneral {

	public static MilfObject decompile(boolean withId, ByteBuffer buffer) {
		byte id = buffer.get();
		switch (id) {
		case MilfMap.ID:
			return new MilfMap().decompile(withId, buffer);
		case MilfString.ID:
			return new MilfString().decompile(withId, buffer);
		case MilfShortString.ID:
			return new MilfShortString().decompile(withId, buffer);
		default:
			throw new IllegalArgumentException("Invalid id " + id);
		}
	}

}
