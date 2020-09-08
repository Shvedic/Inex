package main.java.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class StationTask {

    private final static List<Station> STATION_LIST = Arrays.asList(
            new Station("МОСКВА"),
            new Station("МОЖГА"),
            new Station("МОЗДОК"),
            new Station("САНКТ-ПЕТЕРБУРГ"),
            new Station("САМАРА")
    );

    public  Map<String, List<Station>> collect;

    private StationTask(List<Station> stationList) {
       collect = stationList.stream()
                .collect(Collectors.groupingBy((p) -> p.getName().substring(0, 2)));
    }

    private Collection<Station> getStationsByTwoFirstLetters(String prefix) {
        for (Map.Entry<String, List<Station>> entry : collect.entrySet()) {
            if (entry.getKey().contains(prefix)) {
                return entry.getValue();
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args)  {
        StationTask task = new StationTask(STATION_LIST);

        System.out.println(task.getStationsByTwoFirstLetters("МО"));
        System.out.println(task.getStationsByTwoFirstLetters("СА"));
    }

    private static class Station {

        private final String name;

        public Station(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
