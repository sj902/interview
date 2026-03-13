package com.sj902.intervals;


import java.util.*;

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {

        // Sort the raw building objects from highest to lowest
        Arrays.sort(buildings, (a, b) -> b[2] - a[2]);

        // allCoords contains the desired structure
        TreeMap<Integer, Integer> allCoords = new TreeMap<>();

        for (int[] building : buildings) {

            int left = building[0];
            int right = building[1];
            int currentHeight = building[2];

            List<int[]> toUpdate = new ArrayList<>();

            toUpdate.add(getUpdateCoords(allCoords, left, currentHeight));

            // the current height is exclusive for the right side, so set the true end to right - 1.
            toUpdate.add(getUpdateCoords(allCoords, right-1, currentHeight));
            toUpdate.add(getUpdateCoords(allCoords, right, 0));

            /*
             * For all existing points between left and right (exclusive, both sides), update
             * their heights (basically pull them up to currentHeight if need be).
             */
            List<Integer> xCoordsBeween = betweenExclusive(allCoords, left, right);
            xCoordsBeween
                    .stream()
                    .map(coordPair -> getUpdateCoords(allCoords, coordPair, currentHeight))
                    .forEach(updatePair -> allCoords.put(updatePair[0], updatePair[1]));

            /*
             * Update the building's coords all at once so we don't have overlapping
             * intermediate effects that are hard to account for.
             */
            toUpdate.forEach(coordPair -> allCoords.put(coordPair[0], coordPair[1]));
        }

        List<int[]> resultList = new ArrayList<>();
        /*
         * Convert a map of points with possibly redundant heights into a list of
         * unique-height points.
         *
         * Ex:            [ { 2, 3 }, { 14, 6 }, { 16, 6 }, { 20, 0 } ]
         * is reduced to  [ { 2, 3 }, { 14, 6 }, { 20, 0 } ]
         */
        int lastSeenHeight = -1;
        for (Map.Entry<Integer, Integer> coords : allCoords.entrySet()) {

            int x = coords.getKey();
            int y = coords.getValue();

            if (lastSeenHeight == -1 || lastSeenHeight != y) {
                resultList.add(new int[]{ x, y });
                lastSeenHeight = y;
            }
        }

        return resultList;
    }

    private List<Integer> betweenExclusive(TreeMap<Integer, Integer> map, int left, int right) {
        List<Integer> xCoords = new ArrayList<>();

        for (Integer xCoord : map.tailMap(left, false).keySet()) {
            if (xCoord >= right) break;

            xCoords.add(xCoord);
        }
        return xCoords;
    }

    private int[] getUpdateCoords(TreeMap<Integer, Integer> map, int key, int targetHeight) {

        int newHeight = inBetween(map, key) ? getMiddleHeight(map, key, targetHeight) : targetHeight;
        return new int[]{ key, newHeight };
    }

    /*
     * Given a map, is xCoord in between 2 other xCoordinates to the left and right?
     */
    private boolean inBetween(TreeMap<Integer, Integer> map, int xCoord) {
        return map.floorKey(xCoord) != null && map.ceilingKey(xCoord) != null;
    }

    /*
     * Given an xCoord we know is surrounded by 2 other points, update the y value (or height)
     * at that location, such that it works for the major cases outlined below. c = xCoord
     */
    private int getMiddleHeight(TreeMap<Integer, Integer> map, int xCoord, int targetHeight) {
        int leftHeight = map.floorEntry(xCoord).getValue();
        int rightHeight = map.ceilingEntry(xCoord).getValue();

        int lowestCurrentHeight = Math.min(leftHeight, rightHeight);

        return Math.max(lowestCurrentHeight, targetHeight);
    }
}