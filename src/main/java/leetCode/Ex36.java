package leetCode;

import java.util.*;

//https://leetcode.com/problems/keys-and-rooms/description/
public class Ex36 {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(0);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        System.out.println(canVisitAllRooms(lists));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        int[] checkRoom = new int[size];
        checkRoom[0] = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> firstRoom = rooms.get(0);
        for (int i = 0; i < firstRoom.size(); i++) {
            queue.offer(firstRoom.get(i));
        }
        while (!queue.isEmpty()) {
            Integer curKey = queue.poll();
            if (checkRoom[curKey] == 0) {
                checkRoom[curKey] = 1;
                List<Integer> keyList = rooms.get(curKey);
                for (int i = 0; i < keyList.size(); i++) {
                    queue.offer(keyList.get(i));
                }
            }
        }
        for (int roomNumber : checkRoom) {
            if (roomNumber != 1) return false;
        }
        return true;
    }
}