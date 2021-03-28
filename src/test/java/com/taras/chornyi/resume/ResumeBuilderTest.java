package com.taras.chornyi.resume;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.junit.Assert.assertEquals;

public class ResumeBuilderTest {

    public static final String FILE = "build/resume.pdf";

    @Before
    public void init() {
        deleteFile();
    }

    private void deleteFile() {
        File file = new File(FILE);
        file.delete();
    }

    @After
    public void clean() {
        deleteFile();
    }

    @Test
    public void createPdfFile() throws IOException {
        //given
        ResumeBuilder builder = new ResumeBuilder(FILE, "Resume", "Taras Chornyi", "Resume, CV");

        //when
        builder.addPageNumber("1")
                .addHeader("RESUME")
                .addTitle("Taras Chornyi", "taras.chornyi@gmail.com", "taras.choryi","src/main/resources/images/TC.png", null)
                .build();

        //then
        Finder finder = new Finder("*.pdf");
        Files.walkFileTree(Paths.get("build"), finder);
        int numMatches = finder.getNumMatches();
        assertEquals(numMatches, 1);
    }

    @Test(expected = com.lowagie.text.ExceptionConverter.class)
    public void createAnEmptyPdfFile() throws IOException {
        //given
        ResumeBuilder builder = new ResumeBuilder(FILE, "", "", "");

        //when
        //then
        builder.build();
    }

    public static class Finder extends SimpleFileVisitor<Path> {

        private final PathMatcher matcher;
        private int numMatches = 0;

        Finder(String pattern) {
            matcher = FileSystems.getDefault()
                    .getPathMatcher("glob:" + pattern);
        }

        // Compares the glob pattern against
        // the file or directory name.
        void find(Path file) {
            Path name = file.getFileName();
            if (name != null && matcher.matches(name)) {
                numMatches++;
            }
        }

        // Prints the total number of
        // matches to standard out.
        int getNumMatches() {
            return numMatches;
        }

        // Invoke the pattern matching
        // method on each file.
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            find(file);
            return CONTINUE;
        }

        // Invoke the pattern matching
        // method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            find(dir);
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            return CONTINUE;
        }
    }
}
