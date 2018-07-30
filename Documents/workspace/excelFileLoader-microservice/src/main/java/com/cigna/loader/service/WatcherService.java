
package com.cigna.loader.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.cigna.loader.event.StartEvent;

@Service
public class WatcherService implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(WatcherService.class);
	private final WatchService watchService;
	private boolean watch = true;

	@Autowired
	private ApplicationEventPublisher mApplicationEventPublisher;

	@Value("${minitor.folder.path}")
	private String folderPath;

	public WatcherService() throws IOException {
		this.watchService = FileSystems.getDefault().newWatchService();
	}

	@Override
	public void run() {
		Path path = Paths.get(folderPath);
		WatchKey watchKey;

		try {
			watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}

		while (watch) {

			try {
				List<WatchEvent<?>> events = watchKey.pollEvents();
				for (WatchEvent<?> event : events) {
					final Path changed = (Path) event.context();
					if (changed.endsWith("excel.log")) {
						mApplicationEventPublisher.publishEvent(new StartEvent(this));
		            }
				}
				if (!watchKey.reset()) {
					System.out.println("Reset!");
				}
				Thread.sleep(5000);
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
				Thread.currentThread().interrupt();
			}
		}
	}
}