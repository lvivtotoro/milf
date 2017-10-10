package org.midnightas.milf;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class MilfList implements MilfObject {

	public static final int ID = 5;

	private ArrayList<MilfObject> list;

	public MilfList() {
		this(new ArrayList<>());
	}

	public MilfList(ArrayList<MilfObject> map) {
		this.list = map;
	}

	public void add(MilfObject v) {
		list.add(v);
	}

	public MilfObject get(int i) {
		return list.get(i);
	}

	public boolean contains(MilfObject v) {
		return list.contains(v);
	}

	public int size() {
		return this.size();
	}

	@Override
	public byte[] compile(boolean withId) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		if (withId)
			os.write(ID);
		os.write(MilfUtils.intToBytes(list.size()), 0, 4);
		list.forEach(v -> {
			byte[] valueBytes = v.compile(true);
			os.write(valueBytes, 0, valueBytes.length);
		});
		return os.toByteArray();
	}

	@Override
	public MilfList decompile(boolean withId, ByteBuffer buffer) {
		if (withId)
			buffer.get();
		int size = buffer.getInt();
		for (int i = 0; i < size; i++) {
			list.add(MilfGeneral.decompile(true, buffer));
		}
		return this;
	}

}
