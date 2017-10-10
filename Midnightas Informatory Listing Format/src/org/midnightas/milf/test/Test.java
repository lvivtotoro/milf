package org.midnightas.milf.test;

import org.midnightas.milf.MilfInt;
import org.midnightas.milf.MilfMap;
import org.midnightas.milf.MilfUtils;

public class Test {

	public static void main(String[] args) {
		MilfMap map = new MilfMap();
		map.put("k", new MilfInt(2));
		System.out.println(MilfUtils.byteArrayToString(map.compile(true)));
	}

}
