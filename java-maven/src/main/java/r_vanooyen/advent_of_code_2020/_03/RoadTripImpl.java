package r_vanooyen.advent_of_code_2020._03;

import java.util.List;

public class RoadTripImpl implements RoadTrip {
    private List<String> map;

    public RoadTripImpl(final List<String> map) {
        this.map = map;
    }

    @Override
    public Long lookupAmountOfTreesToPass(final int amountStepsRight, final int amountStepsBot) {
        Long treesPassed = 0L;
        for (int i = 0; i < map.size(); i += amountStepsBot) {
            if (isTreeOnCoordinates(amountStepsRight * i, i)) {
                treesPassed++;
            }
        }
        return treesPassed;
    }

    private boolean isTreeOnCoordinates(int x, int y) {
        final String row = map.get(y);
        return row.charAt(x % row.length()) == '#';
    }
}
