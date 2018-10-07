/**
 * 
 */
package com.cigna.logreader.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tail {

    private static final class RingBuffer {
        private final int limit;
        private final String[] data;
        private int counter = 0;


        public RingBuffer(int limit) {
            this.limit = limit;
            this.data = new String[limit];
        }

        public void collect(String line) {
            data[counter++ % limit] = line;
        }

        public List<String> contents() {
            return IntStream.range(counter < limit ? 0 : counter - limit, counter)
                    .mapToObj(index -> data[index % limit])
                    .collect(Collectors.toList());
        }

    }
    
    public static final List<String> tailFile(final Path source, final int limit) throws IOException {

        try (Stream<String> stream = Files.lines(source)) {
            RingBuffer buffer = new RingBuffer(limit);
            stream.forEach(line -> buffer.collect(line));

            return buffer.contents();
        }

    }

    public static void main(String[] args) throws IOException {

        List<?> list = tailFile(Paths.get("/logs/myapp/app.log"), 10).stream().collect(Collectors.toList());
        System.out.println(list);
    }
}
