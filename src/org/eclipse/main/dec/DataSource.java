package org.eclipse.main.dec;

public interface DataSource {
	
    void writeData(String data);

    String readData();
}
