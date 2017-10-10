package org.midnightas.milf;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class MilfMap implements MilfObject {

	public static final int ID = 0;

	private HashMap<String, MilfObject> map;

	public MilfMap() {
		this(new HashMap<>());
	}

	public MilfMap(HashMap<String, MilfObject> map) {
		this.map = map;
	}

	public void put(String k, MilfObject v) {
		map.put(k, v);
	}
	
	public MilfObject get(String k) {
		return map.get(k);
	}

	public boolean contains(String k) {
		return map.containsKey(k);
	}

	public boolean contains(MilfObject v) {
		return map.containsValue(v);
	}
	
	public int size() {
		return this.size();
	}

	@Override
	public byte[] compile(boolean withId) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		if (withId)
			os.write(ID);
		os.write(MilfUtils.intToBytes(map.size()), 0, 4);
		map.forEach((k, v) -> {
			byte[] keyBytes = new MilfShortString(k).compile(false);
			byte[] valueBytes = v.compile(true);
			os.write(keyBytes, 0, keyBytes.length);
			os.write(valueBytes, 0, valueBytes.length);
		});
		return os.toByteArray();
	}

	@Override
	public MilfMap decompile(boolean withId, ByteBuffer buffer) {
		if(withId)
			buffer.get();
		int size = buffer.getInt();
		for (int i = 0; i < size; i++) {
			map.put(new MilfString().decompile(false, buffer).toString(), MilfGeneral.decompile(true, buffer));
		}
		return this;
	}

}
