package org.eclipse.main.obs;

import java.io.File;

// Interface Observateur commune
public interface EventListener {
	
    void update(String eventType, File file);
}