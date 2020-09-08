package main.java.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LibraryTask {

    public static void main(String[] args) {
        String[] versions = new String[]{"7.2.3", "1.2.3", "2.4.31", "1.2.4", "1.4.1", "7.1.2"};
        System.out.println(sortingVersion(versions));
    }

    private static List<String> sortingVersion(String[] versions) {
        List<String> versionsList = Arrays.asList(versions);

        Comparator<String> comparator = (a, b) -> {
            String[] version = a.split("\\.");
            String[] versionNext = b.split("\\.");

            for (int i = 0; i < Math.min(version.length, versionNext.length); i++) {
                if ((version[i].compareTo(versionNext[i]) != 0)) {
                    return (version[i].compareTo(versionNext[i]));
                }
            }
            return Integer.compare(version.length, versionNext.length);
        };

        versionsList.sort(comparator);
        return versionsList;
    }
}
