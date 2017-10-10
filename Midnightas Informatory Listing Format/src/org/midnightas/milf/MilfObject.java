package org.midnightas.milf;

import java.nio.ByteBuffer;

public interface MilfObject {
	
	public byte[] compile(boolean withId);
	public MilfObject decompile(boolean withId, ByteBuffer buffer);
	
}
