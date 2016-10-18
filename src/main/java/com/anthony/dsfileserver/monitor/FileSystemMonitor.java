package com.anthony.dsfileserver.monitor;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by Anthony on 2016/10/18.
 */
@Component
public class FileSystemMonitor {


    public void run() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Paths.get("G:\\TestDir").register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.context() + "发生了" + event.kind() + "事件");
            }
            if (!key.reset()) {
                break;
            }
        }
    }

}
